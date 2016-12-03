package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberCertificatesDAO;
import com.rc.portal.vo.TMemberCertificates;
import com.rc.portal.vo.TMemberCertificatesExample;

public class TMemberCertificatesDAOImpl implements TMemberCertificatesDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberCertificatesDAOImpl() {
        super();
    }

    public TMemberCertificatesDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberCertificatesExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_certificates.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberCertificatesExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_certificates.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberCertificates key = new TMemberCertificates();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_certificates.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberCertificates record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_certificates.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberCertificates record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_certificates.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberCertificatesExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_certificates.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberCertificates selectByPrimaryKey(Long id) throws SQLException {
        TMemberCertificates key = new TMemberCertificates();
        key.setId(id);
        TMemberCertificates record = (TMemberCertificates) sqlMapClient.queryForObject("t_member_certificates.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberCertificates record, TMemberCertificatesExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_certificates.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberCertificates record, TMemberCertificatesExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_certificates.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberCertificates record) throws SQLException {
        int rows = sqlMapClient.update("t_member_certificates.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberCertificates record) throws SQLException {
        int rows = sqlMapClient.update("t_member_certificates.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberCertificatesExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberCertificatesExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberCertificatesExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_certificates.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
