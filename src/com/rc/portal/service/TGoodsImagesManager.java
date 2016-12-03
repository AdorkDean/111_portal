package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TGoodsImages;
import com.rc.portal.vo.TGoodsImagesExample;

public interface TGoodsImagesManager {
    int countByExample(TGoodsImagesExample example) throws SQLException;

    int deleteByExample(TGoodsImagesExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TGoodsImages record) throws SQLException;

    Long insertSelective(TGoodsImages record) throws SQLException;

    List selectByExample(TGoodsImagesExample example) throws SQLException;

    TGoodsImages selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TGoodsImages record, TGoodsImagesExample example) throws SQLException;

    int updateByExample(TGoodsImages record, TGoodsImagesExample example) throws SQLException;

    int updateByPrimaryKeySelective(TGoodsImages record) throws SQLException;

    int updateByPrimaryKey(TGoodsImages record) throws SQLException;



}
