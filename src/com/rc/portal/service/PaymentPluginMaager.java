package com.rc.portal.service;

import com.rc.portal.payplugin.PaymentPlugin;

public interface PaymentPluginMaager {

	public PaymentPlugin getPaymentPluginById(String pluginId);
}
