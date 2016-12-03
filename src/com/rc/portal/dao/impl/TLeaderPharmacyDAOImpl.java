package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLeaderPharmacyDAO;
import com.rc.portal.vo.TLeaderPharmacy;
import com.rc.portal.vo.TLeaderPharmacyExample;

public class TLeaderPharmacyDAOImpl implements TLeaderPharmacyDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLeaderPharmacyDAOImpl() {
        super();
    }

    public TLeaderPharmacyDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLeaderPharmacyExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_leader_pharmacy.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLeaderPharmacyExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_leader_pharmacy.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLeaderPharmacy key = new TLeaderPharmacy();
        key.setId(id);
        int rows = sqlMapClient.delete("t_leader_pharmacy.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLeaderPharmacy record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_pharmacy.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLeaderPharmacy record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_pharmacy.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLeaderPharmacyExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_leader_pharmacy.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLeaderPharmacy selectByPrimaryKey(Long id) throws SQLException {
        TLeaderPharmacy key = new TLeaderPharmacy();
        key.setId(id);
        TLeaderPharmacy record = (TLeaderPharmacy) sqlMapClient.queryForObject("t_leader_pharmacy.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLeaderPharmacy record, TLeaderPharmacyExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_pharmacy.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLeaderPharmacy record, TLeaderPharmacyExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_pharmacy.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLeaderPharmacy record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_pharmacy.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLeaderPharmacy record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_pharmacy.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLeaderPharmacyExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLeaderPharmacyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLeaderPharmacyExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_leader_pharmacy.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
