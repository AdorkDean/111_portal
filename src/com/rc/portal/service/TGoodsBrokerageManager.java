package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TGoodsBrokerage;
import com.rc.portal.vo.TGoodsBrokerageExample;

public interface TGoodsBrokerageManager {
    int countByExample(TGoodsBrokerageExample example) throws SQLException;

    int deleteByExample(TGoodsBrokerageExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TGoodsBrokerage record) throws SQLException;

    Long insertSelective(TGoodsBrokerage record) throws SQLException;

    List selectByExample(TGoodsBrokerageExample example) throws SQLException;

    TGoodsBrokerage selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TGoodsBrokerage record, TGoodsBrokerageExample example) throws SQLException;

    int updateByExample(TGoodsBrokerage record, TGoodsBrokerageExample example) throws SQLException;

    int updateByPrimaryKeySelective(TGoodsBrokerage record) throws SQLException;

    int updateByPrimaryKey(TGoodsBrokerage record) throws SQLException;



}
