package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLxReceiveRedDAO;
import com.rc.portal.service.TLxReceiveRedManager;
import com.rc.portal.vo.TLxReceiveRed;
import com.rc.portal.vo.TLxReceiveRedExample;

public class TLxReceiveRedManagerImpl  implements TLxReceiveRedManager {

    private TLxReceiveRedDAO tlxreceivereddao;

    public TLxReceiveRedManagerImpl() {
        super();
    }
    public void  setTlxreceivereddao(TLxReceiveRedDAO tlxreceivereddao){
        this.tlxreceivereddao=tlxreceivereddao;
    }
    public TLxReceiveRedDAO getTlxreceivereddao(){
        return this.tlxreceivereddao;
    }
    public     int countByExample(TLxReceiveRedExample example) throws SQLException{
        return tlxreceivereddao. countByExample( example);
    }

    public     int deleteByExample(TLxReceiveRedExample example) throws SQLException{
        return tlxreceivereddao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tlxreceivereddao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLxReceiveRed record) throws SQLException{
        return tlxreceivereddao. insert( record);
    }

    public     Long insertSelective(TLxReceiveRed record) throws SQLException{
        return tlxreceivereddao. insertSelective( record);
    }

    public     List selectByExample(TLxReceiveRedExample example) throws SQLException{
        return tlxreceivereddao. selectByExample( example);
    }

    public     TLxReceiveRed selectByPrimaryKey(Long id) throws SQLException{
        return tlxreceivereddao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLxReceiveRed record, TLxReceiveRedExample example) throws SQLException{
        return tlxreceivereddao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLxReceiveRed record, TLxReceiveRedExample example) throws SQLException{
        return tlxreceivereddao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLxReceiveRed record) throws SQLException{
        return tlxreceivereddao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLxReceiveRed record) throws SQLException{
        return tlxreceivereddao. updateByPrimaryKey( record);
    }


}
