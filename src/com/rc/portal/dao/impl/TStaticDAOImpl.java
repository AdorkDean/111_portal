package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TStaticDAO;
import com.rc.portal.vo.TStatic;
import com.rc.portal.vo.TStaticExample;

public class TStaticDAOImpl implements TStaticDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TStaticDAOImpl() {
        super();
    }

    public TStaticDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TStaticExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_static.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TStaticExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_static.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TStatic key = new TStatic();
        key.setId(id);
        int rows = sqlMapClient.delete("t_static.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TStatic record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_static.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TStatic record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_static.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TStaticExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_static.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TStatic selectByPrimaryKey(Long id) throws SQLException {
        TStatic key = new TStatic();
        key.setId(id);
        TStatic record = (TStatic) sqlMapClient.queryForObject("t_static.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TStatic record, TStaticExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_static.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TStatic record, TStaticExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_static.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TStatic record) throws SQLException {
        int rows = sqlMapClient.update("t_static.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TStatic record) throws SQLException {
        int rows = sqlMapClient.update("t_static.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TStaticExample {
        private Object record;

        public UpdateByExampleParms(Object record, TStaticExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TStaticExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_static.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
