package com.rc.portal.webapp.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TGoodsCommentManager;
import com.rc.portal.service.TGoodsPropertyManager;
import com.rc.portal.service.TOrderItemManager;
import com.rc.portal.service.TOrderManager;
import com.rc.portal.vo.TGoodsComment;
import com.rc.portal.vo.TGoodsCommentExample;
import com.rc.portal.vo.TGoodsProperty;
import com.rc.portal.vo.TGoodsPropertyExample;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TOrder;
import com.rc.portal.vo.TOrderItem;
import com.rc.portal.webapp.util.PageResult;

/**
 * 商品评论Action(前台)
 * 
 * @author user00
 * @createTime 2015-8-12 下午3:24:57
 */
public class GoodsCommentAction extends BaseAction {

	private static final long serialVersionUID = 5294821245374431258L;
	private OpenSqlManage opensqlmanage;

	private PageWraper pw = new PageWraper();
	private PageResult rs = new PageResult();

	private int bestNum;// 好评数
	private int betterNum;// 中评数
	private int poorNum;// 差评数
	private int imgNum;// 带有图片评论数

	private TGoodsCommentManager tgoodscommentmanager;
	private TOrderManager tordermanager;
	private TOrderItemManager torderitemmanager;

	private TGoodsPropertyManager tgoodspropertymanager;

	/**
	 * 我的评论(个人中心<我的评论>列表)
	 * 
	 * @return
	 */
	public String myGoodsCommentPage() {
		String type = this.getRequest().getParameter("type");
		Map<String, Object> map = new HashMap<String, Object>();
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			// tMember = new TMember();
			// tMember.setId(8L);
			// String string =
			// "<script type=\"text/javascript\">alert(\"请您先登录\")</script>";
			// this.writeObjectToResponse(string, ContentType.text_html);
			return ERROR;
		}
		map.put("memberId", tMember.getId());
		// type: 1 好评 2 中评 3 差评
		if (type != null && !"".equals(type) && Integer.valueOf(type) > 0 && Integer.valueOf(type) < 4) {
			map.put("type", Integer.valueOf(type));
		} else {
			type = "";
		}
		// FIXME WWF 公共分页默认一页显示5条
		rs.setP_pageSize(5);
		pw = opensqlmanage.selectForPageByMap(map, "t_goods_comment.selectCountByMap",
				"t_goods_comment.selectListByMap", rs.getP_curPage(), rs.getP_pageSize());
		Map<String, Object> bestMap = new HashMap<String, Object>();
		bestMap.put("memberId", tMember.getId());
		bestMap.put("type", 1);
		Map<String, Object> betterMap = new HashMap<String, Object>();
		betterMap.put("memberId", tMember.getId());
		betterMap.put("type", 2);
		Map<String, Object> poorMap = new HashMap<String, Object>();
		poorMap.put("memberId", tMember.getId());
		poorMap.put("type", 3);
		bestNum = (Integer) opensqlmanage.selectForObjectByMap(bestMap, "t_goods_comment.selectCountByMap");
		betterNum = (Integer) opensqlmanage.selectForObjectByMap(betterMap, "t_goods_comment.selectCountByMap");
		poorNum = (Integer) opensqlmanage.selectForObjectByMap(poorMap, "t_goods_comment.selectCountByMap");
		this.getRequest().setAttribute("ttNum", bestNum + betterNum + poorNum);
		this.getRequest().setAttribute("type", type);
		return "my_goods_comment_page";
	}

	/**
	 * 根据商品信息查看商品评论(商品详情页面的商品评论列表)----已废弃
	 * 
	 * @return
	 */
	public String goodsCommentPage() {
		String type = this.getRequest().getParameter("type");
		String goodsId = this.getRequest().getParameter("goodsId");
		Map<String, Object> map = new HashMap<String, Object>();
		// type: 1 好评 2 中评 3 差评
		if (type != null && !"".equals(type) && (Integer.valueOf(type) > 0 && Integer.valueOf(type) < 4)) {
			map.put("type", Integer.valueOf(type));
		} else {
			type = "";
		}
		if (goodsId != null && !"".equals(goodsId)) {
			map.put("goodsId", goodsId);
		}
		pw = opensqlmanage.selectForPageByMap(map, "t_goods_comment.selectCountByMap",
				"t_goods_comment.selectListByMap", rs.getP_curPage(), rs.getP_pageSize());
		Map<String, Object> bestMap = new HashMap<String, Object>();
		bestMap.put("memberId", Long.valueOf(8));
		bestMap.put("type", 1);
		Map<String, Object> betterMap = new HashMap<String, Object>();
		betterMap.put("memberId", Long.valueOf(8));
		betterMap.put("type", 2);
		Map<String, Object> poorMap = new HashMap<String, Object>();
		poorMap.put("memberId", Long.valueOf(8));
		poorMap.put("type", 3);
		// 好评数
		bestNum = (Integer) opensqlmanage.selectForObjectByMap(bestMap, "t_goods_comment.selectCountByMap");
		// 中评数
		betterNum = (Integer) opensqlmanage.selectForObjectByMap(betterMap, "t_goods_comment.selectCountByMap");
		// 差评数
		poorNum = (Integer) opensqlmanage.selectForObjectByMap(poorMap, "t_goods_comment.selectCountByMap");
		// 全部评价数
		int ttNum = bestNum + betterNum + poorNum;
		this.getRequest().setAttribute("ttNum", ttNum);
		this.getRequest().setAttribute("type", type);// 类型(1好评,2中评,3差评;)

		// 好评度百分比
		this.getRequest().setAttribute("bestPercent", ttNum <= 0 ? 1 : bestNum / ttNum);
		this.getRequest().setAttribute("betterPercent", ttNum <= 0 ? 1 : betterNum / ttNum);
		this.getRequest().setAttribute("poorPercent", ttNum <= 0 ? 1 : poorNum / ttNum);
		return "goods_comment_page";
	}

	/**
	 * 取商品评论数据
	 */
	public void ajaxGoodsComment() 
	{
		String goodsId = this.getRequest().getParameter("goodsId");
		String type = this.getRequest().getParameter("type");
		String currentPage = this.getRequest().getParameter("currentPage");
		int pageSize = Integer.parseInt(this.getRequest().getParameter("pageSize")+"");
		Map<String, Object> map = new HashMap<String, Object>();
		List<TGoodsComment> list = null;
		Map<String, Object> bestMap = new HashMap<String, Object>();
		Map<String, Object> betterMap = new HashMap<String, Object>();
		Map<String, Object> poorMap = new HashMap<String, Object>();
		int totalNum = 0;
		int pages = 0;
		int bestPercent = 0;
		int bettertPercent = 0;
		int poorPercent = 0;
		if(currentPage != null && !"".equals(currentPage.trim())) 
		{
			map.put("start", (Integer.valueOf(currentPage) - 1) * pageSize);
		} 
		else 
		{
			map.put("start", 0);
		}
		if(type != null && !type.equals("")) 
		{
			map.put("type", type);
		}
		if(goodsId != null && !goodsId.equals("")) 
		{
			map.put("goodsId", Long.valueOf(goodsId));
			map.put("pageSize", pageSize);
			list = tgoodscommentmanager.selectGoodscommentByAjax(map);
			bestMap.put("goodsId", Long.valueOf(goodsId));
			bestMap.put("type", 1);
			betterMap.put("type", 2);
			betterMap.put("goodsId", Long.valueOf(goodsId));
			poorMap.put("type", 3);
			poorMap.put("goodsId", Long.valueOf(goodsId));
			//好评数
			bestNum = (Integer) opensqlmanage.selectForObjectByMap(bestMap, "t_goods_comment.selectCountByMap");
			//中评数
			betterNum = (Integer) opensqlmanage.selectForObjectByMap(betterMap, "t_goods_comment.selectCountByMap");
			//差评数
			poorNum = (Integer) opensqlmanage.selectForObjectByMap(poorMap, "t_goods_comment.selectCountByMap");

			//评论总数
			totalNum = bestNum + betterNum + poorNum;// 总数
			pages = (pageSize == 0) ? 0 : (totalNum % pageSize == 0 ? (totalNum / pageSize) : (totalNum / Integer.valueOf(pageSize) + 1));// 页数(多少页)
			bestPercent = (totalNum == 0 ? 0 : ((bestNum * 100) / totalNum));// 好评百分比
			bettertPercent = totalNum == 0 ? 0 : (betterNum * 100) / totalNum;// 好评百分比
			poorPercent = totalNum == 0 ? 0 : ((poorNum * 100) / totalNum);// 好评百分比
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("type", type);
		resultMap.put("list", list);//数据
		resultMap.put("totalNum", totalNum);//条数
		resultMap.put("currentPage", currentPage);
		resultMap.put("pageSize", pageSize);//一页的条数
		resultMap.put("pages", pages);// 页数(多少页)
		resultMap.put("bestNum", bestNum);//好评数
		resultMap.put("betterNum", betterNum);//中评数
		resultMap.put("poorNum", poorNum);//差评数
		resultMap.put("bestPercent", bestPercent);//好评率
		resultMap.put("bettertPercent", bettertPercent);//中评率
		resultMap.put("poorPercent", poorPercent);//差评率
		this.writeObjectToResponse(resultMap, ContentType.application_json);
	}

	/**
	 * 好中差评list
	 */
	public void getListByAjax() {
		// ,页数,type,
		Map<String, Object> map = new HashMap<String, Object>();
		String goodsId = this.getRequest().getParameter("goodsId");
		String type = this.getRequest().getParameter("type");
		String currentPage = this.getRequest().getParameter("currentPage");
		// type: 1 好评 2 中评 3 差评
		int pageSize = 10;
		if (type != null && !"".equals(type) && (Integer.valueOf(type) > 0 && Integer.valueOf(type) < 4)) {
			map.put("type", Integer.valueOf(type));
		} else {
			type = "";
		}
		if (currentPage != null && !"".equals(currentPage)) {
			map.put("start", (Integer.valueOf(currentPage) - 1) * pageSize);
			map.put("pageSize", pageSize);
		} else {
			map.put("start", 0);
			map.put("pageSize", pageSize);
		}
		List<TGoodsComment> list = null;
		int num = 0;
		int pages = 0;
		if (goodsId != null && !"".equals(goodsId)) {
			map.put("goodsId", goodsId);
			list = tgoodscommentmanager.selectGoodscommentByAjax(map);
			num = (Integer) opensqlmanage.selectForObjectByMap(map, "t_goods_comment.selectCountByMap");
			pages = pageSize == 0 ? 0 : (num % 10 == 0 ? (num / pageSize) : (num / Integer.valueOf(pageSize) + 1));// 页数(多少页)
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", list);
		resultMap.put("pageSize", pages);
		this.writeObjectToResponse(resultMap, ContentType.application_json);
	}

	/**
	 * 添加评论
	 * 
	 * @throws SQLException
	 */
	public void saveGoodsComment() throws SQLException {
		ResultData resultData = new ResultData();
		String orderItemId = this.getRequest().getParameter("id");// 评论内容
		String comment = this.getRequest().getParameter("comment");// 评论内容
		String orderId = this.getRequest().getParameter("orderId");// 订单id
		// String goodId = this.getRequest().getParameter("goodId");// 商品id

		String seller = this.getRequest().getParameter("seller");// 卖家评价
		String goodReview = this.getRequest().getParameter("goods");// 商品评分
		String fastMail = this.getRequest().getParameter("fastMail");// 快递评价
		String fastMailPeople = this.getRequest().getParameter("fastMailPeople");// 快递员评价
		Long goodsId = 0L;
		TOrderItem tOrderItem = null;
		if (orderItemId != null && !"".equals(orderItemId)) {
			tOrderItem = torderitemmanager.selectByPrimaryKey(Long.valueOf(orderItemId));
			if (tOrderItem != null) {
				goodsId = tOrderItem.getGoodsId();
				if (tOrderItem.getIfReviews() != null && tOrderItem.getIfReviews() == 1) {
					resultData.setMessage("您已评论过该订单商品!");
					resultData.setStatus(2);
					this.writeObjectToResponse(resultData, ContentType.application_json);
					return;
				}
			}
		}

		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			resultData.setMessage("请您先登录");
			resultData.setStatus(0);
		} else {
			TGoodsComment tGoodsComment = new TGoodsComment();
			tGoodsComment.setComment(comment);// 评论内容
			tGoodsComment.setMemberId(tMember.getId());// 用户ID
			tGoodsComment.setGoodsId(goodsId);// 商品ID
			tGoodsComment.setOrderId(tOrderItem == null ? 0L : tOrderItem.getOrderId());// 订单ID

			// ★是差评 ★★/★★★中评 ★★★★/★★★★★好评
			tGoodsComment.setSeller(seller == null ? 5 : Integer.valueOf(seller));// 快递员好评
			tGoodsComment.setGoods(goodReview == null ? 5 : Integer.valueOf(goodReview));// 评分
			tGoodsComment.setFastMail(fastMail == null ? 5 : Integer.valueOf(fastMail));// 快递好评
			tGoodsComment.setFastMailPeople(fastMailPeople == null ? 5 : Integer.valueOf(fastMailPeople));// 快递好评

			Integer totalPoint = (seller == null ? 5 : Integer.valueOf(seller))
					+ (goodReview == null ? 5 : Integer.valueOf(goodReview))
					+ (fastMail == null ? 5 : Integer.valueOf(fastMail))
					+ (fastMailPeople == null ? 5 : Integer.valueOf(fastMailPeople));
			tGoodsComment.setSumFraction(totalPoint);// 总评分
			// 综合评分算,好/中/差
			int _type = totalPoint <= 4 ? 3 : totalPoint > 4 && totalPoint <= 12 ? 2 : 1;
			tGoodsComment.setType(_type);// 判断(1 好评 2 中评 3 差评)
			tGoodsComment.setIsShow(0);// 默认显示
			tGoodsComment.setCreateTime(new Date());
			tgoodscommentmanager.insert(tGoodsComment);
		}

		if (tOrderItem != null) {
			tOrderItem.setIfReviews(1);// 更新订单项已评论
			torderitemmanager.updateByPrimaryKeySelective(tOrderItem);
			if (tOrderItem.getGoodsId() != null && tOrderItem.getGoodsId() > 0L) {
				TGoodsPropertyExample tGoodsPropertyExample = new TGoodsPropertyExample();
				tGoodsPropertyExample.createCriteria().andGoodsidEqualTo(tOrderItem.getGoodsId());
				List<TGoodsProperty> list = tgoodspropertymanager.selectByExample(tGoodsPropertyExample);
				for (TGoodsProperty tGoodsProperty : list) {
					TGoodsPropertyExample _tGoodsPropertyExample = new TGoodsPropertyExample();
					_tGoodsPropertyExample.createCriteria().andEvaluateEqualTo(
							tGoodsProperty == null ? 1 : tGoodsProperty.getEvaluate() + 1);
					tgoodspropertymanager.updateByExampleSelective(tGoodsProperty, _tGoodsPropertyExample);
				}
			}
		}
		resultData.setMessage("保存成功");
		resultData.setStatus(1);
		this.writeObjectToResponse(resultData, ContentType.application_json);
	}

	/***
	 * 去评论页
	 * 
	 * @return
	 * @throws SQLException
	 * @throws NumberFormatException
	 */
	public String applyGoodsComment() throws NumberFormatException, SQLException {
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			return ERROR;
		}
		String orderId = this.getRequest().getParameter("orderId");
		if (orderId == null || orderId.trim().equals("")) {
			return ERROR;
		}
		TOrder tOrder = tordermanager.selectByPrimaryKey(Long.valueOf(orderId));
		if (tOrder == null) {
			return ERROR;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", tOrder.getId());
		List<Map<String, Object>> list = opensqlmanage.selectForListByMap(map,
				"t_order_item.selectOrderItemByOrderIdApply");
		this.getRequest().setAttribute("list", list);
		this.getRequest().setAttribute("tOrder", tOrder);

		return "add_goodscomment_page";
	}

	/**
	 * 去添加页面(已废弃)
	 * 
	 * @return
	 * @throws SQLException
	 * @throws NumberFormatException
	 */
	public String addGoodsCommentPage() throws NumberFormatException, SQLException {
		// 订单ID
		String oldOrderId = this.getRequest().getParameter("orderId");
		// 商品ID
		String goodsId = this.getRequest().getParameter("goodsId");

		if (oldOrderId == null || "".equals(oldOrderId.trim())) {
			return ERROR;
		}
		if (goodsId == null || "".equals(goodsId.trim())) {
			return ERROR;
		}
		// 登录者信息
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			return ERROR;
		}
		TOrder tOrder = tordermanager.selectByPrimaryKey(Long.valueOf(oldOrderId));
		if (tOrder == null) {
			return ERROR;
		}
		TGoodsCommentExample example = new TGoodsCommentExample();
		example.createCriteria().andMemberIdEqualTo(tMember.getId()).andOrderIdEqualTo(tOrder.getId())
				.andGoodsIdEqualTo(Long.valueOf(goodsId));
		List<TGoodsComment> list = tgoodscommentmanager.selectByExample(example);
		if (list == null) {
			return "add_goodscomment_page";
		} else {// 已评论过,不能重复评论
			return ERROR;
		}
	}

	/**
	 * 根据订单,商品ID登录信息查询是否已评论过
	 * 
	 * @throws SQLException
	 * @throws NumberFormatException
	 */
	public void ifCommentByGoods() throws NumberFormatException, SQLException {
		ResultData resultData = new ResultData();
		// 订单ID
		String oldOrderId = this.getRequest().getParameter("orderId");
		// 商品ID
		String goodsId = this.getRequest().getParameter("goodsId");
		if (oldOrderId == null || "".equals(oldOrderId.trim())) {
			resultData.setStatus(0);
			resultData.setMessage("订单不能为空!");
			return;
		}
		if (goodsId == null || "".equals(goodsId.trim())) {
			resultData.setStatus(0);
			resultData.setMessage("评论商品不能为空!");
			return;
		}
		// 登录者信息
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			resultData.setStatus(0);
			resultData.setMessage("请先登录!");
			return;
		}
		TOrder tOrder = tordermanager.selectByPrimaryKey(Long.valueOf(oldOrderId));
		if (tOrder == null) {
			resultData.setStatus(0);
			resultData.setMessage("您的订单有误,请确认!");
			return;
		}
		TGoodsCommentExample example = new TGoodsCommentExample();
		example.createCriteria().andMemberIdEqualTo(tMember.getId()).andOrderIdEqualTo(tOrder.getId())
				.andGoodsIdEqualTo(Long.valueOf(goodsId));
		List<TGoodsComment> list = tgoodscommentmanager.selectByExample(example);
		if (list != null && list.size() > 0) {
			resultData.setStatus(0);
			resultData.setMessage("您已评论过该商品!");
			return;
		} else {
			resultData.setStatus(1);
			resultData.setMessage("您可以评论该商品");
		}
	}

	@Override
	public Object getModel() {
		return null;
	}

	@Override
	public void setModel(Object o) {

	}

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	public PageWraper getPw() {
		return pw;
	}

	public void setPw(PageWraper pw) {
		this.pw = pw;
	}

	public PageResult getRs() {
		return rs;
	}

	public void setRs(PageResult rs) {
		this.rs = rs;
	}

	public TGoodsCommentManager getTgoodscommentmanager() {
		return tgoodscommentmanager;
	}

	public void setTgoodscommentmanager(TGoodsCommentManager tgoodscommentmanager) {
		this.tgoodscommentmanager = tgoodscommentmanager;
	}

	// ajax请求返回对象
	class ResultData {
		private int status;
		private String message;

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	public int getBestNum() {
		return bestNum;
	}

	public void setBestNum(int bestNum) {
		this.bestNum = bestNum;
	}

	public int getBetterNum() {
		return betterNum;
	}

	public void setBetterNum(int betterNum) {
		this.betterNum = betterNum;
	}

	public int getPoorNum() {
		return poorNum;
	}

	public void setPoorNum(int poorNum) {
		this.poorNum = poorNum;
	}

	public int getImgNum() {
		return imgNum;
	}

	public void setImgNum(int imgNum) {
		this.imgNum = imgNum;
	}

	public TOrderManager getTordermanager() {
		return tordermanager;
	}

	public void setTordermanager(TOrderManager tordermanager) {
		this.tordermanager = tordermanager;
	}

	public TOrderItemManager getTorderitemmanager() {
		return torderitemmanager;
	}

	public void setTorderitemmanager(TOrderItemManager torderitemmanager) {
		this.torderitemmanager = torderitemmanager;
	}

	public TGoodsPropertyManager getTgoodspropertymanager() {
		return tgoodspropertymanager;
	}

	public void setTgoodspropertymanager(TGoodsPropertyManager tgoodspropertymanager) {
		this.tgoodspropertymanager = tgoodspropertymanager;
	}

}
