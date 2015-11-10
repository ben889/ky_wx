package com.framework.dao;

import com.framework.domain.Users;
/** 
 * 用户Dao接口
 */
public interface IUserDao extends ICommonDao<Users> {
	public static final String DAO_NAME = "com.framework.dao.impl.UserDaoImpl";
}
