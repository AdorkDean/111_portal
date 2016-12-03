package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.portal.dao.OpenSqlDAO;
import com.rc.portal.dao.RxTReserveOrderDAO;
import com.rc.portal.dao.TFreightDAO;
import com.rc.portal.dao.TGoodFreightDAO;
import com.rc.portal.dao.TMemberReceiverLatLonDAO;
import com.rc.portal.service.RxTReserveOrderManager;
import com.rc.portal.vo.RxTReserveOrder;
import com.rc.portal.vo.RxTReserveOrderExample;

public class RxTReserveOrderManagerImpl  implements RxTReserveOrderManager {

    private RxTReserveOrderDAO rxtreserveorderdao;
    private TMemberReceiverLatLonDAO tmemberreceiverlatlondao;
    private TGoodFreightDAO tgoodfreightdao;
    private TFreightDAO tfreightdao;
	private OpenSqlDAO opensqldao;
	
	

    public TGoodFreightDAO getTgoodfreightdao() {
		return tgoodfreightdao;
	}
	public void setTgoodfreightdao(TGoodFreightDAO tgoodfreightdao) {
		this.tgoodfreightdao = tgoodfreightdao;
	}
	public TFreightDAO getTfreightdao() {
		return tfreightdao;
	}
	public void setTfreightdao(TFreightDAO tfreightdao) {
		this.tfreightdao = tfreightdao;
	}
	public TMemberReceiverLatLonDAO getTmemberreceiverlatlondao() {
		return tmemberreceiverlatlondao;
	}
	public void setTmemberreceiverlatlondao(
			TMemberReceiverLatLonDAO tmemberreceiverlatlondao) {
		this.tmemberreceiverlatlondao = tmemberreceiverlatlondao;
	}
	public OpenSqlDAO getOpensqldao() {
		return opensqldao;
	}
	public void setOpensqldao(OpenSqlDAO opensqldao) {
		this.opensqldao = opensqldao;
	}
	public RxTReserveOrderManagerImpl() {
        super();
    }
    public void  setRxtreserveorderdao(RxTReserveOrderDAO rxtreserveorderdao){
        this.rxtreserveorderdao=rxtreserveorderdao;
    }
    public RxTReserveOrderDAO getRxtreserveorderdao(){
        return this.rxtreserveorderdao;
    }
    public     int countByExample(RxTReserveOrderExample example) throws SQLException{
        return rxtreserveorderdao. countByExample( example);
    }

    public     int deleteByExample(RxTReserveOrderExample example) throws SQLException{
        return rxtreserveorderdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return rxtreserveorderdao. deleteByPrimaryKey( id);
    }

    public     Long insert(RxTReserveOrder record) throws SQLException{
        return rxtreserveorderdao. insert( record);
    }

    public     Long insertSelective(RxTReserveOrder record) throws SQLException{
        return rxtreserveorderdao. insertSelective( record);
    }

    public     List selectByExample(RxTReserveOrderExample example) throws SQLException{
        return rxtreserveorderdao. selectByExample( example);
    }

    public     RxTReserveOrder selectByPrimaryKey(Long id) throws SQLException{
        return rxtreserveorderdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(RxTReserveOrder record, RxTReserveOrderExample example) throws SQLException{
        return rxtreserveorderdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(RxTReserveOrder record, RxTReserveOrderExample example) throws SQLException{
        return rxtreserveorderdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(RxTReserveOrder record) throws SQLException{
        return rxtreserveorderdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(RxTReserveOrder record) throws SQLException{
        return rxtreserveorderdao. updateByPrimaryKey( record);
    }

    public Map<String, Object> getReserveOrderPrice(String receiverId,Long memberId,Long goodsId,int goodsNum) throws Exception {
    	Map<String,Object> reserveOrderMap = new HashMap<String,Object>();
    	
    	//根据商品id获取商品信息
    	Map map = new HashMap();
    	map.put("id", goodsId);
    	Map goodsMap = (Map) opensqldao.selectForObjectByMap(map, "t_goods.selectGoodsById");
    	
//    	TMemberReceiverLatLon	memberReceiverLatLon  = null;
//    	//订单地址
//    	if(receiverId != null){
//	    	memberReceiverLatLon =tmemberreceiverlatlondao.selectByPrimaryKey(Long.valueOf(receiverId.trim()));
//    	}
    	
    	//计算商品运费【TODO:可以考虑抽取成接口,供多端调用】
//    	BigDecimal freight = getReserveFreight(memberReceiverLatLon,goodsId);
//    	
//    	BigDecimal goodsTotal = null;
//    	//商品小计
//    	if(goodsMap != null && goodsMap.get("pcPrice") != null){
//    		BigDecimal pcPrice =(BigDecimal) goodsMap.get("pcPrice");
//    		goodsTotal = pcPrice.multiply(new BigDecimal(goodsNum));
//    		goodsMap.put("goodsTotal", goodsTotal);
//    		
//    	}
//    	
//    	BigDecimal totalAmount;
//    	//计算订单总价
//    	if(goodsTotal != null){
//    		totalAmount = goodsTotal.add(freight);
//    		goodsMap.put("totalAmount", totalAmount);
//    	}
    	
    	reserveOrderMap.put("goods", goodsMap);
//    	reserveOrderMap.put("freight", freight);
    	return reserveOrderMap;
    }
    
//    public BigDecimal getReserveFreight(TMemberReceiverLatLon	memberReceiverLatLon,Long goodId) throws SQLException{
//    	if(memberReceiverLatLon != null
//    			&& memberReceiverLatLon.getStoreId() != null && memberReceiverLatLon.getStoreId().trim().length() > 0){
//    		return new BigDecimal(0);
//    	}else{
//    		TGoodFreightExample tGoodFreightExample = new TGoodFreightExample();
//    		tGoodFreightExample.createCriteria().andGoodIdEqualTo(goodId);
//    		List tgoodfreightList =  tgoodfreightdao.selectByExample(tGoodFreightExample);
//    		TGoodFreight tGoodFreight = null;
//    		if(tgoodfreightList != null && tgoodfreightList.size() > 0){
//    			tGoodFreight = (TGoodFreight) tgoodfreightList.get(0);
//    			
//    			Long freightId = tGoodFreight.getFreightId();
//    			TFreightExample tFreightExample = new TFreightExample();
//    			tFreightExample.createCriteria().andIdEqualTo(freightId);
//    			List tFreightList = tfreightdao.selectByExample(tFreightExample);
//    			
//    			if(tFreightList != null && tFreightList.size() > 0){
//    				TFreight tFreight = (TFreight) tFreightList.get(0);
//    				if(tFreight.getIsDelete() != 1){
//    					return tFreight.getFreight();
//    				}
//    			}
//    		}
//    	}
//    	
//    	return new BigDecimal(0);
//    }
}
