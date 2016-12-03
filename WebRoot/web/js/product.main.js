$(function(){
	$.ajaxSetup ({
		 cache: false
    });
		 
});
function callBack(){
	var phone = $("#callid").val();
	if(phone==null||phone=="" || !phone.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/)){
		$alert("warn","请输入有效的11位手机号!",null,null);
			return;
	}
	jQuery.ajax({
	   type: "post",
	   url: "/member/saveCall!saveCall.action",	  
	   data:{"goodsId":$("#gid").val(),"call":phone},
	   success: function(data){
		   if(0==data.status){
			   $alert("warn",data.message,null,null);
		   }
		   if(1==data.status){
			   $confirm("warn","亲爱的用户：<br>" +
			   		"我们的专业药师正在为您接通电话，请稍等。<br>" +
			   		"请您留意电话来电。来电完全免费请放心接听，谢谢！<br>" +
			   		"--------------------------------------------------------------------<br>" +
			   		"如紧急，请拨打111医药馆专业药师热线400-606-3111进行咨询。"
					   ,null,function(result){});
		   }
	   },error:function(){
		   $alert("error","网络异常",null,null);
	   }
	}); 
}
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

$(function()
{
	$('.close-adv').click(function(){
		$('.product-adv').slideUp();	
	});
	if($("#specid"+$("#gid").val()).html()==null||$("#specid"+$("#gid").val()).html()==''){
		$("#cpggids").hide();
	}else{
		$("#specid"+$("#gid").val()).attr("class","cur");
	}
	jQuery.ajax(
	{
       type: "post",
       url: "/goods/goods!getGoodsInfo.action",	  
       data:{"id":$("#gid").val()},
       success: function(data){
	       if(data.promotion!=undefined&&data.promotion!=''){
	       		$("#promotiondivid").attr("style","");
	       		var html = "<p><b>满"+data.yf+"包邮</b>订单满"+data.yf+"元免运费</p>";
	       		html = html+"<p><b>"+data.promotion+"</b>"+data.advertise+"</p>";
				$("#promotiondividval").html(html);
	       }else{
	    	   $("#promotiondivid").attr("style","");
	       		var html = "<p><b>满"+data.yf+"包邮</b>订单满"+data.yf+"元免运费</p>";
				$("#promotiondividval").html(html);
	       }
	       if(''==data.obj.promotionId||null==data.obj.promotionId){
	    	   $("#jgmcid").html("本站价格：");
	       }else{
	    	   $("#jgmcid").html("抢购价格：");
	       }
	       if(data.obj.type==1){
	    	   $("#tymcid").addClass("list-tag-otc");
	       }
	       if(data.obj.type==2||data.obj.type==3){
	    	   $("#tymcid").addClass("list-tag-rx");
	       }
	       if(data.ykt==1){
	    	   $("#zffsid").append("<a class='way1' target='_blank' href='http://www.111yao.com/zt/medicalCard/'>医卡通</a>");
	       }
	       $("#pcPrice1").html("¥"+data.pcPrice);
	       if(data.obj.pcStatus!=1||data.obj.stock<=0||data.obj.type==3||data.obj.type==2){
    		$("#jiajian").remove();
    		$("#jrgwc").remove();
			$("#ljgm").remove();
	       }
       },error:function(){
    	   $alert("error","网络异常",null,null);
       }
   }); 
	jQuery.ajax({
       type: "post",
       url: "/goodsConsult/initAjaxGoodsConsult.action",	  
       data:{"goodsId":$("#gid").val()},
       success: function(data){
       		if(data.pages==0){
				$("#divpagingid1").hide();
			}else{
	      		var allData = "";
	      		for(var i=0; i<data.list.length; i++){
		      		if(data.list[i].answer==null){
		      			allData=allData+'<li><div class="qustion-text"><div class="question-time"><span>网友：'+data.list[i].userName+'</span><span>'+data.list[i].createStr+'</span></div><span>咨询内容：</span><p>'+data.list[i].consultContent+'</p></div></li>';
		      		}else{
				       	allData=allData+'<li><div class="qustion-text"><div class="question-time"><span>网友：'+data.list[i].userName+'</span><span>'+data.list[i].createStr+'</span></div><span>咨询内容：</span><p>'+data.list[i].consultContent+'</p></div>'+
				      	'<div class="answer-text"><span>药师回复：</span><p>'+data.list[i].answer+'</p></div></li>';
		      		}
            	}   
				$("#consultULId").append(allData);
				paging1(1,data.pages);
			}
       },error:function(){
    	   $alert("error","网络异常",null,null);
       }
   }); 
jQuery.ajax({
       type: "post",
       url: "/goodsComment/ajaxGoodsComment!ajaxGoodsComment.action",	  
       data:{"goodsId":$("#gid").val()},
       success: function(data){
       		//总评论数
       		$("#ztsspanid").html("("+data.totalNum+")");
       		$("#ztsspanid1").html("("+data.totalNum+")");
       		$("#ztsspanid2").html(data.totalNum);
       		
       		$("#bestid").html("("+data.bestNum+")");// 好评数
       		$("#betterid").html("("+data.betterNum+")");// 中评数
       		$("#poorid").html("("+data.poorNum+")");// 差评数
       		
      		$("#hpds").html(data.bestPercent+"<span>%</span>");
      		$("#hpds1").html("("+data.bestPercent+"%)");
      		$("#zpds").html("("+data.bettertPercent+"%)");
      		$("#cpds").html("("+data.poorPercent+"%)");
			$("#divh").attr("style","width:"+data.bestPercent+"%;");
			$("#divz").attr("style","width:"+data.bettertPercent+"%;");
			$("#divc").attr("style","width:"+data.poorPercent+"%;");
			if(data.pages==0){
				$("#divpagingid2").hide();
			}else{
	      		var allData = "";
	      		for(var i=0; i<data.list.length; i++){
	      			var headimg = data.list[i].headPortrait;
	      			if(null==headimg||""==headimg){
	      				headimg="static/image/temp/20151014/b09e2b114b6779b8fe47bcd8d38fe48a.png";
	      			}
					allData=allData+'<li class="clearfix clear"><div class="w380"><div class="column1"><div class="assess-text"><span style="margin-right:15px">'+data.list[i].comment+'</span><span>'+data.list[i].createDate+'</span></div></div></div>'+
					'<div class="w328"><div class="column2"><div class="start-bg"><span class="start start'+parseInt(data.list[i].sumFraction/4)+'"></span></div></div></div><div class="w300"><div class="column3"><dl class="assess-person">'+
					'<dt><img src="http://ui1.111yao.com/'+headimg+'"/>'+data.list[i].userName+'</dt></dl></div></div></li>';
            	}   
				$("#allData0").append(allData);
				paging(1,data.pages);
				if(data.pages==1){
					$("#divpagingid2").hide();
				}
			}
       },error:function(){
    	   $alert("error","网络异常",null,null);
       }
   });
   /** Attent the product */
   $(".interest-btn").click(function()
   {
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
   });
   /** Judging the attention when loading */
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
});

$(function(){
	$("#zxvalid").focus(function(){
		
		$.get("/goodsConsult/ifLogin!ifLogin.action",null,function(data) {
				if (data.status == 1) {
				} else if(data.status == 0) {
					//window.location.href = "../../../login/login!index.action?redirectUrl="+location.href;
					window.location.href="/login/login!index.action?redirectUrl="+window.location.href;
				}
			});
	});
});