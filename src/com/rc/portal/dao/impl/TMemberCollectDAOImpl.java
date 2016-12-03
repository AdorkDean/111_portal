package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberCollectDAO;
import com.rc.portal.vo.TMemberCollect;
import com.rc.portal.vo.TMemberCollectExample;

public class TMemberCollectDAOImpl implements TMemberCollectDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberCollectDAOImpl() {
        super();
    }

    public TMemberCollectDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberCollectExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_collect.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberCollectExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_collect.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberCollect key = new TMemberCollect();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_collect.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberCollect record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_collect.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberCollect record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_collect.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberCollectExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_collect.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberCollect selectByPrimaryKey(Long id) throws SQLException {
        TMemberCollect key = new TMemberCollect();
        key.setId(id);
        TMemberCollect record = (TMemberCollect) sqlMapClient.queryForObject("t_member_collect.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberCollect record, TMemberCollectExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_collect.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberCollect record, TMemberCollectExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_collect.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberCollect record) throws SQLException {
        int rows = sqlMapClient.update("t_member_collect.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberCollect record) throws SQLException {
        int rows = sqlMapClient.update("t_member_collect.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberCollectExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberCollectExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberCollectExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_collect.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
