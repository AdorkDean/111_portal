package com.rc.portal.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TGoodsBrokerageDAO;
import com.rc.portal.dao.TLeaderDAO;
import com.rc.portal.dao.TLeaderGoodsRecommendDAO;
import com.rc.portal.dao.TLeaderPharmacyDAO;
import com.rc.portal.dao.TMemberAccountDAO;
import com.rc.portal.dao.TMemberBaseMessageExtDAO;
import com.rc.portal.dao.TMemberDAO;
import com.rc.portal.dao.TMemberLeaderDAO;
import com.rc.portal.service.TLeaderManager;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TLeaderExample;
import com.rc.portal.vo.TLeaderGoodsRecommend;
import com.rc.portal.vo.TLeaderGoodsRecommendExample;
import com.rc.portal.vo.TLeaderPharmacy;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberAccount;
import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.vo.TMemberLeader;
import com.rc.portal.vo.TMemberLeaderExample;

public class TLeaderManagerImpl  implements TLeaderManager {

    private TLeaderDAO tleaderdao;
    
    private TMemberDAO tmemberdao;
    
    private TMemberAccountDAO tmemberaccountdao;
    
    private TMemberBaseMessageExtDAO tmemberbasemessageextdao;
    
    private TLeaderPharmacyDAO tleaderpharmacydao;
    
    private TGoodsBrokerageDAO tgoodsbrokeragedao;
    
    private TMemberLeaderDAO tmemberleaderdao;
    
    private TLeaderGoodsRecommendDAO tleadergoodsrecommenddao;
    
    
    
    public TMemberLeaderDAO getTmemberleaderdao() {
		return tmemberleaderdao;
	}
	public void setTmemberleaderdao(TMemberLeaderDAO tmemberleaderdao) {
		this.tmemberleaderdao = tmemberleaderdao;
	}
	public TLeaderPharmacyDAO getTleaderpharmacydao() {
		return tleaderpharmacydao;
	}
	public void setTleaderpharmacydao(TLeaderPharmacyDAO tleaderpharmacydao) {
		this.tleaderpharmacydao = tleaderpharmacydao;
	}
	public TGoodsBrokerageDAO getTgoodsbrokeragedao() {
		return tgoodsbrokeragedao;
	}
	public void setTgoodsbrokeragedao(TGoodsBrokerageDAO tgoodsbrokeragedao) {
		this.tgoodsbrokeragedao = tgoodsbrokeragedao;
	}
	public TMemberDAO getTmemberdao() {
		return tmemberdao;
	}
	public void setTmemberdao(TMemberDAO tmemberdao) {
		this.tmemberdao = tmemberdao;
	}
	public TMemberAccountDAO getTmemberaccountdao() {
		return tmemberaccountdao;
	}
	public void setTmemberaccountdao(TMemberAccountDAO tmemberaccountdao) {
		this.tmemberaccountdao = tmemberaccountdao;
	}
	public TMemberBaseMessageExtDAO getTmemberbasemessageextdao() {
		return tmemberbasemessageextdao;
	}
	public void setTmemberbasemessageextdao(
			TMemberBaseMessageExtDAO tmemberbasemessageextdao) {
		this.tmemberbasemessageextdao = tmemberbasemessageextdao;
	}
	public TLeaderManagerImpl() {
        super();
    }
    public void  setTleaderdao(TLeaderDAO tleaderdao){
        this.tleaderdao=tleaderdao;
    }
    public TLeaderDAO getTleaderdao(){
        return this.tleaderdao;
    }
    public     int countByExample(TLeaderExample example) throws SQLException{
        return tleaderdao. countByExample( example);
    }

    public     int deleteByExample(TLeaderExample example) throws SQLException{
        return tleaderdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tleaderdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLeader record) throws SQLException{
        return tleaderdao. insert( record);
    }

    public     Long insertSelective(TLeader record) throws SQLException{
        return tleaderdao. insertSelective( record);
    }

    public     List selectByExample(TLeaderExample example) throws SQLException{
        return tleaderdao. selectByExample( example);
    }

    public     TLeader selectByPrimaryKey(Long id) throws SQLException{
        return tleaderdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLeader record, TLeaderExample example) throws SQLException{
        return tleaderdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLeader record, TLeaderExample example) throws SQLException{
        return tleaderdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLeader record) throws SQLException{
        return tleaderdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLeader record) throws SQLException{
        return tleaderdao. updateByPrimaryKey( record);
    }

    /**
     * 添加领袖与官网用户
     */
	public Long savetLeaderAndMember(TMember record, TLeader leader,
			TMemberBaseMessageExt base) throws SQLException {
		Long id = tmemberdao. insertSelective( record);
    	TMemberAccount	memberAccount=new TMemberAccount();
    	memberAccount.setMemberId(id);
		memberAccount.setFreezeAmount(new BigDecimal(0));
		memberAccount.setRemainingAmount(new BigDecimal(0));
		memberAccount.setWaitAmount(new BigDecimal(0));
		memberAccount.setTotalAmount(new BigDecimal(0));
		tmemberaccountdao.insertSelective(memberAccount);
		base.setMemberId(id);
		tmemberbasemessageextdao.insertSelective(base);
		leader.setMemberId(id);
		tleaderdao.insertSelective(leader);
		TLeaderGoodsRecommendExample goodsRecommendExample = new TLeaderGoodsRecommendExample();
		goodsRecommendExample.createCriteria().andTypeEqualTo(1);
		List<TLeaderGoodsRecommend> list =tleadergoodsrecommenddao.selectByExample(goodsRecommendExample);
		if(null !=list && list.size() > 0){
			TLeaderPharmacy pharmacy = null;
			for (int i = 0; i < list.size(); i++) {
				TLeaderGoodsRecommend goodsRecommend = (TLeaderGoodsRecommend) list.get(i);
				 pharmacy = new TLeaderPharmacy();
				 pharmacy.setGoodsId(goodsRecommend.getGoodsId());
				 pharmacy.setLeaderId(leader.getId());
				 pharmacy.setMemberId(record.getId());
				 tleaderpharmacydao.insertSelective(pharmacy);
			}
		}
        return id;
	}
	
	@Override
	public Long insertSelectiveLeaderAndGoods(TLeader record)
			throws SQLException {
		Long id = tleaderdao. insertSelective(record);
		TMemberLeaderExample example = new TMemberLeaderExample();
		example.createCriteria().andMemberIdEqualTo(record.getMemberId());
		List memberList =  tmemberleaderdao.selectByExample(example);
		TMemberLeader memberLeader = null;
		if(null != memberList && memberList.size() >0){
			for (int i = 0; i < memberList.size(); i++) {
				memberLeader = (TMemberLeader) memberList.get(i);
				tmemberleaderdao.deleteByPrimaryKey(memberLeader.getId());
			}
		}
		TMemberAccount memberAccount = tmemberaccountdao.selectByPrimaryKey(record.getMemberId());
		if(null == memberAccount || null == memberAccount.getMemberId()){
			memberAccount=new TMemberAccount();
	    	memberAccount.setMemberId(record.getMemberId());
			memberAccount.setFreezeAmount(new BigDecimal(0));
			memberAccount.setRemainingAmount(new BigDecimal(0));
			memberAccount.setWaitAmount(new BigDecimal(0));
			memberAccount.setTotalAmount(new BigDecimal(0));
			tmemberaccountdao.insertSelective(memberAccount);
		}
		TLeaderGoodsRecommendExample goodsRecommendExample = new TLeaderGoodsRecommendExample();
		goodsRecommendExample.createCriteria().andTypeEqualTo(1);
		List<TLeaderGoodsRecommend> list =tleadergoodsrecommenddao.selectByExample(goodsRecommendExample);
		if(null !=list && list.size() > 0){
			TLeaderPharmacy pharmacy = null;
			for (int i = 0; i < list.size(); i++) {
				TLeaderGoodsRecommend goodsRecommend = (TLeaderGoodsRecommend) list.get(i);
				 pharmacy = new TLeaderPharmacy();
				 pharmacy.setGoodsId(goodsRecommend.getGoodsId());
				 pharmacy.setLeaderId(record.getId());
				 pharmacy.setMemberId(record.getMemberId());
				 tleaderpharmacydao.insertSelective(pharmacy);
			}
		}
		return id;
	}
	public TLeaderGoodsRecommendDAO getTleadergoodsrecommenddao() {
		return tleadergoodsrecommenddao;
	}
	public void setTleadergoodsrecommenddao(
			TLeaderGoodsRecommendDAO tleadergoodsrecommenddao) {
		this.tleadergoodsrecommenddao = tleadergoodsrecommenddao;
	}
	
	public boolean updateMemberMobileBind(TMember member,String mobile) throws SQLException{
		//1:修改t_member
		TMember tMember = new TMember();
		tMember.setId(member.getId());
		tMember.setMobile(mobile);
		tMember.setIsMobileCheck(1);
		if(tmemberdao.updateByPrimaryKeySelective(tMember) <= 0){
			return false;
		}
		
		//2:查询t_leader表中是否当前登录会员是健康领秀,如果有update phone
		TLeaderExample leaderExample = new TLeaderExample();
		leaderExample.createCriteria().andMemberIdEqualTo(member.getId());
		List<TLeader> leaderList = tleaderdao.selectByExample(leaderExample);
		if(leaderList.size() > 0){
			TLeader leader = leaderList.get(0);
			
			TLeader leaderTemp = new TLeader();
			leaderTemp.setId(leader.getId());
			leaderTemp.setPhone(mobile.trim());
			if(tleaderdao.updateByPrimaryKeySelective(leaderTemp) <= 0){
				return false;
			}
		}
		
		return true;
	}
}
