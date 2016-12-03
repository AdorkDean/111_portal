package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TCouponRelevance;
import com.rc.portal.vo.TCouponRelevanceExample;

public interface TCouponRelevanceDAO {
    int countByExample(TCouponRelevanceExample example) throws SQLException;

    int deleteByExample(TCouponRelevanceExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TCouponRelevance record) throws SQLException;

    Long insertSelective(TCouponRelevance record) throws SQLException;

    List selectByExample(TCouponRelevanceExample example) throws SQLException;

    TCouponRelevance selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TCouponRelevance record, TCouponRelevanceExample example) throws SQLException;

    int updateByExample(TCouponRelevance record, TCouponRelevanceExample example) throws SQLException;

    int updateByPrimaryKeySelective(TCouponRelevance record) throws SQLException;

    int updateByPrimaryKey(TCouponRelevance record) throws SQLException;


}
