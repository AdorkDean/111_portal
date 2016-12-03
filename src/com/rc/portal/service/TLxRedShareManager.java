package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLxRedShare;
import com.rc.portal.vo.TLxRedShareExample;

public interface TLxRedShareManager {
    int countByExample(TLxRedShareExample example) throws SQLException;

    int deleteByExample(TLxRedShareExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLxRedShare record) throws SQLException;

    Long insertSelective(TLxRedShare record) throws SQLException;

    List selectByExample(TLxRedShareExample example) throws SQLException;

    TLxRedShare selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLxRedShare record, TLxRedShareExample example) throws SQLException;

    int updateByExample(TLxRedShare record, TLxRedShareExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLxRedShare record) throws SQLException;

    int updateByPrimaryKey(TLxRedShare record) throws SQLException;



}
