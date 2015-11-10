package com.framework.action;

import com.framework.domain.Users;
/**
 * 
 */
public class CommonAction<T> extends BaseAction<T> {
	protected int userid;
	protected int usertype;
	protected int status;
	protected String username;
	
	public CommonAction(){
		//权限验证
		
	}
	
	protected Users userInfo(){
		Users user = null;
		user = (Users) request.getSession().getAttribute("user");
		userid = user.getUserid();
		usertype = user.getUsertype();
		status = user.getStatus();
		username = user.getUsername();
		return user;
	}
	
}
