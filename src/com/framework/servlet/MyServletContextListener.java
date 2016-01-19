package com.framework.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.framework.dao.impl.Db;
import com.framework.domain.Users;
import com.framework.service.IUserService;
import com.framework.service.impl.UserService;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;

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
		// new UserService().init();
		// service.init();

		Date date = new Date();
		Timestamp createtime = new Timestamp(date.getTime());
		Users info = new Users("host", "h1234!@#$", "host", "", 0, "host",
				0, 0, 0, createtime, "", createtime);
		try {
			new Db().insert(info, "userid", true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void user_init() throws Exception {
		Date date = new Date();
		Timestamp createtime = new Timestamp(date.getTime());
		Connection conn = null;
		String sql;
		// MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
		// 避免中文乱码要指定useUnicode和characterEncoding
		// 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
		// 下面语句之前就要先创建javademo数据库
		String url = "jdbc:mysql://localhost:3306/myframe?user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
		try {
			// 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
			// 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
			// or:
			// com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			// or：
			// new com.mysql.jdbc.Driver();

			System.out.println("成功加载MySQL驱动程序");
			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			Statement stmt = conn.createStatement();
			// int result = stmt.executeUpdate(sql);//
			// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
			System.out.println("创建数据表成功");
			sql = "INSERT INTO `users`(`username`,`password`,`displayname`,`email`,`status`,`usertype`,`deleted`,`locked`,`createuserid`,`createtime`,`description`,`lasttime`)"
					+ "VALUES('username','password','displayname','email',0,'usertype',1,0,0,'"
					+ createtime + "','description','" + createtime + "');";
			int result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

}
