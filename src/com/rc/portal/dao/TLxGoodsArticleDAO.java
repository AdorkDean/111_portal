package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLxGoodsArticle;
import com.rc.portal.vo.TLxGoodsArticleExample;

public interface TLxGoodsArticleDAO {
    int countByExample(TLxGoodsArticleExample example) throws SQLException;

    int deleteByExample(TLxGoodsArticleExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLxGoodsArticle record) throws SQLException;

    Long insertSelective(TLxGoodsArticle record) throws SQLException;

    List selectByExampleWithBLOBs(TLxGoodsArticleExample example) throws SQLException;

    List selectByExampleWithoutBLOBs(TLxGoodsArticleExample example) throws SQLException;

    TLxGoodsArticle selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLxGoodsArticle record, TLxGoodsArticleExample example) throws SQLException;

    int updateByExampleWithBLOBs(TLxGoodsArticle record, TLxGoodsArticleExample example) throws SQLException;

    int updateByExampleWithoutBLOBs(TLxGoodsArticle record, TLxGoodsArticleExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLxGoodsArticle record) throws SQLException;

    int updateByPrimaryKeyWithBLOBs(TLxGoodsArticle record) throws SQLException;

    int updateByPrimaryKeyWithoutBLOBs(TLxGoodsArticle record) throws SQLException;


}
