 $(function()
 {
	 getSearchTips("六");
	 
	 //搜素参数传递
	 var vurl = window.location.href;
	 if(vurl.indexOf("slist") > 0)
	 {
		 var vsearch = vurl.split("/");
		 $(".header-search-input").val(decodeURI(decodeURI(vsearch[3])));
	 }
	 
	 //搜索
	 $(".header-search-btn").click(function()
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
			console.log("a");
			getSearchTips(keyword);
		}
		var theEvent = e || window.event;    
	    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;  
	    if(code == 13)
	    {  
	    	$(".header-search-btn").click();
	    } 
	})
	.keydown(function(e)
	{
		keyword = encodeURI(encodeURI($.trim($(".header-search-input").val())));
		if(keyword != null && keyword != '' && keyword != undefined)
		{
			console.log("a");
			getSearchTips(keyword);
		}
		var theEvent = e || window.event;    
	    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;  
	    if(code == 13)
	    {  
	    	$(".header-search-btn").click();
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
    	   var aim = json+"";
		   var array = aim.split(",");
		   console.log("success");
		   $(".header-search-input").autocomplete({source: array});
       },
       error: function()
       {
    	   console.log("error");
       }
    }); 
 }
