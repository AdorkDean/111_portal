package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberBaseMessageExtDAO;
import com.rc.portal.service.TMemberBaseMessageExtManager;
import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.vo.TMemberBaseMessageExtExample;

public class TMemberBaseMessageExtManagerImpl  implements TMemberBaseMessageExtManager {

    private TMemberBaseMessageExtDAO tmemberbasemessageextdao;

    public TMemberBaseMessageExtManagerImpl() {
        super();
    }
    public void  setTmemberbasemessageextdao(TMemberBaseMessageExtDAO tmemberbasemessageextdao){
        this.tmemberbasemessageextdao=tmemberbasemessageextdao;
    }
    public TMemberBaseMessageExtDAO getTmemberbasemessageextdao(){
        return this.tmemberbasemessageextdao;
    }
    public     int countByExample(TMemberBaseMessageExtExample example) throws SQLException{
        return tmemberbasemessageextdao. countByExample( example);
    }

    public     int deleteByExample(TMemberBaseMessageExtExample example) throws SQLException{
        return tmemberbasemessageextdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long memberId) throws SQLException{
        return tmemberbasemessageextdao. deleteByPrimaryKey( memberId);
    }

    public     Long insert(TMemberBaseMessageExt record) throws SQLException{
        return tmemberbasemessageextdao. insert( record);
    }

    public     Long insertSelective(TMemberBaseMessageExt record) throws SQLException{
        return tmemberbasemessageextdao. insertSelective( record);
    }

    public     List selectByExample(TMemberBaseMessageExtExample example) throws SQLException{
        return tmemberbasemessageextdao. selectByExample( example);
    }

    public     TMemberBaseMessageExt selectByPrimaryKey(Long memberId) throws SQLException{
        return tmemberbasemessageextdao. selectByPrimaryKey( memberId);
    }

    public     int updateByExampleSelective(TMemberBaseMessageExt record, TMemberBaseMessageExtExample example) throws SQLException{
        return tmemberbasemessageextdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberBaseMessageExt record, TMemberBaseMessageExtExample example) throws SQLException{
        return tmemberbasemessageextdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberBaseMessageExt record) throws SQLException{
        return tmemberbasemessageextdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberBaseMessageExt record) throws SQLException{
        return tmemberbasemessageextdao. updateByPrimaryKey( record);
    }


}
