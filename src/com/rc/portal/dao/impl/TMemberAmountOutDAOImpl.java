package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberAmountOutDAO;
import com.rc.portal.vo.TMemberAmountOut;
import com.rc.portal.vo.TMemberAmountOutExample;

public class TMemberAmountOutDAOImpl implements TMemberAmountOutDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberAmountOutDAOImpl() {
        super();
    }

    public TMemberAmountOutDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberAmountOutExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_amount_out.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberAmountOutExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_amount_out.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberAmountOut key = new TMemberAmountOut();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_amount_out.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberAmountOut record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_amount_out.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberAmountOut record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_amount_out.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberAmountOutExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_amount_out.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberAmountOut selectByPrimaryKey(Long id) throws SQLException {
        TMemberAmountOut key = new TMemberAmountOut();
        key.setId(id);
        TMemberAmountOut record = (TMemberAmountOut) sqlMapClient.queryForObject("t_member_amount_out.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberAmountOut record, TMemberAmountOutExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_amount_out.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberAmountOut record, TMemberAmountOutExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_amount_out.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberAmountOut record) throws SQLException {
        int rows = sqlMapClient.update("t_member_amount_out.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberAmountOut record) throws SQLException {
        int rows = sqlMapClient.update("t_member_amount_out.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberAmountOutExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberAmountOutExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberAmountOutExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_amount_out.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
