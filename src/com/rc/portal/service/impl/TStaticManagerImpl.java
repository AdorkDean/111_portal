package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TStaticDAO;
import com.rc.portal.service.TStaticManager;
import com.rc.portal.vo.TStatic;
import com.rc.portal.vo.TStaticExample;

public class TStaticManagerImpl  implements TStaticManager {

    private TStaticDAO tstaticdao;

    public TStaticManagerImpl() {
        super();
    }
    public void  setTstaticdao(TStaticDAO tstaticdao){
        this.tstaticdao=tstaticdao;
    }
    public TStaticDAO getTstaticdao(){
        return this.tstaticdao;
    }
    public     int countByExample(TStaticExample example) throws SQLException{
        return tstaticdao. countByExample( example);
    }

    public     int deleteByExample(TStaticExample example) throws SQLException{
        return tstaticdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tstaticdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TStatic record) throws SQLException{
        return tstaticdao. insert( record);
    }

    public     Long insertSelective(TStatic record) throws SQLException{
        return tstaticdao. insertSelective( record);
    }

    public     List selectByExample(TStaticExample example) throws SQLException{
        return tstaticdao. selectByExample( example);
    }

    public     TStatic selectByPrimaryKey(Long id) throws SQLException{
        return tstaticdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TStatic record, TStaticExample example) throws SQLException{
        return tstaticdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TStatic record, TStaticExample example) throws SQLException{
        return tstaticdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TStatic record) throws SQLException{
        return tstaticdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TStatic record) throws SQLException{
        return tstaticdao. updateByPrimaryKey( record);
    }


}
