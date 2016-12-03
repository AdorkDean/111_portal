package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TMemberCertificates;
import com.rc.portal.vo.TMemberCertificatesExample;

public interface TMemberCertificatesManager {
    int countByExample(TMemberCertificatesExample example) throws SQLException;

    int deleteByExample(TMemberCertificatesExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TMemberCertificates record) throws SQLException;

    Long insertSelective(TMemberCertificates record) throws SQLException;

    List selectByExample(TMemberCertificatesExample example) throws SQLException;

    TMemberCertificates selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TMemberCertificates record, TMemberCertificatesExample example) throws SQLException;

    int updateByExample(TMemberCertificates record, TMemberCertificatesExample example) throws SQLException;

    int updateByPrimaryKeySelective(TMemberCertificates record) throws SQLException;

    int updateByPrimaryKey(TMemberCertificates record) throws SQLException;



}
