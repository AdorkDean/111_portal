package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.vo.TMemberBaseMessageExtExample;

public interface TMemberBaseMessageExtDAO {
    int countByExample(TMemberBaseMessageExtExample example) throws SQLException;

    int deleteByExample(TMemberBaseMessageExtExample example) throws SQLException;

    int deleteByPrimaryKey(Long memberId) throws SQLException;

    Long insert(TMemberBaseMessageExt record) throws SQLException;

    Long insertSelective(TMemberBaseMessageExt record) throws SQLException;

    List selectByExample(TMemberBaseMessageExtExample example) throws SQLException;

    TMemberBaseMessageExt selectByPrimaryKey(Long memberId) throws SQLException;

    int updateByExampleSelective(TMemberBaseMessageExt record, TMemberBaseMessageExtExample example) throws SQLException;

    int updateByExample(TMemberBaseMessageExt record, TMemberBaseMessageExtExample example) throws SQLException;

    int updateByPrimaryKeySelective(TMemberBaseMessageExt record) throws SQLException;

    int updateByPrimaryKey(TMemberBaseMessageExt record) throws SQLException;


}
