package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TOrderLeaderDAO;
import com.rc.portal.vo.TOrderLeader;
import com.rc.portal.vo.TOrderLeaderExample;

public class TOrderLeaderDAOImpl implements TOrderLeaderDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TOrderLeaderDAOImpl() {
        super();
    }

    public TOrderLeaderDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TOrderLeaderExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_order_leader.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TOrderLeaderExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_order_leader.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TOrderLeader key = new TOrderLeader();
        key.setId(id);
        int rows = sqlMapClient.delete("t_order_leader.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TOrderLeader record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_order_leader.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TOrderLeader record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_order_leader.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TOrderLeaderExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_order_leader.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TOrderLeader selectByPrimaryKey(Long id) throws SQLException {
        TOrderLeader key = new TOrderLeader();
        key.setId(id);
        TOrderLeader record = (TOrderLeader) sqlMapClient.queryForObject("t_order_leader.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TOrderLeader record, TOrderLeaderExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_order_leader.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TOrderLeader record, TOrderLeaderExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_order_leader.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TOrderLeader record) throws SQLException {
        int rows = sqlMapClient.update("t_order_leader.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TOrderLeader record) throws SQLException {
        int rows = sqlMapClient.update("t_order_leader.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TOrderLeaderExample {
        private Object record;

        public UpdateByExampleParms(Object record, TOrderLeaderExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TOrderLeaderExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_order_leader.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
