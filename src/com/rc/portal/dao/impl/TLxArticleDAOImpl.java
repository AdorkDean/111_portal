package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLxArticleDAO;
import com.rc.portal.vo.TLxArticle;
import com.rc.portal.vo.TLxArticleExample;
import com.rc.portal.vo.TLxArticleWithBLOBs;

public class TLxArticleDAOImpl implements TLxArticleDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLxArticleDAOImpl() {
        super();
    }

    public TLxArticleDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLxArticleExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_lx_article.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLxArticleExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_lx_article.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) throws SQLException {
        TLxArticle key = new TLxArticle();
        key.setId(id);
        int rows = sqlMapClient.delete("t_lx_article.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLxArticleWithBLOBs record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_article.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLxArticleWithBLOBs record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_article.ibatorgenerated_insertSelective", record);
    }

    public List selectByExampleWithBLOBs(TLxArticleExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_lx_article.ibatorgenerated_selectByExampleWithBLOBs", example);
        return list;
    }

    public List selectByExampleWithoutBLOBs(TLxArticleExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_lx_article.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLxArticleWithBLOBs selectByPrimaryKey(Integer id) throws SQLException {
        TLxArticle key = new TLxArticle();
        key.setId(id);
        TLxArticleWithBLOBs record = (TLxArticleWithBLOBs) sqlMapClient.queryForObject("t_lx_article.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLxArticleWithBLOBs record, TLxArticleExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_article.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLxArticleWithBLOBs record, TLxArticleExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_article.ibatorgenerated_updateByExampleWithBLOBs", parms);
        return rows;
    }

    public int updateByExample(TLxArticle record, TLxArticleExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_article.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLxArticleWithBLOBs record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_article.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLxArticleWithBLOBs record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_article.ibatorgenerated_updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    public int updateByPrimaryKey(TLxArticle record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_article.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLxArticleExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLxArticleExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLxArticleExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_lx_article.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
