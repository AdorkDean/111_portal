<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>完善资料 </title>
</head>
<body>
<#include "/static/inc/center_header.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content perfect-data">
        	<form id="inputForm" name="inputForm" method="post" enctype="multipart/form-data">
            <h2>完善资料 <span>完善基本资料，可以获得更多积分</span></h2>
            <div class="perfect-data-list">
                <dl class="top">
                    <dt>个人资料</dt>
                    <dd></dd>
                </dl>
                <dl>
                    <dt>昵称</dt>
                    <dd><input name="tmember.nickName" id="nickname" type="text" value="${member.nickName?default('')}" maxlength="9"/><em>完善可得5积分</em></dd>
                </dl>
                <dl>
                    <dt>真实姓名</dt>
                    <dd><input name="tmember.realName" type="text" value="${member.realName?default('')}" maxlength="9"/><em>完善可得5积分</em></dd>
                </dl>
                <dl>
                    <dt>性别</dt>
                    <dd id="sex_dd">
                        <span <#if (member.sex?exists && member.sex == 1)|| !member.sex?exists>class="current"</#if> val="1">男</span>
                        <span <#if member.sex?exists && member.sex == 2>class="current"</#if> val="2">女</span>
                        <input id="sex" name="tmember.sex" type="hidden" value="<#if (member.sex?exists && member.sex == 1)|| !member.sex?exists>1<#else>2</#if>"/>
                        <em>完善可得5积分</em>
                    </dd>
                </dl>
               <dl>
                    <dt>血型</dt>
                    <dd>
                    	<select name="tmember.bloodType">
                    		<option value="">请选择</option>
                    		<option <#if member.bloodType?exists && member.bloodType == "1">selected</#if> value="1">A型</option>
                    		<option <#if member.bloodType?exists && member.bloodType == "2">selected</#if> value="2">B型</option>
                    		<option <#if member.bloodType?exists && member.bloodType == "3">selected</#if> value="3">AB型</option>
                    		<option <#if member.bloodType?exists && member.bloodType == "4">selected</#if> value="4">O型</option>
                    		<option <#if member.bloodType?exists && member.bloodType == "5">selected</#if> value="5">其它</option>
                    	</select>
                    	<em>完善可得5积分</em>
                    </dd>
                </dl>
                <#if member.email?exists>
                <dl>
                    <dt>邮箱</dt>
                    <dd><input name="email" type="hidden" value="${member.email?default('')}"/> ${member.email?default('')}</dd>
                </dl>
                </#if>
                <#if member.mobile?exists>
                <dl>
                    <dt>手机</dt>
                    <dd><input name="mobile" type="hidden" value="${member.mobile?default('')}"/>${member.mobile?default('')}</dd>
                </dl>
                </#if>
                <dl>
                    <dt>常用药</dt>
                    <dd class="position-s"><input id="drug" name="tmember.drug" type="text" value="${member.drug?default('')}" maxlength="200" class="onkeyup" /><strong><b id="drug_b"><#if member.drug?exists>${member.drug?length}<#else>0</#if></b>/<b>200</b></strong></dd>
                </dl>
                <dl>
                    <dt>病史</dt>
                    <dd class="position-s"><input id="history" name="tmember.history" type="text" value="${member.history?default('')}" maxlength="200" class="onkeyup"/><strong><b id="history_b"><#if member.history?exists>${member.history?length}<#else>0</#if></b>/<b>200</b></strong></dd>
                </dl>
                <dl>
                    <dt>过敏史</dt>
                    <dd class="position-s"><input id="allergy" name="tmember.allergy" type="text" value="${member.allergy?default('')}" maxlength="200" class="onkeyup"/><strong><b id="allergy_b"><#if member.allergy?exists>${member.allergy?length}<#else>0</#if></b>/<b>200</b></strong></dd>
                </dl>
                <input type="submit" value="保 存" class="save"/>
            </div>
            <div class="secret">
                <p>保密声明：常用药、病史、过敏史只能被医师查看</p>
                <p>三项填写完整可得50积分</p>
            </div>
            
            </form>
        </div>
    </div>
</div>
<#include "/static/inc/footer.ftl">
</body>
</html>
<script type="text/javascript" src="${base}/web/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${base}/web/js/jquery.validate.js"></script>
<script type="text/javascript" src="${base}/web/js/input.js"></script>
<script type="text/javascript">
$().ready(function() {
	var $inputForm = $("#inputForm");
	
	$("#sex_dd span").click(function(){
		$("#sex_dd span").removeClass("current");
		$(this).addClass("current");	
		$("#sex").val($(this).attr("val"));
	});
	
	$inputForm.validate({
		rules: {
			"tmember.nickName": "required",
			"tmember.realName": "required",
			"tmember.bloodType":"required",
			"tmember.drug": "required",
			"tmember.history": "required",
			"tmember.allergy": "required"
		},
		messages: {
            "tmember.nickName": {
                //required: "昵称",
                //maxlength: "姓名不超过${1}个字符"
            }
        },
		submitHandler: function(form){   
            $.ajax({
	            type: "post",
	            cache: false,
	            dataType:"json",
	            url: "${base}/member/profile!editPerfect.action",
	            data: $inputForm.serialize(),	            
	            success: function(data, textStatus){
	            	var message = "";
	            	if(data.type){
	            		message += "保存成功"
	            		if(data.point >0){
		            		message += ",获得"+data.point+"积分！";
		            	}else{
		            		message += "！"
		            	}
		            	$alert("success",message,"友情提示",null);
		            	$("#cookieusername").html($.trim($("#nickname").val()));
	            	}else{
	            		$alert("warn","保存失败!","友情提示",null);
	            	}
	            }
	        });
        } 
	});
	
	$("#drug").keyup(function(){
		var length = $.trim($("#drug").val()).length;
		$("#drug_b").html(length);
	});
	
	$("#history").keyup(function(){
		var length = $.trim($("#history").val()).length;
		$("#history_b").html(length);
	});
	
	$("#allergy").keyup(function(){
		var length = $.trim($("#allergy").val()).length;
		$("#allergy_b").html(length);
	});
	
});

</script>
<style type="text/css">
.perfect-data .perfect-data-list dl dd{position:relative;}
.perfect-data .perfect-data-list dl dd label {color: #E81B1B; margin-left:5px;  position: absolute;  top: 0;  right: 160px;}
.perfect-data .perfect-data-list dl dd.position-s{position:relative;}
.position-s strong{position:absolute; top:1px; right:200px;}
</style>
