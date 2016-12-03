package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TOrderShipmentDAO;
import com.rc.portal.service.TOrderShipmentManager;
import com.rc.portal.vo.TOrderShipment;
import com.rc.portal.vo.TOrderShipmentExample;

public class TOrderShipmentManagerImpl  implements TOrderShipmentManager {

    private TOrderShipmentDAO tordershipmentdao;

    public TOrderShipmentManagerImpl() {
        super();
    }
    public void  setTordershipmentdao(TOrderShipmentDAO tordershipmentdao){
        this.tordershipmentdao=tordershipmentdao;
    }
    public TOrderShipmentDAO getTordershipmentdao(){
        return this.tordershipmentdao;
    }
    public     int countByExample(TOrderShipmentExample example) throws SQLException{
        return tordershipmentdao. countByExample( example);
    }

    public     int deleteByExample(TOrderShipmentExample example) throws SQLException{
        return tordershipmentdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tordershipmentdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TOrderShipment record) throws SQLException{
        return tordershipmentdao. insert( record);
    }

    public     Long insertSelective(TOrderShipment record) throws SQLException{
        return tordershipmentdao. insertSelective( record);
    }

    public     List selectByExample(TOrderShipmentExample example) throws SQLException{
        return tordershipmentdao. selectByExample( example);
    }

    public     TOrderShipment selectByPrimaryKey(Long id) throws SQLException{
        return tordershipmentdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TOrderShipment record, TOrderShipmentExample example) throws SQLException{
        return tordershipmentdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TOrderShipment record, TOrderShipmentExample example) throws SQLException{
        return tordershipmentdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TOrderShipment record) throws SQLException{
        return tordershipmentdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TOrderShipment record) throws SQLException{
        return tordershipmentdao. updateByPrimaryKey( record);
    }


}
