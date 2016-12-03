$(function()
{
	//图片延迟加载
	try
    {
		$(".lazy").lazyload(
		{
			threshold: 100,
			effect: "fadeIn",
			skip_invisible: false
		});
		
    }catch(e){}
	
	/*header dropdown*/
	$('.dropdown').hover(function()
	{
		$(this).addClass('hover');	
	},
	function()
	{
		$(this).removeClass('hover');	
	});
	
	/*nav menu*/
	$('#nav-menu .menu > li').hover(function()
	{
		$('.children').stop(true,true).hide();
		$('.nav-dropdown').removeClass('navhover');
		$(this).find('.children').delay(200).animate({ opacity:'show', height:'show' },200);
		$(this).find('.nav-dropdown').delay(200).addClass('navhover');
	}, 
	function()
	{
		$('.children').stop(true,true).hide();
		$('.nav-dropdown').removeClass('navhover');
	});
	
	//锚点滚轮事件
	var array = new Array();
	try
	{
		$(".sider-nav ul li").each(function(index)
		{
			array[index] = $(this).attr("class");
		});
	}catch(e){}
	
	/*sider-nav scroll*/
	$(window).scroll(function()
	{
		try
		{
			var oHotTop = $("#index_jrrm").offset().top; 
			var oHotLeft = $("#index_jrrm").offset().left;
			var scrTop = $(window).scrollTop() || document.documentElement.scrollTop;
			scrTop >= oHotTop ? $(".sider-nav").addClass("Jfix").css("left",oHotLeft - 100 + "px") : $(".sider-nav").removeClass("Jfix").css("left","-100px");
			var length = array.length;
			for(var i=0; i<length; i++)
			{
				var curTop = $("#"+array[i]).offset().top-50;
				var curLeft = $("#"+array[i]).offset().left;
				var nextTop = 10000;
				try
				{
					nextTop = $("#"+array[i+1]).offset().top;
				}
				catch(e){}
				if(scrTop >= curTop && scrTop < nextTop)
				{
					$(".sider-nav").addClass('Jfix').css("left",curLeft - 100 + "px");
					$(".sider-nav ul li").eq(i).addClass('current').siblings().removeClass('current');
				}
			}
		}catch(e){}
	});
	
	$('.sider-nav ul li').click(function()
	{
		$(this).addClass('current').siblings().removeClass('current');	
	});
});

function anchorPage(id)
{
	var top = $("#"+id).offset().top;
	var left = $("#"+id).offset().left;
	$(".sider-nav").addClass('Jfix').css("left",left - 100 + "px");
	$("html,body").animate({scrollTop: top},500);
}
