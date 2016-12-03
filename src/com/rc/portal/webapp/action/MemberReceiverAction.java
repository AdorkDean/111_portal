package com.rc.portal.webapp.action;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

import org.springframework.util.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.dst.client.util.ClientSubmitPublic;
import com.rc.portal.service.CLocationCityManager;
import com.rc.portal.service.CLocationManager;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TMemberReceiverLatLonManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.vo.CLocationCity;
import com.rc.portal.vo.CLocationCityExample;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberReceiver;
import com.rc.portal.vo.TMemberReceiverLatLon;
import com.rc.portal.vo.TMemberReceiverLatLonExample;

/**
 * 会员收货地址
 * 
 * @author 
 * 
 */
public class MemberReceiverAction extends BaseAction {

	private static final long serialVersionUID = 54984714474392403L;

	
	private CLocationManager clocationmanager;


	private OpenSqlManage opensqlmanage;

	private TMemberReceiver tmemberreceiver = new TMemberReceiver();
	
	/**
	 * 用户收货地址manager
	 */
	private TMemberReceiverLatLonManager tmemberreceiverlatlonmanager;
	
	/**
	 * 地区城市码表
	 */
	private CLocationCityManager clocationcitymanager;
	
	private TSysParameterManager tsysparametermanager;
	/**
	 * 查询某个用户的所有收货地址
	 * @return
	 * @throws Exception
	 */
	public String queryReceiverList() throws Exception{
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		Long memberId =member.getId();
		TMemberReceiverLatLonExample example = new TMemberReceiverLatLonExample();
		example.createCriteria().andMemberIdEqualTo(memberId);
		example.setOrderByClause(" is_default desc ,id desc");
		List<TMemberReceiverLatLon> receiverLatLonList = tmemberreceiverlatlonmanager.selectByExample(example);
		for(TMemberReceiverLatLon receiverlat:receiverLatLonList){
			if(StringUtils.hasText(receiverlat.getLocationAddress())){
				if(receiverlat.getArea().indexOf(receiverlat.getLocationAddress())!=-1||receiverlat.getAddress().startsWith(receiverlat.getLocationAddress())){
					receiverlat.setLocationAddress("");
				}
			}
		}
		
		this.getRequest().setAttribute("receiverLatLonList", receiverLatLonList);
		CLocationCityExample cityExample = new CLocationCityExample();
		cityExample.createCriteria().andGradeEqualTo(1);
		List<CLocationCity> cityList =this.clocationcitymanager.selectByExample(cityExample);
		this.getRequest().setAttribute("cityList",cityList);
		return "receiver_list";
	}
	
	/**
	 * 设为默认收货地址
	 */
	public void ajaxReceiverSetDefault() throws Exception {
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		String receiverId = this.getRequest().getParameter("receiverId");
		if (StringUtils.hasText(receiverId)) {
			this.tmemberreceiverlatlonmanager.updateReceiverDefault(Long.valueOf(receiverId),sessionMember.getId());
			writeObjectToResponse(1, ContentType.text_html);
		} else {
			writeObjectToResponse(0, ContentType.text_html);
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
			Map<String,Object> receiverMap = new HashMap<String,Object>();
			if(resultMap.get("latitude") instanceof JSONNull && resultMap.get("longitude") instanceof JSONNull){
				resultMap.put("latitude","");
				resultMap.put("longitude","");
			    resultMap.put("location_address", "");
			}
			if(resultMap.get("location_address") instanceof JSONNull){
				resultMap.put("location_address","");
			}else{
				String location_address =(String)resultMap.get("location_address");
				String address =(String)resultMap.get("address");
				String area = (String)resultMap.get("area");
				if(StringUtils.hasText(location_address)){
					if(!address.startsWith(location_address)&&area.indexOf(location_address)==-1){
						address= location_address+address;
						resultMap.put("address",address);
					}
				}
			}
			if(resultMap.get("store_id") instanceof JSONNull){
				resultMap.put("store_id","");
			}
			receiverMap.put("receiver", resultMap);
			this.writeObjectToResponse(receiverMap,ContentType.application_json);
		}
	}
	
	/**
	 * 删除收货地址
	 */
	public void ajaxDeleteReceiver() throws Exception {
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		String receiverId = this.getRequest().getParameter("receiverId");
		if (StringUtils.hasText(receiverId)) {
			TMemberReceiverLatLon receiverLatLon =tmemberreceiverlatlonmanager.selectByPrimaryKey(Long.valueOf(receiverId.trim()));
			if(receiverLatLon!=null&&receiverLatLon.getMemberId()!=null&&receiverLatLon.getMemberId().longValue()==sessionMember.getId().longValue()){
				this.tmemberreceiverlatlonmanager.deleteByPrimaryKey(receiverLatLon.getId());
				writeObjectToResponse(1, ContentType.text_html);
			}else{
				writeObjectToResponse(2, ContentType.text_html);
			}
		} else {
			writeObjectToResponse(0, ContentType.text_html);
		}
	}
	
	

	public Object getModel() {
		return null;
	}

	public void setModel(Object o) {
	}

	public CLocationManager getClocationmanager() {
		return clocationmanager;
	}

	public void setClocationmanager(CLocationManager clocationmanager) {
		this.clocationmanager = clocationmanager;
	}

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	public TMemberReceiver getTmemberreceiver() {
		return tmemberreceiver;
	}

	public void setTmemberreceiver(TMemberReceiver tmemberreceiver) {
		this.tmemberreceiver = tmemberreceiver;
	}

	public TMemberReceiverLatLonManager getTmemberreceiverlatlonmanager() {
		return tmemberreceiverlatlonmanager;
	}

	public void setTmemberreceiverlatlonmanager(
			TMemberReceiverLatLonManager tmemberreceiverlatlonmanager) {
		this.tmemberreceiverlatlonmanager = tmemberreceiverlatlonmanager;
	}

	public CLocationCityManager getClocationcitymanager() {
		return clocationcitymanager;
	}

	public void setClocationcitymanager(CLocationCityManager clocationcitymanager) {
		this.clocationcitymanager = clocationcitymanager;
	}

	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}

	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}
	
	
}
