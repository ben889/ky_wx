package com.framework.action.verifycode;

import java.io.ByteArrayInputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Controller;

import com.framework.utils.verifycode.MyVerifyCode;
import com.framework.utils.verifycode.SecurityCode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("securityCodeImageAction")
public class SecurityCodeImageAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 1496691731440581303L;
	// 图片流
	private ByteArrayInputStream imageStream;
	protected HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
	}
	// session域
	protected HttpSession session;

	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	// public String execute() throws Exception {
	// MyVerificationCode code = new MyVerificationCode();
	// imageStream = code.getVerificationCode();
	// return SUCCESS;
	// // return super.execute();
	// }

	@Override
	public String execute() throws Exception {
		session = request.getSession();
		// 如果开启Hard模式，可以不区分大小写
		// String securityCode =
		// SecurityCode.getSecurityCode(4,SecurityCodeLevel.Hard,
		// false).toLowerCase();

		new MyVerifyCode();
		// 获取默认难度和长度的验证码
		//String securityCode = SecurityCode.getSecurityCode();
		//imageStream = SecurityCode.getImageAsInputStream(securityCode);
		String code = MyVerifyCode.generateVerifyCode(4);
		imageStream = new MyVerifyCode().getVerifyCodeImage(code);
		// 放入session中
		session.setAttribute("veritycode", code);
		return SUCCESS;
	}

	

}
