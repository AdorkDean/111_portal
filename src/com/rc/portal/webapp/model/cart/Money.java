package com.rc.portal.webapp.model.cart;

import java.math.BigDecimal;

public class Money {

	private BigDecimal money;
	private int count;
	
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
