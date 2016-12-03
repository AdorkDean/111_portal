<!-- 显示分页信息 start -->
<div class="gallery-page">
<ul class="gly-page-detail">
 <#assign itemfrom = pw.pageInfo.getPage()?if_exists-1*pw.pageInfo.getPageSize()?if_exists + 1>              
        <#if (pw.pageInfo.getPage()>6)>
        <#assign pfrom = pw.pageInfo.getPage()-5>
        <#assign pto = pw.pageInfo.getPage() + 4>
         <#if (pto>pw.pageInfo.getPages())>
         <#assign pto = pw.pageInfo.getPages()>	
         </#if>
         <#else>
         <#if (pw.pageInfo.getPages()>10)>
         <#assign pfrom = 1><#assign pto = 10>
         <#else>
         <#assign pfrom = 1>
         <#assign pto = pw.pageInfo.getPages()>
         </#if>	
         </#if>	
		
<#if pw.pageInfo.page == 1>
<li><a href="#"><</a></li>
<#else>
<li><a href="#"  onclick="goPage(${pw.pageInfo.page?default(0)-1})"><</a></li>
</#if>
<#foreach p in pfrom..pto>	
	<#if p != pw.pageInfo.getPage()>	
	<li><a href="#" onclick="goPage(${p?default(0)})">${p?if_exists}</a></li>
	<#else>	  
	<li class="gly-page-dtl-active"><a href="#">${p?default(0)}</a></li>
	</#if>
</#foreach>
<#if pw.pageInfo.page == pw.pageInfo.pages> <li class="gly-page-dtl-last"><a href="#">></a></li></li>
<#else>
<li class="gly-page-dtl-last"><a href="#" onclick="goPage(${pw.pageInfo.page?default(0)+1})">></a></li>
</#if>
</ul>
</div>
 <input id="pageNext" name="pageInfo.page" type="hidden" size="2" value="${rs.p_curPage?if_exists}"/>
<input name="pageInfo.pageSize" type="hidden" value="${pw.pageInfo.pageSize?if_exists}"/>
<#if pw.pageInfo.pages?if_exists <= 0><script>
document.getElementById('page').style.display="none";
</script>
</#if><script>

//pageInputObj,输入页码的文本框对象
//pages,总页数
function goPage(pageNum)
{ 
	if( !isInts(pageNum) )
	{
		alert("请正确输入要跳转的页码！");
		document.getElementById('pageNext').value = "";
		document.getElementById('pageNext').focus();
		return;
	}
	if( pageNum>0 )
	{
		if(pageNum > ${pw.pageInfo.pages?if_exists} || pageNum < 1){
			alert("页码超出范围");
			document.getElementById('pageNext').focus();
			return;
		}else{
			document.getElementById('pageNext').value = pageNum;
			document.getElementById('p_curPage').value = pageNum;
			document.form1.submit();
		}
	}else{
		alert("请正确输入要跳转的页码！");
		document.getElementById('pageNext').value = "";
		document.getElementById('pageNext').focus();
	}
}
function isInts(str) 
{
    if (str == "")
    {
      	return false;
    }
    var r = /^[0-9]+$/;
    return r.test(str);
}
</script>
<!-- 显示分页信息 end -->
