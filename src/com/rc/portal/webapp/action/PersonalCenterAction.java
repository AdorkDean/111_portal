package com.rc.portal.webapp.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TMemberBaseMessageExtManager;
import com.rc.portal.service.TOrderItemManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.webapp.util.JsonUtil;
import com.rc.portal.webapp.util.PageResult;

public class PersonalCenterAction extends BaseAction {
	private Condition model = new Condition();
	private PageWraper pw = new PageWraper();
	private PageResult rs = new PageResult(); 
	private OpenSqlManage opensqlmanage;
	private TOrderItemManager torderitemmanager;
	private Map countMap=new HashMap();
	private List<Map> orderList=new ArrayList<Map>();
	private TMemberBaseMessageExtManager tmemberbasemessageextmanager;
	private Map memberMap=new HashMap();
	
	private TSysParameterManager tsysparametermanager;
	
//	首页订单
	@SuppressWarnings("rawtypes")
	public String getCenterIndex() throws Exception{
		Map map=new HashMap();
		TMember member = (TMember)this.getSession().getAttribute("member");
		map.put("memberId", member.getId().toString());
		String homePageConfigId = tsysparametermanager.getKeys("public_service_url");
		Map result = JsonUtil.getData1(map, homePageConfigId+"getJifenOutline");
		memberMap=(Map)opensqlmanage.selectForObjectByMap(map, "t_member.selectMemberCenter");
		memberMap.put("perFect", getPerFect(member.getId()));
		if(result.get("jifen")!=null){
		if(memberMap.get("integral")!=null){
				Integer i=(Integer) memberMap.get("integral");
				Integer j=(Integer) result.get("jifen");
				memberMap.put("integral", i+j);
			}
		}
		Integer i=(Integer) memberMap.get("is_mobile_check");
		Integer j=(Integer) memberMap.get("is_email_check");
		if(i!=null&&j!=null){
			if(i==1&&j==1){
				memberMap.put("save", 3);	
			}else if((i==1&&j!=1)||(i!=1&&j==1)){
				memberMap.put("save", 2);	
			}else{
				memberMap.put("save", 1);	
			}
		}else{
			memberMap.put("save", 1);	
		}
		countMap=(Map)opensqlmanage.selectForObjectByMap(map, "t_order.selectOrderCountIndex");
		orderList=opensqlmanage.selectForListByMap(map, "t_order.selectOrderListCenterIndex");
		if(orderList!=null&&orderList.size()>0){
			for(Map ordermap:orderList){
				Map maptem=new HashMap();
				maptem.put("orderid", ordermap.get("id").toString());
				List<Map> oi = opensqlmanage.selectForListByMap(maptem, "t_order.selectGoodsListByOrderId");
				ordermap.put("orderitem", oi);
			}
		}
		return "getCenterIndex";
	}
	
	
	public Integer getPerFect(Long memberid) throws Exception{
	Integer per=20;
	Integer flag=0;
	TMemberBaseMessageExt base = tmemberbasemessageextmanager.selectByPrimaryKey(memberid);
	if(base!=null){
		if(base.getRealName()!=null&&!"".equals(base.getRealName().trim())){
			flag++;
		}
		if(base.getHeadPortrait()!=null&&!"".equals(base.getHeadPortrait().trim())){
			flag++;
		}
		if(base.getSex()!=null){
			flag++;
		}
		if(base.getNickName()!=null&&!"".equals(base.getNickName().trim())){
			flag++;
		}
		if(base.getArea()!=null&&!"".equals(base.getArea().trim())){
			flag++;
		}
		if(base.getAddress()!=null&&!"".equals(base.getAddress().trim())){
			flag++;
		}
		if(base.getBirthday()!=null){
			flag++;
		}
		if(base.getIsMarry()!=null){
			flag++;
		}
		if(base.getFamilyMember()!=null){
			flag++;
		}
		if(base.getIdentity()!=null){
			flag++;
		}
		if(base.getLiveStatus()!=null&&!"".equals(base.getLiveStatus().trim())){
			flag++;
		}
		if(base.getPersonalIncome()!=null){
			flag++;
		}
		if(base.getChildAge()!=null&&!"".equals(base.getChildAge().trim())){
			flag++;
		}
		if(base.getIsCart()!=null){
			flag++;
		}
		if(base.getPlaceOrigin()!=null&&!"".equals(base.getPlaceOrigin().trim())){
			flag++;
		}
		if(base.getCompanyName()!=null&&!"".equals(base.getCompanyName().trim())){
			flag++;
		}
		if(base.getIndustry()!=null){
			flag++;
		}
		if(base.getPosition()!=null&&!"".equals(base.getPosition().trim())){
			flag++;
		}
		if(base.getWorkYear()!=null){
			flag++;
		}
		if(base.getDiploma()!=null){
			flag++;
		}
		if(base.getGraduationSchool()!=null&&!"".equals(base.getGraduationSchool().trim())){
			flag++;
		}
		if(base.getGraduationDt()!=null&&!"".equals(base.getGraduationDt().trim())){
			flag++;
		}
	}
	if(flag>6&&flag<=11){
		per=50;
	}else if(flag>11&&flag<=20){
		per=75;
	}else if(flag>20){
		per=100;
	}
		return per;
	}
	public class Condition {
		private Integer dateType;
		private Integer orderType;
		private String orderNO;
		
		
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

	public Map getCountMap() {
		return countMap;
	}

	public void setCountMap(Map countMap) {
		this.countMap = countMap;
	}

	public List<Map> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Map> orderList) {
		this.orderList = orderList;
	}


	public TMemberBaseMessageExtManager getTmemberbasemessageextmanager() {
		return tmemberbasemessageextmanager;
	}


	public void setTmemberbasemessageextmanager(
			TMemberBaseMessageExtManager tmemberbasemessageextmanager) {
		this.tmemberbasemessageextmanager = tmemberbasemessageextmanager;
	}


	public Map getMemberMap() {
		return memberMap;
	}


	public void setMemberMap(Map memberMap) {
		this.memberMap = memberMap;
	}


	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}


	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}




	
}
