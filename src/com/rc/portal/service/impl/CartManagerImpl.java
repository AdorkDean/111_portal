package com.rc.portal.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rc.portal.dao.OpenSqlDAO;
import com.rc.portal.dao.TCartDAO;
import com.rc.portal.dao.TCartItemDAO;
import com.rc.portal.dao.TGoodsDAO;
import com.rc.portal.dao.TGoodsPriceDAO;
import com.rc.portal.dao.TOrderDAO;
import com.rc.portal.dao.TOrderItemDAO;
import com.rc.portal.dao.TPromGiftDAO;
import com.rc.portal.dao.TPromItemDAO;
import com.rc.portal.dao.TPromotionDAO;
import com.rc.portal.dao.YktGoodsDAO;
import com.rc.portal.dao.impl.CartDaoImpl;
import com.rc.portal.service.ICartManager;
import com.rc.portal.service.TCartItemManager;
import com.rc.portal.vo.TCart;
import com.rc.portal.vo.TCartExample;
import com.rc.portal.vo.TCartItem;
import com.rc.portal.vo.TCartItemExample;
import com.rc.portal.vo.TGoods;
import com.rc.portal.vo.TGoodsPrice;
import com.rc.portal.vo.TGoodsPriceExample;
import com.rc.portal.vo.TOrder;
import com.rc.portal.vo.TOrderItem;
import com.rc.portal.vo.TOrderItemExample;
import com.rc.portal.vo.TPromItem;
import com.rc.portal.vo.TPromItemExample;
import com.rc.portal.vo.TPromotion;
import com.rc.portal.vo.YktGoodsExample;
import com.rc.portal.webapp.model.cart.CartItem;
import com.rc.portal.webapp.model.cart.CartParam;
import com.rc.portal.webapp.model.cart.GoodsPrice;



public class CartManagerImpl implements ICartManager {
	
	private TCartDAO tcartdao;
	private TCartItemDAO tcartitemdao;
	private OpenSqlDAO opensqldao;
	private TGoodsDAO tgoodsdao;
	private TPromItemDAO tpromitemdao;
	private TPromotionDAO tpromotiondao;
	private TPromGiftDAO tpromgiftdao;
	private TCartItemManager tcartitemmanager;
	private CartDaoImpl cartdao;
	private TOrderDAO torderdao;
	private TOrderItemDAO torderitemdao;
//	private TGoodsManager tgoodsmanager;
	
	private TGoodsPriceDAO tgoodspricedao;
	private YktGoodsDAO yktgoodsdao;
	
	Map map = new HashMap();
	//限购数量前台代码改此处
	private int cartMaxNum = 50000;
	
	
    public static void main(String[] args) throws Exception {
        
    	CartManagerImpl o = new CartManagerImpl();
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext*.xml");
    	o.tcartdao = (TCartDAO) context.getBean("tcartdao");
    	o.tcartitemdao = (TCartItemDAO) context.getBean("tcartitemdao");
    	o.opensqldao = (OpenSqlDAO) context.getBean("opensqldao");
    	o.tgoodsdao = (TGoodsDAO) context.getBean("tgoodsdao");
    	o.cartdao = (CartDaoImpl) context.getBean("cartdao");
    	
//    	String key = "328B37D1-AA38-4C68-B47A-1EB904A31454";
//    	CartParam arg = new CartParam();
//    	arg.setCartkey(key);
//    	Map map = o.accounts(arg);
//    	System.out.println("应付金额----"+map.get("money"));
//    	System.out.println("优惠金额----"+map.get("youhui"));
    	
    	o.synCart(100, "C072294C-6BE4-43D1-9F11-9800DD6E84EF");
    	
    }
    

    /**
     * 再次购买
     */
    @Override
    public String againBuy(long orderid) throws SQLException {
		TOrder tOrder = torderdao.selectByPrimaryKey(orderid);
		TOrderItemExample tOrderItemExample = new TOrderItemExample();
		tOrderItemExample.createCriteria().andOrderIdEqualTo(orderid);
		List<TOrderItem> tCartItemList = torderitemdao.selectByExample(tOrderItemExample);
		
		TCartExample tCartExample = new TCartExample();
		tCartExample.setOrderByClause(" create_time desc");
		tCartExample.createCriteria().andMemberIdEqualTo(tOrder.getMemberId());
		List<TCart> tCartList = tcartdao.selectByExample(tCartExample);
		Long tcartId;
		if(tCartList==null||tCartList.size()<=0){
			TCart tCart = new TCart();
			tCart.setCreateTime(new Date());
			tCart.setMemberId(tOrder.getMemberId());
			tCart.setCartKey(null);
			tcartId = tcartdao.insert(tCart);
		}else{
			tcartId = tCartList.get(0).getId();
		}
		Map<String, Object> cuxiaoParam = null;
//		Map<String, Object> goodMap = new HashMap<String, Object>();
		for (TOrderItem tOrderItem : tCartItemList) {
			cuxiaoParam = new HashMap<String, Object>();
			cuxiaoParam.put("goodId", tOrderItem.getGoodsId());
			cuxiaoParam.put("nowDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			//查询商品是否存在促销,存在的话促销限制个数
			Map<String, Object>  limitCountMap = (Map<String, Object>) opensqldao.selectForObjectByMap(cuxiaoParam, "t_cart_item.selectCuxiaoByGoodId");
			//非促销商品,直接添加购物车
			if(limitCountMap==null||limitCountMap.get("limitCount")==null||limitCountMap.get("startTime")==null||limitCountMap.get("endTime")==null){
				TCartItemExample againExample = new TCartItemExample();
				againExample.createCriteria().andCartIdEqualTo(tcartId).andGoodsIdEqualTo(tOrderItem.getGoodsId());
				List<TCartItem> againList = tcartitemdao.selectByExample(againExample);
				TCartItem againItem = null;
				if(againList==null||againList.size()<=0){
					Integer yktCount = null;
					TGoods good = tgoodsdao.selectByPrimaryKey(tOrderItem.getGoodsId());
					YktGoodsExample yktGoodsExample = new YktGoodsExample();
					yktGoodsExample.createCriteria().andGoodsNoEqualTo(good.getGoodsno());
					yktCount = yktgoodsdao.countByExample(yktGoodsExample);
					againItem = new TCartItem();
					againItem.setCartId(tcartId);
					againItem.setCreateTime(new Date());
					againItem.setGoodsId(tOrderItem.getGoodsId());
					againItem.setIfPremiums(0);
					againItem.setIsSelected(1);
					againItem.setQuantity(tOrderItem.getQuantity());
					againItem.setIsYktGood((yktCount==null||yktCount<=0)?0:1);
					tcartitemdao.insertSelective(againItem);
				}else{
					againItem = againList.get(0);
					againItem.setQuantity(againItem.getQuantity()==null?tOrderItem.getQuantity():againItem.getQuantity()+tOrderItem.getQuantity());
					againItem.setIsSelected(1);
					tcartitemdao.updateByPrimaryKeySelective(againItem);
				}
			}else{//促销商品,判断还能加入购物车的数量
				System.out.println(limitCountMap);
				Integer limit = (Integer) limitCountMap.get("limitCount");
				String startTime = limitCountMap.get("startTime").toString();
				String endTime = limitCountMap.get("endTime").toString();
				Map<String, Object> orderMap = new HashMap<String, Object>();
				orderMap.put("startTime", startTime);
				orderMap.put("endTime", endTime);
				orderMap.put("goodId", tOrderItem.getGoodsId());
				orderMap.put("memberId", tOrder.getMemberId());
				Integer orderItemNum = (Integer) opensqldao.selectForObjectByMap(orderMap, "t_order_item.selectTOrderItemByCart");
				if(orderItemNum==null){
					orderItemNum = 0;
				}
				int itemCount = 0;
				TCartItemExample againExample = new TCartItemExample();
				againExample.createCriteria().andCartIdEqualTo(tcartId).andGoodsIdEqualTo(tOrderItem.getGoodsId());
				List<TCartItem> againList = tcartitemdao.selectByExample(againExample);
				TCartItem newItem = null;
				
				if(againList!=null&&againList.size()>0){
					itemCount = againList.get(0).getQuantity();
					newItem = againList.get(0);
				}else{
					Integer count = null;
					if(limitCountMap.get("goodsno")!=null){
						YktGoodsExample yktGoodsExample = new YktGoodsExample();
						yktGoodsExample.createCriteria().andGoodsNoEqualTo(limitCountMap.get("goodsno").toString());
						count = yktgoodsdao.countByExample(yktGoodsExample);
					}
					newItem = new TCartItem();
					newItem.setCartId(tcartId);
					newItem.setCreateTime(new Date());
					newItem.setGoodsId(tOrderItem.getGoodsId());
					newItem.setIfPremiums(0);
					newItem.setIsSelected(1);
					newItem.setQuantity(tOrderItem.getQuantity());
					newItem.setIsYktGood((count==null||count<=0)?0:1);
					tcartitemdao.insertSelective(newItem);
				}
				if(limit<=orderItemNum){//买过的已经够了
					TCartItemExample delItem = new TCartItemExample();
					delItem.createCriteria().andCartIdEqualTo(tcartId).andGoodsIdEqualTo(tOrderItem.getGoodsId());
					tcartitemdao.deleteByExample(delItem);
				}else if((limit-orderItemNum)<(itemCount+tOrderItem.getQuantity())){//还能买的个数小于(购物车里有的+订单项里的个数)
					newItem.setQuantity(limit-orderItemNum);
					tcartitemdao.updateByPrimaryKeySelective(newItem);
				}else{
					newItem.setQuantity(itemCount+tOrderItem.getQuantity());
					tcartitemdao.updateByPrimaryKeySelective(newItem);
				}
			}
		}
		return null;
	}
    
    
    /**
     * 20160427WWF废弃
     * @deprecated
     * @param orderid
     * @return
     * @throws SQLException
     */
  public String againBuy_old(long orderid) throws SQLException{
    	
    	TOrder order = torderdao.selectByPrimaryKey(orderid);
    	
    	StringBuilder str = new StringBuilder("0");
		
		TCartItemExample  ItemException = new TCartItemExample();
    	List<TCartItem> userItemList = new ArrayList<TCartItem>();
		
		TOrderItemExample example = new TOrderItemExample();
		example.createCriteria().andOrderIdEqualTo(order.getId());
		List<TOrderItem> OrderList = torderitemdao.selectByExample(example);
		
		
		// 查询ID标识下的购物车中所有商品
    	TCartExample userexample = new TCartExample();
    	userexample.createCriteria().andMemberIdEqualTo(order.getMemberId());
		List<TCart> userCartList = tcartdao.selectByExample(userexample);
		TCart UserCart = null;
		if(userCartList.size()>0)
		{
			UserCart = userCartList.get(0);
			// 用户ID标识的购物车中的商品
			ItemException.createCriteria().andCartIdEqualTo(UserCart.getId());
			userItemList = tcartitemdao.selectByExample(ItemException);
		}
		
		List<Long> idlist = new ArrayList<Long>(); // 判断是否包含
		List<Long> cartOldGoodsList = new ArrayList<Long>(); // 就商品不选中
		
		Map<Long,Integer> goodsAndCntMap  = new HashMap<Long,Integer>();
		Map<Long,Long> goodsAndCartItemIdMap  = new HashMap<Long,Long>();
		for(TCartItem item : userItemList){
			idlist.add(item.getGoodsId());
			cartOldGoodsList.add(item.getGoodsId());
			goodsAndCntMap.put(item.getGoodsId(), item.getQuantity());
			goodsAndCartItemIdMap.put(item.getGoodsId(),item.getId());
		}
		
		System.out.println("goodsAndCntMap 的大小 ---->"+goodsAndCntMap.size()+"--"+goodsAndCntMap);
		
		// 如果有购物车
		 TCartItem CartItemRecord = null;
		
		
		if(idlist.size()>0)	// 如果购物本来就有商品
		{
			for(TOrderItem item : OrderList)
			{
				CartItemRecord = new TCartItem();
				
				System.out.println("====="+item.getQuantity()+"===="+item.getGoodsId()+"===="+goodsAndCntMap+"===="+goodsAndCntMap.get(item.getGoodsId()));
				
				int newStore = 1;
				if(idlist.contains(item.getGoodsId())){
					 newStore = item.getQuantity()+goodsAndCntMap.get(item.getGoodsId());
				}else{
					 newStore = item.getQuantity();
				}
				
				CartItemRecord.setGoodsId(item.getGoodsId());
				
				
				TGoods goods = tgoodsdao.selectByPrimaryKey(item.getGoodsId());
				
				if(goods!=null)
				{
					int store = goods.getStock().intValue();//cartdao.getGoodsPrice(item.getGoodsId()).getStock();
					
					TGoodsPriceExample tGoodsPriceExample = new TGoodsPriceExample();
					tGoodsPriceExample.createCriteria().andGoodsIdEqualTo(goods.getId()).andPriceTypeEqualTo("pc");
					List<TGoodsPrice> tGoodsPricesList = tgoodspricedao.selectByExample(tGoodsPriceExample);
					boolean xiajiaFlag = true;
					if(tGoodsPricesList!=null && tGoodsPricesList.size()>0){
						TGoodsPrice tGoodsPrice = tGoodsPricesList.get(0);
						if(tGoodsPrice.getStatus()!=null && tGoodsPrice.getStatus()==2){
							xiajiaFlag = false;
						}
					}
						
					
					if(goods.getType()!=3 && xiajiaFlag && store>0){ // 非处方药B  没有下架
						if(store>=newStore){
							CartItemRecord.setQuantity(newStore);
						}else{
							CartItemRecord.setQuantity(store);
						}
						CartItemRecord.setIfPremiums(0);
						CartItemRecord.setIsSelected(1);
						CartItemRecord.setCartId(UserCart.getId());
						if(idlist.contains(item.getGoodsId()))
						{
							CartItemRecord.setId(goodsAndCartItemIdMap.get(item.getGoodsId()));
							tcartitemdao.updateByPrimaryKeySelective(CartItemRecord);
						}else{
							CartItemRecord.setCreateTime(new Date());
							tcartitemdao.insert(CartItemRecord);
						}
						
					}else{
						str.append(","+item.getGoodsId());
					}
					
				}
				// 移除cartOldGoodsList中旧商品Id
				cartOldGoodsList.remove(item.getGoodsId());
			}
			
			
			
		}else{
			
			long mainid = 0;
			if(UserCart==null){
				TCart  cart = new TCart();
				cart.setCartKey("");
				cart.setCreateTime(new Date());
				cart.setMemberId(order.getMemberId());
				mainid = tcartdao.insert(cart);
			}else{
				mainid = UserCart.getId();
			}
			
			
			 for(TOrderItem item : OrderList)
			 {
				 
				 TGoods goods = tgoodsdao.selectByPrimaryKey(item.getGoodsId());
				 if(goods!=null)
				 {
					    int store = goods.getStock().intValue();//cartdao.getGoodsPrice(item.getGoodsId()).getStock();
						CartItemRecord = new TCartItem();
						CartItemRecord.setId(null);
						CartItemRecord.setCartId(mainid);
						CartItemRecord.setIfPremiums(0);
						CartItemRecord.setGoodsId(item.getGoodsId());
						int newStore = item.getQuantity();
						System.out.println("item.getGoodsId()====="+item.getGoodsId());
						
								
						 if(store>0)
						 {
							if(store>=newStore){
								CartItemRecord.setQuantity(newStore);
							}else{
								CartItemRecord.setQuantity(store);
							}
							CartItemRecord.setIsSelected(1);
							CartItemRecord.setCreateTime(new Date());
							tcartitemdao.insert(CartItemRecord);
							
						}else{
							str.append(","+item.getGoodsId());
						}
				 }
			 }
		}
		
		System.out.println("cartOldGoodsList======="+cartOldGoodsList.size());
		
		// 将旧商品去掉选中状态 
		Map sql = new HashMap();
		sql.put("userid", order.getMemberId());
		for(long id : cartOldGoodsList ){
			sql.put("productid", id);
			opensqldao.updateByMap_drug(sql, "mycart.is_selected_false");
		}
		
		sql.put("allids", str);
		List<String> list =  opensqldao.selectForListByMap(sql, "mycart.getnamestr");
		StringBuilder sb = new StringBuilder();
		for(String s : list){
			sb.append(s+";");
		}
		
		handLimitCount(order.getMemberId());
		
		return sb.toString();
    }
    
  	public void synCart(long memberId,String uuid ) throws SQLException,Exception {

		if(uuid==null||"".equals(uuid)){//cookie不存在,不用合并
			return;
		}
		if (memberId <=0 || "".equals(memberId)) {
			throw new Exception("用户ID不能为空");
		}
		Long cookieCartId = null;
		TCartExample cookieExample = new TCartExample();
		cookieExample.createCriteria().andCartKeyEqualTo(uuid);
		List<TCart> cookieList = tcartdao.selectByExample(cookieExample);
		if (cookieList != null && cookieList.size() > 0) {
			cookieCartId = cookieList.get(0).getId();
		}
		Map<Long, TCartItem> cookieMap = new HashMap<Long, TCartItem>();
		List<TCartItem> cookieItemList = null;
		if (cookieCartId != null && !"".equals(cookieCartId)) {
			TCartItemExample cookeiItemExample = new TCartItemExample();
			cookeiItemExample.createCriteria().andCartIdEqualTo(cookieCartId);
			// cookie购物车项
			cookieItemList = tcartitemdao.selectByExample(cookeiItemExample);
			for (TCartItem tCartItem : cookieItemList) {
				cookieMap.put(tCartItem.getGoodsId(), tCartItem);
			}
		}
		TCartExample tCartExample = new TCartExample();
		tCartExample.createCriteria().andMemberIdEqualTo(memberId);

		List<TCart> tCartList = tcartdao.selectByExample(tCartExample);
		Long cartId = 0L;
		if (tCartList != null && tCartList.size() > 0) {
			cartId = tCartList.get(0).getId();
		}else{
			TCart tCart = new TCart();
			tCart.setCreateTime(new Date());
			tCart.setMemberId(memberId);
			cartId = tcartdao.insertSelective(tCart);
		}
		TCartItemExample tCartItemExample = new TCartItemExample();
		tCartItemExample.createCriteria().andCartIdEqualTo(cartId);
		List<TCartItem> itemList = tcartitemdao.selectByExample(tCartItemExample);
		for (TCartItem tCartItem : itemList) {
			if(cookieMap.containsKey(tCartItem.getGoodsId())){
				Integer newQu = 0;
				newQu = tCartItem.getQuantity()==null?cookieMap.get(tCartItem.getGoodsId()).getQuantity():(tCartItem.getQuantity()+cookieMap.get(tCartItem.getGoodsId()).getQuantity());
				tCartItem.setQuantity(newQu<=cartMaxNum?newQu:cartMaxNum);
				tcartitemdao.updateByPrimaryKeySelective(tCartItem);
				cookieMap.remove(tCartItem.getGoodsId());
			}
		}
		if(cookieMap!=null && cookieMap.values()!=null){
			for (TCartItem _item : cookieMap.values()) {
				_item.setCartId(cartId);
				tcartitemdao.updateByPrimaryKeySelective(_item);
				itemList.add(_item);
			}
		}
		
		//itemList里现在含有合并后的购物车项
		for (TCartItem tCartItem : itemList) {
			Map<String, Object> _Map = new HashMap<String, Object>();
			_Map.put("goodId", tCartItem.getGoodsId());
			_Map.put("nowDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			Map<String, Object>  limitCountMap = 
					(Map<String, Object>) opensqldao.selectForObjectByMap(_Map, "t_cart_item.selectCuxiaoByGoodId");
			if(limitCountMap!=null&&limitCountMap.get("limitCount")!=null&&
					limitCountMap.get("startTime")!=null&&limitCountMap.get("endTime")!=null){
				Integer limit = (Integer)limitCountMap.get("limitCount");
				String startTime = limitCountMap.get("startTime").toString();
				String endTime = limitCountMap.get("endTime").toString();
				//促销中
				//查询订单购买该商品个数
				Map<String, Object> orderMap = new HashMap<String, Object>();
				orderMap.put("startTime", startTime);
				orderMap.put("endTime", endTime);
				orderMap.put("goodId", tCartItem.getGoodsId());
				orderMap.put("memberId", memberId);
				Integer orderItemNum = (Integer) opensqldao.selectForObjectByMap(orderMap, "t_order_item.selectTOrderItemByCart");
				if(orderItemNum==null){
					orderItemNum=0;
				}
				
				if(orderItemNum!=null&&orderItemNum>=limit){
					//删除该购物车项
					tcartitemdao.deleteByPrimaryKey(tCartItem.getId());
				}else if(orderItemNum!=null&&orderItemNum<limit){
					if((limit-orderItemNum)<tCartItem.getQuantity()){
						tCartItem.setQuantity(limit-orderItemNum);
						tcartitemdao.updateByPrimaryKeySelective(tCartItem);
					}
				}
			}
		}
		tcartdao.deleteByPrimaryKey(cookieCartId);
	
  	} 
    
	  /**
	   * WWF20160420废弃-建龙购物车逻辑
	   * @deprecated
	   * @param userId
	   * @param key
	   * @throws SQLException
	   */
    public void synCart_old(long userId,String key ) throws SQLException {
    	
    	if(key==null) return;
    	
    	TCartItemExample  ItemException = new TCartItemExample();
    	List<TCartItem> userItemList = new ArrayList<TCartItem>();
    	List<TCartItem> keyItemList = new ArrayList<TCartItem>();
    	
    	// 查询ID标识下的购物车中所有商品
    	TCartExample userexample = new TCartExample();
    	userexample.createCriteria().andMemberIdEqualTo(userId);
		List<TCart> userCartList = tcartdao.selectByExample(userexample);
		TCart UserCart = null;
		if(userCartList.size()>0){
			UserCart = userCartList.get(0);
			// 用户ID标识的购物车中的商品
			ItemException.createCriteria().andCartIdEqualTo(UserCart.getId());
			userItemList = tcartitemdao.selectByExample(ItemException);
		}
		
		
		 // 查询Cookie标识下的购物车中所有商品
		 TCartExample keyexample = new TCartExample();
		 keyexample.createCriteria().andCartKeyEqualTo(key);	
		 List<TCart> keyCartList = tcartdao.selectByExample(keyexample);
		 TCart KeyCart = null;
		 if(keyCartList.size()>0){
			 KeyCart  = keyCartList.get(0);
		 }else{
			 handLimitCount(userId);
			 return;
		 }
		
		// Cookie标识的购物车中的商品
		 ItemException.clear();
		 ItemException.createCriteria().andCartIdEqualTo(KeyCart.getId());
		 keyItemList = tcartitemdao.selectByExample(ItemException);
		 
		 // 除KEY标识的购物车商品(主子表数据)
		 tcartdao.deleteByPrimaryKey(KeyCart.getId());
		 tcartitemdao.deleteByExample(ItemException);
		
		 // 用户ID标识的购物车数据库中不存在记录
		 if(UserCart==null)
		 {
			 TCart mainCart = new TCart();
			 mainCart.setCartKey("");
			 mainCart.setCreateTime(new Date());
			 mainCart.setMemberId(userId);
			 long mainid = tcartdao.insert(mainCart);
			 
			 for(TCartItem keyItem : keyItemList)
			 {
				 keyItem.setId(null);
				 keyItem.setCartId(mainid);
				 tcartitemdao.insert(keyItem);
			 }
			 
			 /*
			// 购物一中所有的商品，如果有限购的，修改其数量
			 Map m = new  HashMap();
			 m.put("userid", userId);
			 List<Map> promInCartList = opensqldao.selectForListByMap(map, "mycart.prom_in_cart");
			 long goodsId = 0;
			 int count = 1;
			 TCartItem record  = null;
			 for(Map mp : promInCartList){
				 goodsId = (Long)mp.get("goodsid");
				 count = (Integer)mp.get("limitcount");
				 
				 ItemException.clear();
				 ItemException.createCriteria().andCartIdEqualTo(UserCart.getId()).andGoodsIdEqualTo(goodsId).andQuantityEqualTo(count);
				 
				 record = new TCartItem();
				 record.setQuantity(count);
				
				 tcartitemdao.updateByExample(record, ItemException);
			 }
			 
			 // 查询是否买过，将已经买过的过滤掉
			 
			 List<Map> promInOrderList = opensqldao.selectForListByMap(map, "mycart.order_in_cart");
			 int isprom = 0;
			 
			 for(Map omp : promInCartList)
			 {
				 isprom = (Integer)omp.get("isprom");
				 goodsId = (Long)omp.get("goods_id");
				 map.put("goodsid", goodsId);
				 opensqldao.updateByMap_drug(map, "mycart.prom-del-double");
				 m.remove("goodsid");
			 }
			 */
			 
			 handLimitCount(userId);
			 
			 return;
		 }
		 
		 // 用户ID标识的购物车数据库中存在记录
		 
		 
		 Map<Long,Integer> map = new HashMap<Long,Integer>();
		 for(TCartItem userItem :userItemList )
		 {
			 map.put(userItem.getGoodsId(), userItem.getQuantity());
		 }
		 Set<Long> UserSet = map.keySet();
		 for(TCartItem keyItem : keyItemList)
		 {
			 if(UserSet.contains(keyItem.getGoodsId())){	// 修改数量
				 ItemException.clear();
				 ItemException.createCriteria().andCartIdEqualTo(UserCart.getId()).andGoodsIdEqualTo(keyItem.getGoodsId());
				 keyItem.setQuantity(keyItem.getQuantity()+map.get(keyItem.getGoodsId()));
				 keyItem.setCartId(UserCart.getId());
				 tcartitemdao.updateByExample(keyItem, ItemException);
			 }else{
				 keyItem.setId(null);
				 keyItem.setCartId(UserCart.getId());
				 keyItem.setCartId(UserCart.getId());
				 tcartitemdao.insert(keyItem);
			 }
			
		 }
		 
		 handLimitCount(userId);
    }
    
    
    public void handLimitCount(long userId) throws SQLException{
    	
    	
    	System.out.println("userId----------->"+userId);
    	
    	Map map = new HashMap();
    	
    	map.put("userid", userId);
    	
    	Long cartId = (Long)opensqldao.selectForObjectByMap(map,"mycart.get-cartid-user");
    	
    	TCartItemExample  ItemException = new TCartItemExample();
    	
    	map.put("cartid", cartId);
    	// 购物一中所有的商品，如果有限购的，修改其数量
		 Map m = new  HashMap();
		 m.put("userid", userId);
		 List<Map> promInCartList = opensqldao.selectForListByMap(m, "mycart.prom_in_cart");
		 long goodsId = 0;
		 int count = 1;
		 TCartItem record  = null;
		 for(Map mp : promInCartList){
			 
			 goodsId = (Long)mp.get("goodsid");
			 count = (Integer)mp.get("limitcount");
			
			 map.put("goodsid", goodsId);
			 map.put("cnt", count);
			 opensqldao.updateByMap_drug(map, "mycart.update-limit-count");
			 
		 }
    			 
		 // 查询是否买过
		 List<Map> promInOrderList = opensqldao.selectForListByMap(m, "mycart.order_in_cart");
		 long isprom = 0;
		 
		 for(Map omp : promInOrderList)
		 {
			 goodsId = (Long)omp.get("goods_id");
			 map.put("goodsid", goodsId);
			 opensqldao.updateByMap_drug(map, "mycart.prom-del-double");
			 map.remove("goodsid");
					 
		 }
    			 
    }
    
    
	
	public TCart getCart(CartParam arg) throws SQLException{
		TCartExample dstcartexample = new TCartExample();
		if(arg.isIslogin()){ 
			dstcartexample.createCriteria().andMemberIdEqualTo(arg.getUserId());  //  用户ID
		}else{
			dstcartexample.createCriteria().andCartKeyEqualTo(arg.getCartkey());	// uuid
		}
		List<TCart> list = tcartdao.selectByExample(dstcartexample);
		TCart cart = null;
		if(list.size()>0){
		    cart=list.get(0);
		}
		return cart;
	}
	
	
	/**
	 * 新逻辑添加购物车
	 * @author WWF
	 * @datetime 20160420
	 */
	@Override
	public long addCart(CartParam arg,int count) throws SQLException {
		//0:参数错误;-1:库存不足，-2:下架;-3:处方药;-4:商品数大于促销;-5:已经购买过该促销商品的促销个数;-99:内部错误
		long result = 0;
		if(arg==null){
			return 0;
		}
		TGoods goods = tgoodsdao.selectByPrimaryKey(arg.getGoodsId());
		if(goods==null){
			return 0L;
		}
		if (goods.getType() == 3 || goods.getType() == 2) { // 处方药B||处方药A
			return -3l;
		}
		//-1:库存不足，-2:下架;-3:处方药;-4:商品数大于促销;-5:已经购买过该促销商品的促销个数
		YktGoodsExample yktGoodsExample = new YktGoodsExample();
		yktGoodsExample.createCriteria().andGoodsNoEqualTo(goods.getGoodsno());
		Integer yktGoodsCount = yktgoodsdao.countByExample(yktGoodsExample);
		Integer yktGoods = (yktGoodsCount==null||yktGoodsCount<=0)?0:1;
		TGoodsPriceExample tGoodsPriceExample = new TGoodsPriceExample();
		tGoodsPriceExample.createCriteria().andGoodsIdEqualTo(goods.getId()).andPriceTypeEqualTo("pc");
		List<TGoodsPrice> tGoodsPricesList = tgoodspricedao.selectByExample(tGoodsPriceExample);
		if(tGoodsPricesList!=null && tGoodsPricesList.size()>0){
			TGoodsPrice tGoodsPrice = tGoodsPricesList.get(0);
			if(tGoodsPrice.getStatus()!=null && tGoodsPrice.getStatus()==2){
				return -2l;//pc下架
			}
		}
//		if (goods.getAppStatus() == 2) { // app下架
//			return -200l;
//		}
		
		Map<String, Object> cuxiaoParam = new HashMap<String, Object>();
		cuxiaoParam.put("goodId", arg.getGoodsId());
		cuxiaoParam.put("nowDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		//查询商品是否存在促销,存在的话促销限制个数
		Map<String, Object>  limitCountMap = (Map<String, Object>) opensqldao.selectForObjectByMap(cuxiaoParam, "t_cart_item.selectCuxiaoByGoodId");
		Long cartId = null;
		Integer orderItemNum = 0;//促销范围内,订单里已买个数
		if(arg.isIslogin()){
			if(limitCountMap!=null&&limitCountMap.get("startTime")!=null&&limitCountMap.get("endTime")!=null){
				Map<String, Object> orderMap = new HashMap<String, Object>();
				orderMap.put("startTime", limitCountMap.get("startTime").toString());
				orderMap.put("endTime", limitCountMap.get("endTime").toString());
				orderMap.put("goodId", arg.getGoodsId());
				orderMap.put("memberId", arg.getUserId());
				orderItemNum = (Integer) opensqldao.selectForObjectByMap(orderMap, "t_order_item.selectTOrderItemByCart");
				if(orderItemNum==null){
					orderItemNum = 0;
				}
			}else{
				orderItemNum = 0;
			}
		}else{
			orderItemNum = 0;
		}
		if(arg.isIslogin()){//登录过的
			TCartExample _TCartExample = new TCartExample();
			_TCartExample.createCriteria().andMemberIdEqualTo(arg.getUserId());
			List<TCart> cartList = tcartdao.selectByExample(_TCartExample);
			TCart tCart = null;
			if(cartList==null||cartList.size()<=0){
				tCart = new TCart();
				tCart.setCreateTime(new Date());
				tCart.setMemberId(arg.getUserId());
				cartId = tcartdao.insertSelective(tCart);
			}else{
				tCart = cartList.get(0);
				cartId = tCart.getId();
			}
		}else{//未登录
			TCartExample tCartExample = new TCartExample();
			tCartExample.createCriteria().andCartKeyEqualTo(arg.getCartkey());
			List<TCart> tcartList = tcartdao.selectByExample(tCartExample);
			if(tcartList==null||tcartList.size()<=0){//不存在,添加购物车,购物车项
				TCart tCart = new TCart();
				tCart.setCartKey(arg.getCartkey());
				tCart.setCreateTime(new Date());
				tCart.setMemberId(null);
				cartId = tcartdao.insertSelective(tCart);
			}else{
				cartId = tcartList.get(0).getId();
			}
		}
		TCartItemExample itemExample = new TCartItemExample();
		itemExample.createCriteria().andCartIdEqualTo(cartId).andGoodsIdEqualTo(arg.getGoodsId());
		List<TCartItem> itmList = tcartitemdao.selectByExample(itemExample);
		Integer ii = 0;
		if(itmList!=null&&itmList.size()>0){
			ii = itmList.get(0).getQuantity();
		}
//		Integer ii = tcartitemdao.countByExample(itemExample);
		if(ii==null){
			ii=0;
		}
		if((count+ii)>cartMaxNum){
			return -7;
		}
		if (goods.getStock() < (count+Long.valueOf(ii))) { // 库存不足
			return -1l;
		}
		if(limitCountMap==null||limitCountMap.get("limitCount")==null|| "".equals(limitCountMap.get("limitCount"))){//不存在促销
			//根据uuid查询购物车是否存在,
			TCartItemExample _TCartItemExample = new TCartItemExample();
			_TCartItemExample.createCriteria().andCartIdEqualTo(cartId).andGoodsIdEqualTo(arg.getGoodsId());
			List<TCartItem> itemsList = tcartitemdao.selectByExample(_TCartItemExample);
			TCartItem cartItem = null;
			if(itemsList==null||itemsList.size()<=0){
				cartItem = new TCartItem();
				cartItem.setCreateTime(new Date());
				cartItem.setQuantity(count);
				cartItem.setGoodsId(arg.getGoodsId());
				cartItem.setCartId(cartId);
				cartItem.setIsSelected(1);
				cartItem.setIfPremiums(0);
				cartItem.setIsYktGood(yktGoods);
				result = tcartitemdao.insertSelective(cartItem);
			}else{
				cartItem = itemsList.get(0);
				cartItem.setQuantity(cartItem.getQuantity()==null?count:cartItem.getQuantity()+count);
				result = tcartitemdao.updateByPrimaryKeySelective(cartItem);
			}
		}else{//促销中的
			//限购数量
			Integer limit = Integer.valueOf(limitCountMap.get("limitCount").toString());
			if(count>limit){//商品数大于促销,提示
				return -4L;
			}else{//不大于促销,再判断这个购物车里这个商品的个数
				Map<String, Object> numParam = new HashMap<String, Object>();
				numParam.put("goodId", arg.getGoodsId());
				numParam.put("cartId", cartId);
				//根据商品id、购物车id查询该用户(游客)购物车里该商品个数
				Integer cartitemNum = (Integer) opensqldao.selectForObjectByMap(numParam, "t_cart_item.selectCartitemNumByCidGid");
				if(cartitemNum==null||"".equals(cartitemNum)||cartitemNum<=0){
					cartitemNum=0;
				}
				if(count<=limit-cartitemNum-orderItemNum){//添加数量符合,可以购买
					TCartItemExample _TCartItemExample = new TCartItemExample();
					_TCartItemExample.createCriteria().andCartIdEqualTo(cartId).andGoodsIdEqualTo(arg.getGoodsId());
					List<TCartItem> _List = tcartitemdao.selectByExample(_TCartItemExample);
					if(_List==null||_List.size()<=0){
						TCartItem cartItem = new TCartItem();
						cartItem.setCreateTime(new Date());
						cartItem.setQuantity(count);
						cartItem.setGoodsId(arg.getGoodsId());
						cartItem.setCartId(cartId);
						cartItem.setIsSelected(1);
						cartItem.setIfPremiums(0);
						cartItem.setIsYktGood(yktGoods);
						result = tcartitemdao.insertSelective(cartItem);
					}else{
						TCartItem _TCartItem = _List.get(0);
						_TCartItem.setQuantity(_TCartItem.getQuantity()==null?count:_TCartItem.getQuantity()+count);
						result = tcartitemdao.updateByPrimaryKeySelective(_TCartItem);
					}
					return result;
				}else if(orderItemNum>0&&cartitemNum>0){
					return -4l;//该商品正促销中，超出了购买数量
				}else if(orderItemNum>0&&cartitemNum<=0){
					//0:参数错误;-1:库存不足，-2:下架;-3:处方药;-4:商品数大于促销;-5:已经购买过该促销商品的促销个数;-99:内部错误
					return -5l;//您已经购买过该促销商品了
				}else{
					return -4l;//该商品正促销中，超出了购买数量
				}
			}
		}
		return result;
	}

	/**
	 * 建龙购物车逻辑(20160420WWF废弃)
	 * @deprecated
	 * @param arg
	 * @param count
	 * @return
	 * @throws SQLException
	 */
//	@Override
	public long addCart_old(CartParam arg,int count) throws SQLException {
		
		
		TGoods goods = tgoodsdao.selectByPrimaryKey(arg.getGoodsId());
		
		Map map = new HashMap();
		map.put("goodsid", arg.getGoodsId());
		GoodsPrice o = new GoodsPrice(); 
		
		BigDecimal wapPrice = null;
		TGoodsPriceExample wapTGoodsPriceExample = new TGoodsPriceExample();
		wapTGoodsPriceExample.createCriteria().andGoodsIdEqualTo(goods.getId()).andPriceTypeEqualTo("wap");
		List<TGoodsPrice> wapTGoodsPricesList = tgoodspricedao.selectByExample(wapTGoodsPriceExample);
		if(wapTGoodsPricesList != null && wapTGoodsPricesList.size()>0){
			TGoodsPrice tPrice = wapTGoodsPricesList.get(0);
			wapPrice = tPrice.getPrice();
		}
		
		
		o.setWap_price(wapPrice);
		o.setStock((int)goods.getStock().longValue());
		
		if(goods.getType()==3||goods.getType()==2){	// 处方药B||处方药A 
			
			return -100;
		}
		
		
		TGoodsPriceExample tGoodsPriceExample = new TGoodsPriceExample();
		tGoodsPriceExample.createCriteria().andGoodsIdEqualTo(goods.getId()).andPriceTypeEqualTo("pc");
		List<TGoodsPrice> tGoodsPricesList = tgoodspricedao.selectByExample(tGoodsPriceExample);
		if(tGoodsPricesList!=null && tGoodsPricesList.size()>0){
			TGoodsPrice tGoodsPrice = tGoodsPricesList.get(0);
			if(tGoodsPrice.getStatus()!=null && tGoodsPrice.getStatus()==2){
				return -200l;//pc下架
			}
		}
//		if(goods.getWapStatus()==2){	// wap下架
//			return -200;
//		}
		
		if(arg.isIslogin())
		{
			// 已经购买过促销的该商品
			 Map m = new HashMap();
			 m.put("userid", arg.getUserId());
			 List<Map> promInOrderList = opensqldao.selectForListByMap(m, "mycart.order_in_cart");
			 long isprom = 0;
			 long gid = 0;
			 for(Map omp : promInOrderList)
			 {
				 gid = (Long)omp.get("goods_id");
			     if(gid==goods.getId()){
			    	 return -300;
			     }
						 
			 }
		}
		
		 
		
		
		// 判断库存是否充足(与购物国的的商品数对比)
		TCart cart = getCart(arg);
		
		if(cart!=null)
		{
			TCartItemExample cie = new TCartItemExample();
			cie.createCriteria().andCartIdEqualTo(cart.getId()).andGoodsIdEqualTo(arg.getGoodsId());
			List<TCartItem> l = tcartitemdao.selectByExample(cie);
			TPromotion prom = cartdao.getPromByGoods(arg.getGoodsId());
			if(l.size()>0)
			{
				TCartItem item = l.get(0);
				int newcount = item.getQuantity()+count;
				
				if(prom!=null && prom.getType()==1)
				{  
					TPromItemExample example = new TPromItemExample();
					example.createCriteria().andPidEqualTo(prom.getId()).andTargetIdEqualTo(arg.getGoodsId());
					List<TPromItem> itemList = tpromitemdao.selectByExample(example);
					if(itemList.size()>0)
					{
						TPromItem promItem = itemList.get(0);
						if(newcount>promItem.getLimitCount().intValue()){ // 该商品正在做单品促销，超过了限制数量
							return -3;
						}
					}
				}
			
				if(o.getStock()<newcount){
					return -2; 
				}
			}else{
				
				int newcount = count;
				if(prom!=null && prom.getType()==1)
				{  
					TPromItemExample example = new TPromItemExample();
					example.createCriteria().andPidEqualTo(prom.getId()).andTargetIdEqualTo(arg.getGoodsId());
					List<TPromItem> itemList = tpromitemdao.selectByExample(example);
					if(itemList.size()>0)
					{
						TPromItem promItem = itemList.get(0);
						if(newcount>promItem.getLimitCount().intValue()){ // 该商品正在做单品促销，超过了限制数量
							return -3;
						}
					}
				}
			
				if(o.getStock()<newcount){
					return -2; 
				}
				
			}
			
		}else{
			if(o.getStock()<count){
				return -2; 
			}
		}
		
		
		long dstCartId = 0 ;  // 购物车主表的ID
		if(cart==null)
		{
			
			TCart dstCart = new TCart();
			dstCart = new TCart();
			dstCart.setCreateTime( new Date() );
			if(arg.isIslogin()){
				dstCart.setMemberId(arg.getUserId());
			}else{
				dstCart.setMemberId(null);
			}
			dstCart.setCartKey(arg.getCartkey());
			dstCartId = tcartdao.insertSelective(dstCart);
		}else{
			dstCartId = cart.getId();
		}
		
		long dstCartItemId = 0;
		if(dstCartId>0)
		{
			
			// 无查是否已经加过，如果没有加过，直接插入一条，如果加了，改变数量
			TCartItemExample  dstcartitemexample = new TCartItemExample();
			dstcartitemexample.createCriteria().andGoodsIdEqualTo(arg.getGoodsId()).andCartIdEqualTo(dstCartId);
			List<TCartItem> dstCartItemList = tcartitemdao.selectByExample(dstcartitemexample);
			
			if(dstCartItemList.size()>0){
				TCartItem item = dstCartItemList.get(0);
				item.setQuantity(item.getQuantity()+count);
				item.setIsSelected(1);
				dstCartItemId = tcartitemdao.updateByPrimaryKeySelective(item);
			}else{
				// dst_cart_item表插入数据
				TCartItem dstCartItem = new TCartItem();
				dstCartItem.setCreateTime(new Date());
				dstCartItem.setQuantity(count);
				dstCartItem.setGoodsId(arg.getGoodsId());
				dstCartItem.setCartId(dstCartId);
				dstCartItem.setIsSelected(1);
				dstCartItem.setIfPremiums(0);
				
				// 限购数量限制
				
				TPromotion prom = cartdao.getPromByGoods(arg.getGoodsId());
				if(prom!=null && prom.getType()==1)
				{  
					TPromItemExample example = new TPromItemExample();
					example.createCriteria().andPidEqualTo(prom.getId()).andTargetIdEqualTo(arg.getGoodsId());
					List<TPromItem> itemList = tpromitemdao.selectByExample(example);
					if(itemList.size()>0)
					{
						TPromItem promItem = itemList.get(0);
						if(count>promItem.getLimitCount().intValue()){ // 该商品正在做单品促销，超过了限制数量
							return -3;
						}
					}
				}
				
				
				dstCartItemId = tcartitemdao.insertSelective(dstCartItem);
			}
		}
		return dstCartItemId;
	}

	@Override
	public int removeGoodsFromCart(CartParam arg) throws SQLException {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("goods_id", arg.getGoodsId());
		if(arg.isIslogin()){
			map.put("userid", arg.getUserId());
		}else{
			map.put("uuid",arg.getCartkey());
		}
		return opensqldao.updateByMap_drug(map,"mycart.only-del-cart");
	}

	@Override
	public int batchRemoveGoodsFromCart(List<Long> list, CartParam arg) throws SQLException {
		StringBuilder sb = new StringBuilder(""); 
		for(long id : list){
			sb.append(id+",");
		}
		String collectId = sb.substring(0,sb.length()-1);
		Map<String,Object> map = new HashMap<String,Object>();
		if(arg.isIslogin()){
			map.put("userid", arg.getUserId());
		}else{
			map.put("uuid",arg.getCartkey());
		}
		map.put("product", collectId);
		int n = opensqldao.updateByMap_drug(map, "mycart.batch-del-cart");
		return n;
	}
	
	/**
	 * wwf20160420推翻重构
	 */
	public int updateGoodsCount(String cartItemid,String goodsid,int count,String flag) throws SQLException {
		//购物车项ID,商品ID,数量,增减标志(1 加  2 减  3输入数字修改)
		//1:是否是促销→否:改数量
				//	是:→是否登录:否:限购数量跟添加数量比较
							//是:添加数量跟(限购-订单已购-已加数量)
		
		//0:参数错误;-1:库存不足，-2:下架;-3:处方药;-4:商品数大于促销;-5:已经购买过该促销商品的促销个数;-6:剩一条不能在减了;-99:内部错误
		int result = 0;
		if(cartItemid==null||"".equals(cartItemid)){
			return result;
		}
		if(goodsid==null||"".equals(goodsid)){
			return result;
		}
		if(flag==null||"".equals(flag)){
			return result;
		}
		if(count<=0){
			return result;
		}
		
		TCartItem tCartItem = tcartitemdao.selectByPrimaryKey(Long.valueOf(cartItemid));
		if(tCartItem==null){
			return result;
		}
		TCart tCart = tcartdao.selectByPrimaryKey(tCartItem.getCartId());
		TGoods tGoods = tgoodsdao.selectByPrimaryKey(Long.valueOf(goodsid));
		if(tCartItem==null){
			return result;
		}
		if(tCart==null){
			return result;
		}
		if(tGoods==null){
			return result;
		}
		Map<String, Object> cuParam = new HashMap<String, Object>();
		cuParam.put("goodId", goodsid);
		cuParam.put("nowDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		Map<String, Object> limitMap = (Map<String, Object>) opensqldao.selectForObjectByMap(cuParam, "t_cart_item.selectCuxiaoByGoodId");
		if(tCartItem.getQuantity()==1&&"2".equals(flag)){//只有一个了,不能再减了
			return -6;
		}
		int newCount = tCartItem.getQuantity();//加减后的个数
		if("1".equals(flag)){//加
			newCount +=count;
		}else if("2".equals(flag)){
			newCount -=count;
		}else if("3".equals(flag)){
			newCount = count;
		}
		if(newCount>cartMaxNum){//
			newCount = cartMaxNum;
		}
		
		if(limitMap!=null&&limitMap.get("limitCount")!=null&&limitMap.get("startTime")!=null
				&&limitMap.get("endTime")!=null){//促销中
			Integer limit = (Integer) limitMap.get("limitCount");
			String startTime = limitMap.get("startTime").toString();
			String endTime = limitMap.get("endTime").toString();
			Integer orderItemNum = 0;//订单买过的
			
			//登录过得;
			if(tCart.getMemberId()!=null){
				Map<String, Object> orderMap = new HashMap<String, Object>();
				orderMap.put("startTime", startTime);
				orderMap.put("endTime", endTime);
				orderMap.put("goodId", tCartItem.getGoodsId());
				orderMap.put("memberId", tCart.getMemberId());
				orderItemNum = (Integer) opensqldao.selectForObjectByMap(orderMap, "t_order_item.selectTOrderItemByCart");
				if(orderItemNum==null||"".equals(orderItemNum)){
					orderItemNum = 0;
				}
				if(limit-orderItemNum<newCount){//已经超了
					return -3; 
				}else{
					tCartItem.setQuantity(newCount);
					tcartitemdao.updateByPrimaryKeySelective(tCartItem);
					result = count;
				}
				
			}else{//游客添加购物车,只判断:限制个数与(count+-已有的)
				if(newCount>limit){
					return -4;
				}else{
					tCartItem.setQuantity(newCount);
					tcartitemdao.updateByPrimaryKeySelective(tCartItem);
					result = count;
				}
			}
		}else{//非促销
			if(newCount>tGoods.getStock()){//库存不足
				return -1;
			}else{
				tCartItem.setQuantity(newCount);
				tcartitemdao.updateByPrimaryKeySelective(tCartItem);
				result = count;
			}
		}
		return result;
	}

	/**
	 * wwf于20160420废弃
	 * @deprecated
	 * @param cartid
	 * @param goodsid
	 * @param count
	 * @param flag
	 * @return
	 * @throws SQLException
	 */
//	@Override
	public int updateGoodsCount_old(String cartid,String goodsid,int count,String flag) throws SQLException {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", cartid);
		map.put("goodsid", goodsid);
		map.put("flag", flag); // 1 加  2 减  3输入数字修改
		map.put("quantity", count); // flag=3时使用
		int up = 0;
		// 查询购物车中的具体的某一个商品
//		TCartItem cartItem = (TCartItem) opensqldao.selectForObjectByMap(map, "mycart.get-cart-product");
		TCartItem item = tcartitemdao.selectByPrimaryKey(Long.parseLong(cartid));
		if(item!=null) {
			if("2".equals(flag)){ // 减数量
				if(item.getQuantity()==1){  // 如果 购物车中只有一个
					return -1;
				}
			}else if("1".equals(flag) || "3".equals(flag)){	// 加数量 
				GoodsPrice o = (GoodsPrice) opensqldao.selectForObjectByMap(map, "mycart.get-goods-price");
				// 判断库存是否充足(与购物国的的商品数对比)
				int newcount = item.getQuantity()+count;
				TPromotion prom = cartdao.getPromByGoods(Long.parseLong(goodsid));
				if(prom!=null && prom.getType()==1) {  
					TPromItemExample example = new TPromItemExample();
					example.createCriteria().andPidEqualTo(prom.getId()).andTargetIdEqualTo(Long.parseLong(goodsid));
					List<TPromItem> itemList = tpromitemdao.selectByExample(example);
					if(itemList.size()>0) {
						TPromItem promItem = itemList.get(0);
						if(newcount>promItem.getLimitCount().intValue()){ // 该商品正在做单品促销，超过了限制数量
							return -3;
						}
					}else{
					
					}
				}
				if(o.getStock()<newcount){
					return -2; 
				}
			}
		}else if("3".equals(flag)){
			
		}
		up = opensqldao.updateByMap_drug(map, "mycart.alert-cart-count");
		return up;
	}

	@Override
	public int emptyCart(CartParam arg) throws SQLException {
		Map<String,Object> map = new HashMap<String,Object>();
		if(arg.isIslogin()){
			map.put("userid", arg.getUserId());
		}else{
			map.put("uuid",arg.getCartkey());
		}
		return opensqldao.updateByMap_drug(map, "mycart.empty-cart");
	}


	@Override
	public BigDecimal calculate(List<Long> goods) throws SQLException {
	    BigDecimal total = new BigDecimal(0);
	    GoodsPrice  gp = null;
	    for(long  id : goods){
	    	gp = cartdao.getGoodsPrice(id);
	    	if(gp!=null)
	    	total.add(gp.getPc_price());
	    }
		return total;
	}
	
	
	public Map<String,Object> accounts(CartParam arg) throws SQLException{
		Map<String, Object> map = cartdao.accounts(arg); 
		return map;
	}


	@Override
	public List<CartItem> getCartItem(CartParam arg) throws SQLException {
		List<CartItem> list = opensqldao.selectForListByMap(map, "mycart.get-cart-item");
		return list;
	}
	
	
	/**
	 * 
	 */
	public List<Map<String, Object>> jiesuanJudge(Long cartId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cartId", cartId);
		map.put("priceStatus", 2);//下架
		map.put("priceType", "pc");
		map.put("isSelected", 1);
		List<Map<String, Object>> result = (List<Map<String, Object>>) opensqldao.selectListByObject(map, "mycart.selectQuantityAndKucun");
		for (Map<String, Object> map2 : result) {
			if(map2!=null&&map2.get("itemId")!=null){
				TCartItem updateItem = new TCartItem();
				updateItem.setId(Long.valueOf(map2.get("itemId").toString()));
				updateItem.setIsSelected(0);
				int ii = tcartitemdao.updateByPrimaryKeySelective(updateItem);
				System.out.println(ii);
			}
		}
		return result;
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

	public OpenSqlDAO getOpensqldao() {
		return opensqldao;
	}

	public void setOpensqldao(OpenSqlDAO opensqldao) {
		this.opensqldao = opensqldao;
	}

	public TGoodsDAO getTgoodsdao() {
		return tgoodsdao;
	}

	public void setTgoodsdao(TGoodsDAO tgoodsdao) {
		this.tgoodsdao = tgoodsdao;
	}

	public TPromItemDAO getTpromitemdao() {
		return tpromitemdao;
	}

	public void setTpromitemdao(TPromItemDAO tpromitemdao) {
		this.tpromitemdao = tpromitemdao;
	}

	public TPromotionDAO getTpromotiondao() {
		return tpromotiondao;
	}

	public void setTpromotiondao(TPromotionDAO tpromotiondao) {
		this.tpromotiondao = tpromotiondao;
	}

	public TPromGiftDAO getTpromgiftdao() {
		return tpromgiftdao;
	}

	public void setTpromgiftdao(TPromGiftDAO tpromgiftdao) {
		this.tpromgiftdao = tpromgiftdao;
	}

	public CartDaoImpl getCartdao() {
		return cartdao;
	}

	public void setCartdao(CartDaoImpl cartdao) {
		this.cartdao = cartdao;
	}

	public TCartItemManager getTcartitemmanager() {
		return tcartitemmanager;
	}

	public void setTcartitemmanager(TCartItemManager tcartitemmanager) {
		this.tcartitemmanager = tcartitemmanager;
	}

	public TOrderDAO getTorderdao() {
		return torderdao;
	}

	public void setTorderdao(TOrderDAO torderdao) {
		this.torderdao = torderdao;
	}

	public TOrderItemDAO getTorderitemdao() {
		return torderitemdao;
	}

	public void setTorderitemdao(TOrderItemDAO torderitemdao) {
		this.torderitemdao = torderitemdao;
	}

//	public TGoodsManager getTgoodsmanager() {
//		return tgoodsmanager;
//	}
//
//	public void setTgoodsmanager(TGoodsManager tgoodsmanager) {
//		this.tgoodsmanager = tgoodsmanager;
//	}

	@Override
	public TPromotion getPromByGoods(long goodsid) throws SQLException {
		// TODO Auto-generated method stub
		return cartdao.getPromByGoods(goodsid);
	}

	public TGoodsPriceDAO getTgoodspricedao() {
		return tgoodspricedao;
	}

	public void setTgoodspricedao(TGoodsPriceDAO tgoodspricedao) {
		this.tgoodspricedao = tgoodspricedao;
	}

	public YktGoodsDAO getYktgoodsdao() {
		return yktgoodsdao;
	}

	public void setYktgoodsdao(YktGoodsDAO yktgoodsdao) {
		this.yktgoodsdao = yktgoodsdao;
	}


	
	/**
	 *  只/不选医卡通/全部
	 * @throws SQLException 
	 */
	@Override
	public Map<String,List<Long>> updateCheckStatus(Long cartId, Integer type) throws SQLException {
		TCart tCart = tcartdao.selectByPrimaryKey(cartId);
		if (tCart == null) {
			return null;
		}
		// 1:只选医卡通(选中);2:取消医卡通按钮(非选中状态);3:全部选中;4全部不选中;
		TCartItemExample tCartItemExample = new TCartItemExample();
		tCartItemExample.createCriteria().andCartIdEqualTo(cartId);
		List<TCartItem> itemList = tcartitemdao.selectByExample(tCartItemExample);
		List<Long> selectList = new ArrayList<Long>();
		List<Long> unselectList = new ArrayList<Long>();
		Map<String, List<Long>> result = new HashMap<String, List<Long>>();
		for (TCartItem tCartItem : itemList) {
			if (type==1) {//只选医卡通,医卡通的全选中,其他全不选
				if(tCartItem.getIsYktGood()==1){//非医卡通
					tCartItem.setIsSelected(1);
					selectList.add(tCartItem.getId());
				}else{
					tCartItem.setIsSelected(0);
					unselectList.add(tCartItem.getId());
				}
			}
			if (type==2) {//全不选医卡通
				if(tCartItem.getIsYktGood()==1){//非医卡通
					tCartItem.setIsSelected(0);
					unselectList.add(tCartItem.getId());
				}else{
//					tCartItem.setIsSelected(1);
//					selectList.add(tCartItem.getId());
				}
			}
			if (type==3) {//全选
				tCartItem.setIsSelected(1);
				selectList.add(tCartItem.getId());
			}
			if (type==4) {//全不选
				tCartItem.setIsSelected(0);
				unselectList.add(tCartItem.getId());
			}
			tcartitemdao.updateByPrimaryKeySelective(tCartItem);
		}
		result.put("check", selectList);
		result.put("uncheck", unselectList);
		return result;
	}


	/**
	 * 是否全是医卡通/全部
	 * return int 返回值:0:医卡通不选全部选,1:医卡通选;2:全选
	 */
	@Override
	public int ifYktOrAll(CartParam arg) throws SQLException {
		int result = 0;
		Map<String, Object> map = new HashMap<String,Object>();
		if(arg.isIslogin()){
			map.put("userid", arg.getUserId());
		}else{
			map.put("cartKey", arg.getCartkey());
		}
		List<Map<String, Object>> list = (List<Map<String, Object>>) opensqldao.selectListByObject(map, "mycart.selectIfYktOrAll");
		int yktCount = 0;//选中医卡通
		int allCount = 0;
		int notyktCount = 0;//非选中医卡通个数
		Long cartId = 0L;
		if(list!=null&&list.size()>0){
			cartId = (Long) list.get(0).get("id");
		}
		for (Map<String, Object> map2 : list) {
			if(map2.get("is_selected")!=null&&map2.get("is_ykt_good")!=null){
				Integer selected = (Integer) map2.get("is_selected");
				Long ykt = (Long) map2.get("is_ykt_good");
				System.out.println(selected+"--->"+ykt);
				//00;01;10;11
				if(selected==0&&ykt==0){//00;非选中,非医卡通
				}else if(selected==0&&ykt==1l){//01,非选中,医卡通
					notyktCount += 1;
//					break;
				}else if(selected==1&&ykt==0l){//10,选中,非医卡通
					allCount += 1;
				}else if(selected==1&&ykt==1l){//11;选中,医卡通
					yktCount += 1;
					allCount += 1;
				}
			}
		}
		TCartItemExample yktExample = new TCartItemExample();
		yktExample.createCriteria().andIsYktGoodEqualTo(1).andCartIdEqualTo(cartId);
		Integer ykt = tcartitemdao.countByExample(yktExample);
		System.out.println("总数:"+list.size()+"\t\t选中总数"+allCount);
		System.out.println("医卡通总数:"+ykt+"\t\tykt选中总数:"+yktCount+"\t\tnoYkt总数"+notyktCount);
		if(ykt!=null&&yktCount==ykt&&notyktCount<=0){//
			result = 1;
		}
		if(allCount==list.size()){//全选
			result = 2;
		}
		return result;
	}

}
