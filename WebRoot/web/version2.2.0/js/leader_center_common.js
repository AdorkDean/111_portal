$(function(){
	$.ajax(
	{
		url: "/index!getMemberUserName.action",
		type: "GET",
		dataType: "json",
		cache: false,
		async: false,
		success: function(data) 
		{
			if(data == 0)
			{
			}
			else
			{
				$("#leader_center_welcome").html(data.disPlayName+"，欢迎您！");
			}
		}
	});
});