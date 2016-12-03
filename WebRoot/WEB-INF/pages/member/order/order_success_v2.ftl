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
    <title>111医药馆专做药品特卖的网站-医卡通买药价格低便宜实惠-国家药监局指定壹壹壹医药馆网上连锁药店</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="${base}/web/version2.2.0/images/common/favicon.png">
    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="${base}/web/version2.2.0/images/common/favicon.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="${base}/web/version2.2.0/images/common/favicon.png">
    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="${base}/web/version2.2.0/images/common/favicon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <!--common style-->
      <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/common.css">
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/shopping.css">
</head>
<body>
<#include "/WEB-INF/pages/inc/taglibs.ftl">
<#include "/static/inc/version2.2.0/header.ftl">
<style>#goods_detail_class {width:1000px;}</style>
<script type="text/javascript" src="/webersion2.2.0/js/goods_detail_header.js"></script>
<!--步骤开始-->
<div class="second-header w1000">
    <div class="shopping-step clearfix">
        <ul>
            <li class="state-tip"><b>1</b><span>选择商品</span></li>
            <li class="bra-line"></li>
            <li class="state-tip"><b>2</b><span>填写核对订单</span></li>
            <li class="bra-line"></li>
            <li class="state-tip"><b>3</b><span>成功提交订单</span></li>
            <li class="bra-line finish-line"></li>
            <li class="state-tip finish-tip"><b>4</b><span class="doing-tit">完成订单</span></li>
        </ul>
    </div>
    <h2 class="second-logo">完成订单</h2>
</div>
<!--步骤结束-->
<!--订单信息开始-->
<div class="pay-order-finish w1000">
    <h2 class="pay-order-title">感谢您，
			<#if order.orderStatus==1 &&paymentWay.paymentCode =='hdfk'>
    	                订单提交成功！
    	    </#if>
    	   <#if order.orderStatus==1 &&paymentWay.paymentCode !='hdfk'>
    	                订单已支付完成！
    	   </#if>
    	    <#if order.orderStatus==0 &&paymentWay.paymentCode !='hdfk'>
    	                 订单支付处理中！
    	    </#if>   
    </h2>
    <ul class="pay-order-mes">
        <li>订单号：${order.orderSn?if_exists}</li>
        <li> 收货人：${order.receiver?if_exists}</li>
        <li>收货地址：${order.areaName?if_exists}${order.detailedAddress?if_exists}</li>
        <li> 联系电话：${order.phone?if_exists}</li>
        <li>待支付金额：<span>¥${currency(order.payableAmount?default(''))}</span>　　　<b>完成订单后</b>可获积分：<span>${order.rewardIntegration?if_exists}</span></li>
        <#if order.orderStatus==1 &&paymentWay.paymentCode !='hdfk'>
	      <li>付款时间：${payDate?string("yyyy-MM-dd")}</li>
	    </#if>
    </ul>
    <div class="pay-order-finish-btn">
        <a href="/" class="go-shopping">继续购物</a>
        <a href="${base}/member/order!detail.action?id=${order.id?if_exists}" class="look-order">查看订单详情</a>
    </div>
</div>
<!--订单信息结束-->
<script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>




<#include "/static/inc/version2.2.0/footer.ftl">
</body>
</html>
