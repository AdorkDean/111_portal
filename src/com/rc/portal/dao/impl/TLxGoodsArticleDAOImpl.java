package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLxGoodsArticleDAO;
import com.rc.portal.vo.TLxGoodsArticle;
import com.rc.portal.vo.TLxGoodsArticleExample;

public class TLxGoodsArticleDAOImpl implements TLxGoodsArticleDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLxGoodsArticleDAOImpl() {
        super();
    }

    public TLxGoodsArticleDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLxGoodsArticleExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_lx_goods_article.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLxGoodsArticleExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_lx_goods_article.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLxGoodsArticle key = new TLxGoodsArticle();
        key.setId(id);
        int rows = sqlMapClient.delete("t_lx_goods_article.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLxGoodsArticle record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_goods_article.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLxGoodsArticle record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_goods_article.ibatorgenerated_insertSelective", record);
    }

    public List selectByExampleWithBLOBs(TLxGoodsArticleExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_lx_goods_article.ibatorgenerated_selectByExampleWithBLOBs", example);
        return list;
    }

    public List selectByExampleWithoutBLOBs(TLxGoodsArticleExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_lx_goods_article.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLxGoodsArticle selectByPrimaryKey(Long id) throws SQLException {
        TLxGoodsArticle key = new TLxGoodsArticle();
        key.setId(id);
        TLxGoodsArticle record = (TLxGoodsArticle) sqlMapClient.queryForObject("t_lx_goods_article.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLxGoodsArticle record, TLxGoodsArticleExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_goods_article.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExampleWithBLOBs(TLxGoodsArticle record, TLxGoodsArticleExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_goods_article.ibatorgenerated_updateByExampleWithBLOBs", parms);
        return rows;
    }

    public int updateByExampleWithoutBLOBs(TLxGoodsArticle record, TLxGoodsArticleExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_goods_article.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLxGoodsArticle record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_goods_article.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKeyWithBLOBs(TLxGoodsArticle record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_goods_article.ibatorgenerated_updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    public int updateByPrimaryKeyWithoutBLOBs(TLxGoodsArticle record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_goods_article.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLxGoodsArticleExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLxGoodsArticleExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLxGoodsArticleExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_lx_goods_article.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
