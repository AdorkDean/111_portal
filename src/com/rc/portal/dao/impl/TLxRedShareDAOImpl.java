package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLxRedShareDAO;
import com.rc.portal.vo.TLxRedShare;
import com.rc.portal.vo.TLxRedShareExample;

public class TLxRedShareDAOImpl implements TLxRedShareDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLxRedShareDAOImpl() {
        super();
    }

    public TLxRedShareDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLxRedShareExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_lx_red_share.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLxRedShareExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_lx_red_share.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLxRedShare key = new TLxRedShare();
        key.setId(id);
        int rows = sqlMapClient.delete("t_lx_red_share.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLxRedShare record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_red_share.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLxRedShare record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_red_share.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLxRedShareExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_lx_red_share.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLxRedShare selectByPrimaryKey(Long id) throws SQLException {
        TLxRedShare key = new TLxRedShare();
        key.setId(id);
        TLxRedShare record = (TLxRedShare) sqlMapClient.queryForObject("t_lx_red_share.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLxRedShare record, TLxRedShareExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_red_share.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLxRedShare record, TLxRedShareExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_red_share.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLxRedShare record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_red_share.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLxRedShare record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_red_share.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLxRedShareExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLxRedShareExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLxRedShareExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_lx_red_share.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
