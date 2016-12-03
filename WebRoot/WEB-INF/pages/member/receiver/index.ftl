<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>收货地址管理 </title>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content address">
            <h2>收货地址管理 <span>在这里可以预设您的收货地址，最多10个</span></h2>
            
            <div style="margin-right: 20px;">
            
            <div class="address-list">
            	<#if receivers?has_content && 0 < receivers?size>
                <div class="old-add">
                    <table  cellpadding="0" cellspacing="0">
                        <tr class="top-tit-td">
                            <td align="center" valign="middle" height="42" class="l">收货人姓名</td>
                            <td align="center" valign="middle" height="42" style="width:40%">详细地址</td>
                            <td align="center" valign="middle" height="42">联系电话</td>
                            <td align="center" valign="middle" height="42" class="r">操作</td>
                        </tr>
                        <#list  receivers as receiver>
                        <tr name="tr-name" <#if receiver.isDefault?exists && receiver.isDefault == 1>class="current" </#if>>
                            <td align="center" valign="middle" height="42" class="l">${receiver.receiver?default('')}</td>
                            <td align="center" valign="middle" height="42" style="width:40%">${receiver.area?default('')}&nbsp;${receiver.address?default('')}</td>
                            <td align="center" valign="middle" height="42">${receiver.mobile?default('')}</td>
                            <td align="center" valign="middle" height="42"  class="r">
                                <#if receiver.isDefault?exists && receiver.isDefault == 1>
                                	<span class="cor" val="${receiver.id?default('')}">默认地址</span><input type="button" class="btn01 deleteReceiver" val="${receiver.id?default('')}"/><input type="button" class="btn02 editReceiver" val="${receiver.id?default('')}"/>
                                <#else>
                                	<span class="setDefault" val="${receiver.id?default('')}">设为默认</span><input type="button" class="btn01 deleteReceiver" val="${receiver.id?default('')}"/><input type="button" class="btn02 editReceiver" val="${receiver.id?default('')}"/>
                                </#if>                        
                            </td>
                        </tr>
                        </#list>
                    </table>
                </div>
                <#else>
                <div class="old-add">
                	<span style="height:20px;line-height:20px;font-family: 'Microsoft YaHei, Arial, Helvetica, verdana, sans-serif';">还没有地址，请添加常用地址</span>
                </div>	
                </#if>
                <div class="new-add-btn" id="new-add-btn" style="margin-top: 20px;"><input type="button" value="新增收货人地址"/></div>
            </div>
            </div>
        </div>
    </div>
</div>

<!-- 新增收货地址-->
<div class="new-add popup-add">
<form id="inputForm" name="inputForm" method="post" enctype="multipart/form-data">
    <div class="info">修改/新增 收货人地址 <b class="close-out"></b></div>
    <div class="new-add-main">
        <dl>
            <dt><span>*</span>收货人</dt>
            <dd>
            	<input id="id" name ="tmemberreceiver.id" type="hidden" value="" />
            	<input id="receiver" name ="tmemberreceiver.receiver" type="text" value="" maxlength="9"/>
            </dd>
        </dl>
        <dl>
            <dt><span>*</span>是否默认</dt>
            <dd>
            	<span id="isDefaultSpan">
            		<input id="isDefault" name ="tmemberreceiver.isDefault" type="hidden" value=""/>设为默认地址                            	
            	</span>
            </dd>
        </dl>
        <dl>
            <dt><span>*</span>所属地区</dt>
            <dd id="area_dd">
               <input id="areaId" name="tmemberreceiver.areaId" type="hidden" value=""/>                                                             
            </dd>
        </dl>
        <dl>
            <dt><span>*</span>收货地址</dt>
            <dd><input id="address" name ="tmemberreceiver.address" type="text" value="" maxlength="40" style="width:250px;"/></dd>
        </dl>
        <dl>
            <dt><span>*</span>手机号码</dt>
            <dd><input id="mobile" name ="tmemberreceiver.mobile" type="text" value="" maxlength="11"/></dd>
        </dl>
        <dl>
            <dt>邮政编码</dt>
            <dd><input id="zipCode" name ="tmemberreceiver.zipCode" type="text" value="" maxlength="6"/></dd>
        </dl>
        <dl>
            <dt></dt>
            <dd class="submit-refund"><input type="submit" id="mybtn" value="保存收货人信息"/></dd>
        </dl>
    </div>
</from>    
</div>
<div id="shade"></div>
<!-- 新增收货地址-->

<div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
</body>
</html>
<script type="text/javascript" src="${base}/web/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${base}/web/js/jquery.validate.js"></script>
<script type="text/javascript" src="${base}/web/js/jquery.lSelect.js"></script>
<script type="text/javascript" src="${base}/web/js/input.js"></script>
<script type="text/javascript">
$().ready(function() {
	
	var $inputForm = $("#inputForm");
	
	//设置默认
	$(".setDefault").live("click",function(){
		var def = $(this);
		
		$confirm("warn", "确认设置为默认收货地址?", null, function(data){
		
		   if(data){
		   
		   	$.ajax({
		        type: "post",
		        cache: false,
		        dataType:"json",
		        url: "${base}/member/receiver!setDefault.action",
		        data: {
		        	id:def.attr("val")
		        },	            
		        success: function(data, textStatus){
		        	if(data){
		        		$("tr").removeClass("current");
		        		$("td span").removeClass("cor");
		        		$("td span").addClass("setDefault");
		        		$("td span").html("设为默认");
		        		def.removeClass("setDefault");
		        		def.addClass("cor");
		        		def.html("默认地址");
		        		def.parent().parent().addClass("current");
		            	$alert("success","保存成功！","系统提示",null);
		        	}else{
		        		$alert("warn","保存失败","系统提示",null);
		        	}
		        }
		    });
		   }
		
			
		}); 
	
	});
	
	
	//删除收货地址
	$(".deleteReceiver").live("click",function(){
		var def = $(this);
		
		$confirm("warn","确认删除收货地址?","系统提示",function(tag){
			if(tag){
				$.ajax({
			        type: "post",
			        cache: false,
			        dataType:"json",
			        url: "${base}/member/receiver!delete.action",
			        data: {
			        	id:def.attr("val")
			        },	            
			        success: function(data, textStatus){
			        	if(data){
			        		def.parent().parent().remove();
			        		//$alert("success","删除成功！","系统提示",null);
			        	}else{
			        		$alert("warn","删除失败！","系统提示",null);
			        	}
			        }
			    });
			}
		});
		
	});
	
	
	//编辑收货地址
	$("#isDefaultSpan").click(function(){
		if($(this).hasClass("default")){
			$(this).removeClass("default");
			$("#isDefault").val("0");			
		}else{
			$(this).addClass("default");
			$("#isDefault").val("1");	
		}
	});
	
	//编辑收货地址
	$(".editReceiver").live("click",function(){
		$.ajax({
	        type: "post",
	        cache: false,
	        dataType:"json",
	        url: "${base}/member/receiver!edit.action",
	        data: {
	        	id:$(this).attr("val")
	        },	            
	        success: function(data, textStatus){
	        	if(data!=null){
	        		$("#id").val(data.id);
	        		
	        		$("#receiver").val($.trim(data.receiver));
	        		if(data.isDefault!=null && data.isDefault =="1"){
	        			$("#isDefaultSpan").addClass("default");
	        			$("#isDefault").val("1");	
	        		}else{
	        			$("#isDefaultSpan").removeClass("default");
	        			$("#isDefault").val("0");
	        		}
					$("#areaId").val(data.areaId);
	        		$("#address").val($.trim(data.address));
	        		$("#mobile").val($.trim(data.mobile));
	        		$("#zipCode").val($.trim(data.zipCode));
	        		$("#new-add").show();
	        		// 地区选择加载
					$("#areaId").lSelect({
						url: "${base}/location/area.action"
					});
					//显示弹出层
					$("#shade").css({
					    display:"block"
					});
					$(".popup-add").show();
	        	}else{
	        		$alert("warn","编辑失败！","系统提示",null);
	        	}
	        }
	    });
	});
	
	
	jQuery.validator.addMethod("isMobile", function(value, element) {
	    var mobile = /^1[3|4|5|7|8]{1}\d{9}$/;
	    return mobile.test(value);
	}, "请输入有效手机号");
	
	jQuery.validator.addMethod("isZipCode", function(value, element) {
		if(value==null||value==""){
			return true;
		}
	    var zipcode = /^\d{6}$/;
	    return zipcode.test(value);
	}, "请输入正确的邮编");
	
	$inputForm.validate({
		rules: {
			"tmemberreceiver.receiver": "required",
			"tmemberreceiver.areaId": "required",
			"tmemberreceiver.address": "required",
			"tmemberreceiver.mobile":{
            	required : true,
	            // 自定义方法：校验手机号在数据库中是否存在
	            // checkPhoneExist : true,
	            isMobile : true
	        },
			"tmemberreceiver.zipCode":{
				isZipCode:true
	        }
		},
		submitHandler: function(form){   
		
		$('#mybtn').attr("disabled",true);
            $.ajax({
	            type: "post",
	            cache: false,
	            dataType:"json",
	            url: "${base}/member/receiver!saveOrUpdate.action",
	            data: $inputForm.serialize(),	            
	            success: function(data, textStatus){
	            	if(data!=null){
	            		if(data == "max"){
	            			$alert("warn","收货地址最多可添加10个！","系统提示",null);
	            		}else{
		            		$alert("success","保存成功！","系统提示",null);
			            	setTimeout("reload()",3000);
	            		}
	            	}else{
	            		$alert("warn","保存失败！","系统提示",null);
	            	}
	            }
	        });
        } 
	});
	
	
	//弹出层
    $("#new-add-btn").click(function(){
    
    var trcnt = $("tr[name='tr-name']").length;
  
    if(trcnt==10){
        $alert("warn","收货地址最多可添加10个！","系统提示",null);
    	return false;
    }

    	
        $("#shade").css({
            display:"block"
        })
        $inputForm[0].reset();
        $("#areaId").val("");
        // 地区选择加载
		$("#areaId").lSelect({
			url: "${base}/location/area.action"
		});
        $(".popup-add").show();
    })
    $(".close-out").click(function(){
        $("#shade,.popup-add").hide();
    })
   
});
function reload(){
	window.location.reload();
}
</script>

<style type="text/css">
dd label{float:right; color: #E81B1B;}
</style>