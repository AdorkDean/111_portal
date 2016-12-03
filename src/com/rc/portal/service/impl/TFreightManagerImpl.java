package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TFreightDAO;
import com.rc.portal.service.TFreightManager;
import com.rc.portal.vo.TFreight;
import com.rc.portal.vo.TFreightExample;

public class TFreightManagerImpl  implements TFreightManager {

    private TFreightDAO tfreightdao;

    public TFreightManagerImpl() {
        super();
    }
    public void  setTfreightdao(TFreightDAO tfreightdao){
        this.tfreightdao=tfreightdao;
    }
    public TFreightDAO getTfreightdao(){
        return this.tfreightdao;
    }
    public     int countByExample(TFreightExample example) throws SQLException{
        return tfreightdao. countByExample( example);
    }

    public     int deleteByExample(TFreightExample example) throws SQLException{
        return tfreightdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tfreightdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TFreight record) throws SQLException{
        return tfreightdao. insert( record);
    }

    public     Long insertSelective(TFreight record) throws SQLException{
        return tfreightdao. insertSelective( record);
    }

    public     List selectByExample(TFreightExample example) throws SQLException{
        return tfreightdao. selectByExample( example);
    }

    public     TFreight selectByPrimaryKey(Long id) throws SQLException{
        return tfreightdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TFreight record, TFreightExample example) throws SQLException{
        return tfreightdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TFreight record, TFreightExample example) throws SQLException{
        return tfreightdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TFreight record) throws SQLException{
        return tfreightdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TFreight record) throws SQLException{
        return tfreightdao. updateByPrimaryKey( record);
    }


}
