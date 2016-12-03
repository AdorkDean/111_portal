package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLxContent;
import com.rc.portal.vo.TLxContentExample;

public interface TLxContentManager {
    int countByExample(TLxContentExample example) throws SQLException;

    int deleteByExample(TLxContentExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLxContent record) throws SQLException;

    Long insertSelective(TLxContent record) throws SQLException;

    List selectByExample(TLxContentExample example) throws SQLException;

    TLxContent selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLxContent record, TLxContentExample example) throws SQLException;

    int updateByExample(TLxContent record, TLxContentExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLxContent record) throws SQLException;

    int updateByPrimaryKey(TLxContent record) throws SQLException;



}
