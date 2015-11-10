package com.framework.dao.impl;

import org.springframework.stereotype.Repository;

import com.framework.dao.ITabpermissionDao;
import com.framework.domain.Tabpermission;

/**
 * 权限 DaoImpl
 */
@Repository(ITabpermissionDao.DAO_NAME)
public class TabpermissionDaoImpl extends CommonDaoImpl<Tabpermission> implements ITabpermissionDao {
	
}
