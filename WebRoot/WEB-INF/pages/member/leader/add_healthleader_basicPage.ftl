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
                <li class="state-tip"><b>1</b><span>验证手机号</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip finish-tip"><b>2</b><span class="doing-tit">完善资料</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip"><b>3</b><span>申请成功</span></li>
            </ul>
        </div>
    </h2>
    <form id="inputForm" name="form1" action="${base}/newleader/newleader!registerLeader.action" method="post">
    <dl class='extract-binding-margin'></dl>
    <#if  stype=="1" && stype?exists >
    <dl class="extract-binding  w352">
        <dt>设置密码：</dt>
        <dd id="password_text">
            <input type="password" class="extract-binding-text" value="" placeholder='数字加字母组成，且不少于8位' id="password" name="password" maxlength="16" onBlur="ckpassword()" onFocus="submitErr('password','','2')"/>
            <span class="import-correct" style="display: none" id="password_succ"></span>
            <span class="import-wrong" style="display: none" id="password_err"></span>
        </dd>
    </dl>
    <dl class="extract-binding w352">
        <dt>确认密码：</dt>
        <dd id="rePassword_text">
            <input type="password" class="extract-binding-text" value="" placeholder='请重新输入密码' id="rePassword" name="rePassword" maxlength="16" onBlur="ckrePassword()" onFocus="submitErr('rePassword','','2')"/>
            <span class="import-correct" style="display: none" id="rePassword_succ"></span>
            <span class="import-wrong" style="display: none" id="rePassword_err"></span>
        </dd>
    </dl>
    </#if>
    <dl class="extract-binding w352">
        <dt>昵称：</dt>
        <dd id="nickName_text">
            <input type="text" class="extract-binding-text" maxlength="8" id="nickName" name="nickName" onFocus="submitErr('nickName','','2')"/>
            <span class="import-correct" style="display: none" id="nickName_succ"></span>
            <span class="import-wrong" style="display: none" id="nickName_err"></span>
        </dd>
    </dl>
    <dl class="extract-binding w352">
        <dt>真实姓名：</dt>
        <dd id="realName_text">
            <input type="text" class="extract-binding-text" maxlength="16" id="realName" name="realName" onFocus="submitErr('realName','','2')"/>
            <span class="import-correct" style="display: none" id="realName_succ"></span>
            <span class="import-wrong" style="display: none" id="realName_err"></span>
        </dd>
    </dl>
        <input type="hidden" id="stype" name="stype" value="${stype?if_exists}"/>
        <input type="hidden" id="phone" name="phone" value="${phone?if_exists}"/>
    <div class="health-binding-btn">
            <input type="button" value="下一步" onclick="reg()"/>
    </div>
    </form>
</div>
<!--提现结束-->
<!--js-->
<script type="text/javascript">
function ckpassword(){
  var password =  $('#password').val();
  if($.trim(password)=="" || password.length==0 ){
     submitErr('password','密码不能为空','1');
	 return false;
  }
  var p = /^(?!(?:\d*$))[A-Za-z0-9]{6,20}$/;
  if(!p.test(password)){
    submitErr('password','请输入有效的密码','1');
	return false;
  }
  submitErr('password','','3');
}
function ckrePassword(){
  var rePassword =  $('#rePassword').val();
  if($.trim(rePassword)=="" || rePassword.length==0 ){
     submitErr('rePassword','确认密码不能为空','1');
	 return false;
  }
  var p = /^(?!(?:\d*$))[A-Za-z0-9]{6,20}$/;
  if(!p.test(rePassword)){
    submitErr('rePassword','请输入有效的确认密码','1');
	return false;
  }
  var password =  $('#password').val();
  if(password!=rePassword){
    submitErr('rePassword','两次密码不一致','1');
	return false;
  }
  submitErr('rePassword','','3');
}

 function submitErr(id,message,type){
     if(type=="1"){
          $('#'+id+"_text").addClass('border-red');
          $('#'+id+"_succ").hide();
          $('#'+id+"_err").html(message);
          $('#'+id+"_err").show();
     }else if(type=="2"){
     	  $('#'+id+"_text").removeClass('border-red');
          $('#'+id+"_err").html('');
          $('#'+id+"_err").hide();
     }else{
          $('#'+id+"_succ").show();
     }
} 

function reg(){
   var s = $('#stype').val();
   if(s=="1"){
      var password =  $('#password').val();
  	  if($.trim(password)=="" || password.length==0 ){
       	submitErr('password','密码不能为空','1');
	 	return false;
  	  }
	  var p = /^(?!(?:\d*$))[A-Za-z0-9]{6,20}$/;
	  if(!p.test(password)){
	    submitErr('password','请输入有效的密码','1');
		return false;
	  }
	  var rePassword =  $('#rePassword').val();
	  if($.trim(rePassword)=="" || rePassword.length==0 ){
	     submitErr('rePassword','确认密码不能为空','1');
		 return false;
	  }
	  if(!p.test(rePassword)){
		submitErr('rePassword','请输入有效的确认密码','1');
		return false;
	  }
	  var password =  $('#password').val();
	  if(password!=rePassword){
	  	submitErr('rePassword','两次密码不一致','1');
		return false;
	  }
   }
   var nickName =  $('#nickName').val();
   if($.trim(nickName)=="" || nickName.length==0 ){
   	submitErr('nickName','昵称不能为空','1');
 	return false;
   }
   var realName =  $('#realName').val();
   if($.trim(realName)=="" || realName.length==0 ){
       	submitErr('realName','真实姓名不能为空','1');
	 	return false;
  }   
  $('#inputForm').submit(); 
}
</script>
</body>
</html>