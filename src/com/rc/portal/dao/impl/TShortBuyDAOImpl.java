package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TShortBuyDAO;
import com.rc.portal.vo.TShortBuy;
import com.rc.portal.vo.TShortBuyExample;

public class TShortBuyDAOImpl implements TShortBuyDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TShortBuyDAOImpl() {
        super();
    }

    public TShortBuyDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TShortBuyExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_short_buy.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TShortBuyExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_short_buy.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TShortBuy key = new TShortBuy();
        key.setId(id);
        int rows = sqlMapClient.delete("t_short_buy.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TShortBuy record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_short_buy.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TShortBuy record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_short_buy.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TShortBuyExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_short_buy.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TShortBuy selectByPrimaryKey(Long id) throws SQLException {
        TShortBuy key = new TShortBuy();
        key.setId(id);
        TShortBuy record = (TShortBuy) sqlMapClient.queryForObject("t_short_buy.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TShortBuy record, TShortBuyExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_short_buy.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TShortBuy record, TShortBuyExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_short_buy.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TShortBuy record) throws SQLException {
        int rows = sqlMapClient.update("t_short_buy.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TShortBuy record) throws SQLException {
        int rows = sqlMapClient.update("t_short_buy.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TShortBuyExample {
        private Object record;

        public UpdateByExampleParms(Object record, TShortBuyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TShortBuyExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_short_buy.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
