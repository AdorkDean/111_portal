package com.rc.portal.webapp.action.unionlogin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qq.connect.utils.json.JSONObject;
import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.util.JsonUtils;
import com.rc.commons.util.InfoUtil;
import com.rc.portal.service.ICartManager;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TCouponCardManager;
import com.rc.portal.service.TMemberBaseMessageExtManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TMemberThreeBindingManager;
import com.rc.portal.util.CookieUtil;
import com.rc.portal.util.NetworkUtil;
import com.rc.portal.util.cookieManager;
import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.vo.TMemberGrade;
import com.rc.portal.vo.TMemberThreeBinding;
import com.rc.portal.webapp.action.CartAction;
import com.rc.portal.webapp.util.MD5;

public class wxAfterLoginAction extends BaseAction{

	private static final long serialVersionUID = -5875587388413143363L;
	private TMemberManager tmembermanager;
	private TMemberThreeBinding memberThreeBinding;
	private TMemberThreeBindingManager tmemberthreebindingmanager;
	private OpenSqlManage opensqlmanage;
	private ICartManager cartmanager;
	private TCouponCardManager tcouponcardmanager;
	private TMemberBaseMessageExtManager tmemberbasemessageextmanager;
	public TMemberBaseMessageExtManager getTmemberbasemessageextmanager() {
		return tmemberbasemessageextmanager;
	}

	public void setTmemberbasemessageextmanager(
			TMemberBaseMessageExtManager tmemberbasemessageextmanager) {
		this.tmemberbasemessageextmanager = tmemberbasemessageextmanager;
	}

	public TCouponCardManager getTcouponcardmanager() {
		return tcouponcardmanager;
	}

	public void setTcouponcardmanager(TCouponCardManager tcouponcardmanager) {
		this.tcouponcardmanager = tcouponcardmanager;
	}

	public ICartManager getCartmanager() {
		return cartmanager;
	}

	public void setCartmanager(ICartManager cartmanager) {
		this.cartmanager = cartmanager;
	}

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	public static String ksecret = "9b99a29ba636a340bffe0209d9e3e30a";
	public static String kappid = "wx8e633a8b9bb4bb31";
	public TMemberThreeBindingManager getTmemberthreebindingmanager() {
		return tmemberthreebindingmanager;
	}

	public void setTmemberthreebindingmanager(
			TMemberThreeBindingManager tmemberthreebindingmanager) {
		this.tmemberthreebindingmanager = tmemberthreebindingmanager;
	}

	public TMemberThreeBinding getMemberThreeBinding() {
		return memberThreeBinding;
	}

	public void setMemberThreeBinding(TMemberThreeBinding memberThreeBinding) {
		this.memberThreeBinding = memberThreeBinding;
	}

	public TMemberManager getTmembermanager() {
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
	}

	private TMember tmember;

	public TMember getTmember() {
		return tmember;
	}

	public void setTmember(TMember tmember) {
		this.tmember = tmember;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setModel(Object o) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String wxlogin() {
		String key = cookieManager.getCookieValueByName(this.getRequest(), CartAction.cartKey);
		String code = this.getRequest().getParameter("code");
		System.out.println("code:"+code);//通过code获取accessToken
		String accessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ kappid
				+ "&secret="
				+ ksecret
				+ "&code="
				+ code + "&grant_type=authorization_code";
		String result = sendGet(accessTokenUrl);
		System.out.println("accessToken:" + result);
		try {
			if (result != null && !result.equals("")&&result.contains("openid")) {
				JSONObject json = new JSONObject(result);
				String access_token = json.getString("access_token");
				String openid = json.getString("openid");
				Map uuidMap =getUuid_(access_token,openid);
				String uuid = (String) uuidMap.get("unionid");
				getRequest().getSession().setAttribute("demo_openid", uuid);
				Map map=new HashMap();
				map.put("binding_uuid", uuid);
				// 根据openid判断用户信息是否已经存在
				memberThreeBinding = (TMemberThreeBinding) this.opensqlmanage.selectForObjectByMap(map, "t_member_three_binding.ibatorgenerated_selectByWxBindingUuid");
				if (memberThreeBinding == null) {
					TMemberGrade memberGrade1 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectDefaultGrade");
					TMemberGrade memberGrade2 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectlowGrade");
					memberThreeBinding=new TMemberThreeBinding();
					if (uuidMap != null && !uuidMap.toString().equals("")) {
						String nickname = (String) uuidMap.get("nickname");
						String sex = uuidMap.get("sex").toString();
						String province = (String) uuidMap.get("province");
						String city = (String) uuidMap.get("city");
						String country = (String) uuidMap.get("country");
						String headimgurl = (String) uuidMap.get("headimgurl");
						System.out.println("用户微信的nickname："+nickname);
						this.getRequest().setAttribute("otherNickName", nickname);//存nickname
						tmember = new TMember();
						TMemberBaseMessageExt tmemberBaseMessageext=new TMemberBaseMessageExt();
						if (sex.equals("1")) {
							tmemberBaseMessageext.setSex(1);
						} else {
							tmemberBaseMessageext.setSex(2);
						}
						tmember.setUserName("wx_"+uuid);
						tmember.setAreaId(0l);
						if(memberGrade1!=null){
							tmember.setMemberGradeId(memberGrade1.getId());
						}else{
							tmember.setMemberGradeId(memberGrade2.getId());
						}
						tmemberBaseMessageext.setHeadPortrait(headimgurl);
						tmemberBaseMessageext.setNickName(nickname);
						tmemberBaseMessageext.setAddress(country + province + city + "");
						tmember.setPassword(MD5.MD5("111"+uuid+"yao"));
						tmember.setStatus(0);
						tmember.setEnterpriseDiscount(new BigDecimal(0));
						tmember.setIsLeader(0);
						tmember.setIntegral(0);
						tmember.setSource(0);//0表示微信注册
						tmember.setPlatform(1);//1表示PC平台
						tmember.setRegisterIp(NetworkUtil.getIpAddress(this.getRequest()));
						tmember.setRegisterDate(new Date());
						tmember.setLastDate(new Date());
						tmember.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
						tmember.setIsEmailCheck(0);
						tmember.setIsMobileCheck(0);
						tmember.setAgentId(getAgentId());
						tmember.setIsAgent(0);
						TLeader leader = getLeader();
						tmembermanager.insertSelective(tmember,leader);
						tmemberBaseMessageext.setMemberId(tmember.getId());
						tmembermanager.savetmemberbasemessageext(tmemberBaseMessageext);
						if (tmember != null) {
							memberThreeBinding.setMemberId(tmember.getId());
						}
						memberThreeBinding.setSource(0);//微信
						memberThreeBinding.setCreateDate(new Date());
						memberThreeBinding.setBindingUuid(uuid);
						memberThreeBinding.setWxOpenid(openid);
						memberThreeBinding.setWxAppid(kappid);
						tmembermanager.saveMemberThreeBinding(memberThreeBinding);
						if(key!=null){
							cartmanager.synCart(tmember.getId(), key);
						}
						//this.getSession().setAttribute("member", tmember);
						//新用户送优惠券
						String cp = InfoUtil.getInstance().getInfo("config", "regCouponId");
						List regCouponMap = new ArrayList();
						String regCouponId="";
						Map couponMap=new HashMap();
						if(cp!=null&&!cp.equals("")){
							String c[] = cp.split(",");
							for (int i = 0; i < c.length; i++) {
								regCouponId=c[i];
								couponMap.put("regCouponId", regCouponId);
								TCoupon coupon = (TCoupon) opensqlmanage.selectObjectByObject(couponMap, "t_coupon.selectCouponByid");
								regCouponMap.add(coupon);
							}
							tcouponcardmanager.bindingCoupon(regCouponMap,tmember.getId(), 1);
						}
						String attribute = (String) this.getSession().getAttribute("LoginRedirect");
						if(tmember.getMobile()==null || tmember.getMobile()==""){
							return "popup";
						}else{
							this.getSession().setAttribute("member", tmember);
							if (attribute == null) {
								this.getResponse().sendRedirect("/index.html");
							} else {
								this.getSession().removeAttribute("LoginRedirect");
								this.getResponse().sendRedirect(attribute);
							}
						}
					}
				} else {
					Map openmap=new HashMap();
					openmap.put("binding_uuid", uuid);
					TMember member = (TMember) opensqlmanage.selectObjectByObject(openmap, "t_member.selectmemberByWxOpenid");
					if(key!=null){
						cartmanager.synCart(member.getId(), key);
					}
					this.getRequest().setAttribute("otherNickName", member.getNickName());//存nickname
					//this.getSession().setAttribute("member", member);
					System.out.println(member);
					String attribute = (String) this.getSession().getAttribute("LoginRedirect");
					if(member.getMobile()==null || member.getMobile()==""){
						return "popup";
					}else{
						this.getSession().setAttribute("member", member);
						if (attribute == null) {
							this.getResponse().sendRedirect("/index.html");
						} else {
							this.getSession().removeAttribute("LoginRedirect");
							this.getResponse().sendRedirect(attribute);
						}
					}
				}
			}else{
				System.out.println("返回错误   没有获取到openid");
				return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	/**
	 * 发送get请求
	 */

	public static String sendGet(String url) {

		String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("Charsert", "utf-8");
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
	}
	
	/**
	 * 开放平台通过openid获取用户信息
	 * @throws UnsupportedEncodingException 
	 */
	public static Map getUuid_(String access_token, String openid) throws UnsupportedEncodingException {
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token="
				+ access_token + "&openid=" + openid;
		String result = sendGet(url);
		if (result != null && !result.equals("")) {
			Map map = JsonUtils.toObject(result, Map.class);
			return map;
		}
		return null;
	}
	/*
	 * 领袖下线
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TLeader getLeader(){
		String code = CookieUtil.getCookie(this.getRequest(), "leader");//通过code，查找leader 
		Map map=new HashMap();
		map.put("code", code);
		TLeader tleader = (TLeader) opensqlmanage.selectObjectByObject(map, "t_leader.selectLeaderByCode");
		return tleader;
	}
	/*
	 * 获取代理人Id
	 */
	public Long getAgentId(){
		String code = CookieUtil.getCookie(this.getRequest(), "agent");//通过code，获取代理人Id
		if(code!=null){
			return Long.parseLong(code);
		}else{
			return null;
		}
	}
}
