<!doctype html>
<html>
<#include "/WEB-INF/pages/inc/taglibs.ftl">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="111医药馆网上药店是国家药监局认证指定网上药房|打造为老百姓服务药品价格低品种全|网上购药买药就选壹壹壹医药馆药品特卖网站">
    <!-- keywords -->
    <meta name="keywords" content="壹壹壹医药馆|壹药馆|11医药馆|1药馆|医卡通|111医药馆|医药网|药品特卖网站">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>111医药馆专做药品特卖的网站-医卡通买药价格低便宜实惠-国家药监局指定壹壹壹医药馆网上连锁药店</title>
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
    
    <!--common style-->
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/shopping.css">
    
    <style type="text/css" rel="stylesheet">
    	.empty_cart{padding:140px 0 0px 520px; background:#FFF url("${base}/web/version2.2.0/images/shopping/empty_cart.jpg") no-repeat 240px 10px;}
    	.guangguang{
    		background: #FE4310 none repeat scroll 0 0;
	    	border-radius: 4px;
		    color: #fff;
		    display: block;
		    float: left;
		    font-size: 18px;
		    font-weight: bold;
		    height: 37px;
		    line-height: 33px;
		    text-align: center;
		    width: 152px;
    	}
    	.empty{
    		border-radius: 10px;
		    color: #fff;
		    display: block;
		    float: left;
		    font-size: 18px;
		    font-weight: bold;
		    height: 37px;
		    line-height: 46px;
		    text-align: center;
		    width: 152px;
    	}
    	.guangguang{
    		margin-left: 52px;
    		margin-top: 16px;
    		cursor: pointer;
    		font-family:"Hiragino Sans GB","Microsoft YaHei","黑体",Arial,Helvetica,verdana,sans-serif;
    		text-shadow: 1px 1px 3px #0093ed;
    	}
    	.empty_word{
    		margin-left: 52px;
    		font-size: 24px;
    		width:300px;
    		font-family:"Hiragino Sans GB","Microsoft YaHei","黑体",Arial,Helvetica,verdana,sans-serif;
    		line-height: 36px;
    		font-weight:100;
    	}
        .mainlist li:hover .exchange{display:block}
        
        .footer{border-top: 0px solid #00aaa0;}
    </style> 
</head>
<body>
<#include  "/static/inc/version2.2.0/header.ftl"/>
	<!--购物车开始-->
    	<!--步骤开始-->
        	<div class="second-header w1000">
            	<div class="shopping-step clearfix">
                	<ul>
                        <li class="state-tip finish-tip"><b>1</b><span class="doing-tit">选择商品</span></li>
                        <li class="bra-line finish-line"></li>
                        <li class="state-tip"><b>2</b><span>填写核对订单</span></li>
                        <li class="bra-line"></li>
                        <li class="state-tip"><b>3</b><span>成功提交订单</span></li>
                        <li class="bra-line"></li>
                        <li class="state-tip"><b>4</b><span>完成订单</span></li>
                    </ul>
                </div>
        		<h2 class="second-logo">我的购物车</h2>
            </div>
        <!--步骤结束-->
        <!--购物车信息开始-->
        <div class="shopping-cart-main w1000">
        	<h2 class="shopping-cart-title clearfix clear">
            	<span style="border-bottom-width: 0px;color:#222;">全部商品</span>
            </h2>
            <input type="hidden" id="tcartId" value="<#if tcart?exists>${tcart.id?default('')}</#if>"/>
            <#if l?exists && l?size gt 0>
            
            <div class="shopping-cart-content">
            	<div class="shopping-cart-info-title clearfix clear">
                	<div class="w400"><span>商品</span></div>
                    <div class="w125"><span>价格（元）</span></div>
                    <div class="w150"><span>数量</span></div>
                    <div class="w125"><span>小计（元）</span></div>
                    <div class="w140"><span>&nbsp;</span></div>
                </div>
                <div class="shopping-cart-info-table">
                	<input id="imgUrl" type="hidden" value="${ui1}"/>
                	<ul id="itmUl">
                	
                		<#list l?if_exists as c >
                	
                    	<li class="<#if c.is_selected==1>bgred </#if>clearfix clear" id="record_${c.itemid?default(0)}">
                        	<div class="w400 clearfix">
                            	<div class="chioce-mark">
                                	<a href="javascript:void(0)" name="item_checkbox" <#if c.is_selected==1>class="current"</#if> cid="${c.itemid?default(0)}" id="check_${c.itemid?default(0)}"></a>
                                </div>
                                <a href="#" class="shopping-cart-p-details">
                                    <dl class="shopping-cart-info-text clearfix">
                                        <dt><a href="/p/${c.goodsid}.html" target="_new"><img src="${ui1}${c.image_url?default('')}"/></a></dt>
                                        <dd>
                                            <p class="shopping-cart-info-text-title"><a href="/p/${c.goodsid}.html" target="_new">${c.goods_name?default('')}</a></p>
                                            <p class="shopping-cart-info-text-spec">${c.spec?default('')}</p>
                                        </dd>
                                        <#if c.ykt_flag?exists && c.ykt_flag=='1'>
                                        <dd>&nbsp;</dd>
											<#else>
	                                        <dd>
	                                            <span>（不支持医卡通支付）</span>
	                                        </dd>
                                        </#if>
                                    </dl>
                                </a>
                            </div>
                            <div class="w125">
                            	<p class="shopping-cart-info-price" id="price_${c.itemid?default(0)}">${c.pc_price?string("0.00")}</p>
                            </div>
                            <div class="w150">
                            	<div class="shopping-cart-count" style="margin-bottom: 0px;">
                                	<a href="javascript:void(0)" onclick="update(${c.itemid},${c.goodsid},2,1)" class="minu">-</a>
                                	<input type="text" onKeyUp="validateMaxMoney(this)" name="kuang" value="${c.quantity?default('1')}" gid="${c.goodsid}"  id="count_${c.itemid?default(0)}" maxlength="5">
                                	<a href="javascript:void(0)" onclick="update(${c.itemid},${c.goodsid},1,1)" class="plus">+</a>
                                	<div  style="display:none">${c.quantity?default('')}_${c.itemid}</div>
                                </div>
                                <div id="tip_${c.itemid}" style="text-align: center;color:red;margin-top: 2px;" class="buzu"></div>
                            </div>
                            <div class="w125">
                            	<p class="shopping-cart-info-price" id="heji_${c.itemid?default(0)}"><b>${(c.quantity*c.pc_price)?string("0.00")}</b></p>
                            </div>
                            <div class="w140">
                            	<div class="shopping-cart-operate">
                                    <#--<a href="javascript:void(0)" class="shopping-cart-collect"></a>-->
                                    <a href="javascript:void(0)" onclick="del(${c.itemid?default(0)})" class="shopping-cart-delete"></a>
                                </div>
                            </div>
                        </li>
                        </#list>
                        
                        
                    </ul>
                </div>
            </div>
            <#else>
            	<div class="empty_cart">
            		<#--<img class="empty_img" src="${base}/web/version2.2.0/images/shopping/empty_cart.jpg">-->
            		<div style="height:180px;width:300px;margin-top: -30px;">
	            		<div class="empty_word" style="color:#3D3D3D">
	            			购物车是空的,<br/>&nbsp;&nbsp;快去添加吧!
	            		</div>
	            		<div  class="guangguang"><a style="color:#fff;" href="/">马上去逛逛</a></div>
            		</div>
            	</div>
            </#if>
        </div>
        <!--购物车信息结束-->
        <!--购物车结算信息开始-->
        <#if l?exists && l?size gt 0>
        <div class="shopping-cart-settlement" style="margin-top:<#if l?exists && l?size = 1>160px;<#elseif l?exists && l?size = 2>80px;</#if>">
        	<div class="w1000 clearfix clear">
            	<div class="shopping-cart-settlement-info clearfix clear">
                	<a href="#" id="jiesuanBtn" class="shopping-cart-settlement-btn">立即结算</a>
                	<div class="shopping-cart-settlement-info-text clearfix">
                    	<span>已选择<i><b id="g-count">-</b></i>件商品</span>
                        <span>总计（不含运费）<b>¥&nbsp;<span id="money" >---</span>元</b></span>
                    </div>
                </div>
            	<ul class="shopping-cart-choice">
                    <li class="clearfix clear">
                        <div class="y-chioce-mark">
                            <a href="javascript:void(0)" class="<#if ifYkt?exists&&ifYkt==1>current</#if>" id="ykt_only" cid="<#if tcart?exists>${tcart.id?default('')}</#if>"></a>
                        </div>
                        <label>仅选择医卡通支付商品</label>
                    </li>
                    <li class="clearfix clear">
                        <div class="all-chioce-mark">
                            <a id="all_only" href="javascript:void(0)" class="<#if ifYkt?exists&&ifYkt==2>current</#if>" cid="<#if tcart?exists>${tcart.id?default('')}</#if>"></a>
                        </div>
                        <label>全选</label>
                    </li>
            	</ul>
            </div>
        </div>
        </#if>
        <!--购物车结算信息结束-->
        <!-- 左右滚动部分 begin -->
        <div class="relevant-product w1000" style="margin-top:10px;">
            <h2 class="shopping-cart-title clearfix clear">
                <span>推荐商品</span>
            </h2>
            <div class="scroll">
            <div class="picbox">
                <ul class="piclist mainlist">
                </ul>
                <ul class="piclist swaplist"></ul>
            </div>
            <div class="og_prev"></div>
            <div class="og_next"></div>
        </div>
    </div>
    <!-- 左右滚动部分 end -->
    <!--购物车结束-->
    
    <!--js-->
    <script type="text/javascript" src="${base}/web/js/goods-recommend_cart.js"></script>
    <script type="text/javascript" src="${base}/web/version2.2.0/js/shopping.js"></script>
    
    <#include  "/static/inc/version2.2.0/footer.ftl"/>
    <style type="text/css" rel="stylesheet">
        .footer{border-top: 0px solid #00aaa0;}
    </style> 
    <script>

money();
checkEmpty();
islogin();
cartRecomm();
checkedStatus();
checkChoose();

</script>
</body>
</html>
