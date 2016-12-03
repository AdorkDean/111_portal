package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.RxTOrderDAO;
import com.rc.portal.vo.RxTOrder;
import com.rc.portal.vo.RxTOrderExample;

public class RxTOrderDAOImpl implements RxTOrderDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public RxTOrderDAOImpl() {
        super();
    }

    public RxTOrderDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(RxTOrderExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("rx_t_order.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(RxTOrderExample example) throws SQLException {
        int rows = sqlMapClient.delete("rx_t_order.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        RxTOrder key = new RxTOrder();
        key.setId(id);
        int rows = sqlMapClient.delete("rx_t_order.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(RxTOrder record) throws SQLException {
		return (Long)        sqlMapClient.insert("rx_t_order.ibatorgenerated_insert", record);
    }

    public Long insertSelective(RxTOrder record) throws SQLException {
		return (Long)        sqlMapClient.insert("rx_t_order.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(RxTOrderExample example) throws SQLException {
        List list = sqlMapClient.queryForList("rx_t_order.ibatorgenerated_selectByExample", example);
        return list;
    }

    public RxTOrder selectByPrimaryKey(Long id) throws SQLException {
        RxTOrder key = new RxTOrder();
        key.setId(id);
        RxTOrder record = (RxTOrder) sqlMapClient.queryForObject("rx_t_order.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(RxTOrder record, RxTOrderExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("rx_t_order.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RxTOrder record, RxTOrderExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("rx_t_order.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RxTOrder record) throws SQLException {
        int rows = sqlMapClient.update("rx_t_order.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RxTOrder record) throws SQLException {
        int rows = sqlMapClient.update("rx_t_order.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends RxTOrderExample {
        private Object record;

        public UpdateByExampleParms(Object record, RxTOrderExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(RxTOrderExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("rx_t_order.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
