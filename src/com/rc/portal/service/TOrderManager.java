package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.rc.portal.vo.TOrder;
import com.rc.portal.vo.TOrderExample;

public interface TOrderManager {
    int countByExample(TOrderExample example) throws SQLException;

    int deleteByExample(TOrderExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TOrder record) throws SQLException;

    Long insertSelective(TOrder record) throws SQLException;

    List selectByExample(TOrderExample example) throws SQLException;

    TOrder selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TOrder record, TOrderExample example) throws SQLException;

    int updateByExample(TOrder record, TOrderExample example) throws SQLException;

    int updateByPrimaryKeySelective(TOrder record) throws SQLException;

    int updateByPrimaryKey(TOrder record) throws SQLException;
    /**
	 * 根据购物车商品计算优惠券
	 * cartType  购物车结算商品类型   0 全部   1 非医卡通商品  2 医卡通商品
	 * @return
	 * @throws SQLException
	 */
    public List<Map<String,Object>> getCouponByGoods(String cartType,List<Map<String, Object>> memberCouponList,String memberId) throws SQLException;
    
    /**
     * 计算订单相关金额
     * @param couponCardId 优惠券id
     * @param receiverId   收货地址id
     * @param memberId   用户id
     * @param paymentWayId  支付方式
     * @param shortOrderId  秒杀id
     * @param deliveryId  
     * @return cartType  购物车结算商品类型   0 全部   1 非医卡通商品  2 医卡通商品
     * @throws SQLException
     */
	public Map<String, Object> getOrderPrice(String cartType,
			String couponCardId, String receiverId,String memberId,String paymentWayId,String shortOrderId,String deliveryId) throws Exception;

	/**
	 * 校验指定的优惠券是否可以使用
	 * @param couponCardId
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	public boolean checkCouponCard(String cartType,String couponCardId,String memberId,List<Map<String, Object>> memberCouponList) throws Exception;
	
	/**
	 * 保存订单信息   返回订单id
	 * @param order  订单相关信息
	 * @param receiverId  收货地址信息
	 * @param paymentWayId  支付方式
	 * @param couponCardId  优惠券 
	 * @param deliveryId   配送方式id
	 * @return
	 * @throws Exception
	 */
	public long saveOrder(String cartType,TOrder order,String receiverId,String paymentWayId,
			String couponCardId,String shortOrderId,String deliveryId) throws Exception;
	
	/**
	 * 取消订单
	 * @param orderId
	 * @throws Exception
	 */
	public void cancelOrder(long orderId,Integer orderType,long memberId) throws Exception;
	
	/**
	 * 完成订单
	 */
	public void complete(TOrder order,String publicServiceUrl) throws Exception;
	/**
	 * 更改支付方式为货到付款
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public boolean changePayWayHdfk(TOrder order,long paymentmethodId) throws Exception;
	
	
}
