<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="111医药馆网上药店是国家药监局认证指定网上药房|打造为老百姓服务药品价格低品种全|网上购药买药就选壹壹壹医药馆药品特卖网站">
    <!-- keywords -->
    <meta name="keywords" content="壹壹壹医药馆|壹药馆|11医药馆|1药馆|医卡通|111医药馆|医药网|药品特卖网站">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>结算页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/> 
    <link rel="icon" type="image/png" href="${base}/web/img/favicon.png">
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="assets/img/favicon-196x196.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="assets/img/apple-icon-touch.png">
    <meta name="msapplication-TileImage" content="assets/img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <!--style-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css">
    <!--header-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/headerNew.css">
    <!--footer-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/footerNew.css">
    <!--product-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/product.css">
 	<style rel="stylesheet" type="text/css">
        .pay-recommend{display:block; width:30px; height:16px; line-height:16px; float:left;margin:9px 3px 0 22px; background: #e74925; color:#FFF; border-radius:3px;}
        .pay-name{float:left; font-style: normal;}
        .pay-way li strong{width: 123px; height: 34px; line-height: 34px; text-align: center; border: 1px solid #a6a6a6; display: block; position: relative;color:#999;background: #CCC; }
    </style>
    
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=51293f48fbe2e1e51de5299446404273&plugin=AMap.PlaceSearch,AMap.Geocoder"></script>	
    
</head>
<body>
<#include "/WEB-INF/pages/inc/taglibs.ftl">
<#include "/static/inc/shopping_pay_header.ftl">
<form name="orderForm" id="orderForm">
      <input id="paymentWayId" name="paymentWayId" type="hidden" value=""/>
      <input id="receiverId" name="receiverId" type="hidden" value="${receiverId?default('')}"/>
      <input id="invoiceTitle" name="order.invoiceTitle" type="hidden" value=""/>
      <input id="ifInvoice" name="order.ifInvoice" type="hidden" value=""/>
      <input id="invoiceType" name="order.invoiceType" type="hidden" value=""/>
      <input id="remark" name="order.remark" type="hidden" value=""/>
      <input id="shortOrderId" name="shortOrderId" type="hidden" value="${shortOrderId?default('')}"/>
      <input id="couponCardId" name="couponCardId" type="hidden" value=""/>
      <input id="deliveryId" name="deliveryId" type="hidden" value=""/>
      <input id="cartType" name="cartType" type="hidden" value="${cartType?default('')}"/>
</form>
      <input id="invoiceType_test" name="invoiceType_test" type="hidden" value=""/>
	<!--购物车模块开始-->
	<div class="shopping-cart-box">
    	<div class="shopping-cart-main w1210">
        	<!--购物步骤开始-->
        	<div class="shopping-state">
            	<!--进度条-->
            	<div id="process" class="section4">
                	<div class="bar-left"></div>
		            <div class="node fore ready">
                    	<ul>
                        	<li class="tx1"><span class="state"><s></s>选择商品</span></li>
                        </ul>
                    </div>
            		<div class="proce doing">
                    	<ul>
                        	<li class="tx1">&nbsp;</li>
                        </ul>
                    </div>
            		<div class="node doing">
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
                    <h2>填写并核对订单信息</h2>
                </div>
                <!--收货人信息-->
                <div class="my-shopping-cart-list clearfix clear">
                	<h4 class="receiver-info-title">
                    	收货人信息<a href="javascript:void(0)" class="add-new-receiver" id="popup-btn2"><i>+</i>新增收货人信息</a>
                    	<!--<span style="height:20px; padding-left:10px; padding-top:10px; background:#FFF; color:#e74925; font-weight:bold;">注意：北京大兴亦庄地区下单立减邮费</span>-->
                    </h4>
                    <div class="receiving-address">
                    	<div class="receiving-address-all">
                    	<input type="hidden" id="set-top-v" value="0"/>
                            <ul class="more-receiving-address mt10" id="receiverULId">
                             <#list receiverList as receiver>
                            	<li>
                                	<div class="receiving-address-list clearfix clear <#if receiver_index?if_exists ==0>receiving-address-curr2</#if>" id="receiving-address-list" >
                                        <input id="receiver_id" type="hidden" value="${receiver.id?default('')}"/>
                                        <div class="receiving-address-operate">
                                            <a href="javascript:void(0)" id="moren_shouhuo" onClick="setDefaultReceiverDiv(${receiver.id?default('')})">设为默认收货地址</a>
                                            <a href="javascript:void(0)" onClick="updateReceiverDiv(${receiver.id?default('')})" class="popup-btn3">编辑</a>
                                            <a href="javascript:void(0)" class="popup-btn4" onClick="delReceiverDiv(${receiver.id?default('')});">删除</a>
                                        </div>
                                        <div class="receiving-area">
                                            <b></b>
                                            <span>${receiver.receiver?default('')}</span>&nbsp;&nbsp;
                                            <span>${receiver.areaFirstName?default('')}</span>
                                        </div>
                                        <p class="receiving-details">
                                            <span class="area-name">${receiver.receiver?default('')}</span>
                                            <span class="area-a">${receiver.area?default('')}</span>
                                            <span class="area-long">${receiver.locationAddress?default('')}${receiver.address?default('')}
                                            </span>
                                            <span class="receiver-tel">${receiver.mobile?default('')}</span>
                                        </p>
                                    </div>
                                </li>
                                </#list>
                            </ul>
                            <div class="show-more-address" onclick="receiverAllShow()" id="receiverAllShow_DivId">
                                <a href="javascript:gdshdz()"><i></i>更多地址</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!--送货清单-->
                <div class="my-shopping-cart-list mt-1 clearfix clear">
                	<h4 class="receiver-info-title">
                    	送货清单<#if shortOrderId==''><a href="javascript:void(0);" onclick="backcart()" class="add-new-receiver" style="color:#2a96db;">返回购物车修改</a></#if>
                    </h4>
                    <div class="shopping-cart-model shopping-cart-list clearfix clear">
                    	<ul>
                        	 <#list goodsList as goods>
                        	<li class="clearfix clear">
                            	<div class="cart-product-info clearfix clear">
                                    <div class="w60 fl">
                                    	&nbsp;
                                    </div>
                                    <div class="w308 fl">
                                        <dl class="cart-list-info clearfix clear">
                                        	<dt><a href="${base}/static/product/p/${goods.id}.html" target="_new"><img src="${ui1}${goods.abbreviationPicture?default('')}"/></a></dt>
                                            <dd>
                                            	<a href="${base}/static/product/p/${goods.id}.html" target="_new"><p class="cart-product-title">${goods.goodsName?default('')}</p></a>
                                                <p class="cart-product-spec">规格：${goods.spec?default('')}</p>
                                            </dd>
                                        </dl>
                                    </div>
                                    <div class="w290 fl">
                                        <span class="cart-list-price"><!--<b class="cart-activity">满减</b>-->规格：${goods.spec?default('')}</span>
                                    </div>
                                    <div class="w100 fl">
                                        <span class="cart-list-price">x${goods.quantity?default('')}</span>
                                    </div>
                                    <div class="w170 fl">
                                         <span class="cart-list-price cart-list-total-price">
                                         <!-- 判断是否赠品  0 否  1 是-->
                                         <#if shortOrderId!=''>
	                                         ${currency(goods.pcPrice?default(''))}
	                                      <#else>
	                                          <#if goods.ifPremiums==0>
	                                            ${currency(goods.pcPrice?default(''))}
	                                         <#else>
	                                                                                                                             赠品
	                                         </#if>
                                         </#if>
                                         </span>
                                    </div>
                                    <div class="w230 fl">
                                        <span class="cart-list-price">
                                        <#if shortOrderId!=''>
                                                                                                                            有货
	                                    <#else>	  
	                                     <#if goods.pcStatus == 1 >
		                                         <#if goods.stquan &gt;= 0 >
		                                                                                                                                 有货
		                                         <#else>
		                                           <#if goods.ifPremiums == 0 > 
		                                           		 库存${goods.stock?default('')}件
		                                           	<#else>
		                                           		 缺货
		                                           </#if>
		                                         </#if>
	                                         <#else>
	                                           		 商品已下架
	                                         </#if>    		  
                                         </#if>
                                        </span>
                                    </div>
                                </div>
                            </li>
                            </#list>
                        </ul>
                    </div>
                    <div class="leave-message">
                    	<h4>添加订单备注:</h4>
                        <div class="message-input">
                        	<input type="text" maxlength="70" name="remark_test" id="remark_test" >
                        </div>
                    </div>
                </div>
                <!--支付方式-->
                <div class="my-shopping-cart-list mt-1 clearfix clear">
                	<h4 class="receiver-info-title">
                    	支付方式
                    </h4>
					<div class="pay-way">
                    	<ul class="clearfix clear" id="paymentWayUlId">
                         <#list paymentWayList as payment>
                    	    <li><a href="javascript:selectPayment(${payment.id?default('')},'paymentWayUlId')" id="payment${payment.id?default('')}"><b></b>${payment.name?default('')}</a></li>
                         </#list>
                        </ul>
                       <p class="pay-way-tips" style="color:#e74925;">北京望京地区由专业药士达免费配送！</p>
                    </div>
                </div>
                 <!--配送方式-->
                <div class="my-shopping-cart-list mt-1 clearfix clear">
                    <h4 class="receiver-info-title">
                                                          配送方式
                    </h4>
                    <div class="pay-way">
                        <ul class="clearfix clear" id="delivery_ul">
                             <#list deliveryWayList as delivery>
                                 <#if delivery_index==0>
                                     <#assign delivery_instro="${delivery.instro?default('')}">
                                 </#if>
	                    	    <li>
		                    	    <#if delivery.isflag=='1'>
		                    	       <a href="javascript:deliverySelect(${delivery.id?default('')},'delivery_ul')" id="delivery${delivery.id?default('')}"><b></b>${delivery.name?default('')}</a>
		                    	    <#else>
		                    	       <strong>${delivery.name?default('')}</strong>
		                    	    </#if>   
	                    	       <input id="delivery_instro_${delivery.id?default('')}" value="${delivery.instro?default('')}" type="hidden">
	                    	    </li>
	                         </#list>
                        </ul>
                        <p class="pay-way-tips" id="delivery_ul_p">${delivery_instro?default('')}</p>
                    </div>
                </div>
                
                <!--发票信息-->
                <div class="my-shopping-cart-list mt-1 clearfix clear">
                	<h4 class="receiver-info-title">
                    	发票信息
                    </h4>
					<div class="invoice-info">
                    	<span id="fapiaoSpan">不开发票</span>
                        <a href="javascript:void(0)" id="popup-btn1">修改</a>
                    </div>
                </div>
                <!--优惠券、代金券信息-->
                <div class="my-shopping-cart-list mt-1 clearfix clear">
                	<div class="coupons-box">
                        <h4 class="coupons-title">
                            <a href="javascript:void(0)"><i class="off"></i>使用优惠券</a>
                        </h4>
                        <div class="coupons-info" style="display: block;">
                        	<p>可用优惠券<b>${couponListSize?default(0)}</b>张</p>
                            <div class="coupons-list">
                            	<select style="width:100%;" id="couponCardId_card" onchange="pushCouponCardId();jisuanOrderPrice()">
                                	    <option value="">未选择任何优惠券</option>
                                	<#if couponList?exists>
                                	<#list couponList as coupon>
                                	    <option value="${coupon.id?default('')}">${coupon.name?default('')}</option>
                                	</#list>
                                	</#if>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="coupons-box">
                        <h4 class="coupons-title">
                            <a href="javascript:void(0)"><i class="off"></i>优惠券编码</a>
                        </h4>
                        <div class="coupons-info cash-coupon-info clearfix clear" style="display: block;">
                        	<span>请输入优惠券编码</span>
                            <input type="text" name="couponCardNo" id="couponCardNo">
                            <input type="text" name="couponCardName" readOnly="readOnly" id="couponCardName" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px ;display:none">
                            <span id="couponButton"><a href="javascript:cardNoUser()">使用</a></span>
                        </div>
                    </div>
                    <!--商品结算信息-->
                    <div class="final-settlement-info">
                        <p id="goodsPrice">商品总金额：¥${currency(goodsPrice?default(''))}元</p>
                        <p id="promotionalDiscount">优惠金额：¥-${currency(promotionalDiscount?default(''))}元</p>
                        <p id="couponDiscount">优惠券：¥-${currency(couponDiscount?default(''))}元</p>
                        <p>运费：<span id="shippingFee">¥${currency(shippingFee?default(''))}元</span></p>
                    </div>
                    <div class="for-settle-accounts clearfix clear">
                        <a href="javascript:saveOrder()" id="tijiaoOrder" class="go-settle-accounts">提交订单</a>
                      	  应付总额：<b id="payableAmount">¥${currency(payableAmount?default(''))}元</b>
                    </div>
                    <!--商品结算信息结束-->
                </div>
                <div class="final-show-receiving">
                	<!--<p>寄送至：北京 朝阳区 三环到四环之间 daagagaagagaga1门301</p>
					<p>收货人：gagagag  135****2188</p>-->
                </div>
            </div>
            <!--我的购物车结束-->
        </div>
    </div>
    <!--购物模块结束-->
    
<!--遮罩层开始-->
<div id="shade">
    <!--新增收货人信息开始-->
    <div class="out out-box" id="out2" style="display:none">
    	<div class="double-out">
    	<form id="receiverAdd" name="receiverAdd" action="">
            <input type="hidden" name="tmemberreceiver.id" id="tmemberreceiver_id"  value=""/>
            <input type="hidden" name="memberReceiver_adcode" id="memberReceiver_adcode"  value=""/>
            <input type="hidden" name="tmemberreceiver.longitude" id="tmemberreceiver_longitude"  value=""/>
            <input type="hidden" name="city_name_set" id="city_name_set"  value=""/>
            <input type="hidden" name="tmemberreceiver.latitude" id="tmemberreceiver_latitude"  value=""/>
            <input type="hidden" name="tmemberreceiver.locationAddress" id="tmemberreceiver_locationAddress"  value=""/>
            <input type="hidden" name="tmemberreceiver_areaId" id="tmemberreceiver_areaId"  value=""/>
            <div class="firse-out">
                <h4 class="out-title">
                    <a href="javascript:closeDiv('out2')" class="close-out"></a>
                                                      完善收货人信息
                </h4>
                <div class="out-info clearfix clear">
                        <dl class="refund-details clearfix clear">
                            <dt><b>*</b>收货人：</dt>
                            <dd>
                                <div class="refund-box receive-p">
                                    <input type="text" name="tmemberreceiver.receiver" maxlength="10" class="refund-price" id="tmemberreceiver_receiver" value=""/>
                                </div>
                                <span><font color="red" id="receiverSpanFont"></font></span>
                            </dd>
                        </dl>
                        <dl class="refund-details clearfix clear">
                            <dt><b>*</b>位置：</dt>
                            <dd>
                                <div class="refund-list add-address choice-city" onclick="showCity()" id="city_div_id">
                                    <i></i>请选择
                                </div>
                                <div class="location-box">
                                    <input class="city-ipt" type="text" readonly="readonly" onclick="mapShow()" id="map_search" class="refund-price" value="请输入您的地址" onfocus="javascript:if(this.value=='请输入您的地址'){ this.value='';this.style.color='#333'}" onblur="javascript:if(this.value==''){ this.value='请输入您的地址';this.style.color='#afafaf'}">
                                </div>
                                <style>
                                .amap-logo,.amap-copyright{display:none}
                                </style>
                                <span><font color="red" id="weizhixinxi_span"></font></span>
                            </dd>
                        </dl>
                        <dl class="refund-details clearfix clear">
                            <dt><b>*</b>详细地址：</dt>
                            <dd>
                                <div class="refund-box receive-d">
                                    <input type="text" name="tmemberreceiver.address" maxlength="40" class="refund-price" id="tmemberreceiver_address" value=""/>
                                </div>
                                 <span><font color="red" id="addressSpanFont"></font></span>
                            </dd>
                        </dl>
                        <dl class="refund-details tel-details clearfix clear">
                            <dt><b>*</b>手机号码：</dt>
                            <dd>
                                <div class="refund-box">
                                     <input type="text" name="tmemberreceiver.mobile" class="refund-price" id="tmemberreceiver_mobile" value=""/>
                                </div>
                                <span><font color="red" id="mobileSpanFont"></font></span>
                            </dd>
                        </dl>
                        <dl class="refund-details tel-details clearfix clear">
                            <dt></dt>
                            <dd>
                            </dd>
                        </dl>
                    <div class="for-btn-box add-receive-box clearfix clear">
                        <a href="javascript:saveOrupdateReceiver('receiverAdd','out2')" class="submit-refund">保存收货人信息</a>
                    </div>
                </div>
            </div>
            </form>
            <!---->
            <div class="second-out">
            	<h4 class="out-title city-title">
                    <a href="javascript:closeCity()" class="close-city"></a>
                    请选择你所在的城市
                </h4>
                <div class="city-main">
                    <div class="city-location clearfix clear">
                        <!--<div class="guess-location">
                            <span>上海</span>猜你在
                        </div>-->
                        <div class="input-city">
                            <input class="city-ipt" type="text" id="search_input_id" value="请输入城市" onfocus="javascript:if(this.value=='请输入城市'){ this.value='';this.style.color='#333'}" onblur="javascript:if(this.value==''){ this.value='请输入城市';this.style.color='#afafaf'}"  onkeyup="searchCity()" />
                            <ul class="input-city-list" id="search_input_ul_id">
                            
                            </ul>
                        </div>
                    </div>
                    <div class="city-location-list clearfix clear">
                            <#list zimuMap?keys as key> 
                             <dl class="clearfix clear">
						       <dt>${key}</dt>
						       <dd>
                                <ul class="citytown-list clearfix clear">
	                               <#list zimuMap[key] as citylist> 
		                                <li><a href="javascript:selectCity('${citylist.citycode}','${citylist.name}')">${citylist.name}</a></li>
	                                </#list>
	                            </ul>
	                        </dd>
	                        </dl>
						    </#list> 
                    </div>
                </div>
            </div>
            <div class="third-out">
            	<a href="javascript:closeMap()" class="close-add"></a>
            	<div class="show-map2">
                	<div class="map" id="container">
                    	<div class="ab-location">
                        	<div class="fill-lication">
                            	<input class="ipt-lication" type="text" id="search_keyword" class="refund-price" onkeyup="key_search()" value="请输入您的收货地址(写字楼,小区,街道或者学校)" onfocus="javascript:if(this.value=='请输入您的收货地址(写字楼,小区,街道或者学校)'){ this.value='';this.style.color='#333'}" onblur="javascript:if(this.value==''){ this.value='请输入您的收货地址(写字楼,小区,街道或者学校)';this.style.color='#999'}">
                            </div>
                            <a href="javascript:key_search()" class="search-location"></a>
                            <ul class="map-location-list" id="map_search_ul_id">
                            </ul>
                        </div>
                        <!--手动选择地址开始-->
                        <div class="manual-locate">
                            <a href="#" class="manual-locate-btn">手动选择地址</a>
                            <div class="out-info clearfix clear manual-locate-form" style="display:none">
                                <dl class="refund-details clearfix clear">
                                    <dt><b>*</b>位置：</dt>
                                    <dd>
                                        <span class="address-tip" id="cityName_span"></span>
                                        <div class="refund-list add-address">
                                            <select class="selete-box" id="area_select_one">
                                                <option value="">请选择</option>
                                            </select>
                                        </div>
                                        <span id="area_sq_span_id">
                                           
                                        </span>
                                        <span><font color="red" id="area_select_one_span"></font></span>
                                    </dd>
                                </dl>
                                <dl class="refund-details clearfix clear">
                                    <dt><b>*</b>详细地址：</dt>
                                    <dd>
                                        <div class="refund-box receive-d">
                                            <input type="text" maxlength="40" class="refund-price" id="tmemberreceiver_address_sd">
                                        </div>
                                        <span><font color="red" id="addressSpanFont_sd"></font></span>
                                    </dd>
                                </dl>
                                <dl class="refund-details tel-details clearfix clear">
                                    <dt><b>*</b>手机号码：</dt>
                                    <dd>
                                        <div class="refund-box">
                                            <input type="text" class="refund-price" id="tmemberreceiver_mobile_sd">
                                        </div>
                                        <span><font color="red" id="mobileSpanFont_sd"></font></span>
                                    </dd>
                                    
                                </dl>
                                <div class="for-btn-box">
                                    <a href="#" class="submit-refund" id="receiver_sd_save">保存</a><a href="#" class="cancle-refund">取消</a>
                                </div>
                            </div>
                        </div>
                        <style>
                        .manual-locate-btn{width: 154px; height: 40px; line-height: 40px; background: #3682d8; color: #fff; font-size: 14px; text-align: center; display: inline-block; position: relative; right: 40px; top: 10px; z-index: 999; float: right;}
                        .manual-locate .out-info{position: relative; padding:20px 0; top: 20px; left: 10px; right: 10px; width: 670px; overflow: hidden; z-index: 1099;}
                        .manual-locate .out-info .refund-details dt{width:140px;}
                        .manual-locate .out-info .refund-details dd{width:450px;}
                        </style>
                        <!--手动选择地址结束-->
                    </div>
                </div>
            </div>
            
        </div>
    </div>
    <!--新增收货人信息结束-->

    <!--删除收货人信息开始-->
    <div class="out out-box" id="out4" style="display:none">
        <h4 class="out-title">
            <a href="javascript:closeDiv('out4')" class="close-out"></a>
            删除收货人信息
        </h4>
        <div class="out-info clearfix clear">
            <h4 class="delete-teceive-tips">您确定要删除该收货地址吗？</h4>
            <div class="for-btn-box delete-receive-info clearfix clear">
                <input type="hidden" id="delete_receiverid" name="delete_receiverid">
                <a href="javascript:delReceiver()" class="submit-refund">确定</a><a href="javascript:closeDiv('out4')" class="submit-refund">取消</a>
            </div>
        </div>
    </div>
    <!--删除收货人信息结束-->
    
    <!--设置默认收货人信息开始-->
    <div class="out out-box" id="out5" style="display:none">
        <h4 class="out-title">
            <a href="javascript:closeDiv('out5')" class="close-out"></a>
            设置默认收货地址信息
        </h4>
        <div class="out-info clearfix clear">
            <h4 class="delete-teceive-tips">您确定要设置为默认收货地址吗？</h4>
            <div class="for-btn-box delete-receive-info clearfix clear">
                <input type="hidden" id="moren_receiverid" name="delete_receiverid">
                <a href="javascript:setDefaultReceiver()" class="submit-refund">确定</a><a href="javascript:closeDiv('out5')" class="submit-refund">取消</a>
            </div>
        </div>
    </div>
    <!--设置默认收货人信息开始-->


    <!--发票信息开始-->
    <div class="out out-box" id="out1" style="display:none">
        <h4 class="out-title">
            <a href="javascript:closeDiv('out1')" class="close-out"></a>
            发票信息
        </h4>
        <div class="out-info clearfix clear">
                    <dl class="refund-details invoice-details clearfix clear">
                        <dt>发票抬头：</dt>
                        <dd>
                            <div class="message-input">
                               <input type="text" id="invoice_title" maxlength="50" name="invoice_title"><span id="invoice_title"></span>
                            </div>
                        </dd>
                    </dl>
                    <dl class="refund-details clearfix clear">
                        <dt>发票内容：</dt>
                        <dd>
                            <div class="invoice-box">
                                <ul class="invoice-list invoice-info-list clearfix clear">
                                    <li class="invoice-curr" id ="invoice-curr0" onclick="invoiceSelect(0)"><b></b>不开发票</li>
                                    <li id="invoice-curr1" onclick="invoiceSelect(1)"><b></b>明细</li>
                                    <li id="invoice-curr2" onclick="invoiceSelect(2)"><b></b>药品</li>
                                    <li id="invoice-curr3" onclick="invoiceSelect(3)"><b></b>保健品</li>
                                    <li id="invoice-curr4" onclick="invoiceSelect(4)"><b></b>医疗器械</li>
                                </ul>
                            </div>
                        </dd>
                    </dl>
                    
            <div class="for-btn-box save-invoice-info add-receive-box clearfix clear">
                <a href="javascript:saveInvoice()" class="submit-refund">保存发票信息</a><a href="javascript:closeDiv('out1')" class="submit-refund">取消</a>
            </div>
            <p class="invoice-tips"></p>
        </div>
    </div>
    <!--发票信息结束-->
</div>
<!--遮罩层结束-->


<form name="orderPayForm" id="orderPayForm" method="post">
      <input id="orderId" name="orderId" type="hidden" value=""/>
</form>
</body>	
<script type="text/javascript" src="${base}/web/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${base}/web/js/jquery.lSelect.js"></script>
<script type="text/javascript" src="${base}/web/js/input.js"></script>
<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css"/>
<script type="text/javascript" src="${base}/web/js/order_add.js"></script>
<script type="text/javascript" src="${base}/web/js/cookieUtil.js"></script>



<#include "/static/inc/footer.ftl">
<script>
var map ;
var placeSearch;
var  geocoder;
//地图显示
function mapShow(){
    var memberReceiver_adcode = $("#memberReceiver_adcode").val();
    if(memberReceiver_adcode!=''){
        if(!map){
           map = new AMap.Map("container", {
		    resizeEnable: true
		   });
        }
		var city_name_set =$("#city_name_set").val();
		if(city_name_set.split("-").length>1){
		   map.setCity(city_name_set.split("-")[1],function() {
           map.setZoom(11);
           });
		}else{
		   map.setCity(city_name_set.split("-")[0],function() {
           map.setZoom(11);
          });
		}
		map.clearMap(); 
		var placeSearchOptions = { //构造地点查询类
		    pageSize: 10,
		    pageIndex: 1,
		    city: memberReceiver_adcode, //城市
		    map:map
		};
		$('.third-out').show();
	    placeSearch = new AMap.PlaceSearch(placeSearchOptions);
	    placeSearch.setCity(memberReceiver_adcode);
	    placeSearch.setCityLimit(true);
    }else{
       $alertCanDisplay("warn","请先选择城市!",null,null);
    }
}
//地图搜索
function key_search(){
	    var search_keyword = $("#search_keyword").val();
	    if($.trim(search_keyword)!=''){
	      placeSearch.search(search_keyword, callback);
	    }else{
	      $("#map_search_ul_id").html("");
	      $('.map-location-list').hide();
	      map.clearMap();	
	    }
}
	
//地图搜索回调函数
function callback(status, result) {
    $("#map_search_ul_id").html("");
    if (status === 'complete' && result.info === 'OK') {
	   if(result.poiList&&result.poiList.pois){
	      var pois = result.poiList.pois;
		   if(pois.length>0){
		       var map_search_ul_id_html="";
			  for(var i=0;i<pois.length;i++){
				    var pois_address=pois[i].address;
				    var pois_name=pois[i].name;
				    var pname_p =  pois[i].pname;
				    if(pname_p.substring(pname_p.length-1,pname_p.length)=='市'){
				       pname_p= pname_p.substring(0,pname_p.length-1)
				    }
				    var city_name=pname_p+"-"+pois[i].cityname+"-"+pois[i].adname;
			        map_search_ul_id_html+="<li><a href=\"javascript:userSearchLocationAddress('"+city_name+"','"+pois_address+pois_name+"','"+pois[i].location.getLng()+"','"+pois[i].location.getLat()+"')\">";
				    map_search_ul_id_html+="<i>"+(i+1)+"</i>";
				    map_search_ul_id_html+="<p class=\"location-title\">"+pois_name+"</p>";
				    map_search_ul_id_html+="<p class=\"location-text\">"+pois_address+"</p></a>";
				    map_search_ul_id_html+="</li>";
			  }
			  $("#map_search_ul_id").html(map_search_ul_id_html);
			  $('.map-location-list').show();	
		   }else{
		      //$alertCanDisplay("warn","未搜索到相关地址信息",null,null);
		      $('.map-location-list').hide();
		      map.clearMap();
		   }  
	   }
    }else{
       //$alertCanDisplay("warn","未搜索到相关地址信息",null,null);
       $('.map-location-list').hide();
       map.clearMap();
    }
}
	
//使用搜索地址
function userSearchLocationAddress(city_name,locationAddress,longitude,latitude){
    $("#city_name_set").val(city_name);
    $("#tmemberreceiver_locationAddress").val(locationAddress);
    $("#tmemberreceiver_longitude").val(longitude);
    $("#tmemberreceiver_latitude").val(latitude);
    $("#map_search").val(locationAddress);
    $("#tmemberreceiver_areaId").val("");
    closeMap();
}	
	
  //弹出选择城市层
  function showCity(){
     $('.second-out').show();	
  }
   //关闭选择城市弹出层
  function closeCity(){
     $('.second-out').hide();	
  }
  //关闭地图弹出层
  function closeMap(){
     $('.third-out').hide();
     $('.map-location-list').hide();
     $('.manual-locate-form').hide();
     $("#search_keyword").val('');
  }
  
  //选择城市
  function selectCity(citycode,cityname){
      if($("#memberReceiver_adcode").val()!=citycode){
          $("#memberReceiver_adcode").val(citycode);
	      $("#city_div_id").html("<i></i>"+cityname);
	      $("#city_name_set").val(cityname);
	      $("#search_input_id").siblings('ul').hide();
	      $("#search_input_id").val('');
	      $("#search_input_ul_id").html('');
	      $("#tmemberreceiver_longitude").val('');
	      $("#tmemberreceiver_areaId").val('');
	      $("#tmemberreceiver_latitude").val('');
	      $("#tmemberreceiver_locationAddress").val('');
	      $("#tmemberreceiver_address").val('');
		  $("#tmemberreceiver_mobile").val('');
	      $("#map_search").val("请输入您的地址");
	      $("#map_search").attr("color","#333");
      }
      closeCity();
  }
  //筛选城市
  function searchCity(){
      var search_input_id=$("#search_input_id").val();
      if($.trim(search_input_id)==''){
         $("#search_input_id").siblings('ul').hide();
      }else{
        $.ajax({
			url:'${base}/member/order!searchCity.action',
			data:{"cityname":search_input_id},
			type:'post',
			success:function(data){
			    if(data!=''){
			       var trhtml="";
					for(var i=0;i<data.length;i++){
					  trhtml+="<li><a href=\"javascript:selectCity('"+data[i].citycode+"','"+data[i].name+"')\">"+data[i].name+"</a></li>";
					}
			    }
				$("#search_input_ul_id").html(trhtml);
				$("#search_input_id").siblings('ul').show();
			}
		});
      }
  }
  
   $(document).ready(function() {
		
		//弹窗、遮罩层
		function outs(click_id,out_id,shade_id){
                $(click_id).click(function(){
	                if(out_id=='#out1'){
	                    $(shade_id).css({
		                    display:"block"
		                })
		                $(out_id).show();
	                   var invoiceType =$("#invoiceType").val();
	                   if(invoiceType ==''){
	                      invoiceType='0';
	                   }
	                   invoiceSelect(invoiceType);
	                }else if(out_id=='#out2'){
	                     clearReceiverAlert(); 
		                 $("#tmemberreceiver_id").val('');
					     $("#memberReceiver_adcode").val('');
					     $("#tmemberreceiver_longitude").val('');
					     $("#tmemberreceiver_latitude").val('');
					     $("#tmemberreceiver_locationAddress").val('');
					     $("#city_div_id").html("<i></i>请选择");
					     $("#city_name_set").val('');
					     $("#tmemberreceiver_receiver").val('');
					     $("#tmemberreceiver_address").val('');
					     $("#tmemberreceiver_mobile").val('');
					     $("#tmemberreceiver_zipCode").val('');
					     $("#tmemberreceiver_areaId").val('');
					     $("#map_search").val("请输入您的地址");
					     $("#map_search").attr("color","#333");
		                 var receiverlength= $('#receiverULId').children('li').length;
		                 if(receiverlength<10){
		                    $(shade_id).css({
			                    display:"block"
			                })
			                $(out_id).show();
		                 }else{
		                   $alertCanDisplay("warn","收货地址最多可添加10个",null,null);
		                 }  
	                }
	            })
        }
        outs("#popup-btn1","#out1","#shade");
		outs("#popup-btn2","#out2","#shade");
		//outs(".popup-btn3","#out3","#shade");
		//outs(".popup-btn4","#out4","#shade");
		
		//收货地址鼠标滑动效果
        $('.receiving-address-list').hover(function(){
			$(this).addClass('receiving-address-curr');
		},function(){
			$(this).removeClass('receiving-address-curr');	
		})
		//点击选择收货地址
		$('.receiving-address-list').click(function(){
			$(this).addClass('receiving-address-curr2');
			$(this).parents('li').siblings().find('.receiving-address-list').removeClass('receiving-address-curr2');
			$("#receiverId").val($(this).children().eq(0).val());
			$("#set-top-v").val($(this).parents('li').index());
			jisuanOrderPrice();
			queryPaymentWay();
		})
		//商品列表展开收起
		$('.filter-brand-more').click(function(){
			var oCorner3 = $(this).find('b');
			if(oCorner3.hasClass('off')){
				$('.multi-line').removeClass('height-auto');
				$(this).find('span').html('更多');
				oCorner3.removeClass('off');
			}else{
				$('.multi-line').addClass('height-auto');
				$(this).find('span').html('收起');
				oCorner3.addClass('off');
			}
		})
		//商品详情展开收起
		$('.promotion-info a').click(function(){
			var oCorner4 = $(this).find('i');
			if(oCorner4.hasClass('off')){
				$('.promotion-info').removeClass('height-auto');
				oCorner4.removeClass('off');
			}else{
				$('.promotion-info').addClass('height-auto');
				oCorner4.addClass('off');
			}
		})
		$('.coupons-title a').click(function(){
			var oCorner2 = $(this).find('i');
			if(oCorner2.hasClass('off')){
				$(this).parent().siblings().hide();
				oCorner2.removeClass('off');
			}else{
				$(this).parent().siblings().show();
				oCorner2.addClass('off');	
			}
			
		})
		//显示手动添加地址
		$('.manual-locate-btn').click(function(){
		    $("#cityName_span").html($("#city_name_set").val());
		    var city_name_set =$("#city_name_set").val();
			if(city_name_set.split("-").length>1){
			   $("#cityName_span").html(city_name_set.split("-")[1]);
			}else{
			   $("#cityName_span").html(city_name_set.split("-")[0]);
			}
		    $("#area_sq_span_id").html("");
		    $("#tmemberreceiver_address_sd").val($("#tmemberreceiver_address").val());//详细地址
		    $("#tmemberreceiver_mobile_sd").val($("#tmemberreceiver_mobile").val());//手机号
		    $("#area_select_one_span").html("");
		    $("#addressSpanFont_sd").html("");
		    $("#mobileSpanFont_sd").html("");
		    var citycode = $("#memberReceiver_adcode").val();
		      $("#area_select_one").html("<option value=\"\">请选择</option>");
		     $.ajax({
				url:'${base}/member/order!ajaxGetAreaByCity.action',
				data:{"citycode":citycode},
				type:'post',
				success:function(data){
				    if(data.length > 0){
				      var area_select_one_html="<option value=\"\">请选择</option>";
				       for(var i=0;i<data.length;i++){
				          area_select_one_html+="<option value=\""+data[i].id+"\">"+data[i].name+"</option>";
				       }
				       $("#area_select_one").html(area_select_one_html);
				    }
				}
			});
			$('.manual-locate-form').show();
	    });
	    //关闭手动添加地址
	    $('.cancle-refund').click(function(){
	        $('.manual-locate-form').hide();
	    });
	    //手动添加地址保存
	    $('#receiver_sd_save').click(function(){
	        var flag = true;
	        
	        var area_select_one = $("#area_select_one").val();
	        if (area_select_one == '') {
				$("#area_select_one_span").html("请选择所在位置");
				flag = false;
			} else {
				$("#area_select_one_span").html("");
			}
	        
	        // 详细地址
			var tmemberreceiver_address_sd = $.trim($("#tmemberreceiver_address_sd").val());
			if (tmemberreceiver_address_sd == '') {
				$("#addressSpanFont_sd").html("请输入详细地址");
				flag = false;
			} else {
				$("#addressSpanFont_sd").html("");
			}
			// 手机号码
			var tmemberreceiver_mobile_sd = $.trim($("#tmemberreceiver_mobile_sd").val());
			if (tmemberreceiver_mobile_sd == '') {
				$("#mobileSpanFont_sd").html("请输入手机号码");
				flag = false;
			} else {
				var re = /^[1][3,4,7,5,8][0-9]{9}$/;
				if (!re.test(tmemberreceiver_mobile_sd)) {
					$("#mobileSpanFont_sd").html("请输入正确的手机号");
					flag = false;
				} else {
					$("#mobileSpanFont_sd").html("");
				}
			}
	        if(flag){
	            $("#tmemberreceiver_address").val($("#tmemberreceiver_address_sd").val());//详细地址
		        $("#tmemberreceiver_mobile").val($("#tmemberreceiver_mobile_sd").val());//手机号
		        if($("#area_select_two").val()==null||$("#area_select_two").val()==''){
		           $("#tmemberreceiver_locationAddress").val($("#area_select_one").find("option:selected").text());
		           $("#map_search").val($("#area_select_one").find("option:selected").text());
		           $("#tmemberreceiver_areaId").val($("#area_select_one").find("option:selected").val());
		        }else{
		           $("#tmemberreceiver_locationAddress").val($("#area_select_one").find("option:selected").text()+"-"+$("#area_select_two").find("option:selected").text());
		           $("#map_search").val($("#area_select_one").find("option:selected").text()+"-"+$("#area_select_two").find("option:selected").text());
		            $("#tmemberreceiver_areaId").val($("#area_select_two").find("option:selected").val());
		        }
		        $("#tmemberreceiver_longitude").val("");
		        $("#tmemberreceiver_latitude").val("");
	            if($.trim($("#tmemberreceiver_receiver").val())!=''){
	                  closeMap();
	                  saveOrupdateReceiver('receiverAdd','out2');//保存
	            }else{
	                  closeMap();
	            }
	        }
	    });
	    
	    
	    
	    //选择地区判断是否有商圈
	    $('#area_select_one').change(function(){
	        $("#area_sq_span_id").html("");
		     var area_one_id= $(this).children('option:selected').val();
		     if(area_one_id!=''){
		       $.ajax({
				url:'${base}/member/order!ajaxGetTwoAreaByAreaId.action',
				data:{"areaId":area_one_id},
				type:'post',
				success:function(data){
				    if(data.length > 0){
				      var area_sq_span_id_html="<span class=\"address-tip\"></span><div class=\"refund-list add-address\"><select class=\"selete-box\" id=\"area_select_two\">";
				       for(var i=0;i<data.length;i++){
				          area_sq_span_id_html+="<option value=\""+data[i].id+"\">"+data[i].name+"</option>";
				       }
				       $("#area_sq_span_id").html(area_sq_span_id_html+"</select></div>");
				    }
				  }
			   });
		     } 
		});
    });
    
   function backcart(){
   	 var key = getCookie("111yao");
     window.location.href="${base}/carts/cart!page.action?key="+key;
   }
 
 function gdshdz(){
			var _index = $("#set-top-v").val();
			   if(_index == '')
			  {
					_index = 0;
			   }
	          $("#receiverULId").find("li").each(function(index){
				if(index == _index)
				  {
				    $("#receiverULId").prepend($(this));
					$("#set-top-v").val($(this).index())
				  }
			  });
			var oCorner2 = $(this).find('i');
			if(oCorner2.hasClass('off')){
				$(this).parent().siblings().hide();
				oCorner2.removeClass('off');
			}else{
				$(this).parent().siblings().show();
				oCorner2.addClass('off');	
			}
 }
 
 
 
   
</script>
</html>
