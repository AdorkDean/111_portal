package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TGoodsExtend;
import com.rc.portal.vo.TGoodsExtendExample;
import com.rc.portal.vo.TGoodsExtendWithBLOBs;

public interface TGoodsExtendManager {
    int countByExample(TGoodsExtendExample example) throws SQLException;

    int deleteByExample(TGoodsExtendExample example) throws SQLException;

    Long insert(TGoodsExtendWithBLOBs record) throws SQLException;

    Long insertSelective(TGoodsExtendWithBLOBs record) throws SQLException;

    List selectByExampleWithBLOBs(TGoodsExtendExample example) throws SQLException;

    List selectByExampleWithoutBLOBs(TGoodsExtendExample example) throws SQLException;

    int updateByExampleSelective(TGoodsExtendWithBLOBs record, TGoodsExtendExample example) throws SQLException;

    int updateByExample(TGoodsExtendWithBLOBs record, TGoodsExtendExample example) throws SQLException;

    int updateByExample(TGoodsExtend record, TGoodsExtendExample example) throws SQLException;



}
