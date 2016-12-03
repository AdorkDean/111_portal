package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TMemberReceiverLatLon;
import com.rc.portal.vo.TMemberReceiverLatLonExample;

public interface TMemberReceiverLatLonDAO {
    int countByExample(TMemberReceiverLatLonExample example) throws SQLException;

    int deleteByExample(TMemberReceiverLatLonExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TMemberReceiverLatLon record) throws SQLException;

    Long insertSelective(TMemberReceiverLatLon record) throws SQLException;

    List selectByExample(TMemberReceiverLatLonExample example) throws SQLException;

    TMemberReceiverLatLon selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TMemberReceiverLatLon record, TMemberReceiverLatLonExample example) throws SQLException;

    int updateByExample(TMemberReceiverLatLon record, TMemberReceiverLatLonExample example) throws SQLException;

    int updateByPrimaryKeySelective(TMemberReceiverLatLon record) throws SQLException;

    int updateByPrimaryKey(TMemberReceiverLatLon record) throws SQLException;


}
