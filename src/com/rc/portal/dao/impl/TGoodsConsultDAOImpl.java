package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TGoodsConsultDAO;
import com.rc.portal.vo.TGoodsConsult;
import com.rc.portal.vo.TGoodsConsultExample;

public class TGoodsConsultDAOImpl implements TGoodsConsultDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TGoodsConsultDAOImpl() {
        super();
    }

    public TGoodsConsultDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TGoodsConsultExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_goods_consult.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TGoodsConsultExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_goods_consult.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TGoodsConsult key = new TGoodsConsult();
        key.setId(id);
        int rows = sqlMapClient.delete("t_goods_consult.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TGoodsConsult record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods_consult.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TGoodsConsult record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods_consult.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TGoodsConsultExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_goods_consult.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TGoodsConsult selectByPrimaryKey(Long id) throws SQLException {
        TGoodsConsult key = new TGoodsConsult();
        key.setId(id);
        TGoodsConsult record = (TGoodsConsult) sqlMapClient.queryForObject("t_goods_consult.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TGoodsConsult record, TGoodsConsultExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods_consult.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TGoodsConsult record, TGoodsConsultExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods_consult.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TGoodsConsult record) throws SQLException {
        int rows = sqlMapClient.update("t_goods_consult.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TGoodsConsult record) throws SQLException {
        int rows = sqlMapClient.update("t_goods_consult.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TGoodsConsultExample {
        private Object record;

        public UpdateByExampleParms(Object record, TGoodsConsultExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TGoodsConsultExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_goods_consult.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}

	
	@Override
	public List<TGoodsConsult> initAjaxGoodsConsult(Map<String, Object> map) throws SQLException {
		List<TGoodsConsult> list = sqlMapClient.queryForList("t_goods_consult.initAjaxGoodsConsult", map);
		return list;
	}

	@Override
	public int initAjaxGoodsConsultCount(Map<String, Object> map) throws SQLException {
		int count = (Integer) sqlMapClient.queryForObject("t_goods_consult.initAjaxGoodsConsultCount", map);
		return count;
	}
}
