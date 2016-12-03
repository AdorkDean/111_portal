package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TOrderFlow;
import com.rc.portal.vo.TOrderFlowExample;

public interface TOrderFlowDAO {
    int countByExample(TOrderFlowExample example) throws SQLException;

    int deleteByExample(TOrderFlowExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TOrderFlow record) throws SQLException;

    Long insertSelective(TOrderFlow record) throws SQLException;

    List selectByExample(TOrderFlowExample example) throws SQLException;

    TOrderFlow selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TOrderFlow record, TOrderFlowExample example) throws SQLException;

    int updateByExample(TOrderFlow record, TOrderFlowExample example) throws SQLException;

    int updateByPrimaryKeySelective(TOrderFlow record) throws SQLException;

    int updateByPrimaryKey(TOrderFlow record) throws SQLException;


}
