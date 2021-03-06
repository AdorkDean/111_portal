package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TReturnImage;
import com.rc.portal.vo.TReturnImageExample;

public interface TReturnImageManager {
    int countByExample(TReturnImageExample example) throws SQLException;

    int deleteByExample(TReturnImageExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TReturnImage record) throws SQLException;

    Long insertSelective(TReturnImage record) throws SQLException;

    List selectByExample(TReturnImageExample example) throws SQLException;

    TReturnImage selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TReturnImage record, TReturnImageExample example) throws SQLException;

    int updateByExample(TReturnImage record, TReturnImageExample example) throws SQLException;

    int updateByPrimaryKeySelective(TReturnImage record) throws SQLException;

    int updateByPrimaryKey(TReturnImage record) throws SQLException;



}
