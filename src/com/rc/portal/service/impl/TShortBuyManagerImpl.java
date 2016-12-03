package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.portal.dao.OpenSqlDAO;
import com.rc.portal.dao.TShortBuyDAO;
import com.rc.portal.dao.TShortGoodsDAO;
import com.rc.portal.dao.TShortOrderDAO;
import com.rc.portal.service.TShortBuyManager;
import com.rc.portal.vo.TShortBuy;
import com.rc.portal.vo.TShortBuyExample;
import com.rc.portal.vo.TShortGoodsExample;
import com.rc.portal.vo.TShortOrder;
import com.rc.portal.webapp.model.NotEnoughException;

public class TShortBuyManagerImpl  implements TShortBuyManager {

    private TShortBuyDAO tshortbuydao;
    private TShortGoodsDAO tshortgoodsdao;
    private TShortOrderDAO tshortorderdao;
    private OpenSqlDAO opensqldao;
    
   
	@Override
	public synchronized long shortBug(Map param) throws SQLException, NotEnoughException {
		
		long goodsId = (Long)param.get("goodsid");
		long killid = (Long)param.get("killid");
		long memberId = (Long)param.get("memberid");
		int killcount = (Integer)param.get("killcount");
		
		// 查库存
		
		 TShortGoodsExample example = new TShortGoodsExample();
		 example.createCriteria().andGoodsIdEqualTo(goodsId).andShortBuyIdEqualTo(killid).andTotalCountGreaterThan(0);
		 List list = tshortgoodsdao.selectByExample(example);
		 if(list.size()==0){	//库存不足
			 return 0;
		 }
		
		TShortOrder shortOrder = new TShortOrder();
		shortOrder.setMemberId(memberId);
		shortOrder.setStatus(1);
		shortOrder.setCreateTime(new Date());
		shortOrder.setRecycle(1);
		shortOrder.setShortBuyId(killid);
		shortOrder.setGoodsId(goodsId);
		long id = tshortorderdao.insertSelective(shortOrder);
		
		int n = 0;
		if(id>0){
			Map map = new HashMap();
			map.put("goodsid",goodsId );
			map.put("killid",killid );
			map.put("n", killcount);
			n= opensqldao.updateByMap_drug(map, "short-buy.minus-kill-store");
		}else{
			throw new NotEnoughException();
		}
		if(n==0){
			throw new NotEnoughException();
		}
		
		return id;
	}
    

    public TShortBuyManagerImpl() {
        super();
    }
    public void  setTshortbuydao(TShortBuyDAO tshortbuydao){
        this.tshortbuydao=tshortbuydao;
    }
    public TShortBuyDAO getTshortbuydao(){
        return this.tshortbuydao;
    }
    public     int countByExample(TShortBuyExample example) throws SQLException{
        return tshortbuydao. countByExample( example);
    }

    public     int deleteByExample(TShortBuyExample example) throws SQLException{
        return tshortbuydao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tshortbuydao. deleteByPrimaryKey( id);
    }

    public     Long insert(TShortBuy record) throws SQLException{
        return tshortbuydao. insert( record);
    }

    public     Long insertSelective(TShortBuy record) throws SQLException{
        return tshortbuydao. insertSelective( record);
    }

    public     List selectByExample(TShortBuyExample example) throws SQLException{
        return tshortbuydao. selectByExample( example);
    }

    public     TShortBuy selectByPrimaryKey(Long id) throws SQLException{
        return tshortbuydao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TShortBuy record, TShortBuyExample example) throws SQLException{
        return tshortbuydao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TShortBuy record, TShortBuyExample example) throws SQLException{
        return tshortbuydao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TShortBuy record) throws SQLException{
        return tshortbuydao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TShortBuy record) throws SQLException{
        return tshortbuydao. updateByPrimaryKey( record);
    }


	public void setTshortgoodsdao(TShortGoodsDAO tshortgoodsdao) {
		this.tshortgoodsdao = tshortgoodsdao;
	}


	public void setTshortorderdao(TShortOrderDAO tshortorderdao) {
		this.tshortorderdao = tshortorderdao;
	}


	public void setOpensqldao(OpenSqlDAO opensqldao) {
		this.opensqldao = opensqldao;
	}
	

	

}
