package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TGroupGoodsKeywordDAO;
import com.rc.portal.vo.TGroupGoodsKeyword;
import com.rc.portal.vo.TGroupGoodsKeywordExample;

public class TGroupGoodsKeywordDAOImpl implements TGroupGoodsKeywordDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TGroupGoodsKeywordDAOImpl() {
        super();
    }

    public TGroupGoodsKeywordDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TGroupGoodsKeywordExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_group_goods_keyword.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TGroupGoodsKeywordExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_group_goods_keyword.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TGroupGoodsKeyword key = new TGroupGoodsKeyword();
        key.setId(id);
        int rows = sqlMapClient.delete("t_group_goods_keyword.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TGroupGoodsKeyword record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_group_goods_keyword.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TGroupGoodsKeyword record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_group_goods_keyword.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TGroupGoodsKeywordExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_group_goods_keyword.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TGroupGoodsKeyword selectByPrimaryKey(Long id) throws SQLException {
        TGroupGoodsKeyword key = new TGroupGoodsKeyword();
        key.setId(id);
        TGroupGoodsKeyword record = (TGroupGoodsKeyword) sqlMapClient.queryForObject("t_group_goods_keyword.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TGroupGoodsKeyword record, TGroupGoodsKeywordExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_group_goods_keyword.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TGroupGoodsKeyword record, TGroupGoodsKeywordExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_group_goods_keyword.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TGroupGoodsKeyword record) throws SQLException {
        int rows = sqlMapClient.update("t_group_goods_keyword.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TGroupGoodsKeyword record) throws SQLException {
        int rows = sqlMapClient.update("t_group_goods_keyword.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TGroupGoodsKeywordExample {
        private Object record;

        public UpdateByExampleParms(Object record, TGroupGoodsKeywordExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TGroupGoodsKeywordExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_group_goods_keyword.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
