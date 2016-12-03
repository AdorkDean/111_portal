package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLxShareCollection;
import com.rc.portal.vo.TLxShareCollectionExample;

public interface TLxShareCollectionDAO {
    int countByExample(TLxShareCollectionExample example) throws SQLException;

    int deleteByExample(TLxShareCollectionExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLxShareCollection record) throws SQLException;

    Long insertSelective(TLxShareCollection record) throws SQLException;

    List selectByExample(TLxShareCollectionExample example) throws SQLException;

    TLxShareCollection selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLxShareCollection record, TLxShareCollectionExample example) throws SQLException;

    int updateByExample(TLxShareCollection record, TLxShareCollectionExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLxShareCollection record) throws SQLException;

    int updateByPrimaryKey(TLxShareCollection record) throws SQLException;


}
