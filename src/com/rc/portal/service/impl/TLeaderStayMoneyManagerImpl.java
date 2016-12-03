package com.rc.portal.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.portal.dao.OpenSqlDAO;
import com.rc.portal.dao.TLeaderStayMoneyDAO;
import com.rc.portal.jms.MessageSender;
import com.rc.portal.service.TLeaderStayMoneyManager;
import com.rc.portal.vo.TLeaderStayMoney;
import com.rc.portal.vo.TLeaderStayMoneyExample;
import com.rc.portal.vo.TOrder;

public class TLeaderStayMoneyManagerImpl  implements TLeaderStayMoneyManager {

    private TLeaderStayMoneyDAO tleaderstaymoneydao;
    
    private OpenSqlDAO opensqldao;
    
    private MessageSender topicMessageSender;

    public TLeaderStayMoneyManagerImpl() {
        super();
    }
    
    
    public MessageSender getTopicMessageSender() {
		return topicMessageSender;
	}


	public void setTopicMessageSender(MessageSender topicMessageSender) {
		this.topicMessageSender = topicMessageSender;
	}


	public void  setTleaderstaymoneydao(TLeaderStayMoneyDAO tleaderstaymoneydao){
        this.tleaderstaymoneydao=tleaderstaymoneydao;
    }
    public TLeaderStayMoneyDAO getTleaderstaymoneydao(){
        return this.tleaderstaymoneydao;
    }
    public     int countByExample(TLeaderStayMoneyExample example) throws SQLException{
        return tleaderstaymoneydao. countByExample( example);
    }

    public     int deleteByExample(TLeaderStayMoneyExample example) throws SQLException{
        return tleaderstaymoneydao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tleaderstaymoneydao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLeaderStayMoney record) throws SQLException{
        return tleaderstaymoneydao. insert( record);
    }

    public     Long insertSelective(TLeaderStayMoney record) throws SQLException{
        return tleaderstaymoneydao. insertSelective( record);
    }

    public     List selectByExample(TLeaderStayMoneyExample example) throws SQLException{
        return tleaderstaymoneydao. selectByExample( example);
    }

    public     TLeaderStayMoney selectByPrimaryKey(Long id) throws SQLException{
        return tleaderstaymoneydao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLeaderStayMoney record, TLeaderStayMoneyExample example) throws SQLException{
        return tleaderstaymoneydao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLeaderStayMoney record, TLeaderStayMoneyExample example) throws SQLException{
        return tleaderstaymoneydao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLeaderStayMoney record) throws SQLException{
        return tleaderstaymoneydao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLeaderStayMoney record) throws SQLException{
        return tleaderstaymoneydao. updateByPrimaryKey( record);
    }
    
    
    
	public OpenSqlDAO getOpensqldao() {
		return opensqldao;
	}
	public void setOpensqldao(OpenSqlDAO opensqldao) {
		this.opensqldao = opensqldao;
	}
	
	/**
	 * 货到付确认收货
	 * @return
	 */
	@Override
	public void insertStayByHDF(Map<String, Object> phoneMap, TOrder order) throws SQLException {
		// 给领袖算待入账佣金-----------------开始
//		if (phoneMap != null && phoneMap.get("member_id") != null && !"".equals(phoneMap.get("member_id").toString())) {
//			// 该订单属于秀粉订单,找领袖写流水；
//			TLeaderStayMoneyExample tLeaderStayMoneyExample = new TLeaderStayMoneyExample();
//			tLeaderStayMoneyExample.createCriteria().andOrderIdEqualTo(order.getId()).andTypeEqualTo(1)
//					.andRelationMemberIdEqualTo(Long.valueOf(phoneMap.get("member_id").toString()));
//			List<TLeaderStayMoney> stayMoneyList = tleaderstaymoneydao.selectByExample(tLeaderStayMoneyExample);
//			//
//			Long memberId = Long.valueOf(phoneMap.get("member_id").toString());
//			if (memberId != null && memberId > 0L && (stayMoneyList == null || stayMoneyList.size() <= 0)) {
//				Double waitingAmount = 0D;
//				Map<String, Object> countMap = new HashMap<String, Object>();
//				countMap.put("orderId", order.getId());
//				waitingAmount = (Double) opensqldao.selectForObjectByMap(countMap, "t_order_item.countFanxianAmount");
//				if (waitingAmount != null && waitingAmount > 0L) {
//					BigDecimal _waitingAmount = new BigDecimal(waitingAmount);
//					TLeaderStayMoney _TLeaderStayMoney = new TLeaderStayMoney();
//					_TLeaderStayMoney.setCreateDt(new Date());
//					_TLeaderStayMoney.setAmount(_waitingAmount);
//					_TLeaderStayMoney.setMemberType(2);// 领袖ID
//					_TLeaderStayMoney.setOrderId(order.getId());
//					_TLeaderStayMoney.setRelationMemberId(Long.valueOf(phoneMap.get("member_id").toString()));// 要返现领袖用户ID
//					_TLeaderStayMoney.setStatus(0);// 未入账
//					_TLeaderStayMoney.setType(1);
//					tleaderstaymoneydao.insertSelective(_TLeaderStayMoney);
//
//					// 推荐人给写流水------------------------------
//					Map<String, Object> tuijianParm = new HashMap<String, Object>();
//					tuijianParm.put("memberId", memberId);
//					Long tuijianMemberId = (Long) opensqldao.selectForObjectByMap(tuijianParm,
//							"t_member.selectTuijianByMemberId");
//					if (tuijianMemberId != null && tuijianMemberId > 0L) {
//						// 推荐人存在
//						Double tuijianAmount = (Double) opensqldao.selectForObjectByMap(countMap,
//								"t_order_item.countFanxianAmountAgent");
//						if (tuijianAmount > 0) {
//							TLeaderStayMoneyExample _TuijianTLeaderStayMoneyExample = new TLeaderStayMoneyExample();
//							_TuijianTLeaderStayMoneyExample.createCriteria().andOrderIdEqualTo(order.getId())
//									.andTypeEqualTo(1).andRelationMemberIdEqualTo(tuijianMemberId);
//							List<TLeaderStayMoney> tuijianLiushuiList = tleaderstaymoneydao
//									.selectByExample(_TuijianTLeaderStayMoneyExample);
//							if (tuijianLiushuiList != null && tuijianLiushuiList.size() > 0) {
//								System.out.println("推荐人流水已存在");
//							} else {
//								BigDecimal _tuijianAmount = new BigDecimal(tuijianAmount);
//								TLeaderStayMoney _tuijianTLeaderStayMoney = new TLeaderStayMoney();
//								_tuijianTLeaderStayMoney.setCreateDt(new Date());
//								_tuijianTLeaderStayMoney.setAmount(_tuijianAmount);
//								_tuijianTLeaderStayMoney.setMemberType(2);// 领袖ID
//								_tuijianTLeaderStayMoney.setOrderId(order.getId());
//								_tuijianTLeaderStayMoney.setRelationMemberId(tuijianMemberId);// 要返现领袖上级用户ID
//								_tuijianTLeaderStayMoney.setStatus(0);// 未入账
//								_tuijianTLeaderStayMoney.setType(1);
//								tleaderstaymoneydao.insertSelective(_tuijianTLeaderStayMoney);
//							}
//						}
//					}
//					// 推荐人给写流水------------------------------
//				}
//			}
//		} else {
//			// 领袖订单
//			TLeaderStayMoneyExample _TLeaderStayMoneyExample = new TLeaderStayMoneyExample();
//			_TLeaderStayMoneyExample.createCriteria().andOrderIdEqualTo(order.getId()).andTypeEqualTo(1)
//					.andRelationMemberIdEqualTo(order.getMemberId());
//			List<TLeaderStayMoney> liushuiList = tleaderstaymoneydao.selectByExample(_TLeaderStayMoneyExample);
//			if (liushuiList != null && liushuiList.size() > 0) {
//				System.out.println("非法途径");
//			} else {
//				Long memberId = Long.valueOf(order.getMemberId());
//				if (memberId != null && memberId > 0L) {
//					Double waitingAmount = 0D;
//					Map<String, Object> countMap = new HashMap<String, Object>();
//					countMap.put("orderId", order.getId());
//					waitingAmount = (Double) opensqldao.selectForObjectByMap(countMap,
//							"t_order_item.countFanxianAmount");
//					if (waitingAmount != null && waitingAmount > 0L) {
//						BigDecimal _waitingAmount = new BigDecimal(waitingAmount);
//						TLeaderStayMoney _TLeaderStayMoney = new TLeaderStayMoney();
//						_TLeaderStayMoney.setCreateDt(new Date());
//						_TLeaderStayMoney.setAmount(_waitingAmount);
//						_TLeaderStayMoney.setMemberType(2);// 领袖ID
//						_TLeaderStayMoney.setOrderId(order.getId());
//						_TLeaderStayMoney.setRelationMemberId(memberId);// 要返现领袖用户ID
//						_TLeaderStayMoney.setStatus(0);// 未入账
//						_TLeaderStayMoney.setType(1);
//						tleaderstaymoneydao.insertSelective(_TLeaderStayMoney);
//
//						// 推荐人给写流水------------------------------
//						Map<String, Object> tuijianParm = new HashMap<String, Object>();
//						tuijianParm.put("memberId", memberId);
//						Long tuijianMemberId = (Long) opensqldao.selectForObjectByMap(tuijianParm,
//								"t_member.selectTuijianByMemberId");
//						if (tuijianMemberId != null && tuijianMemberId > 0L) {
//							// 推荐人存在
//							Double tuijianAmount = (Double) opensqldao.selectForObjectByMap(countMap,
//									"t_order_item.countFanxianAmountAgent");
//							if (tuijianAmount > 0) {
//								TLeaderStayMoneyExample _TuijianTLeaderStayMoneyExample = new TLeaderStayMoneyExample();
//								_TuijianTLeaderStayMoneyExample.createCriteria().andOrderIdEqualTo(order.getId())
//										.andTypeEqualTo(1).andRelationMemberIdEqualTo(tuijianMemberId);
//								List<TLeaderStayMoney> tuijianLiushuiList = tleaderstaymoneydao
//										.selectByExample(_TuijianTLeaderStayMoneyExample);
//								if (tuijianLiushuiList != null && tuijianLiushuiList.size() > 0) {
//									System.out.println("推荐人流水已存在");
//								} else {
//									BigDecimal _tuijianAmount = new BigDecimal(tuijianAmount);
//									TLeaderStayMoney _tuijianTLeaderStayMoney = new TLeaderStayMoney();
//									_tuijianTLeaderStayMoney.setCreateDt(new Date());
//									_tuijianTLeaderStayMoney.setAmount(_tuijianAmount);
//									_tuijianTLeaderStayMoney.setMemberType(2);// 领袖ID
//									_tuijianTLeaderStayMoney.setOrderId(order.getId());
//									_tuijianTLeaderStayMoney.setRelationMemberId(tuijianMemberId);// 要返现领袖上级用户ID
//									_tuijianTLeaderStayMoney.setStatus(0);// 未入账
//									_tuijianTLeaderStayMoney.setType(1);
//									tleaderstaymoneydao.insertSelective(_tuijianTLeaderStayMoney);
//								}
//							}
//
//						}
//						// 推荐人给写流水------------------------------
//
//					} else {
//					}
//				} else {
//					System.out.println("订单MemberId为空");
//				}
//			}
//		}
		// 给领袖算待入账佣金-----------------结束
		// 给领袖发短信提示---------------开始
		String phone = null;
		if (phoneMap != null && phoneMap.get("m_phone") != null
				&& !"".equals(phoneMap.get("m_phone").toString())) {
			phone = phoneMap.get("m_phone").toString();
		} else if (phoneMap != null && phoneMap.get("l_phone") != null
				&& !"".equals(phoneMap.get("l_phone").toString())) {
			phone = phoneMap.get("l_phone").toString();
		}
		if (phone != null && !"".equals(phone)) {
			Map<String, String> messageMap = new HashMap<String, String>();
			messageMap.put("mobiles", phone);
			messageMap.put("version", "v6");
			messageMap.put("orderSn", order.getOrderSn());
			messageMap.put("smsContent", "领秀" + phoneMap.get("nick_name")
					+ "您好，您有秀粉产生了订单返佣，请到待入账金额中查看！");
			topicMessageSender.sendMapMessage(messageMap);
		}
		// 给领袖发短信提示---------------开始
	}
	
	
	
	
	
	
	/**
	 * 支付完之后调用
	 */
	@Override
	public Map<String, Object> writeStayMoneyByPayment(Map<String, Object> phoneMap, TOrder order) throws SQLException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 0);
		resultMap.put("message", "");

		// 给领袖算待入账佣金-----------------开始
		if (phoneMap != null && phoneMap.get("member_id") != null && !"".equals(phoneMap.get("member_id").toString())) {
			TLeaderStayMoneyExample _TLeaderStayMoneyExample = new TLeaderStayMoneyExample();
			_TLeaderStayMoneyExample.createCriteria().andOrderIdEqualTo(order.getId()).andTypeEqualTo(1)
					.andRelationMemberIdEqualTo(Long.valueOf(phoneMap.get("member_id").toString()));
			List<TLeaderStayMoney> liushuiList = tleaderstaymoneydao.selectByExample(_TLeaderStayMoneyExample);
			if (liushuiList != null && liushuiList.size() > 0) {
				System.out.println("非法途径");
				resultMap.put("status", 0);
				resultMap.put("message", "重复提交");
			} else {
				Long memberId = Long.valueOf(phoneMap.get("member_id").toString());
				if (memberId != null && memberId > 0L) {
					Double waitingAmount = 0D;
					Map<String, Object> countMap = new HashMap<String, Object>();
					countMap.put("orderId", order.getId());
					waitingAmount = (Double) opensqldao.selectForObjectByMap(countMap,
							"t_order_item.countFanxianAmount");
					if (waitingAmount != null && waitingAmount > 0L) {
						BigDecimal _waitingAmount = new BigDecimal(waitingAmount);
						TLeaderStayMoney _TLeaderStayMoney = new TLeaderStayMoney();
						_TLeaderStayMoney.setCreateDt(new Date());
						_TLeaderStayMoney.setAmount(_waitingAmount);
						_TLeaderStayMoney.setMemberType(2);// 领袖ID
						_TLeaderStayMoney.setOrderId(order.getId());
						_TLeaderStayMoney.setRelationMemberId(Long.valueOf(phoneMap.get("member_id").toString()));// 要返现领袖用户ID
						_TLeaderStayMoney.setStatus(0);// 未入账
						_TLeaderStayMoney.setType(1);
						tleaderstaymoneydao.insertSelective(_TLeaderStayMoney);

						// 推荐人给写流水------------------------------
						Map<String, Object> tuijianParm = new HashMap<String, Object>();
						tuijianParm.put("memberId", memberId);
						Long tuijianMemberId = (Long) opensqldao.selectForObjectByMap(tuijianParm,
								"t_member.selectTuijianByMemberId");
						if (tuijianMemberId != null && tuijianMemberId > 0L) {
							// 推荐人存在
							Double tuijianAmount = (Double) opensqldao.selectForObjectByMap(countMap,
									"t_order_item.countFanxianAmountAgent");
							if (tuijianAmount > 0) {
								TLeaderStayMoneyExample _TuijianTLeaderStayMoneyExample = new TLeaderStayMoneyExample();
								_TuijianTLeaderStayMoneyExample.createCriteria().andOrderIdEqualTo(order.getId())
										.andTypeEqualTo(1).andRelationMemberIdEqualTo(tuijianMemberId);
								List<TLeaderStayMoney> tuijianLiushuiList = tleaderstaymoneydao
										.selectByExample(_TuijianTLeaderStayMoneyExample);
								if (tuijianLiushuiList != null && tuijianLiushuiList.size() > 0) {
									System.out.println("推荐人流水已存在");
								} else {
									BigDecimal _tuijianAmount = new BigDecimal(tuijianAmount);
									TLeaderStayMoney _tuijianTLeaderStayMoney = new TLeaderStayMoney();
									_tuijianTLeaderStayMoney.setCreateDt(new Date());
									_tuijianTLeaderStayMoney.setAmount(_tuijianAmount);
									_tuijianTLeaderStayMoney.setMemberType(2);// 领袖ID
									_tuijianTLeaderStayMoney.setOrderId(order.getId());
									_tuijianTLeaderStayMoney.setRelationMemberId(tuijianMemberId);// 要返现领袖上级用户ID
									_tuijianTLeaderStayMoney.setStatus(0);// 未入账
									_tuijianTLeaderStayMoney.setType(1);
									tleaderstaymoneydao.insertSelective(_tuijianTLeaderStayMoney);
								}
							}

						}
						// 推荐人给写流水------------------------------
						resultMap.put("status", 1);
						resultMap.put("message", "写入成功");
					} else {
						resultMap.put("status", 0);
						resultMap.put("message", "待入账金额为0");
					}
				} else {
					resultMap.put("status", 0);
					resultMap.put("message", "非秀粉订单");
				}
			}
		} else {
			// 领袖订单
			TLeaderStayMoneyExample _TLeaderStayMoneyExample = new TLeaderStayMoneyExample();
			_TLeaderStayMoneyExample.createCriteria().andOrderIdEqualTo(order.getId()).andTypeEqualTo(1)
					.andRelationMemberIdEqualTo(order.getMemberId());
			List<TLeaderStayMoney> liushuiList = tleaderstaymoneydao.selectByExample(_TLeaderStayMoneyExample);
			if (liushuiList != null && liushuiList.size() > 0) {
				System.out.println("非法途径");
				resultMap.put("status", 0);
				resultMap.put("message", "重复提交");
			} else {
				Long memberId = Long.valueOf(order.getMemberId());
				if (memberId != null && memberId > 0L) {
					Double waitingAmount = 0D;
					Map<String, Object> countMap = new HashMap<String, Object>();
					countMap.put("orderId", order.getId());
					waitingAmount = (Double) opensqldao.selectForObjectByMap(countMap,
							"t_order_item.countFanxianAmount");
					if (waitingAmount != null && waitingAmount > 0L) {
						BigDecimal _waitingAmount = new BigDecimal(waitingAmount);
						TLeaderStayMoney _TLeaderStayMoney = new TLeaderStayMoney();
						_TLeaderStayMoney.setCreateDt(new Date());
						_TLeaderStayMoney.setAmount(_waitingAmount);
						_TLeaderStayMoney.setMemberType(2);// 领袖ID
						_TLeaderStayMoney.setOrderId(order.getId());
						_TLeaderStayMoney.setRelationMemberId(memberId);// 要返现领袖用户ID
						_TLeaderStayMoney.setStatus(0);// 未入账
						_TLeaderStayMoney.setType(1);
						tleaderstaymoneydao.insertSelective(_TLeaderStayMoney);

						// 推荐人给写流水------------------------------
						Map<String, Object> tuijianParm = new HashMap<String, Object>();
						tuijianParm.put("memberId", memberId);
						Long tuijianMemberId = (Long) opensqldao.selectForObjectByMap(tuijianParm,
								"t_member.selectTuijianByMemberId");
						if (tuijianMemberId != null && tuijianMemberId > 0L) {
							// 推荐人存在
							Double tuijianAmount = (Double) opensqldao.selectForObjectByMap(countMap,
									"t_order_item.countFanxianAmountAgent");
							if (tuijianAmount > 0) {
								TLeaderStayMoneyExample _TuijianTLeaderStayMoneyExample = new TLeaderStayMoneyExample();
								_TuijianTLeaderStayMoneyExample.createCriteria().andOrderIdEqualTo(order.getId())
										.andTypeEqualTo(1).andRelationMemberIdEqualTo(tuijianMemberId);
								List<TLeaderStayMoney> tuijianLiushuiList = tleaderstaymoneydao
										.selectByExample(_TuijianTLeaderStayMoneyExample);
								if (tuijianLiushuiList != null && tuijianLiushuiList.size() > 0) {
									System.out.println("推荐人流水已存在");
								} else {
									BigDecimal _tuijianAmount = new BigDecimal(tuijianAmount);
									TLeaderStayMoney _tuijianTLeaderStayMoney = new TLeaderStayMoney();
									_tuijianTLeaderStayMoney.setCreateDt(new Date());
									_tuijianTLeaderStayMoney.setAmount(_tuijianAmount);
									_tuijianTLeaderStayMoney.setMemberType(2);// 领袖ID
									_tuijianTLeaderStayMoney.setOrderId(order.getId());
									_tuijianTLeaderStayMoney.setRelationMemberId(tuijianMemberId);// 要返现领袖上级用户ID
									_tuijianTLeaderStayMoney.setStatus(0);// 未入账
									_tuijianTLeaderStayMoney.setType(1);
									tleaderstaymoneydao.insertSelective(_tuijianTLeaderStayMoney);
								}
							}
						}
						// 推荐人给写流水------------------------------
						resultMap.put("status", 1);
						resultMap.put("message", "写入成功");
					} else {
						resultMap.put("status", 0);
						resultMap.put("message", "待入账金额为0");
					}
				} else {
					resultMap.put("status", 0);
					resultMap.put("message", "订单MemberId为空");
				}
			}
		}
		return resultMap;
	}


}
