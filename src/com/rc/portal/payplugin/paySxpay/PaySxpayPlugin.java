package com.rc.portal.payplugin.paySxpay;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.rc.portal.payplugin.PaymentPlugin;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.util.NetworkUtil;
import com.rc.portal.vo.TOrder;

/**
 * 闪钱包支付
 * @author user3
 *
 */
public class PaySxpayPlugin  extends PaymentPlugin{

	@Override
	public Map<String, Object> getParameterMap(OpenSqlManage opensqlmanage,TOrder order,
			String description, HttpServletRequest request) {
		Map<String, Object> parameterMap = new LinkedHashMap<String, Object>();
		//密钥
		String secretKey ="916a2ed55cea6ece297cddd30cc7c174";
		// 版本号
		String version = "1.0";
		// 接口类型
		String mercInterface = "mercCrtCsmOrd";
		// 商户编号
		String mercId = "888000000000241";
		// 商户订单号
		String mercOrderNo = order.getOrderSn();
		// 订单金额
		String amount = String.valueOf(order.getPayableAmount().doubleValue());
		// 有效时间
		String validTime = "2d"; // nd：表示n天 nh：表示n小时 nm：表示n分钟
		// 订单描述
		String sxdescription = description;
		// 分账参数
		String allotParm = "";
		// 收件人姓名
		String userName = order.getReceiver();
		// 收件人地址
		String userAddr =order.getAreaName()+order.getDetailedAddress();
		// 收件人手机号
		String userMbl = order.getPhone();
		// -- 外网ip
		String clientIp = NetworkUtil.getIpAddress(request);
		// 页面通知地址
		String pageUrl = "http://www.baidu.com";
		// 后台通知地址
		String notifyUrl = "http://www.baidu.com";

		// -- 计算签名
		StringBuffer signData = new StringBuffer();
		signData.append("UTF-8");
		signData.append(mercId);
		signData.append(mercInterface);
		signData.append(version);
		signData.append("MD5");
		signData.append(allotParm);
		signData.append(mercOrderNo);
		signData.append(amount);
		signData.append(validTime);
		signData.append(description);
		signData.append(clientIp);
		signData.append(pageUrl);
		signData.append(notifyUrl);
		String hmac = MD5.sign(signData.toString(), secretKey, "UTF-8");

		parameterMap.put("charset", "UTF-8"); // 字符集
		parameterMap.put("secretKey", secretKey);
		parameterMap.put("mercId", mercId);
		parameterMap.put("interfaceName", mercInterface);
		parameterMap.put("version", version);
		parameterMap.put("signType", "MD5");
		parameterMap.put("mercOrderNo", mercOrderNo);
		parameterMap.put("amount", amount);
		parameterMap.put("allotParm", allotParm);
		parameterMap.put("validTime", validTime);
		parameterMap.put("description", sxdescription);
		parameterMap.put("userName", userName);
		parameterMap.put("userAddr", userAddr);
		parameterMap.put("userMbl", userMbl);
		parameterMap.put("clientIp", clientIp);
		parameterMap.put("pageUrl", pageUrl);
		parameterMap.put("notifyUrl", notifyUrl);
		parameterMap.put("hmac", hmac);
		return parameterMap;
	}

	@Override
	public String getName() {
		return "闪钱包支付";
	}

	@Override
	public String getRequestUrl() {
		return "https://baitiao.shanqb.com/ips/mercCsm/charges/mercCrtCsmOrd";
	}

	@Override
	public String getRequestMethod() {
		return "post";
	}

	@Override
	public String getRequestCharset() {
		return "UTF-8";
	}

	@Override
	public boolean verifyNotify(TOrder order, HttpServletRequest request) {
		String charset = request.getParameter("charset");
		String mercId = request.getParameter("mercId");
		String signType = request.getParameter("signType");
		String interFace = request.getParameter("interface");
		String version = request.getParameter("version");
		String mercOrderNo = request.getParameter("mercOrderNo");
		String ordAmt = request.getParameter("ordAmt");
		String paySts = request.getParameter("paySts");
		String payAmt = request.getParameter("payAmt");
		String signdata = charset + mercId +signType+ interFace + version 
				+ mercOrderNo + ordAmt + paySts + payAmt;
		String hmac = request.getParameter("hmac");
		//密钥
		String secretKey ="916a2ed55cea6ece297cddd30cc7c174";
		String hmac1 = MD5.sign(signdata, secretKey, charset);
		if (hmac.equals(hmac1) && "S".equals(paySts)
				&& "888000000000241".equals(mercId)
				&& order.getOrderSn().equals(mercOrderNo)
				&& order.getPayableAmount().compareTo(new BigDecimal(ordAmt)) == 0) {
			return true;
		}
		return false;
	}

}
