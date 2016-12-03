package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLxContentDAO;
import com.rc.portal.vo.TLxContent;
import com.rc.portal.vo.TLxContentExample;

public class TLxContentDAOImpl implements TLxContentDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLxContentDAOImpl() {
        super();
    }

    public TLxContentDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLxContentExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_lx_content.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLxContentExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_lx_content.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLxContent key = new TLxContent();
        key.setId(id);
        int rows = sqlMapClient.delete("t_lx_content.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLxContent record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_content.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLxContent record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_content.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLxContentExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_lx_content.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLxContent selectByPrimaryKey(Long id) throws SQLException {
        TLxContent key = new TLxContent();
        key.setId(id);
        TLxContent record = (TLxContent) sqlMapClient.queryForObject("t_lx_content.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLxContent record, TLxContentExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_content.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLxContent record, TLxContentExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_content.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLxContent record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_content.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLxContent record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_content.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLxContentExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLxContentExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLxContentExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_lx_content.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
