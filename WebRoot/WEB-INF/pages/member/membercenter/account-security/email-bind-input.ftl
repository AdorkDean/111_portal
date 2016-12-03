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
    <title>绑定邮箱</title>
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
        <a href="#"><img src="/web/images/login/login_logo.png" alt="" class="forget-logo"/></a>
        <b class="forget-tit">绑定邮箱</b>
    </div>
    <div class="login-content">
        <!--进度条-->
        <div class="process-bra clear clearfix binding-bra">
            <ul>
                <li class="state-tip"><b>1</b><span>验证身份</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip finish-tip"><b>2</b><span class="doing-tit">绑定邮箱</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip"><b>3</b><span>绑定成功</span></li>
            </ul>
        </div>
        <div class="login-list-center binding-box">
            <dl class="import-message">
                <dt></dt>
                <dd class="border-red binding-icon02">
                    <input type="text" maxlength=50 id="email" class="impart-text" placeholder="请输入邮箱"/>
                    <span class="import-wrong" id="email_error_tip" style="display:none;">邮箱格式不正确，请重新填写</span>
                    <span class="import-correct" style="display:none;"></span>
                </dd>
            </dl>
            <div class="login-button binding-button" id="btn_div"><input type="button" id="btn_submit" value="确定"/></div>
            <div class="login-button binding-button " id="btn_div_temp" style="display:none;"><input type="button" style="background:#dddddd;" value="确定"/></div>
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

$("#email").change(function(){
	checkEmail();
});

var emailreg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;

$("#btn_submit").click(function(){
	
	showBtnTemp();
	//$("#btn_submit").attr("disabled",true);
	if(!checkEmail()){
		//$("#btn_submit").attr("disabled",false);
		showBtn();
		return;
	}
	$.ajax({
		url: "${base}/member/memberCenter!sendMail.action",
		data:{email:$("#email").val(),type:1},
		type:"post",
		async:false,
		cache:false,
		success: function(data) {
			if(data==0){//发送失败
				//$("#btn_submit").attr("disabled",false);
				$("#email_error_tip").html("邮箱不能为空");
				$("#email_error_tip").show();
				showBtn();
			}else if(data == 1){//
				//$("#btn_submit").attr("disabled",false);
				$("#email_error_tip").html("绑定邮箱已经存在,请重新输入");
				$("#email_error_tip").show();
				showBtn();
			}else if(data == 2){//发送邮件成功
				window.location.href="/member/memberCenter!toEmailBindSend.action";
			}else if(data == 3){//发送邮件成功
				//$("#btn_submit").attr("disabled",false);
				$("#email_error_tip").html("邮箱发送失败,请重新发送");
				$("#email_error_tip").show();
				showBtn();
			}
		}
	 });
});

function checkEmail(){
	var email = $("#email").val();
	if(!email){
		$("#email_error_tip").html("请输入邮箱");
		$("#email_error_tip").show();
		return false;
	}
	
	if (email.replace(/[^\x00-\xff]/g, "**").length > 50) {
		$("#email_error_tip").html("邮箱只能在50个字符以内");
		$("#email_error_tip").show();
		return false;
	}
	var reg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
	if (email.replace(/[^\x00-\xff]/g, "**").length <= 4 || !reg.test(email)) {
		$("#email_error_tip").html("邮箱格式不正确");
		$("#email_error_tip").show();
		return false;
	}
	$("#email_error_tip").hide();
	$("#email_error_tip").html("");
	return true;
}


</script>
</html>