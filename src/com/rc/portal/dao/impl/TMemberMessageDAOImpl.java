package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberMessageDAO;
import com.rc.portal.vo.TMemberMessage;
import com.rc.portal.vo.TMemberMessageExample;

public class TMemberMessageDAOImpl implements TMemberMessageDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberMessageDAOImpl() {
        super();
    }

    public TMemberMessageDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberMessageExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_message.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberMessageExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_message.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberMessage key = new TMemberMessage();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_message.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberMessage record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_message.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberMessage record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_message.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberMessageExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_message.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberMessage selectByPrimaryKey(Long id) throws SQLException {
        TMemberMessage key = new TMemberMessage();
        key.setId(id);
        TMemberMessage record = (TMemberMessage) sqlMapClient.queryForObject("t_member_message.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberMessage record, TMemberMessageExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_message.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberMessage record, TMemberMessageExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_message.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberMessage record) throws SQLException {
        int rows = sqlMapClient.update("t_member_message.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberMessage record) throws SQLException {
        int rows = sqlMapClient.update("t_member_message.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberMessageExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberMessageExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberMessageExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_message.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
