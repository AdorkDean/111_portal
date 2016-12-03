package com.rc.portal.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberAccountDAO;
import com.rc.portal.dao.TMemberBaseMessageExtDAO;
import com.rc.portal.dao.TMemberDAO;
import com.rc.portal.dao.TMemberLeaderDAO;
import com.rc.portal.dao.TMemberThreeBindingDAO;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberAccount;
import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.vo.TMemberExample;
import com.rc.portal.vo.TMemberLeader;
import com.rc.portal.vo.TMemberThreeBinding;

public class TMemberManagerImpl  implements TMemberManager {

    private TMemberDAO tmemberdao;
    private TMemberThreeBindingDAO tmemberthreebindingdao;
    private TMemberBaseMessageExtDAO tmemberbasemessageextdao;
    public TMemberBaseMessageExtDAO getTmemberbasemessageextdao() {
		return tmemberbasemessageextdao;
	}
	public void setTmemberbasemessageextdao(
			TMemberBaseMessageExtDAO tmemberbasemessageextdao) {
		this.tmemberbasemessageextdao = tmemberbasemessageextdao;
	}

	private TMemberLeaderDAO tmemberleaderdao;
    public TMemberLeaderDAO getTmemberleaderdao() {
		return tmemberleaderdao;
	}
	public void setTmemberleaderdao(TMemberLeaderDAO tmemberleaderdao) {
		this.tmemberleaderdao = tmemberleaderdao;
	}
	public TMemberThreeBindingDAO getTmemberthreebindingdao() {
		return tmemberthreebindingdao;
	}
	public void setTmemberthreebindingdao(
			TMemberThreeBindingDAO tmemberthreebindingdao) {
		this.tmemberthreebindingdao = tmemberthreebindingdao;
	}
	public TMemberManagerImpl() {
        super();
    }
    public void  setTmemberdao(TMemberDAO tmemberdao){
        this.tmemberdao=tmemberdao;
    }
    public TMemberDAO getTmemberdao(){
        return this.tmemberdao;
    }
    
    private TMemberAccountDAO tmemberaccountdao;

    public void  setTmemberaccountdao(TMemberAccountDAO tmemberaccountdao){
        this.tmemberaccountdao=tmemberaccountdao;
    }
    public TMemberAccountDAO getTmemberaccountdao(){
        return this.tmemberaccountdao;
    }
    public     int countByExample(TMemberExample example) throws SQLException{
        return tmemberdao. countByExample( example);
    }

    public     int deleteByExample(TMemberExample example) throws SQLException{
        return tmemberdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmemberdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMember record) throws SQLException{
        return tmemberdao. insert( record);
    }
    public     Long saveTMemberAccount(TMemberAccount record) throws SQLException{
        return tmemberaccountdao. insert( record);
    }
    public     Long insertSelective(TMember record,TLeader leader) throws SQLException{
    	Long id = tmemberdao. insertSelective( record);
    	TMemberAccount	memberAccount=new TMemberAccount();
    	memberAccount.setMemberId(id);
		memberAccount.setFreezeAmount(new BigDecimal(0));
		memberAccount.setRemainingAmount(new BigDecimal(0));
		memberAccount.setWaitAmount(new BigDecimal(0));
		memberAccount.setTotalAmount(new BigDecimal(0));
		tmemberaccountdao.insertSelective(memberAccount);
		if(leader!=null){
			TMemberLeader tmLeader =new TMemberLeader();
			tmLeader.setLeaderId(leader.getId());
			tmLeader.setMemberId(id);
			tmemberleaderdao.insertSelective(tmLeader);
		}
        return id;
    }

    public     List selectByExample(TMemberExample example) throws SQLException{
        return tmemberdao. selectByExample( example);
    }

    public     TMember selectByPrimaryKey(Long id) throws SQLException{
        return tmemberdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMember record, TMemberExample example) throws SQLException{
        return tmemberdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMember record, TMemberExample example) throws SQLException{
        return tmemberdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMember record) throws SQLException{
        return tmemberdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMember record) throws SQLException{
        return tmemberdao. updateByPrimaryKey( record);
    }
	@Override
	public Long saveMemberThreeBinding(TMemberThreeBinding record)
			throws SQLException {
		return tmemberthreebindingdao.insertSelective(record);
	}
	@Override
	public Long savetmemberbasemessageext(TMemberBaseMessageExt record)
			throws SQLException {
		return tmemberbasemessageextdao.insertSelective(record);
	}

}
