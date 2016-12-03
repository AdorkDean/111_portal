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
    <title>提现</title>
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
<script type="text/javascript">
$(function(){
	$(".current-page").find("h2").css({"color":"#19a69f","font-family":"Microsoft Yahei","letter-spacing":"1px"}).html("健康领秀");
	$(".current-page").find("a").css({"color":"#19a69f","border":"#19a69f 1px solid"});
});
</script>
<div class="health-line">
    <div class="health-wrap">
        <div class="current-position">当前位置：<a href="${base}/member/index!getCenterIndex.action">用户中心</a>/<a href="${base}/healthLeader/leader!leader.action">领秀中心</a>/佣金历史</div>
        <div class="health-main">
            <div class="health-nav">
                <ul>
                    <li class="current"><a href="${base}/healthLeader/leader!leader.action">领秀中心</a></li>
                    <li><a href="${base}/healthLeader/leader!list.action">领秀药房</a></li>
                    <li><a href="${base}/healthLeader/leader!ranking.action">领秀排行</a></li>
                </ul>
            </div>
            <div class="health-content" style="overflow: hidden;">
                <!-- 左侧开始-->
                <div class="part-left">
                    <!-- 佣金历史开始-->
                    <div class="bank-history">
                        <div class="money-number">
                            <ul>
                                <li>
                                    <b>${lj?default(0)}</b>
                                    <p>累计申请提现(元)</p>
                                </li>
                                <li>
                                    <b>${ljs?default(0)}</b>
                                    <p>累计通过申请(元)</p>
                                </li>
                                <li>
                                    <b>${account.waitAmount?default(0)}</b>
                                    <p>待返佣金(元)</p>
                                </li>
                                <li class="history-back">
                                    <a href="${base}/member/amountout!amountOut.action">返回</a>
                                </li>
                            </ul>
                        </div>
         <form id="form1" name="form1" action="${base}/member/amountout!list.action" method="get" enctype="multipart/form-data">  
         	     	<input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(1)}" id="p_curPage">
			<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(5)}" id="pageSize">             
                        <table width="780" cellpadding="0" cellspacing="0">
                            <tr>
                                <td align="center" height="36" width="50">序号</td>
                                <td align="center" height="36" width="100">提现账户类型</td>
                                <td align="center" height="36" width="200">提现账户</td>
                                <td align="center" height="36" width="50">姓名</td>
                                <td align="center" height="36" width="130">提交时间</td>
                                <td align="center" height="36" width="100">提现佣金</td>
                                <td align="center" height="36" width="50">审核状态</td>
                                <td align="center" height="36" width="100">备注</td>
                            </tr>
                            <#list pw.result?if_exists as resc>
	                            <tr>
	                                <td align="center" height="70">${resc_index+1?default('')}</td>
	                                <td align="center" height="70"><#if resc.out_type?default(0)==1>支付宝<#elseif resc.out_type?default(0)==2>银行卡</#if></td>
	                                <td align="center" height="70"><#if resc.out_type?default(0)==1>${resc.alipay_no?default('')}<#elseif resc.out_type?default(0)==2>${resc.bank_no?default('')}</#if></td>
	                                <td align="center" height="70">${resc.real_name?default('')}</td>
	                                <td align="center" height="70"><#if resc.out_time?exists>${resc.out_time?string('yyyy-MM-dd')}</#if></td>
	                                <td align="center" height="70">${resc.amount?default(0)}</td>
	                                <td align="center" height="70"><#if resc.status?default(0)==1>申请提现<#elseif resc.status?default(0)==2>提现中<#elseif resc.status?default(0)==3>提现完成<#elseif resc.status?default(0)==4>审核驳回</#if></td>
	                                <td align="center" height="70">${resc.remark?default('')}</td>
	                            </tr>
                            </#list>
                        </table>
                      </form>  
                          <!--分页开始-->
            <#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
            <!--分页结束-->
                    </div>
                    <!-- 佣金历史结束-->
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