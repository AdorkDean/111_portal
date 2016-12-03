package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TPhysicianDAO;
import com.rc.portal.service.TPhysicianManager;
import com.rc.portal.vo.TPhysician;
import com.rc.portal.vo.TPhysicianExample;

public class TPhysicianManagerImpl  implements TPhysicianManager {

    private TPhysicianDAO tphysiciandao;

    public TPhysicianManagerImpl() {
        super();
    }
    public void  setTphysiciandao(TPhysicianDAO tphysiciandao){
        this.tphysiciandao=tphysiciandao;
    }
    public TPhysicianDAO getTphysiciandao(){
        return this.tphysiciandao;
    }
    public     int countByExample(TPhysicianExample example) throws SQLException{
        return tphysiciandao. countByExample( example);
    }

    public     int deleteByExample(TPhysicianExample example) throws SQLException{
        return tphysiciandao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tphysiciandao. deleteByPrimaryKey( id);
    }

    public     Long insert(TPhysician record) throws SQLException{
        return tphysiciandao. insert( record);
    }

    public     Long insertSelective(TPhysician record) throws SQLException{
        return tphysiciandao. insertSelective( record);
    }

    public     List selectByExample(TPhysicianExample example) throws SQLException{
        return tphysiciandao. selectByExample( example);
    }

    public     TPhysician selectByPrimaryKey(Long id) throws SQLException{
        return tphysiciandao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TPhysician record, TPhysicianExample example) throws SQLException{
        return tphysiciandao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TPhysician record, TPhysicianExample example) throws SQLException{
        return tphysiciandao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TPhysician record) throws SQLException{
        return tphysiciandao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TPhysician record) throws SQLException{
        return tphysiciandao. updateByPrimaryKey( record);
    }


}
