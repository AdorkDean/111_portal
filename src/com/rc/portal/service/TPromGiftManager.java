package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TPromGift;
import com.rc.portal.vo.TPromGiftExample;

public interface TPromGiftManager {
    int countByExample(TPromGiftExample example) throws SQLException;

    int deleteByExample(TPromGiftExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TPromGift record) throws SQLException;

    Long insertSelective(TPromGift record) throws SQLException;

    List selectByExample(TPromGiftExample example) throws SQLException;

    TPromGift selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TPromGift record, TPromGiftExample example) throws SQLException;

    int updateByExample(TPromGift record, TPromGiftExample example) throws SQLException;

    int updateByPrimaryKeySelective(TPromGift record) throws SQLException;

    int updateByPrimaryKey(TPromGift record) throws SQLException;



}
