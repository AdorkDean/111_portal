package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberMessageDAO;
import com.rc.portal.service.TMemberMessageManager;
import com.rc.portal.vo.TMemberMessage;
import com.rc.portal.vo.TMemberMessageExample;

public class TMemberMessageManagerImpl  implements TMemberMessageManager {

    private TMemberMessageDAO tmembermessagedao;

    public TMemberMessageManagerImpl() {
        super();
    }
    public void  setTmembermessagedao(TMemberMessageDAO tmembermessagedao){
        this.tmembermessagedao=tmembermessagedao;
    }
    public TMemberMessageDAO getTmembermessagedao(){
        return this.tmembermessagedao;
    }
    public     int countByExample(TMemberMessageExample example) throws SQLException{
        return tmembermessagedao. countByExample( example);
    }

    public     int deleteByExample(TMemberMessageExample example) throws SQLException{
        return tmembermessagedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmembermessagedao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberMessage record) throws SQLException{
        return tmembermessagedao. insert( record);
    }

    public     Long insertSelective(TMemberMessage record) throws SQLException{
        return tmembermessagedao. insertSelective( record);
    }

    public     List selectByExample(TMemberMessageExample example) throws SQLException{
        return tmembermessagedao. selectByExample( example);
    }

    public     TMemberMessage selectByPrimaryKey(Long id) throws SQLException{
        return tmembermessagedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberMessage record, TMemberMessageExample example) throws SQLException{
        return tmembermessagedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberMessage record, TMemberMessageExample example) throws SQLException{
        return tmembermessagedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberMessage record) throws SQLException{
        return tmembermessagedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberMessage record) throws SQLException{
        return tmembermessagedao. updateByPrimaryKey( record);
    }


}
