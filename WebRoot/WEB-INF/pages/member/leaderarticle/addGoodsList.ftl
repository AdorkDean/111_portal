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
<#include "/WEB-INF/pages/inc/taglibs.ftl">
</head>
<body class="health-bc">
<!--头部开始-->
<#include "/static/inc/version2.2.0/new_leader_header.ftl" />
<script>$("#leader_navicator li").eq(2).addClass("cur");</script>
<!--头部结束-->
<!--我的药房开始-->
<div class="my-pharmacy-page w1000">
    <h2 class="article-page-top">我的药房>添加商品
        <form name="form1" id="form1"  action="${base}/leaderarticle/leaderarticle!leaderPharmacyGoodsList.action" method="post">
        <input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(0)}" id="p_curPage">
		<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(8)}" id="pageSize">
        <div class="search-box clearfix shade-title-search add-shopping-search">
            <div class="search">
                <a href="#" class="search-btn health-search-btn" onclick="submitForm()">搜索</a>
                <input class="header-search-input" type="text" name="name" placeholder="请输入搜索的内容..." value="${name?default('')}" >
            </div>
        </div>
      </form> 
        <!--搜索结束-->
    </h2>
    <div class="back-money">
        <span>返佣金额 <b class="up"></b></span>
    </div>
    <div class="picbox pharmacy-padding">
    <#list pw.result?if_exists as resc>
        <ul class="piclist">
            <li class="goodlist">
                <a href="${base}/p/${resc.goods_id?default(0)}.html" target="_blank" style="overflow:hidden; display:block; float:left;"><img src="${ui1}${resc.abbreviation_picture?default('')}" class="pics" /></a>
                <dl>
                    <dt>
                        <a href="${base}/p/${resc.goods_id?default(0)}.html" target="_blank" class="title">${resc.goods_name?default('')}</a>
                        <span class="en">返佣¥ <b>${resc.rebate_amount?default(0)}</b></span>
                    <p><span class="max-price">￥${resc.pc_price?default(0)}</span></p>
                    <input type="button" value="加入药房" class="add-yf" onclick="javascript:addMyPharmacyGoods('${resc.goods_id?default(0)}')"/>
                    </dt>
                </dl>
            </li>
        </ul>
      </#list>
    </div>
</div>
<!--分页开始-->
 <div class="page-box clearfix clear w1000 page-box-margin"><#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl"></div>
<!--分页结束-->
<!--我的药房结束-->

<div style="margin-top:20px;"><#include "/static/inc/version2.2.0/new_leader_footer.ftl"/></div>

<!--js-->
<script>
  $().ready(function() {
	});		
	function submitForm(){
		$('#p_curPage').val(1);
	 	$("#form1").submit();
	}
</script>
<script type="text/javascript">
function addMyPharmacyGoods(goods_id)
{
		$confirm("warn","您确定要添加该商品吗?",null,function(result)
			  {
			    if(result)
			    {
			 	   $.ajax({
				    url: "${base}/leaderarticle/leaderarticle!leaderPharmacyAddGoods.action",
				    type: "GET",
				 	data: {
				 		goodsId: goods_id,
				 	},
				  	cache: false,
			      	success: function(data) {
					if(data==1){
						$alert("warn","添加成功","111医药馆提示您",null);
						return false;
					}else if(data==2){
						$alert("warn","已添加过此商品！","111医药馆提示您",null);
						return false;
					}else{
						$alert("warn","您已经超出领秀药房商品上限"+data+"个","111医药馆提示您",null);
						return false;
					}
				 }
			 	});
		     }
	 });
}
</script>
</body>
</html>