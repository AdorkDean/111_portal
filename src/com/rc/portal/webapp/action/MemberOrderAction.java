package com.rc.portal.webapp.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

import org.springframework.util.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.commons.util.InfoUtil;
import com.rc.dst.client.util.ClientSubmitPublic;
import com.rc.openapi.dubbo.model.TOrderGoodModel;
import com.rc.openapi.serviceApi.OrderServiceDubboApi;
import com.rc.portal.jms.MessageSender;
import com.rc.portal.payplugin.PaymentPlugin;
import com.rc.portal.payplugin.payWzf.util.Signature;
import com.rc.portal.payplugin.payWzf.util.WXTradeType;
import com.rc.portal.service.CDeliveryWayManager;
import com.rc.portal.service.CLocationCityManager;
import com.rc.portal.service.CPaymentWayManager;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.PaymentPluginMaager;
import com.rc.portal.service.TCouponCardManager;
import com.rc.portal.service.TCouponManager;
import com.rc.portal.service.TGoodsManager;
import com.rc.portal.service.TLeaderStayMoneyManager;
import com.rc.portal.service.TMemberAccountManager;
import com.rc.portal.service.TMemberBaseMessageExtManager;
import com.rc.portal.service.TMemberReceiverLatLonManager;
import com.rc.portal.service.TOrderFlowManager;
import com.rc.portal.service.TOrderItemManager;
import com.rc.portal.service.TOrderManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.util.NetworkUtil;
import com.rc.portal.util.OrderEnum;
import com.rc.portal.vo.CDeliveryWay;
import com.rc.portal.vo.CDeliveryWayExample;
import com.rc.portal.vo.CLocationCity;
import com.rc.portal.vo.CLocationCityExample;
import com.rc.portal.vo.CPaymentWay;
import com.rc.portal.vo.CPaymentWayExample;
import com.rc.portal.vo.TCouponCardExample;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberAccount;
import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.vo.TMemberReceiverLatLon;
import com.rc.portal.vo.TMemberReceiverLatLonExample;
import com.rc.portal.vo.TOrder;
import com.rc.portal.vo.TOrderExample;
import com.rc.portal.vo.TOrderFlow;
import com.rc.portal.vo.TOrderFlowExample;
import com.rc.portal.webapp.model.OrderGoodCart;
import com.rc.portal.webapp.util.PageResult;

/**
 * 订单中心
 * @author 刘天灵
 *
 */
public class MemberOrderAction extends BaseAction{

	private static final long serialVersionUID = 646464661L;
	
	private static int PAGE_SIZE = 10;
	
	private PageWraper pw = new PageWraper();
	
	private PageResult rs = new PageResult(); 
	
	/**
	 * 优惠券manager
	 */
	private TCouponManager tcouponmanager;
	
	/**
	 * 订单manager
	 */
	private TOrderManager tordermanager;
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
	 * 用户资金manager
	 */
	private TMemberAccountManager tmemberaccountmanager;
	
	/**
	 * 地区城市码表
	 */
	private CLocationCityManager clocationcitymanager;
	
	/**
	 * 订单支付流水表
	 */
	private TOrderFlowManager torderflowmanager;
	
	/**
	 * 支付插件
	 */
	private PaymentPluginMaager paymentpluginmaager;
	/**
	 * 订单商品表
	 */
	private TOrderItemManager torderitemmanager;
	
	
	private TOrder order;
	/**
	 * 优惠券
	 */
	private TCouponCardManager tcouponcardmanager;
	
	private TSysParameterManager tsysparametermanager;
	
	private MessageSender topicMessageSender;
	
	private TLeaderStayMoneyManager tleaderstaymoneymanager;
	
	/*****OrderServiceDubboApi*******/
	private OrderServiceDubboApi orderservicedubboapi;
	
	/**
	 * 配送方式manager
	 */
	private CDeliveryWayManager cdeliverywaymanager;
	
	/**
	 * 收货地址
	 */
	private TMemberReceiverLatLon tmemberreceiver;
	
	/**
	 * 用户基本信息扩展表
	 */
	private TMemberBaseMessageExtManager tmemberbasemessageextmanager;
	
	/**
	 * 订单中心
	 * @return
	 * @throws SQLException 
	 */
	public String toAddress() throws SQLException{
		
		return "address";
	}
	
	/**
	 * 订单中心
	 * @return
	 * @throws SQLException 
	 */
	public String index() throws SQLException{
		TMember member = (TMember)this.getSession().getAttribute("member");
		
		TMemberAccount account = tmemberaccountmanager.selectByPrimaryKey(member.getId());
		
		this.getRequest().setAttribute("account", account);
		
		Object currentGrade = this.opensqlmanage.selectObjectByObject(member.getMemberGradeId().toString(), "t_member_grade.selectCurrentGrade");
		this.getRequest().setAttribute("currentGrade", currentGrade);
		
		
		
		Object nextGrade = this.opensqlmanage.selectObjectByObject(member.getMemberGradeId().toString(), "t_member_grade.selectNextGrade");
		
		if(nextGrade==null){
			this.getRequest().setAttribute("nextGrade", currentGrade);
		}else{
			this.getRequest().setAttribute("nextGrade", nextGrade);
		}
		
		
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberId", member.getId());
		
		//待确认订单
		Object unconfirmCount = this.opensqlmanage.selectObjectByObject(param, "t_order.select_unconfirm_count");
		this.getRequest().setAttribute("unconfirmCount", unconfirmCount);
		//待支付订单
		Object unpaidCount = this.opensqlmanage.selectObjectByObject(param, "t_order.select_unpaid_count");
		this.getRequest().setAttribute("unpaidCount", unpaidCount);
		//待评价优惠券
		Object toEvaluateCount = this.opensqlmanage.selectObjectByObject(param, "t_order.select_to_evaluate_count");
		this.getRequest().setAttribute("toEvaluateCount", toEvaluateCount);	
		//可使用优惠券
		Object couponCardUseCount = this.opensqlmanage.selectObjectByObject(param, "t_coupon_card.selectCountUse");
		this.getRequest().setAttribute("couponCardUseCount", couponCardUseCount);
		
		//会员收藏
		Object memberCollectCount = this.opensqlmanage.selectObjectByObject(param, "t_member_collect.selectCountToMember");
		this.getRequest().setAttribute("memberCollectCount", memberCollectCount);
		//会员商品咨询
		Object memberConsultCount = this.opensqlmanage.selectObjectByObject(param, "t_goods_consult.selectMemberConsultCount");
		this.getRequest().setAttribute("memberConsultCount", memberConsultCount);
		
		return "index";
	}
	
	/**
	 * 订单列表
	 */
	public String list(){
		
		String type = this.getRequest().getParameter("type");
		String time = this.getRequest().getParameter("time");
		
		if(!org.apache.commons.lang.StringUtils.isNumeric(type) || Integer.parseInt(type) > 4  || Integer.parseInt(type) < 1){
			type = "1";
		}
		
		if(!org.apache.commons.lang.StringUtils.isNumeric(time) || Integer.parseInt(time) > 4 || Integer.parseInt(time) < 1){
			time = "1";
		}
		
		TMember member = (TMember)this.getSession().getAttribute("member");
		
		Map<String,Object> param = new HashMap<String,Object>();
		
		param.put("memberId", member.getId());
		
		
		if(org.apache.commons.lang.StringUtils.isNotEmpty(this.getRequest().getParameter("sn"))){
			param.put("sn", this.getRequest().getParameter("sn"));
		}
		
		if(time.equals("2")){
			//一个月之内
			Date oneMonth = new Date();
			oneMonth.setMonth(oneMonth.getMonth() -1);
			param.put("oneMonth", oneMonth);
		}else if(time.equals("3")){
			//三个月之内
			Date threeMonth = new Date();
			threeMonth.setMonth(threeMonth.getMonth() -3);
			param.put("threeMonth", threeMonth);
		}else if(time.equals("4")){
			//历史订单
			Date history = new Date();
			history.setMonth(history.getMonth() -3);
			param.put("history", history);
		}
		
		if(type.equals("2")){
			//未支付订单
			pw = this.opensqlmanage.selectForPageByMap(param, "t_order.select_unpaid_count", "t_order.select_unpaid_list", rs.getP_curPage(), PAGE_SIZE);
		}else if (type.equals("3")){
			//待收货订单
			pw = this.opensqlmanage.selectForPageByMap(param, "t_order.select_unconfirm_count", "t_order.select_unconfirm_list", rs.getP_curPage(), PAGE_SIZE);
		}else if(type.equals("4")){
			//待评价订单
			pw = this.opensqlmanage.selectForPageByMap(param, "t_order.select_to_evaluate_count", "t_order.select_to_evaluate_list", rs.getP_curPage(), PAGE_SIZE);
		}else{
			//全部订单
			pw = this.opensqlmanage.selectForPageByMap(param, "t_order.select_count", "t_order.select_list", rs.getP_curPage(), PAGE_SIZE);
		}
		
		this.getRequest().setAttribute("type", type);
		this.getRequest().setAttribute("time", time);
		
		return "list";
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
	
	/**
	 * 订单详情
	 * 方法名：detail<BR>
	 * 创建人：Marlon <BR>
	 * @return String <BR>
	 * @throws Exception 
	 */
	public String detail() throws Exception{
		
		String orderId = this.getRequest().getParameter("id");
		int logisticFlag = 0;//物流信息列表标识 1显示 0不显示
		int flowFlag = 0;//物流进度标识 1显示 0不显示
		if (StringUtils.hasText(orderId)) {
			com.rc.openapi.dubbo.vo.TOrder tOrder = orderservicedubboapi.getOrderById(Long.parseLong(orderId.trim()));
			if (tOrder!=null) {
				this.getRequest().setAttribute("order", tOrder);
				/**
				 * 0待支付 1待发货 2待收货 3已完成 4已取消 5已过期 6已关闭
				 * 4已取消 5已过期 表示不显示物流进度标识
				 * 0待支付 1待发货 4已取消  表示不显示物流信息标识
				 */
				int status = tOrder.getOrderStatus();
				
				//支付信息（pay_date付款时间）
				com.rc.openapi.dubbo.vo.TOrderFlow orderFlow = orderservicedubboapi.getOrderFlowOrderId(Long.parseLong(orderId.trim()));
				this.getRequest().setAttribute("orderFlow", orderFlow);
				if (status!=4&&status!=5) {//flowFlag代表0 1 2 3 6
					flowFlag = 1;
				}
				if((status==2||status==3||status==6)){//如果显示物流信息  【去查询】logisticFlag代表 2 3 6
					logisticFlag = 1;
					//物流信息
					com.rc.openapi.dubbo.vo.TOrderShipment orderShipment = orderservicedubboapi.getOrderShipByOrderId(Long.parseLong(orderId.trim()));
					this.getRequest().setAttribute("shipment", orderShipment);
				}
				//该订单下商品项信息的查询
				List<TOrderGoodModel> goodList= orderservicedubboapi.getTOrderGoodListByOrderId(Long.parseLong(orderId.trim()), null);
				if (goodList!=null && goodList.size()>0) {
					List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();//用于存放商品项
					Map<String, Object> map = null;//存放商品项单条商品信息
					for (TOrderGoodModel good : goodList) {
						map = new HashMap<String, Object>();
						map.put("goodsNo", good.getGoodsNo());
						map.put("goodsId", good.getGoodsid());
						map.put("img", good.getAbbreviationPicture());
						map.put("goodsName", good.getGoodsName());
						map.put("price", good.getPrice());
						map.put("num", good.getQuantity());
						System.out.println(good.getGoodsNo());
						items.add(map);
					}
					this.getRequest().setAttribute("goods", items);
				}
			}
			this.getRequest().setAttribute("logisticFlag", logisticFlag);
			this.getRequest().setAttribute("flowFlag", flowFlag);
		}
		return "detail";
	}
	
	/**
	 * 根据收货地址，支付方式 查询配送方式
	 * @param receiverLatLon
	 * @param paymentWayId
	 * @return
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
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
	    		 }else if(receiverLatLon.getArea().indexOf(hdfk_area)!=-1){//判断是否是北京   
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
					resultMap.put("deliveryCode", delivery.getDeliveryCode());
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
					if("1".equals(resultMap.get("isflag"))){
						deliveryWayList.add(resultMap);
					}
				}
			}
			return deliveryWayList;
	}
	
	
	/**
	 * 从购物车跳转到结算页面
	 * @return
	 * @throws Exception
	 */
	public String toOrderAdd() throws Exception{
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		Long memberId =member.getId();
		String shortOrderId="";//暂时不用
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
		
		// 支付方式
		CPaymentWayExample paymentWayExample = new CPaymentWayExample();
		paymentWayExample.setOrderByClause("sort asc");
		List<CPaymentWay> paymentWayList = cpaymentwaymanager.selectByExampleAndReceiverId(paymentWayExample,receiverLatLon);
		Long paymentWayId =null;//支付方式id
 		if(paymentWayList!=null&&paymentWayList.size()>0){
 			paymentWayId = paymentWayList.get(0).getId();
		}
		this.getRequest().setAttribute("paymentWayId", paymentWayId);
		
		//获取配送方式
		List<Map<String,Object>> deliveryWayList = this.getDeliveryWayList(receiverLatLon, paymentWayId==null?"":String.valueOf(paymentWayId));
		Long deliveryId =null;
		if(deliveryWayList!=null&&deliveryWayList.size()>0){
			deliveryId= (Long) deliveryWayList.get(0).get("id");
		}
		this.getRequest().setAttribute("deliveryId", deliveryId);
		String cartType = this.getRequest().getParameter("cartType"); // 购物车结算商品类型   0 全部   1 非医卡通商品  2 医卡通商品
		if(!StringUtils.hasText(cartType)){
			cartType="0";
		}
		//正常购买
//		if(!StringUtils.hasText(shortOrderId)){
			// 查询可以用的优惠券
			List<Map<String, Object>> couponList = this.tordermanager.getCouponByGoods(cartType,null,String.valueOf(memberId));
			this.getRequest().setAttribute("couponList", couponList);//优惠券
			this.getRequest().setAttribute("couponListSize", couponList.size());//优惠券个数
			this.getRequest().setAttribute("receiverList", receiverLatLonList);//收货地址
			this.getRequest().setAttribute("paymentWayList", paymentWayList);//支付方式
			//计算订单相关金额
			Map<String, Object> resultMap =tordermanager.getOrderPrice(cartType,null,receiverId,String.valueOf(memberId),paymentWayId==null?"":String.valueOf(paymentWayId),shortOrderId,deliveryId==null?"":String.valueOf(deliveryId));
			if(resultMap!=null){
				this.getRequest().setAttribute("goodsList", resultMap.get("goodsList"));//商品
				this.getRequest().setAttribute("orderPrice", resultMap.get("orderPrice"));
				this.getRequest().setAttribute("shippingFee", resultMap.get("shippingFee"));
				this.getRequest().setAttribute("couponDiscount", resultMap.get("couponDiscount"));
				this.getRequest().setAttribute("promotionalDiscount",resultMap.get("promotionalDiscount"));
				this.getRequest().setAttribute("payableAmount", resultMap.get("orderPrice"));
				this.getRequest().setAttribute("goodsPrice", resultMap.get("goodsPrice"));
			}
			shortOrderId="";
//		}else{//秒杀购买
//			// 查询购物车商品
//			Map<String, Object> paramMap = new HashMap<String, Object>();
//			paramMap.put("shortOrderId", Long.parseLong(shortOrderId));
//			paramMap.put("memberId", memberId);
//			List<OrderGoodCart> goodsList = this.opensqlmanage.selectForListByMap(paramMap,"t_goods.selectGoodsByShortOrderId");
//			this.getRequest().setAttribute("receiverList", receiverLatLonList);//收货地址
//			this.getRequest().setAttribute("paymentWayList", paymentWayList);//支付方式
//			this.getRequest().setAttribute("goodsList", goodsList);//商品
//			BigDecimal goodsPrice =new BigDecimal("0");
//			if(goodsList!=null&&goodsList.size()>0){
//				goodsPrice=goodsList.get(0).getPcPrice().multiply(new BigDecimal(goodsList.get(0).getQuantity()));
//			}
//			this.getRequest().setAttribute("orderPrice", goodsPrice);
//			this.getRequest().setAttribute("shippingFee", new BigDecimal("0"));
//			this.getRequest().setAttribute("couponDiscount", new BigDecimal("0"));
//			this.getRequest().setAttribute("promotionalDiscount",new BigDecimal("0"));
//			this.getRequest().setAttribute("payableAmount", goodsPrice);
//			this.getRequest().setAttribute("goodsPrice", goodsPrice);
//		}
		this.getRequest().setAttribute("shortOrderId", shortOrderId);
		this.getRequest().setAttribute("deliveryWayList", deliveryWayList);
		
		
//		CLocationCityExample cityexample = new CLocationCityExample();
//		cityexample.createCriteria().andGradeEqualTo(2);
//		cityexample.setOrderByClause(" pinyin asc,name asc ");
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
		this.getRequest().setAttribute("cartType", cartType);
		return "order_add";
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
	public void saveOrder() throws Exception{
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		Long memberId =member.getId();
		//错误消息提示
		ErrorMessage errorMessage = null;
		String receiverId = this.getRequest().getParameter("receiverId");//收货地址id
		String paymentWayId = this.getRequest().getParameter("paymentWayId");//支付方式
		String couponCardId = this.getRequest().getParameter("couponCardId");//优惠券id
		
		String deliveryId = this.getRequest().getParameter("deliveryId");//配送方式
		//秒杀id
		String shortOrderId = this.getRequest().getParameter("shortOrderId"); 
		
		String cartType = this.getRequest().getParameter("cartType"); // 购物车结算商品类型   0 全部   1 非医卡通商品  2 医卡通商品
		if(!StringUtils.hasText(cartType)){
			cartType="0";
		}
		
		boolean flag =true;
		TMemberReceiverLatLon tmemberReceiverLatLon=null;
		String wjarea ="0";//判断是否属于门店配送范围  0 不属于  1 属于
		if(flag&&!StringUtils.hasText(receiverId)){//收货地址
			errorMessage= new ErrorMessage(false,"1","");//收货地址错误
			flag = false;
		}else{
			tmemberReceiverLatLon =tmemberreceiverlatlonmanager.selectByPrimaryKey(Long.valueOf(receiverId.trim()));
			 boolean ysd_ysdj_areaid_flag = false;
		 		if(StringUtils.hasText(tmemberReceiverLatLon.getStoreId())){
		 			ysd_ysdj_areaid_flag= true;
		 		}
			if(tmemberReceiverLatLon!=null&&tmemberReceiverLatLon.getAreaId()!=null&&ysd_ysdj_areaid_flag){//判断是否属于门店配送范围
				wjarea="1";
			}
		}
		//验证余额支付
		CPaymentWay paymentWay= null;
		if(flag&&!StringUtils.hasText(paymentWayId)){//支付方式
			errorMessage= new ErrorMessage(false,"2","");//支付方式
			flag = false;
		}else{
			paymentWay=	cpaymentwaymanager.selectByPrimaryKey(Long.valueOf(paymentWayId.trim()));
		}
		
		if(flag&&!StringUtils.hasText(deliveryId)){//配送方式
			if(!("0".equals(wjarea)&&paymentWay.getPaymentCode().equals(InfoUtil.getInstance().getInfo("config", "payment.hdfk")))){//不是望京 并且是货到付款
				errorMessage= new ErrorMessage(false,"11","");//配送方式
				flag = false;
			}
		}
		// 查询购物车商品
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<OrderGoodCart> goodsList = null;
		if(!StringUtils.hasText(shortOrderId)){
			paramMap.put("memberId", memberId);
			goodsList = this.opensqlmanage.selectForListByMap(paramMap,"t_goods.selectGoodsByCartMemberid");
			if(flag){
				if(goodsList!=null&&goodsList.size()>0){
					for(OrderGoodCart orderGoodCart:goodsList){
						if(orderGoodCart.getIfPremiums()!=null&&orderGoodCart.getIfPremiums().intValue()==0){//不是赠品
							if(orderGoodCart.getStquan().intValue()<0){
								errorMessage= new ErrorMessage(false,"4","");//购物车部分商品库存不足
								flag=false;
								break;
							}
							
							if(orderGoodCart.getPcStatus().intValue()!=1){
								errorMessage= new ErrorMessage(false,"5","");//购物车部分商品已经下架
								flag=false;
								break;
							}
						}
					}
				}else{
					errorMessage= new ErrorMessage(false,"3","");//购物车商品为空
					flag=false;
				}
			}
			//判断 处方药
			if(flag){
				String messageContent="";
				for(OrderGoodCart orderGoodCart:goodsList){
					if(orderGoodCart.getType().intValue()==3){//非购买处方药
						messageContent=messageContent+orderGoodCart.getGoodsName()+";";
						log.info("======>手机端提交订单"+orderGoodCart.getGoodsName()+"为不可加入购物车的处方药！");
						flag=false;
					}
				}
				if(flag){//查询收获地址
					for(OrderGoodCart orderGoodCart:goodsList){
						if(orderGoodCart.getType().intValue()==2&&("0".equals(wjarea)||!paymentWay.getPaymentCode().equals(InfoUtil.getInstance().getInfo("config", "payment.hdfk")))){//非购买处方药
							messageContent=messageContent+orderGoodCart.getGoodsName()+";";
							flag=false;
						}
					}
					if(!flag){
						errorMessage= new ErrorMessage(false,"10",messageContent);//购物车商品为空	
					}
				}else{
					errorMessage= new ErrorMessage(false,"9",messageContent);//购物车商品为空
				}
			}
		}else{
			paramMap.put("shortOrderId", Long.parseLong(shortOrderId));
			paramMap.put("memberId", memberId);
			goodsList = this.opensqlmanage.selectForListByMap(paramMap,"t_goods.selectGoodsByShortOrderId");
			if(goodsList!=null&&goodsList.size()>0){
			}else{
				errorMessage= new ErrorMessage(false,"3","");//购物车商品为空
				flag=false;
			}
		}
		if(flag){
			if(paymentWay!=null){
				if(paymentWay.getPaymentCode().equals(InfoUtil.getInstance().getInfo("config", "payment.yezf"))){//余额支付
					//计算订单相关金额
					Map<String, Object> resultMap =tordermanager.getOrderPrice(cartType,couponCardId, receiverId,String.valueOf(memberId),paymentWayId,shortOrderId,deliveryId);
					//待支付金额
					BigDecimal payableAmount = (BigDecimal) resultMap.get("payableAmount");
					TMemberAccount memberAccount =tmemberaccountmanager.selectByPrimaryKey(memberId);
					if(memberAccount!=null){
						if(memberAccount.getRemainingAmount()==null||(memberAccount.getRemainingAmount()!=null&&memberAccount.getRemainingAmount().compareTo(payableAmount)<0)){
							errorMessage= new ErrorMessage(false,"8","");//余额支付金额不足
							flag=false;	
						}
					}else{
						errorMessage= new ErrorMessage(false,"8","");//余额支付金额不足
						flag=false;	
					}
					
				}
			}else{
				errorMessage= new ErrorMessage(false,"7","");//该支付方式不存在
				flag=false;	
				
			}
		}
		//所有校验已经通过
		if(flag){
			order.setMemberId(memberId);
			long orderId =this.tordermanager.saveOrder(cartType,order, receiverId, paymentWayId, couponCardId, shortOrderId,deliveryId);
			if(orderId!=0){
				errorMessage= new ErrorMessage(true,String.valueOf(orderId),"");//提交成功
			}else{
				errorMessage= new ErrorMessage(false,"6","");//提交失败
			}
		}
		writeObjectToResponse(errorMessage, ContentType.application_json);
	}
	
	/**
	 * 订单提交成功 跳转支付页面
	 * @return
	 * @throws Exception
	 */
	public String orderSumbitSuccess() throws Exception{
		String orderId = this.getRequest().getParameter("orderId");
		if(StringUtils.hasText(orderId)){
			order = this.tordermanager.selectByPrimaryKey(Long.valueOf(orderId.trim()));
			TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
			if(order!=null&&member.getId().longValue()==order.getMemberId().longValue()){
				CPaymentWay paymentWay=this.cpaymentwaymanager.selectByPrimaryKey(order.getPaymentId());
				this.getRequest().setAttribute("paymentWay",paymentWay);
				if(order.getOrderStatus()==OrderEnum.UNDELIVERY.getIndex()){
					return "order_success";
				}else if(order.getOrderStatus()==OrderEnum.UNPAY.getIndex()){
					String hdfk_area =tsysparametermanager.getKeys("paymethod_hdfk_area");//支付方式支持货到付款地区
					String hdfkFlag="0";//是否支持货到付款  0 否 1 是
					if(order.getAreaName().indexOf(hdfk_area)!=-1){
						hdfkFlag="1";
					}
					this.getRequest().setAttribute("hdfkFlag", hdfkFlag);
					TMemberBaseMessageExt memberBaseMessageExt=this.tmemberbasemessageextmanager.selectByPrimaryKey(order.getMemberId());
					String billEmail ="";//账单邮箱
					if(memberBaseMessageExt!=null&&memberBaseMessageExt.getBillEmail()!=null){
						billEmail= memberBaseMessageExt.getBillEmail();
					}
					this.getRequest().setAttribute("billEmail", billEmail);
					
					return "order_payment";
				}
			}else{
				return null;
			}
		}
		return null;
	}
	
	/**
	 * 订单支付
	 * @return
	 * @throws Exception
	 */
	public String orderPay() throws Exception{
		String orderId = this.getRequest().getParameter("orderId");
		String paymentPluginId = this.getRequest().getParameter("paymentPluginId");
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		if(StringUtils.hasText(orderId)){
			order = this.tordermanager.selectByPrimaryKey(Long.valueOf(orderId.trim()));
			if(member.getId().longValue() == order.getMemberId().longValue()){//判断订单是否该用户的订单
				CPaymentWay paymentWay=	cpaymentwaymanager.selectByPrimaryKey(order.getPaymentId());
				String errorMessage = null;
				if(order!=null){
					if(order.getOrderStatus()!=OrderEnum.UNPAY.getIndex()){//未支付
						errorMessage= "该订单已经支付";//该订单已经支付
					}else if(!paymentWay.getPaymentCode().equals(InfoUtil.getInstance().getInfo("config", "payment.xszf"))){//线上支付
						errorMessage= "该订单不支持在线支付";//该订单不支持在线支付
					}else{
						TOrderFlowExample flowExample = new TOrderFlowExample();
						flowExample.createCriteria().andMemberIdEqualTo(order.getMemberId()).andOrderIdEqualTo(order.getId());
						List<TOrderFlow> orderFlowList = this.torderflowmanager.selectByExample(flowExample);
						//订单支付流水表
						TOrderFlow orderFlow = null;
						PaymentPlugin paymentPlugin =paymentpluginmaager.getPaymentPluginById(paymentPluginId);
						if(orderFlowList!=null&&orderFlowList.size()>0){
							orderFlow = orderFlowList.get(0);
							orderFlow.setPaymentPlugin(paymentPluginId);
							orderFlow.setPayMethod(paymentPlugin.getName());
							orderFlow.setHavePay(order.getPayableAmount());
							orderFlow.setOrderId(order.getId());
							this.torderflowmanager.updateByPrimaryKeySelective(orderFlow);
						}else{
							orderFlow =new TOrderFlow();
							orderFlow.setMemberId(order.getMemberId());
							orderFlow.setPaymentStatus(0);//支付状态 0 未支付 1已支付
							orderFlow.setPaymentPlugin(paymentPluginId);
							orderFlow.setPayMethod(paymentPlugin.getName());
							orderFlow.setHavePay(order.getPayableAmount());
							orderFlow.setCreateTime(new Date());
							orderFlow.setOrderId(order.getId());
							this.torderflowmanager.insertSelective(orderFlow);
						}
						
						// 如果使用医卡通,添加商品清单
						if (paymentPluginId.equals("payYktPlugin")) {
							
							Map<String, Object> parMap = new HashMap<String, Object>();
							parMap.put("orderId", order.getId());
							List<Map<String,Object>> orderItemList =this.opensqlmanage.selectForListByMap(parMap, "t_order_item.selectOrderItemGoodsByOrderid");
							this.getRequest().setAttribute("items", orderItemList);
							BigDecimal shouldAmount = new BigDecimal(0);
							for (Map<String,Object> oi : orderItemList) {
								shouldAmount = shouldAmount.add(((BigDecimal)oi.get("price")).multiply(new BigDecimal((Integer)oi.get("quantity"))));
							}
							// 减免金额
							parameterMap.put("costAdjust",order.getPayableAmount().subtract(shouldAmount));
						}
						if (paymentPluginId.equals("payWzfPlugin")) {
							String erWeiMaUrl = getErweiMaUrl( order, orderFlow, this.getRequest(), this.getResponse());
							this.getRequest().setAttribute("erWeiMaUrl", erWeiMaUrl);
							return "wzf";
						}
						this.getRequest().setAttribute("requestUrl", paymentPlugin.getRequestUrl());
						this.getRequest().setAttribute("requestMethod", paymentPlugin.getRequestMethod());
						this.getRequest().setAttribute("requestCharset", paymentPlugin.getRequestCharset());
						parameterMap.putAll(paymentPlugin.getParameterMap(opensqlmanage,order,"订单支付", this.getRequest()));
						this.getRequest().setAttribute("parameterMap", parameterMap);
						if (StringUtils.hasText(paymentPlugin.getRequestCharset())) {
							this.getResponse().setContentType("text/html; charset="+ paymentPlugin.getRequestCharset());
						}
						return "order_payment_submit";
					}
				}else{
					errorMessage= "订单不存在";//订单不存在
				}
			}
			
		}
		
		return null;
	}
	
	/**
	 * 检测订单是否已经支付
	 * @return
	 * @throws Exception
	 */
	public void checkOrderPay() throws Exception{
		String resultFlag ="0";
		String ordersn ="";
		if(StringUtils.hasText(this.getRequest().getParameter("ordersn"))){//订单编号
			ordersn = this.getRequest().getParameter("ordersn");
		}
		if(StringUtils.hasText(ordersn)){
			TOrderExample orderExample = new TOrderExample();
			orderExample.createCriteria().andOrderSnEqualTo(ordersn.trim());
			List<TOrder> orderList =this.tordermanager.selectByExample(orderExample);
			if(orderList!=null&&orderList.size()>0){
				this.order = orderList.get(0);
				if(order.getOrderStatus().intValue()==OrderEnum.UNDELIVERY.getIndex()){
					resultFlag="1";
				}
			}
		}
		writeObjectToResponse(resultFlag, ContentType.text_html);
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
	 * 支付回调方法 跳转支付页面
	 * @return
	 * @throws Exception
	 */
	public String pageReturnUrl() throws Exception{
		String ordersn ="";
		if(StringUtils.hasText(this.getRequest().getParameter("serialNo"))){//医卡通
			ordersn =this.getRequest().getParameter("serialNo");
		}else if(StringUtils.hasText(this.getRequest().getParameter("out_trade_no"))){//支付宝 
			ordersn =this.getRequest().getParameter("out_trade_no");
		}else if(StringUtils.hasText(this.getRequest().getParameter("orderId"))){//快钱
			ordersn =this.getRequest().getParameter("orderId");
		}else if(StringUtils.hasText(this.getRequest().getParameter("order_no"))){//微信支付
			ordersn =this.getRequest().getParameter("order_no");
		}else if(StringUtils.hasText(this.getRequest().getParameter("ordersn"))){//订单编号
			ordersn = this.getRequest().getParameter("ordersn");
		}
		if(StringUtils.hasText(ordersn)){
			TOrderExample orderExample = new TOrderExample();
			orderExample.createCriteria().andOrderSnEqualTo(ordersn.trim());
			List<TOrder> orderList =this.tordermanager.selectByExample(orderExample);
			if(orderList!=null&&orderList.size()>0){
				this.order = orderList.get(0);
				CPaymentWay paymentWay=this.cpaymentwaymanager.selectByPrimaryKey(order.getPaymentId());
				this.getRequest().setAttribute("paymentWay",paymentWay);
				this.getRequest().setAttribute("payDate", new Date());
				return "order_success";
			}
		}
		return null;
	}
	
	/**
	 * 计算订单相关金额
	 * @throws Exception
	 */
	public void computeOrderPrice() throws Exception{
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		getResponse().setContentType("text/html;charset=utf-8");
		PrintWriter write = getResponse().getWriter();
		String couponCardId = this.getRequest().getParameter("couponCardId");//优惠券id
		String receiverId = this.getRequest().getParameter("receiverId");//收货地址id
		String paymentWayId = this.getRequest().getParameter("paymentWayId");//支付方式
		String shortOrderId = this.getRequest().getParameter("shortOrderId");//秒杀id
		String deliveryId = this.getRequest().getParameter("deliveryId");//配送方式
		String cartType = this.getRequest().getParameter("cartType"); // 购物车结算商品类型   0 全部   1 非医卡通商品  2 医卡通商品
		if(!StringUtils.hasText(cartType)){
			cartType="0";
		}
		Map<String, Object> resultMap =tordermanager.getOrderPrice(cartType,couponCardId, receiverId,String.valueOf(member.getId()),paymentWayId,shortOrderId,deliveryId);
		resultMap.remove("goodsList");
		JSONObject json = JSONObject.fromObject(resultMap);
		write.write(json.toString());
		write.close();
	}
	/**
	 * 检验优惠券是否可以使用
	 * @throws Exception
	 */
	public void checkCouponCard() throws Exception{
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		String couponCardNo = this.getRequest().getParameter("couponCardNo");//优惠券卡号
		Map<String,String> resultMap = new HashMap<String,String>();
		String resultFlag="0";
		String name="";
		String couponCardId="";
		String cartType = this.getRequest().getParameter("cartType"); // 购物车结算商品类型   0 全部   1 非医卡通商品  2 医卡通商品
		if(!StringUtils.hasText(cartType)){
			cartType="0";
		}
		try{
		  if(StringUtils.hasText(couponCardNo)){
			  TCouponCardExample cardExample = new TCouponCardExample();
			  cardExample.createCriteria().andCardNoEqualTo(couponCardNo.trim());
			  List cardList =tcouponcardmanager.selectByExample(cardExample);
			  if(cardList!=null&&cardList.size()>0){
				  Map<String, Object> paramMap = new HashMap<String, Object>();
					 paramMap.put("couponCardNo", couponCardNo.trim());
					 paramMap.put("memberId", member.getId());
					 List<Map<String, Object>> memberCouponList= this.opensqlmanage.selectForListByMap(paramMap, "t_coupon_card.selectCouponCardByCardNo");
					 if(memberCouponList!=null&&memberCouponList.size()>0){
						couponCardId = String.valueOf((Long) memberCouponList.get(0).get("id"));
						boolean flag =tordermanager.checkCouponCard(cartType,couponCardId, String.valueOf(member.getId()),memberCouponList);
						if(flag){
							name =(String) memberCouponList.get(0).get("name");
							resultFlag="1";
						}
					 }
			  }else{
				  resultFlag="3";
			  }
			}else{
			 resultFlag="2";
			}
		}catch(Exception e){
			e.printStackTrace();
			resultFlag="-1";
		}
		resultMap.put("resultFlag", resultFlag);
		resultMap.put("name", name);
		resultMap.put("couponCardId", couponCardId);
		writeObjectToResponse(resultMap, ContentType.application_json);
	}
	/**
	 * 取消订单
	 * @throws Exception
	 */
	public void cancelOrder() throws Exception{
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		String orderId = this.getRequest().getParameter("orderId");
		ErrorMessage errorMessage = null;
		try{
			if(StringUtils.hasText(orderId)){
		           order = this.tordermanager.selectByPrimaryKey(Long.valueOf(orderId));
				   if(order!=null){
					   if(order.getMemberId().longValue()==member.getId().longValue()){
						   if(order.getOrderStatus().intValue()==OrderEnum.UNPAY.getIndex()||order.getOrderStatus().intValue()==OrderEnum.UNDELIVERY.getIndex()){
							   tordermanager.cancelOrder(order.getId(), order.getOrderType(), order.getMemberId());
							   errorMessage = new ErrorMessage(true,"取消成功！","");
						   }else{
							   errorMessage = new ErrorMessage(false,"该订单无法取消,请联系客服！",""); 
						   }
					   }else{
						   errorMessage = new ErrorMessage(false,"非法操作！","");
					   }
				   }else{
					   errorMessage = new ErrorMessage(false,"该订单不存在！","");
				   }
				}else{
					errorMessage = new ErrorMessage(false,"该订单不存在！","");
				}
		}catch(Exception e){
			errorMessage = new ErrorMessage(false,"取消失败！","");
			e.printStackTrace();
		}
		
		writeObjectToResponse(errorMessage, ContentType.application_json);
	}
	
	
	/**
	 * 完成订单
	 */
	public void complete() throws Exception {
		// 这里获取登陆的用户id
		TMember member = (TMember) this.getSession().getAttribute("member");

		String id = this.getRequest().getParameter("id");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);

		if (id.matches("[0-9]+")) {
			param.put("memberId", member.getId());
			TOrder order = (TOrder) this.opensqlmanage.selectObjectByObject(param, "t_order.select_member_order_by_id");
			if (order.getOrderStatus() == 2) {
				TOrder updateOrder = new TOrder();
				updateOrder.setId(Long.parseLong(id));
				updateOrder.setOrderStatus(3);
				String publicServiceUrl = tsysparametermanager.getKeys("public_service_url");
				try{
					tordermanager.complete(updateOrder,publicServiceUrl);
					this.writeObjectToResponse(new ErrorMessage(true, "交易已完成", ""), ContentType.application_json);
				}catch(Exception e){
					e.printStackTrace();
					this.writeObjectToResponse(new ErrorMessage(false, "订单有误,请联系客服", ""), ContentType.application_json);
				}
			} else {
				this.writeObjectToResponse(new ErrorMessage(false, "订单有误,请联系客服", ""), ContentType.application_json);
			}
		} else {
			this.writeObjectToResponse(new ErrorMessage(false, "异常操作", ""), ContentType.application_json);
		}

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
		
		String payurl =InfoUtil.getInstance().getInfo("config","pay.payServiceUri");//支付域名
		// 商品描述
		String body = order.getOrderSn();
		String detail = body;
		String total_fee =orderFlow.getHavePay().multiply(new BigDecimal(100)).setScale(0).toString();
		String spbill_create_ip = NetworkUtil.getIpAddress(request);
		String notify_url =  payurl+InfoUtil.getInstance().getInfo("config","wxNotifyUri");//回掉方法
		String trade_type = WXTradeType.NATIVE.toString();//扫码支付
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
		if(resultList!=null&&resultList.size()>0){
			for(Map<String, Object> map:resultList){
				if(map.get("latitude") instanceof JSONNull && map.get("longitude") instanceof JSONNull){
					map.put("latitude","");
					map.put("longitude","");
				}
				if(map.get("location_address") instanceof JSONNull){
					map.put("location_address","");
				}else{
					String location_address =(String)map.get("location_address");
					String address =(String)map.get("address");
					String area = (String)map.get("area");
					if(StringUtils.hasText(location_address)){
						if(!address.startsWith(location_address)&&area.indexOf(location_address)==-1){
							address= location_address+address;
							map.put("address",address);
						}
					}
				}
				if(map.get("store_id") instanceof JSONNull){
					map.put("store_id","");
				}
				if(map.get("area")!=null&&!"".equals(map.get("area"))){
					map.put("areaFirstName", String.valueOf(map.get("area")).split("-")[0]);
				}
			}
		}
 		this.writeObjectToResponse(resultList,ContentType.application_json);
		
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
			if(resultMap.get("latitude") instanceof JSONNull && resultMap.get("longitude") instanceof JSONNull){
				resultMap.put("latitude","");
				resultMap.put("longitude","");
			}
			if(resultMap.get("location_address") instanceof JSONNull){
				resultMap.put("location_address","");
			}else{
				String location_address =(String)resultMap.get("location_address");
				String address =(String)resultMap.get("address");
				String area = (String)resultMap.get("area");
				if(StringUtils.hasText(location_address)){
					if(!(!address.startsWith(location_address)&&area.indexOf(location_address)==-1)){
						resultMap.put("location_address","");
					}
				}
			}
			if(resultMap.get("store_id") instanceof JSONNull){
				resultMap.put("store_id","");
			}
			if (resultMap != null && resultMap.get("area_id") != null) {
				CLocationCity cLocationCity = clocationcitymanager.selectByPrimaryKey(Integer.valueOf(resultMap.get("area_id").toString()));
				if(cLocationCity!=null){
					if(cLocationCity.getGrade().intValue()==3){
						cLocationCity = clocationcitymanager.selectByPrimaryKey(cLocationCity.getParentid());
					}else if(cLocationCity.getGrade().intValue()==4){
						cLocationCity = clocationcitymanager.selectByPrimaryKey(cLocationCity.getParentid());
						cLocationCity = clocationcitymanager.selectByPrimaryKey(cLocationCity.getParentid());
					}
					resultMap.put("citycode", cLocationCity.getCitycode());
				}
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
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String receiverId = "";
		int receiverSize =0;
		String message="";
		
		String publicServiceUrl = tsysparametermanager.getKeys("public_service_url");
		Map<String,String> publicMap = new HashMap<String,String>();
		publicMap.put("member_id", String.valueOf(memberId));
		publicMap.put("mobile", tmemberreceiver.getMobile().trim());
		publicMap.put("receiver", tmemberreceiver.getReceiver().trim());
		publicMap.put("longitude", tmemberreceiver.getLongitude());
		publicMap.put("latitude", tmemberreceiver.getLatitude());
		if(StringUtils.hasText(tmemberreceiver.getLocationAddress())){
			publicMap.put("locationAddress", tmemberreceiver.getLocationAddress().trim());
		}else{
			publicMap.put("locationAddress", this.clocationcitymanager.selectByPrimaryKey(Integer.valueOf(this.getRequest().getParameter("tmemberreceiver_areaId"))).getName());
		}
		publicMap.put("address", tmemberreceiver.getAddress().trim());
		if(StringUtils.hasText(tmemberreceiver.getLongitude())&&StringUtils.hasText(tmemberreceiver.getLatitude())){
			String memberReceiver_adcode = this.getRequest().getParameter("memberReceiver_adcode");
			CLocationCityExample example = new CLocationCityExample();
			example.createCriteria().andCitycodeEqualTo(memberReceiver_adcode).andGradeEqualTo(2);
			List<CLocationCity> cityList =this.clocationcitymanager.selectByExample(example);
			if(cityList!=null&&cityList.size()>0){
				publicMap.put("areaId",String.valueOf(cityList.get(0).getId()));
			}
			publicMap.put("cityName", this.getRequest().getParameter("city_name_set"));
			tmemberreceiver.setArea(this.getRequest().getParameter("city_name_set"));
		}else{
			publicMap.put("areaId",this.getRequest().getParameter("tmemberreceiver_areaId"));
			String cityname =this.clocationcitymanager.selectAreaName(Long.valueOf(this.getRequest().getParameter("tmemberreceiver_areaId")));
			publicMap.put("cityName", cityname);
			tmemberreceiver.setArea(cityname);
			tmemberreceiver.setLocationAddress("");
		}
		publicMap.put("lonlatToAddressFlag", "1");// 是否根据经纬度 反解析地区信息  1表示否   其他表示不用
		publicMap.put("isDefault", this.getRequest().getParameter("tmemberreceiver_is_default"));
		
		TMemberReceiverLatLonExample example = new TMemberReceiverLatLonExample();
		example.createCriteria().andMemberIdEqualTo(memberId);
		List<TMemberReceiverLatLon> receiverLatLonList = tmemberreceiverlatlonmanager.selectByExample(example);
		if (tmemberreceiver.getId() != null) {//修改
			publicMap.put("id", String.valueOf(tmemberreceiver.getId()));
		    String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"updateReceiverAddress");
		    JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
			if (jsonObject != null && jsonObject.get("statusCode") != null && "1".equals(jsonObject.get("statusCode"))) {
				receiverId=String.valueOf(tmemberreceiver.getId().longValue());
			}
		} else {
			receiverSize=receiverLatLonList.size();
			if(!(receiverLatLonList!=null&&receiverLatLonList.size()>9)){
				String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"addReceiverAddress");
				JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
				if (jsonObject != null && jsonObject.get("statusCode") != null && "1".equals(jsonObject.get("statusCode"))) {
					receiverId=String.valueOf(jsonObject.get("id"));
				}
			}else{
				message="收货地址超过10个上线,添加失败";
			}
		}
		if(StringUtils.hasText(receiverId)){
			tmemberreceiver.setId(Long.valueOf(receiverId.trim()));
		}
		resultMap.put("tmemberreceiver", tmemberreceiver);
		resultMap.put("receiverSize", receiverSize);
		resultMap.put("receiverId", receiverId);
		resultMap.put("message", message);
		this.writeObjectToResponse(resultMap,ContentType.application_json);
	}
	
	/**
	 *  ajax 保存或是修改  收货地址
	 * @throws SQLException 
	 */
	public void ajaxSaveOrUpdateReceiverNew() throws Exception{
		TMember member = (TMember) this.getSession().getAttribute("member");
		Long memberId = member.getId();
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String receiverId = "";
		int receiverSize =0;
		String message="";
		
		String publicServiceUrl = tsysparametermanager.getKeys("public_service_url");
		Map<String,String> publicMap = new HashMap<String,String>();
		publicMap.put("member_id", String.valueOf(memberId));
		publicMap.put("mobile", tmemberreceiver.getMobile().trim());
		publicMap.put("receiver", tmemberreceiver.getReceiver().trim());
//		if(StringUtils.hasText(tmemberreceiver.getLocationAddress())){
//			publicMap.put("locationAddress", tmemberreceiver.getLocationAddress().trim());
//		}else{
			publicMap.put("locationAddress", this.clocationcitymanager.selectByPrimaryKey(Integer.valueOf(this.getRequest().getParameter("tmemberreceiver_areaId"))).getName());
//		}
		publicMap.put("address", tmemberreceiver.getAddress().trim());
//		if(StringUtils.hasText(tmemberreceiver.getLongitude())&&StringUtils.hasText(tmemberreceiver.getLatitude())){
//			String memberReceiver_adcode = this.getRequest().getParameter("memberReceiver_adcode");
//			CLocationCityExample example = new CLocationCityExample();
//			example.createCriteria().andCitycodeEqualTo(memberReceiver_adcode).andGradeEqualTo(2);
//			List<CLocationCity> cityList =this.clocationcitymanager.selectByExample(example);
//			if(cityList!=null&&cityList.size()>0){
//				publicMap.put("areaId",String.valueOf(cityList.get(0).getId()));
//			}
//			publicMap.put("cityName", this.getRequest().getParameter("city_name_set"));
//			tmemberreceiver.setArea(this.getRequest().getParameter("city_name_set"));
//		}else{
			publicMap.put("areaId",this.getRequest().getParameter("tmemberreceiver_areaId"));
//			String cityname =this.clocationcitymanager.selectAreaName(Long.valueOf(this.getRequest().getParameter("tmemberreceiver_areaId")));
			publicMap.put("cityName", this.getRequest().getParameter("city_name_set"));
			tmemberreceiver.setArea(this.getRequest().getParameter("city_name_set"));
			tmemberreceiver.setLocationAddress(publicMap.get("locationAddress"));
//		}
		Map<String,String> latlonMap = new HashMap<String,String>();
		latlonMap.put("area", publicMap.get("cityName"));
//		latlonMap.put("locationAddress", publicMap.get("locationAddress"));
		latlonMap.put("address", publicMap.get("address"));
	    String latlonJsonstr =ClientSubmitPublic.getPublicService(latlonMap, publicServiceUrl+"aMapGeoURIService");
		if(StringUtils.hasText(latlonJsonstr)){
			JSONObject latlonObject = JSONObject.fromObject(latlonJsonstr);
			if(latlonObject != null && latlonObject.get("resCode") != null && latlonObject.getInt("resCode")==1){
				String latlon =latlonObject.getJSONObject("result").getString("location");
				 publicMap.put("longitude", latlon.split(",")[0]);
				 publicMap.put("latitude", latlon.split(",")[1]);
			}
		}	
		publicMap.put("lonlatToAddressFlag", "1");// 是否根据经纬度 反解析地区信息  1表示否   其他表示不用
		publicMap.put("isDefault", this.getRequest().getParameter("tmemberreceiver_is_default"));
		if(StringUtils.hasText(this.getRequest().getParameter("tmemberreceiver_is_default"))){
			tmemberreceiver.setIsDefault(Integer.valueOf(this.getRequest().getParameter("tmemberreceiver_is_default")));
		}
		TMemberReceiverLatLonExample example = new TMemberReceiverLatLonExample();
		example.createCriteria().andMemberIdEqualTo(memberId);
		List<TMemberReceiverLatLon> receiverLatLonList = tmemberreceiverlatlonmanager.selectByExample(example);
		if (tmemberreceiver.getId() != null) {//修改
			publicMap.put("id", String.valueOf(tmemberreceiver.getId()));
		    String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"updateReceiverAddress");
		    JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
			if (jsonObject != null && jsonObject.get("statusCode") != null && "1".equals(jsonObject.get("statusCode"))) {
				receiverId=String.valueOf(tmemberreceiver.getId().longValue());
			}
		} else {
			receiverSize=receiverLatLonList.size();
			if(!(receiverLatLonList!=null&&receiverLatLonList.size()>9)){
				String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"addReceiverAddress");
				JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
				if (jsonObject != null && jsonObject.get("statusCode") != null && "1".equals(jsonObject.get("statusCode"))) {
					receiverId=String.valueOf(jsonObject.get("id"));
				}
			}else{
				message="收货地址超过10个上线,添加失败";
			}
		}
		if(StringUtils.hasText(receiverId)){
			tmemberreceiver.setId(Long.valueOf(receiverId.trim()));
		}
		resultMap.put("tmemberreceiver", tmemberreceiver);
		resultMap.put("receiverSize", receiverSize);
		resultMap.put("receiverId", receiverId);
		resultMap.put("message", message);
		this.writeObjectToResponse(resultMap,ContentType.application_json);
	}
	
	/**
	 * 根据城市查询 区域
	 * @throws Exception
	 */
	public void ajaxGetAreaByCity() throws Exception{
		String citycode = this.getRequest().getParameter("citycode");
		if(StringUtils.hasText(citycode)){
			CLocationCityExample cLocationCityExample = new CLocationCityExample();
			cLocationCityExample.createCriteria().andCitycodeEqualTo(citycode);
		    List<CLocationCity> cityAreaList =this.clocationcitymanager.selectByExample(cLocationCityExample);
		    if(cityAreaList!=null&&cityAreaList.size()>0){
		    	cLocationCityExample = new CLocationCityExample();
				cLocationCityExample.createCriteria().andParentidEqualTo(cityAreaList.get(0).getId());
				cityAreaList = clocationcitymanager.selectByExample(cLocationCityExample);
				this.writeObjectToResponse(cityAreaList,ContentType.application_json);
		    }
		}
	}
	/**
	 * 根据城市查询 区域
	 * @throws Exception
	 */
	public void ajaxGetTwoAreaByAreaId() throws Exception{
		String areaId = this.getRequest().getParameter("areaId");
		if(StringUtils.hasText(areaId)){
		    CLocationCityExample cLocationCityExample = new CLocationCityExample();
			cLocationCityExample.createCriteria().andParentidEqualTo(Integer.valueOf(areaId));
			List<CLocationCity> cityAreaList = clocationcitymanager.selectByExample(cLocationCityExample);
			this.writeObjectToResponse(cityAreaList,ContentType.application_json);
		}
	}
	
	/**
	 * 更改订单支付方式为货到付款
	 */
	public void ajaxChangePayWayHdfk() throws Exception{
		String orderId = this.getRequest().getParameter("orderId");
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setFlag(false);
		errorMessage.setMessage("0");
		errorMessage.setMessageContent("服务器异常操作失败!");
		if(StringUtils.hasText(orderId)){
			order = this.tordermanager.selectByPrimaryKey(Long.valueOf(orderId.trim()));
			TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
			if(order!=null&&member.getId().longValue()==order.getMemberId().longValue()){
				if(order.getOrderStatus().intValue()==0){//待支付
					boolean flag =this.tordermanager.changePayWayHdfk(order,4L);
					if(flag){
						errorMessage.setFlag(true);
						errorMessage.setMessage("1");
					}
				}else{
					errorMessage.setMessage("2");//订单不再未支付环节
				}
			}
		}
		this.writeObjectToResponse(errorMessage, ContentType.application_json);
	}
	
	
	/**
	 * 支付成功 payment 调用接口
	 * @throws SQLException 
	 */
	public void writeStayMoneyByPayment() throws Exception {
		String orderSn = this.getRequest().getParameter("orderSn");
		InterfaceResult interfaceResult = new InterfaceResult();
		if (orderSn != null && !"".equals(orderSn)) {
			TOrderExample _tExample = new TOrderExample();
			_tExample.createCriteria().andOrderSnEqualTo(orderSn);
			List<TOrder> _orderList = tordermanager.selectByExample(_tExample);
			if (_orderList != null && _orderList.size() == 1) {
				order = _orderList.get(0);
				if (order != null && order.getPaymentId() != null && order.getPaymentId() > 0L) {
					CPaymentWay cPaymentWay = cpaymentwaymanager.selectByPrimaryKey(order.getPaymentId());
					if (cPaymentWay != null && cPaymentWay.getPaymentCode() != null&& "xszf".equals(cPaymentWay.getPaymentCode())) {
						String publicServiceUrl = tsysparametermanager.getKeys("public_service_url");
						Map<String,String> publicMap = new HashMap<String,String>();
						publicMap.put("orderId", String.valueOf(order.getId()));
						String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"leaderStayMoneyURLService");
						if(JSONObject.fromObject(resultJsonstr).get("statsCode").equals("1")){
							interfaceResult.setStatus(1);
							interfaceResult.setMesssage("写入成功");
							this.writeObjectToResponse(interfaceResult, ContentType.application_json);
						
						}else{
							log.equals("orderId:"+String.valueOf(order.getId())+"计算佣金失败,失败原因:"+JSONObject.fromObject(resultJsonstr).get("message"));
							interfaceResult.setStatus(0);
							interfaceResult.setMesssage("返现异常");
							this.writeObjectToResponse(interfaceResult, ContentType.application_json);
						}
					} else {
						interfaceResult.setStatus(0);
						interfaceResult.setMesssage("非支付订单");
						this.writeObjectToResponse(interfaceResult, ContentType.application_json);
					}
				} else {
					interfaceResult.setStatus(0);
					interfaceResult.setMesssage("非支付订单");
					this.writeObjectToResponse(interfaceResult, ContentType.application_json);
				}
			} else {
				interfaceResult.setStatus(0);
				interfaceResult.setMesssage("未查询到该订单");
				this.writeObjectToResponse(interfaceResult, ContentType.application_json);
			}
		} else {
			interfaceResult.setStatus(0);
			interfaceResult.setMesssage("订单编号为空");
			this.writeObjectToResponse(interfaceResult, ContentType.application_json);
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
	
	
	public Object getModel() {
		return null;
	}

	public void setModel(Object o) {
	}

	public TOrderManager getTordermanager() {
		return tordermanager;
	}

	public void setTordermanager(TOrderManager tordermanager) {
		this.tordermanager = tordermanager;
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

	public TMemberAccountManager getTmemberaccountmanager() {
		return tmemberaccountmanager;
	}


	public TCouponManager getTcouponmanager() {
		return tcouponmanager;
	}

	public void setTcouponmanager(TCouponManager tcouponmanager) {
		this.tcouponmanager = tcouponmanager;
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

	public TOrderItemManager getTorderitemmanager() {
		return torderitemmanager;
	}

	public void setTorderitemmanager(TOrderItemManager torderitemmanager) {
		this.torderitemmanager = torderitemmanager;
	}

	public void setTmemberaccountmanager(TMemberAccountManager tmemberaccountmanager) {
		this.tmemberaccountmanager = tmemberaccountmanager;
	}

	public TOrderFlowManager getTorderflowmanager() {
		return torderflowmanager;
	}

	public void setTorderflowmanager(TOrderFlowManager torderflowmanager) {
		this.torderflowmanager = torderflowmanager;
	}

	public PaymentPluginMaager getPaymentpluginmaager() {
		return paymentpluginmaager;
	}

	public void setPaymentpluginmaager(PaymentPluginMaager paymentpluginmaager) {
		this.paymentpluginmaager = paymentpluginmaager;
	}

	public TCouponCardManager getTcouponcardmanager() {
		return tcouponcardmanager;
	}

	public void setTcouponcardmanager(TCouponCardManager tcouponcardmanager) {
		this.tcouponcardmanager = tcouponcardmanager;
	}

	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}

	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}

	public MessageSender getTopicMessageSender() {
		return topicMessageSender;
	}

	public void setTopicMessageSender(MessageSender topicMessageSender) {
		this.topicMessageSender = topicMessageSender;
	}

	public TLeaderStayMoneyManager getTleaderstaymoneymanager() {
		return tleaderstaymoneymanager;
	}

	public void setTleaderstaymoneymanager(TLeaderStayMoneyManager tleaderstaymoneymanager) {
		this.tleaderstaymoneymanager = tleaderstaymoneymanager;
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

	public TMemberBaseMessageExtManager getTmemberbasemessageextmanager() {
		return tmemberbasemessageextmanager;
	}

	public void setTmemberbasemessageextmanager(
			TMemberBaseMessageExtManager tmemberbasemessageextmanager) {
		this.tmemberbasemessageextmanager = tmemberbasemessageextmanager;
	}

	/**
	 * 根据城市查询 区域
	 * @throws Exception
	 */
	public void ajaxGetFirstAreas() throws Exception{
		CLocationCityExample cLocationCityExample = new CLocationCityExample();
		cLocationCityExample.createCriteria().andParentidEqualTo(-1);
	    List<CLocationCity> cityAreaList =this.clocationcitymanager.selectByExample(cLocationCityExample);
	    if(cityAreaList!=null&&cityAreaList.size()>0){
//	    	cLocationCityExample = new CLocationCityExample();
//			cLocationCityExample.createCriteria().andParentidEqualTo(cityAreaList.get(0).getId());
//			cityAreaList = clocationcitymanager.selectByExample(cLocationCityExample);
			this.writeObjectToResponse(cityAreaList,ContentType.application_json);
	    }
	}

	
	/*********Marlon***********/
	public OrderServiceDubboApi getOrderservicedubboapi() {
		return orderservicedubboapi;
	}

	public void setOrderservicedubboapi(
			OrderServiceDubboApi orderservicedubboapi) {
		this.orderservicedubboapi = orderservicedubboapi;
	}

}
