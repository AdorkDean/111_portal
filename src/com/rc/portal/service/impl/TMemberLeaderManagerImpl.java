package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberLeaderDAO;
import com.rc.portal.service.TMemberLeaderManager;
import com.rc.portal.vo.TMemberLeader;
import com.rc.portal.vo.TMemberLeaderExample;

public class TMemberLeaderManagerImpl  implements TMemberLeaderManager {

    private TMemberLeaderDAO tmemberleaderdao;

    public TMemberLeaderManagerImpl() {
        super();
    }
    public void  setTmemberleaderdao(TMemberLeaderDAO tmemberleaderdao){
        this.tmemberleaderdao=tmemberleaderdao;
    }
    public TMemberLeaderDAO getTmemberleaderdao(){
        return this.tmemberleaderdao;
    }
    public     int countByExample(TMemberLeaderExample example) throws SQLException{
        return tmemberleaderdao. countByExample( example);
    }

    public     int deleteByExample(TMemberLeaderExample example) throws SQLException{
        return tmemberleaderdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmemberleaderdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberLeader record) throws SQLException{
        return tmemberleaderdao. insert( record);
    }

    public     Long insertSelective(TMemberLeader record) throws SQLException{
        return tmemberleaderdao. insertSelective( record);
    }

    public     List selectByExample(TMemberLeaderExample example) throws SQLException{
        return tmemberleaderdao. selectByExample( example);
    }

    public     TMemberLeader selectByPrimaryKey(Long id) throws SQLException{
        return tmemberleaderdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberLeader record, TMemberLeaderExample example) throws SQLException{
        return tmemberleaderdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberLeader record, TMemberLeaderExample example) throws SQLException{
        return tmemberleaderdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberLeader record) throws SQLException{
        return tmemberleaderdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberLeader record) throws SQLException{
        return tmemberleaderdao. updateByPrimaryKey( record);
    }


}
