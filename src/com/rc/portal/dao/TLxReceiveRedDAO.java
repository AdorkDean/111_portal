package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLxReceiveRed;
import com.rc.portal.vo.TLxReceiveRedExample;

public interface TLxReceiveRedDAO {
    int countByExample(TLxReceiveRedExample example) throws SQLException;

    int deleteByExample(TLxReceiveRedExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLxReceiveRed record) throws SQLException;

    Long insertSelective(TLxReceiveRed record) throws SQLException;

    List selectByExample(TLxReceiveRedExample example) throws SQLException;

    TLxReceiveRed selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLxReceiveRed record, TLxReceiveRedExample example) throws SQLException;

    int updateByExample(TLxReceiveRed record, TLxReceiveRedExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLxReceiveRed record) throws SQLException;

    int updateByPrimaryKey(TLxReceiveRed record) throws SQLException;


}
