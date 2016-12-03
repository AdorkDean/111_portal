package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.rc.portal.dao.TReturnDAO;
import com.rc.portal.service.TReturnManager;
import com.rc.portal.vo.TReturn;
import com.rc.portal.vo.TReturnExample;

public class TReturnManagerImpl implements TReturnManager {

	private TReturnDAO treturndao;

	public TReturnManagerImpl() {
		super();
	}

	public void setTreturndao(TReturnDAO treturndao) {
		this.treturndao = treturndao;
	}

	public TReturnDAO getTreturndao() {
		return this.treturndao;
	}

	public int countByExample(TReturnExample example) throws SQLException {
		return treturndao.countByExample(example);
	}

	public int deleteByExample(TReturnExample example) throws SQLException {
		return treturndao.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Long id) throws SQLException {
		return treturndao.deleteByPrimaryKey(id);
	}

	public Long insert(TReturn record) throws SQLException {
		return treturndao.insert(record);
	}

	public Long insertSelective(TReturn record) throws SQLException {
		return treturndao.insertSelective(record);
	}

	public List selectByExample(TReturnExample example) throws SQLException {
		return treturndao.selectByExample(example);
	}

	public TReturn selectByPrimaryKey(Long id) throws SQLException {
		return treturndao.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(TReturn record, TReturnExample example) throws SQLException {
		return treturndao.updateByExampleSelective(record, example);
	}

	public int updateByExample(TReturn record, TReturnExample example) throws SQLException {
		return treturndao.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(TReturn record) throws SQLException {
		return treturndao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(TReturn record) throws SQLException {
		return treturndao.updateByPrimaryKey(record);
	}

	/**
	 * 存储过程取退换货订单编号
	 * 
	 * @param paramMap
	 * @return
	 * @throws SQLException
	 */
	@Override
	public String getTurnOrderSn(Map<String, Object> paramMap) throws SQLException {
		String turnOrderSn = treturndao.getTurnOrderSn(paramMap);
		while (turnOrderSn == null || "".equals(turnOrderSn) || "-1".equals(turnOrderSn)) {
			turnOrderSn = treturndao.getTurnOrderSn(paramMap);
		}
		return turnOrderSn;
	}

}
