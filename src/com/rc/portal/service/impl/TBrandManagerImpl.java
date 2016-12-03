package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TBrandDAO;
import com.rc.portal.service.TBrandManager;
import com.rc.portal.vo.TBrand;
import com.rc.portal.vo.TBrandExample;

public class TBrandManagerImpl  implements TBrandManager {

    private TBrandDAO tbranddao;

    public TBrandManagerImpl() {
        super();
    }
    public void  setTbranddao(TBrandDAO tbranddao){
        this.tbranddao=tbranddao;
    }
    public TBrandDAO getTbranddao(){
        return this.tbranddao;
    }
    public     int countByExample(TBrandExample example) throws SQLException{
        return tbranddao. countByExample( example);
    }

    public     int deleteByExample(TBrandExample example) throws SQLException{
        return tbranddao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tbranddao. deleteByPrimaryKey( id);
    }

    public     Long insert(TBrand record) throws SQLException{
        return tbranddao. insert( record);
    }

    public     Long insertSelective(TBrand record) throws SQLException{
        return tbranddao. insertSelective( record);
    }

    public     List selectByExample(TBrandExample example) throws SQLException{
        return tbranddao. selectByExample( example);
    }

    public     TBrand selectByPrimaryKey(Long id) throws SQLException{
        return tbranddao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TBrand record, TBrandExample example) throws SQLException{
        return tbranddao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TBrand record, TBrandExample example) throws SQLException{
        return tbranddao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TBrand record) throws SQLException{
        return tbranddao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TBrand record) throws SQLException{
        return tbranddao. updateByPrimaryKey( record);
    }


}
