package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TCouponDAO;
import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TCouponExample;

public class TCouponDAOImpl implements TCouponDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TCouponDAOImpl() {
        super();
    }

    public TCouponDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TCouponExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_coupon.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TCouponExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_coupon.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TCoupon key = new TCoupon();
        key.setId(id);
        int rows = sqlMapClient.delete("t_coupon.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TCoupon record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_coupon.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TCoupon record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_coupon.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TCouponExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_coupon.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TCoupon selectByPrimaryKey(Long id) throws SQLException {
        TCoupon key = new TCoupon();
        key.setId(id);
        TCoupon record = (TCoupon) sqlMapClient.queryForObject("t_coupon.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TCoupon record, TCouponExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_coupon.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TCoupon record, TCouponExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_coupon.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TCoupon record) throws SQLException {
        int rows = sqlMapClient.update("t_coupon.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TCoupon record) throws SQLException {
        int rows = sqlMapClient.update("t_coupon.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TCouponExample {
        private Object record;

        public UpdateByExampleParms(Object record, TCouponExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TCouponExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_coupon.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
