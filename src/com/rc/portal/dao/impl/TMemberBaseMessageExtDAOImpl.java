package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberBaseMessageExtDAO;
import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.vo.TMemberBaseMessageExtExample;

public class TMemberBaseMessageExtDAOImpl implements TMemberBaseMessageExtDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberBaseMessageExtDAOImpl() {
        super();
    }

    public TMemberBaseMessageExtDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberBaseMessageExtExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_base_message_ext.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberBaseMessageExtExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_base_message_ext.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long memberId) throws SQLException {
        TMemberBaseMessageExt key = new TMemberBaseMessageExt();
        key.setMemberId(memberId);
        int rows = sqlMapClient.delete("t_member_base_message_ext.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberBaseMessageExt record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_base_message_ext.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberBaseMessageExt record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_base_message_ext.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberBaseMessageExtExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_base_message_ext.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberBaseMessageExt selectByPrimaryKey(Long memberId) throws SQLException {
        TMemberBaseMessageExt key = new TMemberBaseMessageExt();
        key.setMemberId(memberId);
        TMemberBaseMessageExt record = (TMemberBaseMessageExt) sqlMapClient.queryForObject("t_member_base_message_ext.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberBaseMessageExt record, TMemberBaseMessageExtExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_base_message_ext.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberBaseMessageExt record, TMemberBaseMessageExtExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_base_message_ext.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberBaseMessageExt record) throws SQLException {
        int rows = sqlMapClient.update("t_member_base_message_ext.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberBaseMessageExt record) throws SQLException {
        int rows = sqlMapClient.update("t_member_base_message_ext.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberBaseMessageExtExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberBaseMessageExtExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberBaseMessageExtExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_base_message_ext.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
