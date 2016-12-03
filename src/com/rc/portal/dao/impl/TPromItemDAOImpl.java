package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TPromItemDAO;
import com.rc.portal.vo.TPromItem;
import com.rc.portal.vo.TPromItemExample;

public class TPromItemDAOImpl implements TPromItemDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TPromItemDAOImpl() {
        super();
    }

    public TPromItemDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TPromItemExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_prom_item.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TPromItemExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_prom_item.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TPromItem key = new TPromItem();
        key.setId(id);
        int rows = sqlMapClient.delete("t_prom_item.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TPromItem record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_prom_item.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TPromItem record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_prom_item.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TPromItemExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_prom_item.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TPromItem selectByPrimaryKey(Long id) throws SQLException {
        TPromItem key = new TPromItem();
        key.setId(id);
        TPromItem record = (TPromItem) sqlMapClient.queryForObject("t_prom_item.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TPromItem record, TPromItemExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_prom_item.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TPromItem record, TPromItemExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_prom_item.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TPromItem record) throws SQLException {
        int rows = sqlMapClient.update("t_prom_item.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TPromItem record) throws SQLException {
        int rows = sqlMapClient.update("t_prom_item.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TPromItemExample {
        private Object record;

        public UpdateByExampleParms(Object record, TPromItemExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TPromItemExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_prom_item.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
