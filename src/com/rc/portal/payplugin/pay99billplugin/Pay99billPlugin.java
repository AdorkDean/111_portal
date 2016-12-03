package com.rc.portal.payplugin.pay99billplugin;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.rc.commons.util.InfoUtil;
import com.rc.portal.payplugin.PaymentPlugin;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.util.NetworkUtil;
import com.rc.portal.vo.TOrder;
/**
 * 快钱支付 
 * @author user3
 *
 */
public class Pay99billPlugin extends PaymentPlugin {
	/**
	 * 快钱生成请求信息
	 * @param order
	 * @param description
	 * @param request
	 * @return
	 */
	public Map<String, Object> getParameterMap(OpenSqlManage opensqlmanage,TOrder order, String description, HttpServletRequest request) {
		Map<String, Object> parameterMap = new LinkedHashMap<String, Object>();
		parameterMap.put("inputCharset", "1");
		parameterMap.put("pageUrl", InfoUtil.getInstance().getInfo("config","pay_return_url"));//页面通知地址
		parameterMap.put("bgUrl", InfoUtil.getInstance().getInfo("config","pay.payServiceUri")+InfoUtil.getInstance().getInfo("config","pay99billNotifyUri"));//异步通知地址
		parameterMap.put("version", "v2.0");
		parameterMap.put("language", "1");
		parameterMap.put("signType", "4");
		parameterMap.put("merchantAcctId", "1008062687101");//人民币账号 
		String payerContactType = request.getParameter("payerContactType");//支付人联系类型，1 代表电子邮件方式；2 代表手机联系方式。可以为空。
		String payerContact = request.getParameter("payerEmail");//支付人联系方式，与payerContactType设置对应，payerContactType为1，则填写邮箱地址；payerContactType为2，则填写手机号码。可以为空。
		parameterMap.put("payerContactType", payerContactType);
		parameterMap.put("payerContact", payerContact);
		parameterMap.put("payerIP", NetworkUtil.getIpAddress(request));//
		parameterMap.put("orderId", order.getOrderSn());
		parameterMap.put("orderAmount", order.getPayableAmount().multiply(new BigDecimal(100)).setScale(0).toString());
		parameterMap.put("orderTime", new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		parameterMap.put("orderTimestamp", new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		parameterMap.put("productName", StringUtils.abbreviate(description.replaceAll("[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 100));//
		parameterMap.put("productDesc", StringUtils.abbreviate(description.replaceAll("[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 100));//
		parameterMap.put("ext1", "dst");
		parameterMap.put("payType", "10");//修改为直连银行
		parameterMap.put("bankId",request.getParameter("bankId"));//直连银行编号
		parameterMap.put("redoFlag", "0");//  固定选择值： 1、0  1 代表同一订单号只允许提交1 次；0 表示同一订单 号在没有支付成功的前提下可重复提交多次。 
		parameterMap.put("signMsg", new Pkipair().signMsg(parameterMap));
		return parameterMap;
	}

	public String getName() {
		return "快钱支付";
	}
	public String getRequestUrl() {
		return "https://www.99bill.com/gateway/recvMerchantInfoAction.htm";
	}

	public String getRequestMethod() {
		return "post";
	}

	public String getRequestCharset() {
		return "UTF-8";
	}

	@Override
	public boolean verifyNotify(TOrder order, HttpServletRequest request) {
		Map<String, Object> parameterMap = new LinkedHashMap<String, Object>();
		parameterMap.put("merchantAcctId", request.getParameter("merchantAcctId"));
		parameterMap.put("version", request.getParameter("version"));
		parameterMap.put("language", request.getParameter("language"));
		parameterMap.put("signType", request.getParameter("signType"));
		parameterMap.put("payType", request.getParameter("payType"));
		parameterMap.put("bankId", request.getParameter("bankId"));
		parameterMap.put("orderId", request.getParameter("orderId"));
		parameterMap.put("orderTime", request.getParameter("orderTime"));
		parameterMap.put("orderAmount", request.getParameter("orderAmount"));
		parameterMap.put("bindCard", request.getParameter("bindCard"));
		parameterMap.put("bindMobile", request.getParameter("bindMobile"));
		parameterMap.put("dealId", request.getParameter("dealId"));
		parameterMap.put("bankDealId", request.getParameter("bankDealId"));
		parameterMap.put("dealTime", request.getParameter("dealTime"));
		parameterMap.put("payAmount", request.getParameter("payAmount"));
		parameterMap.put("fee", request.getParameter("fee"));
		parameterMap.put("ext1", request.getParameter("ext1"));
		parameterMap.put("ext2", request.getParameter("ext2"));
		parameterMap.put("payResult", request.getParameter("payResult"));
		parameterMap.put("errCode", request.getParameter("errCode"));
		parameterMap.put("signMsg", request.getParameter("signMsg"));
		
		Pkipair pkipair = new Pkipair();
		//把获取的参数以逗号拼接
		String merchantSignMsgVal = pkipair.joinKeyValue(request);
		boolean vitifyFlag = pkipair.enCodeByCer(merchantSignMsgVal, request.getParameter("signMsg"));
		if (vitifyFlag && "1008062687101".equals(request.getParameter("merchantAcctId")) && order.getOrderSn().equals(request.getParameter("orderId")) && "10".equals(request.getParameter("payResult")) && order.getPayableAmount().multiply(new BigDecimal(100)).compareTo(new BigDecimal(request.getParameter("payAmount"))) == 0) {
			return true;
		}
		return false;
	}
	
}
