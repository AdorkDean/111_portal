$(function() 
{
	//根据登录状态赋予元素事件
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
				$(".right_cons").mouseleave(function() 
				{
					$(".right_cons").removeClass("right_cons_hover").hide();
				});
				$(".morev_h").mouseover(function()
				{
					var left = $(".morev_h").offset().left - 35;
					$(".right_cons").css({"position":"absolute","z-index":"999","background":"#f8f8f8","left":left}).show();
				});
			}
		}
	});
	//自动登录                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	autoLogin();
	
	//鼠标滚动时隐藏搜索历史
	$(window).scroll(function()
	{
		$(".autocomplete_ui").hide();
	});
	
	//搜索框颜色判断
	window.setTimeout(function()
	{
		try
		{
			var objsearch = $(".header-search-input");
			var vv = $.trim(objsearch.val());
			if(vv == '请输入搜索的内容...')
			{
				objsearch.css("color","#d7d7d7");
			}
			else
			{
				objsearch.css("color","#222");
			}
		}catch(e){}
	}, 100);
	
});

/**
 * 首页JS封装类
 * @author LGP
 * @date 2016-04-27
 */
var IndexExtend = 
{
		//更多特权显示
		moreRight : function()
		{
			$(".morev_h").mouseover(function()
			{
				var left = $(".morev_h").offset().left - 35;
				$(".right_cons").css({"position":"absolute","z-index":"999","background":"#f8f8f8","left":left}).show();
			});
		},
		//更多特权隐藏
		rightLeave : function()
		{
			var identy = $.trim($("#identy").val());
			$(".right_cons").mouseleave(function() 
			{
				if(identy == 1)
				{
					$(".right_cons").removeClass("right_cons_hover").hide();
				}
			});
		},
		//检查登录
		getUserName : function()
		{
			$.ajax(
			{
				url: "/index!getMemberUserName.action",
				type: "GET",
				dataType: "json",
				cache: false,
				async: false,
				success: function(data) 
				{
					var headUrl = data.headUrl;
					if(headUrl == null || headUrl == '' || headUrl == undefined)
					{
						headUrl = "http://img.zdfei.com/static/image/temp/20160127/73569e0fe07f5e60234179baddec94eb.jpg";
					}
					if(data == 0)
					{
						$(".morev_h").hide();
						$("#hasLogined").hide();
						$(".right_cons").show();
						$("#h_login_reg_btn").show();
						$("#identy").val("2");
					}
					else
					{
						$(".show_username").html(data.disPlayName);
						$(".head_url").attr("src", headUrl);
						$(".morev_h").show();
						$("#hasLogined").show();
						$(".right_cons").hide();
						$("#h_login_reg_btn").hide();
						$("#identy").val("1");
					}
				}
			});
		},
};

//自动登录
function autoLogin()
{
	var pcCookiesPassword = getCookie("pcCookPassword");
	var pcCookiesUsername = getCookie("pcCookUsername");
	if(pcCookiesPassword != null && pcCookiesUsername != null)
	{
		$.ajax
	    ({
	       type: "post",
	       url: "/login/login!autoLogin.action",	 
	       async:false, 
	       success: function()
	       {
	    	   IndexExtend.getUserName();
	       }
	    }); 
		console.log("selected_box");
	}
	else
	{
		IndexExtend.getUserName();
		console.log("no_selected_box");
	}
}







