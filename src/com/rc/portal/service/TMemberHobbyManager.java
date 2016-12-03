package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TMemberHobby;
import com.rc.portal.vo.TMemberHobbyExample;

public interface TMemberHobbyManager {
    int countByExample(TMemberHobbyExample example) throws SQLException;

    int deleteByExample(TMemberHobbyExample example) throws SQLException;

    int deleteByPrimaryKey(Long memberId) throws SQLException;

    Long insert(TMemberHobby record) throws SQLException;

    Long insertSelective(TMemberHobby record) throws SQLException;

    List selectByExample(TMemberHobbyExample example) throws SQLException;

    TMemberHobby selectByPrimaryKey(Long memberId) throws SQLException;

    int updateByExampleSelective(TMemberHobby record, TMemberHobbyExample example) throws SQLException;

    int updateByExample(TMemberHobby record, TMemberHobbyExample example) throws SQLException;

    int updateByPrimaryKeySelective(TMemberHobby record) throws SQLException;

    int updateByPrimaryKey(TMemberHobby record) throws SQLException;



}
