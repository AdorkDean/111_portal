package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLeaderDAO;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TLeaderExample;

public class TLeaderDAOImpl implements TLeaderDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLeaderDAOImpl() {
        super();
    }

    public TLeaderDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLeaderExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_leader.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLeaderExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_leader.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLeader key = new TLeader();
        key.setId(id);
        int rows = sqlMapClient.delete("t_leader.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLeader record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLeader record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLeaderExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_leader.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLeader selectByPrimaryKey(Long id) throws SQLException {
        TLeader key = new TLeader();
        key.setId(id);
        TLeader record = (TLeader) sqlMapClient.queryForObject("t_leader.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLeader record, TLeaderExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLeader record, TLeaderExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLeader record) throws SQLException {
        int rows = sqlMapClient.update("t_leader.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLeader record) throws SQLException {
        int rows = sqlMapClient.update("t_leader.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLeaderExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLeaderExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLeaderExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_leader.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
