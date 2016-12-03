package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.RxTOrderGood;
import com.rc.portal.vo.RxTOrderGoodExample;

public interface RxTOrderGoodDAO {
    int countByExample(RxTOrderGoodExample example) throws SQLException;

    int deleteByExample(RxTOrderGoodExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(RxTOrderGood record) throws SQLException;

    Long insertSelective(RxTOrderGood record) throws SQLException;

    List selectByExample(RxTOrderGoodExample example) throws SQLException;

    RxTOrderGood selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(RxTOrderGood record, RxTOrderGoodExample example) throws SQLException;

    int updateByExample(RxTOrderGood record, RxTOrderGoodExample example) throws SQLException;

    int updateByPrimaryKeySelective(RxTOrderGood record) throws SQLException;

    int updateByPrimaryKey(RxTOrderGood record) throws SQLException;


}
