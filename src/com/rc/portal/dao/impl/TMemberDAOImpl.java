package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberDAO;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberExample;

public class TMemberDAOImpl implements TMemberDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberDAOImpl() {
        super();
    }

    public TMemberDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMember key = new TMember();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMember record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMember record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMember selectByPrimaryKey(Long id) throws SQLException {
        TMember key = new TMember();
        key.setId(id);
        TMember record = (TMember) sqlMapClient.queryForObject("t_member.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMember record, TMemberExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMember record, TMemberExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMember record) throws SQLException {
        int rows = sqlMapClient.update("t_member.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMember record) throws SQLException {
        int rows = sqlMapClient.update("t_member.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
