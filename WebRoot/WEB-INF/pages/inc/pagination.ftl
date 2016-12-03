<#if pw?exists && pw.pageInfo?exists && pw.pageInfo.pages?exists && pw.pageInfo.pages gt 1>

<input id="pageNext" name="rs.p_curPage" type="hidden" size="2" value="${pw.pageInfo.nextPage?if_exists}"/>
<input id="pageSize" name="rs.p_pageSize" type="hidden" value="5" value="2"/>

<div class="page-box clearfix clear" style="margin:0 20px 10px 0;">
    <div class="page-jump fr">
        <span>共${pw.pageInfo.pages?if_exists}页，</span><span>到第</span><input id="next_page_temp" type="text"  value=""/><span class="page_y">页</span><a id="submitA" href="javascript:void(0);" class="page_make">确定</a>
    </div>
    <div class="page clearfix">
    
        <a href="<#if pw.pageInfo.nextPage?exists && pw.pageInfo.nextPage lte pw.pageInfo.pages >javascript:goPage(${pw.pageInfo.nextPage?if_exists})</#if>" class="page-next <#if pw.pageInfo.nextPage?exists && pw.pageInfo.nextPage lte pw.pageInfo.pages >page-next-default</#if>">下一页 &gt;&gt;</a>
        
        <#if pw.pageInfo.pages gt 9 >
        
        	<#if pw.pageInfo.page lte 3 ||  pw.pageInfo.page gte (pw.pageInfo.pages-3)>
        		<#foreach p in pw.pageInfo.pages..(pw.pageInfo.pages-3)>
        		
        			<#if pw.pageInfo.page == p >	
						<a href="javascript:void(0);" class="current">${p}</a>
					<#else>
						<a href="javascript:goPage(${p})">${p}</a>
					</#if>
        		</#foreach>
        		<span>...</span>
        		<#foreach p in 3..1>
					<#if pw.pageInfo.page == p >	
						<a href="javascript:void(0);" class="current">${p}</a>
					<#else>
						<a href="javascript:goPage(${p})">${p}</a>
					</#if>        		
        		</#foreach>
        	<#else>
				<a href="javascript:goPage(${pw.pageInfo.pages})">${pw.pageInfo.pages}</a>
				<a href="javascript:goPage(${pw.pageInfo.pages-1})">${pw.pageInfo.pages-1}</a>
				<span>...</span>
				<a href="javascript:goPage(${pw.pageInfo.page+1})">${pw.pageInfo.page+1}</a>
				<a href="javascript:void(0);" class="current">${pw.pageInfo.page}</a>
				<a href="javascript:goPage(${pw.pageInfo.page-1})">${pw.pageInfo.page-1}</a>
				<span>...</span>
				<a href="javascript:goPage(2)">2</a>
				<a href="javascript:goPage(1)">1</a>					
        	</#if>
        	
        <#else>
	        <#foreach p in pw.pageInfo.pages..1>
	        	<#if pw.pageInfo.page == p >	
					<a href="javascript:void(0);" class="current">${p}</a>
				<#else>
					<a href="javascript:goPage(${p})">${p}</a>	
				</#if>		
			</#foreach>
        </#if>
        
        <a href="<#if pw.pageInfo.prePage?exists && pw.pageInfo.prePage gte 1 >javascript:goPage(${pw.pageInfo.prePage?if_exists})</#if>" class="page-prev <#if pw.pageInfo.prePage?exists && pw.pageInfo.prePage gte 1 >page-prev-default</#if>">&lt;&lt; 上一页</a>
    </div>
</div>

<script type="text/javascript">
$(function(){
	$("#next_page_temp").keydown(function(event){
		if(event.keyCode==13){
			var next_page_temp = $("#next_page_temp").val();
			
			if( !isInts(next_page_temp) ){
				$("#next_page_temp").val("");
				return false;
			}else{
				if(next_page_temp > 0 && next_page_temp <= ${pw.pageInfo.pages?if_exists}){
					$("#pageNext").val(next_page_temp);
					$("form")[0].submit();
				}else{
					$("#next_page_temp").val("");
					return false;
				}
			}
		}
	});
	
	$(".page_make").click(function(){
	
		var next_page_temp = $("#next_page_temp").val();
			
		if( !isInts(next_page_temp) ){
			$("#next_page_temp").val("");
			return false;
		}else{
			if(next_page_temp > 0 && next_page_temp <= ${pw.pageInfo.pages?if_exists}){
				$("#pageNext").val(next_page_temp);
				$("form")[0].submit();
			}else{
				$("#next_page_temp").val("");
				return false;
			}
		}
	});
	
	$("#submitA").click(function(){
		var next_page_temp = $("#next_page_temp").val();
		goPage(next_page_temp)
	});
});

function goPage(pageNum)
{ 
	if( !isInts(pageNum) ){
		$("#pageNext").val("");
		return false;
	}
	
	var currentPage = ${pw.pageInfo.page?default(0)};
	
	if(pageNum > 0 && pageNum <= ${pw.pageInfo.pages?if_exists} && currentPage != pageNum){
		$("#pageNext").val(pageNum);
		$("form")[0].submit();
	}
}
function isInts(str){
    if (str == "")
    {
      	return false;
    }
    var r = /^[0-9]+$/;
    return r.test(str);
}
</script>
</#if>
