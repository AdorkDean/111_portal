<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<#include "/WEB-INF/pages/inc/taglibs.ftl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="icon" type="image/png" href="${base}/web/img/favicon.png">
<title></title>		




 <!--style-->
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css">
<!--header-->
<link rel="stylesheet" type="text/css" href="${base}/web/css/headerNew.css">
<!--footer-->
<link rel="stylesheet" type="text/css" href="${base}/web/css/footerNew.css">
<!--product-->
<link rel="stylesheet" type="text/css" href="${base}/web/css/product.css">
<#--
 <style type="text/css" rel="stylesheet">
        .shopping-empty-wrap{width:1210px; margin:0 auto; overflow: hidden;  background: #EEE;}
        .shopping-empty{padding:140px 0 180px 520px; background:#FFF url("${base}/web/images/shopping-empty.png") no-repeat 370px 140px;}
        .sp-em-p{font-size:14px; color:#19a69f; font-weight: bold; margin-top:18px; height:40px; line-height:40px;}
        .sp-em-btn{height:46px;}
        .sp-em-btn a{height:46px; width:116px; floaT:left; display: block; line-height:46px; text-align: center; font-size:18px;font-weight: bold; color:#FFF; margin-right:15px; background: #19a69f; border-radius: 10px;}
        .sp-em-btn a:last-child{background: #a3a3a3;}
        .sp-em-btn a:first-child:hover{background: #00bfb8;}
        .sp-em-btn a:last-child:hover{background:#acacac;}
    </style>
  -->  
</head>

<html>

<body>


<#include "/static/inc/shopping_header.ftl">



	<!--购物车模块开始-->
	<div class="shopping-cart-box">
    	<div class="shopping-cart-main w1210">
        	
       <#if l.size() == 0>  
       <div class="my-shopping-cart" id="div100">
            <!--购物车-空开始-->
            <div class="shopping-empty-wrap">
            
            <#if Session["member"]?exists>
                <div class="shopping-login">
                    <p class="sp-login-p">购物车内暂时没有商品，快去逛逛吧！</p>
                    <div class="sp-login-btn">
                        <a href="/">去逛逛</a>
                    </div>
                </div>
                
            <#else>
               <div class="shopping-empty">
                    <p class="sp-em-p">购物车内暂时没有商品，登录后将显示您之前加入的商品</p>
                    <div class="sp-em-btn">
                        <a href="${base}/login/login!index.action">登录</a>
                        <a href="/">开始购物</a>
                    </div>
                </div>
                
            </#if>
               
            </div>
            <!--购物车-空结束-->
        	
       <#else>
       <!--购物步骤开始-->
       <div id="div200">
        	<div class="shopping-state">
            	<!--进度条-->
            	<div id="process" class="section4">
                	<div class="bar-left"></div>
		            <div class="node fore doing">
                    	<ul>
                        	<li class="tx1"><span class="state"><s></s>选择商品</span></li>
                        </ul>
                    </div>
            		<div class="proce wait">
                    	<ul>
                        	<li class="tx1">&nbsp;</li>
                        </ul>
                    </div>
            		<div class="node wait">
                    	<ul>
                        	<li class="tx1"><span class="state"><s></s>填写核对订单信息</span></li>
                        </ul>
                    </div>
            		<div class="proce wait">
                    	<ul>
                        	<li class="tx1">&nbsp;</li>
                        </ul>
                    </div>
            		<div class="node wait">
                    	<ul>
                        	<li class="tx1"><span class="state"><s></s>成功提交订单</span></li>
                        </ul>
                    </div>
            		<div class="proce wait">
                    	<ul>
                        	<li class="tx1">&nbsp;</li>
                        </ul>
                    </div>
            		<div class="node wait" style="border-radius:0 8px 8px 0; -moz-border-radius:0 8px 8px 0; -webkit-border-radius:0 8px 8px 0;">
                    	<ul>
                        	<li class="tx1"><span class="state"><s></s>完成订单</span></li>
                        </ul>
                    </div>
           		</div>
            </div>
            <!--购物步骤结束-->
            <!--我的购物车开始-->
            <div class="my-shopping-cart">
            	<div class="my-shopping-cart-title clearfix clear">
                    <h2>我的购物车</h2>
                    <p class="cart-login-tips" style="display:none">现在<a href="${base}/login/login!index.action">登录</a>,您购物车中的商品将被永久保存</p>
                </div>
                <div class="my-shopping-cart-list clearfix clear">
                	<div class="shopping-cart-model shopping-cart-title clearfix clear">
                    	<div class="w60 fl">
                        	<label class="check-link checked-all" id="allchk" ></label>全选
                        </div>
                        <div class="w308 fl">商品</div>
                        <div class="w100 fl">价格（元） </div>
                        <div class="w290 fl">数量</div>
                        <div class="w170 fl">小计（元）</div>
                        <div class="w230 fl">操作</div>
                    </div>
                    <div class="shopping-cart-model shopping-cart-list clearfix clear">
                    	<ul>
                    	
                         <#list l?if_exists as c >
                         <li class="clearfix clear" id="record_${c.itemid?default(0)}" >
                            	<div class="cart-product-info clearfix clear">
                                    <div class="w60 fl">
                                        <label class="check-link <#if c.is_selected==1>checked-curr</#if>" name="item-checkbox" id="${c.itemid?default(0)}"></label>
                                    </div>
                                    <div class="w308 fl">
                                        <dl class="cart-list-info clearfix clear">
                                        	<dt><a href="/p/${c.goodsid}.html" target="_new"><img src="${ui1}${c.image_url?default('')}"/></a></dt>
                                            <dd>
                                            	<a href="/p/${c.goodsid}.html" target="_new"><p class="cart-product-title">${c.goods_name?default('')}</p></a>
                                                <p class="cart-product-spec">${c.spec?default('')}</p>
                                            </dd>
                                        </dl>
                                    </div>
                                    <div class="w100 fl">
                                        <span class="cart-list-price" id="price_${c.itemid?default(0)}">${c.pc_price?string("0.00")}</span>
                                    </div>
                                    <div class="w290 fl">
                                        <div class="cart-product-count">
                                        	<a href="javascript:void(0)" onclick="update(${c.itemid},${c.goodsid},1,1)"　class="count-plus" 　>+</a>
                                            <a href="javascript:void(0)" onclick="update(${c.itemid},${c.goodsid},2,1)" class="count-minus">-</a>
                                            <input class="count-text" onKeyUp="validateMaxMoney(this)" name="kuang"  type="text" gid="${c.goodsid}" value="${c.quantity?default('')}"  id="count_${c.itemid?default(0)}" maxlength="3" >
                                            <div  style="display:none">${c.quantity?default('')}_${c.itemid}</div>
                                        </div>
                                    </div>
                                    <div class="w170 fl">
                                         <span class="cart-list-price cart-list-total-price" id="heji_${c.itemid?default(0)}">${(c.quantity*c.pc_price)?string("0.00")}</span>
                                    </div>
                                    <div class="w230 fl">
                                        <p class="cart-list-operate"><a href="javascript:void(0)" onclick="del(${c.itemid?default(0)})">删除</a><a href="javascript:void(0)" onclick="collect(${c.itemid?default(0)},${c.goodsid?default(0)})" >移入收藏夹</a></p>
                                    </div>
                                </div>
                              
                                <div class="non-selling" id="gift-div-${c.promid?default(0)}" style="display:none">
                                	<div class="non-selling-info">
                                    	<span>赠品：</span>
                                        <ul id="gift-ul-${c.promid?default(0)}">
                                        </ul>
                                    </div>
                                    <div class="non-selling-count">1</div>
                                </div>
                             
                              
                            </li>
                         </#list>   
                            
                            
                           
                    <div class="total-cart-info clearfix clear">
                    	<div class="operate-all-cart">
                        	<a href="#">删除选中商品</a>
                            <a href="#">移入我的收藏夹</a>
                        </div>
                        <div class="total-pro-count">
                        	共<b id="g-count">-</b>件商品
                        </div>
                    	<span class="total-pro-info">合计(不含运费):<b id="money1">00.00</b></span>
                        <span class="total-pro-info">优惠：<b >¥－<span id="youhui">00</span></b>元</span>
                    </div>
                </div>
                <div class="for-settle-accounts clearfix clear">
                	<a href="javascript:void(0)" class="go-settle-accounts" >去结算</a>
                    总计(不含运费)：<b>¥<span id="money" >---</span>元</b>
                </div>
               
            </div>
            <!--我的购物车结束-->
        </div>
    </div>
    <!--购物模块结束--> 
    
       </#if>
       
        	
        	 <!--我的购物车开始-->
      
        	
        	
                 <!--推荐商品开始-->
                <div class="cart-filter-pro">
                    <div class="product-list-title clearfix clear">
                        <ul class="product-list-tag clearfix">
                            <li class="pitch-on">推荐商品</li>
                        </ul> 
                    </div>
                    <div class="cart-filter-list clearfix clear"> 
                    	<ul class="filter-product-list clearfix clear" id="recommond-pro-id-ljl" >
                        	
                    	</ul> 
                    </div>
                </div>                   	       	
                <!--推荐商品结束-->
            </div>
            <!--我的购物车结束-->
        </div>
    </div>
    <!--购物模块结束-->
    


<#include "/static/inc/footer.ftl">
<#include "/static/inc/ceng.html">


<script type="text/javascript" src="${base}/web/js/jquery-1.4.1.min.js"></script>
<script type="text/javascript" src="${base}/web/js/cart.js"></script>
<script type="text/javascript" src="${base}/web/js/goods-recommend.js"></script>
<script type="text/javascript" src="${base}/web/js/productNew.js"></script>

<script>

money();
checkEmpty();
islogin();
cartRecomm();
checkedStatus();
</script>
</body>	
</html>
