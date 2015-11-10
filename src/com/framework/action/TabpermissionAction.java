package com.framework.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.framework.domain.Tabpermission;
import com.framework.service.ITabpermissionService;
/**
 *	权限Action
 */
@Controller("tabpermissionAction")
public class TabpermissionAction extends BaseAction<Tabpermission> {
	private static final long serialVersionUID = 1L;
	
	// TabpermissionService
	@Resource(name=ITabpermissionService.SERVICE_NAME)
	private ITabpermissionService tabpermissionService;
	
	private Tabpermission tabpermission;
	private int tabpermissionid;
	
	
	/*----get set----*/
	public ITabpermissionService getTabpermissionService() {
		return tabpermissionService;
	}
	public void setTabpermissionService(ITabpermissionService tabpermissionService) {
		this.tabpermissionService = tabpermissionService;
	}
	public Tabpermission getTabpermission() {
		return tabpermission;
	}
	public void setTabpermission(Tabpermission tabpermission) {
		this.tabpermission = tabpermission;
	}
	public int getTabpermissionid() {
		return tabpermissionid;
	}
	public void setTabpermissionid(int tabpermissionid) {
		this.tabpermissionid = tabpermissionid;
	}
	
}
