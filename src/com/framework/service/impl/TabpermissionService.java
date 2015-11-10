package com.framework.service.impl;

import org.springframework.stereotype.Service;

import com.framework.domain.Tabpermission;
import com.framework.service.ITabpermissionService;
/**
 * 权限Service
 */
@Service(ITabpermissionService.SERVICE_NAME)
public class TabpermissionService extends CommonService<Tabpermission> implements ITabpermissionService {

}
