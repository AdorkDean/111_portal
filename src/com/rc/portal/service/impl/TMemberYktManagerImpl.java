package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberYktDAO;
import com.rc.portal.service.TMemberYktManager;
import com.rc.portal.vo.TMemberYkt;
import com.rc.portal.vo.TMemberYktExample;

public class TMemberYktManagerImpl  implements TMemberYktManager {

    private TMemberYktDAO tmemberyktdao;

    public TMemberYktManagerImpl() {
        super();
    }
    public void  setTmemberyktdao(TMemberYktDAO tmemberyktdao){
        this.tmemberyktdao=tmemberyktdao;
    }
    public TMemberYktDAO getTmemberyktdao(){
        return this.tmemberyktdao;
    }
    public     int countByExample(TMemberYktExample example) throws SQLException{
        return tmemberyktdao. countByExample( example);
    }

    public     int deleteByExample(TMemberYktExample example) throws SQLException{
        return tmemberyktdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmemberyktdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberYkt record) throws SQLException{
        return tmemberyktdao. insert( record);
    }

    public     Long insertSelective(TMemberYkt record) throws SQLException{
        return tmemberyktdao. insertSelective( record);
    }

    public     List selectByExample(TMemberYktExample example) throws SQLException{
        return tmemberyktdao. selectByExample( example);
    }

    public     TMemberYkt selectByPrimaryKey(Long id) throws SQLException{
        return tmemberyktdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberYkt record, TMemberYktExample example) throws SQLException{
        return tmemberyktdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberYkt record, TMemberYktExample example) throws SQLException{
        return tmemberyktdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberYkt record) throws SQLException{
        return tmemberyktdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberYkt record) throws SQLException{
        return tmemberyktdao. updateByPrimaryKey( record);
    }


}
