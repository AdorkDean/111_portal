package com.rc.portal.webapp.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TCouponCardManager;
import com.rc.portal.service.TCouponManager;
import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TCouponCard;
import com.rc.portal.vo.TMember;
import com.rc.portal.webapp.util.PageResult;

/**
 * 会员优惠券
 * @author 刘天灵
 *
 */
public class MemberCouponAction extends BaseAction{

	private static final long serialVersionUID = 678674541L;
	
	private static int PAGE_SIZE = 10;

	private TCoupon tcoupon;
	
	private TCouponCard tcouponcard;
	
	private TCouponManager tcouponmanager;
	
	private TCouponCardManager tcouponcardmanager;
	
	private OpenSqlManage  opensqlmanage;
	
	private PageWraper pw = new PageWraper();
	private PageWraper usedpw = new PageWraper();
	private PageWraper timeoutpw = new PageWraper();
	
	public PageWraper getPw() {
		return pw;
	}

	public void setPw(PageWraper pw) {
		this.pw = pw;
	}

	public PageWraper getUsedpw() {
		return usedpw;
	}

	public void setUsedpw(PageWraper usedpw) {
		this.usedpw = usedpw;
	}

	public PageWraper getTimeoutpw() {
		return timeoutpw;
	}

	public void setTimeoutpw(PageWraper timeoutpw) {
		this.timeoutpw = timeoutpw;
	}

	private PageResult rs = new PageResult(); 
	
	public TCoupon getTcoupon() {
		return tcoupon;
	}

	public void setTcoupon(TCoupon tcoupon) {
		this.tcoupon = tcoupon;
	}

	public TCouponManager getTcouponmanager() {
		return tcouponmanager;
	}

	public void setTcouponmanager(TCouponManager tcouponmanager) {
		this.tcouponmanager = tcouponmanager;
	}

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}


	public PageResult getRs() {
		return rs;
	}
	
	public TCouponCard getTcouponcard() {
		return tcouponcard;
	}

	public void setTcouponcard(TCouponCard tcouponcard) {
		this.tcouponcard = tcouponcard;
	}

	public TCouponCardManager getTcouponcardmanager() {
		return tcouponcardmanager;
	}

	public void setTcouponcardmanager(TCouponCardManager tcouponcardmanager) {
		this.tcouponcardmanager = tcouponcardmanager;
	}

	public void setRs(PageResult rs) {
		this.rs = rs;
	}

	public Object getModel() {
		return null;
	}

	public void setModel(Object o) {}

	
	/**
	 * 我的优惠券
	 * @return
	 */
	public String index(){
		
		String type = this.getRequest().getParameter("type");
		if(StringUtils.isEmpty(type)){
			type = "1";
		}
		
		TMember member = (TMember)this.getSession().getAttribute("member");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberId", member.getId());
		

		//未使用优惠券
		this.getRequest().setAttribute("countUse", this.opensqlmanage.selectObjectByObject(param, "t_coupon_card.selectCountUse"));
		//已使用优惠券
		this.getRequest().setAttribute("countUsed", this.opensqlmanage.selectObjectByObject(param, "t_coupon_card.selectCountUsed"));
		//已过期优惠券
		this.getRequest().setAttribute("countTimeOUt", this.opensqlmanage.selectObjectByObject(param, "t_coupon_card.selectCountTimeout"));
		
		
		if(type.equals("2")){
			//已使用
			this.pw = this.opensqlmanage.selectForPageByMap(param, "t_coupon_card.selectCountUsed", "t_coupon_card.selectUsedList", rs.getP_curPage(), PAGE_SIZE);
		}else if(type.equals("3")){
			//已过期
			this.pw = this.opensqlmanage.selectForPageByMap(param, "t_coupon_card.selectCountTimeout", "t_coupon_card.selectTimeoutList", rs.getP_curPage(), PAGE_SIZE);
		}else{
			//未使用
			this.pw = this.opensqlmanage.selectForPageByMap(param, "t_coupon_card.selectCountUse", "t_coupon_card.selectUseList", rs.getP_curPage(), PAGE_SIZE);
		}
		List result = pw.getResult();
		for(int i=0;i<result.size();i++){
			Map object = (Map) result.get(i);
			Long cid = (Long) object.get("id");
			Map<String,Object> cidMap = new HashMap<String,Object>();
			cidMap.put("cid", cid);
			Integer scope = (Integer) object.get("scope");
			String name="";
			if(scope==0){
				name="全场通用";
			}else if(scope==1){
				name="免运费";
			}else if(scope==2){
				name=(String) this.opensqlmanage.selectObjectByObject(cidMap, "t_coupon_card.selectCategoryName");
			}else if(scope==3){
				name=(String) this.opensqlmanage.selectObjectByObject(cidMap, "t_coupon_card.selectBrandName");
			}else if(scope==4){
				name=(String) this.opensqlmanage.selectObjectByObject(cidMap, "t_coupon_card.selectPshortName");
			}else{
				name="";
			}
			object.put("useName", name);
		}
		pw.setResult(result);
		System.out.println("result---》"+result);
		this.getRequest().setAttribute("type", type);
		return "index";
	}
	

	/**
	 * 删除优惠券
	 * @return
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public void deleteCoupon() throws Exception{
		String couponCardId = this.getRequest().getParameter("couponCardId");//优惠码ID
		String type = this.getRequest().getParameter("type");
		int flag=0;
		if(null!=couponCardId || !"".equals(couponCardId)){
			this.getRequest().setCharacterEncoding("utf-8");
		    this.getResponse().setContentType("text/plain;charset=utf-8");
		    PrintWriter out =  getResponse().getWriter();
			this.tcouponcardmanager.deleteByPrimaryKey(Long.valueOf(couponCardId));
			if(type.equals("1")){
				flag=1;
			}else{
				flag=3;
			}
			out.print(flag);
			out.close();
		}
	}
	
	/**
	 * 优惠券规则
	 * @return
	 */
	public String rule(){
		return "rule";
	}
}
