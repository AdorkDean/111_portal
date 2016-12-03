package com.rc.portal.webapp.util;

import java.util.ArrayList;
import java.util.List;

public class PageResult {

	private String p_tableName;
	private String p_strWhere;
	private String p_orderColumn;
	private String p_column;
	private String p_orderStyle;
	private Integer p_curPage=1;
	private Integer p_pageSize=20;
	private Integer p_totalRecords;
	private Integer p_totalPages;
	private String p_sql;
	private List resultList=new ArrayList();
	public PageResult() {
		super();
	}
	
	public PageResult(String p_tableName, String p_strWhere, String p_orderColumn, String p_column, String p_orderStyle,
			Integer p_curPage, Integer p_pageSize, Integer p_totalRecords, Integer p_totalPages,List resultList) {
		super();
		this.p_tableName = p_tableName;
		this.p_strWhere = p_strWhere;
		this.p_orderColumn = p_orderColumn;
		this.p_column = p_column;
		this.p_orderStyle = p_orderStyle;
		this.p_curPage = p_curPage;
		this.p_pageSize = p_pageSize;
		this.p_totalRecords = p_totalRecords;
		this.p_totalPages = p_totalPages;
		this.resultList = resultList;
	}
	/**
	 * @param name
	 * @param where
	 * @param column
	 * @param p_column2
	 * @param style
	 * @param page
	 * @param size
	 */
	public PageResult(String p_tableName, String p_strWhere, String p_orderColumn,
			String p_column, String p_orderStyle, Integer p_curPage, Integer p_pageSize)
	{
		super();
		this.p_tableName = p_tableName;
		this.p_strWhere = p_strWhere;
		this.p_orderColumn = p_orderColumn;
		this.p_column = p_column;
		this.p_orderStyle = p_orderStyle;
		this.p_curPage = p_curPage;
		this.p_pageSize = p_pageSize;
	}
	public PageResult(String p_tableName, String p_strWhere, String p_orderColumn,
			String p_orderStyle, Integer p_curPage, Integer p_pageSize)
	{
		super();
		this.p_tableName = p_tableName;
		this.p_strWhere = p_strWhere;
		this.p_orderColumn = p_orderColumn;
		this.p_orderStyle = p_orderStyle;
		this.p_curPage = p_curPage;
		this.p_pageSize = p_pageSize;
	}
	public String getP_tableName() {
		return p_tableName;
	}
	public void setP_tableName(String name) {
		p_tableName = name;
	}
	public String getP_strWhere() {
		return p_strWhere;
	}
	public void setP_strWhere(String where) {
		p_strWhere = where;
	}
	public String getP_orderColumn() {
		return p_orderColumn;
	}
	public void setP_orderColumn(String column) {
		p_orderColumn = column;
	}
	public String getP_orderStyle() {
		return p_orderStyle;
	}
	public void setP_orderStyle(String style) {
		p_orderStyle = style;
	}
	public Integer getP_curPage() {
		return p_curPage;
	}
	public void setP_curPage(Integer page) {
		if(page < 1){
			p_curPage = 0;
		}else{
			p_curPage = page;
		}
	}
	public Integer getP_pageSize() {
		return p_pageSize;
	}
	public void setP_pageSize(Integer size) {
		p_pageSize = size;
	}
	public Integer getP_totalRecords() {
		return p_totalRecords;
	}
	public void setP_totalRecords(Integer records) {
		p_totalRecords = records;
	}
	public Integer getP_totalPages() {
		return p_totalPages;
	}
	public void setP_totalPages(Integer pages) {
		p_totalPages = pages;
	}
	public List getResultList() {
		return resultList;
	}
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	public String getP_sql() {
		return p_sql;
	}

	public void setP_sql(String p_sql) {
		this.p_sql = p_sql;
	}
	/**
	 * @return the p_column
	 */
	public String getP_column()
	{
		return p_column;
	}

	/**
	 * @param p_column the p_column to set
	 */
	public void setP_column(String p_column)
	{
		this.p_column = p_column;
	}
}
