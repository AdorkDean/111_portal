package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLeaderAccountNumberDAO;
import com.rc.portal.vo.TLeaderAccountNumber;
import com.rc.portal.vo.TLeaderAccountNumberExample;

public class TLeaderAccountNumberDAOImpl implements TLeaderAccountNumberDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLeaderAccountNumberDAOImpl() {
        super();
    }

    public TLeaderAccountNumberDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLeaderAccountNumberExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_leader_account_number.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLeaderAccountNumberExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_leader_account_number.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLeaderAccountNumber key = new TLeaderAccountNumber();
        key.setId(id);
        int rows = sqlMapClient.delete("t_leader_account_number.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLeaderAccountNumber record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_account_number.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLeaderAccountNumber record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_account_number.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLeaderAccountNumberExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_leader_account_number.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLeaderAccountNumber selectByPrimaryKey(Long id) throws SQLException {
        TLeaderAccountNumber key = new TLeaderAccountNumber();
        key.setId(id);
        TLeaderAccountNumber record = (TLeaderAccountNumber) sqlMapClient.queryForObject("t_leader_account_number.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLeaderAccountNumber record, TLeaderAccountNumberExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_account_number.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLeaderAccountNumber record, TLeaderAccountNumberExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_account_number.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLeaderAccountNumber record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_account_number.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLeaderAccountNumber record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_account_number.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLeaderAccountNumberExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLeaderAccountNumberExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLeaderAccountNumberExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_leader_account_number.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
