package com.rc.portal.payplugin.pay99billplugin;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;


public class Pkipair {
	public String signMsg( Map<String, Object> parameterMap) {
		String signMsg = joinKeyValue(parameterMap, null, "", "&", true, null);
		System.out.println(signMsg);
		String base64 = "";
		try {
			// 密钥仓库
			KeyStore ks = KeyStore.getInstance("PKCS12");

			// 读取密钥仓库
//			FileInputStream ksfis = new FileInputStream("e:/tester-rsa.pfx");
			
			// 读取密钥仓库（相对路径）
			String file = Pkipair.class.getResource("99bill-rsa.pfx").getPath().replaceAll("%20", " ");
			
			FileInputStream ksfis = new FileInputStream(file);
			
			BufferedInputStream ksbufin = new BufferedInputStream(ksfis);

//			char[] keyPwd = "111yao2015".toCharArray(); 壹佰壹拾壹科技公司密码
			
			char[] keyPwd = "123456".toCharArray();
			//char[] keyPwd = "YaoJiaNiLOVE999Year".toCharArray();
			ks.load(ksbufin, keyPwd);
			// 从密钥仓库得到私钥
			PrivateKey priK = (PrivateKey) ks.getKey("test-alias", keyPwd);
			Signature signature = Signature.getInstance("SHA1withRSA");
			signature.initSign(priK);
			signature.update(signMsg.getBytes("utf-8"));
			sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
			base64 = encoder.encode(signature.sign());
			
		} catch(FileNotFoundException e){
			System.out.println("文件找不到");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return base64;
	}
	public boolean enCodeByCer( String val, String msg) {
		boolean flag = false;
		try {
			//获得文件(绝对路径)
			//InputStream inStream = new FileInputStream("e:/99bill[1].cert.rsa.20140803.cer");
			
			//获得文件(相对路径)
			String file = Pkipair.class.getResource("99bill.cert.rsa.20340630.cer").toURI().getPath();
			FileInputStream inStream = new FileInputStream(file);
			
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
			//获得公钥
			PublicKey pk = cert.getPublicKey();
			//签名
			Signature signature = Signature.getInstance("SHA1withRSA");
			signature.initVerify(pk);
			signature.update(val.getBytes());
			//解码
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			flag = signature.verify(decoder.decodeBuffer(msg));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("no");
		} 
		return flag;
	}
	/**
	 * 连接Map值
	 * 
	 * @param map
	 *            Map
	 * @param prefix
	 *            前缀
	 * @param suffix
	 *            后缀
	 * @param separator
	 *            连接符
	 * @param ignoreEmptyValue
	 *            忽略空值
	 * @param ignoreKeys
	 *            忽略Key
	 * @return 字符串
	 */
	protected String joinValue(Map<String, Object> map, String prefix, String suffix, String separator, boolean ignoreEmptyValue, String... ignoreKeys) {
		List<String> list = new ArrayList<String>();
		if (map != null) {
			for (Entry<String, Object> entry : map.entrySet()) {
				String key = entry.getKey();
				String value = ConvertUtils.convert(entry.getValue());
				if (StringUtils.isNotEmpty(key) && !ArrayUtils.contains(ignoreKeys, key) && (!ignoreEmptyValue || StringUtils.isNotEmpty(value))) {
					list.add(value != null ? value : "");
				}
			}
		}
		return (prefix != null ? prefix : "") + StringUtils.join(list, separator) + (suffix != null ? suffix : "");
	}
	/**
	 * 连接Map键值对
	 * 
	 * @param map
	 *            Map
	 * @param prefix
	 *            前缀
	 * @param suffix
	 *            后缀
	 * @param separator
	 *            连接符
	 * @param ignoreEmptyValue
	 *            忽略空值
	 * @param ignoreKeys
	 *            忽略Key
	 * @return 字符串
	 */
	protected String joinKeyValue(Map<String, Object> map, String prefix, String suffix, String separator, boolean ignoreEmptyValue, String... ignoreKeys) {
		List<String> list = new ArrayList<String>();
		if (map != null) {
			for (Entry<String, Object> entry : map.entrySet()) {
				String key = entry.getKey();
				String value = ConvertUtils.convert(entry.getValue());
				if (StringUtils.isNotEmpty(key) && !ArrayUtils.contains(ignoreKeys, key) && (!ignoreEmptyValue || StringUtils.isNotEmpty(value))) {
					list.add(key + "=" + (value != null ? value : ""));
				}
			}
		}
		return (prefix != null ? prefix : "") + StringUtils.join(list, separator) + (suffix != null ? suffix : "");
	}
public String joinKeyValue(HttpServletRequest request){
		
		//人民币网关账号，该账号为11位人民币网关商户编号+01,该值与提交时相同。
		String merchantAcctId = request.getParameter("merchantAcctId");
		//网关版本，固定值：v2.0,该值与提交时相同。
		String version = request.getParameter("version");
		//语言种类，1代表中文显示，2代表英文显示。默认为1,该值与提交时相同。
		String language = request.getParameter("language");
		//签名类型,该值为4，代表PKI加密方式,该值与提交时相同。
		String signType = request.getParameter("signType");
		//支付方式，一般为00，代表所有的支付方式。如果是银行直连商户，该值为10,该值与提交时相同。
		String payType = request.getParameter("payType");
		//银行代码，如果payType为00，该值为空；如果payType为10,该值与提交时相同。
		String bankId = request.getParameter("bankId");
		//商户订单号，该值与提交时相同。
		String orderId = request.getParameter("orderId");
		//订单提交时间，格式：yyyyMMddHHmmss，如：20071117020101,该值与提交时相同。
		String orderTime = request.getParameter("orderTime");
		//订单金额，金额以“分”为单位，商户测试以1分测试即可，切勿以大金额测试,该值与支付时相同。
		String orderAmount = request.getParameter("orderAmount");
		// 快钱交易号，商户每一笔交易都会在快钱生成一个交易号。
		String dealId = request.getParameter("dealId");
		//银行交易号 ，快钱交易在银行支付时对应的交易号，如果不是通过银行卡支付，则为空
		String bankDealId = request.getParameter("bankDealId");
		//快钱交易时间，快钱对交易进行处理的时间,格式：yyyyMMddHHmmss，如：20071117020101
		String dealTime = request.getParameter("dealTime");
		//商户实际支付金额 以分为单位。比方10元，提交时金额应为1000。该金额代表商户快钱账户最终收到的金额。
		String payAmount = request.getParameter("payAmount");
		//费用，快钱收取商户的手续费，单位为分。
		String fee = request.getParameter("fee");
		//扩展字段1，该值与提交时相同。
		String ext1 = request.getParameter("ext1");
		//扩展字段2，该值与提交时相同。
		String ext2 = request.getParameter("ext2");
		//处理结果， 10支付成功，11 支付失败，00订单申请成功，01 订单申请失败
		String payResult = request.getParameter("payResult");
		//错误代码 ，请参照《人民币网关接口文档》最后部分的详细解释。
		String errCode = request.getParameter("errCode");
		//把获取的参数以逗号拼接
		String merchantSignMsgVal = "";
		merchantSignMsgVal = appendParam(merchantSignMsgVal,"merchantAcctId", merchantAcctId);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "version",version);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "language",language);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "signType",signType);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "payType",payType);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "bankId",bankId);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "orderId",orderId);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "orderTime",orderTime);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "orderAmount",orderAmount);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "dealId",dealId);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "bankDealId",bankDealId);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "dealTime",dealTime);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "payAmount",payAmount);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "fee", fee);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "ext1", ext1);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "ext2", ext2);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "payResult",payResult);
		merchantSignMsgVal = appendParam(merchantSignMsgVal, "errCode",errCode);
		return merchantSignMsgVal;
	}
	public String appendParam(String returns, String paramId, String paramValue) {
		if (!returns.equals("")) {
	
			if (!paramValue.equals("")) {
				returns += "&" + paramId + "=" + paramValue;
			}
	
		} else {
	
			if (!paramValue.equals("")) {
				returns = paramId + "=" + paramValue;
			}
		}
	
		return returns;
	}

	
}
