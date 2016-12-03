package com.rc.portal.dao;


import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TGoodFreight;
import com.rc.portal.vo.TGoodFreightExample;

public interface TGoodFreightDAO {
    int countByExample(TGoodFreightExample example) throws SQLException;

    int deleteByExample(TGoodFreightExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TGoodFreight record) throws SQLException;

    Long insertSelective(TGoodFreight record) throws SQLException;

    List selectByExample(TGoodFreightExample example) throws SQLException;

    TGoodFreight selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TGoodFreight record, TGoodFreightExample example) throws SQLException;

    int updateByExample(TGoodFreight record, TGoodFreightExample example) throws SQLException;

    int updateByPrimaryKeySelective(TGoodFreight record) throws SQLException;

    int updateByPrimaryKey(TGoodFreight record) throws SQLException;


}
