<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=<#if requestCharset?has_content>${requestCharset}<#else>utf-8</#if>" />
<title></title>

</head>
<body onload="javascript: document.forms[0].submit();">
	<form action="${requestUrl}"<#if requestMethod?has_content> method="${requestMethod}"</#if><#if requestCharset?has_content> accept-charset="${requestCharset}"</#if>>
		<#list parameterMap.entrySet() as entry>
			<input type="hidden" name="${entry.key}" value="${entry.value}" />
		</#list>
		
		<#if items?exists>
			<#list items as item>
				<input type="hidden" name="mname" value="${item.goods_name?default('')}" />
				<input type="hidden" name="mspec" value="-"/>
				<input type="hidden" name="mtype" value="-"/>
				<input type="hidden" name="munit" value="-"/>
				<input type="hidden" name="mprice" value="${item.price}"/>
				<input type="hidden" name="mnum" value="${item.quantity}"/>
				<input type="hidden" name="mcode" value="${item.goodsno}"/>
			</#list>
		</#if>
	</form>
</body>
</html>