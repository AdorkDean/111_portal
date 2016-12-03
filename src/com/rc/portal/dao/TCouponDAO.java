package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TCouponExample;

public interface TCouponDAO {
    int countByExample(TCouponExample example) throws SQLException;

    int deleteByExample(TCouponExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TCoupon record) throws SQLException;

    Long insertSelective(TCoupon record) throws SQLException;

    List selectByExample(TCouponExample example) throws SQLException;

    TCoupon selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TCoupon record, TCouponExample example) throws SQLException;

    int updateByExample(TCoupon record, TCouponExample example) throws SQLException;

    int updateByPrimaryKeySelective(TCoupon record) throws SQLException;

    int updateByPrimaryKey(TCoupon record) throws SQLException;


}
