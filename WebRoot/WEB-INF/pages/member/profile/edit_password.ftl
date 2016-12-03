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
</head>
<body>
<#include "/static/inc/center_header.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<form id="inputForm" name="inputForm" method="post" action="${base}/member/profile!savePassword.action" enctype="multipart/form-data">
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content binging">
            <h2>修改密码</h2>
            <div class="binging-box">
                <!--进度条-->
                <div id="process" class="section3 clear clearfix" style="margin-left:300px;">
                    <div class="bar-left"></div>
                    <div class="node doing">
                        <ul>
                            <li class="tx1"><span class="state-tip" style="color:#ff8181;"><s></s>修改登录密码</span></li>
                        </ul>
                    </div>
                    <div class="proce wait" style="width:300px;">
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
                        <dt>已验证手机</dt>
                        
                        <dd><p>${member.mobile[0..2]?default('')}<strong>****</strong>${member.mobile[7..10]?default('')}</p></dd>
                    </dl>
                    <dl>
                        <dt>短信校验码</dt>
                        <dd>
                            <input id="mobileCheck" name="mobileCheck" type="text"  class="txt"/>
                            <input type="button" value="获取验证码" class="btn-gain btn-send-mobileCheck"/>
                            
                        </dd>
                    </dl>
                    <dl>
                        <dt>新的密码</dt>
                        <dd>
                            <input id="password" name="password" type="password" class="txt"/>
                        	<a style="line-height:45px;height:45px;margin-left:10px;">由6-20位字母、数字，符号两种以上组成</a>
                        </dd>
                    </dl>
                    <dl>
                        <dt>确认密码</dt>
                        <dd>
                            <input id="rePassword" name="rePassword" type="password" class="txt"/>
                        </dd>
                    </dl>
                    <dl>
                        <dt>验证码</dt>
                        <dd>
                            <input id="rand" name="rand" type="text" class="txt"/>
                            <span><img id="randImg" style="  line-height: 28px;height: 28px;" src="${base}/static/inc/number.jsp"/></span>
                            <input  type="button" value="换一张" class="btn-change"/>
                        </dd>
                    </dl>
                    <dl class="submit-dl">
                        <dt></dt>
                        <dd><input  type="submit" value="下一步"  class="btn-submit"/></dd>
                    </dl>
                    <div class="verify-tel">
                        <p>如果您有任何疑问，请联系在线客服或者</p>
                        <p>拨打服务热线： 400-606-3111</p>
                    </div>
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
		$(".btn-send-mobileCheck").val(count+"秒重新发送");
		$(".btn-send-mobileCheck").css("background-color","#e5e5e5");
		$(".btn-send-mobileCheck").prop("disabled", "disabled");
	}else{
		$(".btn-send-mobileCheck").val("重获验证码");
		$(".btn-send-mobileCheck").css("background-color","#e5e5e5");
		$(".btn-send-mobileCheck").prop("disabled", "");
		count = 61;
		clearInterval(timer);
		timer = "";
	}
}

$().ready(function(){
	$(".btn-send-mobileCheck").click(function(){
		
		if(count == 61){
			timer = window.setInterval("timeDesc()", 1000);
			//发送短信验证码
			$.ajax({
				url: "${base}/member/profile!sendMobileCheck.action",
				data:{mobile:'${member.mobile?default('')}'},
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
		var mobileCheck = $("#mobileCheck").val();
		var password = $("#password").val();
		var rePassword = $("#rePassword").val();
		var rand = $("#rand").val();
		
		if(mobileCheck==null || mobileCheck == ""){
			$alert("warn","短信验证码为空","友情提示",null);
			return false;					
		}
		
		var reg = /^(?!(?:\d*$))[A-Za-z0-9]{6,20}$/;
		
		
		if(password==null || password == ""){
			$alert("warn","密码不能为空","友情提示",null);
			return false;					
		}
		
		if(!reg.test(password)){
			$alert("warn","密码格式错误","友情提示",null);
			return false;					
		}
		
		if(rePassword==null || rePassword == ""){
			$alert("warn","确认密码不能为空","友情提示",null);
			return false;					
		}
		
		if(password != rePassword){
			$alert("warn","两次密码不一致","友情提示",null);
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
});
</script>