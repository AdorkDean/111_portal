<link rel="stylesheet" type="text/css" href="/web/css/jq-alert-confirm.css">
<link rel="stylesheet" type="text/css" href="/web/version2.2.0/css/jquery-ui-1.10.4.custom.min.css">
<link rel="stylesheet" type="text/css" href="/web/version2.2.0/css/common.css">
<link rel="stylesheet" type="text/css" href="/web/version2.2.0/css/health.css">
<script type="text/javascript" src="/web/version2.2.0/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/web/version2.2.0/js/global.js"></script>
<script type="text/javascript" src="/web/js/cookieUtil.js"></script>
<script type="text/javascript" src="/web/js/cart.js"></script>
<script type="text/javascript" src="/web/js/jq-alert-confirm.js"></script>
<script type="text/javascript" src="/web/version2.2.0/js/jquery-ui-1.10.4.custom.min.js"></script>
<div class="health-header-wrap">
    <div class="health-header w1000 clearfix">
        <div class="health-header-name"><span>健康领秀</span>
        	<b id="leader_center_welcome">
        	<#if tleader?exists>
	        	<#if tleader.nickName?exists>
		        	<#if tleader.nickName != ''>
		        	${tleader.nickName?default('')}
		        	<#else>
		        	<#if tleader.realName?exists>
			        	<#if tleader.realName != ''>
			        		${tleader.realName?default('')}
			        		<#else>
			        		<#if tleader.phone?exists>
				        		<#if tleader.phone != ''>
				        		${tleader.phone?default('')}
				        		<#else>
				        		</#if>
			        		</#if>
			        	</#if>
		        	</#if>
		        	</#if>
	        	</#if>
        	</#if>
        	</b>
        	<a href="/">［返回医药馆］</a>
        	<a href="/login/login!logout.action" onmouseover="this.style.color='#00c9f4';" onmouseleave="this.style.color='#666666';">［退出］</a>
        </div>
        <ul class="health-header-list clearfix" id="leader_navicator">
            <li><a href="/leaderarticle/leaderarticle!index.action">领秀中心</a></li>
            <li><a href="/leaderarticle/leaderarticle!pcRecommendArticleList.action">我的文章</a></li>
            <li><a href="/leaderarticle/leaderarticle!leaderPharmacy.action">我的药房</a></li>
            <li><a href="/leaderarticle/leaderarticle!myLeaderFans.action">管理中心</a></li>
        </ul>
    </div>
</div>