package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.YktGoods;
import com.rc.portal.vo.YktGoodsExample;

public interface YktGoodsDAO {
    int countByExample(YktGoodsExample example) throws SQLException;

    int deleteByExample(YktGoodsExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(YktGoods record) throws SQLException;

    Long insertSelective(YktGoods record) throws SQLException;

    List selectByExample(YktGoodsExample example) throws SQLException;

    YktGoods selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(YktGoods record, YktGoodsExample example) throws SQLException;

    int updateByExample(YktGoods record, YktGoodsExample example) throws SQLException;

    int updateByPrimaryKeySelective(YktGoods record) throws SQLException;

    int updateByPrimaryKey(YktGoods record) throws SQLException;


}
