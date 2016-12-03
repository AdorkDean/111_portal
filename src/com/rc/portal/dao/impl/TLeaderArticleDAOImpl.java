package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLeaderArticleDAO;
import com.rc.portal.vo.TLeaderArticle;
import com.rc.portal.vo.TLeaderArticleExample;

public class TLeaderArticleDAOImpl implements TLeaderArticleDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLeaderArticleDAOImpl() {
        super();
    }

    public TLeaderArticleDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLeaderArticleExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_leader_article.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLeaderArticleExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_leader_article.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLeaderArticle key = new TLeaderArticle();
        key.setId(id);
        int rows = sqlMapClient.delete("t_leader_article.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLeaderArticle record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_article.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLeaderArticle record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_article.ibatorgenerated_insertSelective", record);
    }

    public List selectByExampleWithBLOBs(TLeaderArticleExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_leader_article.ibatorgenerated_selectByExampleWithBLOBs", example);
        return list;
    }

    public List selectByExampleWithoutBLOBs(TLeaderArticleExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_leader_article.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLeaderArticle selectByPrimaryKey(Long id) throws SQLException {
        TLeaderArticle key = new TLeaderArticle();
        key.setId(id);
        TLeaderArticle record = (TLeaderArticle) sqlMapClient.queryForObject("t_leader_article.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLeaderArticle record, TLeaderArticleExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_article.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExampleWithBLOBs(TLeaderArticle record, TLeaderArticleExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_article.ibatorgenerated_updateByExampleWithBLOBs", parms);
        return rows;
    }

    public int updateByExampleWithoutBLOBs(TLeaderArticle record, TLeaderArticleExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_article.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLeaderArticle record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_article.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKeyWithBLOBs(TLeaderArticle record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_article.ibatorgenerated_updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    public int updateByPrimaryKeyWithoutBLOBs(TLeaderArticle record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_article.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLeaderArticleExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLeaderArticleExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLeaderArticleExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_leader_article.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
