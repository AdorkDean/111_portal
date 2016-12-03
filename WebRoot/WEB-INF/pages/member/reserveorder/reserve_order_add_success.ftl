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
    <title>提交成功页面</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="${base}/web/img/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="${base}/web/img/favicon-196x196.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="${base}/web/img/apple-icon-touch.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="${base}/web/img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <!--style-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css">
    <!--header-->
    <!--footer-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/footerNew.css">
    <!--product-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/product.css">
    <script type="text/javascript" src="${base}/web/js/jquery.min.js"></script>
    <style type="text/css">
        .state s{  background: url(${base}/web/img/product_ico_yf.png) no-repeat;}
        .w1210{width:1000px;}
        .shopping-cart-main{background: none;}
        .shopping-state{width:1000px; background: #eee; margin:0 auto;}
        .shopping-state{padding: 15px 0 40px;}
        .section4{width:932px;}
        #process .proce{width:270px;}
        #process .node, #process .proce{  background-image: url(${base}/web/img/bg_state_yf.jpg);}
        .bar-left{  background: #1eb8c8;}
        .state{background: #FFF; color:#000;}
        .doing .state{background: #1eb8c8; color:#FFF;}
        .state s{background-position: 0 -67px;}
        .state-yf s{background-position: -17px -67px;}
        .pink-back{background: #feffef; padding:10px 10px 30px; width:980px; margin:0 auto;}
        .succeed-yf{height:32px; line-height:32px; font-size:18px; font-weight: bold; padding-left:38px; background: url("${base}/web/img/member-icon10.jpg") no-repeat; color:#4c4c4c;}
        .succeed-txt{height:40px; line-height:40px; padding-left:38px;}
        .money-yf span{color:#e95555; font-size:18px;font-weight: bold;}
        .hint-yf span{display: inline-block;width:30px; height:18px; line-height:18px; text-align: center; color:#FFF; background: #e95555; border-radius:3px; margin-right:5px;}
        .hint-yf b{color:#e95555;}
    </style>
</head>
<body>
<#include "/WEB-INF/pages/inc/taglibs.ftl">
<#include "${base}/static/inc/version2.2.0/header.ftl"/>
<#include "${base}/static/inc/version2.2.0/search_box.html"/>
<script>
	$(".current-location").html("提交成功页面");
</script>
<!--购物车模块开始-->
<div class="shopping-cart-box">
    <!--购物步骤开始-->
    <div class="shopping-state">
        <!--进度条-->
        <div id="process" class="section4">
            <div class="bar-left"></div>
            <div class="node doing">
                <ul>
                    <li class="tx1"><span class="state state-yf"><s></s>提交预定</span></li>
                </ul>
            </div>
            <div class="proce doing">
                <ul>
                    <li class="tx1">&nbsp;</li>
                </ul>
            </div>
            <div class="node wait doing">
                <ul>
                    <li class="tx1"><span class="state state-yf"><s></s>药师回拨</span></li>
                </ul>
            </div>
            <div class="proce wait">
                <ul>
                    <li class="tx1">&nbsp;</li>
                </ul>
            </div>
            <div class="node wait">
                <ul>
                    <li class="tx1"><span class="state"><s></s>线下付款</span></li>
                </ul>
            </div>
            <div class="proce wait">
                <ul>
                    <li class="tx1">&nbsp;</li>
                </ul>
            </div>
            <div class="node wait" style="border-radius:0 8px 8px 0; -moz-border-radius:0 8px 8px 0; -webkit-border-radius:0 8px 8px 0;">
                <ul>
                    <li class="tx1"><span class="state"><s></s>流程结束</span></li>
                </ul>
            </div>
        </div>
    </div>
    <!--购物步骤结束-->
    <div class="shopping-cart-main pink-back">
        <h2 class="succeed-yf">您已成功提交预定！</h2>
        <p class="succeed-txt money-yf">待支付金额：<span id="orderAmount">￥</span></p>
        <p class="succeed-txt hint-yf"><span>提示</span>1小时内药房药师将通过电话与您联系。如需取消预约或其他用药咨询，可使用 <b>在线咨询</b>或拨打客服电话 <b>400-606-3111</b>获取服务。</p>
    </div>
</div>
<!--购物模块结束-->

<script>
	var orderAmount = ${orderAmount?default(0)};
	$("#orderAmount").html("￥"+orderAmount.toFixed(2));
</script>
<script  type="text/javascript" src="${base}/web/js/productNew.js"></script>
<#include "${base}/static/inc/version2.2.0/footer.ftl"/>
</body>
</html>
