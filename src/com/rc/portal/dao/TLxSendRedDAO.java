package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLxSendRed;
import com.rc.portal.vo.TLxSendRedExample;

public interface TLxSendRedDAO {
    int countByExample(TLxSendRedExample example) throws SQLException;

    int deleteByExample(TLxSendRedExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLxSendRed record) throws SQLException;

    Long insertSelective(TLxSendRed record) throws SQLException;

    List selectByExample(TLxSendRedExample example) throws SQLException;

    TLxSendRed selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLxSendRed record, TLxSendRedExample example) throws SQLException;

    int updateByExample(TLxSendRed record, TLxSendRedExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLxSendRed record) throws SQLException;

    int updateByPrimaryKey(TLxSendRed record) throws SQLException;


}
