package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.portal.dao.OpenSqlDAO;
import com.rc.portal.dao.TMemberReceiverLatLonDAO;
import com.rc.portal.service.TMemberReceiverLatLonManager;
import com.rc.portal.vo.TMemberReceiverLatLon;
import com.rc.portal.vo.TMemberReceiverLatLonExample;

public class TMemberReceiverLatLonManagerImpl  implements TMemberReceiverLatLonManager {

    private TMemberReceiverLatLonDAO tmemberreceiverlatlondao;
    
    private OpenSqlDAO opensqldao;

    public TMemberReceiverLatLonManagerImpl() {
        super();
    }
    public void  setTmemberreceiverlatlondao(TMemberReceiverLatLonDAO tmemberreceiverlatlondao){
        this.tmemberreceiverlatlondao=tmemberreceiverlatlondao;
    }
    public TMemberReceiverLatLonDAO getTmemberreceiverlatlondao(){
        return this.tmemberreceiverlatlondao;
    }
    public     int countByExample(TMemberReceiverLatLonExample example) throws SQLException{
        return tmemberreceiverlatlondao. countByExample( example);
    }

    public     int deleteByExample(TMemberReceiverLatLonExample example) throws SQLException{
        return tmemberreceiverlatlondao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmemberreceiverlatlondao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberReceiverLatLon record) throws SQLException{
        return tmemberreceiverlatlondao. insert( record);
    }

    public     Long insertSelective(TMemberReceiverLatLon record) throws SQLException{
        return tmemberreceiverlatlondao. insertSelective( record);
    }

    public     List selectByExample(TMemberReceiverLatLonExample example) throws SQLException{
        return tmemberreceiverlatlondao. selectByExample( example);
    }

    public     TMemberReceiverLatLon selectByPrimaryKey(Long id) throws SQLException{
        return tmemberreceiverlatlondao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberReceiverLatLon record, TMemberReceiverLatLonExample example) throws SQLException{
        return tmemberreceiverlatlondao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberReceiverLatLon record, TMemberReceiverLatLonExample example) throws SQLException{
        return tmemberreceiverlatlondao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberReceiverLatLon record) throws SQLException{
        return tmemberreceiverlatlondao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberReceiverLatLon record) throws SQLException{
        return tmemberreceiverlatlondao. updateByPrimaryKey( record);
    }
	public void updateReceiverDefault(Long receiverId, Long memeberId)
			throws SQLException {
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("id", receiverId);
		paramMap.put("memberId", memeberId);
		this.opensqldao.updateByMap_drug(paramMap, "t_member_receiver_lat_lon.updateReceiverByMemberIdAndId");
		
		TMemberReceiverLatLon receiverLatLon = new TMemberReceiverLatLon();
		receiverLatLon.setId(receiverId);
		receiverLatLon.setIsDefault(1);
		this.tmemberreceiverlatlondao.updateByPrimaryKeySelective(receiverLatLon);
		
	}
	public OpenSqlDAO getOpensqldao() {
		return opensqldao;
	}
	public void setOpensqldao(OpenSqlDAO opensqldao) {
		this.opensqldao = opensqldao;
	}


}
