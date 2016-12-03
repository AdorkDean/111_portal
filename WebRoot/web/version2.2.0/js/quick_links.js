jQuery(function($)
{
	//定义变量
	var 
	quickHTML = document.querySelector("div.quick_link_mian"),
	quickShell = $(document.createElement('div')).html(quickHTML).addClass('quick_links_wrap'),
	quickLinks = quickShell.find('.quick_links');
	quickPanel = quickLinks.next();
	quickShell.appendTo('.mui-mbar-tabs');
	
	//初始化组件
	var 
	quickPopXHR = null,
	popTmpl = '<a href="javascript:;" class="ibar_closebtn" title="关闭"></a><div class="ibar_plugin_title"><h3><%=title%></h3></div><div class="pop_panel"><%=content%></div><div class="arrow"><i></i></div><div class="fix_bg"></div>',
	quickPop = quickShell.find('#quick_links_pop'),
	quickDataFns = 
	{
		//购物车
		message_list: 
		{
			title: '<a href="/carts/cart!page.action" target="_blank">我的购物车</a>',
			content : null,
			init:$.noop
		},
		mpbtn_histroy:
		{
			title: '我的足迹',
			content: null,
			init: $.noop
		},
		mpbtn_wdsc:
		{
			title: '<a href="/member/collect.action" target="_blank">我的收藏</a>',
			content: null,
			init: $.noop
		},
		//客服咨询
		mpbtn_kfkf:
		{
			title: '',
			content:'<div class="base-bg"><img src="http://img.zdfei.com/static/image/temp/20160819/971d27f50451a7a9b1f298cd59096ecb.png"/><b class="base-close"></b></div><b class="icon_arrow_right_black"></b><div class="base-doctor-list"><h3>药师咨询</h3><div class="doctor-name"><span>唐药师 <a href="javascript:;" onclick=window.open("http://wpa.qq.com/msgrd?v=3&uin=2601114970&site=qq&menu=yes","_blank") class="sider-on-line"></a></span><b>[从业15年  QQ咨询]</b></div><div class="doctor-name"><span>王药师 <a href="javascript:;" onclick=window.open("http://wpa.qq.com/msgrd?v=3&uin=2601114970&site=qq&menu=yes","_blank") class="sider-on-line"></a></span><b>[从业6年  QQ咨询]</b></div><div class="doctor-name"><span>邢药师 <a href="javascript:;" onclick=window.open("http://amos.im.alisoft.com/msg.aw?v=2&uid=%E6%97%B6%E4%BB%A3%E5%8D%83%E6%96%B9&site=cntaobao&s=1&charset=utf-8","_blank") class="sider-on-line"></a></span><b>[从业5年  旺旺咨询]</b></div><div class="doctor-name"><span>王药师 <a href="#" onclick=window.open("http://amos.im.alisoft.com/msg.aw?v=2&uid=%E6%97%B6%E4%BB%A3%E5%8D%83%E6%96%B9&site=cntaobao&s=1&charset=utf-8","_blank") class="sider-on-line"></a></span><b>[从业8年  旺旺咨询]</b></div><div class="base-line"></div><div class="doctor-name"><span class="base-margin">售后咨询 <a href="javascript:;" onclick=window.open("http://wpa.qq.com/msgrd?v=3&uin=2601114970&site=qq&menu=yes","_blank") class="sider-on-line"></a></span></div><div class="base-line"></div><div class="doctor-name"><span>电话咨询</span><p>400-606-3111</p></div></div>',
			init: $.noop
		}
	};
	
	//showQuickPop
	var 
	prevPopType = null,
	prevTrigger = null,
	doc = $(document),
	popDisplayed = false,
	hideQuickPop = function()
	{
		if(prevTrigger)
		{
			prevTrigger.removeClass('current');
		}
		popDisplayed = false;
		prevPopType = '';
		quickPop.hide();
		quickPop.animate({left:280,queue:true});
		$(".mui-mbar-tabs").css("width","auto");
		$(".quick_links_wrap").css("width","auto");
	},
	showQuickPop = function(type)
	{
		if(quickPopXHR && quickPopXHR.abort)
		{
			quickPopXHR.abort();
		}
		if(type !== prevPopType)
		{
			var fn = quickDataFns[type];
			quickPop.html(ds.tmpl(popTmpl, fn));
			fn.init.call(this, fn);
		}
		doc.unbind('click.quick_links').one('click.quick_links', hideQuickPop);
		quickPop[0].className = 'quick_links_pop quick_' + type;
		popDisplayed = true;
		prevPopType = type;
		quickPop.show();
		quickPop.animate({left:0,queue:true});
	};
	quickShell.bind('click.quick_links', function(e)
	{
		e.stopPropagation();
	});
	quickPop.delegate('a.ibar_closebtn','click',function()
	{
		hideQuickPop();
	});
	
	//事件处理
	var 
	view = $(window),
	quickLinkCollapsed = !!ds.getCookie('ql_collapse'),
	getHandlerType = function(className)
	{
		return className.replace(/current/g, '').replace(/\s+/, '');
	},
	showPopFn = function()
	{
		var type = getHandlerType(this.className);
		if(popDisplayed && type === prevPopType)
		{
			$(".mui-mbar-tabs").css("width","auto");
			$(".quick_links_wrap").css("width","auto");
			return hideQuickPop();
		}
		showQuickPop(this.className);
		//加载历史记录数据
		if(this.className == 'mpbtn_histroy')
		{
			loadHistoryData();
		}
		//加载我的收藏数据
		if(this.className == 'mpbtn_wdsc')
		{
			loadCollectData();
		}
		//加载购物车数据
		if(this.className == 'message_list')
		{
			loadShoppingCartDatas();
		}
		prevTrigger = $(this).addClass('current');
		if(prevTrigger)
		{
			prevTrigger.removeClass('current');
		}
		$(".mui-mbar-tabs").css("width","320px");
		$(".quick_links_wrap").css("width","320px");
	},
	//函数监听器
	quickHandlers = 
	{
			my_qlinks: showPopFn,
			message_list: showPopFn,
			history_list: showPopFn,
			leave_message: showPopFn,
			mpbtn_histroy:showPopFn,
			mpbtn_recharge:showPopFn,
			mpbtn_wdsc:showPopFn,
			mpbtn_kfkf:showPopFn,
			return_top: function()
			{
				ds.scrollTo(0, 0);
				hideReturnTop();
			}
	};
	quickShell.delegate('a', 'click', function(e)
	{
		var type = getHandlerType(this.className);
		if(type && quickHandlers[type])
		{
			quickHandlers[type].call(this);
			e.preventDefault();
		}
		console.log(this.className);
	});
	
	var scrollTimer = null, resizeTimer = null;
	function resizeHandler()
	{
		clearTimeout(scrollTimer);
		scrollTimer = setTimeout(checkScroll, 160);
	}
	
	function checkResize()
	{
		quickShell[view.width() > 1340 ? 'removeClass' : 'addClass']('quick_links_dockright');
	}
	function scrollHandler()
	{
		clearTimeout(resizeTimer);
		resizeTimer = setTimeout(checkResize, 160);
	}
	function checkScroll()
	{
		view.scrollTop()>100 ? showReturnTop() : hideReturnTop();
	}
	function showReturnTop()
	{
		quickPanel.addClass('quick_links_allow_gotop');
	}
	function hideReturnTop()
	{
		quickPanel.removeClass('quick_links_allow_gotop');
	}
	view.bind('scroll.go_top', resizeHandler).bind('resize.quick_links', scrollHandler);
	quickLinkCollapsed && quickShell.addClass('quick_links_min');
	resizeHandler();
	scrollHandler();
	if($(".index_jrrm").text() != "")
	{
		window.onload=showQuickPop('mpbtn_kfkf');
		$(".pop_panel").css("margin-right","40px");
		var ua = navigator.userAgent;
		if(ua.indexOf("Chrome") > -1){}
		else
		{
		    if (ua.indexOf("Safari") > -1) 
		    {
		    	$(".pop_panel").css("margin-right","0px");
		    }
		}
	}
});

//加载历史浏览数据
function loadHistoryData()
{
	var start = '<div class="ibar_plugin_content"><div class="ibar_cart_group ibar_cart_product"><ul id="history_ul_data">';
	var end = '</ul></div></div>';
	var myprohisview = "";
	var proInfos = ($invert(getCookie("id")) + "").replace(",", ":");
	try
	{
		proInfos = proInfos.substring(0,proInfos.length - 3);
		var jsonArry = proInfos.split(":::");
		var lgth = jsonArry.length;
		if(parseInt(lgth) > 7)
		{
			lgth = 7;
		}
		if(lgth > 0)
		{
			var f = false;
			for(var i=0;i<lgth;i++)
			{
				 var proinfo = jsonArry[i].split("#");
				 var proId = proinfo[0];
				 var price = proinfo[1];
				 var proImg = null;
				 if(proinfo[2] == '' || proinfo[2] == null)
				 {
					 proImg = "/web/images/300.jpg";
				 }
				 else
				 {
					 proImg = global_image_url+proinfo[2];
				 }
				 var goods_name = proinfo[3];
				 myprohisview += "<li class='cart_item' id='history_data_"+i+"'>"
					+'<div class="cart_item_pic">'
					+'<a href="/p/'+proId+'.html" target="_blank"><img src="'+proImg+'" /></a>'
					+'</div>'
					+'<div class="cart_item_desc">'
					+'<a href="/p/'+proId+'.html" target="_blank" class="cart_item_name">'+goods_name+'</a>'
					+"<div class='cart_item_price'><a href='javascript:void(0)' onclick=removedata('"+proId+"','"+price+"','"+encodeURIComponent(goods_name)+"','"+proinfo[2]+"','"+i+"')>删除</a>"
					+'<span class="cart_price red">¥'+price+'</span>'
					+'</div>'
					+'</div>'
					+'</li>';
				 if(goods_name == undefined || proId == undefined || price == undefined)
				 {
					 f = true;
					 break;
				 }
			 }
			 if(f)
			 {
				 $(".pop_panel").html("<div class='cart-empty'><p>您没有浏览过任何商品！</p></div>");
			 }
			 else
			 {
				 $(".pop_panel").html(start + myprohisview + end);
			 }
		}
		else
		{
			$(".pop_panel").html("<div class='cart-empty'><p>您没有浏览过任何商品！</p></div>");
		}
	}catch(e){}
}
//移除浏览历史数据
function removedata(proId, price, goods_name, proinfo, i)
{
	goods_name = decodeURIComponent(goods_name);
	var historyData = proId+"#"+price+"#"+proinfo+"#"+goods_name+":::";
	var proInfos = $invert(getCookie("id"))+"";
	proInfos = proInfos.replace(",", ":");
	var resultDatas = proInfos.replace(historyData, "");
	setCookie("id", resultDatas);
	$("#history_data_"+i).remove();
	var hudlg = $("#history_ul_data").find("li").length;
	if(hudlg == 0)
	{
		$(".pop_panel").html("<div class='cart-empty'><p>您没有浏览过任何商品！</p></div>");
	}
}


//去我的收藏
function toMyCollect()
{
	if(!checklogin())
	{
		window.location.href = "/login/login!index.action?redirectUrl="+window.location.href;
	}
}

//取消收藏
function removeCollect(id, i)
{
	$.ajax(
	{
        type: "POST",
        cache: false,
        dataType:"json",
        url: "/member/collect!cancel.action",
        data: {id : id},	            
        success: function(data)
        {
        	if(data > 0)
        	{
        		$("#collect_data_"+i).remove();
        		loadCollectData();
        	}
        	else
        	{
        		$alertCanDisplay("warn", "取消失败！", "111医药馆提示您", null);
        	}
        }
    });
}

//加载我的收藏数据
function loadCollectData()
{
	var start = '<div class="ibar_plugin_content"><div class="ibar_cart_group ibar_cart_product"><ul id="collect_ul_data">';
	var end = '</ul></div></div>';
	var mycollectview = "";
	if(checklogin())
	{
		$.ajax(
		{
			url: "/member/collect!myCollectIndex.action",
			type: "GET",
			cache: false,
			async: false,
			success: function(data) 
			{
				var s = eval(data);
				var lg = s.length;
				for(var i=0; i<lg; i++)
				{
					var id = s[i].id;
					var goods_name = s[i].goods_name;
					var goods_id = s[i].goodsid;
					var goods_price = s[i].pc_price;
					var goods_img = s[i].abbreviation_picture;
					if(goods_img == null || goods_img == '' || goods_img == undefined)
					{
						goods_img = "/web/images/300.jpg";
					}
					else
					{
						goods_img = global_image_url + goods_img;
					}
					mycollectview += "<li class='cart_item' id='collect_data_"+i+"'>"
					+'<div class="cart_item_pic">'
					+'<a href="/p/'+goods_id+'.html" target="_blank"><img src="'+goods_img+'" /></a>'
					+'</div>'
					+'<div class="cart_item_desc">'
					+'<a href="/p/'+goods_id+'.html" target="_blank" class="cart_item_name">'+goods_name+'</a>'
					+"<div class='cart_item_price'><a href='javascript:void(0)' onclick=removeCollect('"+id+"','"+i+"')>删除</a>"
					+'<span class="cart_price red">¥'+goods_price+'</span>'
					+'</div>'
					+'</div>'
					+'</li>';
				}
				if(lg > 6)
				{
					mycollectview += "<li class='readmore'><a href='/member/collect.action' target='blank'>查看更多收藏商品>></a></li>";
				}
				$(".pop_panel").html(start + mycollectview + end);
				if(lg == 0)
				{
					$(".pop_panel").html("<div class='cart-empty'><p>您没有收藏任何商品！</p></div>");
				}
			}
		 });
	}
	else
	{
		$(".pop_panel").html("<div class='cart-empty'><p>您没有收藏任何商品！</p></div>");
	}
}

//移除购物车数据
function removeCart(id, i)
{
	$.ajax(
	{
		url: "/carts/cart!del.action?id="+id,
		type: "GET",
		cache: false,
		async: false,
		success: function(data) 
		{
			if(data == 1)
			{
				//计算商品数
				var n = parseInt($.trim($(".cart_num").html()));
				var m = parseInt($.trim($("#cart_num_"+i).val()));
				var r = 0;
				if(n >= m)
				{
					r = n - m;
				}
				if(r <= 0)
				{
					r = 0;
				}
				$("#goods_total_num").html(r);
				$("#cart_data_"+i).remove();
				loadShoppingCartDatas();
			}
		}
	 });
}

//加载购物车数据
function loadShoppingCartDatas()
{
	var goods_total_num = 0;
	var goods_price_num = 0;
	var start = '<div class="ibar_plugin_content"><div class="ibar_cart_group ibar_cart_product"><ul id="cart_ul_data">';
	var cartcontents = "";
	$.ajax(
	{
		url: "/carts/cart!getCartList.action",
		type: "GET",
		cache: false,
		async: false,
		success: function(data) 
		{
			var s = eval(data);
			var lg = s.length;
			for(var i=0; i<lg; i++)
			{
				var id = s[i].itemid;
				var goods_name = s[i].goods_name;
				var goods_id = s[i].goodsid;
				var goods_price = parseFloat(s[i].pc_price);
				var goods_img = s[i].image_url;
				var quantity = parseInt(s[i].quantity);
				if(goods_img == null || goods_img == '' || goods_img == undefined)
				{
					goods_img = "/web/images/300.jpg";
				}
				else
				{
					goods_img = global_image_url + goods_img;
				}
				cartcontents += "<li class='cart_item' id='cart_data_"+i+"'>"
				+'<div class="cart_item_pic">'
				+'<a href="/p/'+goods_id+'.html" target="_blank"><img src="'+goods_img+'" /></a>'
				+'</div>'
				+'<div class="cart_item_desc">'
				+'<a href="/p/'+goods_id+'.html" target="_blank" class="cart_item_name">'+goods_name+'</a>'
				+"<div class='cart_item_price'><a href='javascript:void(0)' onclick=removeCart('"+id+"','"+i+"')>删除</a>"
				+'<span class="cart_price red">¥'+goods_price+' × '+quantity+'</span>'
				+'</div>'
				+'</div>'
				+'<input type="hidden" value="'+quantity+'" id="cart_num_'+i+'"/>'
				+'</li>';
				goods_total_num += quantity;
				goods_price_num += (quantity*goods_price);
			}
			
			
			goods_price_num = goods_price_num.toFixed(2);
			var end = '</ul></div></div><div class="cart_handler"><div class="cart_handler_header"><span class="cart_handler_left">共<span class="cart_price" id="goods_total_num">'+goods_total_num+'</span>件商品</span><span class="cart_handler_right" id="goods_price_num">¥'+goods_price_num+'</span></div><a href="/carts/cart!page.action" class="cart_go_btn clearfix clear" target="_blank">去购物车结算</a></div></div>';
			if(lg == 0)
			{
				$(".pop_panel").html("<div class='cart-empty'><p>购物车暂无商品<br/>快去添加吧！</p></div>");
				$(".cart_num").html("0");
			}
			else
			{
				$(".pop_panel").html(start + cartcontents + end);
				var rn = parseInt($.trim($("#goods_total_num").html()));
				var rm = "99+";
				if(rn <= 99)
				{
					rm = rn;
				}
				$(".cart_num").html(rm);
			}
		}
	 });
}
