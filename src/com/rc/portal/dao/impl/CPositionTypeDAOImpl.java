package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.CPositionTypeDAO;
import com.rc.portal.vo.CPositionType;
import com.rc.portal.vo.CPositionTypeExample;

public class CPositionTypeDAOImpl implements CPositionTypeDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public CPositionTypeDAOImpl() {
        super();
    }

    public CPositionTypeDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(CPositionTypeExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("c_position_type.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(CPositionTypeExample example) throws SQLException {
        int rows = sqlMapClient.delete("c_position_type.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        CPositionType key = new CPositionType();
        key.setId(id);
        int rows = sqlMapClient.delete("c_position_type.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(CPositionType record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_position_type.ibatorgenerated_insert", record);
    }

    public Long insertSelective(CPositionType record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_position_type.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(CPositionTypeExample example) throws SQLException {
        List list = sqlMapClient.queryForList("c_position_type.ibatorgenerated_selectByExample", example);
        return list;
    }

    public CPositionType selectByPrimaryKey(Long id) throws SQLException {
        CPositionType key = new CPositionType();
        key.setId(id);
        CPositionType record = (CPositionType) sqlMapClient.queryForObject("c_position_type.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(CPositionType record, CPositionTypeExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_position_type.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(CPositionType record, CPositionTypeExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_position_type.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(CPositionType record) throws SQLException {
        int rows = sqlMapClient.update("c_position_type.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(CPositionType record) throws SQLException {
        int rows = sqlMapClient.update("c_position_type.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends CPositionTypeExample {
        private Object record;

        public UpdateByExampleParms(Object record, CPositionTypeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(CPositionTypeExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("c_position_type.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
