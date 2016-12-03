package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.CImageDAO;
import com.rc.portal.vo.CImage;
import com.rc.portal.vo.CImageExample;

public class CImageDAOImpl implements CImageDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public CImageDAOImpl() {
        super();
    }

    public CImageDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(CImageExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("c_image.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(CImageExample example) throws SQLException {
        int rows = sqlMapClient.delete("c_image.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) throws SQLException {
        CImage key = new CImage();
        key.setId(id);
        int rows = sqlMapClient.delete("c_image.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(CImage record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_image.ibatorgenerated_insert", record);
    }

    public Long insertSelective(CImage record) throws SQLException {
		return (Long)        sqlMapClient.insert("c_image.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(CImageExample example) throws SQLException {
        List list = sqlMapClient.queryForList("c_image.ibatorgenerated_selectByExample", example);
        return list;
    }

    public CImage selectByPrimaryKey(Integer id) throws SQLException {
        CImage key = new CImage();
        key.setId(id);
        CImage record = (CImage) sqlMapClient.queryForObject("c_image.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(CImage record, CImageExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_image.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(CImage record, CImageExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("c_image.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(CImage record) throws SQLException {
        int rows = sqlMapClient.update("c_image.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(CImage record) throws SQLException {
        int rows = sqlMapClient.update("c_image.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends CImageExample {
        private Object record;

        public UpdateByExampleParms(Object record, CImageExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(CImageExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("c_image.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
