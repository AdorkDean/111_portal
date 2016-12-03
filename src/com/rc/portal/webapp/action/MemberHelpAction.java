package com.rc.portal.webapp.action;

import com.rc.app.framework.webapp.action.BaseAction;

/**
 * 售后服务
 * @author 刘天灵
 *
 */
public class MemberHelpAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	public Object getModel() {		return null;	}

	public void setModel(Object o) {}
	
	/**
	 * 售后服务
	 */
	public String after_service(){
		
		return "after_service";
	}

}
