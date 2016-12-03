package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TCustomerCallDAO;
import com.rc.portal.vo.TCustomerCall;
import com.rc.portal.vo.TCustomerCallExample;

public class TCustomerCallDAOImpl implements TCustomerCallDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TCustomerCallDAOImpl() {
        super();
    }

    public TCustomerCallDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TCustomerCallExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_customer_call.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TCustomerCallExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_customer_call.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TCustomerCall key = new TCustomerCall();
        key.setId(id);
        int rows = sqlMapClient.delete("t_customer_call.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TCustomerCall record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_customer_call.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TCustomerCall record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_customer_call.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TCustomerCallExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_customer_call.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TCustomerCall selectByPrimaryKey(Long id) throws SQLException {
        TCustomerCall key = new TCustomerCall();
        key.setId(id);
        TCustomerCall record = (TCustomerCall) sqlMapClient.queryForObject("t_customer_call.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TCustomerCall record, TCustomerCallExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_customer_call.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TCustomerCall record, TCustomerCallExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_customer_call.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TCustomerCall record) throws SQLException {
        int rows = sqlMapClient.update("t_customer_call.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TCustomerCall record) throws SQLException {
        int rows = sqlMapClient.update("t_customer_call.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TCustomerCallExample {
        private Object record;

        public UpdateByExampleParms(Object record, TCustomerCallExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TCustomerCallExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_customer_call.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
