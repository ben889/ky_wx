package com.framework.dao.impl;

import org.springframework.stereotype.Repository;

import com.framework.dao.IUserDao;
import com.framework.domain.Users;
/**
 * 用户 DaoImpl
 */
@Repository(IUserDao.DAO_NAME)
public class UserDaoImpl extends CommonDaoImpl<Users> implements IUserDao {

}
