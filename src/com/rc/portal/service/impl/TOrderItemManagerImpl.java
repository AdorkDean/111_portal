package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TOrderItemDAO;
import com.rc.portal.service.TOrderItemManager;
import com.rc.portal.vo.TOrderItem;
import com.rc.portal.vo.TOrderItemExample;

public class TOrderItemManagerImpl  implements TOrderItemManager {

    private TOrderItemDAO torderitemdao;

    public TOrderItemManagerImpl() {
        super();
    }
    public void  setTorderitemdao(TOrderItemDAO torderitemdao){
        this.torderitemdao=torderitemdao;
    }
    public TOrderItemDAO getTorderitemdao(){
        return this.torderitemdao;
    }
    public     int countByExample(TOrderItemExample example) throws SQLException{
        return torderitemdao. countByExample( example);
    }

    public     int deleteByExample(TOrderItemExample example) throws SQLException{
        return torderitemdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return torderitemdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TOrderItem record) throws SQLException{
        return torderitemdao. insert( record);
    }

    public     Long insertSelective(TOrderItem record) throws SQLException{
        return torderitemdao. insertSelective( record);
    }

    public     List selectByExample(TOrderItemExample example) throws SQLException{
        return torderitemdao. selectByExample( example);
    }

    public     TOrderItem selectByPrimaryKey(Long id) throws SQLException{
        return torderitemdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TOrderItem record, TOrderItemExample example) throws SQLException{
        return torderitemdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TOrderItem record, TOrderItemExample example) throws SQLException{
        return torderitemdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TOrderItem record) throws SQLException{
        return torderitemdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TOrderItem record) throws SQLException{
        return torderitemdao. updateByPrimaryKey( record);
    }


}
