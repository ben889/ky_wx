package com.framework.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.framework.domain.Roles;
import com.framework.service.IRoleService;
import com.opensymphony.xwork2.ActionContext;
/**	
 * 角色Action
 */
@Controller("roleAction")
public class RoleAction extends BaseAction<Roles> {
	private static final long serialVersionUID = 1L;
	// 角色Service
	@Resource(name = IRoleService.SERVICE_NAME)
	private IRoleService roleService;
	
	private Roles role;
	private int roleid;
	
	/**	查找	 **/
	public String list(){
		try{
			Map<String, Object> mapRequest = (Map<String, Object>) ActionContext.getContext().get("request");
			int start = -1;
			int end=-1;
			String condition = "";
			Object[] params = {};
			Map<String, String> orderby = new HashMap<String, String>();
			orderby.put("roleid", "");
			
			List<Roles> roles = roleService.find(start, end, condition,params, orderby);
			mapRequest.put("roles", roles);
			return "list"; // 跳转到列表页面
		}catch(Exception e){
			return ERROR;
		}
	}
	
	/** 编辑(添加、修改) **/
	@SuppressWarnings("all")
	public String edit(){
		try{
			roleid = 0;
			role = new Roles();
			roleid = request.getParameter("roleid") != null ? Integer.parseInt(request.getParameter("roleid").trim()) : 0;
			if(roleid > 0){ // 修改
				Map<String, Object> mapRequest = (Map<String, Object>) ActionContext.getContext().get("request");
			    role = roleService.find(roleid);
		    	mapRequest.put("role", role);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "edit";
	}
	
	/** 保存 (添加、修改)**/
	public void save() throws Exception{
		//获取路径
		String resultMsg="";
		try{
			roleid = request.getParameter("roleid") != null ? Integer.parseInt(request.getParameter("roleid").trim()) : 0;
			if(roleid == 0){
				role.setCreatedtime(new Date()); // 设置创建时间
				roleService.save(role); //添加
			}else if(roleid > 0){
				roleService.update(role);//修改
			}
			resultMsg = "<script>parent.success(\"保存成功\");parent.back('role_list');</script>";
		}catch(Exception e){
			resultMsg = "<script>parent.fail(\"保存失败!\");</script>";
		}finally{
			response.getWriter().write(resultMsg);
			response.getWriter().close();
		}
	}
	
	/** 删除 **/
	public void delete() throws Exception{
			String resultMsg="";
		try{
			roleid = request.getParameter("roleid") != null ? Integer.parseInt(request.getParameter("roleid").trim()) : 0;
			roleService.delete(roleid);
			resultMsg = "<script>alert(\"删除成功\");location.href='admin/role_list';</script>";
		}catch(Exception e){
			resultMsg = "<script>alert(\"删除失败!\");</script>";
		}finally{
			response.getWriter().write(resultMsg);
			response.getWriter().close();
		}
	}
	
	//=================get set========================
	public IRoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
}
