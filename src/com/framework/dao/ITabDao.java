package com.framework.dao;

import com.framework.domain.Tabs;
/**
 * 标签DAO接口
 * @createTime 2015年5月29日
 */
public interface ITabDao extends ICommonDao<Tabs> {
	public static final String DAO_NAME = "com.framework.dao.impl.TabDaoImpl";
}
