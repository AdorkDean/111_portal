package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLeaderArticleGoodsDAO;
import com.rc.portal.vo.TLeaderArticleGoods;
import com.rc.portal.vo.TLeaderArticleGoodsExample;

public class TLeaderArticleGoodsDAOImpl implements TLeaderArticleGoodsDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLeaderArticleGoodsDAOImpl() {
        super();
    }

    public TLeaderArticleGoodsDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLeaderArticleGoodsExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_leader_article_goods.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLeaderArticleGoodsExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_leader_article_goods.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLeaderArticleGoods key = new TLeaderArticleGoods();
        key.setId(id);
        int rows = sqlMapClient.delete("t_leader_article_goods.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLeaderArticleGoods record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_article_goods.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLeaderArticleGoods record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_article_goods.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLeaderArticleGoodsExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_leader_article_goods.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLeaderArticleGoods selectByPrimaryKey(Long id) throws SQLException {
        TLeaderArticleGoods key = new TLeaderArticleGoods();
        key.setId(id);
        TLeaderArticleGoods record = (TLeaderArticleGoods) sqlMapClient.queryForObject("t_leader_article_goods.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLeaderArticleGoods record, TLeaderArticleGoodsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_article_goods.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLeaderArticleGoods record, TLeaderArticleGoodsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_article_goods.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLeaderArticleGoods record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_article_goods.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLeaderArticleGoods record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_article_goods.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLeaderArticleGoodsExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLeaderArticleGoodsExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLeaderArticleGoodsExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_leader_article_goods.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
