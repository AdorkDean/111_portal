package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TPhysicianDAO;
import com.rc.portal.vo.TPhysician;
import com.rc.portal.vo.TPhysicianExample;

public class TPhysicianDAOImpl implements TPhysicianDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TPhysicianDAOImpl() {
        super();
    }

    public TPhysicianDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TPhysicianExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_physician.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TPhysicianExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_physician.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TPhysician key = new TPhysician();
        key.setId(id);
        int rows = sqlMapClient.delete("t_physician.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TPhysician record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_physician.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TPhysician record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_physician.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TPhysicianExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_physician.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TPhysician selectByPrimaryKey(Long id) throws SQLException {
        TPhysician key = new TPhysician();
        key.setId(id);
        TPhysician record = (TPhysician) sqlMapClient.queryForObject("t_physician.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TPhysician record, TPhysicianExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_physician.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TPhysician record, TPhysicianExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_physician.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TPhysician record) throws SQLException {
        int rows = sqlMapClient.update("t_physician.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TPhysician record) throws SQLException {
        int rows = sqlMapClient.update("t_physician.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TPhysicianExample {
        private Object record;

        public UpdateByExampleParms(Object record, TPhysicianExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TPhysicianExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_physician.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
