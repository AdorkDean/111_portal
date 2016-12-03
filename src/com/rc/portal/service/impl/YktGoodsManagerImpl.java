package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.YktGoodsDAO;
import com.rc.portal.service.YktGoodsManager;
import com.rc.portal.vo.YktGoods;
import com.rc.portal.vo.YktGoodsExample;

public class YktGoodsManagerImpl  implements YktGoodsManager {

    private YktGoodsDAO yktgoodsdao;

    public YktGoodsManagerImpl() {
        super();
    }
    public void  setYktgoodsdao(YktGoodsDAO yktgoodsdao){
        this.yktgoodsdao=yktgoodsdao;
    }
    public YktGoodsDAO getYktgoodsdao(){
        return this.yktgoodsdao;
    }
    public     int countByExample(YktGoodsExample example) throws SQLException{
        return yktgoodsdao. countByExample( example);
    }

    public     int deleteByExample(YktGoodsExample example) throws SQLException{
        return yktgoodsdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return yktgoodsdao. deleteByPrimaryKey( id);
    }

    public     Long insert(YktGoods record) throws SQLException{
        return yktgoodsdao. insert( record);
    }

    public     Long insertSelective(YktGoods record) throws SQLException{
        return yktgoodsdao. insertSelective( record);
    }

    public     List selectByExample(YktGoodsExample example) throws SQLException{
        return yktgoodsdao. selectByExample( example);
    }

    public     YktGoods selectByPrimaryKey(Long id) throws SQLException{
        return yktgoodsdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(YktGoods record, YktGoodsExample example) throws SQLException{
        return yktgoodsdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(YktGoods record, YktGoodsExample example) throws SQLException{
        return yktgoodsdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(YktGoods record) throws SQLException{
        return yktgoodsdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(YktGoods record) throws SQLException{
        return yktgoodsdao. updateByPrimaryKey( record);
    }


}
