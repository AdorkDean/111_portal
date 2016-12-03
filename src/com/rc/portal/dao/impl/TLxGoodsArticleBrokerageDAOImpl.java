package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLxGoodsArticleBrokerageDAO;
import com.rc.portal.vo.TLxGoodsArticleBrokerage;
import com.rc.portal.vo.TLxGoodsArticleBrokerageExample;

public class TLxGoodsArticleBrokerageDAOImpl implements TLxGoodsArticleBrokerageDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLxGoodsArticleBrokerageDAOImpl() {
        super();
    }

    public TLxGoodsArticleBrokerageDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLxGoodsArticleBrokerageExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_lx_goods_article_brokerage.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLxGoodsArticleBrokerageExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_lx_goods_article_brokerage.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLxGoodsArticleBrokerage key = new TLxGoodsArticleBrokerage();
        key.setId(id);
        int rows = sqlMapClient.delete("t_lx_goods_article_brokerage.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLxGoodsArticleBrokerage record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_goods_article_brokerage.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLxGoodsArticleBrokerage record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_goods_article_brokerage.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLxGoodsArticleBrokerageExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_lx_goods_article_brokerage.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLxGoodsArticleBrokerage selectByPrimaryKey(Long id) throws SQLException {
        TLxGoodsArticleBrokerage key = new TLxGoodsArticleBrokerage();
        key.setId(id);
        TLxGoodsArticleBrokerage record = (TLxGoodsArticleBrokerage) sqlMapClient.queryForObject("t_lx_goods_article_brokerage.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLxGoodsArticleBrokerage record, TLxGoodsArticleBrokerageExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_goods_article_brokerage.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLxGoodsArticleBrokerage record, TLxGoodsArticleBrokerageExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_goods_article_brokerage.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLxGoodsArticleBrokerage record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_goods_article_brokerage.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLxGoodsArticleBrokerage record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_goods_article_brokerage.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLxGoodsArticleBrokerageExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLxGoodsArticleBrokerageExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLxGoodsArticleBrokerageExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_lx_goods_article_brokerage.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
