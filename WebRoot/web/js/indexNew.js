// JavaScript Document
$(function(){
	//下拉导航
	$('.all-sort').hover(function(){
			$('.wrap2').show()
		},function(){
			$('.wrap2').hide()	
		})
	//下拉菜单
	$('.dropdown').hover(function(){
		$(this).find('a').addClass('hover');
		$(this).find('div').show();
	},function(){
		$(this).find('a').removeClass('hover');	
		$(this).find('div').hide();
	})
	//输入联想
	$('.header-search-input').focus(function(){
		$('.search-list').show();	
	})	
	$('.header-search-input').blur(function(){
		$('.search-list').hide();	
	})	
})

//header-list
$(function(){
	$('.all-sort-list > .item').hover(function(){
			var eq = $('.all-sort-list > .item').index(this),				//获取当前滑过是第几个元素
				h = $('.all-sort-list').offset().top,						//获取当前下拉菜单距离窗口多少像素
				s = $(window).scrollTop(),									//获取游览器滚动了多少高度
				i = $(this).offset().top,									//当前元素滑过距离窗口多少像素
				item = $(this).children('.item-list').height(),				//下拉菜单子类内容容器的高度
				sort = $('.all-sort-list').height();						//父类分类列表容器的高度
			
			if ( item < sort ){												//如果子类的高度小于父类的高度
				if ( eq == 0 ){
					$(this).children('.item-list').css('top', (i-h));
				} else {
					$(this).children('.item-list').css('top', (i-h)+1);
				}
			} else {
				if ( s > h ) {												//判断子类的显示位置，如果滚动的高度大于所有分类列表容器的高度
					if ( i-s > 0 ){											//则 继续判断当前滑过容器的位置 是否有一半超出窗口一半在窗口内显示的Bug,
						$(this).children('.item-list').css('top', (s-h)+2 );
					} else {
						$(this).children('.item-list').css('top', (s-h)-(-(i-s))+2 );
					}
				} else {
					$(this).children('.item-list').css('top', 0 );
				}
			}	

			$(this).addClass('hover');
			$(this).children('.item-list').css('display','block');
		},function(){
			$(this).removeClass('hover');
			$(this).children('.item-list').css('display','none');
		});

		$('.item > .item-list > .close').click(function(){
			$(this).parent().parent().removeClass('hover');
			$(this).parent().hide();
		});	
})

//banner
var time = "";
 	var index = 1;
	$(function () {
		showimg(index);
		//鼠标移入移出
		$(".imgnum span").hover(function () {
			clearTimeout(time);
			var icon=$(this).text();
			$(".imgnum span").removeClass("onselect").eq(icon-1).addClass("onselect");
			$("#banner-img li").hide().stop(true,true).eq(icon-1).fadeIn("slow");
		}, function () {
			index=$(this).text()> 4 ? 1 :parseInt($(this).text())+1;
            time = setTimeout("showimg(" + index + ")", 3000);
        });
	});
 
    function showimg(num) {
    	index = num;
    	$(".imgnum span").removeClass("onselect").eq(index-1).addClass("onselect");
    	$("#banner-img li").hide().stop(true,true).eq(index-1).fadeIn("slow");
    	index = index + 1 > 5 ? 1 : index + 1;
    	time = setTimeout("showimg(" + index + ")", 3000);
   	}

//change list
$(document).ready(function(){
    $('.column-list li a').hover(function(){
		//$(this).addClass('hov').parent('li').siblings().find('a').removeClass('hov');
		$(this).parent('li').siblings().find('div').hide();
		$(this).parent('li').find('div').show();
	})
});

//tj
$(document).ready(function(){
	$('.cornerTR').hover(function(){
		var el = $(this).parent('div');
		if(el.hasClass('usual-adv')){
			el.find('b').css({"display":"none"});
			el.find('div').stop().animate({width:440,height:280},'slow');
			el.find('p').stop(true,true).show();
		}else if(el.hasClass('first-usual')){
			
		}else if(el.hasClass('last-usual')){
			
		}else{
			
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
			$(this).addClass('borderC')		
		}
		
	},function(){
		$(this).removeClass('borderC')	
	})
});

//brand p
$(document).ready(function(){
    $(".brand-list li").hover(function(){
		$(this).find('p').fadeIn();
	},function(){
		$(this).find('p').fadeOut();	
	})
	
	/** 最热活动鼠标滑过特效*/
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
					$("#atycon"+i).fadeOut();
					$("#act"+i).removeClass("current");
				}
				else
				{
					$("#atycon"+i).fadeIn();
					$("#act"+i).addClass("current");
				}
			}
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
		});
	});
	
    /** 换一批*/
    $(".refresh").click(function()
    {
    	var cv = parseInt($("#chageC").val());
    	for(var i=1;i<=3;i++)
    	{
    		if(i != cv)
			{
    			$("#rbox"+i).fadeOut();
			}
			else
			{
				if(cv == 1)
				{
					$("#rbox"+i).fadeOut();
				}
				$("#rbox"+i).fadeIn();
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
	
	
});

