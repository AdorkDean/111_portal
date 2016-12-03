package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TGoodsImagesDAO;
import com.rc.portal.service.TGoodsImagesManager;
import com.rc.portal.vo.TGoodsImages;
import com.rc.portal.vo.TGoodsImagesExample;

public class TGoodsImagesManagerImpl  implements TGoodsImagesManager {

    private TGoodsImagesDAO tgoodsimagesdao;

    public TGoodsImagesManagerImpl() {
        super();
    }
    public void  setTgoodsimagesdao(TGoodsImagesDAO tgoodsimagesdao){
        this.tgoodsimagesdao=tgoodsimagesdao;
    }
    public TGoodsImagesDAO getTgoodsimagesdao(){
        return this.tgoodsimagesdao;
    }
    public     int countByExample(TGoodsImagesExample example) throws SQLException{
        return tgoodsimagesdao. countByExample( example);
    }

    public     int deleteByExample(TGoodsImagesExample example) throws SQLException{
        return tgoodsimagesdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tgoodsimagesdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TGoodsImages record) throws SQLException{
        return tgoodsimagesdao. insert( record);
    }

    public     Long insertSelective(TGoodsImages record) throws SQLException{
        return tgoodsimagesdao. insertSelective( record);
    }

    public     List selectByExample(TGoodsImagesExample example) throws SQLException{
        return tgoodsimagesdao. selectByExample( example);
    }

    public     TGoodsImages selectByPrimaryKey(Long id) throws SQLException{
        return tgoodsimagesdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TGoodsImages record, TGoodsImagesExample example) throws SQLException{
        return tgoodsimagesdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TGoodsImages record, TGoodsImagesExample example) throws SQLException{
        return tgoodsimagesdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TGoodsImages record) throws SQLException{
        return tgoodsimagesdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TGoodsImages record) throws SQLException{
        return tgoodsimagesdao. updateByPrimaryKey( record);
    }


}
