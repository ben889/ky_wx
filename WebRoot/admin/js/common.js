/*选项卡*/
function tabs() {
	    var $div_li = $("#tab_menu ul li a");
	    $div_li.click(function () {
	        $div_li.removeClass("selected");
	        $(this).addClass("selected");
	        var div_index = $div_li.index(this);
	        $("#tab_box>div").hide();
	        $("#tab_box>div").eq(div_index).show();
	    });
}

/*提交表单*/
function save(formid)
{
	LoadDialog();
	$("#"+formid+"").submit();
	return true;
}
/*提交表单失败*/
function fail(info)
{
	RemoveLoadDialog();
	if (info!="")
		alert(info);
}
/*提交表单成功*/
function success(info){
	RemoveLoadDialog();
	if (info!="")
		alert(info);
}
/*返回上一页*/
function back(url){
	//移除加载进度
	RemoveLoadDialog();
	//获取主机地址，如： http://localhost:8080
    //var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/myframe1.0
    //var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	location.href=""+url+"";
}