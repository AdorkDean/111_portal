package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TShortGoods;
import com.rc.portal.vo.TShortGoodsExample;

public interface TShortGoodsManager {
    int countByExample(TShortGoodsExample example) throws SQLException;

    int deleteByExample(TShortGoodsExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TShortGoods record) throws SQLException;

    Long insertSelective(TShortGoods record) throws SQLException;

    List selectByExample(TShortGoodsExample example) throws SQLException;

    TShortGoods selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TShortGoods record, TShortGoodsExample example) throws SQLException;

    int updateByExample(TShortGoods record, TShortGoodsExample example) throws SQLException;

    int updateByPrimaryKeySelective(TShortGoods record) throws SQLException;

    int updateByPrimaryKey(TShortGoods record) throws SQLException;



}
