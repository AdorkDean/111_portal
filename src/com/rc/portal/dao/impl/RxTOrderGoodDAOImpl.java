package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.RxTOrderGoodDAO;
import com.rc.portal.vo.RxTOrderGood;
import com.rc.portal.vo.RxTOrderGoodExample;

public class RxTOrderGoodDAOImpl implements RxTOrderGoodDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public RxTOrderGoodDAOImpl() {
        super();
    }

    public RxTOrderGoodDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(RxTOrderGoodExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("rx_t_order_good.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(RxTOrderGoodExample example) throws SQLException {
        int rows = sqlMapClient.delete("rx_t_order_good.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        RxTOrderGood key = new RxTOrderGood();
        key.setId(id);
        int rows = sqlMapClient.delete("rx_t_order_good.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(RxTOrderGood record) throws SQLException {
		return (Long)        sqlMapClient.insert("rx_t_order_good.ibatorgenerated_insert", record);
    }

    public Long insertSelective(RxTOrderGood record) throws SQLException {
		return (Long)        sqlMapClient.insert("rx_t_order_good.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(RxTOrderGoodExample example) throws SQLException {
        List list = sqlMapClient.queryForList("rx_t_order_good.ibatorgenerated_selectByExample", example);
        return list;
    }

    public RxTOrderGood selectByPrimaryKey(Long id) throws SQLException {
        RxTOrderGood key = new RxTOrderGood();
        key.setId(id);
        RxTOrderGood record = (RxTOrderGood) sqlMapClient.queryForObject("rx_t_order_good.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(RxTOrderGood record, RxTOrderGoodExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("rx_t_order_good.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RxTOrderGood record, RxTOrderGoodExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("rx_t_order_good.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RxTOrderGood record) throws SQLException {
        int rows = sqlMapClient.update("rx_t_order_good.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RxTOrderGood record) throws SQLException {
        int rows = sqlMapClient.update("rx_t_order_good.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends RxTOrderGoodExample {
        private Object record;

        public UpdateByExampleParms(Object record, RxTOrderGoodExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(RxTOrderGoodExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("rx_t_order_good.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
