package com.framework.filter;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.ehcache.constructs.web.filter.Filter;

import com.framework.domain.Users;

public class LoginFilter extends Filter {

	@Override
	protected void doDestroy() {

	}

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp,
			FilterChain chain) throws Throwable {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		//ServletContext application = session.getServletContext();
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 获取URL
		String url = request.getRequestURL().toString();
		System.out.println("=============doFilter=============\nurl:" + url); // test

		// 在session中提取user
		Users user = null;
		user = (Users) session.getAttribute("user");

		// 设置过滤
		if (user != null || url.endsWith("login.jsp") || url.endsWith(".css")
				|| url.endsWith(".js")|| url.endsWith(".gif") || url.endsWith(".png")
				|| url.endsWith(".jpg")) {
			// 放行
			chain.doFilter(request, response);
		} else {
			String locationURL = request.getContextPath() + "/admin/login.jsp";
			 PrintWriter out = response.getWriter();
			 out.print("<script language>top.location.href='" + locationURL
			 + "'</script>");
			//response.sendRedirect(locationURL);
		}
	}

	@Override
	protected void doInit(FilterConfig arg0) throws Exception {
		System.out.println("=============doInit=============");
	}

	// class MyRequest extends HttpServletRequestWrapper {
	// private HttpServletRequest request;
	//
	// public MyRequest(HttpServletRequest request) {
	// super(request);
	// this.request = request;
	// }
	//
	// @Override
	// public String getParameter(String name) {
	//
	// String value = this.request.getParameter(name);
	// if (value == null) {
	// return null;
	// }
	// if (!this.request.getMethod().equalsIgnoreCase("get")) {
	// return value;
	// }
	// try {
	// value = new String(value.getBytes("iso8859-1"), "UTF-8");
	// } catch (UnsupportedEncodingException e) {
	// throw new RuntimeException(e);
	// }
	// return value;
	// }
	// }

}
