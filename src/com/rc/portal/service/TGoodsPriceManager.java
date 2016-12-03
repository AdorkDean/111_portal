package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TGoodsPrice;
import com.rc.portal.vo.TGoodsPriceExample;

public interface TGoodsPriceManager {
    int countByExample(TGoodsPriceExample example) throws SQLException;

    int deleteByExample(TGoodsPriceExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TGoodsPrice record) throws SQLException;

    Long insertSelective(TGoodsPrice record) throws SQLException;

    List selectByExample(TGoodsPriceExample example) throws SQLException;

    TGoodsPrice selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TGoodsPrice record, TGoodsPriceExample example) throws SQLException;

    int updateByExample(TGoodsPrice record, TGoodsPriceExample example) throws SQLException;

    int updateByPrimaryKeySelective(TGoodsPrice record) throws SQLException;

    int updateByPrimaryKey(TGoodsPrice record) throws SQLException;



}
