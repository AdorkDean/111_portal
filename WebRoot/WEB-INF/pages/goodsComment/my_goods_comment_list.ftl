<!DOCTYPE html>
<html>
<#include "/WEB-INF/pages/inc/taglibs.ftl">
<head>
    <meta charset="UTF-8">
    <title>我的评论</title>
    
    
    <style type="text/css">
		.page-box{
			float:right;
		}
	</style>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/myGoodsComment.css"/>
<script type="text/javascript" src="${base}/web/js/jquery.min.js"></script>
<script type="text/javascript" src="${base}/web/js/goods_comment_list.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/shopping.css">

<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单栏------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        
        <!------右侧-------->
        <form name="form1" id="subform"  action="${base}/member/comment!myGoodsCommentPage.action" method="post">
        <div class="member-content">
            <h2>我的评价</h2>
            <div class="member-main">
            	<div class="member-refund-line line-mar"></div>
                <div class="info" id="choose-info"><span class="current" id="allComment">全部评价（${ttNum?if_exists}）</span><span id="bestComment">好评（${bestNum?if_exists}）</span><span id="betterComment">中评（${betterNum?if_exists})</span><span id="poorComment">差评（${poorNum?if_exists})</span><!--<span>有图片的评论（90)</span>--></div>
                <div class="list" id="choose-list">
                <input type="hidden" id="_type" value="${type?if_exists}"/>
                <input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(1)}" id="p_curPage">
				<input type="hidden" name="rs.p_pageSize" value="5" id="pageSize">
                    <div class="list-con current">
                    	<input type="hidden" name="type" value="${type?if_exists}"/>
                        <table width="990" border="0" cellpadding="0" cellspacing="0">
                            <tr class="td-bold">
                                <td align="center" valign="middle" height="36" width="510" width="470">评价心得</td>
                                <td valign="middle" height="36" width="160" >满意度</td>
                                <td valign="middle" height="36" width="340" >购买信息</td>
                            </tr>
							<#if pw.result?exists && pw.result?size gt 0>
								<#list pw.result as tGoodsComment>
									<tr>
										<td style="word-break: break-all;line-height: 22px;" valign="middle" class="tab-td" width="40%">
											<p style="height:100%;">
												<b>${tGoodsComment.comment?if_exists}</b>
												<b style="float: right">
													<#if tGoodsComment.createTime?exists>${tGoodsComment.createTime?if_exists?string("yyyy-MM-dd HH:mm:ss")}</#if>
												</b>
											</p>
											<!--<div class="pic">
												<div class="pic-img"><img src="img/member-img01.jpg" alt=""/></div>
												<div class="pic-img"><img src="img/member-img01.jpg" alt=""/></div>
												<b>共2张图片</b>
											</div>-->
											<!--<p><b>回复（19）</b><b>赞（7）</b></p>-->
										</td>
										<td valign="middle" width="30%">
												<p style="color:#FFB200;" class="start-bg" style="width:-75px">
													<#if tGoodsComment?exists && tGoodsComment.sumFraction?exists>
														
														<span style="padding-left: 0;width: 10;" class="start start${(tGoodsComment.sumFraction/4)?int}"></span>
													<#else>
														<span class="start start1"></span>
													</#if>
												</p>
										</td>
										<td valign="middle" height="76" width="30%">
											<p title="${tGoodsComment.goodsName?if_exists}">
												<#if tGoodsComment?exists && tGoodsComment.goodsName?exists && tGoodsComment.goodsName?length lt 20>
													${tGoodsComment.goodsName?if_exists}
												<#else>${tGoodsComment.goodsName[0..19]}...
												</#if>
											</p>
											<p title="${tGoodsComment.spec?if_exists}">${tGoodsComment.spec?if_exists}</p>
										</td>
									</tr>
	                            </#list>
                            <#else>
                            	<tr>
									<td  colspan="3" valign="middle" height="76" class="tab-td" width="470">
										<div class="text"><p>暂无评论记录</p></div>
									</td>
								</tr>
                            </#if>
                        </table>
                    </div>
                </div>
            </div>
			</form>
            <!--分页开始-->
			<#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
            <!--分页结束-->
            <!-- 商品列表开始 -->
            <#--<div class="filter-tag-info" >
            	<ul class="filter-product-list clearfix clear" id="recommond-pro-id"></ul>
            </div>-->
            
            
            
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
</div>

<script type="text/javascript" src="${base}/web/js/goods-recommend_cart.js"></script>
<script type="text/javascript" src="${base}/web/version2.2.0/js/shopping.js"></script>

</body>
</html>