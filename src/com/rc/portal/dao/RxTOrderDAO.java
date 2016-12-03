package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.RxTOrder;
import com.rc.portal.vo.RxTOrderExample;

public interface RxTOrderDAO {
    int countByExample(RxTOrderExample example) throws SQLException;

    int deleteByExample(RxTOrderExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(RxTOrder record) throws SQLException;

    Long insertSelective(RxTOrder record) throws SQLException;

    List selectByExample(RxTOrderExample example) throws SQLException;

    RxTOrder selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(RxTOrder record, RxTOrderExample example) throws SQLException;

    int updateByExample(RxTOrder record, RxTOrderExample example) throws SQLException;

    int updateByPrimaryKeySelective(RxTOrder record) throws SQLException;

    int updateByPrimaryKey(RxTOrder record) throws SQLException;


}
