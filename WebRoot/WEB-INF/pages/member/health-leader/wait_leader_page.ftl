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
    <title>申请领秀</title>
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
    <link rel="stylesheet" type="text/css" href="${base}/web/css/health.css"/>
    <script type="text/javascript" src="${base}/web/js/jquery.min.js"></script>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/center_leader.ftl">
<script>
$(function(){
	$(".current-page").find("h2").css({"color":"#19a69f","font-family":"Microsoft Yahei","letter-spacing":"1px"}).html("健康领秀");
	$(".current-page").find("a").css({"color":"#19a69f","border":"#19a69f 1px solid"});
});
</script>
<div class="health-line">
    <div class="health-bg">
        <div class="link-con">
        	<#if tLeader?exists && tLeader.auditType?exists && tLeader.auditType==2>
	            <span class="audit">领秀身份审核不通过,请您<a style="color:red;" href="../healthLeader/editHealthLeaderPage!editHealthLeaderPage.action?id=${tLeader.id?if_exists}"class="edit">去修改页</a>修改</span>
	            <#if tLeader?exists && tLeader.auditRemark?exists>
		            <div class="explain">
		            	<p><#if tLeader?exists><span style="color:red;">原因：</span>${tLeader.auditRemark?if_exists}</#if></p>
		            </div>
	            </#if>
        	<#elseif tLeader?exists && tLeader.auditType?exists && tLeader.auditType==0>
	            <span class="audit">领秀身份审核中......</span>
        	</#if>
            <b><img src="${base}/web/img/health-arrow.gif" alt=""/></b>
        </div>
    </div>
    <div class="health-rule">
        <ul>
            <li><h3>领秀活动规则</h3></li>
			<li>1、注册成为111医药馆健康领秀；</li>
			<li>2、分享您的专属链接到微信、微博、QQ等渠道，通过您的专属链接注册成为111医药馆的用户将自动成为您的“秀粉”，普通会员也可以在健康广场主动申请成为您的“秀粉”；</li>
			<li>3、您的“秀粉”在111医药馆网上消费后（不计使用优惠券抵扣的金额），会按照一定佣金比例为您累积“壹贝”；</li>
			<li>4、当您的“壹贝”数大于10（1壹贝＝¥1）时，您可以在每月5日前向我们申请提现，申请被审核通过后我们会短信通知您，并在每月15日前向您的指定账户返现。</li>
			
			<li style="font-size:85%;">注：甘肃地区暂时不参加返佣活动，本活动最终解释权由111医药馆所有，感谢您的参与！</li>
        </ul>
    </div>
</div>

<div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
</body>
</html>