package com.rc.portal.webapp.model.cart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CartSum {

	private int cnt;
	private List<Map<String,Object>> list;
	private BigDecimal zongjia;
	private BigDecimal youhui;
	
	
	public BigDecimal getZongjia() {
		return zongjia;
	}
	public void setZongjia(BigDecimal zongjia) {
		this.zongjia = zongjia;
	}
	public BigDecimal getYouhui() {
		return youhui;
	}
	public void setYouhui(BigDecimal youhui) {
		this.youhui = youhui;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public List<Map<String,Object>> getList() {
		return list;
	}
	public void setList(List<Map<String,Object>> list) {
		this.list = list;
	}

}
