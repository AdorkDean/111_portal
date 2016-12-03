<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
 <#include "/WEB-INF/pages/inc/taglibs.ftl">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="">
    <!-- keywords -->
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>品牌搜索列表</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/> 
    <link rel="icon" type="${base}/web/image/png" href="${base}/web/img/favicon.png">
    
    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="${base}/web/img/favicon-196x196.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="${base}/web/img/apple-icon-touch.png">
    
    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="${base}/web/img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    
   

</head>

<body>
<#include "/static/inc/header.ftl">
 <!--style-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css">
           <!--header-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/header-new.css">
    <!--footer-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/footerNew.css">
    <!--product-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/product.css">
    <!--treeview-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/jquery.treeview.css">
	<!--商品模块开始-->
    <div class="w1210 mt10">
		<div class="product-box">
        	<!--右侧主体开始-->
			<div class="product-main">
				<div class="product-main-wrap">
					<div class="product-relevant">
                    	<div class="product-screening clearfix clear">
                        	<!--面包屑导航开始-->
                        	<div class="location-bread clearfix">
                            	<div class="relevant-count fr">相关商品：<span><#if pw?exists>${pw.pageInfo.count?default(0)}<#else>0</#if></span>件</div>
                            	<a href="${base}/${brandkey?default('')}/blist.html"><#if brand?exists>${brand.brandName?default('')}</#if></a>
                                <b class="location-corner"></b>
                            </div>
                            <!--面包屑导航结束-->
                            <!--品牌、公司介绍开始-->
                            <dl class="brand-info-text clearfix clear">
                            	<#if brand?exists><#if brand.logo?default('')!=''><dt><img src="${ui1}${brand.logo?default('')}"/></dt></#if></#if>
                                <dd><#if brand?exists>${brand.brandInfo?default('')}</#if></dd>
                            </dl>
                            <!--品牌、公司介绍结束-->
                            <!--品牌筛选开始-->
                            <div class="filter-list">
                            	<div class="filter-title"><span>品牌：</span></div>
                                <div class="filter-main">
                                	<div class="filter-list-type multi-line clearfix">
                                        <ul class="clearfix clear" id="brandId">
                                            <li><a id="${brand.id?default()}" href="${base}/${Url_C?default('')}/blist${Url_E?default('')}${type?default('')}${Url_G?default('')}${pricea?default('')}${Url_H?default('')}${priceb?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" >${brand.brandName?default('')}</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <a class="filter-brand-more" href="#">
                                    <b></b><span>更多</span>
                                </a>
                            </div>
                            <!--品牌筛选结束-->
                            <!--类型筛选开始-->
                            <div class="filter-list">
                            	<div class="filter-title"><span>类型：</span></div>
                                <div class="filter-main">
                                	<div class="filter-list-type one-line clearfix">
                                        <ul class="clearfix clear">
                                            <li><a href="${base}/${Url_C?default('')}/blist${Url_F?default('')}${brandid?default('')}${Url_G?default('')}${pricea?default('')}${Url_H?default('')}${priceb?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" <#if type?default('')==''>class="curr"</#if>>全部</a></li>
                                            <li><a href="${base}/${Url_C?default('')}/blist-d1${Url_G?default('')}${pricea?default('')}${Url_H?default('')}${priceb?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" <#if type?default('')=='1'>class="curr"</#if>>OTC</a></li>
                                            <li><a href="${base}/${Url_C?default('')}/blist-d2${Url_G?default('')}${pricea?default('')}${Url_H?default('')}${priceb?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" <#if type?default('')=='2'>class="curr"</#if>>处方药</a></li>
                                            <li><a href="${base}/${Url_C?default('')}/blist-d3${Url_G?default('')}${pricea?default('')}${Url_H?default('')}${priceb?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" <#if type?default('')=='3'>class="curr"</#if>>非药品</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!--类型筛选结束-->
                        
                            <!--价格筛选开始-->
                            <div class="filter-list">
                            	<div class="filter-title"><span>价格：</span></div>
                                <div class="filter-main">
                                	<div class="filter-list-type one-line clearfix">
                                        <ul class="price-filter-list clearfix"  id="priceRange1">
                                            <li><a href="${base}/${Url_C?default('')}/blist${Url_E?default('')}${type?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" <#if pricea?default('')==''&&priceb?default('')==''>class="curr"</#if>>全部</a></li>
                                            <li><a href="${base}/${Url_C?default('')}/blist${Url_E?default('')}${type?default('')}-f0-g40${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" id="0|40">0-40元</a></li>
                                            <li><a href="${base}/${Url_C?default('')}/blist${Url_E?default('')}${type?default('')}-f40-g100${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" id="40|100">40-100元</a></li>
                                            <li><a href="${base}/${Url_C?default('')}/blist${Url_E?default('')}${type?default('')}-f100-g200${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" id="100|200">100-200元</a></li>
                                        </ul>
                                        <div class="input-price-filter clearfix">
                                            <input type="text"  id="startPriceII" value="${pricea?default('')}" ><span>-</span><input type="text" id="endPriceII"  value="${priceb?default('')}">
                                            <a href="#" id="SubPrice" class="price-filter-btn">确定</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--价格筛选结束-->
                            <!--相关搜索开始-->
                        </div>
                        <!--商品列表开始-->
                        <div class="product-list-main mt10">
                        	<div class="product-list-title clearfix clear">
                            	<ul class="product-list-tag clearfix">
                                	<li class="pitch-on">商品列表</li>
                                </ul>
                            </div>
                            <!--排序筛选开始-->
                            <div id="tab">
                            	<div class="sort-filter">
                                    <ul class="sort-filter-tag clearfix" id="tab-hd">
                                        <li id="id_a" onclick="set('id_a')" <#if sort?default('0')=='0'> class="active"</#if> ><#if sort?default('0')=='0'><i <#if orderby?default('1')=='1'>class="up"<#else>class="down"</#if> ></i></#if>默认</li>
                                        <li id="click_a"  onclick="set('click_a')" <#if sort?default('0')=='1'> class="active"</#if>><#if sort?default('0')=='1'><i <#if orderby?default('1')=='1'>class="up"<#else>class="down"</#if> ></i></#if>评价</li>
                                        <li id="price_a" onclick="set('price_a')" <#if sort?default('0')=='2'> class="active"</#if>><#if sort?default('0')=='2'><i <#if orderby?default('1')=='1'>class="up"<#else>class="down"</#if> ></i></#if>价格</li>
                                        <li id="salesvolume_a" onclick="set('salesvolume_a')" <#if sort?default('0')=='3'> class="active"</#if>><#if sort?default('0')=='3'><i <#if orderby?default('1')=='1'>class="up"<#else>class="down"</#if> ></i></#if>销量</li>
                                    </ul>
                                </div>
                                
                    	<input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default()}" id="p_curPage">
		    			<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(40)}" id="pageSize">
		    			<input type="hidden" name="type" id="type" value="${type?default('')}" >
		    			<input type="hidden" name="brandkey" id="brandkey" value="${brandkey?default('')}" >
						<input type="hidden" id="pricea" name="pricea" value="${pricea?default('')}"/>      
						<input type="hidden" id="priceb" name="priceb" value="${priceb?default('')}"/>      
						<input type="hidden" id="sort" name="sort" value="${sort?default('')}"/>       
						<input type="hidden" id="orderby" name="orderby" value="${orderby?default('')}"/>   <!--排序 1升序 2降序-->
						<input type="hidden" id="url_C" name="Url_C" value="${Url_C?default('')}"/>       
						<input type="hidden" id="url_E" name="Url_E" value="${Url_E?default('')}"/>     
						<input type="hidden" id="url_F" name="Url_F" value="${Url_F?default('')}"/>     
						<input type="hidden" id="url_G" name="Url_G" value="${Url_G?default('')}"/>       
						<input type="hidden" id="url_H" name="Url_H" value="${Url_H?default('')}"/>       
						<input type="hidden" id="url_I" name="Url_I" value="${Url_I?default('')}"/>       
						<input type="hidden" id="url_J" name="url_J" value="${url_J?default('')}"/>       
						<input type="hidden" id="url_K" name="url_K" value="${url_K?default('')}"/>       
						<input type="hidden" id="url_L" name="url_L" value="${url_L?default('')}"/>       
                                <div class="clearfix clear" id="tab-bd">
                                	<div class="filter-tag-info">
                                    	<ul class="filter-product-list clearfix clear">
                                    	<#list pw.result?if_exists as resc>
                                        	<li>
                                        	<#if resc.type?default(0)==2||resc.type?default(0)==3>
                                        		<b class="list-tag-rx"></b>
                                        	<#elseif resc.type?default(0)==1>
                                        		<b class="list-tag-otc"></b>
                                        	</#if>
                                            	<a class="product-list-link" title="${resc.goods_name?default('')}" target="_blank" href="${base}/p/${resc.id?default()}.html">
                                                	<img src="${ui1}${resc.abbreviation_picture?default('')}" />
                                                    <p class="product-list-price">
                                                    	<#if resc.pc_price?exists><span>¥${resc.pc_price?string('0.00')}</span></#if><i><#if resc.price?exists>¥${resc.price?string('0.00')}</#if></i>
                                                    </p>
                                                    <p class="product-list-text">
                                                    <#if resc.goods_name?length lt 15>   
														${resc.goods_name?default('')}
													<#else> 
     													${resc.goods_name[0..13]}... 
													</#if>
                                                    </p>
                                                </a>
                                                <div class="attention-into-cart clearfix clear">
                                                	<a href="javascript:;" id="atted-btn-${resc_index+1}" onclick="atted(${resc.id},${resc_index+1})" <#if resc.relevance_id?exists>class="pay-attention already"<#else>class="pay-attention"</#if>><i></i>关注</a>
                                                     <#if resc.type?default(0)==2||resc.type?default(0)==3>
                                                    <a target="_blank" href="${base}/p/${resc.id?default()}.html" class="list-into-cart"><i></i>立即预定</a>
                                                    <#else>
                                                    <a href="javascript:void(0);" id="${resc.id?default()}" class="list-into-cart btn-buy"><i></i>加入购物车</a>
                                                    </#if>
                                                </div>
                                            </li>
                                         </#list>   
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!--排序筛选结束-->
                            <!--分页开始-->
                          <#if pw.pageInfo.count?default(0)!=0>
                         <#include "/WEB-INF/pages/inc/pagebox_condition_brand.ftl">
                         </#if>
                            <!--分页结束-->
                        </div>
                        <!--商品列表结束-->
                        <!--推荐列表结束-->
                    </div>
				</div>
			</div>
            <!--右侧主体结束-->
            
			<div class="product-sub">
				<div class="product-sider">
                	<#include "/static/imgout/product_detail_ads.html">
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
    <!--商品模块结束-->
    <#include "/static/inc/footer.ftl">
</body>	
</html>

<script type="text/javascript" src="${base}/web/js/validate.js"></script>
<script type="text/javascript" src="${base}/web/js/productNew.js"></script>
<script type="text/javascript" src="${base}/web/js/list/catefirst_brand.js"></script>
<script type="text/javascript" src="${base}/web/js/cart.js"></script>
<script type="text/javascript" src="${base}/web/js/product-view-history.js"></script>
<script type="text/javascript" src="${base}/web/js/hots-product.js"></script>