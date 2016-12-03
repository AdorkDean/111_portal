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
    <style type="text/css">
        .feature{overflow: hidden;}
        .feature-title{padding:30px 0 50px 0; overflow: hidden;}
        .feature-title h3{height:90px; line-height:90px; text-align: center; font-size:40px;}
        .feature-title p{height:30px; line-height:30px; text-align: center; font-size:20px;}
        .feature-content{padding:60px 0; overflow: hidden;}
        .feature-content.bgColor{background: #f8f8f8;}
        .feature-text{float:left; width:417px; padding-top:60px;}
        .feature-text h3{height:60px; line-height:60px; text-align: center;font-size:40px;}
        .feature-text p{height:40px; line-height:40px; text-align: center; font-size:18px; color:#666;}
        .feature-text p span{float:left; }
        .feature-text p b{float:left; display: inline-block; height:14px; width:22px; background: url("${base}/web/version2.2.0/images/health/feature_arrow.png") no-repeat; margin:13px 20px; }
        .feature-img{width:481px; padding:0 50px; float:left;}
        .feature-img img{width:481px; height:282px; box-shadow:0 0 15px #666;}
        .wx-attention{padding:50px 0 80px; overflow: hidden;}
        .wx-attention li{float:left;}
        .wx-attention li.wx-menu{width:200px; height:20px; padding-top:150px; text-align: center; font-size:18px; background: url("${base}/web/version2.2.0/images/health/feature_icon.png") no-repeat;}
        .wx-attention li.wx-icon{width:22px; height:14px; background: url("${base}/web/version2.2.0/images/health/feature_arrow.png") no-repeat; margin:100px 0;}
        .wx-attention li.wx-menu.wx-icon01{background-position: 0 0;}
        .wx-attention li.wx-menu.wx-icon02{background-position: 0 -170px;}
        .wx-attention li.wx-menu.wx-icon03{background-position: 0 -340px;}
        .wx-attention li.wx-menu.wx-icon04{background-position: 0 -510px;}
    </style>
</head>
<body class="health-bc">
<#include "/static/inc/version2.2.0/new_leader_header.ftl"/>
<script>$("#leader_navicator li").eq(3).addClass("cur");</script>
<div class="my-pharmacy-page w1000" style="margin-top:25px;padding-bottom:20px;">
    <div class="personal-data">
        <ul class="data-nav">
            <li><a href="/leaderarticle/leaderarticle!myLeaderFans.action"><span>我的秀粉</span></a></li>
            <li><a href="/member/bindingAmount!presentRecordList.action"><span>提现记录</span></a></li>
            <li><a href="/member/bindingAmount!proceedsDetailList.action"><span>收益明细</span></a></li>
            <li><a href="/leaderarticle/leaderarticle!leaderIdentity.action"><span>身份认证</span></a></li>
            <li class="current"><a href="/leaderarticle/leaderarticle!leaderFunctionIntroduce.action"><span>特色功能</span></a></li>
        </ul>
        <div class="data-line"></div>
    </div>
    <div class="feature">
        <div class="feature-title">
            <h3>新版功能，期待您的体验</h3>
            <p>编写文章，分享文章，分享药房，赚取佣金</p>
        </div>
        <div class="feature-content bgColor clearfix">
            <div class="feature-text">
                <h3>编写文章</h3>
                <p>添加商品到文章中，把商品分享给朋友！</p>
                <p style="padding-left:40px;"><span>我的文章</span><b></b><span>写文章</span><b></b><span>发布文章</span></p>
            </div>
            <div class="feature-img">
                <img src="${base}/web/version2.2.0/images/health/feature01.png" alt=""/>
            </div>
        </div>
        <div class="feature-content clearfix">
            <div class="feature-img">
                <img src="${base}/web/version2.2.0/images/health/feature02.png" alt=""/>
            </div>
            <div class="feature-text">
                <h3>分享文章</h3>
                <p>把好的文章分享到朋友圈来赚取您的佣金！</p>
                <p style="padding-left:20px;"><span>手机扫码分享</span><b></b><span>点击分享</span><b></b><span>我的文章</span></p>
            </div>
        </div>
        <div class="feature-content bgColor clearfix">
            <div class="feature-text">
                <h3>管理药房</h3>
                <p>为自己的药房配置商品，轻松分享给朋友！</p>
                <p style="padding-left:40px;"><span>我的文章</span><b></b><span>添加商品</span><b></b><span>管理药房</span></p>
            </div>
            <div class="feature-img">
                <img src="${base}/web/version2.2.0/images/health/feature03.png" alt=""/>
            </div>
        </div>
        <div class="feature-content clearfix">
            <div class="feature-img">
                <img src="${base}/web/version2.2.0/images/health/feature04.png" alt=""/>
            </div>
            <div class="feature-text">
                <h3>收益管理</h3>
                <p>管理佣金，方便你查看佣金流水！</p>
                <p style="padding-left:20px;"><span>立即提现</span><b></b><span>查看明细</span><b></b><span>我的收益</span></p>
            </div>
        </div>
        <div class="feature-content bgColor clearfix">
            <div class="feature-text">
                <h3>一键提现</h3>
                <p>绑定账号，一键提现，轻松管理所获佣金！</p>
                <p style="padding-left:40px;"><span>一键提现</span><b></b><span>绑定账号</span><b></b><span>提现到银行卡</span></p>
            </div>
            <div class="feature-img">
                <img src="${base}/web/version2.2.0/images/health/feature05.png" alt=""/>
            </div>
        </div>
        <div class="feature-title">
            <h3>关注健康领秀微信公众号</h3>
            <p>你不仅可以在网页端登录</p>
            <p>也可以通过微信公众号随时使用健康领秀</p>
            <ul class="wx-attention">
                <li class="wx-menu wx-icon01">打开微信</li>
                <li class="wx-icon"></li>
                <li class="wx-menu wx-icon02">打开屏幕下面“发现”</li>
                <li class="wx-icon"></li>
                <li class="wx-menu wx-icon03">选择“扫一扫”</li>
                <li class="wx-icon"></li>
                <li class="wx-menu wx-icon04">点击“关注”即可</li>
            </ul>
        </div>
    </div>
</div>

<div style="margin-top:20px;"><#include "/static/inc/version2.2.0/new_leader_footer.ftl"/></div>
</body>
</html>