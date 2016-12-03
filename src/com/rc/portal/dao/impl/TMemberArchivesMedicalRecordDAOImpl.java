package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberArchivesMedicalRecordDAO;
import com.rc.portal.vo.TMemberArchivesMedicalRecord;
import com.rc.portal.vo.TMemberArchivesMedicalRecordExample;

public class TMemberArchivesMedicalRecordDAOImpl implements TMemberArchivesMedicalRecordDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberArchivesMedicalRecordDAOImpl() {
        super();
    }

    public TMemberArchivesMedicalRecordDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberArchivesMedicalRecordExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_archives_medical_record.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberArchivesMedicalRecordExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_archives_medical_record.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberArchivesMedicalRecord key = new TMemberArchivesMedicalRecord();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_archives_medical_record.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberArchivesMedicalRecord record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_archives_medical_record.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberArchivesMedicalRecord record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_archives_medical_record.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberArchivesMedicalRecordExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_archives_medical_record.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberArchivesMedicalRecord selectByPrimaryKey(Long id) throws SQLException {
        TMemberArchivesMedicalRecord key = new TMemberArchivesMedicalRecord();
        key.setId(id);
        TMemberArchivesMedicalRecord record = (TMemberArchivesMedicalRecord) sqlMapClient.queryForObject("t_member_archives_medical_record.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberArchivesMedicalRecord record, TMemberArchivesMedicalRecordExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_archives_medical_record.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberArchivesMedicalRecord record, TMemberArchivesMedicalRecordExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_archives_medical_record.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberArchivesMedicalRecord record) throws SQLException {
        int rows = sqlMapClient.update("t_member_archives_medical_record.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberArchivesMedicalRecord record) throws SQLException {
        int rows = sqlMapClient.update("t_member_archives_medical_record.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberArchivesMedicalRecordExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberArchivesMedicalRecordExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberArchivesMedicalRecordExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_archives_medical_record.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
