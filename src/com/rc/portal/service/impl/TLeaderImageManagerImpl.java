package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLeaderImageDAO;
import com.rc.portal.service.TLeaderImageManager;
import com.rc.portal.vo.TLeaderImage;
import com.rc.portal.vo.TLeaderImageExample;

public class TLeaderImageManagerImpl  implements TLeaderImageManager {

    private TLeaderImageDAO tleaderimagedao;

    public TLeaderImageManagerImpl() {
        super();
    }
    public void  setTleaderimagedao(TLeaderImageDAO tleaderimagedao){
        this.tleaderimagedao=tleaderimagedao;
    }
    public TLeaderImageDAO getTleaderimagedao(){
        return this.tleaderimagedao;
    }
    public     int countByExample(TLeaderImageExample example) throws SQLException{
        return tleaderimagedao. countByExample( example);
    }

    public     int deleteByExample(TLeaderImageExample example) throws SQLException{
        return tleaderimagedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tleaderimagedao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLeaderImage record) throws SQLException{
        return tleaderimagedao. insert( record);
    }

    public     Long insertSelective(TLeaderImage record) throws SQLException{
        return tleaderimagedao. insertSelective( record);
    }

    public     List selectByExample(TLeaderImageExample example) throws SQLException{
        return tleaderimagedao. selectByExample( example);
    }

    public     TLeaderImage selectByPrimaryKey(Long id) throws SQLException{
        return tleaderimagedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLeaderImage record, TLeaderImageExample example) throws SQLException{
        return tleaderimagedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLeaderImage record, TLeaderImageExample example) throws SQLException{
        return tleaderimagedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLeaderImage record) throws SQLException{
        return tleaderimagedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLeaderImage record) throws SQLException{
        return tleaderimagedao. updateByPrimaryKey( record);
    }


}
