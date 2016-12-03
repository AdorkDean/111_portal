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
    #passwordwarn1 {display: none;}
    #passwordwarn2 {display: none;}
    #passwordwarn3 {display: none;}
    #right1 {display: none;}
    #right2 {display: none;}
    #repasswordwarn1 {display: none;}
    #repasswordwarn2 {display: none;}
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
                <li class="state-tip"><b>1</b><span>填写账户信息</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>2</b><span>选择找回方式</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>3</b><span>验证身份</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip finish-tip"><b>4</b><span class="doing-tit">设置新密码</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip"><b>5</b><span>完成</span></li>
            </ul>
        </div>
        <div class="login-list-center">
         	<#if tmember.email?exists && tmember.email?string !="">
            <p class="ts-p">您正在使用"邮箱验证"重置密码</p>
            <#else>
            <p class="ts-p">您正在使用"短信验证"重置密码</p>
           </#if>
            <input type="hidden" value="${tmember.mobile?default('')}" id="mobile" />
            <input type="hidden" value="${tmember.email?default('')}" id="email" />
            <dl class="import-message">
                <dt>设置密码：</dt>
                <dd>
                    <input type="password"  class="impart-text" placeholder="数字加字母组合，且不少于8位" id="password"/>
                    <span class="import-wrong" id="passwordwarn1">密码必须是8-16位，请您重新设置</span>
				    <span class="import-wrong" id="passwordwarn2">密码规则简单，请您重新设置密码</span>
				    <span class="import-wrong" id="passwordwarn3">密码不能为空，请您重新设置</span>
                    <span class="import-correct" id="right1"></span>
                </dd>
            </dl>
            <dl class="import-message">
                <dt>确认密码：</dt>
                <dd>
                    <input type="password"  class="impart-text" placeholder="请再次输入密码" id="repassword"/>
                    <span class="import-wrong" id="repasswordwarn1">密码不能为空，请您重新设置</span>
    				<span class="import-wrong" id="repasswordwarn2">两次密码不一致，请您重新输入</span>
    				<span class="import-correct" id="right2"></span>
                </dd>
            </dl>
            <div class="login-button for-btn">
                <input type="button" value="下一步"  class="fl" id="nextButton"/>
                <b class="fl">遇到问题，联系客服<br>400-606-3111</b>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
$(function(){
		var $password = $("#password");
		var $repassword = $("#repassword");
		var pwdreg =  /^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{8,20}$/;//密码验证规则
		var flag=false;
		var result=false;
	$password.blur(function(){
		var password = $(this).val();
		if(password==null || $.trim(password) == ""){
			$("#passwordwarn3").hide().parent().removeClass("border-red");
			$("#passwordwarn1").hide();
			$("#passwordwarn2").hide();
			$("#right1").hide();
			flag=false;
		}else if($.trim(password).length <8 || $.trim(password).length >16){
			$("#passwordwarn1").show().parent().addClass("border-red");
			$("#passwordwarn2").hide();
			$("#passwordwarn3").hide();
			$("#right1").hide();
			flag=false;
		}else if(!pwdreg.test(password)){
			$("#passwordwarn2").show().parent().addClass("border-red");
			$("#passwordwarn1").hide();
			$("#passwordwarn3").hide();
			$("#right1").hide();
			flag=false;
		}else{
			$("#right1").show().parent().removeClass("border-red");
			$("#passwordwarn1").hide();
			$("#passwordwarn2").hide();
			$("#passwordwarn3").hide();
			flag=true;
		}
		return flag;
	});
	$repassword.blur(function(){
		var repassword = $(this).val();
		var password = $("#password").val();
		if(repassword==null || $.trim(repassword) == ""){
			$("#repasswordwarn1").hide().parent().removeClass("border-red");
			$("#repasswordwarn2").hide();
			$("#right2").hide();
			 result=false;
		}else if(repassword != password){
			$("#repasswordwarn2").show().parent().addClass("border-red");
			$("#repasswordwarn1").hide();
			$("#right2").hide();
			 result=false;
		}else{
			$("#right2").show().parent().removeClass("border-red");
			$("#repasswordwarn1").hide();
			$("#repasswordwarn2").hide();
			 result=true;
		}
		return result;
	});
	$("#nextButton").click(function(){
			var password = $("#password").val();
			var repassword = $("#repassword").val();
			if(password==null || $.trim(password) == ""){
				$("#passwordwarn3").show().parent().addClass("border-red");
				$("#passwordwarn1").hide();
				$("#passwordwarn2").hide();
				$("#right1").hide();
				return false;
			}
			if(repassword==null || $.trim(repassword) == ""){
				$("#repasswordwarn1").show().parent().addClass("border-red");
				$("#repasswordwarn2").hide();
				$("#right2").hide();
				return false;
			}
 			if(!($password.triggerHandler("blur"))){
	 			$password.triggerHandler("blur");
	 			if(flag==false){
	 				return false;
	 			}
 			}
 			if(!($repassword.triggerHandler("blur"))){
	 			$repassword.triggerHandler("blur");
	 			if(result==false){
	 				return false;
	 			}
 			}
 		 $.ajax({
				    url: "${base}/findpassword/findpassword!reSetPassword.action",
				    type: "GET",
				 	data: { 
				 		password: $("#password").val(),
				 		mobile:$("#mobile").val(),
				 		email:$("#email").val(),
				 	},
				  	cache: false,
			      	success: function(data) {
					if(data!=0){
						alert("数据异常，密码没有设置成功！");
						return false;
					}else{
						location.href="${base}/findpassword/findpassword!success.action";
					}		
					return true;
				}
			  });
		});
});
</script>
</html>