package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLxContentDAO;
import com.rc.portal.service.TLxContentManager;
import com.rc.portal.vo.TLxContent;
import com.rc.portal.vo.TLxContentExample;

public class TLxContentManagerImpl  implements TLxContentManager {

    private TLxContentDAO tlxcontentdao;

    public TLxContentManagerImpl() {
        super();
    }
    public void  setTlxcontentdao(TLxContentDAO tlxcontentdao){
        this.tlxcontentdao=tlxcontentdao;
    }
    public TLxContentDAO getTlxcontentdao(){
        return this.tlxcontentdao;
    }
    public     int countByExample(TLxContentExample example) throws SQLException{
        return tlxcontentdao. countByExample( example);
    }

    public     int deleteByExample(TLxContentExample example) throws SQLException{
        return tlxcontentdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tlxcontentdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLxContent record) throws SQLException{
        return tlxcontentdao. insert( record);
    }

    public     Long insertSelective(TLxContent record) throws SQLException{
        return tlxcontentdao. insertSelective( record);
    }

    public     List selectByExample(TLxContentExample example) throws SQLException{
        return tlxcontentdao. selectByExample( example);
    }

    public     TLxContent selectByPrimaryKey(Long id) throws SQLException{
        return tlxcontentdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLxContent record, TLxContentExample example) throws SQLException{
        return tlxcontentdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLxContent record, TLxContentExample example) throws SQLException{
        return tlxcontentdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLxContent record) throws SQLException{
        return tlxcontentdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLxContent record) throws SQLException{
        return tlxcontentdao. updateByPrimaryKey( record);
    }


}
