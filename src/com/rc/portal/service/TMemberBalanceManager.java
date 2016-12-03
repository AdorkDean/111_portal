package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TMemberBalance;
import com.rc.portal.vo.TMemberBalanceExample;

public interface TMemberBalanceManager {
    int countByExample(TMemberBalanceExample example) throws SQLException;

    int deleteByExample(TMemberBalanceExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TMemberBalance record) throws SQLException;

    Long insertSelective(TMemberBalance record) throws SQLException;

    List selectByExample(TMemberBalanceExample example) throws SQLException;

    TMemberBalance selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TMemberBalance record, TMemberBalanceExample example) throws SQLException;

    int updateByExample(TMemberBalance record, TMemberBalanceExample example) throws SQLException;

    int updateByPrimaryKeySelective(TMemberBalance record) throws SQLException;

    int updateByPrimaryKey(TMemberBalance record) throws SQLException;



}
