package com.rc.portal.util;
/**
 * 订单状态枚举
 * @author user3
 *
 */
public enum  OrderEnum {
	
//	0 待支付 1 待发货 2 待收货  3 已完成  4 已取消 5 已过期
	
    
	/** 待支付 */
	UNPAY(0),
	/** 待发货 */
	UNDELIVERY(1),
	/** 待收货 **/
	DELIVERY(2),
	/** 已完成 **/
	FINISH(3),
	/** 已取消 **/
	CANCEL(4),
	/** 已过期 **/
	OVERDUE(5);
	
    private int index;
    // 构造方法
    private OrderEnum( int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

}
