package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLeaderStayMoney;
import com.rc.portal.vo.TLeaderStayMoneyExample;

public interface TLeaderStayMoneyDAO {
    int countByExample(TLeaderStayMoneyExample example) throws SQLException;

    int deleteByExample(TLeaderStayMoneyExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLeaderStayMoney record) throws SQLException;

    Long insertSelective(TLeaderStayMoney record) throws SQLException;

    List selectByExample(TLeaderStayMoneyExample example) throws SQLException;

    TLeaderStayMoney selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLeaderStayMoney record, TLeaderStayMoneyExample example) throws SQLException;

    int updateByExample(TLeaderStayMoney record, TLeaderStayMoneyExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLeaderStayMoney record) throws SQLException;

    int updateByPrimaryKey(TLeaderStayMoney record) throws SQLException;


}
