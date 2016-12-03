package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TCartItemDAO;
import com.rc.portal.vo.TCartItem;
import com.rc.portal.vo.TCartItemExample;

public class TCartItemDAOImpl implements TCartItemDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TCartItemDAOImpl() {
        super();
    }

    public TCartItemDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TCartItemExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_cart_item.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TCartItemExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_cart_item.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TCartItem key = new TCartItem();
        key.setId(id);
        int rows = sqlMapClient.delete("t_cart_item.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TCartItem record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_cart_item.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TCartItem record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_cart_item.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TCartItemExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_cart_item.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TCartItem selectByPrimaryKey(Long id) throws SQLException {
        TCartItem key = new TCartItem();
        key.setId(id);
        TCartItem record = (TCartItem) sqlMapClient.queryForObject("t_cart_item.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TCartItem record, TCartItemExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_cart_item.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TCartItem record, TCartItemExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_cart_item.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TCartItem record) throws SQLException {
        int rows = sqlMapClient.update("t_cart_item.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TCartItem record) throws SQLException {
        int rows = sqlMapClient.update("t_cart_item.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TCartItemExample {
        private Object record;

        public UpdateByExampleParms(Object record, TCartItemExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TCartItemExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_cart_item.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
