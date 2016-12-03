package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TBrandDAO;
import com.rc.portal.vo.TBrand;
import com.rc.portal.vo.TBrandExample;

public class TBrandDAOImpl implements TBrandDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TBrandDAOImpl() {
        super();
    }

    public TBrandDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TBrandExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_brand.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TBrandExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_brand.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TBrand key = new TBrand();
        key.setId(id);
        int rows = sqlMapClient.delete("t_brand.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TBrand record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_brand.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TBrand record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_brand.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TBrandExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_brand.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TBrand selectByPrimaryKey(Long id) throws SQLException {
        TBrand key = new TBrand();
        key.setId(id);
        TBrand record = (TBrand) sqlMapClient.queryForObject("t_brand.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TBrand record, TBrandExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_brand.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TBrand record, TBrandExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_brand.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TBrand record) throws SQLException {
        int rows = sqlMapClient.update("t_brand.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TBrand record) throws SQLException {
        int rows = sqlMapClient.update("t_brand.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TBrandExample {
        private Object record;

        public UpdateByExampleParms(Object record, TBrandExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TBrandExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_brand.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
