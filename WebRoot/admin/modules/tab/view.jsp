<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>标签页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- base style -->
<link rel="stylesheet" href="<%=basePath%>admin/css/style.css" type="text/css"></link>
<script type="text/javascript" src="<%=basePath%>admin/js/jquery.min.js"></script>
<!-- /base style -->

<!-- 分页插件 -->
<script type="text/javascript" src="<%=basePath%>js/Pagination/Pagination.js"></script>
<link rel="stylesheet" href="<%=basePath%>js/Pagination/pager.css" type="text/css"></link>
<!-- /分页插件 -->

</head>

<body class="mainbody">
	<!--导航栏-->
	<div class="location">
	    <h1>用户列表</h1>
	</div>
	<!--/导航栏-->
	<!--工具栏-->
	<div class="toolbar-wrap">
	    <div id="floatHead" class="toolbar">
	        <div class="l-list">
	            <ul class="icon-list">
	                <li><a class="add" href="javascript:;" onclick="location.href='<%=basePath%>admin/user_'"><i></i><span>新增</span></a></li>
					 <li><a class="all" href="javascript:;"><i></i><span>全选</span></a></li>
					 <li><a class="del" href="javascript:;" onclick="return confirm('确定删除吗？');" id="btnDelete"><i></i><span>删除</span></a></li>
	            </ul>
	        </div>
	    </div>
	</div>
	<!--/工具栏-->
	<!--列表-->
        <table class="ltable" border="0" cellpadding="0" cellspacing="0" width="100%">
            <tbody>
            	<tr class="odd_bg">
					<th width="6%">选择</th>
					<th align="left">菜单</th>
					<th align="left">权限</th>
				</tr>
				<s:iterator value="#request['tabList']" id="tab">
				<tr class="DataGrid_Item">
					<td align="center">
						<input id="selectall2" type="checkbox" title="全选/全不选">
						<label for="selectall2">全选</label>
					</td>
					<td align="left" style="text-align: left;">
						<div style="float: left; padding-left: 10px;"> &nbsp; </div>
						<div style="float: left; padding-left: 10px;">
							┠ <s:property value="#tab.tabname"/>
							<input  type="hidden" id="" name="" />
						</div>
					</td>
					<td width="40%" align="left" style="text-align: left;">
						<input type="checkbox" id="insert" /> 
						<label for="insert">添加 </label>
						<input type="checkbox" id="delete" /> 
						<label for="delete">删除 </label>
						<input type="checkbox" id="update" /> 
						<label for="update">修改 </label>
						<input type="checkbox" id="view" /> 
						<label for="view">查看 </label>
					</td>
				</tr>
				</s:iterator>
			</tbody>
        </table>
        <!--/列表-->
        <!-- 分页 -->
		<div class="Pagination">
			<div class="pager" style="text-align:right;">
	         <s:if test="#request.page!=null">
	         	<div id="pg"></div>
	         	<script>
	         		//分页功能
					var pg = new showPages("pg"); //分页div的ID 
					pg.pageCount = ${page.totalPage}; //总页数 
					pg.argName = "page";  //定义参数名(可选,默认为page)
					pg.printHtml();
	         	</script>
	         </s:if>
			</div>
		</div>
		<!-- /分页 -->
</body>
</html>
