package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberBalanceDAO;
import com.rc.portal.vo.TMemberBalance;
import com.rc.portal.vo.TMemberBalanceExample;

public class TMemberBalanceDAOImpl implements TMemberBalanceDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberBalanceDAOImpl() {
        super();
    }

    public TMemberBalanceDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberBalanceExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_balance.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberBalanceExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_balance.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberBalance key = new TMemberBalance();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_balance.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberBalance record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_balance.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberBalance record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_balance.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberBalanceExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_balance.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberBalance selectByPrimaryKey(Long id) throws SQLException {
        TMemberBalance key = new TMemberBalance();
        key.setId(id);
        TMemberBalance record = (TMemberBalance) sqlMapClient.queryForObject("t_member_balance.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberBalance record, TMemberBalanceExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_balance.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberBalance record, TMemberBalanceExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_balance.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberBalance record) throws SQLException {
        int rows = sqlMapClient.update("t_member_balance.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberBalance record) throws SQLException {
        int rows = sqlMapClient.update("t_member_balance.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberBalanceExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberBalanceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberBalanceExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_balance.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
