package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberYktDAO;
import com.rc.portal.vo.TMemberYkt;
import com.rc.portal.vo.TMemberYktExample;

public class TMemberYktDAOImpl implements TMemberYktDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberYktDAOImpl() {
        super();
    }

    public TMemberYktDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberYktExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_ykt.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberYktExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_ykt.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberYkt key = new TMemberYkt();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_ykt.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberYkt record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_ykt.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberYkt record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_ykt.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberYktExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_ykt.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberYkt selectByPrimaryKey(Long id) throws SQLException {
        TMemberYkt key = new TMemberYkt();
        key.setId(id);
        TMemberYkt record = (TMemberYkt) sqlMapClient.queryForObject("t_member_ykt.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberYkt record, TMemberYktExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_ykt.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberYkt record, TMemberYktExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_ykt.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberYkt record) throws SQLException {
        int rows = sqlMapClient.update("t_member_ykt.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberYkt record) throws SQLException {
        int rows = sqlMapClient.update("t_member_ykt.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberYktExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberYktExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberYktExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_ykt.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
