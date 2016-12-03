package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TGoodsBrokerageDAO;
import com.rc.portal.service.TGoodsBrokerageManager;
import com.rc.portal.vo.TGoodsBrokerage;
import com.rc.portal.vo.TGoodsBrokerageExample;

public class TGoodsBrokerageManagerImpl  implements TGoodsBrokerageManager {

    private TGoodsBrokerageDAO tgoodsbrokeragedao;

    public TGoodsBrokerageManagerImpl() {
        super();
    }
    public void  setTgoodsbrokeragedao(TGoodsBrokerageDAO tgoodsbrokeragedao){
        this.tgoodsbrokeragedao=tgoodsbrokeragedao;
    }
    public TGoodsBrokerageDAO getTgoodsbrokeragedao(){
        return this.tgoodsbrokeragedao;
    }
    public     int countByExample(TGoodsBrokerageExample example) throws SQLException{
        return tgoodsbrokeragedao. countByExample( example);
    }

    public     int deleteByExample(TGoodsBrokerageExample example) throws SQLException{
        return tgoodsbrokeragedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tgoodsbrokeragedao. deleteByPrimaryKey( id);
    }

    public     Long insert(TGoodsBrokerage record) throws SQLException{
        return tgoodsbrokeragedao. insert( record);
    }

    public     Long insertSelective(TGoodsBrokerage record) throws SQLException{
        return tgoodsbrokeragedao. insertSelective( record);
    }

    public     List selectByExample(TGoodsBrokerageExample example) throws SQLException{
        return tgoodsbrokeragedao. selectByExample( example);
    }

    public     TGoodsBrokerage selectByPrimaryKey(Long id) throws SQLException{
        return tgoodsbrokeragedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TGoodsBrokerage record, TGoodsBrokerageExample example) throws SQLException{
        return tgoodsbrokeragedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TGoodsBrokerage record, TGoodsBrokerageExample example) throws SQLException{
        return tgoodsbrokeragedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TGoodsBrokerage record) throws SQLException{
        return tgoodsbrokeragedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TGoodsBrokerage record) throws SQLException{
        return tgoodsbrokeragedao. updateByPrimaryKey( record);
    }


}
