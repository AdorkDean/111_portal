package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLong;
import com.rc.portal.vo.TLongExample;

public interface TLongManager {
    int countByExample(TLongExample example) throws SQLException;

    int deleteByExample(TLongExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLong record) throws SQLException;

    Long insertSelective(TLong record) throws SQLException;

    List selectByExample(TLongExample example) throws SQLException;

    TLong selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLong record, TLongExample example) throws SQLException;

    int updateByExample(TLong record, TLongExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLong record) throws SQLException;

    int updateByPrimaryKey(TLong record) throws SQLException;



}
