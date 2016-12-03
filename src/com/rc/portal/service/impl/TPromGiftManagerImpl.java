package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TPromGiftDAO;
import com.rc.portal.service.TPromGiftManager;
import com.rc.portal.vo.TPromGift;
import com.rc.portal.vo.TPromGiftExample;

public class TPromGiftManagerImpl  implements TPromGiftManager {

    private TPromGiftDAO tpromgiftdao;

    public TPromGiftManagerImpl() {
        super();
    }
    public void  setTpromgiftdao(TPromGiftDAO tpromgiftdao){
        this.tpromgiftdao=tpromgiftdao;
    }
    public TPromGiftDAO getTpromgiftdao(){
        return this.tpromgiftdao;
    }
    public     int countByExample(TPromGiftExample example) throws SQLException{
        return tpromgiftdao. countByExample( example);
    }

    public     int deleteByExample(TPromGiftExample example) throws SQLException{
        return tpromgiftdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tpromgiftdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TPromGift record) throws SQLException{
        return tpromgiftdao. insert( record);
    }

    public     Long insertSelective(TPromGift record) throws SQLException{
        return tpromgiftdao. insertSelective( record);
    }

    public     List selectByExample(TPromGiftExample example) throws SQLException{
        return tpromgiftdao. selectByExample( example);
    }

    public     TPromGift selectByPrimaryKey(Long id) throws SQLException{
        return tpromgiftdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TPromGift record, TPromGiftExample example) throws SQLException{
        return tpromgiftdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TPromGift record, TPromGiftExample example) throws SQLException{
        return tpromgiftdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TPromGift record) throws SQLException{
        return tpromgiftdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TPromGift record) throws SQLException{
        return tpromgiftdao. updateByPrimaryKey( record);
    }


}
