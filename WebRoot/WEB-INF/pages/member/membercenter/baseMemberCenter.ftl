<!doctype html>
<html>
<head>
	<#include "/WEB-INF/pages/inc/taglibs.ftl">
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
    <link rel="icon" type="image/png" href="images/common/favicon.png">
    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/common/favicon.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="images/common/favicon.png">
    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/common/favicon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <!--common style-->
    <!--
    <link rel="stylesheet" type="text/css" href="${base}/web/css/common.css">
    -->
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/common.css">
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/member.css">
    <!--
    <link rel="stylesheet" type="text/css" href="${base}/web/css/member-new.css">
    -->
    
    
    <script type="text/javascript" src="${base}/web/js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css">
	<link rel="stylesheet" type="text/css" href="${base}/web/css/jquery-ui.css">
	<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
    <style>
    	.data-ts-me {
		  float: left;
		  height: 32px;
		  line-height: 32px;
		  background: url("/web/version2.2.0/images/member/tip.jpg") no-repeat left center;
		  padding-left: 21px;
		  margin-left: 5px;
		  color:#ff9900;
		}
		
		.data-ts{float:left; height:32px; line-height:32px; background: url("/web/images/member-center/member_data_icon.png") no-repeat left center; padding-left:15px; margin-left:5px;}
		
		.data-part{
			padding:18px 0 20px 34px;
		}
		
		#img148 {
		  height: 148px;
		  width: 148px;
		  border: 1px solid #d2d2d2;
		}
		#img100{
		  height: 100px;
		  width: 100px;
		  border: 1px solid #d2d2d2;
		}
		#img48{
		  height: 48px;
		  width: 48px;
		  border: 1px solid #d2d2d2;
		}
		
		
		.out-box-member .btn-close {
			position: absolute;
			right: 8px;
			top: 6px;
			overflow: hidden;
			width: 18px;
			height: 17px;
			margin: 0;
			background: url("/web/version2.2.0/images/member/pop.png")  no-repeat 5px 5px;
			text-indent: -99px;
			outline: 0
		}
		
		.out-box-member .btn-close:hover {
			background-position: -30px 0
		}
    </style>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">

<input type="hidden" name="currentForm" id="currentForm" value="baseMemberCenterForm"/>
<!-- line开始-->
<div class="member-line"></div>
<!-- line结束-->
<!--内容开始-->
<div class="member-content w1090">
	<!--左侧导航开始-->
	<#include "/WEB-INF/pages/member/left-menu.ftl">
	<!--左侧导航结束-->
    
    <!-- 右侧内容开始-->
    <div class="member-main-right" >
        <div class="m-site"><a href="/member/index!getCenterIndex.action">用户中心</a>　>　<span>个人资料</span></div>
        <div class="personal-data">
            <ul class="data-nav">
                <li class="current base-li"><a href="#"><span>基本资料</span><em></em></a></li>
                <li class="more-li"><a href="#"><span>更多个人资料</span><em></em></a></li>
                <li class="hobby-li"><a href="#"><span>兴趣爱好</span></a></li>
            </ul>
            <div class="data-line"></div>
        </div>
        
		<form id="baseMemberCenterForm">
		<input type="hidden" name="tMemberBaseMessageExt.memberId" value="<#if member?exists>${member.id?default('')}</#if>"/>
	    <!-- 个人资料开始-->
        <div class="base-member-center">
	        <div class="data-part" style="padding-bottom: 20px;">
		            <div class="data-header">
		            	<!--
		                <img style="width:80px;height:80px;" src="<#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.headPortrait?exists && tMemberBaseMessageExt.headPortrait?has_content><#if !tMemberBaseMessageExt.headPortrait?starts_with('http:')>${ui1}</#if>${tMemberBaseMessageExt.headPortrait?default('')}<#else>${ui1}/static/image/temp/20151014/b09e2b114b6779b8fe47bcd8d38fe48a.png</#if>" alt=""/>
		                -->
		                <div class="data-header-img">
		                    <img id="headPortrait" src="<#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.headPortrait?exists && tMemberBaseMessageExt.headPortrait?has_content><#if !tMemberBaseMessageExt.headPortrait?starts_with('http:')>${ui1}</#if>${tMemberBaseMessageExt.headPortrait?default('')}<#else>${ui1}/static/image/temp/20160127/73569e0fe07f5e60234179baddec94eb.jpg</#if>" alt=""/>
		                    <b class="data-header-btn popup-btn6">修改</b>
	               		</div>
		                <span>用户名：<b>${member.userName?default('')}</b></span>
		            </div>
		            <!-- 个人信息开始-->
		            <div class="data-message">
		                <h3 class="data-tit">个人信息</h3>
		                <dl class="input-message">
		                    <dt><span>*</span>昵称:</dt>
		                    <dd>
		                        <div class="input-box" style="float:left">
		                        	<input type="text" maxlength="10" id="nickName" name="tMemberBaseMessageExt.nickName" value="<#if tMemberBaseMessageExt?exists>${tMemberBaseMessageExt.nickName?default('')}</#if>"/>
		                        </div>
			                    <p id="tip-validate-nickName" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请输入昵称</p>
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt><span>*</span>真实姓名:</dt>
		                    <dd>
		                        <div class="input-box" style="float:left">
		                        	<input type="text" maxlength="30" id="realName" name="tMemberBaseMessageExt.realName" value="<#if tMemberBaseMessageExt?exists>${tMemberBaseMessageExt.realName?default('')}</#if>"/>
		                        </div>
		                        <p id="tip-validate-realName" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请输入真实姓名</p>
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt><span>*</span>性别:</dt>
		                    <dd>
		                        <div class="radio-box" style="float:left">
		                            <input class="sex_radio_class" name="tMemberBaseMessageExt.sex" type="radio" value="1" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.sex?exists && tMemberBaseMessageExt.sex == 1>checked</#if> />男
		                            <input class="sex_radio_class" id="sex_mail" name="tMemberBaseMessageExt.sex" type="radio" value="2" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.sex?exists && tMemberBaseMessageExt.sex == 2>checked</#if>/>女
		                        </div>
		                        <p id="tip-validate-sex" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请选择性别</p>
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt><span>*</span>生日:</dt>
		                    <dd>
		                    	<#if year?exists>
		                    		<select id="yearfix" name="year"   class="selete-box-member">
			                            <option selected="selected" value="0">${year}</option>
			                        </select>
			                        <select id="monthfix" name="month"  class="selete-box-member">
			                            <option selected="selected" value="0">${month}</option>
			                        </select>
			                        <select id="dayfix" name="day" onkeyup="" class="selete-box-member">
										<option selected="selected" value="0">${day}</option>
			                        </select>
		                    	<#else>
		                    		<select id="year" name="year" onchange="showmonth();"  class="selete-box-member">
			                            <option selected="selected" value="0">选择年</option>
			                        </select>
			                        <select id="month" name="month" onchange="showday();" class="selete-box-member">
			                            <option selected="selected" value="0">选择月</option>
			                        </select>
			                        <select id="day" name="day" onkeyup="" class="selete-box-member">
										<option selected="selected" value="0">选择日</option>
									</select>
		                    	</#if>
		                        <p id="tip-validate-birth" class="data-ts-me" style="display:none;">请选择您的生日日期</p>
		                        <p id="tip-birth" class="data-ts">生日填写后不能轻易更改</p>
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt><span>*</span>身份:</dt>
		                    <dd>
		                        <div class="radio-box" style="float:left;">
		                            <input class="identity" name="tMemberBaseMessageExt.identity" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.identity?exists &&tMemberBaseMessageExt.identity==0>checked</#if> value="0" type="radio"/>学生
		                            <input class="identity" name="tMemberBaseMessageExt.identity" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.identity?exists &&tMemberBaseMessageExt.identity==1>checked</#if> value="1" type="radio"/>在职
		                            <input class="identity" name="tMemberBaseMessageExt.identity" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.identity?exists &&tMemberBaseMessageExt.identity==2>checked</#if> value="2" type="radio"/>自由职业
		                            <input class="identity" name="tMemberBaseMessageExt.identity" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.identity?exists &&tMemberBaseMessageExt.identity==3>checked</#if> value="3" type="radio"/>家庭主妇
		                            <input class="identity" name="tMemberBaseMessageExt.identity" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.identity?exists &&tMemberBaseMessageExt.identity==4>checked</#if> value="4" type="radio"/>退休
		                        </div>
		                        <p id="tip-validate-identity" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请选择身份</p>
		                    </dd>
		                </dl>
		            </div>
	            	<!-- 个人信息结束-->
		            <!-- 通讯方式开始-->
		            <div class="data-message">
		                <h3 class="data-tit">通讯方式</h3>
		                <dl class="input-message">
		                    <dt>手机:</dt>
		                    <dd>
		                    	<#if member.mobile?exists && member.mobile?length gt 0>
		                    		<span>
		                    			${member.mobile}
		                    			<#if member.isMobileCheck?exists && member.isMobileCheck == 1>
		                    				<span class="font-color update_mobile" style="cursor:pointer">修改手机</span>
		                    			<#else>
		                    				[未认证]<span class="font-color bind_mobile" style="cursor:pointer">认证手机</span>
		                    			</#if>
		                    		</span>
		                    	<#else>
		                    		<span class="font-color bind_mobile" style="cursor:pointer">认证手机</span>
		                    	</#if>
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt>电话:</dt>
		                    <dd>
		                        <div class="input-box w130-input" style="float:left;">
		                        	<input id="phone" maxlength="13" name="memberForm.phone" value="${member.phone?default('')}" type="text"/>
		                        </div>
		                        <p id="tip-validate-phone" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请输入电话</p>
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt>邮箱:</dt>
		                    <dd>
		                    	<#if member.email?exists && member.email?length gt 0>
		                    		<span>
		                    			${member.email}
		                    			<#if member.isEmailCheck?exists && member.isEmailCheck == 1>
		                    				<span class="font-color update_email" style="cursor:pointer">修改邮箱</span>
		                    			<#else>
		                    				[未认证]<span class="font-color bind_email" style="cursor:pointer">认证邮箱</span>
		                    			</#if>
		                    		</span>
		                    	<#else>
		                    		<span class="font-color bind_email" style="cursor:pointer">认证邮箱</span>
		                    	</#if>
		                    
		                    	<!--
		                        <div class="input-box w130-input" style="float:left;">
		                        	<input id="email" name="memberForm.email" value="${member.email?default('')}" type="text"/>
		                        </div>
		                        <p id="tip-validate-email" class="data-ts-me" style="float:left;margin-left:10px;display:none;">邮箱格式不正确</p>
		                        -->
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt>账单邮箱:</dt>
		                    <dd>
		                        <div class="input-box w130-input" style="float:left;">
		                        	<input id="billEmail" maxlength="30" name="tMemberBaseMessageExt.billEmail" value="<#if tMemberBaseMessageExt?exists>${tMemberBaseMessageExt.billEmail?default('')}</#if>" type="text"/>
		                        </div>
		                        <p id="tip-validate-billEmail" class="data-ts-me" style="float:left;margin-left:10px;display:none;">账单邮箱格式不正确</p>
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt>居住地:</dt>
		                    <dd>
		                        <select class="selete-box-member" id="province" name="province"  onchange="showcity();">
				                    <option value="0">
								                           请选择省
								    </option>
		                        </select>
		                        <select class="selete-box-member" id="city" name="city" onchange="showcounty()">
									<option value="0">
										请选择城市
									</option>
		                        </select>
		                        <select class="selete-box-member" id="county" name="county">
									<option value="0">
										请选择区县
									</option>
		                        </select>
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt>居住城市:</dt>
		                    <dd>
		                        <div class="input-box w330-input"><input type="text" maxlength="180" name="tMemberBaseMessageExt.address" value="<#if tMemberBaseMessageExt?exists>${tMemberBaseMessageExt.address?default('')}</#if>" class="w130-input"/></div>
		                    </dd>
		                </dl>
		            </div>
		            <!-- 通讯方式结束-->
		            <!-- 家庭情况开始-->
		            <div class="data-message">
		                <h3 class="data-tit">家庭情况</h3>
		                <dl class="input-message">
		                    <dt><span>*</span>婚姻状况:</dt>
		                    <dd>
		                        <div class="radio-box"  style="float:left;">
		                            <input class="isMarry" type="radio" name="tMemberBaseMessageExt.isMarry" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.isMarry?exists && tMemberBaseMessageExt.isMarry==0>checked</#if> value="0"/>未婚
		                            <input class="isMarry" type="radio" name="tMemberBaseMessageExt.isMarry" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.isMarry?exists && tMemberBaseMessageExt.isMarry==1>checked</#if> value="1"/>已婚
		                            <input class="isMarry" type="radio" name="tMemberBaseMessageExt.isMarry" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.isMarry?exists && tMemberBaseMessageExt.isMarry==2>checked</#if> value="2"/>保密
		                        </div>
		                        <p id="tip-validate-isMarry" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请选择婚姻状况</p>
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt>居住状况:</dt>
		                    <dd>
		                        <div class="radio-box">
		                            <input type="checkbox" name="tMemberBaseMessageExt.liveStatus" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.liveStatus?exists && tMemberBaseMessageExt.liveStatus?index_of(',0,') gte 0 >checked</#if> value="0"/>保密
		                            <input type="checkbox" name="tMemberBaseMessageExt.liveStatus" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.liveStatus?exists && tMemberBaseMessageExt.liveStatus?index_of(',1,') gte 0 >checked</#if> value="1"/>和伴侣
		                            <input type="checkbox" name="tMemberBaseMessageExt.liveStatus" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.liveStatus?exists && tMemberBaseMessageExt.liveStatus?index_of(',2,') gte 0 >checked</#if> value="2"/>和室友
		                            <input type="checkbox" name="tMemberBaseMessageExt.liveStatus" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.liveStatus?exists && tMemberBaseMessageExt.liveStatus?index_of(',3,') gte 0 >checked</#if> value="3"/>和父母
		                        </div>
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt>家庭成员:</dt>
		                    <dd>
		                        <select name="tMemberBaseMessageExt.familyMember" class="selete-box-member">
		                            <option value="0" selected>请选择</option>
		                            <option value="1" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.familyMember?exists && tMemberBaseMessageExt.familyMember==1>selected</#if>  >1人</option>
		                            <option value="2" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.familyMember?exists && tMemberBaseMessageExt.familyMember==2>selected</#if>  >2人</option>
		                            <option value="3" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.familyMember?exists && tMemberBaseMessageExt.familyMember==3>selected</#if>  >3人</option>
		                            <option value="4" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.familyMember?exists && tMemberBaseMessageExt.familyMember==4>selected</#if>  >4人以上</option>
		                        </select>
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt>小孩年龄:</dt>
		                    <dd>
		                        <div class="radio-box">
		                            <input type="checkbox" name="tMemberBaseMessageExt.childAge" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.childAge?exists && tMemberBaseMessageExt.childAge?index_of(',0,') gte 0 >checked</#if> value="0"/>无
		                            <input type="checkbox" name="tMemberBaseMessageExt.childAge" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.childAge?exists && tMemberBaseMessageExt.childAge?index_of(',1,') gte 0 >checked</#if> value="1"/>0-3岁
		                            <input type="checkbox" name="tMemberBaseMessageExt.childAge" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.childAge?exists && tMemberBaseMessageExt.childAge?index_of(',2,') gte 0 >checked</#if> value="2"/>4-6岁
		                            <input type="checkbox" name="tMemberBaseMessageExt.childAge" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.childAge?exists && tMemberBaseMessageExt.childAge?index_of(',3,') gte 0 >checked</#if> value="3"/>7-12岁
		                            <input type="checkbox" name="tMemberBaseMessageExt.childAge" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.childAge?exists && tMemberBaseMessageExt.childAge?index_of(',4,') gte 0 >checked</#if> value="4"/>13-18岁
		                            <input type="checkbox" name="tMemberBaseMessageExt.childAge" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.childAge?exists && tMemberBaseMessageExt.childAge?index_of(',5,') gte 0 >checked</#if> value="5"/>18岁以上
		                        </div>
		                    </dd>
		                </dl>
		            </div>
		            <!-- 家庭情况结束-->
		            <!-- 家庭资产开始-->
		            <div class="data-message border-no">
		                <h3 class="data-tit">家庭资产</h3>
		                <dl class="input-message">
		                    <dt style="width:85px;"><span>*</span>个人收入状况:</dt>
		                    <dd>
		                        <select id="personalIncome" name="tMemberBaseMessageExt.personalIncome" class="selete-box-member" selected="selected">
		                            <option value="0">
										请选择
									</option>
									<option label="2000元及以下" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.personalIncome?exists && tMemberBaseMessageExt.personalIncome==1>selected</#if>  value="1">
										2000元及以下
									</option>
									<option label="2000&#8213;5000元(包含5000元)" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.personalIncome?exists && tMemberBaseMessageExt.personalIncome==2>selected</#if> value="2">
										2000&#8213;5000元(包含5000元)
									</option>
									<option label="5000&#8213;10000元(包含10000元)" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.personalIncome?exists && tMemberBaseMessageExt.personalIncome==3>selected</#if> value="3">
										5000&#8213;10000元(包含10000元)
									</option>
									<option label="10000&#8213;20000元(包含20000元)" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.personalIncome?exists && tMemberBaseMessageExt.personalIncome==4>selected</#if> value="4">
										10000&#8213;20000元(包含20000元)
									</option>
									<option label="20000&#8213;40000元(包含40000元)" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.personalIncome?exists && tMemberBaseMessageExt.personalIncome==5>selected</#if> value="5">
										20000&#8213;40000元(包含40000元)
									</option>
									<option label="40000元以上" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.personalIncome?exists && tMemberBaseMessageExt.personalIncome==6>selected</#if> value="6">
										40000元以上
									</option>
		                        </select>
		                        <p id="tip-validate-personalIncome" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请选择个人收入状况</p>
		                    </dd>
		                </dl>
		                <dl class="input-message">
		                    <dt><span>*</span>是否有车:</dt>
		                    <dd>
		                        <div class="radio-box" style="float:left;">
		                            <input class="isCart" name="tMemberBaseMessageExt.isCart" value="1" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.isCart?exists && tMemberBaseMessageExt.isCart==1>checked</#if> type="radio" />是
		                            <input class="isCart" name="tMemberBaseMessageExt.isCart" value="0" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.isCart?exists && tMemberBaseMessageExt.isCart==0>checked</#if> type="radio" />否
		                        </div>
		                        <p id="tip-validate-isCart" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请选择是否有车</p>
		                    </dd>
		                </dl>
		            </div>
		            <!-- 家庭资产结束-->
		            <div class="member-btn"><input type="button" class="btn_div" value="保存" onclick="saveMemberCenter('baseMemberCenterForm')"/></div>
		            <div class="member-btn"><input type="button" class="btn_div_temp" value="保存" style="display:none;background:#dddddd"/></div>
	        </div>
	    </div>
        <!-- 个人资料结束-->

		</form>
	    <!-- 右侧内容结束-->
		<#include "hobbyMemberCenter.ftl"/>
		<#include "moreMemberCenter.ftl"/>
    </div>

<div class="user_center_footer" style="float:left;"><#include "/static/inc/version2.2.0/footer.ftl"></div>
</div>
<!--内容结束-->
<!--遮罩层开始-->

<div id="shade">
	<form id="inputForm" name="inputForm" method="post" enctype="multipart/form-data">
	    <!--修改头像开始-->
	    <div class="out-box-member out-member" id="out6" style="display:block">
	    	<a class="pop-close btn-close" id="btn-close" href="javascript:void(0);">鍏抽棴</a>
	        <div class="uploading-input">
	            <a href="#"> <input  id="head" name="head" type="file" class=""/>选择您要上传的头像</a>
	            <p>仅支持JPG、GIF、PNG、JPEG、BMP格式，文件小于4M</p>
	        </div>
	        <div class="uploading-img">
	            <img id="img148" src="" alt=""/>
	        </div>
	        <p class="uploading-text"><span>预览效果</span>你上传的图片会自动生成2种尺寸，请注意小尺寸的头像是否清晰</p>
	        <ul class="uploading-preview">
	            <li><img id="img100" src="" alt=""/></li>
	            <li class="img02"><img id="img48" src="" alt=""/></li>
	        </ul>
	        <div class="uploading-btn">
	            <input id="imageSubmit" type="button" value="保存"/>
	        </div>
	    </div>
	</form>
    <!--修改头像结束-->
</div>
<!--遮罩层结束-->

	


<!--js-->
<script src="${base}/web/js/jquery-1.7.2.js"></script>
<script src="${base}/web/js/common-membercenter.js"></script>
<script src="${base}/web/js/underline-slide.js"></script>
<script src="${base}/web/js/membercenter.js"></script>
<script src="${base}/web/version2.2.0/js/shopping.js"></script>
<script src="${base}/web/version2.2.0/js/uploadHeadPortrait.js"></script>
<script src="${base}/web/js/My97DatePicker/WdatePicker.js"></script>
<script>
var $province = "${province?default('')}";
var $city = "${city?default('')}";
var $county = "${county?default('')}";

initProvinces($province);
if($city != ''){
	initCity($province,$city);
}
if($county != ''){
	initcounty($city,$county);
}

</script>
</body>
</html>