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
					    $("#haveAddressFlag").val("1");//存在收货地址
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
			url : "../member/reserveOrder!ajaxDeleteReceiver.action",
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
			url : "../member/reserveOrder!ajaxReceiverSetDefault.action",
			type : "post",
			data : {
				"receiverId" : id
			},
			success : function(data) {
				if (data != '') { // '1'更新,'2'修改
					closeDiv('out5');
					$alertCanDisplay("success","设置成功",null,null);
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
		//$("#receiverSpanFont").html("");
	// 位置信息
		//$("#weizhixinxi_span").html("");
	// 详细地址
	   //$("#addressSpanFont").html("");
	// 手机号码
			//$("#mobileSpanFont").html("");
	// 邮编
			//$("#zipCodeSpanFont").html("");
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
				$("#haveAddressFlag").val("1");//存在收货地址
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
					
					var location_address = "";
					if(data){
						
					}
					
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
				$("#haveAddressFlag").val("0");//不存在收货地址
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
							//jisuanOrderPrice();
							calculatePrice();
						}
					})
		},
		error : function() {
			$alertCanDisplay("error","操作失败，请稍后再试",null,null);
		}
	});
}





// 计算预订单金额
function jisuanOrderPrice() {
	var receiverId = $("#receiverId").val();// 收货地址id
	$.ajax({
		url : "../member/order!computeOrderPrice.action",
		type : "post",
		data : {
			"couponCardId" : couponCardId,
			"paymentWayId" : paymentWayId,
			"receiverId" : receiverId,
			"shortOrderId" : shortOrderId,
			"deliveryId" : deliveryId
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
		$("#city-picker3").val("");
	} else if (out_id == 'out3') {
		$("#update_receiverSpanFont").html("");
		$("#update_areaIdSpanFont").html("");
		$("#update_addressSpanFont").html("");
		$("#update_mobileSpanFont").html("");
		$("#update_zipCodeSpanFont").html("");
	}

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

//保存预订单
function saveReserveOrder() {
	$("#replyMobileTempMsg").html("");
	
	$("#replyMobile").val($("#replyMobileTemp").val());// 回拨电话
	$("#remark").val($("#remarkTemp").val());// 备注
	
	var $haveAddressFlag = $("#haveAddressFlag").val();
	if($haveAddressFlag != 1){
		$alertCanDisplay("warn","请新增收货地址!",null,null);
		$("#tijiaoOrder").attr("href", "javascript:saveReserveOrder()");
		$("#tijiaoOrder").html("提交预定");
		return;
	}
	
	var receiverId = $("#receiverId").val();// 收货地址
	if (receiverId == '') {
		$alertCanDisplay("warn","请选择收货地址!",null,null);
		$("#tijiaoOrder").attr("href", "javascript:saveReserveOrder()");
		$("#tijiaoOrder").html("提交预定");
		return;
	}
	if(!ajaxCheckArea('',receiverId)){
		return;
	}
	
	// 手机号码
	var reply_mobile = $.trim($("#replyMobile").val());
	if (reply_mobile == '') {
		$("#replyMobileTempMsg").html("请填写回拨电话!");
		$alertCanDisplay("warn","请填写回拨电话!",null,null);
		$("#replyMobileTemp").focus();
		return;
	} else {
		var re = /^[1][3,4,7,5,8][0-9]{9}$/;
		if (!re.test(reply_mobile)) {
			$("#replyMobileTempMsg").html("请输入11位有效回拨电话!");
			$alertCanDisplay("warn","请输入11位有效回拨电话!",null,null);
			$("#replyMobileTemp").focus();
			return;
		} else {
			$("#replyMobileTempMsg").html("");
		}
	}
	
	$("#tijiaoOrder").attr("href", "javascript:void(0)");
	$("#tijiaoOrder").html("提交中...");
	$("#tijiaoOrder").css("text-decoration","none");
	var formInfo = $("#reserveOrderForm").serialize();
	$
			.ajax({
				url : "../member/reserveOrder!saveReserveOrder.action",
				type : "post",
				data : formInfo,
				success : function(data) {
					if (data.flag) { // '1'更新,'2'修改
						$("#reserveOrderId").val(data.rxTReserveOrderId);
						$("#orderAmount").val(data.orderAmount);
						$("#reserveOrderPayForm").attr("action","../member/reserveOrder!reserveOrderAddSuccess.action");
						$("#reserveOrderPayForm").submit();
						return;
					} else {
						if (data.message == '1') {
							$alertCanDisplay("warn","请选择收货地址!",null,null);
						} else if (data.message == '2') {
							$("#replyMobileTempMsg").html("请填写回拨电话!");
							$alertCanDisplay("warn","请填写回拨电话!",null,null);
							$("#replyMobileTemp").focus();
						} else if (data.message == '21') {
							$("#replyMobileTempMsg").html("请输入11位有效回拨电话!");
							$alertCanDisplay("warn","请输入11位有效回拨电话!",null,null);
							$("#replyMobileTemp").focus();
						} else if (data.message == '3') {
							$alertCanDisplay("warn","请输入商品数量!",null,null);
						} else if (data.message == '4') {
							$alertCanDisplay("warn","请选择商品!",null,null);
						} else if (data.message == '5') {
							$alertCanDisplay("warn","商品不存在!",null,null);
						} else if (data.message == '6') {
							$alertCanDisplay("warn","该商品库存不足!",null,null);
						}else if (data.message == '7') {
							$alertCanDisplay("warn","保存预订单失败!",null,null);
						}else if (data.message == '8') {
							$alertCanDisplay("warn","该商品库存不足!",null,null);
						}else if (data.message == '9') {
							$alertCanDisplay("warn","商品不存在!",null,null);
						}else if (data.message == '10') {
							$alertCanDisplay("warn","该商品已下架!",null,null);
						}
						
						$("#tijiaoOrder")
								.attr("href", "javascript:saveReserveOrder()");
						$("#tijiaoOrder").html("提交预定");
					}
				},
				error : function() {
					$alertCanDisplay("error","系统异常，请稍后再试",null,null);
					$("#tijiaoOrder").attr("href", "javascript:saveReserveOrder()");
					$("#tijiaoOrder").html("提交预定");
				}
			});

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




///////////////////////////////////////////////////////////////////////////////////////////////////////////////


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




$(document).ready(function() {
		
		calculatePrice();
	
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
		//outs("#popup-btn2","#out2","#shade");
		
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
			//jisuanOrderPrice();
			calculatePrice();
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
		
		/*
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
		*/
		
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
				url:'order!ajaxGetAreaByCity.action',
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
				url:'order!ajaxGetTwoAreaByAreaId.action',
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
   //筛选城市
  function searchCity(){
      var search_input_id=$("#search_input_id").val();
      if($.trim(search_input_id)==''){
         $("#search_input_id").siblings('ul').hide();
      }else{
        $.ajax({
			url:'order!searchCity.action',
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
 
 
 
 
 
 /**
 * 图片上传显示效果
 */
 
/*
$(function(){
	$(document).ready(function(){
		$("input[type=file]").live('click',function(){
				
				if(typeof FileReader==='undefined'){ 
					$(this).change(function(){
						loadImgForIE(this);
					})
				}else{ 
					$(this).change(function(){
						//alert(7);
						readFile(this);
					})
				} 
		})
	});
	function readFile(obj){
		var file = obj.files[0]; 
		if(typeof(file) == "undefined"){
			return false;
		}
		if(!/image\/jpeg/.test(file.type)){ 
			alert("文件必须为JPG图片！"); 
			$(obj).val("");
			$(obj).siblings("span").html("点此上传");
			return false; 
		}
		if(file.size>2097152){ 
			alert("文件必须小于等于2M"); 
			$(obj).val("");
			$(obj).siblings("span").html("点此上传");
			return false; 
		}
		var reader = new FileReader(); 
		reader.readAsDataURL(file); 
		reader.onload = function(e){
			$(obj).siblings("span")[0].innerHTML = '<img style="width:108px;height:78px;" src="'+this.result+'" alt="" id=""/>' ;
		} 
	}
	function loadImgForIE(obj){
		var imgPath=$(obj).val();
		$(obj).siblings("span")[0].innerHTML = '<img src="'+this.result+'" alt="" id=""/>' ;
	}
})


$(function(){
    $(".img-close").click(function(){
    	$(this).siblings("input[type='file']").val("");
    	$(this).siblings("span").children("img").remove();
    	$(this).siblings("span").html("点此上传");
    });
})
*/

var maxsize = 5*1024*1024;//2M  
var errMsg = "上传的附件文件不能超过5M！！！";  
var tipMsg = "您的浏览器暂不支持计算上传文件的大小，确保上传文件不要超过5M，建议使用IE、FireFox、Chrome浏览器。";  
var  browserCfg = {};  
var ua = window.navigator.userAgent;  
if (ua.indexOf("MSIE")>=1){  
    browserCfg.ie = true;  
}else if(ua.indexOf("Firefox")>=1){  
    browserCfg.firefox = true;  
}else if(ua.indexOf("Chrome")>=1){  
    browserCfg.chrome = true;  
}  
function checkfile(){  
    try{  
        var obj_file = document.getElementById("reserveImg");  
        if(obj_file.value==""){  
        	$alertCanDisplay("warn","请先选择上传文件",null,null); 
            return false;  
        }  
        var filesize = 0;  
        if(browserCfg.firefox || browserCfg.chrome ){  
            filesize = obj_file.files[0].size;  
        }else if(browserCfg.ie){  
            var obj_img = document.getElementById('reserveImg');  
            obj_img.dynsrc=obj_file.value;  
            filesize = obj_img.fileSize;  
        }else{  
            $alertCanDisplay("warn",tipMsg,null,null);  
            return false;  
        }  
        if(filesize==-1){  
        	$alertCanDisplay("warn",errMsg,null,null);    
            return false;  
        }else if(filesize>maxsize){  
        	$alertCanDisplay("warn",errMsg,null,null);  
            return false;  
        }else{  
            return true;  
        }  
        return true;  
    }catch(e){  
        alert(e);  
    }  
}  

function ajaxFileUpload() {
		if(!checkfile()){
			$("#reserveImg").val('');
			return;
		}
		
	    $.ajaxFileUpload
	    (
	        {
	            url: "reserveOrder!uploadImg.action", //用于文件上传的服务器端请求地址
	            secureuri: false, //是否需要安全协议，一般设置为false
	            fileElementId: 'reserveImg', //文件上传域的ID
	            dataType: 'json', //返回值类型 一般设置为json
	            success: function (data, status)  //服务器成功响应处理函数
	            {
	            		if(data.flag == 1){//文件上传成功
	            			$(".reserve_img").html("<img src='"+data.imgUrl+"'>");
	            			$alertCanDisplay("success",data.msg,null,null);
	            			$("#rxImgUrl").val(data.imgUrl);
	            		}else{
	            			$alert("error",data.msg,null,null);
	            		}
	            		/*
	            		alert(data.flag);
	            		alert(data.msg);
	            		alert(data.imgUrl);
	            		alert(data.fileType);
	            		*/
	            		/*
	            		$("#fileTip").html(data.msg);
	            		$("#filePath").html(data.imgUrl);
	            		$("#fileType").html(data.fileType)
	            		*/
	            },
	            error: function (data, status, e)//服务器响应失败处理函数
	            {
	                alert(e);
	            }
	        }
	    )
	    return false;
	}
	
	function removeImg(){
		$(".reserve_img").html("点此上传");
		$("#rxImgUrl").val('');
	}
	
	
	//计算商品价格及运费
	function addProduct(receiverId,goodsId,goodsCnt){
		$.ajax({
			url:'reserveOrder!addProduct.action',
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
	
	var count_minus_plus_clickFlag = true;//用于控制点击是否可用 true:可点击 false:不可点击
	function updateCount(elementId,operator){
		if(count_minus_plus_clickFlag == false){
			return;
		}
		
		count_minus_plus_clickFlag = false;//关门
		
		var count = elementId.siblings(".count-text").val();
		var countBack = count;
		
		count = parseInt(count);
		if(count <= 1 && operator == 'sub'){
			count_minus_plus_clickFlag = true;
			return;
		}
		
		if(count >= 99 && operator == 'add'){
			count_minus_plus_clickFlag = true;
			$alertCanDisplay("warn","您所需要的数量过大,请拨打客服电话进行订购!",null,null);
			return;
		}
		
		if(operator == 'add'){
			count += 1;
			elementId.siblings(".count-text").val(count);
		}else if(operator == 'sub'){
			count -= 1;
			elementId.siblings(".count-text").val(count);
		}
		
		//ajax获取商品价格，小计，运费（参数 商品id,商品数量,receiverId）
		var goodsId = $("#goodsId").val();
		var goodsNum = elementId.siblings(".count-text").val();
		var receiverId = $("#receiverId").val();
		
		$.ajax({
			url:'reserveOrder!calculatePrice.action',
			data:{"goodsId":goodsId,"goodsNum":goodsNum,"receiverId":receiverId},
			type:'post',
			dataType: 'json',
			success:function(data){
				/*
				alert("运费:"+data.freight);
				alert("预订单总金额:"+data.totalAmount);
				alert("商品单价:"+data.pcPrice);
				alert("state:"+data.state);
				*/
				if(data.state == 1){
					$(".pc_price").html(data.pcPrice.toFixed(2));
					$(".goods_total").html(data.goodsTotal);
					$(".total_amount").html(data.totalAmount);
					$(".freight").html(data.freight);
					$("#goodsNum").val(count);
					count_minus_plus_clickFlag = true;
					return;
				}else if(data.state == 2){//库存不足
					elementId.siblings(".count-text").val(data.stock);
					$alertCanDisplay("warn","商品库存不足!",null,null);
					count_minus_plus_clickFlag = true;
					return;
				}else{
					$alertCanDisplay("warn",data.msg,null,null);
					count_minus_plus_clickFlag = true;
					return;
				}
			},
			error:function(){
				//alert("error");
				count_minus_plus_clickFlag = true;
			}
		});
		
	}
	
	function calculatePrice(){
		$.ajax({
			url:'reserveOrder!calculatePrice.action',
			data:{"goodsId":$("#goodsId").val(),"goodsNum":$("#goodsNum").val(),"receiverId":$("#receiverId").val()},
			type:'post',
			dataType: 'json',
			success:function(data){
				if(data.state == 1){
					$(".pc_price").html(data.pcPrice.toFixed(2));
					$(".goods_total").html(data.goodsTotal);
					$(".total_amount").html(data.totalAmount);
					$(".freight").html(data.freight);
					return;
				}else if(data.state == 2){//库存不足
					//elementId.siblings(".count-text").val(count);
					$alertCanDisplay("warn","商品库存不足!",null,null);
					return;
				}else if(data.state == 3){//商品不存在
					$alertCanDisplay("warn","商品不存在!",null,null);
					return;
				}else if(data.state == 4){//商品不存在
					$alertCanDisplay("warn","商品不存在!",null,null);
					return;
				}else if(data.state == 5){//商品数量为空
					$alertCanDisplay("warn","请填写药品数量!",null,null);
					return;
				}else{
					$alertCanDisplay("warn",data.msg,null,null);
					return;
				}
			},
			error:function(){
				$alertCanDisplay("warn","网络异常!",null,null);
			}
		});
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
			//jisuanOrderPrice();
			calculatePrice();
		}else{
			$("#"+uiid).find("li").each(function() {
				if($(this).children().hasClass('address-current-box')){
					$(this).children().removeClass('address-current-box');
				}
			});
			$("#receiver_div_two_"+receiverId).children().addClass('address-current-box');
		}
	}
	
	
	
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
	
	var receiverIdVal = $("#receiverId").val();
	if(receiverIdVal != null && receiverIdVal != ''){
		xuanzeReceiver(receiverIdVal,'receiver_div_id')
	}