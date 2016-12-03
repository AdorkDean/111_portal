package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberBalanceDAO;
import com.rc.portal.service.TMemberBalanceManager;
import com.rc.portal.vo.TMemberBalance;
import com.rc.portal.vo.TMemberBalanceExample;

public class TMemberBalanceManagerImpl  implements TMemberBalanceManager {

    private TMemberBalanceDAO tmemberbalancedao;

    public TMemberBalanceManagerImpl() {
        super();
    }
    public void  setTmemberbalancedao(TMemberBalanceDAO tmemberbalancedao){
        this.tmemberbalancedao=tmemberbalancedao;
    }
    public TMemberBalanceDAO getTmemberbalancedao(){
        return this.tmemberbalancedao;
    }
    public     int countByExample(TMemberBalanceExample example) throws SQLException{
        return tmemberbalancedao. countByExample( example);
    }

    public     int deleteByExample(TMemberBalanceExample example) throws SQLException{
        return tmemberbalancedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmemberbalancedao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberBalance record) throws SQLException{
        return tmemberbalancedao. insert( record);
    }

    public     Long insertSelective(TMemberBalance record) throws SQLException{
        return tmemberbalancedao. insertSelective( record);
    }

    public     List selectByExample(TMemberBalanceExample example) throws SQLException{
        return tmemberbalancedao. selectByExample( example);
    }

    public     TMemberBalance selectByPrimaryKey(Long id) throws SQLException{
        return tmemberbalancedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberBalance record, TMemberBalanceExample example) throws SQLException{
        return tmemberbalancedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberBalance record, TMemberBalanceExample example) throws SQLException{
        return tmemberbalancedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberBalance record) throws SQLException{
        return tmemberbalancedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberBalance record) throws SQLException{
        return tmemberbalancedao. updateByPrimaryKey( record);
    }


}
