package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLongCardDAO;
import com.rc.portal.service.TLongCardManager;
import com.rc.portal.vo.TLongCard;
import com.rc.portal.vo.TLongCardExample;

public class TLongCardManagerImpl  implements TLongCardManager {

    private TLongCardDAO tlongcarddao;

    public TLongCardManagerImpl() {
        super();
    }
    public void  setTlongcarddao(TLongCardDAO tlongcarddao){
        this.tlongcarddao=tlongcarddao;
    }
    public TLongCardDAO getTlongcarddao(){
        return this.tlongcarddao;
    }
    public     int countByExample(TLongCardExample example) throws SQLException{
        return tlongcarddao. countByExample( example);
    }

    public     int deleteByExample(TLongCardExample example) throws SQLException{
        return tlongcarddao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tlongcarddao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLongCard record) throws SQLException{
        return tlongcarddao. insert( record);
    }

    public     Long insertSelective(TLongCard record) throws SQLException{
        return tlongcarddao. insertSelective( record);
    }

    public     List selectByExample(TLongCardExample example) throws SQLException{
        return tlongcarddao. selectByExample( example);
    }

    public     TLongCard selectByPrimaryKey(Long id) throws SQLException{
        return tlongcarddao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLongCard record, TLongCardExample example) throws SQLException{
        return tlongcarddao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLongCard record, TLongCardExample example) throws SQLException{
        return tlongcarddao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLongCard record) throws SQLException{
        return tlongcarddao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLongCard record) throws SQLException{
        return tlongcarddao. updateByPrimaryKey( record);
    }


}
