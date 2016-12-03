package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLeaderQrCodeDAO;
import com.rc.portal.vo.TLeaderQrCode;
import com.rc.portal.vo.TLeaderQrCodeExample;

public class TLeaderQrCodeDAOImpl implements TLeaderQrCodeDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLeaderQrCodeDAOImpl() {
        super();
    }

    public TLeaderQrCodeDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLeaderQrCodeExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_leader_qr_code.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLeaderQrCodeExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_leader_qr_code.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLeaderQrCode key = new TLeaderQrCode();
        key.setId(id);
        int rows = sqlMapClient.delete("t_leader_qr_code.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLeaderQrCode record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_qr_code.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLeaderQrCode record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_qr_code.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLeaderQrCodeExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_leader_qr_code.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLeaderQrCode selectByPrimaryKey(Long id) throws SQLException {
        TLeaderQrCode key = new TLeaderQrCode();
        key.setId(id);
        TLeaderQrCode record = (TLeaderQrCode) sqlMapClient.queryForObject("t_leader_qr_code.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLeaderQrCode record, TLeaderQrCodeExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_qr_code.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLeaderQrCode record, TLeaderQrCodeExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_qr_code.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLeaderQrCode record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_qr_code.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLeaderQrCode record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_qr_code.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLeaderQrCodeExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLeaderQrCodeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLeaderQrCodeExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_leader_qr_code.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
