<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="111医药馆网上药店是国家药监局认证指定网上药房|打造为老百姓服务药品价格低品种全|网上购药买药就选壹壹壹医药馆药品特卖网站">
    <!-- keywords -->
    <meta name="keywords" content="壹壹壹医药馆|壹药馆|11医药馆|1药馆|医卡通|111医药馆|医药网|药品特卖网站">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>支付成功页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/> 
    <link rel="icon" type="image/png" href="${base}/web/img/favicon.png">
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="assets/img/favicon-196x196.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="assets/img/apple-icon-touch.png">
    <meta name="msapplication-TileImage" content="assets/img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <!--style-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css">
    <!--header-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/headerNew.css">
    <!--footer-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/footerNew.css">
    <!--product-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/product.css">
</head>
<#include "/static/inc/shopping_pay_header.ftl">
<!--购物-支付模块开始-->
	<div class="shopping-cart-box">
    	<div class="shopping-cart-main w1210">
        	<!--购物步骤开始-->
        	<div class="shopping-state">
            	<!--进度条-->
            	<div id="process" class="section4">
                	<div class="bar-left"></div>
		            <div class="node fore ready">
                    	<ul>
                        	<li class="tx1"><span class="state"><s></s>选择商品</span></li>
                        </ul>
                    </div>
            		<div class="proce ready">
                    	<ul>
                        	<li class="tx1">&nbsp;</li>
                        </ul>
                    </div>
            		<div class="node ready">
                    	<ul>
                        	<li class="tx1"><span class="state"><s></s>填写核对订单信息</span></li>
                        </ul>
                    </div>
            		<div class="proce ready">
                    	<ul>
                        	<li class="tx1">&nbsp;</li>
                        </ul>
                    </div>
            		<div class="node ready">
                    	<ul>
                        	<li class="tx1"><span class="state"><s></s>成功提交订单</span></li>
                        </ul>
                    </div>
            		<div class="proce doing">
                    	<ul>
                        	<li class="tx1">&nbsp;</li>
                        </ul>
                    </div>
            		<div class="node doing" style="border-radius:0 8px 8px 0; -moz-border-radius:0 8px 8px 0; -webkit-border-radius:0 8px 8px 0;">
                    	<ul>
                        	<li class="tx1"><span class="state"><s></s>完成订单</span></li>
                        </ul>
                    </div>
           		</div>
            </div>
            <!--购物步骤结束-->
            <!--支付开始-->
            <div class="my-shopping-cart">
            	<div class="shopping-order complete-order">
                	<dl class="submit-order-info clearfix clear">
                    	<dt><b></b>
                    	    <#if order.orderStatus==1 &&paymentWay.paymentCode =='hdfk'>
                    	                订单提交成功！
                    	    </#if>
                    	   <#if order.orderStatus==1 &&paymentWay.paymentCode !='hdfk'>
                    	                  订单支付成功！
                    	   </#if>
                    	    <#if order.orderStatus==0 &&paymentWay.paymentCode !='hdfk'>
                    	                 订单支付处理中！
                    	    </#if>
                    	<a href="${base}/member/order!detail.action?id=${order.id?if_exists}">点击查看订单信息</a></dt>
                        <dd>
                        	<p>订单号：${order.orderSn?if_exists}</p>
							<p><span>收货人：${order.receiver?if_exists}</span><span>${order.areaName?if_exists}${order.detailedAddress?if_exists}</span><span>${order.phone?if_exists}</span></p>
							<p><span>
							<#if order.orderStatus==1 &&paymentWay.paymentCode =='hdfk'>
                    	                待付金额:
                    	     <#else>
                    	                支付金额:        
                    	    </#if><b>¥${currency(order.payableAmount?default(''))}</b></span><spa>可获积分：<b>${order.rewardIntegration?if_exists}</b></span></p>
                            <!--<p>成交时间：2015-8-17 11:53:56</p>-->
                        </dd>
                    </dl>
                    <div class="reback-order-tips"><span id="daojishi">5</span>秒后自动跳转我的订单</div>
                    <div class="reback-order-manual"><a href="${base}/member/order!list.action">返回我的订单</a></div>
                </div>
            </div>
            <!--支付结束-->
        </div>
    </div>
    <!--购物-支付模块结束-->
</body>	
<script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
<#include "/static/inc/footer.ftl">
<script>
   	var i = 5; 
	var intervalid; 
	intervalid = setInterval("djs()", 1000); 
	function djs() { 
	if (i == 0) { 
	    clearInterval(intervalid); 
	    window.location.href = "${base}/member/order!list.action"; 
	} 
	$("#daojishi").html(i);
	i--; 
	}

</script>
</html>