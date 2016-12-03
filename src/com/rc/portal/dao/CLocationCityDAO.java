package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.CLocationCity;
import com.rc.portal.vo.CLocationCityExample;

public interface CLocationCityDAO {
    int countByExample(CLocationCityExample example) throws SQLException;

    int deleteByExample(CLocationCityExample example) throws SQLException;

    int deleteByPrimaryKey(Integer id) throws SQLException;

    Long insert(CLocationCity record) throws SQLException;

    Long insertSelective(CLocationCity record) throws SQLException;

    List selectByExample(CLocationCityExample example) throws SQLException;

    CLocationCity selectByPrimaryKey(Integer id) throws SQLException;

    int updateByExampleSelective(CLocationCity record, CLocationCityExample example) throws SQLException;

    int updateByExample(CLocationCity record, CLocationCityExample example) throws SQLException;

    int updateByPrimaryKeySelective(CLocationCity record) throws SQLException;

    int updateByPrimaryKey(CLocationCity record) throws SQLException;


}
