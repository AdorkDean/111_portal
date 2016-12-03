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
    <link rel="stylesheet" type="text/css" href="/web/version2.2.0/editor/css/editor-min.css" />
</head>
<body class="health-bc">
<!--头部开始-->
<#include "/static/inc/version2.2.0/new_leader_header.ftl"/>
<script>$("#leader_navicator li").eq(1).addClass("cur");</script>
<!--头部结束-->
<!--推荐文章开始-->
<div class="my-articles w1000 clearfix my-articles-edit" style="margin-top:25px;">
    <!-- 左侧导航开始-->
    <div class="articles-left-nav">
        <ul>
            <li class="nav-edit"><a href="${base}/leaderarticle/leaderarticle!add.action">写文章</a></li>
            <li class="current"><a href="${base}/leaderarticle/leaderarticle!pcRecommendArticleList.action"><span>推荐文章</span><b>${pcArticleCount?default(0)}</b></a></li>
            <li><a  href="${base}/leaderarticle/leaderarticle!leaderArticleList.action"><span>我的文章</span><b>${myArticleCount?default(0)}</b></a></li>
             <li><a href="${base}/leaderarticle/leaderarticle!draftLeaderArticleList.action"><span>待发布文章</span><b>${draftArticleCount?default(0)}</b></a></li>
        </ul>
    </div>
    <!-- 左侧导航结束-->
    <!-- 文章列表开始-->
    <div class="articles-wrap">
        <!--搜索开始-->
        <form name="form1" id="form1"  action="${base}/leaderarticle/leaderarticle!pcRecommendArticleList.action" method="post">
        <input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(0)}" id="p_curPage">
		<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(10)}" id="pageSize">
        <div class="search-box clearfix clear">
            <div class="search health-search">
             <!--	<input type="button"   id="buttonsub" value="搜索" class="search-btn" onclick="submitForm()" />  -->
                <a href="#" class="search-btn" onclick="submitForm()">搜索</a>
                <input class="header-search-input" type="text" name="title" placeholder="请输入搜索的内容..." value="${title?default('')}">
            </div>
        </div>
      </form> 
        <!--搜索结束-->
        <#list pw.result?if_exists as resc>
        <div class="articles-list">
            <a href="javascript:;" onclick="look_article_detail(${resc.id})"  class="articles-list-title">${resc.title?default('')}</a>
            <p class="health-time"><#if resc.sendDt?exists>${resc.sendDt?string('yyyy-MM-dd HH:mm:ss')}</#if></p>
            <div class="comment-num clearfix">
                <ul class="operation-btn">
                    <li class="share"><b></b><a href="#" onclick="shareData('${resc.id}','${resc.title?default('')}','0')">分享</a></li>
                </ul>
            </div>
        </div>
       </#list>
         <!--分页开始-->
            <div style="margin-bottom:20px;"><#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl"></div>
         <!--分页结束-->
    </div>
    <!-- 文章列表结束-->
</div>
<!--推荐文章结束-->
<div style="margin-top:25px;"><#include "/static/inc/version2.2.0/new_leader_footer.ftl"/></div>
<!---------------------------- 二维码预览图 ------------------------------------->
<div class="imgCode">
	<div class="closeImg">
		<b class="title_b">手机扫码分享到朋友圈</b>
		<span class="title_c"></span>
		<img class="close_i" src="http://img.zdfei.com/static/image/temp/20160609/be88eaadd4cbb4dad089fd4879cf7b34.png" onclick="hideCode()"/>
	</div>
	<img id="codePriview"/>
</div>
<div class="mask-ui"></div>

<!-------预览------->
  <div id="previewbox"> 
   <div style="height:100%;overflow-y:scroll;padding-right:5px;"> 
    <div id="preview"></div> 
   </div> 
   <div onclick="closePreview()" style="position:absolute;right:10px;top:10px;cursor:pointer;width:50px;height:50px;font-size:50px;font-weight:700" id="phoneclose">
    X
   </div> 
  </div>

</body>
<script>
	//分享
	function shareData(articleId, title, type)
	{
		var article = "/static/leader/"+articleId+".html";
		if(type == 1)
	    {
	    	article = "/static/leader/user/"+articleId+".html";
	    }
	    var r = share_erwei_code + "/leader/leader!shareLeaderHtml.action?hurl="+article+"&code="+ '${tleader.code?default('')}' + "&id="+ '${tleader.id?default('')}';
	    console.log(r);
	    var url_ = encodeURIComponent(r); 
	    var img = document.getElementById("codePriview");  
	    img.src = "/static/inc/wxCode.jsp?url="+url_+"&s="+ Math.random();
		$(".title_c").html(title);
   		$(".imgCode").show();
   		$(".mask-ui").show();
	}
	
	//隐藏二维码
	function hideCode()
	{
	    $(".imgCode").hide();
   		$(".mask-ui").hide();
	}
	
  $().ready(function() {
	});		
	function submitForm(){
	 	$('#p_curPage').val(1);
	 	$("#form1").submit();
	}
	
	
	function look_article_detail(article_id)
	{
		jQuery.ajax
		({
			type: "POST",
			url: "/leaderarticle/leaderarticle!lookArticleDetail2.action?article_id="+article_id,
			success: function(content) 
			{  
				$("#previewbox").css("left","44%").fadeIn();
				$("#preview").html(content);
				$(".mask-ui").fadeIn();
	        },  
	        error: function(e){console.log(e)}  
		});
	}
	
	function closePreview()
	{
		$("#previewbox").fadeOut();
		$("#preview").html("");
		$(".mask-ui").fadeOut();
	}
	
</script>
</html>