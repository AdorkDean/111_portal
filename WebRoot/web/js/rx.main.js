$(function()
{
	//防止缓存
	$.ajaxSetup (
	{
		 cache: false
    });
	
	//规格定位
	var new_goods_id = $.trim($("#gid").val());
	$("#specid_"+new_goods_id).css({"border":"#fe4310 2px solid","padding":"0 9px"});
	
	//咨询内容
	RX.getConsultData(2);
	
	//关闭广告
	$('.close-adv').click(function(){
		$('.product-adv').slideUp();	
	});
	
	//产品规格
	//RX.spec();
	
	//获取商品价格/OTC/RX判断
	RX.getPriceOTCRX();
	
    //关注商品
    $(".interest-btn").click(function()
    {
	   RX.attention();
    });
   
	//判断是否关注过商品
	RX.isAttention();
	
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

	//最顶部导航样式改变
	$(".header-nav-fixed").css({"position":"relative"});
	$(".logo-search-cart").css({"margin-top":"0px"});
	
	//是否显示提交需求按钮
	RX.showBtnOrNot();
	
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


var pageNo = 1;
var pageSize = 10;
var RX = 
{
	//电话回拨
	callBack : function()
	{
		var phone = $("#callid").val();
		if(phone == null || phone == "" || !phone.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$/))
		{
			$alertCanDisplay("warn","请输入有效的11位手机号!",null,null);
			return;
		}
		jQuery.ajax(
		{
		   type: "post",
		   url: "/member/saveCall!saveCall.action",	  
		   data:{"goodsId":$("#gid").val(),"call":phone},
	       async: false,
	       cache: false,
		   success: function(data)
		   {
			   if(0 == data.status)
			   {
				   $alertCanDisplay("warn",data.message,null,null);
			   }
			   if(1 == data.status)
			   {
				   var result = "亲爱的用户：<br>"  
					          + "我们的专业药师正在为您接通电话，请稍等。<br>" 
					          + "请您留意电话来电。来电完全免费请放心接听，谢谢！<br>" 
					          + "--------------------------------------------------------------------<br>" 
				              + "如紧急，请拨打111医药馆专业药师热线400-606-3111进行咨询。";
				   
				   $confirm("warn", result, null, function(result){});
			   }
		   },
		   error:function()
		   {
			   $alertCanDisplay("error","网络异常",null,null);
		   }
		}); 
	},
	//咨询内容框产生焦点
	focus : function()
	{
		$.get("/goodsConsult/ifLogin!ifLogin.action",null,function(data) 
		{
			if(data.status == 0) 
			{
				window.location.href="/login/login!index.action?redirectUrl="+window.location.href;
			}
		});
	},
	//咨询内容提交
	submit : function()
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
	},
	//获取咨询内容
	getConsultData : function(type)
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
	},
	//产品规格
	spec : function()
	{
		if($("#specid"+$("#gid").val()).html() == null || $("#specid"+$("#gid").val()).html() == '')
		{
			$("#rx_spec_con").hide();
			$("#cpggids").css("margin-bottom","20px");
		}
		else
		{
			$("#specid"+$("#gid").val()).attr("class","cur");
		}
	},
	//获取商品价格/OTC/RX判断
	getPriceOTCRX : function()
	{
		jQuery.ajax(
		{
			type: "post",
	        url: "/goods/goods!getGoodsDetail.action",	  
	        data:{"id":$("#gid").val()},
	        success: function(data)
	        {
	    	   /*OTC
		       if(data.obj.type == 1)
		       {
		    	   $("#tymcid").addClass("list-tag-otc");
		       }
		       //RX
		       if(data.obj.type == 2 || data.obj.type == 3)
		       {
		    	   $("#tymcid").addClass("list-tag-rx");
		       }*/
		       //价格
		       $("#pcPrice1").html("¥"+data.pcPrice);
	         },
	         error:function()
	         {
	        	 $alertCanDisplay("error","网络异常",null,null);
	         }
	     }); 
	},
	//关注商品
	attention : function() 
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
		   window.location.href = "/login/login!index.action?redirectUrl="+location.href;
	   }
	},
	//判断是否关注过商品
	isAttention : function()
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
	},
	//是否显示提交需求按钮
	showBtnOrNot : function()
	{
	   var $id = $.trim($("#gid").val());
	   $.ajax(
	   {
			url: "/index!jugeStatus.action?id="+$id,
			type: "POST",
			cache: false,
			async: false,
			success: function(data) 
			{
				if(data == 1)
				{
					$(".rx-submit-btn").show();
				}
				if(data == 2)
				{
					$(".rx-submit-btn").hide();
				}
				if(data == 3)
				{
					$(".rx-submit-btn").show();
				}
				if(data == 4)
				{
					$(".rx-submit-btn").hide();
				}
			}
		});
	},
	//提交需求
	submitNeeds : function()
	{
		var $id = $.trim($("#gid").val());
		if(checklogin())
		{
			window.location.href = "/member/reserveOrder!toReserveOrderAdd.action?goodsId="+$id;
		}
		else
		{
			window.location.href = "/login/login!index.action?redirectUrl="+location.href;
		}
	},
	//标签选项点击事件
	selectCon : function(obj,curIndex)
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
			$("#rx-xgwd").show();
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
		if(curIndex == 10)
		{
			$("#rx-instroduce").hide();
			$("#rx-zzzm").hide();
			$("#rx-xgwd").hide();
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
		if(curIndex == 1)
		{
			$("#rx-instroduce").hide();
			$("#rx-docs").hide();
			$("#rx-zzzm").show();
			$("#rx-xgwd").hide();
			
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
		//相关问答
		if(curIndex == 2)
		{
			$("#rx-instroduce").show();
			$("#rx-xgwd").show();
			$("#rx-docs").hide();
			$("#rx-zzzm").hide();
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
};





