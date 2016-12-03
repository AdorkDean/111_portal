package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberExample;

public interface TMemberDAO {
    int countByExample(TMemberExample example) throws SQLException;

    int deleteByExample(TMemberExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TMember record) throws SQLException;

    Long insertSelective(TMember record) throws SQLException;

    List selectByExample(TMemberExample example) throws SQLException;

    TMember selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TMember record, TMemberExample example) throws SQLException;

    int updateByExample(TMember record, TMemberExample example) throws SQLException;

    int updateByPrimaryKeySelective(TMember record) throws SQLException;

    int updateByPrimaryKey(TMember record) throws SQLException;


}
