<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="/web/img/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="/web/img/favicon-196x196.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="img/apple-icon-touch.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/login.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css">
    <script type="text/javascript" src="${base}/web/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${base}/web/js/input.js"></script>
    <script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
    <!--[if IE 6]>
    <script src="${base}/webjs/png.js"></script>
    <script>
        PNG.fix('*');
    </script>
    <![endif]-->
</head>
<body>
<div class="login">
    <!-- head开始-->
    <div class="login-head">
     	<h1><#include "/static/imgout/header_logo.html"></h1>
        <p><span>还没有账户？</span><a href="${base}/register/register!rindex.action">立即注册</a></p>
    </div>
    <!-- head结束-->
    <!-- 中间内容开始-->
    <div class="login-center">
        <div class="main-wrap">
            <div class="main">
                <div class="info" id="choose-info"><span class="current" id="emailButton">用户名登录</span><span id="phoneButton">手机快捷登录</span></div>
                <div class="icon" id="choose-icon"><b></b></div>
                <div class="list" id="choose-list">
                    <div class="list-con current">
                        <ul>
                            <li><input type="text"  value="请输入用户名" id="emailUsername" tar="请输入用户名" placeholder="请输入用户名" class="txt01" maxlength="40"/><div class="empty" id="emailAccount" style="display:none;"><p class="em-p"><span class="emailText"></span><i></i></p><em></em></div></li>
                            <li><input type="text" value="请输入密码" id="password" tar="请输入密码" placeholder="请输入密码" class="txt02" maxlength="20"/><div class="empty" id="accountPassword" style="display:none;"><p class="em-p"><span class="passwordText"></span><i></i></p><em></em></div></li>
                            <li class="li-emp-mail"><input type="text" value="请输入验证码" tar="请输入验证码" placeholder="请输入验证码" id="emailCode" class="txt03" maxlength="12"/><span class="span-yz"><img src="${base}/static/inc/number.jsp?,Math.random();" alt="" id="emailSrcCode"/></span><input type="button" id="changeEmailCode" value="换一张" class="btn01"/><div class="empty" id="accountCode" style="display:none;"><p class="em-p"><span class="emailCodeText"></span><i></i></p><em></em></div></li>
                             <li class="li-w01"><input type="checkbox" checked="checked" id="isRememberEmailUsername" class="txt04"/><b>记住用户名</b><a href="${base}/findpassword/findpassword!index.action">忘记密码？</a></li>
                            <li class="li-w02"><input type="button" id="email_submit"  value="立即登录" class="btn02"/></li>
                        </ul>
                    </div>
                    <div class="list-con">
                        <ul>
                            <li><input type="text" value="请输入手机号" id="phoneUsername" tar="请输入手机号" placeholder="请输入手机号" class="txt01" maxlength="25"/><div class="empty" id="phoneAccount" style="display:none;"><p class="em-p"><span class="phursnam"></span><i></i></p><em></em></div></li>
                            <li class="li-emp-iphone"><input type="text" value="请输入验证码" id="phoneCode" tar="请输入验证码" placeholder="请输入验证码" class="txt03" maxlength="12"/><span class="span-yz"><img id="phoneSrcCode" src="${base}/static/inc/number.jsp?,Math.random();" alt="" /></span><input type="button" id="phoneChangeCode" value="换一张" class="btn01"/><div class="empty" id="vcode" style="display:none;"><p class="em-p"><span class="codetext"></span><i></i></p><em></em></div></li>
                            <li class="li-emp-iphone"><input type="text" value="请输入短信验证码" id="smsCode" tar="请输入短信验证码" placeholder="请输入短信验证码" class="txt03" maxlength="12"/><input type="button" id="getCode" value="获取验证码" class="btn03"/><div class="empty b-4" id="msgcode" style="display:none;"><p class="em-p"><span class="smsCodeText"></span><i></i></p><em></em></div></li>
                            <li class="li-w01"><input type="checkbox" checked="checked" id="isRememberUsername" class="txt04"/><b>记住用户名</b><a href="${base}/findpassword/findpassword!index.action">忘记密码？</a></li>
                            <li class="li-w02"><input type="button" id ="mobile_submit" value="立即登录" class="btn02"/></li>
                        </ul>
                    </div>
                </div>
                <!--支付宝登录form    --begin    --> 
                <div id="alipayDiv"  style="display:none;">
					<form  id="alipaysubmit" name="alipaysubmit"  action="https://mapi.alipay.com/gateway.do?_input_charset=utf-8" method="get">
						<input type="hidden" name="partner" value=""/>
						<input type="hidden"  name="target_service" value=""/>
						<input type="hidden" name="service" value=""/>
						<input type="hidden"  name="_input_charset" value=""/>
						<input type="hidden"  name="sign" value=""/>
						<input type="hidden"  name="return_url" value=""/>
						<input type="hidden"  name="exter_invoke_ip" value=""/>
						<input type="hidden"  name="sign_type" value=""/>
						<input  type="submit" value="确认" style="display:none;" >
					</form>
				</div>
				<!--支付宝登录form    --end    -->   
                <div class="account">
                    <p><span></span><b>你也可以使用以下账号登录</b><span></span></p>
                    <ul>
                        <!--li><a href="${base}/login/weibologin!index.action<#if redirectUrl?exists>?weiboredirectUrl=${redirectUrl}</#if>"><img src="${base}/web/images/login/landing-icon06.png" alt=""/><span>新浪微博</span></a></li-->
                        <li><a href="${base}/login/wxlogin!index.action<#if redirectUrl?exists>?wxLoginRedirect=${redirectUrl}</#if>"><img src="${base}/web/images/login/landing-icon07.png" alt=""/><span>微信</span></a></li>
                        <li><a href="${base}/login/yktlogin!index.action<#if redirectUrl?exists>?yktLoginRedirect=${redirectUrl}</#if>"><img src="${base}/web/images/login/landing-icon11.png" alt=""/><span>医卡通</span></a></li>  
                        <li><a href="javascript:;"><img src="${base}/web/images/100-100-QQ.png" alt=""/><span>QQ</span></a></li>
                        <li><a href="javascript:;" id="alipayLogin"><img src="${base}/web/images/login/landing-icon09.png" alt=""/><span>支付宝</span></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- 中间内容结束-->
    <!-- footer开始-->
    <div class="login-footer">
        <p>111医药馆－国家药监局认证的合法网上药店，致力于打造优质、低价、便捷的网上药店和最值得信赖的健康服务平台</p>
        <p>版权所有 Copyright©2015 www.111yao.com All rights reserved</p>
    </div>
    <!-- footer结束-->
</div>
 <script type="text/javascript">    
 	//支付宝登录
	$("#alipayLogin").click(function(){
	       $.ajax({
				url: "${base}/login/alipaylogin!index.action",
				data:{
					<#if redirectUrl?exists>
					alipayRedirectUrl:"${redirectUrl}"
					</#if>
				},
				type: "GET",
				dataType: "json",
				cache: false,
				success: function(data) {
			          $("#alipayDiv").find("input[name='partner']").val(data.partner);
				      $("#alipayDiv").find("input[name='target_service']").val(data.target_service);
				      $("#alipayDiv").find("input[name='service']").val(data.service);
			     	  $("#alipayDiv").find("input[name='_input_charset']").val(data._input_charset);
				 	  $("#alipayDiv").find("input[name='sign']").val(data.sign);
				 	  $("#alipayDiv").find("input[name='return_url']").val(data.return_url);
				      $("#alipayDiv").find("input[name='exter_invoke_ip']").val(data.exter_invoke_ip);
				      $("#alipayDiv").find("input[name='sign_type']").val(data.sign_type);
			         $("#alipaysubmit").submit();
				}
		   });
	   return false;		  	
	});
</script>
<script type="text/javascript">
$(function(){
    $("#choose-info span").click(function(){
        $(this).addClass('current').siblings().removeClass('current');
        if($(this).index() == 1){
            $("#choose-icon b").addClass('current');
        }else{
            $("#choose-icon b").removeClass('current');
        }
        $("#choose-list .list-con:eq("+$(this).index()+")").addClass('current').siblings().removeClass('current');
    })
    $("#choose-icon").click(function(){
        if ($('#choose-icon b').hasClass('current')) {
            $("#choose-info span:eq(0)").click();
        }else{
            $("#choose-info span:eq(1)").click();
        }
    });
})
		var count = 61;
		var timer ;
	function timeDesc(){
		if(count>0){
			count--;
			$("#getCode").val(count+"秒后重新获取");
			$("#getCode").css("background-color","#e5e5e5");
			$("#getCode").prop("disabled", "disabled");
		}else{
			$("#getCode").val("获取短信验证码");
			$("#getCode").css("background-color","#00A6A0");
			$("#getCode").prop("disabled", "");
			count = 61;
			clearInterval(timer);
			timer = "";
		}
	}
	$().ready(function() {
	var $phoneUsername = $("#phoneUsername");
	var $phoneCode = $("#phoneCode");
	var $smsCode = $("#smsCode");
	var textValue="请输入11位有效手机号码!";
	var textPhoneCode="请输入验证码!";
	var textSmsCode="请输入短信验证码!";
	var $isRememberUsername = $("#isRememberUsername");
	// 记住用户名
		$isRememberUsername.prop("checked", true);
	if (getCookie("memberUsername") != null) {
		$isRememberUsername.prop("checked", true);
		$phoneUsername.val(getCookie("memberUsername"));
		$phoneCode.focus();
		$smsCode.focus();
	} else {
		$isRememberUsername.prop("checked", false);
		$phoneUsername.focus();
	}
	$("#emailSrcCode").click(function(){
		 var img = document.getElementById("emailSrcCode");   
   			 img.src = "${base}/static/inc/number.jsp?" + Math.random();
		});	
	$("#changeEmailCode").click(function(){
		 var img = document.getElementById("emailSrcCode");   
   			 img.src = "${base}/static/inc/number.jsp?" + Math.random();
		});	
	$("#phoneSrcCode").click(function(){
		 var img = document.getElementById("phoneSrcCode");   
   			 img.src = "${base}/static/inc/number.jsp?" + Math.random();
		});
	$("#phoneChangeCode").click(function(){
		 var img = document.getElementById("phoneSrcCode");   
   			 img.src = "${base}/static/inc/number.jsp?" + Math.random();
		});
	$("#emailButton").click(function(){
		 var img = document.getElementById("emailSrcCode");   
   			 img.src = "${base}/static/inc/number.jsp?" + Math.random();
   			 $("#phoneAccount").hide();
   			 $("#vcode").hide();
   			 $("#msgcode").hide();
		});	
	$("#phoneButton").click(function(){
		 var img = document.getElementById("phoneSrcCode");   
   			 img.src = "${base}/static/inc/number.jsp?" + Math.random();
   			 $("#emailAccount").hide();
   			 $("#accountPassword").hide();
   			 $("#accountCode").hide();
		});
		
	$phoneUsername.focus(function(){
		if($(this).val() == $(this).attr("tar")){
			$(this).val("");
		}
		$('.phoneAccount').html("<p class='em-p'><span class='phursnam'>"+textValue+"</span><i></i></p></div></li>");
	});
	$phoneUsername.keydown(function(event) {
		if (event.keyCode == 13) {
			$("#mobile_submit").trigger("click");
		}
	});
	$phoneUsername.blur(function(){
		var username = $(this).val();
		var pattern = new RegExp(/^[1][3,4,7,5,8][0-9]{9}$/);
		var isPass =  pattern.test($.trim(username));
		if(username==null || $.trim(username) == ""){
			textValue="请输入11位有效手机号码!";
			$(".phursnam").text(textValue);
			$("#phoneAccount").fadeIn();
			return false;
		}else{
			$("#phoneAccount").hide();
		}
		if(!isPass){
			textValue="请输入11位有效手机号!";
			$(".phursnam").text(textValue);
			$("#phoneAccount").fadeIn();
			return false;
			}else{
			$("#phoneAccount").hide();
			}
		});
	$phoneCode.focus(function(){
		if($(this).val() == $(this).attr("tar")){
			$(this).val("");
		}
		$('.vcode').html("<p class='em-p'><span class='codetext'>"+textPhoneCode+"</span><i></i></p></div></li>");
	});
	$phoneCode.blur(function(){
		var phoneCode = $(this).val();
		if(phoneCode==null || $.trim(phoneCode) == ""|| phoneCode=="请输入验证码"){
			textPhoneCode="请输入验证码!";
			$(".codetext").text(textPhoneCode);
			$("#vcode").fadeIn();
			return false;
		}else{
			$("#vcode").hide();
		}
		});
	$smsCode.focus(function(){
		if($(this).val() == $(this).attr("tar")){
			$(this).val("");
		}
		$('.msgcode').html("<p class='em-p'><span class='smsCodeText'>"+textSmsCode+"</span><i></i></p></div></li>");
	});
	$smsCode.keydown(function(event) {
		if (event.keyCode == 13) {
			$("#mobile_submit").trigger("click");
		}
	});
	$smsCode.blur(function(){
		var smsCode = $(this).val();
		if(smsCode==null || $.trim(smsCode) == ""||smsCode=="请输入短信验证码"){
			$(".smsCodeText").text(textSmsCode);
			$("#msgcode").fadeIn();
			return false;
		}else{
			$("#msgcode").hide();
		}
		});
		
   $("#getCode").click(function(){
   		var username = $phoneUsername.val();
		var pattern = new RegExp(/^[1][3,4,7,5,8][0-9]{9}$/);
		var isPass =  pattern.test($.trim(username));
		var phoneCode = $("#phoneCode").val();
		if(username==null || $.trim(username) == ""){
			textValue="请输入11位有效手机号码!";
			$(".phursnam").text(textValue);
			$("#phoneAccount").fadeIn();
			return false;
		}else{
			$("#phoneAccount").hide();
		}
		if(!isPass){
			textValue="请输入11位有效手机号!";
			$(".phursnam").text(textValue);
			$("#phoneAccount").fadeIn();
			return false;
			}else{
			$("#phoneAccount").hide();
		 }
		if(phoneCode==null || $.trim(phoneCode) == ""){
			$(".codetext").text(textPhoneCode);
			$("#vcode").fadeIn();
			return false;
		}else{
			$("#vcode").hide();
		}
   		if(count == 61){
		$.ajax({
			url: "${base}/login/login!validateMobileCode.action",
			type: "GET",
			data: {
				username: $.trim($phoneUsername.val()),
				smsCode: $('#smsCode').val(),
				phoneCode:phoneCode,
			},
			cache: false,
			success: function(data) {
				if(data==0){
				timer = window.setInterval("timeDesc()", 1000);
					$alert("warn","验证码发送成功","友情提示",null);
				}else if(data==1){
					$alert("warn","验证码发送失败！","友情提示",null);
				}else if(data==2){
					textPhoneCode="验证码不正确！";
					$(".codetext").text(textPhoneCode);
					$("#vcode").fadeIn();
				}else if(data==3){
					textValue="该手机号不存在，请注册后登录!";
					$(".phursnam").text(textValue);
					$("#phoneAccount").fadeIn();
					return false;
				}
			}
		});
   		}
	});
    //手机验证登录
	$("#mobile_submit").click(function (){
		var username = $phoneUsername.val();
		var pattern = new RegExp(/^[1][3,4,7,5,8][0-9]{9}$/);
		var isPass =  pattern.test($.trim(username));
		if(username==null || username == ""){
			$(".phursnam").text("请输入11位有效手机号!");
			$("#phoneAccount").fadeIn();
			return false;
		}
		if(username=="请输入手机号"){
			textValue="请输入11位有效手机号!";
			$(".phursnam").text(textValue);
			$("#phoneAccount").fadeIn();
			return false;
		}
		if(!isPass){
			textValue="请输入11位有效手机号!";
			$(".phursnam").text(textValue);
			$("#phoneAccount").fadeIn();
			return false;
		}
		if($phoneCode.val()==null || $.trim($phoneCode.val()) == "" || $phoneCode.val()=="请输入验证码"){
			textPhoneCode="请输入验证码!";
			$(".codetext").text(textPhoneCode);
			$("#vcode").fadeIn();
			return false;
		}
		if($smsCode.val()==null || $.trim($smsCode.val()) == ""|| $smsCode.val()=="请输入短信验证码"){
			$(".smsCodeText").text("请输入短信验证码!");
			$("#msgcode").fadeIn();
			return false;
		}
		 $.ajax({
				url: "${base}/login/login!mobileLogin.action",
				data:{
				username:$.trim($phoneUsername.val()),
				phoneCode:$.trim($phoneCode.val()),
				smsCode:$.trim($smsCode.val()),
				},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
					if ($isRememberUsername.prop("checked")) {
						addCookie("memberUsername", $phoneUsername.val(), {expires: 7 * 24 * 60 * 60});
					} else {
						removeCookie("memberUsername");
					}	
					if(data.flag==1){
						textValue="该手机号不存在，请注册后登录!";
						$(".phursnam").text(textValue);
						$("#phoneAccount").fadeIn();
						return false;
					}else if(data.flag==2){
						textValue="该帐户已被停用！";
						$(".phursnam").text(textValue);
						$("#phoneAccount").fadeIn();
						return false;
					}else if(data.flag==4){
						textPhoneCode="验证码不正确！";
						$(".codetext").text(textPhoneCode);
						$("#vcode").fadeIn();
					}else if(data.flag==3){
						textSmsCode="短信验证码输入不正确！";
						$(".smsCodeText").text(textSmsCode);
						$("#msgcode").fadeIn();
					}else{
						if(data.flag==5){
							$('#phoneAccount').append(data.login);
						}
						setTimeout(function() {
								addCookie("username", $phoneUsername.val(), {expires: 7 * 24 * 60 * 60});
								<#if redirectUrl?exists>
									location.href = "${redirectUrl}";
								<#else>
									location.href = "${base}/index.html";
								</#if>
							}, 500);
					}
				}
		   });
	});
	//用户名验证登录
	var $emailUsername = $("#emailUsername");
	var $password = $("#password");
	var $emailCode = $("#emailCode");
	var textEmail="";
	var textPassword="";
	var textCode="";
	//记住邮箱用户名
	var $isRememberEmailUsername=$("#isRememberEmailUsername");
	$isRememberEmailUsername.prop("checked", true);
	if (getCookie("memberEmailUsername") != null) {
		$isRememberEmailUsername.prop("checked", true);
		$emailUsername.val(getCookie("memberEmailUsername"));
		//$password.focus();
		//$emailCode.focus();
	} else {
		$isRememberEmailUsername.prop("checked", false);
		//$emailUsername.focus();
	}
	$emailUsername.focus(function(){
		if($(this).val() == $(this).attr("tar")){
			$(this).val("");
		}
		$('.emailAccount').html("<p class='em-p'><span class='emailText'>"+textEmail+"</span><i></i></p></div></li>");
	});
	$emailUsername.keydown(function(event) {
		if (event.keyCode == 13) {
			$("#email_submit").trigger("click");
		}
	});
	$emailUsername.blur(function(){
		var emailUsername = $(this).val();
		if(emailUsername==null || $.trim(emailUsername) == "" ||emailUsername=="请输入用户名"){
			textEmail="请输入用户名!";
			$(".emailText").text(textEmail);
			$("#emailAccount").fadeIn();
			return false;
		}else{
			$("#emailAccount").hide();
		}
		});
	$password.focus(function(){
		document.getElementById("password").type = 'password';
		if($(this).val() == $(this).attr("tar")){
			$(this).val("");
		}
		$('.accountPassword').html("<p class='em-p'><span class='passwordText'>"+textPassword+"</span><i></i></p></div></li>");
	});
	$password.keydown(function(event) {
		if (event.keyCode == 13) {
			$("#email_submit").trigger("click");
		}
	});
	$password.blur(function(){
		var password = $(this).val();
		document.getElementById("password").type = 'text';
		if(password==null || $.trim(password) == ""){
			textPassword="请输入密码！";
			$(".passwordText").text(textPassword);
			$("#accountPassword").fadeIn();
			return false;
		}else{
			document.getElementById("password").type = 'password';
			$("#accountPassword").hide();
		}
		});
	$emailCode.focus(function(){
		if($(this).val() == $(this).attr("tar")){
			$(this).val("");
		}
		$('.accountCode').html("<p class='em-p'><span class='emailCodeText'>"+textCode+"</span><i></i></p></div></li>");
	});
	$emailCode.keydown(function(event) {
		if (event.keyCode == 13) {
			$("#email_submit").trigger("click");
		}
	});
	$emailCode.blur(function(){
		var emailCode2 = $(this).val();
		if(emailCode2==null || $.trim(emailCode2) == ""){
			textCode="请输入验证码！";
			$(".emailCodeText").text(textCode);
			$("#accountCode").fadeIn();
			return false;
		}else{
			$("#accountCode").hide();
		}
		});
	$("#email_submit").click(function (){
		if($emailUsername.val()==null || $.trim($emailUsername.val()) == "" || $emailUsername.val()=="请输入用户名"){
			textEmail="请输入用户名！";
			$(".emailText").text(textEmail);
			$("#emailAccount").fadeIn();
			return false;
		}
		if($password.val()==null || $.trim($password.val()) == ""|| $password.val()=="请输入密码"){
		textPassword="请输入密码！";
			$(".passwordText").text(textPassword);
			$("#accountPassword").fadeIn();
			return false;
		}
		if($emailCode.val()==null || $.trim($emailCode.val()) == ""||$emailCode.val()=="请输入验证码"){
			textCode="请输入验证码！";
			$(".emailCodeText").text(textCode);
			$("#accountCode").fadeIn();
			return false;
		}
		 $.ajax({
				url: "${base}/login/login!emailLogin.action",
				data:{
				username:$.trim($emailUsername.val()),
				password:$.trim($password.val()),
				emailCode:$.trim($emailCode.val()),
				},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
					if ($isRememberEmailUsername.prop("checked")) {
						addCookie("memberEmailUsername", $emailUsername.val(), {expires: 7 * 24 * 60 * 60});
					} else {
						removeCookie("memberEmailUsername");
					}	
					if(data.flag==1){
						textEmail="该用户名不存在，请注册后登录!";
						$(".emailText").text(textEmail);
						$("#emailAccount").fadeIn();
						return false;
					}else if(data.flag==2){
						textEmail="该帐户已被停用！";
						$(".emailText").text(textEmail);
						$("#emailAccount").fadeIn();
						return false;
					}else if(data.flag==3){
						textPassword="用户名或密码有误!";
						$(".passwordText").text(textPassword);
						$("#accountPassword").fadeIn();
						return false;
					}else if(data.flag==4){
						textCode="验证码不正确！";
						$(".emailCodeText").text(textCode);
						$("#accountCode").fadeIn();
						return false;
					}else{
							if(data.flag==5){
								$('#accountPassword').append(data.login);
							}
						setTimeout(function() {
							addCookie("username", $emailUsername.val(), {expires: 7 * 24 * 60 * 60});
							<#if redirectUrl?exists>
								location.href = "${redirectUrl}";
							<#else>
								location.href = "${base}/index.html";
							</#if>
						}, 500);
					}
				}
		   });
	});
});
</script>
</body>
</html>
