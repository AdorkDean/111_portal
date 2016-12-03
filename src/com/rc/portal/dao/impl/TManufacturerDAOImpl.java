package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TManufacturerDAO;
import com.rc.portal.vo.TManufacturer;
import com.rc.portal.vo.TManufacturerExample;

public class TManufacturerDAOImpl implements TManufacturerDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TManufacturerDAOImpl() {
        super();
    }

    public TManufacturerDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TManufacturerExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_manufacturer.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TManufacturerExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_manufacturer.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TManufacturer key = new TManufacturer();
        key.setId(id);
        int rows = sqlMapClient.delete("t_manufacturer.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TManufacturer record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_manufacturer.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TManufacturer record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_manufacturer.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TManufacturerExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_manufacturer.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TManufacturer selectByPrimaryKey(Long id) throws SQLException {
        TManufacturer key = new TManufacturer();
        key.setId(id);
        TManufacturer record = (TManufacturer) sqlMapClient.queryForObject("t_manufacturer.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TManufacturer record, TManufacturerExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_manufacturer.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TManufacturer record, TManufacturerExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_manufacturer.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TManufacturer record) throws SQLException {
        int rows = sqlMapClient.update("t_manufacturer.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TManufacturer record) throws SQLException {
        int rows = sqlMapClient.update("t_manufacturer.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TManufacturerExample {
        private Object record;

        public UpdateByExampleParms(Object record, TManufacturerExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TManufacturerExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_manufacturer.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
