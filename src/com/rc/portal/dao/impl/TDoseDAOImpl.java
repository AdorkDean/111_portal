package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TDoseDAO;
import com.rc.portal.vo.TDose;
import com.rc.portal.vo.TDoseExample;

public class TDoseDAOImpl implements TDoseDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TDoseDAOImpl() {
        super();
    }

    public TDoseDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TDoseExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_dose.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TDoseExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_dose.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TDose key = new TDose();
        key.setId(id);
        int rows = sqlMapClient.delete("t_dose.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TDose record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_dose.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TDose record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_dose.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TDoseExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_dose.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TDose selectByPrimaryKey(Long id) throws SQLException {
        TDose key = new TDose();
        key.setId(id);
        TDose record = (TDose) sqlMapClient.queryForObject("t_dose.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TDose record, TDoseExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_dose.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TDose record, TDoseExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_dose.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TDose record) throws SQLException {
        int rows = sqlMapClient.update("t_dose.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TDose record) throws SQLException {
        int rows = sqlMapClient.update("t_dose.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TDoseExample {
        private Object record;

        public UpdateByExampleParms(Object record, TDoseExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TDoseExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_dose.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
