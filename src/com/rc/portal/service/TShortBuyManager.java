package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.rc.portal.vo.TShortBuy;
import com.rc.portal.vo.TShortBuyExample;
import com.rc.portal.webapp.model.NotEnoughException;

public interface TShortBuyManager {
    int countByExample(TShortBuyExample example) throws SQLException;

    int deleteByExample(TShortBuyExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TShortBuy record) throws SQLException;

    Long insertSelective(TShortBuy record) throws SQLException;

    List selectByExample(TShortBuyExample example) throws SQLException;

    TShortBuy selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TShortBuy record, TShortBuyExample example) throws SQLException;

    int updateByExample(TShortBuy record, TShortBuyExample example) throws SQLException;

    int updateByPrimaryKeySelective(TShortBuy record) throws SQLException;

    int updateByPrimaryKey(TShortBuy record) throws SQLException;
    
    public long shortBug(Map param) throws SQLException,NotEnoughException;



}
