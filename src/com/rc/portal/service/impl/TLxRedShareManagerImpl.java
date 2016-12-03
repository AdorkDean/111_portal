package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLxRedShareDAO;
import com.rc.portal.service.TLxRedShareManager;
import com.rc.portal.vo.TLxRedShare;
import com.rc.portal.vo.TLxRedShareExample;

public class TLxRedShareManagerImpl  implements TLxRedShareManager {

    private TLxRedShareDAO tlxredsharedao;

    public TLxRedShareManagerImpl() {
        super();
    }
    public void  setTlxredsharedao(TLxRedShareDAO tlxredsharedao){
        this.tlxredsharedao=tlxredsharedao;
    }
    public TLxRedShareDAO getTlxredsharedao(){
        return this.tlxredsharedao;
    }
    public     int countByExample(TLxRedShareExample example) throws SQLException{
        return tlxredsharedao. countByExample( example);
    }

    public     int deleteByExample(TLxRedShareExample example) throws SQLException{
        return tlxredsharedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tlxredsharedao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLxRedShare record) throws SQLException{
        return tlxredsharedao. insert( record);
    }

    public     Long insertSelective(TLxRedShare record) throws SQLException{
        return tlxredsharedao. insertSelective( record);
    }

    public     List selectByExample(TLxRedShareExample example) throws SQLException{
        return tlxredsharedao. selectByExample( example);
    }

    public     TLxRedShare selectByPrimaryKey(Long id) throws SQLException{
        return tlxredsharedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLxRedShare record, TLxRedShareExample example) throws SQLException{
        return tlxredsharedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLxRedShare record, TLxRedShareExample example) throws SQLException{
        return tlxredsharedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLxRedShare record) throws SQLException{
        return tlxredsharedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLxRedShare record) throws SQLException{
        return tlxredsharedao. updateByPrimaryKey( record);
    }


}
