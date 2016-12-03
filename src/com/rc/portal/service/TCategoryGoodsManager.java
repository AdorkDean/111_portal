package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TCategoryGoods;
import com.rc.portal.vo.TCategoryGoodsExample;

public interface TCategoryGoodsManager {
    int countByExample(TCategoryGoodsExample example) throws SQLException;

    int deleteByExample(TCategoryGoodsExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TCategoryGoods record) throws SQLException;

    Long insertSelective(TCategoryGoods record) throws SQLException;

    List selectByExample(TCategoryGoodsExample example) throws SQLException;

    TCategoryGoods selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TCategoryGoods record, TCategoryGoodsExample example) throws SQLException;

    int updateByExample(TCategoryGoods record, TCategoryGoodsExample example) throws SQLException;

    int updateByPrimaryKeySelective(TCategoryGoods record) throws SQLException;

    int updateByPrimaryKey(TCategoryGoods record) throws SQLException;



}
