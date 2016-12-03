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
    <title>登陆</title>
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
   <!-- <link rel="stylesheet" type="text/css" href="${base}/web/css/login/common.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/login/login.css"/> -->
    <script src="${base}/web/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${base}/web/version2.2.0/js/global.js"></script>
    <script type="text/javascript" src="${base}/web/js/cookieUtil.js"></script>
    <script type="text/javascript" src="${base}/web/js/cart.js"></script> 
    <link href="${base}/web/css/login/login.css" rel="stylesheet" type="text/css" />
    <link href="${base}/web/css/login/common.css" rel="stylesheet" type="text/css" />
    
  <!--  <script type="text/javascript" src="/web/js/??jquery.min.js,cookieUtil.js,cart.js,alert.main.js"></script>
    <script type="text/javascript" src="/web/version2.2.0/js/??global.js"></script>-->
    <style>
	input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {color: #999; } 
	input:-moz-placeholder, textarea:-moz-placeholder { color: #999; } 
	input::-moz-placeholder, textarea::-moz-placeholder { color: #999; } 
	input:-ms-input-placeholder, textarea:-ms-input-placeholder { color: #999; } 
    #right {display: none;}
    #usernamewarn {display: none;}
    #passwordwarn {display: none;}
    #validatewarn {display: none;}
    #codewarn {display: none;}
    #codenullwarn {display: none;}
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
           <h2 class="fl">老用户登录/ <b>尊敬的医药馆用户，欢迎您回来！</b></h2>
           <span class="fr">没有账户？<a href="${base}/register/register!rindex.action">立即注册</a></span>
       </div>
        <div class="login-content">
            <div class="login-list-left">
                <dl class="import-message">
                    <dt>账 号：</dt>
                    <dd>
                        <input type="text" class="impart-text" placeholder="用户名/手机号/邮箱" value="18610806042" id="username"/>
                        <span class="import-correct" id="right"></span>
                        <span class="import-wrong" id="usernamewarn">您输入的用户名不正确，请重新输入</span>
                    </dd>
                </dl>
                <dl class="import-message">
                    <dt>密 码：</dt>
                    <dd>
                        <input type="password"  class="impart-text" placeholder="请输入密码" value="a1111111" id="password"/>
                        <span class="import-wrong" id="passwordwarn">您输入的密码不正确，请重新输入</span>
                    </dd>
                </dl>
                <dl class="import-message" id="validatewarn">
               	   <dt>验 证：</dt>
                   <dd class="impart-dd">
                   <input type="text" id="phoneCode" placeholder="请输入验证码" maxlength="12" class="impart-code"/>
					<img id="phoneSrcCode" src="${base}/static/inc/number.jsp?,Math.random();" alt="" class="code-img"/>
					<a href="#" class="see-no" id="phoneChangeCode">看不清换一张</a>
					<span class="import-wrong" id="codenullwarn">请您输入验证码</span>
					<span class="import-wrong" id="codewarn">您输入的验证码不正确，请重新输入</span>
				   </dd>
                </dl>
                <div class="login-button"><input type="button" id="userLogin" value="立即登录"/></div>
                <div class="forget-password">
                    <input type="checkbox" id="autoLogin"/>自动登录
                    <a href="${base}/findpassword/findpassword!index.action">忘记密码？</a>
                </div>
                <div class="other-id">
                    <span>您可以使用以下账号登录</span>
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
                <div class="other-list">
                    <ul>
                        <li><a href="${base}/login/qqlogin!index.action<#if redirectUrl?exists>?qqLoginRedirect=${redirectUrl}</#if>"><b class="login-qq"></b>QQ登录</a></li>
                        <li><a href="${base}/login/wxlogin!index.action<#if redirectUrl?exists>?wxLoginRedirect=${redirectUrl}</#if>"><b class="login-wx"></b>微信登录</a></li>
                        <li><a href="${base}/login/yktlogin!index.action<#if redirectUrl?exists>?yktLoginRedirect=${redirectUrl}</#if>"><b class="login-ykt"></b>医卡通登录</a></li>
                        <li><a href="javascript:;" id="alipayLogin"><b class="login-zfb"></b>支付宝</a></li>
                    </ul>
                </div>
            </div>
            <div class="login-banner">
             <a href="${base}/register/register!rindex.action"><img src="${base}/web/images/login/login_img.jpg" alt=""/></a>
            </div>
        </div>
    </div>
    <div style="margin-top:20px;">
     <#include "/static/inc/version2.2.0/footer.ftl">
    </div>
</body>
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
$().ready(function() {

$(".footer-content").css("border-top","none");

	$("#phoneChangeCode").click(function(){
		 var img = document.getElementById("phoneSrcCode");   
   			 img.src = "${base}/static/inc/number.jsp?" + Math.random();
		});
	var $username = $("#username");
	var $password = $("#password");
	var $phoneCode = $("#phoneCode");
	var flag=false;
	<#if loginfailureCount?exists>
		<#if loginfailureCount?length gte 3>
	  		 $("#validatewarn").show();
	   	</#if>
	  	
	</#if>
	$username.keydown(function(event) {
		if (event.keyCode == 13) {
			$("#userLogin").trigger("click");
		}
	});
	$password.keydown(function(event) {
		if (event.keyCode == 13) {
			$("#userLogin").trigger("click");
		}
	});
	$phoneCode.keydown(function(event) {
		if (event.keyCode == 13) {
			$("#userLogin").trigger("click");
		}
	});
	$username.blur(function(){
		var username = $(this).val();
		if(username==null || $.trim(username) == ""){
			$("#usernamewarn").hide().parent().removeClass("border-red");
			$("#right").hide();
			return false;
		}else{
			$("#usernamewarn").hide().parent().removeClass("border-red");
		}
		 $.ajax({
				url: "${base}/login/login!checkUserIsExist.action",
				data:{
				username:$.trim($username.val()),
				},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
					if(data==0){
						$("#right").show().parent().removeClass("border-red");
					}else{
						$("#right").hide();
						$("#usernamewarn").show().parent().addClass("border-red");
						return false;
					}
				}
		   });
	});
	$password.blur(function(){
		var password = $(this).val();
		if(password==null || $.trim(password) == ""){
			$("#passwordwarn").hide().parent().removeClass("border-red");
			return false;
		}else{
			$("#passwordwarn").hide().parent().removeClass("border-red");
		}
	});
	
	$("#userLogin").click(function (){
		<#if loginfailureCount?exists>
			<#if loginfailureCount?length gte 3>
		  		 $("#validatewarn").show();
		  		 if($phoneCode.val()==""||$phoneCode.val()==null){
								$("#codenullwarn").show().parent().addClass("border-red");
								$("#codewarn").hide();
								return false;
					}
		   	</#if>
		</#if>
		if($username.val()==null || $.trim($username.val()) == ""){
			$("#usernamewarn").show().parent().addClass("border-red");
			$("#right").hide();
			return false;
		}else{
			$("#usernamewarn").hide().parent().removeClass("border-red");
		}
		if($password.val()==null || $.trim($password.val()) == ""){
			$("#passwordwarn").show().parent().addClass("border-red");
			return false;
		}else{
			$("#passwordwarn").hide().parent().removeClass("border-red");
		}
		if($("#autoLogin").attr("checked")){
 			$.ajax({
						url: "${base}/login/login!saveCookie.action?"+Math.random(),
						type: "post",
						data: {
								username: $.trim($username.val()),
								password:$.trim($password.val()),
							  },
						async:false,
						cache:false,
						success: function(dataInfo) {
							}
				});
 		}
		 $.ajax({
				url: "${base}/login/login!userLogin.action?"+Math.random(),
				data:{
				username:$.trim($username.val()),
				password:$.trim($password.val()),
				phoneCode:$.trim($phoneCode.val()),
				},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
				if(data.flag==3){
					$("#usernamewarn").show().parent().addClass("border-red");
					$("#right").hide();
					flag=false;
				}else if(data.flag==6){
					if($phoneCode.val()==""||$phoneCode.val()==null){
							$("#codenullwarn").show().parent().addClass("border-red");
							$("#codewarn").hide();
							flag=false;
							}else{
							$("#codewarn").show().parent().addClass("border-red");
							$("#codenullwarn").hide();
							flag=false;
					 } 
				}else if(data.flag==1){
						$("#passwordwarn").show().parent().addClass("border-red");
						flag=false;
					}else if(data.flag==4){
						$("#validatewarn").show();
							$.ajax({
								url: "${base}/login/login!validateCode.action?"+Math.random(),
								type: "post",
								data: {
									username: $.trim($username.val()),
									phoneCode:$.trim($phoneCode.val()),
									password:$.trim($password.val()),
								},
								async:false,
								cache:false,
								success: function(dataInfo) {
									if($phoneCode.val()==""||$phoneCode.val()==null){
										$("#codenullwarn").show().parent().addClass("border-red");
										$("#codewarn").hide();
										flag=false;
									}else{
										$("#codenullwarn").hide().parent().removeClass("border-red");
										$("#codewarn").hide();
									}
									if(dataInfo==1){
										$("#codewarn").show().parent().addClass("border-red");
										$("#codenullwarn").hide();
										flag=false;
									}else if(dataInfo==2){
										$("#passwordwarn").show().parent().addClass("border-red");
										flag=false;
									}else{
										$("#codewarn").hide().parent().removeClass("border-red");
										$("#codenullwarn").hide();
										flag=true;
									}
								}
							});
					}else{
						if(data.flag==5){
							$('#usernamewarn').append(data.login);
						}
						<#if redirectUrl?exists>
								location.href = "${redirectUrl}";
							<#else>
								location.href = "${base}/index.html";
						</#if>
					}
				}
		   });
		  return flag;
	});
});
</script>
</html>