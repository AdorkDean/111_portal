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
    <title>注册</title>
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
    <script type="text/javascript" src="${base}/web/version2.2.0/js/global.js"></script>
    <script type="text/javascript" src="${base}/web/js/cookieUtil.js"></script>
    <script type="text/javascript" src="${base}/web/js/cart.js"></script>
    <style>
    input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {color: #999; } 
	input:-moz-placeholder, textarea:-moz-placeholder { color: #999; } 
	input::-moz-placeholder, textarea::-moz-placeholder { color: #999; } 
	input:-ms-input-placeholder, textarea:-ms-input-placeholder { color: #999; } 
    #usernamewarn1 {display: none;}
    #usernamewarn2 {display: none;}
    #usernamewarn3 {display: none;}
    #usernamewarn4 {display: none;}
    #usernamewarn5 {display: none;}
    
    #right1 {display: none;}
    #right2 {display: none;}
    #right3 {display: none;}
    #right4 {display: none;}
    
    #passwordwarn1 {display: none;}
    #passwordwarn2 {display: none;}
    #passwordwarn3 {display: none;}
    
    #repasswordwarn1 {display: none;}
    #repasswordwarn2 {display: none;}
    
    #mobilewarn1 {display: none;}
    #mobilewarn2 {display: none;}
    
    #codewarn1 {display: none;}
    #codewarn2 {display: none;}
    
    #mobilecodewarn1 {display: none;}
    #mobilecodewarn2 {display: none;}
    </style>
</head>
<body class="login-bg">
<!--login-header-->
<div class="login-header">
    <div class="login-header-main">
    <div style="width:142px;height:45px;float:left;margin:11px 30px 7px 0;"><#include "/static/imgout/version2.2.0/header_logo.html"></div>
        <div class="header-list fr">
            <ul>
                <li><b></b><span>实体药店</span></li>
                <li><b></b><span>GSP认证</span></li>
                <li><b></b><span>闪电发货</span></li>
                <li><b></b><span>保密发货</span></li>
                <li><b></b><span>99包邮</span></li>
            </ul>
            <div class="line-left"></div>
        </div>
    </div>
</div>
<div class="login-wrap">
    <div class="login-title">
        <h2 class="fl">新用户注册/ <b>注册医药馆，赢积分换好礼</b></h2>
        <span class="fr">已有账户？<a href="${base}/login/login!index.action">立即登录</a></span>
    </div>
    <div class="login-content">
        <div class="login-list-left">
            <dl class="import-message">
                <dt>用  &nbsp;户   &nbsp;名  &nbsp;：</dt>
                <dd>
                    <input type="text" class="impart-text" placeholder="一旦设置成功，无法修改" id="username"/>
                    <span class="import-correct" id="right1"></span>
                    <span class="import-wrong" id="usernamewarn1">用户名不符合规则，请重新输入</span>
                    <span class="import-wrong" id="usernamewarn2">用户名已存在，请跟换用户名</span>
                    <span class="import-wrong" id="usernamewarn3">用户名不能是纯数字</span>
                    <span class="import-wrong" id="usernamewarn4">用户名必须是6-12位，请重新输入</span>
                    <span class="import-wrong" id="usernamewarn5">支持中文,字母,数字,“－”,“_”的组合,6-12位</span>
                </dd>
            </dl>
            <dl class="import-message">
                <dt>设 置 密 码：</dt>
                <dd>
                    <input type="password"  class="impart-text" placeholder="数字加字母组合，且不少于8位" id="password"/>
                    <span class="import-correct" id="right2"></span>
                    <span class="import-wrong" id="passwordwarn1">密码必须是8-16位，请您重新设置</span>
                    <span class="import-wrong" id="passwordwarn2">密码规则简单，请您重新设置密码</span>
                    <span class="import-wrong" id="passwordwarn3">密码不能为空，请您重新设置</span>
                </dd>
            </dl>
            <dl class="import-message">
                <dt>确 认 密 码：</dt>
                <dd>
                    <input type="password"  class="impart-text" placeholder="请再次输入密码" id="repassword"/>
                    <span class="import-correct" id="right3"></span>
                    <span class="import-wrong" id="repasswordwarn1">密码不能为空，请您重新设置</span>
                    <span class="import-wrong" id="repasswordwarn2">两次密码不一致，请您重新输入</span>
                </dd>
            </dl>
            <dl class="import-message">
                <dt>验 证 手 机：</dt>
                <dd>
                    <input type="text"  class="impart-text" placeholder="建议使用经常使用的手机号" maxlength="11" id="mobile"/>
                    <span class="import-correct" id="right4"></span>
                    <span class="import-wrong" id="mobilewarn1">手机号已被使用，请重新更换手机号</span>
                    <span class="import-wrong" id="mobilewarn2">手机号码格式不正确，请重新输入</span>
                </dd>
            </dl>
            <dl class="import-message">
                <dt>验&nbsp;&nbsp;证&nbsp;&nbsp;码 &nbsp;：</dt>
                <dd class="impart-dd">
                    <input type="text"  class="impart-code" placeholder="请输入验证码" id="code"/>
                    <img src="${base}/static/inc/number.jsp?,Math.random(); alt="" class="code-img" id="phoneSrcCode"/>
                    <a href="#" class="see-no" id="phoneChangeCode">看不清换一张</a>
                    <span class="import-wrong" id="codewarn1">请您输入验证码</span>
					<span class="import-wrong" id="codewarn2">您输入的验证码不正确，请重新输入</span>
                </dd>
            </dl>
            <dl class="import-message">
                <dt>手机验证码：</dt>
                <dd>
                    <input type="text"  class="impart-text" placeholder="请输入手机验证码" id="mobilecode"/>
                    <span class="iphone-code" id="getCode">获取验证码</span>
                    <span class="import-wrong" id="mobilecodewarn1">验证码错误或者已失效，请重新输入</span>
                    <span class="import-wrong" id="mobilecodewarn2">请您输入手机验证码</span>
                </dd>
            </dl>
            <div class="forget-password read-clause">
                <input type="checkbox" checked="checked" id="xy_checkbox" />您已阅读并勾选同意 <a target="_blank" href="http://cms.111yao.com/helps/About_111/clause/">《111医药馆用户使用条款》</a>
            </div>

            <div class="login-button register-button"><input type="button"  value="立即注册" id="registerButton"/></div>
        </div>
        <div class="login-banner">
           <a href="${base}/register/register!rindex.action"><img src="${base}/web/images/login/login_img.jpg" alt=""/></a>
        </div>
    </div>
</div>

<div style="margin-top:20px;"><#include "/static/inc/version2.2.0/footer.ftl"></div>

<script type="text/javascript">
	
	$(".footer-content").css("border-top","none");

	//倒计时
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
$().ready(function() {
		$("#phoneChangeCode").click(function(){
		 var img = document.getElementById("phoneSrcCode");   
   			 img.src = "${base}/static/inc/number.jsp?" + Math.random();
		});
	var $username = $("#username");
	var $password = $("#password");
	var $repassword = $("#repassword");
	var $mobile = $("#mobile");
	var $code = $("#code");
	var $mobilecode = $("#mobilecode");
	var $xy_checkbox = $("#xy_checkbox");
	var $registerButton = $("#registerButton");
	
	var isUserPass1 = /^[\u4e00-\u9fa5a-zA-Z0-9_\-]{4,20}$/;
					 //[\u4e00-\u9fa5a-zA-Z0-9\-]{4,20}
	var isUserPass2 =/^[0-9]*$/;//不可以是纯数字
	var pwdreg = /^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{8,20}$/;//密码验证规则
	var mobileReg = new RegExp(/^[1][3,4,7,5,8][0-9]{9}$/);
	var result=false;
	$username.focus(function(){
		var username = $(this).val();
		if(username==null || $.trim(username) == ""){
			$("#usernamewarn5").show().parent().addClass("border-red");
			$("#usernamewarn3").hide();
			$("#usernamewarn2").hide();
			$("#usernamewarn4").hide();
			$("#usernamewarn1").hide();
			$("#right1").hide();
			return false;
		}else{
			$("#usernamewarn5").hide().parent().removeClass("border-red");
			$("#usernamewarn3").hide();
			$("#usernamewarn2").hide();
			$("#usernamewarn4").hide();
			$("#usernamewarn1").hide();
			$("#right1").hide();
			return false;
		}
	});
	$username.blur(function(){
		var username = $(this).val();
		if(username==null || $.trim(username) == ""){
			$("#usernamewarn1").hide().parent().removeClass("border-red");
			$("#usernamewarn3").hide();
			$("#usernamewarn2").hide();
			$("#usernamewarn4").hide();
			$("#usernamewarn5").hide()
			$("#right1").hide();
			return false;
		}else if($.trim(username).length <6 || $.trim(username).length >12){
			$("#usernamewarn4").show().parent().addClass("border-red");
			$("#usernamewarn1").hide();
			$("#usernamewarn2").hide();
			$("#usernamewarn3").hide();
			$("#usernamewarn5").hide()
			$("#right1").hide();
			return false;
		}else if(!isUserPass1.test(username)){
			$("#usernamewarn1").show().parent().addClass("border-red");
			$("#usernamewarn2").hide();
			$("#usernamewarn3").hide();
			$("#usernamewarn4").hide();
			$("#usernamewarn5").hide()
			$("#right1").hide();
			return false;
		}else if(isUserPass2.test(username)){
			$("#usernamewarn3").show().parent().addClass("border-red");
			$("#usernamewarn1").hide();
			$("#usernamewarn2").hide();
			$("#usernamewarn4").hide();
			$("#usernamewarn5").hide()
			$("#right1").hide();
			return false;
		}else{
			 $.ajax({
				url: "${base}/register/register!checkUserNameIsExist.action",
				data:{
				username:$.trim($username.val()),
				},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
					if(data==0){
						$("#right1").hide();
						$("#usernamewarn2").show().parent().addClass("border-red");
						$("#usernamewarn1").hide();
						$("#usernamewarn3").hide();
						$("#usernamewarn4").hide();
						$("#usernamewarn5").hide()
						result=false;
					}else{
						$("#right1").show().parent().removeClass("border-red");
						$("#usernamewarn1").hide();
						$("#usernamewarn2").hide();
						$("#usernamewarn3").hide();
						$("#usernamewarn4").hide();
						$("#usernamewarn5").hide()
						result=true;
					}
				}
		   });
		}
		return result;
	});
	$password.blur(function(){
		var password = $(this).val();
		if(password==null || $.trim(password) == ""){
			$("#passwordwarn3").hide().parent().removeClass("border-red");
			$("#passwordwarn1").hide();
			$("#passwordwarn2").hide();
			$("#right2").hide();
			return false;
		}else if($.trim(password).length <8 || $.trim(password).length >16){
			$("#passwordwarn1").show().parent().addClass("border-red");
			$("#passwordwarn2").hide();
			$("#passwordwarn3").hide();
			$("#right2").hide();
			return false;
		}else if(!pwdreg.test(password)){
			$("#passwordwarn2").show().parent().addClass("border-red");
			$("#passwordwarn1").hide();
			$("#passwordwarn3").hide();
			$("#right2").hide();
			return false;
		}else{
			$("#right2").show().parent().removeClass("border-red");
			$("#passwordwarn1").hide();
			$("#passwordwarn2").hide();
			$("#passwordwarn3").hide();
		}
	});
	$repassword.blur(function(){
		var repassword = $(this).val();
		var password = $("#password").val();
		if(repassword==null || $.trim(repassword) == ""){
			$("#repasswordwarn1").hide().parent().removeClass("border-red");
			$("#repasswordwarn2").hide();
			$("#right3").hide();
			return false;
		}else if(repassword != password){
			$("#repasswordwarn2").show().parent().addClass("border-red");
			$("#repasswordwarn1").hide();
			$("#right3").hide();
			return false;
		}else{
			$("#right3").show().parent().removeClass("border-red");
			$("#repasswordwarn1").hide();
			$("#repasswordwarn2").hide();
		}
	});
	$mobile.blur(function(){
		var mobile = $(this).val();
		if(mobile==null || $.trim(mobile) == ""){
			$("#mobilewarn2").hide().parent().removeClass("border-red");
			$("#mobilewarn1").hide();
			$("#right4").hide();
			return false;
		}else if(!mobileReg.test($.trim(mobile))){
			$("#mobilewarn2").show().parent().addClass("border-red");
			$("#mobilewarn1").hide();
			$("#right4").hide();
			return false;
		}else{
			 $.ajax({
				url: "${base}/register/register!checkMobileUserNameIsExist.action",
				data:{
				mobile:$.trim($mobile.val()),
				},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
					if(data==0){
						$("#mobilewarn1").show().parent().addClass("border-red");
						$("#mobilewarn2").hide();
						$("#right4").hide();
						result=false;
					}else{
						$("#right4").show().parent().removeClass("border-red");
						$("#mobilewarn1").hide();
						$("#mobilewarn2").hide();
						result=true;
					}
				}
		   });
		}
		return result;
	});
	$code.blur(function(){
		var code = $(this).val();
		if(code==null || $.trim(code) == ""){
			$("#codewarn1").hide().parent().removeClass("border-red");
			$("#codewarn2").hide();
			return false;
		}else{
			$.ajax({
				url: "${base}/register/register!checkCodeIsExist.action",
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
	$mobilecode.blur(function(){
		var mobilecode = $(this).val();
			if(mobilecode==null || $.trim(mobilecode) == ""){
				$("#mobilecodewarn2").hide().parent().removeClass("border-red");
				$("#mobilecodewarn1").hide();
				return false;
			}else{
				$("#mobilecodewarn1").hide().parent().removeClass("border-red");
				$("#mobilecodewarn2").hide().parent().removeClass("border-red");
			}
		});
	$("#getCode").click(function(){
		var code= $("#code").val();
		if(code==null || $.trim(code) == ""){
			$("#codewarn1").show().parent().addClass("border-red");
			$("#codewarn2").hide();
			return false;
		}else{
			$.ajax({
				url: "${base}/register/register!checkCodeIsExist.action",
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
					}else{
						if(count == 60){
							$.ajax({
								url: "${base}/register/register!validateMobileCode.action",
								data:{
								mobile:$.trim($("#mobile").val()),
								},
								type:"post",
								async:false,
								cache:false,
								success: function(data) {
									if(data==0){//发送成功
										timer = window.setInterval("timeDesc()", 1000);
										$("#mobilecodewarn1").hide().removeClass("border-red");
										$("#mobilecodewarn2").hide().removeClass("border-red");
										result=true;
									}else{
										$("#mobilecodewarn1").show().parent().addClass("border-red");
										$("#mobilecodewarn2").hide();
										result=false;
									}
								}
						   });
							$("#codewarn1").hide().parent().removeClass("border-red");
							$("#codewarn2").hide().parent().removeClass("border-red");
						}
					}
				}
		   });
		   return result;
		}
		$mobilecode.blur(function(){
			var mobilecode = $("#mobilecode").val();
			if(mobilecode==null || $.trim(mobilecode) == ""){
				$("#mobilecodewarn2").hide().parent().removeClass("border-red");
				$("#mobilecodewarn1").hide();
				return false;
			}else{
				$("#mobilecodewarn1").hide().parent().removeClass("border-red");
				$("#mobilecodewarn2").hide().parent().removeClass("border-red");
			}
		});
	});
	
	$("#registerButton").click(function (){
		var username = $("#username").val();
		var password = $("#password").val();
		var repassword = $("#repassword").val();
		var mobile = $("#mobile").val();
		var code = $("#code").val();
		var mobilecode = $("#mobilecode").val();
		if(username==null || $.trim(username) == ""){
			$("#usernamewarn1").show().parent().addClass("border-red");
			$("#usernamewarn2").hide();
			$("#right1").hide();
			return false;
		}
		if(!isUserPass1.test(username)){
			$("#usernamewarn1").show().parent().addClass("border-red");
			$("#usernamewarn2").hide();
			$("#right1").hide();
			return false;
		}
		if(isUserPass2.test(username)){
			$("#usernamewarn1").show().parent().addClass("border-red");
			$("#usernamewarn2").hide();
			$("#right1").hide();
			return false;
		}
		if(password==null || $.trim(password) == ""){
			$("#passwordwarn3").show().parent().addClass("border-red");
			$("#passwordwarn1").hide();
			$("#passwordwarn2").hide();
			$("#right2").hide();
			return false;
		}
		if($.trim(password).length <8 || $.trim(password).length >16){
			$("#passwordwarn1").show().parent().addClass("border-red");
			$("#passwordwarn2").hide();
			$("#passwordwarn3").hide();
			$("#right2").hide();
			return false;
		}
		if(!pwdreg.test(password)){
			$("#passwordwarn2").show().parent().addClass("border-red");
			$("#passwordwarn1").hide();
			$("#passwordwarn3").hide();
			$("#right2").hide();
			return false;
		}else{
			$("#right2").show().parent().removeClass("border-red");
			$("#passwordwarn1").hide();
			$("#passwordwarn2").hide();
			$("#passwordwarn3").hide();
		}
		if(repassword==null || $.trim(repassword) == ""){
			$("#repasswordwarn1").show().parent().addClass("border-red");
			$("#repasswordwarn2").hide();
			$("#right3").hide();
			return false;
		}
		if(repassword != password){
			$("#repasswordwarn2").show().parent().addClass("border-red");
			$("#repasswordwarn1").hide();
			$("#right3").hide();
			return false;
		}else{
			$("#right3").show().parent().removeClass("border-red");
			$("#repasswordwarn1").hide();
			$("#repasswordwarn2").hide();
		}
		if(mobile==null || $.trim(mobile) == ""){
			$("#mobilewarn2").show().parent().addClass("border-red");
			$("#mobilewarn1").hide();
			$("#right4").hide();
			return false;
		}
	   if(!mobileReg.test($.trim(mobile))){
			$("#mobilewarn2").show().parent().addClass("border-red");
			$("#mobilewarn1").hide();
			$("#right4").hide();
			return false;
		}
		if(code==null || $.trim(code) == ""){
			$("#codewarn1").show().parent().addClass("border-red");
			$("#codewarn2").hide();
			return false;
		}
		if(mobilecode==null || $.trim(mobilecode) == ""){
				$("#mobilecodewarn2").show().parent().addClass("border-red");
				$("#mobilecodewarn1").hide();
				return false;
			}else{
				$("#mobilecodewarn1").hide().parent().removeClass("border-red");
				$("#mobilecodewarn2").hide().parent().removeClass("border-red");
			}
 		if(!$("#xy_checkbox").attr("checked")){
 			$alert("warn","请您阅读并勾选同意“《111医药馆用户使用条款》”","友情提示",null);
 			return false;
 		}
		 $.ajax({
				url: "${base}/register/register!userRegister.action?"+Math.random(),
				data:{
				username:$.trim(username),
				password:$.trim(password),
				mobile:$.trim(mobile),
				mobilecode:$.trim(mobilecode),
				},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
				if(data==3){
						$("#right1").hide();
						$("#usernamewarn2").show().parent().addClass("border-red");
						$("#usernamewarn1").hide();
						result=false;
				}else if(data==0){
						$("#mobilewarn1").show().parent().addClass("border-red");
						$("#mobilewarn2").hide();
						$("#right4").hide();
						result=false;
				}else if(data==2){
						$("#mobilecodewarn1").show().parent().addClass("border-red");
						$("#mobilecodewarn2").hide();
						 result=false;
				}else{
						location.href = "${base}/register/register!success.action";
					    result=true;
					}
				}
		   });
		  return result; 
	});
});
</script>
<script type="text/javascript">
$(function(){
	isMobile();
	function isMobile() 
{
	var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
	if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) 
	{
		window.location.href = "http://m.111yao.com/login/login!index.action";
		
	}
}
});
</script>
</body>
</html>