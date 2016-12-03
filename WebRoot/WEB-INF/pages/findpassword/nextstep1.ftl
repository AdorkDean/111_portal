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
    <link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css">
    <script src="${base}/web/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
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
                <li class="bra-line finish-line"></li>
                <li class="state-tip finish-tip"><b>2</b><span class="doing-tit">选择找回方式</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip"><b>3</b><span>验证身份</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>4</b><span>设置新密码</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>5</b><span>完成</span></li>
            </ul>
        </div>
        <div class="login-list-center">
            <ul class="selector-mode">
                <li>正在为您的账户<span>${tmember.userName?default('')} </span>重置登录密码，请选择方式</li>
                <#if tmember.mobile?exists && tmember.mobile?string !="">
                <li>
                    <p>通过绑定手机，短信验证重置</p>
                    <p>您验证的手机号码：<span id="mobileshow"></span></p>
                    <input type="button" value="立即重置" id="mobileButton"/>
                </li>
                </#if>
                <#if tmember.email?exists && tmember.email?string !="">
                <li>
                    <p>通过绑定邮箱，邮箱验证重置</p>
                    <p>您验证的电子邮箱：<span id="emailshow"></span></p>
                    <input type="button" value="立即重置" id="emailButton"/>
                </li>
               </#if>
               <#if !tmember.email?exists && !tmember.mobile?exists>
	                 <li>
	                    <p>您的帐号没有绑定「手机号码」和「邮箱」无法通过该方式找回密码，<br>请联系客服进行处理。客服电话「400-606-3111」</p>
	               	 </li>
	            </#if>    
            </ul>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
$(function(){
		var mobile="${tmember.mobile?default('')}";
		var	mobileshow = mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
		$("#mobileshow").html(mobileshow);
		
		var reg = /(.{2}).+(.{2}@.+)/g;
		var email="${tmember.email?default('')}";
		var emailshow=email.replace(reg, "$1****$2");
		$("#emailshow").html(emailshow);
		
		$("#mobileButton").click(function(){
			var mobile="${tmember.mobile?default('')}";
	    	location.href="${base}/findpassword/findpassword!mobileValidate.action?mobile="+mobile;
		});
		$("#emailButton").click(function(){
			var email="${tmember.email?default('')}";
	    	$.ajax({
						url: "${base}/findpassword/findpassword!sendEmail.action",
						data:{
							email:$.trim(email),
						    },
						type:"post",
						async:false,
						cache:false,
						success: function(data) {
							if(data==0){//发送成功
								$alert("warn","已发送至绑定邮箱中，邮件链接两小时内有效，请尽快登录邮箱完成密码重置","友情提示",null);
								return false;
							}else{
								$alert("warn","网络异常，发送失败","友情提示",null);
								return false;
							}
						}
				});
		});
});
</script>
</html>