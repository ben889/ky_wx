package com.framework.service.impl;

import org.springframework.stereotype.Service;

import com.framework.domain.Tabs;
import com.framework.service.ITabService;
/**
 *	标签Service
 */
@Service(ITabService.SERVICE_NAME)
public class TabService extends CommonService<Tabs> implements ITabService {

}
