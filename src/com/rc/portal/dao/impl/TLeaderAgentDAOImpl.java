package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLeaderAgentDAO;
import com.rc.portal.vo.TLeaderAgent;
import com.rc.portal.vo.TLeaderAgentExample;

public class TLeaderAgentDAOImpl implements TLeaderAgentDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLeaderAgentDAOImpl() {
        super();
    }

    public TLeaderAgentDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLeaderAgentExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_leader_agent.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLeaderAgentExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_leader_agent.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLeaderAgent key = new TLeaderAgent();
        key.setId(id);
        int rows = sqlMapClient.delete("t_leader_agent.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLeaderAgent record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_agent.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLeaderAgent record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_agent.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLeaderAgentExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_leader_agent.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLeaderAgent selectByPrimaryKey(Long id) throws SQLException {
        TLeaderAgent key = new TLeaderAgent();
        key.setId(id);
        TLeaderAgent record = (TLeaderAgent) sqlMapClient.queryForObject("t_leader_agent.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLeaderAgent record, TLeaderAgentExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_agent.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLeaderAgent record, TLeaderAgentExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_agent.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLeaderAgent record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_agent.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLeaderAgent record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_agent.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLeaderAgentExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLeaderAgentExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLeaderAgentExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_leader_agent.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
