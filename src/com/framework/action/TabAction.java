package com.framework.action;

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
 *	标签Action
 */
@Controller("tabAction")
public class TabAction extends CommonAction<Tabs> {
	private static final long serialVersionUID = 1L;
	
	//TabService
	@Resource(name = ITabService.SERVICE_NAME)
	private ITabService tabService;
	
	private Tabs tab;
	private int tabid;
	
	
	//分页查找
	@SuppressWarnings("unchecked")
	public String list(){
		try{
			Map<String, Object> mapRequest = (Map<String, Object>) ActionContext.getContext().get("request");
			PageInfo pageInfo = new PageInfo(request);
			String condition = "1=1"; // 条件
			String[] params = {}; // 参数
			Map<String, String> orderby = new HashMap<String,String>(); // 排序
			List<Tabs> tabList = tabService.find(condition, params, orderby, pageInfo);
			mapRequest.put("tabList", tabList);
			mapRequest.put("page", pageInfo);
			return "list";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/** 返回第一级别的菜单 **/
	public void getMenuJson() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		try{
			String condition = "o.parentid=?"; // 条件
			Object[] params = {0}; // 参数
			Map<String, String> orderby = new HashMap<String,String>(); // 排序
			orderby.put("o.orderby", "desc");
			List<Tabs> tabs = tabService.find(-1, -1, condition, params, orderby);
			if(tabs != null && tabs.size() > 0){
				for(Tabs t : tabs){
					sb.append("{\"url\":\"" + t.getTaburl() + "\",\"id\":\"" + t.getTabid() + "\",\"name\":\"" + t.getTabname() + "\",\"submenu\":[]},");
				}
				if(sb.toString().endsWith(",")){
					sb.deleteCharAt(sb.length()-1);
				}
			}
			sb.append("]");
			response.getWriter().write(sb.toString());
		}catch(Exception e){
			e.printStackTrace();
			response.getWriter().write("[]");
		}finally{
			response.getWriter().close();
		}
	}
	
	
	//保存
	public String save(){
		try{
			
			tabService.save(tab);
			return "save";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//删除
	public String delete(){
		try{
			tabService.delete(tabid);
			return "delete";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//返回一个实体
	public String bind(){
		try{
			if(tabid <= 0){
				return null;
			}
			tab = tabService.find(tabid);
			if(tab == null){
				return null;
			}
			Map<String,Object> mapRequest = (Map<String, Object>) ActionContext.getContext().get("request");
			mapRequest.put("tab", tab);
			return "bind";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
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
