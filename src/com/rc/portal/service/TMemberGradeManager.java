package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TMemberGrade;
import com.rc.portal.vo.TMemberGradeExample;

public interface TMemberGradeManager {
    int countByExample(TMemberGradeExample example) throws SQLException;

    int deleteByExample(TMemberGradeExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TMemberGrade record) throws SQLException;

    Long insertSelective(TMemberGrade record) throws SQLException;

    List selectByExample(TMemberGradeExample example) throws SQLException;

    TMemberGrade selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TMemberGrade record, TMemberGradeExample example) throws SQLException;

    int updateByExample(TMemberGrade record, TMemberGradeExample example) throws SQLException;

    int updateByPrimaryKeySelective(TMemberGrade record) throws SQLException;

    int updateByPrimaryKey(TMemberGrade record) throws SQLException;



}
