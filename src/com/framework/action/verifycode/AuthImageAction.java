package com.framework.action.verifycode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.framework.utils.verifycode.VerificationCodeUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AuthImageAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}

	public void setServletResponse(HttpServletResponse res) {
		this.response = res;
	}

	public String getAuthImage() {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 生成随机字串

		return "success";
	}

	private ByteArrayInputStream inputStream;

	public String getRandomPictrue() throws IOException {
		VerificationCodeUtil vcu = VerificationCodeUtil.Instance();
		return SUCCESS;
	}
}
