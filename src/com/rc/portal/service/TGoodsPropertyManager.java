package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TGoodsProperty;
import com.rc.portal.vo.TGoodsPropertyExample;

public interface TGoodsPropertyManager {
    int countByExample(TGoodsPropertyExample example) throws SQLException;

    int deleteByExample(TGoodsPropertyExample example) throws SQLException;

    Long insert(TGoodsProperty record) throws SQLException;

    Long insertSelective(TGoodsProperty record) throws SQLException;

    List selectByExample(TGoodsPropertyExample example) throws SQLException;

    int updateByExampleSelective(TGoodsProperty record, TGoodsPropertyExample example) throws SQLException;

    int updateByExample(TGoodsProperty record, TGoodsPropertyExample example) throws SQLException;



}
