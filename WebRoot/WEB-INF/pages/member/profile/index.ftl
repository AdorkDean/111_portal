<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人资料</title>
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
        <div class="member-content  personal-data">
            <h2>个人资料</h2>
            <div class="personal-data-main">
                <!-- 个人资料-->
                <div class="left">
                    <table width="580" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td align="left" valign="middle" height="36">基本资料</td>
                            <td align="left" valign="middle" height="36"></td>
                            <td align="left" valign="middle" height="36"></td>
                        </tr>
                        <tr>
                            <td align="left" valign="middle" height="42" class="icon01">手机号</td>
                            <td align="left" valign="middle" height="42">${member.mobile?default('')} <#if member.mobile?exists> <#if member.isMobileCheck != 1><input type="button" class="revise" onClick="isMobileCheck()"></#if></#if></td>
                            <td align="left" valign="middle" height="42">
                            	<#if member.isMobileCheck == 1>
                            		<span class="icon03" class="icon03">已验证</span>
                            	<#else>
                            		<span class="icon04">未验证</span>
                            		<a href="${base}/member/profile!editMobile.action" class="yz">点击验证</a>
                            	</#if> 
                            </td>
                        </tr>
                        <tr>
                            <td align="left" valign="middle" height="42" class="icon02">邮箱</td>
                            <td align="left" valign="middle" height="42">${member.email?default('')} <#if member.email?exists><#if member.isEmailCheck != 1> <input type="button" class="revise" onClick="isEmailCheck()"></#if></#if></td>
                            <td align="left" valign="middle" height="42">
                            	<#if member.isEmailCheck == 1>
                            		<span class="icon03" class="icon03">已验证</span>
                            	<#else>
                            		<span class="icon04">未验证</span>
                            		<a href="javascript:void(0);" class="yz checkEmail">点击验证</a>
                            	</#if>
                            </td>
                        </tr>
                        <tr class="bottom-td">
                            <td align="left" valign="middle" height="42" class="icon03">密码</td>
                            <td align="left" valign="middle" height="42">**************<input type="button" class="revise editPassword"/></td>
                            <td align="left" valign="middle" height="42" class="password-td">由6-20位字母、数字，符号两种以上组成</td>
                        </tr>
                    </table>
                </div>
                <!-- 消费记录-->
                <div class="right">
                    <h3>消费记录</h3>
                    <div class="num">
                    	<b>近一年消费记录</b>
                        <p><em>元</em><span>${currency(monetary?default('0'))}</span></p>
                    </div>
                </div>
            </div>
            <!-- 商品列表-->
            <div class="recommond-title" style="height:30px; line-height:30px; padding-left:22px;"><span style="font-size:18px; font-weight:bold;">热门推荐</span></div>
            <div id ="recommond-pro-id">
            
            </div>
            <!-- 商品列表-->
        </div>
    </div>
</div>
<#include "/static/inc/footer.ftl">
</body>
</html>
<script type="text/javascript" src="${base}/web/js/goods-recommend.js"></script>
<script type="text/javascript" >
$().ready(function(){
	$(".checkEmail").click(function(){
		<#if member.isMobileCheck?exists && member.isMobileCheck == 1>
			location.href="${base}/member/profile!editEmail.action";
		<#else>
			$alert("warn","请先验证手机","友情提示",null);	
			location.href="${base}/member/profile!editMobile.action";	
		</#if> 
	});
	
	
	$(".editPassword").click(function(){
		<#if member.isMobileCheck?exists && member.isMobileCheck == 1>
			location.href = "${base}/member/profile!editPassword.action";
		<#else>
			$alert("warn","请先验证手机","友情提示",null);	
			location.href="${base}/member/profile!editMobile.action";	
		</#if> 
	});
});

<#if member.isMobileCheck != 1>
function isMobileCheck(){
	location.href = "${base}/member/profile!editMobile.action";
}
</#if>

<#if member.isEmailCheck != 1>
function isEmailCheck(){
	$(".checkEmail").trigger("click");
}
</#if>
</script>