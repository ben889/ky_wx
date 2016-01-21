package com.framework.servlet;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.framework.dao.impl.Db;
import com.framework.domain.Users;
import com.framework.service.IUserService;
import com.framework.utils.MD5;

public class MyServletContextListener implements ServletContextListener {
	private IUserService service;

	public IUserService getService() {
		return service;
	}

	public void setService(IUserService service) {
		this.service = service;
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		//new UserService().init();
		// service.init();
		System.out.println("=======数据初始化＝＝＝＝＝＝＝＝＝UserService.init()========");
		Date date = new Date();
		Timestamp createtime = new Timestamp(date.getTime());

		new MD5();
		String password = MD5.GetMD5Code("h1234!@#$");
		Users info = new Users("host", password, "host", "", 0, "host", 0, 0,
				0, createtime, "", createtime);
		try {
			Boolean b = new Db().isExists(info, "username='host'");
			if (!b) {
				new Db().insert(info, "userid", true);
			}
			info = new Users("admin", password, "admin", "", 0, "admin", 0, 0,
					0, createtime, "", createtime);
			b = new Db().isExists(info, "username='admin'");
			if (!b) {
				new Db().insert(info, "userid", true);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
