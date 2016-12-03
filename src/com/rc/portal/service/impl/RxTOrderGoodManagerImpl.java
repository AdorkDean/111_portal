package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.RxTOrderGoodDAO;
import com.rc.portal.service.RxTOrderGoodManager;
import com.rc.portal.vo.RxTOrderGood;
import com.rc.portal.vo.RxTOrderGoodExample;

public class RxTOrderGoodManagerImpl  implements RxTOrderGoodManager {

    private RxTOrderGoodDAO rxtordergooddao;

    public RxTOrderGoodManagerImpl() {
        super();
    }
    public void  setRxtordergooddao(RxTOrderGoodDAO rxtordergooddao){
        this.rxtordergooddao=rxtordergooddao;
    }
    public RxTOrderGoodDAO getRxtordergooddao(){
        return this.rxtordergooddao;
    }
    public     int countByExample(RxTOrderGoodExample example) throws SQLException{
        return rxtordergooddao. countByExample( example);
    }

    public     int deleteByExample(RxTOrderGoodExample example) throws SQLException{
        return rxtordergooddao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return rxtordergooddao. deleteByPrimaryKey( id);
    }

    public     Long insert(RxTOrderGood record) throws SQLException{
        return rxtordergooddao. insert( record);
    }

    public     Long insertSelective(RxTOrderGood record) throws SQLException{
        return rxtordergooddao. insertSelective( record);
    }

    public     List selectByExample(RxTOrderGoodExample example) throws SQLException{
        return rxtordergooddao. selectByExample( example);
    }

    public     RxTOrderGood selectByPrimaryKey(Long id) throws SQLException{
        return rxtordergooddao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(RxTOrderGood record, RxTOrderGoodExample example) throws SQLException{
        return rxtordergooddao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(RxTOrderGood record, RxTOrderGoodExample example) throws SQLException{
        return rxtordergooddao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(RxTOrderGood record) throws SQLException{
        return rxtordergooddao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(RxTOrderGood record) throws SQLException{
        return rxtordergooddao. updateByPrimaryKey( record);
    }


}
