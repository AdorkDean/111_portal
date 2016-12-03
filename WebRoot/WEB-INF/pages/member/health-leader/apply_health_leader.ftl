<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="">
    <!-- keywords -->
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>申请领秀</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="/web/img/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="/web/img/favicon-196x196.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="img/apple-icon-touch.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/health.css"/>
   
    
    
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/center_leader.ftl">
 <script type="text/javascript" src="${base}/web/js/jquery.min.js"></script>
    
	<link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css">
	<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
    
    <script type="text/javascript" src="${base}/web/js/apply_health_leader.js"></script>
    
<script>
$(function(){
	$(".current-page").find("h2").css({"color":"#19a69f","font-family":"Microsoft Yahei","letter-spacing":"1px"}).html("健康领秀");
	$(".current-page").find("a").css({"color":"#19a69f","border":"#19a69f 1px solid"});
});
</script>        
<form action="../healthLeader/saveHealthLeader!saveHealthLeader.action" id="subForm" method="post" enctype="multipart/form-data">
<div class="health-wrap">
    <div class="apply-wrap">
        <h2>申请领秀</h2>
        
        <div class="apply-list message">
            <dl>
                <dt>昵称</dt>
                <dd><input maxlength="10" type="text" value="" name="nickName"/><i class="inputTip">请输入您的昵称</i></dd>
            </dl>
            <dl>
                <dt>姓名</dt>
                <dd><input maxlength="10" type="text" style="color:#000;" value="" name="realName"/><i class="inputTip">请输入您的姓名</i></dd>
            </dl>
            <dl>
                <dt>性别</dt>
                <dd><span id="man" class="current">男</span><span id="woman">女</span><input value="1" type="hidden" name="sex"/></dd>
            </dl>
            <dl>
                <dt>身份证号</dt>
                <dd><input maxlength="18" type="text" value="" name="cardCode"/><i class="inputTip">请输入您的身份证号</i></dd>
            </dl>
        </div>
        <div class="apply-list message">
            <dl>
                <dt>所属地区</dt>
                <dd>
                    <div class="coupons-list">
                        <select onchange="selectLocation()" name="firstLocation" class="selete-box" id="firstLocation">
                            <option value="">请选择</option>
                            <#list firstList as location>
	                            <option value="${location.id?if_exists}">${location.name?if_exists}</option>
                            </#list>
                        </select>
                    </div>
                    <b class="city">省</b>
                    <div class="coupons-list">
                        <select  onchange="selectCity()" name="secondLocation" class="selete-box" id="secondLocation">
                            <option value="">请选择</option>
                        </select>
                    </div>
                    <b class="city">市</b>
                    <div class="coupons-list">
                        <select class="selete-box" id="thirdLocation" id="thirdLocation" name="thirdLocation">
                            <option value="" id="_thirdLocation"> 请选择</option>
                        </select>
                    </div>
                    <b class="city">区</b>
                </dd>
            </dl>
            <dl>
                <dt>详细地址</dt>
                <dd><input maxlength="80" type="text" value="" name="address"/><i class="inputTip">请输入您的详细地址</i></dd>
            </dl>
        </div>
        <div class="apply-list message">
            <dl>
                <dt>确认手机</dt>
                <dd><input maxlength="11" type="text" id="confirmPhone" value="" name="phone"/><i class="inputTip" style="margin-left:-210px;">请输入您的手机号</i><input type="button" id="sendCode" value="发送验证码" class="code"/></dd>
            </dl>
            <dl>
                <dt>验证码</dt>
                <dd><input maxlength="6" type="text" value="" name="verifyCode"/><i class="inputTip">请输入手机验证码</i></dd>
            </dl>
        </div>
        
        
        <div class="apply-list uploading">
            <p>上传您的照片：  图片不大于2M,格式为jpg</p>
            <dl>
                <dt>
                	<span class="see-example">查看范例</span>
                    <div class="example-img"><img src="${base}/web/img/health-photo01.jpg" alt="" width="320" height="209"/></div>
                </dt>
                <dd>
                    <div class="click-w">
                        <input unselectable="on" type="file" name="headImage"/>
                        <span id="headImageTip">
                        	<#if tLeader?exists && tLeader.headUrl?exists>
                        		<img src="${base}${tLeader.headUrl?if_exists}"/>
                        	<#else>
                        		点此上传
                        	</#if>
                        </span>
                        <div class="health-close"></div>
                    </div>
                </dd>
            </dl>
            <p>上传您的资质：  最少上传一张最多五张，资质比如执业医师，执业药师，健康管理师，育婴师，药士，初中级药师，主管药师，护士资格证，中药调剂员等资质，图片不大于2M,格式为jpg</p>
            <dl>
                <dt>
					<span class="see-example">查看范例</span>
                    <div class="example-img"><img src="${base}/web/img/health-photo02.jpg" alt="" width="320" height="209"/></div>
				</dt>
                <dd>
                    <div class="click-w">
                        <input unselectable="on" type="file" name="leaderImage1"/>
                        <span>点此上传</span>
                        <div class="health-close"></div>
                    </div>
                    <div class="click-w">
                        <input unselectable="on" type="file" name="leaderImage2"/>
                        <span>点此上传</span>
                        <div class="health-close"></div>
                    </div>
                    <div class="click-w">
                        <input unselectable="on" type="file" name="leaderImage3"/>
                        <span>点此上传</span>
                        <div class="health-close"></div>
                    </div>
                    <div class="click-w">
                        <input unselectable="on" type="file" name="leaderImage4"/>
                        <span>点此上传</span>
                        <div class="health-close"></div>
                    </div>
                    <div class="click-w">
                        <input unselectable="on" type="file" name="leaderImage5"/>
                        <span>点此上传</span>
                        <div class="health-close"></div>
                    </div>
                </dd>
            </dl>
            <p>上传您的身份证正面：  图片不大于2M,格式为jpg</p>
            <dl>
                <dt>
					<span class="see-example">查看范例</span>
                    <div class="example-img"><img src="${base}/web/img/health-photo03.jpg" alt="" width="320" height="209"/></div>
				</dt>
                <dd>
                    <div class="click-w">
                        <input unselectable="on" type="file"  name="cardFirst"/>
                        <span>点此上传</span>
                        <div class="health-close"></div>
                    </div>
                </dd>
            </dl>
            <p>上传您的身份证反面：  图片不大于2M,格式为jpg</p>
            <dl>
                <dt>
					<span class="see-example">查看范例</span>
                    <div class="example-img"><img src="${base}/web/img/health-photo04.jpg" alt="" width="320" height="209"/></div>
				</dt>
                <dd>
                    <div class="click-w">
                        <input unselectable="on" type="file" name="cardTwo"/>
                        <span>点此上传</span>
                        <div class="health-close"></div>
                    </div>
                </dd>
            </dl>
        </div>
        <div class="apply-declare"><input type="checkbox" name="checked" checked="checked"/><b>我已同意并阅读</b><a target="_blank" href="http://cms.111yao.com/helps/health-leaders/agreement/">《健康领秀活动相关声明》</a></div>
        <div class="apply-submit"><input type="button" id="subBtn" value="提交申请"/></div>
    </div>
</div>
</form>


<div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
</body>
</html>