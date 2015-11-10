package com.framework.service;

import com.framework.dao.ICommonDao;

public interface ICommonService<T> extends ICommonDao<T> {
	public static final String SERVICE_NAME = "com.framework.service.impl.CommonService";
	
}
