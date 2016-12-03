

<input name="pageInfo.pageSize" type="hidden" value="${pw.pageInfo.pageSize?if_exists}"/>

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

  <div class="page-box clearfix clear">
                            	<div class="page-jump fr">
                                    <span>共${pw.pageInfo.pages?if_exists}页，</span><span>到第</span> <input id="pageNext" name="pageInfo.page" type="text" size="2" value="${rs.p_curPage?if_exists}"/><span class="page_y">页</span><a href="javascript:void(0);" onclick="goPage(document.getElementById('pageNext').value)" class="page_make">确定</a>
                                </div>
                                <div class="page page2 clearfix">
					<#if pw.pageInfo.page == 1>
                                  	<a href="javascript:void(0);" class="page-prev page-prev-default">&lt;&lt; 上一页</a>
					<#else>
					<a href="javascript:void(0);" class="page-prev" onclick="goPage(${pw.pageInfo.page?default(0)-1})">&lt;&lt; 上一页</a>
					</#if>
					<#foreach p in pfrom..pto>	
						<#if p != pw.pageInfo.getPage()>
						<a href="#" onclick="goPage(${p?default(0)})" >${p?default(0)}</a>
						<#else>	  
						<a href="#" onclick="goPage(${p?default(0)})" class="current">${p?default(0)}</a>
						</#if>
					</#foreach>
					
					<#if pw.pageInfo.page == pw.pageInfo.pages>
                                	<a href="javascript:void(0);" class="page-next page-next-default">下一页 &gt;&gt;</a>
				<#else>
					<a href="javascript:void(0);" class="page-next" onclick="goPage(${pw.pageInfo.page?default(0)+1})">下一页 &gt;&gt;</a>
				</#if>
                                </div>
                        </div>


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
			var fid = $("#url_A").val();
			var furl =$("#url_E").val() + $("#type").val() + $("#url_F").val()
			+ $("#brandid").val() + $("#url_G").val() + $("#pricea").val()
			+ $("#url_H").val() + $("#priceb").val()+$("#url_I").val()+$("#sort").val()
			+$("#url_J").val()+$("#orderby").val();
			var fu="-j"+pageNum+"-k"+40;
			window.location.href ="/" + fid + "/list" + furl + fu + ".html";
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
