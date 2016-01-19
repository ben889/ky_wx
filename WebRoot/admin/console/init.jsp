<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>数据初始化</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="<%=basePath%>admin/js/jquery.min.js"></script>
<!-- dialog -->
<link rel="stylesheet"
	href="<%=basePath%>admin/js/dialog/css/dialog.css" type="text/css"></link>
<script type="text/javascript"
	src="<%=basePath%>admin/js/dialog/js/dialog.js"></script>
<!-- /dialog -->
<script>
	function submitform() {
		if (confirm('确定执行吗？')) {
			LoadDialog("提交中");
			document.getElementById('form1').submit();
		}
	}
	function submitform2() {
		if (confirm('确定执行吗？')) {
			LoadDialog("提交中");
			document.getElementById('form2').submit();
		}
	}
</script>
<script>
	function success(info) {
		RemoveLoadDialog();
		if (info != "")
			alert(info);
	}
	function fail(info) {
		RemoveLoadDialog();
		if (info != "")
			alert(info);
	}
</script>
</head>

<body>
	<div style="padding:10px;">
		<form id="form1" name="form1" method="post"
			action="<%=basePath%>admin/tab_init" target="hd">
			<input type="button" value="数据初始化" class="button create"
				onclick="submitform();" />
		</form>
		<form id="form2" name="form2" method="post"
			action="<%=basePath%>admin/user_init" target="hd">
			<input type="button" value="帐号初始化" class="button create"
				onclick="submitform2();" />
		</form>
		<iframe name="hd" style="display: none;"></iframe>
	</div>
</body>
</html>
