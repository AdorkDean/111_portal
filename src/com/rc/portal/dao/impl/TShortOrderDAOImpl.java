package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TShortOrderDAO;
import com.rc.portal.vo.TShortOrder;
import com.rc.portal.vo.TShortOrderExample;

public class TShortOrderDAOImpl implements TShortOrderDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TShortOrderDAOImpl() {
        super();
    }

    public TShortOrderDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TShortOrderExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_short_order.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TShortOrderExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_short_order.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TShortOrder key = new TShortOrder();
        key.setId(id);
        int rows = sqlMapClient.delete("t_short_order.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TShortOrder record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_short_order.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TShortOrder record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_short_order.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TShortOrderExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_short_order.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TShortOrder selectByPrimaryKey(Long id) throws SQLException {
        TShortOrder key = new TShortOrder();
        key.setId(id);
        TShortOrder record = (TShortOrder) sqlMapClient.queryForObject("t_short_order.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TShortOrder record, TShortOrderExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_short_order.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TShortOrder record, TShortOrderExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_short_order.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TShortOrder record) throws SQLException {
        int rows = sqlMapClient.update("t_short_order.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TShortOrder record) throws SQLException {
        int rows = sqlMapClient.update("t_short_order.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TShortOrderExample {
        private Object record;

        public UpdateByExampleParms(Object record, TShortOrderExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TShortOrderExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_short_order.selectByExampleByPage", example);
		System.out.println("资源分页查询list.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
