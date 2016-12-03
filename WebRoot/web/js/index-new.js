//图片容器个数
var lbtpLength = $("#banner-img li").length;
var time = "";
var index = 1;
$(function() 
{
		//图片轮播
		showimg(index);
		//鼠标移入移出
		$(".imgnum span").hover(function () {
			clearTimeout(time);
			var icon=parseInt($(this).index())+1;
			$(".imgnum span").removeClass("onselect").eq(icon-1).addClass("onselect");
			$("#banner-img li").hide().stop(true,true).eq(icon-1).fadeIn("slow");
		}, function () {
			index=parseInt($(this).index())+1> 4 ? 1 :parseInt($(this).index())+1;
            time = setTimeout("showimg(" + index + ")", 3000);
        });
	
});
function showimg(num) 
{
	index = num;
	$(".imgnum span").removeClass("onselect").eq(index-1).addClass("onselect");
	$("#banner-img li").hide().stop(true,true).eq(index-1).fadeIn("slow");
	index = index + 1 > parseInt(lbtpLength) ? 1 : index + 1;
	time = setTimeout("showimg(" + index + ")", 3000);
}

$(document).ready(function()
{
	try{
		$('.cornerTR').hover(function(){
			var el = $(this).parent('div');
			if(el.hasClass('usual-adv')){
				el.find('b').css({"display":"none"});
				el.find('div').stop().animate({width:440,height:280},'slow');
				el.find('p').stop(true,true).show();
			}
			else if(el.hasClass('first-usual'))
			{
				el.find('b').css({"display":"none"});
				el.find('div').stop().animate({width:220,height:270},'slow');
				el.find('p').stop(true,true).show();
			}
		},function(){
			var el = $(this).parent('div');
			// 隐藏文字
			el.find('p').stop(true,true).hide();
			// 去掉遮罩
			el.find('div').stop().animate({width:60,height:60},'fast',function(){el.find('b').css({"display":"block"});});
			
		}).click(function(){
			el.find('span').hide();
			// 点击图片时打开链接
			window.open($(this).find('a').attr('href'));
		});
		
		$('.usual-list').hover(function(){
			if($(this).hasClass('usual-adv')){
					
			}else{
				$(this).addClass('borderC');		
			}
			
		},function(){
			$(this).removeClass('borderC');	
		});
	}catch(e){
	}
});

$(document).ready(function()
{
	try{
	    $(".brand-list li").hover(function(){
			$(this).find('p').stop(true,true).fadeIn();
		},function(){
			$(this).find('p').stop(true,true).fadeOut();	
		});
		
		//最热活动鼠标滑过特效
		$("#signnum").find("a").each(function(j)
		{
			var index = j + 1;
			$(this).mouseover(function()
			{
				$("#identity").val(index);
				for(var i=1;i<=3;i++)
				{
					if(i != index)
					{
						$("#atycon"+i).stop(true,true).fadeOut();
						$("#act"+i).removeClass("current");
					}
					else
					{
						$("#atycon"+i).stop(true,true).fadeIn();
						$("#act"+i).addClass("current");
					}
				}
				clearAutoT();
			})
			.mouseleave(function()
			{
				var eqv = $("#identity").val();
				for(var i=1;i<=3;i++)
				{
					if(eqv != i)
					{
						$("#act"+i).removeClass("current");
					}
					else
					{
						$("#act"+i).addClass("current");
					}
				}
				looper();
			});
		});
		
		$("#a-big-c").find("div.activity-box").each(function(i)
		{
			$(this).mouseover(function(){
				clearAutoT();
			});
			$(this).mouseleave(function(){
				looper();
			});
		});
		
	    //换一批
	    $(".refresh").click(function()
	    {
	    	var cv = parseInt($("#chageC").val());
	    	for(var i=1;i<=3;i++)
	    	{
	    		if(i != cv)
				{
	    			$("#rbox"+i).fadeOut("fast");
				}
				else
				{
					if(cv == 1)
					{
						$("#rbox"+i).fadeOut("fast");
					}
					$("#rbox"+i).fadeIn("fast");
				}
	    	}
	    	switch(cv)
	       	{
	   		case 1:
	   			$("#chageC").val("2");
	   		  break;
	   		case 2:
	   			$("#chageC").val("3");
	   		  break;
	   		default:
	   			$("#chageC").val("1");
	       	}
	    });
		
	}catch(e){
	} 
	
});

/** Get the client screen height */
function getScrollTop()
{
    var scrollTop=0;
    if(document.documentElement&&document.documentElement.scrollTop)
    {
        scrollTop=document.documentElement.scrollTop;
    }
    else if(document.body)
    {
        scrollTop=document.body.scrollTop;
    }
    return scrollTop;
}

var timeInterval = null;
var $cindex = 1;
function cEvent(index)
{
	++$cindex;
	if($cindex > 3)
	{
		$cindex = 1;
	}
	$("#identity").val(index);
	for(var i=1;i<=3;i++)
	{
		if(i != index)
		{
			$("#atycon"+i).stop(true,true).fadeOut();
			$("#act"+i).removeClass("current");
		}
		else
		{
			$("#atycon"+i).stop(true,true).fadeIn();
			$("#act"+i).addClass("current");
		}
	}
}

function clearAutoT()
{
	window.clearInterval(timeInterval);
}

looper();

function looper()
{
	timeInterval = window.setInterval(function()
	{
		cEvent($cindex);
	}, 1000);
}



