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
    <title>修改邮箱</title>
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
        <b class="forget-tit">修改邮箱</b>
    </div>
    <div class="login-content">
        <!--进度条-->
        <div class="process-bra clear clearfix binding-bra">
            <ul>
                <li class="state-tip finish-tip"><b>1</b><span class="doing-tit">验证身份</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip"><b>2</b><span>修改邮箱</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>3</b><span>修改成功</span></li>
            </ul>
        </div>
        <div class="login-list-center binding-box">
        	<p class="reset-email">已经验证邮箱：${email}</p>
            <dl class="import-message">
                <dt></dt>
                <dd class="border-red binding-icon03">
                    <input type="password" id="password" class="impart-text" maxlength="30" placeholder="请输入密码"/>
                    <span class="import-wrong" id="import-wrong" style="display:none;">密码错误,请重新输入</span>
                    <span class="import-correct" style="display:none;"></span>
                </dd>
            </dl>
            <dl class="import-message">
                <dt></dt>
                <dd class="impart-dd">
                    <input type="text" id="rand"  class="impart-code" maxlength="4" placeholder="请输入验证码"/>
                    <!--
                    <img src="/web/images/login/verification_code.jpg" alt="" class="code-img"/>
                    <a href="#" class="see-no">看不清换一张</a>
                    --!>
                    
                    <img id="randImg" class="code-img" style="  line-height: 28px;height: 28px;" src="${base}/static/inc/number.jsp"/>
                    <input  type="button" value="看不清换一张" class="btn-change see-no"/>
                    <span class="rand-wrong import-wrong" id="rand-wrong" style="display:none;">验证码输入错误</span>
                </dd>
            </dl>
            <div class="login-button binding-button" id="btn_div"><input type="button" id="btn-next" value="下一步"/></div>
            <div class="login-button binding-button" id="btn_div_temp" style="display:none;"><input type="button"  value="下一步"  style="background:#dddddd;"/></div>
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
	$("#password").focus(function(){
		$("#import-wrong").hide();
		$("#import-wrong").html('');
	});
	$("#rand").focus(function(){
		$("#rand-wrong").hide();
		$("#rand-wrong").html('');
	});
	$("#btn-next").click(function(){
		if($.trim($("#password").val()) == ''){
			$("#import-wrong").html("请输入密码");
			$("#import-wrong").show();
			return;
		}
		
		if($.trim($("#rand").val()) == ''){
			$("#rand-wrong").html("请输入验证码");
			$("#rand-wrong").show();
			return;
		}
		
		var tag =  true;
		showBtnTemp();	
		$.ajax({
			url: "${base}/member/memberCenter!randCheck.action",
			data:{rand:$("#rand").val(),password:$("#password").val(),type:'emailType'},
			type:"post",
			async:false,
			cache:false,
			success: function(data) {
				if(data==0){
					$("#rand-wrong").html("验证码错误");
					$("#rand-wrong").show();
					tag = false;
				}else if(data == 1){
					$("#import-wrong").html("密码错误,请重新输入");
					$("#import-wrong").show();
					tag = false;
				}else{
					randomUUID = data;
				}
			}
		 });	
		   
		 if(!tag){
		 	showBtn();
		   	return false;
		 }
		 
		 window.location.href = "${base}/member/memberCenter!toEmailUpdateInput.action?randomUUID="+randomUUID;
		
	});
</script>

</html>