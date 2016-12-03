package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TPharmacistDAO;
import com.rc.portal.vo.TPharmacist;
import com.rc.portal.vo.TPharmacistExample;

public class TPharmacistDAOImpl implements TPharmacistDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TPharmacistDAOImpl() {
        super();
    }

    public TPharmacistDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TPharmacistExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_pharmacist.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TPharmacistExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_pharmacist.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TPharmacist key = new TPharmacist();
        key.setId(id);
        int rows = sqlMapClient.delete("t_pharmacist.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TPharmacist record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_pharmacist.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TPharmacist record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_pharmacist.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TPharmacistExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_pharmacist.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TPharmacist selectByPrimaryKey(Long id) throws SQLException {
        TPharmacist key = new TPharmacist();
        key.setId(id);
        TPharmacist record = (TPharmacist) sqlMapClient.queryForObject("t_pharmacist.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TPharmacist record, TPharmacistExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_pharmacist.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TPharmacist record, TPharmacistExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_pharmacist.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TPharmacist record) throws SQLException {
        int rows = sqlMapClient.update("t_pharmacist.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TPharmacist record) throws SQLException {
        int rows = sqlMapClient.update("t_pharmacist.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TPharmacistExample {
        private Object record;

        public UpdateByExampleParms(Object record, TPharmacistExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TPharmacistExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_pharmacist.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
