<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="">
    <!-- keywords -->
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>领秀中心</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="/web/img/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="/web/img/favicon-196x196.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="img/apple-icon-touch.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/center_leader.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/health.css"/>
<script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${base}/web/js/member.js"></script>
<style type="text/css">
.shade-one{
	margin-top: 83px;
}
.shade-two{
	margin-top: 126px;
}
.header-nav {
border-left: 0px;
border-right: 0px;
}
</style>
<script>
$(function(){
	$(".current-page").find("h2").css({"color":"#19a69f","font-family":"Microsoft Yahei","letter-spacing":"1px"}).html("健康领秀");
	$(".current-page").find("a").css({"color":"#19a69f","border":"#19a69f 1px solid"});
});
</script>
<div class="health-line">
    <div class="health-wrap" style="background: #EEE; padding-bottom:20px;">
        <div class="current-position">当前位置：<a href="${base}/member/index!getCenterIndex.action">用户中心</a>/领秀中心<!-- <a href="#" class="see-member">查看个人资质</a> --></div>
        <div class="health-main">
            <div class="health-nav">
                <ul>
                    <li class="current" ><a href="#">领秀中心</a></li>
                    <li><a href="${base}/healthLeader/leader!list.action">领秀药房</a></li>
                    <li><a href="${base}/healthLeader/leader!ranking.action">领秀排行</a></li>
                </ul>
            </div>
            <div class="health-content">
                <!-- 左侧开始-->
                <div class="part-left" style="width:810px;">
                    <div class="team-center">
                        <div class="team-center-info">
                            <ul>
                                <li class="wd-1"><img src="<#if leaderMap.head_portrait?exists && leaderMap.head_portrait?has_content><#if !leaderMap.head_portrait?starts_with('http:')>${ui1}</#if>${leaderMap.head_portrait?default('')}
                                    	<#else>${ui1}/static/image/temp/20160127/73569e0fe07f5e60234179baddec94eb.jpg</#if>" alt=""/></li>
                                <li class="wd-2">
                                    <b>${leaderMap.cnt?default(0)}</b>
                                    <p class="p01">您的秀粉</p>
                                </li>
                                <li class="wd-2">
                                    <b>${leaderMap.total_amount?default(0)}</b>
                                    <p class="p02">累计佣金(元)</p>
                                </li>
                                <li class="wd-2">
                                    <b>${leaderMap.phone?default('')}</b>
                                    <p class="p03">手机</p>
                                </li>
                                <li class="wd-3"><a href="${base}/member/amountout!amountOut.action">申请提现</a></li>
                            </ul>
                        </div>
                        <div class="team-center-car">
                            <ul>
                                <li class="car01">
                                    <b>${waitAmount?default(0)}</b>
                                    <span>待入账的壹贝</span>
                                    <div class="question-icon">
                                        <em></em>
                                        <div class="question-con">
                                            <p>待入账壹贝：秀粉已消费，但未达40天的待入账佣金。</p>
                                        </div>
                                    </div>
                                </li>
                                <li class="car02">
                                    <b>${leaderMap.remaining_amount?default(0)}</b>
                                    <span>可提现的壹贝</span>
                                    <div class="question-icon">
                                        <em></em>
                                        <div class="question-con">
                                            <p>可提现壹贝：可以申请提现的佣金总额</p>
                                        </div>
                                    </div>
                                </li>
                                <li class="car03">
                                    <b>${leaderMap.freeze_amount?default(0)}</b>
                                    <span>提现中的壹贝</span>
                                    <div class="question-icon">
                                        <em></em>
                                        <div class="question-con">
                                            <p>提现中壹贝：正在申请提现中的佣金</p>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- 左侧结束-->
                <!-- 右侧开始-->
                <div class="part-right" style="margin-left:0;">
                    <div class="status">
                        <p>这是您的专属身份：</p>
                        <span style="color:#000;">分享到</span>
                        <style>#jiathis_webchat img{margin:0 auto;}</style>
						<div onmouseover="setShare('111医药馆注册即超值豪礼！要健康、要美丽、要时尚@111医药馆', '${leaderUrl?default('')}','1','${qmap.code?default('')}','${ui1}${qmap.dimensional_code_url?default('')}');" style="margin-top:10px;"> <!--自定义第一个分享标题和链接-->
		                     <div class="jiathis_style">       
		                     <a href="http://www.jiathis.com/share/?uid=2058212" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
		                     <a class="jiathis_button_weixin"></a>
		                     <a class="jiathis_button_tsina"></a>
		                     <a class="jiathis_button_qzone"></a>
		                     <a class="jiathis_button_kaixin001"></a>
		                     <a class="jiathis_button_renren"></a>
		                     </div>
						</div>
                    </div>
                    <!--<div class="share">
                    	<a href="#">查看个人主页</a>	
                    	<a href="#">如何使用健康领秀</a>           
                    </div>-->
                    <div class="two-dimension"><img src="${ui1}/static/image/codeqr/${qmap.code?default('')}.jpg" alt=""/></div>
                </div>
                <!-- 右侧结束-->
            </div>
        </div>
        <!-- 热卖推荐开始-->
        <div class="hot-sale">
            <div class="hot-sale-info"><span>热卖推荐</span></div>
            <div class="hot-sale-list">
                <ul id="share-ul-id">
                <#list list?if_exists as resc>
                    <li>
                        <a href="${www}/static/product/p/${resc.goods_id?default(0)}.html" class="pic"><img src="${ui1}${resc.abbreviation_picture?default('')}" alt="" height="120" width="120"/></a>
                        <p><a href="${www}/static/product/p/${resc.goods_id?default(0)}.html">${resc.short_name?default('')}</a></p>
                        <span>￥${resc.pc_price?default('')} <b>￥${resc.price?default('')}</b></span>
							<div onmouseover="setShare('${resc.short_name?default('')}', '/static/product/p/${resc.goods_id?default(0)}.html','2','${qmap.code?default('')}','${ui1}${resc.abbreviation_picture?default('')}');" style="margin-top:35px;margin-left:-15px;">
			                     <div class="jiathis_style">       
			                     <a href="http://www.jiathis.com/share/?uid=2058212" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
			                     <a class="jiathis_button_weixin"></a>
			                     <a class="jiathis_button_tsina"></a>
			                     <a class="jiathis_button_qzone"></a>
			                     <a class="jiathis_button_kaixin001"></a>
			                     <a class="jiathis_button_renren"></a>
			                     </div>
							</div>  
                    </li>
                   </#list>
                </ul>
            </div>
        </div>
        <!-- 热卖推荐结束-->
    </div>
</div>
<!--遮罩层开始-->
<div class="health-shade">
    <!-- 第一步开始-->
    <div class="shade-one" style="margin-top: 83px;">
        <span class="share-close"></span>
        <span class="share-next"></span>
    </div>
    <!-- 第一步结束-->
    <!-- 第二步开始-->
    <div class="shade-two">
        <span class="share-close share-close-two" style="margin-top: 126px;"></span>
        <a href="#" class="share-cash share-close share-close-two"></a>
    </div>
    <!-- 第二步结束-->
</div>
<!--遮罩层结束-->
<script type="text/javascript">
      function setShare(title, url,type,code,pic) {
          //url = "${www}/healthLeader/sharedleader!shareLeader.action?hurl="+encodeURIComponent(url)+"&code="+code;
          url = "http://www.111yao.com/web/share/leader.html?code=${qmap.code?default('')}&id=${qmap.id?default('')}"; 
          jiathis_config.title = title;
          jiathis_config.url = url;
          jiathis_config.pic = pic;
      }
        var jiathis_config = {}
        
        
        $(function(){
	        $('.question-icon em').hover(function(){
	            $(this).siblings().toggle();
	        });
	    })
	    $(function(){
	        $('.share-next').click(function(){
	            $('.shade-one').hide().siblings('.shade-two').show();
	        })
	        $('.share-close').click(function(){
	            $('.health-shade').hide();
        })
    })
</script>   
<!--分享参数代码结束-->
<!--分享功能代码统一放到页尾-->
<script type="text/javascript" src="http://v1.jiathis.com/code/jia.js?uid=2058212" charset="utf-8"></script>
<div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
</body>

</html>