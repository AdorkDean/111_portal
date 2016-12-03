package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLeaderAccountNumber;
import com.rc.portal.vo.TLeaderAccountNumberExample;

public interface TLeaderAccountNumberDAO {
    int countByExample(TLeaderAccountNumberExample example) throws SQLException;

    int deleteByExample(TLeaderAccountNumberExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLeaderAccountNumber record) throws SQLException;

    Long insertSelective(TLeaderAccountNumber record) throws SQLException;

    List selectByExample(TLeaderAccountNumberExample example) throws SQLException;

    TLeaderAccountNumber selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLeaderAccountNumber record, TLeaderAccountNumberExample example) throws SQLException;

    int updateByExample(TLeaderAccountNumber record, TLeaderAccountNumberExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLeaderAccountNumber record) throws SQLException;

    int updateByPrimaryKey(TLeaderAccountNumber record) throws SQLException;


}
