<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript" src="<%=basePath%>admin/js/jquery.min.js"></script>
<link href="<%=basePath%>admin/css/style.css" type="text/css" rel="stylesheet" ></link>
<link href="<%=basePath%>css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript">
//子菜单收展
	function submenutoggle(mid) {
	    $("#SubMenu ul li ul").hide();
	    $("#" + mid).next().show();
	}
</script>
</head>
<body class="indexbody">
	<div class="header">
        <div class="header-box">
            <h1 class="logo"><span class="fa fa-comments-o" style="font-size:24px;"></span> &nbsp;&nbsp;商家中心</h1>
            <ul id="nav" class="nav menu">
                <li class="selected"><span>商品</span></li>
                <li><span>会员</span></li>
                <li><span>订单</span></li>
                <li><span>界面</span></li>
                <li><span>控制面板</span></li>
            </ul>
            <div class="nav-right">
                <div class="icon-info">
                    <span><font class="fa fa-meh-o" style="font-size:18px;"></font>&nbsp;&nbsp;您好，<a href="javascript:;" onclick="return confirm('确定退出吗？');" style="color:#ffffff;">退出</a></span>
                </div>
            </div>
        </div>
    </div>

    <!--左部菜单-->
    <div class="main-sidebar">
        <div id="sidebar-nav" class="sidebar-nav" tabindex="5000" style="overflow: hidden; outline: none;">
            <div class="list-box">
                <div class="list-group" name="商家" style="display: block;">
                    <h2><a href="javascript:void(0);" onclick="member()">商家管理</a><i></i></h2>
                    <ul style="display: block;" >
                        <li><a navid="user_manage" class="item pack">
                            <div class="arrow"></div>
                            <div class="expandable open"></div>
                            <div class="folder close"></div>
                            <span>用户管理</span> </a>
                            <ul style="display: block;">
                                <li>
                                	<a navid="user_list" href="<%=basePath%>admin/user_list" target="mainframe" class="item">
	                                    <div class="arrow"></div>
	                                    <div class="expandable"></div>
	                                    <div class="folder open"></div>
	                                    <span>用户信息</span>
                                   	</a>
                               </li>
                            </ul>
                        </li>
                    </ul>
                    <ul style="display: block;" id="list">
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!--内容-->
    <div class="main-container">
        <iframe id="mainframe" name="mainframe" frameborder="0" src="main.aspx"></iframe>
    </div>
</body>
</html>

