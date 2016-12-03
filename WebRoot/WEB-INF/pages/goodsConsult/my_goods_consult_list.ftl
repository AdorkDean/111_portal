<!DOCTYPE html>
<html>
<#include "/WEB-INF/pages/inc/taglibs.ftl">
<head>
    <meta charset="utf-8">
    <title>我的咨询</title>
    
    <style type="text/css">
		.shopping-cart-title h2{
			padding: 0;
			height: 32px;
		}
		.page-box{
			float:right;
		}
</style>
    
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<script type="text/javascript" src="${base}/web/js/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/shopping.css">
    
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        
        <!------右侧-------->
        <div class="member-content">
            <h2>我的咨询</h2>
            <form name="form1" id="subform"  method="post" action="${base}/member/consult!myGoodsConsultPage.action">
             <input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(1)}" id="p_curPage">
				<input type="hidden" name="rs.p_pageSize" value="5" id="pageSize">
            <div class="member-main">
                <div class="member-main-text">
                	<#if pw.result?exists && pw.result?size gt 0>
	                	<#list pw.result as tGoodsConsult>
		                    <div class="question <#if (pw.pageInfo.pageSize*(pw.pageInfo.page-1)+1+tGoodsConsult_index)=pw.pageInfo.end>last</#if>">
		                        <ul>
		                            <li style="height:100%;">咨询内容：${tGoodsConsult.consultContent?if_exists}</li>
		                            <li class="answer" style="height:100%;">药师回复：${tGoodsConsult.answer?if_exists}</li>
		                        </ul>
		                    </div>
	                    </#list>
	                    <#else>
	                    <div class="text"><p>暂无咨询记录</p></div>
                    </#if>
                </div>
            </div>
            </form>
            
            <!--分页开始-->
            <#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
            <!--分页结束-->
            <!-- 商品列表开始 -->
            <div class="relevant-product w1000" style="margin-top:10px;">
	            <h2 class="shopping-cart-title clearfix clear" style="padding-left:0px;height:49px;width:1000px;">
	                <span>推荐商品</span>
	            </h2>
	            <div class="scroll">
	            <div class="picbox">
	                <ul class="piclist mainlist">
	                </ul>
	                <ul class="piclist swaplist"></ul>
	            </div>
	            <div class="og_prev"></div>
	            <div class="og_next"></div>
	        </div>
            
            <!-- 商品列表结束 -->
        </div>
    </div>
    
<div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
<script type="text/javascript" src="${base}/web/js/goods-recommend_cart.js"></script>
<script type="text/javascript" src="${base}/web/version2.2.0/js/shopping.js"></script>
    
</div>


</body>
</html>