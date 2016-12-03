package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TOrderShipmentDAO;
import com.rc.portal.vo.TOrderShipment;
import com.rc.portal.vo.TOrderShipmentExample;

public class TOrderShipmentDAOImpl implements TOrderShipmentDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TOrderShipmentDAOImpl() {
        super();
    }

    public TOrderShipmentDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TOrderShipmentExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_order_shipment.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TOrderShipmentExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_order_shipment.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TOrderShipment key = new TOrderShipment();
        key.setId(id);
        int rows = sqlMapClient.delete("t_order_shipment.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TOrderShipment record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_order_shipment.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TOrderShipment record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_order_shipment.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TOrderShipmentExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_order_shipment.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TOrderShipment selectByPrimaryKey(Long id) throws SQLException {
        TOrderShipment key = new TOrderShipment();
        key.setId(id);
        TOrderShipment record = (TOrderShipment) sqlMapClient.queryForObject("t_order_shipment.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TOrderShipment record, TOrderShipmentExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_order_shipment.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TOrderShipment record, TOrderShipmentExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_order_shipment.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TOrderShipment record) throws SQLException {
        int rows = sqlMapClient.update("t_order_shipment.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TOrderShipment record) throws SQLException {
        int rows = sqlMapClient.update("t_order_shipment.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TOrderShipmentExample {
        private Object record;

        public UpdateByExampleParms(Object record, TOrderShipmentExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TOrderShipmentExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_order_shipment.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
