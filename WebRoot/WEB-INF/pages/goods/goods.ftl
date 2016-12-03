<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
    <#if goods.seo_describe?exists>
    	<#if goods.seo_describe?trim != ''>
    		<meta name="description" content="${goods.seo_describe}" />
    	<#else>
    		<meta name="description" content="111医药馆网上药店是国家药监局认证指定网上药房|打造为老百姓服务药品价格低品种全|网上购药买药就选壹壹壹医药馆药品特卖网站" />
    	</#if>
    <#else>
    	<meta name="description" content="111医药馆网上药店是国家药监局认证指定网上药房|打造为老百姓服务药品价格低品种全|网上购药买药就选壹壹壹医药馆药品特卖网站" />
    </#if>
   
    <#if goods.seo_keyword?exists>
    	<#if goods.seo_keyword?trim != ''>
    		<meta name="keywords" content="${goods.seo_keyword}" />
    	<#else>
	    	<meta name="keywords" content="壹壹壹医药馆|壹药馆|11医药馆|1药馆|医卡通|111医药馆|医药网|药品特卖网站" />
    	</#if>
    <#else>
    	<meta name="keywords" content="壹壹壹医药馆|壹药馆|11医药馆|1药馆|医卡通|111医药馆|医药网|药品特卖网站" />
    </#if>
    
    
    <#if goods.seo_title?exists>
    	<#if goods.seo_title?trim != ''>
    		<title>${goods.seo_title}</title>
    	<#else>
	    	<title>${goods.goodsName?default('')}-111医药馆-要健康 要美丽 要时尚-医卡通买药价格低便宜实惠-国家药监局指定壹壹壹医药馆网上连锁药店</title>
    	</#if>
    <#else>
    	<title>${goods.goodsName?default('')}-111医药馆-要健康 要美丽 要时尚-医卡通买药价格低便宜实惠-国家药监局指定壹壹壹医药馆网上连锁药店</title>
    </#if>
    
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/> 
    <link rel="icon" type="image/png" href="/web/img/favicon.png">
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="/web/img/favicon-196x196.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="/web/img/apple-icon-touch.png">
    <meta name="msapplication-TileImage" content="/web/img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <link rel="stylesheet" type="text/css" href="/web/css/commonNew.css"/>
    <link rel="stylesheet" type="text/css" href="/web/css/footerNew.css"/>
    <link rel="stylesheet" type="text/css" href="/web/css/product.css"/>
    <link rel="stylesheet" type="text/css" href="/web/css/base.css"/>
    <#assign ui1 = "http://img.zdfei.com/"/>
    <#assign www = "http://www.111yao.com/"/>
    <#assign www1 = "http://www.111yao.com/p/"/>
</head>

<body>
	<input type="hidden" value="1" id="goodsdetail-turn"/>
	<input type="hidden" value="${goods.id?c?default('')}" id="trun-gid" />
	<!--#include virtual="/static/inc/header.html" -->
	
	
	<!------------------------------------------------------------------------------------------------------------------------------------------>
	<link rel="stylesheet" type="text/css" href="/web/css/commonNew.css">
	<link rel="stylesheet" type="text/css" href="/web/css/header-new.css">
	<link rel="stylesheet" type="text/css" href="/web/css/footer-new.css">
	<script type="text/javascript" src="/web/js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/web/css/jq-alert-confirm.css">
	<link rel="stylesheet" type="text/css" href="/web/css/jquery-ui.css">
	<script type="text/javascript" src="/web/js/jq-alert-confirm.js"></script>
	<script type="text/javascript" src="/web/js/cookieUtil.js"></script>
	<script type="text/javascript" src="/web/js/common.js"></script>
	<script type="text/javascript" src="/web/js/categoryhover.js"></script>
	<script type="text/javascript" src="/web/js/search.js"></script>
	<script type="text/javascript" src="/web/js/ismobile.js"></script>
	<!------------------------------------------------------------------------------------------------------------------------------------------>
	
	
	
    <!--商品详情开始-->
    <div class="product-box">
    	<!--商品详情信息开始-->
    	<div class="details-info">
			<!--#include virtual="/static/imgout/goods_detail_ads.html" -->
        	<div class="w1210">
                <div class="bread-nav">
                		<#list listpc?if_exists as resc>
    		                <#if resc_index == 0>
	    		                <a href="${www}${resc.id?default('')}/list.html" class="bread-column">${resc.name?default('')}</a>
                        	<#else>
			                    <em>&gt;</em><a href="${www}${resc.id?default('')}/list.html">${resc.name?default('')}</a>
                        	</#if>
				    	</#list>
				    <em>&gt;</em><a href="#">${goods.goodsName?default('')}</a>
                </div>
                <div class="details-box w1210 clearfix clear">
                    <!--产品参数开始-->
                    <div class="magnifier">
                    <div id="preview" class="spec-preview">
						<span class="jqzoom">
                   			<img class="pro-img" jqimg="${ui1}${goods.defaultimg?default('')}" src="${ui1}${goods.defaultimgs?default('')}350x350.jpg" />
                   		</span>  
                    </div>
                    <!--缩图开始-->
                    <div class="spec-scroll clearfix"> <a class="prev">&lt;</a> <a class="next">&gt;</a>
                      <div class="items">
                        <ul>
                        <#list listi?if_exists as resc>
                        	<li><img alt="图片" bimg="${ui1}${resc.artworkUrl?default('')}" src="${ui1}${resc.imageUrl?default('')}350x350.jpg" onmousemove="preview(this);"></li>
					    </#list>
                        </ul>
                      </div>
                    </div>
                    <!--缩图结束-->
                   <div class="share-interest">
                        <a href="javascript:;" class="interest-btn" style="float:right;margin-top:3px;"><span class="attention-img"></span>&nbsp;关注商品</a>
                        <div class="bdsharebuttonbox" style="width:145px;float:right;margin-right:-35px;"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone"></a><a href="#" class="bds_tsina" data-cmd="tsina"></a><a href="#" class="bds_tqq" data-cmd="tqq"></a><a href="#" class="bds_renren" data-cmd="renren"></a><a href="#" class="bds_weixin" data-cmd="weixin"></a></div>
                    </div>
                  </div>
                  <!--产品参数结束-->
                  <div class="details-info-text">
                  	<div class="add-list-fk">
                    	<ul>
                        	<li class="fk01"><b></b>国家认证</li>
                            <li class="fk02"><b></b>连锁百强</li>
                            <li class="fk03"><b></b>GSP认证</li>
                            <li class="fk04"><b></b>满99包邮</li>
                            <li class="fk05"><b></b>货到付款</li>
                        </ul>
                    </div>
                    <input type="hidden" value="${goods.id?c?default('')}" id="gid">
                    <input type="hidden" value="${goods.abbreviation_picture?default('')}" id="goodaimg">
                    <input type="hidden" value="${goods.goodsName?default('')}" id="goodsName">
                    <input type="hidden" value="${goods.pcPrice?default('')}" id="pcPrice">
                    
                    <h2 class="product-title">${goods.goodsName?default('')}</h2>
                    <p class="indications">${goods.mainTitle?default('')}</p>
                    <p class="details-text">通用名称：${goods.genericName?default('')}<b id="tymcid"></b></p>
                    <p class="details-text">产品编号：${goods.goodsno?default('')}</p>
                    <#if goods.approvalNumber?default('')!=''>
	                    <p class="details-text">批准文号：${goods.approvalNumber?default('')}</p>
	            	</#if>
                    <p class="details-text">生产厂家：<span>${goods.manufacturer?default('')}</span></p>
                    <div class="details-price">
                        <div class="evaluate-count">
                            累计评价<p id="ztsspanid2"></p>
                        </div>
                        <div class="price-text clearfix clear"><span>市场价格：</span><i>¥&nbsp;${goods.price?default('')}</i></div>
					    <div class="price-text clearfix clear"><span id="jgmcid">本站价格：</span><b class="product-price" id="pcPrice1">¥&nbsp;${goods.pcPrice?default('')}</b></div>
                        <div class="price-text clearfix clear" id="promotiondivid" style="display: none">
                            <span>促销信息：</span>
                            <div class="promotion-info" id="promotiondividval">
                            </div>   
                        </div>
                    </div>
	                    <dl class="choice-details clearfix clear" id="cpggids">
	                        <dt>产品规格：</dt>
	                        <dd>
	                            <ul class="clearfix clear">
		                            <#list lists?if_exists as resc>
			                            <li><a href="${www1}${resc.id?c?default('')}.html" id="specid${resc.id?c?default('')}">${resc.spec?default('')}</a></li>
							    	</#list>
	                            </ul>
	                        </dd>
	                    </dl>
                    <div class="product-btn clearfix clear">
                        <div class="cart-product-count fl" id="jiajian">
                            <a href="javascript:void(0)" class="count-plus" id="count-plus" >+</a>
                            <a href="javascript:void(0)" class="count-minus" id="count-minus" >-</a>
                            <input class="count-text" readonly="readonly" type="text" value="1" maxlength="8" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
                        </div>
                        <a href="javascript:void(0)" onclick="javascript:add(${goods.id?c})" class="into-cart-btn" id="jrgwc">加入购物车</a>
                        <a href="javascript:void(-1)" onclick="shortBug(${goods.id?c})" class="buy-now-btn" id="ljgm">立即购买</a>
                    </div>
                    <div class="product-btn clearfix clear">
                    	<div class="call-back-tel clearfix">
                            <a href="javascript:void(0);" class="call-back-btn" onclick="callBack();">回拨电话</a>
                            <input class="call-bakc-tel-num" type="text" id="callid" value="请输入联系电话" 
                            onfocus="javascript:if(this.value=='请输入联系电话'){ this.value='';this.style.color='#333'}" 
                            onblur="javascript:if(this.value==''){ this.value='请输入联系电话';this.style.color='#c0c9ca'}" 
                            maxlength="11" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
                        </div>
                    </div>
                    	<div class="pay-way-show">
	                    	<dl class="clearfix clear">
	                        	<dt>支付方式：</dt>
	                            <dd class="clearfix" id="zffsid">
	                                <a class="way2" href="#">微信支付</a>
	                                <a class="way3" href="#">支付宝</a>
	                                <a class="way4" href="#">闪钱包</a>
	                            </dd>
	                        </dl>
	                    </div>
	                    <style>
						.pay-way-show{color:#585858; margin:15px 0;}
	                    .pay-way-show dt{float:left; margin-right:10px;}
						.pay-way-show dd a{height:18px; line-height:18px; margin-right:20px; display:inline-block; background:url(/web/img/payway_ico.png) no-repeat; float:left; padding-left:25px;}
						.pay-way-show dd a:hover{color:#00a6a0;}
						.pay-way-show dd a.way1{background-position:0 0;}
						.pay-way-show dd a.way2{background-position:0 -18px;}
						.pay-way-show dd a.way3{background-position:0 -36px;}
						.pay-way-show dd a.way4{background-position:0 -54px;}
	                    </style>
                  </div>
                </div>
                </div>
            </div>
            <!--商品详情信息结束-->
           	<!--推荐开始-->
           	<#if listg?if_exists?size gt 0>
            <div class="details-recommend w1210 mt10">
            	<!--推荐列表开始-->
                        <div class="product-list-main mt10">
                        	<div id="tab">
                                <div class="product-list-title clearfix clear">
                                    <ul class="product-list-tag clearfix" id="tab-hd2">
                                    <#list listg?if_exists as resc>
                                    	<#if resc_index == 0>
	                                        <li class="active2">优惠套餐${resc_index+1}</li>
                                    	<#else>
	                                        <li>优惠套餐${resc_index+1}</li>
                                    	</#if>
                                    </#list>
                                    </ul>
                                </div>
                                <div class="clearfix clear" id="tab-bd2">
                                <#list listg?if_exists as resc>
                                    <!--推荐1开始-->
                                    <div class="recommend-combination clearfix clear">
                                        <div class="combination-sum fr">
                                            <span class="equal fl"></span>
                                            <div class="all-combination-price">
                                                <p class="combination-price"><span>套餐价：</span><b>￥${resc.pcPrice?default('')}</b></p>
                                                <p class="original-price"><span>原价：</span><b>￥${resc.price?default('')}</b></p>
                                                <p class="saved-price"><span>立即节省：</span>￥${resc.price-resc.pcPrice?default('')}</p>
                                                <p class="combination-buy"><a href="javascript:;" onclick="shortBug(${resc.id?c})">立即购买</a></p>
                                            </div>
                                        </div>
                                        <ul class="combination-list">
                                        
                                        <#list resc.list?if_exists as resc1>
	                                        <#if !resc1_has_next>
		                                        <li>
	                                                <a href="${www1}${resc1.goodsid?c?default('')}.html">
	                                                    <img src="${ui1}${resc1.abbreviationPicture?default('')}"/>
	                                                    <p class="combination-list-text">
	                                                       ${resc1.short_name?default('')} 
	                                                    </p>
	                                                    <p class="combination-list-price">
	                                                        <span>¥${resc1.pcPrice?default('')} </span>
	                                                    </p>
	                                                </a>
	                                            </li>
	                                        <#else>
	                                            <li>
	                                                <a href="${www1}${resc1.goodsid?c?default('')}.html">
	                                                    <img src="${ui1}${resc1.abbreviationPicture?default('')}"/>
	                                                    <p class="combination-list-text">
	                                                       ${resc1.short_name?default('')} 
	                                                    </p>
	                                                    <p class="combination-list-price">
	                                                        <span>¥${resc1.pcPrice?default('')} </span>
	                                                    </p>
	                                                </a>
	                                            </li>
	                                            <li>
	                                                <span class="plus"></span>
	                                            </li>
	                                        </#if>
                                    	</#list>
                                        </ul>
                                    	<#if resc.is_view==0>
	                                        <div class="recommendation clearfix clear">
	                                            <b class="recommendation-corner"></b>
	                                            <p class="recommendation-tips">推荐点评</p>
	                                            <dl class="recommendation-info">
	                                                <dt>
	                                                    <img src="${ui1}${resc.head_url?default('')}"/>
	                                                    <span>${resc.real_name?default('')}<br/><i>${resc.work_year?default('')}年药师经验</i></span>
	                                                </dt>
	                                                <dd>${resc.comment_content?default('')}</dd>
	                                            </dl>
	                                        </div>
                                    	</#if>
                                    </div>
                                    <!--推荐1结束-->
                                    </#list>
                                </div>
                            </div>
                        </div>
                        <!--推荐列表结束-->
            </div>
            </#if>
            <!--推荐结束-->
            <div class="w1210 mt10">
            	<div class="product-box">
                    <!--右侧主体开始-->
                    <div class="product-main">
                        <div class="product-main-wrap">
                            <div class="product-relevant">
                                <!--推荐列表开始-->
                                <div class="product-list-main">
                                    <div id="tab">
                                        <div class="product-list-title clearfix clear">
                                            <ul class="product-list-tag clearfix" id="tab-hd3">
                                                <li class="active2">商品介绍</li>
                                                <li>说明书</li>
                                                <li>荣誉资质</li>
                                                <li>用户评价<span class="assess-count" id="ztsspanid"></span></li>
                                                <li>相关问答</li>
                                            </ul>
                                        </div>
                                        <div class="clearfix clear" id="tab-bd3">
                                            <!--商品介绍开始-->
                                            <div class="recommend-combination clearfix clear">
                                            	<div class="introduce-box">
                                            		<!--<p><img src="http://img.zdfei.com/static/image/temp/20160202/019ad5734e114eda9931bf86898477ee.jpg" alt="服务公告"/></p>-->
                                            		<#if goods.goodsDescribes?default('')!=''>
	                                            		${goods.goodsDescribes?default('')}
	                                            	<#else>
	                                            		<img src="http://img.zdfei.com/static/image/temp/20160129/35214c817c8e09df0d2c95761a43e8af.jpg"/>
									            	</#if>
                                                </div>
                                            </div>
                                            <!--商品介绍结束-->
                                            <!--说明书开始-->
                                            <div class="recommend-combination clearfix clear">
                                                <div class="introduce-box">
                                                	${goods.instructions?default('')}
                                                </div>
                                            </div>
                                            <!--说明书结束-->
                                            <!--资质证明开始-->
                                            <div class="recommend-combination clearfix clear">
                                                <div class="introduce-box seniority-box">
                                                	<img src="http://img.zdfei.com/static/image/temp/20160129/35214c817c8e09df0d2c95761a43e8af.jpg"/>
                                                </div>
                                            </div>
                                            <!--资质证明结束-->
                                            <!--资质证明开始-->
                                            <div class="recommend-combination clearfix clear">
                                                <div class="introduce-box assess-box">
                                                	<h2>商品评价</h2>
                                                    <div class="assess-scaling clearfix clear">
                                                    	<div class="scaling">
                                                        	<strong id="hpds"></strong>
                                                            <p>好评度</p>
                                                        </div>
                                                        <div class="percent">
                                                            <dl>
                                                                <dt>好评<span id="hpds1"></span></dt>
                                                                <dd>
                                                                <div id="divh">
                                                                </div>
                                                                </dd>
                                                            </dl>
                                                            <dl>
                                                                <dt>中评<span id="zpds"></span></dt>
                                                                <dd class="d1">
                                                                <div id="divz">
                                                                </div>
                                                                </dd>
                                                            </dl>
                                                            <dl>
                                                                <dt>差评<span id="cpds"></span></dt>
                                                                <dd class="d1">
                                                                <div id="divc">
                                                                </div>
                                                                </dd>
                                                            </dl>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--评价列表开始-->
                                <div class="product-list-main mt10" id="qbpjids">
                                    <div id="tab">
                                        <div class="product-list-title clearfix clear">
                                            <ul class="product-list-tag clearfix" id="tab-hd4">
                                                <li class="active2" onclick="tabonc(0)">全部评价<span id="ztsspanid1"></span></li>
                                                <li onclick="tabonc(1)">好评<span id="bestid"></span></li>
                                                <li onclick="tabonc(2)">中评<span id="betterid"></span></li>
                                                <li onclick="tabonc(3)">差评<span id="poorid"></span></li>
                                            </ul>
                                        </div>
                                        <!--assess title start-->
                                        <div class="assess-title">
                                        	<div class="w380">
                                            	<span>评价心得</span>
                                        	</div>
                                        	<div class="w328">
                                            	<span>顾客满意度</span>
                                            </div>
                                            <div class="w300 assess-p">
                                            	<span class="pl40">评论者</span>
                                            </div>
                                        </div>
                                        <!--assess title end-->
                                        <div class="clearfix clear" id="tab-bd4">
                                            <!--全部评价开始-->
                                            <div class="recommend-combination clearfix clear">
                                                <div class="assess-details clearfix clear">
                                                    <ul class="assess-details clearfix clear" id="allData0">
                                                    </ul>
                                                </div>
                                            </div>
                                            <!--全部评价结束-->
                                            <!--好评开始-->
                                            <div class="recommend-combination clearfix clear">
                                                <div class="assess-details clearfix clear">
                                                    <ul class="assess-details clearfix clear" id="allData1">
                                                    </ul>
                                                </div>
                                            </div>
                                            <!--好评结束-->
                                            <!--中评开始-->
                                            <div class="recommend-combination clearfix clear">
                                                <div class="assess-details clearfix clear">
                                                    <ul class="assess-details clearfix clear" id="allData2">
                                                    </ul>
                                                </div>
                                            </div>
                                            <!--中评结束-->
                                            <!--差评开始-->
                                            <div class="recommend-combination clearfix clear">
                                                <div class="assess-details clearfix clear">
                                                    <ul class="assess-details clearfix clear" id="allData3">
                                                    </ul>
                                                </div>
                                            </div>
                                            <!--差评结束-->
                                        </div>
                                        <div class="page-box details-page clearfix clear" id="divpagingid2">
                                        	<!--#include virtual="/static/inc/paging.html" --> 
                                        </div>
                                    </div>
                                </div>
                                <!--评价列表结束-->
                                            </div>
                                            <!--资质证明结束-->
                                            <!--资质证明开始-->
                                            <div class="recommend-combination clearfix clear">
                                                <div class="introduce-box question-box">
                                                	<ul id="consultULId">
                                                    </ul>
                                                </div>
                                                <div class="page-box details-page clearfix clear" id="divpagingid1">
                                                	<!--#include virtual="/static/inc/paging1.html" --> 
                                                </div>
                                                <!--发表咨询开始-->
                                                <div class="submit-question">
                                                	<h5>发表咨询</h5>
                                                    <dl class="input-question clearfix clear">
                                                    	<dt>咨询内容：</dt>
                                                        <dd class="clearfix">
                                                        	<div class="input-area">
                                                            	<textarea maxlength="100" id="zxvalid"></textarea>
                                                            </div>
                                                            <p class="question-tips">咨询内容长度在4-100字之间</p>
                                                            <p><a href="javascript:void(0);" class="submit-question-btn fr" onclick="zixun();">提交</a></p>
                                                        </dd>
                                                    </dl>
                                                </div>
                                                <!--发表咨询结束-->
                                            </div>
                                            <!--资质证明结束-->
                                        </div>
                                    </div>
                                </div>
                                <!--推荐列表结束-->
                            </div>
                        </div>
                    </div>
                    <!--右侧主体结束-->
                    
                    <div class="product-sub">
                        <div class="product-sider">
							<!--#include virtual="/static/imgout/product_detail_ads.html" -->
                            <!--热销商品开始-->
                            <div class="product-sider-info">
                                <h2 class="product-sider-title">热销商品</h2>
                                <ul class="product-sider-list" id="hotsproducts">
                                </ul>
                            </div>
                            <!--热销商品结束-->
                            <!--我的浏览历史开始-->
                            <div class="product-sider-info">
                                <h2 class="product-sider-title">我的浏览历史</h2>
                                <ul class="product-sider-list" id="myprohisview">
                                </ul>
                            </div>
                            <!--我的浏览历史结束-->                  
                        </div>
                    </div>
                </div>
            </div>
        
    </div>
    <!--商品详情结束-->
    <!--#include virtual="/static/inc/footer.html" -->
    <!--#include virtual="/static/inc/ceng.html" -->
    
    <script type="text/javascript" src="/web/js/productNew.js"></script>
    <script type="text/javascript" src="/web/js/jquery.jqzoom.js"></script>
    <script type="text/javascript" src="/web/js/base.js"></script>
    <script type="text/javascript" src="/web/js/cookieUtil.js"></script>
    <script type="text/javascript" src="/web/js/product-view-history.js"></script>
    <script type="text/javascript" src="/web/js/hots-product.js"></script>
    <script type="text/javascript" src="/web/js/product.main.js"></script>
    <script type="text/javascript" src="/web/js/cart.js"></script>
	<script>goodsDetailRecomm();</script>
	<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
</body>	
</html>