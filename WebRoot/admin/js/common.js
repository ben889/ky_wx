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
	RemoveLoadDialog();
	location.href=""+url+"";
}