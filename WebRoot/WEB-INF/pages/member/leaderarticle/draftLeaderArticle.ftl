<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="111医药馆网上药店是国家药监局认证指定网上药房|打造为老百姓服务药品价格低品种全|网上购药买药就选壹壹壹医药馆药品特卖网站">
    <!-- keywords -->
    <meta name="keywords" content="壹壹壹医药馆|壹药馆|11医药馆|1药馆|医卡通|111医药馆|医药网|药品特卖网站">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>健康领秀</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="images/common/favicon.png">
    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/common/favicon.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="images/common/favicon.png">
    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/common/favicon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
</head>
<body class="health-bc">
<#include "/static/inc/version2.2.0/new_leader_header.ftl"/>
<script>$("#leader_navicator li").eq(1).addClass("cur");</script>

<!--推荐文章开始-->
<div class="my-articles w1000 clearfix my-articles-edit" style="margin-top:25px;">
		<form name="form1" id="form1"  action="${base}/leaderarticle/leaderarticle!draftLeaderArticleList.action" method="post">
        <input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(0)}" id="p_curPage">
		<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(10)}" id="pageSize">
		</form> 
    <!-- 左侧导航开始-->
    <div class="articles-left-nav">
        <ul>
           <li class="nav-edit"><a href="/leaderarticle/leaderarticle!add.action">写文章</a></li>
            <li><a href="${base}/leaderarticle/leaderarticle!pcRecommendArticleList.action"><span>推荐文章</span><b>${pcArticleCount?default(0)}</b></a></li>
            <li><a  href="${base}/leaderarticle/leaderarticle!leaderArticleList.action"><span>我的文章</span><b>${myArticleCount?default(0)}</b></a></li>
            <li class="current"><a href="${base}/leaderarticle/leaderarticle!draftLeaderArticleList.action"><span>待发布文章</span><b>${draftArticleCount?default(0)}</b></a></li>
        </ul>
    </div>
    <!-- 左侧导航结束-->
    <!-- 文章列表开始-->
    <#if (pw.result?size>0)>
    <div class="articles-wrap">
    <#list pw.result?if_exists as resc>
        <div class="articles-list">
            <a class="articles-list-title">${resc.title?default('')}</a>
            <p class="health-time"><#if resc.updateDt?exists>${resc.updateDt?string('yyyy-MM-dd HH:mm:ss')}</#if></p>
           
                <ul class="operation-btn">
                	<#if resc.auditStatus?string=="1">
                	 <div class="comment-num clearfix">
	                  <strong class="audit-btn">审核中</strong>
	            	 </div>
	            	 <#elseif resc.auditStatus?string=="3">
	            	  <div class="comment-num clearfix">
	                  <strong class="audit-btn">审核不通过</strong>
                    <li class="edit"><b></b><a href="/leaderarticle/leaderarticle!edit.action?articleId=${resc.id?default(0)}">编辑</a></li>
                    <li class="delete"><b></b><a href="javascript:;" onclick="javascript:deleteMyArticle('${resc.id?default(0)}')">删除</a></li>
                     </div>
                   	<#else>
                   	<div class="comment-num clearfix">
                   	<li class="edit"><b></b><a href="/leaderarticle/leaderarticle!edit.action?articleId=${resc.id?default(0)}">编辑</a></li>
                    <li class="delete"><b></b><a href="javascript:;" onclick="javascript:deleteMyArticle('${resc.id?default(0)}')">删除</a></li>
                    </div>
                    </#if>
                </ul>
        </div>
     </#list>
        <!--分页开始-->
         <div style="margin-bottom:20px;"><#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl"></div>
        <!--分页结束-->
    </div>
    <#else>
    <!-- 缺省页开始-->
  	<div class="health-default">
        <p class="default-shopping">还没有待发布文章，快去<a href="${base}/leaderarticle/leaderarticle!add.action">添加</a>吧～</p>
    </div>
    <!-- 缺省页结束-->
   </#if>
    <!-- 文章列表结束-->
</div>
<!--推荐文章结束-->
<div style="margin-top:20px;"><#include "/static/inc/version2.2.0/new_leader_footer.ftl"/></div>
</body>
<script type="text/javascript">
function deleteMyArticle(articleId)
{
		$confirm("warn","您确定要删除该文章吗?",null,function(result)
			  {
			    if(result)
			    {
			 	   $.ajax({
				    url: "${base}/leaderarticle/leaderarticle!deleteMyArticle.action",
				    type: "GET",
				 	data: {
				 		articleId: articleId,
				 	},
				  	cache: false,
			      	success: function(data) {
					if(data==1){
						$alert("warn","删除成功！");
						location.href="/leaderarticle/leaderarticle!draftLeaderArticleList.action";
						return false;
					}else if(data==2){
						$alert("warn","删除失败！");
						location.href="/leaderarticle/leaderarticle!draftLeaderArticleList.action";
						return false;
					}
				 }
			 	});
		     }
	 });
}
</script>
</html>