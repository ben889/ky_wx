package com.framework.action;

import java.io.IOException;

import com.framework.domain.Users;

@SuppressWarnings("all")
public class CommonAction<T> extends BaseAction<T> {
	protected int userid;
	protected String usertype;
	protected int status;
	protected String username;
	public String tabkey;
	public Users user;

	public CommonAction() {
		
		// 权限验证
//		if (user != null && !user.getUsertype().toLowerCase().equals("host")
//				&& !user.getUsertype().toLowerCase().equals("admin")) {
//			if (tabkey == null || tabkey.trim().length() == 0) {
//				try {
//					response.getWriter().write(
//							"<script>alert('tabkey为空');</script>");
//					// System.out.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				return;
//			}
//		}
	}

	protected void userInfo() {
		user = (Users) request.getSession().getAttribute("user");
		userid = user.getUserid();
		usertype = user.getUsertype();
		status = user.getStatus();
		username = user.getUsername();
		// return user;
	}

}
