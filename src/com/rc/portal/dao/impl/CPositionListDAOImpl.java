package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.CPositionListDAO;
import com.rc.portal.vo.CPositionList;
import com.rc.portal.vo.CPositionListExample;

public class CPositionListDAOImpl implements CPositionListDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public CPositionListDAOImpl() {
        super();
    }

    public CPositionListDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(CPositionListExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("c_position_list.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(CPositionListExample example) throws SQLException {
        int rows = sqlMapClient.delete("c_position_list.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) throws SQLException {
        CPositionList key = new CPositionList();
        key.setId(id);
        int rows = sqlMapClient.delete("c_position_list.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(CPositionList record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_position_list.ibatorgenerated_insert", record);
    }

    public Long insertSelective(CPositionList record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_position_list.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(CPositionListExample example) throws SQLException {
        List list = sqlMapClient.queryForList("c_position_list.ibatorgenerated_selectByExample", example);
        return list;
    }

    public CPositionList selectByPrimaryKey(Integer id) throws SQLException {
        CPositionList key = new CPositionList();
        key.setId(id);
        CPositionList record = (CPositionList) sqlMapClient.queryForObject("c_position_list.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(CPositionList record, CPositionListExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_position_list.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(CPositionList record, CPositionListExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_position_list.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(CPositionList record) throws SQLException {
        int rows = sqlMapClient.update("c_position_list.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(CPositionList record) throws SQLException {
        int rows = sqlMapClient.update("c_position_list.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends CPositionListExample {
        private Object record;

        public UpdateByExampleParms(Object record, CPositionListExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(CPositionListExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("c_position_list.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
