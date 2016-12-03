 <div class="list_fy_list">
<#if pw.pageInfo.page == 1>
<a class="prev" href="#"></a>
<#else>
<a class="prev" href="#" onclick="goPage(${pw.pageInfo.page?default(0)-1})"></a>
</#if>
<#if pw.pageInfo.page == pw.pageInfo.pages> <a class="next" href="#"></a>
<#else>
<a class="next" href="#" onclick="goPage(${pw.pageInfo.page?default(0)+1})"></a>
</#if>
</div>
 <input id="pageNext" name="pageInfo.page" type="hidden" size="2" value="${rs.p_curPage?if_exists}"/>
<input name="pageInfo.pageSize" type="hidden" value="${pw.pageInfo.pageSize?if_exists}"/>
<script>
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
