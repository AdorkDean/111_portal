package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TShortGoodsDAO;
import com.rc.portal.vo.TShortGoods;
import com.rc.portal.vo.TShortGoodsExample;

public class TShortGoodsDAOImpl implements TShortGoodsDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TShortGoodsDAOImpl() {
        super();
    }

    public TShortGoodsDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TShortGoodsExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_short_goods.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TShortGoodsExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_short_goods.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TShortGoods key = new TShortGoods();
        key.setId(id);
        int rows = sqlMapClient.delete("t_short_goods.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TShortGoods record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_short_goods.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TShortGoods record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_short_goods.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TShortGoodsExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_short_goods.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TShortGoods selectByPrimaryKey(Long id) throws SQLException {
        TShortGoods key = new TShortGoods();
        key.setId(id);
        TShortGoods record = (TShortGoods) sqlMapClient.queryForObject("t_short_goods.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TShortGoods record, TShortGoodsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_short_goods.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TShortGoods record, TShortGoodsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_short_goods.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TShortGoods record) throws SQLException {
        int rows = sqlMapClient.update("t_short_goods.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TShortGoods record) throws SQLException {
        int rows = sqlMapClient.update("t_short_goods.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TShortGoodsExample {
        private Object record;

        public UpdateByExampleParms(Object record, TShortGoodsExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TShortGoodsExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_short_goods.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
