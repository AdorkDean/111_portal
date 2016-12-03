package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLxGoodsArticleBrokerage;
import com.rc.portal.vo.TLxGoodsArticleBrokerageExample;

public interface TLxGoodsArticleBrokerageManager {
    int countByExample(TLxGoodsArticleBrokerageExample example) throws SQLException;

    int deleteByExample(TLxGoodsArticleBrokerageExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLxGoodsArticleBrokerage record) throws SQLException;

    Long insertSelective(TLxGoodsArticleBrokerage record) throws SQLException;

    List selectByExample(TLxGoodsArticleBrokerageExample example) throws SQLException;

    TLxGoodsArticleBrokerage selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLxGoodsArticleBrokerage record, TLxGoodsArticleBrokerageExample example) throws SQLException;

    int updateByExample(TLxGoodsArticleBrokerage record, TLxGoodsArticleBrokerageExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLxGoodsArticleBrokerage record) throws SQLException;

    int updateByPrimaryKey(TLxGoodsArticleBrokerage record) throws SQLException;



}
