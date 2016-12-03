$(function(){
	try
	{
		//公共属性特效
		$('.dropdown').hover(function()
		{
			$(this).find('a').addClass('hover');
			$(this).find('div').show();
		},
		function()
		{
			$(this).find('a').removeClass('hover');	
			$(this).find('div').hide();
		});	
		//商品分类
		if(document.getElementById("indexPage") != null)
		{
			$(".footer-icon").css("display","block");
		}
		else
		{
			var pageType = $.trim($("#header-nav").val());
			if(pageType == '3' || pageType == '5')
			{
			}
			else
			{
				if(pageType == '2')
				{
					$('#index-pro-category').css("display","block");
				}
				else
				{
					$('.all-sort').hover(function()
					{
						$('#index-pro-category').css("display","block");
						$('.wrap2').show();
					},
					function()
					{
						$('#index-pro-category').css("display","none");
						$('.wrap2').hide();
					});
				}
			}
			
		}
		
		//用户登录获取用户名
		getUserName();
	}
	catch(e)
	{
		$('.all-sort').hover(function(){
			$('.all-sort-list').css({"background":"rgba(0,166,160,1)"});
			$('.wrap2').show();
		},function(){
			$('.all-sort-list').css({"background":"rgba(0,166,160,.8)"});
			$('.wrap2').hide();	
		});
	}
	
	/** navicator content color */
	var $nav = $.trim($("#header-nav").val());
	$("#header-nav-"+$nav).css("color","#00a6a0");
	
});

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

//获取登录用户名
function getUserName()
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
			if(data == 0)
			{
				$(".header-login").css({"display":"block","color":"#ffffff"});
				$("#cookieusername").css("display","none");
				$("#reg-btn").css("display","block");
				$("#cookiebtn").css("display","none");
			}
			else
			{
				$(".header-login").css("display","none");
				$("#cookieusername").html(data).css({"color":"#ffffff","margin-right":"10px","font-family":"'宋体'","display":"block"});
				$("#reg-btn").css("display","none");
				$("#cookiebtn").css("display","block");
			}
		}
	});
}

var imgUrl = "http://ui1.111yao.com/";
