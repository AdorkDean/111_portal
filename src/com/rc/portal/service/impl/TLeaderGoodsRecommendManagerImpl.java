package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLeaderGoodsRecommendDAO;
import com.rc.portal.service.TLeaderGoodsRecommendManager;
import com.rc.portal.vo.TLeaderGoodsRecommend;
import com.rc.portal.vo.TLeaderGoodsRecommendExample;

public class TLeaderGoodsRecommendManagerImpl  implements TLeaderGoodsRecommendManager {

    private TLeaderGoodsRecommendDAO tleadergoodsrecommenddao;

    public TLeaderGoodsRecommendManagerImpl() {
        super();
    }
    public void  setTleadergoodsrecommenddao(TLeaderGoodsRecommendDAO tleadergoodsrecommenddao){
        this.tleadergoodsrecommenddao=tleadergoodsrecommenddao;
    }
    public TLeaderGoodsRecommendDAO getTleadergoodsrecommenddao(){
        return this.tleadergoodsrecommenddao;
    }
    public     int countByExample(TLeaderGoodsRecommendExample example) throws SQLException{
        return tleadergoodsrecommenddao. countByExample( example);
    }

    public     int deleteByExample(TLeaderGoodsRecommendExample example) throws SQLException{
        return tleadergoodsrecommenddao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tleadergoodsrecommenddao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLeaderGoodsRecommend record) throws SQLException{
        return tleadergoodsrecommenddao. insert( record);
    }

    public     Long insertSelective(TLeaderGoodsRecommend record) throws SQLException{
        return tleadergoodsrecommenddao. insertSelective( record);
    }

    public     List selectByExample(TLeaderGoodsRecommendExample example) throws SQLException{
        return tleadergoodsrecommenddao. selectByExample( example);
    }

    public     TLeaderGoodsRecommend selectByPrimaryKey(Long id) throws SQLException{
        return tleadergoodsrecommenddao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLeaderGoodsRecommend record, TLeaderGoodsRecommendExample example) throws SQLException{
        return tleadergoodsrecommenddao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLeaderGoodsRecommend record, TLeaderGoodsRecommendExample example) throws SQLException{
        return tleadergoodsrecommenddao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLeaderGoodsRecommend record) throws SQLException{
        return tleadergoodsrecommenddao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLeaderGoodsRecommend record) throws SQLException{
        return tleadergoodsrecommenddao. updateByPrimaryKey( record);
    }


}
