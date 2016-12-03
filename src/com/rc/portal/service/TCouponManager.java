package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TCouponExample;
import com.rc.portal.vo.TMember;

public interface TCouponManager {
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

    /**
     * 生成优惠券
     * @param record
     * @param member(选填)
     * @param count(选填)
     */
    void createCouponCard(TCoupon record ,TMember member,Integer count) throws SQLException;

}
