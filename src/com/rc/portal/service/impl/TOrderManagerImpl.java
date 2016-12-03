package com.rc.portal.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.util.StringUtils;

import com.rc.commons.util.InfoUtil;
import com.rc.dst.client.util.ClientSubmitPublic;
import com.rc.portal.dao.CDeliveryWayDAO;
import com.rc.portal.dao.CPaymentWayDAO;
import com.rc.portal.dao.IDaoManager;
import com.rc.portal.dao.OpenSqlDAO;
import com.rc.portal.dao.TCartDAO;
import com.rc.portal.dao.TCartItemDAO;
import com.rc.portal.dao.TCouponCardDAO;
import com.rc.portal.dao.TCouponDAO;
import com.rc.portal.dao.TGoodsBrokerageDAO;
import com.rc.portal.dao.TGoodsDAO;
import com.rc.portal.dao.TGoodsPriceDAO;
import com.rc.portal.dao.TMemberBalanceDAO;
import com.rc.portal.dao.TMemberIntegralDAO;
import com.rc.portal.dao.TMemberLeaderDAO;
import com.rc.portal.dao.TMemberReceiverLatLonDAO;
import com.rc.portal.dao.TOrderDAO;
import com.rc.portal.dao.TOrderFlowDAO;
import com.rc.portal.dao.TOrderItemDAO;
import com.rc.portal.dao.TOrderLeaderDAO;
import com.rc.portal.dao.TPromotionDAO;
import com.rc.portal.dao.TReturnDAO;
import com.rc.portal.dao.TReturnItemDAO;
import com.rc.portal.dao.TShortOrderDAO;
import com.rc.portal.dao.TSysParameterDAO;
import com.rc.portal.jms.MessageSender;
import com.rc.portal.service.TOrderManager;
import com.rc.portal.util.OrderEnum;
import com.rc.portal.vo.CDeliveryWay;
import com.rc.portal.vo.CPaymentWay;
import com.rc.portal.vo.TCart;
import com.rc.portal.vo.TCartExample;
import com.rc.portal.vo.TCartItemExample;
import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TCouponCard;
import com.rc.portal.vo.TCouponRelevance;
import com.rc.portal.vo.TGoods;
import com.rc.portal.vo.TGoodsBrokerage;
import com.rc.portal.vo.TGoodsBrokerageExample;
import com.rc.portal.vo.TGoodsPrice;
import com.rc.portal.vo.TGoodsPriceExample;
import com.rc.portal.vo.TMemberIntegral;
import com.rc.portal.vo.TMemberReceiverLatLon;
import com.rc.portal.vo.TOrder;
import com.rc.portal.vo.TOrderExample;
import com.rc.portal.vo.TOrderFlowExample;
import com.rc.portal.vo.TOrderItem;
import com.rc.portal.vo.TOrderItemExample;
import com.rc.portal.vo.TPromotion;
import com.rc.portal.vo.TReturn;
import com.rc.portal.vo.TReturnItem;
import com.rc.portal.vo.TShortOrder;
import com.rc.portal.vo.TShortOrderExample;
import com.rc.portal.webapp.model.OrderGoodCart;
import com.rc.portal.webapp.model.cart.CartGift;
import com.rc.portal.webapp.model.cart.CartParam;

public class TOrderManagerImpl implements TOrderManager {

	private TOrderDAO torderdao;

	private OpenSqlDAO opensqldao;

	private TPromotionDAO tpromotiondao;
	
	private TMemberReceiverLatLonDAO tmemberreceiverlatlondao;
	
	 private CPaymentWayDAO cpaymentwaydao;
	 
	 private TOrderItemDAO torderitemdao;
	 
	 private TCartDAO tcartdao;
	 
	 private TCartItemDAO tcartitemdao;
	 
	 private TMemberBalanceDAO tmemberbalancedao;
	 
	 private TOrderFlowDAO torderflowdao;
	 
	 private IDaoManager cartdao;
	 
	 private TMemberLeaderDAO tmemberleaderdao;
	 
	 private TMemberIntegralDAO tmemberintegraldao;
	 
	 private TShortOrderDAO tshortorderdao;
	 private TReturnDAO treturndao;
	 private TReturnItemDAO treturnitemdao;
	 private TGoodsDAO tgoodsdao;
	 
	 private TCouponCardDAO tcouponcarddao;
	 
	 private TSysParameterDAO tsysparameterdao;
	 
	 private TGoodsBrokerageDAO tgoodsbrokeragedao;

	 
	 private TOrderLeaderDAO torderleaderdao;
	 
	 private MessageSender topicMessageSender;
	 
	 private CDeliveryWayDAO cdeliverywaydao;
	 
	 private TGoodsPriceDAO tgoodspricedao;
	 
	 private TCouponDAO tcoupondao;
	 
	public TOrderManagerImpl() {
		super();
	}

	public void setTorderdao(TOrderDAO torderdao) {
		this.torderdao = torderdao;
	}

	public TOrderDAO getTorderdao() {
		return this.torderdao;
	}

	public int countByExample(TOrderExample example) throws SQLException {
		return torderdao.countByExample(example);
	}

	public int deleteByExample(TOrderExample example) throws SQLException {
		return torderdao.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Long id) throws SQLException {
		return torderdao.deleteByPrimaryKey(id);
	}

	public Long insert(TOrder record) throws SQLException {
		return torderdao.insert(record);
	}

	public Long insertSelective(TOrder record) throws SQLException {
		return torderdao.insertSelective(record);
	}

	public List selectByExample(TOrderExample example) throws SQLException {
		return torderdao.selectByExample(example);
	}

	public TOrder selectByPrimaryKey(Long id) throws SQLException {
		return torderdao.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(TOrder record, TOrderExample example)
			throws SQLException {
		return torderdao.updateByExampleSelective(record, example);
	}

	public int updateByExample(TOrder record, TOrderExample example)
			throws SQLException {
		return torderdao.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(TOrder record) throws SQLException {
		return torderdao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(TOrder record) throws SQLException {
		return torderdao.updateByPrimaryKey(record);
	}

	public OpenSqlDAO getOpensqldao() {
		return opensqldao;
	}

	public void setOpensqldao(OpenSqlDAO opensqldao) {
		this.opensqldao = opensqldao;
	}
	
    public TMemberIntegralDAO getTmemberintegraldao() {
		return tmemberintegraldao;
	}

	public void setTmemberintegraldao(TMemberIntegralDAO tmemberintegraldao) {
		this.tmemberintegraldao = tmemberintegraldao;
	}

	public TOrderLeaderDAO getTorderleaderdao() {
		return torderleaderdao;
	}

	public void setTorderleaderdao(TOrderLeaderDAO torderleaderdao) {
		this.torderleaderdao = torderleaderdao;
	}

	public MessageSender getTopicMessageSender() {
		return topicMessageSender;
	}

	public void setTopicMessageSender(MessageSender topicMessageSender) {
		this.topicMessageSender = topicMessageSender;
	}

	/**
     * 计算订单相关金额
     * @param goodsList  商品list
     * @param couponCardId 优惠券id
     * @param receiverId   收货地址id
     * @param memberId   用户id
     * @param paymentWayId  支付方式
     * @param shortOrderId  秒杀id
     * @return cartType  购物车结算商品类型   0 全部   1 非医卡通商品  2 医卡通商品
     * @throws SQLException
     */
	public Map<String, Object> getOrderPrice(String cartType,String couponCardId, String receiverId,String memberId,String paymentWayId,String shortOrderId,String deliveryId) throws Exception {
		 Map<String,Object> resultMap = new HashMap<String,Object>();
         try{
        	 BigDecimal goodsPrice = new BigDecimal("0");//商品金额
        	 BigDecimal shippingFee = new BigDecimal("0");//运费
        	 BigDecimal couponDiscount = new BigDecimal("0");//优惠券优惠金额
        	 BigDecimal promotionalDiscount = new BigDecimal("0");//促销折扣金额
        	 Map<String, Object> paramMap = new HashMap<String, Object>();
        	 List<OrderGoodCart> goodsList = new ArrayList<OrderGoodCart>();
        	 if(!StringUtils.hasText(shortOrderId)){
					paramMap.put("memberId", memberId);
					// 这里需要调用建龙计算优惠金额
					CartParam cartParam = new CartParam();
					cartParam.setUserId(Long.parseLong(memberId));
					cartParam.setIslogin(true);
					if("1".equals(cartType)){//非医卡通商品
						paramMap.put("is_ykt_good", 0);
						cartParam.setCartType("0");
					}else if("2".equals(cartType)){//医卡通商品
						paramMap.put("is_ykt_good", 1);
						cartParam.setCartType("1");
					}
					goodsList = this.opensqldao.selectForListByMap(paramMap,"t_goods.selectGoodsByCartMemberid");
					
					Map cartMap = cartdao.accounts(cartParam);
					promotionalDiscount = (BigDecimal) cartMap.get("youhui");
					List<CartGift> giftList = (List<CartGift>) cartMap.get("gift");
					if(giftList!=null&&giftList.size()>0){
						TGoods goods = null;
						OrderGoodCart goodCart = null;
//						TGoodsPriceExample priceExample= null;
						for(CartGift cartGift:giftList){
							goods = this.tgoodsdao.selectByPrimaryKey(cartGift.getGoodsid());
							goodCart = new OrderGoodCart();
							goodCart.setId(goods.getId());
							goodCart.setPcPrice(new BigDecimal("0"));
							goodCart.setGoodsName(goods.getGoodsName());
							goodCart.setStock(goods.getStock());
							goodCart.setQuantity(cartGift.getCnt());
							goodCart.setAbbreviationPicture(goods.getAbbreviationPicture());
							goodCart.setSpec(goods.getSpec());
							goodCart.setIfPremiums(1);
							goodCart.setStock(goods.getStock());
//							priceExample = new TGoodsPriceExample();
//							priceExample.createCriteria().andGoodsIdEqualTo(goods.getId()).andPriceTypeEqualTo("pc").andPlatformTypeEqualTo("111yao");
//							List<TGoodsPrice> priceList =tgoodspricedao.selectByExample(priceExample);
//							if(priceList!=null&&priceList.size()>0){
//								goodCart.setPcStatus(priceList.get(0).getStatus());
//							}else{
//								goodCart.setPcStatus(2);
//							}
							
							goodCart.setWeight(goods.getWeight());
							goodsList.add(goodCart);
						}
					}
					
        		 }else{
        			 paramMap.put("shortOrderId", Long.parseLong(shortOrderId));
        			 paramMap.put("memberId", memberId);
        		    goodsList = this.opensqldao.selectForListByMap(paramMap,"t_goods.selectGoodsByShortOrderId");
        		 }
        	 BigDecimal weight = new BigDecimal("0");
        	 boolean feeflag=false; //是否免运费
        	 if(goodsList!=null&&goodsList.size()>0){//计算商品总金额  总重量
        		for(OrderGoodCart orderGoodCart:goodsList){
        			if(orderGoodCart.getIfPremiums()==0){
        				if (orderGoodCart.getPcPrice() != null) {
            				goodsPrice = goodsPrice.add(orderGoodCart.getPcPrice().multiply(new BigDecimal(orderGoodCart.getQuantity())));
    					}
        			}
        			if(orderGoodCart.getWeight() != null){
        				weight =weight.add(orderGoodCart.getWeight().multiply(new BigDecimal(orderGoodCart.getQuantity())));
        			}
        		}
        	 }
        	 //计算优惠券 优惠金额
        	 if(StringUtils.hasText(couponCardId)){
        		 //查询该用户所能使用的优惠券
        		 paramMap.clear();
 				 paramMap.put("couponCardId", Long.valueOf(couponCardId.trim()));
 				 paramMap.put("memberId", Long.valueOf(memberId.trim()));
        		 List<Map<String, Object>> memberCouponList= this.opensqldao.selectForListByMap(paramMap, "t_coupon_card.selectCouponCardByCardNo");
        		 List<Map<String, Object>> memberCouponUserList =getCouponByGoods(cartType,memberCouponList,String.valueOf(memberId));
        		 for(Map<String, Object> couponMap : memberCouponUserList){
        			 if(couponMap.get("id")!=null&&Long.valueOf(couponCardId.trim()).longValue()==((Long)couponMap.get("id")).longValue()){
        				 if(String.valueOf(couponMap.get("scope")).equals("1")){//免运费
        					 feeflag=true;
        				 }else{
        					 if(couponMap.get("dis_price")!=null){
            					 couponDiscount = (BigDecimal)couponMap.get("dis_price");
            				 }
        				 }
        			 }
        		 }
        	 }
        	 String ysdjFlag ="0";// 0否   1 是
        	 CDeliveryWay deliveryWay = new CDeliveryWay();
        	 String deliveryCode="ptkd";//普通快递
             if(StringUtils.hasText(receiverId)){//收获地址
         		 TMemberReceiverLatLon memberReceiverLatLon = this.tmemberreceiverlatlondao.selectByPrimaryKey(Long.valueOf(receiverId.trim()));
         		 
         		boolean ysd_ysdj_areaid_flag = false;
		 		if(StringUtils.hasText(memberReceiverLatLon.getStoreId())){
		 			ysd_ysdj_areaid_flag = true;
		 		}
         		 
         		 if(ysd_ysdj_areaid_flag){
         			if (StringUtils.hasText(deliveryId)) {// 配送方式id
    					deliveryWay = this.cdeliverywaydao.selectByPrimaryKey(Long
    							.valueOf(deliveryId.trim()));
    					if (deliveryWay.getDeliveryCode().equals("ysdj")) {// 药师到家
    						ysdjFlag = "1";
    						shippingFee = deliveryWay.calculateFreight(weight);
    					}
    				} 
         		 }
         		if(ysdjFlag.equals("0")){
         			String hdfk_area =tsysparameterdao.getKeys("paymethod_hdfk_area");//支付方式支持货到付款地区
         			 if(ysd_ysdj_areaid_flag){//判断望京   是望京
             			 deliveryCode="ysd";//药士达
             		 }else if(memberReceiverLatLon.getArea().indexOf(hdfk_area)!=-1){//判断是否是北京   
             			    if(!StringUtils.hasText(paymentWayId)){
             			    	paymentWayId ="1";
             			    }
             			    CPaymentWay paymentWay=	cpaymentwaydao.selectByPrimaryKey(Long.valueOf(paymentWayId.trim()));
    	         				if(paymentWay.getPaymentCode().equals("hdfk")){//货到付款
    	         					deliveryCode="hdfk";
    	         		}
             		 }
         		}
         	 }
        	 if(ysdjFlag.equals("0")){//不是 药师到家配送方式
        		//计算全场免运费金额
            	 if(!feeflag){
    			    	String free_shippingfee_price =tsysparameterdao.getKeys("free_shippingfee_price");
    			    	if(StringUtils.hasText(free_shippingfee_price)){
    			    		if(goodsPrice.compareTo(new BigDecimal(free_shippingfee_price.trim()))>=0){
    			    			feeflag=true;
    			    		}
    			    	}
    			    }
            	    paramMap.clear();
	 				paramMap.put("deliveryCode", deliveryCode);
	 			    List<CDeliveryWay> deliveryList =this.opensqldao.selectForListByMap(paramMap, "c_delivery_way.selectDeliveryWayByMap");
	 			    if(deliveryList!=null&&deliveryList.size()>0){
	 			    	deliveryWay = deliveryList.get(0);
	 			    	shippingFee=deliveryWay.calculateFreight(weight);
	 			    }
	            	if(feeflag){//是否免运费
	            		  shippingFee = new BigDecimal("0");
	            	 }
        	 }
        	//订单金额
        	 BigDecimal goodsPriceNoShippingFee = goodsPrice.subtract(couponDiscount).subtract(promotionalDiscount);
        	 if(goodsPriceNoShippingFee.compareTo(new BigDecimal("0"))<=0){
        		 goodsPriceNoShippingFee=new BigDecimal("0");
        		 couponDiscount = goodsPrice.subtract(promotionalDiscount);
        	 }
        	 BigDecimal orderPrice = goodsPriceNoShippingFee.add(shippingFee);
        	 if(orderPrice.compareTo(new BigDecimal("0"))<=0){
        		 orderPrice = new BigDecimal("0");
        	 }
        	 resultMap.put("goodsPrice", goodsPrice);
        	 resultMap.put("orderPrice", orderPrice.setScale(2,   BigDecimal.ROUND_HALF_UP));
        	 resultMap.put("shippingFee", shippingFee);
        	 resultMap.put("couponDiscount", couponDiscount);
        	 resultMap.put("promotionalDiscount",promotionalDiscount);
        	 resultMap.put("payableAmount", orderPrice.setScale(2,   BigDecimal.ROUND_HALF_UP));
        	 resultMap.put("goodsList", goodsList);
        	 resultMap.put("deliveryWay", deliveryWay);
         }catch(Exception e){
        	 e.printStackTrace();
        	 throw new Exception(e.getMessage());
         }
		return resultMap;
	}
	
	
	/**
	 * 校验指定的优惠券是否可以使用
	 * @param couponCardId
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	public boolean checkCouponCard(String cartType,String couponCardId,String memberId,List<Map<String, Object>> memberCouponList) throws Exception{
		boolean flag = false;
	    try{
	     if(StringUtils.hasText(couponCardId)&&StringUtils.hasText(memberId)){
			 List<Map<String, Object>> memberCouponUserList =getCouponByGoods(cartType,memberCouponList,String.valueOf(memberId));
			 for(Map<String, Object> couponMap : memberCouponUserList){
				 if(couponMap.get("id")!=null&&Long.parseLong(couponCardId.trim())==((Long)couponMap.get("id")).longValue()){
					 flag = true;
				 }
			 }
	     }
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    return flag;
	}
	

	/**
	 * 根据购物车商品计算优惠券
	 *  cartType  购物车结算商品类型   0 全部   1 非医卡通商品  2 医卡通商品
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getCouponByGoods(String cartType,List<Map<String, Object>> memberCouponList,String memberId)
			throws SQLException {
		// 可以使用的优惠券
		List<Map<String, Object>> couponList = new ArrayList<Map<String, Object>>();
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("memberId", Long.parseLong(memberId));
			paramMap.put("ifPremiums", 0);
			if("1".equals(cartType)){//非医卡通商品
				paramMap.put("is_ykt_good", 0);
			}else if("2".equals(cartType)){//医卡通商品
				paramMap.put("is_ykt_good", 1);
			}
			List<OrderGoodCart> goodsList = this.opensqldao.selectForListByMap(paramMap,"t_goods.selectGoodsByCartMemberid");
			if (goodsList != null && goodsList.size() > 0) {
				Map<String, List<OrderGoodCart>> promotionGoodsMap = new HashMap<String, List<OrderGoodCart>>();
				List<OrderGoodCart> porList = null;
				// 把商品按照促销划分一下 按照促销放到 map里面
				for (OrderGoodCart orderGoodCart : goodsList) {
					if (orderGoodCart.getPromotionId()!= null) {
						if (promotionGoodsMap.get(String.valueOf(orderGoodCart.getPromotionId())) != null) {
							porList = promotionGoodsMap.get(String.valueOf(orderGoodCart.getPromotionId()));
						} else {
							porList = new ArrayList<OrderGoodCart>();
						}
						porList.add(orderGoodCart);
						promotionGoodsMap.put(String.valueOf(orderGoodCart.getPromotionId()), porList);
					}
				}
				// 调用建龙方法计算购物车商品 参与的促销活动
				for (String promotionId : promotionGoodsMap.keySet()) {
					// 查询促销
					TPromotion promotion = tpromotiondao
							.selectByPrimaryKey(Long.parseLong(promotionId));
					if (promotion!=null&&promotion.getIsTiket() != null
							&& promotion.getIsTiket().intValue() == 2) {// 不能使用优惠券
						// 这里需要根据 建龙的方法判断 该促销的商品是否 满足促销 如果满足促销 则移除 该促销的使所有商品
						porList = promotionGoodsMap.get(promotionId);
						if (porList != null) {
							goodsList.removeAll(porList);
						}
					}
				}

				// 用户拥有的优惠券
				if(memberCouponList==null){
					memberCouponList = this.opensqldao.selectForListByMap(paramMap,"t_coupon_card.selectCouponCardByMemberid");
				}
				if (memberCouponList != null && memberCouponList.size() > 0&&goodsList!=null&&goodsList.size()>0) {
					String goodsIds = "";// 商品ids
					String brandIds = "";// 品牌ids
					for (OrderGoodCart orderGoodCart :goodsList) {
						if (orderGoodCart.getId()!= null) {
							goodsIds = goodsIds+ String.valueOf(orderGoodCart.getId()) + ",";
						}
						if (orderGoodCart.getBrandId()!= null) {
							brandIds = brandIds+ String.valueOf(orderGoodCart.getBrandId())+ ",";
						}
					}
					if(StringUtils.hasText(goodsIds)){
						goodsIds = goodsIds.substring(0,goodsIds.length() - 1);
					}
					if(StringUtils.hasText(brandIds)){
						brandIds = brandIds.substring(0,brandIds.length() - 1);
					}
					BigDecimal goodsumPrice = null;
					boolean couponGoodsFlag = false;
					for (Map<String, Object> couponMap : memberCouponList) {
						couponGoodsFlag = false;
						if (couponMap.get("scope") != null) {
							if (String.valueOf(couponMap.get("scope")).equals("1")) {// 免运费
								couponGoodsFlag = true;
								couponList.add(couponMap);
							} else {
								goodsumPrice = new BigDecimal("0");
								if (String.valueOf(couponMap.get("scope")).equals("0")) {// 全场
									for (OrderGoodCart orderGoodCart :goodsList) {
										if (orderGoodCart.getPcPrice()!= null&&orderGoodCart.getIfPremiums()==0) {
											couponGoodsFlag = true;
											goodsumPrice = goodsumPrice.add(orderGoodCart.getPcPrice().multiply(new BigDecimal(orderGoodCart.getQuantity())));
										}
									}
								} else if (String.valueOf(couponMap.get("scope")).equals("2")) {// 分类
									paramMap.clear();
									paramMap.put("couponId",couponMap.get("couponid"));
									List<TCouponRelevance> couponRelevanceList = this.opensqldao
											.selectForListByMap(paramMap,"t_coupon_relevance.selectCouponRelevanceByMap");
									if (couponRelevanceList != null
											&& couponRelevanceList.size() > 0) {
										for (TCouponRelevance couponRelevance : couponRelevanceList) {
											for (OrderGoodCart orderGoodCart :goodsList) {
												if (orderGoodCart.getCategoryid() != null&& couponRelevance.getRelevanceId().longValue() == orderGoodCart.getCategoryid().longValue()) {
													if (orderGoodCart.getPcPrice() != null&&orderGoodCart.getIfPremiums()==0) {
														couponGoodsFlag = true;
														goodsumPrice = goodsumPrice.add(orderGoodCart.getPcPrice().multiply(new BigDecimal(orderGoodCart.getQuantity())));
													}
												} 
//												else if (orderGoodCart.getCategoryid() != null) {
//													paramMap.clear();
//													paramMap.put("id",couponRelevance.getRelevanceId());
//													List<TCategory> categoryList = this.opensqldao
//															.selectForListByMap(paramMap,"t_category.selectCategoryByMap");
//													if (categoryList != null&& categoryList.size() > 0) {
//														if (categoryList.get(0).getAllParentId().indexOf(String.valueOf(orderGoodCart.getCategoryid())) > 0) {
//															if (orderGoodCart.getPcPrice() != null&&orderGoodCart.getIfPremiums()==0) {
//																couponGoodsFlag = true;
//																goodsumPrice = goodsumPrice.add(orderGoodCart.getPcPrice().multiply(new BigDecimal(orderGoodCart.getQuantity())));
//															}
//														}
//													}
//												}
											}
										}
									}

								} else if (String.valueOf(couponMap.get("scope")).equals("3")) {// 品牌
									if (StringUtils.hasText(brandIds)) {
										paramMap.clear();
										paramMap.put("couponId",couponMap.get("couponid"));
//										paramMap.put("relevanceId", brandIds);
										List<TCouponRelevance> couponRelevanceList = this.opensqldao
												.selectForListByMap(paramMap,"t_coupon_relevance.selectCouponRelevanceByMap");
										if (couponRelevanceList != null
												&& couponRelevanceList.size() > 0) {
											for (TCouponRelevance couponRelevance : couponRelevanceList) {
												for (OrderGoodCart orderGoodCart : goodsList) {
													if (orderGoodCart.getBrandId()!= null
															&& orderGoodCart.getBrandId().longValue() == couponRelevance.getRelevanceId().longValue()) {
														if (orderGoodCart.getPcPrice() != null&&orderGoodCart.getIfPremiums()==0) {
															couponGoodsFlag = true;
															goodsumPrice = goodsumPrice.add(orderGoodCart.getPcPrice().multiply(new BigDecimal(orderGoodCart.getQuantity())));
														}
													}
												}
											}
										}
									}
								} else if (String.valueOf(couponMap.get("scope")).equals("4")) {// 商品
									if (StringUtils.hasText(goodsIds)) {
										paramMap.clear();
										paramMap.put("couponId",couponMap.get("couponid"));
//										paramMap.put("relevanceId", goodsIds);
										List<TCouponRelevance> couponRelevanceList = this.opensqldao
												.selectForListByMap(paramMap,"t_coupon_relevance.selectCouponRelevanceByMap");
										if (couponRelevanceList != null
												&& couponRelevanceList.size() > 0) {
											for (TCouponRelevance couponRelevance : couponRelevanceList) {
												for (OrderGoodCart orderGoodCart :goodsList) {
													if (orderGoodCart.getId()!= null
															&& orderGoodCart.getId().longValue() == couponRelevance.getRelevanceId().longValue()) {
														if (orderGoodCart.getPcPrice()  != null&&orderGoodCart.getIfPremiums()==0) {
															couponGoodsFlag = true;
															goodsumPrice = goodsumPrice.add(orderGoodCart.getPcPrice().multiply(new BigDecimal(orderGoodCart.getQuantity())));
														}
													}
												}
											}
										}
									}
								}
								if (couponGoodsFlag&&checkCoupon(couponMap, goodsumPrice)) {
									couponList.add(couponMap);
								}
							}
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return couponList;
	}

	/**
	 * 判断优惠券是否能用
	 * 
	 * @param couponMap
	 * @param goodsumPrice
	 * @return
	 */
	public boolean checkCoupon(Map<String, Object> couponMap,
			BigDecimal goodsumPrice)  {
		boolean flag = false;
		if (couponMap.get("start_price") != null
				&& couponMap.get("end_price") != null) {
			if (goodsumPrice.compareTo((BigDecimal) couponMap.get("start_price")) >= 0&& goodsumPrice.compareTo((BigDecimal) couponMap.get("end_price")) <= 0) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 保存订单信息
	 */
	public long saveOrder(String cartType,TOrder order, String receiverId, String paymentWayId,
			String couponCardId, String shortOrderId,String deliveryId)
			throws Exception {
		long orderId =0;
		try{
			//计算各种运费
			 Map<String, Object>  orderPriceMap =  getOrderPrice( cartType,couponCardId, receiverId, String.valueOf(order.getMemberId()), paymentWayId,shortOrderId,deliveryId);
			 String orderSn =getOrderSn();
			 order.setOrderSn(orderSn);//订单号
			 order.setOrderSource(1);//订单来源 1 pc 2 wap 3 安卓 4 ios 5 手动下单
			 order.setShippingFee((BigDecimal)orderPriceMap.get("shippingFee"));//运费
			 order.setPromotionalDiscount((BigDecimal)orderPriceMap.get("promotionalDiscount"));//促销折扣
			 order.setCouponDiscount((BigDecimal)orderPriceMap.get("couponDiscount"));//优惠券折扣
			 //用于测试使用
//			 order.setOrderAmount(new BigDecimal("0.01"));//订单金额
//			 order.setPayableAmount(new BigDecimal("0.01"));//应付金额
			 order.setOrderAmount((BigDecimal)orderPriceMap.get("orderPrice"));//订单金额
			 order.setPayableAmount((BigDecimal)orderPriceMap.get("payableAmount"));//应付金额
			 
			 if(StringUtils.hasText(couponCardId)){//优惠券id
				 order.setCouponId(Long.parseLong(couponCardId));
			 }
			 order.setIntegrationDiscount(new BigDecimal("0"));//积分折扣
			 order.setUseIntegration(0);//使用积分
			 order.setAdjustAmount(new BigDecimal("0"));//调整金额
			 order.setPaymentId(Long.valueOf(paymentWayId));//支付方式
			 order.setPaidAmount(new BigDecimal("0"));//已付金额
			 order.setRewardIntegration(order.getOrderAmount().intValue()/2);//赠送积分
			  //查询收货地址
			 TMemberReceiverLatLon  memberReceiverLatLon =tmemberreceiverlatlondao.selectByPrimaryKey(Long.valueOf(receiverId.trim()));
			 boolean hdfkFlag = false;
			 boolean yezfFlag = false;
			 
			 Map<String, Object> paramMap = new HashMap<String, Object>();
			
			 if(memberReceiverLatLon!=null){
				 order.setReceiver(memberReceiverLatLon.getReceiver());//收货人 
				 order.setAreaId(memberReceiverLatLon.getAreaId());//地区id
				 order.setAreaName(memberReceiverLatLon.getArea());//地区名称
				 
				 if(StringUtils.hasText(memberReceiverLatLon.getLocationAddress())){
					 order.setDetailedAddress(memberReceiverLatLon.getLocationAddress()+memberReceiverLatLon.getAddress());//详细地址
				 }else{
					 order.setDetailedAddress(memberReceiverLatLon.getAddress());//详细地址
				 }
				 order.setZipCode(memberReceiverLatLon.getZipCode());//邮编
				 order.setPhone(memberReceiverLatLon.getMobile());//联系电话
				 order.setLongitude(memberReceiverLatLon.getLongitude());
				 order.setLatitude(memberReceiverLatLon.getLatitude());
				 order.setStoreId(memberReceiverLatLon.getStoreId());
			 }
			 CPaymentWay paymentWay=	cpaymentwaydao.selectByPrimaryKey(Long.valueOf(paymentWayId.trim()));
			 if(paymentWay.getPaymentCode().equals(InfoUtil.getInstance().getInfo("config", "payment.hdfk"))){//货到付款
					hdfkFlag = true;
				}else if(paymentWay.getPaymentCode().equals(InfoUtil.getInstance().getInfo("config", "payment.yezf"))){//余额支付
					yezfFlag=true;
				}
			 order.setDeliveryId(((CDeliveryWay)orderPriceMap.get("deliveryWay")).getId());
			 if(order.getInvoiceType()!=null&&order.getInvoiceType()>0){
				 order.setIfInvoice(1);
			 }else{
				 order.setIfInvoice(0);
				 order.setInvoiceTitle("");
			 }
			 order.setIsPush(0);//是否推送海典 0 否 1 是
			 order.setPushTime(null);//推送海淀时间
			 order.setDeleteStatus(0);//删除状态 0 未删除 1 已删除
			 if(yezfFlag){
				 order.setOrderStatus(OrderEnum.UNDELIVERY.getIndex());//订单状态  待发货
				 order.setVerifyStatus(1);//核实状态  0 未核实  1 已核实
			 }else{
				 if(hdfkFlag){
					 order.setOrderStatus(OrderEnum.UNDELIVERY.getIndex());//订单状态  待发货
				 }else{
					 order.setOrderStatus(OrderEnum.UNPAY.getIndex());//订单状态 0 未支付
				 }
//				 order.setOrderStatus(OrderEnum.UNPAY.getIndex());//订单状态 0 未支付
				 order.setVerifyStatus(0);//核实状态  0 未核实  1 已核实
			 }
			 if(hdfkFlag||order.getPayableAmount().compareTo(new BigDecimal("0"))<=0){
				 order.setOrderStatus(OrderEnum.UNDELIVERY.getIndex());//订单状态  待发货
				 order.setPaymentId(4L);//货到付款
			 }else{
				 order.setOrderStatus(OrderEnum.UNPAY.getIndex());//订单状态 0 未支付
			 }
			 
			 if(StringUtils.hasText(shortOrderId)){
				 order.setOrderType(2);//订单类型  1-正常 2-秒杀 3-团购
			 }else{
				 order.setOrderType(1);//订单类型  1-正常 2-秒杀 3-团购
			 }
			 order.setReturnType(1);//返佣状态 1 未返佣  2 已返佣
			 order.setCreateDate(new Date());//下单时间
			 
			 
			 //保存订单
			 orderId =this.torderdao.insertSelective(order);
			 
//			 if(yezfFlag){//余额支付
//				 paramMap.clear();
//				 paramMap.put("memberId", order.getMemberId());
//				 TMemberAccount memberAccount = (TMemberAccount) this.opensqldao.selectForObjectByMap(paramMap, "t_member_account.selectByPrimaryKeyLock");
//			     //账户资金流水
//				 TMemberBalance   memberBalance = new TMemberBalance();
//				 memberBalance.setStreamType(3);//流水类型 1 充值  2 领袖提成 3 消费 4提现 
//				 memberBalance.setPrice(order.getPayableAmount().multiply(new BigDecimal("100")).longValue());//金额
//				 memberBalance.setBalance((memberAccount.getRemainingAmount().subtract(order.getPayableAmount())).multiply(new BigDecimal("100")).longValue());//余额
//				 memberBalance.setCreateDate(new Date());
//				 memberBalance.setMemberId(order.getMemberId());
//				 memberBalance.setRemark("订单"+order.getOrderSn()+"消费");
//				 this.tmemberbalancedao.insert(memberBalance);
//				 paramMap.put("remainingAmount", order.getPayableAmount());
//				 opensqldao.updateByMap_drug(paramMap, "t_member_account.updateRemainingAmountByPrimaryKey");
//				 
//				 
//				    TOrderFlow orderFlow =new TOrderFlow();
//					orderFlow.setMemberId(order.getMemberId());
//					orderFlow.setPaymentStatus(1);//支付状态 0 未支付 1已支付
//					orderFlow.setPaymentPlugin("lbPayplugin");
//					orderFlow.setPayMethod("龙币支付");
//					orderFlow.setHavePay(order.getPayableAmount());
//					orderFlow.setCreateTime(new Date());
//					orderFlow.setOrderId(orderId);
//					orderFlow.setPayDate(new Date());
//				    this.torderflowdao.insertSelective(orderFlow);
//				 
//				 
//			 }
			 Map<String,Object> goodMap = null;
			 TOrderItem orderItem = null;
			 List<OrderGoodCart> goodsList = (List<OrderGoodCart>) orderPriceMap.get("goodsList");
//			 if(StringUtils.hasText(shortOrderId)){//秒杀订单修改
//				 TGoodsBrokerageExample brokerageExample = null;
//				 for(OrderGoodCart goodCart: goodsList){
//					 paramMap.clear();
//					 paramMap.put("id", goodCart.getId());
//					 goodMap = (Map<String, Object>) this.opensqldao.selectForObjectByMap(paramMap, "t_goods.selectByPrimaryKeyForUpdate");
//				     orderItem = new TOrderItem();
//					 orderItem.setOrderId(orderId);
//					 orderItem.setCreateTime(new Date());
//					 orderItem.setGoodsId((Long)goodMap.get("id"));
//					 orderItem.setIfPremiums(0);
//					 orderItem.setPrice((BigDecimal)goodMap.get("pc_price"));
//					 orderItem.setQuantity(goodCart.getQuantity());
//					 orderItem.setIfReviews(0);
//					 brokerageExample = new TGoodsBrokerageExample();
//					 brokerageExample.createCriteria().andGoodsIdEqualTo(orderItem.getGoodsId());
//					 List<TGoodsBrokerage> brokerageList= tgoodsbrokeragedao.selectByExample(brokerageExample);
//					 if(brokerageList!=null&&brokerageList.size()>0){
//						 orderItem.setBrokerage(brokerageList.get(0).getBrokerage());
//					 }else{
//						 orderItem.setBrokerage(Long.valueOf(InfoUtil.getInstance().getInfo("config", "good_yongjin_lilv").trim()));
//					 }
//					 this.torderitemdao.insertSelective(orderItem);
//				 }
//			 }else{
				 TGoodsBrokerageExample brokerageExample = null;
				 TGoodsPriceExample priceExample = null;
				 for(OrderGoodCart goodCart: goodsList){
					 paramMap.clear();
					 paramMap.put("id", goodCart.getId());
					 goodMap = (Map<String, Object>) this.opensqldao.selectForObjectByMap(paramMap, "t_goods.selectByPrimaryKeyForUpdate");
				     orderItem = new TOrderItem();
					 orderItem.setOrderId(orderId);
					 orderItem.setCreateTime(new Date());
					 orderItem.setGoodsId((Long)goodMap.get("id"));
					 orderItem.setIfPremiums(goodCart.getIfPremiums());
					 if(goodCart.getIfPremiums().intValue()==1){//赠品
						 orderItem.setPrice(new BigDecimal("0"));
						 if(goodCart.getStquan().intValue()>=0){//判断赠品库存是否充足
							 orderItem.setQuantity(goodCart.getQuantity());
						 }else{
							 orderItem.setQuantity(goodCart.getStock().intValue());
						 }
					 }else{
					    priceExample = new TGoodsPriceExample();
						priceExample.createCriteria().andGoodsIdEqualTo(orderItem.getGoodsId()).andPriceTypeEqualTo("pc").andPlatformTypeEqualTo("111yao");
						List<TGoodsPrice> priceList =tgoodspricedao.selectByExample(priceExample);
						if(priceList!=null&&priceList.size()>0){
							 orderItem.setPrice(priceList.get(0).getPrice());
						}else{
							orderItem.setPrice(new BigDecimal("0"));
						}
						 orderItem.setQuantity(goodCart.getQuantity());
					 }
					 orderItem.setIfReviews(0);
					 brokerageExample = new TGoodsBrokerageExample();
					 brokerageExample.createCriteria().andGoodsIdEqualTo(orderItem.getGoodsId());
					 List<TGoodsBrokerage> brokerageList= tgoodsbrokeragedao.selectByExample(brokerageExample);
					 if(brokerageList!=null&&brokerageList.size()>0){
						 orderItem.setBrokerage(brokerageList.get(0).getBrokerage());
					 }else{
						 orderItem.setBrokerage(Long.valueOf(InfoUtil.getInstance().getInfo("config", "good_yongjin_lilv").trim()));
					 }
					 this.torderitemdao.insertSelective(orderItem);
					 paramMap.clear();
					 paramMap.put("id", goodCart.getId());
					 paramMap.put("quantity", goodCart.getQuantity());
					 this.opensqldao.updateByMap_drug(paramMap, "t_goods.updateGoodStockById");
//				 }
//				 删除购物车
				 TCartExample cartExample = new TCartExample();
				 cartExample.createCriteria().andMemberIdEqualTo(order.getMemberId());
				 List<TCart> cartList =this.tcartdao.selectByExample(cartExample);
				 if(cartList!=null&&cartList.size()>0){
					   TCartItemExample cartItemExample = new TCartItemExample();
					    if("1".equals(cartType)){//非医卡通商品
					    	cartItemExample.createCriteria().andCartIdEqualTo(cartList.get(0).getId()).andIsSelectedEqualTo(1).andIsYktGoodEqualTo(0);
						}else if("2".equals(cartType)){//医卡通商品
							cartItemExample.createCriteria().andCartIdEqualTo(cartList.get(0).getId()).andIsSelectedEqualTo(1).andIsYktGoodEqualTo(1);
						}else{
							cartItemExample.createCriteria().andCartIdEqualTo(cartList.get(0).getId()).andIsSelectedEqualTo(1);
						}
					 this.tcartitemdao.deleteByExample(cartItemExample);
				 }
			 }
//			 if(StringUtils.hasText(shortOrderId)){//秒杀订单修改
//				 TShortOrder shortOrder = new TShortOrder();
//				 shortOrder.setId(Long.parseLong(shortOrderId));
//				 shortOrder.setOrderId(orderId);
//				 shortOrder.setStatus(2);//状态 1 生成预订单 2生成正式订单 3预订单取消
//				 tshortorderdao.updateByPrimaryKeySelective(shortOrder);
//			 }
//			 
			 //更新优惠券使用信息
			 if(StringUtils.hasText(couponCardId)){
				 TCouponCard couponCard = new TCouponCard();
				 couponCard.setId(Long.valueOf(couponCardId));
				 couponCard.setIsUse(1);//是否使用 1 已使用
				 couponCard.setUseTime(new Date());//使用时间
				 couponCard.setMemberId(order.getMemberId());
				 tcouponcarddao.updateByPrimaryKeySelective(couponCard);
			 }
			 
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return orderId;
	}
	
	/**
	 * 获取订单号
	 * @return
	 */
	public String getOrderSn(){
		   Map<String,Object> paramMap = new HashMap<String,Object>();
		   paramMap.put("len", 6);
		   String ordersn =(String) opensqldao.selectForObjectByMap(paramMap, "t_order.select_order_sn_call");
		   if("-1".equals(ordersn)){
			  return getOrderSn();
		   }else{
			   return ordersn;
		   }
	}
	public TPromotionDAO getTpromotiondao() {
		return tpromotiondao;
	}

	public void setTpromotiondao(TPromotionDAO tpromotiondao) {
		this.tpromotiondao = tpromotiondao;
	}

	

	public TMemberReceiverLatLonDAO getTmemberreceiverlatlondao() {
		return tmemberreceiverlatlondao;
	}

	public void setTmemberreceiverlatlondao(
			TMemberReceiverLatLonDAO tmemberreceiverlatlondao) {
		this.tmemberreceiverlatlondao = tmemberreceiverlatlondao;
	}

	public CPaymentWayDAO getCpaymentwaydao() {
		return cpaymentwaydao;
	}

	public void setCpaymentwaydao(CPaymentWayDAO cpaymentwaydao) {
		this.cpaymentwaydao = cpaymentwaydao;
	}

	public TOrderItemDAO getTorderitemdao() {
		return torderitemdao;
	}

	public void setTorderitemdao(TOrderItemDAO torderitemdao) {
		this.torderitemdao = torderitemdao;
	}

	public TCartDAO getTcartdao() {
		return tcartdao;
	}

	public void setTcartdao(TCartDAO tcartdao) {
		this.tcartdao = tcartdao;
	}

	public TCartItemDAO getTcartitemdao() {
		return tcartitemdao;
	}

	public void setTcartitemdao(TCartItemDAO tcartitemdao) {
		this.tcartitemdao = tcartitemdao;
	}

	public TMemberBalanceDAO getTmemberbalancedao() {
		return tmemberbalancedao;
	}

	public void setTmemberbalancedao(TMemberBalanceDAO tmemberbalancedao) {
		this.tmemberbalancedao = tmemberbalancedao;
	}

	public TOrderFlowDAO getTorderflowdao() {
		return torderflowdao;
	}

	public void setTorderflowdao(TOrderFlowDAO torderflowdao) {
		this.torderflowdao = torderflowdao;
	}

	public IDaoManager getCartdao() {
		return cartdao;
	}

	public void setCartdao(IDaoManager cartdao) {
		this.cartdao = cartdao;
	}

	public TShortOrderDAO getTshortorderdao() {
		return tshortorderdao;
	}

	public void setTshortorderdao(TShortOrderDAO tshortorderdao) {
		this.tshortorderdao = tshortorderdao;
	}

	@Override
	public void cancelOrder(long orderId,Integer orderType,long memberId) throws Exception {
		
		TOrder orderold = this.torderdao.selectByPrimaryKey(orderId);
		
		TOrder order = new TOrder();
		order.setId(orderId);
		order.setOrderStatus(OrderEnum.CANCEL.getIndex());
		this.torderdao.updateByPrimaryKeySelective(order);
		
		TOrderItemExample orderItemExample = new TOrderItemExample();
		orderItemExample.createCriteria().andOrderIdEqualTo(orderId);
		List<TOrderItem> orderItemList =  this.torderitemdao.selectByExample(orderItemExample);
		if(orderItemList!=null&&orderItemList.size()>0){
			 Map<String, Object> paramMap = new HashMap<String, Object>();
			for(TOrderItem orderItem:orderItemList){
				paramMap.clear();
				paramMap.put("id", orderItem.getGoodsId());
				this.opensqldao.selectForObjectByMap(paramMap, "t_goods.selectByPrimaryKeyForUpdate");
				paramMap.clear();
				paramMap.put("id", orderItem.getGoodsId());
				paramMap.put("quantity", orderItem.getQuantity());
				this.opensqldao.updateByMap_drug(paramMap, "t_goods.updateGoodAddStockById");
			}
			
		}
		if(orderType!=null&&orderType.intValue()==2){//秒杀
			
			TShortOrderExample shortOrderExample = new TShortOrderExample();
			shortOrderExample.createCriteria().andOrderIdEqualTo(orderId).andMemberIdEqualTo(memberId);
			List<TShortOrder> shortOrderList =this.tshortorderdao.selectByExample(shortOrderExample);
			if(shortOrderList!=null&&shortOrderList.size()>0){
				TShortOrder shortOrder = shortOrderList.get(0);
				shortOrder.setStatus(1);
				shortOrder.setOrderId(null);
				this.tshortorderdao.updateByPrimaryKey(shortOrder);
			}
			
		}
       //退换货
		TReturn tReturn = new TReturn();
		if(orderold.getOrderStatus().intValue()==0||orderold.getOrderStatus().intValue()==1){
			if(orderold.getOrderStatus().intValue()==1){
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("len", 6);
				String returnOrderSn = (String) opensqldao.selectForObjectByMap(paramMap,
						"t_return.select_new_return_ordersn");
				while (returnOrderSn == null || "".equals(returnOrderSn) || "-1".equals(returnOrderSn)) {
					returnOrderSn = (String) opensqldao.selectForObjectByMap(paramMap, "t_return.select_new_return_ordersn");
				}
				tReturn.setOrderSn(returnOrderSn);
				tReturn.setServiceType(0);
				tReturn.setShipperPhone(orderold.getPhone());
				tReturn.setMemberId(orderold.getMemberId());
				tReturn.setRefundDescribe(orderold.getOrderSn()+"取消订单");
				tReturn.setOrderStatus(0);
				tReturn.setCreateTime(new Date());
				tReturn.setOldOrderId(orderold.getId());
				CPaymentWay paymentWay =cpaymentwaydao.selectByPrimaryKey(orderold.getPaymentId());
				if(paymentWay.getPaymentWay().intValue()==0){//线上
					tReturn.setRefundAmount(orderold.getPayableAmount());
				}else if(paymentWay.getPaymentWay().intValue()==1){//线下
					tReturn.setRefundAmount(new BigDecimal("0"));
				}
				Long returnId=this.treturndao.insertSelective(tReturn);
				TReturnItem returnItem = null;
				for(TOrderItem orderItem:orderItemList){
					returnItem = new TReturnItem();
					returnItem.setCreateTime(new Date());
					returnItem.setGoodsId(orderItem.getGoodsId());
					returnItem.setProductAmount(orderItem.getPrice());
					returnItem.setQuantity(orderItem.getQuantity());
					returnItem.setReturnId(returnId);
					this.treturnitemdao.insertSelective(returnItem);
				}
			}
		}else{
			throw new Exception("取消订单失败订单状态未在可取消范围内");
		}
		
	}

	public TReturnDAO getTreturndao() {
		return treturndao;
	}

	public void setTreturndao(TReturnDAO treturndao) {
		this.treturndao = treturndao;
	}

	public TReturnItemDAO getTreturnitemdao() {
		return treturnitemdao;
	}

	public void setTreturnitemdao(TReturnItemDAO treturnitemdao) {
		this.treturnitemdao = treturnitemdao;
	}

	public TGoodsDAO getTgoodsdao() {
		return tgoodsdao;
	}

	public void setTgoodsdao(TGoodsDAO tgoodsdao) {
		this.tgoodsdao = tgoodsdao;
	}

	public TCouponCardDAO getTcouponcarddao() {
		return tcouponcarddao;
	}

	public void setTcouponcarddao(TCouponCardDAO tcouponcarddao) {
		this.tcouponcarddao = tcouponcarddao;
	}

	public TSysParameterDAO getTsysparameterdao() {
		return tsysparameterdao;
	}

	public void setTsysparameterdao(TSysParameterDAO tsysparameterdao) {
		this.tsysparameterdao = tsysparameterdao;
	}

	/**
	 * 完成订单
	 */
	public void complete(TOrder order,String publicServiceUrl) throws Exception{
		
		TOrder dbOrder = torderdao.selectByPrimaryKey(order.getId());
		
		TMemberIntegral tmemberintegral = new TMemberIntegral();
		tmemberintegral.setCreateDate(new Date());
		tmemberintegral.setIntegral(dbOrder.getRewardIntegration());
		tmemberintegral.setMemberId(dbOrder.getMemberId());
		tmemberintegral.setSource(9);
		tmemberintegraldao.insertSelective(tmemberintegral);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", dbOrder.getMemberId().toString());
		map.put("jifen", dbOrder.getRewardIntegration().toString());
		map.put("version", "v7");
		topicMessageSender.sendMapMessage(map);
		order.setFinishDate(new Date());
		this.updateByPrimaryKeySelective(order);
		if (dbOrder.getPaymentId() != null && dbOrder.getPaymentId() > 0L) {
			CPaymentWay _cPaymentWay = cpaymentwaydao.selectByPrimaryKey(dbOrder.getPaymentId());
			if (_cPaymentWay != null && _cPaymentWay.getPaymentCode() != null&& dbOrder.getMemberId() != null) {
				Map<String,String> publicMap = new HashMap<String,String>();
				publicMap.put("orderId", String.valueOf(order.getId()));
				String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"leaderStayMoneyURLService");
				if(JSONObject.fromObject(resultJsonstr).get("statsCode").equals("0")){
					throw new Exception(String.valueOf(order.getId())+":佣金计算失败,失败原因:"+JSONObject.fromObject(resultJsonstr).get("message"));
				}
			}
		}
	}
	
	/**
	 * 更改支付方式为  货到付款
	 */
	public boolean changePayWayHdfk(TOrder order,long paymentmethodId) throws Exception {
		boolean flag = true;
		try{
			if(order.getOrderStatus().intValue()==0){
				TOrder updateOrder = new TOrder();
				updateOrder.setId(order.getId());
				updateOrder.setPaymentId(paymentmethodId);
				updateOrder.setOrderStatus(1);//待发货
			    boolean ysd_ysdj_areaid_flag = false; //是否 是门店配送范围
		 		if(StringUtils.hasText(order.getStoreId())){
		 			ysd_ysdj_areaid_flag = true;
		 		}
				if(!ysd_ysdj_areaid_flag){  //是门店配送范围
					BigDecimal freight = new BigDecimal("0");// 运费
				    BigDecimal weight = new BigDecimal("0");// 商品总重量
				    BigDecimal price = new BigDecimal("0"); //商品总金额
					boolean feeflag = false;   //是否免邮费
					if(order.getCouponId()!=null){//判断是否使用免运费优惠券
						TCouponCard couponCard = tcouponcarddao.selectByPrimaryKey(order.getCouponId());
						if(couponCard!=null&&couponCard.getTicketId()!=null){
							TCoupon tcoupon =tcoupondao.selectByPrimaryKey(couponCard.getTicketId());
							if(tcoupon!=null&&tcoupon.getScope()!=null&&tcoupon.getScope().intValue()==1){//免运费
								feeflag = true;
							}
						}
					}
					
					Map<String,Object> paramMap = new HashMap<String,Object>(); 
				    paramMap.put("orderId", order.getId());
				    List orderPirceWeightlist =opensqldao.selectForListByMap(paramMap, "t_order.selectGoodsPriceWeightByorderID");
				    if(orderPirceWeightlist!=null&&orderPirceWeightlist.size()>0){
				    	Map<String,Object> resultMap = (Map<String, Object>) orderPirceWeightlist.get(0);
				    	if(resultMap.get("pricesum")!=null){
				    		price =(BigDecimal) resultMap.get("pricesum");
				    	}
				    	if(resultMap.get("weightsum")!=null){
				    		weight=(BigDecimal) resultMap.get("weightsum");
				    	}
				    }
				    if(!feeflag){
				    	String free_shippingfee_price =tsysparameterdao.getKeys("free_shippingfee_price");
				    	if(StringUtils.hasText(free_shippingfee_price)){
				    		if(price.compareTo(new BigDecimal(free_shippingfee_price.trim()))>=0){
				    			feeflag=true;
				    		}
				    	}
				    }
				    
				    paramMap.clear();
			    	paramMap.put("deliveryCode", "hdfk");
				    List<CDeliveryWay> deliveryList =this.opensqldao.selectForListByMap(paramMap, "c_delivery_way.selectDeliveryWayByMap");
				    if(deliveryList!=null&&deliveryList.size()>0){
				    	 if(!feeflag){
				    		 freight=deliveryList.get(0).calculateFreight(weight);
						 }
				    	 updateOrder.setDeliveryId(deliveryList.get(0).getId());
				     }
				     updateOrder.setPayableAmount(order.getPayableAmount().subtract(order.getShippingFee()).add(freight));
					 updateOrder.setOrderAmount(order.getPayableAmount().subtract(order.getShippingFee()).add(freight));
					 updateOrder.setShippingFee(freight);
					 updateOrder.setRewardIntegration(updateOrder.getOrderAmount().intValue()/2);
				}
				this.torderdao.updateByPrimaryKeySelective(updateOrder);
				TOrderFlowExample orderflowExample = new TOrderFlowExample();
				orderflowExample.createCriteria().andOrderIdEqualTo(order.getId()).andMemberIdEqualTo(order.getMemberId());
				this.torderflowdao.deleteByExample(orderflowExample);
			}else{
				flag = false;
			}
		}catch(Exception e){
			e.printStackTrace();
			flag =false;
		}
		return flag;
	}

	public TMemberLeaderDAO getTmemberleaderdao() {
		return tmemberleaderdao;
	}

	public void setTmemberleaderdao(TMemberLeaderDAO tmemberleaderdao) {
		this.tmemberleaderdao = tmemberleaderdao;
	}

	public TGoodsBrokerageDAO getTgoodsbrokeragedao() {
		return tgoodsbrokeragedao;
	}

	public void setTgoodsbrokeragedao(TGoodsBrokerageDAO tgoodsbrokeragedao) {
		this.tgoodsbrokeragedao = tgoodsbrokeragedao;
	}

	public CDeliveryWayDAO getCdeliverywaydao() {
		return cdeliverywaydao;
	}

	public void setCdeliverywaydao(CDeliveryWayDAO cdeliverywaydao) {
		this.cdeliverywaydao = cdeliverywaydao;
	}

	public TGoodsPriceDAO getTgoodspricedao() {
		return tgoodspricedao;
	}

	public void setTgoodspricedao(TGoodsPriceDAO tgoodspricedao) {
		this.tgoodspricedao = tgoodspricedao;
	}

	public TCouponDAO getTcoupondao() {
		return tcoupondao;
	}

	public void setTcoupondao(TCouponDAO tcoupondao) {
		this.tcoupondao = tcoupondao;
	}

	
	
}
