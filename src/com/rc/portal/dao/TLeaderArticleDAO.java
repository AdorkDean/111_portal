package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLeaderArticle;
import com.rc.portal.vo.TLeaderArticleExample;

public interface TLeaderArticleDAO {
    int countByExample(TLeaderArticleExample example) throws SQLException;

    int deleteByExample(TLeaderArticleExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLeaderArticle record) throws SQLException;

    Long insertSelective(TLeaderArticle record) throws SQLException;

    List selectByExampleWithBLOBs(TLeaderArticleExample example) throws SQLException;

    List selectByExampleWithoutBLOBs(TLeaderArticleExample example) throws SQLException;

    TLeaderArticle selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLeaderArticle record, TLeaderArticleExample example) throws SQLException;

    int updateByExampleWithBLOBs(TLeaderArticle record, TLeaderArticleExample example) throws SQLException;

    int updateByExampleWithoutBLOBs(TLeaderArticle record, TLeaderArticleExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLeaderArticle record) throws SQLException;

    int updateByPrimaryKeyWithBLOBs(TLeaderArticle record) throws SQLException;

    int updateByPrimaryKeyWithoutBLOBs(TLeaderArticle record) throws SQLException;


}
