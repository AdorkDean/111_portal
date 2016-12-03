package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TPromotion;
import com.rc.portal.vo.TPromotionExample;

public interface TPromotionDAO {
    int countByExample(TPromotionExample example) throws SQLException;

    int deleteByExample(TPromotionExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TPromotion record) throws SQLException;

    Long insertSelective(TPromotion record) throws SQLException;

    List selectByExample(TPromotionExample example) throws SQLException;

    TPromotion selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TPromotion record, TPromotionExample example) throws SQLException;

    int updateByExample(TPromotion record, TPromotionExample example) throws SQLException;

    int updateByPrimaryKeySelective(TPromotion record) throws SQLException;

    int updateByPrimaryKey(TPromotion record) throws SQLException;


}
