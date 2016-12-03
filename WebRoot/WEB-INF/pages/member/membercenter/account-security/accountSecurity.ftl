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
    <title>账户安全</title>
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
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/common.css">
    <link rel="stylesheet" type="text/css" href="${base}/web/version2.2.0/css/member.css">
    <script type="text/javascript" src="${base}/web/js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css">
	<link rel="stylesheet" type="text/css" href="${base}/web/css/jquery-ui.css">
	<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
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
	<#include "/WEB-INF/pages/member/left-menu.ftl">
    <!-- 右侧内容开始-->
    <div class="member-main-right">
        <div class="m-site order-site"><a href="/member/index!getCenterIndex.action">用户中心</a>　>　<span>账户安全</span></div>
        <div class="personal-data">
            <ul class="data-nav">
                <li class="current"><a href="#"><span></span></a></li>
            </ul>
            <div class="data-line"></div>
        </div>
        <!-- 账户安全开始-->
        <div class="grade-content clearfix">
            <p>您的评分安全</p>
            <span><em style="border-radius:20px;width:${grade?default('30')}%; <#if grade?exists && grade==65>background:#41ffff;</#if><#if grade?exists && grade==100>background:#87FF41;</#if> "></em></span>
            <b><#if grade?exists && grade==65>中<#elseif grade?exists && grade==100>高<#elseif grade?exists && grade==30>低</#if></b>
        </div>
        <ul class="grade-list">
            <li>
                <span>登录密码</span>
                <p>定期修改帐号密码，确保帐号安全</p>
                <a href="#" id="btn_update">修改</a>
            </li>
            <li>
                <span>邮箱验证</span>
                <#if isEmailCheck?exists && isEmailCheck == true>
	                <p>您验证的邮箱：${email}</p>
	                <a href="/member/memberCenter!toEmailUpdateValidate.action">修改</a>
                <#else>
	                <p>为保障帐号安全，请绑定邮箱</p>
	                <a href="/member/memberCenter!toEmailBindValidate.action">绑定</a>
                </#if>
            </li>
            <li>
                <span>手机验证</span>
                <#if isMobileCheck?exists && isMobileCheck == true>
	                <p>您验证的手机号码：${mobile}，若已丢失或停用，请立即更换</p>
	                <a href="/member/memberCenter!toMobileUpdateValidate.action">修改</a>
                <#else>
	                <p>为保障帐号安全，请绑定手机</p>
	                <a href="/member/memberCenter!toMobileBindValidate.action">绑定</a>
                </#if>
            </li>
            <li>
                <span>账单邮箱</span>
                <input type="text" id="billEmail" name="billEmail" <#if billEmail?exists && billEmail != ''>disabled</#if> value="${billEmail?default('')}"/>
                <p>用于接收您的账单消息</p>
	            <a id="a_update" href="javascript:return 0;" <#if billEmail?exists && billEmail != ''>style="display:inline;"<#else>style="display:none;"</#if> onclick="updateBillEmail()">修改</a>
                <a id="a_save" href="javascript:return 0;" <#if billEmail?exists && billEmail != ''>style="display:none;"</#if> onclick="saveBillEmail()">保存</a>
            </li>
        </ul>
        <!--账户安全提示开始 -->
         <div class="safe-prompt">
             <div class="safe-prompt-info"><span>安全服务提示</span></div>
             <p>1.确认您登录的是111医药馆网址 <a href="#"> http://www.111yao.com </a>注意防范进入钓鱼网站，不要轻信各种即时通讯工具发送的商品或支付链接，谨防网购诈骗。</p>
             <p>2.建议您安装杀毒软件，并定期更新操作系统等软件补丁，确保账户及交易安全。</p>
         </div>
        <!--账户安全提示开始 -->
        <!-- 账户安全结束-->
    </div>
    <!-- 右侧内容结束-->
</div>
<!--内容结束-->
<div class="user_center_footer" style="float:left;"><#include "/static/inc/version2.2.0/footer.ftl"></div>
<!--js-->
<script type="text/javascript" src="${base}/web/js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css">
<link rel="stylesheet" type="text/css" href="${base}/web/css/jquery-ui.css">
<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>

<script>
	$("#btn_update").click(function(){
		window.location.href="${base}/member/memberCenter!toPasswordValidate.action";
	});
	
	function saveBillEmail(){
		if(checkEmail()){
			$.ajax({
				url: "${base}/member/memberCenter!billEmailSave.action",
				data:{billEmail:$("#billEmail").val()},
				type:"post",
				async:false,
				cache:false,
				success: function(data) {
					if(data == 1){
						$alertCanDisplay("success","账单邮箱保存成功","友情提示",null);
						$("#billEmail").attr('disabled',true);
						$("#a_update").show();
						$("#a_save").hide();
					}else{
						$alertCanDisplay("warn","账单邮箱保存失败,请重新尝试","友情提示",null);
					}
				}
			 });
		}
	}
	
	function checkEmail(){
		var email = $("#billEmail").val();
		if(!email){
			$alertCanDisplay("warn","请输入账单邮箱","友情提示",null);
			$("#billEmail").focus();
			return false;
		}
		
		if (email.replace(/[^\x00-\xff]/g, "**").length > 50) {
			$alertCanDisplay("warn","邮箱只能在50个字符以内","友情提示",null);
			$("#billEmail").focus();
			return false;
		}
		var reg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
		if (email.replace(/[^\x00-\xff]/g, "**").length <= 4 || !reg.test(email)) {
			$alertCanDisplay("warn","邮箱格式不正确","友情提示",null);
			$("#billEmail").focus();
			return false;
		}
		return true;
	}
	
	
	function updateBillEmail(){
		$("#billEmail").attr('disabled',false);
		$("#billEmail").focus();
		$("#a_update").hide();
		$("#a_save").show();
	}
</script>
</body>
</html>