package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLeaderAccountNumberDAO;
import com.rc.portal.service.TLeaderAccountNumberManager;
import com.rc.portal.vo.TLeaderAccountNumber;
import com.rc.portal.vo.TLeaderAccountNumberExample;

public class TLeaderAccountNumberManagerImpl  implements TLeaderAccountNumberManager {

    private TLeaderAccountNumberDAO tleaderaccountnumberdao;

    public TLeaderAccountNumberManagerImpl() {
        super();
    }
    public void  setTleaderaccountnumberdao(TLeaderAccountNumberDAO tleaderaccountnumberdao){
        this.tleaderaccountnumberdao=tleaderaccountnumberdao;
    }
    public TLeaderAccountNumberDAO getTleaderaccountnumberdao(){
        return this.tleaderaccountnumberdao;
    }
    public     int countByExample(TLeaderAccountNumberExample example) throws SQLException{
        return tleaderaccountnumberdao. countByExample( example);
    }

    public     int deleteByExample(TLeaderAccountNumberExample example) throws SQLException{
        return tleaderaccountnumberdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tleaderaccountnumberdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLeaderAccountNumber record) throws SQLException{
        return tleaderaccountnumberdao. insert( record);
    }

    public     Long insertSelective(TLeaderAccountNumber record) throws SQLException{
        return tleaderaccountnumberdao. insertSelective( record);
    }

    public     List selectByExample(TLeaderAccountNumberExample example) throws SQLException{
        return tleaderaccountnumberdao. selectByExample( example);
    }

    public     TLeaderAccountNumber selectByPrimaryKey(Long id) throws SQLException{
        return tleaderaccountnumberdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLeaderAccountNumber record, TLeaderAccountNumberExample example) throws SQLException{
        return tleaderaccountnumberdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLeaderAccountNumber record, TLeaderAccountNumberExample example) throws SQLException{
        return tleaderaccountnumberdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLeaderAccountNumber record) throws SQLException{
        return tleaderaccountnumberdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLeaderAccountNumber record) throws SQLException{
        return tleaderaccountnumberdao. updateByPrimaryKey( record);
    }


}
