package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TCouponCardDAO;
import com.rc.portal.vo.TCouponCard;
import com.rc.portal.vo.TCouponCardExample;

public class TCouponCardDAOImpl implements TCouponCardDAO {
   
	
	private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TCouponCardDAOImpl() {
        super();
    }

    public TCouponCardDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TCouponCardExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_coupon_card.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TCouponCardExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_coupon_card.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TCouponCard key = new TCouponCard();
        key.setId(id);
        int rows = sqlMapClient.delete("t_coupon_card.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TCouponCard record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_coupon_card.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TCouponCard record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_coupon_card.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TCouponCardExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_coupon_card.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TCouponCard selectByPrimaryKey(Long id) throws SQLException {
        TCouponCard key = new TCouponCard();
        key.setId(id);
        TCouponCard record = (TCouponCard) sqlMapClient.queryForObject("t_coupon_card.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TCouponCard record, TCouponCardExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_coupon_card.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TCouponCard record, TCouponCardExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_coupon_card.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TCouponCard record) throws SQLException {
        int rows = sqlMapClient.update("t_coupon_card.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TCouponCard record) throws SQLException {
        int rows = sqlMapClient.update("t_coupon_card.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TCouponCardExample {
        private Object record;

        public UpdateByExampleParms(Object record, TCouponCardExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TCouponCardExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_coupon_card.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
