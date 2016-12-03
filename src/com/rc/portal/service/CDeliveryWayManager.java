package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.CDeliveryWay;
import com.rc.portal.vo.CDeliveryWayExample;

public interface CDeliveryWayManager {
    int countByExample(CDeliveryWayExample example) throws SQLException;

    int deleteByExample(CDeliveryWayExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(CDeliveryWay record) throws SQLException;

    Long insertSelective(CDeliveryWay record) throws SQLException;

    List selectByExample(CDeliveryWayExample example) throws SQLException;

    CDeliveryWay selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(CDeliveryWay record, CDeliveryWayExample example) throws SQLException;

    int updateByExample(CDeliveryWay record, CDeliveryWayExample example) throws SQLException;

    int updateByPrimaryKeySelective(CDeliveryWay record) throws SQLException;

    int updateByPrimaryKey(CDeliveryWay record) throws SQLException;



}
