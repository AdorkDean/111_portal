
<#assign works_img = "/static/image/works/"/> <!--图片path-->
<#assign artist_img = "/static/image/artist/"/> <!--图片path-->
<#assign gallery_img = "/static/image/gallery/"/> <!--图片path-->
<#assign imgurl = "/"/> <!--图片path-->
<#assign ui1 = "http://img.zdfei.com"/> <!--图片path-->
<script type="text/javascript">
var jsCtx = "${base}";
var jsurl = "${ui1}";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<META HTTP-EQUIV="pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
<META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT">

<!--定义一个宏，用于遍历opensql结果里的List-->
<#macro mylist map keyname>
		<#list map?keys as key>
			<#if key==keyname>	
				<#assign name=map[key]?default("")>
				${name?default("")}
			 </#if>
	     </#list>
</#macro>

<#function getMapValue mymap keyname>
		<#list mymap?keys as key>
			<#if key==keyname>	
				<#assign name=mymap[key]?default(0)>
				<#return name?default("")>
			 </#if>
	     </#list>
</#function>
