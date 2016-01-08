package com.framework.action.verifycode;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.framework.utils.verifycode.MyVerifyCode;
import com.framework.utils.verifycode.SecurityCode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("securityCodeImageAction")
public class SecurityCodeImageAction extends ActionSupport {

	private static final long serialVersionUID = 1496691731440581303L;
	// 图片流
	private ByteArrayInputStream imageStream;
	// session域
	private Map<String, Object> session;

	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}

	public void setSession(Map<String, Object> session) {
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
		session = ActionContext.getContext().getSession();
		// 如果开启Hard模式，可以不区分大小写
		// String securityCode =
		// SecurityCode.getSecurityCode(4,SecurityCodeLevel.Hard,
		// false).toLowerCase();

		// 获取默认难度和长度的验证码
		//String securityCode = SecurityCode.getSecurityCode();
		//imageStream = SecurityCode.getImageAsInputStream(securityCode);
		imageStream = new MyVerifyCode().getVerifyCodeImage();
		// 放入session中
		//session.put("securityCode", securityCode);
		return SUCCESS;
	}

}
