package com.rc.portal.webapp.action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageInfo;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.dst.client.util.ClientSubmitPublic;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TCouponManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TCouponExample;
import com.rc.portal.vo.TMember;
import com.rc.portal.webapp.util.JsonUtil;
import com.rc.portal.webapp.util.PageResult;

/**
 * 会员积分
 * @author 刘天灵
 *
 */
public class MemberPointAction extends BaseAction{

	private static final long serialVersionUID = 4575686891L;
	
	private static int PAGE_SIZE = 5;
	
	private TCouponManager tcouponmanager;
	
	private OpenSqlManage  opensqlmanage;
	
	private TMemberManager tmembermanager;
	
	private PageWraper pw = new PageWraper();
	
	private PageResult rs = new PageResult(); 
	
	private TSysParameterManager tsysparametermanager;
	
	public TMemberManager getTmembermanager() {
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
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

	public Object getModel() {
		return null;
	}

	public void setModel(Object o) {}

	
	/**
	 * 我的积分
	 * @return
	 * @throws Exception 
	 */
	public String index() throws Exception{
		TMember member = (TMember)this.getSession().getAttribute("member");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberId", member.getId().toString());
		TMember m = tmembermanager.selectByPrimaryKey(member.getId());
		String homePageConfigId = tsysparametermanager.getKeys("public_service_url");
		Map result = JsonUtil.getData1(param, homePageConfigId+"getJifenOutline");
		if(result.get("jifen")!=null){
			if(m.getIntegral()!=null){
				Integer i=(Integer) m.getIntegral();
				Integer j=(Integer) result.get("jifen");
				member.setIntegral(i+j);
				this.getSession().setAttribute("member", member);
			}
		}
		
		Object nickname = this.opensqlmanage.selectObjectByObject(param, "t_member_base_message_ext.selectNickName");
		this.getRequest().setAttribute("nickname", nickname);
		
		TCouponExample example = new TCouponExample();
		example.createCriteria().andIsExchangeEqualTo(1).andStartTimeLessThan(new Date()).andEndTimeGreaterThan(new Date());
		
		
		Object currentGrade = this.opensqlmanage.selectObjectByObject(member.getMemberGradeId().toString(), "t_member_grade.selectCurrentGrade");
		this.getRequest().setAttribute("currentGrade", currentGrade);
		
		Object nextGrade = this.opensqlmanage.selectObjectByObject(member.getMemberGradeId().toString(), "t_member_grade.selectNextGrade");
		this.getRequest().setAttribute("nextGrade", nextGrade);
		
		pw = this.opensqlmanage.selectForPageByObject(example, "t_coupon.ibatorgenerated_countByExample", "t_coupon.selectByExampleByPage", rs.getP_curPage(), PAGE_SIZE);
		
		this.getRequest().setAttribute("type", "1");
		return "index";
	}
	/**
	 * 积分流水
	 * @return
	 * @throws Exception 
	 */
	public String pointList() throws Exception{
		TMember member = (TMember)this.getSession().getAttribute("member");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("memberId", member.getId());
		
		Object nickname = this.opensqlmanage.selectObjectByObject(param, "t_member_base_message_ext.selectNickName");
		this.getRequest().setAttribute("nickname", nickname);
		
		TCouponExample example = new TCouponExample();
		example.createCriteria().andIsExchangeEqualTo(1).andStartTimeLessThan(new Date()).andEndTimeGreaterThan(new Date());
		
		
		Object currentGrade = this.opensqlmanage.selectObjectByObject(member.getMemberGradeId().toString(), "t_member_grade.selectCurrentGrade");
		this.getRequest().setAttribute("currentGrade", currentGrade);
		
		Object nextGrade = this.opensqlmanage.selectObjectByObject(member.getMemberGradeId().toString(), "t_member_grade.selectNextGrade");
		this.getRequest().setAttribute("nextGrade", nextGrade);
		
		String pointType = this.getRequest().getParameter("pointType");//积分类型   1 表示线上积分流水  2表示线下积分流水
		if(!(pointType!=null&&!"".equals(pointType))){
			pointType = "1";
		}
		String timeType = this.getRequest().getParameter("timeType");//统计时间类型  1 一个月内   2 三个月内   3  六个月内   4 更多
		if(!(timeType!=null&&!"".equals(timeType))){
			timeType="1";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		String startDate="";
		String endDate="";
		if(!"4".equals(timeType)){
			startDate =getDateTimeStr(timeType)+" 00:00:00";
			endDate =format.format(new Date())+" 23:59:59";
		}else{
			endDate =getDateTimeStr(timeType)+" 23:59:59";
			startDate ="2000-01-01 00:00:00";
		}
		String publicServiceUrl = tsysparametermanager.getKeys("public_service_url");
		Map<String,String> publicMap = new HashMap<String,String>();
		publicMap.put("memberId", String.valueOf(member.getId()));
		publicMap.put("pageNo", String.valueOf(rs.getP_curPage()));
		publicMap.put("pageSize", "10");
		publicMap.put("startDate", startDate);
		publicMap.put("endDate", endDate);
		Integer count=0;
        PageInfo pageInfo=new PageInfo();
        pageInfo.setPage(rs.getP_curPage());
        pageInfo.setPageSize(10);
        pageInfo.setStart(rs.getP_curPage(), 10);
        pageInfo.setEnd(rs.getP_curPage(), 10);
        List<Map<String,String>> pointList = new ArrayList<Map<String,String>>();
		if("1".equals(pointType)){//线上  
			String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"getIntegralOnLine");
			JSONObject resultJson = JSONObject.fromObject(resultJsonstr);
			if(resultJson.get("statusCode").equals("1")){
				JSONObject data = resultJson.getJSONObject("data");
				JSONObject pageInfojson = data.getJSONObject("pageInfo");
		        count = Integer.valueOf(String.valueOf(pageInfojson.get("count")));
				JSONArray resultArray = data.getJSONArray("result");
				List<Map<String, Object>> _resultList = (List<Map<String, Object>>) JSONArray.toCollection(resultArray, Map.class);
				if(_resultList!=null&&_resultList.size()>0){
					Map<String,String> pointMap = null;
					Map<String,String> pointRemarkMap = new HashMap<String,String>();
					pointRemarkMap.put("1", "注册赠送");
					pointRemarkMap.put("2", "完善昵称赠送");
					pointRemarkMap.put("3", "完善真实姓名赠送");
					pointRemarkMap.put("4", "完善性别赠送");
					pointRemarkMap.put("5", "完善血型赠送");
					pointRemarkMap.put("6", "完善病历赠送");
					pointRemarkMap.put("7", "评论赠送");
					pointRemarkMap.put("8", "签到赠送");
					pointRemarkMap.put("9", "下单购买完成赠送");
					pointRemarkMap.put("10", "兑换优惠券");
					pointRemarkMap.put("11", "线下消费");
					for(Map<String,Object> resultMapJson:_resultList){
						pointMap = new HashMap<String,String>();
						pointMap.put("pointId", String.valueOf(resultMapJson.get("id")));//消费记录id
						pointMap.put("integral", String.valueOf(resultMapJson.get("integral")));//消费分数
						pointMap.put("createDate", String.valueOf(resultMapJson.get("createDate")));//消费时间
//						1 注册 2完善用户名 3完善真实姓名 4完善性别 5完善血型  6完善会员病历(常用药、病史、过敏史) 7 评论 8 签到  9订单完成  10兑换优惠券   11海典消分
						if(String.valueOf(resultMapJson.get("source")).equals("10")||String.valueOf(resultMapJson.get("source")).equals("11")){
							pointMap.put("pointSource", "2");//消费
						}else{
							pointMap.put("pointSource", "1");//赠送
						}
//						if(resultMapJson.get("remark")!=null&&!"".equals(resultMapJson.get("remark"))){
//							pointMap.put("remark", String.valueOf(resultMapJson.get("remark")));//消费备注
//						}else{
							pointMap.put("remark", pointRemarkMap.get(String.valueOf(resultMapJson.get("source"))));//消费备注
//						}
						pointList.add(pointMap);
					}
				}
			}
		}else{// 线下
			String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"getIntegralOutLine");
			JSONObject resultJson = JSONObject.fromObject(resultJsonstr);
			if(resultJson.get("statusCode").equals("1")){
				JSONObject data = resultJson.getJSONObject("data");
		        count = Integer.valueOf(String.valueOf(data.get("count")));
				JSONArray resultArray = data.getJSONArray("list");
				List<Map<String, Object>> _resultList = (List<Map<String, Object>>) JSONArray.toCollection(resultArray, Map.class);
				
				if(_resultList!=null&&_resultList.size()>0){
					Map<String,String> pointMap = null;
					for(Map<String,Object> resultMapJson:_resultList){
						pointMap = new HashMap<String,String>();
						pointMap.put("pointId", "0");//消费记录id
						pointMap.put("integral", String.valueOf(resultMapJson.get("integral")));//消费分数
						pointMap.put("createDate", String.valueOf(resultMapJson.get("create_date")));//消费时间
						
						if(Double.valueOf(String.valueOf(resultMapJson.get("integral")))>0){
							pointMap.put("pointSource", "1");//赠送 
						}else{
							pointMap.put("pointSource", "2");//消费
						}
						pointMap.put("remark", String.valueOf(resultMapJson.get("remark")));//消费备注
						pointList.add(pointMap);
					}
				}
				
			}
		}
		pw=PageManager.getPageWraper(pageInfo, pointList, count);
		this.getRequest().setAttribute("pointType", pointType);
		this.getRequest().setAttribute("timeType", timeType);
		this.getRequest().setAttribute("type", "2");
		return "point_list";
	}
	/**
	 * 得到相应的时间  统计时间类型  1 一个月内   2 三个月内   3  六个月内   4 更多
	 * @return
	 */
	public String getDateTimeStr(String timeType){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		Calendar calendar = Calendar.getInstance();   
		if("1".equals(timeType)){
			calendar.add(Calendar.MONTH, -1);    //得到前一个月   
		}else if("2".equals(timeType)){
			calendar.add(Calendar.MONTH, -3);    //三个月内  
		}else if("3".equals(timeType)){
			calendar.add(Calendar.MONTH, -6);    //六个月内  
		}else if("4".equals(timeType)){
			calendar.add(Calendar.MONTH, -6);   
			calendar.add(Calendar.DATE, -1);    
		}
		return format.format(calendar.getTime());    //六个月内  ;
	}
	
	/**
	 * 积分兑换 0积分不足1兑换成功
	 */
	public void exchange() throws NumberFormatException, SQLException{
		TMember member = (TMember)this.getSession().getAttribute("member");
		if(StringUtils.isNumeric(this.getRequest().getParameter("id"))){
			TCoupon coupon = this.tcouponmanager.selectByPrimaryKey(Long.parseLong(this.getRequest().getParameter("id")));
			
			
			if(coupon.getExchangeCount()!=null && member.getIntegral()!=null && coupon.getExchangeCount().intValue() <= member.getIntegral().intValue() ){
				tcouponmanager.createCouponCard(coupon, member,null);
				this.getSession().setAttribute("member", tmembermanager.selectByPrimaryKey(member.getId()));
				this.writeObjectToResponse(1, ContentType.application_json);
			}else{
				this.writeObjectToResponse(0, ContentType.application_json);
			}
			
		}else{
			this.writeObjectToResponse(0, ContentType.application_json);
		}
	}
	
	/**
	 * 积分规则
	 * @return
	 */
	public String rule(){
		return "rule";
	}
	
	
	
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Calendar calendar = Calendar.getInstance();   
		calendar.add(Calendar.MONTH, -6);    //六个月内 
		calendar.add(Calendar.DATE, -1);    //六个月内  
		calendar.getTime();
		System.out.println(format.format(calendar.getTime()));
		
	}

	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}

	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}
	
	
	
}
