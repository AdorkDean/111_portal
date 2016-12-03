package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TCartDAO;
import com.rc.portal.service.TCartManager;
import com.rc.portal.vo.TCart;
import com.rc.portal.vo.TCartExample;

public class TCartManagerImpl  implements TCartManager {

    private TCartDAO tcartdao;

    public TCartManagerImpl() {
        super();
    }
    public void  setTcartdao(TCartDAO tcartdao){
        this.tcartdao=tcartdao;
    }
    public TCartDAO getTcartdao(){
        return this.tcartdao;
    }
    public     int countByExample(TCartExample example) throws SQLException{
        return tcartdao. countByExample( example);
    }

    public     int deleteByExample(TCartExample example) throws SQLException{
        return tcartdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tcartdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TCart record) throws SQLException{
        return tcartdao. insert( record);
    }

    public     Long insertSelective(TCart record) throws SQLException{
        return tcartdao. insertSelective( record);
    }

    public     List selectByExample(TCartExample example) throws SQLException{
        return tcartdao. selectByExample( example);
    }

    public     TCart selectByPrimaryKey(Long id) throws SQLException{
        return tcartdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TCart record, TCartExample example) throws SQLException{
        return tcartdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TCart record, TCartExample example) throws SQLException{
        return tcartdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TCart record) throws SQLException{
        return tcartdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TCart record) throws SQLException{
        return tcartdao. updateByPrimaryKey( record);
    }


}
