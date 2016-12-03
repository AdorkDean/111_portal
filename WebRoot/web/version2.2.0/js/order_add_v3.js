//返回购物车
function backcart(){
   	 var key = getCookie("111yao");
     window.location.href="../carts/cart!page.action?key="+key;
}

//选择收货地址
function xuanzeReceiver(receiverId,uiid){
	if(receiverId!=$("#receiverId").val()){
		$("#receiverId").val(receiverId);
		$("#"+uiid).find("li").each(function() {
			if($(this).children().hasClass('address-current-box')){
				$(this).children().removeClass('address-current-box');
			}
		});
		$("#receiver_div_two_"+receiverId).children().addClass('address-current-box');
		jisuanOrderPrice();
		queryPaymentWay();
	}else{
		$("#"+uiid).find("li").each(function() {
			if($(this).children().hasClass('address-current-box')){
				$(this).children().removeClass('address-current-box');
			}
		});
		$("#receiver_div_two_"+receiverId).children().addClass('address-current-box');
	}
}

//根据收货地址查询 支付方式
function queryPaymentWay() {
	var receiverId = $("#receiverId").val();
	$("#paymentWayId").val("");
	if (receiverId != '') {
		$.ajax({
					url : "../member/order!paymentWayByReceiverId.action",
					type : "post",
					data : {
						"receiverId" : receiverId
					},
					success : function(data) {
						if (data != '') { // '1'更新,'2'修改
							if (data.length > 0) {
								var paymentHtml = "";
								for ( var i = 0; i < data.length; i++) {
									paymentHtml +="<div class=\"pay-box\" onclick =\"selectPayment("+ data[i].id+ ",'paymentWayUlId')\" id=\"payment"+data[i].id+"\">";
									if(data[i].paymentWay==1){
										paymentHtml +="<span class=\"on-delivery\">"+data[i].name+"</span>";
									}else{
										paymentHtml +="<span class=\"on-line\">"+data[i].name+"</span>";
									}
									if(i==1){
										paymentHtml +="<p class=\"pay-explain pay-explain02\">"+data[i].intro+"<b></b></p>";
									}else{
										paymentHtml +="<p class=\"pay-explain\">"+data[i].intro+"<b></b></p>";
									}
									paymentHtml +="<div class=\"pay-icon\"><img src=\"../web/version2.2.0/images/shopping/order_icon02.png\" alt=\"\"/></div>";
									paymentHtml +="</div>";
								}
								$("#paymentWayUlId").html(paymentHtml);
							} else {
								$("#paymentWayUlId").html("");
							}
						}
					},
					error : function() {
						$alertCanDisplay("error","系统异常，请稍后再试",null,null);
					}
				});
	}
	deliveryWayList();
}





//优惠券选择框赋值优惠券id
function pushCouponCardId(){
	$("#couponCardId").val($("#couponCardId_card").val());
	$("#couponCardName").val("");
	$("#couponCardName").hide();
	$("#couponCardNo").val("");
	$("#couponCardNo").show();
	 $("#couponButton").html("<a href=\"javascript:cardNoUser()\">使用</a>")
}

//使用优惠券
function cardNoUser(){
  var couponCardNo = $("#couponCardNo").val();// 优惠券码
   if($.trim(couponCardNo)==''){
       $alertCanDisplay("warn","请输入优惠券编码",null,null);
       return ;
   }
   var cartType =$("#cartType").val();
   $.ajax({
		url : "../member/order!checkCouponCard.action",
		type : "post",
		data : {
			"couponCardNo" : couponCardNo,
			"cartType":cartType
		},
		success : function(data) {
			if(data.resultFlag=='1'){
			   $("#couponCardId_card").val("");
			   $("#couponCardNo").hide();
			   $("#couponCardName").show();
			   $("#couponCardName").val(data.name);
			   $("#couponCardId").val(data.couponCardId);
			   $("#couponButton").html("<a href=\"javascript:cardNoQuxiao()\">取消</a>")
			   jisuanOrderPrice();
			}else if(data.resultFlag=='2'){
			   $alertCanDisplay("warn","请输入优惠券编码!",null,null);
			}else if(data.resultFlag=='3'){
			   $alertCanDisplay("warn","该优惠券不存在!",null,null);
			}else{
			   $alertCanDisplay("warn","该优惠券不符合使用规则,无法使用!",null,null);
			}
		},
		error : function() {
			$alertCanDisplay("error","操作失败，请稍后再试",null,null);
		}
	});
   
}

//选择支付方式
function selectPayment(paymentId,uiid) {
	if(paymentId!=$("#paymentWayId").val()){
		cancleClass(uiid);
		$("#payment" + paymentId).attr("class", "pay-box pay-current-box");
		$("#paymentWayId").val(paymentId);
		deliveryWayList();
		jisuanOrderPrice();
	}
	
}

//选择配送方式
function deliverySelect(deliveryId,uiid){
	cancleClass(uiid);
	$("#delivery" + deliveryId).attr("class", "pay-box pay-current-box");
	$("#deliveryId").val(deliveryId);
	jisuanOrderPrice();
}

//取消被选中的支付方式
function cancleClass(uiid) {
	$("#"+uiid).find(".pay-current-box").each(function() {
		$(this).attr("class", "pay-box");
	});
}
//计算订单金额
function jisuanOrderPrice() {
	var shortOrderId = $("#shortOrderId").val();//秒杀订单id
	var couponCardId = $("#couponCardId").val();// 优惠券id
	var receiverId = $("#receiverId").val();// 收货地址id
	var paymentWayId = $("#paymentWayId").val();// 支付方式
	var deliveryId =$("#deliveryId").val();
	var cartType =$("#cartType").val();
	$.ajax({
		url : "../member/order!computeOrderPrice.action",
		type : "post",
		data : {
			"couponCardId" : couponCardId,
			"paymentWayId" : paymentWayId,
			"receiverId" : receiverId,
			"shortOrderId" : shortOrderId,
			"deliveryId" : deliveryId,
			"cartType":cartType
		},
		success : function(data) {
			data = eval('(' + data + ')');
			$("#goodsPrice").html("¥ " + data.goodsPrice.toFixed(2) + "元")
			$("#promotionalDiscount").html("¥ -" + data.promotionalDiscount.toFixed(2) + "元")
			$("#couponDiscount").html("¥ -" + data.couponDiscount.toFixed(2) + "元")
			$("#shippingFee").html("¥ " + data.shippingFee.toFixed(2) + "元")
			$("#payableAmount").html("¥ " + data.payableAmount.toFixed(2) + "元")
		},
		error : function() {
			$alertCanDisplay("error","操作失败，请稍后再试",null,null);
		}
	});
}



//根据收货地址  支付方式 查询 配送方式
function deliveryWayList() {
	var paymentWayId =$("#paymentWayId").val();
	var receiverId = $("#receiverId").val();
	$("#deliveryId").val("");
	//$("#delivery_ul").html("");
	if (receiverId != '') {
		$.ajax({
					url : "../member/order!deliveryWayList.action",
					type : "post",
					data : {
						"receiverId" : receiverId,
						"paymentWayId":paymentWayId
					},
					success : function(data) {
						if (data != '') { 
							if (data.length > 0) {
								var paymentHtml = "";
								for ( var i = 0; i < data.length; i++) {
									paymentHtml+="<div class=\"pay-box\" onclick=\"deliverySelect("+data[i].id+",'delivery_ul')\" id=\"delivery"+data[i].id+"\">";
									paymentHtml+="<span class=\"express-text\">";
									if(data[i].deliveryCode=='ysd'||data[i].deliveryCode=='ysdj'){
										paymentHtml+="<b>推荐</b>";	
									}
									paymentHtml += data[i].name+"</span>";
									if(i>0){
										paymentHtml += "<p class=\"pay-explain pay-explain0"+(i+1)+" express-p\">"+data[i].instro+"<b></b></p>";
									}else{
										paymentHtml += "<p class=\"pay-explain express-p\">"+data[i].instro+"<b></b></p>";
									}
									paymentHtml += "<div class=\"pay-icon\"><img src=\"../web/version2.2.0/images/shopping/order_icon02.png\" alt=\"\"/></div>";
									paymentHtml += "</div>";
								}
								$("#delivery_ul").html(paymentHtml);
							} else if(paymentWayId==4){
								$("#delivery_ul").html("<p class=\"pay-explain-jd\" >货到付款默认由京东快递发货<b></b></p>");
							}else{
								$("#delivery_ul").html("");
							}
						}else if(paymentWayId==4){
							$("#delivery_ul").html("<p class=\"pay-explain-jd\" >货到付款默认由京东快递发货<b></b></p>");
						}else{
							$("#delivery_ul").html("");
						}
					},
					error : function() {
						$alertCanDisplay("error","系统异常，请稍后再试",null,null);
					}
				});
	}
}

//显示发票弹出层
function showInvoice(){
		$("#shade").css({
			display:"block"
		})
		/*alert($("#del_").val());*/
		$("#out1").show();
		var invoiceType =$("#invoiceType").val();
        if(invoiceType ==''){
           invoiceType='0';
        }
        invoiceSelect(invoiceType);
}

//选择发票类型
function invoiceSelect(id) {
	$(".invoice-curr").each(function() {
		$(this).attr("class", "");
	});
	$("#invoice-curr" + id).attr("class", "invoice-curr");
	$("#invoiceType_test").val(id);
}

//添加发票信息
function saveInvoice() {
	var invoice_title = $.trim($("#invoice_title").val());
	if ($("#invoiceType_test").val() != 0) {
		if (invoice_title =='') {
			$alertCanDisplay("warn","发票抬头不能为空",null,null);
			return;
		} 
		$("#invoiceTitle").val(invoice_title);
		$("#invoiceType").val($("#invoiceType_test").val());
		$("#fapiaoSpan").html(invoice_title);
	} else {
		$("#invoice_title").val("");
		$("#invoiceType").val("");
		$("#fapiaoSpan").html("不开发票");
	}
	$("#out1").hide();
	$("#shade").hide();
}
//关闭div层
function closeDiv(out_id) {
	$("#" + out_id).hide();
	$("#shade").hide();
	if (out_id == 'out1') {// 发票关闭层
		$("#nvoiceType_test").val($("#nvoiceType").val());
	} else if (out_id == 'out2') {
		//$("#receiverSpanFont").html("");
		//$("#addressSpanFont").html("");
		//$("#mobileSpanFont").html("");
		$("#city-picker3").val("");
	} else if (out_id == 'out3') {
		$("#update_receiverSpanFont").html("");
		$("#update_areaIdSpanFont").html("");
		$("#update_addressSpanFont").html("");
		$("#update_mobileSpanFont").html("");
		$("#update_zipCodeSpanFont").html("");
	}

}


//验证收货信息
function checkReceiver() {
	var flag = true;
	
	var areaVal =$("#city-picker3").val();
   if(areaVal!=null&&areaVal!=''){
      if(areaVal.split("-").length<2){
    	  flag= false;
    	  $("#city-picker3_tishi").show();
	   }
   }else{
	   flag= false;
    	  $("#city-picker3_tishi").show();
   }
	// 收货人
	var tmemberreceiver_receiver = $.trim($("#tmemberreceiver_receiver").val());
	if (tmemberreceiver_receiver == ''||tmemberreceiver_receiver =='请输入收货人姓名') {
		//$("#receiverSpanFont").html("请输入收货人姓名，不超过10个字");
		flag = false;
	} else {
		//$("#receiverSpanFont").html("");
	}

	// 详细地址
	var tmemberreceiver_address = $.trim($("#tmemberreceiver_address").val());
	if (tmemberreceiver_address == '' || tmemberreceiver_address=='请输入你的收货地址（写字楼,小区,街道或者学校）' ) {
		//$("#addressSpanFont").html("请输入你的收货地址（写字楼,小区,街道或者学校），不超过40个字");
		flag = false;
	} else {
		//$("#addressSpanFont").html("");
	}

	// 手机号码
	var tmemberreceiver_mobile = $.trim($("#tmemberreceiver_mobile").val());
	if (tmemberreceiver_mobile == ''|| tmemberreceiver_mobile == '请输入收货人手机号') {
		//$("#mobileSpanFont").html("请填写收货人手机号码");
		flag = false;
	} else {
		var re = /^[1][3,4,7,5,8][0-9]{9}$/;
		if (!re.test(tmemberreceiver_mobile)) {
			//$("#mobileSpanFont").html("手机号码格式不正确");
			flag = false;
		} else {
			//$("#mobileSpanFont").html("");
		}
	}
	return flag;
}
//保存或是修改收货地址
function saveOrupdateReceiver(formId, divId) {
	if (checkReceiver()) {
		var bischecked=$('#tmemberreceiver_is_default_checkbox').is(':checked');
	     if(bischecked){
	        $('#tmemberreceiver_is_default').val($("#tmemberreceiver_is_default_checkbox").val())
	     }
	     $("#city_name_set").val($("#city-picker3").val());
			var formInfo = $("#" + formId).serialize();
			$.ajax({
				url : "../member/order!ajaxSaveOrUpdateReceiverNew.action",
				type : "post",
				data : formInfo,
				dataType:"json",
				success : function(data) {
					if (data.receiverId != '') { // '1'更新,'2'修改
						$alertCanDisplay("success","保存成功",null,null);
						closeDiv(divId);
						//$("#receiverId").val(data.receiverId);
					    var receiverHtml ="<li id=\"receiver_div_two_"+data.tmemberreceiver.id+"\">";
					    receiverHtml+="<div  onclick =\"xuanzeReceiver("+data.tmemberreceiver.id+",'receiver_div_id')\" class=\"address-box address-current-box\">";
					    receiverHtml+="<span>"+data.tmemberreceiver.receiver+"</span>";
					    receiverHtml+="<span>"+data.tmemberreceiver.mobile+"</span>";
					    receiverHtml+="<p>"+data.tmemberreceiver.area+data.tmemberreceiver.locationAddress+data.tmemberreceiver.address+"</p>";
					    if(data.tmemberreceiver.isDefault==1){
					    	$("#receiver_is_default_b_id").remove();
					    	 receiverHtml+="<b id =\"receiver_is_default_b_id\">默认地址</b>";
					    }
					    receiverHtml+="<div class=\"add-border-top\"></div>";
					    receiverHtml+="<div class=\"add-border-bottom\"></div>";
					    receiverHtml+="<div class=\"select-red-bg\"><img src=\"../web/version2.2.0/images/shopping/order_icon01.png\" alt=\"\"/></div>";
					    receiverHtml+="</div>";
					    receiverHtml+="</li>";
					    if($("#receiver_is_default_b_id").html()){//判断是否有默认地址
					         $(receiverHtml).insertAfter($("#receiver_is_default_b_id").parent().parent());
					    }else{
					         $(receiverHtml).insertBefore($("#receiver_div_id").children().eq(0));
					    }
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
					    xuanzeReceiver(data.tmemberreceiver.id,'receiver_div_id');
					    if(data.receiverSize>2){
					    	$("#gengduo_address_id").show();
					    }
					}else if(data.receiverSize>9){
						$alertCanDisplay("error",data.message,null,null);
					}else{
						$alertCanDisplay("error","操作失败，请稍后再试",null,null);
					}
				},
				error : function() {
					$alertCanDisplay("error","操作失败，请稍后再试",null,null);
				}
			});
	}
}


//清空收获地址校验信息 
function clearReceiverAlert(){
	// 收货人
		//$("#receiverSpanFont").html("");
	// 详细地址
	   //$("#addressSpanFont").html("");
	// 手机号码
	   // $("#mobileSpanFont").html("");
}


//收货人信息 显示
function showReceiver(){
		$("#shade").css({
			display:"block"
		})
		$("#out2").show();
		 clearReceiverAlert(); 
         $("#tmemberreceiver_id").val('');
	     $("#memberReceiver_adcode").val('');
	     $("#tmemberreceiver_longitude").val('');
	     $("#tmemberreceiver_latitude").val('');
	     $("#tmemberreceiver_locationAddress").val('');
	     $("#city_name_set").val('');
	     $("#tmemberreceiver_receiver").val('请输入收货人姓名');
	     $("#tmemberreceiver_address").val('请输入你的收货地址（写字楼,小区,街道或者学校）');
	     $("#tmemberreceiver_mobile").val('请输入收货人手机号');
	     $("#tmemberreceiver_areaId").val('');
	     $("#tmemberreceiver_is_default").val('');
	     $("#city-picker3").val(null).trigger('change');
	     $("#city-picker3_tishi").show();
}

//保存订单
function saveOrder() {
	$("#remark").val($("#remark_test").val());// 订单备注赋值
	var paymentWayId = $("#paymentWayId").val();// 配送方式
	var receiverId = $("#receiverId").val();// 收货地址
	if (receiverId == '') {
		$alertCanDisplay("warn","请选择收货地址!",null,null);
		return;
	}
	if (paymentWayId == '') {
		$alertCanDisplay("warn","请选择支付方式!",null,null);
		return;
	}
	if(!ajaxCheckArea('',receiverId)){
		return;
	}
	$("#tijiaoOrder").attr("onclick", "");
	$("#tijiaoOrder").val("提交中...");
	var formInfo = $("#orderForm").serialize();
	$
			.ajax({
				url : "../member/order!saveOrder.action",
				type : "post",
				data : formInfo,
				success : function(data) {
					if (data.flag) { // '1'更新,'2'修改
						window.location.href="/member/order!orderSumbitSuccess.action?orderId="+data.message;
					} else {
						if (data.message == '1') {
							$alertCanDisplay("warn","请选择收货地址!",null,null);
						} else if (data.message == '2') {
							$alertCanDisplay("warn","请选择支付方式!",null,null);
						} else if (data.message == '3') {
							$alertCanDisplay("warn","购物车没有商品,请选购结算商品!",null,null);
						} else if (data.message == '4') {
							$alertCanDisplay("warn","购物车中存在库存不足商品,请返回购物车修改!",null,null);
						} else if (data.message == '5') {
							$alertCanDisplay("warn","购物车存在已经下架商品!",null,null);
						} else if (data.message == '6') {
							$alertCanDisplay("warn","提交订单失败!",null,null);
						}else if (data.message == '7') {
							$alertCanDisplay("warn","该支付方式不存在!",null,null);
						}else if (data.message == '8') {
							$alertCanDisplay("warn","余额不足请选择其他支付方式!",null,null);
						}else if (data.message == '9') {
							$alertCanDisplay("warn","商品:"+data.messageContent+"为处方药不可在线购买!",null,null);
						}else if (data.message == '10') {
							$alertCanDisplay("warn","商品:"+data.messageContent+"是处方药，目前处方药仅支持北京部分地区以货到付款的方式购买。",null,null);
						}else if (data.message == '11') {
							$alertCanDisplay("warn","请选择配送方式！",null,null);
						}else {
							$alertCanDisplay("warn",data.message,null,null);
						}
						$("#tijiaoOrder").attr("onclick", "saveOrder()");
						$("#tijiaoOrder").val("提交订单");
					}
				},
				error : function() {
					$alertCanDisplay("error","系统异常，请稍后再试",null,null);
					$("#tijiaoOrder").attr("onclick", "saveOrder()");
					$("#tijiaoOrder").val("提交订单");
				}
			});

}

//检查收货地址 层级  
function ajaxCheckArea(areaId,receiverId){
	return true;
}
