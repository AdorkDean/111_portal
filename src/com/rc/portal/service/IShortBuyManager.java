package com.rc.portal.service;

import java.sql.SQLException;

import com.rc.portal.vo.TShortBuy;

public interface IShortBuyManager {
	
	public TShortBuy getShortBuyGooods() throws SQLException;

	
}
