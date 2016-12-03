package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TOrderFlowDAO;
import com.rc.portal.vo.TOrderFlow;
import com.rc.portal.vo.TOrderFlowExample;

public class TOrderFlowDAOImpl implements TOrderFlowDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TOrderFlowDAOImpl() {
        super();
    }

    public TOrderFlowDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TOrderFlowExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_order_flow.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TOrderFlowExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_order_flow.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TOrderFlow key = new TOrderFlow();
        key.setId(id);
        int rows = sqlMapClient.delete("t_order_flow.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TOrderFlow record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_order_flow.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TOrderFlow record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_order_flow.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TOrderFlowExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_order_flow.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TOrderFlow selectByPrimaryKey(Long id) throws SQLException {
        TOrderFlow key = new TOrderFlow();
        key.setId(id);
        TOrderFlow record = (TOrderFlow) sqlMapClient.queryForObject("t_order_flow.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TOrderFlow record, TOrderFlowExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_order_flow.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TOrderFlow record, TOrderFlowExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_order_flow.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TOrderFlow record) throws SQLException {
        int rows = sqlMapClient.update("t_order_flow.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TOrderFlow record) throws SQLException {
        int rows = sqlMapClient.update("t_order_flow.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TOrderFlowExample {
        private Object record;

        public UpdateByExampleParms(Object record, TOrderFlowExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TOrderFlowExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_order_flow.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
