package com.framework.dao.impl;

import org.springframework.stereotype.Repository;

import com.framework.dao.ITabDao;
import com.framework.domain.Tabs;

/**
 * 标签 DaoImpl
 */
@Repository(ITabDao.DAO_NAME)
public class TabDaoImpl extends CommonDaoImpl<Tabs> implements ITabDao {
}
