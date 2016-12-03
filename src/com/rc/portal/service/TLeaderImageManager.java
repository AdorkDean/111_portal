package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLeaderImage;
import com.rc.portal.vo.TLeaderImageExample;

public interface TLeaderImageManager {
    int countByExample(TLeaderImageExample example) throws SQLException;

    int deleteByExample(TLeaderImageExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLeaderImage record) throws SQLException;

    Long insertSelective(TLeaderImage record) throws SQLException;

    List selectByExample(TLeaderImageExample example) throws SQLException;

    TLeaderImage selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLeaderImage record, TLeaderImageExample example) throws SQLException;

    int updateByExample(TLeaderImage record, TLeaderImageExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLeaderImage record) throws SQLException;

    int updateByPrimaryKey(TLeaderImage record) throws SQLException;



}
