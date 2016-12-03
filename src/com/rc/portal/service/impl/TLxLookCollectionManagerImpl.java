package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLxLookCollectionDAO;
import com.rc.portal.service.TLxLookCollectionManager;
import com.rc.portal.vo.TLxLookCollection;
import com.rc.portal.vo.TLxLookCollectionExample;

public class TLxLookCollectionManagerImpl  implements TLxLookCollectionManager {

    private TLxLookCollectionDAO tlxlookcollectiondao;

    public TLxLookCollectionManagerImpl() {
        super();
    }
    public void  setTlxlookcollectiondao(TLxLookCollectionDAO tlxlookcollectiondao){
        this.tlxlookcollectiondao=tlxlookcollectiondao;
    }
    public TLxLookCollectionDAO getTlxlookcollectiondao(){
        return this.tlxlookcollectiondao;
    }
    public     int countByExample(TLxLookCollectionExample example) throws SQLException{
        return tlxlookcollectiondao. countByExample( example);
    }

    public     int deleteByExample(TLxLookCollectionExample example) throws SQLException{
        return tlxlookcollectiondao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tlxlookcollectiondao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLxLookCollection record) throws SQLException{
        return tlxlookcollectiondao. insert( record);
    }

    public     Long insertSelective(TLxLookCollection record) throws SQLException{
        return tlxlookcollectiondao. insertSelective( record);
    }

    public     List selectByExample(TLxLookCollectionExample example) throws SQLException{
        return tlxlookcollectiondao. selectByExample( example);
    }

    public     TLxLookCollection selectByPrimaryKey(Long id) throws SQLException{
        return tlxlookcollectiondao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLxLookCollection record, TLxLookCollectionExample example) throws SQLException{
        return tlxlookcollectiondao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLxLookCollection record, TLxLookCollectionExample example) throws SQLException{
        return tlxlookcollectiondao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLxLookCollection record) throws SQLException{
        return tlxlookcollectiondao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLxLookCollection record) throws SQLException{
        return tlxlookcollectiondao. updateByPrimaryKey( record);
    }


}
