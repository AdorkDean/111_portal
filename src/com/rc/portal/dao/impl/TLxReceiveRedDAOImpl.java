package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLxReceiveRedDAO;
import com.rc.portal.vo.TLxReceiveRed;
import com.rc.portal.vo.TLxReceiveRedExample;

public class TLxReceiveRedDAOImpl implements TLxReceiveRedDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLxReceiveRedDAOImpl() {
        super();
    }

    public TLxReceiveRedDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLxReceiveRedExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_lx_receive_red.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLxReceiveRedExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_lx_receive_red.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLxReceiveRed key = new TLxReceiveRed();
        key.setId(id);
        int rows = sqlMapClient.delete("t_lx_receive_red.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLxReceiveRed record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_receive_red.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLxReceiveRed record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_receive_red.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLxReceiveRedExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_lx_receive_red.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLxReceiveRed selectByPrimaryKey(Long id) throws SQLException {
        TLxReceiveRed key = new TLxReceiveRed();
        key.setId(id);
        TLxReceiveRed record = (TLxReceiveRed) sqlMapClient.queryForObject("t_lx_receive_red.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLxReceiveRed record, TLxReceiveRedExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_receive_red.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLxReceiveRed record, TLxReceiveRedExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_receive_red.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLxReceiveRed record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_receive_red.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLxReceiveRed record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_receive_red.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLxReceiveRedExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLxReceiveRedExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLxReceiveRedExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_lx_receive_red.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
