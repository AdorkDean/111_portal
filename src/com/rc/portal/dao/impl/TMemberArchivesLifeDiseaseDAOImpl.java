package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberArchivesLifeDiseaseDAO;
import com.rc.portal.vo.TMemberArchivesLifeDisease;
import com.rc.portal.vo.TMemberArchivesLifeDiseaseExample;

public class TMemberArchivesLifeDiseaseDAOImpl implements TMemberArchivesLifeDiseaseDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberArchivesLifeDiseaseDAOImpl() {
        super();
    }

    public TMemberArchivesLifeDiseaseDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberArchivesLifeDiseaseExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_archives_life_disease.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberArchivesLifeDiseaseExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_archives_life_disease.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberArchivesLifeDisease key = new TMemberArchivesLifeDisease();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_archives_life_disease.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberArchivesLifeDisease record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_archives_life_disease.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberArchivesLifeDisease record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_archives_life_disease.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberArchivesLifeDiseaseExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_archives_life_disease.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberArchivesLifeDisease selectByPrimaryKey(Long id) throws SQLException {
        TMemberArchivesLifeDisease key = new TMemberArchivesLifeDisease();
        key.setId(id);
        TMemberArchivesLifeDisease record = (TMemberArchivesLifeDisease) sqlMapClient.queryForObject("t_member_archives_life_disease.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberArchivesLifeDisease record, TMemberArchivesLifeDiseaseExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_archives_life_disease.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberArchivesLifeDisease record, TMemberArchivesLifeDiseaseExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_archives_life_disease.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberArchivesLifeDisease record) throws SQLException {
        int rows = sqlMapClient.update("t_member_archives_life_disease.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberArchivesLifeDisease record) throws SQLException {
        int rows = sqlMapClient.update("t_member_archives_life_disease.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberArchivesLifeDiseaseExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberArchivesLifeDiseaseExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberArchivesLifeDiseaseExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_archives_life_disease.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
