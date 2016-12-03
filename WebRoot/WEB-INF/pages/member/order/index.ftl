<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单中心</title>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
    <script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${base}/web/js/member.js"></script>
    <!--[if IE 6]>
    <script src="js/png.js"></script>
    <script>
        PNG.fix('*');
    </script>
    <![endif]-->
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content">
            <div class="member-con-center">
                <div class="member-center-top">
                    <div class="center-top-head">
                        <div class="head-img"><img style="width:76px;height:76px;" src="<#if member.headPortrait?exists && member.headPortrait?has_content><#if !member.headPortrait?starts_with('http:')>${ui1}</#if>${member.headPortrait?default('')}<#else>${ui1}/static/image/temp/20151014/b09e2b114b6779b8fe47bcd8d38fe48a.png</#if>" alt=""/></div>
                        <div class="head-settings"><a href="${base}/member/profile!headPortrait.action"><img src="${base}/web/images/member-center/member-settings.png" alt=""/></a></div>
                    </div>
                    <div class="center-top-txt">
                        <h3><#if nickname?exists && nickname?has_content>${nickname}<#else>${member.userName}</#if>，<b>欢迎您！</b></h3>
                        <ul>
                            <li>我的等级：<i>${currentGrade.name}</i></li>
                            <li class="icon">壹贝：<i>${account.remainingAmount}个</i></li>
                        </ul>
                    </div>
                    <div class="center-top-card">
                        <div class="card"></div>
                        <div class="integral">
                            <div class="num"><em id="member_point">${member.integral?default(0)}</em><b>积分</b></div>
                            <div class="txt">
                                <ul>
                                    <li>
                                        <p>积分可兑换优惠券 </p>
                                        <a href="${base}/member/point!rule.action">获取积分</a>
                                    </li>
                                    <li>
                                        <p>距离下一等级还差<b><#if (nextGrade.consumePrice?default(0) - member.accumulateIntegral?default(0))<=0>0<#else>${nextGrade.consumePrice?default(0) - member.accumulateIntegral?default(0)}</#if></b>积分</p>
                                        <div class="bar gradient stripe color3"><span></span></div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="member-center-order">
                    <ul>
                        <li class="li01"><a href="${base}/member/order!list.action?type=3"><strong>${unconfirmCount?default(0)}<i>个</i></strong><b class="icon01">待收货订单</b></a></li>
                        <li class="li02"><a href="${base}/member/order!list.action?type=2"><strong>${unpaidCount?default(0)}<i>个</i></strong><b class="icon02">待支付订单</b></a></li>
                        <li class="li03"><a href="${base}/member/order!list.action?type=4"><strong>${toEvaluateCount?default(0)}<i>个</i></strong><b class="icon03">待评价订单</b></a></li>
                        <li class="li04"><a href="${base}/member/coupon.action"><strong>${couponCardUseCount?default(0)}<i>张</i></strong><b>优惠券</b></a></li>
                        <li class="li05">
                            <a href="${base}/member/collect.action"><strong>${memberCollectCount?default(0)}<i>个</i></strong><b class="icon04">我的收藏</b></a>
                            <a href="${base}/member/consult!myGoodsConsultPage.action" class="color"><strong>${memberConsultCount?default(0)}<i>条</i></strong><b class="icon05">提问回复</b></a>
                        </li>
                    </ul>
                </div>
            </div>
            
            <!-- 商品列表-->
            <div class="recommond-title" style="height:30px; line-height:30px; padding-left:22px;"><span style="font-size:18px; font-weight:bold;">热门推荐</span></div>
            <div id ="recommond-pro-id">
            
            </div>
            <!-- 商品列表-->
        </div>
    </div>
</div>
    <div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
</body>
</html>
<script type="text/javascript" src="${base}/web/js/goods-recommend.js"></script>
<script type="text/javascript" >
$(document).ready( function() {
    var delay = 0;
    $('.bar').children('span').each( function() {
    	<#if (nextGrade.consumePrice?default(0) - member.accumulateIntegral?default(0))<=0>
		var num = 1;
		<#else>
		var num = ${member.accumulateIntegral?default(0)}/<#if nextGrade?has_content >${nextGrade.consumePrice}<#else>${member.accumulateIntegral?default(0)}</#if>;
		</#if>        
        $(this)
            .width(0)
            .delay(delay)
            .animate({
                'width': (num*100)+'%'
            }, 3000);
        delay += 1500;
    });
   
});
</script>
<script type="text/javascript">
$().ready(function() {
//异步刷新会员积分
$.ajax({
	url : "${base}/member/profile!ajaxMemberInfo.action",
	type : "post",
	datatype:"json",
	success : function(data) {
		if (data != null) { 
		     $("#member_point").html(data.integral);
		}
	},
	error : function() {}
});

});      
</script>