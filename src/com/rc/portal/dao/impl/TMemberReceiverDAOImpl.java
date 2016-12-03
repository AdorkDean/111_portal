package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberReceiverDAO;
import com.rc.portal.vo.TMemberReceiver;
import com.rc.portal.vo.TMemberReceiverExample;

public class TMemberReceiverDAOImpl implements TMemberReceiverDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberReceiverDAOImpl() {
        super();
    }

    public TMemberReceiverDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberReceiverExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_receiver.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberReceiverExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_receiver.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberReceiver key = new TMemberReceiver();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_receiver.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberReceiver record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_receiver.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberReceiver record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_receiver.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberReceiverExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_receiver.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberReceiver selectByPrimaryKey(Long id) throws SQLException {
        TMemberReceiver key = new TMemberReceiver();
        key.setId(id);
        TMemberReceiver record = (TMemberReceiver) sqlMapClient.queryForObject("t_member_receiver.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberReceiver record, TMemberReceiverExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_receiver.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberReceiver record, TMemberReceiverExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_receiver.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberReceiver record) throws SQLException {
        int rows = sqlMapClient.update("t_member_receiver.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberReceiver record) throws SQLException {
        int rows = sqlMapClient.update("t_member_receiver.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberReceiverExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberReceiverExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberReceiverExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_receiver.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
