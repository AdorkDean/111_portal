package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TGoodsPriceDAO;
import com.rc.portal.service.TGoodsPriceManager;
import com.rc.portal.vo.TGoodsPrice;
import com.rc.portal.vo.TGoodsPriceExample;

public class TGoodsPriceManagerImpl  implements TGoodsPriceManager {

    private TGoodsPriceDAO tgoodspricedao;

    public TGoodsPriceManagerImpl() {
        super();
    }
    public void  setTgoodspricedao(TGoodsPriceDAO tgoodspricedao){
        this.tgoodspricedao=tgoodspricedao;
    }
    public TGoodsPriceDAO getTgoodspricedao(){
        return this.tgoodspricedao;
    }
    public     int countByExample(TGoodsPriceExample example) throws SQLException{
        return tgoodspricedao. countByExample( example);
    }

    public     int deleteByExample(TGoodsPriceExample example) throws SQLException{
        return tgoodspricedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tgoodspricedao. deleteByPrimaryKey( id);
    }

    public     Long insert(TGoodsPrice record) throws SQLException{
        return tgoodspricedao. insert( record);
    }

    public     Long insertSelective(TGoodsPrice record) throws SQLException{
        return tgoodspricedao. insertSelective( record);
    }

    public     List selectByExample(TGoodsPriceExample example) throws SQLException{
        return tgoodspricedao. selectByExample( example);
    }

    public     TGoodsPrice selectByPrimaryKey(Long id) throws SQLException{
        return tgoodspricedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TGoodsPrice record, TGoodsPriceExample example) throws SQLException{
        return tgoodspricedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TGoodsPrice record, TGoodsPriceExample example) throws SQLException{
        return tgoodspricedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TGoodsPrice record) throws SQLException{
        return tgoodspricedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TGoodsPrice record) throws SQLException{
        return tgoodspricedao. updateByPrimaryKey( record);
    }


}
