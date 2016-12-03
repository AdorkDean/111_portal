package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberIntegralDAO;
import com.rc.portal.service.TMemberIntegralManager;
import com.rc.portal.vo.TMemberIntegral;
import com.rc.portal.vo.TMemberIntegralExample;

public class TMemberIntegralManagerImpl  implements TMemberIntegralManager {

    private TMemberIntegralDAO tmemberintegraldao;

    public TMemberIntegralManagerImpl() {
        super();
    }
    public void  setTmemberintegraldao(TMemberIntegralDAO tmemberintegraldao){
        this.tmemberintegraldao=tmemberintegraldao;
    }
    public TMemberIntegralDAO getTmemberintegraldao(){
        return this.tmemberintegraldao;
    }
    public     int countByExample(TMemberIntegralExample example) throws SQLException{
        return tmemberintegraldao. countByExample( example);
    }

    public     int deleteByExample(TMemberIntegralExample example) throws SQLException{
        return tmemberintegraldao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmemberintegraldao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberIntegral record) throws SQLException{
        return tmemberintegraldao. insert( record);
    }

    public     Long insertSelective(TMemberIntegral record) throws SQLException{
        return tmemberintegraldao. insertSelective( record);
    }

    public     List selectByExample(TMemberIntegralExample example) throws SQLException{
        return tmemberintegraldao. selectByExample( example);
    }

    public     TMemberIntegral selectByPrimaryKey(Long id) throws SQLException{
        return tmemberintegraldao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberIntegral record, TMemberIntegralExample example) throws SQLException{
        return tmemberintegraldao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberIntegral record, TMemberIntegralExample example) throws SQLException{
        return tmemberintegraldao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberIntegral record) throws SQLException{
        return tmemberintegraldao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberIntegral record) throws SQLException{
        return tmemberintegraldao. updateByPrimaryKey( record);
    }


}
