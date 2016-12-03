package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TOrderFlowDAO;
import com.rc.portal.service.TOrderFlowManager;
import com.rc.portal.vo.TOrderFlow;
import com.rc.portal.vo.TOrderFlowExample;

public class TOrderFlowManagerImpl  implements TOrderFlowManager {

    private TOrderFlowDAO torderflowdao;

    public TOrderFlowManagerImpl() {
        super();
    }
    public void  setTorderflowdao(TOrderFlowDAO torderflowdao){
        this.torderflowdao=torderflowdao;
    }
    public TOrderFlowDAO getTorderflowdao(){
        return this.torderflowdao;
    }
    public     int countByExample(TOrderFlowExample example) throws SQLException{
        return torderflowdao. countByExample( example);
    }

    public     int deleteByExample(TOrderFlowExample example) throws SQLException{
        return torderflowdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return torderflowdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TOrderFlow record) throws SQLException{
        return torderflowdao. insert( record);
    }

    public     Long insertSelective(TOrderFlow record) throws SQLException{
        return torderflowdao. insertSelective( record);
    }

    public     List selectByExample(TOrderFlowExample example) throws SQLException{
        return torderflowdao. selectByExample( example);
    }

    public     TOrderFlow selectByPrimaryKey(Long id) throws SQLException{
        return torderflowdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TOrderFlow record, TOrderFlowExample example) throws SQLException{
        return torderflowdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TOrderFlow record, TOrderFlowExample example) throws SQLException{
        return torderflowdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TOrderFlow record) throws SQLException{
        return torderflowdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TOrderFlow record) throws SQLException{
        return torderflowdao. updateByPrimaryKey( record);
    }


}
