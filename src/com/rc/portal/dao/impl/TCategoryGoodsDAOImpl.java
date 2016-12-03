package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TCategoryGoodsDAO;
import com.rc.portal.vo.TCategoryGoods;
import com.rc.portal.vo.TCategoryGoodsExample;

public class TCategoryGoodsDAOImpl implements TCategoryGoodsDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TCategoryGoodsDAOImpl() {
        super();
    }

    public TCategoryGoodsDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TCategoryGoodsExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_category_goods.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TCategoryGoodsExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_category_goods.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TCategoryGoods key = new TCategoryGoods();
        key.setId(id);
        int rows = sqlMapClient.delete("t_category_goods.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TCategoryGoods record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_category_goods.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TCategoryGoods record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_category_goods.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TCategoryGoodsExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_category_goods.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TCategoryGoods selectByPrimaryKey(Long id) throws SQLException {
        TCategoryGoods key = new TCategoryGoods();
        key.setId(id);
        TCategoryGoods record = (TCategoryGoods) sqlMapClient.queryForObject("t_category_goods.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TCategoryGoods record, TCategoryGoodsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_category_goods.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TCategoryGoods record, TCategoryGoodsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_category_goods.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TCategoryGoods record) throws SQLException {
        int rows = sqlMapClient.update("t_category_goods.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TCategoryGoods record) throws SQLException {
        int rows = sqlMapClient.update("t_category_goods.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TCategoryGoodsExample {
        private Object record;

        public UpdateByExampleParms(Object record, TCategoryGoodsExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TCategoryGoodsExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_category_goods.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
