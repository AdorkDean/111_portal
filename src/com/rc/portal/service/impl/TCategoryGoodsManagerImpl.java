package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TCategoryGoodsDAO;
import com.rc.portal.service.TCategoryGoodsManager;
import com.rc.portal.vo.TCategoryGoods;
import com.rc.portal.vo.TCategoryGoodsExample;

public class TCategoryGoodsManagerImpl  implements TCategoryGoodsManager {

    private TCategoryGoodsDAO tcategorygoodsdao;

    public TCategoryGoodsManagerImpl() {
        super();
    }
    public void  setTcategorygoodsdao(TCategoryGoodsDAO tcategorygoodsdao){
        this.tcategorygoodsdao=tcategorygoodsdao;
    }
    public TCategoryGoodsDAO getTcategorygoodsdao(){
        return this.tcategorygoodsdao;
    }
    public     int countByExample(TCategoryGoodsExample example) throws SQLException{
        return tcategorygoodsdao. countByExample( example);
    }

    public     int deleteByExample(TCategoryGoodsExample example) throws SQLException{
        return tcategorygoodsdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tcategorygoodsdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TCategoryGoods record) throws SQLException{
        return tcategorygoodsdao. insert( record);
    }

    public     Long insertSelective(TCategoryGoods record) throws SQLException{
        return tcategorygoodsdao. insertSelective( record);
    }

    public     List selectByExample(TCategoryGoodsExample example) throws SQLException{
        return tcategorygoodsdao. selectByExample( example);
    }

    public     TCategoryGoods selectByPrimaryKey(Long id) throws SQLException{
        return tcategorygoodsdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TCategoryGoods record, TCategoryGoodsExample example) throws SQLException{
        return tcategorygoodsdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TCategoryGoods record, TCategoryGoodsExample example) throws SQLException{
        return tcategorygoodsdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TCategoryGoods record) throws SQLException{
        return tcategorygoodsdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TCategoryGoods record) throws SQLException{
        return tcategorygoodsdao. updateByPrimaryKey( record);
    }


}
