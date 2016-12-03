<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
 <#include "/WEB-INF/pages/inc/taglibs.ftl">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="">
    <!-- keywords -->
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>商品评论</title>
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
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
	<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
	<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
	<script type="text/javascript" src="${base}/web/js/jquery.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css">
	<script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
	
	<script type="text/javascript" src="${base}/web/js/goods_comment_add.js"></script>

<div class="member-line">
        <!-------左侧菜单栏------->
    <div class="member-wrap">
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <div class="member-discuss w1210">
        	<h2>商品评价</h2>
            <div class="discuss-box">
            
            	<div class="discuss-title clearfix clear">
                    <span class="w50-p" style=" text-align:left; text-indent:150px">商品信息</span>
                    <span class="w25-p">购买时间</span>
                    <span class="w25-p">操作</span>
                </div>
                <input value="${tOrder.id?if_exists}" type="hidden" name="orderId"/>
                <#if list?exists> 
                <ul class="dis-list">
                	<#list list as map>
                	<li class="">
                    	<div class="dis-all clearfix clear">
                            <div class="dis-product w50-p">
                                <dl class="dis-info clearfix clear">
                                    <dt>
                                    	<#if map?exists && map.goods_id?exists>
                                    		<a target="_blank" href="${base}/p/${map.goods_id?default()}.html"><img src="${ui1?if_exists}/${map.abbreviation_picture?if_exists}"></a>
                                    		<#else>
                                    		<img src="${ui1?if_exists}/${map.abbreviation_picture?if_exists}">
                                    	</#if>
                                    </dt>
                                    <dd style="width:275px;">
                                    	<#if map?exists && map.goods_id?exists>
                                    		<a target="_blank" href="${base}/p/${map.goods_id?default()}.html">${map.goods_name?if_exists}</a>
                                    		<#else>
                                    		${map.goods_name?if_exists}
                                    	</#if>
                                    </dd>
                                </dl>
                            </div>
                            <div class="dis-time w25-p">${map.create_time?if_exists?string("yyyy-MM-dd HH:mm:ss")}</div>
                            <div class="dis-operate w25-p"><a id="if_${map.id?if_exists}" href="javascript:void(0)" class="show-dis"><#if map.if_reviews?exists && map.if_reviews==0><span style="color:#e37070;">发表评价</span><#else><span>已评论</span></#if></a></div>
                        </div>
                        <#if map.if_reviews?exists && map.if_reviews==0>
	                        <form id="subForm_${map.id?if_exists}" >
	                        <div class="dis-input-box" style="display:<#if map_index==0>block<#else>none</#if>;">
	                        	<b class="dis-corner"></b>
	                            <dl class="dis-text clearfix clear">
	                            	<dt>商品评分：</dt>
	                                <dd style="width:700px;">
	                                	<span class="star-bg">
	                                    	<a href="javascript:void(0)" class="star1"></a>
	                                        <a href="javascript:void(0)" class="star2"></a>
	                                        <a href="javascript:void(0)" class="star3"></a>
	                                        <a href="javascript:void(0)" class="star4"></a>
	                                        <a href="javascript:void(0)" class="star5"></a>
	                                    </span>
	                                    <input type="hidden" name="goods"/>
	                                </dd>
	                            </dl>
	                            <dl class="dis-text clearfix clear">
	                            	<dt>卖家评分：</dt>
	                                <dd style="width:700px;">
	                                	<span class="star-bg">
	                                    	<a href="javascript:void(0)" class="star1"></a>
	                                        <a href="javascript:void(0)" class="star2"></a>
	                                        <a href="javascript:void(0)" class="star3"></a>
	                                        <a href="javascript:void(0)" class="star4"></a>
	                                        <a href="javascript:void(0)" class="star5"></a>
	                                    </span>
	                                    <input type="hidden" name="seller"/>
	                                </dd>
	                            </dl>
	                            <dl class="dis-text clearfix clear">
	                            	<dt>快递评分：</dt>
	                                <dd style="width:700px;">
	                                	<span class="star-bg">
	                                    	<a href="javascript:void(0)" class="star1"></a>
	                                        <a href="javascript:void(0)" class="star2"></a>
	                                        <a href="javascript:void(0)" class="star3"></a>
	                                        <a href="javascript:void(0)" class="star4"></a>
	                                        <a href="javascript:void(0)" class="star5"></a>
	                                    </span>
	                                    <input type="hidden" name="fastMail"/>
	                                </dd>
	                            </dl>
	                            <dl class="dis-text clearfix clear">
	                            	<dt>快递员评分：</dt>
	                                <dd style="width:700px;">
	                                	<span class="star-bg">
	                                    	<a href="javascript:void(0)" class="star1"></a>
	                                        <a href="javascript:void(0)" class="star2"></a>
	                                        <a href="javascript:void(0)" class="star3"></a>
	                                        <a href="javascript:void(0)" class="star4"></a>
	                                        <a href="javascript:void(0)" class="star5"></a>
	                                    </span>
	                                    <input type="hidden" id="fastMailPeople" name="fastMailPeople"/>
	                                </dd>
	                            </dl>
	                            <dl class="dis-text clearfix clear">
	                            	<dt>心得：</dt>
	                                <dd>
	                                	<div class="dis-area">
	                                    	<textarea name="comment" maxlength="400" onkeyup="checkLen(this)"></textarea>
	                                    	<span class="refund-tips">还可以输入<span id="leaveCount" style="color:red;"></span>字（最多400字）</span>
	                                    </div>
	                                    <div class="dis-submit-btn clearfix clear">
	                                    	<a href="javascript:void(0)" onclick="saveComment(${map.id?if_exists})">评价</a>
	                                        <div class="nm fr">
	                                            <!--<input name="anonymous" onclick="checkedAnonymous(${map.id?if_exists})" type="checkbox" value="" checked="checked">
	                                            <label for="nm-ipt">匿名评价</label>-->
	                                        </div>
	                                    </div>
	                                </dd>
	                            </dl>
	                        </div>
	                        </form>
                        </#if>
                    </li>
                </#list>
                </ul>
                <#else>
                <!--暂无-->
                <div class="none-dis">
                     	暂无商品需要评价
                </div>
                </#if>
            </div>
            
        </div>
        				<!--分页开始-->
        					<#include "/WEB-INF/pages/inc/pagination.ftl">
        				<!--分页结束-->
    </div>
<div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
</div>
</body>
</html>
<script type="text/javascript">

</script>