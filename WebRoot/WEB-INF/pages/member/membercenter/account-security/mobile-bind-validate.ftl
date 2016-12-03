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
    <title>绑定手机</title>
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
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/common.css">
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/login.css">
    <script type="text/javascript" src="${base}/web/js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css">
	<link rel="stylesheet" type="text/css" href="${base}/web/css/jquery-ui.css">
	<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
</head>
<body class="login-bg">
<div class="login-wrap">
    <div class="login-title">
        <a href="#"><img src="${base}/web/images/login/login_logo.png" alt="" class="forget-logo"/></a>
        <b class="forget-tit">绑定手机</b>
    </div>
    <div class="login-content">
        <!--进度条-->
        <div class="process-bra clear clearfix binding-bra">
            <ul>
                <li class="state-tip finish-tip"><b>1</b><span class="doing-tit">验证身份</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip"><b>2</b><span>绑定手机</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>3</b><span>绑定成功</span></li>
            </ul>
        </div>
        <div class="login-list-center binding-box">
            <dl class="import-message">
                <dt></dt>
                <dd class="border-red binding-icon03">
                    <input type="password" id="password" maxlength=20 class="impart-text" placeholder="请输入密码"/>
                    <span class="import-wrong" id="password_wrong_tip" style="display:none;">密码输入错误</span>
                    <span class="import-correct" style="display:none;"></span>
                </dd>
            </dl>
            <dl class="import-message">
                <dt></dt>
                <dd class="impart-dd">
                    <input type="text"  maxlength=4 id="randCode"  class="impart-code" placeholder="请输入验证码"/>
                    <img id="randImg" class="code-img" style="  line-height: 28px;height: 28px;" src="${base}/static/inc/number.jsp"/>
                    <input  type="button" value="看不清换一张" class="btn-change see-no"/>
                    <span class="import-wrong" id="rand_wrong_tip" style="display:none;">验证码输入错误</span>
                    <span class="import-correct" style="display:none;"></span>
                </dd>
            </dl>
            <div class="login-button binding-button" id="btn_div"><input type="button" id="btn_validate" value="验证"/></div>
            <div class="login-button binding-button" id="btn_div_temp" style="display:none;"><input type="button" style="background:#dddddd;" value="验证"/></div>
        </div>
    </div>
</div>
</body>
<script>
	function showBtnTemp(){
		$("#btn_div_temp").show();
		$("#btn_div").hide();
	}
	function showBtn(){
		$("#btn_div").show();
		$("#btn_div_temp").hide();
	}

	$(".btn-change").click(function(){
		$("#randImg").attr("src","${base}/static/inc/number.jsp?,"+Math.random());
	})
	
	$("#btn_validate").click(function(){
		if(!validatePassword()){
			return;
		}
		if(!validateRandCode()){
			return;
		}
		showBtnTemp();
		$.ajax({
			url: "${base}/member/memberCenter!validatePasswordCode.action",
			type: "GET",
			data: {
				password: $("#password").val(),
				randCode: $("#randCode").val()
			},
			cache: false,
			success: function(data) {
				if(data == 1){//验证码和密码正确
					window.location.href="${base}/member/memberCenter!toMobileBindCaptcha.action";
				}else if(data == 2){//验证码不正确
					$("#rand_wrong_tip").html("验证码不正确");
					$("#randCode").focus();
					$("#rand_wrong_tip").show();
					showBtn();
				}else if(data == 3){//密码错误,请重新输入
					$("#password_wrong_tip").html("密码错误,请重新输入");
					$("#password").focus();
					$("#password_wrong_tip").show();
					showBtn();
				}else if(data == 4){//密码不能为空
					$("#password_wrong_tip").html("密码不能为空");
					$("#password_wrong_tip").show();
					showBtn();
				}else if(data == 5){//密码错误,请重新输入
					$("#rand_wrong_tip").html("验证码不能为空");
					$("#rand_wrong_tip").show();
					showBtn();
				}
				
			}
		});
		
	});
	
	$("#password").focus(function(){
		$("#password_wrong_tip").hide();
	});
	
	$("#randCode").focus(function(){
		$("#rand_wrong_tip").hide();
	});
	$("#password").keyup(function(){
		$("#password_wrong_tip").hide();
	});
	
	$("#randCode").keyup(function(){
		$("#rand_wrong_tip").hide();
	});
	
	function validatePassword(){
		if($.trim($("#password").val()) == ''){
			$("#password_wrong_tip").html("请输入密码");
			$("#password").focus();
			$("#password_wrong_tip").show();
			return false;
		}else{
			$("#password_wrong_tip").hide();
		}
		
		return true;
	}
	
	function validateRandCode(){
		if($.trim($("#randCode").val()) == ''){
			$("#rand_wrong_tip").html("请输入验证码");
			$("#randCode").focus();
			$("#rand_wrong_tip").show();
			return false;
		}
		
		return true;
	}
</script>
</html>