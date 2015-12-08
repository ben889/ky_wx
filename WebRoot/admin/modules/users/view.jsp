<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>帐号列表</title>
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
					<th align="left" width="6%">ID</th>
					<th align="left">帐号</th>
					<th align="left">名称</th>
					<th align="left">邮箱</th>
					<th align="left">创建日期</th>
					<th align="left">角色</th>
					<th align="left">所属公司</th>
					<th align="left" width="120px">操作</th>
				</tr>
				<s:if test="#request['list'] != null">
				<s:iterator value="#request['list']" id="user">
					<tr>
						<td align="center">
                        <span class="checkall" style="vertical-align: middle;">
                            <input type="checkbox" id="" name="" >
                        </span>
                    	</td>
						<td><s:property value="#user.userid" />
						</td>
						<td><s:property value="#user.username" /></td>
						<td><s:property value="#user.displayname" />
						</td>
						<td><s:property value="#user.email" /></td>
						<td><s:date name="#user.createtime" format="yyyy-MM-dd HH:mm:ss" /> </td>
						<td>
							<s:if test="#user.usertype!=0">
								<a href="javascript:void(0);" title="管理角色"> 
									<input type="image" title="角色管理" src="<%=basePath%>admin/images/icon_securityroles_16px.gif"
										style="border-width:0px;" /> 
								</a>
							</s:if>
						</td>
						<td>
							<s:date name="#user.lasttime" format="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>
						<a href="<%=basePath%>admin/user_bind?userid=<s:property value="#user.userid" />">修改</a>
							| 
						<s:if test="#user.locked == 0">
							<a href="<%=basePath%>admin/user_update?locked=on&userid=<s:property value="#user.userid" />">未锁定</a>
						</s:if>
						<s:else>
							<a href="<%=basePath%>admin/user_update?locked=off&userid=<s:property value="#user.userid" />" style="color:red;">已锁定</a>
						</s:else>
						   |  
						<a href="<%=basePath%>admin/user_delete?userid=<s:property value="#user.userid" />" onclick="return confirm('确定删除吗？');">删除</a>
						</td>
					</tr>
				</s:iterator>
				</s:if>
				<s:else>
					<tr><td colspan="9"><p style="color:red;text-align:center;">没有数据</p></td></tr>
				</s:else>
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
