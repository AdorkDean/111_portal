package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLeaderImageDAO;
import com.rc.portal.vo.TLeaderImage;
import com.rc.portal.vo.TLeaderImageExample;

public class TLeaderImageDAOImpl implements TLeaderImageDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLeaderImageDAOImpl() {
        super();
    }

    public TLeaderImageDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLeaderImageExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_leader_image.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLeaderImageExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_leader_image.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLeaderImage key = new TLeaderImage();
        key.setId(id);
        int rows = sqlMapClient.delete("t_leader_image.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLeaderImage record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_image.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLeaderImage record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_leader_image.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLeaderImageExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_leader_image.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLeaderImage selectByPrimaryKey(Long id) throws SQLException {
        TLeaderImage key = new TLeaderImage();
        key.setId(id);
        TLeaderImage record = (TLeaderImage) sqlMapClient.queryForObject("t_leader_image.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLeaderImage record, TLeaderImageExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_image.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLeaderImage record, TLeaderImageExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_leader_image.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLeaderImage record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_image.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLeaderImage record) throws SQLException {
        int rows = sqlMapClient.update("t_leader_image.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLeaderImageExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLeaderImageExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLeaderImageExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_leader_image.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
