package com.rc.portal.webapp.action;


import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.commons.util.InfoUtil;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TLeaderManager;
import com.rc.portal.service.TLeaderQrCodeManager;
import com.rc.portal.service.TMemberAccountManager;
import com.rc.portal.service.TMemberAmountOutManager;
import com.rc.portal.util.cookieManager;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TLeaderExample;
import com.rc.portal.vo.TLeaderQrCode;
import com.rc.portal.vo.TLeaderQrCodeExample;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberAmountOut;
import com.rc.portal.webapp.util.PageResult;

/**
 * 领袖
 *
 */
public class LeaderAction extends BaseAction{

	private static final long serialVersionUID = 672274541L;

	private TMemberAccountManager tmemberaccountmanager;
	
	private TMemberAmountOutManager tmemberamountoutmanager;
	
	private TMemberAmountOut amountOut;
	
	private OpenSqlManage opensqlmanage;
	
	private TLeaderManager tleadermanager;
	
	private TLeaderQrCodeManager tleaderqrcodemanager;
	
	private PageWraper pw = new PageWraper();
	private PageResult rs = new PageResult();
	
	private String name ;
	private String type = "1";
	private String url;
	
	/**
	 * 领袖商品列表
	 * @return
	 * @throws SQLException
	 */
	public String list()throws SQLException{
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		if (sessionMember != null) {
			Map<String, Object> _map = new HashMap<String, Object>();
			_map.put("memberId", sessionMember.getId());
			Long leaderId = (Long) opensqlmanage.selectForObjectByMap(_map, "t_leader.selectLeaderIdByMemberId");
			if (leaderId == null || leaderId <= 0L) {
				return "not_health_leader";
			}
		}
		System.out.println("name="+name+"----type=="+type);
		Map<String,Object> querMap = new HashMap<String,Object>();
		if(null != type && !("").equals(type)){
			
			if(type.equals("1")){
				querMap.put("orderby", " ORDER BY b.brokerage DESC");
			}else if(type.equals("2")){
				querMap.put("orderby", " ORDER BY b.brokerage ASC");
			}else if(type.equals("3")){
				querMap.put("orderby", " ORDER BY  p.sales DESC ");
			}else if(type.equals("4")){
				querMap.put("orderby", " ORDER BY  p.sales ASC");
			}else if(type.equals("5")){
				querMap.put("orderby", " ORDER BY gp.price DESC ");
			}else if(type.equals("6")){
				querMap.put("orderby", " ORDER BY gp.price ASC ");
			}
		}
		
		if(null != name && !("").equals(name)){
			querMap.put("name", "%"+name+"%");
		}
		rs.setP_pageSize(5);
		pw = opensqlmanage.selectForPageByMap(querMap, "t_goods_brokerage.selectListPageCount", "t_goods_brokerage.selectListPage", rs.getP_curPage(), rs.getP_pageSize());
		
		Map<String,Object> q = new HashMap<String,Object>();
		q.put("id", sessionMember.getId());
		Map qmap = (Map) opensqlmanage.selectForObjectByMap(q, "t_leader.selectLeaderObject");
		this.getRequest().setAttribute("qmap", qmap);
		String leaderUrl = InfoUtil.getInstance().getInfo("config", "leaderUrl");
		this.getRequest().setAttribute("leaderUrl", leaderUrl);
		return "list";
	}
	
   /**
    * 领袖排行
    * @return
 * @throws SQLException 
    */
	public String ranking() throws SQLException{
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		if(sessionMember!=null){
			Map<String, Object> _map = new HashMap<String, Object>();
			_map.put("memberId", sessionMember.getId());
			Long leaderId = (Long) opensqlmanage.selectForObjectByMap(_map, "t_leader.selectLeaderIdByMemberId");
			if (leaderId == null || leaderId <= 0L) {
				return "not_health_leader";
			}
		}
		Map<String,Object> querMap = new HashMap<String,Object>();
		List leaderList = opensqlmanage.selectForListByMap(querMap, "t_member_leader.selectCountLeader");
		this.getRequest().setAttribute("leaderList", leaderList); //领袖药丸数排行
		List amountList = opensqlmanage.selectForListByMap(querMap, "t_member_leader.selectLeaderAmount");
		this.getRequest().setAttribute("amountList", amountList); //领袖佣金排行
		querMap.put("id", sessionMember.getId());
		TLeaderExample tle = new TLeaderExample();
		tle.createCriteria().andMemberIdEqualTo(sessionMember.getId());
		List list = tleadermanager.selectByExample(tle);
		if(null != list && list.size()==1){
			TLeader leader = (TLeader) list.get(0);
			this.getRequest().setAttribute("leader", leader); 
		}
		Map qmap = (Map) opensqlmanage.selectForObjectByMap(querMap, "t_leader.selectLeaderObject");
		this.getRequest().setAttribute("qmap", qmap);
		String leaderUrl = InfoUtil.getInstance().getInfo("config", "leaderUrl");
		this.getRequest().setAttribute("leaderUrl", leaderUrl);
		return "ranking";
	}
	
	/**
	 * 领袖中心
	 * @return
	 * @throws SQLException 
	 */
	public String leader() throws SQLException{
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		if(sessionMember!=null){
			Map<String, Object> _map = new HashMap<String, Object>();
			_map.put("memberId", sessionMember.getId());
			Long leaderId = (Long) opensqlmanage.selectForObjectByMap(_map, "t_leader.selectLeaderIdByMemberId");
			if (leaderId == null || leaderId <= 0L) {
				return "not_health_leader";
			}
		}
		Map<String,Object> querMap = new HashMap<String,Object>();
		querMap.put("id", sessionMember.getId());
		Map map = (Map) opensqlmanage.selectForObjectByMap(querMap, "t_leader.selectLeaderMember");
		this.getRequest().setAttribute("leaderMap", map);
		Map<String,Object> quer = new HashMap<String,Object>();
		quer.put("start", 0);
		quer.put("end", 5);
		List list = opensqlmanage.selectForListByMap(quer,"t_goods_brokerage.selectObjectGoods");
		this.getRequest().setAttribute("list", list);
		Map qmap = (Map) opensqlmanage.selectForObjectByMap(querMap, "t_leader.selectLeaderObject");
		this.getRequest().setAttribute("waitAmount", opensqlmanage.selectObjectByObject(sessionMember.getId(), "t_leader_stay_money.select_wait_amount_by_leader_id"));
		this.getRequest().setAttribute("qmap", qmap);
		String leaderUrl = InfoUtil.getInstance().getInfo("config", "leaderUrl");
		this.getRequest().setAttribute("leaderUrl", leaderUrl);
		return "leader";
	}
	
	/**
	 * 分享领袖
	 * @return
	 * @throws SQLException 
	 */
	public String shareLeader() throws SQLException{
		String code = this.getRequest().getParameter("code"); //获取领袖编码
		String hurl = this.getRequest().getParameter("hurl"); //获取跳转地址
		if(null != code && !("").equals(code) && null != hurl && !("").equals(hurl)){
			TLeaderExample te = new TLeaderExample();
			te.createCriteria().andCodeEqualTo(code);
			List list = tleadermanager.selectByExample(te);
			if(null != list && list.size()==1){
				cookieManager.addCookie(this.getRequest(), this.getResponse(), "leader", code, 100000,".111yao.com");
			    url = hurl;
			}else{
				url="/";
			}
		}else{
			url="/";
		}
		return "url";
	}
	
	/**
	 * 分享代理
	 * @return
	 * @throws SQLException 
	 */
	public String shareAgent() throws SQLException{
		String code = this.getRequest().getParameter("code"); //获取代理编码
		String hurl = this.getRequest().getParameter("hurl"); //获取跳转地址
		if(null != code && !("").equals(code) && null != hurl && !("").equals(hurl)){
			TLeaderExample te = new TLeaderExample();
			te.createCriteria().andCodeEqualTo(code);
			List list = tleadermanager.selectByExample(te);
			if(null != list && list.size()==1){
				cookieManager.addCookie(this.getRequest(), this.getResponse(), "agent", code, 100000,".111yao.com");
			    url = hurl;
			}else{
				url="/";
			}
		}else{
			url="/";
		}
		return "url";
	}
	
	
	
	/**
	 * 分享领袖商品文章
	 * @return
	 * @throws SQLException 
	 */
	public String shareLeaderHtml() throws SQLException{
		String code = this.getRequest().getParameter("code"); //获取领袖编码
		String hurl = this.getRequest().getParameter("hurl"); //获取跳转地址
		String id = this.getRequest().getParameter("id");
		if(null != code && !("").equals(code) && null != hurl && !("").equals(hurl)){
			TLeaderExample te = new TLeaderExample();
			te.createCriteria().andCodeEqualTo(code);
			List list = tleadermanager.selectByExample(te);
			if(null != list && list.size()==1){
				cookieManager.addCookie(this.getRequest(), this.getResponse(), "leader", code, 100000,".111yao.com");
			    url = hurl+"?code="+code+"&id="+id;
			}else{
				url="/";
			}
		}else{
			url="/";
		}
		return "url";
	}
	
	
	public void getHaiBao() throws Exception{
		this.getRequest().setCharacterEncoding("utf-8");
	    this.getResponse().setContentType("text/plain;charset=utf-8");
	    PrintWriter out =  this.getResponse().getWriter();
	    String id = this.getRequest().getParameter("id");
	    String statusCode = "0";
	    try {
			TLeaderQrCodeExample example = new TLeaderQrCodeExample();
			example.createCriteria().andLeaderIdEqualTo(new Long(id))
					.andTypeEqualTo(1);
			List list = tleaderqrcodemanager.selectByExample(example);
			if (null != list) {
				TLeaderQrCode qrCode = (TLeaderQrCode) list.get(0);
				statusCode = qrCode.getImgUrl();
			}
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "1";
		}
		out.print(statusCode);
		out.close();
		
	}
	
	//获取佣金商品文章
	public void getGoodsArticle() throws Exception{
		this.getRequest().setCharacterEncoding("utf-8");
	    this.getResponse().setContentType("text/plain;charset=utf-8");
	    PrintWriter out =  this.getResponse().getWriter();
	    String goods_id = this.getRequest().getParameter("goods_id");
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("id", goods_id);
		String statusCode = "0";
		try {
			List list = opensqlmanage.selectForListByMap(_map,
					"t_lx_goods_article.selectGoodsArticleList");
			if (null != list && list.size() > 0) {
				net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(list);
				statusCode = jsonArray.toString();
			} else {
				statusCode = "-1";
			}
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "0";
		}
		out.print(statusCode);
		out.close();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TLeaderManager getTleadermanager() {
		return tleadermanager;
	}

	public void setTleadermanager(TLeaderManager tleadermanager) {
		this.tleadermanager = tleadermanager;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TLeaderQrCodeManager getTleaderqrcodemanager() {
		return tleaderqrcodemanager;
	}

	public void setTleaderqrcodemanager(TLeaderQrCodeManager tleaderqrcodemanager) {
		this.tleaderqrcodemanager = tleaderqrcodemanager;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("123");
		net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());
	}
}
