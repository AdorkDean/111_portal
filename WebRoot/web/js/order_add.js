//验证收货信息
function checkReceiver() {
	var flag = true;
	// 收货人
	var tmemberreceiver_receiver = $.trim($("#tmemberreceiver_receiver").val());
	if (tmemberreceiver_receiver == '') {
		$("#receiverSpanFont").html("收货人不能为空");
		flag = false;
	} else {
		$("#receiverSpanFont").html("");
	}
	// 位置信息
	var memberReceiver_adcode = $.trim($("#memberReceiver_adcode").val());
	var tmemberreceiver_longitude = $.trim($("#tmemberreceiver_longitude").val());
	if($("#tmemberreceiver_areaId").val()==''){
		if (memberReceiver_adcode == ''||tmemberreceiver_longitude=='') {
			$("#weizhixinxi_span").html("请完善位置信息");
			flag = false;
		} else {
			$("#weizhixinxi_span").html("");
		}
	}
	

	// 详细地址
	var tmemberreceiver_address = $.trim($("#tmemberreceiver_address").val());
	if (tmemberreceiver_address == '') {
		$("#addressSpanFont").html("详细地址不能为空");
		flag = false;
	} else {
		$("#addressSpanFont").html("");
	}

	// 手机号码
	var tmemberreceiver_mobile = $.trim($("#tmemberreceiver_mobile").val());
	if (tmemberreceiver_mobile == '') {
		$("#mobileSpanFont").html("手机号码不能为空");
		flag = false;
	} else {
		var re = /^[1][3,4,7,5,8][0-9]{9}$/;
		if (!re.test(tmemberreceiver_mobile)) {
			$("#mobileSpanFont").html("手机号码格式不正确");
			flag = false;
		} else {
			$("#mobileSpanFont").html("");
		}
	}
	// 邮编
	var tmemberreceiver_zipCode = $.trim($("#tmemberreceiver_zipCode").val());
	if (tmemberreceiver_zipCode != '') {
		var re = /^[1-9][0-9]{5}$/;
		if (!re.test(tmemberreceiver_zipCode)) {
			$("#zipCodeSpanFont").html("邮编格式不正确");
			flag = false;
		} else {
			$("#zipCodeSpanFont").html("");
		}
	}
	return flag;
}

// 保存或是修改收货地址
function saveOrupdateReceiver(formId, divId) {
	if (checkReceiver()) {
			var formInfo = $("#" + formId).serialize();
			$.ajax({
				url : "../member/order!ajaxSaveOrUpdateReceiver.action",
				type : "post",
				data : formInfo,
				dataType:"json",
				success : function(data) {
					if (data != '' && data !="max") { // '1'更新,'2'修改
						$alertCanDisplay("success","保存成功",null,null);
						closeDiv(divId);
						selectAllReceiver();
						if($("#tmemberreceiver_id").val()==$("#receiverId").val()){
							jisuanOrderPrice();
							queryPaymentWay();
						}
					}else if(data=="max"){
						$alertCanDisplay("error","收货地址最多可添加10个",null,null);
					} else {
						$alertCanDisplay("error","操作失败，请稍后再试",null,null);
					}
				},
				error : function() {
					$alertCanDisplay("error","操作失败，请稍后再试",null,null);
				}
			});
	}
}
//弹出删除收货地址div
function delReceiverDiv(id){
	$("#shade").css({
        display:"block"
    })
    $("#out4").show();
    $("#delete_receiverid").val(id);
}


// 删除收货地址
function delReceiver() {
	var id =$("#delete_receiverid").val();
		$.ajax({
			url : "../member/order!ajaxDeleteReceiver.action",
			type : "post",
			data : {
				"id" : id
			},
			success : function(data) {
				if (data != '') { // '1'更新,'2'修改
					closeDiv('out4');
					$alertCanDisplay("success","删除成功",null,null);
					if ($("#receiverId").val() == id) {
						$("#receiverId").val("");
					}
					selectAllReceiver();
				} else {
					$alertCanDisplay("error","操作失败，请稍后再试",null,null);
				}
			},
			error : function() {
				$alertCanDisplay("error","操作失败，请稍后再试",null,null);
			}
		});
}
//设置为默认收货地址div
function setDefaultReceiverDiv(id){
	$("#shade").css({
        display:"block"
    })
    $("#out5").show();
    $("#moren_receiverid").val(id);
}

// 设置为默认收货地址
function setDefaultReceiver(id) {
	var id =$("#moren_receiverid").val();
		$.ajax({
			url : "../member/order!ajaxReceiverSetDefault.action",
			type : "post",
			data : {
				"receiverId" : id
			},
			success : function(data) {
				if (data != '') { // '1'更新,'2'修改
					closeDiv('out5');
					$alertCanDisplay("success","设置成功",null,null);
					queryPaymentWay();
				} else {
					$alertCanDisplay("error","操作失败，请稍后再试",null,null);
				}
			},
			error : function() {
				$alertCanDisplay("error","操作失败，请稍后再试",null,null);
			}
		});
}
//清空收获地址校验信息 
function clearReceiverAlert(){
	
	// 收货人
		$("#receiverSpanFont").html("");
	// 位置信息
		$("#weizhixinxi_span").html("");
	// 详细地址
	   $("#addressSpanFont").html("");
	// 手机号码
			$("#mobileSpanFont").html("");
	// 邮编
			$("#zipCodeSpanFont").html("");
}




// 弹出收货地址修改层赋值
function updateReceiverDiv(receiverId) {
	$("#shade").css({
		display : "block"
	})
	$.ajax({
		url : "../member/order!ajaxReceiver.action",
		type : "post",
		data : {
			"receiverId" : receiverId
		},
		success : function(data) {
			clearReceiverAlert();
			 $("#tmemberreceiver_id").val(data.receiver.id);
		     $("#memberReceiver_adcode").val(data.receiver.citycode);
		     $("#tmemberreceiver_longitude").val(data.receiver.longitude);
		     $("#tmemberreceiver_latitude").val(data.receiver.latitude);
		     $("#tmemberreceiver_locationAddress").val(data.receiver.location_address);
		     $("#city_div_id").html("<i></i>"+data.receiver.area);
				if(data.receiver.area.split("-").length>1){
				   $("#city_div_id").html("<i></i>"+data.receiver.area.split("-")[1]);
				}else{
				   $("#city_div_id").html("<i></i>"+data.receiver.area.split("-")[0]);
				}
			$("#tmemberreceiver_areaId").val(data.receiver.area_id);
		     $("#city_name_set").val(data.receiver.area);
		     $("#tmemberreceiver_receiver").val(data.receiver.receiver);
		     $("#tmemberreceiver_address").val(data.receiver.address);
		     $("#tmemberreceiver_mobile").val(data.receiver.mobile);
		     $("#tmemberreceiver_zipCode").val(data.receiver.zip_code);
		     $("#map_search").val(data.receiver.location_address);
		     $("#out2").show();
		},
		error : function() {
			$alertCanDisplay("error","操作失败，请稍后再试",null,null);
		}
	});
}
// 动态刷新收获地址
function selectAllReceiver() {
	$("#receiverULId").html("");
	var receiverId = $("#receiverId").val();
	$.ajax({
				url : "../member/order!ajaxReceiverList.action",
				type : "post",
				success : function(data) {
					if (data.length > 0) {
						var receiverhtml = "";
						for ( var i = 0; i < data.length; i++) {
							receiverhtml += "<li>";
							if (data[i].id == receiverId) {
								$("#set-top-v").val(i);
								receiverhtml += "<div class=\"receiving-address-list clearfix clear receiving-address-curr2\" id=\"receiving-address-list\" >";
							} else {
								receiverhtml += "<div class=\"receiving-address-list clearfix clear \" id=\"receiving-address-list\" >";
							}
							receiverhtml += "<input id=\"receiver_id\" type=\"hidden\" value=\""
									+ data[i].id + "\"/>";
							receiverhtml += "<div class=\"receiving-address-operate\">";
							receiverhtml += "<a href=\"javascript:void(0)\" onClick=\"setDefaultReceiverDiv("
									+ data[i].id + ")\">设为默认收货地址</a>";
							receiverhtml += "<a href=\"javascript:void(0)\" onClick=\"updateReceiverDiv("
									+ data[i].id
									+ ")\" class=\"popup-btn3\">编辑</a>";
							receiverhtml += "<a href=\"javascript:void(0)\" class=\"popup-btn4\" onClick=\"delReceiverDiv("
									+ data[i].id + ")\">删除</a>";
							receiverhtml += "</div>";
							receiverhtml += "<div class=\"receiving-area\"><b></b>";
							receiverhtml += "<span>" + data[i].receiver
									+ "</span>&nbsp;&nbsp;";
							receiverhtml += "<span>" + data[i].areaFirstName
									+ "</span>";
							receiverhtml += "</div>";
							receiverhtml += "<p class=\"receiving-details\">";
							receiverhtml += "<span class=\"area-name\">" + data[i].receiver
									+ "</span>";
							receiverhtml += "<span class=\"area-a\">" + data[i].area + "</span>";
							receiverhtml += "<span class=\"area-long\">" +data[i].location_address+data[i].address
									+ "</span>";
							receiverhtml += "<span class=\"receiver-tel\">"
									+ data[i].mobile + "</span>";
							receiverhtml += "</p>";
							receiverhtml += "</div>";
							receiverhtml += "</li>";
						}
						$("#receiverULId").html(receiverhtml);
					} else {
						$("#receiverULId").html("");
					}
					receiverAllShow();
					// 收货地址鼠标滑动效果
					$('.receiving-address-list').hover(function() {
						$(this).addClass('receiving-address-curr');
					}, function() {
						$(this).removeClass('receiving-address-curr');
					})
					// 点击选择收货地址
					$('.receiving-address-list').click(
							function() {
								if(ajaxCheckArea('',$(this).children().eq(0).val())){
									$(this).addClass('receiving-address-curr2');
									$(this).parents('li').siblings().find(
											'.receiving-address-list').removeClass(
											'receiving-address-curr2');
									$("#receiverId").val($(this).children().eq(0).val());
									$("#set-top-v").val($(this).parents('li').index());
									jisuanOrderPrice();
									queryPaymentWay();
								}
							})
				},
				error : function() {
					$alertCanDisplay("error","操作失败，请稍后再试",null,null);
				}
			});
}

// 选择发票类型
function invoiceSelect(id) {
	$(".invoice-curr").each(function() {
		$(this).attr("class", "");
	});
	$("#invoice-curr" + id).attr("class", "invoice-curr");
	$("#invoiceType_test").val(id);
}

// 取消被选中的支付方式
function cancleClass(uiid) {
	$("#"+uiid).find(".pay-curr").each(function() {
		$(this).attr("class", "");
	});
}

//选择配送方式
function deliverySelect(deliveryId,uiid){
	cancleClass(uiid);
	$("#delivery" + deliveryId).attr("class", "pay-curr");
	$("#deliveryId").val(deliveryId);
	$("#delivery_ul_p").html($("#delivery_instro_"+deliveryId).val());
	jisuanOrderPrice();
}

// 选择支付方式
function selectPayment(paymentId,uiid) {
	cancleClass(uiid);
	$("#payment" + paymentId).attr("class", "pay-curr");
	$("#paymentWayId").val(paymentId);
	deliveryWayList();
	jisuanOrderPrice();
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

// 计算订单金额
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
			$("#goodsPrice").html("商品总金额：¥" + data.goodsPrice.toFixed(2) + "元")
			$("#promotionalDiscount").html(
					"优惠金额：¥-" + data.promotionalDiscount.toFixed(2) + "元")
			$("#couponDiscount").html(
					"优惠券：¥-" + data.couponDiscount.toFixed(2) + "元")
			$("#shippingFee").html("¥" + data.shippingFee.toFixed(2) + "元")
			$("#payableAmount").html("¥" + data.payableAmount.toFixed(2) + "元")
		},
		error : function() {
			$alertCanDisplay("error","操作失败，请稍后再试",null,null);
		}
	});
}

// 关闭div层
function closeDiv(out_id) {
	$("#" + out_id).hide();
	$("#shade").hide();
	if (out_id == 'out1') {// 发票关闭层
		$("#nvoiceType_test").val($("#nvoiceType").val());
	} else if (out_id == 'out2') {
		$("#receiverSpanFont").html("");
		$("#areaIdSpanFont").html("");
		$("#addressSpanFont").html("");
		$("#mobileSpanFont").html("");
		$("#zipCodeSpanFont").html("");
	} else if (out_id == 'out3') {
		$("#update_receiverSpanFont").html("");
		$("#update_areaIdSpanFont").html("");
		$("#update_addressSpanFont").html("");
		$("#update_mobileSpanFont").html("");
		$("#update_zipCodeSpanFont").html("");
	}

}
// 添加发票信息
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
// 展开所有收获地址
function receiverAllShow() {
	var oCorner = $("#receiverAllShow_DivId").find('i');
	if (oCorner.hasClass('off')) {
		$('.more-receiving-address').removeClass('height-auto');
		oCorner.removeClass('off');
	} else {
		$('.more-receiving-address').addClass('height-auto');
		oCorner.addClass('off');
	}
}

// 保存订单
function saveOrder() {
	$("#remark").val($("#remark_test").val());// 订单备注赋值
	var paymentWayId = $("#paymentWayId").val();// 配送方式
	var receiverId = $("#receiverId").val();// 收货地址
	if (receiverId == '') {
		$alertCanDisplay("warn","请选择收货地址!",null,null);
		$("#tijiaoOrder").attr("href", "javascript:saveOrder()");
		$("#tijiaoOrder").html("提交订单");
		return;
	}
	if (paymentWayId == '') {
		$alertCanDisplay("warn","请选择支付方式!",null,null);
		$("#tijiaoOrder").attr("href", "javascript:saveOrder()");
		$("#tijiaoOrder").html("提交订单");
		return;
	}
	if(!ajaxCheckArea('',receiverId)){
		return;
	}
	$("#tijiaoOrder").attr("href", "javascript:void(0)");
	$("#tijiaoOrder").html("提交中...");
	var formInfo = $("#orderForm").serialize();
	$
			.ajax({
				url : "../member/order!saveOrder.action",
				type : "post",
				data : formInfo,
				success : function(data) {
					if (data.flag) { // '1'更新,'2'修改
						$("#orderId").val(data.message);
						$("#orderPayForm").attr("action","../member/order!orderSumbitSuccess.action");
						$("#orderPayForm").submit();
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
						$("#tijiaoOrder")
								.attr("href", "javascript:saveOrder()");
						$("#tijiaoOrder").html("提交订单");
					}
				},
				error : function() {
					$alertCanDisplay("error","系统异常，请稍后再试",null,null);
					$("#tijiaoOrder").attr("href", "javascript:saveOrder()");
					$("#tijiaoOrder").html("提交订单");
				}
			});

}

//根据收货地址  支付方式 查询 配送方式
function deliveryWayList() {
	var paymentWayId =$("#paymentWayId").val();
	var receiverId = $("#receiverId").val();
	$("#deliveryId").val("");
	if (receiverId != '') {
		$
				.ajax({
					url : "../member/order!deliveryWayList.action",
					type : "post",
					data : {
						"receiverId" : receiverId,
						"paymentWayId":paymentWayId
					},
					success : function(data) {
						if (data != '') { // '1'更新,'2'修改
							if (data.length > 0) {
								var paymentHtml = "";
								for ( var i = 0; i < data.length; i++) {
									
									if(data[i].isflag=='1'){
										paymentHtml += "<li><a href=\"javascript:deliverySelect("+data[i].id+",'delivery_ul')\" id=\"delivery"+data[i].id+"\"><b></b>"+data[i].name+"</a>";
									}else{
										paymentHtml += "<li><strong>"+data[i].name+"</strong>";
									}
									paymentHtml += "<input id=\"delivery_instro_"+data[i].id+"\" value=\""+data[i].instro+"\" type=\"hidden\"></li>";
								}
								$("#delivery_ul").html(paymentHtml);
							} else {
								$("#delivery_ul").html("");
							}
						}
					},
					error : function() {
						$alertCanDisplay("error","系统异常，请稍后再试",null,null);
					}
				});
	}
}

// 根据收货地址查询 支付方式
function queryPaymentWay() {
	var receiverId = $("#receiverId").val();
	$("#paymentWayId").val("");
	if (receiverId != '') {
		$
				.ajax({
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
									paymentHtml += "<li><a href=\"javascript:selectPayment("
											+ data[i].id
											+ ",'paymentWayUlId')\" id=\"payment"
											+ data[i].id
											+ "\"><b></b>"
											+ data[i].name
											+ "</a></li>"
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
//优惠券取消
function cardNoQuxiao(){
 $("#couponCardName").val("");
 $("#couponCardName").hide();
 $("#couponCardNo").show();
 $("#couponCardId").val("");
 $("#couponButton").html("<a href=\"javascript:cardNoUser()\">使用</a>")
 jisuanOrderPrice();
}

//检查收货地址 层级  
function ajaxCheckArea(areaId,receiverId){
   //var flag = false;
   //$.ajax({
	//		url : "../location/area!ajaxCheckArea.action",
	//		type : "post",
	//		cache:false,  
    //   		async:false,  
	//		data : {"areaId":areaId,"receiverId":receiverId},
	//		success : function(data) {
	//		    if(data.flag=='true'){
	//		      flag=true;
	//		    }
	//		},
	//		error : function() {
	//		}
	//	});
	//if(!flag){
	//   $alertCanDisplay("warn","收货地址所在地区信息不完整,请完善!",null,null);
	//}
	//return flag;
	
	return true;
}
