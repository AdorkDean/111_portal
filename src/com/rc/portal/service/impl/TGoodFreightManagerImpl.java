package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TGoodFreightDAO;
import com.rc.portal.service.TGoodFreightManager;
import com.rc.portal.vo.TGoodFreight;
import com.rc.portal.vo.TGoodFreightExample;

public class TGoodFreightManagerImpl  implements TGoodFreightManager {

    private TGoodFreightDAO tgoodfreightdao;

    public TGoodFreightManagerImpl() {
        super();
    }
    public void  setTgoodfreightdao(TGoodFreightDAO tgoodfreightdao){
        this.tgoodfreightdao=tgoodfreightdao;
    }
    public TGoodFreightDAO getTgoodfreightdao(){
        return this.tgoodfreightdao;
    }
    public     int countByExample(TGoodFreightExample example) throws SQLException{
        return tgoodfreightdao. countByExample( example);
    }

    public     int deleteByExample(TGoodFreightExample example) throws SQLException{
        return tgoodfreightdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tgoodfreightdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TGoodFreight record) throws SQLException{
        return tgoodfreightdao. insert( record);
    }

    public     Long insertSelective(TGoodFreight record) throws SQLException{
        return tgoodfreightdao. insertSelective( record);
    }

    public     List selectByExample(TGoodFreightExample example) throws SQLException{
        return tgoodfreightdao. selectByExample( example);
    }

    public     TGoodFreight selectByPrimaryKey(Long id) throws SQLException{
        return tgoodfreightdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TGoodFreight record, TGoodFreightExample example) throws SQLException{
        return tgoodfreightdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TGoodFreight record, TGoodFreightExample example) throws SQLException{
        return tgoodfreightdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TGoodFreight record) throws SQLException{
        return tgoodfreightdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TGoodFreight record) throws SQLException{
        return tgoodfreightdao. updateByPrimaryKey( record);
    }


}
