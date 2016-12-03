


$(function(){
        //Marquee
        $('#marquee6').kxbdSuperMarquee({
            isMarquee:true,
            isEqual:false,
            scrollDelay:100,
            controlBtn:{up:'#goUM',down:'#goDM'},
            direction:'up'
        });
        //左侧边栏图标定位
        var oColTop = 0;
        if($('.product-box').length>0)
        {
    		oColTop = $('.product-main').offset().top;
    	}	
    	$(window).scroll(function(){
    		var scrTop = $(window).scrollTop() || document.documentElement.scrollTop;
    		scrTop-50 >= oColTop ? $(".nav-menu").addClass('Jfix'): $(".nav-menu").removeClass('Jfix');
    		
    	});
        //左侧边栏图标
        $('.nav-menu li a').hover(function()
        {
    		$(this).find('span').stop(true,true).fadeIn().css({"display":"block"});	
    	},
    	function()
    	{
    		$(this).find('span').stop(true,true).fadeOut();
    	});
    	
    	//左侧边栏图标点击事件
    	$('.nav-menu li').each(function(index)
    	{
    		$(this).click(function()
    		{
    			var j = $(this).index() + 1;
    			$(".tab-hd").children().eq(index).addClass("current").siblings().removeClass("current");
    			$(".tab-bd").children().eq(index).show().siblings().hide();
    			window.scroll(0,575);
    			//商品ID集合
    			var idsarray = "";
    			$("#erea_"+index).find("input").each(function(i)
    			{
    				var gid = $(this).val();
    				idsarray += gid + ",";
    			});
    			idsarray = idsarray.substring(0,idsarray.length-1);
    			var _idsarray = idsarray.split(",");
    			//封装数据
    		  	var ps = "";
    		  	for(var n=0; n<_idsarray.length; n++)
    		  	{
    		  		var hj = "price_"+j+"_obj_"+n;
    		  		var p1 = "{'goodsId':"+_idsarray[n]+",'nowPrice':'00.00','platform':'1','htmlObjId':'"+hj+"'}"; 
    		  		ps += p1 + ",";
    		  	}
    		  	ps = ps.substring(0,ps.length-1);
    		  	//动态获取价格
    		  	var p_start = "[" ;
    			var p_end = "]" ;
    			var params = p_start + ps + p_end ;
    		  	$.ajax
    			({
    				type: "get",
    				url: "http://www.111yao.com/index!countpricebyplatform.action",
    				data: "params="+params,
    				dataType: "jsonp",
    				jsonp: "jsoncallback",
    				success: function(data) 
    				{  
    					if(data != null && data != '' && data != undefined)
    					{
    						for(var i=0; i<data.length; i++)
    					    {
    							var nowPrice = data[i].nowPrice;
    							var htmlObjId = data[i].htmlObjId;
    							$("#"+htmlObjId).html(nowPrice);
    					    }
    					}
    					else
    					{
    						console.log("Datas null !"); 
    					}
    		        },  
    		        error: function() 
    		        {  
    		            console.log("Server error !"); 
    		        }  
    			});
    		});
    	});
    	
    });








$(function(){
    	
    	var j = 1;
			//商品ID集合
			var idsarray = "";
			$("#erea_0").find("input").each(function(i)
			{
				var gid = $(this).val();
				idsarray += gid + ",";
			});
			idsarray = idsarray.substring(0,idsarray.length-1);
			var _idsarray = idsarray.split(",");
			//封装数据
		  	var ps = "";
		  	for(var n=0; n<_idsarray.length; n++)
		  	{
		  		var hj = "price_"+j+"_obj_"+n;
		  		var p1 = "{'goodsId':"+_idsarray[n]+",'nowPrice':'00.00','platform':'1','htmlObjId':'"+hj+"'}"; 
		  		ps += p1 + ",";
		  	}
		  	ps = ps.substring(0,ps.length-1);
		  	//动态获取价格
		  	var p_start = "[" ;
			var p_end = "]" ;
			var params = p_start + ps + p_end ;
		  	$.ajax
			({
				type: "get",
				url: "/index!countpricefrompc.action",
				data: {"params":params},
				success: function(data) 
				{  
					if(data != null && data != '' && data != undefined)
					{
						for(var i=0; i<data.length; i++)
					    {
							var nowPrice = data[i].nowPrice;
							var htmlObjId = data[i].htmlObjId;
							$("#"+htmlObjId).html(nowPrice);
					    }
					}
					else
					{
						console.log("Datas null !"); 
					}
		        },  
		        error: function() 
		        {  
		            console.log("Server error !"); 
		        }  
			});
    	
    	
    	
        function tabs(tabTit,on,tabCon)
        {
            $(tabCon).each(function()
            {
                $(this).children().eq(0).show();
            });
            $(tabTit).each(function(){
                $(this).children().eq(0).addClass(on);
            });
            $(tabTit).children().hover(function()
            {
                $(this).addClass(on).siblings().removeClass(on);
                var index = $(tabTit).children().index(this);
                $(tabCon).children().eq(index).show().siblings().hide();
                
   	    			var j = $(this).index() + 1;
   	    			//商品ID集合
   	    			var idsarray = "";
   	    			$("#erea_"+index).find("input").each(function(i)
   	    			{
   	    				var gid = $(this).val();
   	    				idsarray += gid + ",";
   	    			});
   	    			idsarray = idsarray.substring(0,idsarray.length-1);
   	    			var _idsarray = idsarray.split(",");
   	    			//封装数据
   	    		  	var ps = "";
   	    		  	for(var n=0; n<_idsarray.length; n++)
   	    		  	{
   	    		  		var hj = "price_"+j+"_obj_"+n;
   	    		  		var p1 = "{'goodsId':"+_idsarray[n]+",'nowPrice':'00.00','platform':'1','htmlObjId':'"+hj+"'}"; 
   	    		  		ps += p1 + ",";
   	    		  	}
   	    		  	ps = ps.substring(0,ps.length-1);
   	    		  	//动态获取价格
   	    		  	var p_start = "[" ;
   	    			var p_end = "]" ;
   	    			var params = p_start + ps + p_end ;
   	    		  	$.ajax
   	    			({
   	    				type: "get",
   	    				url: "/index!countpricefrompc.action",
   	    				data: {"params":params},
   	    				success: function(data) 
   	    				{  
   	    					if(data != null && data != '' && data != undefined)
   	    					{
   	    						for(var i=0; i<data.length; i++)
   	    					    {
   	    							var nowPrice = data[i].nowPrice;
   	    							var htmlObjId = data[i].htmlObjId;
   	    							$("#"+htmlObjId).html(nowPrice);
   	    					    }
   	    					}
   	    					else
   	    					{
   	    						console.log("Datas null !"); 
   	    					}
   	    		        },  
   	    		        error: function() 
   	    		        {  
   	    		            console.log("Server error !"); 
   	    		        }  
   	    			});
            });
        }
        tabs(".tab-hd","current",".tab-bd");
    });