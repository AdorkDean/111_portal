package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rc.commons.util.InfoUtil;
import com.rc.portal.dao.CPaymentWayDAO;
import com.rc.portal.dao.TSysParameterDAO;
import com.rc.portal.service.CPaymentWayManager;
import com.rc.portal.vo.CPaymentWay;
import com.rc.portal.vo.CPaymentWayExample;
import com.rc.portal.vo.TMemberReceiverLatLon;

public class CPaymentWayManagerImpl  implements CPaymentWayManager {

    private CPaymentWayDAO cpaymentwaydao;
    private TSysParameterDAO tsysparameterdao;

    public CPaymentWayManagerImpl() {
        super();
    }
    public void  setCpaymentwaydao(CPaymentWayDAO cpaymentwaydao){
        this.cpaymentwaydao=cpaymentwaydao;
    }
    public CPaymentWayDAO getCpaymentwaydao(){
        return this.cpaymentwaydao;
    }
    public     int countByExample(CPaymentWayExample example) throws SQLException{
        return cpaymentwaydao. countByExample( example);
    }

    public     int deleteByExample(CPaymentWayExample example) throws SQLException{
        return cpaymentwaydao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return cpaymentwaydao. deleteByPrimaryKey( id);
    }

    public     Long insert(CPaymentWay record) throws SQLException{
        return cpaymentwaydao. insert( record);
    }

    public     Long insertSelective(CPaymentWay record) throws SQLException{
        return cpaymentwaydao. insertSelective( record);
    }

    public     List selectByExample(CPaymentWayExample example) throws SQLException{
        return cpaymentwaydao. selectByExample( example);
    }

    public     CPaymentWay selectByPrimaryKey(Long id) throws SQLException{
        return cpaymentwaydao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(CPaymentWay record, CPaymentWayExample example) throws SQLException{
        return cpaymentwaydao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(CPaymentWay record, CPaymentWayExample example) throws SQLException{
        return cpaymentwaydao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(CPaymentWay record) throws SQLException{
        return cpaymentwaydao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(CPaymentWay record) throws SQLException{
        return cpaymentwaydao. updateByPrimaryKey( record);
    }
	public List<CPaymentWay> selectByExampleAndReceiverId(
			CPaymentWayExample example, TMemberReceiverLatLon receiverLatLon) throws SQLException {
		List<CPaymentWay> paymentList =cpaymentwaydao. selectByExample( example);
		List<CPaymentWay> paymentListnew = new ArrayList<CPaymentWay>();
		if(receiverLatLon!=null&&receiverLatLon.getArea()!=null){
			String hdfk_area =tsysparameterdao.getKeys("paymethod_hdfk_area");//支付方式支持货到付款地区
			 if(receiverLatLon.getArea().indexOf(hdfk_area)==-1){//判断北京
		        	for(CPaymentWay payWay:paymentList){
		        		if(!payWay.getPaymentCode().equals(InfoUtil.getInstance().getInfo("config", "payment.hdfk"))){
		        			paymentListnew.add(payWay);
		        		}
		        	}
		        }else{
		        	paymentListnew.addAll(paymentList);
		        }
		}else{
			paymentListnew.addAll(paymentList);
		}
		return paymentListnew;
	}
	public TSysParameterDAO getTsysparameterdao() {
		return tsysparameterdao;
	}
	public void setTsysparameterdao(TSysParameterDAO tsysparameterdao) {
		this.tsysparameterdao = tsysparameterdao;
	}


}
