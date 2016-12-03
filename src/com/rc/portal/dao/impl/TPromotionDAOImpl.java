package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TPromotionDAO;
import com.rc.portal.vo.TPromotion;
import com.rc.portal.vo.TPromotionExample;

public class TPromotionDAOImpl implements TPromotionDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TPromotionDAOImpl() {
        super();
    }

    public TPromotionDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TPromotionExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_promotion.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TPromotionExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_promotion.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TPromotion key = new TPromotion();
        key.setId(id);
        int rows = sqlMapClient.delete("t_promotion.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TPromotion record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_promotion.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TPromotion record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_promotion.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TPromotionExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_promotion.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TPromotion selectByPrimaryKey(Long id) throws SQLException {
        TPromotion key = new TPromotion();
        key.setId(id);
        TPromotion record = (TPromotion) sqlMapClient.queryForObject("t_promotion.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TPromotion record, TPromotionExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_promotion.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TPromotion record, TPromotionExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_promotion.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TPromotion record) throws SQLException {
        int rows = sqlMapClient.update("t_promotion.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TPromotion record) throws SQLException {
        int rows = sqlMapClient.update("t_promotion.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TPromotionExample {
        private Object record;

        public UpdateByExampleParms(Object record, TPromotionExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TPromotionExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_promotion.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
