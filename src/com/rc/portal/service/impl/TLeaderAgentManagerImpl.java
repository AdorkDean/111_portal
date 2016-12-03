package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLeaderAgentDAO;
import com.rc.portal.service.TLeaderAgentManager;
import com.rc.portal.vo.TLeaderAgent;
import com.rc.portal.vo.TLeaderAgentExample;

public class TLeaderAgentManagerImpl  implements TLeaderAgentManager {

    private TLeaderAgentDAO tleaderagentdao;

    public TLeaderAgentManagerImpl() {
        super();
    }
    public void  setTleaderagentdao(TLeaderAgentDAO tleaderagentdao){
        this.tleaderagentdao=tleaderagentdao;
    }
    public TLeaderAgentDAO getTleaderagentdao(){
        return this.tleaderagentdao;
    }
    public     int countByExample(TLeaderAgentExample example) throws SQLException{
        return tleaderagentdao. countByExample( example);
    }

    public     int deleteByExample(TLeaderAgentExample example) throws SQLException{
        return tleaderagentdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tleaderagentdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLeaderAgent record) throws SQLException{
        return tleaderagentdao. insert( record);
    }

    public     Long insertSelective(TLeaderAgent record) throws SQLException{
        return tleaderagentdao. insertSelective( record);
    }

    public     List selectByExample(TLeaderAgentExample example) throws SQLException{
        return tleaderagentdao. selectByExample( example);
    }

    public     TLeaderAgent selectByPrimaryKey(Long id) throws SQLException{
        return tleaderagentdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLeaderAgent record, TLeaderAgentExample example) throws SQLException{
        return tleaderagentdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLeaderAgent record, TLeaderAgentExample example) throws SQLException{
        return tleaderagentdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLeaderAgent record) throws SQLException{
        return tleaderagentdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLeaderAgent record) throws SQLException{
        return tleaderagentdao. updateByPrimaryKey( record);
    }


}
