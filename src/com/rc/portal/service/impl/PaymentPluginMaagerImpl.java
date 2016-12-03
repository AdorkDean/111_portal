package com.rc.portal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.rc.portal.payplugin.PaymentPlugin;
import com.rc.portal.payplugin.alipayDirect.AlipayDirectPlugin;
import com.rc.portal.payplugin.pay99billplugin.Pay99billPlugin;
import com.rc.portal.payplugin.payEBC.PayEBCPlugin;
import com.rc.portal.payplugin.paySxpay.PaySxpayPlugin;
import com.rc.portal.payplugin.payWzf.PayWzfPlugin;
import com.rc.portal.payplugin.payYkt.PayYktPlugin;
import com.rc.portal.service.PaymentPluginMaager;

public class PaymentPluginMaagerImpl implements PaymentPluginMaager{
	private Map<String,PaymentPlugin> paymentMap = null;
	
	public PaymentPlugin getPaymentPluginById(String pluginId) {
		if(StringUtils.hasText(pluginId)){
			init();
			return paymentMap.get(pluginId);
		}
		return null;
	}

	public void init(){
		if(paymentMap==null){
			paymentMap = new HashMap<String,PaymentPlugin>();
			paymentMap.put("pay99billPlugin",new Pay99billPlugin());
			paymentMap.put("payEBCPlugin",new PayEBCPlugin());
			paymentMap.put("paySxpayPlugin",new PaySxpayPlugin());
			paymentMap.put("payWzfPlugin",new PayWzfPlugin());
			paymentMap.put("payYktPlugin",new PayYktPlugin());
			paymentMap.put("alipayDirectPlugin",new AlipayDirectPlugin());
		}
	}
}
