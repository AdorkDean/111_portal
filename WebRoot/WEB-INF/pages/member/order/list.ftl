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
    <title>我的订单</title>
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
<body>
<#include "/static/inc/center_header.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<form id="inputForm" name="form1" action="${base}/member/order!list.action" method="post" >
<input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(0)}" id="p_curPage">
<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(10)}" id="pageSize">	
<div class="member-line">
    <div class="member-wrap" style="overflow: visible;">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content refund">
            <h2>我的订单</h2><div class="select-order"><a class="current" href="${base}/member/order!list.action">线上订单</a><a href="${base}/member/orderlist!getOutOrderList.action" >门店订单</a></div>
            <div class="member-refund">
            	<div class="member-refund-line"></div>
                <div class="info" id="choose-info">
                	<input id="type" type="hidden" name="type" value="${type?default('')}">
                	<span val="1" <#if type == "1">class="current" </#if>>全部订单</span>
                	<span val="2" <#if type == "2">class="current"</#if>>待支付订单</span>
                	<span val="3" <#if type == "3">class="current"</#if>>待收货订单</span>
                	<span val="4" <#if type == "4">class="current"</#if>>待评价订单</span>
                </div>
                <div class="list" id="choose-list">
                    <div class="list-con current">
                        <div class="state">
                            <div class="state-list">
                                <select class="selete-box" name="time">
                                	<option value="1" <#if time == "1">selected</#if>>所有订单</option>
                                    <option value="2" <#if time == "2">selected</#if>>一个月内订单</option>
                                    <option value="3" <#if time == "3">selected</#if>>最近三个月</option>
                                    <option value="4" <#if time == "4">selected</#if>>历史订单</option>
                                </select>
                            </div>
                            <div class="search">
                                <input id="sn" type="text" value="请输入订单编号..."  class="text"/>
                                <input id="snValue" name="sn" type="hidden" value="" />
                                <input id="submitBnt" type="button" value="搜索" class="btn"/>
                            </div>
                        </div>
                        
                         <div class="table-wrap">
                            <table width="950" border="0" cellpadding="0" cellspacing="0">
                                <tr class="tab-top">
                                    <td align="left" valign="middle" height="40" width="160">订单编号</td>
                                    <td align="left" valign="middle" height="40" width="120">订单商品</td>
                                    <td align="left" valign="middle" height="40" width="96">收货人</td>
                                    <td align="center" valign="middle" height="40" width="100">订单金额(元)</td>
                                    <td align="center" valign="middle" height="40" width="140">订单时间</td>
                                    <td align="left" valign="middle" height="40" width="80">订单状态</td>
                                    <td align="left" valign="middle" height="40" width="80">积分</td>
                                    <td align="left" valign="middle" height="40" width="60">操作</td>
                                </tr>                                
                            </table>
                        </div>
                        
                        <#if pw.result?has_content>
                        <#list pw.result?if_exists as resc>
                        <div class="table-wrap">
                            <table width="950" border="0" cellpadding="0" cellspacing="0">
                                
                                <tr class="list-tab">
                                    <td align="left" valign="middle" height="40" width="160" class="cor-b">${resc.orderSn?default('')}</td>
                                    <td align="left" valign="middle" height="40" width="120" class="cor-b"><span class="more" val="${resc.id?default('')}">查看全部商品</span></td>
                                    <td align="left" valign="middle" height="40" width="96"><#if resc.receiver?length gt 9>${resc.receiver[0..8]?default('')}<#else>${resc.receiver?default('')}</#if></td>
                                    <td align="center" valign="middle" height="40" width="100" class="cor-r">${currency(resc.orderAmount?default(0))}</td>
                                    <td align="left" valign="middle" height="40" width="140"><#if resc.createDate?has_content>${resc.createDate?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
                                    <td align="left" valign="middle" height="40" width="80" class="cor-r" id="order_status_${resc.id?default('')}">
                                    	<#if resc.orderStatus?exists && resc.orderStatus == 0>待支付 </#if>                                    	
                                    	<#if resc.orderStatus?exists && resc.orderStatus == 1>待发货</#if>
                                    	<#if resc.orderStatus?exists && resc.orderStatus == 2>待收货</#if>
                                    	<#if resc.orderStatus?exists && resc.orderStatus == 3>已完成</#if>
                                    	<#if resc.orderStatus?exists && resc.orderStatus == 4>已取消</#if>
                                    	<#if resc.orderStatus?exists && resc.orderStatus == 5>已过期</#if>
                                    </td>
                                    <td align="left" valign="middle" height="40 "width="80">${resc.rewardIntegration?default(0)}</td>
                                    <td align="left" valign="middle" height="40" width="60" class="cor-n">
                                    	<#if resc.orderStatus?exists && resc.orderStatus == 0>
                                    		<a href="${base}/member/order!detail.action?id=${resc.id?default('')}" class="see">查看详情</a>
                                    		<a href="javascript:void(0);" class="cancelOrder" val="${resc.id?default('')}">取消订单</a>
                                			<a id="paybtn" href="${base}/member/order!orderSumbitSuccess.action?orderId=${resc.id?default('')}" class="payment">支付</a>		                                      		
                                    	</#if>                                    	
                                    	<#if resc.orderStatus?exists && resc.orderStatus == 1>
                                    		<a href="${base}/member/order!detail.action?id=${resc.id?default('')}" class="see">查看详情</a>
                                    		<!--<a href="javascript:void(0);" class="cancelOrder" val="${resc.id?default('')}">取消订单</a>-->
                                    	</#if>
                                    	<#if resc.orderStatus?exists && resc.orderStatus == 2>
                                    		<a href="${base}/member/order!detail.action?id=${resc.id?default('')}" class="see">查看详情</a>
                                    		<a href="javascript:void(0);" val="${resc.id?default('')}" class="see complete">确认收货</a>
                                    	</#if>
                                    	<#if resc.orderStatus?exists && resc.orderStatus == 3>
                                    		<a href="${base}/member/order!detail.action?id=${resc.id?default('')}" class="see">查看详情</a>
                                    		<!-- 待评论订单肯定有去评论按钮 -->
                                    		<#if resc.reviews?default(0) gt 0 ||  type == "4">
                                    		<a href="${base}/member/order!applyGoodsComment.action?orderId=${resc.id?default('')}" class="see">去评论</a>
                                    		<#else>
                                    		已评论	
                                    		</#if>
                                    	</#if>
                                    	<#if resc.orderStatus?exists && resc.orderStatus == 4>
                                    		<a href="${base}/member/order!detail.action?id=${resc.id?default('')}" class="see">查看详情</a>
                                    		<#if resc.rxOrder?default(0)==0>
                                    		<a class="see" href="${base}/carts/cart!rebuy.action?orderid=${resc.id?default('')}">再次购买</a>
                                    		</#if>
                                    	</#if>
                                    	<#if resc.orderStatus?exists && resc.orderStatus == 5>
                                    		<a href="${base}/member/order!detail.action?id=${resc.id?default('')}" class="see">查看详情</a>
                                    		<#if  resc.rxOrder?default(0)==0>
                                    		<a class="see" href="${base}/carts/cart!rebuy.action?orderid=${resc.id?default('')}">再次购买</a>
                                    		</#if>
                                    	</#if>
                                    </td>
                                </tr>
                            </table>
                            
                            <!--订单商品明细开始-->
                            <div class="commodity scroll">
                                <!-- 异步调用回来 -->
                                
                            </div>
                            <!--订单商品明细借宿-->
                        </div>
                        </#list>
                        </#if>
                        
                    </div>
                   
                    <!--分页开始-->
		            <#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
		            <!--分页结束-->
                </div>
            </div>
        </div>
    </div>
</div>
</form>
<div style="float:left;width:100%;">
<#include "/static/inc/footer.ftl">
</div>
</body>
</html>
<script type="text/javascript" charset="utf-8">
$(function(){
    $('.more').click(function(){
        var oCur=$(this).parents('.table-wrap').find('.commodity')
        if(oCur.is(":hidden")){
        	$.ajax({
		        type: "post",
		        cache: true,	
		        async: false,	        
		        url: "${base}/member/order!getOrderItem.action",
		        data: {
		        	id:$(this).attr("val")
		        },	            
		        success: function(data, textStatus){
		        	oCur.html(data);
		        }
		    });
            oCur.show();
            $(this).html("收起全部商品");
        }else{
            oCur.hide();
            $(this).html("查看全部商品")
        }
    })
    
    $("#choose-info span").click(function(){
    	$("#type").val($(this).attr("val"));
    	$("#p_curPage").val("");
    	$("#pageSize").val("");
        $("form")[0].submit();
    });
    
    
    $(".selete-box").change(function(){
    	$("#p_curPage").val("");
    	$("#pageSize").val("");
    	$("form")[0].submit();
    });
    
    var title = "请输入订单编号...";
    $("#sn").focus(function(){
    	if(title == $(this).val()){
			$(this).val("");    	
    	}
    });
    
    $("#submitBnt").click(function(){
    	 if(title != $("#sn").val()){
    	 	$("#snValue").val($("#sn").val());
    	 	$("#pageNext").val("");
    		$("#pageSize").val("");
			$("form")[0].submit();    	
    	}
    });
    
 	$(".cancelOrder").click(function(){

    	var obj = $(this);
    	$confirm("warn","确认取消订单",null,function(result){
	 		if(result){
	 			$.ajax({
		        type: "post",
		        cache: true,	
		        async: false,	        
		        url: "${base}/member/order!cancelOrder.action",
		        data: {
		        	"orderId":obj.attr("val")
		        },	            
		        success: function(data, textStatus){
		        	if(data.flag){
		        		//$alert("success",data.message,"友情提示",null);
		        		<#if type == "2">
		        		obj.parent().parent().parent().parent().parent().remove();
		        		<#else>
		        			$('#paybtn').remove(); 
		        		    obj.parent().append("<a class='see' href='${base}/carts/cart!rebuy.action?orderid="+obj.attr("val")+"'>再次购买</a>");
		        			$("#order_status_"+obj.attr("val")).html("已取消");
		        			obj.remove();	
		        		</#if>
		        	}else{
		        		$alert("warn",data.message,"友情提示",null);
		        	}
		        }
		    });
	 		}
	 	});
    });
    
    $(".complete").click(function(){

    	var obj = $(this);
    	$confirm("warn","确认收货",null,function(result){
	 		if(result){
	 			$.ajax({
			        type: "post",
			        cache: true,	
			        async: false,	        
			        url: "${base}/member/order!complete.action",
			        data: {
			        	id:obj.attr("val")
			        },	            
			        success: function(data, textStatus){
			        	if(data.flag){
			        		$alert("success",data.message,"友情提示",null);
			        		<#if type == "3">
			        		obj.parent().parent().parent().parent().parent().remove();
			        		<#else>
			        			obj.parent().append("<a class='see' href='${base}/member/order!applyGoodsComment.action?orderId="+obj.attr("val")+"'>去评论</a>");
			        			$("#order_status_"+obj.attr("val")).html("已完成");
			        			obj.remove();	
			        		</#if>
			        	}else{
			        		$alert("warn",data.message,"友情提示",null);
			        	}
			        }
			    });
	 		}
	 	});
    });
    
    
})
</script>
<style type="text/css">
	.member-refund .list .list-con .table-wrap table td a.payment{  background: #e37070 none repeat scroll 0 0;  border-radius: 5px;  color: #ffffff;  cursor: pointer;  display: block;  height: 20px;  width: 52px;  text-align: center;}
	.member-refund .list .list-con .table-wrap table .tab-top td{border-bottom:0; border-top:0;}
	.member-refund .list .list-con .table-wrap{padding:10px 0 10px 10px; overflow:hidden; border-bottom: 1px solid #EEE; }
	.member-refund .list .list-con .table-wrap table{margin-bottom:0;}
	.member-refund .list .list-con .state{height:26px; width:950px; padding:0 10px;padding-bottom:10px;border-bottom: 1px solid #dcdcdc; }
	.member-refund .list .list-con .table-wrap table .list-tab td{border-bottom: 0;}
	
	.member-refund .list .list-con .state .state-list .selete-box{border:1px solid #a1a1a1; _width:150px;height: 24px;line-height: 24px;}
	.member-refund .list .list-con .table-wrap table .list-tab td{padding-top:0px;}
	.member-refund .list .list-con .table-wrap table td .payment {
    background: #e37070 none repeat scroll 0 0;
    border-radius: 5px;
    color: #ffffff;
    cursor: pointer;
    display: block;
    height: 20px;
    width: 52px;
}
</style>
<style type="text/css">
        .select-order{position: absolute; top:17px;; left:100px; }
        .select-order a{float:left; display: inline-block; margin-right:10px; width:60px; height:28px; line-height:28px; text-align: center;}
        .select-order a.current{background: #19a69f; border-radius:5px; color:#FFF;}
    </style>
