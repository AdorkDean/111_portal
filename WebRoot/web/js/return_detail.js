$(function(){
	$("input[name='expressCompany']").focus(function(){
		document.getElementById("expressCompanyTip").innerHTML ="";
	});
	$("input[name='expressDelivery']").focus(function(){
		document.getElementById("expressDeliveryTip").innerHTML ="";
	});
 
	$("#subLogisticsInfo").click(function() {
		var expressCompany = $("input[name='expressCompany']").val();
		var expressDelivery = $("input[name='expressDelivery']").val();
		var singleId = $("#singleId").val();
		if (singleId == "") {
			alert("请选择正确的有效数据!");
			return false;
		}
		if (expressCompany == "") {
			document.getElementById("expressCompanyTip").innerHTML = "物流公司不能为空! ";
			return;
		}
		if (expressDelivery == "") {
			document.getElementById("expressDeliveryTip").innerHTML = "快递单号不能为空!";
			return;
		}
		$.ajax({// setShowGoodsComment
			url : "../member/return!addLogisticsInfo.action",
			type : "POST",
			data : {
				'id' : singleId,
				'expressCompany' : expressCompany,
				'expressDelivery' : expressDelivery
			},
			async:false,
			success : function(data) {
				if (data.status == 1) {
					$("#shade,.popup-add").hide();
					$alert("success", data.message, null, null);
					$("#addLogisticsInfo").innerHTML ="<h4 class=\"mt20\"><b class=\"warning\"></b>您已填写物流信息,请等待审核通过</h4>";
					window.location.reload(true);
				} else {
					$("#shade,.popup-add").hide();
					$alert("warn", data.message, null, null);
					window.location.reload(true);
				}
			},
			error : function(data) {
				$alert("warn", "内部错误,请稍后重试!");
				window.location.reload(true);
			}
		});
	});
});

// 弹出层
$(function() {
	$("#popup-btn").click(function() {
		$("#shade").css({
			display : "block"
		})
		$(".popup-add").show();
	})
	$(".close-out").click(function() {
		$("#shade,.popup-add").hide();
	});
	$(".cancle-refund").click(function() {
		$("#shade,.popup-add").hide();
	});
});
/**
 * 弹出层
 * 
 * @param id
 */
function addLogisticsInfo(id) {// expressCompany,expressDelivery
	$("#shade").css({
		display : "block"
	});
	$(".popup-add").show();
	$("#singleId").val(id);
}

// 退款退货
$(function() {
	function tabs(tabTit, on, tabCon) {
		$(tabCon).each(function() {
			$(this).children().eq(0).show();
		});
		$(tabTit).each(function() {
			$(this).children().eq(0).addClass(on);
		});
		$(tabTit).children().click(function() {// 鼠标“click”的效果
			$(this).addClass(on).siblings().removeClass(on);
			var index = $(tabTit).children().index(this);
			$(tabCon).children().eq(index).show().siblings().hide();
		});
	}
	tabs("#tab-hd", "active", "#tab-bd");
	tabs("#tab-hd2", "active2", "#tab-bd2");
	tabs("#tab-hd3", "active2", "#tab-bd3");
	tabs("#tab-hd4", "active2", "#tab-bd4");
});
