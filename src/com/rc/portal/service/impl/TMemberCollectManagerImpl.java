package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberCollectDAO;
import com.rc.portal.service.TMemberCollectManager;
import com.rc.portal.vo.TMemberCollect;
import com.rc.portal.vo.TMemberCollectExample;

public class TMemberCollectManagerImpl  implements TMemberCollectManager {

    private TMemberCollectDAO tmembercollectdao;

    public TMemberCollectManagerImpl() {
        super();
    }
    public void  setTmembercollectdao(TMemberCollectDAO tmembercollectdao){
        this.tmembercollectdao=tmembercollectdao;
    }
    public TMemberCollectDAO getTmembercollectdao(){
        return this.tmembercollectdao;
    }
    public     int countByExample(TMemberCollectExample example) throws SQLException{
        return tmembercollectdao. countByExample( example);
    }

    public     int deleteByExample(TMemberCollectExample example) throws SQLException{
        return tmembercollectdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmembercollectdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberCollect record) throws SQLException{
        return tmembercollectdao. insert( record);
    }

    public     Long insertSelective(TMemberCollect record) throws SQLException{
        return tmembercollectdao. insertSelective( record);
    }

    public     List selectByExample(TMemberCollectExample example) throws SQLException{
        return tmembercollectdao. selectByExample( example);
    }

    public     TMemberCollect selectByPrimaryKey(Long id) throws SQLException{
        return tmembercollectdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberCollect record, TMemberCollectExample example) throws SQLException{
        return tmembercollectdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberCollect record, TMemberCollectExample example) throws SQLException{
        return tmembercollectdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberCollect record) throws SQLException{
        return tmembercollectdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberCollect record) throws SQLException{
        return tmembercollectdao. updateByPrimaryKey( record);
    }


}
