package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.CLocationCityDAO;
import com.rc.portal.vo.CLocationCity;
import com.rc.portal.vo.CLocationCityExample;

public class CLocationCityDAOImpl implements CLocationCityDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public CLocationCityDAOImpl() {
        super();
    }

    public CLocationCityDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(CLocationCityExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("c_location_city.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(CLocationCityExample example) throws SQLException {
        int rows = sqlMapClient.delete("c_location_city.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) throws SQLException {
        CLocationCity key = new CLocationCity();
        key.setId(id);
        int rows = sqlMapClient.delete("c_location_city.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(CLocationCity record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_location_city.ibatorgenerated_insert", record);
    }

    public Long insertSelective(CLocationCity record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_location_city.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(CLocationCityExample example) throws SQLException {
        List list = sqlMapClient.queryForList("c_location_city.ibatorgenerated_selectByExample", example);
        return list;
    }

    public CLocationCity selectByPrimaryKey(Integer id) throws SQLException {
        CLocationCity key = new CLocationCity();
        key.setId(id);
        CLocationCity record = (CLocationCity) sqlMapClient.queryForObject("c_location_city.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(CLocationCity record, CLocationCityExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_location_city.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(CLocationCity record, CLocationCityExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_location_city.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(CLocationCity record) throws SQLException {
        int rows = sqlMapClient.update("c_location_city.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(CLocationCity record) throws SQLException {
        int rows = sqlMapClient.update("c_location_city.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends CLocationCityExample {
        private Object record;

        public UpdateByExampleParms(Object record, CLocationCityExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(CLocationCityExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("c_location_city.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
