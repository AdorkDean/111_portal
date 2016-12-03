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
    <title>绑定手机号</title>
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

    <!--style-->
    <script type="text/javascript" src="${base}/web/js/jquery-1.7.2.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css">
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css">
     <script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/login.css">
</head>

<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">  
<!-- line开始-->
<div class="member-line"></div>
<!-- line结束-->
   
<!--联合登录开始-->
<div class="unite-login" >
    <h4 class="unite-title unite-title-login">亲，绑定手机号，开启111医药馆之旅吧......</h4>
    <div class="unite-info clearfix clear">
        <dl class="unite-joint-login clearfix clear">
            <dt><img src="${base}/web/images/register/joint_login.jpg"/></dt>
            <dd>
                <ul>
                    <li class="clearfix clear">
                        <span>手机号</span>
                        <div class="unite-joint-login-ipt">
                            <i class="u_ico"></i>
                            <input type="text" value="请输入手机号" id="mobile" onfocus="javascript:if(this.value=='请输入手机号'){ this.value='';this.style.color='#333'}" onblur="javascript:if(this.value==''){ this.value='请输入手机号';this.style.color='#c0c9ca'}">
                            <div class="empty" id="mobileAccount" style="display:none;"><span class="mobileText"></span></div>
                        </div>
                    </li>
                    <li class="clearfix clear">
                        <span>密码</span>
                        <div class="unite-joint-login-ipt">
                            <i class="p_ico"></i>
                            <input type="password"  id="password" value="密码长度6-16字符(区分大小写)" onfocus="javascript:if(this.value=='密码长度6-16字符(区分大小写)'){ this.value='';this.style.color='#333'}" onblur="javascript:if(this.value==''){ this.value='密码长度6-16字符(区分大小写)';this.style.color='#c0c9ca'}">
                        </div>
                    </li>
                    <li class="clearfix clear">
                        <span>短信验证码</span>
                        <div class="unite-joint-login-ipt w168">
                            <i></i>
                            <input type="text" id="smsCode" value="请输入验证码" onfocus="javascript:if(this.value=='请输入验证码'){ this.value='';this.style.color='#333'}" onblur="javascript:if(this.value==''){ this.value='请输入验证码';this.style.color='#c0c9ca'}">
                        </div>
                        <input type="button" id="getCode" value="获取验证码" class="get-code"/>
                    </li>
                    <li class="last-btn clearfix clear">
                        <span></span>
                        <a href="javascript:modify();" id="startButton" class="start-btn">开始体验</a>
                        <a href="javascript:modify();" id="noExperience" class="neglect-btn">忽略体验</a>
                    </li>
                </ul>
            </dd>
        </dl>
    </div>
</div>
<!--联合登录结束-->
</body>
<script type="text/javascript">    
 	var pattern = new RegExp(/^[1][3,4,7,5,8][0-9]{9}$/);
 	var $moblie=$("#mobile").val();
	var $password=$("#password").val();
		//开始倒计时
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
 	//获取验证码
 	 $("#getCode").click(function(){
 	 	 var isPass =  pattern.test($.trim($("#mobile").val()));
 	 	 if($("#mobile").val()=="" || $("#mobile").val()==null ||$("#mobile").val()=="请输入手机号"){
		 $alert("warn","请输入手机号码","友情提示",null);
		 return false;
		}
 	 	if(!isPass){
		 $alert("warn","请输入有效的手机号码","友情提示",null);
		 return false;
		}
		if(count==61){
			$.ajax({
				url: "${base}/login/bindingmobile!validateMobileCode.action",
				type: "GET",
				data: {
					moblie:$("#mobile").val(),
				},
				cache: false,
				success: function(data) {
					if(data==0){
					timer = window.setInterval("timeDesc()", 1000);
						$alert("warn","验证码发送成功","友情提示",null);
					}else if(data==1){
						$alert("warn","验证码发送失败！","友情提示",null);
						return false;
					}
				}
			});
		}
	});
	
	$("#mobile").blur(function(){
		var username = $(this).val();
		var pattern = new RegExp(/^[1][3,4,7,5,8][0-9]{9}$/);
		var isPass =  pattern.test($.trim(username));
		if(!isPass || username==null || $.trim(username) == ""){
		 $alert("warn","请输入有效的手机号！",null);
		 return false;
		 }
	});
		$("#password").blur(function(){
		var password = $(this).val();
		var regpassword = /^(?!(?:\d*$))[A-Za-z0-9]{6,16}$/;
		var isPass =  regpassword.test($.trim(password));
		if(!isPass || password==null || $.trim(password) == ""){
		 $alert("warn","密码由6-16位字母，数字，符号两种组合以上组成！",null);
		 return false;
		}
	});
	//忽略体验
	$("#noExperience").click(function(){
		var loginRedirect = "";
		  <#if Session.LoginRedirect?exists>  
   				loginRedirect="${Session.LoginRedirect}";
 		 </#if> 
 		 if(loginRedirect==null || loginRedirect==""){
			    location.href = "${base}/index.html";
			    }else{
			       window.location.href=loginRedirect;
			  }
	});
	//绑定手机号
	$("#startButton").click(function(){
		var isPass =  pattern.test($.trim($("#mobile").val()));
		if($("#mobile").val()=="" || $("#mobile").val()==null ||$("#mobile").val()=="请输入手机号"){
		 $alert("warn","请输入手机号码","友情提示",null);
		 return false;
		}
		if(!isPass){
		 $alert("warn","请输入有效的手机号码","友情提示",null);
		 return false;
		}
		var $code=$("#smsCode");
 	    if($code.val()==null || $code.val()==""){
 	    	$alert("warn","验证码不能为空！","友情提示",null);
 	    	return false;
 	    }
	       $.ajax({
				url: "${base}/login/bindingmobile!bindingMobile.action",
				data:{
				moblie:$("#mobile").val(),
				password:$("#password").val(),
				smsCode:$("#smsCode").val(),
				},
				type: "GET",
				cache: false,
				success: function(data) {
			         if(data==0){
			      	 $alert("warn","该手机号已被注册,请尝试直接登录或者换个手机号码！","友情提示",null);
			         }else if(data==1){
			         $alert("warn","验证码不正确","友情提示",null);
			         }else if(data==2){
			          var loginRedirect="";
			          <#if Session.LoginRedirect?exists>  
   						loginRedirect="${Session.LoginRedirect}";
 					  </#if>  
			          if(loginRedirect==null || loginRedirect==""){
			        	 location.href = "${base}/index.html";
			          }else{
			         	 location.href=loginRedirect;
			          }
			         }
				}
		   });
	   return false;		  	
	});
</script>
</html>