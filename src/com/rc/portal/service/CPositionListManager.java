package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.CPositionList;
import com.rc.portal.vo.CPositionListExample;

public interface CPositionListManager {
    int countByExample(CPositionListExample example) throws SQLException;

    int deleteByExample(CPositionListExample example) throws SQLException;

    int deleteByPrimaryKey(Integer id) throws SQLException;

    Long insert(CPositionList record) throws SQLException;

    Long insertSelective(CPositionList record) throws SQLException;

    List selectByExample(CPositionListExample example) throws SQLException;

    CPositionList selectByPrimaryKey(Integer id) throws SQLException;

    int updateByExampleSelective(CPositionList record, CPositionListExample example) throws SQLException;

    int updateByExample(CPositionList record, CPositionListExample example) throws SQLException;

    int updateByPrimaryKeySelective(CPositionList record) throws SQLException;

    int updateByPrimaryKey(CPositionList record) throws SQLException;



}
