package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TFreightDAO;
import com.rc.portal.vo.TFreight;
import com.rc.portal.vo.TFreightExample;

public class TFreightDAOImpl implements TFreightDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TFreightDAOImpl() {
        super();
    }

    public TFreightDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TFreightExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_freight.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TFreightExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_freight.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TFreight key = new TFreight();
        key.setId(id);
        int rows = sqlMapClient.delete("t_freight.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TFreight record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_freight.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TFreight record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_freight.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TFreightExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_freight.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TFreight selectByPrimaryKey(Long id) throws SQLException {
        TFreight key = new TFreight();
        key.setId(id);
        TFreight record = (TFreight) sqlMapClient.queryForObject("t_freight.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TFreight record, TFreightExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_freight.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TFreight record, TFreightExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_freight.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TFreight record) throws SQLException {
        int rows = sqlMapClient.update("t_freight.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TFreight record) throws SQLException {
        int rows = sqlMapClient.update("t_freight.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TFreightExample {
        private Object record;

        public UpdateByExampleParms(Object record, TFreightExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TFreightExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_freight.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
