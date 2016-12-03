package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLongCard;
import com.rc.portal.vo.TLongCardExample;

public interface TLongCardDAO {
    int countByExample(TLongCardExample example) throws SQLException;

    int deleteByExample(TLongCardExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLongCard record) throws SQLException;

    Long insertSelective(TLongCard record) throws SQLException;

    List selectByExample(TLongCardExample example) throws SQLException;

    TLongCard selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLongCard record, TLongCardExample example) throws SQLException;

    int updateByExample(TLongCard record, TLongCardExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLongCard record) throws SQLException;

    int updateByPrimaryKey(TLongCard record) throws SQLException;


}
