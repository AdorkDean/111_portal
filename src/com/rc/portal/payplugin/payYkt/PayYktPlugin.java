package com.rc.portal.payplugin.payYkt;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.rc.commons.util.InfoUtil;
import com.rc.portal.payplugin.PaymentPlugin;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.vo.TOrder;
/**
 * Plugin 医卡通
 * @author Bing King
 *
 */
public class PayYktPlugin extends PaymentPlugin{

	public Map<String, Object> getParameterMap(OpenSqlManage opensqlmanage,TOrder order,
			String description, HttpServletRequest request) {
		    Map<String, Object> parameterMap = new LinkedHashMap<String, Object>();
		    String un = "bjybysyyysystem";//partner
		    parameterMap.put("un", un);
		    String pw = new StringBuffer(un).append("123456").append("111yao").toString();//pluginConfig.getAttribute("key")
		    pw = PlusUtils.getMD5Str(pw);
		    parameterMap.put("pw", pw);
		    parameterMap.put("storeName","111医药馆(德生堂旗下网上医药馆)");//storename
		    parameterMap.put("operator", "111yao");
		    parameterMap.put("serialNo", order.getOrderSn());
		    parameterMap.put("callbackURL", InfoUtil.getInstance().getInfo("config","pay.payServiceUri")+InfoUtil.getInstance().getInfo("config","yktNotifyUri"));//
		    parameterMap.put("redirectURL", InfoUtil.getInstance().getInfo("config","pay_return_url"));//医卡通扣款操作完成后，跳转到此URL
		    parameterMap.put("identifyCode", "857566");
		    parameterMap.put("recipient", order.getReceiver()); //收件人姓名，不可为空
		    parameterMap.put("phone", order.getPhone());// 收件人手机 , 不可为空
		    parameterMap.put("address", order.getDetailedAddress().length()>32?order.getDetailedAddress().substring(0, 32):order.getDetailedAddress());//收件人地址, 不可为空, 地址不包含省市区信息
		    parameterMap.put("district",order.getAreaName().replaceAll("-"," "));//收件人街区 “xx省 xx市 xx区”, 不可为空, 空格分离
			return parameterMap;
	}

	public String getName() {
		return "医卡通";
	}

	public String getRequestUrl() {
		        
//		return "https://www.ebaolife.com/payment/pay.php";  旧网址 
		return "https://pay.ebaolife.com/pay.php";        	
	}

	public String getRequestMethod() {
		return "post";
	}

	public String getRequestCharset() {
	    return "UTF-8";
	}

	@Override
	public boolean verifyNotify(TOrder order, HttpServletRequest request) {
		String un = "bjybysyyysystem";
		String pw = new StringBuffer(un).append("123456").append("111yao")
				.toString();
		pw = PlusUtils.getMD5Str(pw);
		// 该条消费记录在理赔系统中的唯一标识
		String id = request.getParameter("id");
		String serialNo = request.getParameter("serialNo");
		String code = request.getParameter("code");
		int intCode = Integer.parseInt(code);
		String cardNo = request.getParameter("cardNo");
		// 扣款金额
		String charge = request.getParameter("charge");
		String chargeTime = request.getParameter("chargeTime");
		String vCode = PlusUtils.getMD5Str(serialNo + chargeTime.toString()
				+ un + pw);
		String verifyCode = request.getParameter("verifyCode");
		if (intCode == 0 && Long.valueOf(chargeTime) > 0
				&& verifyCode.equals(vCode)) {
			return true;
		}
		return false;
	}

}
