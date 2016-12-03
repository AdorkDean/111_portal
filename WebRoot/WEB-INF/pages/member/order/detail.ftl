<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
 <#include "/WEB-INF/pages/inc/taglibs.ftl">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="">
    <!-- keywords -->
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>订单详情</title>
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
    <link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.1/css/order.css"/>
    <script type="text/javascript" src="${base}/web/js/jquery.min.js"></script>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!-- 右侧内容开始-->
    <div class="member-main-right">
        <div class="m-site order-site">
            <a href="${base}/member/index!getCenterIndex.action">用户中心</a>　>　<a href="${base}/member/center!getOrderList.action">我的订单</a>　>　<span>订单详情</span>
        </div>
        <!--订单详情开始-->
        <div class="order-details-box">
        	<h2>订单详情</h2>
            <div class="order-details-state clearfix clear">
            	<#if order?exists && order.orderStatus?exists>
            	<div class="order-details-state-text">
                	<p class="order-details-state-location">当前状态：<span>
	                	<#if order.orderStatus?default(0) == 0>待支付 </#if>
	                	<#if order.orderStatus?default(0) == 1>待发货</#if>
	                	<#if order.orderStatus?default(0) == 2>已发货</#if>
	                	<#if order.orderStatus?default(0) == 3>已完成</#if>
	                	<#if order.orderStatus?default(0) == 4>已取消</#if>
	                	<#if order.orderStatus?default(0) == 5>已过期(24小时未支付)</#if>
	                	<#if order.orderStatus?default(0) == 6>已关闭</#if>
                	</span>
                	</p>
                    <p class="order-details-call">
                    <#if order.orderStatus == 0><a href="${base}/member/order!orderSumbitSuccess.action?orderId=${order.id?default('')}" class="order-pay">支付</a></#if>
                    <#if order.orderStatus == 3><a href="${base}/member/order!applyGoodsComment.action?orderId=${order.id?default('')}" class="order-success">去评论</a></#if>
                    <#if order.orderStatus == 4 ||order.orderStatus == 5 ||order.orderStatus == 6><a href="${base}/carts/cart!page.action?url=${base}/member/center!getOrderList.action" class="order-pay">重新购买</a></#if>
                	<a href="javascript:void(0);" onclick="window.open(&quot;http://wpa.qq.com/msgrd?v=3&amp;uin=2601114970&amp;site=qq&amp;menu=yes&quot;,&quot;_blank&quot;)" class="on-line">
                    <i></i>联系客服</a></p>
                </div>
            	</#if>
                <#if flowFlag==1 && order.orderStatus?exists>
                <div class="order-details-state-bar">
                	<ul>
	                	<#if order.orderStatus == 0>
                        	<li class="order-state-tip finish-tip"><b>1</b><span class="doing-tit">待支付</span></li>
                        	<li class="bra-line finish-line"></li>
                        <#else>
	                		<li class="order-state-tip"><b>1</b><span>待支付</span></li>
                        	<li class="bra-line"></li>
	                	</#if>
	                	<#if order.orderStatus == 1>
                        	<li class="order-state-tip finish-tip"><b>2</b><span class="doing-tit">待发货</span></li>
                        	<li class="bra-line finish-line"></li>
                        <#else>
	                		<li class="order-state-tip"><b>2</b><span>待发货</span></li>
                        	<li class="bra-line"></li>
	                	</#if>
	                	<#if order.orderStatus == 2>
                        	<li class="order-state-tip finish-tip"><b>3</b><span class="doing-tit">待收货</span></li>
                        	<li class="bra-line finish-line"></li>
                        <#else>
	                		<li class="order-state-tip"><b>3</b><span>待收货</span></li>
                        	<li class="bra-line"></li>
	                	</#if>
	                	<#if order.orderStatus == 3 || order.orderStatus == 6>
	                		<#if order.orderStatus == 3>
                        	<li class="order-state-tip finish-tip"><b>4</b><span class="doing-tit">已完成</span></li>
                        	<#else>
	                		<li class="order-state-tip finish-tip"><b>4</b><span class="doing-tit">已关闭</span></li>
                        	</#if>
                        <#else>
	                		<li class="order-state-tip"><b>4</b><span>已完成</span></li>
	                	</#if>
                    </ul>
                </div>
                </#if>
            </div>
        </div>
        <#if logisticFlag==1 && shipment?exists>
        <div class="order-details-box">
        	<h2>物流信息</h2>
            <div class="logistics-details-box">
            	<div class="logistics-details-info clearfix clear">
                	<span>发货方式：</span>
                    <p><#if order.deliveryId?exists>
                    	<#if order.deliveryId?default(1) == 1>快递</#if>
	                	<#if order.deliveryId?default(1) == 4>货到付款</#if>
                    </#if></p>
                </div>
                <div class="logistics-details-info clearfix clear">
                	<span>物流公司：</span>
                    <p>${shipment.logisticsName?default('')}</p>
                </div>
                <div class="logistics-details-info clearfix clear">
                	<span>运单号码：</span>
                    <p>${shipment.logisticsNo?default('')}</p>
                </div>
                <div class="logistics-details-info clearfix clear">
                	<span>物流跟踪：</span>
                    <p><b>商品已出库</b><#if logisticFlag==1>${shipment.shipmentDt?string('yyyy-MM-dd HH:mm:ss')}</#if><br/><b>快递已取件</b><#if logisticFlag==1>${shipment.shipmentDt?string('yyyy-MM-dd HH:mm:ss')}</#if></p>
                </div>
            </div>
        </div>
        </#if>
        <#if order?exists>
        <div class="order-details-box">
        	<h2>收货信息</h2>
            <div class="logistics-details-box clearfix clear">
            	<div class="logistics-details-info clearfix clear">
                	<span>收货地址：</span>
                    <p>${order.receiver?default('')}，${order.phone?default('')}，${order.areaName?default('')} ${order.detailedAddress?default('')} ${order.zipCode?default('')}</p>
                </div>
                <div class="logistics-details-info clearfix clear">
                	<span>留&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;言：</span>
                    <p>${order.remark?default('')}</p>
                </div>
                <div class="logistics-details-info clearfix clear">
                	<span>订单信息</span>
                    <p>&nbsp</p>
                </div>
                <div>
                    <div class="logistics-details-info clearfix w40">
                        <span>订单编号：</span>
                        <p>${order.orderSn?default('')}</p>
                    </div>
                    <div class="logistics-details-info clearfix w40">
                        <span>创建时间：</span>
                        <p><#if order.createDate?exists>${order.createDate?string('yyyy-MM-dd HH:mm:ss')}</#if></p>
                    </div>
                	<#if shipment?exists>
                    <div class="logistics-details-info clearfix w40">
                        <span>发货时间：</span>
                        <p><#if logisticFlag==1>${shipment.shipmentDt?string('yyyy-MM-dd HH:mm:ss')}</#if></p>
                    </div>
                    </#if>
                    <#if orderFlow?exists && orderFlow.payDate?exists>
                    <div class="logistics-details-info clearfix w40">
                        <span>付款时间：</span>
                        <p>${orderFlow.payDate?string('yyyy-MM-dd HH:mm:ss')}</p>
                    </div>
                    </#if>
                </div>
            </div>
        </div>
        </#if>
        <div class="order-details-info-box">
        	<h2 class="clearix clear">
            	<span class="w15">商品编号</span>
                <span class="w15">商品图片</span>
                <span class="w40">商品名称</span>
                <span class="w15">单价（元）</span>
                <span class="w15">数量</span>
            </h2>
       		<#list goods?if_exists as good>
            <ul class="order-details-info-list">
            	<li>
                	<span class="w15 blue">${good.goodsNo?default('')}</span>
                    <span class="w15"><a target="_blank" href="${base}/p/${good.goodsId?default('')}.html"><img src="${ui1}${good.img?default('')}"/></a></span>
                    <span class="w40"><a target="_blank" href="${base}/p/${good.goodsId?default('')}.html">${good.goodsName?default('')}</a></span>
                    <span class="w15 red"><#if good.price?exists>${good.price?string.currency}</#if></span>
                    <span class="w15">${good.num?default('0')}</span>
                </li>
            </ul>
        	</#list>
        </div>
        <!--订单详情结束-->
    </div>
    <!-- 右侧内容结束-->
	<div class="user_center_footer" style="float:left;"><#include "/static/inc/version2.2.0/footer.ftl"></div>
    </div>
</div>
</body>
</html>