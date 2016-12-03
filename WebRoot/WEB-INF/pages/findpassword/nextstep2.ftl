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
    #mobilecodewarn1 {display: none;}
    #mobilecodewarn2 {display: none;}
    #right {display: none;}
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
                <li class="bra-line finish-line"></li>
                <li class="state-tip finish-tip"><b>3</b><span class="doing-tit">验证身份</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip"><b>4</b><span>设置新密码</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>5</b><span>完成</span></li>
            </ul>
        </div>
        <div class="login-list-center">
            <dl class="import-message">
                <dt>验证码：</dt>
                <dd>
                    <input type="text"  class="impart-text" placeholder="请输入手机验证码" id="mobilecode"/>
                    <span class="iphone-code" id="getCode">获取验证码</span>
                    <span class="import-wrong" id="mobilecodewarn1">验证码错误或者已失效，请重新输入</span>
   					<span class="import-wrong" id="mobilecodewarn2">请您输入手机验证码</span>
                    <span class="import-correct" id="right"></span>
                    <b class="iphone-num">手机号码：  ${mobile?default('')}</b>
                </dd>
            </dl>
            <div class="login-button for-btn"><input type="button" value="下一步" id="nextButton"/><a href="#">重新选择验证方式</a></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var getCode = document.getElementById("getCode");
    var timer = null;
    var count = 60;
    function timeDesc() {
        if (count > 0) {
            count--;
            getCode.innerHTML = count + "S";
            getCode.style.background = "#DDD";
        } else {
            getCode.innerHTML = "重新获取";
            getCode.style.background = "#f3f5f7";
            count = 60;
            window.clearInterval(timer);
            timer = "";
        }
    }
    $().ready(function(){
    	 var $mobilecode = $("#mobilecode");
    	 var mobile="${mobile?default('')}";
    	 var flag=false;
   		 $mobilecode.blur(function(){
			if(mobilecode==null || $.trim(mobilecode) == ""){
				$("#mobilecodewarn2").show().parent().addClass("border-red");
				$("#mobilecodewarn1").hide();
				flag=false;
			}else{
				$.ajax({
						url: "${base}/findpassword/findpassword!checkMobileCode.action",
						data:{
							mobile:$.trim(mobile),
							mobilecode: $.trim($("#mobilecode").val()),
						    },
						type:"post",
						async:false,
						cache:false,
						success: function(data) {
							if(data==0){//验证码正确
								$("#mobilecodewarn1").hide().parent().removeClass("border-red");
								$("#mobilecodewarn2").hide().parent().removeClass("border-red");
								$("#right").show();
								flag=true;
							}else{
								$("#mobilecodewarn1").show().parent().addClass("border-red");
								$("#mobilecodewarn2").hide();
								$("#right").hide();
								flag=false;
							}
						}
				});
			}
			return flag;
		});
    	$("#getCode").click(function(){
			var mobile=  ${mobile?default('')}
			if(count == 60){
				$.ajax({
						url: "${base}/findpassword/findpassword!getMobileCode.action",
						data:{
							mobile:$.trim(mobile),
						    },
						type:"post",
						async:false,
						cache:false,
						success: function(data) {
							if(data==0){//发送成功
								timer = window.setInterval("timeDesc()", 1000);
							}
						}
				});
			}
		});
		$("#nextButton").click(function(){
			if(!($mobilecode.triggerHandler("blur"))){
	 			$mobilecode.triggerHandler("blur");
	 			if(flag==false){
	 				return false;
	 			}
 			}
 		location.href="${base}/findpassword/findpassword!setPassword.action?mobile="+mobile;//转到设置密码页
		});
    });
</script>
</body>
</html>