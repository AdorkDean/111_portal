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
    <title>会员中心</title>
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
    <!--js-->
</head>

<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
    <link rel="stylesheet" type="text/css" href="/web/css/jq-alert-confirm.css">
<script src="${base}/web/version2.2.0/js/underline-slide.js"></script>
<script type="text/javascript" src="/web/version2.2.0/js/goods_detail_header.js"></script>
<!-- line开始-->
<div class="member-line"></div>
<!-- line结束-->
<!--内容开始-->
<div class="member-content w1090">
    <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
    <!-- 右侧内容开始-->
    <div class="member-main-right">
        <div class="m-site order-site">
            <a href="/member/index!getCenterIndex.action">用户中心</a>　>　<span>我的订单</span>
        <!-- 搜索开始-->
        <div class="order-search">
            <input type="text" id="key" <#if orderNO?exists&&orderNO?default('')!=''>value="${orderNO?default('')}"<#else>value="请输入订单编号..." </#if>class="input-text"/>
            <input type="button" value="搜索" onclick="seach();" class="input-btn"/>
        </div>
        <!-- 搜索结束-->
        </div>
        <div class="personal-data">
            <ul class="data-nav order-info">
            <#if orderType?default(-1)==5>
                <li class="current"><a href="javascript:void(0);" onclick="selectOrderList(5);"><span>历史订单</span></a></li>
            <#else>
                <li <#if orderType?default(-1)==-1>class="current"</#if>><a href="javascript:void(0);" onclick="selectOrderList(-1);"><span>全部订单</span></a></li>
                <li <#if orderType?default(-1)==1>class="current"</#if>><a href="javascript:void(0);"  onclick="selectOrderList(1);"><span>待支付订单</span><#if countModel.orderNoPay?default(0)!=0><b>${countModel.orderNoPay?default(0)}</b></#if></a></li>
                <li <#if orderType?default(-1)==4>class="current"</#if>><a href="javascript:void(0);"  onclick="selectOrderList(4);"><span>待发货订单</span><#if countModel.orderPay?default(0)!=0><b>${countModel.orderPay?default(0)}</b></#if></a></li>
                <li <#if orderType?default(-1)==2>class="current"</#if>><a href="javascript:void(0);"  onclick="selectOrderList(2);"><span>待收货订单</span><#if countModel.orderDelivery?default(0)!=0><b>${countModel.orderDelivery?default(0)}</b></#if></a></li>
                <li <#if orderType?default(-1)==3>class="current"</#if>><a href="javascript:void(0);"  onclick="selectOrderList(3);"><span>待评价订单</span><#if countModel.orderRev?default(0)!=0><b>${countModel.orderRev?default(0)}</b></#if></a></li>
                <li><a href="${base}/member/orderlist!getOutOrderList.action"><span>门店订单</span></a></li>
            </#if>
            </ul>
            <div class="data-line order-line"></div>
        </div>
        <div class="order-tab-name">
            <ul>
                <li>
                    <select name="datetype" id="datetype" class="order-select">
                        <option <#if dateType?default(1)==1>selected</#if> value="1">近三个月订单</option>
                        <option  <#if dateType?default(1)==2>selected</#if> value="2">近半年订单</option>
                        <option <#if dateType?default(1)==3>selected</#if> value="3">全部订单</option>
                    </select>
                </li>
                <li>订单信息</li>
                <li>收货人</li>
                <li>订单状态</li>
                <li>操作</li>
            </ul>
        </div>
        <#if pw.pageInfo.count?default(0)!=0>
        <!--订单列表开始-->
        <#list pw.result?if_exists as resc>
        <div class="order-list">
	            <div class="list-details">
		                 <div class="list-details-info">
		                     <ul>
		                         <li>${resc.create_date?default('')}</li>
		                         <li>订单号：${resc.order_sn?default('')}</li>
		                         <li>总金额：${resc.order_amount?string('0.00')}元</li>
		                         <li><#if (resc.receiver?length>6)>${resc.receiver.substring(0,6)}...<#else>${resc.receiver?default('')}</#if></li>
		                         
		                         <#if resc.order_status?default(-1)==0>
		                         	<li class="color-red">待支付</li>
		                         <#elseif resc.order_status?default(-1)==1>
		                         	<li>待发货</li>
		                         <#elseif resc.order_status?default(-1)==2>
		                         	<li>待收货</li>
		                         <#elseif resc.order_status?default(-1)==3>
		                         	<li>已完成</li>
		                         <#elseif resc.order_status?default(-1)==4>
		                         	<li>已取消</li>
		                         <#elseif resc.order_status?default(-1)==5>
		                         	<li>已过期</li>
		                         </#if>
		                         
		                     </ul>
		                 </div>
		                <div class="list-details-main">
		                <#list resc.orderitem?if_exists as items>
		                    <ul class="order-num">
		                        <li><a target="_blank" href="${base}/p/${items.goods_id?default()}.html"><img src="${ui1}${items.abbreviation_picture?default('')}" alt="${items.short_name?default('')}"/></a></li>
		                        <li><a target="_blank" href="${base}/p/${items.goods_id?default()}.html">${items.goods_name?default('')}</a></li>
		                        <li>规格:${items.spec?default('')}</li>
		                        <li>＊${items.quantity?default(0)}</li>
		                        <li>${items.price?string('0.00')}</li>
		                        <li>
		                        <#if resc.order_status?default(-1)==2||resc.order_status?default(-1)==3>
		                        <#if items.refund_process?default(0)==0>
		                        	<a href="javascript:void(0)" onclick="applyReturn1(${resc.id},${items.goods_id},${items.quantity},${items.id})">退款</a>\
		                        	<a href="javascript:void(0)" onclick="applyReturn2(${resc.id},${items.goods_id},${items.quantity},${items.id})">退货</a>
		                        <#elseif items.refund_process?default(0)==1>
		                        <a href="#" onclick="${base}/member/return!detailReturn.action?goodId=${items.goods_id}&orderId=${resc.id}">查看退款/退货</a>
		                        </#if>
		                        </#if>
		                        </li>
		                    </ul>
		                 </#list>   
		                </div>
	            </div>
		            <div class="look-details two-rows">
		                <a href="${base}/member/order!detail.action?id=${resc.id?default(0)}" class="font-weight">查看详情</a>
		                <#if resc.order_status?default(-1)==0>
		                <a href="javascript:void(0);" val="${resc.id?default(0)}" class="cancelOrder" >取消订单</a>
		                <a href="${base}/member/order!orderSumbitSuccess.action?orderId=${resc.id?default('')}" class="pay-btn">支付</a>
		                </#if>
		                <#if resc.order_status?default(-1)==1>
		                <a href="javascript:void(0);" val="${resc.id?default(0)}" class="cancelOrder" >取消订单</a>
		                </#if>
		                <#if resc.order_status?default(-1)==2>
		                <a href="javascript:void(0);" val="${resc.id?default(0)}" class="pay-btn complete">确认收货</a>
		                </#if>
		                <#if resc.recount?default(0) &gt; 0>
		                <a href="/member/order!applyGoodsComment.action?orderId=${resc.id?default('')}" class="font-weight">去评论</a>
		                </#if>
		                <#if resc.order_status?default(-1)==5||resc.order_status?default(-1)==4>
		                <a href="javascript:void(0);" val="${resc.id?default(0)}" class="pay-btn chongxinbuy">重新购买</a>
		                </#if>
		            </div>
        </div>
        </#list>
        <!--订单列表结束-->
        <#else>
          <div class="mb-index-box-no-order" style="height: 210px;border: 1px solid #d7d7d7; line-height: 210px; text-align: center; margin:10px 0;">
            <p>对不起，您当前暂无订单！</p>
        </div>
        </#if>
        <#if pw.pageInfo.count?default(0)!=0>
        <!--分页开始-->
            <#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
            <!--分页结束-->
         </#if>   
    </div>
    <!-- 右侧内容结束-->
    
    
</div>
    <div class="user_center_footer" style="float:left; "><#include "/static/inc/version2.2.0/footer.ftl">
       <style>.autocomplete_ui {width:170px;}.autocomplete_ui span {width:165px;}</style>
    </div>
<!--内容结束-->

<form name="form1" id="form1"  action="${base}/member/center!getOrderList.action" method="post">
	     	<input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(1)}" id="p_curPage">
			<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(10)}" id="pageSize">
			<input type="hidden" name="orderType" value="${orderType?default(-1)}" id="orderType">
			<input type="hidden" name="dateType" value="${dateType?default(1)}" id="dateType">
			<input type="hidden" name="orderNO" value="${orderNO?default('')}" id="orderNO">
			<input id="orderId" type="hidden" value="">
</form>
  <!-- 退款/退货弹窗开始-->
<#include "/WEB-INF/pages/goodsReturn/apply_return_dialog.ftl">
<!-- 退款/退货弹窗结束-->
<!--遮罩层开始-->
<div id="shade1" >
    <!--取消订单开始-->
    <div class="out450 out-box450" id="out4" style="display:none">
        <h4 class="out-title">
            <a href="javascript:void(0);" onclick="closeDiv();" class="close-out"></a>
            取消订单
        </h4>
        <div class="out-info clearfix clear">
            <div class="cancle-order-tips">
            	<div class="choice-cancal-reason">
                	<span>取消原因</span>
                    <p>
                    	<select id="cancleMessage">
                        	<option value="1">现在不想购买</option>
                            <option value="2">商品价格较贵</option>
                            <option value="3">价格波动</option>
                            <option value="4">商品拍错</option>
                            <option value="5">重复下单</option>
                            <option value="6">收货人信息有误</option>
                            <option value="7">商品缺货</option>
                            <option value="8">发票信息有误</option>
                            <option value="9">发货慢</option>
                            <option value="10">无法支付订单</option>
                            <option value="11">其他原因</option>
                        </select>
                    </p>
                </div>
            	<p class="choice-cancle-tips">订单成功取消后将无法恢复<br/>已支付订单审核通过后将由客服联系您退款</p>
            	
            </div>
            <div class="out-button">
                <a href="javascript:void(0);" onclick="cancleOrder();">确 定</a>
                <a href="javascript:void(0);"  onclick="closeDiv();" class="bg-color">再考虑下</a>
            </div>
        </div>
    </div>
    </div>
    <!--取消订单开始-->
    <style>
	.choice-cancal-reason{height:30px; padding:20px 60px 0;}
    .choice-cancal-reason span{float:left; display:block; height:30px; line-height:30px; width:60px;}
	.choice-cancal-reason p{width:120px; height:28px; border:1px solid #efefef; border-radius:2px; -webkit-border-radius:2px; float:left; padding:0 5px;}
	.choice-cancal-reason p select{width:100%; margin:6px 0 5px; border:none; background:none;}
	.choice-cancle-tips{padding:20px 60px 0;}
    </style>
<script src="${base}/web/version2.2.0/js/shopping.js"></script>
</div>
<!--遮罩层结束-->
</body>

<script>
function submitForm(){
	 	$("#p_curPage").val("1");
	 	$("#form1").submit();
	}
	
function selectOrderList(orderStatus){
	$("#orderType").val(orderStatus);
	submitForm();
}
$("#datetype").change(function(){
var dat=$("#datetype").val();
$("#dateType").val(dat);
	submitForm();
});


$(".cancelOrder").click(function(){
$("#shade1").show();
$("#out4").show();
var orderId=$(this).attr("val")
$("#orderId").val(orderId);
    });
    
    
     $(".complete").click(function(){

    	var obj = $(this);
    	$confirm("warn","确认收货",null,function(result){
	 		if(result){
	 			$.ajax({
			        type: "post",
			        cache: true,	
			        async: false,	        
			        url: "${base}/member/center!confirmOrder.action",
			        data: {
			        	orderId:obj.attr("val")
			        },	            
			        success: function(data){
			        	  var obj=jQuery.parseJSON(data);
			        	if(obj.status>0){
			        		$alert("success",obj.message,"友情提示",null);
			        		$("#form1").submit();
			        	}else{
			        		$alert("warn",obj.message,"友情提示",null);
			        	}
			        }
			    });
	 		}
	 	});
    });
    
    var title = "请输入订单编号...";
    $("#key").focus(function(){
    	if(title == $(this).val()){
			$(this).val("");    	
    	}
    });
    function seach(){
    var orderNo=$("#key").val();
    if(orderNo=="请输入订单编号..."){
   orderNo="";
    }
    $("#orderNO").val(orderNo); 
   submitForm();
    }
    
    
    
 $(".chongxinbuy").click(function(){
 var obj = $(this);
 var status = 1;
    jQuery.ajax
   ({
       type: "post",
       url: "/member/center!showBuy.action",	  
       data:{
       orderid:obj.attr("val")
       },
       async:false,
       success: function(data)
       {
    	   
    	   var s=jQuery.parseJSON(data);
    	   status = s.status;
    	   if(s.status==0)
    	   {
    		   getCartSum(1); 
    	   $alert("success","已成功添加至购物车","友情提示",null);
    	   }else{
    	   $alert("warn","部分商品或者全部商品加入购物车失败","友情提示",null);
    	   }
    		  window.location.href="/carts/cart!page.action?url="+window.location.href;
       }
   }); 
 });
	
function closeDiv(){
$("#shade1").hide();
$("#out4").hide();

}
  
  function cancleOrder(){
  var cancleMessage=$("#cancleMessage").val();
  var orderId=$("#orderId").val();
  $.ajax({
			        type: "post",
			        cache: true,	
			        async: false,	        
			        url: "${base}/member/center!cancelOrder.action",
			        data: {
			        	orderid:orderId,cancleType:cancleMessage
			        },	            
			        success: function(data){
			        var obj=jQuery.parseJSON(data);
			        	if(obj.flag>0){
			        		$alert("success",obj.message,"友情提示",null);
							$("#out4").hide();
			        		$("#shade1").hide();
			        		
			        		$("#form1").submit();
			        	}else{
			        		$alert("warn",obj.message,"友情提示",null);
			        	}
			        }
			    });
  }
</script>
</html>