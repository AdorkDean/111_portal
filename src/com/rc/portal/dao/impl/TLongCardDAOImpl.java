package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLongCardDAO;
import com.rc.portal.vo.TLongCard;
import com.rc.portal.vo.TLongCardExample;

public class TLongCardDAOImpl implements TLongCardDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLongCardDAOImpl() {
        super();
    }

    public TLongCardDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLongCardExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_long_card.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLongCardExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_long_card.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLongCard key = new TLongCard();
        key.setId(id);
        int rows = sqlMapClient.delete("t_long_card.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLongCard record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_long_card.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLongCard record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_long_card.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLongCardExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_long_card.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLongCard selectByPrimaryKey(Long id) throws SQLException {
        TLongCard key = new TLongCard();
        key.setId(id);
        TLongCard record = (TLongCard) sqlMapClient.queryForObject("t_long_card.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLongCard record, TLongCardExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_long_card.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLongCard record, TLongCardExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_long_card.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLongCard record) throws SQLException {
        int rows = sqlMapClient.update("t_long_card.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLongCard record) throws SQLException {
        int rows = sqlMapClient.update("t_long_card.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLongCardExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLongCardExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLongCardExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_long_card.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
