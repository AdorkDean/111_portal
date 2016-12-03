/**
 * 提交申请
 */
function subApply(){
	var serviceType=$("select[name='serviceType']").val();
	var goodsNum=$("#goodsNum").val();
	var numTip=$("#_numTip").val();
	var refundDescribe=$("#refundDescribe").val();
	var goodsId=$("#goodsId").val();
	var orderId=$("#orderId").val();
	
	if(serviceType==""){
		$alert("warn", "请选择要退换货的类型", null, null);
//		alert("请选择要退换货的类型");
		return;
	}
	if(serviceType!=null && serviceType!=2 && (goodsNum==""||parseInt(goodsNum)<=0)){
		$alert("warn", "商品数不能为空或小于等于0", null, null);
//		alert("商品数不能为空");
		return;
	}
	if(parseInt(goodsNum)>parseInt(numTip)){
		$alert("warn", "商品数不能大于最大商品数", null, null);
//		alert("商品数不能大于最大商品数");
		return;
	}
	if(refundDescribe==""){
		$alert("warn", "退换货说明不能为空", null, null);
//		alert("退换货说明不能为空");
		return;
	}
	
//	var con = confirm("您确定要提交退换货申请?");
//	if(!con){
//		return false;
//	}
	$("#ttForm").submit();
}


/**
 * 点击<申请退换货>
 * @param orderId 订单ID
 * @param goodsId 商品ID
 * @param num 订单中该商品总数
 */
function applyReturn(orderId,goodsId,num){
	var flag = verifyGoodsReturn(orderId,goodsId);
	
	if(flag){
		//出现弹框
		$("#shade").css({
			display:"block"
		});
		$(".popup-add").show();
		//给出提示个数
		document.getElementById("numTip").innerHTML =num;
		document.getElementById("_numTip").value =num;
		document.getElementById("goodsId").value =goodsId;
		document.getElementById("orderId").value =orderId;
	}else{
		$alert("warn", "该订单项已申请过退换货", null, null);
	}
}

function verifyGoodsReturn(orderId,goodsId){
	var flag = false;
	$.ajax({//setShowGoodsComment
		url: "../goodsReturn/verifyGoodsReturn!verifyGoodsReturn.action",
		type: "POST",
		data: {'orderId':orderId,'goodsId':goodsId} ,
		async:false,
		success: function(data){
			if(data.status==1){//已申请过
				flag = false;
			}else{//未申请过
				flag = true;
			}
		},error:function(data){
			flag = false;
		}
	});
	return flag;
}

$(function(){
	$(document).ready(function(){
//		$("input[type='file']").live('click',function(){
		$("input[type='file']").on('click',function(){
				if(typeof FileReader==='undefined'){ 
				$(this).change(function(){
						loadImgForIE(this);
					})
				}else{ 
					$(this).change(function(){
						readFile(this)
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
			return false; 
		}
		if(file.size>2097152){ 
			alert("文件必须小于等于2M"); 
			$(obj).val("");
			return false; 
		}
		var reader = new FileReader(); 
		reader.readAsDataURL(file); 
		reader.onload = function(e){
			$(obj).siblings("span")[0].innerHTML = '<img src="'+this.result+'" alt="" id=""/>' ;
		} 
	}
	function loadImgForIE(obj){
		var imgPath=$(obj).val();
		$(obj).siblings("span")[0].innerHTML = '<img src="'+this.result+'" alt="" id=""/>' ;
	}
})

////////////////上传图片并显示结束/////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////////////////////////////
$(function(){
	$("#choose-info span").click(function(){
	$(this).addClass('current').siblings().removeClass('current');
	$("#choose-icon b:eq("+$(this).index()+")").addClass('current').siblings().removeClass('current');
	$("#choose-list .list-con:eq("+$(this).index()+")").addClass('current').siblings().removeClass('current');
	})
})

//弹出层
$(function(){
	$("#popup-btn").click(function(){
		$("#shade").css({
			display:"block"
		})
		$(".popup-add").show();
	})
	
	
	$(".close-out").click(function(){
		$("#refundDescribe").val("");
		$("#goodsNum").val("");
		$("#serviceType").val("");
		$("input[typ='file]'").val("");
		$(".fileSpan1").empty();
		$(".fileSpan1").html("上传");
		$("#leaveCount").html("150");
		$("#shade,.popup-add").hide();
	})
	$(".cancle-refund").click(function(){
		
		$("#refundDescribe").val("");
		$("#goodsNum").val("");
		$("#serviceType").val("");
		$("input[typ='file]'").val("");
		$(".fileSpan1").empty();
		$(".fileSpan1").html("上传");
		
		$("#leaveCount").html("150");
		$("#shade,.popup-add").hide();
	});
})

//退款退货
$(function () {
	function tabs(tabTit, on, tabCon) {
		$(tabCon).each(function () {
			$(this).children().eq(0).show();
		});
		$(tabTit).each(function () {
			$(this).children().eq(0).addClass(on);
		});
		$(tabTit).children().click(function () {//鼠标“click”的效果
			$(this).addClass(on).siblings().removeClass(on);
			var index = $(tabTit).children().index(this);
			$(tabCon).children().eq(index).show().siblings().hide();
		});
	}
	tabs("#tab-hd", "active", "#tab-bd");
	tabs("#tab-hd2", "active2", "#tab-bd2");
});


$(function(){
	$("#lll").children("li").eq(0).click(function(){
		$(this).addClass("active2");
		$("#lll").children("li").eq(1).removeClass();
	});
	$("#lll").children("li").eq(1).click(function(){
		$(this).addClass("active2");
		$("#lll").children("li").eq(0).removeClass();
	});
		
});

function validateMaxNum(obj){
	//先把非数字的都替换掉，除了数字
	obj.value = obj.value.replace(/[^\d]/g,"");
	var numQ = $("#itemQ").val();
	if(parseInt(obj.value)>parseInt(numQ)){
		obj.value = numQ;
	}else if(parseInt(obj.value)<=0){
		obj.value = 1;
	}
}

/**
 * textarea文本输入还能输入多少
 */
function checkLen(obj) {
	var maxChars = 150;//最多字符数
	if (obj.value.length > maxChars)
	obj.value = obj.value.substring(0,maxChars);
	var curr = maxChars - obj.value.length;
	document.getElementById("leaveCount").innerHTML = curr.toString();
}

/**
 * 提示剩余还能输入
 */
$(function(){
	var tt = $("#refundDescribe").val();
	if(tt.length!=null && tt.length>150){
		$("#refundDescribe").html(tt.substring(0,150));
	}
	document.getElementById("leaveCount").innerHTML = 150-tt.length;
});

/**
 * 退换货类型改变
 */
function changeTuihuanHuo(){
	var tt = $("#serviceType").val();
	if(undefined != tt && tt!="" && tt==2){//隐藏个数
		$("#goodsNumDiv").attr("style","display:none;");
	}else{
		$("#goodsNumDiv").attr("style","display:block;");
	}
}





////////////////////////////////////////新版退换货样式 start/////////////////////////////////////////
/**
 * 退款
 */
function applyReturn1(orderId,goodsId,num,orderItemId){
	var flag = verifyGoodsReturn(orderId,goodsId);
	if(!flag){
		$alert("warn", "该订单项已申请过退换货", null, null);
	}else{
		window.location.href="../goodsReturn/applyGoodsReturnPage!applyGoodsReturnPage.action?orderItemId="+orderItemId+"&flag=2";
	}
}
/**
 * 退货
 * @param orderId
 * @param goodsId
 * @param num
 */
function applyReturn2(orderId,goodsId,num,orderItemId){
	var flag = verifyGoodsReturn(orderId,goodsId);
	if(!flag){
		$alert("warn", "该订单项已申请过退换货", null, null);
	}else{
		window.location.href="../goodsReturn/applyGoodsReturnPage!applyGoodsReturnPage.action?orderItemId="+orderItemId+"&flag=0";
	}
}

function changeNum(count){
	var serviceType=$("select[name='serviceType']").val();
	if(serviceType=="0"){
		count = parseInt(count);
		var flagNow = parseInt($("#goodsNum").val());
		var max = parseInt($("#itemQ").val());
		if(count==1&&flagNow<max){
			$("#goodsNum").val(flagNow+count);
		}else if(count==1&&flagNow>=max){
			$alert("warn", "最多"+max+"个", null, null);
		}
		if(count==-1 && flagNow<=1){
//		$alert("warn", "最少1个", null, null);
		}else if(count==-1 && flagNow>1){
			$("#goodsNum").val(flagNow+count);
		}
	}
}
/**
 * 
 */
function changeType(obj){
//	var changeType = $("#changeType").value;
	var max = parseInt($("#itemQ").val());
	var returnType =obj.value; 
	if(returnType=='0'){
		$("#tuihuan").attr("style","display:block;");
		$("#jintui").attr("style","display:none;");
		$("#goodsNum").attr("disabled",false);
	}else if(returnType=='2'){//仅退款
		$("#tuihuan").attr("style","display:none;");
		$("#jintui").attr("style","display:block;");
		$("#goodsNum").attr("disabled",true);
		$("#goodsNum").val(max);
	}
}


function submitApply(){
	var serviceType=$("select[name='serviceType']").val();
	var goodsNum=$("#goodsNum").val();
	var numTip=$("#_numTip").val();
	var refundDescribe=$("#refundDescribe").val();
	var goodsId=$("#goodsId").val();
	var orderId=$("#orderId").val();
	
	if(serviceType==""){
		$alert("warn", "请选择要退换货的类型", null, null);
//		alert("请选择要退换货的类型");
		return;
	}
	if(serviceType!=null && serviceType!=2 && (goodsNum==""||parseInt(goodsNum)<=0)){
		$alert("warn", "商品数不能为空或小于等于0", null, null);
//		alert("商品数不能为空");
		return;
	}
	if(parseInt(goodsNum)>parseInt(numTip)){
		$alert("warn", "商品数不能大于最大商品数", null, null);
//		alert("商品数不能大于最大商品数");
		return;
	}
	if(refundDescribe==""){
		$alert("warn", "退换货说明不能为空", null, null);
//		alert("退换货说明不能为空");
		return;
	}
	var _flag = verifyGoodsReturn(orderId,goodsId);
	if(_flag){
		//alert(_flag);
		$("#ttForm").submit();
	}else{
		$alert("warn", "该商品已经申请过退换货", null, null);
	}
}

$(function(){
	var serviceType=$("select[name='serviceType']").val();
	var max = parseInt($("#itemQ").val());
	if(serviceType=='0'){
		$("#tuihuan").attr("style","display:block;");
		$("#jintui").attr("style","display:none;");
		$("#goodsNum").attr("disabled",false);
	}else if(serviceType=='2'){//仅退款
		$("#tuihuan").attr("style","display:none;");
		$("#jintui").attr("style","display:block;");
		$("#goodsNum").attr("disabled",true);
		$("#goodsNum").val(max);
	}
});

////////////////////////////////////////新版退换货样式 end/////////////////////////////////////////