<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<#include "/WEB-INF/pages/inc/taglibs.ftl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>商品评论管理</title>

</head>
<body style="margin:0 3px" >
<!-- 顶部分页查询区域 Start -->

<div>商品单品页的商品评论:<div/>
<table>
	<tr>
		<td>评价心得</td>
		<td>顾客满意度(总评分)</td>
		<td>购买信息</td>
		<td>评论者</td>
	</tr>
	<#list pw.result as tGoodsComment>
		<tr>
			<td><input type="hidden" value="${tGoodsComment.id?if_exists}"/>${tGoodsComment.comment?if_exists}</td>
			<td>${tGoodsComment.sumFraction?if_exists}</td>
			<td>${tGoodsComment.goodsName?if_exists}</td>
			<td>${tGoodsComment.memberId?if_exists}</td>
		</tr>
	</#list>
	
</table>
	${pw.pageInfo.pages}

</body>
</html>
