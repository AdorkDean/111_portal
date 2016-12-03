<!DOCTYPE html>
<html>
<head>
 <#include "/WEB-INF/pages/inc/taglibs.ftl">
    <meta charset="UTF-8">
    <title>我的收藏</title>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>

<form id="inputForm" name="form1" action="${base}/member/collect.action" method="post" >
<input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(0)}" id="p_curPage">
<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(10)}" id="pageSize">	
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content collect">
            <h2>我的收藏</h2>
            <!-- 收藏列表开始-->
            <div class="collect-list">
            	<div class="member-refund-line"></div>
            	<div class="info" id="choose-info">
	            	<a href="${base}/member/collect.action?type=1" <#if type == "1">class="current goodsSapn" </#if>>商品（${goodsCount?default(0)}）</a>
	            	<a href="${base}/member/collect.action?type=2" <#if type != "1">class="current brandSpan" </#if>>品牌（${brandCount?default(0)}）</a>
	            	<input type="hidden" name="type" value="${type?default('')}"/>
	            </div>
	             <#if pw.pageInfo.count?default(0)!=0>
            	<#if type == "1" && pw.result?has_content>
                <table width="970" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td align="center" valign="middle" width="130" height="36">商品图片</td>
                        <td align="center" valign="middle" width="300" height="36">名称</td>
                        <td align="center" valign="middle" width="300" height="36">编号</td>
                        <td align="center" valign="middle" width="120" height="36">销售价（元）</td>
                        <td align="center" valign="middle" width="120" height="36">操作</td>
                    </tr>
                    <#list pw.result?if_exists as resc>
                     <tr>
                        <td align="center" valign="middle" height="72"><a href="${base}/p/${resc.relevance_id?default()}.html" target="_bank"><img src="${ui1}${resc.abbreviation_picture?default('')}" style="width:60px;height:60px;"/></a></td>
                        <td align="center" valign="middle" height="72"><a href="${base}/p/${resc.relevance_id?default()}.html" target="_bank">${resc.goods_name?default('')}</a></td>
                        <td align="center" valign="middle" height="72" class="cor"><a href="${base}/p/${resc.relevance_id?default()}.html" target="_bank">${resc.sku_id?default('')}</a></td>
                        <td align="center" valign="middle" height="72">${currency(resc.pc_price?default('0'))}</td>
                        <td align="center" valign="middle" height="72">
                        <#if resc.type?default(1)==2||resc.type?default(1)==3>
                        <a style="display:inline-block; color:#3c94e7; width:70px; height:20px; text-align:left; line-height:20px;" href="${base}/p/${resc.relevance_id?default()}.html" target="_bank">立即预订</a>
                        <#else>
                        <input onclick="add3(${resc.goodsid?default('')},this)" type="button" value="加入购物车" class="btn1" val="goods"/>
                        </#if>
                        <input type="button" value="取消收藏" class="btn2 cancelCollect" val="${resc.id?default('')}" val_type="goods"/></td>
                    </tr>
                    </#list>
                </table>
                </#if>
                
                <#if type != "1" && pw.result?has_content>
                <table width="970" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                    	<td align="center" valign="middle" height="36">名称</td>
                        <td align="center" valign="middle" height="36">品牌LOGO</td>
                        <td align="center" valign="middle" height="36">品牌网址</td>
                        <td align="center" valign="middle" height="36">操作</td>
                    </tr>
                    <#list pw.result?if_exists as resc>
                    <tr>
                    	<td align="center" valign="middle" height="72"><a href="${base}/${resc.relevance_id?default()}/blist.html" target="_bank">${resc.brand_name?default('')}</a></td>
                    	<td align="center" valign="middle" height="72"><a href="${base}/${resc.relevance_id?default()}/blist.html" target="_bank"><img style="max-height:70px;max-width:160px;"src="${ui1}${resc.logo?default('')}"/></a></td>
                        <td align="center" valign="middle" height="72"><a href="${resc.brand_url?default('')}" target="_bank">${resc.brand_url?default('')}</a></td>
                        <td align="center" valign="middle" height="72"><input type="button" value="取消收藏" class="btn2 cancelCollect" val="${resc.id?default('')}" val_type="brand"/></td>
                    </tr>
                    </#list>
                </table>
                </#if>
                
                
                
                 <#else>
                 <div class="mb-index-box-no-order" style="height: 210px;border: 1px solid #d7d7d7; line-height: 210px; text-align: center; margin:10px 0;">
		            <p>对不起，您当前暂无收藏！</p>
		        </div>
		        </#if>
            </div>
            <!-- 收藏列表结束-->
            <#if pw.pageInfo.count?default(0)!=0>
            <!--分页开始-->
            <#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
            <!--分页结束-->
            </#if>
        </div>
    </div>
    <div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl">
    <style>.autocomplete_ui {width:170px;}.autocomplete_ui span {width:165px;}</style>
    </div>
</div>
</form>
</body>
</html>
<script type="text/javascript">
$().ready(function() {
	
	var goodsCount = ${goodsCount?default(0)};
	var brandCount = ${brandCount?default(0)};
	
	$(".cancelCollect").click(function(){
		var def = $(this);
		$.ajax({
	        type: "post",
	        cache: false,
	        dataType:"json",
	        url: "${base}/member/collect!cancel.action",
	        data: {
	        	id:$(this).attr("val")
	        },	            
	        success: function(data, textStatus){
	        	if(data>0){
	        		$alert("success","取消成功！","友情提示",null);
	        		if(def.attr("val_type") == "goods"){
	        			goodsCount -- ;
	        			$(".goodsSapn").html("商品（"+goodsCount+"）")
	        		}
	        		
	        		if(def.attr("val_type") == "brand"){
	        			brandCount -- ;
	        			$(".brandSpan").html("商品（"+brandCount+"）")
	        		}
	        		def.parent().parent().remove();
	        	}else{
	        		$alert("warn","取消失败！","友情提示",null);
	        	}
	        }
	    });
	});
   
});

</script>