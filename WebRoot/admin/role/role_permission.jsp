<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>角色权限</title>
<link rel="stylesheet" href="<%=basePath%>admin/css/style.css"
	type="text/css"></link>
<script type="text/javascript" src="<%=basePath%>admin/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>admin/js/common.js"></script>
</head>
<body>
	<div class="main">
		<div class="header header_content">
			<table border="0" cellpadding="2" cellspacing="0" width="100%"
				align="center">
				<tbody>
					<tr>
						<td align="left">
							<h2>
								<span style="color:red;">站点管理员</span> 权限设置
							</h2></td>
						<td align="right"></td>
					</tr>
				</tbody>
			</table>
		</div>



		<div style="margin-top: 4px; border-bottom: 1px solid #cccccc;">

			<table border="0" cellspacing="1" cellpadding="2"
				class="DataGrid_Table" width="100%" align="center">
				<tr class="DataGrid_Header">
					<td align="center" width="60"><input type="checkbox"
						name="selectall" id="selectall">全选</td>
					<td align="center"><b>菜单</b>
					</td>
					<td align="center"><b>选择</b>
					</td>
				</tr>
				<s:if test="#request['tabs'] != null">
					<s:iterator value="#request['tabs']" id="tabs">
						<tr onmouseover="this.className='DataGrid_SelectedItem'"
							onmouseout="this.className='DataGrid_Item'" class="DataGrid_Item"
							name="tr0" subname="1">
							<td><label> <input type="checkbox"
									name="selectallsub" id="selectallsub1"
									onclick="selectsub('<s:property value="#tabs.tabid" />');">全选
							</label>
							</td>
							<td align="left" style="padding-left: 12px;">
								<div style="float: left; padding-left: 10px;">&nbsp;</div>
								<div style="float: left; padding-left: 10px;">
									├
									<s:property value="#tabs.tabname" />
									<input type="hidden" name="rpTabslist$ctl01$hfTabID"
										id="rpTabslist_ctl01_hfTabID" value="1">
								</div>

								<div style="clear: both;"></div>
							</td>
							<td align="left" style="text-align: left;" id="td1">
								<div>
									<label><input type="checkbox" name="PermissionBox"
										id="Permission1" value="1|1">查看</label>
									<div style="clear: both;"></div>
								</div>
							</td>
						</tr>
					</s:iterator>
				</s:if>
			</table>
		</div>
	</div>

</body>
</html>