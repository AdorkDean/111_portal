package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TGroupGoodsDAO;
import com.rc.portal.vo.TGroupGoods;
import com.rc.portal.vo.TGroupGoodsExample;

public class TGroupGoodsDAOImpl implements TGroupGoodsDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TGroupGoodsDAOImpl() {
        super();
    }

    public TGroupGoodsDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TGroupGoodsExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_group_goods.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TGroupGoodsExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_group_goods.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TGroupGoods key = new TGroupGoods();
        key.setId(id);
        int rows = sqlMapClient.delete("t_group_goods.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TGroupGoods record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_group_goods.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TGroupGoods record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_group_goods.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TGroupGoodsExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_group_goods.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TGroupGoods selectByPrimaryKey(Long id) throws SQLException {
        TGroupGoods key = new TGroupGoods();
        key.setId(id);
        TGroupGoods record = (TGroupGoods) sqlMapClient.queryForObject("t_group_goods.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TGroupGoods record, TGroupGoodsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_group_goods.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TGroupGoods record, TGroupGoodsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_group_goods.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TGroupGoods record) throws SQLException {
        int rows = sqlMapClient.update("t_group_goods.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TGroupGoods record) throws SQLException {
        int rows = sqlMapClient.update("t_group_goods.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TGroupGoodsExample {
        private Object record;

        public UpdateByExampleParms(Object record, TGroupGoodsExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TGroupGoodsExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_group_goods.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
