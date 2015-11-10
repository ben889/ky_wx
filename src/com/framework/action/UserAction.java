package com.framework.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.framework.domain.Users;
import com.framework.service.IUserService;
import com.framework.utils.pagination.PageInfo;
import com.opensymphony.xwork2.ActionContext;
/**
 *	用户Action
 */
//@Scope(value = "prototype")
@Controller("userAction")
public class UserAction extends BaseAction<Users> {
	private static final long serialVersionUID = 1L;

	//用户service
	@Resource(name = IUserService.SERVICE_NAME)
	private IUserService service;
	
	private Users user;
	private int userid;
		

	@Override
	public String execute() throws Exception {
		userid = 0;
		bind();
		return SUCCESS;
	}

	/**
	 * 查询全部信息
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String list() {
		try {
			String condition = "1=1";
			PageInfo pageInfo = new PageInfo(request);
			Map<String, Object> mapRequest = (Map<String, Object>) ActionContext.getContext().get("request");
			List list = service.find(condition, null, "", pageInfo);
			mapRequest.put("list", list);
			mapRequest.put("page", pageInfo);
			return "list";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 获取一个实体类
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String bind() {
		try {
			userid = request.getParameter("userid") != null ? Integer.parseInt(request.getParameter("userid").trim()) : 0;
			if (userid > 0) {
				user = service.find(userid);
				Map<String, Users> request = (Map<String, Users>) ActionContext.getContext().get("request");
				request.put("user", user);
				return "bind";
			} else {
				user = new Users();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 保存
	 * 
	 */
	public String save() throws IOException {
		String password2 = request.getParameter("password2") != null ? request.getParameter("password2").toString() : "";
		try {
			String locked = request.getParameter("locked"); // 是否锁定
			if (locked == null || locked.equals("off")) {
				user.setLocked(false);
			} else if (locked.equals("on")) {
				user.setLocked(true);
			}
			//如果用户 id>0 执行更新方法
			if (userid > 0) {
				user.setLasttime(new Date()); // 最后操作时间
				service.update(user); // 更新
			} else {
				if (password2 == null || password2.trim().length() == 0) {
					response.getWriter().write("<script>parent.fail('请确认密码');</script>");
					this.addActionError("请确认密码");
					return "success";
				}
				if (!password2.equals(user.getPassword())) {
					response.getWriter().write("<script>parent.fail('密码不一至');</script>");
					this.addActionError("密码不一至");
					return "success";
				}
				user.setCreatetime(new Date()); // 创建时间
				user.setLasttime(new Date()); // 最后操作时间
				service.save(user); // 添加
			}
			response.getWriter().write("<script>parent.success('保存成功');parent.back('user_list');</script>");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("<script>parent.fail('添加失败');</script>");
		} finally {
			response.getWriter().close();
		}
		return null;
	}

	/**
	 * 删除
	 */
	public String delete() throws IOException {
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("<script>function fails(info){alert(info);}</script>");
		response.getWriter().write("<script>function success(info){if (info!='') alert(info);location.href='"+basePath+"admin/user_list';}</script>");
		try {
			userid = request.getParameter("userid") != null ? Integer.parseInt(request.getParameter("userid").trim()) : 0;
			if (userid > 0) {
				service.delete(userid); // 删除
				response.getWriter().write("<script>fails('删除成功');location.href='"+basePath+"admin/user_list';</script>");
				return null;
			}
		} catch (Exception e) {
			response.getWriter().write("<script>fails('删除失败');location.href='"+basePath+"admin/user_list';</script>");
			return null;
		} finally {
			response.getWriter().close();
		}
		return null;
	}

	/**
	 * 更新
	 */
	public String update() throws IOException {
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
		try {
			userid = request.getParameter("userid") != null ? Integer.parseInt(request.getParameter("userid").trim()) : 0;
			String locked = request.getParameter("locked") != null ? request.getParameter("locked").toString() : "off";
			Users user = service.find(userid);
			if(user == null){
				response.getWriter().write("<script>alert('操作失败，ID有误');location.href='"+basePath+"admin/user_list';</script>");
				return null;
			}
			boolean isLocked = "on".equals(locked) ? true : false;
			user.setLocked(isLocked);
			user.setLasttime(new Date());
			service.update(user); //更新
		} catch (Exception e) {
			response.getWriter().write("<script>alert('操作失败');location.href='"+basePath+"admin/user_list';</script>");
			return null;
		}finally{
			response.getWriter().close();
		}
		return "update";
	}
	
	/** ---------------------- get set ------------------------- **/
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public IUserService getService() {
		return service;
	}

	public void setService(IUserService service) {
		this.service = service;
	}


}
