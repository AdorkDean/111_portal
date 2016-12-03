package com.rc.portal.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.app.framework.webapp.model.page.PageManager;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.dao.TGoodsImagesDAO;
import com.rc.portal.vo.TGoodsImages;
import com.rc.portal.vo.TGoodsImagesExample;

public class TGoodsImagesDAOImpl implements TGoodsImagesDAO {
    private SqlMapClient sqlMapClient;

    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
    public TGoodsImagesDAOImpl() {
        super();
    }

    public TGoodsImagesDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    public int countByExample(TGoodsImagesExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("t_goods_images.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(TGoodsImagesExample example) throws SQLException {
        int rows = sqlMapClient.delete("t_goods_images.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) throws SQLException {
        TGoodsImages key = new TGoodsImages();
        key.setId(id);
        int rows = sqlMapClient.delete("t_goods_images.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(TGoodsImages record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods_images.ibatorgenerated_insert", record);
    }

    public Long insertSelective(TGoodsImages record) throws SQLException {
		return (Long)        sqlMapClient.insert("t_goods_images.ibatorgenerated_insertSelective", record);
    }

    public List selectByExample(TGoodsImagesExample example) throws SQLException {
        List list = sqlMapClient.queryForList("t_goods_images.ibatorgenerated_selectByExample", example);
        return list;
    }

    public TGoodsImages selectByPrimaryKey(Long id) throws SQLException {
        TGoodsImages key = new TGoodsImages();
        key.setId(id);
        TGoodsImages record = (TGoodsImages) sqlMapClient.queryForObject("t_goods_images.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(TGoodsImages record, TGoodsImagesExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods_images.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TGoodsImages record, TGoodsImagesExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("t_goods_images.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TGoodsImages record) throws SQLException {
        int rows = sqlMapClient.update("t_goods_images.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TGoodsImages record) throws SQLException {
        int rows = sqlMapClient.update("t_goods_images.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends TGoodsImagesExample {
        private Object record;

        public UpdateByExampleParms(Object record, TGoodsImagesExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
	public PageWraper selectByRepositoryByPage(TGoodsImagesExample example) throws SQLException {
		PageWraper pw=null;
		int count=this.countByExample(example);
		List list = sqlMapClient.queryForList("t_goods_images.selectByExampleByPage", example);
		System.out.println("��Դ��ҳ��ѯlist.size="+list.size());
		pw=PageManager.getPageWraper(example.getPageInfo(), list, count);
		return pw;
	}
}
