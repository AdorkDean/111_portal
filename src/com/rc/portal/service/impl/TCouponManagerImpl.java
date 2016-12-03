package com.rc.portal.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.rc.portal.dao.TCouponCardDAO;
import com.rc.portal.dao.TCouponDAO;
import com.rc.portal.dao.TMemberDAO;
import com.rc.portal.dao.TMemberIntegralDAO;
import com.rc.portal.jms.MessageSender;
import com.rc.portal.service.TCouponManager;
import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TCouponCard;
import com.rc.portal.vo.TCouponExample;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberIntegral;

public class TCouponManagerImpl  implements TCouponManager {

    private TCouponDAO tcoupondao;

    private TCouponCardDAO tcouponcarddao;
    
    private TMemberDAO tmemberdao;
    
    private TMemberIntegralDAO tmemberintegraldao;
    
    private MessageSender topicMessageSender;
    
    public MessageSender getTopicMessageSender() {
		return topicMessageSender;
	}
	public void setTopicMessageSender(MessageSender topicMessageSender) {
		this.topicMessageSender = topicMessageSender;
	}
	public TMemberDAO getTmemberdao() {
		return tmemberdao;
	}
	public void setTmemberdao(TMemberDAO tmemberdao) {
		this.tmemberdao = tmemberdao;
	}
	public TMemberIntegralDAO getTmemberintegraldao() {
		return tmemberintegraldao;
	}
	public void setTmemberintegraldao(TMemberIntegralDAO tmemberintegraldao) {
		this.tmemberintegraldao = tmemberintegraldao;
	}
	public TCouponCardDAO getTcouponcarddao() {
		return tcouponcarddao;
	}
	public void setTcouponcarddao(TCouponCardDAO tcouponcarddao) {
		this.tcouponcarddao = tcouponcarddao;
	}
	public TCouponManagerImpl() {
        super();
    }
    public void  setTcoupondao(TCouponDAO tcoupondao){
        this.tcoupondao=tcoupondao;
    }
    public TCouponDAO getTcoupondao(){
        return this.tcoupondao;
    }
    public     int countByExample(TCouponExample example) throws SQLException{
        return tcoupondao. countByExample( example);
    }

    public     int deleteByExample(TCouponExample example) throws SQLException{
        return tcoupondao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tcoupondao. deleteByPrimaryKey( id);
    }

    public     Long insert(TCoupon record) throws SQLException{
        return tcoupondao. insert( record);
    }

    public     Long insertSelective(TCoupon record) throws SQLException{
        return tcoupondao. insertSelective( record);
    }

    public     List selectByExample(TCouponExample example) throws SQLException{
        return tcoupondao. selectByExample( example);
    }

    public     TCoupon selectByPrimaryKey(Long id) throws SQLException{
        return tcoupondao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TCoupon record, TCouponExample example) throws SQLException{
        return tcoupondao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TCoupon record, TCouponExample example) throws SQLException{
        return tcoupondao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TCoupon record) throws SQLException{
        return tcoupondao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TCoupon record) throws SQLException{
        return tcoupondao. updateByPrimaryKey( record);
    }


    public void createCouponCard(TCoupon record ,TMember member,Integer count) throws SQLException {
    	
    	if(count == null){
    		count =1;
    	}
    	
        for(int i=0;i<count;i++){
        	TCouponCard card = new TCouponCard();
        	String uuid = UUID.randomUUID().toString().toUpperCase();
        	String code = null;
        	Integer number = record.getCodeLength() != null ? record
					.getCodeLength() : 10;    //获取位数
			if (record.getRule() != null && record.getRule() == 0) { //生成优惠券码
				code = record.getPrefix()
						+ BigDecimal
								.valueOf(
										Math.round((Math.random() + new Random(
												10).nextDouble())
												* Math.pow(10.0D,
														number)))
								.toString().substring(0, number);
			} else {
				code = record.getPrefix()
						+ (uuid + uuid).replaceAll("-", "")
								.replaceAll("0|O", "K")
								.substring(0, number);
			}
			card.setCreateTime(new Date());
			card.setCardNo(code);
			card.setIsUse(0);
			card.setTicketId(record.getId());
			card.setMemberId(member.getId());
			if(member!=null){
				
				TMemberIntegral tmemberintegral = new TMemberIntegral();
				tmemberintegral.setCreateDate(new Date());
				tmemberintegral.setIntegral(record.getExchangeCount()*-1);
				tmemberintegral.setMemberId(member.getId());
				tmemberintegral.setRemark("兑换优惠券:"+record.getName());
				tmemberintegral.setSource(10);
				
				tmemberintegraldao.insertSelective(tmemberintegral);
				
				Map<String, String> map = new HashMap<String, String>();
				map.put("memberId", member.getId().toString());
				map.put("jifen", (record.getExchangeCount()*-1)+"");
				map.put("version", "v7");
				topicMessageSender.sendMapMessage(map);
			}
			tcouponcarddao.insertSelective(card);
        }
	}
}
