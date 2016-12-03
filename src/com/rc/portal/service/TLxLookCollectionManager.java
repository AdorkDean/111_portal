package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLxLookCollection;
import com.rc.portal.vo.TLxLookCollectionExample;

public interface TLxLookCollectionManager {
    int countByExample(TLxLookCollectionExample example) throws SQLException;

    int deleteByExample(TLxLookCollectionExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLxLookCollection record) throws SQLException;

    Long insertSelective(TLxLookCollection record) throws SQLException;

    List selectByExample(TLxLookCollectionExample example) throws SQLException;

    TLxLookCollection selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLxLookCollection record, TLxLookCollectionExample example) throws SQLException;

    int updateByExample(TLxLookCollection record, TLxLookCollectionExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLxLookCollection record) throws SQLException;

    int updateByPrimaryKey(TLxLookCollection record) throws SQLException;



}
