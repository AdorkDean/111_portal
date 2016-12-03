package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLxSendRedDAO;
import com.rc.portal.vo.TLxSendRed;
import com.rc.portal.vo.TLxSendRedExample;

public class TLxSendRedDAOImpl implements TLxSendRedDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLxSendRedDAOImpl() {
        super();
    }

    public TLxSendRedDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLxSendRedExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_lx_send_red.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLxSendRedExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_lx_send_red.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLxSendRed key = new TLxSendRed();
        key.setId(id);
        int rows = sqlMapClient.delete("t_lx_send_red.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLxSendRed record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_send_red.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLxSendRed record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_send_red.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLxSendRedExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_lx_send_red.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLxSendRed selectByPrimaryKey(Long id) throws SQLException {
        TLxSendRed key = new TLxSendRed();
        key.setId(id);
        TLxSendRed record = (TLxSendRed) sqlMapClient.queryForObject("t_lx_send_red.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLxSendRed record, TLxSendRedExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_send_red.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLxSendRed record, TLxSendRedExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_send_red.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLxSendRed record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_send_red.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLxSendRed record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_send_red.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLxSendRedExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLxSendRedExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLxSendRedExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_lx_send_red.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
