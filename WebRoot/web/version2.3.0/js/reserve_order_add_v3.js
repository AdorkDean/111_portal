
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
		$("span.placeholder").show( "fast" );
		$("span.title").hide( "fast" );
		$("#consignee_address").val("请输入你的收货地址（写字楼，小区，街道或者学校）");
		$("#consignee_name").val("请输入收货人姓名");
		$("#consignee_mobile").val("请输入收货人手机号");

		$("#consignee_address").attr( { "style":"color:#222; border:1px solid #d7d7d7" } );
		$("#consignee_name").attr( { "style":"color:#222; border:1px solid #d7d7d7" } );
		$("#consignee_mobile").attr( { "style":"color:#222; border:1px solid #d7d7d7" } );

		//$("#address_form_div > input").val("");
	} else if (out_id == 'out3') {
		$("#update_receiverSpanFont").html("");
		$("#update_areaIdSpanFont").html("");
		$("#update_addressSpanFont").html("");
		$("#update_mobileSpanFont").html("");
		$("#update_zipCodeSpanFont").html("");
	}

}

