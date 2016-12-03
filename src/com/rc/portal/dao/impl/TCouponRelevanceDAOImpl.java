package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TCouponRelevanceDAO;
import com.rc.portal.vo.TCouponRelevance;
import com.rc.portal.vo.TCouponRelevanceExample;

public class TCouponRelevanceDAOImpl implements TCouponRelevanceDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TCouponRelevanceDAOImpl() {
        super();
    }

    public TCouponRelevanceDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TCouponRelevanceExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_coupon_relevance.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TCouponRelevanceExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_coupon_relevance.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TCouponRelevance key = new TCouponRelevance();
        key.setId(id);
        int rows = sqlMapClient.delete("t_coupon_relevance.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TCouponRelevance record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_coupon_relevance.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TCouponRelevance record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_coupon_relevance.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TCouponRelevanceExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_coupon_relevance.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TCouponRelevance selectByPrimaryKey(Long id) throws SQLException {
        TCouponRelevance key = new TCouponRelevance();
        key.setId(id);
        TCouponRelevance record = (TCouponRelevance) sqlMapClient.queryForObject("t_coupon_relevance.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TCouponRelevance record, TCouponRelevanceExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_coupon_relevance.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TCouponRelevance record, TCouponRelevanceExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_coupon_relevance.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TCouponRelevance record) throws SQLException {
        int rows = sqlMapClient.update("t_coupon_relevance.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TCouponRelevance record) throws SQLException {
        int rows = sqlMapClient.update("t_coupon_relevance.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TCouponRelevanceExample {
        private Object record;

        public UpdateByExampleParms(Object record, TCouponRelevanceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TCouponRelevanceExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_coupon_relevance.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
