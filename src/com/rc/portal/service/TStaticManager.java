package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TStatic;
import com.rc.portal.vo.TStaticExample;

public interface TStaticManager {
    int countByExample(TStaticExample example) throws SQLException;

    int deleteByExample(TStaticExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TStatic record) throws SQLException;

    Long insertSelective(TStatic record) throws SQLException;

    List selectByExample(TStaticExample example) throws SQLException;

    TStatic selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TStatic record, TStaticExample example) throws SQLException;

    int updateByExample(TStatic record, TStaticExample example) throws SQLException;

    int updateByPrimaryKeySelective(TStatic record) throws SQLException;

    int updateByPrimaryKey(TStatic record) throws SQLException;



}
