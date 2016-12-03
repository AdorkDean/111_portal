<!--------------------------tab切换js start-------------------------->
$(".base-li").click(function(){
	showBase();
	$("#currentForm").val("baseMemberCenterForm");
});
$(".hobby-li").click(function(){
	showHobby();
	$("#currentForm").val("hobbyMemberCenterForm");
});
$(".more-li").click(function(){
	showMore();
	$("#currentForm").val("moreMemberCenterForm");
});

function showBase(){
	$(".base-member-center").show();
	$(".hobby-member-center").hide();
	$(".more-member-center").hide();
}
function showHobby(){
	$(".base-member-center").hide();
	$(".hobby-member-center").show();
	$(".more-member-center").hide();
}
function showMore(){
	$(".base-member-center").hide();
	$(".hobby-member-center").hide();
	$(".more-member-center").show();
}

<!--------------------------tab切换js end---------------------------->

<!--------------------------选择日期js脚本 start--------------------------------->
$(function(){
	var changed = 0;
	if(changed != 1){
		inityear();
	}
});


var byear = 0;
var bmonth = 0;
var bday = 0;
var monthChange = true;
var dayChange = true;
function inityear(){
	var yearbegin = 1920;
  	var now = new Date();
 	var yearend = now.getFullYear(); 
 	var yearcon = "<option value=" + 0+ ">选择年</option>";
 	for (var i = yearend; i >= yearbegin; i--) {
 		if(i == byear){
          	yearcon += ("<option value=" + i + " selected='selected'>" + i + "年</option>");
      	}else{
          	yearcon += ("<option value=" + i + ">" + i + "年</option>");
      	}
	}
	$("#year").html(yearcon);
 	showmonth();
 	
}

function showmonth(){
	$("#year").siblings(".er-tips").hide();
	var year = $("#year").val();
	var month = $("#month").val();
	if(year!=null && year.length>0 && year!=0){
		var monthcon="";
     	for (var i = 1; i <= 12; i++) {
        	if(monthChange && bmonth == i){
            	monthcon += ("<option value=" + i + " selected='selected'>" + i + "月</option>");
            	monthChange = false;
          	}else{
             	monthcon += ("<option value=" + i + ">" + i + "月</option>");
           	}
      	}
   		$("#month").html(monthcon);
  		showday();
	}
}
function showday(){
	var daycon = "";
	var month = $("#month").val();
	if(month != null && month.length>0 && month != 0){
		for(var i=1 ; i<=28 ; i++){
			daycon += ("<option value=" + i + ">" + i + "日</option>");
		}
		if(month == 2){
			var year = $("#year").val();
          	if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0){
            	daycon += ("<option value=" + 29 + ">" + 29 + "日</option>");
         	} 
		}else if(month == 1 || month == 3 || month == 5  || month == 7 || month == 8  || month ==10 || month == 12 ){
			daycon += ("<option value=" + 29 + ">" + 29 + "日</option>");
			daycon += ("<option value=" + 30 + ">" + 30 + "日</option>");
			daycon += ("<option value=" + 31 + ">" + 31 + "日</option>");
		}else{
			daycon += ("<option value=" + 29 + ">" + 29 + "日</option>");
			daycon += ("<option value=" + 30 + ">" + 30 + "日</option>");
		}
		$("#day").html(daycon);
		if(dayChange){
			$("#day option").each(function(){		   					
		   		if($(this).val()==bday){
		   			$(this).attr("selected","selected");	   										
		   		}		   					
		  	});
			dayChange = false;
		}
	}
}

<!--------------------------选择日期js脚本 end--------------------------------->

<!--------------------------选择地址js脚本 start--------------------------------->
function initProvinces(provinceId){
	$.ajax({
		url:'order!ajaxGetFirstAreas.action',
		data:{},
		type:'post',
		success:function(data){
		    if(data.length > 0){
		      var province_html="<option value=\"0\">请选择省</option>";
		      for(var i=0;i<data.length;i++){
		    	  if(provinceId == data[i].id){
		    		  province_html+="<option selected value=\""+data[i].name+"_"+data[i].id+"\">"+data[i].name+"</option>";
		    	  }else{
		    		  province_html+="<option value=\""+data[i].name+"_"+data[i].id+"\">"+data[i].name+"</option>";
		    	  }
		      }
		      $("#province").html(province_html);
		    }
		 }
	});
}



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
		          area_sq_span_id_html+="<option value=\""+data[i].name+"_"+data[i].id+"\">"+data[i].name+"</option>";
		       }
		       $("#area_sq_span_id").html(area_sq_span_id_html+"</select></div>");
		    }
		  }
	   });
     } 
});

function showcity(){
	var provinceid = $("#province").val();
	if(provinceid != null && provinceid != 0){
		provinceid = provinceid.split('_')[1];
		initCity(provinceid,'');
	}
 	/*
	if(provinceid != null && provinceid != 0){
 		provinceid = provinceid.split('_')[1]
    	var url = "order!ajaxGetTwoAreaByAreaId.action?provinceid="+provinceid;
    	
    	$.ajax({
			url:"order!ajaxGetTwoAreaByAreaId.action?areaId="+provinceid,
			data:{"areaId":provinceid},
			type:'post',
			success:function(data){
			    if(data.length > 0){
			    	var html = '<option value="0">请选择城市</option>';
			    	for(var i=0 ; i<data.length ; i++){
			        	var city = data[i];
			       		var con = "<option value='"+city.name+"_"+city.id+"'>"+city.name+"</option>";
			       		html += con;
			    	}
			     	$("#city").html(html);
			    }
			  }
	   });
	}
	*/
}

function initCity(provinceid,cityid){
	if(provinceid != null && provinceid != 0){
    	var url = "order!ajaxGetTwoAreaByAreaId.action?provinceid="+provinceid;
    	
    	$.ajax({
			url:"order!ajaxGetTwoAreaByAreaId.action?areaId="+provinceid,
			data:{"areaId":provinceid},
			type:'post',
			success:function(data){
			    if(data.length > 0){
			    	var html = '<option value="0">请选择城市</option>';
			    	for(var i=0 ; i<data.length ; i++){
			        	var city = data[i];
			        	if(cityid > 0 && cityid == city.id){
			        		var con = "<option selected value='"+city.name+"_"+city.id+"'>"+city.name+"</option>";
			        	}else{
			        		var con = "<option value='"+city.name+"_"+city.id+"'>"+city.name+"</option>";
			        	}
			       		html += con;
			    	}
			     	$("#city").html(html);
			    }
			  }
	   });
	}
}

function showcounty(){
	var cityid = $("#city").val();
	if(cityid != null && cityid != 0){
		cityid = cityid.split('_')[1]
		initcounty(cityid,'');
  	}
}

function initcounty(cityid,countyid){
	if(cityid != null && cityid != 0){
    	var url = "order!ajaxGetTwoAreaByAreaId.action?cityid="+cityid;
    	
    	$.ajax({
			url: "order!ajaxGetTwoAreaByAreaId.action?cityid="+cityid,
			data:{"areaId":cityid},
			type:'post',
			success:function(data){
			    if(data.length > 0){
			    	var html = '<option value="0">请选择区县</option>';
			    	for(var i=0 ; i<data.length ; i++){
			        	var county = data[i];
			        	if(countyid > 0 && countyid == county.id){
			        		var con = "<option selected value='"+county.name+"_"+county.id+"'>"+county.name+"</option>";
			        	}else{
			        		var con = "<option value='"+county.name+"_"+county.id+"'>"+county.name+"</option>";
			        	}
			       		html += con;
			    	}
			     	$("#county").html(html);
			    }
			  }
	   });
  	}
}
<!--------------------------选择地址js脚本 end--------------------------------->

$("#nickName").focus(function(){
	if($.trim( $(this).val() ) == ''){
		$("#tip-validate-nickName").hide();
	}
});
$("#nickName").blur(function(){

	if(!checkCharLen(this)){
		return;
	}
	
	if($.trim( $(this).val() ) == ''){
		$("#tip-validate-nickName").html('请输入昵称');
		$("#tip-validate-nickName").show();
	}
});
$("#realName").focus(function(){
	if($.trim( $(this).val() ) == ''){
		$("#tip-validate-realName").hide();
	}
});
$("#realName").blur(function(){
	if($.trim( $(this).val() ) == ''){
		$("#tip-validate-realName").show();
	}
});

$(".identity").click(function(){
	$("#tip-validate-identity").hide();
});

$(".isCart").click(function(){
	$("#tip-validate-isCart").hide();
});

$(".isMarry").click(function(){
	$("#tip-validate-isMarry").hide();
});

$(".industry").click(function(){
	$("#tip-validate-industry").hide();
});

$(".diploma").click(function(){
	$("#tip-validate-diploma").hide();
});

$("#year").click(function(){
	if($(this).val() != 0){
		$("#tip-validate-birth").hide();
		$("#tip-birth").show();
	}
});

$("#email").focus(function(){
	$("#tip-validate-email").hide();
});

$("#phone").focus(function(){
	$("#tip-validate-phone").hide();
});

$("#personalIncome").change(function(){
	$("#tip-validate-personalIncome").hide();
});
$("#workYear").change(function(){
	$("#tip-validate-workYear").hide();
});

$(".shoppingLike").click(function(){
	$("#tip-validate-shoppingLike").hide();
});
$(".shoppingPreference").click(function(){
	$("#tip-validate-shoppingPreference").hide();
});
$("#billEmail").focus(function(){
	$("#tip-validate-billEmail").hide();
});
function checkEmail(){
	var email = $("#email").val();
//		if(email == null || email ==""){
//			$("#emailErrorInfo").html("请填写邮箱").attr("style","display: inlineblock;");;
//			return false;
//		}
	if(email != undefined && email.length >=1){
		var re = /^[0-9a-z\.\-_]+@([0-9a-z\-_]*\.*)([0-9a-z\-_]+)\.[a-z\.]+$/i;
		if(!re.test(email)){
			$("#tip-validate-email").html("邮箱格式不正确").show();
			$alertCanDisplay("warn","邮箱格式不正确",null,null);
			return false;
		}else{//验证邮箱唯一性
			var validateFlag = false;
			$.ajax({
				url : "../member/memberCenter!validateEmail.action",
				type : "post",
				data : {"email":email},
				dataType:"json",
				async:false,
				success : function(data) {
					if(data.status == 0){//已经存在
						$alertCanDisplay("warn","该邮箱已经存在",null,null);
						$("#email").focus();
						$("#tip-validate-email").html("该邮箱已经存在").show();
						validateFlag = false;
					}else{
						validateFlag = true;
					}
				},
				error : function() {
					$alertCanDisplay("error","操作失败，请稍后再试",null,null);
					return false;
				}
			});
			return validateFlag;
		}
	}else{
		$("#tip-validate-email").html("请填写邮箱").show();
		$alertCanDisplay("warn","请填写邮箱",null,null);
		return false;
	}
	return true;
}

function checkBillEmail(){
	var billEmail = $("#billEmail").val();
	if(billEmail != undefined && billEmail.length >=1){
		var re = /^[0-9a-z\.\-_]+@([0-9a-z\-_]*\.*)([0-9a-z\-_]+)\.[a-z\.]+$/i;
		if(!re.test(billEmail)){
			$("#tip-validate-billEmail").html("账单邮箱格式不正确").show();
			$alertCanDisplay("warn","账单邮箱格式不正确",null,null);
			return false;
		}
	}
	return true;
}
<!--------------------------保存按钮点击 start--------------------------------->
function checkFormData(formId){
	if(formId == 'baseMemberCenterForm'){
		var $nickName = $("#nickName");
		if(!checkCharLen($nickName)){
			$alertCanDisplay("warn","请填写昵称",null,null);
			$nickName.focus();
			return false;
		}
		if($.trim($nickName.val()) == ''){
			$alertCanDisplay("warn","请填写昵称",null,null);
			$nickName.focus();
			$("#tip-validate-nickName").html('请输入昵称');
			$("#tip-validate-nickName").show();
			return false;
		}
		
		var $realName = $("#realName");
		if($.trim($realName.val()) == ''){
			$alertCanDisplay("warn","请填写真实姓名",null,null);
			$realName.focus();
			$("#tip-validate-realName").show();
			return false;
		}
		
		var $sex_radio_class = $(".sex_radio_class:checked");
		if($sex_radio_class.val() == undefined){
			$alertCanDisplay("warn","请选择性别",null,null);
			$("#tip-validate-sex").show();
			return false;
		}
		
		var $year = $("#year");
		if($.trim($year.val()) == '0'){
			$alertCanDisplay("warn","请选择您的生日日期",null,null);
			$year.focus();
			$("#tip-birth").hide();
			$("#tip-validate-birth").show();
			return false;
		}
		
		var $identity = $(".identity:checked");
		if($identity.val() == undefined){
			$alertCanDisplay("warn","请选择身份",null,null);
			$("#tip-validate-identity").show();
			return false;
		}
		
		var $isMarry = $(".isMarry:checked");
		if($isMarry.val() == undefined){
			$alertCanDisplay("warn","请选择婚姻状况",null,null);
			$("#tip-validate-isMarry").show();
			return false;
		}
		
		if($("#personalIncome").val()==undefined || $("#personalIncome").val() == 0){
			$alertCanDisplay("warn","请选择个人收入状况",null,null);
			$("#tip-validate-personalIncome").show();
			return false;
		}
		
		var $isCart = $(".isCart:checked");
		if($isCart.val() == undefined){
			$alertCanDisplay("warn","请选择是否有车",null,null);
			$("#tip-validate-isCart").show();
			return false;
		}
		
		/*
		if(!checkEmail()){
			return false;
		}
		*/
		if(!checkBillEmail()){
			return false;
		}
		
		if(!checkTelephone()){
			return false;
		}
		
		return true;
	}
	
	if(formId == 'hobbyMemberCenterForm'){
		var $shoppingLike = $("input:checkbox[name='tMemberHobby.shoppingLike']:checked");
		if($shoppingLike.size() <= 0){
			$alertCanDisplay("warn","请选择购物喜好",null,null);
			$("#tip-validate-shoppingLike").show();
			return false;
		}
		
		var $shoppingPreference = $("input:checkbox[name='tMemberHobby.shoppingPreference']:checked");
		if($shoppingPreference.size() <= 0){
			$alertCanDisplay("warn","请选择购物类型",null,null);
			$("#tip-validate-shoppingPreference").show();
			return false;
		}
		return true;
	}
	if(formId == 'moreMemberCenterForm'){
		var $industry = $(".industry:checked");
		if($industry.val() == undefined){
			$alertCanDisplay("warn","请选择行业",null,null);
			$("#tip-validate-industry").show();
			return false;
		}
		
		if($("#workYear").val()==undefined || $("#workYear").val() == 0){
			$alertCanDisplay("warn","请选择工作年限",null,null);
			$("#tip-validate-workYear").show();
			return false;
		}
		
		var $diploma = $(".diploma:checked");
		if($diploma.val() == undefined){
			$alertCanDisplay("warn","请选择教育程度",null,null);
			$("#tip-validate-diploma").show();
			return false;
		}
		return true;
	}
	
}

function checkTelephone(){
	if($("#phone").val() == undefined || $("#phone").val() == ""){
		/*
		$alertCanDisplay("warn","请输入电话",null,null);
		$("#phone").focus();
		$("#tip-validate-phone").html("请输入电话").show();
		return false;
		*/
		return true;
	}else{
		var re = /^((\d{3,4})|(\d{3,4}-))?\d{7,8}$/;
		if(!re.test($("#phone").val())){
			$alertCanDisplay("warn","请输入正确的电话号码",null,null);
			$("#phone").focus();
			$("#tip-validate-phone").html("请输入正确的电话号码").show();
			return false;
		}
	}
	return true;
}


function saveMemberCenter(formId){
	
	if(!checkFormData(formId)){
		return;
	}
	showBtnTemp();
	
	var formInfo = $("#" + formId).serialize();
	$.ajax({
		url : "../member/memberCenter!saveMemberCenter.action",
		type : "post",
		data : formInfo,
		dataType:"json",
		success : function(data) {
			if(data.status == 1){
				$alertCanDisplay("success","恭喜你，修改个人资料成功!",null,null);
				location.href= '../member/memberCenter!toEditBaseMemberCenter.action';
			}else{
				showBtn();
			}
			//$alertCanDisplay("success","保存成功",null,null);
		},
		error : function() {
			$alertCanDisplay("error","操作失败，请稍后再试",null,null);
			showBtn();
		}
	});
	
}
<!--------------------------保存按钮点击 end--------------------------------->
function showBtnTemp(){
	$(".btn_div_temp").show();
	$(".btn_div").hide();
}
function showBtn(){
	$(".btn_div").show();
	$(".btn_div_temp").hide();
}

$(".update_mobile").click(function(){
	window.location.href = "/member/memberCenter!toMobileUpdateValidate.action";
});

$(".bind_mobile").click(function(){
	window.location.href = "/member/memberCenter!toMobileBindValidate.action";
});

$(".update_email").click(function(){
	window.location.href = "/member/memberCenter!toEmailUpdateValidate.action";
});

$(".bind_email").click(function(){
	window.location.href = "/member/memberCenter!toEmailBindValidate.action";
});


$(".sex_radio_class").click(function(){
	$("#tip-validate-sex").hide();
});


function checkCharLen(ele){
	$(ele).val($.trim($(ele).val()));
	
	if($.trim($(ele).val()).replace(/[^\x00-\xff]/g, "**").length <= 0 || $.trim($(ele).val()).replace(/[^\x00-\xff]/g, "**").length > 10 ){
		$("#tip-validate-nickName").html('英文长度:10   中文长度:5');
		$("#tip-validate-nickName").show();
		return false;
	}
	return true;
}

$("input").focus(function(){
	$(".input-box").removeClass("border-cur");
	$(this).parents(".input-box").addClass("border-cur");
});
//$(".input-box")

// border-cur
