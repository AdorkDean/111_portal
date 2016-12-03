package com.rc.portal.payplugin.payEBC;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Encoder;

import com.rc.portal.payplugin.PaymentPlugin;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.vo.TOrder;
/**
 * 商联通支付
 * @author Bing King
 *
 */
public class PayEBCPlugin  extends PaymentPlugin{

	public Map<String, Object> getParameterMap(OpenSqlManage opensqlmanage,TOrder order,
			String description, HttpServletRequest request) {
		Map<String, Object> parameterMap = new LinkedHashMap<String, Object>();
		parameterMap.put("partner","611100000308124");//账号
		parameterMap.put("charset", "utf-8");
		parameterMap.put("sign_type", "MD5");
		parameterMap.put("out_trade_no", order.getOrderSn());
		parameterMap.put("total_fee", order.getPayableAmount().setScale(2).toString());
		parameterMap.put("payment_type", "sale");
		try {
			parameterMap.put("show_url", URLEncoder.encode("http://www.baidu.com", getRequestCharset()));
			parameterMap.put("describe", URLEncoder.encode(description, getRequestCharset()));
			parameterMap.put("return_url", URLEncoder.encode("http://www.baidu.com", getRequestCharset()));
			parameterMap.put("sign",  generateSign("?", parameterMap));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parameterMap;
	}

	@Override
	public String getName() {
		return "商联通支付";
	}

	@Override
	public String getRequestUrl() {
		return "https://pay.bjebc.com/trade.action";
	}

	@Override
	public String getRequestMethod() {
		return "post";
	}

	@Override
	public String getRequestCharset() {
		return "UTF-8";
	}
	/**
	 * 生成签名
	 * 
	 * @param parameterMap
	 *            参数
	 * @return 签名
	 * @throws Exception 
	 */
	private String generateSign(String prefix, Map<String, Object> parameterMap) throws Exception {
		String key = "6B7391E0-89CB-11E4-B0D5-A111DE6ECE30";
		String parameters = joinKeyValue(parameterMap, prefix ,key , "&", true, "");
		String sign = encryptBASE64(encryptMD5(parameters.getBytes())).trim();
		return sign;
	}
	/** BASE64处理 */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }
    /** MD5处理 */
    public static byte[] encryptMD5(byte[] data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(data);
        return md5.digest();
    }

	@Override
	public boolean verifyNotify(TOrder order, HttpServletRequest request) {
		try {
			String status = request.getParameter("trade_status");
			Map<String, Object> parameterMap = new LinkedHashMap<String, Object>();
			String payment_type = request.getParameter("payment_type");
			String show_url = request.getParameter("show_url");
			String describe = request.getParameter("describe");
			parameterMap.put("notify_id", request.getParameter("notify_id"));
			parameterMap.put("notify_time", request.getParameter("notify_time"));
			parameterMap.put("charset", request.getParameter("charset"));
			parameterMap.put("sign_type", request.getParameter("sign_type"));
			parameterMap.put("version", request.getParameter("version"));
			parameterMap.put("out_trade_no", order.getOrderSn());
			parameterMap.put("total_fee", request.getParameter("total_fee"));
			parameterMap.put("payment_type", StringUtils.isNotEmpty(payment_type) ?URLEncoder.encode(payment_type , getRequestCharset()) : payment_type);
			parameterMap.put("show_url", StringUtils.isNotEmpty(show_url) ?URLEncoder.encode(show_url , getRequestCharset()) : show_url);
			parameterMap.put("describe", StringUtils.isNotEmpty(describe) ?URLEncoder.encode(describe , getRequestCharset()) : describe);
			parameterMap.put("trade_status", status);
			parameterMap.put("trade_no", request.getParameter("trade_no"));
			parameterMap.put("gmt_create", request.getParameter("gmt_create"));
			parameterMap.put("gmt_payment", request.getParameter("gmt_payment"));
			if (status.equals("00") && generateSign("&", parameterMap).equals(request.getParameter("sign"))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
