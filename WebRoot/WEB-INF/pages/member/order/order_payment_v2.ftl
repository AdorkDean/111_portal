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
    <link rel="stylesheet" type="text/css" href="${base}/web/css/weixinzhifu.css">
</head>
<body>
<#include "/WEB-INF/pages/inc/taglibs.ftl">
<#include "/static/inc/version2.2.0/header.ftl">
<style>#goods_detail_class {width:1000px;}</style>
<script type="text/javascript" src="/webersion2.2.0/js/goods_detail_header.js"></script>
<!--步骤开始-->
<div class="second-header w1000">
    <div class="shopping-step clearfix">
        <ul>
            <li class="state-tip"><b>1</b><span>选择商品</span></li>
            <li class="bra-line"></li>
            <li class="state-tip"><b>2</b><span>填写核对订单</span></li>
            <li class="bra-line finish-line"></li>
            <li class="state-tip finish-tip"><b>3</b><span class="doing-tit">成功提交订单</span></li>
            <li class="bra-line finish-line"></li>
            <li class="state-tip"><b>4</b><span>完成订单</span></li>
        </ul>
    </div>
    <h2 class="second-logo">支付订单</h2>
</div>
<!--步骤结束-->
<!--订单信息开始-->
<div class="pay-order w1000">
    <h2 class="pay-order-title">订单已提交，请于24小时内完成支付</h2>
    <ul class="pay-order-mes">
        <li>订单号：${order.orderSn?if_exists}</li>
        <li> 收货人：${order.receiver?if_exists}</li>
        <li>收货地址：${order.areaName?if_exists}${order.detailedAddress?if_exists}</li>
        <li> 联系电话：${order.phone?if_exists}</li>
        <li>待支付金额：<span>¥${currency(order.payableAmount?default(''))}</span>　　　<b>完成订单后</b>可获积分：<span>${order.rewardIntegration?if_exists}</span></li>
    </ul>
    <!-- 支付平台开始-->
    <div class="pay-terrace-title">
        <span>支付平台</span>
    </div>
    <ul class="pay-terrace-list">
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank01.jpg" alt=""/><a href="javascript:selectPaymentPluginId('payWzfPlugin')" id="payWzfPlugin"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank02.jpg" alt=""/><a href="javascript:selectPaymentPluginId('alipayDirectPlugin')" id="alipayDirectPlugin" ><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank03.jpg" alt=""/><a href="javascript:selectPaymentPluginId('payYktPlugin')" id="payYktPlugin"><b></b></a></li>
    </ul>
    <!-- 支付平台结束-->
    <!-- 银行卡开始-->
    <div class="pay-terrace-title">
        <span>银行卡</span>
    </div>
    <ul class="pay-terrace-list">
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank04.jpg" alt=""/><a href="javascript:selectBank('ICBC')" id="ICBC"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank05.jpg" alt=""/><a href="javascript:selectBank('CCB')" id="CCB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank06.jpg" alt=""/><a href="javascript:selectBank('ABC')" id="ABC"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank07.jpg" alt=""/><a href="javascript:selectBank('CMB')" id="CMB"><b></b></a></li>
        <li class="pay-no-margin"><img src="${base}/web/version2.2.0/images/shopping/pay_bank08.jpg" alt=""/><a href="javascript:selectBank('BOC')" id="BOC"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank09.jpg" alt=""/><a href="javascript:selectBank('SPDB')" id="SPDB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank10.jpg" alt=""/><a href="javascript:selectBank('BCOM')" id="BCOM"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank11.jpg" alt=""/><a href="javascript:selectBank('GDB')" id="GDB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank12.jpg" alt=""/><a href="javascript:selectBank('CMBC')" id="CMBC"><b></b></a></li>
        <li class="pay-no-margin"><img src="${base}/web/version2.2.0/images/shopping/pay_bank13.jpg" alt=""/><a href="javascript:selectBank('CIB')" id="CIB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank14.jpg" alt=""/><a href="javascript:selectBank('CEB')" id="CEB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank15.jpg" alt=""/><a href="javascript:selectBank('CITIC')" id="CITIC"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank16.jpg" alt=""/><a href="javascript:selectBank('PSBC')" id="PSBC"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank17.jpg" alt=""/><a href="javascript:selectBank('PAB')" id="PAB"><b></b></a></li>
        <li class="pay-no-margin"><img src="${base}/web/version2.2.0/images/shopping/pay_bank18.jpg" alt=""/><a href="javascript:selectBank('SHB')" id="SHB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank19.jpg" alt=""/><a href="javascript:selectBank('SDB')" id="SDB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank20.jpg" alt=""/><a href="javascript:selectBank('BJRCB')" id="BJRCB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank21.jpg" alt=""/><a href="javascript:selectBank('BOB')" id="BOB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank22.jpg" alt=""/><a href="javascript:selectBank('NBCB')" id="NBCB"><b></b></a></li>
        <li class="pay-no-margin"><img src="${base}/web/version2.2.0/images/shopping/pay_bank23.jpg" alt=""/><a href="javascript:selectBank('HSB')" id="HSB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank24.jpg" alt=""/><a href="javascript:selectBank('HXB')" id="HXB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank25.jpg" alt=""/><a href="javascript:selectBank('NJCB')" id="NJCB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank26.jpg" alt=""/><a href="javascript:selectBank('CBHB')" id="CBHB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank27.jpg" alt=""/><a href="javascript:selectBank('HZB')" id="HZB"><b></b></a></li>
        <li class="pay-no-margin"><img src="${base}/web/version2.2.0/images/shopping/pay_bank28.jpg" alt=""/><a href="javascript:selectBank('BEA')" id="BEA"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank29.jpg" alt=""/><a href="javascript:selectBank('SRCB')" id="SRCB"><b></b></a></li>
        <li><img src="${base}/web/version2.2.0/images/shopping/pay_bank30.jpg" alt=""/><a href="javascript:selectBank('CZB')" id="CZB"><b></b></a></li>
    </ul>
    <dl class="pay-order-email" id="emailOut" style="display:none">
        <dt><span>*</span>填写账单邮箱</dt>
        <dd><input name="payerEmailDiv" id="payerEmailDiv" type="text" class="emailInput" value="${billEmail?if_exists}"/></dd>
    </dl>
    <!-- 银行卡结束-->
    <div class="pay-order-btn">
        <input type="button" value="确认支付" class="popup-btn3" onclick="orderSubmit()"/>
        <#if hdfkFlag =='1'>
        	<p>在线遇到问题？<a href="javascript:showPayWindow('shade','out4');">货到付款</a></p>
        </#if>
    </div>
</div>
<!--遮罩层开始-->
<div id="shade">
    <!--提交支付开始-->
    <div class="out450 out-box450" id="out3" style="display:none;">
        <h4 class="out-title">
            <a href="javascript:closePayWindow('shade','out3')" class="close-out"></a>
            提示信息
        </h4>
        <div class="out-info clearfix clear">
            <p class="out-text">请您在新的支付页面完成付款！</p>
            <dl class="out-text-btn">
                <dt>付款成功：</dt>
                <dd><a href="${base}/member/order!detail.action?id=${order.id?if_exists}">查看订单详情</a></dd>
            </dl>
            <dl class="out-text-btn">
                <dt>付款失败：</dt>
                <dd><a href="javascript:closePayWindow('shade','out3')">选择其他支付方式</a></dd>
            </dl>
        </div>
    </div>
    <!--提交支付结束-->
    
   <!--货到付款提示信息开始-->
    <div class="out450 out-box450" id="out4" style="display:none;">
        <h4 class="out-title">
            <a href="javascript:closePayWindow('shade','out4')" class="close-out"></a>
            提示信息
        </h4>
        <div class="out-info clearfix clear">
            <p class="out-text">您确定要使用货到付款进行支付吗？</p>
            <div class="out-button">
                <a href="javascript:changePayWay()" class="bg-color">确 认</a>
                <a href="javascript:closePayWindow('shade','out4')"">取 消</a>
            </div>
        </div>
    </div>
    <!--货到付款提示信息结束-->
</div>
<!--遮罩层结束-->
<!--订单信息结束-->


<div id="weixinzhifu" style="display:none;">
	<div class="lbybg"></div>
    <div class="weixincont">
    	<div class="weixinwrp">
    		<a class="scha" href="javascript:wzfclose()"></a>
        	<div class="weilogo">
            	<img src="${base}/web/images/weilogo_03.jpg" title="111医药馆网上药店微信支付"/>
            </div>
            <div class="belowwrp">
                <div class="weileft">
                    <div class="bottomline price">¥${currency(order.payableAmount?default(''))}</div>
                    <div class="bottomline num">
                        <p><span>交易单号</span>&nbsp;<span>${order.orderSn?if_exists}</span></p>
                        <p><span>创建时间</span>&nbsp;<span>${order.createDate?string("yyyy-MM-dd")}</span>&nbsp;<span>${order.createDate?string("HH:mm:ss")}</span></p>
                    </div>
                    <div class="phonenum"><img src="${base}/web/images/phone_03.jpg"/></div>                
                </div>            
                <div class="weiright">
                    <div class="weima"><img id="wzfPay" src="" width="242px" height="242px"/></div>
                    <div class="weitshi"><img src="${base}/web/images/weibottom_10.jpg"/></div>
                </div>
            </div>
        </div>
    </div>
</div>

 <form name="payForm" id="payForm" method="post" action ="" target="_blank">
        <input id="orderId" name="orderId" type="hidden" value="${order.id?if_exists}"/>
	    <input type="hidden" name="bankId" id="bankId" value="" />
	    <input type="hidden" name="paymentPluginId" id="paymentPluginId" value="" />
	    <!--//支付人联系类型，1 代表电子邮件方式；2 代表手机联系方式。可以为空。-->
	    <input type="hidden" name="payerContactType" id="payerContactType" value="1" />
	    <input name="payerEmail" id="payerEmail" type="hidden" >
 </form>

<script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css"/>
<script>
//取消被选中的支付方式
   function cancleClass(){
      $(".show").each(function(){
	    $(this).removeClass('show');
	  });
	  $(".show2").each(function(){
	    $(this).removeClass('show2');
	  });
   }
   //支付平台选择
   function selectPaymentPluginId(paymentPluginId){
      cancleClass();
      $("#"+paymentPluginId).parent().addClass('show2');
      $("#paymentPluginId").val(paymentPluginId);
      $("#emailOut").hide();
   }
   
   //银行卡选择
   function selectBank(bankId){
      cancleClass();
      $("#"+bankId).parent().addClass('show');
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
            $alertCanDisplay("warn","请填写账单邮箱!",null,null);
            return;
          }else{
             var emailzz  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
             if (!emailzz.test($.trim($("#payerEmailDiv").val()))){
                 $alertCanDisplay("warn","账单邮箱格式不正确!",null,null);
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
          showPayWindow('shade','out3');
	      //$("#submitpay").val("提交中...")
	      $("#payForm").attr("action","${base}/member/order!orderPay.action")
	      $("#payForm").submit();
      }
   }
 //弹出提示层 
function showPayWindow(shadeId,outId){
   $("#"+shadeId).css({
			display:"block"
   })
   $("#"+outId).show();
}  
//关闭弹出层   
function closePayWindow(shadeId,outId){
	$("#"+outId).hide();
	$("#"+shadeId).hide();

}   
//关闭微信支付层
   function wzfclose(){
        $('#weixinzhifu').hide();
   }
   
   //更改支付方式
   function changePayWay(){
       $.ajax({
				url : "../member/order!ajaxChangePayWayHdfk.action",
				type : "post",
				data :{"orderId":$("#orderId").val()},
				success : function(data) {
					if (data.flag) { 
						window.location.href="/member/order!orderSumbitSuccess.action?orderId="+$("#orderId").val();
					} else {
						if (data.message == '0') {
							$alertCanDisplay("warn","系统异常，请稍后再试!",null,null);
						} else if (data.message == '2') {
							$alertCanDisplay("warn","操作失败，订单当前环节无法更改为货到付款!",null,null);
						} 
					}
				},
				error : function() {
					$alertCanDisplay("error","系统异常，请稍后再试",null,null);
				}
			});
     
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
<#include "/static/inc/version2.2.0/footer.ftl">
</body>
</html>
