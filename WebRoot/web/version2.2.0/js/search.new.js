 $(function()
 {
	 //初始化搜索交互
	 getSearchTips("六");
	 
	 //弹出搜索历史记录
	 var sets = showSearchRecord();
	 
	 //搜素参数传递
	 var vurl = window.location.href;
	 if(vurl.indexOf("slist") > 0)
	 {
		 var vsearch = vurl.split("/");
		 $(".header-search-input").val(decodeURI(decodeURI(vsearch[3])));
	 }
	 
	 $("#header-search-btn").click(function()
	 {
		 var $inputObj = $(".header-search-input");
		 if($.trim($inputObj.val()) != null && $.trim($inputObj.val()) != '' && $.trim($inputObj.val()) != '请输入搜索的内容...')
		 {
			 window.location.href = "/"+$.trim($inputObj.val())+"/slist.html";
		 }
		 else
		 {
			 $inputObj.focus();
		 }
	 });
	
	var keyword = "";
	$(".header-search-input").keyup(function(e)
	{
		keyword = encodeURI(encodeURI($.trim($(".header-search-input").val())));
		if(keyword != null && keyword != '' && keyword != undefined)
		{
			getSearchTips(keyword);
		}
		var theEvent = e || window.event;    
	    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;  
	    if(code == 13)
	    {  
	    	$("#header-search-btn").click();
	    }
	})
	.keydown(function(e)
	{
		keyword = encodeURI(encodeURI($.trim($(".header-search-input").val())));
		if(keyword != null && keyword != '' && keyword != undefined)
		{
			getSearchTips(keyword);
		}
		var theEvent = e || window.event;    
	    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;  
	    if(code == 13)
	    {  
	    	$("#header-search-btn").click();
	    } 
	})
	.focus(function(e)
	{
		var v = $(this).val();
		if(v != "" && v != null && v != undefined)
		{
		}
		else
		{
			var tips = "<span><a>nul</a></span><span class=clear_cookie_set><b>清除最近搜索记录</b></span>";
			if(sets != tips)
			{
				$(".autocomplete_ui").html("");
				var sets2 = showSearchRecord();
				if(sets2 != tips)
				{
					var left = $(this).offset().left;
					var top = $(this).offset().top+17;
					$(".autocomplete_ui").css({"left":left, "top":top}).show();
				}
			}
		}
	})
	.blur(function(e)
	{
		 var flag = false;
		 $(".autocomplete_ui span").each(function(index)
		 {
			 if($(this).hasClass("autocomplete_ui_span_hover"))
			 {
				 flag = true;
			 }
			 if($(this).hasClass("autocomplete_ui_span_hover2"))
			 {
				 clearCookieSets();
			 }
		 });
		 if(!flag)
		 {
			 $(".autocomplete_ui").hide();
		 }
	});
 });
 
 function getSearchTips(keyword)
 {
	$.ajax(
    {
       type: "GET",
       url: "/index!getshortname.action?shortname="+keyword,
       async: false,
       cache: false,
       success: function(json)
       {
    	   $(".autocomplete_ui").hide();
    	   var aim = json+"";
		   var array = aim.split(",");
		   console.log("success");
		   try
		   {
			   $(".header-search-input").autocomplete({source: array});
		   }catch(e){}
       },
       error: function()
       {
    	   console.log("error");
       }
    }); 
 }
 
 function cookieSearch(kw)
 {
	 window.location.href = "/"+kw+"/slist.html";
 }
 
 //清除最近的搜索记录
 function clearCookieSets()
 {
	 delCookie("kws");
	 $(".autocomplete_ui").hide();
	 console.log("删除后的cookies= "+decodeURIComponent(getCookie("kws")));
 }
 
 //弹出最近的搜索记录
 function showSearchRecord()
 {
	 var kw = invertStr(decodeURIComponent(getCookie("kws")), "@", 1);
	 console.log("search.new.js.kw = "+kw);
	 var sets = "";
	 if(kw != null && kw != '' && kw != undefined)
	 {
		 var kws = kw.split("@");
		 for(var i = 0; i<10; i++)
		 {
			 if(kws[i] != null && kws[i] != '' && kws[i] != undefined)
			 {
				 sets += "<span><a>"+kws[i]+"</a></span>";
			 }
		 }
		 sets += "<span class=clear_cookie_set><b>清除最近搜索记录</b></span>";
		 $(".autocomplete_ui").append(sets);
		 //赋予元素事件
		 $(".autocomplete_ui span").each(function(index)
		 {
			 var obj = $(this);
			 obj.find("a").click(function()
			 {
				 cookieSearch($.trim($(this).html()));
			 });
			 obj.find("a").mouseover(function()
			 {
				 obj.css({"border":"#ccc 1px solid"}).addClass("autocomplete_ui_span_hover");
			 });
			 obj.find("a").mouseleave(function()
			 {
				 obj.css({"border":"#fff 1px solid"}).removeClass("autocomplete_ui_span_hover");
			 });
			 obj.find("b").mouseover(function()
			 {
				 obj.addClass("autocomplete_ui_span_hover2");
			 });
			 obj.find("b").mouseleave(function()
			 {
				 obj.removeClass("autocomplete_ui_span_hover2");
			 });
		  });
	 }
	 return sets;
 }
 
 