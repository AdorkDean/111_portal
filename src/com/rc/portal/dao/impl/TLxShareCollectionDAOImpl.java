package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLxShareCollectionDAO;
import com.rc.portal.vo.TLxShareCollection;
import com.rc.portal.vo.TLxShareCollectionExample;

public class TLxShareCollectionDAOImpl implements TLxShareCollectionDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLxShareCollectionDAOImpl() {
        super();
    }

    public TLxShareCollectionDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLxShareCollectionExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_lx_share_collection.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLxShareCollectionExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_lx_share_collection.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLxShareCollection key = new TLxShareCollection();
        key.setId(id);
        int rows = sqlMapClient.delete("t_lx_share_collection.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLxShareCollection record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_share_collection.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLxShareCollection record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_share_collection.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLxShareCollectionExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_lx_share_collection.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLxShareCollection selectByPrimaryKey(Long id) throws SQLException {
        TLxShareCollection key = new TLxShareCollection();
        key.setId(id);
        TLxShareCollection record = (TLxShareCollection) sqlMapClient.queryForObject("t_lx_share_collection.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLxShareCollection record, TLxShareCollectionExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_share_collection.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLxShareCollection record, TLxShareCollectionExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_share_collection.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLxShareCollection record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_share_collection.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLxShareCollection record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_share_collection.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLxShareCollectionExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLxShareCollectionExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLxShareCollectionExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_lx_share_collection.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
