package com.rc.portal.dao;

import java.sql.SQLException;
import java.util.Map;

import com.rc.portal.webapp.model.cart.CartParam;

public interface IDaoManager {
	
	public Map<String,Object> accounts(CartParam arg) throws SQLException;

}
