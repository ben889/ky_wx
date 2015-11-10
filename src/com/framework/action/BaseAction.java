package com.framework.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.framework.utils.TUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>, ServletRequestAware, ServletResponseAware {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	T entity;
	
	public T getModel() {
		return entity;
	}

	// 获取子类传递父类的泛型真实对象
	public BaseAction() {
		// 泛型转换（获取子类传递的真实的参数类型，并进行实例化）
		Class entityClass = TUtils.getActualType(this.getClass());
		// 实例化
		try {
			entity = (T) entityClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}

	public void setServletResponse(HttpServletResponse res) {
		this.response = res;
	}

}
