package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLxShareCollectionDAO;
import com.rc.portal.service.TLxShareCollectionManager;
import com.rc.portal.vo.TLxShareCollection;
import com.rc.portal.vo.TLxShareCollectionExample;

public class TLxShareCollectionManagerImpl  implements TLxShareCollectionManager {

    private TLxShareCollectionDAO tlxsharecollectiondao;

    public TLxShareCollectionManagerImpl() {
        super();
    }
    public void  setTlxsharecollectiondao(TLxShareCollectionDAO tlxsharecollectiondao){
        this.tlxsharecollectiondao=tlxsharecollectiondao;
    }
    public TLxShareCollectionDAO getTlxsharecollectiondao(){
        return this.tlxsharecollectiondao;
    }
    public     int countByExample(TLxShareCollectionExample example) throws SQLException{
        return tlxsharecollectiondao. countByExample( example);
    }

    public     int deleteByExample(TLxShareCollectionExample example) throws SQLException{
        return tlxsharecollectiondao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tlxsharecollectiondao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLxShareCollection record) throws SQLException{
        return tlxsharecollectiondao. insert( record);
    }

    public     Long insertSelective(TLxShareCollection record) throws SQLException{
        return tlxsharecollectiondao. insertSelective( record);
    }

    public     List selectByExample(TLxShareCollectionExample example) throws SQLException{
        return tlxsharecollectiondao. selectByExample( example);
    }

    public     TLxShareCollection selectByPrimaryKey(Long id) throws SQLException{
        return tlxsharecollectiondao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLxShareCollection record, TLxShareCollectionExample example) throws SQLException{
        return tlxsharecollectiondao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLxShareCollection record, TLxShareCollectionExample example) throws SQLException{
        return tlxsharecollectiondao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLxShareCollection record) throws SQLException{
        return tlxsharecollectiondao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLxShareCollection record) throws SQLException{
        return tlxsharecollectiondao. updateByPrimaryKey( record);
    }


}
