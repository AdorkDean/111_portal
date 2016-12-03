package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberAccountDAO;
import com.rc.portal.vo.TMemberAccount;
import com.rc.portal.vo.TMemberAccountExample;

public class TMemberAccountDAOImpl implements TMemberAccountDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberAccountDAOImpl() {
        super();
    }

    public TMemberAccountDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberAccountExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_account.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberAccountExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_account.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long memberId) throws SQLException {
        TMemberAccount key = new TMemberAccount();
        key.setMemberId(memberId);
        int rows = sqlMapClient.delete("t_member_account.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberAccount record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_account.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberAccount record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_account.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberAccountExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_account.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberAccount selectByPrimaryKey(Long memberId) throws SQLException {
        TMemberAccount key = new TMemberAccount();
        key.setMemberId(memberId);
        TMemberAccount record = (TMemberAccount) sqlMapClient.queryForObject("t_member_account.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberAccount record, TMemberAccountExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_account.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberAccount record, TMemberAccountExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_account.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberAccount record) throws SQLException {
        int rows = sqlMapClient.update("t_member_account.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberAccount record) throws SQLException {
        int rows = sqlMapClient.update("t_member_account.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberAccountExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberAccountExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberAccountExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_account.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
