package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLeaderGoodsRecommend;
import com.rc.portal.vo.TLeaderGoodsRecommendExample;

public interface TLeaderGoodsRecommendDAO {
    int countByExample(TLeaderGoodsRecommendExample example) throws SQLException;

    int deleteByExample(TLeaderGoodsRecommendExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLeaderGoodsRecommend record) throws SQLException;

    Long insertSelective(TLeaderGoodsRecommend record) throws SQLException;

    List selectByExample(TLeaderGoodsRecommendExample example) throws SQLException;

    TLeaderGoodsRecommend selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLeaderGoodsRecommend record, TLeaderGoodsRecommendExample example) throws SQLException;

    int updateByExample(TLeaderGoodsRecommend record, TLeaderGoodsRecommendExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLeaderGoodsRecommend record) throws SQLException;

    int updateByPrimaryKey(TLeaderGoodsRecommend record) throws SQLException;


}
