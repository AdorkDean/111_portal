package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TMemberMessage;
import com.rc.portal.vo.TMemberMessageExample;

public interface TMemberMessageDAO {
    int countByExample(TMemberMessageExample example) throws SQLException;

    int deleteByExample(TMemberMessageExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TMemberMessage record) throws SQLException;

    Long insertSelective(TMemberMessage record) throws SQLException;

    List selectByExample(TMemberMessageExample example) throws SQLException;

    TMemberMessage selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TMemberMessage record, TMemberMessageExample example) throws SQLException;

    int updateByExample(TMemberMessage record, TMemberMessageExample example) throws SQLException;

    int updateByPrimaryKeySelective(TMemberMessage record) throws SQLException;

    int updateByPrimaryKey(TMemberMessage record) throws SQLException;


}
