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
    <title>领秀排行</title>
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
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/health.css"/>
<script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${base}/web/js/member.js"></script>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/center_leader.ftl">
<script>
$(function(){
	$(".current-page").find("h2").css({"color":"#19a69f","font-family":"Microsoft Yahei","letter-spacing":"1px"}).html("健康领秀");
	$(".current-page").find("a").css({"color":"#19a69f","border":"#19a69f 1px solid"});
});
</script>
<div class="health-line">
    <div class="health-wrap">
        <div class="current-position">当前位置：<a href="${base}/member/index!getCenterIndex.action">用户中心</a>/领秀排行</div>
        <div class="health-main">
            <div class="health-nav">
                <ul>
                    <li><a href="${base}/healthLeader/leader!leader.action">领秀中心</a></li>
                    <li><a href="${base}/healthLeader/leader!list.action">领秀药房</a></li>
                    <li class="current"><a href="#">领秀排行</a></li>
                </ul>
            </div>
            <div class="health-content clearfix clear" style="background: #FFF;">
                <!-- 左侧开始-->
                <div class="part-left">
                    <!-- 领秀排行开始-->
                    <div class="ranking-list">
                        <div class="ranking-list-info">
                            <span class="span01">秀粉排行榜</span>
                            <span class="span02">收益排行榜</span>
                            <a href="${base}/member/amountout!amountOut.action">申请提现</a>
                        </div>
                        <div class="ranking-list-num">
                            <ul>
                                <li>
                                    <b>${leader.peopleRanking?default(99999)}</b>
                                    <p>我的秀粉排名</p>
                                </li>
                                <li>
                                    <b>${leader.priceRanking?default(99999)}</b>
                                    <p>我的收益排名</p>
                                </li>
                            </ul>
                        </div>
                        <div class="ranking-list-con">
                            <ul>
                            <div style="border-bottom:1px solid #a6a6a6;width: 180px;"></div>
                            <#list leaderList?if_exists as resc>
                                <li style="border-bottom:0px;">
                                    <div class="head-img"><img src="<#if resc.head_portrait?exists && resc.head_portrait?has_content><#if !resc.head_portrait?starts_with('http:')>${ui1}</#if>${resc.head_portrait?default('')}
                                    <#else>${ui1}/static/image/temp/20151014/b09e2b114b6779b8fe47bcd8d38fe48a.png</#if>" alt=""/></div>
                                    <div class="name-num">
                                        <b>${resc.nick_name?default('')}</b>
                                        <span>${resc.id?default(0)}个秀粉</span>
                                    </div>
                                </li>
	                                <div style="border-bottom:1px solid #a6a6a6;width: 180px;" align="center"></div>
                            </#list>
                            </ul>
                            <ul style="margin-left: 70px;">
	                                <div style="border-bottom:1px solid #a6a6a6;width: 180px;"></div>
                                <#list amountList?if_exists as resc>
	                                <li style="border-bottom:0px;">
	                                    <div class="head-img"><img src="<#if resc.head_portrait?exists && resc.head_portrait?has_content><#if !resc.head_portrait?starts_with('http:')>${ui1}</#if>${resc.head_portrait?default('')}
                                    	<#else>${ui1}/static/image/temp/20151014/b09e2b114b6779b8fe47bcd8d38fe48a.png</#if>" alt=""/></div>
	                                    <div class="name-num">
	                                        <b>${resc.nick_name?default('')}</b>
	                                        <span>${resc.total_amount?default(0)}元</span>
	                                    </div>
	                                </li>
	                                <div style="border-bottom:1px solid #a6a6a6;width: 180px;" align="center"></div>
                                </#list>
                            </ul>
                        </div>
                    </div>
                    <!-- 领秀排行结束-->
                </div>
                <!-- 左侧结束-->
                <!-- 右侧开始-->
                <div class="part-right">
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
                    <div class="two-dimension"><img src="${ui1}/static/image/codeqr/${qmap.code?default('')}.jpg" alt=""/></div>
                </div>
                <!-- 右侧结束-->
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
      function setShare(title, url,type,code,pic) {
          //url = "${www}/healthLeader/sharedleader!shareLeader.action?hurl="+encodeURIComponent(url)+"&code="+code; 
          url = "http://www.111yao.com/web/share/leader.html?code=${qmap.code?default('')}&id=${qmap.id?default('')}"; 
          jiathis_config.title = title;
          jiathis_config.url = url;
          jiathis_config.pic = pic;
      }
        var jiathis_config = {}
</script>   
<!--分享参数代码结束-->
<!--分享功能代码统一放到页尾-->
<div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
<script type="text/javascript" src="http://v1.jiathis.com/code/jia.js?uid=2058212" charset="utf-8"></script>
</body>
</html>