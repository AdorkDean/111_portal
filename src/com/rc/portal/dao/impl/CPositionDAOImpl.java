package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.CPositionDAO;
import com.rc.portal.vo.CPosition;
import com.rc.portal.vo.CPositionExample;

public class CPositionDAOImpl implements CPositionDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public CPositionDAOImpl() {
        super();
    }

    public CPositionDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(CPositionExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("c_position.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(CPositionExample example) throws SQLException {
        int rows = sqlMapClient.delete("c_position.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) throws SQLException {
        CPosition key = new CPosition();
        key.setId(id);
        int rows = sqlMapClient.delete("c_position.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(CPosition record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_position.ibatorgenerated_insert", record);
    }

    public Long insertSelective(CPosition record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_position.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(CPositionExample example) throws SQLException {
        List list = sqlMapClient.queryForList("c_position.ibatorgenerated_selectByExample", example);
        return list;
    }

    public CPosition selectByPrimaryKey(Integer id) throws SQLException {
        CPosition key = new CPosition();
        key.setId(id);
        CPosition record = (CPosition) sqlMapClient.queryForObject("c_position.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(CPosition record, CPositionExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_position.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(CPosition record, CPositionExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_position.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(CPosition record) throws SQLException {
        int rows = sqlMapClient.update("c_position.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(CPosition record) throws SQLException {
        int rows = sqlMapClient.update("c_position.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends CPositionExample {
        private Object record;

        public UpdateByExampleParms(Object record, CPositionExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(CPositionExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("c_position.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
