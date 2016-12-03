package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLeaderArticleGoodsDAO;
import com.rc.portal.service.TLeaderArticleGoodsManager;
import com.rc.portal.vo.TLeaderArticleGoods;
import com.rc.portal.vo.TLeaderArticleGoodsExample;

public class TLeaderArticleGoodsManagerImpl  implements TLeaderArticleGoodsManager {

    private TLeaderArticleGoodsDAO tleaderarticlegoodsdao;

    public TLeaderArticleGoodsManagerImpl() {
        super();
    }
    public void  setTleaderarticlegoodsdao(TLeaderArticleGoodsDAO tleaderarticlegoodsdao){
        this.tleaderarticlegoodsdao=tleaderarticlegoodsdao;
    }
    public TLeaderArticleGoodsDAO getTleaderarticlegoodsdao(){
        return this.tleaderarticlegoodsdao;
    }
    public     int countByExample(TLeaderArticleGoodsExample example) throws SQLException{
        return tleaderarticlegoodsdao. countByExample( example);
    }

    public     int deleteByExample(TLeaderArticleGoodsExample example) throws SQLException{
        return tleaderarticlegoodsdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tleaderarticlegoodsdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLeaderArticleGoods record) throws SQLException{
        return tleaderarticlegoodsdao. insert( record);
    }

    public     Long insertSelective(TLeaderArticleGoods record) throws SQLException{
        return tleaderarticlegoodsdao. insertSelective( record);
    }

    public     List selectByExample(TLeaderArticleGoodsExample example) throws SQLException{
        return tleaderarticlegoodsdao. selectByExample( example);
    }

    public     TLeaderArticleGoods selectByPrimaryKey(Long id) throws SQLException{
        return tleaderarticlegoodsdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLeaderArticleGoods record, TLeaderArticleGoodsExample example) throws SQLException{
        return tleaderarticlegoodsdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLeaderArticleGoods record, TLeaderArticleGoodsExample example) throws SQLException{
        return tleaderarticlegoodsdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLeaderArticleGoods record) throws SQLException{
        return tleaderarticlegoodsdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLeaderArticleGoods record) throws SQLException{
        return tleaderarticlegoodsdao. updateByPrimaryKey( record);
    }


}
