package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberHobbyDAO;
import com.rc.portal.service.TMemberHobbyManager;
import com.rc.portal.vo.TMemberHobby;
import com.rc.portal.vo.TMemberHobbyExample;

public class TMemberHobbyManagerImpl  implements TMemberHobbyManager {

    private TMemberHobbyDAO tmemberhobbydao;

    public TMemberHobbyManagerImpl() {
        super();
    }
    public void  setTmemberhobbydao(TMemberHobbyDAO tmemberhobbydao){
        this.tmemberhobbydao=tmemberhobbydao;
    }
    public TMemberHobbyDAO getTmemberhobbydao(){
        return this.tmemberhobbydao;
    }
    public     int countByExample(TMemberHobbyExample example) throws SQLException{
        return tmemberhobbydao. countByExample( example);
    }

    public     int deleteByExample(TMemberHobbyExample example) throws SQLException{
        return tmemberhobbydao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long memberId) throws SQLException{
        return tmemberhobbydao. deleteByPrimaryKey( memberId);
    }

    public     Long insert(TMemberHobby record) throws SQLException{
        return tmemberhobbydao. insert( record);
    }

    public     Long insertSelective(TMemberHobby record) throws SQLException{
        return tmemberhobbydao. insertSelective( record);
    }

    public     List selectByExample(TMemberHobbyExample example) throws SQLException{
        return tmemberhobbydao. selectByExample( example);
    }

    public     TMemberHobby selectByPrimaryKey(Long memberId) throws SQLException{
        return tmemberhobbydao. selectByPrimaryKey( memberId);
    }

    public     int updateByExampleSelective(TMemberHobby record, TMemberHobbyExample example) throws SQLException{
        return tmemberhobbydao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberHobby record, TMemberHobbyExample example) throws SQLException{
        return tmemberhobbydao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberHobby record) throws SQLException{
        return tmemberhobbydao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberHobby record) throws SQLException{
        return tmemberhobbydao. updateByPrimaryKey( record);
    }


}
