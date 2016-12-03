package com.rc.portal.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.portal.dao.OpenSqlDAO;
import com.rc.portal.dao.TMemberAccountDAO;
import com.rc.portal.dao.TMemberAmountOutDAO;
import com.rc.portal.service.TMemberAmountOutManager;
import com.rc.portal.vo.TMemberAccount;
import com.rc.portal.vo.TMemberAmountOut;
import com.rc.portal.vo.TMemberAmountOutExample;

public class TMemberAmountOutManagerImpl  implements TMemberAmountOutManager {

    private TMemberAmountOutDAO tmemberamountoutdao;
    
    private TMemberAccountDAO tmemberaccountdao;

    public TMemberAmountOutManagerImpl() {
        super();
    }
    
	private OpenSqlDAO opensqldao;
	
	public OpenSqlDAO getOpensqldao() {
		return opensqldao;
	}

	public void setOpensqldao(OpenSqlDAO opensqldao) {
		this.opensqldao = opensqldao;
	}
    public void  setTmemberaccountdao(TMemberAccountDAO tmemberaccountdao){
        this.tmemberaccountdao=tmemberaccountdao;
    }
    public TMemberAccountDAO getTmemberaccountdao(){
        return this.tmemberaccountdao;
    }
    public void  setTmemberamountoutdao(TMemberAmountOutDAO tmemberamountoutdao){
        this.tmemberamountoutdao=tmemberamountoutdao;
    }
    public TMemberAmountOutDAO getTmemberamountoutdao(){
        return this.tmemberamountoutdao;
    }
    public     int countByExample(TMemberAmountOutExample example) throws SQLException{
        return tmemberamountoutdao. countByExample( example);
    }

    public     int deleteByExample(TMemberAmountOutExample example) throws SQLException{
        return tmemberamountoutdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmemberamountoutdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberAmountOut record) throws SQLException{
        return tmemberamountoutdao. insert( record);
    }

    public     Long insertSelective(TMemberAmountOut record) throws SQLException{
        return tmemberamountoutdao. insertSelective( record);
    }

    public     List selectByExample(TMemberAmountOutExample example) throws SQLException{
        return tmemberamountoutdao. selectByExample( example);
    }

    public     TMemberAmountOut selectByPrimaryKey(Long id) throws SQLException{
        return tmemberamountoutdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberAmountOut record, TMemberAmountOutExample example) throws SQLException{
        return tmemberamountoutdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberAmountOut record, TMemberAmountOutExample example) throws SQLException{
        return tmemberamountoutdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberAmountOut record) throws SQLException{
        return tmemberamountoutdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberAmountOut record) throws SQLException{
        return tmemberamountoutdao. updateByPrimaryKey( record);
    }
	

    /**
     * 提现申请
     */
	public Long insertAmountOut(TMemberAmountOut record) throws SQLException {
		Map<String,Object> querMap = new HashMap<String,Object>();
		querMap.put("memberid", record.getMemberId());
		Map map = (Map) opensqldao.selectForObjectByMap(querMap, "t_member_account.selectForUpdate");
		if(null != map && null != map.get("member_id")){
			BigDecimal remaining_amount = new BigDecimal(map.get("remaining_amount").toString());
	    	if(remaining_amount.compareTo(record.getAmount())>=0){ //冻结金额大于提现申请
	    		TMemberAccount amount = new  TMemberAccount();
	    		amount.setMemberId(new Long(map.get("member_id").toString()));
	    		amount.setRemainingAmount(remaining_amount.subtract(record.getAmount()));//余额减去提现金额
	    		BigDecimal freeze_amount = new BigDecimal(map.get("freeze_amount").toString());
	    		amount.setFreezeAmount(freeze_amount.add(record.getAmount())); //冻结金额加上提现金额
	    		tmemberaccountdao.updateByPrimaryKeySelective(amount);
	    	}else{
	    		return -3L; //账户余额小于提现金额
	    	}
		}else{
			return -2L; //无该用户资金表
		}
		record.setOutTime(new Date());
		record.setStatus(1);
		return tmemberamountoutdao.insertSelective(record); //添加提现记录
	}


}
