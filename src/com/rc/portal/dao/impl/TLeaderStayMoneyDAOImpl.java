package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLeaderStayMoneyDAO;
import com.rc.portal.vo.TLeaderStayMoney;
import com.rc.portal.vo.TLeaderStayMoneyExample;

public class TLeaderStayMoneyDAOImpl implements TLeaderStayMoneyDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLeaderStayMoneyDAOImpl() {
        super();
    }

    public TLeaderStayMoneyDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLeaderStayMoneyExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_leader_stay_money.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLeaderStayMoneyExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_leader_stay_money.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLeaderStayMoney key = new TLeaderStayMoney();
        key.setId(id);
        int rows = sqlMapClient.delete("t_leader_stay_money.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLeaderStayMoney record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_stay_money.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLeaderStayMoney record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_stay_money.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLeaderStayMoneyExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_leader_stay_money.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLeaderStayMoney selectByPrimaryKey(Long id) throws SQLException {
        TLeaderStayMoney key = new TLeaderStayMoney();
        key.setId(id);
        TLeaderStayMoney record = (TLeaderStayMoney) sqlMapClient.queryForObject("t_leader_stay_money.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLeaderStayMoney record, TLeaderStayMoneyExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_stay_money.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLeaderStayMoney record, TLeaderStayMoneyExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_stay_money.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLeaderStayMoney record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_stay_money.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLeaderStayMoney record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_stay_money.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLeaderStayMoneyExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLeaderStayMoneyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLeaderStayMoneyExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_leader_stay_money.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
