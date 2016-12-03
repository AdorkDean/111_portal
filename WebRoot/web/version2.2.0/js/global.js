var global_image_url = "http://img.zdfei.com/";
var share_erwei_code = "http://testwap.111yao.com/";
//检测用户登录
function checklogin() 
{
	var result = false;
	$.ajax(
	{
		url: "/index!clogin.action",
		type: "GET",
		dataType: "json",
		cache: false,
		async: false,
		success: function(data) 
		{
			if(data == 1)
			{
				result = true;
			}
		}
	});
	return result;
}