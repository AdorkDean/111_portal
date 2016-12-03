package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TManufacturerDAO;
import com.rc.portal.service.TManufacturerManager;
import com.rc.portal.vo.TManufacturer;
import com.rc.portal.vo.TManufacturerExample;

public class TManufacturerManagerImpl  implements TManufacturerManager {

    private TManufacturerDAO tmanufacturerdao;

    public TManufacturerManagerImpl() {
        super();
    }
    public void  setTmanufacturerdao(TManufacturerDAO tmanufacturerdao){
        this.tmanufacturerdao=tmanufacturerdao;
    }
    public TManufacturerDAO getTmanufacturerdao(){
        return this.tmanufacturerdao;
    }
    public     int countByExample(TManufacturerExample example) throws SQLException{
        return tmanufacturerdao. countByExample( example);
    }

    public     int deleteByExample(TManufacturerExample example) throws SQLException{
        return tmanufacturerdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmanufacturerdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TManufacturer record) throws SQLException{
        return tmanufacturerdao. insert( record);
    }

    public     Long insertSelective(TManufacturer record) throws SQLException{
        return tmanufacturerdao. insertSelective( record);
    }

    public     List selectByExample(TManufacturerExample example) throws SQLException{
        return tmanufacturerdao. selectByExample( example);
    }

    public     TManufacturer selectByPrimaryKey(Long id) throws SQLException{
        return tmanufacturerdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TManufacturer record, TManufacturerExample example) throws SQLException{
        return tmanufacturerdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TManufacturer record, TManufacturerExample example) throws SQLException{
        return tmanufacturerdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TManufacturer record) throws SQLException{
        return tmanufacturerdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TManufacturer record) throws SQLException{
        return tmanufacturerdao. updateByPrimaryKey( record);
    }


}
