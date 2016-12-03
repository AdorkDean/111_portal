package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberHobbyDAO;
import com.rc.portal.vo.TMemberHobby;
import com.rc.portal.vo.TMemberHobbyExample;

public class TMemberHobbyDAOImpl implements TMemberHobbyDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberHobbyDAOImpl() {
        super();
    }

    public TMemberHobbyDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberHobbyExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_hobby.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberHobbyExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_hobby.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long memberId) throws SQLException {
        TMemberHobby key = new TMemberHobby();
        key.setMemberId(memberId);
        int rows = sqlMapClient.delete("t_member_hobby.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberHobby record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_hobby.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberHobby record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_hobby.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberHobbyExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_hobby.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberHobby selectByPrimaryKey(Long memberId) throws SQLException {
        TMemberHobby key = new TMemberHobby();
        key.setMemberId(memberId);
        TMemberHobby record = (TMemberHobby) sqlMapClient.queryForObject("t_member_hobby.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberHobby record, TMemberHobbyExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_hobby.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberHobby record, TMemberHobbyExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_hobby.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberHobby record) throws SQLException {
        int rows = sqlMapClient.update("t_member_hobby.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberHobby record) throws SQLException {
        int rows = sqlMapClient.update("t_member_hobby.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberHobbyExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberHobbyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberHobbyExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_hobby.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
