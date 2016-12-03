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
    <title>退款退货</title>
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
<body style="height:100%;">
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
    <script type="text/javascript" src="${base}/web/js/jquery.min.js"></script>
    <script type="text/javascript" src="${base}/web/js/member.js"></script>
    <script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
    <script type="text/javascript" src="${base}/web/js/return_detail.js"></script>
    <style type="text/css">
    .refund-details dd{
    	width:400px;
    }
    </style>
<div class="member-line" style="height: 100%; border-top-width: 4px;">
    <div class="member-wrap">
        <!-------左侧------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content refund">
			<#if tReturn.serviceType==0>
        		<h2>退货详情</h2>
        	<#elseif tReturn.serviceType==1>
        		<h2>换货详情</h2>
        	<#elseif tReturn.serviceType==2>
        		<h2>退款详情(无需退货)</h2>
        	</#if>
            <div class="refund-info-box">
            	<!--            <审核退/换货申请>开始	  -->
            	<#if tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==0||tReturn.orderStatus==2)>
            	<div class="refund-info-state">
                	<div id="process" class="section5 clearfix clear">
                        <div class="bar-left"></div>
                        <div class="node fore ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>申请退/换货</span></li>
                            </ul>
                        </div>
                        <div class="proce doing">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node doing">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>审核退/换货申请</span></li>
                            </ul>
                        </div>
                        <div class="proce wait">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node wait">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>填写物流信息</span></li>
                            </ul>
                        </div>
                        <div class="proce wait">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node wait">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>退换货进行中</span></li>
                            </ul>
                        </div>
                        <div class="proce wait">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node wait" style="border-radius:0 8px 8px 0; -moz-border-radius:0 8px 8px 0; -webkit-border-radius:0 8px 8px 0;">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>退换货完成</span></li>
                            </ul>
                        </div>
                    </div>
                </div>
            	<!--            <审核退/换货申请>结束	  -->
            	<!--			<填写物流信息>开始		-->
            	<#elseif  tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==1)>
            	<div class="refund-info-state">
                	<div id="process" class="section5 clearfix clear">
                        <div class="bar-left"></div>
                        <div class="node fore ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>申请退/换货</span></li>
                            </ul>
                        </div>
                        <div class="proce ready">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>审核退/换货申请</span></li>
                            </ul>
                        </div>
                        <div class="proce ready">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node doing">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>填写物流信息</span></li>
                            </ul>
                        </div>
                        <div class="proce wait">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node wait">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>退换货进行中</span></li>
                            </ul>
                        </div>
                        <div class="proce wait">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node wait" style="border-radius:0 8px 8px 0; -moz-border-radius:0 8px 8px 0; -webkit-border-radius:0 8px 8px 0;">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>退换货完成</span></li>
                            </ul>
                        </div>
                    </div>
                </div>
            	<!--			<填写物流信息>结束		-->
            	
            	<!--			<退换货进行中>开始		-->
            	<#elseif  tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==3||tReturn.orderStatus==4||tReturn.orderStatus==5||tReturn.orderStatus==6||tReturn.orderStatus==7||tReturn.orderStatus==8)>
            	<div class="refund-info-state">
                	<div id="process" class="section5 clearfix clear">
                        <div class="bar-left"></div>
                        <div class="node fore ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>申请退/换货</span></li>
                            </ul>
                        </div>
                        <div class="proce ready">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>审核退/换货申请</span></li>
                            </ul>
                        </div>
                        <div class="proce ready">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>填写物流信息</span></li>
                            </ul>
                        </div>
                        <div class="proce ready">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node doing">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>退换货进行中</span></li>
                            </ul>
                        </div>
                        <div class="proce wait">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node wait" style="border-radius:0 8px 8px 0; -moz-border-radius:0 8px 8px 0; -webkit-border-radius:0 8px 8px 0;">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>退换货完成</span></li>
                            </ul>
                        </div>
                    </div>
                </div>
            	<!--			<退换货进行中>结束		-->
            	
            	<!--			<退换货完成>开始		-->
            	<#elseif  tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==9)>
            	<div class="refund-info-state">
                	<div id="process" class="section5 clearfix clear">
                        <div class="bar-left"></div>
                        <div class="node fore ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>申请退/换货</span></li>
                            </ul>
                        </div>
                        <div class="proce ready">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>审核退/换货申请</span></li>
                            </ul>
                        </div>
                        <div class="proce ready">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>填写物流信息</span></li>
                            </ul>
                        </div>
                        <div class="proce ready">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node ready">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>退换货进行中</span></li>
                            </ul>
                        </div>
                        <div class="proce ready">
                            <ul>
                                <li class="tx1">&nbsp;</li>
                            </ul>
                        </div>
                        <div class="node ready" style="border-radius:0 8px 8px 0; -moz-border-radius:0 8px 8px 0; -webkit-border-radius:0 8px 8px 0;">
                            <ul>
                                <li class="tx1"><span class="state-tip"><s></s>退换货完成</span></li>
                            </ul>
                        </div>
                    </div>
                </div>
                </#if>
            	<!--			<退换货完成>结束		-->
                
                <div class="refund-details clearfix clear">
                	<div class="refund-menu">
            		<#if tReturn.serviceType==0>
                		<h4>退货申请</h4>
                	<#elseif tReturn.serviceType==1>
                		<h4>换货申请</h4>
                	<#elseif tReturn.serviceType==2>
                		<h4>退款申请(无需退货)</h4>
                	</#if>
                        <ul class="refund-menu-list mt10">
                        	<li>服务类型：<#if tReturn.serviceType?exists &&tReturn.serviceType==0>退货<#else>换货</#if></li>
                            <li><#if tReturn.serviceType==0>退货<#elseif  tReturn.serviceType==1>换货<#elseif  tReturn.serviceType==1>退款<#else>退换货</#if>编号：${tReturn.orderSn?if_exists}</li>
                            <li class="mt20">订单编号：<#if tOrder?exists>${tOrder.orderSn?if_exists}</#if></li>
							<li>成交时间：<#if tOrder?exists && tOrder.createDate?exists>${tOrder.createDate?if_exists?string("yyyy-MM-dd HH:mm:ss")}</#if></li>
							<li>运费：<#if tOrder?exists>${currency(tOrder.shippingFee?if_exists,"true","true")}</#if></li>
							<li>总优惠：<#if youhui?exists> ${currency(youhui?if_exists,"true","true")}</#if>
								<!--<#if tOrder?exists>${currency((tOrder.payableAmount-tOrder.paidAmount)?if_exists,"true","true")}</#if>-->
							</li>
							<li>总计：<#if tOrder?exists>${currency(tOrder.payableAmount?if_exists,"true","true")}</#if></li>
                        </ul>
                    </div>
                    <div class="state-current">
        				<!--            <审核退/换货申请>开始	  -->
		            	<#if tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==0)>
		            		<h4><b class="warning"></b>
		            		<#if tReturn.serviceType==0>
		                		等待审核退货申请
		                	<#elseif tReturn.serviceType==1>
		                		等待审核换货申请
		                	<#elseif tReturn.serviceType==2>
		                		等待审核退款申请
		                	</#if>
		            		</h4>
		            	<!--            <审核退/换货申请>结束	  -->
		            	
		            	<!--			<填写物流信息>开始		-->
		            	<#elseif  tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==1)>
			            		<h4><b class="warning"></b>请退货给我们</h4>
		                        <p class="refund-address">退货地址：北京北京市朝阳区望京湖光中街西口季景沁园216号楼</p>
		         				<p class="refund-address">收件人：111医药馆收&nbsp;&nbsp;&nbsp;&nbsp;电话：010-56295528-818&nbsp;&nbsp;&nbsp;&nbsp;4006063111</p>
		            		<div id="addLogisticsInfo">
		            			<#if tReturn.expressCompany?exists && tReturn.expressDelivery?exists>
		                        <h4 class="mt20"><b class="warning"></b>您已填写物流信息,请等待审核通过</h4>
		            			<#else>
		                        <h4 class="mt20"><b class="warning"></b>并填写退货物流信息</h4>
		                        <p class="refund-address">
				            		<a href="javascript:void(0)" onclick="addLogisticsInfo('${tReturn.id?if_exists}')">填写物流信息</a>
				            	</p>
				            	</#if>
			            	</div>
		            	<!--			<填写物流信息>结束		-->
		            	
		            	<!--			<退换货进行中>开始		-->
		            	<#elseif  tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==3||tReturn.orderStatus==5||tReturn.orderStatus==6||tReturn.orderStatus==7||tReturn.orderStatus==8)>
			            	<h4>我们收到货后会尽快安排验货，请及时关注您的订单状态，如有疑问，请和客服联系。<br/>客服电话：4006063111</h4>
		            	<!--			<退换货进行中>结束		-->
		            	
		            	<!--			<退换货完成>开始		-->
		            	<#elseif  tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==9)>
			            	<!--成功-->
	                   		<h4><b class="success"></b>
	                   		<#if tReturn.serviceType==0>
		                		退货完成
		                	<#elseif tReturn.serviceType==1>
		                		换货完成
		                	<#elseif tReturn.serviceType==2>
		                		退款完成
		                	</#if>
	                   		</h4>
	                        <!--失败-->
		            	<#elseif  tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==4)>
	                        <h4><b class="error"></b>验货不通过</h4>
	                        <p class="refund-address">
	                        	<#if tReturn.serviceType==0>
			                		退货
			                	<#elseif tReturn.serviceType==1>
			                		换货
			                	<#elseif tReturn.serviceType==2>
			                		退款
			                	</#if>不成功，请您联系客服进行处理</p>
	         				<p class="refund-address">客服电话：4006063111</p>
	                        <!--审核失败-->
		            	<#elseif  tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==2)>
	                        <h4><b class="error"></b>
	                        	<#if tReturn.serviceType==0>
			                		退货审核未通过
			                	<#elseif tReturn.serviceType==1>
			                		换货审核未通过
			                	<#elseif tReturn.serviceType==2>
			                		退款审核未通过
			                	</#if>
							</h4>
	                        <p class="refund-address">
	                        	<#if tReturn.serviceType==0>
			                		退货申请未通过
			                	<#elseif tReturn.serviceType==1>
			                		换货申请未通过
			                	<#elseif tReturn.serviceType==2>
			                		退款申请未通过
			                	</#if>，需要您修改退货申请或联系客服</p>
	         				<p class="refund-address">客服电话：4006063111</p>
		                </#if>
		            	<!--			<退换货完成>结束		-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 退款/退货弹窗开始-->
<div class="out-box out popup-add">
    <h4 class="out-title">
        <a href="#" class="close-out"></a>
        <ul class="refund-choice clearfix clear" id="tab-hd2">
            <li>物流信息</li>
        </ul>
    </h4>
    <div class="out-info clearfix clear">
    	<input type="hidden" id="singleId"/>
        <ul class="refund-info" id="tab-bd2">
            <li class="choice-box">
                <dl class="refund-details clearfix clear">
                    <dt><b>*</b>物流公司：</dt>
                    <dd>
                        <div class="refund-list" style="width:341px;">
                            <input type="text" maxlength="80" value="${tReturn.expressCompany?if_exists}" name="expressCompany" class="refund-price" style="width: 336px;">
                        </div>
                        <span style="color:red;" id="expressCompanyTip"></span>
                    </dd>
                </dl>
                <dl class="refund-details clearfix clear">
                    <dt><b>*</b>快递单号：</dt>
                    <dd>
                        <div class="refund-list" style="width:341px;">
                            <input type="text" maxlength="80" name="expressDelivery" value="${tReturn.expressDelivery?if_exists}" class="refund-price" style="width: 336px;">
                        </div>
                        <span style="color:red;" id="expressDeliveryTip"></span>
                    </dd>
                </dl>
                <dl class="refund-details clearfix clear">
                    <dt><b>*</b>收货人：</dt>
                    <dd>
                        <div class="refund-list" style="width:341px;">
                            <input type="text" name="receiver" value="111医药馆" style="width: 336px;" disabled="disabled" class="refund-price">
                        </div>
                    </dd>
                </dl>
                <dl class="refund-details clearfix clear">
                    <dt><b>*</b>手机号：</dt>
                    <dd>
                        <div class="refund-list" style="width:341px;">
                            <input type="text" name="phone" value="4006063111" style="width: 336px;" disabled="disabled" class="refund-price">
                        </div>
                    </dd>
                </dl>
                <dl class="refund-details clearfix clear">
                    <dt><b>*</b>收货地址：</dt>
                    <dd>
                        <div class="refund-list" style="width:341px;">
                            <input type="text" name="receiverAddress" style="width:336px;" value="北京北京市朝阳区望京湖光中街西口季景沁园216号楼" disabled="disabled" class="refund-price">
                        </div>
                    </dd>
                </dl>
                <div class="for-btn-box">
                    <a href="#" id="subLogisticsInfo" class="submit-refund">提交</a><a href="#" class="cancle-refund">取消</a>
                </div>
            </li>
        </ul>
    </div>
</div>
<!-- 退款/退货弹窗结束-->
<div id="shade"></div>
<#include "/static/inc/version2.2.0/footer.ftl">

<style>
.refund-details dd {
    float: left;
    width: 10px;
}
</style>
</body>
</html>