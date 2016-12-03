package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TGoodsBrokerage;
import com.rc.portal.vo.TGoodsBrokerageExample;

public interface TGoodsBrokerageDAO {
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

    //查询最高返佣的
    List select(int pageSize) throws SQLException;
}
