package com.framework.dao.impl;

import org.springframework.stereotype.Repository;

import com.framework.dao.IRoleDao;
import com.framework.domain.Roles;
/**
 * 角色 DaoImpl
 */
@Repository(IRoleDao.DAO_NAME)
public class RoleDaoImpl extends CommonDaoImpl<Roles> implements IRoleDao {

}
