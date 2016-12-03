package com.rc.portal.webapp.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.dst.client.util.ClientSubmitPublic;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TGoodsCommentManager;
import com.rc.portal.service.TGoodsManager;
import com.rc.portal.service.TLeaderStayMoneyManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.vo.TGoods;
import com.rc.portal.vo.TGoodsComment;
import com.rc.portal.vo.TGoodsExample;
import com.rc.portal.vo.TMember;

/**
 * 门店订单
 * @author 王明
 * 2016-1-28
 *
 */
public class StoreOrderAction extends BaseAction{

	private static final long serialVersionUID = 646164661L;
	
	private static int PAGE_SIZE = 10;
	
	/**
	 * opensql  
	 */
	private OpenSqlManage opensqlmanage;
	/**
	 * 商品manager
	 */
	private TGoodsManager tgoodsmanager;

	private TSysParameterManager tsysparametermanager;
	
	private TLeaderStayMoneyManager tleaderstaymoneymanager;
	
	/**
	 * 门店订单详情
	 * @return
	 */
	public String storeOrderInfo(){
		String statusCode = "0";
		String message = "";
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map map = new HashMap();
		TMember member = (TMember)this.getSession().getAttribute("member");
		String orderSn = this.getRequest().getParameter("orderSn");
		try {
				Map<String, String> publicMap = new HashMap<String, String>();
				publicMap.put("member_id", member.getId().toString());
				//publicMap.put("member_id", "171924");
				publicMap.put("order_id", orderSn);
				//publicMap.put("order_id", "13012081120014");
				String homePageConfigId = tsysparametermanager.getKeys("public_service_url");
				String resultJsonstr = ClientSubmitPublic.getPublicService(publicMap, homePageConfigId
						+ "getOffLineOrderItemList");  //调用public接口
				JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
				if (jsonObject != null) {
					System.out.println(jsonObject);
					statusCode = jsonObject.get("statusCode") == null ? "0" : jsonObject.get("statusCode").toString();// 成功
					message = jsonObject.get("message") == null ? "" : jsonObject.get("message").toString();
					if(!statusCode.equals("0")){
						resultMap = (Map<String, Object>) JSONObject.toBean(JSONObject.fromObject(jsonObject.get("order")),
								Map.class);
						JSONArray jsonArray=jsonObject.getJSONArray("list");
						List list = JSONArray.toList(jsonArray, Map.class);
						this.getRequest().setAttribute("goodsList", list);
						this.getRequest().setAttribute("order", resultMap);
					}else{
						//错误
					}	
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getRequest().setAttribute("orderSn", orderSn);
		return "storeList";
	}
	
	/**
	 * 跳转门店订单评论也
	 * @return
	 */
	public String comment(){
		String statusCode = "0";
		String message = "";
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map map = new HashMap();
		TMember member = (TMember)this.getSession().getAttribute("member");
		String orderSn = this.getRequest().getParameter("orderSn");
		try {
				Map<String, String> publicMap = new HashMap<String, String>();
				publicMap.put("member_id", member.getId().toString());
				//publicMap.put("member_id", "171924");
				publicMap.put("order_id", orderSn);
				//publicMap.put("order_id", "13012081120014");
				String homePageConfigId = tsysparametermanager.getKeys("public_service_url");
				String resultJsonstr = ClientSubmitPublic.getPublicService(publicMap, homePageConfigId
						+ "getOffLineOrderItemList");  //调用public接口
				JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
				if (jsonObject != null) {
					System.out.println(jsonObject);
					statusCode = jsonObject.get("statusCode") == null ? "0" : jsonObject.get("statusCode").toString();// 成功
					message = jsonObject.get("message") == null ? "" : jsonObject.get("message").toString();
					if(!statusCode.equals("0")){
						resultMap = (Map<String, Object>) JSONObject.toBean(JSONObject.fromObject(jsonObject.get("order")),
								Map.class);
						this.getRequest().setAttribute("order", resultMap);
					}else{
						//错误
					}	
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getRequest().setAttribute("orderSn", orderSn);
		return "comment";
	}
	
	/**
	 * 门店订单评论
	 * @return
	 * @throws Exception 
	 */
	public void storeOrderComment() throws Exception{
		this.getRequest().setCharacterEncoding("UTF-8");
		this.getResponse().setContentType("text/html;charset=utf-8");
		PrintWriter out =this.getResponse().getWriter();
		String statusCode = "评论成功";
		String message = "";
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Map map = new HashMap();
		String orderSn = this.getRequest().getParameter("orderSn");
		String content = this.getRequest().getParameter("content");
		try {
			TMember member = (TMember)this.getSession().getAttribute("member");
			Map<String, String> publicMap = new HashMap<String, String>();
			publicMap.put("member_id", member.getId().toString());
			publicMap.put("order_id", orderSn);
			String homePageConfigId = tsysparametermanager.getKeys("public_service_url");
			//publicMap.put("member_id", "171924");
			//publicMap.put("order_id", "13012081120014");
			String resultJsonstr = ClientSubmitPublic.getPublicService(publicMap, homePageConfigId
					+ "getOffLineOrderItemList");  //调用public接口
			JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
			if (jsonObject != null) {
				System.out.println(jsonObject);
				statusCode = jsonObject.get("statusCode") == null ? "0" : jsonObject.get("statusCode").toString();// 成功
				message = jsonObject.get("message") == null ? "" : jsonObject.get("message").toString();
				if(!statusCode.equals("0")){
					resultMap = (Map<String, Object>) JSONObject.toBean(JSONObject.fromObject(jsonObject.get("order")),
							Map.class);
					JSONArray jsonArray=jsonObject.getJSONArray("list");
					List list = JSONArray.toList(jsonArray, Map.class);
					Map goodsMap = null;
					for (int i = 0; i < list.size(); i++) {
						TGoodsExample example = new TGoodsExample();
						goodsMap = (Map) list.get(i);
						String no = (String) goodsMap.get("orderItemSn");
						example.createCriteria().andGoodsnoEqualTo(no);
						List gList = tgoodsmanager.selectByExample(example);
						if(null !=gList && gList.size()>0){
							TGoods goods = (TGoods) gList.get(0);
							TGoodsComment comment = new TGoodsComment(); 
							comment.setSumFraction(20);
							comment.setType(1);
							comment.setSeller(5);
							comment.setGoods(5);
							comment.setFastMail(5);
							comment.setFastMailPeople(5);
							comment.setIsShow(0);
							comment.setMemberId(member.getId());
							comment.setGoodsId(goods.getId());
							comment.setOrderId(-1L);
							comment.setCreateTime(new Date());
							comment.setComment(content);
							tgoodscommentmanager.insertSelective(comment);
						}
					} 
					statusCode = "评论成功";
				}else{
					System.out.println("海典错误信息="+message);
					statusCode = "门店记录同步失败";
				}	
			}
		} catch (Exception e) {
			statusCode = "系统异常";
			e.printStackTrace();
		}
		 out.print(statusCode);
		 out.close();
	}
	
	
	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	public TGoodsManager getTgoodsmanager() {
		return tgoodsmanager;
	}

	public void setTgoodsmanager(TGoodsManager tgoodsmanager) {
		this.tgoodsmanager = tgoodsmanager;
	}

	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}

	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}

	public TLeaderStayMoneyManager getTleaderstaymoneymanager() {
		return tleaderstaymoneymanager;
	}

	public void setTleaderstaymoneymanager(
			TLeaderStayMoneyManager tleaderstaymoneymanager) {
		this.tleaderstaymoneymanager = tleaderstaymoneymanager;
	}

	public TMemberManager getTmembermanager() {
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
	}

	public TGoodsCommentManager getTgoodscommentmanager() {
		return tgoodscommentmanager;
	}

	public void setTgoodscommentmanager(TGoodsCommentManager tgoodscommentmanager) {
		this.tgoodscommentmanager = tgoodscommentmanager;
	}

	private TMemberManager tmembermanager;
	
	private TGoodsCommentManager tgoodscommentmanager;
	
	
	
	public Object getModel() {
		return null;
	}

	public void setModel(Object o) {
	}

    
	
}
