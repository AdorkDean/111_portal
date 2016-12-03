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
    <title>订单详情</title>
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
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
    <style type="text/css">
        /*.member-content{padding-left:24px;}*/
        .member-content h2{height:40px; line-height:50px; width:965px; padding-left:24px;}
        .orders-massage{width:962px; margin-left:24px; border:1px solid #d7d7d7;}
        .orders-details{border:1px solid #eedca7; width:922px; position: relative; padding-left:42px;margin-left:24px;}
        .at-once{position: absolute; top:50%; right:54px; margin-top:-13px; display: block; width:76px; height:26px; text-align: center; line-height:26px; border-radius:5px; background: #fe4310;color:#FFF; font-size:12px;}
        .orders-massage h3{margin-bottom:0; font-size:14px; color:#FFF;background: #d7d7d7; height:38px; line-height:38px; margin-top:0;}
        .orders-massage ul{ padding:10px 0 10px 24px; width:908px;}
        .orders-massage ul li{width:400px;}
        .orders-massage .orders-list{padding:0;}
        .tab-top td{background: #f3f5f7; border-top:1px solid #d7d7d7;}
        .tab-orders tr td{border-bottom:1px solid #d7d7d7;}
        .tab-orders tr:last-child td{border-bottom:none;}
        .tab-orders tr td:first-child{padding-left:10px; }
        .tab-orders td.color01{font-weight: bold;}
    </style>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧------->
       <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content refund">
            <h2>订单中心</h2>
            <!-- 订单详情开始-->
            <div class="orders-details">
                <h3>当前订单状态：<span>已发货</span></h3>
                <a href="#" class="at-once" id="popup-btn">立即评价</a>
            </div>
            <!-- 订单详情开始-->
            <!-- 订单信息开始-->
            <div class="orders-massage">
                <h3>订单信息</h3>
                <ul>
                    <li>订单编号：<#if order?exists && order.orderSn?exists >
               		 				${order.orderSn?default('')}
               					</#if>
               		</li>
                    <li>下单时间：<#if order?exists && order.accdate?exists>
               					 ${order.accdate?default('')}
               		 			</#if>
                    </li>
                    <li>订单金额：<#if order?exists && order.orderAmount ?exists>
               					 ${order.orderAmount?default('')}
				  			   </#if>
                    </li>
                </ul>
                <div class="orders-list">
                    <table width="966" cellspacing="0" cellpadding="0" class="tab-orders">
                        <tr class="tab-top">
                            <td align="left" height="32">商品编号</td>
                            <td align="left" height="32">商品名称</td>
                            <td align="left" height="32">单价(元)</td>
                            <td align="left" height="32">数量</td>
                            <td align="left" height="32">商品总价(元)</td>
                        </tr>
                        <#if goodsList?exists >
                        	<#list goodsList?if_exists as item>
		                        <tr>
		                            <td align="left" height="32" class="color01">${item.orderItemSn?default('')}</td>
		                            <td align="left" height="32">${item.shortName?default('')}</td>
		                            <td align="left" height="32" class="color02">${item.price?default('')}</td>
		                            <td align="left" height="32" class="color02">${item.orderItemQty?default('')}</td>
		                            <td align="left" height="32" class="color02">${(item.orderItemQty?number*item.price?number)?string("0.00")}</td>
		                        </tr>
	                        </#list> 
                        </#if>
                    </table>
                </div>
            </div>
            <!-- 订单信息结束-->
            <!-- 商品列表开始-->
            
            <!-- 商品列表结束-->
        </div>
        <#include "/static/inc/version2.2.0/footer.ftl">
<style>.autocomplete_ui {width:170px;}.autocomplete_ui span {width:165px;}</style>
    </div>
</div>
<!--遮罩层开始--><div id="shade"></div><!--遮罩层结束-->
    <!--商品评论开始-->
    <div class="out out-box popup-add">
        <h4 class="out-title title-middle">
            <a href="#" class="close-out"></a>
            商品评价
        </h4>
        <div class="tab-info clearfix clear">
            <table border="0">
              <tr class="tab-info-title">
                <td>订单编号</td>
                <td>订单金额（元）</td>
                <td>购买时间</td>
                <td>订单状态</td>
              </tr>
              <tr>
                <td><#if order?exists && order.orderSn?exists >
               		 				${order.orderSn?default('')}
               		</#if>
                </td>
                <td><#if order?exists && order.orderAmount ?exists>
               					 ${order.orderAmount?default('')}
				  	</#if>
                </td>
                <td><#if order?exists && order.accdate?exists>
               					 ${order.accdate?default('')}
               		 </#if>
                </td>
                <td>已完成</td>
              </tr>
            </table>
        </div>
        <div class="xd-box">
            <dl class="clearfix">
                <dt><span>*</span>心得：</dt>
                <dd>
                    <div class="xd-info">
                        <textarea maxlength="100" placeholder="商品是否满意？快分享你的购买心得吧！" id="content" onpropertychange="checkLength(this,100);" oninput="checkLength(this,100);"></textarea>
                    </div>
                    <div class="xd-btn clearfix">
                        <a href="#" class="pj-btn" onclick="sub()" id="btn">评价</a>
                        <span class="xd-tips">10-100字</span>
                    </div>
                </dd>
            </dl>
        </div>
    </div>
    <!--商品评论结束-->
<style>
.tab-info table{border-collapse:collapse; width:100%;}
.tab-info tr{border-bottom:1px solid #d7d7d7; height:65px; line-height:65px;}
.tab-info td{width:20%; text-indent:24px;}
.tab-info tr.tab-info-title{height:35px; line-height:35px;}
.xd-box{padding:20px 50px 30px;}
.xd-box dt{width:70px; font-weight:bold; float:left; text-align:center; line-height:26px;}
.xd-box dt span{color:#ee4646;}
.xd-box dd{width:520px; float:left;}
.xd-info{border:1px solid #a6a6a6; height:110px; padding:5px;}
.xd-info textarea{height:110px; width:100%;}
.xd-btn{ text-align:right; padding:10px 0;}
.nm-box{width:80px; float:right; text-align:left; line-height:26px;}
.nm{padding:0; margin:1px 2px 0; float:left;}
.pj-btn{height:26px; line-height:25px; width:66px; background:#e37070; border-radius:4px; -webkit-border-radius:4px; color:#fff; display:block; float:right; text-align:center;}
.xd-tips{ line-height:26px; padding-right:15px;}
</style>
<script type="text/javascript" src="${base}/web/js/member.js"></script>
<script type="text/javascript" charset="utf-8">
function checkLength(obj,maxlength){
    if(obj.value.length > maxlength){
        obj.value = obj.value.substring(0,maxlength);
    }
}

 function sub(){
    var orderSn = "${orderSn?default('')}";
    var content = $("#content").val();
    $("#btn").attr("disabled", true);
    if($.trim(content)==""){
      	content = "宝贝很好哦，极力向大家推荐！！";
    }
    if(content.length<10){
       alert("评论内容为10-100字");
       $("#btn").attr("disabled", false);
       return ;
    }
    $.post("${base}/storeOrder/storeOrder!storeOrderComment.action", {orderSn:orderSn,content:content,random:Math.random()}, function(data){
          alert(data);
          window.location.href="${base}/member/orderlist!getOutOrderList.action"; 
    });
 }
</script>
</body>
</html>