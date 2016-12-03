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
    <title>找回密码</title>
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
    <link rel="stylesheet" type="text/css" href="${base}/web/css/login/common.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/login/login.css"/>
    <script src="${base}/web/js/jquery.min.js" type="text/javascript"></script>
</head>
<body class="login-bg">
<div class="login-wrap">
    <div class="login-title">
       <a href="${base}/"><img src="${base}/web/images/login/login_logo.png" alt="" class="forget-logo"/></a>
        <b class="forget-tit">找回密码</b>
    </div>
    <div class="login-content">
        <!--进度条-->
        <div class="process-bra clear clearfix">
            <ul>
                <li class="state-tip"><b>1</b><span>填写账户信息</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>2</b><span>选择找回方式</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>3</b><span>验证身份</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>4</b><span>设置新密码</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip finish-tip"><b>5</b><span class="doing-tit">完成</span></li>
            </ul>
        </div>
        <div class="login-list-center">
            <p class="ts-p back-num">您已成功找回密码，<span id="num">5</span>秒钟后自动跳转至登录页面</p>
            <div class="login-button for-btn back-index">
                <a href="${base}/index.html" class="back-index-a">返回首页</a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" charset="utf-8">
    var t=5;//设定跳转的时间
    setInterval("refer()",1000); //启动1秒定时
    function refer(){
        if(t==0){
            location="${base}/login/login!index.action"; //#设定跳转的链接地址
        }
        document.getElementById('num').innerHTML=t; // 显示倒计时
        t--; // 计数器递减
    }
</script>
</body>
</html>