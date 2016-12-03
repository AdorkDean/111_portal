package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.CPosition;
import com.rc.portal.vo.CPositionExample;

public interface CPositionManager {
    int countByExample(CPositionExample example) throws SQLException;

    int deleteByExample(CPositionExample example) throws SQLException;

    int deleteByPrimaryKey(Integer id) throws SQLException;

    Long insert(CPosition record) throws SQLException;

    Long insertSelective(CPosition record) throws SQLException;

    List selectByExample(CPositionExample example) throws SQLException;

    CPosition selectByPrimaryKey(Integer id) throws SQLException;

    int updateByExampleSelective(CPosition record, CPositionExample example) throws SQLException;

    int updateByExample(CPosition record, CPositionExample example) throws SQLException;

    int updateByPrimaryKeySelective(CPosition record) throws SQLException;

    int updateByPrimaryKey(CPosition record) throws SQLException;



}
