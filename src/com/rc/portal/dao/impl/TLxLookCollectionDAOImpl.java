package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLxLookCollectionDAO;
import com.rc.portal.vo.TLxLookCollection;
import com.rc.portal.vo.TLxLookCollectionExample;

public class TLxLookCollectionDAOImpl implements TLxLookCollectionDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLxLookCollectionDAOImpl() {
        super();
    }

    public TLxLookCollectionDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLxLookCollectionExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_lx_look_collection.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLxLookCollectionExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_lx_look_collection.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLxLookCollection key = new TLxLookCollection();
        key.setId(id);
        int rows = sqlMapClient.delete("t_lx_look_collection.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLxLookCollection record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_look_collection.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLxLookCollection record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_look_collection.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLxLookCollectionExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_lx_look_collection.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLxLookCollection selectByPrimaryKey(Long id) throws SQLException {
        TLxLookCollection key = new TLxLookCollection();
        key.setId(id);
        TLxLookCollection record = (TLxLookCollection) sqlMapClient.queryForObject("t_lx_look_collection.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLxLookCollection record, TLxLookCollectionExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_look_collection.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLxLookCollection record, TLxLookCollectionExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_look_collection.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLxLookCollection record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_look_collection.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLxLookCollection record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_look_collection.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLxLookCollectionExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLxLookCollectionExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLxLookCollectionExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_lx_look_collection.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
