package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TDoseDAO;
import com.rc.portal.service.TDoseManager;
import com.rc.portal.vo.TDose;
import com.rc.portal.vo.TDoseExample;

public class TDoseManagerImpl  implements TDoseManager {

    private TDoseDAO tdosedao;

    public TDoseManagerImpl() {
        super();
    }
    public void  setTdosedao(TDoseDAO tdosedao){
        this.tdosedao=tdosedao;
    }
    public TDoseDAO getTdosedao(){
        return this.tdosedao;
    }
    public     int countByExample(TDoseExample example) throws SQLException{
        return tdosedao. countByExample( example);
    }

    public     int deleteByExample(TDoseExample example) throws SQLException{
        return tdosedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tdosedao. deleteByPrimaryKey( id);
    }

    public     Long insert(TDose record) throws SQLException{
        return tdosedao. insert( record);
    }

    public     Long insertSelective(TDose record) throws SQLException{
        return tdosedao. insertSelective( record);
    }

    public     List selectByExample(TDoseExample example) throws SQLException{
        return tdosedao. selectByExample( example);
    }

    public     TDose selectByPrimaryKey(Long id) throws SQLException{
        return tdosedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TDose record, TDoseExample example) throws SQLException{
        return tdosedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TDose record, TDoseExample example) throws SQLException{
        return tdosedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TDose record) throws SQLException{
        return tdosedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TDose record) throws SQLException{
        return tdosedao. updateByPrimaryKey( record);
    }


}
