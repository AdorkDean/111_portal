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
    <title>会员中心</title>
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
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/member.css">
    <link href="${base}/web/version2.2.0/css/bootstrap.css" rel="stylesheet">
    <link href="${base}/web/version2.2.0/css/city-picker.css" rel="stylesheet">
    <link href="${base}/web/version2.2.0/css/main.css" rel="stylesheet">
     <script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
	<script src="${base}/web/version2.2.0/js/bootstrap.js"></script>
	<script src="${base}/web/version2.2.0/js/city-picker.data.js"></script>
	<script src="${base}/web/version2.2.0/js/city-picker.js"></script>
	<script src="${base}/web/version2.2.0/js/main.js"></script>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<!-- line开始-->
<div class="member-line"></div>
<!-- line结束-->
<!--内容开始-->
<div class="member-content w1090">
    <!--左侧导航开始-->
   <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
    <!--左侧导航结束-->
    <!-- 右侧内容开始-->
    <div class="member-main-right">
        <div class="m-site order-site"><a href="/member/index!getCenterIndex.action">用户中心</a>　>　<span>收货地址</span></div>
        <!-- 新增收货地址开始-->
        <div class="address-info"><span>新增收货地址</span></div>
        <form id="receiverForm" name="receiverForm" action="">
        <input type="hidden" name="tmemberreceiver.id" id="tmemberreceiver_id"  value=""/>
        <input type="hidden" name="tmemberreceiver_areaId" id="tmemberreceiver_areaId"  value=""/>
        <input type="hidden" name="tmemberreceiver.locationAddress" id="tmemberreceiver_locationAddress"  value=""/>
        <input type="hidden" name="tmemberreceiver_is_default" id="tmemberreceiver_is_default"  value=""/>
         <input type="hidden" name="tmemberreceiver.longitude" id="tmemberreceiver_longitude"  value=""/>
        <input type="hidden" name="city_name_set" id="city_name_set"  value=""/>
        <input type="hidden" name="tmemberreceiver.latitude" id="tmemberreceiver_latitude"  value=""/>
        <div class="address-edit">
            <dl class="address-edit-dl">
                <dt><span>*</span>位置：</dt>
                <dd style="position: relative;">
                    <div id="distpicker">
                        <div class="form-group" style="margin-bottom:0;">
                            <div style="position: relative;">
                                <input id="city-picker3" class="form-control" readonly type="text" value="" data-toggle="city-picker" style="padding-left: 5px; outline: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); border: 1px solid #d7d7d7; background-color: #fff;color: #ccc; width: 405px; ">
                            </div>
                        </div>
                    </div>
                    <b id="area_tishi_b_id" style="position: absolute;top: 8px;left: 412px;display: block;width: 300px;">请填写完整的位置信息</b>
                </dd>
            </dl>
            <dl class="address-edit-dl">
                <dt><span>*</span>详细地址：</dt>
                <dd>
                    <input type="text" onblur="checkReceiver()" name="tmemberreceiver.address" style="width:356px;" value="" id="tmemberreceiver_address" maxlength="40" />
                    <b  id="address_tishi_b_id">请填写收货人详细地址，不超过40个字</b>
                </dd>
            </dl>
            <dl class="address-edit-dl">
                <dt><span>*</span>收货人姓名：</dt>
                <dd>
                    <input type="text" value="" onblur="checkReceiver()" name="tmemberreceiver.receiver" id="tmemberreceiver_receiver" maxlength="10" />
                    <b  id="receiver_tishi_b_id">请填写收货人姓名，不超过10个字</b>
                </dd>
            </dl>
            <dl class="address-edit-dl">
                <dt><span>*</span>手机号码：</dt>
                <dd>
                    <input type="text" onblur="checkReceiver()" name="tmemberreceiver.mobile" value="" id="tmemberreceiver_mobile" maxlength="11" />
                    <b  id="mobile_tishi_b_id">请输入11位正确手机号码</b>
                </dd>
            </dl>
           <div class="address-checkbox">
               <input type="checkbox" value="1" id="tmemberreceiver_is_default_checkbox"/> 设为默认收货地址
           </div>
            <div class="address-button">
                <input type="button" value="保 存" onclick="saveReceiver()"/>
            </div>
        </div>
        </form>
        <!-- 新增收货地址结束-->
        <!-- 现有收货地址开始-->
        <div class="address-info"><span>现有收货地址</span></div>
        <!-- 收货人开始-->
        <div class="address-wrap">
            <ul class="address-total">
            <#list receiverLatLonList as receiver>
                <li class="<#if receiver_index?if_exists ==3||receiver_index?if_exists ==7 ||receiver_index?if_exists ==11>address-no-margin</#if>">
                    <div class="address-box <#if receiver.isDefault?if_exists ==1>address-current-box2</#if> ">
                        <span>${receiver.receiver?default('')}</span>
                        <span>${receiver.mobile?default('')}</span>
                        <p>${receiver.area?default('')}${receiver.locationAddress?default('')}${receiver.address?default('')}</p>
                        <#if receiver.isDefault?if_exists ==1><b>默认地址</b>
                        <#else>
                           <em onclick="receiverSetDefault(${receiver.id?default('')})">设为默认</em>
                        </#if>
                        <strong class="amend-btn" onclick="javascript:ajaxReceiver(${receiver.id?default('')})"></strong>
                        <strong class="delete-btn popup-btn5" onclick="showDeleteReceiver(${receiver.id?default('')})"></strong>
                        <div class="add-border-top"></div>
                        <div class="add-border-bottom"></div>
                        <div class="select-red-bg"><img src="${base}/web/version2.2.0/images/shopping/order_icon01.png" alt=""/></div>
                    </div>
                </li>
            </#list> 
            </ul>
        </div>
        <!--收货人结束-->



        <!-- 现有收货地址结束-->
    </div>
    <!-- 右侧内容结束-->
</div>
<!--内容结束-->
<div id="shade">
    <!--删除地址提示信息开始-->
    <div class="out450 out-box450" id="out5" >
        <h4 class="out-title">
            <a href="javascript:closeDeleteReceiver()" class="close-out"></a>
            删除地址
        </h4>
        <div class="out-info clearfix clear">
            <p class="out-text">您确定要删除该地址吗？</p>
            <div class="out-button">
                <a href="javascript:deleteReceiver()" class="bg-color">确定</a>
                <a href="javascript:closeDeleteReceiver()" >再考虑一下</a>
            </div>
        </div>
    </div>
    <!--删除地址提示信息结束-->
</div>
<!--js-->

<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css"/>
<script>
// 获得选中地址的areaId
function getAreaId(areaId){
   $("#tmemberreceiver_areaId").val(areaId);
}
//根据选择判断 位置内容
function checkArea(areaVal){
   $("#city-picker3").val(areaVal);
   if(areaVal!=null&&areaVal!=''){
      if(areaVal.split("-").length>2){
	     $("#area_tishi_b_id").hide();
	   }else{
	     $("#area_tishi_b_id").show();
	   }
   }else{
        $("#area_tishi_b_id").show();
   }
}


$('.address-box').hover(function(){
	$(this).addClass('address-current-box');
},function(){
	$(this).removeClass('address-current-box');
})
//设置为默认
function receiverSetDefault(receiverId){
   $.ajax({
			url:'${base}/member/receiver!ajaxReceiverSetDefault.action',
			data:{"receiverId":receiverId},
			type:'post',
			success:function(data){
			    if(data==1){
			       $alertCanDisplay("success","操作成功!",null,null);
			       window.location.href="${base}/member/receiver.action";
			    }else{
			       $alertCanDisplay("error","系统异常，请稍后再试",null,null);
			    }
			  },
			error : function() {
				$alertCanDisplay("error","系统异常，请稍后再试",null,null);
			}
		   });
}
//显示删除提示层
var deleteReceiverId ;
function showDeleteReceiver(receiverId){
        deleteReceiverId =receiverId;
        $("#shade").css({
			display:"block"
		})
		$("#out5").show();
}

//关闭删除提示层
function closeDeleteReceiver(){
   $("#shade").hide();
	$("#out5").hide();
	deleteReceiverId="";
}
//删除收货人地址
function deleteReceiver(){
  $.ajax({
	url:'${base}/member/receiver!ajaxDeleteReceiver.action',
	data:{"receiverId":deleteReceiverId},
	type:'post',
	success:function(data){
	    if(data==1){
	       $alertCanDisplay("success","操作成功!",null,null);
	       window.location.href="${base}/member/receiver.action";
	    }else{
	       $alertCanDisplay("error","系统异常，请稍后再试",null,null);
	    }
	  },
	error : function() {
		$alertCanDisplay("error","系统异常，请稍后再试",null,null);
	}
   });

}

//检查收货地址信息
function checkReceiver(){
      var checkFlag = true;
     var areaVal=$("#city-picker3").val();
   if(areaVal!=null&&areaVal!=''){
      if(areaVal.split("-").length>2){
	     $("#area_tishi_b_id").hide();
	   }else{
	     checkFlag = false;
	     $("#area_tishi_b_id").show();
	   }
   }else{
        checkFlag = false;
        $("#area_tishi_b_id").show();
   }
// 详细地址
	var tmemberreceiver_address = $.trim($("#tmemberreceiver_address").val());
	if (tmemberreceiver_address == '') {
		$("#address_tishi_b_id").show();
		checkFlag = false;
	}else{
	    $("#address_tishi_b_id").hide();
	} 

    // 收货人
	var tmemberreceiver_receiver = $.trim($("#tmemberreceiver_receiver").val());
	if (tmemberreceiver_receiver == '') {
		$("#receiver_tishi_b_id").show();
		checkFlag = false;
	} else {
		$("#receiver_tishi_b_id").hide();
	}


   // 手机号码
	var tmemberreceiver_mobile = $.trim($("#tmemberreceiver_mobile").val());
	if (tmemberreceiver_mobile == '') {
	    $("#mobile_tishi_b_id").html("请输入11位正确手机号码");
	    $("#mobile_tishi_b_id").show();
		checkFlag = false;
	} else {
		var re = /^[1][3,4,7,5,8][0-9]{9}$/;
		if (!re.test(tmemberreceiver_mobile)) {
			$("#mobile_tishi_b_id").html("手机号码格式不正确");
		    $("#mobile_tishi_b_id").show();
			checkFlag = false;
		} else {
			$("#mobile_tishi_b_id").hide();
		}
	}
	return checkFlag;
}
//保存或是修改收获地址
function saveReceiver(){
   if(checkReceiver()){
    var bischecked=$('#tmemberreceiver_is_default_checkbox').is(':checked');
     if(bischecked){
        $('#tmemberreceiver_is_default').val($("#tmemberreceiver_is_default_checkbox").val())
     }
     $("#city_name_set").val($("#city-picker3").val());
     var formInfo = $("#receiverForm").serialize();
			$.ajax({
				url : "../member/order!ajaxSaveOrUpdateReceiverNew.action",
				type : "post",
				data : formInfo,
				dataType:"json",
				success : function(data) {
					if (data.receiverId != '') { // '1'更新,'2'修改
						$alertCanDisplay("success","保存成功",null,null);
						 window.location.href="${base}/member/receiver.action";
					}else if(data.receiverSize>9){
						$alertCanDisplay("warn",data.message,null,null);
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

function ajaxReceiver(receiverId){
  $.ajax({
		url : "../member/receiver!ajaxReceiver.action",
		type : "post",
		data : {"receiverId":receiverId},
		dataType:"json",
		success : function(data) {
		   
			$("#tmemberreceiver_id").val(data.receiver.id);
			$("#tmemberreceiver_areaId").val(data.receiver.area_id);
			$("#tmemberreceiver_receiver").val(data.receiver.receiver);
		    $("#tmemberreceiver_address").val(data.receiver.address);
		    $("#tmemberreceiver_mobile").val(data.receiver.mobile);
		    $("#tmemberreceiver_longitude").val(data.receiver.longitude);
		    $("#tmemberreceiver_latitude").val(data.receiver.latitude);
		    if(data.receiver.is_default==1){
		        document.getElementById("tmemberreceiver_is_default_checkbox").checked = true;
		    }else{
		       document.getElementById("tmemberreceiver_is_default_checkbox").checked = false;
		    }
		    $("#city-picker3").val(data.receiver.area).trigger('change');
		    
		    
		    $(".placeholder").hide();
		    $(".city dd").html("");
		    $(".district dd").html("");
		    $(".active").each(function(i){
		        if($(this).html()!='省份'&&$(this).html()!='城市'&&$(this).html()!='区县'){
		            $(this).attr("class","");
		        }
		    });
		    var titlehtml="";
		    if(data.receiver.area!=null&&data.receiver.area!=''){
		      var area_s = data.receiver.area.split("-");
		      if(area_s.length >2){
			      titlehtml+="<span class=\"select-item\" data-count=\"province\" >"+area_s[0]+"</span>-";
			      titlehtml+="<span class=\"select-item\" data-count=\"city\" >"+area_s[1]+"</span>-";
			      titlehtml+="<span class=\"select-item\" data-count=\"district\" >"+area_s[2]+"</span>";
		      }else if(area_s.length >1){
		       	  titlehtml+="<span class=\"select-item\" data-count=\"province\" >"+area_s[0]+"</span>-";
		      	  titlehtml+="<span class=\"select-item\" data-count=\"city\" >"+area_s[1]+"</span>";
		      }else{
		      	  titlehtml+="<span class=\"select-item\" data-count=\"province\" >"+area_s[0]+"</span>";
		      }
		    }
		    $(".title").html(titlehtml);
		    $(".title").show();
		     
		     
		     /*if(data.receiver.area!=null&&data.receiver.area!=''){
			      var area_s = data.receiver.area.split("-");
				     if(area_s.length >0){
				        $(".province a").each(function(i){
					        if($(this).html()==area_s[0]){
					           $(this).attr("class","active");
					           titlehtml+="<span class=\"select-item\" data-count=\"province\" data-code=\""+$(this).attr("data-code")+"\">"+area_s[0]+"</span>-";
					           var districts= ChineseDistricts[$(this).attr("data-code")];
					             if ($.isPlainObject(districts)) {
					                var city_html = "";
					                $.each(districts, function (code, address) {
					                      city_html+="<a onclick=\"javascript:getAreaId("+code+")\" title=\""+address+"\" data-code=\""+code+"\" class=\"\">"+address+"</a>"; 
					                });
					                $(".city dd").html(city_html);
					            }
					        }
					    });
				    }
				    if(area_s.length >1){
				         $(".city a").each(function(i){
					        if($(this).html()==area_s[1]){
					        titlehtml+="<span class=\"select-item\" data-count=\"province\" data-code=\""+$(this).attr("data-code")+"\">"+area_s[1]+"</span>-";
					           $(this).attr("class","active");
					           var districts= ChineseDistricts[$(this).attr("data-code")];
					             if ($.isPlainObject(districts)) {
					             var district_html = "";
					                $.each(districts, function (code, address) {
					                      district_html+="<a onclick=\"javascript:getAreaId("+code+")\" title=\""+address+"\" data-code=\""+code+"\" class=\"\">"+address+"</a>"; 
					                });
					                $(".district dd").html(district_html);
					            }
					        }
					    });
				    }
				    if(area_s.length >2){
				         $(".district a").each(function(i){
					        if($(this).html()==area_s[2]){
					           titlehtml+="<span class=\"select-item\" data-count=\"province\" data-code=\""+$(this).attr("data-code")+"\">"+area_s[2]+"</span>";
					           $(this).attr("class","active");
					        }
					    });
				    }
		    }*/
		     
		     
		     
		    checkReceiver();
		},
		error : function() {
			$alertCanDisplay("error","操作失败，请稍后再试",null,null);
		}
	});
}

</script>
<div class="user_center_footer" style="float:left;"><#include "/static/inc/version2.2.0/footer.ftl"></div>
</body>
</html>