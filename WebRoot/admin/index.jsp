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
	
<<<<<<< HEAD

=======
	//获取一级菜单
	<%-- function bindmenu(){
		$.ajax({
			url:"<%=basePath%>admin/tab_getmenuJson",
			type:"post",
			dataType:"json",
			data:{},
			success:function(data, textStatus){
				bindmenuRows(data);
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert("系统异常：XMLHttpRequest="+XMLHttpRequest+" textStatus="+textStatus+" errorThrown="+errorThrown);
			}
		});
	} --%>
		
	//获取子级菜单
	<%-- function bindsubmenu(parentid){
	alert(""+parentid);
		$.ajax({
			url:"<%=basePath%>admin/tab_getsubmenuJson",
			type:"post",
			dataType:"json",
			data:{parentid:parentid},
			success:function(data, textStatus){
				var rowhtml = setleftmenuhtml(json,1);
                $("#menu").append(rowhtml);
				changeBackground(parentid);
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert("系统异常：XMLHttpRequest="+XMLHttpRequest+" textStatus="+textStatus+" errorThrown="+errorThrown);
			}
		});
	} --%>
	
	//绑定一级菜单
	/* function bindmenuRows(json) {
            if (json.length > 0) {
                for (var i = 0; i < json.length; i++) {
                	if(i == 0)
                		var rowhtml = "<li class=\"selected\" onclick=\"bindsubmenu("+json[i].id+")\" id=\""+json[i].id+"\"><span>"+json[i].name+"</span></li>";
                	else
                  	 	var rowhtml = "<li onclick=\"bindsubmenu("+json[i].id+")\" id=\""+json[i].id+"\"><span>"+json[i].name+"</span></li>";
                    $("#nav").append(rowhtml);
                }
            }
        }
	
	
	  var lev = 0;
       //子级菜单
       function setleftmenuhtml(subjson, showul) {

           if (subjson == undefined || subjson.length == 0)
               return "";
           var dtlength = subjson.length;
           if (dtlength > 0) {
               lev++;

               var display = "";
               if (showul == 1)
                   display = "style=\"display:block;\"";
              	subresulthtml += "<ul " + display + ">";
               var clickfun = "";
               for (var i = 0; i < dtlength; i++) {
                   if (lev == 1) {
                       clickfun = "submenutoggle('" + subjson[i].id + "');";
                   }
                   var subj = subjson[i].submenu;
                   subresulthtml += "<li><a href=\"" + subjson[i].url + "\" id=\"" + subjson[i].id + "\" target=\"mainframe\" onclick=\"" + clickfun + "\">" + subjson[i].name + "</a>";
                   var isshow = 0;
                   if (lev == 2 && i == 0) {
                       isshow = 1;
                   }
                   setleftmenuhtml(subj, isshow);
                   subresulthtml += "</li>";
               }
               subresulthtml += "</ul>";
               lev--;
           }
           return subresulthtml;
       } */
	
	
	//点击切换背样式
	/* function changeBackground(parentid){
		$("#nav li").removeClass("selected");
        $("#" + parentid).parent().addClass("selected");
	} */
>>>>>>> origin/master
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


            
<<<<<<< HEAD
=======
            <div class="nav-right">
                <div class="icon-info">
                    <span><font class="fa fa-meh-o" style="font-size:18px;"></font>&nbsp;&nbsp;您好，【】&nbsp;&nbsp;<a href="javascript:;" onclick="return confirm('确定退出吗？');" style="color:#ffffff;">退出</a></span>
                </div>
            </div>
        </div>
        
	<!-- <div class="header">
        <div class="header-box">
            <h1 class="logo"><span class="fa fa-comments-o" style="font-size:24px;"></span> &nbsp;&nbsp;商家中心</h1>
            <ul id="nav" class="nav menu vvv">
                
                <li class="selected"><span>商品</span></li>
                <li><span>会员</span></li>
                <li><span>订单</span></li>
                <li><span>界面</span></li>
                <li><span>控制面板</span></li>
            </ul>
>>>>>>> origin/master
            <div class="nav-right">
                <div class="icon-info">
                    <span><font class="fa fa-meh-o" style="font-size:18px;"></font>&nbsp;&nbsp;您好，【】&nbsp;&nbsp;<a href="javascript:;" onclick="return confirm('确定退出吗？');" style="color:#ffffff;">退出</a></span>
                </div>
            </div>
        </div>
<<<<<<< HEAD

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
=======
    </div> -->

    <!--左部菜单-->
    <div class="main-sidebar">
        <div id="sidebar-nav" class="sidebar-nav" tabindex="5000" style="overflow: hidden; outline: none;">
            <div class="list-box">
                <div class="list-group" style="display: block;">
                    <h2><a href="javascript:void(0);">商家管理</a><i></i></h2>
                    <ul style="display: block;" id="submenu">
                        <%-- <li><a navid="user_manage" class="item pack">
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
                        </li> --%>
                    </ul>
                    	
                </div>
            </div>
>>>>>>> origin/master
        </div>
    </div>
    <!--内容-->
    <div class="main-container">
        <iframe id="mainframe" name="mainframe" allowtransparency="true" src="" border="0"
            frameborder="0" framespacing="0" marginheight="0" marginwidth="0" style="width: 100%; height: 100%; position: absolute;"></iframe>
    </div>
</body>
</html>

