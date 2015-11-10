<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- base style -->
	<link rel="stylesheet" href="<%=basePath%>admin/css/style.css" type="text/css"></link>
	<script type="text/javascript" src="<%=basePath%>admin/js/jquery.min.js"></script>
  	<script type="text/javascript" src="<%=basePath%>admin/js/common.js"></script>
	<!-- /base style -->
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
                       <li><a class="add" href="javascript:;" onclick="location.href='<%=basePath%>admin/role_edit'"><i></i><span>新增</span></a></li>
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
					<th align="left" width="6%">ID</th>
					<th align="left">名称</th>
					<th align="left">描述</th>
					<th align="left">图标</th>
					<th align="left">创建日期</th>
					<th align="left">操作</th>
				</tr>
  				<s:if test="#request['roles'] != null">
				<s:iterator value="#request['roles']" id="role">
					<tr>
						<td align="center">
							<span class="checkall" style="vertical-align: middle;">
	                            <input type="checkbox" id="" name="" >
	                        </span>
						</td>
						<td><s:property value="#role.roleid"/></td>
						<td><s:property value="#role.rolename"/></td>
						<td><s:property value="#role.description"/></td>
						<td>
							<img width="50px" height="50px" src="<s:property value='#role.icon'/>" />
						</td>
						<td><s:date name="#role.createdtime" format="yyyy-MM-dd HH:mm:ss"/></td>
						<td>
							<a href="<%=basePath%>admin/role_edit?roleid=<s:property value="#role.roleid"/>">编辑 </a>
							|
							<a href="<%=basePath%>admin/role_delete?roleid=<s:property value="#role.roleid"/>" onclick="return confirm('确定删除吗？');">删除</a>
						</td>
					</tr>
				</s:iterator>
			   	</s:if>
				<s:else>
					<tr><td colspan="6"><p style="color:red;text-align:center;">没有数据</p></td></tr>
				</s:else>
				</tbody>
		</table>
  </body>
</html>
