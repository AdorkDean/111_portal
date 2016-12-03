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
    <title>退款退款</title>
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
 <style type="text/css">
    .refund-details dd{
    	width:400px;
    }
    </style>
</head>
<body style="height:100%;">
	<#--<#include "/static/inc/center_header.ftl">-->
	<#include "/static/inc/version2.2.0/header.ftl">
	<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
	<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
	<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
	<script type="text/javascript" src="${base}/web/js/jquery.min.js"></script>
	<script type="text/javascript" src="${base}/web/js/member.js"></script>
<div class="member-line" style="height: 100%; border-top-width: 4px;">
    <div class="member-wrap">
        <!-------左侧------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        
        <!------右侧-------->
        <div class="member-content refund">
            <h2>退款详情</h2>
            <div class="refund-info-box">
            
            	<#if tReturn.orderStatus==0 || tReturn.orderStatus==1 || tReturn.orderStatus==2 || tReturn.orderStatus==5>
            	<!--      无需退货审核中开始(0,1,2,5,9)	    -->
            	<div class="refund-info-state">
                	<div id="process" class="section3 clearfix clear">
                        <div class="bar-left"></div>
                        <div class="node fore ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>申请退款</span></li>
                            </ul>
                        </div>
                        <div class="proce ready">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node doing">
                            <ul>
                                <li class="tx1">
                                	<span class="state-tip"><s></s>
                                		审核退款申请
                                	</span>
                                </li>
                            </ul>
                        </div>
                        <div class="proce wait">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node wait" style="border-radius:0 8px 8px 0; -moz-border-radius:0 8px 8px 0; -webkit-border-radius:0 8px 8px 0;">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>退款完成</span></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!--      无需退货审核中结束	    -->
                <#elseif tReturn.orderStatus==9>
                
                <!--      完成开始	    -->
                <div class="refund-info-state">
                	<div id="process" class="section3 clearfix clear">
                        <div class="bar-left"></div>
                        <div class="node fore ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>申请退款</span></li>
                            </ul>
                        </div>
                        <div class="proce ready">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>审核退款申请</span></li>
                            </ul>
                        </div>
                        <div class="proce ready">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node ready" style="border-radius:0 8px 8px 0; -moz-border-radius:0 8px 8px 0; -webkit-border-radius:0 8px 8px 0;">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>退款完成</span></li>
                            </ul>
                        </div>
                    </div>
                </div>
                </#if>
                
                <!--      完成结束	    -->
                
                
                
                <div class="refund-details clearfix clear">
                	<div class="refund-menu">
                    	<h4>退款申请</h4>
                        <ul class="refund-menu-list mt10">
                        	<li>退款类型：退款(无需退货)</li>
                            <li>退款编号：${tReturn.orderSn?if_exists}</li>
                            <li class="mt20">订单编号：${tOrder.orderSn?if_exists}</li>
							<li>成交时间：<#if tOrder?exists && tOrder.createDate?exists>${tOrder.createDate?if_exists?string("yyyy-MM-dd HH:mm:ss")}</#if></li>
							<li>运费：${currency(tOrder.shippingFee?if_exists,"true","true")}</li>
							<li>总优惠：${currency(youhui?if_exists,"true","true")}
							</li>
							<li>总计：${currency(tOrder.payableAmount?if_exists,"true","true")}</li>
                        </ul>
                    </div>
                    
                    <div class="state-current">
                        <#if tReturn.orderStatus==0 || tReturn.orderStatus==1 || tReturn.orderStatus==2 || tReturn.orderStatus==5>
	                        <h4><b class="warning"></b>等待审核退款申请</h4>
	                        <p class="refund-address">如果退款申请通过，退款完成并返还退款</p>
	         				<p class="refund-address">如果退款申请未通过，将需要您修改退款申请或联系客服</p>
                        
                        <#elseif tReturn.orderStatus==9>
	                        <h4><b class="success"></b>退款完成</h4>
	                        <p class="refund-address">退款完成时间：<#if tReturn.finishDt?exists>${tReturn.finishDt?if_exists?string("yyyy-MM-dd HH:mm:ss")}</#if></p>
	         				<p class="refund-address">退款金额：<#if tReturn.refundAmount?exists>${currency(tReturn.refundAmount?if_exists,"true","true")}</#if></p>
         				</#if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="shade"></div>
<#include "/static/inc/footer.ftl">
</body>
</html>