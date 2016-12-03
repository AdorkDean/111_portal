package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TMemberYkt;
import com.rc.portal.vo.TMemberYktExample;

public interface TMemberYktManager {
    int countByExample(TMemberYktExample example) throws SQLException;

    int deleteByExample(TMemberYktExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TMemberYkt record) throws SQLException;

    Long insertSelective(TMemberYkt record) throws SQLException;

    List selectByExample(TMemberYktExample example) throws SQLException;

    TMemberYkt selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TMemberYkt record, TMemberYktExample example) throws SQLException;

    int updateByExample(TMemberYkt record, TMemberYktExample example) throws SQLException;

    int updateByPrimaryKeySelective(TMemberYkt record) throws SQLException;

    int updateByPrimaryKey(TMemberYkt record) throws SQLException;



}
