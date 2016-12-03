<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="">
    <!-- keywords -->
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>找回密码</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="img/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="img/favicon-196x196.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="img/apple-icon-touch.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <link rel="stylesheet" type="text/css" href="${base}/web/css/login/common.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/login/login.css"/>
    <script src="${base}/web/js/jquery.min.js" type="text/javascript"></script>
    <style>
    input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {color: #999; } 
	input:-moz-placeholder, textarea:-moz-placeholder { color: #999; } 
	input::-moz-placeholder, textarea::-moz-placeholder { color: #999; } 
	input:-ms-input-placeholder, textarea:-ms-input-placeholder { color: #999; } 
    #usernamewarn1 {display: none;}
    #usernamewarn2 {display: none;}
    #right1 {display: none;}
    
    #codewarn1 {display: none;}
    #codewarn2 {display: none;}
    </style>
</head>
<body class="login-bg">
<div class="login-wrap">
    <div class="login-title">
       <#include "/static/imgout/version2.2.0/header_logo.html">
        <b class="forget-tit">找回密码</b>
    </div>
    <div class="login-content">
        <!--进度条-->
        <div class="process-bra clear clearfix">
            <ul>
                <li class="state-tip finish-tip"><b>1</b><span class="doing-tit">填写账户信息</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip"><b>2</b><span>选择找回方式</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>3</b><span>验证身份</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>4</b><span>设置新密码</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>5</b><span>完成</span></li>
            </ul>
        </div>
        <div class="login-list-center">
            <dl class="import-message">
                <dt>账号：</dt>
                <dd>
                    <input type="text" class="impart-text" placeholder="用户名/手机号/邮箱" id="username"/>
                    <span class="import-wrong" id="usernamewarn1">请输入账号</span>
					<span class="import-wrong" id="usernamewarn2">账号输入错误</span>
                    <span class="import-correct" id="right1"></span>
                </dd>
            </dl>
            <dl class="import-message">
                <dt>验证：</dt>
                <dd class="impart-dd">
                    <input type="text"  class="impart-code" placeholder="请输入验证码" id="code"/>
                    <img src="${base}/static/inc/number.jsp?,Math.random();" id="changeSrcCode" alt="" class="code-img"/>
                    <a href="#" class="see-no" id="changeCode" >看不清换一张</a>
                    <span class="import-wrong" id="codewarn1">请您输入验证码</span>
					<span class="import-wrong" id="codewarn2">您输入的验证码不正确，请重新输入</span>
                </dd>
            </dl>
            <div class="login-button"><input type="button" value="确定" id="nextStep1"/></div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
$(function(){
	var $username = $("#username");
	var $code = $("#code");
	var flag=false;
	var result=false;
	// 更换验证码
	$("#changeCode").click(function(){
		 var img = document.getElementById("changeSrcCode");   
   			 img.src = "${base}/static/inc/number.jsp?" + Math.random();
		});	
	$("#changeSrcCode").click(function(){
		 var img = document.getElementById("changeSrcCode");   
   			 img.src = "${base}/static/inc/number.jsp?" + Math.random();
		});	
	$username.blur(function(){
          var  username = $("#username").val();          
          if( $.trim(username)==null || $.trim(username)==""){
            $("#usernamewarn1").hide().parent().removeClass("border-red");
			$("#usernamewarn2").hide();
			$("#right1").hide();
			return false;
	      }else{
			    $.ajax({
				    url: "${base}/findpassword/findpassword!checkUserIsExist.action",
				    type: "GET",
				 	data: { username: $("#username").val() },
				  	cache: false,
			      	success: function(data) {
					if(data !=0){
					 $("#usernamewarn2").show().parent().addClass("border-red");
					 $("#usernamewarn1").hide();
					 $("#right1").hide();
					 flag=false;
					 return false;
					}else{
						$("#right1").show().parent().removeClass("border-red");
						$("#usernamewarn1").hide();
						$("#usernamewarn2").hide();
						 flag=true;;
					}
				}
			   });
		  } 
		 return flag;
	  });
	$code.blur(function(){
		var code = $(this).val();
		if(code==null || $.trim(code) == ""){
			$("#codewarn1").hide().parent().removeClass("border-red");
			$("#codewarn2").hide();
			return false;
		}else{
			$.ajax({
				url: "${base}/findpassword/findpassword!checkCodeIsExist.action",
				data:{
				code:$.trim($code.val()),
				},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
					if(data==0){
						$("#codewarn2").show().parent().addClass("border-red");
						$("#codewarn1").hide();
						 result=false;
						return false;
					}else{
						$("#codewarn1").hide().parent().removeClass("border-red");
						$("#codewarn2").hide().parent().removeClass("border-red");
						 result=true;
					}
				}
		   });
		}
		return result;
	});
	  $("#nextStep1").click(function(){
	  var username=$("#username").val();
	  if( $.trim(username)==null || $.trim(username)==""){
            $("#usernamewarn1").show().parent().addClass("border-red");;
			$("#usernamewarn2").hide();
			$("#right1").hide();
			return false;
	      }
	    var code = $("#code").val();
		if(code==null || $.trim(code) == ""){
			$("#codewarn1").show().parent().addClass("border-red");;
			$("#codewarn2").hide();
			return false;
		}
	   if(!($username.triggerHandler("blur"))){
	 			$username.triggerHandler("blur");
	 			if(flag==false){
	 				return false;
	 			}
 			}
 	  if(!($code.triggerHandler("blur"))){
	 			$code.triggerHandler("blur");
	 			if(result==false){
	 				return false;
	 			}
 			}
	  location.href="${base}/findpassword/findpassword!chooseFindMethod.action?username="+username;
	  });
});
</script>
</html>