package com.rc.portal.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.rc.portal.dao.TCouponCardDAO;
import com.rc.portal.service.TCouponCardManager;
import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TCouponCard;
import com.rc.portal.vo.TCouponCardExample;

public class TCouponCardManagerImpl  implements TCouponCardManager {

    private TCouponCardDAO tcouponcarddao;

    public TCouponCardManagerImpl() {
        super();
    }
    public void  setTcouponcarddao(TCouponCardDAO tcouponcarddao){
        this.tcouponcarddao=tcouponcarddao;
    }
    public TCouponCardDAO getTcouponcarddao(){
        return this.tcouponcarddao;
    }
    public     int countByExample(TCouponCardExample example) throws SQLException{
        return tcouponcarddao. countByExample( example);
    }

    public     int deleteByExample(TCouponCardExample example) throws SQLException{
        return tcouponcarddao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tcouponcarddao. deleteByPrimaryKey( id);
    }

    public     Long insert(TCouponCard record) throws SQLException{
        return tcouponcarddao. insert( record);
    }

    public     Long insertSelective(TCouponCard record) throws SQLException{
        return tcouponcarddao. insertSelective( record);
    }

    public     List selectByExample(TCouponCardExample example) throws SQLException{
        return tcouponcarddao. selectByExample( example);
    }

    public     TCouponCard selectByPrimaryKey(Long id) throws SQLException{
        return tcouponcarddao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TCouponCard record, TCouponCardExample example) throws SQLException{
        return tcouponcarddao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TCouponCard record, TCouponCardExample example) throws SQLException{
        return tcouponcarddao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TCouponCard record) throws SQLException{
        return tcouponcarddao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TCouponCard record) throws SQLException{
        return tcouponcarddao. updateByPrimaryKey( record);
    }
	
    
	public Long bindingCoupon(TCoupon coupon, Long memberId,int quantity) throws SQLException {
        Long id = 0L;
		for(int i=0;i<quantity;i++){
      	TCouponCard card = new TCouponCard();
      	String uuid = UUID.randomUUID().toString().toUpperCase();
      	String code = null;
      	Integer number = coupon.getCodeLength() != null ? coupon
					.getCodeLength() : 10;    //获取位数
			if (coupon.getRule() != null && coupon.getRule() == 0) { //生成优惠券码
				code = coupon.getPrefix()
						+ BigDecimal
								.valueOf(
										Math.round((Math.random() + new Random(
												10).nextDouble())
												* Math.pow(10.0D,
														number)))
								.toString().substring(0, number);
			} else {
				code = coupon.getPrefix()
						+ (uuid + uuid).replaceAll("-", "")
								.replaceAll("0|O", "K")
								.substring(0, number);
			}
			card.setCreateTime(new Date());
			card.setCardNo(code);
			card.setIsUse(0);
			card.setTicketId(coupon.getId());
			card.setMemberId(memberId);
			id = tcouponcarddao.insertSelective(card);
      }
		return id;
	}
	@Override
	public Long bindingCouponLimit(TCoupon coupon, Long memberId, int quantity)
			throws SQLException {
		TCouponCardExample tcce = new TCouponCardExample();
		tcce.createCriteria().andMemberIdIsNull().andTicketIdEqualTo(coupon.getId()).andIsUseEqualTo(0);
		List list = tcouponcarddao.selectByExample(tcce);
		if(null != list && list.size()>0){
			TCouponCard card = (TCouponCard) list.get(0);
			card.setMemberId(memberId);
			tcouponcarddao.updateByPrimaryKeySelective(card);
			return 1L;
		}else{
			return -1L;
		}
	}
	/**
	 * 用户注册发放优惠劵
	 */
	public Long bindingCoupon(List couponList, Long memberId, int quantity)
			throws SQLException {
		for(int j=0;j<couponList.size();j++){
			TCoupon coupon = (TCoupon) couponList.get(j);
			for(int i=0;i<quantity;i++){
		      	TCouponCard card = new TCouponCard();
		      	String uuid = UUID.randomUUID().toString().toUpperCase();
		      	String code = null;
		      	Integer number = coupon.getCodeLength() != null ? coupon
							.getCodeLength() : 10;    //获取位数
					if (coupon.getRule() != null && coupon.getRule() == 0) { //生成优惠券码
						code = coupon.getPrefix()
								+ BigDecimal
										.valueOf(
												Math.round((Math.random() + new Random(
														10).nextDouble())
														* Math.pow(10.0D,
																number)))
										.toString().substring(0, number);
					} else {
						code = coupon.getPrefix()
								+ (uuid + uuid).replaceAll("-", "")
										.replaceAll("0|O", "K")
										.substring(0, number);
					}
					card.setCreateTime(new Date());
					card.setCardNo(code);
					card.setIsUse(0);
					card.setTicketId(coupon.getId());
					card.setMemberId(memberId);
					tcouponcarddao.insertSelective(card);
		      }
			
		}
		return null;
	}
}
