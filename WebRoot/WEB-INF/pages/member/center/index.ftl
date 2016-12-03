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
    <title>个人中心</title>
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
 <style>.mainlist li:hover .exchange{display:block}</style>
    <!--common style-->
    <link rel="stylesheet" type="text/css" href="/web/css/jq-alert-confirm.css">
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/shopping.css">
    <!--js-->
</head>

<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<script type="text/javascript" src="${base}/web/js/goods-recommend_cart.js"></script>
<script src="${base}/web/version2.2.0/js/underline-slide.js"></script>
<script type="text/javascript" src="${base}/web/version2.2.0/js/shopping.js"></script>
<!-- line开始-->
<div class="member-line"></div>
<!-- line结束-->
<!--内容开始-->
<div class="member-content w1090">
     <#include "/WEB-INF/pages/member/left-menu.ftl">
    <!-- 右侧内容开始-->
    <div class="member-main-right">
        <div class="mb-name">
        <#if memberMap.nick_name?exists>
        ${memberMap.nick_name?default('')}
        <#elseif memberMap.user_name?exists>
        ${memberMap.user_name?default('')}
        <#else>
        	匿名
        </#if>
        ，欢迎您！</div>
        <!-- 个人中心头像资料开始-->
        <div class="member-index-header clearfix">
            <div class="mb-index-part">
                <div class="circleProgress_wrapper">
                <#if memberMap.perFect?default(20)==20>
					<div class="circle25"></div>
                <#elseif memberMap.perFect?default(20)==50>
                    <div class="circle50"></div>
                <#elseif memberMap.perFect?default(20)==75>
                    <div class="circle75"><span></span></div>
                <#elseif memberMap.perFect?default(20)==100>
                    <div class="circle100"></div>
                </#if>
                    <div class="circleProgress"></div>
                </div>
                <div class="member-deader-img">
                <img src="<#if memberMap.head_portrait?exists && memberMap.head_portrait?has_content><#if !memberMap.head_portrait?starts_with('http:')>${ui1}</#if>${memberMap.head_portrait?default('')}<#else>${ui1}/static/image/temp/20160127/73569e0fe07f5e60234179baddec94eb.jpg</#if>" alt=""/>
                </div>
                <p class="mb-index-num">资料完善度：<span>${memberMap.perFect?default(20)}%</span></p>
                <a href="${base}/member/memberCenter!toEditBaseMemberCenter.action" class="now-btn">立即完善</a>
            </div>
            <div class="mb-index-part">
            <#if memberMap.source?default(0)!=0&&memberMap.source?default(0)!=1&&memberMap.source?default(0)!=2&&memberMap.source?default(0)!=3&&memberMap.source?default(0)!=4>
                <#if memberMap.save?default(1)==1>
                <div class="mb-save">
                    <b class="mb-save-ico save-low"></b>
                </div>
                <p class="mb-index-num yellow-color">账号安全度：<span>低</span></p>
                <#elseif memberMap.save?default(1)==2>
                <div class="mb-save">
                    <b class="mb-save-ico save-center"></b>
                </div>
                <p class="mb-index-num yellow-color">账号安全度：<span>中</span></p>
                <#elseif memberMap.save?default(1)==3>
                <div class="mb-save">
                    <b class="mb-save-ico save-height"></b>
                </div>
                <p class="mb-index-num yellow-color">账号安全度：<span>高</span></p>
                </#if>
                <#if memberMap.save?default(1)!=3>
                <a href="${base}/member/memberCenter!toAccountSecurity.action" class="now-btn">安全提升</a>
                </#if>
              <#else>
              <div class="mb-save">
                    <b class="mb-save-ico save-height"></b>
                </div>
                <p class="mb-index-num yellow-color">账号安全度：<span>高</span></p>
              </#if>  
            </div>
            <div class="mb-index-select">
                <ul class="mb-index-select-list">
                    <li>
                    <#if memberMap.gradeName?default('')=='普卡会员'>
                    <b class="mb-grade01"></b>
                    <#elseif memberMap.gradeName?default('')=='银卡会员'>
                    <b class="mb-grade02"></b>
                    <#elseif memberMap.gradeName?default('')=='金卡会员'>
                    <b class="mb-grade03"></b>
                    <#elseif memberMap.gradeName?default('')=='白金卡会员'>
                    <b class="mb-grade04"></b>
                    <#elseif memberMap.gradeName?default('')=='钻石卡会员'>
                    <b class="mb-grade05"></b>
                    <#elseif memberMap.gradeName?default('')=='员工卡会员'>
                    <b class="mb-grade06"></b>
                    <#elseif memberMap.gradeName?default('')=='集团卡会员'>
                    <b class="mb-grade07"></b>
                    <#else>
                    <b class="mb-grade01"></b>
                    </#if>
                    ${memberMap.gradeName?default('')}</li>
                    <#if memberMap.source?default(0)!=0&&memberMap.source?default(0)!=1&&memberMap.source?default(0)!=2&&memberMap.source?default(0)!=3&&memberMap.source?default(0)!=4>
                    <li><#if memberMap.is_mobile_check?default(0)==1><b class="yet-iphone"></b><a href="javascript:void(0);" >已绑定手机</a><#else><b class="bind-iphone"></b><a href="${base}/member/memberCenter!toMobileBindValidate.action" class="bind-index">绑定手机</a></#if></li>
                    <li><#if memberMap.is_email_check?default(0)==1><b class="yet-email"></b><a href="javascript:void(0);" >已绑定邮箱</a><#else><b class="bind-email"></b><a href="${base}/member/memberCenter!toEmailBindValidate.action" class="bind-index">绑定邮箱</a></#if></li>
              		</#if>
                </ul>
                <#if memberMap.source?default(0)!=0&&memberMap.source?default(0)!=1&&memberMap.source?default(0)!=2&&memberMap.source?default(0)!=3&&memberMap.source?default(0)!=4>
                 <#if memberMap.save?default(1)!=3>
               <div class="ts-save">
                   <p>您的账号存在安全风险，<br/>立即 <a href="${base}/member/memberCenter!toAccountSecurity.action">提升账号安全度</a></p>
               </div>
               </#if>
               </#if>
            </div>
            <div class="mb-index-integral">
                <p>我的积分：　<span class="num-color01"><b>${memberMap.integral?default(0)}</b>分</span></p>
                <p>我的优惠券：<span class="num-color02"><b>${memberMap.copCount?default(0)}</b>张</span></p>
            </div>
        </div>
        <!-- 个人中心头像资料结束-->
        <form name="form1" id="form1"  action="${base}/member/center!getOrderList.action" method="post">
	     	<input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(1)}" id="p_curPage">
			<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(10)}" id="pageSize">
			<input type="hidden" name="orderType" value="${orderType?default(-1)}" id="orderType">
		</form>
        <!--我的订单开始-->
        <div class="member-my-order">
            <div class="personal-data">
                <ul class="data-nav order-info">
                    <li><a href="javascript:void(0);"  onclick="selectOrderList(-1);"><span>全部订单</span></a></li>
                    <li><a href="javascript:void(0);"  onclick="selectOrderList(1);"><span>待支付订单</span><#if countMap.payCount?default(0)!=0><b>${countMap.payCount?default(0)}</b></#if></a></li>
                    <li><a href="javascript:void(0);"  onclick="selectOrderList(2);"><span>待收货订单</span><#if countMap.deliveCount?default(0)!=0><b>${countMap.deliveCount?default(0)}</b></#if></a></li>
                    <li><a href="javascript:void(0);"  onclick="selectOrderList(3);"><span>待评价订单</span><#if countMap.revCount?default(0)!=0><b>${countMap.revCount?default(0)}</b></#if></a></li>
                </ul>
                <div class="data-line order-line"></div>
            </div>
            
            <#if countMap.payCount?default(0)!=0>
            <div class="mb-index-box">
            <#list orderList?if_exists as resc>
                <ul class="mb-index-box-list">
                    <li class="li01">订单号：<br/>${resc.order_sn?default('')}</li>
                    <li class="li02">
                    <#if resc.orderitem?exists>
						                
                    </#if>
            	<#list resc.orderitem?if_exists as items>
            		<#if items_index &lt; 3>  
                       <a class="li02-img" target="_blank" href="${base}/p/${items.goods_id?default()}.html"> <img src="${ui1}${items.abbreviation_picture?default('')}" alt="${items.short_name?default('')}"/></a>
                   </#if>     
                 </#list>
                	 <#if resc.orderitem.size() &gt;3>
                        <b></b>
                        <b></b>
                        <b></b>
                        <a class="show-all" href="${base}/member/order!detail.action?id=${resc.id?default(0)}">显示全部</a>
                    </#if>    
                    </li>
                    <li class="li03">${resc.receiver?default('')} <br/>${resc.phone?default('')}</li>
                    <li class="li04">${resc.order_amount?string('0.00')}<br/><#if resc.shipping_fee?default(0)!=0>（包含运费¥${resc.shipping_fee?string('0.00')}）</#if></li>
                    <li class="li05">
                        <a href="${base}/member/order!orderSumbitSuccess.action?orderId=${resc.id?default('')}" class="li05-pay">支付</a>
                        <a href="${base}/member/order!detail.action?id=${resc.id?default(0)}" class="li05-look">查看详情</a>
                    </li>
                </ul>
              </#list>  
            </div>
            <#else>
              <div class="mb-index-box-no-order">
                <p>对不起，您当前暂无订单！</p>
            </div>
            </#if>
        </div>
        <!-- 我的订单结束-->
<!-- 左右滚动部分 begin -->
        <div class="relevant-product w1000" style="margin-top: 16px;width: 1000px;">
            <h2 class="shopping-cart-title clearfix clear">
                <span>推荐商品</span>
            </h2>
            <div class="scroll" style="width: 998px;">
            <div class="picbox">
                <ul class="piclist mainlist">
                </ul>
                <ul class="piclist swaplist"></ul>
            </div>
            <div class="og_prev"></div>
            <div class="og_next"></div>
        </div>
    </div>
    <!-- 左右滚动部分 end -->
    </div>
    <!-- 右侧内容结束-->
</div>
<!--内容结束-->
    <div class="user_center_footer" style="float:left; "><#include "/static/inc/version2.2.0/footer.ftl"></div>
<style>.autocomplete_ui {width:170px;}.autocomplete_ui span {width:165px;}</style>
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
</script>
</html>