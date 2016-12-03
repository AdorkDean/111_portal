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
    <title>更换手机</title>
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
	
	<style>
		.rand-wrong{
			display: block;
			height: 22px;
			line-height: 22px;
			padding-left: 30px;
			background: url("${base}/web/images/login/login_ts_icon02.png") no-repeat;
			color: #e94715;
			width: 254px;
		}
	</style>
</head>
<body class="login-bg">
<div class="login-wrap">
    <div class="login-title">
        <a href="#"><img src="/web/images/login/login_logo.png" alt="" class="forget-logo"/></a>
        <b class="forget-tit">更换手机</b>
    </div>
    <div class="login-content">
        <!--进度条-->
        <div class="process-bra clear clearfix binding-bra">
            <ul>
                <li class="state-tip finish-tip"><b>1</b><span class="doing-tit">验证身份</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip"><b>2</b><span>修改已验证手机</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>3</b><span>修改成功</span></li>
            </ul>
        </div>
        <div class="login-list-center binding-box">
            <p class="reset-password">您正在使用“短信验证”重置密码</p>
            <dl class="import-message" style="padding-bottom: 0px;">
                <dt></dt>
                <dd class="impart-dd">
                    <input type="text"  maxlength=4 id="phoneCode"  class="impart-code" placeholder="请输入验证码"/>
                    
                    <!--
                    <img src="/web/images/login/verification_code.jpg" alt="" class="code-img"/>
                    <a href="#" class="see-no">看不清换一张</a>
                    -->
                     
                    <img id="randImg" class="code-img" style="  line-height: 28px;height: 28px;" src="${base}/static/inc/number.jsp"/>
                    <input  type="button" value="看不清换一张" class="btn-change see-no"/>
                </dd>
            </dl>
            <dl class="impart-mobile" id="rand-wrong-dl" style="width:300px;height:30px;display:none;">
                <dt></dt>
                <dd class="impart-dd">
                    <span class="rand-wrong" id="rand-wrong" style="">验证码输入错误</span>
                </dd>
            </dl>
            <dl class="impart-mobile" style="width:300px;height:20px;padding:10px 2px;">
                <dt></dt>
                <dd class="impart-dd">
                    <b class="">手机号码：   ${mobile}</b>
                </dd>
            </dl>
            <dl class="import-message" style="padding-bottom: 0px;">
                <dt></dt>
                <dd class="binding-icon04">
                	<input type="hidden" id="phoneUsername" value="${mobile}"/>
                	<input type="hidden" id="phoneCaptchaFlag" value=""/>
                    <input type="text" maxlength=10 id="smsCode" class="impart-text" placeholder="请输入手机验证码"/>
                    <button class="iphone-code" style="border:0px;width:100px;"  href="javascript:void(0)" id="getCode" >获取验证码</button>
                    <span class="import-correct" style="display:none;"></span>
                    <span></span>
                </dd>
            </dl>
            <dl class="impart-mobile" id="mobile-captcha-dl" style="width:300px;height:30px;display:none;">
                <dt></dt>
                <dd class="impart-dd">
                    <span class="rand-wrong" id="mobile-captcha-wrong" >手机验证码输入错误</span>
                </dd>
            </dl>
            <dl class="impart-mobile" id="show_time" style="width:300px;height:16px;padding:2px;display:none;">
                <dt></dt>
                <dd class="impart-dd">
                    <b class="">校验码已发出，你可以在<span id="times" style="color:red;">120</span>秒后要求系统重新发送</b>
                </dd>
            </dl>
            <div class="login-button for-btn reset-btn" id="btn_div">
                <input type="button" id="btn-next" value="下一步"  class="fl"/>
                <b class="fl">手机无法接受短信？<br>遇到问题，联系客服 400-606-3111</b>
            </div>
            
            <div class="login-button for-btn reset-btn" id="btn_div_temp" style="display:none;">
                <input type="button"  style="background:#dddddd;" value="下一步"  class="fl"/>
                <b class="fl">手机无法接受短信？<br>遇到问题，联系客服 400-606-3111</b>
            </div>
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
	
	function showTimes(){
		
		var times = $("#times").html();
		if(times >= 1){
			times--;
			$("#times").html(times);
			setTimeout("showTimes()",1000);
		}else{
			$("#getCode").attr("disabled",false);
			$("#show_time").hide();
			$("#times").html(120);
			return;
		}
		
	}
	
	
	$("#getCode").click(function(){
		$("#getCode").attr("disabled",true);
	
		var count = $("#times").html();
	
		var $phoneUsername = $("#phoneUsername");
	
		var phoneCode = $("#phoneCode").val();
		if(phoneCode==null || $.trim(phoneCode) == ""){
			$("#phoneCode").focus();
			$("#rand-wrong").html("请输入验证码");
			$("#getCode").attr("disabled",false);
			$("#rand-wrong-dl").fadeIn();
			return false;
		}else{
			$("#rand-wrong-dl").hide();
		}
   		if(count == 120){
			$.ajax({
				url: "${base}/member/memberCenter!validateMobileCode.action",
				type: "GET",
				data: {
					username: $.trim($phoneUsername.val()),
					phoneCode:phoneCode,
				},
				cache: false,
				success: function(data) {
					if(data==0){
						$("#phoneCaptchaFlag").val(1);
						$("#show_time").show();
						showTimes();
						return;
					}else if(data==1){
						$alert("warn","验证码发送失败！","友情提示",null);
						$("#getCode").attr("disabled",false);
					}else if(data==2){
						$("#phoneCode").focus();
						$("#rand-wrong").html("验证码不正确");
						$("#rand-wrong-dl").fadeIn();
						$("#getCode").attr("disabled",false);
						return;
					}else if(data==3){
						$alert("warn","已绑定手机号不存在！","友情提示",null);
						$("#getCode").attr("disabled",false);
						return false;
					}
				}
			});
   		}
	});
	
	
	$("#smsCode").focus(function(){
		$("#mobile-captcha-dl").hide();
	});
	$("#btn-next").click(function(){
		if($("#phoneCaptchaFlag").val() != 1){
			$alertCanDisplay("warn","请获取手机验证码！","友情提示",null);
			return;
		}
	
		if($.trim($("#smsCode").val()) == ''){
			$("#mobile-captcha-wrong").html("请输入手机验证码");
			$("#mobile-captcha-dl").show();
			return;
		}
		
		showBtnTemp();
		$.ajax({
				url: "${base}/member/memberCenter!validateSmsCode.action",
				data:{
					smsCode:$.trim($("#smsCode").val()),
				},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
					if(data != 1){
						showBtn();
					}
				
					if(data==1){//验证通过
						window.location.href="${base}/member/memberCenter!toMobileUpdateCaptcha.action";
						return false;
					}else if(data==2){//验证码不正确
						$("#mobile-captcha-wrong").html("手机验证码不正确");
						$("#mobile-captcha-dl").show();
						return false;
					}else if(data.flag==3){//手机验证码已过期
						$("#mobile-captcha-wrong").html("手机验证码已过期");
						$("#mobile-captcha-dl").show();
						return false;
					}
				}
		   });
		
	});
</script>
</html>