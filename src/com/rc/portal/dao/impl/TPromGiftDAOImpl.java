package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TPromGiftDAO;
import com.rc.portal.vo.TPromGift;
import com.rc.portal.vo.TPromGiftExample;

public class TPromGiftDAOImpl implements TPromGiftDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TPromGiftDAOImpl() {
        super();
    }

    public TPromGiftDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TPromGiftExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_prom_gift.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TPromGiftExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_prom_gift.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TPromGift key = new TPromGift();
        key.setId(id);
        int rows = sqlMapClient.delete("t_prom_gift.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TPromGift record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_prom_gift.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TPromGift record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_prom_gift.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TPromGiftExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_prom_gift.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TPromGift selectByPrimaryKey(Long id) throws SQLException {
        TPromGift key = new TPromGift();
        key.setId(id);
        TPromGift record = (TPromGift) sqlMapClient.queryForObject("t_prom_gift.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TPromGift record, TPromGiftExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_prom_gift.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TPromGift record, TPromGiftExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_prom_gift.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TPromGift record) throws SQLException {
        int rows = sqlMapClient.update("t_prom_gift.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TPromGift record) throws SQLException {
        int rows = sqlMapClient.update("t_prom_gift.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TPromGiftExample {
        private Object record;

        public UpdateByExampleParms(Object record, TPromGiftExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TPromGiftExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_prom_gift.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
