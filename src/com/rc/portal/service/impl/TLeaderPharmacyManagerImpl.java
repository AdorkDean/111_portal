package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLeaderPharmacyDAO;
import com.rc.portal.service.TLeaderPharmacyManager;
import com.rc.portal.vo.TLeaderPharmacy;
import com.rc.portal.vo.TLeaderPharmacyExample;

public class TLeaderPharmacyManagerImpl  implements TLeaderPharmacyManager {

    private TLeaderPharmacyDAO tleaderpharmacydao;

    public TLeaderPharmacyManagerImpl() {
        super();
    }
    public void  setTleaderpharmacydao(TLeaderPharmacyDAO tleaderpharmacydao){
        this.tleaderpharmacydao=tleaderpharmacydao;
    }
    public TLeaderPharmacyDAO getTleaderpharmacydao(){
        return this.tleaderpharmacydao;
    }
    public     int countByExample(TLeaderPharmacyExample example) throws SQLException{
        return tleaderpharmacydao. countByExample( example);
    }

    public     int deleteByExample(TLeaderPharmacyExample example) throws SQLException{
        return tleaderpharmacydao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tleaderpharmacydao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLeaderPharmacy record) throws SQLException{
        return tleaderpharmacydao. insert( record);
    }

    public     Long insertSelective(TLeaderPharmacy record) throws SQLException{
        return tleaderpharmacydao. insertSelective( record);
    }

    public     List selectByExample(TLeaderPharmacyExample example) throws SQLException{
        return tleaderpharmacydao. selectByExample( example);
    }

    public     TLeaderPharmacy selectByPrimaryKey(Long id) throws SQLException{
        return tleaderpharmacydao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLeaderPharmacy record, TLeaderPharmacyExample example) throws SQLException{
        return tleaderpharmacydao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLeaderPharmacy record, TLeaderPharmacyExample example) throws SQLException{
        return tleaderpharmacydao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLeaderPharmacy record) throws SQLException{
        return tleaderpharmacydao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLeaderPharmacy record) throws SQLException{
        return tleaderpharmacydao. updateByPrimaryKey( record);
    }


}
