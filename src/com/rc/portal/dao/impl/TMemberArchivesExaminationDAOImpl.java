package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberArchivesExaminationDAO;
import com.rc.portal.vo.TMemberArchivesExamination;
import com.rc.portal.vo.TMemberArchivesExaminationExample;

public class TMemberArchivesExaminationDAOImpl implements TMemberArchivesExaminationDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberArchivesExaminationDAOImpl() {
        super();
    }

    public TMemberArchivesExaminationDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberArchivesExaminationExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_archives_examination.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberArchivesExaminationExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_archives_examination.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberArchivesExamination key = new TMemberArchivesExamination();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_archives_examination.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberArchivesExamination record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_archives_examination.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberArchivesExamination record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_archives_examination.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberArchivesExaminationExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_archives_examination.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberArchivesExamination selectByPrimaryKey(Long id) throws SQLException {
        TMemberArchivesExamination key = new TMemberArchivesExamination();
        key.setId(id);
        TMemberArchivesExamination record = (TMemberArchivesExamination) sqlMapClient.queryForObject("t_member_archives_examination.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberArchivesExamination record, TMemberArchivesExaminationExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_archives_examination.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberArchivesExamination record, TMemberArchivesExaminationExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_archives_examination.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberArchivesExamination record) throws SQLException {
        int rows = sqlMapClient.update("t_member_archives_examination.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberArchivesExamination record) throws SQLException {
        int rows = sqlMapClient.update("t_member_archives_examination.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberArchivesExaminationExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberArchivesExaminationExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberArchivesExaminationExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_archives_examination.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
