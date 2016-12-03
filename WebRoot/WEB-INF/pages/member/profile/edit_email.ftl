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
    <title>邮箱绑定</title>
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
    <link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
    <script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${base}/static/js/jq-alert-confirm.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/static/css/jq-alert-confirm.css">
</head>
<body>
<#include "/static/inc/center_header.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<form id="inputForm" name="inputForm" method="post" action="${base}/member/profile!saveEmail.action" enctype="multipart/form-data">
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content binging">
            <h2>邮箱绑定</h2>
            <div class="binging-box">
                <!--进度条-->
                <div id="process" class="section3 clear clearfix">
                    <div class="bar-left"></div>
                    <div class="node ready">
                        <ul>
                            <li class="tx1"><span class="state-tip"><s></s>验证身份</span></li>
                        </ul>
                    </div>
                    <div class="proce doing">
                        <ul>
                            <li class="tx1">&nbsp;</li>
                        </ul>
                    </div>
                    <div class="node doing">
                        <ul>
                            <li class="tx1"><span class="state-tip" style="color:#ff8181;"><s></s>绑定邮箱</span></li>
                        </ul>
                    </div>
                    <div class="proce wait">
                        <ul>
                            <li class="tx1">&nbsp;</li>
                        </ul>
                    </div>
                    <div class="node wait" style="border-radius:0 8px 8px 0; -moz-border-radius:0 8px 8px 0; -webkit-border-radius:0 8px 8px 0;">
                        <ul>
                            <li class="tx1"><span class="state-tip"><s></s>完成</span></li>
                        </ul>
                    </div>
                </div>
                <div class="verify-list">
                    <dl>
                        <dt>我的邮箱</dt>
                        <dd>
                            <input id="email" type="text" class="txt" name="email"/>
                            <input  type="button" value="发送验证码" class="btn-gain btn-send-emailCheck"/>
                        </dd>
                    </dl>
                    <dl>
                        <dt>邮箱验证码</dt>
                        <dd>
                            <input id="emailCheck" type="text" class="txt" name="emailCheck"/>
                            <a href="javascript:void(0);" id="login_mail" style="height:45px;line-height:45px;margin-left:10px;" target="_bank">请登录邮箱查看</a>
                        </dd>
                    </dl>
                    <dl>
                        <dt>验证码</dt>
                        <dd>
                            <input id="rand" type="text" class="txt" name="rand"/>
                            <span><img id="randImg" style="height:28px;" src="${base}/static/inc/number.jsp"/></span>
                            <input  type="button" value="换一张" class="btn-change"/>
                        </dd>
                    </dl>
                    <dl class="submit-dl">
                        <dt></dt>
                        <dd><input  type="button" value="绑定邮箱"  class="btn-submit"/></dd>
                    </dl>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
<#include "/static/inc/footer.ftl">
</body>
</html>
<script type="text/javascript">


var count = 61;
var timer ;
function timeDesc(){
	if(count>0){
		count--;
		$(".btn-send-emailCheck").val(count+"秒重新发送");
		$(".btn-send-emailCheck").css("background-color","#e5e5e5");
		$(".btn-send-emailCheck").prop("disabled", "disabled");
	}else{
		$(".btn-send-emailCheck").val("重发验证码");
		$(".btn-send-emailCheck").css("background-color","#e5e5e5");
		$(".btn-send-emailCheck").prop("disabled", "");
		count = 61;
		clearInterval(timer);
		timer = "";
	}
}

$().ready(function(){

	$(".btn-send-emailCheck").click(function(){
		
		var email = $("#email").val();
		if(email==null || email == ""){
			$alert("warn","邮箱不能为空","友情提示",null);
			return false;					
		}
		
		var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		
		if(!filter.test(email)){
			$alert("warn","邮箱格式不正确","友情提示",null);
			return false;					
		}
		
		if(count == 61){
			timer = window.setInterval("timeDesc()", 1000);
			//发送邮箱验证码
			$.ajax({
				url: "${base}/member/profile!sendEmailCheck.action",
				data:{email:$("#email").val()},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
					if(data>0){
						$alert("success","验证码发送成功","友情提示",null);
					}else{
						$alert("warn","验证码发送失败","友情提示",null);				
					}
				}
		   });
		}
	})

	
	$(".btn-change").click(function(){
		$("#randImg").attr("src","${base}/static/inc/number.jsp?,"+Math.random());
	})
	
	
	$(".btn-submit").click(function(){
		var email = $("#email").val();
		var emailCheck = $("#emailCheck").val();
		var rand = $("#rand").val();
		
		if(email==null || email == ""){
			$alert("warn","邮箱不能为空","友情提示",null);
			return false;					
		}
		
		if(emailCheck==null || emailCheck == ""){
			$alert("warn","邮箱验证码为空","友情提示",null);
			return false;					
		}
		
		if(rand==null || rand == ""){
			$alert("warn","验证码为空","友情提示",null);
			return false;					
		}else{
				
			var tag =  true;	
			$.ajax({
				url: "${base}/member/profile!randCheck.action",
				data:{rand:$("#rand").val()},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
					if(data<=0){
						$alert("warn","验证码错误","友情提示",null);
						tag = false;
					}
				}
		   });	
		   
		   if(!tag){
		   	return false;
		   }
		}		
		
		$("#inputForm").submit();
						
	});
	
	$("#login_mail").click(function(){
	
		var email = $("#email").val();
		var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		
		if(filter.test(email)){
			var split = email.split("@");
			window.open("http://email."+split[1]);
		}
		
	});
});
</script>
