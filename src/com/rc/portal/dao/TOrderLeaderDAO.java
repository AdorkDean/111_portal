package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TOrderLeader;
import com.rc.portal.vo.TOrderLeaderExample;

public interface TOrderLeaderDAO {
    int countByExample(TOrderLeaderExample example) throws SQLException;

    int deleteByExample(TOrderLeaderExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TOrderLeader record) throws SQLException;

    Long insertSelective(TOrderLeader record) throws SQLException;

    List selectByExample(TOrderLeaderExample example) throws SQLException;

    TOrderLeader selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TOrderLeader record, TOrderLeaderExample example) throws SQLException;

    int updateByExample(TOrderLeader record, TOrderLeaderExample example) throws SQLException;

    int updateByPrimaryKeySelective(TOrderLeader record) throws SQLException;

    int updateByPrimaryKey(TOrderLeader record) throws SQLException;


}
