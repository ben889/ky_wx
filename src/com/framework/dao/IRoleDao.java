package com.framework.dao;

import com.framework.domain.Roles;
/**
 *	角色Dao接口
 */
public interface IRoleDao extends ICommonDao<Roles> {
	public static final String DAO_NAME = "com.framework.dao.impl.RoleDaoImpl";
}
