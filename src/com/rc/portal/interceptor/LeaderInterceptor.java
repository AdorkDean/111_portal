package com.rc.portal.interceptor;

import java.util.List;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TLeaderManager;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TLeaderExample;
import com.rc.portal.vo.TMember;

/**
 * 领秀拦截器
 */
@SuppressWarnings("unchecked")
public class LeaderInterceptor implements Interceptor 
{
	private static final long serialVersionUID = 56589424541L;
	
	private OpenSqlManage opensqlmanage;
	
	public void destroy() {}

	public void init() {}
	
	private String redirectUrl;
	
	private TLeaderManager tleadermanager;

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	public TLeaderManager getTleadermanager() {
		return tleadermanager;
	}

	public void setTleadermanager(TLeaderManager tleadermanager) {
		this.tleadermanager = tleadermanager;
	}

	/**
	 * 会员是否为领秀拦截,如果不是领秀跳转到领秀注册
	 */
	public String intercept(ActionInvocation invocation) throws Exception 
	{
		TMember member = (TMember)ServletActionContext.getRequest().getSession().getAttribute("member");
		TLeaderExample example = new TLeaderExample();
		example.createCriteria().andMemberIdEqualTo(member.getId());
		List<TLeader> selectByExample = tleadermanager.selectByExample(example);
		if(selectByExample != null && selectByExample.size() > 0)
		{					
			ServletActionContext.getRequest().getSession().setAttribute("tleader", selectByExample.get(0));
		}
		else
		{
			return "leader_register";
		}
		return invocation.invoke();
	}

}