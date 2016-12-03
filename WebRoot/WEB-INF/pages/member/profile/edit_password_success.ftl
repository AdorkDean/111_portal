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
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content binging">
            <h2>修改密码</h2>
            <div class="binging-box">
                <!--进度条-->
                <div id="process" class="section3 clear clearfix"  style="margin-left:300px;">
                    <div class="bar-left"></div>
                    <div class="node ready">
                        <ul>
                            <li class="tx1"><span class="state-tip"><s></s>修改登录密码</span></li>
                        </ul>
                    </div>
                    <div class="proce ready" style="width:300px;">
                        <ul>
                            <li class="tx1">&nbsp;</li>
                        </ul>
                    </div>
                    <div class="node ready" style="border-radius:0 8px 8px 0; -moz-border-radius:0 8px 8px 0; -webkit-border-radius:0 8px 8px 0;">
                        <ul>
                            <li class="tx1"><span class="state-tip"><s></s>完成</span></li>
                        </ul>
                    </div>
                </div>
                <div class="verify-list">
                    <ul style="margin-left:145px;">
                        <#if option?exists && option>
                    		<li class="bold-li">恭喜，修改登录密码成功</li>
                    	<#else>
							<li class="bold-li">很遗憾，修改登录密码失败</li>
                    	</#if>
                    </ul>
                    <dl class="submit-dl">
                        <dt></dt>
                        <dd><a href="${base}/"  class="btn-submit">返回首页继续购物</a></dd>
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
<#include "/static/inc/footer.ftl">
</body>
</html>