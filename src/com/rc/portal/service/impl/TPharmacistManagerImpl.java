package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TPharmacistDAO;
import com.rc.portal.service.TPharmacistManager;
import com.rc.portal.vo.TPharmacist;
import com.rc.portal.vo.TPharmacistExample;

public class TPharmacistManagerImpl  implements TPharmacistManager {

    private TPharmacistDAO tpharmacistdao;

    public TPharmacistManagerImpl() {
        super();
    }
    public void  setTpharmacistdao(TPharmacistDAO tpharmacistdao){
        this.tpharmacistdao=tpharmacistdao;
    }
    public TPharmacistDAO getTpharmacistdao(){
        return this.tpharmacistdao;
    }
    public     int countByExample(TPharmacistExample example) throws SQLException{
        return tpharmacistdao. countByExample( example);
    }

    public     int deleteByExample(TPharmacistExample example) throws SQLException{
        return tpharmacistdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tpharmacistdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TPharmacist record) throws SQLException{
        return tpharmacistdao. insert( record);
    }

    public     Long insertSelective(TPharmacist record) throws SQLException{
        return tpharmacistdao. insertSelective( record);
    }

    public     List selectByExample(TPharmacistExample example) throws SQLException{
        return tpharmacistdao. selectByExample( example);
    }

    public     TPharmacist selectByPrimaryKey(Long id) throws SQLException{
        return tpharmacistdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TPharmacist record, TPharmacistExample example) throws SQLException{
        return tpharmacistdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TPharmacist record, TPharmacistExample example) throws SQLException{
        return tpharmacistdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TPharmacist record) throws SQLException{
        return tpharmacistdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TPharmacist record) throws SQLException{
        return tpharmacistdao. updateByPrimaryKey( record);
    }


}
