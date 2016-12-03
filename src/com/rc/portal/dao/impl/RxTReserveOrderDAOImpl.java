package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.RxTReserveOrderDAO;
import com.rc.portal.vo.RxTReserveOrder;
import com.rc.portal.vo.RxTReserveOrderExample;

public class RxTReserveOrderDAOImpl implements RxTReserveOrderDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public RxTReserveOrderDAOImpl() {
        super();
    }

    public RxTReserveOrderDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(RxTReserveOrderExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("rx_t_reserve_order.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(RxTReserveOrderExample example) throws SQLException {
        int rows = sqlMapClient.delete("rx_t_reserve_order.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        RxTReserveOrder key = new RxTReserveOrder();
        key.setId(id);
        int rows = sqlMapClient.delete("rx_t_reserve_order.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(RxTReserveOrder record) throws SQLException {
		return (Long)        sqlMapClient.insert("rx_t_reserve_order.ibatorgenerated_insert", record);
    }

    public Long insertSelective(RxTReserveOrder record) throws SQLException {
		return (Long)        sqlMapClient.insert("rx_t_reserve_order.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(RxTReserveOrderExample example) throws SQLException {
        List list = sqlMapClient.queryForList("rx_t_reserve_order.ibatorgenerated_selectByExample", example);
        return list;
    }

    public RxTReserveOrder selectByPrimaryKey(Long id) throws SQLException {
        RxTReserveOrder key = new RxTReserveOrder();
        key.setId(id);
        RxTReserveOrder record = (RxTReserveOrder) sqlMapClient.queryForObject("rx_t_reserve_order.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(RxTReserveOrder record, RxTReserveOrderExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("rx_t_reserve_order.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RxTReserveOrder record, RxTReserveOrderExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("rx_t_reserve_order.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RxTReserveOrder record) throws SQLException {
        int rows = sqlMapClient.update("rx_t_reserve_order.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RxTReserveOrder record) throws SQLException {
        int rows = sqlMapClient.update("rx_t_reserve_order.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends RxTReserveOrderExample {
        private Object record;

        public UpdateByExampleParms(Object record, RxTReserveOrderExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(RxTReserveOrderExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("rx_t_reserve_order.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
