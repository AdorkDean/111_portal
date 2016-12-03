package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLeaderGoodsRecommendDAO;
import com.rc.portal.vo.TLeaderGoodsRecommend;
import com.rc.portal.vo.TLeaderGoodsRecommendExample;

public class TLeaderGoodsRecommendDAOImpl implements TLeaderGoodsRecommendDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLeaderGoodsRecommendDAOImpl() {
        super();
    }

    public TLeaderGoodsRecommendDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLeaderGoodsRecommendExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_leader_goods_recommend.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLeaderGoodsRecommendExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_leader_goods_recommend.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLeaderGoodsRecommend key = new TLeaderGoodsRecommend();
        key.setId(id);
        int rows = sqlMapClient.delete("t_leader_goods_recommend.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLeaderGoodsRecommend record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_goods_recommend.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLeaderGoodsRecommend record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_goods_recommend.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLeaderGoodsRecommendExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_leader_goods_recommend.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLeaderGoodsRecommend selectByPrimaryKey(Long id) throws SQLException {
        TLeaderGoodsRecommend key = new TLeaderGoodsRecommend();
        key.setId(id);
        TLeaderGoodsRecommend record = (TLeaderGoodsRecommend) sqlMapClient.queryForObject("t_leader_goods_recommend.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLeaderGoodsRecommend record, TLeaderGoodsRecommendExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_goods_recommend.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLeaderGoodsRecommend record, TLeaderGoodsRecommendExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_goods_recommend.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLeaderGoodsRecommend record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_goods_recommend.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLeaderGoodsRecommend record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_goods_recommend.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLeaderGoodsRecommendExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLeaderGoodsRecommendExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLeaderGoodsRecommendExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_leader_goods_recommend.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
