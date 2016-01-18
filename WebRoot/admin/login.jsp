<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link href="css/login.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>/js/dialog/css/dialog.css"
	type="text/css"></link>
<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<script type="text/javascript" src="<%=path%>/js/dialog/js/dialog.js"></script>
<script type="text/javascript">
        $(document).ready(function () {
            $("#btnlogin").click(function () {
                if ($.trim($("#username").val()) == "") {
                    alert("请填写用户名");
                    return false;
                }
                if ($.trim($("#password").val()) == "") {
                    alert("请填写密码");
                    return false;
                }
                if ($.trim($("#checkcode").val()) == "") {
                    alert("请填写验证码");
                    return false;
                }
                login($.trim($("#username").val()), $.trim($("#password").val()), $.trim($("#checkcode").val()));
                return false;
            });
            $("#username,#password,#checkcode").keydown(function () {
                //alert("abcv");
                //return keypress(event,'btnlogin');
            });

            settextboxEvent();

        });

		

        function settextboxEvent() {

            $("#username").focus(function () {
                if ($.trim($(this).val()) == "") {
                    $("#lbusername").hide();
                }
            });
            $("#username").blur(function () {
                if ($.trim($(this).val()) == "") {
                    $("#lbusername").show();
                }
            });



            $("#password").focus(function () {
                if ($.trim($(this).val()) == "") {
                    $("#lbpass").hide();
                }
            });
            $("#password").blur(function () {
                if ($.trim($(this).val()) == "") {
                    $("#lbpass").show();
                }
            });
        }

        function login(usernameval, passwordval, checkcodeval) {
            $("#btnlogin").attr("disabled", "true");
            var iscookie = $("#cbxisCookies").attr("checked") == "checked" ? 1 : 0;
            //alert(iscookie);
            var ajaxdata = {username: usernameval, password: passwordval, checkcode: checkcodeval, isCookies: iscookie };
            $.ajax({
                type: "POST",
                url: '<%=path%>/user_login',
                data: ajaxdata,
                dataType: "text",
                beforeSend: function () {
                    //$("#loginstate").html("<font style='color:red;'>验证中...</font>");
                    $("#btnlogin").val("验证中...");
                },
                success: function (results) {
                    //alert(results);
                    //var userid = parseInt(result); //-4已被删除 -2被锁定 -100异常 -1帐号/密码错误
                    //var result = results.result;
                    //var msg = results.msg;
                    if (results == "1") {

                        $("#loginstate").html("<font style='color:#00FF00;'>验证正确.登陆中.</font>");
                        //setInterval("gotodefaultpage()", 3000);
                        window.location = "index.jsp";
                    }
                    else {
                        $("#loginstate").html("<font style='color:red;'>" + results + "</font>");
                    }
                    $("#btnlogin").removeAttr("disabled");
                    $("#btnlogin").val("登 录");
                },
                error: function () { $("#loginstate").html("<font style='color:red;'> 异常错误！</font>"); }
            });
        }

        function RefreshCheckCode() {
            document.getElementById('yzm').src = '<%=basePath%>verifycode?'
				+ new Date;
	}
</script>
</head>
<body>
	<div class="login">
		<div class="login-box">
			<div id="logo" style="height: 45px;">
				<!--<img src="images/logo.gif" alt="logo" height="45" width="150" />-->
			</div>
			<div align="left" style="margin: 0 0 4px 0; font-size: 14px;">
				<b> <!--康之源热泵洗头床微商系统--> </b>
			</div>
			<div style="margin: 0 0 40px 0;">
				<div class="login-box-left">
					<img src="images/login.jpg" height="270" width="495" />
				</div>
				<div class="login-box-right loginform">
					<form id="form1" name="form1" method="post">
						<div id="loginstate" style="margin-bottom: 1px; text-align: left;">
						</div>
						<ul>
							<li>
								<div class="input_w">
									<label id="lbusername"> 帐号</label> <input name="username"
										type="text" class="texbox" id="username" style="width: 100%;" />
								</div></li>
							<li>
								<div class="input_w">
									<label id="lbpass"> 密码</label> <input type="password"
										name="password" id="password" style="width: 100%;"
										class="texbox" />
								</div></li>
							<li><input type="text" name="checkcode" id="checkcode"
								style="width: 120px;" class="texbox" /> <a
								href="javascript:RefreshCheckCode();" title="点击刷新"> <img
									id="yzm" src="<%=basePath%>verifycode" alt="点击刷新" border="0"
									style="height:30px;" />
							</a></li>
							<li style="height: 40px;"><input name="btnlogin"
								id="btnlogin" type="button" value="登 录" class="loginbutton" />
								<label> <input type="checkbox" name="cbxisCookies"
									id="cbxisCookies" /> 记住登录状态</label></li>
							<li>忘记密码？ | 立即注册</li>
						</ul>
					</form>
				</div>
			</div>
			<!--<div> <img src="images/loginimg.gif" /> </div>-->
		</div>
	</div>
</body>
</html>

