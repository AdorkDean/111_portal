package com.rc.portal.webapp.action;

import java.util.HashMap;
import java.util.Map;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.webapp.util.PageResult;

public class ArticleAction extends BaseAction{
	private Condition model = new Condition(); 
	private PageWraper pw = new PageWraper();
	private PageResult rs = new PageResult();
	private OpenSqlManage opensqlmanage;
	
	public String getArticleList(){
		rs.setP_pageSize(10);
		Map map=new HashMap();
		if(model.getCateId()!=null&&model.getCateId()!=0){
			map.put("cateId", model.getCateId());
		}
		if(model.getKeyword()!=null&&!"".equals(model.getKeyword().trim())){
			map.put("keyword", model.getKeyword().trim());
		}
		pw=opensqlmanage.selectForPageByMap(map, "c_article.getArticleListCount", "c_article.getArticleList", rs.getP_curPage(), rs.getP_pageSize());
		return "getArticleList";
	}
	public class Condition {
		private Integer cateId;
		private Integer id;
		private String keyword;
		
		
		public String getKeyword() {
			return keyword;
		}
		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		public Integer getCateId() {
			return cateId;
		}
		public void setCateId(Integer cateId) {
			this.cateId = cateId;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
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

}
