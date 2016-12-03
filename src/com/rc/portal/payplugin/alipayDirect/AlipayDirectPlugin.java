package com.rc.portal.payplugin.alipayDirect;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import com.rc.portal.alipay.config.AlipayConfig;
import com.rc.portal.alipay.util.AlipayNotify;
import com.rc.portal.payplugin.PaymentPlugin;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.util.NetworkUtil;
import com.rc.portal.vo.TOrder;
/**
 * 支付宝即时交易
 * @author user3
 *
 */
public class AlipayDirectPlugin extends PaymentPlugin{

	@Override
	public Map<String, Object> getParameterMap(OpenSqlManage opensqlmanage,TOrder order,
			String description, HttpServletRequest request) {
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("service", "create_direct_pay_by_user");
		parameterMap.put("partner", AlipayConfig.partner);//账号
		parameterMap.put("_input_charset", "utf-8");
		parameterMap.put("sign_type", "MD5");
		parameterMap.put("return_url", AlipayConfig.returnurl);//页面通知地址
		parameterMap.put("notify_url", AlipayConfig.notifyurl);//异步通知地址
		parameterMap.put("out_trade_no", order.getOrderSn());
		parameterMap.put("subject", StringUtils.abbreviate(description.replaceAll("[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 60));
		parameterMap.put("body", StringUtils.abbreviate(description.replaceAll("[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 200));
		parameterMap.put("payment_type", "1");
		parameterMap.put("seller_id", AlipayConfig.partner);//支付账号
		parameterMap.put("total_fee", order.getPayableAmount().setScale(2).toString());
		parameterMap.put("show_url", "http://www.111yao.com");
		parameterMap.put("paymethod", "directPay");
		parameterMap.put("exter_invoke_ip",  NetworkUtil.getIpAddress(request));//
		parameterMap.put("extra_common_param", "dst");
		parameterMap.put("sign", generateSign(parameterMap));//
		return parameterMap;
	}
	
	/**
	 * 生成签名
	 * 
	 * @param parameterMap
	 *            参数
	 * @return 签名
	 */
	private String generateSign(Map<String, ?> parameterMap) {
		return DigestUtils.md5Hex(joinKeyValue(new TreeMap<String, Object>(parameterMap), null, AlipayConfig.key, "&", true, "sign_type", "sign"));
	}

	@Override
	public String getName() {
		return "支付宝(即时交易)";
	}

	@Override
	public String getRequestUrl() {
		return "https://mapi.alipay.com/gateway.do";
	}

	@Override
	public String getRequestMethod() {
		return "get";
	}

	@Override
	public String getRequestCharset() {
		return "UTF-8";
	}

	@Override
	public boolean verifyNotify(TOrder order, HttpServletRequest request) {
		   boolean verify = false;
	        //获取支付宝POST过来反馈信息
	        Map<String,String> params = new HashMap<String,String>();
	        Map requestParams = request.getParameterMap();
	        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();)
	        {
	            String name = (String) iter.next();
	            String[] values = (String[]) requestParams.get(name);
	            String valueStr = "";
	            for (int i = 0; i < values.length; i++)
	            {
	                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
	            }
	            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
	            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
	            params.put(name, valueStr);
	        }
	        if(AlipayNotify.verify(params))
	        {
	            verify = true;
	        }
	        return verify;
	}

}
