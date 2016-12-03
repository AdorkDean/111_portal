package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.CLocation;
import com.rc.portal.vo.CLocationExample;

public interface CLocationManager {
    int countByExample(CLocationExample example) throws SQLException;

    int deleteByExample(CLocationExample example) throws SQLException;

    int deleteByPrimaryKey(Integer id) throws SQLException;

    Long insert(CLocation record) throws SQLException;

    Long insertSelective(CLocation record) throws SQLException;

    List selectByExample(CLocationExample example) throws SQLException;

    CLocation selectByPrimaryKey(Integer id) throws SQLException;

    int updateByExampleSelective(CLocation record, CLocationExample example) throws SQLException;

    int updateByExample(CLocation record, CLocationExample example) throws SQLException;

    int updateByPrimaryKeySelective(CLocation record) throws SQLException;

    int updateByPrimaryKey(CLocation record) throws SQLException;

    String selectAreaName(long id) throws SQLException;

	List<CLocation> selectAllChildrenByParendId(Integer id) throws SQLException;

	List<CLocation> selectAllArea(long id,List<CLocation> locationList)throws SQLException;
}
