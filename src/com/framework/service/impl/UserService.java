package com.framework.service.impl;

import org.springframework.stereotype.Service;

import com.framework.domain.Users;
import com.framework.service.IUserService;
/**
 *	用户Service
 */
@Service(IUserService.SERVICE_NAME)
public class UserService extends CommonService<Users> implements IUserService {

}
