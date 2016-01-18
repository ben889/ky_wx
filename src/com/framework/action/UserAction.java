package com.framework.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.framework.domain.Users;
import com.framework.service.IUserService;
import com.framework.utils.CommFun;
import com.framework.utils.pagination.PageInfo;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户Action
 */
// @Scope("prototype")
@Controller("userAction")
public class UserAction extends BaseAction<Users> {
	private static final long serialVersionUID = 1L;

	// 用户service
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
			Map<String, Object> mapRequest = (Map<String, Object>) ActionContext
					.getContext().get("request");
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
			int _userid = request.getParameter("userid") != null ? Integer
					.parseInt(request.getParameter("userid").trim()) : 0;
			setUserid(_userid);
			if (userid > 0) {
				user = service.find(userid);
				Map<String, Users> request = (Map<String, Users>) ActionContext
						.getContext().get("request");
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
		String password2 = request.getParameter("pass2");
		try {

			if (password2 == null || password2.trim().length() == 0) {
				response.getWriter().write(
						"<script>parent.fail('请确认密码');</script>");
				this.addActionError("请确认密码");
				return "success";
			}
			if (!password2.equals(user.getPassword())) {
				response.getWriter().write(
						"<script>parent.fail('密码不一至');</script>");
				this.addActionError("密码不一至");
				return "success";
			}

			String locked = request.getParameter("locked"); // 是否锁定
			if (locked == null || locked.equals("off")) {
				user.setLocked(false);
			} else if (locked.equals("on")) {
				user.setLocked(true);
			}
			// 如果用户 id>0 执行更新方法
			if (userid > 0) {
				user.setLasttime(new Date()); // 最后操作时间
				service.update(user); // 更新
			} else {

				user.setCreatetime(new Date()); // 创建时间
				user.setLasttime(new Date()); // 最后操作时间
				service.save(user); // 添加
			}
			response.getWriter()
					.write("<script>parent.success('保存成功');parent.location.href='admin/user_list';</script>");
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
	public void delete() throws IOException {
		try {
			userid = request.getParameter("userid") != null ? Integer
					.parseInt(request.getParameter("userid").trim()) : 0;
			if (userid > 0) {
				service.delete(userid); // 删除
				response.getWriter()
						.write("<script>alert('删除成功');location.href='admin/user_list';</script>");
				return;
			}
		} catch (Exception e) {
			response.getWriter()
					.write("<script>alert('删除失败');location.href='admin/user_list';</script>");
			return;
		} finally {
			response.getWriter().close();
		}
	}

	/**
	 * 更新
	 */
	public void update() throws IOException {
		try {
			userid = request.getParameter("userid") != null ? Integer
					.parseInt(request.getParameter("userid").trim()) : 0;
			if (userid <= 0) {
				response.getWriter()
						.write("<script>alert('操作失败，ID有误');location.href='admin/user_list';</script>");
				return;
			}
			String locked = request.getParameter("locked") != null ? request
					.getParameter("locked").toString() : "off";
			Users user = service.find(userid);
			if (user == null) {
				response.getWriter()
						.write("<script>alert('操作失败，ID有误');location.href='admin/user_list';</script>");
				return;
			}
			boolean isLocked = "on".equals(locked) ? true : false;
			user.setLocked(isLocked);
			user.setLasttime(new Date());
			service.update(user); // 更新
			response.getWriter()
					.write("<script>alert('更新成功');location.href='admin/user_list';</script>");
		} catch (Exception e) {
			response.getWriter()
					.write("<script>alert('更新失败');location.href='admin/user_list';</script>");
			return;
		} finally {
			response.getWriter().close();
		}
	}

	public void login() throws IOException {
		try {
			String username = CommFun.ObjectToStr(request
					.getParameter("username"));
			String password = CommFun.ObjectToStr(request
					.getParameter("password"));
			String checkcode = CommFun.ObjectToStr(request
					.getParameter("checkcode"));
			if (username.trim().length() <= 0) {
				response.getWriter().write("请输入帐号");
				return;
			}
			if (password.trim().length() <= 0) {
				response.getWriter().write("请输入密码");
				return;
			}
			if (checkcode.trim().length() <= 0) {
				response.getWriter().write("请输入验证码");
				return;
			}
			List<Users> getlist = service.find(0, 1,
					"username=? and password=?", new Object[] { username, password }, null);
			if (getlist == null || getlist.size() == 0) {
				response.getWriter().write("帐号/密码错误");
				return;
			}
			Users user = getlist.get(0);
			if (user.getUserid() <= 0) {
				response.getWriter().write("帐号/密码错误");
				return;
			}
			if (user.getLocked() != null && user.getLocked()) {
				response.getWriter().write("帐号已被锁定");
				return;
			}
			if (user.getDeleted() != null && user.getDeleted()) {
				response.getWriter().write("帐号已被删除");
				return;
			}
			response.getWriter().write("1");
		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
			return;
		} finally {
			response.getWriter().close();
		}
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
