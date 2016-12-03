package com.rc.portal.webapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.springframework.util.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.openapi.dubbo.model.TOrderStatusCountModel;
import com.rc.openapi.serviceApi.OrderServiceDubboApi;
import com.rc.portal.service.ICartManager;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TCartManager;
import com.rc.portal.service.TOrderItemManager;
import com.rc.portal.util.cookieManager;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TOrderItem;
import com.rc.portal.vo.TOrderItemExample;
import com.rc.portal.webapp.model.cart.CartParam;
import com.rc.portal.webapp.util.PageResult;

public class PersonalCenterOrderAction extends BaseAction {
	private Condition model = new Condition();
	private PageWraper pw = new PageWraper();
	private PageResult rs = new PageResult(); 
	private OpenSqlManage opensqlmanage;
	private TOrderItemManager torderitemmanager;
	private TOrderStatusCountModel countModel=new TOrderStatusCountModel();
	public static String cartKey = "111yao";
	private TCartManager tcartmanager;
	private ICartManager cartmanager;
	private OrderServiceDubboApi orderservicedubboapi;
	private CartParam arg = new CartParam();
	
	public String getOrderList() throws Exception{
		rs.setP_pageSize(10);
		TMember member = (TMember)this.getSession().getAttribute("member");
		String startDate="";
		String endDate="";
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		Calendar chart=new GregorianCalendar();
		if(model.getDateType()!=null&&model.getDateType()!=0){
			if(model.getDateType()==1){
				chart.add(Calendar.MONTH,-3);
			}else if(model.getDateType()==2){
				chart.add(Calendar.MONTH,-6);
			}
		}else{
			chart.add(Calendar.MONTH,-3);
		}
		startDate=sdf.format(chart.getTime());
		endDate=sdf.format(new Date());
		
		if(model.getOrderType()==null||model.getOrderType()==-1){
			model.setOrderType(-1);
		}
		
		countModel = orderservicedubboapi.orderStatusCountByMemberid(startDate,endDate,member.getId());
		pw=orderservicedubboapi.getOrderListByPage(member.getId(),startDate,endDate,model.getOrderType(),model.getOrderNO(),rs.getP_pageSize(), rs.getP_curPage());
		return "getOrderList";
	}
	
	/**
	 * 确认收货
	 * 方法名：confirmOrder<BR>
	 * 创建人：Marlon <BR>
	 * @throws IOException <BR>
	 * @return void <BR>
	 */
	public void confirmOrder() throws IOException{
		getResponse().setContentType("text/html;charset=utf-8");
		PrintWriter out = this.getResponse().getWriter();
		Map<String, Object> map = new HashMap<String, Object>();
		String statusCode ="";
		String message="服务器繁忙请稍后重试！";//用于给前台返回一个状态信息
		
		TMember member = (TMember)this.getSession().getAttribute("member");//用与判断是否登录
		String orderId = this.getRequest().getParameter("orderId");//订单id
		
		if (member!=null) {
			try {
				if (StringUtils.hasText(orderId)) {
					String str = orderservicedubboapi.orderConfirmReceipt(Long.parseLong(orderId.trim()));
					JSONObject obj = JSONObject.fromObject(str);
					if (obj.get("flag").equals("1")) {
						message = "操作成功！";
						statusCode = "1";
					}else {
						message = "操作失败";
						statusCode = "0";
					}
				}else {
					message = "订单id有误，请检查";
					statusCode = "0";
				}
			} catch (Exception e) {
				message=e.getMessage();
				statusCode = "0";
				e.printStackTrace();
			}
		}else {
			message = "未登录，请登录";
			statusCode = "0";
		}
		map.put("status", statusCode);
		map.put("message", message);
		JSONObject json = JSONObject.fromObject(map);
		out.print(json.toString());
		out.close();
	}
	
	
	public void showBuy() throws Exception{
		getResponse().setContentType("text/html;charset=utf-8");
		PrintWriter out = this.getResponse().getWriter();
		Map rs=new HashMap();
		Integer flag=1;
		String key = cookieManager.getCookieValueByName(this.getRequest(), cartKey);
		if(model.getOrderid()!=null&&!"".equals(model.getOrderid().trim())){
			TOrderItemExample oie=new TOrderItemExample();
			oie.createCriteria().andOrderIdEqualTo(new Long(model.getOrderid().trim()));
			List<TOrderItem> goodsList = torderitemmanager.selectByExample(oie);
			if(goodsList!=null&&goodsList.size()>0){
				flag=goodsList.size();
				for(TOrderItem oi:goodsList){
					if(oi==null||oi.getGoodsId()==null||oi.getQuantity()==null||oi.getQuantity()==0){
						writeObjectToResponse("参数有误", ContentType.text_html);
						return;
					}
					int count = 1;
					if(oi!=null && oi.getQuantity()!=0){
						count = oi.getQuantity();
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
					arg.setGoodsId(oi.getGoodsId());
					
					long id = 0;
					id = cartmanager.addCart(arg,count);
					if(id>0){
						flag=flag-1;
					}
				}
				
				
			}
		}
		rs.put("status",flag);
		rs.put("key", key);
		JSONObject json = JSONObject.fromObject(rs);
		out.print(json.toString());
		out.close();
		
	}
	
	 public String createKey(){
	    	return UUID.randomUUID().toString().toUpperCase();
	   }
		  
	 
	 /**
		 * 取消订单
		 * @throws Exception
		 */
		public void cancelOrder() throws Exception{
			getResponse().setContentType("text/html;charset=utf-8");
			PrintWriter write = getResponse().getWriter();
			Map map=new HashMap();
			Integer flag=0;
			String memssage="";
			boolean f=false;
			TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
			if(member!=null&&member.getId()!=null){
				if(model.getOrderid()!=null&&!"".equals(model.getOrderid().trim())){
					if(model.getCancleType()!=null&&model.getCancleType()!=0){
						try {
						 f= orderservicedubboapi.cancelOrder(new Long(model.getOrderid().trim()), model.getCancleType(), null, member.getId());
						} catch (Exception e) {
							memssage=e.getMessage();
							e.printStackTrace();
						}
					}else{
						memssage="取消原因不能为空！";
					}
					
				}else{
					memssage="订单不存在！";
				}
			}else{
				memssage="登录已过期，请重新登录！";
			}
			if(f){
				flag=1;
				memssage="订单取消成功";
			}
			map.put("flag", flag);
			map.put("message", memssage);
			JSONObject json = JSONObject.fromObject(map);
			write.write(json.toString());
			write.close();
		}
		
		
	 
	public class Condition {
		private Integer dateType;
		private Integer orderType;
		private String orderNO;
		private String orderid;
		private Integer cancleType;
		
		
		
		
		
		public Integer getCancleType() {
			return cancleType;
		}

		public void setCancleType(Integer cancleType) {
			this.cancleType = cancleType;
		}

		public String getOrderid() {
			return orderid;
		}

		public void setOrderid(String orderid) {
			this.orderid = orderid;
		}

		public String getOrderNO() {
			return orderNO;
		}

		public void setOrderNO(String orderNO) {
			this.orderNO = orderNO;
		}

		public Integer getOrderType() {
			return orderType;
		}

		public void setOrderType(Integer orderType) {
			this.orderType = orderType;
		}

		public Integer getDateType() {
			return dateType;
		}

		public void setDateType(Integer dateType) {
			this.dateType = dateType;
		}
		
		
		
	}
	
	@Override
	public Object getModel() {
		return this.model;
	}

	@Override
	public void setModel(Object o) {
		this.model = (Condition) o;
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

	public TOrderItemManager getTorderitemmanager() {
		return torderitemmanager;
	}

	public void setTorderitemmanager(TOrderItemManager torderitemmanager) {
		this.torderitemmanager = torderitemmanager;
	}


	public TCartManager getTcartmanager() {
		return tcartmanager;
	}

	public void setTcartmanager(TCartManager tcartmanager) {
		this.tcartmanager = tcartmanager;
	}

	public CartParam getArg() {
		return arg;
	}

	public void setArg(CartParam arg) {
		this.arg = arg;
	}

	public static String getCartKey() {
		return cartKey;
	}

	public static void setCartKey(String cartKey) {
		PersonalCenterOrderAction.cartKey = cartKey;
	}

	public ICartManager getCartmanager() {
		return cartmanager;
	}

	public void setCartmanager(ICartManager cartmanager) {
		this.cartmanager = cartmanager;
	}

	public OrderServiceDubboApi getOrderservicedubboapi() {
		return orderservicedubboapi;
	}

	public void setOrderservicedubboapi(OrderServiceDubboApi orderservicedubboapi) {
		this.orderservicedubboapi = orderservicedubboapi;
	}

	public TOrderStatusCountModel getCountModel() {
		return countModel;
	}

	public void setCountModel(TOrderStatusCountModel countModel) {
		this.countModel = countModel;
	}
}
