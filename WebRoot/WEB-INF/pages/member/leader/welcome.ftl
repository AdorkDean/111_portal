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
                <li class="bra-line"></li>
                <li class="state-tip"><b>2</b><span>完善资料</span></li>
                <li class="bra-line finish-line"></li>
                <li class="state-tip finish-tip"><b>3</b><span class="doing-tit">申请成功</span></li>
            </ul>
        </div>
    </h2>
    <div class="health-bg">
        <img src="${base}/web/images/health_bg.jpg" alt=""/>
    </div>
    <div class="health-binding-btn">
            <input type="button" value="进入健康领秀" onclick="leader()"/>
    </div>
</div>
<!--提现结束-->
<!--js-->
</body>
<script>
function leader(){
	window.location.href="../leaderarticle/leaderarticle!index.action";
}
</script>
</html>