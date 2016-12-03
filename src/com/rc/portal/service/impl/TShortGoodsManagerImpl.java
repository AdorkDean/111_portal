package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TShortGoodsDAO;
import com.rc.portal.service.TShortGoodsManager;
import com.rc.portal.vo.TShortGoods;
import com.rc.portal.vo.TShortGoodsExample;

public class TShortGoodsManagerImpl  implements TShortGoodsManager {

    private TShortGoodsDAO tshortgoodsdao;

    public TShortGoodsManagerImpl() {
        super();
    }
    public void  setTshortgoodsdao(TShortGoodsDAO tshortgoodsdao){
        this.tshortgoodsdao=tshortgoodsdao;
    }
    public TShortGoodsDAO getTshortgoodsdao(){
        return this.tshortgoodsdao;
    }
    public     int countByExample(TShortGoodsExample example) throws SQLException{
        return tshortgoodsdao. countByExample( example);
    }

    public     int deleteByExample(TShortGoodsExample example) throws SQLException{
        return tshortgoodsdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tshortgoodsdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TShortGoods record) throws SQLException{
        return tshortgoodsdao. insert( record);
    }

    public     Long insertSelective(TShortGoods record) throws SQLException{
        return tshortgoodsdao. insertSelective( record);
    }

    public     List selectByExample(TShortGoodsExample example) throws SQLException{
        return tshortgoodsdao. selectByExample( example);
    }

    public     TShortGoods selectByPrimaryKey(Long id) throws SQLException{
        return tshortgoodsdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TShortGoods record, TShortGoodsExample example) throws SQLException{
        return tshortgoodsdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TShortGoods record, TShortGoodsExample example) throws SQLException{
        return tshortgoodsdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TShortGoods record) throws SQLException{
        return tshortgoodsdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TShortGoods record) throws SQLException{
        return tshortgoodsdao. updateByPrimaryKey( record);
    }


}
