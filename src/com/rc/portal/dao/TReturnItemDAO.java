package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TReturnItem;
import com.rc.portal.vo.TReturnItemExample;

public interface TReturnItemDAO {
    int countByExample(TReturnItemExample example) throws SQLException;

    int deleteByExample(TReturnItemExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TReturnItem record) throws SQLException;

    Long insertSelective(TReturnItem record) throws SQLException;

    List selectByExample(TReturnItemExample example) throws SQLException;

    TReturnItem selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TReturnItem record, TReturnItemExample example) throws SQLException;

    int updateByExample(TReturnItem record, TReturnItemExample example) throws SQLException;

    int updateByPrimaryKeySelective(TReturnItem record) throws SQLException;

    int updateByPrimaryKey(TReturnItem record) throws SQLException;


}
