package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TGoodsBrokerageDAO;
import com.rc.portal.vo.TGoodsBrokerage;
import com.rc.portal.vo.TGoodsBrokerageExample;

public class TGoodsBrokerageDAOImpl implements TGoodsBrokerageDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TGoodsBrokerageDAOImpl() {
        super();
    }

    public TGoodsBrokerageDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TGoodsBrokerageExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_goods_brokerage.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TGoodsBrokerageExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_goods_brokerage.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TGoodsBrokerage key = new TGoodsBrokerage();
        key.setId(id);
        int rows = sqlMapClient.delete("t_goods_brokerage.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TGoodsBrokerage record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods_brokerage.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TGoodsBrokerage record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods_brokerage.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TGoodsBrokerageExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_goods_brokerage.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TGoodsBrokerage selectByPrimaryKey(Long id) throws SQLException {
        TGoodsBrokerage key = new TGoodsBrokerage();
        key.setId(id);
        TGoodsBrokerage record = (TGoodsBrokerage) sqlMapClient.queryForObject("t_goods_brokerage.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TGoodsBrokerage record, TGoodsBrokerageExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods_brokerage.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TGoodsBrokerage record, TGoodsBrokerageExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods_brokerage.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TGoodsBrokerage record) throws SQLException {
        int rows = sqlMapClient.update("t_goods_brokerage.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TGoodsBrokerage record) throws SQLException {
        int rows = sqlMapClient.update("t_goods_brokerage.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TGoodsBrokerageExample {
        private Object record;

        public UpdateByExampleParms(Object record, TGoodsBrokerageExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TGoodsBrokerageExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_goods_brokerage.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}

	//查询最高的返佣商品
	public List select(int pageSize) throws SQLException {
		List list = sqlMapClient.queryForList("t_goods_brokerage.selectLeaderGoodsListDesc", null);
		return list;
	}
}
