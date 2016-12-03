package com.rc.portal.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.rc.portal.vo.TReturn;
import com.rc.portal.vo.TReturnExample;

public interface TReturnManager {
	int countByExample(TReturnExample example) throws SQLException;

	int deleteByExample(TReturnExample example) throws SQLException;

	int deleteByPrimaryKey(Long id) throws SQLException;

	Long insert(TReturn record) throws SQLException;

	Long insertSelective(TReturn record) throws SQLException;

	List selectByExample(TReturnExample example) throws SQLException;

	TReturn selectByPrimaryKey(Long id) throws SQLException;

	int updateByExampleSelective(TReturn record, TReturnExample example) throws SQLException;

	int updateByExample(TReturn record, TReturnExample example) throws SQLException;

	int updateByPrimaryKeySelective(TReturn record) throws SQLException;

	int updateByPrimaryKey(TReturn record) throws SQLException;

	/**
	 * 存储过程取退换货订单编号
	 * 
	 * @param paramMap
	 * @return
	 * @throws SQLException 
	 */
	String getTurnOrderSn(Map<String, Object> paramMap) throws SQLException;

}
