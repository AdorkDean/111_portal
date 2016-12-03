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
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/shopping.css">
    <link href="${base}/web/version2.2.0/css/bootstrap.css" rel="stylesheet">
    <link href="${base}/web/version2.2.0/css/city-picker.css" rel="stylesheet">
    <link href="${base}/web/version2.2.0/css/main.css" rel="stylesheet">
</head>
<body>
<#include "/WEB-INF/pages/inc/taglibs.ftl">
<#include "/static/inc/version2.2.0/header.ftl">
<style>#goods_detail_class {width:1000px;}.header-privilege{width:424px;}</style>
<script type="text/javascript" src="${base}/web/webersion2.2.0/js/goods_detail_header.js"></script>
<form name="orderForm" id="orderForm">
      <input id="paymentWayId" name="paymentWayId" type="hidden" value="${paymentWayId?default('')}"/>
      <input id="receiverId" name="receiverId" type="hidden" value="${receiverId?default('')}"/>
      <input id="invoiceTitle" name="order.invoiceTitle" type="hidden" value=""/>
      <input id="ifInvoice" name="order.ifInvoice" type="hidden" value=""/>
      <input id="invoiceType" name="order.invoiceType" type="hidden" value=""/>
      <input id="remark" name="order.remark" type="hidden" value=""/>
      <input id="shortOrderId" name="shortOrderId" type="hidden" value="${shortOrderId?default('')}"/>
      <input id="couponCardId" name="couponCardId" type="hidden" value=""/>
      <input id="deliveryId" name="deliveryId" type="hidden" value="${deliveryId?default('')}"/>
      <input id="cartType" name="cartType" type="hidden" value="${cartType?default('')}"/>
</form>
<input id="invoiceType_test" name="invoiceType_test" type="hidden" value=""/>
<!--步骤开始-->
<div class="w1000" style="height:70px;">
    <div class="shopping-step clearfix">
        <ul>
            <li class="state-tip"><b>1</b><span>选择商品</span></li>
            <li class="bra-line finish-line"></li>
            <li class="state-tip finish-tip"><b>2</b><span class="doing-tit">填写核对订单</span></li>
            <li class="bra-line finish-line"></li>
            <li class="state-tip"><b>3</b><span>成功提交订单</span></li>
            <li class="bra-line"></li>
            <li class="state-tip"><b>4</b><span>完成订单</span></li>
        </ul>
    </div>
    <h2 class="second-logo">确认订单信息</h2>
</div>
<!--步骤结束-->
<!--订单信息开始-->
<div class="order-wrap w1000">
    <!-- 收货人开始-->
    <div class="order-title">
        <h3>1、收货人</h3>
        <span ><a href="${base}/member/receiver.action" target="_blank" class="order-popup">收货地址管理</a></span>
    </div>
    <div class="address-wrap">
        <input type="hidden" id="set-top-v" value="0"/>
        <ul class="address-total" id="receiver_div_id">
           <#list receiverList as receiver>
	            <#if receiver_index?if_exists &lt; 10 >
		            <li id="receiver_div_two_${receiver.id?default('')}" class="<#if receiver_index?if_exists ==3||receiver_index?if_exists ==7>address-no-margin</#if>">
			            <div  onclick ="xuanzeReceiver(${receiver.id?default('')},'receiver_div_id')" class="address-box <#if receiver.id  ==receiverId>address-current-box</#if> ">
			                <span>${receiver.receiver?default('')}</span>
			                <span>${receiver.mobile?default('')}</span>
			                <p>${receiver.area?default('')}${receiver.locationAddress?default('')}${receiver.address?default('')}</p>
			                <#if receiver.isDefault?if_exists ==1><b id ="receiver_is_default_b_id">默认地址</b></#if>
			                <div class="add-border-top"></div>
			                <div class="add-border-bottom"></div>
			                <div class="select-red-bg"><img src="${base}/web/version2.2.0/images/shopping/order_icon01.png" alt=""/></div>
			            </div>
		            </li>
	            </#if>
            </#list>
            <#if receiverSizeFlag?if_exists =='0' >
               <li class="address-no-margin" id="popup-btn2" onclick="showReceiver()">
                <div class="add-address-box"></div>
               </li>
            </#if>
           </ul>
	        <div class="show-more-address" id="gengduo_address_id" <#if (receiverList?size<4) > style="display:none;" </#if>>
	            <a href="javascript:void(0)"><i></i>更多地址</a>
	        </div>
           
    </div>
    <!--收货人结束-->
    <!-- 送货清单开始-->
    <div class="order-title">
        <h3>2、送货清单</h3>
        <a href="javascript:void(0);" onclick="backcart()" class="order-popup">返回购物车修改</a>
    </div>
    <#list goodsList as goods>
	    <div class="invoice-box">
	        <img src="${ui1}${goods.abbreviationPicture?default('')}" alt="" class="invoice-img"/>
	        <span  class="invoice-name">${goods.goodsName?default('')}</span>
	        <span  class="invoice-num">x${goods.quantity?default('')}</span>
	        <span class="invoice-money">${currency(goods.pcPrice?default(''))}</span>
	        <span class="invoice-pay">
	         <#if goods.isYktGood?if_exists ==0>                
	                                   不支持医卡通支付
	         </#if>
	        </span>
	    </div>
     </#list>
    <!-- 送货清单结束-->
    <!-- 支付方式开始-->
    <div class="order-title">
        <h3>3、支付方式</h3>
    </div>
    <div class="pay-list" id="paymentWayUlId">
         <#list paymentWayList as payment>
	           <div class="pay-box <#if payment.id== paymentWayId>pay-current-box</#if>" onclick ="selectPayment(${payment.id?default('')},'paymentWayUlId')" id="payment${payment.id?default('')}">
		            <span class="<#if payment.paymentWay?if_exists ==1>on-delivery</#if> <#if payment.paymentWay?if_exists ==0>on-line</#if>">${payment.name?default('')}</span>
		            <p class="pay-explain <#if payment_index?if_exists ==1>pay-explain02</#if>">${payment.intro?default('')}<b></b></p>
		            <div class="pay-icon"><img src="${base}/web/version2.2.0/images/shopping/order_icon02.png" alt=""/></div>
	           </div>
        </#list>
    </div>
    <!-- 支付方式结束-->
    <!-- 配送方式开始-->
    <div class="order-title">
        <h3>4、配送方式</h3>
    </div>
    <div class="pay-list" id="delivery_ul">
     <#list deliveryWayList as delivery>
         <#if delivery.isflag=='1'>
	         <div class="pay-box <#if delivery.id== deliveryId>pay-current-box</#if>" onclick="deliverySelect(${delivery.id?default('')},'delivery_ul')" id="delivery${delivery.id?default('')}">
	            <span class="express-text">
	            <#if delivery.deliveryCode=='ysd' || delivery.deliveryCode=='ysdj'>
	               <b>推荐</b>
	             </#if>
	             ${delivery.name?default('')}</span>
	            <p class="pay-explain <#if delivery_index &gt; 0>pay-explain0${delivery_index+1}</#if> express-p">${delivery.instro?default('')}<b></b></p>
	            <div class="pay-icon"><img src="${base}/web/version2.2.0/images/shopping/order_icon02.png" alt=""/></div>
	         </div>
         </#if>
      </#list>
    </div>
    <!-- 配送方式结束-->
    <!-- 其他信息及优惠开始-->
    <div class="order-title">
        <h3>5、其他信息及优惠</h3>
    </div>
    <!--发票信息-->
    <div class="my-shopping-cart-list mt-1 clearfix clear">
        <div class="invoice-info">
            <span>发票信息：</span>
            <span style="text-align:left;width:auto;" id="fapiaoSpan">不开发票</span>
            <a href="javascript:showInvoice()" id="popup-btn1">修改</a>
        </div>
        <div class="invoice-info">
            <span>添加订单备注：</span>
            <input type="text"  name="remark_test" id="remark_test" maxlength="70" class="invoice-info-input"/>
        </div>
    </div>
    <!--优惠券、代金券信息-->
    <div class="my-shopping-cart-list mt-1 clearfix clear">
        <div class="coupons-box">
            <h4 class="coupons-title">
                <a href="javascript:void(0)"><i></i>使用优惠券</a>
            </h4>
            <div class="coupons-info">
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
               <!-- <p>
                    <span>共使用了<b>0</b>张优惠券</span>
                    <span>可以优惠<b>0.00</b>元</span>
                </p>-->
            </div>
        </div>
        <div class="coupons-box">
            <h4 class="coupons-title">
                <a href="javascript:void(0)"><i></i>使用现金券</a>
            </h4>
            <div class="coupons-info cash-coupon-info clearfix clear">
                <span>请输入现金券密码</span>
                <input type="text" name="couponCardNo" id="couponCardNo">
                <input type="text" name="couponCardName" readOnly="readOnly" id="couponCardName" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px ;display:none">
                <span id="couponButton"><a href="javascript:cardNoUser()">使用</a></span>
            </div>
        </div>
    </div>
    <!-- 其他信息及优惠结束-->
    <!-- 支付信息开始-->
    <div class="order-title">
        <h3>6、支付信息</h3>
    </div>
    <div class="pay-message">
        <ul>
            <li><span>商品总金额：</span><b id="goodsPrice">¥ ${currency(goodsPrice?default(''))}元</b></li>
            <li><span>优惠金额：</span><b id="promotionalDiscount">¥ -${currency(promotionalDiscount?default(''))}元</b></li>
             <li><span>优惠券：</span><b id="couponDiscount">¥ -${currency(couponDiscount?default(''))}元</b></li>
            <li><span>运费：</span><b id="shippingFee">¥ ${currency(shippingFee?default(''))}元</b></li>
            <li><span style="width:auto;">应付总额：<em id="payableAmount" style="width:auto;">¥ ${currency(payableAmount?default(''))}元</em></span></li>
        </ul>
        <input type="button" id="tijiaoOrder" onclick="saveOrder()" value="提交订单" class="pay-message-btn"/>
    </div>
    <!-- 支付信息结束-->
</div>
<!--订单信息结束-->

<!--遮罩层开始-->
<div id="shade">
 <!--新增收货人信息开始-->
    <div class="out out-box" id="out2" style="display:none">
     <form id="receiverAdd" name="receiverAdd" action="">
      <input type="hidden" name="tmemberreceiver.id" id="tmemberreceiver_id"  value=""/>
            <input type="hidden" name="memberReceiver_adcode" id="memberReceiver_adcode"  value=""/>
            <input type="hidden" name="tmemberreceiver.longitude" id="tmemberreceiver_longitude"  value=""/>
            <input type="hidden" name="city_name_set" id="city_name_set"  value=""/>
            <input type="hidden" name="tmemberreceiver.latitude" id="tmemberreceiver_latitude"  value=""/>
            <input type="hidden" name="tmemberreceiver.locationAddress" id="tmemberreceiver_locationAddress"  value=""/>
            <input type="hidden" name="tmemberreceiver_areaId" id="tmemberreceiver_areaId"  value=""/>
            <input type="hidden" name="tmemberreceiver_is_default" id="tmemberreceiver_is_default"  value=""/>
        <div class="double-out">
            <div class="firse-out">
                <h4 class="out-title">
                    <a href="javascript:closeDiv('out2')" class="close-out"></a>
                    新增收货人信息
                </h4>
                <div class="out-info clearfix clear">
                    <dl class="refund-details clearfix clear">
                        <dt><b>*</b>位置：</dt>
                        <dd>
                            <div id="distpicker">
                                <div class="form-group" style="margin-bottom:0;">
                                    <div style="position: relative;">
                                        <input id="city-picker3" class="form-control" readonly type="text" value="" data-toggle="city-picker">
                                    </div>
                                </div>
                            </div>
                            <div class="location-box" id="city-picker3_tishi">
                            请补充完省市区地址
                            </div>
                        </dd>
                    </dl>
                    <dl class="refund-details clearfix clear">
                        <dt><b>*</b>详细地址：</dt>
                        <dd style="width:500px; position: relative;">
                            <div class="refund-box receive-d">
                                <input type="text" name="tmemberreceiver.address" maxlength="40" id="tmemberreceiver_address" class="refund-price" value="请输入你的收货地址（写字楼,小区,街道或者学校）" onfocus="javascript:if(this.value=='请输入你的收货地址（写字楼,小区,街道或者学校）'){ this.value='';this.style.color='#222';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='请输入你的收货地址（写字楼,小区,街道或者学校）';this.style.color='#222';this.style.border='1px solid #d7d7d7'}">
                            </div>
                             <div id="addressSpanFont" style="position: absolute; top:3px; left:359px; width:116px; height:38px; padding-left: 20px;"><font color="red" ><i style="position: absolute; top:0; left:0; background: url(${base}/web/version2.2.0/images/member/member_data_icon_red.png) no-repeat left center;display:inline-block; width:15px; height:15px;"></i>请填写收货人详细地址，不超过40个字</font></div>
                        </dd>
                    </dl>
                    <dl class="refund-details tel-details clearfix clear">
                        <dt><b>*</b>收货人姓名：</dt>
                        <dd style="width:500px;">
                            <div class="refund-box">
                                <input type="text"  name="tmemberreceiver.receiver" maxlength="10" id="tmemberreceiver_receiver" class="refund-price" value="请输入收货人姓名" onfocus="javascript:if(this.value=='请输入收货人姓名'){ this.value='';this.style.color='#222';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='请输入收货人姓名';this.style.color='#222';this.style.border='1px solid #d7d7d7'}">
                            </div>
                             <div id="receiverSpanFont"><font color="red"  class="location-box" style="line-height:38px;">请填写收货人姓名，不超过10个字</font></div>
                        </dd>
                    </dl>
                    <dl class="refund-details tel-details clearfix clear">
                        <dt><b>*</b>收货人手机号：</dt>
                        <dd style="width:500px;">
                            <div class="refund-box">
                                <input type="text" name="tmemberreceiver.mobile" maxlength="11" id="tmemberreceiver_mobile" class="refund-price" value="请输入收货人手机号" onfocus="javascript:if(this.value=='请输入收货人手机号'){ this.value='';this.style.color='#222';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='请输入收货人手机号';this.style.color='#222';this.style.border='1px solid #d7d7d7'}">
                            </div>
                            <div ><font color="red" id="mobileSpanFont"  class="location-box"  style="line-height:38px;">请输入11位正确手机号码</font></div>
                        </dd>
                    </dl>
                    <div class="check-box-address">
                        <input type="checkbox" value="1" id="tmemberreceiver_is_default_checkbox"/>设置为默认收货地址
                    </div>
                    <div class="for-btn-box add-receive-box clearfix clear">
                        <a href="javascript:saveOrupdateReceiver('receiverAdd','out2')" class="submit-refund">提 交</a>
                        <a href="javascript:closeDiv('out2')" class="cancel-btn">取消</a>
                    </div>
                </div>
            </div>
        </div>
        </form>
    </div>
    <!--新增收货人信息结束-->
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
                    <div class="invoice-box-popup">
                        <ul class="invoice-list">
                            <li class="invoice-input">
                               <input type="text" id="invoice_title" maxlength="50" name="invoice_title"><span id="invoice_title"></span>
                            </li>
                        </ul>
                    </div>
                </dd>
            </dl>
            <dl class="refund-details clearfix clear">
                <dt>发票内容：</dt>
                <dd>
                    <div class="invoice-box-popup">
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
                 <a href="javascript:saveInvoice()" class="submit-refund">保存发票信息</a><a href="javascript:closeDiv('out1')" >取消</a>
            </div>
        </div>
    </div>
    <!--发票信息结束-->
</div>
<!--遮罩层结束-->
<script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${base}/web/js/cookieUtil.js"></script>
<script  type="text/javascript" src="${base}/web/version2.2.0/js/order_add_v3.js"></script>
<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
<script src="${base}/web/version2.2.0/js/bootstrap.js"></script>
<script src="${base}/web/version2.2.0/js/city-picker.data.js"></script>
<script src="${base}/web/version2.2.0/js/city-picker.js"></script>
<script src="${base}/web/version2.2.0/js/main.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css"/>
<script>
//更多地址
$('.show-more-address').click(function(){
	var oCorner = $(this).find('i');
	if(oCorner.hasClass('off')){
		$('.address-total').removeClass('height-auto');
		oCorner.removeClass('off');
		 $("#receiver_div_id").find("li").each(function(index){
			if($(this).children().hasClass('address-current-box')){
			  if(index>3){
			      if($("#receiver_is_default_b_id").html()){//判断是否有默认地址
			         $(this).insertAfter($("#receiver_is_default_b_id").parent().parent());
			      }else{
			         $(this).insertBefore($("#receiver_div_id").children().eq(0));
			      }
			      return false;
			  }
		    }
		  });
		  
		  $("#receiver_div_id").find("li").each(function(index){
			if(index == 3||index==7){
			   if(!$(this).hasClass('address-no-margin')){
			      $(this).addClass('address-no-margin');
			   }
			}else{
			   if($(this).hasClass('address-no-margin')){
			      $(this).removeClass('address-no-margin');
			   }
			}
		  });
	}else{
		$('.address-total').addClass('height-auto');
		oCorner.addClass('off');
	}
})
//优惠券展开收起
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
// 获得选中地址的areaId
function getAreaId(areaId){
   $("#tmemberreceiver_areaId").val(areaId);
}
//根据选择判断 位置内容
function checkArea(areaVal){
   $("#city-picker3").val(areaVal);
   if(areaVal!=null&&areaVal!=''){
      if(areaVal.split("-").length>2){
	     $("#city-picker3_tishi").hide();
	   }else{
	     $("#city-picker3_tishi").show();
	   }
   }else{
        $("#city-picker3_tishi").show();
   }
}


</script>
<#include "/static/inc/version2.2.0/footer.ftl">
</body>
</html>