<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="111医药馆网上药店是国家药监局认证指定网上药房|打造为老百姓服务药品价格低品种全|网上购药买药就选壹壹壹医药馆药品特卖网站">
    <meta name="keywords" content="壹壹壹医药馆|壹药馆|11医药馆|1药馆|医卡通|111医药馆|医药网|药品特卖网站">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>管理中心</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="images/common/favicon.png">
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/common/favicon.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="images/common/favicon.png">
    <meta name="msapplication-TileImage" content="images/common/favicon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
</head>
<body class="health-bc">
<#include "/static/inc/version2.2.0/new_leader_header.ftl" />
<script>$("#leader_navicator li").eq(3).addClass("cur");</script>
<form name="form1" id="form1"  action="/leaderarticle/leaderarticle!myLeaderFans.action" method="POST">
        <input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(0)}" id="p_curPage">
		<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(10)}" id="pageSize">
		<input type="hidden" name="orderby" id="orderby" value="${orderby}"/>
</form>
<!--提现开始-->
<div class="my-pharmacy-page w1000" style="margin-top:25px;padding-bottom:20px;">
    <div class="personal-data">
        <ul class="data-nav">
            <li class="current"><a href="/leaderarticle/leaderarticle!myLeaderFans.action"><span>我的秀粉</span></a></li>
            <li><a href="/member/bindingAmount!presentRecordList.action"><span>提现记录</span></a></li>
            <li><a href="/member/bindingAmount!proceedsDetailList.action"><span>收益明细</span></a></li>
            <li><a href="/leaderarticle/leaderarticle!leaderIdentity.action"><span>身份认证</span></a></li>
            <li><a href="/leaderarticle/leaderarticle!leaderFunctionIntroduce.action"><span>特色功能</span></a></li>
        </ul>
        <div class="data-line"></div>
    </div>
    <div class="my-xf-info">
        <ul>
            <li>用户名</li>
            <li>成为秀粉日期</li>
            <li onclick="sortOrderDown(1)">下单次数 <b id="order_down_sum" class="<#if orderby == ''>up</#if><#if orderby == '1'>down</#if>"></b></li>
            <li onclick="sortOrderDown(2)">累积收入(壹贝) <b class="<#if orderby == ''>up</#if><#if orderby == '2'>down</#if>"></b></li>
        </ul>
    </div>
    <p class="xf-number">秀粉总人数：
    <#if size?exists>
    	${size?default(0)}
    </#if>
    </p>
    
    <#if pw.result?size != 0>
    <ul class="xf-list">
        <#list pw.result?if_exists as resc>
        <li>
            <span class="xf-list-img"><img src="${resc.head_portrait?default('http://img.zdfei.com/static/image/temp/20160127/73569e0fe07f5e60234179baddec94eb.jpg')}" alt=""/></span>
            <span class="xf-list-text">
            <#if resc.nick_name?exists>
            	<#if resc.nick_name?length gt 6>
            	${resc.nick_name[0..5]}***
            	<#else>
            	${resc.nick_name?default('')}
            	</#if>
            </#if>
            
            </span>
            <span class="xf-list-text">${resc.register_date?default('')}</span>
            <span class="xf-list-text">${resc.order_count?default(0)}</span>
            <span class="xf-list-text">${resc.money?default(0)}</span>
        </li>
        </#list>
    </ul>
    <div class="page-box clearfix clear w1000 page-box-margin xf-page"><#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl"></div>
    </#if>
    
    <#if pw.result?size == 0>
    	<div class="health-default">
        	<p class="default-shopping">您还没有秀粉哦~~</p>
    	</div>
    </#if>
    
</div>
<!--提现结束-->
<div style="margin-top:20px;"><#include "/static/inc/version2.2.0/new_leader_footer.ftl"/></div>

<script>
	function sortOrderDown(type)
	{
		var v = $("#orderby").val();
		if(v == type)
		{
			$("#orderby").val("");
		}
		else
	    {
	    	$("#orderby").val(type);
	    }
		$("#form1").submit();
	}
</script>
</body>
</html>