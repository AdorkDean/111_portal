<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="111医药馆网上药店是国家药监局认证指定网上药房|打造为老百姓服务药品价格低品种全|网上购药买药就选壹壹壹医药馆药品特卖网站">
    <!-- keywords -->
    <meta name="keywords" content="壹壹壹医药馆|壹药馆|11医药馆|1药馆|医卡通|111医药馆|医药网|药品特卖网站">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>健康领秀</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="images/common/favicon.png">
    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/common/favicon.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="images/common/favicon.png">
    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/common/favicon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <!--common style-->

</head>
<body class="health-bc">
<!--头部开始-->
<#include "/static/inc/version2.2.0/new_leader_header.ftl"/>
<!--头部结束-->
<!--提现开始-->
<div class="my-pharmacy-page w1000 extract-padding">
    <h2 class="article-page-top">申请领秀
        <!--进度条-->
        <div class="process-bra clear clearfix">
            <ul>
                <li class="state-tip finish-tip"><b>1</b><span class="doing-tit">验证手机号</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip"><b>2</b><span>完善资料</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>3</b><span>申请成功</span></li>
            </ul>
        </div>
    </h2>
    <div class="login-list-center binding-box">
        <dl class="import-message">
            <dt></dt>
            <dd class="binding-icon01" id="phone_text">
                <input type="text" name="phone" class="impart-text"  placeholder="手机号码" maxlength="11" onkeyup="value=value.replace(/[^0-9]/g,'')" onFocus="submitErr('phone','','2')" value="<#if member?exists && member.mobile?exists>${member.mobile}</#if>" <#if member?exists && member.mobile?exists>readonly</#if>/>
                <span class="iphone-code02" id="getCode" onclick="sendPhoneCode()">获取验证码</span>
                <span class="import-wrong" style="display: none" id="phone_err"></span>
            </dd>
        </dl>
        <dl class="import-message">
            <dt></dt>
            <dd class="binding-icon04" id="code_text">
                <input type="text" name="code" class="impart-text" value="" placeholder="请输入手机验证码..." maxlength="6" onFocus="submitErr('code','','2')"/>
                <span class="import-wrong" style="display: none" id="code_err"></span>
            </dd>
        </dl>
    </div>
    <div class="agreement-input">
        <input type="checkbox" id="tk" checked="checked"/>同意<a href="http://www.111yao.com/web/share/agreement.html"  target="_blank" >健康领秀活动相关说明</a>
    </div>
    <div class="health-binding-btn">
            <input type="button" value="下一步" onclick="submitBtn();"/>
    </div>
</div>
<!--提现结束-->
<!--js-->
<script type="text/javascript">
    var getCode = document.getElementById("getCode");
    var timer = null;
    var count = 60;
    function ctime(){
		if (count == 60) {
            timer = window.setInterval("timeDesc()", 1000);
        }
    }
    function timeDesc() {
        if (count > 0) {
            count--;
            getCode.innerHTML = count + "S";
            getCode.style.background = "#f3f5f7";
            getCode.style.color="#666";
        } else {
            getCode.innerHTML = "获取验证码";
            getCode.style.background = "#fe4310";
            getCode.style.color="#FFF";
            count = 60;
            window.clearInterval(timer);
            timer = "";
        }
    }
    
function sendPhoneCode(){
	if (count == 60) {
			var phone = $("input[name='phone']").val();
			if(phone==null||phone==""){
				submitErr('phone','手机号码不能为空','1');
				return false;
			}
			if(!phone.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$/)){
				submitErr('phone','请输入正确的手机号码','1');
				return false;
			}
			
			$.ajax({// setShowGoodsComment
				url: "../newleader/newleader!sendPhoneCode.action",
				type: "POST",
				async:false,
				data: {'phone':phone} ,
				success: function(data){
					if(data=="-1"){
						submitErr('phone','手机号码已注册过健康领秀','1');
						return;
					}else if(data=="1"){
						$alertCanDisplay("success","发送成功","111医药馆提示您",null);
						ctime();
						return;
					}else{
						$alertCanDisplay("warn","发送失败","111医药馆提示您",null);
						ctime();
						return;				
					}
				},error:function(data){
				}
			});
	 }		
}  


function submitBtn(){
    var phone = $("input[name='phone']").val();
    if(phone==null||phone==""){
		submitErr('phone','手机号码不能为空','1');
		//nextBtnClass("0");
		return false;
	}
    if(!phone.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$/)){
		submitErr('phone','请输入正确的手机号码','1');
		//nextBtnClass("0");
		return false;
	}
    var code = $("input[name='code']").val();
    if(code==null||code==""){
		submitErr('code','验证码不能为空','1');
		//nextBtnClass("0");
		return false;
	}  
	if(!$("#tk").prop("checked")){
	   $alertCanDisplay("warn","请同意健康领秀用户使用条款","111医药馆提示您",null)
	   return false;
	}
   
    $.ajax({
		url: "../newleader/newleader!verifyPhoneCode.action",
		type: "POST",
		data: {'phone':phone,'verifyCode':code} ,
		async:false,
		success: function(data){
			if(data.status==1){
				window.location.href="../newleader/newleader!addHealthLeaderPage.action?phone="+phone;
			}else{
				submitErr('code','验证码不正确','1');
			}
		},error:function(data){
		}
	});
    
}   


function submitErr(id,message,type){
     if(type=="1"){
          $('#'+id+"_text").addClass('border-red');
          $('#'+id+"_err").html(message);
          $('#'+id+"_err").show();
     }else{
     	  $('#'+id+"_text").removeClass('border-red');
          $('#'+id+"_err").html('');
          $('#'+id+"_err").hide();
     }
}     

function nextBtnClass(s){
    if(s=="1"){
    	$("#nextBtn").html('');
   		$("#nextBtn").append("<a href='JavaScript:void(0)' class='gray'>下一步</a>");
    }else{
    	$("#nextBtn").html('');
   		$("#nextBtn").append("<a href='JavaScript:void(0)' onclick='submitBtn();'>下一步</a>");    
    }
}
</script>
</body>
</html>