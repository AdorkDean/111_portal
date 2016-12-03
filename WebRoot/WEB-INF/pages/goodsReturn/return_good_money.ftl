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
    <title>退货审核</title>
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
<div class="">
     <div class="member-header w1000">
        <!--售后进度条-->
        <div class="customer-service-state clear clearfix">
            <ul>
                <li class="state-tip"><b>1</b><span>提交售后申请</span></li>
                <li class="bra-line"></li>
                <li class="state-tip<#if tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==0> finish-tip</#if>"><b>2</b><span <#if tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==0> class="doing-tit"</#if>>客服审核申请</span></li>
                <li class="bra-line"></li>
                <li class="state-tip<#if tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==1> finish-tip</#if>"><b>3</b><span <#if tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==1> class="doing-tit"</#if>>用户退货</span></li>
                <li class="bra-line"></li>
                <li class="state-tip<#if tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==7)> finish-tip</#if>"><b>4</b><span <#if tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==7> class="doing-tit"</#if>>等待客服验货</span></li>
                <li class="bra-line"></li>
                <#if tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==3||tReturn.orderStatus==5||tReturn.orderStatus==6||tReturn.orderStatus==8||tReturn.orderStatus==9)>
	                <li class="state-tip finish-tip"><b>5</b><span class="doing-tit">完成退货</span></li>
                <#elseif tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==2||tReturn.orderStatus==4)>
	                <li class="state-tip error-tip"><b>5</b><span class="error-tit">退货失败</span></li>
	            <#else>
	                <li class="state-tip"><b>5</b><span>完成退货</span></li>
                </#if>
            </ul>
        </div>
        <h2 class="member-title clear clearfix">售后申请</h2>
    </div>
    <div class="order-all w1000">
        <div class="order-box">
            <div class="order-main">
                <div class="order-wrap">
            
				<#if tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==0>
                	<#--   第二步,客服审核申请   -->
                    <div class="customer-service-form">
						<div class="customer-service-state-tips">
                        	<img src="/web/version2.2.1/images/order/examine_img.png"/>
                            <h2 class="customer-service-state-title">等待客服审核您的申请...</h2>
                            <p class="customer-service-state-text">
                            	如果审核通过，需要您退货并填写相关物流信息<br/>
                                如果审核未通过，需要您修改申请或联系客服解决
                            </p>
                        </div>
                    </div>
                    
                <#elseif tReturn?exists && tReturn.orderStatus?exists && (tReturn.orderStatus==2||tReturn.orderStatus==4)>    
                    <#--   第二步,客服审核未通过/验货未通过   -->
                    <div class="customer-service-form">
						<div class="customer-service-state-tips">
                        	<img src="/web/version2.2.1/images/order/reject_img.png"/>
                            <h2 class="customer-service-state-title">
                            	退货申请未通过
                            </h2>
                            <p class="customer-service-state-text">
                            	退货申请未通过，需要您修改退货申请或联系客服
                            </p>
                            <p class="customer-service-state-tel">
                            	<span>客服电话：400-606-3111</span>
                            </p>
                        </div>
                    </div>
                <#elseif tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==1>    
                 
                    <#--  第三步,用户退货填信息   -->
                    <div class="customer-service-reback">
                    	<div class="customer-service-reback-list clearfix clear">
                        	<h2>1. 审核通过，请您将商品退回给我们</h2>
                        </div>
                        <div class="customer-service-reback-list clearfix clear">
                        	<span>退货地址：</span>
                            <div class="customer-service-reback-info clearfix">
                            	<p>
                                	北京北京市顺义区高丽营镇唐自头村西仓储园东库一号
                                </p>
                            </div>
                        </div>
                        <div class="customer-service-reback-list clearfix clear">
                        	<span>收&nbsp;&nbsp;件&nbsp;&nbsp;人：</span>
                            <div class="customer-service-reback-info clearfix">
                            	<p>
                                	111医药馆收
                                </p>
                            </div>
                        </div>
                        <div class="customer-service-reback-list clearfix clear">
                        	<span>联系电话：</span>
                            <div class="customer-service-reback-info clearfix">
                            	<p>
                                	4006063111
                                </p>
                            </div>
                        </div>
                        <div class="customer-service-reback-list mt20 clearfix clear">
                        	<h2>2. 填写物流信息</h2>
                        </div>
                        <div class="customer-service-reback-list mt20 clearfix clear">
                        	<span>物流公司：</span>
                            <div class="customer-service-reback-info clearfix">
                            	<p class="customer-service-reback-type">
                                	<input type="text" maxlength="80" name="expressCompany" placeholder="请填写物流公司"/>
                                </p>
                            </div>
                        </div>
                        <div class="customer-service-reback-list mt20 clearfix clear">
                        	<span>运单号码：</span>
                            <div class="customer-service-reback-info clearfix">
                            	<p class="customer-service-reback-type">
                                	<input type="text" maxlength="80" name="expressDelivery" placeholder="请填写物流单号"/>
                                </p>
                            </div>
                        </div>
                        <div class="customer-service-reback-list mt20 clearfix clear">
                        	<span>联系电话：</span>
                            <div class="customer-service-reback-info clearfix">
                            	<p class="customer-service-reback-type">
                                	<input type="text" name="shipperPhone" maxlength="12" value=""  placeholder="请填写联系电话"/>
                                </p>
                            </div>
                        </div>
                        <div class="customer-service-reback-list clearfix clear">
                        	<span>&nbsp;</span>
                            <div class="customer-service-form-info clearfix">
								<a href="javascript:void(0)" id="subLogisticsInfo" class="customer-service-submit">提交物流信息</a>
                            </div>
                        </div>
                    </div>
                    
                <#elseif tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==7>    
                    <#--  第四步,等待客服验货   -->
                    <div class="customer-service-form">
						<div class="customer-service-state-tips">
                        	<img src="/web/version2.2.1/images/order/Inspection_img.png"/>
                            <h2 class="customer-service-state-title">我们收到货后会尽快安排验货，请及时关注您<br/>的订单状态，如有疑问，请和客服联系。</h2>
                            <p class="customer-service-state-tel">
                            	<span>客服电话：400-606-3111</span>
                            </p>
                        </div>
                    </div>
                <#elseif (tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==3)||
		                 (tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==5)||
		                 (tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==6)||
		                 (tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==8)||
		                 (tReturn?exists && tReturn.orderStatus?exists && tReturn.orderStatus==9)>    
                   
                    <#--  第五步,完成退货   -->
                    <div class="customer-service-form">
						<div class="customer-service-state-tips">
                        	<img src="/web/version2.2.1/images/order/success_img.png"/>
                            <h2 class="customer-service-state-title">退款成功啦，退款金额将会在3-5个<br/>工作日内返回您的账户，请您注意查收！</h2>
                            <p class="customer-service-state-text">
                            	退款完成时间：<#if tReturn?exists && tReturn.finishDt?exists> ${tReturn.finishDt?if_exists?string("yyyy-MM-dd HH:mm:ss")}</#if><br/>
                                退款金额：<span><#if tReturn?exists && tReturn.refundAmount?exists>${tReturn.refundAmount?if_exists?string("#0.00")}</#if></span> 元 
                            </p>
                        </div>
                    </div>
                    <#-------------------------------------------------------------->
                </#if>
                
                
                </div>
            </div>
            <div class="order-sub">
                <div class="customer-service-info">
                    <h2>售后申请</h2>
                    <div class="order-number">
                    	<input type="hidden" id="singleId" value="${tReturn.id?if_exists}"/>
						<b>订单编号：</b><span>${tOrder.orderSn?if_exists}</span>
                    </div>
                    <ul class="customer-service-order-list">
                        <#--<li class="clearfix clear">
                            <img src="images/order/p_img.jpg"/>
                            <p>子弹飞牌六味地黄丸1000丸滋阴补肾</p>
                        </li>
                        -->
                        <li class="clearfix clear">
                            <img src="${ui1}${tGoods.abbreviationPicture?if_exists}"/>
                            <p>${tGoods.shortName?if_exists}</p>
                        </li>
                    </ul>
                    <div class="customer-service-order-info">
                    	<p><b>商品数量：</b><span>${tOrderItem.quantity?if_exists}</span></p>
                        <p><b>成交时间：</b><span>${tOrderItem.createTime?if_exists?string("yyyy-MM-dd HH:mm:ss")}</span></p>
                        <p><b>运&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费：</b><span>${tOrder.shippingFee?if_exists?string("0.00")}元</span></p>
                        <p><b>优惠金额：</b><span>${youhui?if_exists?string("0.00")}元</span></p>
                        <p><b>实付金额：</b><span>${tOrder.paidAmount?string("0.00")}元</span></p>
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
</body>
</html>

<script type="text/javascript">
$(function(){
	$('.customer-service-type-box').hover(function(){
		$('.customer-service-type-tips').show();	
	},function(){
		$('.customer-service-type-tips').hide();
	})	
	
	
	
	
	
	$("#subLogisticsInfo").click(function() {
		var expressCompany = $("input[name='expressCompany']").val();
		var expressDelivery = $("input[name='expressDelivery']").val();
		var shipperPhone = $("input[name='shipperPhone']").val();
		var singleId = $("#singleId").val();
		if (singleId == "") {
			alert("请选择正确的有效数据!");
			return false;
		}
		//if (expressCompany == "") {
		//	document.getElementById("expressCompanyTip").innerHTML = "物流公司不能为空! ";
		//	return;
		//}
		//if (expressDelivery == "") {
		//	document.getElementById("expressDeliveryTip").innerHTML = "快递单号不能为空!";
		//	return;
		//}
		$.ajax({// setShowGoodsComment
			url : "../member/return!addLogisticsInfo.action",
			type : "POST",
			data : {
				'id' : singleId,
				'expressCompany' : expressCompany,
				'expressDelivery' : expressDelivery,
				'shipperPhone' : shipperPhone
			},
			async:false,
			success : function(data) {
				if (data.status == 1) {
					$("#shade,.popup-add").hide();
					$alert("success", data.message, null, null);
					$("#addLogisticsInfo").innerHTML ="<h4 class=\"mt20\"><b class=\"warning\"></b>您已填写物流信息,请等待审核通过</h4>";
					window.location.reload(true);
				} else {
					$("#shade,.popup-add").hide();
					$alert("warn", data.message, null, null);
					window.location.reload(true);
				}
			},
			error : function(data) {
				$alert("warn", "内部错误,请稍后重试!");
				window.location.reload(true);
			}
		});
	});
})
</script>
