package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberGradeDAO;
import com.rc.portal.vo.TMemberGrade;
import com.rc.portal.vo.TMemberGradeExample;

public class TMemberGradeDAOImpl implements TMemberGradeDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberGradeDAOImpl() {
        super();
    }

    public TMemberGradeDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberGradeExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_grade.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberGradeExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_grade.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberGrade key = new TMemberGrade();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_grade.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberGrade record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_grade.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberGrade record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_grade.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberGradeExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_grade.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberGrade selectByPrimaryKey(Long id) throws SQLException {
        TMemberGrade key = new TMemberGrade();
        key.setId(id);
        TMemberGrade record = (TMemberGrade) sqlMapClient.queryForObject("t_member_grade.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberGrade record, TMemberGradeExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_grade.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberGrade record, TMemberGradeExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_grade.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberGrade record) throws SQLException {
        int rows = sqlMapClient.update("t_member_grade.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberGrade record) throws SQLException {
        int rows = sqlMapClient.update("t_member_grade.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberGradeExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberGradeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberGradeExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_grade.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
