package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TManufacturer;
import com.rc.portal.vo.TManufacturerExample;

public interface TManufacturerDAO {
    int countByExample(TManufacturerExample example) throws SQLException;

    int deleteByExample(TManufacturerExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TManufacturer record) throws SQLException;

    Long insertSelective(TManufacturer record) throws SQLException;

    List selectByExample(TManufacturerExample example) throws SQLException;

    TManufacturer selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TManufacturer record, TManufacturerExample example) throws SQLException;

    int updateByExample(TManufacturer record, TManufacturerExample example) throws SQLException;

    int updateByPrimaryKeySelective(TManufacturer record) throws SQLException;

    int updateByPrimaryKey(TManufacturer record) throws SQLException;


}
