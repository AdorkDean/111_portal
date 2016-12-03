package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.YktGoodsDAO;
import com.rc.portal.vo.YktGoods;
import com.rc.portal.vo.YktGoodsExample;

public class YktGoodsDAOImpl implements YktGoodsDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public YktGoodsDAOImpl() {
        super();
    }

    public YktGoodsDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(YktGoodsExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("ykt_goods.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(YktGoodsExample example) throws SQLException {
        int rows = sqlMapClient.delete("ykt_goods.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        YktGoods key = new YktGoods();
        key.setId(id);
        int rows = sqlMapClient.delete("ykt_goods.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(YktGoods record) throws SQLException {
		return (Long)        sqlMapClient.insert("ykt_goods.ibatorgenerated_insert", record);
    }

    public Long insertSelective(YktGoods record) throws SQLException {
		return (Long)        sqlMapClient.insert("ykt_goods.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(YktGoodsExample example) throws SQLException {
        List list = sqlMapClient.queryForList("ykt_goods.ibatorgenerated_selectByExample", example);
        return list;
    }

    public YktGoods selectByPrimaryKey(Long id) throws SQLException {
        YktGoods key = new YktGoods();
        key.setId(id);
        YktGoods record = (YktGoods) sqlMapClient.queryForObject("ykt_goods.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(YktGoods record, YktGoodsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("ykt_goods.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(YktGoods record, YktGoodsExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("ykt_goods.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(YktGoods record) throws SQLException {
        int rows = sqlMapClient.update("ykt_goods.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(YktGoods record) throws SQLException {
        int rows = sqlMapClient.update("ykt_goods.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends YktGoodsExample {
        private Object record;

        public UpdateByExampleParms(Object record, YktGoodsExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(YktGoodsExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("ykt_goods.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
