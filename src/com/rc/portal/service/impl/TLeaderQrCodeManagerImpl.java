package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLeaderQrCodeDAO;
import com.rc.portal.service.TLeaderQrCodeManager;
import com.rc.portal.vo.TLeaderQrCode;
import com.rc.portal.vo.TLeaderQrCodeExample;

public class TLeaderQrCodeManagerImpl  implements TLeaderQrCodeManager {

    private TLeaderQrCodeDAO tleaderqrcodedao;

    public TLeaderQrCodeManagerImpl() {
        super();
    }
    public void  setTleaderqrcodedao(TLeaderQrCodeDAO tleaderqrcodedao){
        this.tleaderqrcodedao=tleaderqrcodedao;
    }
    public TLeaderQrCodeDAO getTleaderqrcodedao(){
        return this.tleaderqrcodedao;
    }
    public     int countByExample(TLeaderQrCodeExample example) throws SQLException{
        return tleaderqrcodedao. countByExample( example);
    }

    public     int deleteByExample(TLeaderQrCodeExample example) throws SQLException{
        return tleaderqrcodedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tleaderqrcodedao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLeaderQrCode record) throws SQLException{
        return tleaderqrcodedao. insert( record);
    }

    public     Long insertSelective(TLeaderQrCode record) throws SQLException{
        return tleaderqrcodedao. insertSelective( record);
    }

    public     List selectByExample(TLeaderQrCodeExample example) throws SQLException{
        return tleaderqrcodedao. selectByExample( example);
    }

    public     TLeaderQrCode selectByPrimaryKey(Long id) throws SQLException{
        return tleaderqrcodedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLeaderQrCode record, TLeaderQrCodeExample example) throws SQLException{
        return tleaderqrcodedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLeaderQrCode record, TLeaderQrCodeExample example) throws SQLException{
        return tleaderqrcodedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLeaderQrCode record) throws SQLException{
        return tleaderqrcodedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLeaderQrCode record) throws SQLException{
        return tleaderqrcodedao. updateByPrimaryKey( record);
    }


}
