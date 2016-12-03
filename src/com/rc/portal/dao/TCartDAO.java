package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TCart;
import com.rc.portal.vo.TCartExample;

public interface TCartDAO {
    int countByExample(TCartExample example) throws SQLException;

    int deleteByExample(TCartExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TCart record) throws SQLException;

    Long insertSelective(TCart record) throws SQLException;

    List selectByExample(TCartExample example) throws SQLException;

    TCart selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TCart record, TCartExample example) throws SQLException;

    int updateByExample(TCart record, TCartExample example) throws SQLException;

    int updateByPrimaryKeySelective(TCart record) throws SQLException;

    int updateByPrimaryKey(TCart record) throws SQLException;


}
