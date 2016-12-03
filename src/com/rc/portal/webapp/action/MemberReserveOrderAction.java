package com.rc.portal.webapp.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.util.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.commons.util.InfoUtil;
import com.rc.dst.client.util.ClientSubmit;
import com.rc.dst.client.util.ClientSubmitPublic;
import com.rc.portal.commons.DataUtil;
import com.rc.portal.payplugin.payWzf.util.Signature;
import com.rc.portal.payplugin.payWzf.util.WXTradeType;
import com.rc.portal.service.CDeliveryWayManager;
import com.rc.portal.service.CLocationCityManager;
import com.rc.portal.service.CPaymentWayManager;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.RxTReserveOrderManager;
import com.rc.portal.service.TGoodsManager;
import com.rc.portal.service.TMemberReceiverLatLonManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.util.NetworkUtil;
import com.rc.portal.vo.CDeliveryWay;
import com.rc.portal.vo.CDeliveryWayExample;
import com.rc.portal.vo.CLocationCity;
import com.rc.portal.vo.CLocationCityExample;
import com.rc.portal.vo.CPaymentWay;
import com.rc.portal.vo.CPaymentWayExample;
import com.rc.portal.vo.RxTReserveOrder;
import com.rc.portal.vo.TGoods;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberReceiverLatLon;
import com.rc.portal.vo.TMemberReceiverLatLonExample;
import com.rc.portal.vo.TOrder;
import com.rc.portal.vo.TOrderFlow;
import com.rc.portal.webapp.util.PageResult;

/**
 * 订单中心
 * @author 刘天灵
 *
 */
public class MemberReserveOrderAction extends BaseAction{
	private final Long MAXSIZE = 1024*1024*5L;
	// 图片路径
	private final String diskPath = InfoUtil.getInstance().getInfo("img", "images.public.reserveorder.path");
	private static final long serialVersionUID = 646464661L;
	
	private PageWraper pw = new PageWraper();
	
	private PageResult rs = new PageResult(); 
	
	Condition model = new Condition();
	
	/**
	 * 用户收货地址manager
	 */
	private TMemberReceiverLatLonManager tmemberreceiverlatlonmanager;
	/**
	 * 支付方式
	 */
	private CPaymentWayManager cpaymentwaymanager;
	/**
	 * opensql  
	 */
	private OpenSqlManage opensqlmanage;
	/**
	 * 商品manager
	 */
	private TGoodsManager tgoodsmanager;
	/**
	 * 地区城市码表
	 */
	private CLocationCityManager clocationcitymanager;
	
	
	
	
	private TOrder order;
	private RxTReserveOrder reserveOrder;
	
	
	
	private TSysParameterManager tsysparametermanager;
	
	
	
	private RxTReserveOrderManager rxtreserveordermanager;
	
	
	
	
	public RxTReserveOrder getReserveOrder() {
		return reserveOrder;
	}

	public void setReserveOrder(RxTReserveOrder reserveOrder) {
		this.reserveOrder = reserveOrder;
	}

	public RxTReserveOrderManager getRxtreserveordermanager() {
		return rxtreserveordermanager;
	}

	public void setRxtreserveordermanager(
			RxTReserveOrderManager rxtreserveordermanager) {
		this.rxtreserveordermanager = rxtreserveordermanager;
	}

	/**
	 * 配送方式manager
	 */
	private CDeliveryWayManager cdeliverywaymanager;
	
	/**
	 * 收货地址
	 */
	private TMemberReceiverLatLon tmemberreceiver;
	
	
	@Override
	public void setModel(Object o) {
		this.model =(Condition) o;
		
	}

	
	/**
	 * 获取订单商品明细
	 * @return
	 */
	public String getOrderItem(){
		
		String id = this.getRequest().getParameter("id");
		
		if(org.apache.commons.lang.StringUtils.isNumeric(id)){
			Object orderItems = this.opensqlmanage.selectListByObject(id, "t_order_item.selectOrderItemByOrderId");
			this.getRequest().setAttribute("orderItems", orderItems);
		}
		
		return "order_item";
	}
	
	
	
	
	public  List<Map<String,Object>> getDeliveryWayList(TMemberReceiverLatLon receiverLatLon,String paymentWayId) throws NumberFormatException, SQLException{
		    if(!StringUtils.hasText(paymentWayId)){
		    	paymentWayId="1";
		    }
		    CPaymentWay paymentWay=	this.cpaymentwaymanager.selectByPrimaryKey(Long.valueOf(paymentWayId.trim()));
		    Map<String,Object> resultsmap  = new HashMap<String,Object>();
		    List<Map<String,Object>> deliveryWayList = new ArrayList<Map<String,Object>>();
			CDeliveryWayExample deliveryWayexample = new CDeliveryWayExample();
			deliveryWayexample.createCriteria().andDeliveryCodeNotEqualTo("hdfk");
			List<CDeliveryWay> deliveryList = cdeliverywaymanager.selectByExample(deliveryWayexample);
			
			Map<String,Object> resultMap = null;
			 String receiverFlag ="0";// 0 表示外地  
			 String hdfk_area =tsysparametermanager.getKeys("paymethod_hdfk_area");//支付方式支持货到付款地区
			 if(receiverLatLon!=null){
				 boolean ysd_ysdj_areaid_flag = false;
				 if(StringUtils.hasText(receiverLatLon.getStoreId())){
					 ysd_ysdj_areaid_flag= true;
				 }
				 if(ysd_ysdj_areaid_flag){//判断望京   是望京
					 receiverFlag="1";//表示 望京
	    		 }else if(receiverLatLon.getArea().indexOf(hdfk_area)>0){//判断是否是北京   
	    			 receiverFlag="2";//表示北京
	    		 }
			 }else{
				 receiverFlag="-1";//表示 没有收获地址 
			 }
			
			if(deliveryList!=null&&deliveryList.size()>0){
				for(CDeliveryWay delivery:deliveryList){
					resultMap = new HashMap<String,Object>();
					resultMap.put("id", delivery.getId());
					resultMap.put("name", delivery.getName());
					resultMap.put("instro", delivery.getInstro());
					resultMap.put("isflag", "0");//表示否
					if(!paymentWay.getPaymentCode().equals("hdfk")){
						    if(delivery.getDeliveryCode().equals("ptkd")){//普通快递
							   if(receiverFlag.equals("0")||receiverFlag.equals("2")){//外地  或是北京
								   resultMap.put("isflag", "1");//表示是
							   }
							}else if(delivery.getDeliveryCode().equals("ysd")){//药士达
							   if(receiverFlag.equals("1")){//表示 望京
								   resultMap.put("isflag", "1");//表示是
							   }
							}else if(delivery.getDeliveryCode().equals("ysdj")){//药师到家
							   if(receiverFlag.equals("1")){//表示 望京
									   resultMap.put("isflag", "1");//表示是
								}
							}
					}else{
						if(receiverFlag.equals("1")){//表示 望京
							if(delivery.getDeliveryCode().equals("ysd")|| delivery.getDeliveryCode().equals("ysdj")){//药士达    药师到家
								 resultMap.put("isflag", "1");//表示是
							}
						}
					}
					
					deliveryWayList.add(resultMap);
				}
			}
			return deliveryWayList;
	}
	
	
	
	
	/**
	 * 根据收货地址 查询支付方式
	 * @throws Exception
	 */
	public void paymentWayByReceiverId() throws Exception{
		String receiverId = this.getRequest().getParameter("receiverId");//收货地址id
		TMemberReceiverLatLon receiverLatLon = null;
		if(StringUtils.hasText(receiverId)){
			receiverLatLon = this.tmemberreceiverlatlonmanager.selectByPrimaryKey(Long.valueOf(receiverId));
		}
		// 支付方式
		CPaymentWayExample paymentWayExample = new CPaymentWayExample();
		paymentWayExample.setOrderByClause("sort asc");
		List<CPaymentWay> paymentWayList = cpaymentwaymanager.selectByExampleAndReceiverId(paymentWayExample,receiverLatLon);
		
		
//		获取配送方式
//	   List<Map<String,Object>> deliveryWayList = this.getDeliveryWayList(receiver, "");
		
//	   Map<String,Object> resultMap = new HashMap<String,Object>();
//	   resultMap.put("paymentWayList", paymentWayList);
//	   resultMap.put("deliveryWayList", deliveryWayList);
		writeObjectToResponse(paymentWayList, ContentType.application_json);
	}
	
	/**
	 * 动态获取配送方式集合
	 * @throws Exception
	 */
	public void deliveryWayList() throws Exception{
		String receiverId = this.getRequest().getParameter("receiverId");//收货地址id
		String paymentWayId = this.getRequest().getParameter("paymentWayId");//支付方式
		TMemberReceiverLatLon receiverLatLon = null;
		if(StringUtils.hasText(receiverId)){
			receiverLatLon = this.tmemberreceiverlatlonmanager.selectByPrimaryKey(Long.valueOf(receiverId));
		}
		//获取配送方式
		List<Map<String,Object>> deliveryWayList = this.getDeliveryWayList(receiverLatLon, paymentWayId);
		writeObjectToResponse(deliveryWayList, ContentType.application_json);
	}
	
	/**
	 * 提交订单
	 * @throws Exception
	 */
	public void saveReserveOrder() throws Exception{
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		Long memberId =member.getId();
		getResponse().setContentType("text/html;charset=utf-8");
		
		String receiverId = this.getRequest().getParameter("receiverId");
		if(!StringUtils.hasText(receiverId)){//收货地址错误
			writeObjectToResponse(new ErrorMessage(false,"1",""), ContentType.application_json);
			return;
		}
		
		String replyMobile = this.getRequest().getParameter("replyMobile");
		if(!StringUtils.hasText(replyMobile)  ){//回拨电话为空
			writeObjectToResponse(new ErrorMessage(false,"2",""), ContentType.application_json);
			return;
		}
		replyMobile = replyMobile.trim();
		if(!DataUtil.validateMobile(replyMobile)){//回拨电话错误
			writeObjectToResponse(new ErrorMessage(false,"21",""), ContentType.application_json);
			return;
		}
		
		String goodsNum = this.getRequest().getParameter("goodsNum");
		if(!StringUtils.hasText(goodsNum) ){//商品数量
			writeObjectToResponse(new ErrorMessage(false,"3",""), ContentType.application_json);
			return;
		}
		
		String goodsId = this.getRequest().getParameter("goodsId");
		if(!StringUtils.hasText(goodsId) ){//商品不能为空
			writeObjectToResponse(new ErrorMessage(false,"4",""), ContentType.application_json);
			return;
		}else{
			TGoods goods = tgoodsmanager.selectByPrimaryKey(Long.valueOf(goodsId));
			if(goods == null){//商品不存在
				writeObjectToResponse(new ErrorMessage(false,"5",""), ContentType.application_json);
				return;
			}else{//库存不足
				if(goods.getStock() < Long.valueOf(goodsNum)){
					writeObjectToResponse(new ErrorMessage(false,"6",""), ContentType.application_json);
					return;
				}
			}
		}
		
		String remark = getRequest().getParameter("remark");
		String rxImgUrl = getRequest().getParameter("rxImgUrl");
		//所有校验已经通过
		//调用接口保存预订单
		//根据保存结果返回数据
		
		String publicServiceUrl = tsysparametermanager.getKeys("public_service_url");
		Map<String,String> publicMap = new HashMap<String,String>();
		publicMap.put("memberId", String.valueOf(memberId));
		publicMap.put("receiverId", receiverId);
		publicMap.put("goodid", goodsId);
		publicMap.put("num", goodsNum);
		publicMap.put("replyMobile", replyMobile);
		publicMap.put("remark",remark);
		publicMap.put("rxImgUrl", rxImgUrl);
		publicMap.put("source", "1");
		
	    String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"createReserveOrderURLService");
	    JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
	    if(jsonObject != null){
	    	if(jsonObject.get("statusCode") != null){
	    		String statusCode = jsonObject.get("statusCode").toString();
	    		if(statusCode.equals("1")){
	    			String rxTReserveOrderId = jsonObject.get("rxTReserveOrderId").toString();//生成的预订单id
	    			String orderAmount = jsonObject.get("orderAmount").toString();//订单金额
	    			Map resultMap = new HashMap();
	    			resultMap.put("rxTReserveOrderId", rxTReserveOrderId);
	    			resultMap.put("orderAmount", orderAmount);
	    			resultMap.put("flag", true);
	    			writeObjectToResponse(resultMap, ContentType.application_json);//保存预订单成功
	    			//发送短信
	    			sendSuccessMsg(replyMobile);
	    			return;
	    		}else if(statusCode.equals("0")){
	    			String rxTReserveOrderId = jsonObject.get("rxTReserveOrderId").toString();
	    			if(rxTReserveOrderId.equals("-1000")){//如果 -1000(缺货) -1001(商品不存在)
	    				writeObjectToResponse(new ErrorMessage(false,"8",""), ContentType.application_json);//缺货
	    				return;
	    			}else if(rxTReserveOrderId.equals("-1001")){
	    				writeObjectToResponse(new ErrorMessage(false,"9",""), ContentType.application_json);//商品不存在
	    				return;
	    			}else if(rxTReserveOrderId.equals("-1002")){
	    				writeObjectToResponse(new ErrorMessage(false,"10",""), ContentType.application_json);//商品已下架
	    				return;
	    			}
	    		}
	    	}
	    }
	    
	    writeObjectToResponse(new ErrorMessage(false,"7",""), ContentType.application_json);//保存预订单失败
	    System.out.println(resultJsonstr);
	    
	}
	
	private void sendSuccessMsg(String mobile) throws Exception{
		//发送短信
		Map<String, String> map = new HashMap<String, String>();
		map.put("mobiles", mobile);
		map.put("smsContent", InfoUtil.getInstance().getInfo("smsmessages", "createReserveOrderSuccessMsg"));
		String YAO_GATEWAY_URL =tsysparametermanager.getKeys("sms");
		String buildRequestBySMS = ClientSubmit.buildRequestBySMS(map,YAO_GATEWAY_URL);
	}
	
	/**
	 * 说明：组织调用payment项目的接口url(用于获取微信支付二维码图片的url)
	 * @param order	订单
	 * @param orderFlow	支付流水
	 * @param request
	 * @param response
	 * @return
	 */
	public String getErweiMaUrl(TOrder order,TOrderFlow orderFlow,HttpServletRequest request, HttpServletResponse response){
		
		String payurl =InfoUtil.getInstance().getInfo("config","pay.payServiceUri");
		// 商品描述
		String body = order.getOrderSn();
		String detail = body;
		String total_fee =orderFlow.getHavePay().multiply(new BigDecimal(100)).setScale(0).toString();
		String spbill_create_ip = NetworkUtil.getIpAddress(request);
		String notify_url =  payurl+InfoUtil.getInstance().getInfo("config","wxNotifyUri");//回掉方法
		String trade_type = WXTradeType.NATIVE.toString();
		String product_id = order.getId().toString();
		
		//获取私钥,生成sign
		Map<String,Object> sendPaymentMap = new HashMap();
		sendPaymentMap.put("body", body);
		sendPaymentMap.put("detail", detail);
		sendPaymentMap.put("out_trade_no", order.getOrderSn());//订单编号
		sendPaymentMap.put("total_fee", total_fee);
		sendPaymentMap.put("spbill_create_ip", spbill_create_ip);
		sendPaymentMap.put("notify_url", notify_url);
		sendPaymentMap.put("trade_type", trade_type);
		sendPaymentMap.put("product_id", product_id);
		String sign = Signature.getSign(sendPaymentMap,InfoUtil.getInstance().getInfo("config","wx.wxPaymentPk"));
		
		
		//组织需要传的参数
		StringBuilder sendParams = new StringBuilder();
		sendParams.append("?body=").append(body)
					.append("&detail=").append(detail)
					.append("&out_trade_no=").append(order.getOrderSn())//订单编号
					.append("&total_fee=").append(total_fee)
					.append("&spbill_create_ip=").append(spbill_create_ip)
					.append("&notify_url=").append(notify_url)
					.append("&trade_type=").append(trade_type)
					.append("&product_id=").append(product_id)
					.append("&sign=").append(sign);
		
		//调用paymentService接口,获取微信二维码
		String url = payurl+InfoUtil.getInstance().getInfo("config","pay.goUnifiedOrderServiceUri");
		System.out.println(url + sendParams);
		return url + sendParams;
	}
	
	
	/**
	 * 检索城市
	 * @throws SQLException 
	 */
	public void searchCity() throws SQLException{
		String cityname = this.getRequest().getParameter("cityname");
		if(StringUtils.hasText(cityname)){
			CLocationCityExample cityexample = new CLocationCityExample();
			cityexample.createCriteria().andGradeEqualTo(2).andNameLike("%"+cityname+"%");
			cityexample.setOrderByClause(" pinyin asc");
			List<CLocationCity> cityList =this.clocationcitymanager.selectByExample(cityexample);
			this.writeObjectToResponse(cityList, ContentType.application_json);
		}
	}
	
	/**
	 * 动态获取收货地址列表
	 * @throws SQLException 
	 */
	public void ajaxReceiverList() throws Exception{
		TMember member = (TMember)this.getSession().getAttribute("member");
		Long memberId = member.getId();
		
	   
		String publicServiceUrl = tsysparametermanager.getKeys("public_service_url");
		Map<String,String> publicMap = new HashMap<String,String>();
		publicMap.put("member_id", String.valueOf(memberId));
	    String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"getReceiverAddress");
	   
	    List<Map<String, Object>> resultList = null;
	    JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
		if (jsonObject != null) {
			JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("list"));
			resultList = (List<Map<String, Object>>) JSONArray.toCollection(jsonArray, HashMap.class);
		}
//	 // 查询收获地址
// 		TMemberReceiverExample example = new TMemberReceiverExample();
// 		example.createCriteria().andMemberIdEqualTo(memberId);
// 		example.setOrderByClause(" is_default desc");
// 		List<TMemberReceiver> receiverList = tmemberreceivermanager.selectByExample(example);
 		this.writeObjectToResponse(resultList,ContentType.application_json);
		
	}
	
	
	/**
	 * 设为默认收货地址
	 */
	public void ajaxReceiverSetDefault() throws Exception {
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		String receiverId = this.getRequest().getParameter("receiverId");
		if (StringUtils.hasText(receiverId)) {
			this.tmemberreceiverlatlonmanager.updateReceiverDefault(Long.valueOf(receiverId),sessionMember.getId());
			writeObjectToResponse("1", ContentType.text_html);
		} else {
			writeObjectToResponse("0", ContentType.text_html);
		}
	}
	
	
	/**
	 * 删除收货地址
	 */
	public void ajaxDeleteReceiver() throws Exception {
		if (StringUtils.hasText(this.getRequest().getParameter("id"))) {
			this.tmemberreceiverlatlonmanager.deleteByPrimaryKey(Long.valueOf(this.getRequest().getParameter("id")));
			writeObjectToResponse("1", ContentType.text_html);
		} else {
			writeObjectToResponse("0", ContentType.text_html);
		}
	}
	
	/**
	 * ajax动态获取收货地址信息
	 * @throws SQLException 
	 * @throws NumberFormatException 
	 */
	public void ajaxReceiver() throws Exception{
		String receiverId = this.getRequest().getParameter("receiverId");//收货地址id
		if(StringUtils.hasText(receiverId)){
			
			TMember member = (TMember)this.getSession().getAttribute("member");
			Long memberId = member.getId();
		   
			String publicServiceUrl = tsysparametermanager.getKeys("public_service_url");
			Map<String,String> publicMap = new HashMap<String,String>();
			publicMap.put("member_id", String.valueOf(memberId));
			publicMap.put("id", receiverId);
		    String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"getReceiverAddressById");
		   
		    List<Map<String, Object>> resultList = null;
		    Map<String, Object> resultMap = null;
		    JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
			if (jsonObject != null) {
				resultMap = (Map<String, Object>) JSONObject.toBean(JSONObject.fromObject(jsonObject.get("address")),Map.class);
			}
			String beijingFlag ="0";//收获地址是否是北京  1 是  0 否
			String hdfk_area =tsysparametermanager.getKeys("paymethod_hdfk_area");// 得到支持 货到付款的区域
			if(resultMap!=null&&resultMap.get("area")!=null&&String.valueOf(resultMap.get("area")).indexOf(hdfk_area)!=-1){
				beijingFlag="1";
			}
			Map<String,Object> receiverMap = new HashMap<String,Object>();
			receiverMap.put("beijingFlag", beijingFlag);
			if(resultMap!=null&&resultMap.get("area_id")!=null){
				resultMap.put("citycode", this.clocationcitymanager.selectByPrimaryKey(Integer.valueOf(String.valueOf(resultMap.get("area_id")))).getCitycode());
			}
			receiverMap.put("receiver", resultMap);
			this.writeObjectToResponse(receiverMap,ContentType.application_json);
		}
	}
	
	/**
	 *  ajax 保存或是修改  收货地址
	 * @throws SQLException 
	 */
	public void ajaxSaveOrUpdateReceiver() throws Exception{
		TMember member = (TMember) this.getSession().getAttribute("member");
		Long memberId = member.getId();
		String publicServiceUrl = tsysparametermanager.getKeys("public_service_url");
		Map<String,String> publicMap = new HashMap<String,String>();
		publicMap.put("member_id", String.valueOf(memberId));
		publicMap.put("mobile", tmemberreceiver.getMobile());
		publicMap.put("receiver", tmemberreceiver.getReceiver());
		publicMap.put("longitude", tmemberreceiver.getLongitude());
		publicMap.put("latitude", tmemberreceiver.getLatitude());
		publicMap.put("locationAddress", tmemberreceiver.getLocationAddress());
		publicMap.put("address", tmemberreceiver.getAddress());
		publicMap.put("zipCode", tmemberreceiver.getZipCode());
		String memberReceiver_adcode = this.getRequest().getParameter("memberReceiver_adcode");
		CLocationCityExample example = new CLocationCityExample();
		example.createCriteria().andCitycodeEqualTo(memberReceiver_adcode).andGradeEqualTo(2);
		List<CLocationCity> cityList =this.clocationcitymanager.selectByExample(example);
		if(cityList!=null&&cityList.size()>0){
			publicMap.put("areaId",String.valueOf(cityList.get(0).getId()));
		}
		if (tmemberreceiver.getId() != null) {
			publicMap.put("id", String.valueOf(tmemberreceiver.getId()));
		    String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"updateReceiverAddress");
		    JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
			if (jsonObject != null && jsonObject.get("statusCode") != null && "1".equals(jsonObject.get("statusCode"))) {
				this.writeObjectToResponse(tmemberreceiver.getId(),ContentType.application_json);
			}else{
				this.writeObjectToResponse("",ContentType.application_json);
			}
		} else {
			String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"addReceiverAddress");
			JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
			if (jsonObject != null && jsonObject.get("statusCode") != null && "1".equals(jsonObject.get("statusCode"))) {
				Long id = Long.valueOf(String.valueOf(jsonObject.get("id")));
				this.writeObjectToResponse(id,ContentType.application_json);
			}else{
				this.writeObjectToResponse("",ContentType.application_json);
			}
		}
	}
	

	class InterfaceResult {
		private int status;
		private String messsage;

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getMesssage() {
			return messsage;
		}

		public void setMesssage(String messsage) {
			this.messsage = messsage;
		}
	}

	
	public class ErrorMessage {
		private boolean flag;
		private String message;
		private String messageContent;
		
		public ErrorMessage() {
			super();
		}
		public ErrorMessage(boolean flag, String message,String messageContent) {
			super();
			this.flag = flag;
			this.message = message;
			this.messageContent= messageContent;
		}
		public boolean isFlag() {
			return flag;
		}
		public void setFlag(boolean flag) {
			this.flag = flag;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getMessageContent() {
			return messageContent;
		}
		public void setMessageContent(String messageContent) {
			this.messageContent = messageContent;
		}
       
		
	}
	
	
	public Condition getModel() {
		return model;
	}


	public TMemberReceiverLatLonManager getTmemberreceiverlatlonmanager() {
		return tmemberreceiverlatlonmanager;
	}

	public void setTmemberreceiverlatlonmanager(
			TMemberReceiverLatLonManager tmemberreceiverlatlonmanager) {
		this.tmemberreceiverlatlonmanager = tmemberreceiverlatlonmanager;
	}

	public CPaymentWayManager getCpaymentwaymanager() {
		return cpaymentwaymanager;
	}

	public void setCpaymentwaymanager(CPaymentWayManager cpaymentwaymanager) {
		this.cpaymentwaymanager = cpaymentwaymanager;
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

	public TOrder getOrder() {
		return order;
	}


	public void setOrder(TOrder order) {
		this.order = order;
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


	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}

	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}

	public CDeliveryWayManager getCdeliverywaymanager() {
		return cdeliverywaymanager;
	}

	public void setCdeliverywaymanager(CDeliveryWayManager cdeliverywaymanager) {
		this.cdeliverywaymanager = cdeliverywaymanager;
	}

	public CLocationCityManager getClocationcitymanager() {
		return clocationcitymanager;
	}

	public void setClocationcitymanager(CLocationCityManager clocationcitymanager) {
		this.clocationcitymanager = clocationcitymanager;
	}

	public TMemberReceiverLatLon getTmemberreceiver() {
		return tmemberreceiver;
	}

	public void setTmemberreceiver(TMemberReceiverLatLon tmemberreceiver) {
		this.tmemberreceiver = tmemberreceiver;
	}


	/**
	 * 从商品页跳转到预订单创建页面
	 * @return
	 * @throws Exception
	 */
	public String toReserveOrderAdd() throws Exception{
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		if(member == null){
			return null;
		}
		
		Long memberId =member.getId();
		
		// 查询收获地址
		TMemberReceiverLatLonExample example = new TMemberReceiverLatLonExample();
		example.createCriteria().andMemberIdEqualTo(memberId);
		example.setOrderByClause(" is_default desc ,id desc");
		List<TMemberReceiverLatLon> receiverLatLonList = tmemberreceiverlatlonmanager.selectByExample(example);
		String receiverId = null;
		TMemberReceiverLatLon receiverLatLon = null;
		String receiverSizeFlag ="0"; //0 表示不够10个   1 表示超过10个
		if(receiverLatLonList!=null&&receiverLatLonList.size()>0){
			receiverLatLon=receiverLatLonList.get(0);
			receiverId = String.valueOf(receiverLatLonList.get(0).getId());
			this.getRequest().setAttribute("receiverId", Long.valueOf(receiverId));
			for(TMemberReceiverLatLon receiverlat:receiverLatLonList){
//				if(!StringUtils.hasText(receiverlat.getLatitude())){
//					receiverlat.setLocationAddress(""); 
//				}
				if(StringUtils.hasText(receiverlat.getLocationAddress())){
					String location_address =receiverlat.getLocationAddress();
					String address =receiverlat.getAddress();
					String area = receiverlat.getArea();
					if(StringUtils.hasText(location_address)){
						if(!(!address.startsWith(location_address)&&area.indexOf(location_address)==-1)){
							receiverlat.setLocationAddress("");
						}
					}
				}
			}
			if(receiverLatLonList.size()>9){
				receiverSizeFlag="1";
			}
		}
		this.getRequest().setAttribute("receiverSizeFlag", receiverSizeFlag);
//		String receiverId = null;
//		TMemberReceiverLatLon receiverLatLon = null;
//		if(receiverLatLonList!=null&&receiverLatLonList.size()>0){
//			receiverLatLon=receiverLatLonList.get(0);
//			receiverId = String.valueOf(receiverLatLonList.get(0).getId());
//			this.getRequest().setAttribute("receiverId", receiverId);
//			for(TMemberReceiverLatLon receiverlat:receiverLatLonList){
//				if(!StringUtils.hasText(receiverlat.getLatitude())){
//					receiverlat.setLocationAddress("");
//				}
//			}
//		}
		
		// 查询可以用的优惠券
		this.getRequest().setAttribute("receiverList", receiverLatLonList);//收货地址
		
//		CLocationCityExample cityexample = new CLocationCityExample();
//		cityexample.createCriteria().andGradeEqualTo(2);
//		cityexample.setOrderByClause(" pinyin asc");
//		List<CLocationCity> cityList =this.clocationcitymanager.selectByExample(cityexample);
//		List<CLocationCity> cityzimuList = null;
//		TreeMap<String,List<CLocationCity>> zimuMap = new TreeMap<String,List<CLocationCity>>();
//		for(CLocationCity city:cityList){
//			if(zimuMap.get(city.getPinyin())!=null){
//				cityzimuList = zimuMap.get(city.getPinyin());
//				cityzimuList.add(city);
//				zimuMap.put(city.getPinyin(), cityzimuList);
//			}else{
//				cityzimuList = new ArrayList<CLocationCity>();
//				cityzimuList.add(city);
//				zimuMap.put(city.getPinyin(), cityzimuList);
//			}
//		}
//		this.getRequest().setAttribute("zimuMap", zimuMap);
		
		String goodsId = this.getRequest().getParameter("goodsId");//商品id
		if(goodsId == null || goodsId.trim().length() == 0){
			return null;
		}
		Map<String,Object> reserveOrderMap = rxtreserveordermanager.getReserveOrderPrice(receiverId,memberId,Long.valueOf(goodsId),1);
		Map goodsMap = (Map) reserveOrderMap.get("goods");
		this.getRequest().setAttribute("goods", goodsMap);
//		BigDecimal freight =  (BigDecimal) reserveOrderMap.get("freight");//运费
//		BigDecimal pcPrice =(BigDecimal) goodsMap.get("pcPrice");
//		this.getRequest().setAttribute("freight", freight);
//		this.getRequest().setAttribute("totalAmount", freight.add(pcPrice));
		return "reserve_order_add";
	}
    
	public void uploadImg() throws IOException{
		int flag =-1;
		String msg="EXCEL上传出现异常";
		this.getRequest().setCharacterEncoding("utf-8");
	    this.getResponse().setContentType("text/html;charset=utf-8");
		PrintWriter out = this.getResponse().getWriter();
		String basePath = this.getRequest().getSession().getServletContext().getRealPath("/");
		String filename = model.getReserveImgFileName();
		String fileType= FilenameUtils.getExtension(filename);
		String fullName= "";
		String imgUrl = "";
		File file = model.getReserveImg();
		if(checkFileType(fileType)){
			if(file.length()<MAXSIZE){
				String fullPath=diskPath+getDiskName()+"/"+DigestUtils.md5Hex(String.valueOf(System.currentTimeMillis()));
				imgUrl=fullPath+"."+fileType;
				fullName=basePath+imgUrl;
				File uploadFile = new File(fullName);
				FileUtils.copyFile(file, uploadFile);//上传文件
				flag=1;
				msg="文件上传成功";
			}else{
				flag =2;
				msg="上传文件大小超过5M";
			}
		}else{
			flag=0;
			msg="上传文件类型错误,暂支持jpg/png/gif格式的图片";
		}
		Map map = new HashMap();
		map.put("fileType", fileType);
		map.put("flag", flag);
		map.put("msg", msg);
		map.put("imgUrl", imgUrl);
		System.out.println(JSONObject.fromObject(map).toString());
		writeObjectToResponse(map, ContentType.text_html);
//		out.write("{\"imgUrl\":\"111\"}");
//		out.write(JSONObject.fromObject(map).toString());
//		out.close();
		return;
	}
	
	/**
	 * 检查文件类型
	 * @param type
	 * @return
	 */
	public boolean checkFileType(String type){
		boolean flag=false;
		type = type.toLowerCase();
		String[] arrType={"jpg","png","gif"};
		for(String s:arrType){
			if(type.equals(s)){
				return true;
			}
		}
		return flag;
	}
	
	public class Condition{
		private File reserveImg;
		private String reserveImgFileName;//文件名
		public File getReserveImg() {
			return reserveImg;
		}
		public void setReserveImg(File reserveImg) {
			this.reserveImg = reserveImg;
		}
		public String getReserveImgFileName() {
			return reserveImgFileName;
		}
		public void setReserveImgFileName(String reserveImgFileName) {
			this.reserveImgFileName = reserveImgFileName;
		}
		
	}
	
	public static String getDiskName(){
		String diskname="";
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		diskname =df.format(new Date());
		return diskname;
		
	}
	
    		
	/**
	 * 计算预订单价格
	 * @return
	 * @throws Exception
	 */
	public void calculatePrice() throws Exception{
		//获取参数：商品id,商品数量,receiveId
		String goodsId = getRequest().getParameter("goodsId");
		int goodsNum = DataUtil.getIntVal(getRequest().getParameter("goodsNum"));
		String receiverId = getRequest().getParameter("receiverId");
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		
		Long memberId =member.getId();
		if(goodsNum < 0){
			Map map = new HashMap();
			map.put("state", 5);//商品数量不正确
			writeObjectToResponse(map, ContentType.text_html);
			return ;
		}
		
		if(goodsId == null || goodsId.trim().length() == 0){
			Map map = new HashMap();
			map.put("state", 4);//商品不存在
			writeObjectToResponse(map, ContentType.text_html);
			return ;
		}
		
		String publicServiceUrl = tsysparametermanager.getKeys("public_service_url");
		
		Map<String,String> publicMap = new HashMap<String,String>();
		publicMap.put("memberId", String.valueOf(memberId));
		publicMap.put("receiverId", receiverId);
		publicMap.put("goodid", goodsId);
		publicMap.put("num", goodsNum+"");
		publicMap.put("source", "1");
		String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"getReserveOrderPricesURLService");
	    JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
	    System.out.println("***"+jsonObject.toString());
	    writeObjectToResponse(jsonObject, ContentType.text_html);
		return ;
	}
//	/**
//	 * 计算预订单价格
//	 * @return
//	 * @throws Exception
//	 */
//	public void calculatePrice() throws Exception{
//		//获取参数：商品id,商品数量,receiveId
//		String goodsId = getRequest().getParameter("goodsId");
//		int goodsNum = DataUtil.getIntVal(getRequest().getParameter("goodsNum"));
//		String receiverId = getRequest().getParameter("receiverId");
//		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
//		
//		Long memberId =member.getId();
//		if(goodsNum < 0){
//			Map map = new HashMap();
//			map.put("state", 5);//商品数量不正确
//			writeObjectToResponse(map, ContentType.text_html);
//			return ;
//		}
//		
//		if(goodsId == null || goodsId.trim().length() == 0){
//			Map map = new HashMap();
//			map.put("state", 4);//商品不存在
//			writeObjectToResponse(map, ContentType.text_html);
//			return ;
//		}
//		Map<String,Object> reserveOrderMap = rxtreserveordermanager.getReserveOrderPrice(receiverId,memberId,Long.valueOf(goodsId),goodsNum);
//		Map goodsMap = (Map) reserveOrderMap.get("goods");
//		if(goodsMap != null){
//			long stock = (Long) goodsMap.get("stock");
//			if(goodsNum > stock){
//				Map map = new HashMap();
//				map.put("state", 2);//库存不足
//				writeObjectToResponse(map, ContentType.text_html);
//				return ;
//			}
//		}else{
//			Map map = new HashMap();
//			map.put("state", 3);//商品不存在
//			writeObjectToResponse(map, ContentType.text_html);
//			return ;
//		}
//		
//		
//		this.getRequest().setAttribute("goods", goodsMap);
//		
//		BigDecimal freight =  (BigDecimal) reserveOrderMap.get("freight");
//		BigDecimal totalAmount =  (BigDecimal) goodsMap.get("totalAmount");
//		this.getRequest().setAttribute("freight", reserveOrderMap.get("freight"));
//		this.getRequest().setAttribute("totalAmount", reserveOrderMap.get("totalAmount"));
//		
//		Map map = new HashMap();
//		map.put("freight", freight);
//		map.put("totalAmount", totalAmount);
//		map.put("pcPrice",goodsMap.get("pcPrice"));
//		map.put("goodsTotal",goodsMap.get("goodsTotal"));
//		map.put("state", 1);
//		System.out.println(JSONObject.fromObject(map).toString());
//		writeObjectToResponse(map, ContentType.text_html);
//		return ;
//	}
	
	
	public String reserveOrderAddSuccess(){
		String reserveOrderId = getRequest().getParameter("reserveOrderId");
		String orderAmount = getRequest().getParameter("orderAmount");
		
		
		//【TODO:】加上发短信
		getRequest().setAttribute("reserveOrderId", reserveOrderId);
		getRequest().setAttribute("orderAmount", orderAmount);
		return "reserve_order_add_success";
	}
	
	
}
