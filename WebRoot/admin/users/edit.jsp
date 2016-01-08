<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加帐号</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- base style -->
<link rel="stylesheet" href="<%=basePath%>admin/css/style.css"
	type="text/css"></link>
<script type="text/javascript" src="<%=basePath%>admin/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>admin/js/common.js"></script>
<!-- /base style -->

<!-- 提示框 -->
<link rel="stylesheet"
	href="<%=basePath%>admin/js/dialog/css/dialog.css" type="text/css"></link>
<script type="text/javascript"
	src="<%=basePath%>admin/js/dialog/js/dialog.js"></script>
<!-- /提示框 -->

<script type="text/javascript">
	$(function() {
		tabs();
	});
</script>
</head>

<body>
	<div class="main">
		<!--导航栏-->
		<div class="header header_content">
			<h2>编辑用户信息</h2>
		</div>
		<!--/导航栏-->
		<div class="content-form">

			<!-- 选项卡 -->
			<div class="content-tab-wrap">
				<div id="floatHead" class="content-tab">
					<div class="content-tab-ul-wrap" id="tab_menu">
						<ul>
							<li><a href="javascript:;" class="selected">帐号信息</a></li>
							<li><a href="javascript:;">修改密码</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- 选项卡内容 -->
			<div id="tab_box" >
				<form id="form1" name="form1" method="post" action="user_save"
					target="hd">
					<!-- 第一个选项卡 -->
					<div class="tab-content">
						<s:iterator value="#request['user']" id="user" />
						<table cellspacing="1" cellpadding="2" border="0"
							class="formtable">
							<tr>
								<td width="100" align="left">帐号：</td>
								<td align="left"><input name="user.username" type="text"
									id="username" value="<s:property value="#user.username" />"
									class="textbox">
								</td>
							</tr>
							<tr>
								<td align="left">密码：</td>
								<td align="left"><input name="user.password"
									type="password" id="password" class="textbox"
									value='<s:property value="#user.password"/>'>
								</td>
							</tr>
							<tr>
								<td align="left">确认密码：</td>
								<td align="left"><input name="pass2" type="password"
									id="pass2" class="textbox"
									value='<s:property value="#user.password"/>'>
								</td>
							</tr>
							<tr>
								<td align="left">显示名称：</td>
								<td align="left"><input name="user.displayname" type="text"
									id="displayname"
									value='<s:property value="#user.displayname"/>' class="textbox">
								</td>
							</tr>
							<tr>
								<td align="left">Email：</td>
								<td align="left"><input name="user.email" type="text"
									id="email" class="textbox"
									value='<s:property value="#user.email"/>'>
								</td>
							</tr>
							<tr>
								<td align="left">锁定：</td>
								<td align="left"><input type="checkbox" name="locked"
									id="locked"
									<s:if test="#user.locked == 1">
									checked="checked"
								</s:if> />
									<label for="locked">是</label>
								</td>
							</tr>
						</table>
					</div>
				</form>
				<!-- 第二个选项卡 -->
				<div class="tab-content" style="display: none;">22222222222</div>
				<!-- 第三个选项卡 -->
			</div>

			<!--工具栏-->
			<div class="page-footer">
				<div class="btn-list">
					<input type="button" id="btnsave" class="button save" value="保存"
						onclick="save('form1');" /> <input type="button" name="btnReturn"
						class="button cancel" value="返回上一页" onclick="back('user_list');" />
				</div>
				<div class="clear"></div>
			</div>
			<!--/工具栏-->
		</div>
		<iframe name="hd" style="display: none;"></iframe>
	</div>
</body>
</html>
