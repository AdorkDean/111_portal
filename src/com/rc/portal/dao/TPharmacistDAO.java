package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TPharmacist;
import com.rc.portal.vo.TPharmacistExample;

public interface TPharmacistDAO {
    int countByExample(TPharmacistExample example) throws SQLException;

    int deleteByExample(TPharmacistExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TPharmacist record) throws SQLException;

    Long insertSelective(TPharmacist record) throws SQLException;

    List selectByExample(TPharmacistExample example) throws SQLException;

    TPharmacist selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TPharmacist record, TPharmacistExample example) throws SQLException;

    int updateByExample(TPharmacist record, TPharmacistExample example) throws SQLException;

    int updateByPrimaryKeySelective(TPharmacist record) throws SQLException;

    int updateByPrimaryKey(TPharmacist record) throws SQLException;


}
