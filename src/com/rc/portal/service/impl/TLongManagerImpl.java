package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLongDAO;
import com.rc.portal.service.TLongManager;
import com.rc.portal.vo.TLong;
import com.rc.portal.vo.TLongExample;

public class TLongManagerImpl  implements TLongManager {

    private TLongDAO tlongdao;

    public TLongManagerImpl() {
        super();
    }
    public void  setTlongdao(TLongDAO tlongdao){
        this.tlongdao=tlongdao;
    }
    public TLongDAO getTlongdao(){
        return this.tlongdao;
    }
    public     int countByExample(TLongExample example) throws SQLException{
        return tlongdao. countByExample( example);
    }

    public     int deleteByExample(TLongExample example) throws SQLException{
        return tlongdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tlongdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLong record) throws SQLException{
        return tlongdao. insert( record);
    }

    public     Long insertSelective(TLong record) throws SQLException{
        return tlongdao. insertSelective( record);
    }

    public     List selectByExample(TLongExample example) throws SQLException{
        return tlongdao. selectByExample( example);
    }

    public     TLong selectByPrimaryKey(Long id) throws SQLException{
        return tlongdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLong record, TLongExample example) throws SQLException{
        return tlongdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLong record, TLongExample example) throws SQLException{
        return tlongdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLong record) throws SQLException{
        return tlongdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLong record) throws SQLException{
        return tlongdao. updateByPrimaryKey( record);
    }


}
