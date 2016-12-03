package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.CDeliveryWayDAO;
import com.rc.portal.vo.CDeliveryWay;
import com.rc.portal.vo.CDeliveryWayExample;

public class CDeliveryWayDAOImpl implements CDeliveryWayDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public CDeliveryWayDAOImpl() {
        super();
    }

    public CDeliveryWayDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(CDeliveryWayExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("c_delivery_way.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(CDeliveryWayExample example) throws SQLException {
        int rows = sqlMapClient.delete("c_delivery_way.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        CDeliveryWay key = new CDeliveryWay();
        key.setId(id);
        int rows = sqlMapClient.delete("c_delivery_way.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(CDeliveryWay record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_delivery_way.ibatorgenerated_insert", record);
    }

    public Long insertSelective(CDeliveryWay record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_delivery_way.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(CDeliveryWayExample example) throws SQLException {
        List list = sqlMapClient.queryForList("c_delivery_way.ibatorgenerated_selectByExample", example);
        return list;
    }

    public CDeliveryWay selectByPrimaryKey(Long id) throws SQLException {
        CDeliveryWay key = new CDeliveryWay();
        key.setId(id);
        CDeliveryWay record = (CDeliveryWay) sqlMapClient.queryForObject("c_delivery_way.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(CDeliveryWay record, CDeliveryWayExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_delivery_way.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(CDeliveryWay record, CDeliveryWayExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_delivery_way.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(CDeliveryWay record) throws SQLException {
        int rows = sqlMapClient.update("c_delivery_way.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(CDeliveryWay record) throws SQLException {
        int rows = sqlMapClient.update("c_delivery_way.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends CDeliveryWayExample {
        private Object record;

        public UpdateByExampleParms(Object record, CDeliveryWayExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(CDeliveryWayExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("c_delivery_way.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
