package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLeaderPharmacy;
import com.rc.portal.vo.TLeaderPharmacyExample;

public interface TLeaderPharmacyDAO {
    int countByExample(TLeaderPharmacyExample example) throws SQLException;

    int deleteByExample(TLeaderPharmacyExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLeaderPharmacy record) throws SQLException;

    Long insertSelective(TLeaderPharmacy record) throws SQLException;

    List selectByExample(TLeaderPharmacyExample example) throws SQLException;

    TLeaderPharmacy selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLeaderPharmacy record, TLeaderPharmacyExample example) throws SQLException;

    int updateByExample(TLeaderPharmacy record, TLeaderPharmacyExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLeaderPharmacy record) throws SQLException;

    int updateByPrimaryKey(TLeaderPharmacy record) throws SQLException;


}
