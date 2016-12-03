package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.CLocationDAO;
import com.rc.portal.vo.CLocation;
import com.rc.portal.vo.CLocationExample;

public class CLocationDAOImpl implements CLocationDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public CLocationDAOImpl() {
        super();
    }

    public CLocationDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(CLocationExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("c_location.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(CLocationExample example) throws SQLException {
        int rows = sqlMapClient.delete("c_location.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) throws SQLException {
        CLocation key = new CLocation();
        key.setId(id);
        int rows = sqlMapClient.delete("c_location.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(CLocation record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_location.ibatorgenerated_insert", record);
    }

    public Long insertSelective(CLocation record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_location.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(CLocationExample example) throws SQLException {
        List list = sqlMapClient.queryForList("c_location.ibatorgenerated_selectByExample", example);
        return list;
    }

    public CLocation selectByPrimaryKey(Integer id) throws SQLException {
        CLocation key = new CLocation();
        key.setId(id);
        CLocation record = (CLocation) sqlMapClient.queryForObject("c_location.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(CLocation record, CLocationExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_location.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(CLocation record, CLocationExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_location.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(CLocation record) throws SQLException {
        int rows = sqlMapClient.update("c_location.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(CLocation record) throws SQLException {
        int rows = sqlMapClient.update("c_location.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends CLocationExample {
        private Object record;

        public UpdateByExampleParms(Object record, CLocationExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(CLocationExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("c_location.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
