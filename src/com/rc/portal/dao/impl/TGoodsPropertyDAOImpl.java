package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TGoodsPropertyDAO;
import com.rc.portal.vo.TGoodsProperty;
import com.rc.portal.vo.TGoodsPropertyExample;

public class TGoodsPropertyDAOImpl implements TGoodsPropertyDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TGoodsPropertyDAOImpl() {
        super();
    }

    public TGoodsPropertyDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TGoodsPropertyExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_goods_property.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TGoodsPropertyExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_goods_property.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public Long insert(TGoodsProperty record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods_property.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TGoodsProperty record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods_property.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TGoodsPropertyExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_goods_property.ibatorgenerated_selectByExample", example);
        return list;
    }

    public int updateByExampleSelective(TGoodsProperty record, TGoodsPropertyExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods_property.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TGoodsProperty record, TGoodsPropertyExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods_property.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends TGoodsPropertyExample {
        private Object record;

        public UpdateByExampleParms(Object record, TGoodsPropertyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TGoodsPropertyExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_goods_property.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
