package com.rc.portal.payplugin.payWzf;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.rc.portal.payplugin.PaymentPlugin;
import com.rc.portal.payplugin.payWzf.util.Sha1Util;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.vo.TOrder;
/**
 * 微信支付
 * @author 
 *
 */
public class PayWzfPlugin extends PaymentPlugin{

	public Map<String, Object> getParameterMap(OpenSqlManage opensqlmanage,TOrder order,
			String description, HttpServletRequest request) {
		Map<String, Object> paramterMap = new LinkedHashMap<String,Object>();
		//时间戳
		paramterMap.put("timestamp", Sha1Util.getTimeStamp());
		//随机字符串
		paramterMap.put("noncestr", Sha1Util.getNonceStr());
		//二维码url
		paramterMap.put("erurl", "weixin://wxpay/bizpayurl?");
		//appid
		paramterMap.put("appid", "wx05e56a440dc95cab");
		//paySignKey
		paramterMap.put("paySignKey", "p62tTz3KMGF6g0d7j2r1abQgt5i7Eq5jhrUqB3YnGNQbDXDmsOd5FWGnbf6s7kP2HEPs7B9fXoAgaS9QDHaEse62jZBYj5zxdgDZyjjulcKiFxEUEucmrLC4RbZqNuuZ");
		//appSecret
		paramterMap.put("appSecret", "b3c235d698bf9f68d1891a701a335652");
		//partnerId
		paramterMap.put("partnerId", "1220532401");
		//partnerKey
		paramterMap.put("partnerKey", "500ec7b3ff40569032dfc7d8030c641c");
		//订单号
		paramterMap.put("order_no", order.getOrderSn());
		//订单金额
		paramterMap.put("total_fee", order.getPayableAmount());
		//notifyurl
		paramterMap.put("notify_url", "http://www.baidu.com");
		//商品描述
		paramterMap.put("description", description);
		return paramterMap;
	}

	public String getName() {
		return "微信支付";
	}

	public String getRequestUrl() {
		return "https://mp.weixin.qq.com/";
	}

	public String getRequestMethod() {
		return "get";
	}

	public String getRequestCharset() {
		return "UTF-8";
	}

	@Override
	public boolean verifyNotify(TOrder order, HttpServletRequest request) {
		// 支付结果通知返回数据
		// 支付结果状态，0 成功
		String trade_state = request.getParameter("trade_state");
		if (trade_state.equals("0")) {
			return true;
		}
		return false;
	}

}
