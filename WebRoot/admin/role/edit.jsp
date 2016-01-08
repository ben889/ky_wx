<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>角色编辑</title>
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

<!-- dialog -->
<link rel="stylesheet"
	href="<%=basePath%>admin/js/dialog/css/dialog.css" type="text/css"></link>
<script type="text/javascript"
	src="<%=basePath%>admin/js/dialog/js/dialog.js"></script>
<!-- /dialog -->

<!-- KindEditor -->
<link rel="stylesheet"
	href="<%=basePath%>kingeditor/themes/default/default.css"
	type="text/css" />
<script type="text/javascript"
	src="<%=basePath%>kingeditor/kindeditor-all-min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>kingeditor/lang/zh-CN.js"></script>
<!-- /KindEditor -->

<script type="text/javascript">
	$(function(){
		tabs(); // 选项卡
		initKingEditor();//初始化kingeditor
	});
	
	function initKingEditor(){
		KindEditor.ready(function(K) {
				var editor = K.editor({
					allowImageUpload: true,
					allowFileManager : true,
					uploadJson : "<%=basePath%>kingeditor/jsp/upload_json.jsp", // 文件上传处理URL
					fileManagerJson : "<%=basePath%>
	kingeditor/jsp/file_manager_json.jsp" // 文件管理处理URL
							});
					//图片上传
					$("#uploadimage").click(
							function() {
								editor.loadPlugin("image", function() {
									editor.plugin.imageDialog({
										imageUrl : $("#icon").val(),
										clickFn : function(url, title, width,
												height, border, align) {
											$("#icon").val(url);
											editor.hideDialog();
										}
									});
								});
							});
				});
	}
</script>
</head>

<body>
	<div class="main">
		<!--导航栏-->
		<div class="header header_content">
			<h2>编辑角色信息</h2>
		</div>
		<!--/导航栏-->
		<div class="content-form">
			<form id="form1" name="form1" method="post"
				action="<%=basePath%>admin/role_save" target="hd">
				<!-- 选项卡 -->
				<div class="content-tab-wrap">
					<div id="floatHead" class="content-tab">
						<div class="content-tab-ul-wrap" id="tab_menu">
							<ul>
								<li><a href="javascript:;" class="selected">基本信息</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- 选项卡内容 -->
				<div id="tab_box">
					<!-- 第一个选项卡 -->
					<div class="tab-content">
						<s:iterator value="#request['role']" id="role" />
						<table cellspacing="1" cellpadding="2" border="0"
							class="formtable">
							<tr>
								<td width="100" align="left">名称：</td>
								<td align="left"><input type="text" name="role.rolename"
									class="textbox" value="<s:property value='#role.rolename' />" />
								</td>
							</tr>
							<tr>
								<td align="left">图标：</td>
								<td align="left">
									<div class="file-box">
										<input type="text" name="role.icon" id="icon" class="textbox"
											style="width: 200px;" readonly="readonly" value=""> <input
											type="button" id="uploadimage" class="button" value="浏览...">
										建议尺寸:50*50px
									</div>
								</td>
							</tr>
							<tr>
								<td align="left">描述：</td>
								<td align="left"><textarea name="role.description"
										style="height:80px;width:600px;" class="textarea">
									<s:property value="#role.description" />
								</textarea>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<!--工具栏-->
				<div class="page-footer">
					<div class="btn-list">
						<input type="button" id="btnsave" class="button save" value="保存"
							onclick="save('form1');" /> <input type="button"
							name="btnReturn" class="button create" value="返回上一页"
							onclick="back('role_list');" />
					</div>
					<div class="clear"></div>
				</div>
				<!--/工具栏-->
				<!-- hidden -->
				<s:if test="#role.roleid > 0">
					<input type="hidden" name="roleid" id="roleid"
						value="<s:property value='#role.roleid'/>" />
				</s:if>
				<s:else>
					<input type="hidden" name="roleid" id="roleid" value="0" />
				</s:else>
				<!-- /hidden -->
			</form>
		</div>
		<iframe name="hd" style="display: none;"></iframe>
	</div>
</body>
</html>
