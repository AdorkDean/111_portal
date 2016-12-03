package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TGoodsPriceDAO;
import com.rc.portal.vo.TGoodsPrice;
import com.rc.portal.vo.TGoodsPriceExample;

public class TGoodsPriceDAOImpl implements TGoodsPriceDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TGoodsPriceDAOImpl() {
        super();
    }

    public TGoodsPriceDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TGoodsPriceExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_goods_price.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TGoodsPriceExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_goods_price.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TGoodsPrice key = new TGoodsPrice();
        key.setId(id);
        int rows = sqlMapClient.delete("t_goods_price.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TGoodsPrice record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods_price.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TGoodsPrice record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods_price.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TGoodsPriceExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_goods_price.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TGoodsPrice selectByPrimaryKey(Long id) throws SQLException {
        TGoodsPrice key = new TGoodsPrice();
        key.setId(id);
        TGoodsPrice record = (TGoodsPrice) sqlMapClient.queryForObject("t_goods_price.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TGoodsPrice record, TGoodsPriceExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods_price.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TGoodsPrice record, TGoodsPriceExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods_price.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TGoodsPrice record) throws SQLException {
        int rows = sqlMapClient.update("t_goods_price.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TGoodsPrice record) throws SQLException {
        int rows = sqlMapClient.update("t_goods_price.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TGoodsPriceExample {
        private Object record;

        public UpdateByExampleParms(Object record, TGoodsPriceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TGoodsPriceExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_goods_price.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
