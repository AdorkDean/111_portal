package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberLeaderDAO;
import com.rc.portal.vo.TMemberLeader;
import com.rc.portal.vo.TMemberLeaderExample;

public class TMemberLeaderDAOImpl implements TMemberLeaderDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberLeaderDAOImpl() {
        super();
    }

    public TMemberLeaderDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberLeaderExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_leader.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberLeaderExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_leader.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberLeader key = new TMemberLeader();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_leader.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberLeader record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_leader.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberLeader record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_leader.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberLeaderExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_leader.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberLeader selectByPrimaryKey(Long id) throws SQLException {
        TMemberLeader key = new TMemberLeader();
        key.setId(id);
        TMemberLeader record = (TMemberLeader) sqlMapClient.queryForObject("t_member_leader.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberLeader record, TMemberLeaderExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_leader.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberLeader record, TMemberLeaderExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_leader.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberLeader record) throws SQLException {
        int rows = sqlMapClient.update("t_member_leader.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberLeader record) throws SQLException {
        int rows = sqlMapClient.update("t_member_leader.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberLeaderExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberLeaderExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberLeaderExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_leader.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
