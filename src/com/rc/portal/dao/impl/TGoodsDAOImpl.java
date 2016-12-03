package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TGoodsDAO;
import com.rc.portal.vo.TGoods;
import com.rc.portal.vo.TGoodsExample;

public class TGoodsDAOImpl implements TGoodsDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TGoodsDAOImpl() {
        super();
    }

    public TGoodsDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TGoodsExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_goods.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TGoodsExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_goods.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TGoods key = new TGoods();
        key.setId(id);
        int rows = sqlMapClient.delete("t_goods.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TGoods record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TGoods record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TGoodsExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_goods.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TGoods selectByPrimaryKey(Long id) throws SQLException {
        TGoods key = new TGoods();
        key.setId(id);
        TGoods record = (TGoods) sqlMapClient.queryForObject("t_goods.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TGoods record, TGoodsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TGoods record, TGoodsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TGoods record) throws SQLException {
        int rows = sqlMapClient.update("t_goods.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TGoods record) throws SQLException {
        int rows = sqlMapClient.update("t_goods.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TGoodsExample {
        private Object record;

        public UpdateByExampleParms(Object record, TGoodsExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TGoodsExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_goods.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
