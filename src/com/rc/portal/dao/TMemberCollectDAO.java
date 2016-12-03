package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TMemberCollect;
import com.rc.portal.vo.TMemberCollectExample;

public interface TMemberCollectDAO {
    int countByExample(TMemberCollectExample example) throws SQLException;

    int deleteByExample(TMemberCollectExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TMemberCollect record) throws SQLException;

    Long insertSelective(TMemberCollect record) throws SQLException;

    List selectByExample(TMemberCollectExample example) throws SQLException;

    TMemberCollect selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TMemberCollect record, TMemberCollectExample example) throws SQLException;

    int updateByExample(TMemberCollect record, TMemberCollectExample example) throws SQLException;

    int updateByPrimaryKeySelective(TMemberCollect record) throws SQLException;

    int updateByPrimaryKey(TMemberCollect record) throws SQLException;


}
