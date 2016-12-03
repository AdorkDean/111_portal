package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TOrderLeaderDAO;
import com.rc.portal.service.TOrderLeaderManager;
import com.rc.portal.vo.TOrderLeader;
import com.rc.portal.vo.TOrderLeaderExample;

public class TOrderLeaderManagerImpl  implements TOrderLeaderManager {

    private TOrderLeaderDAO torderleaderdao;

    public TOrderLeaderManagerImpl() {
        super();
    }
    public void  setTorderleaderdao(TOrderLeaderDAO torderleaderdao){
        this.torderleaderdao=torderleaderdao;
    }
    public TOrderLeaderDAO getTorderleaderdao(){
        return this.torderleaderdao;
    }
    public     int countByExample(TOrderLeaderExample example) throws SQLException{
        return torderleaderdao. countByExample( example);
    }

    public     int deleteByExample(TOrderLeaderExample example) throws SQLException{
        return torderleaderdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return torderleaderdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TOrderLeader record) throws SQLException{
        return torderleaderdao. insert( record);
    }

    public     Long insertSelective(TOrderLeader record) throws SQLException{
        return torderleaderdao. insertSelective( record);
    }

    public     List selectByExample(TOrderLeaderExample example) throws SQLException{
        return torderleaderdao. selectByExample( example);
    }

    public     TOrderLeader selectByPrimaryKey(Long id) throws SQLException{
        return torderleaderdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TOrderLeader record, TOrderLeaderExample example) throws SQLException{
        return torderleaderdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TOrderLeader record, TOrderLeaderExample example) throws SQLException{
        return torderleaderdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TOrderLeader record) throws SQLException{
        return torderleaderdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TOrderLeader record) throws SQLException{
        return torderleaderdao. updateByPrimaryKey( record);
    }


}
