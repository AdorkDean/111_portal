package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TMemberReceiverLatLonDAO;
import com.rc.portal.vo.TMemberReceiverLatLon;
import com.rc.portal.vo.TMemberReceiverLatLonExample;

public class TMemberReceiverLatLonDAOImpl implements TMemberReceiverLatLonDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TMemberReceiverLatLonDAOImpl() {
        super();
    }

    public TMemberReceiverLatLonDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TMemberReceiverLatLonExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_member_receiver_lat_lon.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TMemberReceiverLatLonExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_member_receiver_lat_lon.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TMemberReceiverLatLon key = new TMemberReceiverLatLon();
        key.setId(id);
        int rows = sqlMapClient.delete("t_member_receiver_lat_lon.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TMemberReceiverLatLon record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_receiver_lat_lon.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TMemberReceiverLatLon record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_member_receiver_lat_lon.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TMemberReceiverLatLonExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_member_receiver_lat_lon.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TMemberReceiverLatLon selectByPrimaryKey(Long id) throws SQLException {
        TMemberReceiverLatLon key = new TMemberReceiverLatLon();
        key.setId(id);
        TMemberReceiverLatLon record = (TMemberReceiverLatLon) sqlMapClient.queryForObject("t_member_receiver_lat_lon.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TMemberReceiverLatLon record, TMemberReceiverLatLonExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_receiver_lat_lon.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TMemberReceiverLatLon record, TMemberReceiverLatLonExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_member_receiver_lat_lon.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TMemberReceiverLatLon record) throws SQLException {
        int rows = sqlMapClient.update("t_member_receiver_lat_lon.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TMemberReceiverLatLon record) throws SQLException {
        int rows = sqlMapClient.update("t_member_receiver_lat_lon.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TMemberReceiverLatLonExample {
        private Object record;

        public UpdateByExampleParms(Object record, TMemberReceiverLatLonExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TMemberReceiverLatLonExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_member_receiver_lat_lon.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
