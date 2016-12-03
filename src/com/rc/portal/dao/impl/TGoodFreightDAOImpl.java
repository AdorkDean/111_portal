package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TGoodFreightDAO;
import com.rc.portal.vo.TGoodFreight;
import com.rc.portal.vo.TGoodFreightExample;

public class TGoodFreightDAOImpl implements TGoodFreightDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TGoodFreightDAOImpl() {
        super();
    }

    public TGoodFreightDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TGoodFreightExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_good_freight.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TGoodFreightExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_good_freight.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TGoodFreight key = new TGoodFreight();
        key.setId(id);
        int rows = sqlMapClient.delete("t_good_freight.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TGoodFreight record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_good_freight.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TGoodFreight record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_good_freight.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TGoodFreightExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_good_freight.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TGoodFreight selectByPrimaryKey(Long id) throws SQLException {
        TGoodFreight key = new TGoodFreight();
        key.setId(id);
        TGoodFreight record = (TGoodFreight) sqlMapClient.queryForObject("t_good_freight.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TGoodFreight record, TGoodFreightExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_good_freight.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TGoodFreight record, TGoodFreightExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_good_freight.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TGoodFreight record) throws SQLException {
        int rows = sqlMapClient.update("t_good_freight.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TGoodFreight record) throws SQLException {
        int rows = sqlMapClient.update("t_good_freight.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TGoodFreightExample {
        private Object record;

        public UpdateByExampleParms(Object record, TGoodFreightExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TGoodFreightExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_good_freight.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
