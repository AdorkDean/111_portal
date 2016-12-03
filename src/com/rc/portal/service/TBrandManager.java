package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TBrand;
import com.rc.portal.vo.TBrandExample;

public interface TBrandManager {
    int countByExample(TBrandExample example) throws SQLException;

    int deleteByExample(TBrandExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TBrand record) throws SQLException;

    Long insertSelective(TBrand record) throws SQLException;

    List selectByExample(TBrandExample example) throws SQLException;

    TBrand selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TBrand record, TBrandExample example) throws SQLException;

    int updateByExample(TBrand record, TBrandExample example) throws SQLException;

    int updateByPrimaryKeySelective(TBrand record) throws SQLException;

    int updateByPrimaryKey(TBrand record) throws SQLException;



}
