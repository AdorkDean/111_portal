package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TGoodsPropertyDAO;
import com.rc.portal.service.TGoodsPropertyManager;
import com.rc.portal.vo.TGoodsProperty;
import com.rc.portal.vo.TGoodsPropertyExample;

public class TGoodsPropertyManagerImpl  implements TGoodsPropertyManager {

    private TGoodsPropertyDAO tgoodspropertydao;

    public TGoodsPropertyManagerImpl() {
        super();
    }
    public void  setTgoodspropertydao(TGoodsPropertyDAO tgoodspropertydao){
        this.tgoodspropertydao=tgoodspropertydao;
    }
    public TGoodsPropertyDAO getTgoodspropertydao(){
        return this.tgoodspropertydao;
    }
    public     int countByExample(TGoodsPropertyExample example) throws SQLException{
        return tgoodspropertydao. countByExample( example);
    }

    public     int deleteByExample(TGoodsPropertyExample example) throws SQLException{
        return tgoodspropertydao. deleteByExample( example);
    }

    public     Long insert(TGoodsProperty record) throws SQLException{
        return tgoodspropertydao. insert( record);
    }

    public     Long insertSelective(TGoodsProperty record) throws SQLException{
        return tgoodspropertydao. insertSelective( record);
    }

    public     List selectByExample(TGoodsPropertyExample example) throws SQLException{
        return tgoodspropertydao. selectByExample( example);
    }

    public     int updateByExampleSelective(TGoodsProperty record, TGoodsPropertyExample example) throws SQLException{
        return tgoodspropertydao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TGoodsProperty record, TGoodsPropertyExample example) throws SQLException{
        return tgoodspropertydao. updateByExample( record, example);
    }


}
