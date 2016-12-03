<!doctype html>
<html>
<head>
 <#include "/WEB-INF/pages/inc/taglibs.ftl">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="111医药馆网上药店是国家药监局认证指定网上药房|打造为老百姓服务药品价格低品种全|网上购药买药就选壹壹壹医药馆药品特卖网站">
    <!-- keywords -->
    <meta name="keywords" content="壹壹壹医药馆|壹药馆|11医药馆|1药馆|医卡通|111医药馆|医药网|药品特卖网站">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>退款申请</title>
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
    <link rel="stylesheet" type="text/css" href="/web/version2.2.1/css/common.css">
    <link rel="stylesheet" type="text/css" href="/web/version2.2.1/css/member.css">
    <link rel="stylesheet" type="text/css" href="/web/version2.2.1/css/order.css">
    
    <!--js-->
    <script type="text/javascript" src="/web/version2.2.1/js/jquery.min.js"></script>
   
</head>


<body>
<#include "/static/inc/version2.2.0/header.ftl">
<form id="ttForm" action="../member/return!saveGoodsReturn.action" method="post" enctype="multipart/form-data">
<div class="">
     <div class="member-header w1000">
		<input type="hidden" name="orderId" id="orderId" value="${tOrder.id?if_exists}"/>
		<input type="hidden" name="goodsId" id="goodsId" value="${tGoods.id?if_exists}"/>
        <!--售后进度条-->
        <div class="customer-service-state clear clearfix" id="jintui" <#if flag?exists&&flag='2'>style="display:block;"<#else>style="display:none;"</#if>>
            <ul>
                <li class="state-tip finish-tip"><b>1</b><span class="doing-tit">提交售后申请</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>2</b><span>客服审核申请</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>3</b><span>完成退款</span></li>
            </ul>
        </div>
        
        <div class="customer-service-state clear clearfix" id="tuihuan" <#if flag?exists&&flag='0'>style="display:block;"<#else>style="display:none;"</#if>>
            <ul>
                <li class="state-tip finish-tip"><b>1</b><span class="doing-tit">提交售后申请</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>2</b><span>客服审核申请</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>3</b><span>用户退货</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>4</b><span>等待客服验货</span></li>
                <li class="bra-line"></li>
                <li class="state-tip"><b>5</b><span>完成退货</span></li>
            </ul>
        </div>
        
        <h2 class="member-title clear clearfix">售后申请</h2>
    </div>
    <div class="order-all w1000">
        <div class="order-box">
            <div class="order-main">
                <div class="order-wrap">
                    <div class="customer-service-form">
                        <div class="customer-service-form-list clearfix clear">
                        	<span>退款类型：</span>
                            <div class="customer-service-form-info clearfix">
                            	<p class="customer-service-type">
                                	<select onchange="changeType(this)" name="serviceType">
                                		<#if flag?exists&&flag=='2'>
	                                        <option value="2">仅退款</option>
	                                        <option value="0">退货退款</option>
	                                       <#else>
	                                        <option value="0">退货退款</option>
	                                        <option value="2">仅退款</option>
                                		</#if>
                                    </select>
                                </p>
                                <div class="customer-service-type-box">
                                	<span></span>
                                    <div class="customer-service-type-tips">
                                    	<i></i>
                                        <p><b>1. 仅退款</b></p>
                                        <p>申请条件：若您未收到货，请选择“仅退款”选项。</p>
                                        <p>退款流程：1.申请退款 >2.审核退款申请>3.退款成功</p>
                                        <p><b>2. 退货退款</b></p>
                                        <p>申请条件：若为商品问题，或者不想要了且与111医药馆客服达成一致退货，请选择“退货退款”选项，退货后请保留物流底单。</p>
                                        <p>退货流程：1.申请退款退货>2.审核退款退货申请>3.用户退货并填写退货物流信息>4.等待商品退回 >5.退货成功。</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="customer-service-form-list clearfix clear">
                        	<span>商品数量：</span>
                            <div class="customer-service-form-info clearfix">
								<div class="customer-service-count">
                                	<a href="javascript:void(0)" onclick="changeNum(-1)" class="minu">-</a>
                            		<input type="text" value="<#if tOrderItem?exists && tOrderItem.quantity?exists>${tOrderItem.quantity?if_exists}<#else>1</#if>" maxlength="6" onkeyup="validateMaxNum(this)" <#if flag?exists&&flag=='0'><#else>disabled="true"</#if> name="goodsNum" id="goodsNum">
                            		<a href="javascript:void(0)" onclick="changeNum(1)" class="plus">+</a>
                                </div>
                            </div>
                        </div>
                        <div class="customer-service-form-list clearfix clear">
                        	<span>退款说明：</span>
                            <div class="customer-service-form-info clearfix">
								<div class="customer-service-leave-message">
                                	<textarea maxlength="150" style="border: 1px solid #d7d7d7;" class="refund-reason" onkeyup="checkLen(this)" name="refundDescribe" id="refundDescribe"></textarea>
                                </div>
                                <p class="customer-service-leave-message-tips">还可输入<span id="leaveCount" style="color:red;float:none;"></span>字</p>
                            </div>
                        </div>
                        <div class="customer-service-form-list clearfix clear">
                        	<span>上传凭证：</span>
                            <div class="customer-service-form-info clearfix">
								<ul class="customer-service-upload clearfix clear">
                                	<!--<li><img src="images/order/p_img.jpg"></li>
                                    <li><img src="images/order/p_img.jpg"></li>
                                    <li><a href="javascript:void(0)">点此上传<input unselectable="on" type="file" name="image1" id="file1" class="file1" value="file1"/></a></li>
                                    -->
                                    <li><a href="javascript:void(0)"><input unselectable="on" type="file" name="image1" id="file1" class="file1" value="file1"/><span style="line-height: 78px;" id="fileSpan1" class="fileSpan1">点击上传</span></a></li>
	                                <li><a href="javascript:void(0)"><input unselectable="on" type="file" name="image2" id="file2" class="file1" value="file1"/><span style="line-height: 78px;" id="fileSpan2" class="fileSpan1">点击上传</span></a></li>
	                                <li><a href="javascript:void(0)"><input unselectable="on" type="file" name="image3" id="file3" class="file1" value="file1"/><span style="line-height: 78px;" id="fileSpan3" class="fileSpan1">点击上传</span></a></li>
	                                <li><a href="javascript:void(0)"><input unselectable="on" type="file" name="image4" id="file4" class="file1" value="file1"/><span style="line-height: 78px;" id="fileSpan4" class="fileSpan1">点击上传</span></a></li>
	                                <li><a href="javascript:void(0)"><input unselectable="on" type="file" name="image5" id="file5" class="file1" value="file1"/><span style="line-height: 78px;" id="fileSpan5" class="fileSpan1">点击上传</span></a></li>
                                    
                                    
                                </ul>
                                <p class="customer-service-upload-tips">为了帮助我们更好的解决问题，请上传相关照片，最多三张，每张不超过3M，仅支持JPG/PNG格式。</p>
                            </div>
                        </div>
                        <div class="customer-service-form-list clearfix clear">
                        	<span>&nbsp;</span>
                            <div class="customer-service-form-info clearfix">
								<a href="javascript:void(0)" onclick="submitApply()" class="customer-service-submit">提交申请</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="order-sub">
                <div class="customer-service-info">
                    <h2>售后申请</h2>
                    <div class="order-number">
						<b>订单编号：</b><span><#if tOrder?exists>${tOrder.orderSn?if_exists}</#if></span>
                    </div>
                    <ul class="customer-service-order-list">
                        <li class="clearfix clear">
                            <img src="${ui1}${tGoods.abbreviationPicture?if_exists}"/>
                            <p>${tGoods.shortName?if_exists}</p>
                        </li>
                    </ul>
                    <div class="customer-service-order-info">
                    	<p><b>商品数量：</b><span>${tOrderItem.quantity?if_exists}<input type="hidden" id="itemQ" value="${tOrderItem.quantity?if_exists}"/></span></p>
                        <p><b>成交时间：</b><span>${tOrderItem.createTime?if_exists?string("yyyy-MM-dd HH:mm:ss")}</span></p>
                        <p><b>运&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费：</b><span>${tOrder.shippingFee?if_exists}元</span></p>
                        <p><b>优惠金额：</b><span>${youhui?if_exists}元</span></p>
                        <p><b>实付金额：</b><span>${tOrder.paidAmount}元</span></p>
                    </div>
                </div>
                <div class="customer-service-info mt10">
                    <h2>常见问题</h2>
                    <ul class="customer-service-question">
                    	<li><a href="#">· 退款的申请条件和流程</a></li>
                        <li><a href="#">· 退款退货的申请条件和流程</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<form>
<script type="text/javascript" src="${base}/web/js/return_apply.js"></script>
</body>
</html>
 <style type="text/css">
	    .fileSpan1{
	    	line-height: 78px;
	    }
    </style>
<script type="text/javascript">
$(function(){
	$('.customer-service-type-tips').show();	
	$('.customer-service-type-box').hover(function(){
		$('.customer-service-type-tips').show();	
	},function(){
		$('.customer-service-type-tips').hide();
	})	
})
</script>
