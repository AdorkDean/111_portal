package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TDose;
import com.rc.portal.vo.TDoseExample;

public interface TDoseDAO {
    int countByExample(TDoseExample example) throws SQLException;

    int deleteByExample(TDoseExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TDose record) throws SQLException;

    Long insertSelective(TDose record) throws SQLException;

    List selectByExample(TDoseExample example) throws SQLException;

    TDose selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TDose record, TDoseExample example) throws SQLException;

    int updateByExample(TDose record, TDoseExample example) throws SQLException;

    int updateByPrimaryKeySelective(TDose record) throws SQLException;

    int updateByPrimaryKey(TDose record) throws SQLException;


}
