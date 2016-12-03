package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TCategoryDAO;
import com.rc.portal.vo.TCategory;
import com.rc.portal.vo.TCategoryExample;

public class TCategoryDAOImpl implements TCategoryDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TCategoryDAOImpl() {
        super();
    }

    public TCategoryDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TCategoryExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_category.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TCategoryExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_category.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TCategory key = new TCategory();
        key.setId(id);
        int rows = sqlMapClient.delete("t_category.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TCategory record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_category.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TCategory record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_category.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TCategoryExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_category.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TCategory selectByPrimaryKey(Long id) throws SQLException {
        TCategory key = new TCategory();
        key.setId(id);
        TCategory record = (TCategory) sqlMapClient.queryForObject("t_category.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TCategory record, TCategoryExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_category.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TCategory record, TCategoryExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_category.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TCategory record) throws SQLException {
        int rows = sqlMapClient.update("t_category.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TCategory record) throws SQLException {
        int rows = sqlMapClient.update("t_category.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TCategoryExample {
        private Object record;

        public UpdateByExampleParms(Object record, TCategoryExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TCategoryExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_category.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
