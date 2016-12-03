package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TLxAnnouncementDAO;
import com.rc.portal.vo.TLxAnnouncement;
import com.rc.portal.vo.TLxAnnouncementExample;

public class TLxAnnouncementDAOImpl implements TLxAnnouncementDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TLxAnnouncementDAOImpl() {
        super();
    }

    public TLxAnnouncementDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TLxAnnouncementExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_lx_announcement.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TLxAnnouncementExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_lx_announcement.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TLxAnnouncement key = new TLxAnnouncement();
        key.setId(id);
        int rows = sqlMapClient.delete("t_lx_announcement.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TLxAnnouncement record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_announcement.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TLxAnnouncement record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_lx_announcement.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TLxAnnouncementExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_lx_announcement.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TLxAnnouncement selectByPrimaryKey(Long id) throws SQLException {
        TLxAnnouncement key = new TLxAnnouncement();
        key.setId(id);
        TLxAnnouncement record = (TLxAnnouncement) sqlMapClient.queryForObject("t_lx_announcement.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TLxAnnouncement record, TLxAnnouncementExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_announcement.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TLxAnnouncement record, TLxAnnouncementExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_lx_announcement.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TLxAnnouncement record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_announcement.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TLxAnnouncement record) throws SQLException {
        int rows = sqlMapClient.update("t_lx_announcement.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TLxAnnouncementExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLxAnnouncementExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TLxAnnouncementExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_lx_announcement.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
