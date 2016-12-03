package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.CDeliveryWayDAO;
import com.rc.portal.service.CDeliveryWayManager;
import com.rc.portal.vo.CDeliveryWay;
import com.rc.portal.vo.CDeliveryWayExample;

public class CDeliveryWayManagerImpl  implements CDeliveryWayManager {

    private CDeliveryWayDAO cdeliverywaydao;

    public CDeliveryWayManagerImpl() {
        super();
    }
    public void  setCdeliverywaydao(CDeliveryWayDAO cdeliverywaydao){
        this.cdeliverywaydao=cdeliverywaydao;
    }
    public CDeliveryWayDAO getCdeliverywaydao(){
        return this.cdeliverywaydao;
    }
    public     int countByExample(CDeliveryWayExample example) throws SQLException{
        return cdeliverywaydao. countByExample( example);
    }

    public     int deleteByExample(CDeliveryWayExample example) throws SQLException{
        return cdeliverywaydao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return cdeliverywaydao. deleteByPrimaryKey( id);
    }

    public     Long insert(CDeliveryWay record) throws SQLException{
        return cdeliverywaydao. insert( record);
    }

    public     Long insertSelective(CDeliveryWay record) throws SQLException{
        return cdeliverywaydao. insertSelective( record);
    }

    public     List selectByExample(CDeliveryWayExample example) throws SQLException{
        return cdeliverywaydao. selectByExample( example);
    }

    public     CDeliveryWay selectByPrimaryKey(Long id) throws SQLException{
        return cdeliverywaydao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(CDeliveryWay record, CDeliveryWayExample example) throws SQLException{
        return cdeliverywaydao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(CDeliveryWay record, CDeliveryWayExample example) throws SQLException{
        return cdeliverywaydao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(CDeliveryWay record) throws SQLException{
        return cdeliverywaydao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(CDeliveryWay record) throws SQLException{
        return cdeliverywaydao. updateByPrimaryKey( record);
    }


}
