package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberThreeBindingDAO;
import com.rc.portal.vo.TMemberThreeBinding;
import com.rc.portal.vo.TMemberThreeBindingExample;

public class TMemberThreeBindingDAOImpl implements TMemberThreeBindingDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberThreeBindingDAOImpl() {
        super();
    }

    public TMemberThreeBindingDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberThreeBindingExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_three_binding.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberThreeBindingExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_three_binding.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberThreeBinding key = new TMemberThreeBinding();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_three_binding.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberThreeBinding record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_three_binding.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberThreeBinding record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_three_binding.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberThreeBindingExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_three_binding.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberThreeBinding selectByPrimaryKey(Long id) throws SQLException {
        TMemberThreeBinding key = new TMemberThreeBinding();
        key.setId(id);
        TMemberThreeBinding record = (TMemberThreeBinding) sqlMapClient.queryForObject("t_member_three_binding.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberThreeBinding record, TMemberThreeBindingExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_three_binding.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberThreeBinding record, TMemberThreeBindingExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_three_binding.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberThreeBinding record) throws SQLException {
        int rows = sqlMapClient.update("t_member_three_binding.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberThreeBinding record) throws SQLException {
        int rows = sqlMapClient.update("t_member_three_binding.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberThreeBindingExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberThreeBindingExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberThreeBindingExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_three_binding.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
