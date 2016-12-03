package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLeaderAgent;
import com.rc.portal.vo.TLeaderAgentExample;

public interface TLeaderAgentManager {
    int countByExample(TLeaderAgentExample example) throws SQLException;

    int deleteByExample(TLeaderAgentExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLeaderAgent record) throws SQLException;

    Long insertSelective(TLeaderAgent record) throws SQLException;

    List selectByExample(TLeaderAgentExample example) throws SQLException;

    TLeaderAgent selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLeaderAgent record, TLeaderAgentExample example) throws SQLException;

    int updateByExample(TLeaderAgent record, TLeaderAgentExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLeaderAgent record) throws SQLException;

    int updateByPrimaryKey(TLeaderAgent record) throws SQLException;



}
