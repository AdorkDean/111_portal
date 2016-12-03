package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TFreight;
import com.rc.portal.vo.TFreightExample;

public interface TFreightManager {
    int countByExample(TFreightExample example) throws SQLException;

    int deleteByExample(TFreightExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TFreight record) throws SQLException;

    Long insertSelective(TFreight record) throws SQLException;

    List selectByExample(TFreightExample example) throws SQLException;

    TFreight selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TFreight record, TFreightExample example) throws SQLException;

    int updateByExample(TFreight record, TFreightExample example) throws SQLException;

    int updateByPrimaryKeySelective(TFreight record) throws SQLException;

    int updateByPrimaryKey(TFreight record) throws SQLException;



}
