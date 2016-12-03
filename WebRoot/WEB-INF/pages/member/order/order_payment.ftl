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
    <link rel="stylesheet" type="text/css" href="${base}/web/css/weixinzhifu.css">
</head>
<body>
<#include "/static/inc/shopping_pay_header.ftl">
  <form name="payForm" id="payForm" method="post" action ="">
	<!--购物-支付模块开始-->
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
            		<div class="proce ready">
                    	<ul>
                        	<li class="tx1">&nbsp;</li>
                        </ul>
                    </div>
            		<div class="node ready">
                    	<ul>
                        	<li class="tx1"><span class="state"><s></s>填写核对订单信息</span></li>
                        </ul>
                    </div>
            		<div class="proce doing">
                    	<ul>
                        	<li class="tx1">&nbsp;</li>
                        </ul>
                    </div>
            		<div class="node doing">
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
            <!--支付开始-->
            <div class="my-shopping-cart">
            	<div class="shopping-order">
                	<dl class="submit-order-info clearfix clear">
                    	<dt><b></b>
                    	  <#if order.orderStatus==0 &&paymentWay.paymentCode !='hdfk'>
                    	              订单已提交，请于24小时内完成支付！
                    	   </#if>
                    	   <#if order.orderStatus==1 &&paymentWay.paymentCode =='hdfk'>
                    	                订单提交成功，请等待商品配送！
                    	    </#if>
                    	   <#if order.orderStatus==1 &&paymentWay.paymentCode !='hdfk'>
                    	                     订单支付成功，请等待商品配送！
                    	    </#if>
                    	</dt>
                        <dd>
                        	<p>订单号：${order.orderSn?if_exists}</p>
							<p><span>收货人：${order.receiver?if_exists}</span><span>${order.areaName?if_exists}${order.detailedAddress?if_exists}</span><span>${order.phone?if_exists}</span></p>
							<p><span>待支付金额：<b>¥${currency(order.payableAmount?default(''))}</b></span><spa>可获积分：<b>${order.rewardIntegration?if_exists}</b></span></p>
                        </dd>
                    </dl>
                </div>
                <#if paymentWay.paymentCode=='xszf' && order.orderStatus==0>
                   <div class="payment-way">
                	<div class="payment-platform">
                    	<h4 class="receiver-info-title">支付平台</h4>
                        <ul class="payment-platform-list clearfix clear">
                        	<!--<li><a href="javascript:selectPaymentPluginId('payEBCPlugin')" id="payEBCPlugin" class=""><img width="120" height="25" src="../web/images/pay/pay_slt.jpg"/><i></i></a></li>
                            <li><a href="javascript:selectPaymentPluginId('paySxpayPlugin')" id="paySxpayPlugin" class=""><img width="120" height="25" src="../web/images/pay/pay_sqb.png"/><i></i></a></li>-->
                            <li><a href="javascript:selectPaymentPluginId('payWzfPlugin')" id="payWzfPlugin" class=""><img width="120" height="25" src="../web/images/pay/pay_wxzf.jpg"/><i></i></a></li>
                            <li><a href="javascript:selectPaymentPluginId('alipayDirectPlugin')" id="alipayDirectPlugin" class=""><img width="120" height="25" src="../web/images/pay/pay_zfb.jpg"/><i></i></a></li>
                            <li><a href="javascript:selectPaymentPluginId('payYktPlugin')" id="payYktPlugin" class=""><img width="120" height="25" src="../web/images/pay/pay_ykt.jpg"/><i></i></a></li>
                        </ul>
                    </div>
                    <div class="bank-card">
                    	<h4 class="receiver-info-title">银行卡</h4>
                        <ul class="payment-platform-list bank-card-list clearfix clear">
                                           <li>
	                                                <a href="javascript:selectBank('ICBC')" id="ICBC" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_icbc.jpg"/><i></i></a>
	                                        </li>
	                                        <li>
	                                                <a href="javascript:selectBank('CCB')" id="CCB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_ccb.jpg"/><i></i></a>
	                                        </li>
	                                        <li>
	                                                <a href="javascript:selectBank('ABC')" id="ABC" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_abc.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('CMB')" id="CMB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_cmb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('BOC')" id="BOC" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_boc.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('SPDB')" id="SPDB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_spdb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('BCOM')" id="BCOM" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_bcom.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('GDB')" id="GDB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_gdb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('CMBC')" id="CMBC" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_cmbc.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('CIB')" id="CIB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_cib.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('CEB')" id="CEB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_ceb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('CITIC')" id="CITIC" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_citic.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('PSBC')" id="PSBC" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_psbc.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('PAB')" id="PAB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_pab.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('SHB')" id="SHB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_shb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('SDB')" id="SDB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_sdb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('BJRCB')" id="BJRCB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_bjrcb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('BOB')" id="BOB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_bob.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('NBCB')" id="NBCB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_nbcb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('HSB')" id="HSB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_hsb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('HXB')" id="HXB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_hxb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('NJCB')" id="NJCB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_njcb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('CBHB')" id="CBHB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_cbhb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('HZB')" id="HZB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_hzb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('BEA')" id="BEA" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_bea.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('SRCB')" id="SRCB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_srcb.jpg"/><i></i></a>
	                                        </li>
	                            			<li>
	                                                <a href="javascript:selectBank('CZB')" id="CZB" class=""><img width="120" height="25" alt="" src="../web/images/bankimages/bank_czb.jpg"/><i></i></a>
	                                        </li>
                        
                        </ul>
                    </div>
                    <div id="emailOut" class="emailOutTip" style="display:none">
				       <span class="text12B">填写支付邮箱：</span>
                       <input name="payerEmailDiv" id="payerEmailDiv" type="text" class="emailInput" value="" >
				       <span id="emailYuan" class="textGray">（必填）留下您有效电子邮箱，可接受本次交易的支付凭证。</span>
				    </div>
                    <div class="for-settle-accounts clearfix clear">
                        <a href="javascript:orderSubmit()" class="go-settle-accounts" id="submitpay">确认支付</a>
                    </div>
                </div>
                </#if>
            </div>
            <!--支付结束-->
        </div>
    </div>
     <#if paymentWay.paymentCode=='xszf' && order.orderStatus==0>
	    <input id="orderId" name="orderId" type="hidden" value="${order.id?if_exists}"/>
	    <input type="hidden" name="bankId" id="bankId" value="" />
	    <input type="hidden" name="paymentPluginId" id="paymentPluginId" value="" />
	    <!--//支付人联系类型，1 代表电子邮件方式；2 代表手机联系方式。可以为空。-->
	    <input type="hidden" name="payerContactType" id="payerContactType" value="1" />
	    <input name="payerEmail" id="payerEmail" type="hidden" >
	    </#if>
    </form>
    
    
    <!--购物-支付模块结束-->
    
  <div id="weixinzhifu" style="display:none;">
	<div class="lbybg"></div>
    <div class="weixincont">
    	<div class="weixinwrp">
    		<a class="scha" href="javascript:wzfclose()"></a>
        	<div class="weilogo">
            	<img src="../web/images/weilogo_03.jpg" title="111医药馆网上药店微信支付"/>
            </div>
            <div class="belowwrp">
                <div class="weileft">
                    <div class="bottomline price">¥${currency(order.payableAmount?default(''))}</div>
                    <div class="bottomline num">
                        <p><span>交易单号</span>&nbsp;<span>${order.orderSn?if_exists}</span></p>
                        <p><span>创建时间</span>&nbsp;<span>${order.createDate?string("yyyy-MM-dd")}</span>&nbsp;<span>${order.createDate?string("HH:mm:ss")}</span></p>
                    </div>
                    <div class="phonenum"><img src="../web/images/phone_03.jpg"/></div>                
                </div>            
                <div class="weiright">
                    <div class="weima"><img id="wzfPay" src="" width="242px" height="242px"/></div>
                    <div class="weitshi"><img src="../web/images/weibottom_10.jpg"/></div>
                </div>
            </div>
        </div>
    </div>
</div>
    
    
</body>	
<script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css"/>
<#include "/static/inc/footer.ftl">
<script>
   //取消被选中的支付方式
   function cancleClass(){
      $(".payment-curr").each(function(){
	    $(this).attr("class","");
	  });
   }
   //支付平台选择
   function selectPaymentPluginId(paymentPluginId){
      cancleClass();
      $("#"+paymentPluginId).attr("class","payment-curr");
      $("#paymentPluginId").val(paymentPluginId);
      $("#emailOut").hide();
   }
   //银行卡选择
   function selectBank(bankId){
      cancleClass();
      $("#"+bankId).attr("class","payment-curr");
      $("#paymentPluginId").val("pay99billPlugin");
      $("#bankId").val(bankId);
      $("#emailOut").show();
   }
   //提交
   function orderSubmit(){
      if($("#paymentPluginId").val()==''){
          $alertCanDisplay("warn","请选择支付方式!",null,null);
         return;
      }
      if($("#paymentPluginId").val()=='pay99billPlugin'){
          if($.trim($("#payerEmailDiv").val())==''){
            $alertCanDisplay("warn","请填写支付邮箱!",null,null);
            return;
          }else{
             var emailzz  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
             if (!emailzz.test($.trim($("#payerEmailDiv").val()))){
                 $alertCanDisplay("warn","邮箱格式不正确!",null,null);
                   return;
             }
          }
         $("#payerEmail").val($.trim($("#payerEmailDiv").val()));
      }
      if($("#paymentPluginId").val()=='payWzfPlugin') {
			$.post("${base}/member/order!orderPay.action",$('#payForm').serialize(),function(data){
				$("#wzfPay").attr("src",data);
				$("#weixinzhifu").show();
			});
       }else{
      $("#submitpay").val("提交中...")
      $("#payForm").attr("action","${base}/member/order!orderPay.action")
      $("#payForm").submit();
      }
   }
   
   function wzfclose(){
   $('#weixinzhifu').hide();
   }
   
      // 检查支付
		setInterval(function() {
			$.ajax({
				url: "${base}/member/order!checkOrderPay.action",
				type: "POST",
				data: {ordersn: "${order.orderSn?if_exists}"},
				dataType: "json",
				cache: false,
				success: function(data) {
					if (data=='1') {
						location.href = "${base}/member/order!pageReturnUrl.action?ordersn="+${order.orderSn?if_exists};
					}
				}
			});
		}, 5000);
</script>

</html>
