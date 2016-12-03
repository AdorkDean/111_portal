package com.rc.portal.webapp.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.commons.util.InfoUtil;
import com.rc.openapi.serviceApi.OrderReturnServiceDubboApi;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TGoodsManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TOrderItemManager;
import com.rc.portal.service.TOrderManager;
import com.rc.portal.service.TReturnImageManager;
import com.rc.portal.service.TReturnItemManager;
import com.rc.portal.service.TReturnManager;
import com.rc.portal.util.DateUtil;
import com.rc.portal.util.NumberUtil;
import com.rc.portal.vo.TGoods;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TOrder;
import com.rc.portal.vo.TOrderItem;
import com.rc.portal.vo.TOrderItemExample;
import com.rc.portal.vo.TReturn;
import com.rc.portal.vo.TReturn.ReturnStatus;
import com.rc.portal.vo.TReturnImage;
import com.rc.portal.vo.TReturnImageExample;
import com.rc.portal.vo.TReturnItem;
import com.rc.portal.webapp.util.PageResult;

/**
 * 退换货action
 * 
 * @author user00
 */
public class GoodsReturnAction extends BaseAction {

	private static final long serialVersionUID = 7968906976268104386L;
	private PageWraper pw = new PageWraper();
	private PageResult rs = new PageResult();
	private OpenSqlManage opensqlmanage;

	private TReturnManager treturnmanager;
	private TGoodsManager tgoodsmanager;
	private TOrderManager tordermanager;
	private TOrderItemManager torderitemmanager;
	private TReturnItemManager treturnitemmanager;
	private TReturnImageManager treturnimagemanager;
	private TMemberManager tmembermanager;
	private OrderReturnServiceDubboApi orderreturnservicedubboapi;

	private TReturn tReturn;

	private File[] files;
	private File image1;
	private File image2;
	private File image3;
	private File image4;
	private File image5;
	private String image1FileName;
	private String image2FileName;
	private String image3FileName;
	private String image4FileName;
	private String image5FileName;

	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型

	private final String diskPath = InfoUtil.getInstance().getInfo("img", "images.public.head.path");
	private final Long MAXSIZE = 1024 * 1024 * 5L;// 限制图片大小为5M

	/**
	 * 申请退换货页面
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public String applyGoodsReturnPage() throws SQLException {
		String orderItemId = this.getRequest().getParameter("orderItemId");
		String flag = this.getRequest().getParameter("flag");
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if(orderItemId==null||!NumberUtil.isNumeric(orderItemId)||tMember==null){
			return ERROR;
		}
		TOrderItem tOrderItem = torderitemmanager.selectByPrimaryKey(Long.valueOf(orderItemId));
		if(tOrderItem==null){
			return ERROR;
		}
		TOrder tOrder = tordermanager.selectByPrimaryKey(tOrderItem.getOrderId());
		if(tOrder==null||tOrder.getMemberId()==null||tOrder.getMemberId().longValue()!=tMember.getId().longValue()){
			return ERROR;
		}
		BigDecimal  youhui = new BigDecimal(0);
		if(tOrder.getPromotionalDiscount()!=null){
			youhui.add(tOrder.getPromotionalDiscount());
		}
		if(tOrder.getCouponDiscount()!=null){
			youhui.add(tOrder.getCouponDiscount());
		}
		if(tOrder.getIntegrationDiscount()!=null){
			youhui.add(tOrder.getIntegrationDiscount());
		}
		if(tOrder.getAdjustAmount()!=null){
			youhui.add(tOrder.getAdjustAmount());
		}
		TGoods tGoods = tgoodsmanager.selectByPrimaryKey(tOrderItem.getGoodsId());
		this.getRequest().setAttribute("tOrderItem",tOrderItem);
		this.getRequest().setAttribute("tOrder",tOrder);
		this.getRequest().setAttribute("tGoods",tGoods);
		this.getRequest().setAttribute("flag",flag);
		this.getRequest().setAttribute("youhui",youhui);
		return "apply_goodsreturn_page";
	}

	
	public String saveGoodsReturn() throws SQLException {
		String orderId = this.getRequest().getParameter("orderId");// 订单ID
		// String memberId = this.getRequest().getParameter("memberId");// 会员ID
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			// return ERROR;
		}
		if (orderId == null || "".equals(orderId.trim())) {
			return ERROR;
		}

		TOrder tOrder = tordermanager.selectByPrimaryKey(Long.valueOf(orderId));
		if (tOrder == null) {// 订单未查到;
			return ERROR;
		}
		String refundDescribe = this.getRequest().getParameter("refundDescribe");// 退换货描述
		String serviceType = this.getRequest().getParameter("serviceType");// 服务类型
		String goodsId = this.getRequest().getParameter("goodsId");// 选择退换货商品IDs
		String goodsNum = this.getRequest().getParameter("goodsNum");
		
		if (goodsId == null || "".equals(goodsId)) {

			return ERROR;
		}
		List<File> imgList = new ArrayList<File>();
		if(image1!=null){
			imgList.add(image1);
		}
		if(image2!=null){
			imgList.add(image2);
		}
		if(image3!=null){
			imgList.add(image3);
		}
		if(image4!=null){
			imgList.add(image4);
		}
		if(image5!=null){
			imgList.add(image5);
		}
		Map<Long, Integer> paramMap = new HashMap<Long, Integer>();
		paramMap.put(Long.valueOf(goodsId), Integer.valueOf(goodsNum));
		try {
			orderreturnservicedubboapi.submitReturnInfo
				("pc", Long.valueOf(orderId), serviceType, refundDescribe, null, imgList, paramMap);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "go_my_goodsreturn_page";
	}
	
	/**
	 * 保存申请退换货信息
	 * 
	 * @return
	 * @throws SQLException
	 * 
	 */
	@Deprecated
	public String saveGoodsReturn_old() throws SQLException {
		String orderId = this.getRequest().getParameter("orderId");// 订单ID
		// String memberId = this.getRequest().getParameter("memberId");// 会员ID
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			// return ERROR;
		}
		if (orderId == null || "".equals(orderId.trim())) {
			return ERROR;
		}

		TOrder tOrder = tordermanager.selectByPrimaryKey(Long.valueOf(orderId));
		if (tOrder == null) {// 订单未查到;
			return ERROR;
		}
		String refundDescribe = this.getRequest().getParameter("refundDescribe");// 退换货描述
		String serviceType = this.getRequest().getParameter("serviceType");// 服务类型
		String goodsId = this.getRequest().getParameter("goodsId");// 选择退换货商品IDs

		if (goodsId == null || "".equals(goodsId)) {

			return ERROR;
		}

		TReturn tReturn = new TReturn();
		tReturn.setCreateTime(new Date());
		tReturn.setMemberId(tMember.getId());
		tReturn.setOldOrderId(Long.valueOf(orderId));
		tReturn.setRefundDescribe(refundDescribe);
		tReturn.setServiceType(Integer.valueOf(serviceType));
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("len", 6);
		String returnOrderSn = (String) opensqlmanage.selectForObjectByMap(paramMap,
				"t_return.select_new_return_ordersn");
		while (returnOrderSn == null || "".equals(returnOrderSn) || "-1".equals(returnOrderSn)) {
			returnOrderSn = (String) opensqlmanage.selectForObjectByMap(paramMap, "t_return.select_new_return_ordersn");
		}
		tReturn.setOrderSn(returnOrderSn);
		tReturn.setOrderStatus(ReturnStatus.untreated.ordinal());

		tReturn.setShipperPhone(tMember.getPhone());
		tReturn.setUserName(tMember.getUserName());

		// 此处金额算不出该退多少(考虑到优惠价,优惠券等),后台退款节点的时候手动填
		// tReturn.setRefundAmount(tOrder.getPayableAmount());//

		Long returnId = treturnmanager.insertSelective(tReturn);
		TReturnItem tReturnItem = null;

		TOrderItemExample tOrderItemExample = new TOrderItemExample();
		tOrderItemExample.createCriteria().andOrderIdEqualTo(Long.valueOf(orderId));
		String goodsNum = this.getRequest().getParameter("goodsNum");
		tReturnItem = new TReturnItem();
		tReturnItem.setCreateTime(new Date());
		tReturnItem.setGoodsId(Long.valueOf(goodsId));
		// BigDecimal b = new BigDecimal(12D);
		// tReturnItem.setProductAmount(b);//
		// 流程已改为后台退款过程中,填写退款金额
		if (goodsNum != null && !"".equals(goodsNum.trim())) {
			tReturnItem.setQuantity(Integer.valueOf(goodsNum));
		}
		tReturnItem.setReturnId(returnId);
		treturnitemmanager.insertSelective(tReturnItem);
		List<String> pathList = null;
		try {
			pathList = uploadImage();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (pathList != null && pathList.size() > 0) {
			TReturnImage tReturnImage = null;
			for (String string : pathList) {
				tReturnImage = new TReturnImage();
				tReturnImage.setImageUrl(string);
				tReturnImage.setReturnId(returnId);
				treturnimagemanager.insertSelective(tReturnImage);
			}
		}
		return "go_my_goodsreturn_page";
	}

	/**
	 * 上传文件
	 * 
	 * @throws IOException
	 */
	private List<String> uploadImage() throws IOException {
		List<String> pathList = new ArrayList<String>();

		this.getRequest().setCharacterEncoding("utf-8");
		this.getResponse().setContentType("text/plain;charset=utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
		String _subFilePath = sdf.format(new Date());
		File folderFile = new File(diskPath + "/" + _subFilePath);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}
		if (image1 != null && image1.exists()) {
			File _image1 = new File(diskPath + "/" + _subFilePath + "/" + randomFileName(image1FileName));
			if (!_image1.exists()) {
				_image1.createNewFile();
			}
			FileUtils.copyFile(image1, _image1);
			pathList.add(_image1.getPath());
		}
		if (image2 != null && image2.exists()) {
			File _image2 = new File(diskPath + "/" + _subFilePath + "/" + randomFileName(image2FileName));
			if (!_image2.exists()) {
				_image2.createNewFile();
			}
			FileUtils.copyFile(image2, _image2);
			pathList.add(_image2.getPath());
		}
		if (image3 != null && image3.exists()) {
			File _image3 = new File(diskPath + "/" + _subFilePath + "/" + randomFileName(image3FileName));
			if (!_image3.exists()) {
				_image3.createNewFile();
			}
			FileUtils.copyFile(image3, _image3);
			pathList.add(_image3.getPath());
		}
		if (image4 != null && image4.exists()) {
			File _image4 = new File(diskPath + "/" + _subFilePath + "/" + randomFileName(image4FileName));
			if (!_image4.exists()) {
				_image4.createNewFile();
			}
			FileUtils.copyFile(image4, _image4);
			pathList.add(_image4.getPath());
		}
		if (image5 != null && image5.exists()) {
			File _image5 = new File(diskPath + "/" + _subFilePath + "/" + randomFileName(image5FileName));
			if (!_image5.exists()) {
				_image5.createNewFile();
			}
			FileUtils.copyFile(image5, _image5);
			pathList.add(_image5.getPath());
		}
		return pathList;
	}

	/**
	 * 我的退换货列表
	 * 
	 * @return
	 */
	public String myReturns() {
		Map<String, Object> map = new HashMap<String, Object>();
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			return ERROR;
		}
		// 状态auditing(审核中1,3),nopass(不通过2,4),ing(处理中5,8,6,7),finish(结束9)
		map.put("memberId", tMember.getId());
		String betweenDate = this.getRequest().getParameter("betweenDate");
		String status = this.getRequest().getParameter("status");
		String orderSn = this.getRequest().getParameter("orderSn");
		List<Integer> integers = null;
		if (status != null && !"".equals(status)) {
			integers = new ArrayList<Integer>();
			if ("auditing".equals(status)) {
				integers.add(TReturn.ReturnStatus.untreated.ordinal());// 0
				integers.add(TReturn.ReturnStatus.passed.ordinal());// 1
				integers.add(TReturn.ReturnStatus.passInspection.ordinal());// 3
				map.put("statusIn", integers);
			} else if ("nopass".equals(status)) {
				integers.add(TReturn.ReturnStatus.noPass.ordinal());// 2
				integers.add(TReturn.ReturnStatus.noPassInspection.ordinal());// 4
				map.put("statusIn", integers);
			} else if ("ing".equals(status)) {
				integers.add(TReturn.ReturnStatus.refund.ordinal());// 5
				integers.add(TReturn.ReturnStatus.processing.ordinal());// 6
				integers.add(TReturn.ReturnStatus.inspectionGoods.ordinal());// 7
				integers.add(TReturn.ReturnStatus.replaceGoods.ordinal());// 8
				map.put("statusIn", integers);
			} else if ("finish".equals(status)) {// 9
				map.put("orderStatus", 9);
			}
			this.getRequest().setAttribute("orderStatus", status);
		}
		if (orderSn != null && !"".equals(orderSn) && !"请输入订单编号...".equals(orderSn)) {
			//TODO (公用分页有问题),
			map.put("orderSn", orderSn);
//			rs.setP_curPage(1); 这行代码千万别解开，解开以后妖怪就出来啦
			this.getRequest().setAttribute("orderSn", orderSn);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beforeThree = DateUtil.dateAddDays(new Date(), -60);
		if (betweenDate != null && !"".equals(betweenDate) && "beforeThree".equals(betweenDate)) {// lastThree//beforeThree
			map.put("endDate", sdf.format(beforeThree));
			// } else {
			// map.put("startDate", sdf.format(beforeThree));
			// map.put("endDate", sdf.format(new Date()));
		}
		System.out.println("当前页:" + rs.getP_curPage());
		rs.setP_pageSize(10);
		System.out.println("一页条数:" + rs.getP_pageSize());
		
		List<Integer> serviceTypeList = new ArrayList<Integer>();
		serviceTypeList.add(0);
		serviceTypeList.add(2);
		try {
			pw = orderreturnservicedubboapi.getOrderReturn(tMember.getId().longValue(), orderSn, integers, null, null, rs.getP_curPage(), rs.getP_pageSize(), serviceTypeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		pw = opensqlmanage.selectForPageByMap(map, "t_return.selectCountByMap", "t_return.selectListByMap",
//				rs.getP_curPage(), rs.getP_pageSize());
		return "my_goodsreturn_page";
	}

	/**
	 * 退换货详细
	 * 
	 * @return
	 * @throws SQLException
	 * @throws NumberFormatException
	 */
	public String detailReturn() throws NumberFormatException, SQLException {
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			return "go_my_goodsreturn_page";
		}
		String id = this.getRequest().getParameter("id");
		String goodId = this.getRequest().getParameter("goodId");
		String orderId = this.getRequest().getParameter("orderId");
		if (id == null || "".equals(id.trim())) {
			if(orderId==null||!NumberUtil.isNumeric(orderId)||goodId==null||!NumberUtil.isNumeric(goodId)){
				return ERROR;
			}else{
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("goodId", Long.valueOf(goodId));
				map.put("orderId", Long.valueOf(orderId));
				tReturn = (TReturn) opensqlmanage.selectForObjectByMap(map, "t_return.selectReturnByOrderGood");
			}
		}else{
			tReturn = treturnmanager.selectByPrimaryKey(Long.valueOf(id));
		}
		
		if (tReturn == null) {
			return ERROR;
		}
		if(tReturn.getMemberId()!=null&&(tReturn.getMemberId().intValue()!=tMember.getId().intValue())){
			return "go_my_goodsreturn_page";
		}
		BigDecimal youhui = new BigDecimal(0);
		if (tReturn.getOldOrderId() != null) {
			TOrder tOrder = tordermanager.selectByPrimaryKey(tReturn.getOldOrderId());
			if (tOrder != null) {
				if (tOrder.getAdjustAmount() != null) {
					youhui.add(tOrder.getAdjustAmount());
				}
				if (tOrder.getIntegrationDiscount() != null) {
					youhui.add(tOrder.getIntegrationDiscount());
				}
				if (tOrder.getCouponDiscount() != null) {
					youhui.add(tOrder.getCouponDiscount());
				}
				if (tOrder.getPromotionalDiscount() != null) {
					youhui.add(tOrder.getPromotionalDiscount());
				}
			}
			// 原订单
			this.getRequest().setAttribute("tOrder", tOrder);

			TOrderItemExample tOrderItemExample = new TOrderItemExample();
			tOrderItemExample.createCriteria().andOrderIdEqualTo(tReturn.getOldOrderId());
			List<TOrderItem> list = torderitemmanager.selectByExample(tOrderItemExample);
			if(list!=null&&list.size()>0){
				TGoods tGoods = tgoodsmanager.selectByPrimaryKey(list.get(0).getGoodsId());
				this.getRequest().setAttribute("tGoods", tGoods);
				this.getRequest().setAttribute("tOrderItem", list.get(0));
			}
			
			// 订单项
			this.getRequest().setAttribute("orderItemList", list);
			
			this.getRequest().setAttribute("tOrderItem", list.get(0));
			

			TReturnImageExample tReturnImageExample = new TReturnImageExample();
			tReturnImageExample.createCriteria().andReturnIdEqualTo(tReturn.getId());
			List<TReturnImage> imageList = treturnimagemanager.selectByExample(tReturnImageExample);
			// 退换货图片
			this.getRequest().setAttribute("imageList", imageList);
		}
		this.getRequest().setAttribute("youhui", youhui);
		this.getRequest().setAttribute("tReturn", tReturn);
		if (tReturn.getServiceType() == 2) {// 退款,无需退货
			// 审核中
			// if (tReturn.getOrderStatus() ==
			// TReturn.ReturnStatus.untreated.ordinal()
			// || tReturn.getOrderStatus() ==
			// TReturn.ReturnStatus.refund.ordinal()) {
			return "detail_return_nogoods";
			// } else {// 审核完成
			// return "detail_return_nogoods";
			// }
		} else {
			System.out.println("---------退换货-------");
			return "detail_return";
		}
	}

	/**
	 * 填写物流信息
	 * 
	 * @return
	 * @throws SQLException
	 * @throws NumberFormatException
	 */
	public void addLogisticsInfo() throws NumberFormatException, SQLException {
		String id = this.getRequest().getParameter("id");
		String expressCompany = this.getRequest().getParameter("expressCompany");
		String expressDelivery = this.getRequest().getParameter("expressDelivery");
		String shipperPhone = this.getRequest().getParameter("shipperPhone");
		ResultData resultData = new ResultData();
		if (id == null || "".equals(id)) {
			resultData.setStatus(0);
			resultData.setMessage("id不能为空!");
			this.writeObjectToResponse(resultData, ContentType.application_json);
			return;
		}
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		tReturn = treturnmanager.selectByPrimaryKey(Long.valueOf(id));
		if (tReturn == null||tMember == null) {
			resultData.setStatus(0);
			resultData.setMessage("未查询到该退换货数据!");
			this.writeObjectToResponse(resultData, ContentType.application_json);
			return;
		}
		if(tReturn.getMemberId().longValue()!=tMember.getId().longValue()){
			resultData.setStatus(0);
			resultData.setMessage("未查询到该退换货数据!");
			this.writeObjectToResponse(resultData, ContentType.application_json);
			return;
		}
		tReturn.setExpressCompany(expressCompany);
		tReturn.setExpressDelivery(expressDelivery);
		tReturn.setShipperPhone(shipperPhone);
		tReturn.setOrderStatus(ReturnStatus.inspectionGoods.ordinal());
		treturnmanager.updateByPrimaryKeySelective(tReturn);
		resultData.setStatus(1);
		resultData.setMessage("添加物流信息成功!");
		this.writeObjectToResponse(resultData, ContentType.application_json);
		return;
	}

	/**
	 * 判断
	 */
	public void verifyGoodsReturn() {
		String orderId = this.getRequest().getParameter("orderId");
		String goodsId = this.getRequest().getParameter("goodsId");
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", orderId);
		map.put("goodsId", goodsId);
		map.put("memberId", tMember.getId());
		// 查询是否已经存在该订单该商品已经申请过退换货
		List<TReturnItem> list = opensqlmanage.selectForListByMap(map, "t_return_item.selectVerifyGoodsReturn");
		ResultData resultData = new ResultData();
		if (list == null || list.size() <= 0) {
			resultData.setMessage("未申请过退换货");
			resultData.setStatus(0);
		} else {
			resultData.setMessage("已经申请过退换货");
			resultData.setStatus(1);
		}
		this.writeObjectToResponse(resultData, ContentType.application_json);
	}

	private String randomFileName(String fileName) {
		// messageCode
		String sub = "";
		if (fileName.contains(".")) {
			sub = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
		String randName = sdf.format(new Date()) + randomString();
		if (sub != null && !"".equals(sub)) {
			randName += sub;
		}
		return randName;
	}

	public String randomString() {
		int i = (int) (Math.random() * 1000000 + 100000);
		String messageCode = String.valueOf(i);
		if (messageCode.length() == 7) {
			messageCode = messageCode.substring(0, 6);
		}
		return messageCode;
	}

	@Override
	public Object getModel() {
		return null;
	}

	@Override
	public void setModel(Object o) {

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

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	public TReturnManager getTreturnmanager() {
		return treturnmanager;
	}

	public void setTreturnmanager(TReturnManager treturnmanager) {
		this.treturnmanager = treturnmanager;
	}

	public TOrderManager getTordermanager() {
		return tordermanager;
	}

	public void setTordermanager(TOrderManager tordermanager) {
		this.tordermanager = tordermanager;
	}

	public TGoodsManager getTgoodsmanager() {
		return tgoodsmanager;
	}

	public void setTgoodsmanager(TGoodsManager tgoodsmanager) {
		this.tgoodsmanager = tgoodsmanager;
	}

	public TOrderItemManager getTorderitemmanager() {
		return torderitemmanager;
	}

	public void setTorderitemmanager(TOrderItemManager torderitemmanager) {
		this.torderitemmanager = torderitemmanager;
	}

	public TReturnItemManager getTreturnitemmanager() {
		return treturnitemmanager;
	}

	public void setTreturnitemmanager(TReturnItemManager treturnitemmanager) {
		this.treturnitemmanager = treturnitemmanager;
	}

	public TReturnImageManager getTreturnimagemanager() {
		return treturnimagemanager;
	}

	public void setTreturnimagemanager(TReturnImageManager treturnimagemanager) {
		this.treturnimagemanager = treturnimagemanager;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public File getImage1() {
		return image1;
	}

	public void setImage1(File image1) {
		this.image1 = image1;
	}

	public TReturn gettReturn() {
		return tReturn;
	}

	public void settReturn(TReturn tReturn) {
		this.tReturn = tReturn;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public File getImage2() {
		return image2;
	}

	public void setImage2(File image2) {
		this.image2 = image2;
	}

	public File getImage3() {
		return image3;
	}

	public void setImage3(File image3) {
		this.image3 = image3;
	}

	public File getImage4() {
		return image4;
	}

	public void setImage4(File image4) {
		this.image4 = image4;
	}

	public File getImage5() {
		return image5;
	}

	public void setImage5(File image5) {
		this.image5 = image5;
	}

	public String getImage1FileName() {
		return image1FileName;
	}

	public void setImage1FileName(String image1FileName) {
		this.image1FileName = image1FileName;
	}

	public String getImage2FileName() {
		return image2FileName;
	}

	public void setImage2FileName(String image2FileName) {
		this.image2FileName = image2FileName;
	}

	public String getImage3FileName() {
		return image3FileName;
	}

	public void setImage3FileName(String image3FileName) {
		this.image3FileName = image3FileName;
	}

	public String getImage4FileName() {
		return image4FileName;
	}

	public void setImage4FileName(String image4FileName) {
		this.image4FileName = image4FileName;
	}

	public String getImage5FileName() {
		return image5FileName;
	}

	public void setImage5FileName(String image5FileName) {
		this.image5FileName = image5FileName;
	}

	public TMemberManager getTmembermanager() {
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
	}
	

	public OrderReturnServiceDubboApi getOrderreturnservicedubboapi() {
		return orderreturnservicedubboapi;
	}


	public void setOrderreturnservicedubboapi(OrderReturnServiceDubboApi orderreturnservicedubboapi) {
		this.orderreturnservicedubboapi = orderreturnservicedubboapi;
	}


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
}
