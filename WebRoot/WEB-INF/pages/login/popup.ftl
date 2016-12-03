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
    <title>绑定账号</title>
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
    <style type="text/css">
        .login-title .name-gray{font-size:12px; color:#999;}
        .binding-account{padding:55px 0 0 380px;}
        .import-message dd{width:230px; padding:6px 10px;}
        .impart-text{width:230px;}
        .binding-button input{width:333px;}
        #right {display: none;}
        #coderight {display: none;}
	    #mobilewarn1 {display: none;}
	    #mobilewarn2 {display: none;}
	    #codewarn {display: none;}
	    #codenullwarn {display: none;}
    </style>
</head>
<body class="login-bg">
 <div class="login-header">
        <div class="login-header-main">
            <h1 class="login-logo fl"><a href="#"><img src=http://img.zdfei.com/static/image/temp/20160727/b2cf6667dcefe918e8803b548d5d297a.png alt=""/></a></h1>
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
        <b class="forget-tit">绑定账号</b> <span class="name-gray">　/　您好，亲爱的${otherNickName?default('')}，欢迎来到医药馆！</span>
    </div>
    <div class="login-content">
       <div class="binding-account">
           <dl class="import-message">
               <dt>验证手机：</dt>
               <dd>
                   <input type="text" class="impart-text" placeholder="请输入手机号" id="mobile"/>
                   <span class="import-wrong" id="mobilewarn1">建议使用常用手机号验证</span>
                   <span class="import-wrong" id="mobilewarn2">请输入有效的手机号码</span>
                   <span class="import-correct" id="right"></span>
               </dd>
           </dl>
           <dl class="import-message">
               <dt>手机验证码：</dt>
               <dd>
                   <input type="text"  class="impart-text" placeholder="请输入手机验证码" id="phoneCode"/>
                   <span class="iphone-code" id="getCode">获取验证码</span>
                   <span class="import-wrong" id="codenullwarn">请输入手机验证码</span>
                   <span class="import-wrong" id="codewarn">您输入的验证码不正确，请重新输入</span>
                   <span class="import-correct" id="coderight"></span>
               </dd>
           </dl>
           <div class="login-button binding-button"><input type="button" value="立即绑定" id="bindingButton"/></div>
       </div>
    </div>
</div>
</body>
<script type="text/javascript">
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
	var $mobile = $("#mobile");
	var $phoneCode = $("#phoneCode");
	var mobileReg = new RegExp(/^[1][3,4,7,5,8][0-9]{9}$/);
	var result=false;
	$mobile.focus(function(){
		var mobile = $(this).val();
		if(mobile==null || $.trim(mobile) == ""){
			$("#mobilewarn1").show().parent().addClass("border-red");
			$("#mobilewarn2").hide();
			$("#right").hide();
			return false;
		}else{
			$("#mobilewarn1").hide().parent().removeClass("border-red");
			$("#mobilewarn2").hide();
			$("#right").hide();
			return false;
		}
	});
	$mobile.blur(function(){
		var mobile = $(this).val();
		if(mobile==null || $.trim(mobile) == ""){
			$("#mobilewarn1").hide().parent().removeClass("border-red");
			$("#mobilewarn2").hide();
			$("#right").hide();
			return false;
		}else if(!mobileReg.test($.trim(mobile))){
			$("#mobilewarn2").show().parent().addClass("border-red");
			$("#mobilewarn1").hide();
			$("#right").hide();
			return false;
		}else{
			$("#right").show().parent().removeClass("border-red");
			$("#mobilewarn1").hide();
			$("#mobilewarn2").hide();
		}
	});
	$phoneCode.blur(function(){
		var phoneCode = $(this).val();
		if(phoneCode==null || $.trim(phoneCode) == ""){
			$("#codenullwarn").hide().parent().removeClass("border-red");
			$("#codewarn").hide();
			return false;
		}else{
			$("#codenullwarn").hide().parent().removeClass("border-red");
			$("#codewarn").hide();
		}
	});
	$("#getCode").click(function(){
				var phoneCode =$("#phoneCode").val();
				var mobile = $("#mobile").val();
				if(mobile==null || $.trim(mobile) == ""){
					$("#mobilewarn2").show().parent().addClass("border-red");
					$("#mobilewarn1").hide();
					$("#right").hide();
					return false;
				}else if(!mobileReg.test($.trim(mobile))){
					$("#mobilewarn2").show().parent().addClass("border-red");
					$("#mobilewarn1").hide();
					$("#right").hide();
					return false;
				}else{
					$("#right").show().parent().removeClass("border-red");
					$("#mobilewarn1").hide();
					$("#mobilewarn2").hide();
				}
				if(count == 60){
					$.ajax({
							url: "${base}/login/bindingmobile!validateMobileCode.action",
							data:{
								mobile:mobile,
							    },
							type:"post",
							async:false,
							cache:false,
							success: function(data) {
								if(data==0){//发送成功
								timer = window.setInterval("timeDesc()", 1000);
								}else{
									$alert("warn","网络异常！","友情提示",null);
								}
							}
					});
				}
			});
	$("#bindingButton").click(function (){
				var phoneCode =$("#phoneCode").val();
				var mobile = $("#mobile").val();
				if(mobile==null || $.trim(mobile) == ""){
					$("#mobilewarn2").show().parent().addClass("border-red");
					$("#mobilewarn1").hide();
					$("#right").hide();
					return false;
				}else if(!mobileReg.test($.trim(mobile))){
					$("#mobilewarn2").show().parent().addClass("border-red");
					$("#mobilewarn1").hide();
					$("#right").hide();
					return false;
				}else{
					$("#right").show().parent().removeClass("border-red");
					$("#mobilewarn1").hide();
					$("#mobilewarn2").hide();
				}
				if(phoneCode==null || $.trim(phoneCode) == ""){
					$("#codenullwarn").show().parent().addClass("border-red");
					$("#codewarn").hide();
					return false;
				}else{
					$("#codenullwarn").hide().parent().removeClass("border-red");
					$("#codewarn").hide();
				}
				$.ajax({
							url: "${base}/login/bindingmobile!bindingMobile.action",
							data:{
								mobile:$.trim($("#mobile").val()),
								phoneCode:$.trim($("#phoneCode").val()),
							    },
							type:"post",
							async:false,
							cache:false,
							success: function(data) {
								if(data==2){//绑定成功
									$alert("warn","绑定成功！","友情提示",null);
									  var loginRedirect="";
									  <#if Session?exists> 
							          <#if Session.LoginRedirect?exists>  
				   						loginRedirect="${Session.LoginRedirect}";
				 					  </#if>  
				 					  </#if>  
							          if(loginRedirect==null || loginRedirect==""){
							        	 location.href = "${base}/index.html";
							          }else{
							         	 location.href=loginRedirect;
							          }
								}else if(data==1){//验证码不正确
										$("#codewarn").show().parent().addClass("border-red");
										$("#codenullwarn").hide();
										result=false;
								}else{
									$alert("warn","该账号异常，请联系客服！","友情提示",null);
								}
							}
				});
		 return result; 	
	});
});
</script>
</html>