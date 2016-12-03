package com.rc.portal.webapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TCouponCardManager;
import com.rc.portal.service.TCouponManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TCouponCardExample;
import com.rc.portal.vo.TMember;

/**
 * 用户绑定优惠劵
 * @author Administrator
 *
 */
@SuppressWarnings("rawtypes")
public class CouponAction extends BaseAction {
	
	
	private static final long serialVersionUID = 1L;
	private OpenSqlManage opensqlmanage;
	private TCouponManager tcouponmanager;
	private TCouponCardManager tcouponcardmanager;
	private TMemberManager tmembermanager;
	private TSysParameterManager tsysparametermanager;
	
	/**
	 * 
	 * return 1成功 2用户已经绑定 3优惠劵已经发放完毕 4服务器错误 5无效优惠劵6无效用户
	 * @throws IOException
	 * @throws SQLException
	 */
	
	public void bindingCoupon() throws IOException, SQLException{
		HttpServletResponse reponse = this.getResponse();
	    reponse.setContentType("text/html;charset=utf-8");
	    PrintWriter out = reponse.getWriter();
	    String flag = "3";
	    
	    try {
			TMember sessionMember = (TMember) this.getSession().getAttribute(
					"member");
			if(null !=sessionMember && null != sessionMember.getId()){
				String couponId = this.getRequest().getParameter("couponId");
				if (null != couponId) {
//					String cp = InfoUtil.getInstance()
//							.getInfo("config", "couponId");
					String cp  = tsysparametermanager.getKeys("couponId");
					// cp 网站活动可以领取的优惠劵ID集合 
					String c[] = cp.split(",");
					boolean b = false;
					for (int i = 0; i < c.length; i++) {
						if (couponId.equals(c[i])) {
							b = true;
							break;
						}
					}
					if (!b) {
						flag = "5";
					} else {
						TCouponCardExample tcce = new TCouponCardExample();
						tcce.createCriteria()
								.andMemberIdEqualTo(sessionMember.getId())
								.andTicketIdEqualTo(new Long(couponId));
						List list = tcouponcardmanager.selectByExample(tcce);
						if (null != list && list.size() > 0) { //判断用户是否绑定过该优惠劵
							flag = "2";
						} else {
							TCoupon coupon = tcouponmanager
									.selectByPrimaryKey(new Long(couponId));
							Long id = tcouponcardmanager.bindingCoupon(coupon,
									sessionMember.getId(), 1);
							if (id > 0) {
								flag = "1";
							}
						}
					}

				} else {
					flag = "5";
				}
			}else{
				flag ="6";
			}
		} catch (Exception e) {
			flag="4";
		}
		out.print(flag);
		out.close();
	}
	
	/**
	 * return 1成功 2用户已经绑定 3优惠劵已经发放完毕 4服务器错误 5无效优惠劵6无效用户
	 * @throws IOException
	 * @throws SQLException
	 */
	public void bindingCouponLimit() throws IOException, SQLException{
		HttpServletResponse reponse = this.getResponse();
	    reponse.setContentType("text/html;charset=utf-8");
	    PrintWriter out = reponse.getWriter();
	    String flag = "3";
	    try {
			TMember sessionMember = (TMember) this.getSession().getAttribute(
					"member");
			if(null !=sessionMember && null != sessionMember.getId()){
				String couponId = this.getRequest().getParameter("couponId");
				if (null != couponId) {
//					String cp = InfoUtil.getInstance()
//							.getInfo("config", "couponId");
					String cp  = tsysparametermanager.getKeys("couponId");
					// cp 网站活动可以领取的优惠劵ID集合 
					String c[] = cp.split(",");
					boolean b = false;
					for (int i = 0; i < c.length; i++) {
						if (couponId.equals(c[i])) {
							b = true;
							break;
						}
					}
					if (!b) {
						flag = "5";
					} else {
						TCouponCardExample tcce = new TCouponCardExample();
						tcce.createCriteria()
								.andMemberIdEqualTo(sessionMember.getId())
								.andTicketIdEqualTo(new Long(couponId));
						List list = tcouponcardmanager.selectByExample(tcce);
						if (null != list && list.size() > 0) { //判断用户是否绑定过该优惠劵
							flag = "2";
						} else {
							TCoupon coupon = tcouponmanager
									.selectByPrimaryKey(new Long(couponId));
							Long id = tcouponcardmanager.bindingCouponLimit(coupon,
									sessionMember.getId(), 1);
							if (id > 0) {
								flag = "1";
							}else{
								flag = "3";
							}
						}
					}

				} else {
					flag = "5";
				}
			}else{
				flag ="6";
			}
		} catch (Exception e) {
			flag="4";
		}
		out.print(flag);
		out.close();
	}
	
	/**
	 * 
	 * return 1成功 2用户已经绑定 3优惠劵已经发放完毕 4服务器错误 5无效优惠劵6无效用户
	 * @throws IOException
	 * @throws SQLException
	 */
	public void zqBindingCoupon() throws IOException, SQLException{
		HttpServletResponse reponse = this.getResponse();
	    reponse.setContentType("text/html;charset=utf-8");
	    PrintWriter out = reponse.getWriter();
	    String flag = "3";
	    try {
			TMember sessionMember = (TMember) this.getSession().getAttribute(
					"member");
			if(null !=sessionMember && null != sessionMember.getId()){
				String couponId = this.getRequest().getParameter("couponId");
				if (null != couponId) {
					String cp  = tsysparametermanager.getKeys("couponId");
					// cp 网站活动可以领取的优惠劵ID集合 
					String c[] = cp.split(",");
					boolean b = false;
					for (int i = 0; i < c.length; i++) {
						if (couponId.equals(c[i])) {
							b = true;
							break;
						}
					}
					if (!b) {
						flag = "5";
					} else {
						TCoupon coupon = tcouponmanager
								.selectByPrimaryKey(new Long(couponId));
						Long id = tcouponcardmanager.bindingCoupon(coupon,
								sessionMember.getId(), 1);
						if (id > 0) {
							flag = "1";
						}
					}

				} else {
					flag = "5";
				}
			}else{
				flag ="6";
			}
		} catch (Exception e) {
			flag="4";
		}
		out.print(flag);
		out.close();
	}
	
	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}


	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
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

	public TCouponManager getTcouponmanager() {
		return tcouponmanager;
	}

	public void setTcouponmanager(TCouponManager tcouponmanager) {
		this.tcouponmanager = tcouponmanager;
	}

	public TCouponCardManager getTcouponcardmanager() {
		return tcouponcardmanager;
	}

	public void setTcouponcardmanager(TCouponCardManager tcouponcardmanager) {
		this.tcouponcardmanager = tcouponcardmanager;
	}

	public TMemberManager getTmembermanager() {
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
	}

	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}

	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}

}
