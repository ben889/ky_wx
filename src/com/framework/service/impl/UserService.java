package com.framework.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.framework.domain.Users;
import com.framework.service.IUserService;

/**
 * 用户Service
 */
@Service(IUserService.SERVICE_NAME)
public class UserService extends CommonService<Users> implements IUserService {
	public void init() {
		System.out.println("=======UserService.init()========");
		Date date = new Date();
		Timestamp createtime = new Timestamp(date.getTime());
		List<Users> list = new ArrayList<Users>();
		Users info = new Users("host", "h1234!@#$", "host", "", 0, "host",
				0, 0, 0, createtime, "", createtime);
		list.add(info);
		info = new Users("admin", "h1234!@#$", "admin", "", 0, "host",
				0, 0, 0, createtime, "", createtime);
		list.add(info);
		save(list);
	}
}
