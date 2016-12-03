<!doctype html>
<html>
<head>
<#include "/WEB-INF/pages/inc/taglibs.ftl">
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
    <link rel="icon" type="image/png" href="${base}/web/version2.2.0/images/common/favicon.png">
    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="${base}/web/version2.2.0/images/common/favicon.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="${base}/web/version2.2.0/images/common/favicon.png">    
    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="${base}/web/version2.2.0/images/common/favicon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <!--common style-->
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/common.css">
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/index.css">
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/shopping.css">
     <style>.mainlist li:hover .exchange{display:block}</style>
    <!--common js-->
    <script src="${base}/web/version2.2.0/js/jquery.min.js"></script>
    <script type="text/javascript" src="${base}/web/version2.2.0/js/superslide.2.1.js"></script>
    <script type="text/javascript" src="${base}/web/js/validate.js"></script>
	<script type="text/javascript" src="${base}/web/js/list/catefirst_yiyao.js"></script>
	<script type="text/javascript" src="${base}/web/js/cart.js"></script>
	<script type="text/javascript" src="${base}/web/js/productNew.js"></script>
	<script type="text/javascript" src="${base}/web/js/product-view-history.js"></script>
	<script type="text/javascript" src="${base}/web/js/hots-product.js"></script>
	

</head>

<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/search_box.html">
<#include "/static/inc/version2.2.0/product_category.html">
    <!--搜索列表开始-->
    <div class="list-box">
    	<div class="w1090 clearfix clear">
            <!--面包屑导航开始-->
            <div class="location-bread clearfix">
                    <#list cate1List?if_exists as resc>
                 	 <a href="${base}/${brandcate?default('')}/${resc.id?default()}/ylist.html"><span class="location-curr">${resc.categoryName?default('')}</span></a>
                    <em>&gt;</em>
                  </#list>
            </div>
            <!--面包屑导航结束-->
            
            
               <input type="hidden" id="categoryid" name="categoryid" value="${categoryid?default('')}"/>  
					   <input type="hidden" id="brandcate" name="brandcate" value="${brandcate?default(0)}"/>  
                    	<input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default()}" id="p_curPage">
		    			<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(40)}" id="pageSize">
		    			<input type="hidden" name="type" id="type" value="${type?default('')}" >
		    			<input type="hidden" id="brandid" name="brandid" value="${brandid?default('')}"/>
						<input type="hidden" id="pricea" name="pricea" value="${pricea?default('')}"/>      
						<input type="hidden" id="priceb" name="priceb" value="${priceb?default('')}"/>      
						<input type="hidden" id="sort" name="sort" value="${sort?default('')}"/>       
						<input type="hidden" id="orderby" name="orderby" value="${orderby?default('')}"/>   <!--排序 1升序 2降序-->
						<input type="hidden" id="url_A" name="Url_A" value="${Url_A?default('')}"/>      
						<input type="hidden" id="url_D" name="Url_D" value="${Url_D?default('')}"/>  
						<input type="hidden" id="url_E" name="Url_E" value="${Url_E?default('')}"/>     
						<input type="hidden" id="url_F" name="Url_F" value="${Url_F?default('')}"/>     
						<input type="hidden" id="url_G" name="Url_G" value="${Url_G?default('')}"/>       
						<input type="hidden" id="url_H" name="Url_H" value="${Url_H?default('')}"/>       
						<input type="hidden" id="url_I" name="Url_I" value="${Url_I?default('')}"/>       
						<input type="hidden" id="url_J" name="url_J" value="${url_J?default('')}"/>       
						<input type="hidden" id="url_K" name="url_K" value="${url_K?default('')}"/>       
						<input type="hidden" id="url_L" name="url_L" value="${url_L?default('')}"/>      
            <div class="filter-box">
                			<!--类型筛选开始-->
                            <div class="filter-list">
                            	<div class="filter-title"><i class="filter-type"></i><span>类型：</span></div>
                                <div class="filter-main">
                                	<div class="filter-list-type one-line clearfix">
                                        <ul class="clearfix clear">
                                        	 <li><a href="${base}/${Url_D?default('')}/${Url_A?default('')}/ylist${Url_F?default('')}${brandid?default('')}${Url_G?default('')}${pricea?default('')}${Url_H?default('')}${priceb?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" <#if type?default('')==''>class="curr"</#if>>全部</a></li>
                                            <li><a href="${base}/${Url_D?default('')}/${Url_A?default('')}/ylist-d1${Url_F?default('')}${brandid?default('')}${Url_G?default('')}${pricea?default('')}${Url_H?default('')}${priceb?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" <#if type?default('')=='1'>class="curr"</#if>>OTC</a></li>
                                            <li><a href="${base}/${Url_D?default('')}/${Url_A?default('')}/ylist-d2${Url_F?default('')}${brandid?default('')}${Url_G?default('')}${pricea?default('')}${Url_H?default('')}${priceb?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" <#if type?default('')=='2'>class="curr"</#if>>处方药</a></li>
                                            <li><a href="${base}/${Url_D?default('')}/${Url_A?default('')}/ylist-d3${Url_F?default('')}${brandid?default('')}${Url_G?default('')}${pricea?default('')}${Url_H?default('')}${priceb?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" <#if type?default('')=='3'>class="curr"</#if>>非药品</a></li>                                        
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!--类型筛选结束-->
                            <!--品牌筛选开始-->
                            <div class="filter-list">
                            	<div class="filter-title"><i class="filter-brand"></i><span>品牌：</span></div>
                                <div class="filter-main">
                                	<div class="filter-list-type multi-line clearfix">
                                        <ul class="for-count clearfix clear" id="brandId">
                                            <li><a href="${base}/${Url_D?default('')}/${Url_A?default('')}/ylist${Url_E?default('')}${type?default('')}${Url_G?default('')}${pricea?default('')}${Url_H?default('')}${priceb?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" <#if brandid?default('')==''>class="curr"</#if>>全部</a></li>
                                            <#list brandList?if_exists as resc>
                                            <li><a id="${resc.id?default('')}" href="${base}/${Url_D?default('')}/${Url_A?default('')}/ylist${Url_E?default('')}${type?default('')}-e${resc.id?default('')}${Url_G?default('')}${pricea?default('')}${Url_H?default('')}${priceb?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" >${resc.brand_name?default('')}</a></li>
                                            </#list>
                                        </ul>
                                    </div>
                                </div>
                                <a class="filter-brand-more" href="javascript:void(0)">
                                    <b></b><span>更多</span>
                                </a>
                            </div>
                            <!--品牌筛选结束-->
                            <!--价格筛选开始-->
                            <div class="filter-list">
                            	<div class="filter-title"><i class="filter-price"></i><span>价格：</span></div>
                                <div class="filter-main">
                                	<div class="filter-list-type one-line clearfix">
                                        <ul class="price-filter-list clearfix" id="priceRange1">
                                            <li><a href="${base}/${Url_D?default('')}/${Url_A?default('')}/ylist${Url_E?default('')}${type?default('')}${Url_F?default('')}${brandid?default('')}${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" <#if pricea?default('')==''&&priceb?default('')==''>class="curr"</#if>>全部</a></li>
                                            <li><a href="${base}/${Url_D?default('')}/${Url_A?default('')}/ylist${Url_E?default('')}${type?default('')}${Url_F?default('')}${brandid?default('')}-f0-g40${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" id="0|40">0-40元</a></li>
                                            <li><a href="${base}/${Url_D?default('')}/${Url_A?default('')}/ylist${Url_E?default('')}${type?default('')}${Url_F?default('')}${brandid?default('')}-f40-g100${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" id="40|100">40-100元</a></li>
                                            <li><a href="${base}/${Url_D?default('')}/${Url_A?default('')}/ylist${Url_E?default('')}${type?default('')}${Url_F?default('')}${brandid?default('')}-f100-g200${Url_I?default('')}${sort?default('')}${Url_J?default('')}${orderby?default('')}.html" id="100|200">100-200元</a></li>
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
                            <!--
                            <div class="filter-list">
                            	<div class="filter-title"><i class="filter-relevant"></i><span>相关搜索：</span></div>
                                <div class="filter-main">
                                	<div class="filter-list-type one-line clearfix">
                                        <ul class="related-search clearfix clear">
                                        	<li>&nbsp;</li>
                                            <li><a href="#">"小药丸1"</a></li>
                                            <li><a href="#">"小药丸2"</a></li>
                                            <li><a href="#">"小药丸3"</a></li>
                                            <li><a href="#">"小药丸4"</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            -->
                            <!--相关搜索结束-->
            </div>
            <!--商品列表开始-->
                        <div class="product-list-main">
                            <!--排序筛选开始-->
                            <div id="tab">
                            	<div class="sort-filter">
                                     <ul class="sort-filter-tag clearfix" id="tab-hd">
                                        <li id="id_a" onclick="set('id_a')" <#if sort?default('0')=='0'> class="active"</#if> ><#if sort?default('0')=='0'><i <#if orderby?default('1')=='1'>class="up"<#else>class="down"</#if> ></i></#if>综合</li>
                                        <li id="click_a"  onclick="set('click_a')" <#if sort?default('0')=='1'> class="active"</#if>><#if sort?default('0')=='1'><i <#if orderby?default('1')=='1'>class="up"<#else>class="down"</#if> ></i></#if>评价</li>
                                        <li id="price_a" onclick="set('price_a')" <#if sort?default('0')=='2'> class="active"</#if>><#if sort?default('0')=='2'><i <#if orderby?default('1')=='1'>class="up"<#else>class="down"</#if> ></i></#if>价格</li>
                                        <li id="salesvolume_a" onclick="set('salesvolume_a')" <#if sort?default('0')=='3'> class="active"</#if>><#if sort?default('0')=='3'><i <#if orderby?default('1')=='1'>class="up"<#else>class="down"</#if> ></i></#if>销量</li>
                                    </ul>
                                </div>
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
                                                	 <p class="product-list-name">
                                                	<#if resc.goods_name?length lt 15>   
														${resc.goods_name?default('')}
													<#else> 
     													${resc.goods_name[0..13]}... 
													</#if>
                                                	 </p>
                                                    	<#if resc.pc_price?exists><span class="en">¥${resc.pc_price?default('0.00')}</span></#if><p><span class="max-price"><#if resc.price?exists>¥${resc.price?default('0.00')}</#if></span></p>
                                                </a>
                                                
                                               <div class="exchange">
                                                   <#if resc.type?default(0)==2||resc.type?default(0)==3>
													<a target="_blank" href="${base}/p/${resc.id?default()}.html" class="add-shopping-cart"><i></i>立即预定</a>                                                
                                                   <#else>
                                                    <a href="javascript:void(0);" id="${resc.id?default('')}" class="add-shopping-cart btn-buy"><i></i>加入购物车</a>
                                                   </#if>
                                                	<a href="javascript:void(0)" id="atted-btn-${resc.id?default('')}" onclick="atted(${resc.id?default('')},${resc.id?default('')})" class="add-collect"><i></i><span>添加收藏</span></a>
                                                </div>
                                            </li>
                                         </#list>   
                                    	
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!--排序筛选结束-->
                        </div>
                        <!--商品列表结束-->
                    	                            <!--分页开始-->
                            <#if pw.pageInfo.count?default(0)!=0>
                         <#include "/WEB-INF/pages/inc/pagebox_condition_yiyao.ftl">
                           </#if>
                            <!--分页结束-->
        </div>
        
        
     <!-- 左右滚动部分 begin -->
        <div class="relevant-product relevant-product2 w1090">
            <h2 class="shopping-cart-title clearfix clear">
                <span>相关商品</span>
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
    </div>
	<!--搜索列表结束-->
    <!--js-->
    <script type="text/javascript" src="${base}/web/js/goods-recommend.js"></script>
    <script type="text/javascript" src="${base}/web/version2.2.0/js/common.js"></script>
    <script type="text/javascript" src="${base}/web/version2.2.0/js/shopping.js"></script>
    <#include "/static/inc/version2.2.0/footer.ftl">
</body>
<script>
$(document).ready(function() {
	$.post("${base}/goodsList/goodsList!getRelevanceForSearch.action",{random:Math.random()},function(data){
var str=data;
if($.trim(str)!=""){
var aid=str.split(',');
for(var i=1;i<aid.length;i++){
$("#atted-btn-"+aid[i]).addClass("add-collect curr");
}
}
});

});
</script>
</html>
