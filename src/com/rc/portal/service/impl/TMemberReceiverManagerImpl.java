package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.portal.dao.OpenSqlDAO;
import com.rc.portal.dao.TMemberReceiverDAO;
import com.rc.portal.service.TMemberReceiverManager;
import com.rc.portal.vo.TMemberReceiver;
import com.rc.portal.vo.TMemberReceiverExample;

public class TMemberReceiverManagerImpl  implements TMemberReceiverManager {

    private TMemberReceiverDAO tmemberreceiverdao;
    private OpenSqlDAO opensqldao;

    public TMemberReceiverManagerImpl() {
        super();
    }
    public void  setTmemberreceiverdao(TMemberReceiverDAO tmemberreceiverdao){
        this.tmemberreceiverdao=tmemberreceiverdao;
    }
    public TMemberReceiverDAO getTmemberreceiverdao(){
        return this.tmemberreceiverdao;
    }
    public     int countByExample(TMemberReceiverExample example) throws SQLException{
        return tmemberreceiverdao. countByExample( example);
    }

    public     int deleteByExample(TMemberReceiverExample example) throws SQLException{
        return tmemberreceiverdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmemberreceiverdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberReceiver record) throws SQLException{
        return tmemberreceiverdao. insert( record);
    }

    public     Long insertSelective(TMemberReceiver record) throws SQLException{
        return tmemberreceiverdao. insertSelective( record);
    }

    public     List selectByExample(TMemberReceiverExample example) throws SQLException{
        return tmemberreceiverdao. selectByExample( example);
    }

    public     TMemberReceiver selectByPrimaryKey(Long id) throws SQLException{
        return tmemberreceiverdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberReceiver record, TMemberReceiverExample example) throws SQLException{
        return tmemberreceiverdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberReceiver record, TMemberReceiverExample example) throws SQLException{
        return tmemberreceiverdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberReceiver record) throws SQLException{
        return tmemberreceiverdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberReceiver record) throws SQLException{
        return tmemberreceiverdao. updateByPrimaryKey( record);
    }
	@Override
	public void updateReceiverDefault(long receiverId,long memberId) throws SQLException {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("id", receiverId);
		paramMap.put("memberId", memberId);
		this.opensqldao.updateByMap_drug(paramMap, "t_member_receiver.updateReceiverByMemberIdAndId");
		TMemberReceiver record = new TMemberReceiver();
		record.setId(receiverId);
		record.setIsDefault(1);//默认收货地址
		this.tmemberreceiverdao.updateByPrimaryKeySelective(record);
		
	}
	public OpenSqlDAO getOpensqldao() {
		return opensqldao;
	}
	public void setOpensqldao(OpenSqlDAO opensqldao) {
		this.opensqldao = opensqldao;
	}

	

}
