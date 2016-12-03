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
    <meta name="renderer" content="webkit" />
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="images/common/favicon.png" />
    <meta name="mobile-web-app-capable" content="yes" />
    <link rel="icon" sizes="192x192" href="images/common/favicon.png" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <link rel="apple-touch-icon-precomposed" href="images/common/favicon.png" />
    <meta name="msapplication-TileImage" content="images/common/favicon.png" />
    <meta name="msapplication-TileColor" content="#0e90d2" />
    <link rel="stylesheet" type="text/css" href="/web/version2.2.0/editor/css/editor-min.css" /> 
    <#assign www="http://img.zdfei.com/" />
</head>
<body class="health-bc">
<#include "/static/inc/version2.2.0/new_leader_header.ftl" />
<script>$("#leader_navicator li").eq(0).addClass("cur");</script>
<style>
#shade{background: rgba(0,0,0,.7);opacity:1.7;}
.guide-wrap{position: absolute;  top: 0;  left: 50%; height:670px; margin-left: -375px;  z-index: 1000;
            -webkit-animation: move .7s ease-in-out ;
            -webkit-transform-origin:top;}
        @-webkit-keyframes move {
            0%{
                top:-670px;
            }
            60%{
                top:0;
            }
            70%{
                top:-5%;
            }
            80%{
                top:-2px;
            }
            90%{
                top:-5px;
            }
            100%{
                top:0;
            }
        }
        .guide-box{  width: 750px;  border-radius: 5px;  -moz-border-radius: 5px;  -webkit-border-radius: 5px;  background: #fff; height:588px; position: absolute; top:82px; left:0;}
        .guide-line{height:82px; width:1px; background: #FFF; position: absolute; top:0; left:375px;}
        .fullSlide {  width: 750px;  position: relative;  height: 588px; }
        .fullSlide .bd {  margin: 0 auto;  position: relative;  z-index: 0;  }
        .fullSlide .bd ul { width: 420px!important;  margin:25px 0 0 165px; }
        .fullSlide .bd li {  width: 420px!important;  height: 420px;   text-align: center;  }
        .fullSlide .bd ul li h3{position: absolute; bottom:-50px; left:50%; width:200px; text-align: center; margin-left:-100px; color:#00c9f4; font-size:22px;}
        .fullSlide .bd ul li p{position: absolute; bottom:-80px; left:50%; width:400px; text-align: center; margin-left:-200px; font-size:16px;}
        .fullSlide .hd {  width: 750px;  position: relative;  z-index: 1; bottom:-100px;  height: 30px;  line-height: 30px;  }
        .fullSlide .hd ul {  text-align: right;  position: absolute;  left: 355px;  }
        .fullSlide .hd ul li { cursor: pointer;  display: inline-block;  zoom: 1;  width: 9px;  height: 9px;  margin: 2px;  overflow: hidden;  background: #d7d7d7;  border-radius: 100%;  -webkit-border-radius: 100%;  line-height: 999px;  }

        .fullSlide .hd ul .on {  background: #00aaa0;  }
        .fullSlide .gd {  width: 750px;  margin: -200px auto 0;  position: relative;  height: 0;  background: #000;    }
        .fullSlide .next, .fullSlide .prev {  display: block;  position: absolute;  z-index: 1;  top: 50%;  margin-top: -30px;  left: 0;  z-index: 1;  width: 40px;  height: 60px;  background: url(/web/version2.2.0/images/health/health-slider-arrow.png) no-repeat;  cursor: pointer;   }
        .fullSlide .next {  left: auto;  right: 0;  background-position: -40px 0;  }
        .guide-close{position: absolute; top:0; right:0; height:60px; width:60px; background: #00c9f4 url("/web/version2.2.0/images/health/guide_close.png") no-repeat 25px 15px; border-radius:0 0 0 100%; cursor: pointer;}
         
</style>
<input type="hidden" name="leader_first" id ="leader_first" value="${leader_first?default('0')}"> 
<!--遮罩层开始-->
<div id="shade" style="display:none">
    <div class="guide-wrap" style="display:block;">
        <div class="guide-line"></div>
        <div class="guide-box">
            <!--轮播图开始-->
            <div class="fullSlide clearfix clear">
                <div class="bd">
                    <ul>
                        <li _src="url(/web/version2.2.0/images/health/guide_banner01.png)" style="background:#fff center center no-repeat;"><h3>轻松赚取佣金</h3><p>通过写文章，分享文章,分享药房赚取佣金！</p></li>
                        <li _src="url(/web/version2.2.0/images/health/guide_banner02.png)" style="background:#fff center center no-repeat;"><h3>您的专属药房</h3><p>健康领秀,可自由配置您的药房！</p></li>
                        <li _src="url(/web/version2.2.0/images/health/guide_banner03.png)" style="background:#fff center center no-repeat;"><h3>移动药房</h3><p>配合微信版，移动管理您的药房</p></li>
                    </ul>
                </div>
                <div class="hd">
                    <ul></ul>
                </div>
                <div class="gd"><span class="prev"></span><span class="next"></span></div>
            </div>
            <div class="guide-close"></div>
            <!-- 轮播图结束 -->
        </div>
    </div>
</div>


<!--领秀内容开始-->
<div class="health-content w1000" style="margin-top:25px;">
    <div class="health-part">
        <div class="health-header-img"><img src="${headerUrl}" alt=""/></div>
        <ul class="my-earnings">
            <li class="li01">我的收益 <span>[包含待入账收益]</span></li>
            <li class="li02">${memberAccount.remainingAmount?default(0)+memberAccount.waitAmount?default(0)}
                <b>壹贝
                    <span class="yi-bei">1壹贝=1元 <i></i></span>
                </b>
                <a href="/member/bindingAmount!proceedsDetailList.action">查看明细</a><a href="javascript:;" onclick="now_withdraw()">立即提现</a></li>
            <li class="li03">
                <span class="xf">我的秀粉 <b onclick="window.open('/leaderarticle/leaderarticle!myLeaderFans.action','_self')">${leaderCount.xufen?default(0)}</b></span>
                <span class="wz">我的文章 <b onclick="window.open('/leaderarticle/leaderarticle!leaderArticleList.action','_self')">${leaderArticleListSize?default(0)}</b></span>
                <span class="yf">我的药房 <b onclick="window.open('/leaderarticle/leaderarticle!leaderPharmacy.action','_self')">${leaderCount.yaofang?default(0)}</b></span>
            </li>
        </ul>
    </div>
    <!-- 推荐文章开始-->
    <div class="recommended-articles">
        <h2 class="article-title">推荐文章</h2>
        <ul class="recommended-list">
        	<#list articleList?if_exists as resc>
        		<li><a href="javascript:;"><span onclick="look_article_detail2(${resc.id})">${resc.title?default('')}</span><b onclick="shareData('${resc.id}','${resc.title?default('')}','0')">分享</b></a></li>
        	</#list>
        </ul>
        <a href="/leaderarticle/leaderarticle!pcRecommendArticleList.action" class="recommended-more" title="查看更多推荐文章"><b></b><b></b><b></b></a>
    </div>
    <!-- 推荐文章结束-->
</div>
<!--领秀内容结束-->

<!--我的文章开始-->
<div class="my-articles" style="margin:auto;margin-top:10px;">
    <h2 class="article-title">我的文章</h2>
    <#if leaderArticleListSize?exists>
    <#if leaderArticleListSize != 0>
    <#list leaderArticleList?if_exists as resc>
    	<div class="articles-list">
	        <a href="javascript:;" onclick="look_article_detail(${resc.id})"   class="articles-list-title">${resc.title?default('')}</a>
	        <p class="articles-list-text">${resc.shareTitle?default('')}</p>
	        <div class="comment-num clearfix">
	            <span>${resc.clickLikeSum?default(0)}次感谢</span>
	            <span>${resc.commentSum?default(0)}次分享</span>
	            <ul class="operation-btn">
	                <li class="edit"><b></b><a href="/leaderarticle/leaderarticle!edit.action?articleId=${resc.id}">编辑</a></li>
	                <li class="share"><b></b><a href="javascript:;" onclick="shareData('${resc.id}','${resc.title?default('')}','1')">分享</a></li>
	            </ul>
	        </div>
    	</div>
    </#list>
    <a href="/leaderarticle/leaderarticle!leaderArticleList.action" class="recommended-more" title="查看更多我的文章"><b></b><b></b><b></b></a>
    </#if>
    </#if>
    
    <#if leaderArticleListSize?exists>
	    <#if leaderArticleListSize == 0>
	    <div class="health-default">
	        <p class="default-articles">还没有文章可分享，快去<a href="/leaderarticle/leaderarticle!add.action" target="_blank">写一篇</a>吧～</p>
	    </div>
	    </#if>
    </#if>
    
</div>
<!--我的文章结束-->
<!--我的药房开始-->
<div class="my-pharmacy" style="margin:auto;margin-top:10px;">
    <h2 class="article-title">我的药房</h2>
    
    <#if leaderGoodsListSize?exists>
    <#if leaderGoodsListSize != 0>
    <div class="picbox">
        <ul class="piclist">
        
        	<#list leaderGoodsList?if_exists as resc>
            <li class="goodlist" id="goodlist_${resc_index}">
                <a href="/p/${resc.goods_id?default(0)}.html" target="_blank" style="overflow:hidden; display:block; float:left;"><img src="${www}${resc.abbreviation_picture?default('')}" class="pics" /></a>
                <dl>
                    <dt>
                        <a href="#" target="_blank" class="title">${resc.goods_name?default('')}</a>
                        <span class="en">返佣¥ <b>${resc.rebate_amount?default(0)}</b></span>
                    <p><span class="max-price">¥${resc.price?default(0)}</span></p>
                    <ul class="operation-btn">
                        <li class="delete"><b></b><a href="javascript:void(0)" onclick="del_my_pharmacy_goods('${resc.id?default(0)}','${resc_index}')">删除</a></li>
                    </ul>
                    </dt>
                </dl>
            </li>
            </#list>
            
        </ul>
    </div>
    <a href="/leaderarticle/leaderarticle!leaderPharmacy.action" class="recommended-more"><b></b><b></b><b></b></a>
    </#if>
    </#if>
    
    <#if leaderGoodsListSize?exists>
    <#if leaderGoodsListSize == 0>
    <div class="health-default">
        <p class="default-shopping">还没有商品可显示，快去<a href="/leaderarticle/leaderarticle!leaderPharmacyGoodsList.action">添加</a>吧～</p>
    </div>
    </#if>
    </#if>
</div>
<div style="margin-top:20px;"><#include "/static/inc/version2.2.0/new_leader_footer.ftl"/></div>
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

<script type="text/javascript" src="/web/version2.2.0/js/superslide.2.1.js"></script>
<script>
  $(function(){
        $(".guide-close").click(function(){
            $("#shade").css({"display":"none"});
        })
        var leader_first =$("#leader_first").val();
        if(leader_first==1){
           $("#shade").css({"display":"block"});
        }
    })
jQuery(".fullSlide").slide({
        titCell: ".hd ul",
        mainCell: ".bd ul",
        effect: "fold",
        autoPlay: true,
        autoPage: true,
        trigger: "click",
        startFun: function(i) {
            var curLi = jQuery(".fullSlide .bd li").eq(i);
            if ( !! curLi.attr("_src")) {
                curLi.css("background-image", curLi.attr("_src")).removeAttr("_src")
            }
        }
    });



    //删除我的药房商品
	function del_my_pharmacy_goods(pharmacy_goods_id, index)
	{
	    var url = "/leaderarticle/leaderarticle!delPharmacyGoods.action";
		$confirm("warn","您真的要删除该记录吗？","111医药馆提示您",function(result)
		{
			if(result)
		    {
		    	$.ajax
				({
					type: "POST",
					url: url,
					async: false,
					data:{"pharmacy_goods_id":pharmacy_goods_id},
					dataType: "json",
					success: function(data) 
					{  
						if(data == 1)
						{
						    /*$("#goodlist_"+index).remove();
						    var lg = $(".piclist li").length;
						    if(lg == 0)
						    {
						        $(".picbox").css("border-bottom","0");
						        $(".recommended-more").hide();
						    }*/
						    window.location.reload();
						}
				    },  
				    error: function(e) 
				    {  
				    }  
				});
		    }
		});
	}
	
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
	
	//立即体现
	function now_withdraw()
	{
		var url = "/member/bindingAmount!isBindingAmount.action";
      	$.ajax
		({
			type: "POST",
			url: url,
			success: function(data) 
			{  
				if(data == 1)
				{
					window.location.href = "/member/bindingAmount!drawingProceedsIndex.action";
				}
				if(data == 2)
				{
					window.location.href = "/member/bindingAmount!bindingAmountIndex.action";
				}
	        },  
	        error: function(e){console.log(e);}  
		});
	}
	
	function look_article_detail(article_id)
	{
		$("#preview").html("");
		jQuery.ajax
		({
			type: "POST",
			url: "/leaderarticle/leaderarticle!lookArticleDetail.action?article_id="+article_id,
			success: function(content) 
			{  
				$("#previewbox").css("left","44%").fadeIn();
				$("#preview").html(content);
				$(".mask-ui").fadeIn();
	        },  
	        error: function(e){console.log(e)}  
		});
	}
	
	function look_article_detail2(article_id)
	{
		$("#preview").html("");
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
</body>
</html>