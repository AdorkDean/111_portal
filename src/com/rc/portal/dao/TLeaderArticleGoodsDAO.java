package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLeaderArticleGoods;
import com.rc.portal.vo.TLeaderArticleGoodsExample;

public interface TLeaderArticleGoodsDAO {
    int countByExample(TLeaderArticleGoodsExample example) throws SQLException;

    int deleteByExample(TLeaderArticleGoodsExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLeaderArticleGoods record) throws SQLException;

    Long insertSelective(TLeaderArticleGoods record) throws SQLException;

    List selectByExample(TLeaderArticleGoodsExample example) throws SQLException;

    TLeaderArticleGoods selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLeaderArticleGoods record, TLeaderArticleGoodsExample example) throws SQLException;

    int updateByExample(TLeaderArticleGoods record, TLeaderArticleGoodsExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLeaderArticleGoods record) throws SQLException;

    int updateByPrimaryKey(TLeaderArticleGoods record) throws SQLException;


}
