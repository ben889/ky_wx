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
	<script type="text/javascript" src="menu.js"></script>
	<link href="<%=basePath%>admin/css/skin.css" type="text/css" rel="stylesheet" ></link>
	<link href="<%=basePath%>css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"></link>
	<script type="text/javascript">
	//初始化菜单
	$(function(){
	    post_menuurl="<%=basePath%>admin/tab_getMenuJson";
	    post_submenuurl="<%=basePath%>admin/tab_getSubMenuJson";
		bindmenu();
	});
	

	</script>
</head>
<body class="indexbody">
<div class="header">
        <h1 class="logo">
            <span class="fa fa-comments-o" style="font-size:24px;"></span> &nbsp;&nbsp;
            </h1>
            <div class="nav">
                <div id="menu">
                </div>
            </div>

            <div class="nav-right">
                <div class="icon-info">
                    <span><font class="fa fa-meh-o" style="font-size:18px;"></font>&nbsp;&nbsp;您好，【】&nbsp;&nbsp;<a href="javascript:;" onclick="return confirm('确定退出吗？');" style="color:#ffffff;">退出</a></span>
                </div>
            </div>
        </div>

    <!--左部菜单-->
    <div class="main-sidebar">
        <div style="height: 0px;">
        </div>
        <div id="submenu-top">
        </div>
        <div id="submenu">
            <%--<ul>
                <li><a href="DesktopModules/Product/productlist.aspx" id="11" target="mainframe">产品</a><ul>
                    <li><a href="DesktopModules/Product/productlist.aspx" id="111" target="mainframe">产品</a></li>
                    <li><a href="DesktopModules/Product/producttype.aspx" id="112" target="mainframe">产品分类</a></li>
                </ul>
                </li>
                <li><a href="DesktopModules/Order/order.aspx" id="12" target="main">订单</a></li>
            </ul>--%>
        </div>
    </div>
    <!--内容-->
    <div class="main-container">
        <iframe id="mainframe" name="mainframe" allowtransparency="true" src="" border="0"
            frameborder="0" framespacing="0" marginheight="0" marginwidth="0" style="width: 100%; height: 100%; position: absolute;"></iframe>
    </div>
</body>
</html>

