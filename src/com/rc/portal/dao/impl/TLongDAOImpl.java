package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLongDAO;
import com.rc.portal.vo.TLong;
import com.rc.portal.vo.TLongExample;

public class TLongDAOImpl implements TLongDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLongDAOImpl() {
        super();
    }

    public TLongDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLongExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_long.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLongExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_long.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLong key = new TLong();
        key.setId(id);
        int rows = sqlMapClient.delete("t_long.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLong record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_long.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLong record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_long.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLongExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_long.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLong selectByPrimaryKey(Long id) throws SQLException {
        TLong key = new TLong();
        key.setId(id);
        TLong record = (TLong) sqlMapClient.queryForObject("t_long.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLong record, TLongExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_long.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLong record, TLongExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_long.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLong record) throws SQLException {
        int rows = sqlMapClient.update("t_long.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLong record) throws SQLException {
        int rows = sqlMapClient.update("t_long.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLongExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLongExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLongExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_long.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
