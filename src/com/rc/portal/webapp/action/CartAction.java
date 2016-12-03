package com.rc.portal.webapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.portal.service.ICartManager;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TCartItemManager;
import com.rc.portal.service.TCartManager;
import com.rc.portal.service.TGoodsManager;
import com.rc.portal.service.TGroupGoodsManager;
import com.rc.portal.service.TMemberCollectManager;
import com.rc.portal.util.cookieManager;
import com.rc.portal.vo.TCart;
import com.rc.portal.vo.TCartExample;
import com.rc.portal.vo.TCartItem;
import com.rc.portal.vo.TCartItemExample;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberCollect;
import com.rc.portal.webapp.model.cart.CartItem;
import com.rc.portal.webapp.model.cart.CartParam;
import com.rc.portal.webapp.model.cart.CartSum;

public class CartAction extends BaseAction {
	
	private static final long serialVersionUID = -8356530130533759951L;
	private ICartManager cartmanager;
	private OpenSqlManage opensqlmanage;
	private TCartItemManager tcartitemmanager;
	private TMemberCollectManager tmembercollectmanager;
	private TGoodsManager tgoodsmanager;
	private TGroupGoodsManager tgroupgoodsmanager;
	public static String cartKey = "111yao";
	
	private TCartManager tcartmanager;
	
	private CartParam arg = new CartParam();
	
	/**
	 * 只选择医卡通商品
	 * 
	 * @throws IOException
	 * @throws SQLException 
	 * @throws NumberFormatException 
	 */
	public void chooseYKT() throws IOException, NumberFormatException, SQLException {
		PrintWriter out = this.getResponse().getWriter();
		// 1:只选医卡通(选中);2:取消医卡通按钮(非选中状态);3:全部选中;4全部不选中;
		String type = this.getRequest().getParameter("type");
		String cartId = this.getRequest().getParameter("cartId");
		if (cartId == null || "".equals(cartId)) {// 为空
			return;
		}
		if (type == null || "".equals(type)) {
			type = "3";// 默认全选
		}
		Map<String,List<Long>> resultMap = cartmanager.updateCheckStatus(Long.valueOf(cartId),Integer.valueOf(type));
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", "1");
		result.put("check", resultMap.get("check"));
		result.put("uncheck", resultMap.get("uncheck"));
		JSONObject json = JSONObject.fromObject(result);
		out.print(json);
		out.close();
	}
	
	
	
	
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString().toUpperCase();
		System.out.println(uuid);
	}
	
	
	public void getCartSum() throws IOException, SQLException{
		HttpServletResponse reponse = this.getResponse();
	    reponse.setContentType("text/html;charset=utf-8");
	    PrintWriter out = reponse.getWriter();
		String key = cookieManager.getCookieValueByName(this.getRequest(), CartAction.cartKey);
		System.out.println("getcartsum = "+key);
		TMember user = (TMember) this.getSession().getAttribute("member");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uuid", key);
		if(user!=null){
			map.put("userid", user.getId());
		}
//		if(user!=null){
//			System.out.println("同步.......");
//			System.out.println("用户ID="+user.getId());
//		}
		map.put("priceType", "pc");
		List<Map<String,Object>> list = opensqlmanage.selectForListByMap(map, "mycart.get-cart-item");
		int cnt = 0;
		for(Map<String,Object> m : list){
			cnt = cnt + ((Integer)m.get("quantity"));
		}
//		System.out.println("cnt----------->"+cnt);
		if(user!=null){
			arg.setUserId(user.getId());
			arg.setIslogin(true);
		}else{
			if(key==null || "null".equals(key) || "".equals(key)){	// 客户端 已经存在一个key
				arg.setCartkey(createKey());
			}else{
				arg.setCartkey(key);
			}
			arg.setIslogin(false);
		}
		Map<String,Object> mp = cartmanager.accounts(arg);
		BigDecimal money = (BigDecimal) mp.get("money");
		BigDecimal youhui = (BigDecimal) mp.get("youhui");
		CartSum cs = new CartSum();
		cs.setCnt(cnt);
		cs.setList(list);
		cs.setYouhui(youhui);
		cs.setZongjia(money);
		JSONObject json = JSONObject.fromObject(cs);
		out.print(json.toString());
		out.close();
	}
	
	public void recommend() throws IOException{
		PrintWriter out = this.getResponse().getWriter();
		String key = cookieManager.getCookieValueByName(this.getRequest(), cartKey);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("key", key);
		List<HashMap<String,Object>> list = opensqlmanage.selectForListByMap(map, "mycart.cart-recommend");
		JSONArray json = JSONArray.fromObject(list);
		out.print(json.toString());
		out.close();
	}
	

	
   public String createKey(){
    	return UUID.randomUUID().toString().toUpperCase();
   }
	    
   
   
	/**
	 * 再次购买
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public String rebuy() throws NumberFormatException, SQLException {
		String orderid = this.getRequest().getParameter("orderid");
		if(orderid!=null&& !"".equals(orderid)){
			cartmanager.againBuy(Long.parseLong(orderid));
		}
		return "rebuy";
	}	   
	   
	public void addCart() throws SQLException, IOException{
//		this.getResponse().setContentType("text/html");
		Map<String,Object> rs = new HashMap<String,Object>();
		
		PrintWriter out = this.getResponse().getWriter();
		String gid = this.getRequest().getParameter("gid");
		String cnt = this.getRequest().getParameter("cnt");
		String key = cookieManager.getCookieValueByName(this.getRequest(), cartKey);
		if(gid==null||"".equals(gid)||cnt==null||"".equals(cnt)){
			writeObjectToResponse("参数有误", ContentType.text_html);
			return;
		}
		int count = 1;
		if(cnt!=null && !"0".equals(cnt) && !"".equals(cnt)){
			count = Integer.parseInt(cnt);
		}
		arg = new CartParam();
		
		TMember user = (TMember) this.getSession().getAttribute("member");
		if(user!=null){
			arg.setUserId(user.getId());
			arg.setIslogin(true);
		}else{
			arg.setIslogin(false);
			if(key==null){	// 客户端 已经存在一个key
				key = createKey();
			}
			arg.setCartkey(key);
			cookieManager.addCookie(this.getRequest(), this.getResponse(), cartKey, key, 1000000);
		}
		// arg.setCartkey(key);
		arg.setGoodsId(Long.parseLong(gid));
		
//		TGoods goods = tgoodsmanager.selectByPrimaryKey(Long.parseLong(gid));
		long id = 0;
//		if(goods.getIsSuit()==1){	// 如果是套装
//			TGroupGoodsExample example = new TGroupGoodsExample();
//			example.createCriteria().andGroupIdEqualTo(Long.parseLong(gid));
//			List<TGroupGoods> list = tgroupgoodsmanager.selectByExample(example);
//			for(TGroupGoods t : list){
//				arg.setGoodsId(t.getGoodsid());
//				id = cartmanager.addCart(arg,t.getGoodsNum());
//			}
//		}else{	// 正常商品
//			id = cartmanager.addCart(arg,count);
//		}
		
		//pc端状态以这些为准,不够依次往下加;(WWF20160510)
		//0:参数错误;-1:库存不足，-2:下架;-3:处方药;-4:商品数大于促销;-5:已经购买过该促销商品的促销个数;-6:剩一条不能在减了;-99:内部错误
		//-7:单品不能超过199个
		id = cartmanager.addCart(arg,count);
		
		rs.put("status",id);
		rs.put("key", key);
		JSONObject json = JSONObject.fromObject(rs);
		out.print(json.toString());
		out.close();
	}
	
	
	/*public String getCart() throws SQLException{
		
		String cookie = cookieManager.getCookieValueByName(this.getRequest(), "111yao");
		
		System.out.println("cookie==============="+cookie);
		
		String key = this.getRequest().getParameter("key");
		arg.setCartkey(key);
		TMember user = (TMember) this.getSession().getAttribute("member");
		if(user!=null){
			arg.setUserId(user.getId());
			arg.setIslogin(true);
		}
		TCart c = cartmanager.getCart(arg);
		this.getRequest().setAttribute("cart", c);
		return "cart-detail";
	}*/
	
	public void checked() throws IOException, SQLException{
		
		PrintWriter out = this.getResponse().getWriter();
		String flag= this.getRequest().getParameter("x");  // 1选中 0不选中
		String id = this.getRequest().getParameter("id");
//		CartParam arg = nRew CartParam();
//		cartmanager.updateGoodsCount(arg, flag);
		String key = cookieManager.getCookieValueByName(this.getRequest(), cartKey);
		
		arg = new CartParam();
		TMember user = (TMember) this.getSession().getAttribute("member");
		if(user!=null){
			arg.setUserId(user.getId());
			arg.setIslogin(true);
		}else{
			arg.setIslogin(false);
			if(key==null){	// 客户端 已经存在一个key
				key = createKey();
			}
			arg.setCartkey(key);
		}
		// arg.setCartkey(key);
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("flag", flag);
		int n = opensqlmanage.updateByMap_drug(map, "mycart.check-cart-item");
		
		
		//:0:医卡通不选全部选,1:医卡通选;2:全选
		int ifYkt = cartmanager.ifYktOrAll(arg);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", n);
		result.put("ifYkt", ifYkt);
		JSONObject json = JSONObject.fromObject(result);
		
		out.print(json.toString());
		out.close();
		
	}
	
	
	public void allChecked() throws IOException, SQLException{
		
		PrintWriter out = this.getResponse().getWriter();
		String flag= this.getRequest().getParameter("x");  // 1选中 0不选中
		String id = this.getRequest().getParameter("id");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("flag", flag);
		int n = opensqlmanage.updateByMap_drug(map, "mycart.all-check-cart-item");
		
		out.print(n);
		out.close();
	}
	
	
	public void del() throws IOException, NumberFormatException, SQLException{
		this.getResponse().setContentType("text/html");
		PrintWriter out = this.getResponse().getWriter();
		String id = this.getRequest().getParameter("id");
		tcartitemmanager.deleteByPrimaryKey(Long.parseLong(id));
		out.print(1);
		out.close();
	}
	
	
	public void collect() throws IOException, NumberFormatException, SQLException{
		
		PrintWriter out = this.getResponse().getWriter();
		String cartid = this.getRequest().getParameter("cartid");
		String goodsid = this.getRequest().getParameter("goodsid");
		

		TMember user = (TMember) this.getSession().getAttribute("member");
		
		TMemberCollect record = new TMemberCollect();
		record.setRelevanceId(Long.parseLong(goodsid));
		record.setMemberId(user.getId());
		record.setCollectType(0);
		record.setCreateDate(new Date());
		long a = tmembercollectmanager.insert(record);
		int n = 0;
		if(a>0){
			n = tcartitemmanager.deleteByPrimaryKey(Long.parseLong(cartid));
		}
		out.print(1);
		out.close();
	}
	

	public void isLogin() throws IOException{
		
		PrintWriter out = this.getResponse().getWriter();
		TMember user = (TMember) this.getSession().getAttribute("member");
		int n= 1;
		if(user==null){
			n = 0;
		}
		out.print(n);
		out.close();
		
	}
	
	
	public String page() throws SQLException{

//		String key = this.getRequest().getParameter("key");
		

		String key = cookieManager.getCookieValueByName(this.getRequest(), cartKey);
		
		if("null".equals(key) || key==null){
			key = cookieManager.getCookieValueByName(this.getRequest(), cartKey);
		}
		System.out.println("cookie==============="+key);
		TMember user = (TMember) this.getSession().getAttribute("member");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uuid", key);
		if(user!=null){
			map.put("userid", user.getId());
		}
		List<CartItem> list = new ArrayList<CartItem>();
		
		map.put("priceType", "pc");
		list = opensqlmanage.selectForListByMap(map, "mycart.get-cart-item");
		this.getRequest().setAttribute("l", list);
		TCartExample tCartExample = new TCartExample();
		TCart tCart = null;
		List<TCart> tCartList = null;
		if(user!=null){
			tCartExample.createCriteria().andMemberIdEqualTo(user.getId());
			tCartList = tcartmanager.selectByExample(tCartExample);
		}else if(key!=null&&!"".equals(key)){
			tCartExample.createCriteria().andCartKeyEqualTo(key);
			tCartList = tcartmanager.selectByExample(tCartExample);
		}
		if(tCartList!=null&&tCartList.size()>0){
			tCart = tCartList.get(0);
		}
		this.getRequest().setAttribute("tcart", tCart);
		if(user!=null){
			arg.setUserId(user.getId());
			arg.setIslogin(true);
		}else{
			arg.setIslogin(false);
			if(key==null){	// 客户端 已经存在一个key
				key = createKey();
			}
			arg.setCartkey(key);
		}
		//:0:医卡通不选全部选,1:医卡通选;2:全选
		int ifYkt = cartmanager.ifYktOrAll(arg);
		this.getRequest().setAttribute("ifYkt", ifYkt);
		return "cart-page";
	}
	
	//异步获取购物车列表
	public void getCartList() throws SQLException
	{
		String key = cookieManager.getCookieValueByName(this.getRequest(), cartKey);
		if("null".equals(key) || key==null)
		{
			key = cookieManager.getCookieValueByName(this.getRequest(), cartKey);
		}
		TMember user = (TMember) this.getSession().getAttribute("member");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uuid", key);
		if(user != null)
		{
			map.put("userid", user.getId());
		}
		List<CartItem> list = new ArrayList<CartItem>();
		list = opensqlmanage.selectForListByMap(map, "mycart.get-cart-item");
		writeObjectToResponse(list, ContentType.application_json);
	}
	
	public void update() throws IOException, SQLException{
		
		PrintWriter out = this.getResponse().getWriter();
		String cartid = this.getRequest().getParameter("cartid");
		String flag = this.getRequest().getParameter("flag");
		String goodsid = this.getRequest().getParameter("goodsid");
		String cnt = this.getRequest().getParameter("count");
		
		String key = cookieManager.getCookieValueByName(this.getRequest(), cartKey);
		
		Map<String,Object> rs = new HashMap<String,Object>();
		int count = 1;
		
		if(cnt!=null && !"".equals(cnt)){
			count = Integer.parseInt(cnt);
		}
		if(cartid==null||"".equals(cartid)){
			rs.put("data",0);
			JSONObject json = JSONObject.fromObject(rs);
			writeObjectToResponse(json.toString(), ContentType.application_json);
			return;
		}
		
		TCartItem _item = tcartitemmanager.selectByPrimaryKey(Long.valueOf(cartid));
		if(_item==null){
			rs.put("data",-100);
			JSONObject json = JSONObject.fromObject(rs);
			writeObjectToResponse(json.toString(), ContentType.application_json);
			return;
		}
		
		
		int n = cartmanager.updateGoodsCount(cartid,goodsid.trim(),count,flag);
		
		if(n>0){	// 操作成功 
			CartParam arg = new CartParam();
			arg.setCartkey(key);
			TMember user = (TMember) this.getSession().getAttribute("member");
			if(user!=null){
				arg.setUserId(user.getId());
				arg.setIslogin(true);
			}else{
				if("null".equals(key) || key==null){	// 客户端 已经存在一个key
					arg.setCartkey(createKey());
				}else{
					arg.setCartkey(key);
				}
				arg.setIslogin(false);
			}
			
			//rs = cartmanager.accounts(arg);
		}else{
			if(n==-1){		// 购物车中只剩下一个商品了，不能做再减动作
				
			}else if(n==-2){	// 库存不足
				
			}else if(n==-3){	// 该商品正在做单品促销，超过了限制数量
				 
			}
			TCartItem item = tcartitemmanager.selectByPrimaryKey(Long.parseLong(cartid));
			rs.put("cnt", item==null?1:item.getQuantity());
		}
		
		System.out.println("update n = "+n);
		
		rs.put("data",n);
		JSONObject json = JSONObject.fromObject(rs);
		out.print(json.toString());
		out.close();
		
	}
	
	public void batchDelete() throws SQLException, IOException{
		
		PrintWriter out = this.getResponse().getWriter();
		String idstr = this.getRequest().getParameter("str");
		List<Long> l = new ArrayList<Long>();
		String[] array = idstr.split(",");
		for(String s : array){
			l.add(Long.parseLong(s));
		}
		TCartItemExample example = new TCartItemExample();
		example.createCriteria().andIdIn(l);
		int n = tcartitemmanager.deleteByExample(example);
		
		out.print(n);
		out.close();
	}
	
	
	
	public void money() throws IOException, SQLException{
		PrintWriter out = this.getResponse().getWriter();
//		String key = this.getRequest().getParameter("key");
		String key = cookieManager.getCookieValueByName(this.getRequest(), cartKey);
		System.out.println("money key = "+key);
		CartParam arg = new CartParam();
		arg.setCartkey(key);
		TMember user = (TMember) this.getSession().getAttribute("member");
		if(user!=null){
			arg.setUserId(user.getId());
			arg.setIslogin(true);
		}else{
			if("null".equals(key) || key==null){	// 客户端 已经存在一个key
				arg.setCartkey(createKey());
			}else{
				arg.setCartkey(key);
			}
			arg.setIslogin(false);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		if (arg.isIslogin()) {
		    map.put("userid", arg.getUserId());
		} else {
			map.put("key", arg.getCartkey());
		}
		Map<String,Object> rs = cartmanager.accounts(arg);
//		BigDecimal money = (BigDecimal)rs.get("money");
//		int count = (Integer)rs.get("count");
//		List<CartGift> giftList = (List<CartGift>)rs.get("gift");
		map.put("isSelected", 1);
	    int cnt = (Integer)opensqlmanage.selectForObjectByMap(map, "mycart.get-cart-sum");
		rs.put("count", cnt);
		JSONObject j = JSONObject.fromObject(rs);
		out.print(j.toString());
		out.close();
	}
	
	
	
	/**
	 * 点击结算判断
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws NumberFormatException 
	 */
	public void jiesuanJudge() throws IOException, NumberFormatException, SQLException{
		Map<String,Object> rs = new HashMap<String,Object>();
		PrintWriter out = this.getResponse().getWriter();
		String cartId = this.getRequest().getParameter("cartId");
		
		TCart tCart = tcartmanager.selectByPrimaryKey(Long.valueOf(cartId));
		if(tCart==null){//购物车为空
			rs.put("status", -1);//
		} else {
			List<Map<String, Object>> cartItemList = cartmanager.jiesuanJudge(tCart.getId());
			if (cartItemList == null || cartItemList.size() <= 0) {// 不存在库存不足,下架,处方药
				rs.put("status", 1);
			} else {//存在(库存不足,下架,处方药)
				rs.put("status", -2);
				rs.put("cartData", cartItemList);
				//{"stock":3,"status":1,"quantity":7,"is_suit":0,"itemId":8973}
			}
		}
		JSONObject json = JSONObject.fromObject(rs);
		
		System.out.println(json.toString());
		out.print(json.toString());
		out.close();
		
	}
	
	/**
	 * 推荐商品加入购物车,不刷新当前页面;
	 * @throws IOException 
	 */
	public void ajaxCartItemByGoodsId() throws IOException{
		Map<String,Object> rs = new HashMap<String,Object>();
		
		String goodId = this.getRequest().getParameter("goodsId");
		TMember user = (TMember) this.getSession().getAttribute("member");
		Map<String, Object> map = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String key = cookieManager.getCookieValueByName(this.getRequest(), cartKey);
		
		if(goodId!=null&&user!=null){
			param.put("memberId", user.getId());
			param.put("goodsId", goodId);
		}else if(goodId!=null&&key!=null){
			param.put("key", key);
			param.put("goodsId", goodId);
		}
		map = (Map<String, Object>) opensqlmanage.selectObjectByObject(param, "mycart.selectDataByUserIdGoodId");
		if(map==null){
			rs.put("status", 0);
			rs.put("dataItm", "");
		}else{
			rs.put("status", 1);
			rs.put("dataItm", map);
		}
		JSONObject json = JSONObject.fromObject(rs);
		this.writeObjectToResponse(json.toString(), ContentType.application_json);
//		System.out.println(json.toString());
//		out.print(json.toString());
//		out.close();
	}
	

	public ICartManager getCartmanager() {
		return cartmanager;
	}


	public void setCartmanager(ICartManager cartmanager) {
		this.cartmanager = cartmanager;
	}


	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}


	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}


	public TCartItemManager getTcartitemmanager() {
		return tcartitemmanager;
	}


	public void setTcartitemmanager(TCartItemManager tcartitemmanager) {
		this.tcartitemmanager = tcartitemmanager;
	}


	public TMemberCollectManager getTmembercollectmanager() {
		return tmembercollectmanager;
	}


	public void setTmembercollectmanager(TMemberCollectManager tmembercollectmanager) {
		this.tmembercollectmanager = tmembercollectmanager;
	}

	
	
	@Override
	public Object getModel() {
		return null;
	}

	@Override
	public void setModel(Object o) {

	}


	public TGoodsManager getTgoodsmanager() {
		return tgoodsmanager;
	}


	public void setTgoodsmanager(TGoodsManager tgoodsmanager) {
		this.tgoodsmanager = tgoodsmanager;
	}


	public TGroupGoodsManager getTgroupgoodsmanager() {
		return tgroupgoodsmanager;
	}

	public void setTgroupgoodsmanager(TGroupGoodsManager tgroupgoodsmanager) {
		this.tgroupgoodsmanager = tgroupgoodsmanager;
	}

	public TCartManager getTcartmanager() {
		return tcartmanager;
	}
	public void setTcartmanager(TCartManager tcartmanager) {
		this.tcartmanager = tcartmanager;
	}
	
	
}
