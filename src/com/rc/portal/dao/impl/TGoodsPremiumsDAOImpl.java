package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TGoodsPremiumsDAO;
import com.rc.portal.vo.TGoodsPremiums;
import com.rc.portal.vo.TGoodsPremiumsExample;

public class TGoodsPremiumsDAOImpl implements TGoodsPremiumsDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TGoodsPremiumsDAOImpl() {
        super();
    }

    public TGoodsPremiumsDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TGoodsPremiumsExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_goods_premiums.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TGoodsPremiumsExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_goods_premiums.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TGoodsPremiums key = new TGoodsPremiums();
        key.setId(id);
        int rows = sqlMapClient.delete("t_goods_premiums.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TGoodsPremiums record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods_premiums.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TGoodsPremiums record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods_premiums.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TGoodsPremiumsExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_goods_premiums.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TGoodsPremiums selectByPrimaryKey(Long id) throws SQLException {
        TGoodsPremiums key = new TGoodsPremiums();
        key.setId(id);
        TGoodsPremiums record = (TGoodsPremiums) sqlMapClient.queryForObject("t_goods_premiums.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TGoodsPremiums record, TGoodsPremiumsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods_premiums.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TGoodsPremiums record, TGoodsPremiumsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods_premiums.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TGoodsPremiums record) throws SQLException {
        int rows = sqlMapClient.update("t_goods_premiums.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TGoodsPremiums record) throws SQLException {
        int rows = sqlMapClient.update("t_goods_premiums.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TGoodsPremiumsExample {
        private Object record;

        public UpdateByExampleParms(Object record, TGoodsPremiumsExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TGoodsPremiumsExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_goods_premiums.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
