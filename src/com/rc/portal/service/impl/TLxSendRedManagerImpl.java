package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLxSendRedDAO;
import com.rc.portal.service.TLxSendRedManager;
import com.rc.portal.vo.TLxSendRed;
import com.rc.portal.vo.TLxSendRedExample;

public class TLxSendRedManagerImpl  implements TLxSendRedManager {

    private TLxSendRedDAO tlxsendreddao;

    public TLxSendRedManagerImpl() {
        super();
    }
    public void  setTlxsendreddao(TLxSendRedDAO tlxsendreddao){
        this.tlxsendreddao=tlxsendreddao;
    }
    public TLxSendRedDAO getTlxsendreddao(){
        return this.tlxsendreddao;
    }
    public     int countByExample(TLxSendRedExample example) throws SQLException{
        return tlxsendreddao. countByExample( example);
    }

    public     int deleteByExample(TLxSendRedExample example) throws SQLException{
        return tlxsendreddao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tlxsendreddao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLxSendRed record) throws SQLException{
        return tlxsendreddao. insert( record);
    }

    public     Long insertSelective(TLxSendRed record) throws SQLException{
        return tlxsendreddao. insertSelective( record);
    }

    public     List selectByExample(TLxSendRedExample example) throws SQLException{
        return tlxsendreddao. selectByExample( example);
    }

    public     TLxSendRed selectByPrimaryKey(Long id) throws SQLException{
        return tlxsendreddao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLxSendRed record, TLxSendRedExample example) throws SQLException{
        return tlxsendreddao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLxSendRed record, TLxSendRedExample example) throws SQLException{
        return tlxsendreddao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLxSendRed record) throws SQLException{
        return tlxsendreddao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLxSendRed record) throws SQLException{
        return tlxsendreddao. updateByPrimaryKey( record);
    }


}
