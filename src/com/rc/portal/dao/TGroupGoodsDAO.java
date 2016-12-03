package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TGroupGoods;
import com.rc.portal.vo.TGroupGoodsExample;

public interface TGroupGoodsDAO {
    int countByExample(TGroupGoodsExample example) throws SQLException;

    int deleteByExample(TGroupGoodsExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TGroupGoods record) throws SQLException;

    Long insertSelective(TGroupGoods record) throws SQLException;

    List selectByExample(TGroupGoodsExample example) throws SQLException;

    TGroupGoods selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TGroupGoods record, TGroupGoodsExample example) throws SQLException;

    int updateByExample(TGroupGoods record, TGroupGoodsExample example) throws SQLException;

    int updateByPrimaryKeySelective(TGroupGoods record) throws SQLException;

    int updateByPrimaryKey(TGroupGoods record) throws SQLException;


}
