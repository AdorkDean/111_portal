package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TCartDAO;
import com.rc.portal.vo.TCart;
import com.rc.portal.vo.TCartExample;

public class TCartDAOImpl implements TCartDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TCartDAOImpl() {
        super();
    }

    public TCartDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TCartExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_cart.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TCartExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_cart.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TCart key = new TCart();
        key.setId(id);
        int rows = sqlMapClient.delete("t_cart.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TCart record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_cart.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TCart record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_cart.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TCartExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_cart.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TCart selectByPrimaryKey(Long id) throws SQLException {
        TCart key = new TCart();
        key.setId(id);
        TCart record = (TCart) sqlMapClient.queryForObject("t_cart.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TCart record, TCartExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_cart.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TCart record, TCartExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_cart.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TCart record) throws SQLException {
        int rows = sqlMapClient.update("t_cart.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TCart record) throws SQLException {
        int rows = sqlMapClient.update("t_cart.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TCartExample {
        private Object record;

        public UpdateByExampleParms(Object record, TCartExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TCartExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_cart.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
