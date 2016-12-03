 <div class="list_fy_list">
<#if pwman.pageInfo.page == 1>
<a class="prev" href="#"></a>
<#else>
<a class="prev" href="#" onclick="goPage2(${pwman.pageInfo.page?default(0)-1})"></a>
</#if>
<#if pwman.pageInfo.page == pwman.pageInfo.pages> <a class="next" href="#"></a>
<#else>
<a class="next" href="#" onclick="goPage2(${pwman.pageInfo.page?default(0)+1})"></a>
</#if>
</div>
 <input id="pageNext2" name="pageInfo.page" type="hidden" size="2" value="${rsman.p_curPage?if_exists}"/>
<input name="pageInfo.pageSize" type="hidden" value="${pwman.pageInfo.pageSize?if_exists}"/>
<script>
function goPage2(pageNum)
{ 
	if( !isInts(pageNum) )
	{
		alert("请正确输入要跳转的页码！");
		document.getElementById('pageNext2').value = "";
		document.getElementById('pageNext2').focus();
		return;
	}
	if( pageNum>0 )
	{
		if(pageNum > ${pwman.pageInfo.pages?if_exists} || pageNum < 1){
			alert("页码超出范围");
			document.getElementById('pageNext2').focus();
			return;
		}else{
			document.getElementById('pageNext2').value = pageNum;
			document.getElementById('rsman_p_curPage').value = pageNum;
			document.form1.submit();
		}
	}else{
		alert("请正确输入要跳转的页码！");
		document.getElementById('pageNext2').value = "";
		document.getElementById('pageNext2').focus();
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
