package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLeaderQrCode;
import com.rc.portal.vo.TLeaderQrCodeExample;

public interface TLeaderQrCodeManager {
    int countByExample(TLeaderQrCodeExample example) throws SQLException;

    int deleteByExample(TLeaderQrCodeExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLeaderQrCode record) throws SQLException;

    Long insertSelective(TLeaderQrCode record) throws SQLException;

    List selectByExample(TLeaderQrCodeExample example) throws SQLException;

    TLeaderQrCode selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLeaderQrCode record, TLeaderQrCodeExample example) throws SQLException;

    int updateByExample(TLeaderQrCode record, TLeaderQrCodeExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLeaderQrCode record) throws SQLException;

    int updateByPrimaryKey(TLeaderQrCode record) throws SQLException;



}
