package com.framework.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.framework.domain.Tabs;
import com.framework.service.ITabService;
import com.framework.utils.pagination.PageInfo;
import com.opensymphony.xwork2.ActionContext;

/**
 * 标签Action
 */
@Controller("tabAction")
public class TabAction extends CommonAction<Tabs> {
	private static final long serialVersionUID = 1L;

	public TabAction() {
		System.out.println("=======TabAction========");
	}

	// TabService
	@Resource(name = ITabService.SERVICE_NAME)
	private ITabService tabService;

	private Tabs tab;
	private int tabid;

	// 分页查找
	@SuppressWarnings("unchecked")
	public String list() {
		try {
			Map<String, Object> mapRequest = (Map<String, Object>) ActionContext
					.getContext().get("request");
			PageInfo pageInfo = new PageInfo(request);
			String condition = "1=1"; // 条件
			String[] params = {}; // 参数
			Map<String, String> orderby = new HashMap<String, String>(); // 排序
			List<Tabs> tabList = tabService.find(condition, params, orderby,
					pageInfo);
			mapRequest.put("tabList", tabList);
			mapRequest.put("page", pageInfo);
			return "list";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/** 一级菜单 **/
	public void getMenuJson() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		try {
			String condition = "o.parentid=?"; // 条件
			Object[] params = { 0 }; // 参数
			Map<String, String> orderby = new HashMap<String, String>(); // 排序
			orderby.put("o.orderby", "asc");
			List<Tabs> tabs = tabService
					.find(0, -1, condition, params, orderby);
			if (tabs != null && tabs.size() > 0) {
				for (Tabs t : tabs) {
					sb.append("{\"url\":\"" + t.getTaburl() + "\",\"id\":\""
							+ t.getTabid() + "\",\"name\":\"" + t.getTabname()
							+ "\",\"submenu\":[]},");
				}
			}
			sb.append("{\"url\":\"\",\"id\":\"admin\",\"name\":\"admin\",\"submenu\":[]},");
			sb.append("{\"url\":\"\",\"id\":\"host\",\"name\":\"host\",\"submenu\":[]},");

			if (sb.toString().endsWith(",")) {
				sb.deleteCharAt(sb.length() - 1);
			}

			sb.append("]");
			response.getWriter().write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("[]");
		} finally {
			response.getWriter().close();
		}
	}

	/** 获取子级菜单 **/
	public void getSubMenuJson() throws Exception {
		try {
			String result = "[]";
			sb1 = new StringBuilder();
			int pid = 0;
			String parentidstr = request.getParameter("pid");
			if (parentidstr.toLowerCase().equals("host")) {
				sb1.append("[{");
				sb1.append("\"id\":\"init\",");
				sb1.append("\"name\":\"刷新基础数据\",");
				sb1.append("\"url\":\"console/init.jsp\",");
				sb1.append("\"submenu\":[]");
				sb1.append("},");
				sb1.append("{");
				sb1.append("\"id\":\"execsql\",");
				sb1.append("\"name\":\"执行脚本\",");
				sb1.append("\"url\":\"SQL/execSQL.jsp\",");
				sb1.append("\"submenu\":[]");
				sb1.append("}]");

				result = sb1.toString();

			} else if (parentidstr.toLowerCase().equals("admin")) {
				sb1.append("[{");
				sb1.append("\"id\":\"users\",");
				sb1.append("\"name\":\"帐号\",");
				sb1.append("\"url\":\"user_list\",");
				sb1.append("\"submenu\":[]");
				sb1.append("},");
				sb1.append("{");
				sb1.append("\"id\":\"roles\",");
				sb1.append("\"name\":\"角色\",");
				sb1.append("\"url\":\"role/role_list\",");
				sb1.append("\"submenu\":[]");
				sb1.append("}]");
				result = sb1.toString();
			} else {
				pid = Integer.parseInt(parentidstr);
				result = getListMenu(pid);
			}

			response.getWriter().write(result);
		} catch (Exception e) {
			response.getWriter().write("[]");
		} finally {
			response.getWriter().close();
		}
	}

	StringBuilder sb1;

	/** 递归子级菜单 **/
	private String getListMenu(int parentid) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			if (parentid > 0) {
				Map<String, String> orderby = new HashMap<String, String>(); // 排序
				orderby.put("o.orderby", "asc");
				List<Tabs> list = tabService.find(0, -1, "parentid=?",
						new Object[] { parentid }, orderby);
				if (list != null && list.size() > 0) {
					for (Tabs info : list) {
						sb.append("{");
						sb.append("\"id\":\"" + info.getTabid() + "\",");
						sb.append("\"name\":\"" + info.getTabname() + "\",");
						sb.append("\"url\":\"" + info.getTaburl() + "\",");
						sb.append("\"submenu\":" + getListMenu(info.getTabid()));
						sb.append("},");
					}
				}
			}

			if (sb.toString().endsWith(",")) {
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.append("]");
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "[]";
	}

	// 保存
	public String save() {
		try {
			tabService.save(tab);
			return "save";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	// 删除
	public String delete() {
		try {
			tabService.delete(tabid);
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	// 返回一个实体
	public String bind() {
		try {
			if (tabid <= 0) {
				return null;
			}
			tab = tabService.find(tabid);
			if (tab == null) {
				return null;
			}
			Map<String, Object> mapRequest = (Map<String, Object>) ActionContext
					.getContext().get("request");
			mapRequest.put("tab", tab);
			return "bind";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	// ==================重新初始化
	public void init() throws IOException {
		try {
			tabService.delete("");
			List<Tabs> tabs = new ArrayList<Tabs>();
			Tabs info = new Tabs(1, "内容发布", "", 0, 1, 99, "", true, "all");
			tabs.add(info);
			info = new Tabs(11, "文章", "article/article", 1, 2, 99, "", true,
					"article");
			tabs.add(info);
			info = new Tabs(2, "会员", "", 0, 1, 99, "", true, "member");
			tabs.add(info);
			info = new Tabs(22, "会员列表", "member/member", 2, 2, 99, "", true,
					"member");
			tabs.add(info);
			tabService.save(tabs);
			response.getWriter().write(
					"<script>parent.success('执行完毕');</script>");
		} catch (Exception e) {
			response.getWriter().write(
					"<script>parent.fail('"
							+ e.getMessage().replace("'", "").replace("\n", "")
									.replace("\r", "") + "');</script>");
			this.addActionError(e.getMessage());
			e.printStackTrace();
		}
	}

	// =============================

	/*------get set------*/
	public Tabs getTab() {
		return tab;
	}

	public void setTab(Tabs tab) {
		this.tab = tab;
	}

	public ITabService getTabService() {
		return tabService;
	}

	public void setTabService(ITabService tabService) {
		this.tabService = tabService;
	}

	public int getTabid() {
		return tabid;
	}

	public void setTabid(int tabid) {
		this.tabid = tabid;
	}

}
