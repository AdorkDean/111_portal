package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLxArticle;
import com.rc.portal.vo.TLxArticleExample;
import com.rc.portal.vo.TLxArticleWithBLOBs;

public interface TLxArticleDAO {
    int countByExample(TLxArticleExample example) throws SQLException;

    int deleteByExample(TLxArticleExample example) throws SQLException;

    int deleteByPrimaryKey(Integer id) throws SQLException;

    Long insert(TLxArticleWithBLOBs record) throws SQLException;

    Long insertSelective(TLxArticleWithBLOBs record) throws SQLException;

    List selectByExampleWithBLOBs(TLxArticleExample example) throws SQLException;

    List selectByExampleWithoutBLOBs(TLxArticleExample example) throws SQLException;

    TLxArticleWithBLOBs selectByPrimaryKey(Integer id) throws SQLException;

    int updateByExampleSelective(TLxArticleWithBLOBs record, TLxArticleExample example) throws SQLException;

    int updateByExample(TLxArticleWithBLOBs record, TLxArticleExample example) throws SQLException;

    int updateByExample(TLxArticle record, TLxArticleExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLxArticleWithBLOBs record) throws SQLException;

    int updateByPrimaryKey(TLxArticleWithBLOBs record) throws SQLException;

    int updateByPrimaryKey(TLxArticle record) throws SQLException;


}
