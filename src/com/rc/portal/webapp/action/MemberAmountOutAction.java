package com.rc.portal.webapp.action;


import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.commons.util.InfoUtil;
import com.rc.dst.client.util.ClientSubmit;
import com.rc.portal.memcache.MemCached;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TLeaderAccountNumberManager;
import com.rc.portal.service.TLeaderManager;
import com.rc.portal.service.TMemberAccountManager;
import com.rc.portal.service.TMemberAmountOutManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.util.CodeUtil;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TLeaderAccountNumber;
import com.rc.portal.vo.TLeaderAccountNumberExample;
import com.rc.portal.vo.TLeaderExample;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberAccount;
import com.rc.portal.vo.TMemberAmountOut;
import com.rc.portal.webapp.util.PageResult;

/**
 * 会员提现
 *
 */
public class MemberAmountOutAction extends BaseAction{

	private static final long serialVersionUID = 672274541L;

	private TMemberAccountManager tmemberaccountmanager;
	
	private TMemberAmountOutManager tmemberamountoutmanager;
	
	private TMemberAmountOut amountOut;
	
	private TMemberAccount  account;
	
	private OpenSqlManage opensqlmanage;
	
	private TLeaderManager tleadermanager;
	
	private TLeaderAccountNumber tleaderAccountNumber;
	
	private TLeaderAccountNumberManager tleaderaccountnumbermanager;
	
	private TSysParameterManager tsysparametermanager;
	
	@SuppressWarnings("rawtypes")
	private List result=new ArrayList();
	private PageWraper pw = new PageWraper();
	private PageResult rs = new PageResult();
	
	private String url;
	
	/*
	 * 绑定提现帐号页面
	 */
	@SuppressWarnings("unchecked")
	public String bindingAmountIndex() throws Exception{
		TMember member = (TMember)this.getRequest().getSession().getAttribute("member");
		//获取领袖
		TLeaderExample tle = new TLeaderExample();
		tle.createCriteria().andMemberIdEqualTo(member.getId());
		List<TLeader> lists = tleadermanager.selectByExample(tle);
		TLeader tleader = lists.get(0);
		this.getRequest().setAttribute("mobile", tleader.getPhone());
		return "bindingAmountIndex";
	}
	
	/*
	 * 判断是否有绑定账号
	 */
	@SuppressWarnings("rawtypes")
	public void isBindingAmount() throws Exception{
		int flag=-1;
		PrintWriter out = this.getResponse().getWriter();
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("memberId", sessionMember.getId());
		List leaderAmountList = (List) opensqlmanage.selectListByObject(_map, "t_leader_account_number.selectLeaderAccountNumberByMemberId");
		if(leaderAmountList.size()>0){
			flag=1;//转到提现页
		}else{
			flag=2;//转到绑定帐号页
		}
		out.print(flag);
		out.close();
	}		
	
	/*
	 * 绑定帐号
	 */
	
	@SuppressWarnings("unchecked")
	public void bindingAmount() throws Exception{
		int flag=-1;
		PrintWriter out = this.getResponse().getWriter();
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		TLeaderExample tle = new TLeaderExample();
		tle.createCriteria().andMemberIdEqualTo(sessionMember.getId());
		List<TLeader> lists = tleadermanager.selectByExample(tle);
		TLeader tleader = lists.get(0);
		String numberType = this.getRequest().getParameter("numberType");//账号类型  1 支付宝 2银行卡
		String numberAmount = this.getRequest().getParameter("numberAmount");//帐号
		String bankName = this.getRequest().getParameter("bankName");//银行名称
		String accountRealName = this.getRequest().getParameter("accountRealName");//银行名称
		String mobileCode =	this.getRequest().getParameter("mobileCode");//手机验证码
		String amoblieCode = (String) MemCached.getmcc().get(tleader.getPhone());
		
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("memberId", sessionMember.getId());
		Long leaderId = (Long) opensqlmanage.selectForObjectByMap(_map, "t_leader.selectLeaderIdByMemberId");
		
		if(mobileCode!=null && !"".equals(mobileCode) && mobileCode.equals(amoblieCode)){
			if(numberType.equals("1")){
				tleaderAccountNumber=new TLeaderAccountNumber();
				tleaderAccountNumber.setLeaderId(leaderId);
				tleaderAccountNumber.setMemberId(sessionMember.getId());
				tleaderAccountNumber.setAccountNumber(numberAmount);
				tleaderAccountNumber.setCreateDt(new Date());
				tleaderAccountNumber.setNumberType(1);
				tleaderaccountnumbermanager.insertSelective(tleaderAccountNumber);
				flag=0;//绑定成功
			}else{
				tleaderAccountNumber=new TLeaderAccountNumber();
				tleaderAccountNumber.setLeaderId(leaderId);
				tleaderAccountNumber.setMemberId(sessionMember.getId());
				tleaderAccountNumber.setAccountNumber(numberAmount);
				tleaderAccountNumber.setBankName(bankName);
				tleaderAccountNumber.setAccountRealName(accountRealName);
				tleaderAccountNumber.setCreateDt(new Date());
				tleaderAccountNumber.setNumberType(2);
				tleaderaccountnumbermanager.insertSelective(tleaderAccountNumber);
				flag=0;//绑定成功
			}
		}else{
			flag=1;//验证码错误
		}
		out.print(flag);
		out.close();
	}
	/*
	 * 转到解除绑定页
	 */
	@SuppressWarnings("unchecked")
	public String unbindingIndex() throws Exception{
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		//获取领袖
		TLeaderExample tle = new TLeaderExample();
		tle.createCriteria().andMemberIdEqualTo(sessionMember.getId());
		List<TLeader> lists = tleadermanager.selectByExample(tle);
		TLeader tleader = lists.get(0);
		this.getRequest().setAttribute("mobile", tleader.getPhone());
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("memberId", sessionMember.getId());
		Object leaderAmountList = opensqlmanage.selectListByObject(_map, "t_leader_account_number.selectLeaderAccountNumberByMemberId");
	    result.add(leaderAmountList);
		return "unbindingIndex";
	}
	/*
	 * 解除绑定
	 */
	@SuppressWarnings("unchecked")
	public void unbinding() throws Exception{
		int flag=-1;
		PrintWriter out =  getResponse().getWriter();
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		//获取领袖
		TLeaderExample tle = new TLeaderExample();
		tle.createCriteria().andMemberIdEqualTo(sessionMember.getId());
		List<TLeader> lists = tleadermanager.selectByExample(tle);
		TLeader tleader = lists.get(0);
		String numberAmountId = this.getRequest().getParameter("numberAmountId");
		String mobileCode =	this.getRequest().getParameter("mobileCode");//手机验证码
		String amoblieCode = (String) MemCached.getmcc().get(tleader.getPhone());
		if(mobileCode!=null && !"".equals(mobileCode) && mobileCode.equals(amoblieCode)){
			if(null!=numberAmountId && !"".equals(numberAmountId)){
				this.tleaderaccountnumbermanager.deleteByPrimaryKey(Long.valueOf(numberAmountId));
				flag=0;//删除成功
			}
		}else{
			flag=1;//验证码错误
		}
		out.print(flag);
		out.close();
	}
	/*
	 * 提取收益页
	 */
	@SuppressWarnings("unchecked")
	public String drawingProceedsIndex() throws Exception{
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		
		TMemberAccount account = tmemberaccountmanager.selectByPrimaryKey(sessionMember.getId());
		this.getRequest().setAttribute("account", account);
		
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("memberId", sessionMember.getId());
		Object leaderAmountList = opensqlmanage.selectListByObject(_map, "t_leader_account_number.selectLeaderAccountNumberByMemberId");
	    result.add(leaderAmountList);
	    System.out.println(result.size());
		return "drawingProceedsIndex";
	}
	/*
	 * 提取收益
	 */
	@SuppressWarnings("rawtypes")
	public String drawingProceeds() throws Exception{
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		String tqAmount = this.getRequest().getParameter("tqAmount");
		String numberAmountId = this.getRequest().getParameter("checkAmount");
		
		if (sessionMember != null) {
			Map<String, Object> _map = new HashMap<String, Object>();
			_map.put("memberId", sessionMember.getId());
			TLeaderExample example = new TLeaderExample();
			example.createCriteria().andMemberIdEqualTo(sessionMember.getId());
			List list  = tleadermanager.selectByExample(example);
			if(null !=list && list.size()>0){
				TLeader leader = (TLeader)list.get(0);
				/*if(leader.getAuditType()!=1){
					url = "/healthLeader/editHealthLeaderPage!editHealthLeaderPage.action?id="+leader.getId();
					return "url";
				}*/
			}else{
				return "not_health_leader";
			}
		}
		amountOut=new TMemberAmountOut();
		if(numberAmountId!=null && !"".equals(numberAmountId)){
			TLeaderAccountNumber leaderAccountNumber = this.tleaderaccountnumbermanager.selectByPrimaryKey(Long.valueOf(numberAmountId));
			if(leaderAccountNumber!=null){
				amountOut.setMemberId(sessionMember.getId());
				amountOut.setOutType(leaderAccountNumber.getNumberType());
				amountOut.setBankNo(leaderAccountNumber.getAccountNumber());
				amountOut.setAlipayNo(leaderAccountNumber.getAccountNumber());
				amountOut.setBankName(leaderAccountNumber.getBankName());
				BigDecimal bd=new BigDecimal(tqAmount);
				amountOut.setAmount(bd);
				amountOut.setSerialNumber(String.valueOf(System.currentTimeMillis()));
			}
		}
		Long id = tmemberamountoutmanager.insertAmountOut(amountOut);
		TMemberAccount account = tmemberaccountmanager.selectByPrimaryKey(sessionMember.getId());
		this.getRequest().setAttribute("account", account);
		
		Map<String,Object> q = new HashMap<String,Object>();
		q.put("id", sessionMember.getId());
		Map qmap = (Map) opensqlmanage.selectForObjectByMap(q, "t_leader.selectLeaderObject");
		this.getRequest().setAttribute("qmap", qmap);
		this.getRequest().setAttribute("err", id);
		String leaderUrl = InfoUtil.getInstance().getInfo("config", "leaderUrl");
		this.getRequest().setAttribute("leaderUrl", leaderUrl);
		return "todrawingProceedsIndex";
	}
	
	
	/*
	 * 检测帐号是否已经存在
	 */
	public void checkUserNameIsExist() throws Exception{
		int flag=-1;
		String numberAmount = this.getRequest().getParameter("numberAmount");//帐号
		PrintWriter out =  this.getResponse().getWriter();
		
		TLeaderAccountNumberExample e = new TLeaderAccountNumberExample();
		e.createCriteria().andAccountNumberEqualTo(numberAmount);
		int countByExample = this.tleaderaccountnumbermanager.countByExample(e);
		if(countByExample > 0){
			flag=0;//帐号已经存在
		}
		out.print(flag);
		out.close();
	}
	/*
	 * 发送验证码
	 */
	@SuppressWarnings("unchecked")
	public void validateMobileCode() throws Exception{
		String captcha = CodeUtil .getVcode(4);
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		
		//获取领袖
		TLeaderExample tle = new TLeaderExample();
		tle.createCriteria().andMemberIdEqualTo(sessionMember.getId());
		List<TLeader> lists = tleadermanager.selectByExample(tle);
		TLeader tleader = lists.get(0);
		String mobile = tleader.getPhone();
		MemCached.getmcc().set(mobile,captcha,new Date(1000*300));
		Pattern pattern = Pattern.compile("^[1][3,4,7,5,8][0-9]{9}$"); // 验证手机号 
		int flag=-1;
		PrintWriter out = this.getResponse().getWriter();
		if(mobile!=null &&  pattern.matcher(mobile).matches()){
			Map<String, String> map = new HashMap<String, String>();
			map.put("mobiles", mobile);
			map.put("smsContent", "您的111医药馆验证码:"+captcha+"。影视明星何政军先生推荐的中国好药房@111医药馆！");
			String YAO_GATEWAY_URL =tsysparametermanager.getKeys("sms");
			String buildRequestBySMS = ClientSubmit.buildRequestBySMS(map,YAO_GATEWAY_URL);
			System.out.println(buildRequestBySMS);
			flag=0;
		}
		out.print(flag);
		out.close();
	}
	/*
	 * 提现记录
	 */
	@SuppressWarnings("rawtypes")
	public String presentRecordList()throws SQLException{
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		String startDate = this.getRequest().getParameter("startDate");
		String endDate = this.getRequest().getParameter("endDate");
		if (sessionMember != null) {
			Map<String, Object> _map = new HashMap<String, Object>();
			_map.put("memberId", sessionMember.getId());
			TLeaderExample example = new TLeaderExample();
			example.createCriteria().andMemberIdEqualTo(sessionMember.getId());
			List list  = tleadermanager.selectByExample(example);
			if(null !=list && list.size()>0){
				TLeader leader = (TLeader)list.get(0);
				/*if(leader.getAuditType()!=1){
					url = "/healthLeader/editHealthLeaderPage!editHealthLeaderPage.action?id="+leader.getId();
					return "url";
				}*/
			}else{
				return "not_health_leader";
			}
		}
		Map<String,Object> querMap = new HashMap<String,Object>();
		
		if(StringUtils.hasText(startDate) && !startDate.equals("开始日期")){
			querMap.put("start_date", startDate.trim());
			this.getRequest().setAttribute("startDate", startDate);
		}else{
			querMap.put("start_date", "1900-01-01 00:00:00");
		}
		if(StringUtils.hasText(endDate) && !endDate.equals("结束日期")){
			querMap.put("end_date", endDate.trim());
			this.getRequest().setAttribute("endDate", endDate);
		}else{
			querMap.put("end_date", "9999-12-01 00:00:00");
		}
		querMap.put("member_id", sessionMember.getId());
		rs.setP_pageSize(3);
		pw = opensqlmanage.selectForPageByMap(querMap, "t_member_amount_out.selectPresentRecordListCount", "t_member_amount_out.selectPresentRecordList", rs.getP_curPage(), rs.getP_pageSize());
		System.currentTimeMillis();
		return "presentRecordList";
	}
	/*
	 * 收益明细
	 */
	@SuppressWarnings("rawtypes")
	public String proceedsDetailList() throws Exception{
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		TMemberAccount account = tmemberaccountmanager.selectByPrimaryKey(sessionMember.getId());
		this.getRequest().setAttribute("account", account);
		String startDate = this.getRequest().getParameter("startDate");
		String endDate = this.getRequest().getParameter("endDate");
		
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("memberId", sessionMember.getId());
		TLeaderExample example = new TLeaderExample();
		example.createCriteria().andMemberIdEqualTo(sessionMember.getId());
		List list  = tleadermanager.selectByExample(example);
		TLeader leader = (TLeader)list.get(0);
		if (sessionMember != null) {
			if(null !=list && list.size()>0){
				leader = (TLeader)list.get(0);
			/*	if(leader.getAuditType()!=1){
					url = "/healthLeader/editHealthLeaderPage!editHealthLeaderPage.action?id="+leader.getId();
					return "url";
				}*/
			}else{
				return "not_health_leader";
			}
		}
		Map<String,Object> querMap = new HashMap<String,Object>();
		
		if(StringUtils.hasText(startDate) && !startDate.equals("开始日期")){
			querMap.put("start_date", startDate.trim());
			this.getRequest().setAttribute("startDate", startDate);
		}else{
			querMap.put("start_date", "1900-01-01 00:00:00");
		}
		if(StringUtils.hasText(endDate) && !endDate.equals("结束日期")){
			querMap.put("end_date", endDate.trim());
			this.getRequest().setAttribute("endDate", endDate);
		}else{
			querMap.put("end_date", "9999-12-01 00:00:00");
		}
		querMap.put("memberId", sessionMember.getId());
		rs.setP_pageSize(3);
		pw = opensqlmanage.selectForPageByMap(querMap, "t_leader_stay_money.selectProceedsDetailListCount", "t_leader_stay_money.selectProceedsDetailList", rs.getP_curPage(), rs.getP_pageSize());
		return "proceedsDetailList";
	}
	
	/**
	 * 提现申请跳转
	 * @return
	 * @throws SQLException 
	 */
	public String amountOut() throws SQLException{
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		if (sessionMember != null) {
			Map<String, Object> _map = new HashMap<String, Object>();
			_map.put("memberId", sessionMember.getId());
//			Long leaderId = (Long) opensqlmanage.selectForObjectByMap(_map, "t_leader.selectLeaderIdByMemberId");
//			if (leaderId == null || leaderId <= 0L) {
//				
//			}
			TLeaderExample example = new TLeaderExample();
			example.createCriteria().andMemberIdEqualTo(sessionMember.getId());
			List list  = tleadermanager.selectByExample(example);
			if(null !=list && list.size()>0){
				TLeader leader = (TLeader)list.get(0);
				/*if(leader.getAuditType()!=1){
					url = "/healthLeader/editHealthLeaderPage!editHealthLeaderPage.action?id="+leader.getId();
					return "url";
				}*/
			}else{
				return "not_health_leader";
			}
		}
		TMemberAccount account = tmemberaccountmanager.selectByPrimaryKey(sessionMember.getId());
		Map<String,Object> q = new HashMap<String,Object>();
		q.put("id", sessionMember.getId());
		Map qmap = (Map) opensqlmanage.selectForObjectByMap(q, "t_leader.selectLeaderObject");
		this.getRequest().setAttribute("qmap", qmap);
		this.getRequest().setAttribute("account", account);
		String leaderUrl = InfoUtil.getInstance().getInfo("config", "leaderUrl");
		this.getRequest().setAttribute("leaderUrl", leaderUrl);
		return "amountOut";
	}
	
	/**
	 * 提交提现申请
	 * @return
	 * @throws SQLException
	 */
	public String subAmountOut() throws SQLException{
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		if (sessionMember != null) {
			Map<String, Object> _map = new HashMap<String, Object>();
			_map.put("memberId", sessionMember.getId());
//			Long leaderId = (Long) opensqlmanage.selectForObjectByMap(_map, "t_leader.selectLeaderIdByMemberId");
//			if (leaderId == null || leaderId <= 0L) {
//				return "not_health_leader";
//			}
			TLeaderExample example = new TLeaderExample();
			example.createCriteria().andMemberIdEqualTo(sessionMember.getId());
			List list  = tleadermanager.selectByExample(example);
			if(null !=list && list.size()>0){
				TLeader leader = (TLeader)list.get(0);
				/*if(leader.getAuditType()!=1){
					url = "/healthLeader/editHealthLeaderPage!editHealthLeaderPage.action?id="+leader.getId();
					return "url";
				}*/
			}else{
				return "not_health_leader";
			}
		}
		amountOut.setMemberId(sessionMember.getId());
		Long id = tmemberamountoutmanager.insertAmountOut(amountOut);
		TMemberAccount account = tmemberaccountmanager.selectByPrimaryKey(sessionMember.getId());
		this.getRequest().setAttribute("account", account);
		
		Map<String,Object> q = new HashMap<String,Object>();
		q.put("id", sessionMember.getId());
		Map qmap = (Map) opensqlmanage.selectForObjectByMap(q, "t_leader.selectLeaderObject");
		this.getRequest().setAttribute("qmap", qmap);
		this.getRequest().setAttribute("err", id);
		String leaderUrl = InfoUtil.getInstance().getInfo("config", "leaderUrl");
		this.getRequest().setAttribute("leaderUrl", leaderUrl);
		return "amountOut";
	}	
	
	/**
	 * 提现列表
	 * @return
	 * @throws SQLException
	 */
	public String list()throws SQLException{
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		if (sessionMember != null) {
			Map<String, Object> _map = new HashMap<String, Object>();
			_map.put("memberId", sessionMember.getId());
//			Long leaderId = (Long) opensqlmanage.selectForObjectByMap(_map, "t_leader.selectLeaderIdByMemberId");
//			if (leaderId == null || leaderId <= 0L) {
//				return "not_health_leader";
//			}
			TLeaderExample example = new TLeaderExample();
			example.createCriteria().andMemberIdEqualTo(sessionMember.getId());
			List list  = tleadermanager.selectByExample(example);
			if(null !=list && list.size()>0){
				TLeader leader = (TLeader)list.get(0);
				if(leader.getAuditType()!=1){
					url = "/healthLeader/editHealthLeaderPage!editHealthLeaderPage.action?id="+leader.getId();
					return "url";
				}
			}else{
				return "not_health_leader";
			}
		}
		Map<String,Object> querMap = new HashMap<String,Object>();
		querMap.put("member_id", sessionMember.getId());
		rs.setP_pageSize(5);
		pw = opensqlmanage.selectForPageByMap(querMap, "t_member_amount_out.selectListPageCount", "t_member_amount_out.selectListPage", rs.getP_curPage(), rs.getP_pageSize());
		Double lj = (Double) opensqlmanage.selectForObjectByMap(querMap, "t_member_amount_out.selectAmountSum");
		this.getRequest().setAttribute("lj", lj);
		querMap.put("status", 3);
		Double ljs = (Double) opensqlmanage.selectForObjectByMap(querMap, "t_member_amount_out.selectAmountSum");
		this.getRequest().setAttribute("ljs", ljs);
		account = tmemberaccountmanager.selectByPrimaryKey(sessionMember.getId());
		
		Map<String,Object> q = new HashMap<String,Object>();
		q.put("id", sessionMember.getId());
		Map qmap = (Map) opensqlmanage.selectForObjectByMap(q, "t_leader.selectLeaderObject");
		this.getRequest().setAttribute("qmap", qmap);
		String leaderUrl = InfoUtil.getInstance().getInfo("config", "leaderUrl");
		this.getRequest().setAttribute("leaderUrl", leaderUrl);
		return "amountList";
	}
	
	
	
	public TMemberAccountManager getTmemberaccountmanager() {
		return tmemberaccountmanager;
	}

	public void setTmemberaccountmanager(TMemberAccountManager tmemberaccountmanager) {
		this.tmemberaccountmanager = tmemberaccountmanager;
	}

	public Object getModel() {
		return null;
	}

	public void setModel(Object o) {}

	public TMemberAmountOut getAmountOut() {
		return amountOut;
	}

	public void setAmountOut(TMemberAmountOut amountOut) {
		this.amountOut = amountOut;
	}

	public TMemberAmountOutManager getTmemberamountoutmanager() {
		return tmemberamountoutmanager;
	}

	public void setTmemberamountoutmanager(
			TMemberAmountOutManager tmemberamountoutmanager) {
		this.tmemberamountoutmanager = tmemberamountoutmanager;
	}

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
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

	public TMemberAccount getAccount() {
		return account;
	}

	public void setAccount(TMemberAccount account) {
		this.account = account;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TLeaderManager getTleadermanager() {
		return tleadermanager;
	}

	public void setTleadermanager(TLeaderManager tleadermanager) {
		this.tleadermanager = tleadermanager;
	}

	public TLeaderAccountNumber getTleaderAccountNumber() {
		return tleaderAccountNumber;
	}

	public void setTleaderAccountNumber(TLeaderAccountNumber tleaderAccountNumber) {
		this.tleaderAccountNumber = tleaderAccountNumber;
	}

	public TLeaderAccountNumberManager getTleaderaccountnumbermanager() {
		return tleaderaccountnumbermanager;
	}

	public void setTleaderaccountnumbermanager(
			TLeaderAccountNumberManager tleaderaccountnumbermanager) {
		this.tleaderaccountnumbermanager = tleaderaccountnumbermanager;
	}

	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}

	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}

	@SuppressWarnings("rawtypes")
	public List getResult() {
		return result;
	}

	@SuppressWarnings("rawtypes")
	public void setResult(List result) {
		this.result = result;
	}
	
	
}
