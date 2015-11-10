package com.framework.service.impl;

import org.springframework.stereotype.Service;

import com.framework.domain.Roles;
import com.framework.service.IRoleService;
/**
 *	角色Service
 */
@Service(IRoleService.SERVICE_NAME)
public class RoleService extends CommonService<Roles> implements IRoleService {
	
}
