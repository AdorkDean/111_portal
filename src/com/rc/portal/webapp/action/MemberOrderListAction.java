package com.rc.portal.webapp.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageInfo;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.vo.TMember;
import com.rc.portal.webapp.util.JsonUtil;
import com.rc.portal.webapp.util.PageResult;

public class MemberOrderListAction extends BaseAction {
	private Condition model = new Condition();
	private PageWraper pw = new PageWraper();
	private PageResult rs = new PageResult(); 
	private OpenSqlManage opensqlmanage;
	private TSysParameterManager tsysparametermanager;
	private Map result=new HashMap();
	
	
	public String getOutOrderList() throws Exception{
		TMember member = (TMember)this.getSession().getAttribute("member");
		String homePageConfigId=tsysparametermanager.getKeys("public_service_url");
		Map map=new HashMap();
		rs.setP_pageSize(10);
		if(member!=null){
			map.put("member_id", member.getId().toString());
			map.put("pageNumber",rs.getP_curPage().toString());
			map.put("pageSize", rs.getP_pageSize().toString());
			result=JsonUtil.getData(map, homePageConfigId+"getOffLineOrderList");
			PageInfo pageInfo=new PageInfo();
			if((Integer)result.get("statusCode")!=0){
				Map m = (Map)result.get("pageInfo");
				pageInfo.setCount((Integer)m.get("count"));
				pageInfo.setPage((Integer)m.get("page"));
				pageInfo.setPages((Integer)m.get("pages"));
				pageInfo.setPageSize((Integer)m.get("pageSize"));
			}
			pw.setPageInfo(pageInfo);
			pw.setResult((List) result.get("list"));
		}
		return "getOutOrderList";
	}
	public class Condition {
		private String pageNumber;

		public String getPageNumber() {
			return pageNumber;
		}

		public void setPageNumber(String pageNumber) {
			this.pageNumber = pageNumber;
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

	public Map getResult() {
		return result;
	}

	public void setResult(Map result) {
		this.result = result;
	}

	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}

	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}


	
}
