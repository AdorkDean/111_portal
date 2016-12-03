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
    <title>修改密码</title>
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
	.import-tip {
	  position: absolute;
	  bottom: -25px;
	  left: 0px;
	  display: block;
	  height: 22px;
	  line-height: 22px;
	  padding-left: 2px;
	  width: 254px;
	}
	</style>
</head>
<body class="login-bg">
<div class="login-wrap">
    <div class="login-title">
        <a href="#"><img src="/web/images/login/login_logo.png" alt="" class="forget-logo"/></a>
        <b class="forget-tit">修改密码</b>
    </div>
    <div class="login-content">
        <!--进度条-->
        <div class="process-bra clear clearfix binding-bra">
            <ul>
                <li class="state-tip"><b>1</b><span>验证身份</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip finish-tip"><b>2</b><span class="doing-tit">设置新密码</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip"><b>3</b><span>修改成功</span></li>
            </ul>
        </div>
        <div class="login-list-center binding-box">
            <dl class="import-message">
                <dt></dt>
                <dd class="border-red binding-icon03">
                    <input type="password" id="new_password" name="newPassword" class="impart-text" maxlength="20" placeholder="数字加字母组合，8-20个字符"/>
                    <span class="import-wrong" id="password_wrong_one" style="display:none;">长度只能在8-20个字符之间</span>
                    <span class="import-tip" id="password_tip_one" style="display:none;">长度只能在8-20个字符之间</span>
                    <span class="import-correct" id="new_password_correct" style="display:none;"></span>
                </dd>
            </dl>
            <dl class="import-message">
                <dt></dt>
                <dd class="border-red binding-icon03">
                    <input type="password" id="new_password_two" class="impart-text" maxlength="20" placeholder="请重新输入密码"/>
                    <span class="import-wrong" id="password_wrong_two" style="display:none;">两次输入密码不一致</span>
                    <span class="import-correct" id="new_password_two_correct"  style="display:none;"></span>
                </dd>
            </dl>
            <div  class="login-button binding-button"><input type="button" id="btn_submit" value="确定"/></div>
        </div>
    </div>
</div>
</body>
<script>
	$("#new_password").keyup(function(){
		validateNewPasswordTip();
	});
	
	$("#new_password").focus(function(){
		$("#password_tip_one").show();
		$("#password_wrong_one").hide();
	});
	$("#new_password").focusout(function(){
		$("#password_tip_one").hide();
		validateNewPassword();
	});
	function validateNewPasswordTip(){
		var pwdreg = /^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{8,20}$/;
		var rs=pwdreg.test($("#new_password").val());
		if(rs){
			$("#new_password_correct").show();
			$("#password_wrong_one").html("");
			$("#password_wrong_one").hide();
			return true;
		}else{
			$("#new_password_correct").hide();
			//$("#password_wrong_one").html("数字加字母组合，8-20个字符");
			$("#password_tip_one").html("数字加字母组合，8-20个字符");
			$("#password_tip_one").show();
			return false;
		}
	}
	
	function validateNewPassword(){
		var pwdreg = /^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{8,20}$/;
		var rs=pwdreg.test($("#new_password").val());
		if(rs){
			$("#new_password_correct").show();
			$("#password_wrong_one").html("");
			$("#password_wrong_one").hide();
			return true;
		}else{
			$("#new_password_correct").hide();
			$("#password_wrong_one").html("数字加字母组合，8-20个字符");
			$("#password_tip_one").hide();
			$("#password_wrong_one").show();
			return false;
		}
	}
	
	
	function validateNewPasswordTwo(){
	
		if($.trim( $("#new_password").val() ) != ''){
			if($("#new_password_two").val() == ''){
				$("#password_wrong_two").html("请重新输入密码");
				$("#password_wrong_two").show();
				$("#new_password_two_correct").hide();
				return false;
		    }
		
			if($("#new_password").val() == $("#new_password_two").val()){
				$("#password_wrong_two").html("");
				$("#password_wrong_two").hide();
				$("#new_password_two_correct").show();
				return true;
			}else{
				$("#password_wrong_two").html("两次输入密码不一致");
				$("#password_wrong_two").show();
				$("#new_password_two_correct").hide();
				return false;
			}
		}
		return false;
	} 
	$("#new_password_two").change(function(){
		validateNewPasswordTwo();
		
	});
	$("#new_password_two").focus(function(){
		$("#password_wrong_two").html("");
		$("#password_wrong_two").hide();
	});
	
	$("#btn_submit").click(function(){
		if(validateNewPassword() && validateNewPasswordTwo()){
			var tag =  true;	
			$.ajax({
				url: "${base}/member/memberCenter!setNewPassword.action",
				data:{newPassword:$("#new_password").val()},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
					if(data==0){
						$alert("warn","密码设置失败","友情提示",null);
						tag = false;
					}else if(data == 1){
						//$alert("warn","密码设置成功","友情提示",null);
						tag = true;
					}
				}
			 });	
			   
			 if(!tag){
			   	return false;
			 }
			 
			 window.location.href = "${base}/member/memberCenter!toPasswordSetsuccess.action";
		 }
	});
</script>
</html>