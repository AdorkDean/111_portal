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
    <title>佣金商品列表</title>
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
	 <style rel="stylesheet" type="text/css">
        body{position: relative;}
        .share-box{display:none; position:absolute; left:50%; top:25%; margin-left:-120px;  width:320px; border:2px solid #CCC; background: #FFF; padding:10px;}
        .con-main{ border-bottom:1px solid #DDD; padding:5px 0;height:50px;}
        .con-main img{float:left; height:50px; width:50px; margin-right:5px;}
        .con-main a.share-text{float:left; display:block; height:50px; line-height:50px; overflow: hidden; text-overflow: ellipsis; white-space:nowrap; width:210px;}
        .con-main a.share-pop{float:right; display: block; height:50px; line-height:50px;}
        .con-main:last-child {border-bottom:none;}
        .close-btn{position: absolute; top:2px; right:2px; display: block; height:20px; width:20px; background: url("/web/img/close.png") no-repeat 0 -20px; cursor: pointer; z-index: 9;}
        .two-dimension-code{display:none; position:absolute; left:50%; top:-2px; margin-left:-140px;  width:220px; height:220px;padding:25px; background: #FFF; border:1px solid #CCC; z-index: 99;}
        .two-dimension-code img{width:220px; height:220px;}
        .two-btn{position: absolute; top:2px; right:2px; display: block; height:20px; width:20px; background: url("/web/img/close.png") no-repeat 0 -20px; cursor: pointer;}
        .search_new{float:left; width:276px; height:40px; }
		.search_new .s-txt{height:38px; border:1px solid #a6a6a6; line-height:38px; border-right:0; padding:0 5px 0 20px; width:170px; float:left; background: url("../img/member-icon18.jpg") no-repeat 5px center; color:#a6a6a6; }
		.search_new .s-btn{height:40px; cursor: pointer; border-radius:0 5px 5px 0 ; display: block; width:70px; floaT:left; background: #a6a6a6; color:#FFF;}
    </style>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/center_leader.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/health.css"/>
<script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${base}/web/js/member.js"></script>
<script>
$(function(){
    $(".two-btn").click(function(){
        $(".two-dimension-code").hide();
    });
	$(".current-page").find("h2").css({"color":"#19a69f","font-family":"Microsoft Yahei","letter-spacing":"1px"}).html("健康领秀");
	$(".current-page").find("a").css({"color":"#19a69f","border":"#19a69f 1px solid"});
});
</script>
<div class="health-line">
    <div class="health-wrap">
        <div class="current-position">当前位置：<a href="${base}/member/index!getCenterIndex.action">用户中心</a>/领秀药房</div>
        <div class="health-main">
            <div class="health-nav">
                <ul>
                    <li><a href="${base}/healthLeader/leader!leader.action">领秀中心</a></li>
                    <li class="current"><a href="#">领秀药房</a></li>
                    <li><a href="${base}/healthLeader/leader!ranking.action">领秀排行</a></li>
                </ul>
            </div>
            <div class="health-content clearfix clear">
                <!-- 左侧开始-->
                <div class="part-left">
                    <!-- 药房列表开始-->
                    <div class="my-pharmacy">
                      <form id="inputForm" name="form1" action="${base}/healthLeader/leader!list.action" method="post">               
                        <input type="hidden" name="type" value="${type?default('1')}" id="type">
                        <input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default()}" id="p_curPage">
		    			<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default()}" id="pageSize">		
                        <div class="my-pharmacy-list">
                            <div class="sort"><b>排序</b></div>
                            <div class="info" id="choose-info">
                            	<span <#if type?default('')=='1'> class="current" onclick="subformtype(2)" <#elseif type?default('')=='2'> class="current" onclick="subformtype(1)"  <#else> onclick="subformtype(1)" </#if>>
                            		<i>佣金比例</i>
                            		<#if type?default('')=='1' || type?default('')=='2'>
                            		<strong <#if type?default('')=='1'>class="up"</#if><#if type?default('')=='2'>class="down"</#if>  ></strong>
                            		</#if>
                            	</span>
                            	<span <#if type?default('')=='3'> class="current" onclick="subformtype(4)" <#elseif type?default('')=='4'> class="current" onclick="subformtype(3)"  <#else> onclick="subformtype(3)" </#if>>
                            		<i>销量</i>
                            		<#if type?default('')=='3' || type?default('')=='4'>
                            		<strong <#if type?default('')=='3'>class="up"</#if><#if type?default('')=='4'>class="down"</#if>  ></strong>
                            		</#if>
                            	</span>
                            	<span <#if type?default('')=='5'> class="current" onclick="subformtype(6)" <#elseif type?default('')=='6'> class="current" onclick="subformtype(5)"  <#else> onclick="subformtype(5)" </#if>>
                            		<i>价格</i>
                            		<#if type?default('')=='5' || type?default('')=='6'>
                            		<strong <#if type?default('')=='5'>class="up"</#if><#if type?default('')=='6'>class="down"</#if>  ></strong>
                            		</#if>
                            	</span>
                        		<b></b>
                        	</div>
                            <div class="form">
                                <div class="search_new"><input type="text" name="name" value="${name?default('')}" class="s-txt"/><input type="button" value="搜索" class="s-btn" onclick="subform();"/></div>
                                <a href="${base}/member/amountout!amountOut.action">申请提现</a>
                            </div>
                            <div class="list" id="choose-list">
                                <div class="list-con current">
                                    <table width="760" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td height="20" width="180">商品名称</td>
                                            <td height="20" width="70" align="center">规格</td>
                                            <td height="20" width="110"align="center">商品编码</td>
                                            <td height="20" width="80" align="center">市场价格(元)</td>
                                            <td height="20" width="80" align="center">本站价格(元)</td>
                                            <td height="20" width="80" align="center">佣金比例</td>
                                            <td height="20" width="80" align="center">可返壹贝</td>
                                            <td height="20" width="80" align="center">操作</td>
                                        </tr>
                                      <#list pw.result?if_exists as resc>  
                                        <tr>
                                            <td height="50" class="img-position" align="center">${resc.short_name?default('')}<img src="${ui1}${resc.abbreviation_picture?default('')}" alt="" height="150" width="150"/></td>
                                            <td height="50" align="center">${resc.spec?default('')}</td>
                                            <td height="50" align="center">${resc.goodsno?default('')}</td>
                                            <td height="50" align="center">${resc.price?default('')}</td>
                                            <td height="50" align="center" class="cor-r">${resc.pc_price?default('')}</td>
                                            <td height="50" align="center">${resc.brokerage?default('')}%</td>
                                            <td height="50" align="center" >${resc.yong?default('')}</td>
                                            <td height="50" align="center"><a href="${www}/static/product/p/${resc.goods_id?default(0)}.html" class="cor-b" target="_blank">查看</a>
                                            <style>#jiathis_webchat img{margin:0 auto;}</style>
							                     <a href="javascript:void(0)" onclick='shared(${resc.goods_id?default(0)});' class="share-btn"  style="margin-top:8px;">文章分享</a>
                                            </td>
                                        </tr>
                                      </#list>  
                                    </table>
                                    <div class="share-box" id="fx">
                                    </div>
                                    <div class="two-dimension-code" id="fxcode">
                                    	<img src="" alt="" height="250" width="250" id="wxcode"/>
                                    	<b class="two-btn"></b>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--分页开始-->
                          <#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
                        <!--分页结束-->
                    </div>
                    </form>
                    <!-- 药房列表结束-->
                </div>
                <!-- 左侧结束-->
                <!-- 右侧开始-->
                <div class="part-right">
                    <div class="status">
                        <p>这是您的专属身份：</p>
                        <span style="color:#000;">分享到</span>
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
                    <!--<div class="rg-img"><a href="#" class="l-a"><img src="img/health-img01.jpg" alt=""/></a><a href="#"><img src="img/health-img01.jpg" alt=""/></a></div>-->
                </div>
                <!-- 右侧结束-->
            </div>
        </div>
    </div>
</div>
<div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
</body>
<script type="text/javascript">
      function setShare(title, url,type,code,pic) {
          //url = "${www}/healthLeader/sharedleader!shareLeader.action?hurl="+encodeURIComponent(url)+"&code="+code; 
          url = "http://www.111yao.com/web/share/leader.html?code=${qmap.code?default('')}&id=${qmap.id?default('')}"; 
          jiathis_config.title = title;
          jiathis_config.url = url;
          jiathis_config.pic = pic;
      }
      function setShareHTML(id,title,share_title,share_image_url) {
          alert("id==="+id);
          alert("title==="+title);
          alert("share_title==="+share_title);
          alert("share_image_url==="+share_image_url);
          //var article = "/zt/article/"+index+".html";
          //url = "${www}/healthLeader/sharedleader!shareLeaderHtml.action?hurl="+encodeURIComponent(article)+"&code="+code+"&id="+id; 
          //jiathis_config.title = title;
          //jiathis_config.url = url;
          //jiathis_config.pic = pic;
      }
        var jiathis_config = {}
</script>   
<!--分享参数代码结束-->
<!--分享功能代码统一放到页尾-->
<script type="text/javascript" src="http://v1.jiathis.com/code/jia.js?uid=2058212" charset="utf-8"></script>
<script>
function subform(){
   $('#p_curPage').val(1);
   $('#inputForm').submit();
}

function subformtype(type){
   $('#p_curPage').val(1);
   $('#type').val(type);
   $('#inputForm').submit();
}

function shared(id){
    $.post("${base}/healthLeader/sharedleader!getGoodsArticle.action?goods_id="+id,{random:Math.random()},function(data){
          if(data=="0"){
             alert("系统异常");
          }else if(data=="-1"){
             alert("无分享文章");
          }else{
	          var obj = eval("("+data+")"); 
	          $(".share-box").html('');
	          var str = "";
	          $.each(obj,function(key,value){
	           str += "<div class='con-main'><img src=${ui1}"+value.share_image_url+" alt='' height='50' width='50'/><a href='javascript:void(0)' class='share-text'>"+
	                  value.title+"</a><a href='javascript:void(0)' class='share-pop' onclick=openCode("+value.id+")>分享</a></div>";                           
	    	  });
	    	  if(str != ""){
	    	     str += "<span class='close-btn' onclick='sharedClose();'></span>";
	    	  }
	    	  $("#fx").append(str);
	          $(".share-box").show();
	      }    
    });
}

function  sharedClose(){
     $(".share-box").hide();
} 

function openCode(id){
   var article = "/static/leader/"+id+".html";
   var url_ = encodeURIComponent("http://m.111yao.com/leader/leader!shareLeaderHtml.action?hurl="+article+"&code=${qmap.code?default('')}&id=${qmap.id?default('')}"); 
   var img = document.getElementById("wxcode");  
   img.src="${base}/static/inc/wxCode.jsp?url="+url_+"&s="+ Math.random();
   $(".share-box").hide();
   $('#fxcode').show();
}
</script>
</html>