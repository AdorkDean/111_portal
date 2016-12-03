package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberThreeBindingDAO;
import com.rc.portal.service.TMemberThreeBindingManager;
import com.rc.portal.vo.TMemberThreeBinding;
import com.rc.portal.vo.TMemberThreeBindingExample;

public class TMemberThreeBindingManagerImpl  implements TMemberThreeBindingManager {

    private TMemberThreeBindingDAO tmemberthreebindingdao;

    public TMemberThreeBindingManagerImpl() {
        super();
    }
    public void  setTmemberthreebindingdao(TMemberThreeBindingDAO tmemberthreebindingdao){
        this.tmemberthreebindingdao=tmemberthreebindingdao;
    }
    public TMemberThreeBindingDAO getTmemberthreebindingdao(){
        return this.tmemberthreebindingdao;
    }
    public     int countByExample(TMemberThreeBindingExample example) throws SQLException{
        return tmemberthreebindingdao. countByExample( example);
    }

    public     int deleteByExample(TMemberThreeBindingExample example) throws SQLException{
        return tmemberthreebindingdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmemberthreebindingdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberThreeBinding record) throws SQLException{
        return tmemberthreebindingdao. insert( record);
    }

    public     Long insertSelective(TMemberThreeBinding record) throws SQLException{
        return tmemberthreebindingdao. insertSelective( record);
    }

    public     List selectByExample(TMemberThreeBindingExample example) throws SQLException{
        return tmemberthreebindingdao. selectByExample( example);
    }

    public     TMemberThreeBinding selectByPrimaryKey(Long id) throws SQLException{
        return tmemberthreebindingdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberThreeBinding record, TMemberThreeBindingExample example) throws SQLException{
        return tmemberthreebindingdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberThreeBinding record, TMemberThreeBindingExample example) throws SQLException{
        return tmemberthreebindingdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberThreeBinding record) throws SQLException{
        return tmemberthreebindingdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberThreeBinding record) throws SQLException{
        return tmemberthreebindingdao. updateByPrimaryKey( record);
    }


}
