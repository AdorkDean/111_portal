package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.OpenSqlDAO;
import com.rc.portal.service.OpenSqlManage;

/**  
 * @Title: OpenSqlManageImple.java
 * @Description: 
 * @author yinbinhome@163.com  
 * @date 2012-6-27 下午10:43:58
 * @version V1.0  
 */

public class OpenSqlManageImpl implements OpenSqlManage {
	private OpenSqlDAO opensqldao;
	
	public OpenSqlDAO getOpensqldao() {
		return opensqldao;
	}

	public void setOpensqldao(OpenSqlDAO opensqldao) {
		this.opensqldao = opensqldao;
	}

	@Override
	public List selectForListByMap(Map map, String querySql) {
		// TODO Auto-generated method stub
		return opensqldao.selectForListByMap(map, querySql);
	}

	@Override
	public Object selectForObjectByMap(Map map, String querySql) {
		// TODO Auto-generated method stub
		return opensqldao.selectForObjectByMap(map, querySql);
	}

	@Override
	public PageWraper selectForPageByMap(Map map, String sql_count, String sql_record, Integer page, Integer pagesize) {
		// TODO Auto-generated method stub
		return opensqldao.selectForPageByMap(map, sql_count, sql_record, page, pagesize);
	}

	@Override
	public String batchInsertByList_drug(List<Object> list, String insertsql) throws SQLException {
		// TODO Auto-generated method stub
		return opensqldao.batchInsertByList_drug(list, insertsql);
	}

	@Override
	public void insertByMap_drug(Map map, String insertsql) throws SQLException {
		// TODO Auto-generated method stub
		opensqldao.insertByMap_drug(map, insertsql);
	}

	@Override
	public int updateByMap_drug(Map map, String updatesql) throws SQLException {
		// TODO Auto-generated method stub
		return opensqldao.updateByMap_drug(map, updatesql);
	}

	/**
	 * 根据对象查找对象
	 * @param object 任意类型
	 * @param querySql 需要执行的sql_map ID
	 * @return 任意对象 依据sql_map定义类型
	 */
	public Object selectObjectByObject(Object object,String querySql){
		return opensqldao.selectObjectByObject(object, querySql);
	}
	
	/**
	 * 根据对象查找集合
	 * @param object 任意类型
	 * @param querySql 需要执行的sql_map ID
	 * @return 任意对象 依据sql_map定义类型集合
	 */
	public Object selectListByObject(Object object,String querySql){
		return opensqldao.selectListByObject(object, querySql);
	}
	
	/**
	 * 公共分页工具方法，传入条件Map，计算总记录数sqlmap的id，查询结果集sqlmap的id
	 * @param object 任意继承BaseModel对象的参数
	 * @param sql_count 计算总记录数sqlmap的id
	 * @param sql_record 查询结果集sqlmap的id
	 * @param page 页码
	 * @param pagesize 每页显示个数
	 * @return
	 */
	public PageWraper selectForPageByObject(Object object,String sql_count,String sql_record,Integer page,Integer pagesize){
		return opensqldao.selectForPageByObject( object, sql_count, sql_record, page, pagesize);
	}
}
