$(function()
{
	$.ajaxSetup (
	{
		 cache: false
    });
	
	//规格定位
	var new_goods_id = $.trim($("#gid").val());
	$("#specid_"+new_goods_id).css({"border":"#fe4310 2px solid","padding":"0 9px"});
	
	//动态获取价格
	getDbPrice();
	
	//判断是否关注过商品
	isAttention();
	
	//产品数量减操作
	$(".count-min").click(function()
	{
		var obj = $(".product_nums_in");
		var v = parseInt($.trim(obj.val()));
		if(v > 1)
		{
			obj.val(v-1);
		}
	});
	
	//产品数量加操作
	$(".count-plus").click(function()
	{
		var obj = $(".product_nums_in");
		var v = parseInt($.trim(obj.val()));
		if(v < 199)
		{
			obj.val(v+1);
		}
	});
	
	//产品数量失去焦点事件
	$(".product_nums_in").blur(function()
	{
		var obj = $(".product_nums_in");
		var v = parseInt($.trim(obj.val()));
		if(v > 199)
		{
			obj.val(199);
		}
		if(v <= 0)
		{
			obj.val(1);
		}
	});
	
	//定位标签选项卡
	var oColTop = $('.product-sub').offset().top;
	$(window).scroll(function()
	{
		var scrTop = $(window).scrollTop() || document.documentElement.scrollTop;
		scrTop >= oColTop ? $("#rx-product-list-title").addClass('Jfix'): $("#rx-product-list-title").removeClass('Jfix');
		
		/*隐藏按分类搜索内容
		if($(".classify_find_category").hasClass("classify_nav_show"))
		{
			$(".classify_find_category").removeClass("classify_nav_show");
			$(".classify_find_category").find("i").removeClass("off");
			$(".product_nav_category").hide();
			$(".classify_nav_icon").hide();
		}*/
	});
	
	//加载咨询内容
	getConsultData(2);
	
	//获取商品评论信息
	getGoodsCritique();
	
	//咨询问题框参数焦点
	$("#zxvalid").focus(function()
	{
		$.get("/goodsConsult/ifLogin!ifLogin.action",null,function(data) 
		{
			if(data.status == 1) 
			{
			} 
			else if(data.status == 0) 
			{
				window.location.href="/login/login!index.action?redirectUrl="+window.location.href;
			}
		});
	 });
	
	 //初始化产品数量
	 $(".product_nums_in").val(1);
	 
	 //按分类找药
	 $(".classify_find_category").click(function()
	 {
		if($(this).hasClass("classify_nav_show"))
		{
			$(this).removeClass("classify_nav_show");
			$(this).find("i").removeClass("off");
			$(".product_nav_category").hide();
			$(".classify_nav_icon").hide();
		}
		else
		{
			$(this).addClass("classify_nav_show");
			$(this).find("i").addClass("off");
			var top = $(".search").offset().top+50;
			$(".product_nav_category").css({"top":top,"left":0}).show();
			$(".classify_nav_icon").show();
			$('.first-stmenu').find('.nav-dropdown').addClass('navhover');
			$('.first-stmenu').find('.children').show();
		}
  	 });
});

function zixun()
{
    var vs = $("#zxvalid").val();
	if($.trim(vs).length>=4)
	{
		jQuery.ajax(
		{
	       type: "post",
	       url: "/goodsConsult/saveGoodsConsult!saveGoodsConsult.action",	  
	       data:{"goodsId":$("#gid").val(),"consultContent":vs},
	       success: function(data){
	    	   if(data.status==0){
	    		   $alert("warn",data.message,function(){
	    			   //alert(window.location.href);
	    			   window.location.href="../../../login/login!index.action?redirectUrl="+window.location.href;
	    		   },12000);
	    		   
	    	   }else if(data.status==1){
	    		   $alert("success",data.message,null,null);
	    		   $("#zxvalid").text();
	    	   }else{
	    		   $alert("warn",data.message,null,null);
	    	   }
	       },error:function(){
	    	   $alert("error","网络异常",null,null);
	       }
	    }); 
	}
	else
	{
		$alert("warn","咨询内容过短!",null,null);
	}
} 

//获取商品价格
function getDbPrice() 
{
	var goodsId = $.trim($("#gid").val());
	jQuery.ajax(
	{
       type: "POST",
       url: "/goods/goods!getGoodsDetail.action",	  
       data:{"id": goodsId},
       success: function(data)
       {
    	   if(data != null && data != "" && data != undefined)
    	   {
    		   if(data.ykt == 1)
    		   {
    			   $("#pay_ways").append("<a class='way1'>医卡通支付</a>");
    		   }
    		   if(data.stock == 0)
    		   {
    			   $(".buy-now-btn").hide();
    			   $(".into-cart-btn").hide();
    		   }
    		   if(data.pc_status == 2)
    		   {
    			   $(".buy-now-btn").hide();
    			   $(".into-cart-btn").hide();
    		   }
    		   $("#new_pc_price").html(data.pcPrice);
    	   }
       },
       error:function()
       {
    	   $alertCanDisplay("error","网络异常",null,null);
       }
   });
}

//标签选项点击事件
function selectCon(obj,curIndex)
{
	$("#tab-hd3 li").each(function(index)
	{
		if(index != curIndex)
		{
			$(this).removeClass("active2");
		}
	});
	var offsetTop = 0;
	//商品介绍
	if(curIndex == 0)
	{
		$("#rx-instroduce").show();
		$("#rx-docs").hide();
		$("#rx-zzzm").hide();
		$("#rx-xgwd").hide();
		$("#rx-yhpj").hide();
		if($("#rx-product-list-title").hasClass('Jfix'))
		{
			offsetTop = $("#rx-instroduce").offset().top;
		}
		else
		{
			offsetTop = $("#rx-instroduce").offset().top-40;
		}
		$('body,html').animate({scrollTop:offsetTop},1000);
	}
	//说明书
	if(curIndex == 1)
	{
		$("#rx-instroduce").hide();
		$("#rx-zzzm").hide();
		$("#rx-xgwd").hide();
		$("#rx-yhpj").hide();
		$("#rx-docs").show();
		if($("#rx-product-list-title").hasClass('Jfix'))
		{
			offsetTop = $("#rx-docs").offset().top-29;
		}
		else
		{
			offsetTop = $("#rx-docs").offset().top-70;
		}
		$('body,html').animate({scrollTop:offsetTop},0);
	}
	//荣誉资质
	if(curIndex == 2)
	{
		$("#rx-instroduce").hide();
		$("#rx-docs").hide();
		$("#rx-zzzm").show();
		$("#rx-xgwd").hide();
		$("#rx-yhpj").hide();
		if($("#rx-product-list-title").hasClass('Jfix'))
		{
			offsetTop = $("#rx-zzzm").offset().top-10;
		}
		else
		{
			offsetTop = $("#rx-zzzm").offset().top-50;
		}
		$('body,html').animate({scrollTop:offsetTop},0);
	}
	//用户评价
	if(curIndex == 3)
	{
		$("#rx-instroduce").hide();
		$("#rx-docs").hide();
		$("#rx-zzzm").hide();
		$("#rx-xgwd").hide();
		$("#rx-yhpj").show();
		
		if($("#rx-product-list-title").hasClass('Jfix'))
		{
			offsetTop = $("#rx-yhpj").offset().top-30;
		}
		else
		{
			offsetTop = $("#rx-yhpj").offset().top-70;
		}
		$('body,html').animate({scrollTop:offsetTop},0);
	}
	//相关问答
	if(curIndex == 4)
	{
		$("#rx-instroduce").show();
		$("#rx-xgwd").show();
		$("#rx-docs").hide();
		$("#rx-zzzm").hide();
		$("#rx-yhpj").hide();
		offsetTop = $("#rx-xgwd").offset().top-85;
		$('body,html').animate({scrollTop:offsetTop},1000);
	}
	if(obj == 'docs-rx')
	{
		$("#"+obj).addClass("active2");
		offsetTop = $("#rx-docs").offset().top-69;
		$('body,html').animate({scrollTop:offsetTop},0);
	}
	else
	{
		$(obj).addClass("active2");
	}
}

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

//判断是否关注过商品
function isAttention()
{
   if(checklogin())
   {
	   var $id = $.trim($("#gid").val());
	   $.ajax(
	   {
			url: "/index!isuserattentioned.action?proid="+$id+"&ctype=0",
			type: "GET",
			cache: false,
			async: false,
			success: function(data) 
			{
				   if(data == 0)
				   {
					   $(".attention-img").css("background","url(/web/images/red_heart.png) no-repeat");
				   }
				   else
				   {
					   $(".attention-img").css("background","url(/web/images/gray_heart.png) no-repeat");
				   }
			}
		});
   }
   else
   {
	   $(".attention-img").css("background","url(/web/images/gray_heart.png) no-repeat");
   }
}

//关注商品
function attention() 
{
   var $id = $.trim($("#gid").val());
   if(checklogin())
   {
	   $.ajax(
	   {
			url: "/index!attentionpro.action?proid="+$id+"&ctype=0",
			type: "GET",
			cache: false,
			async: false,
			success: function(data) 
			{
			   if(data == 1)
			   {
				   $(".attention-img").css("background","url(../web/images/red_heart.png) no-repeat");
			   }
			   else
			   {
				   $(".attention-img").css("background","url(../web/images/gray_heart.png) no-repeat");
			   }
			}
	    });
   }
   else
   {
	   window.location.href = "/login/login!index.action?redirectUrl="+location.href;
   }
}

//获取咨询内容
var pageNo = 1;
var pageSize = 10;
function getConsultData(type)
{
	if(type == 1)
	{
		$(".rx-a-more").hide();
		$(".rx-loading-img").show();
	}
	
	window.setTimeout(function()
	{
		var allData = "";
		var goodsId = $.trim($("#gid").val());
		jQuery.ajax(
		{
	       type: "GET",
	       url: "/goodsConsult/showGoodsConsults.action?pageNo="+pageNo+"&pageSize="+pageSize+"&goodsId="+goodsId,
	       async: false,
	       cache: false,
	       success: function(data)
	       {
	    	   pageNo += 1;
	    	   if(data != null && data.length > 0)
	    	   {
	    		   for(var i=0; i<data.length; i++)
	    		   {
	    			   var username = (data[i].user_name+"").substring(0,1)+"***";
	    			   var answer = data[i].answer;
	    			   if(answer == 'null' || answer == '' || answer == undefined)
	    			   {
	    				   answer = "请等药师稍后联系您吧！";
	    			   }
	    			   allData = allData+'<li><div class="qustion-text"><div class="question-time"><span>网友：'+ username +'</span><span>'+data[i].create_date+'</span></div><span id="rx_zxnr_title">咨询内容：</span><p id="rx_zxnr_cons">'+data[i].consult_content+'</p></div>'+
    				   '<div class="answer-text"><span id="rx_yshf_title">药师回复：</span><p id="rx_yshf_cons">'+answer+'</p></div></li>';
	    		   }
	    		   $(".rx-a-more").show();
	    	   }
	    	   else
	    	   {
	    		   var msg = "暂无问答！";
	    		   if(pageNo != 2)
	    		   {
	    			   msg = "没有更多问答了！";
	    		   }
	    		   allData = "<li class='rx-no-data'>( ^_^ )"+msg+"</li>";
	    		   $(".rx-load-more").hide();
	    	   }
	    	   $("#consultULId").append(allData);
			   $(".rx-loading-img").hide();
	       },
	       error:function()
	       {
	    	   $alertCanDisplay("error","网络异常",null,null);
	    	   $(".rx-a-more").show();
	    	   $(".rx-loading-img").hide();
	       }
	   }); 
	}, 1000);
}

//咨询内容框产生焦点
function focus()
{
	$.get("/goodsConsult/ifLogin!ifLogin.action",null,function(data) 
	{
		if(data.status == 0) 
		{
			window.location.href="/login/login!index.action?redirectUrl="+window.location.href;
		}
	});
}

//咨询内容提交
function submit()
{
	var vs = $("#zxvalid").val();
	if($.trim(vs).length>=4)
	{
		jQuery.ajax(
		{
	       type: "post",
	       url: "/goodsConsult/saveGoodsConsult!saveGoodsConsult.action",	  
	       data:{"goodsId":$("#gid").val(),"consultContent":vs},
	       async: false,
	       cache: false,
	       success: function(data)
	       {
	    	   if(data.status == 0)
	    	   {
	    		  $alertCanDisplay("warn",data.message,function()
	    		  {
	    			   window.location.href="../../../login/login!index.action?redirectUrl="+window.location.href;
	    		  },12000);
	    		   
	    	   }
	    	   else if(data.status == 1)
	    	   {
	    		   $alertCanDisplay("success",data.message,null,null);
	    		   $("#zxvalid").val("");
	    	   }
	    	   else
	    	   {
	    		   $alertCanDisplay("warn",data.message,null,null);
	    		   $("#zxvalid").val("");
	    	   }
	       },
	       error:function()
	       {
	    	   $alertCanDisplay("error","网络异常",null,null);
	       }
	    }); 
	}
	else
	{
		$alertCanDisplay("warn","咨询内容过短！",null,null);
	}
}

//获取商品评论信息
function getGoodsCritique()
{
	var pageSize = 10;
	var gid = $.trim($("#gid").val());
	jQuery.ajax(
	{
	       type: "POST",
	       url: "/goodsComment/ajaxGoodsComment!ajaxGoodsComment.action",	  
	       data:{"goodsId":gid, "pageSize": pageSize},
	       success: function(data)
	       {
	       		//评论数
	    	    $(".cris").html("("+data.totalNum+")");
	       		$("#ztsspanid").html("（"+data.totalNum+"）");
	       		$("#ztsspanid1").html("（"+data.totalNum+"）");
	       		$("#ztsspanid2").html(data.totalNum);
	       		//为隐含域赋值
	       		$("#totalCri").val(data.totalNum);
	       		$("#goodCri").val(data.bestNum);
	       		$("#middleCri").val(data.betterNum);
	       		$("#poorCri").val(data.poorNum);
	       		
	       		$("#bestid").html("（"+data.bestNum+"）");//好评数
	       		$("#betterid").html("（"+data.betterNum+"）");//中评数
	       		$("#poorid").html("（"+data.poorNum+"）");//差评数
	       		
	      		$("#hpds").html(data.bestPercent+"<span>%</span>");
	      		$("#hpds1").html("（"+data.bestPercent+"%）");
	      		$("#zpds").html("（"+data.bettertPercent+"%）");
	      		$("#cpds").html("（"+data.poorPercent+"%）");
				$("#divh").attr("style","width:"+data.bestPercent+"%;");
				$("#divz").attr("style","width:"+data.bettertPercent+"%;");
				$("#divc").attr("style","width:"+data.poorPercent+"%;");
				if(data.pages == 0)
				{
					$("#divpagingid2").hide();
				}
				else
				{
		      		var allData = "";
		      		for(var i=0; i<data.list.length; i++)
		      		{
		      			var headimg = data.list[i].headPortrait;
		      			if(null==headimg||""==headimg)
		      			{
		      				headimg = "static/image/temp/20151014/b09e2b114b6779b8fe47bcd8d38fe48a.png";
		      			}
						allData += '<li class="clearfix clear"><div class="w380"><div class="column1"><div class="assess-text"><span style="margin-right:15px">'+data.list[i].comment+'</span><span>'+data.list[i].createDate+'</span></div></div></div>'+
						'<div class="w328"><div class="column2"><div class="start-bg"><span class="start start'+parseInt(data.list[i].sumFraction/4)+'"></span></div></div></div><div class="w300"><div class="column3"><dl class="assess-person">'+
						'<dt><img src="http://ui1.111yao.com/'+headimg+'"/>'+data.list[i].userName+'</dt></dl></div></div></li>';
		      		}   
					$("#allData0").append(allData);
					paging(1,data.pages,pageSize);
					if(data.pages == 1)
					{
						//$("#divpagingid2").hide();
					}
				}
	       },
	       error:function()
	       {
	    	   $alertCanDisplay("error","网络异常",null,null);
	       }
	  });
}
