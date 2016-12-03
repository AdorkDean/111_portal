<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="111医药馆网上药店是国家药监局认证指定网上药房|打造为老百姓服务药品价格低品种全|网上购药买药就选壹壹壹医药馆药品特卖网站">
    <meta name="keywords" content="壹壹壹医药馆|壹药馆|11医药馆|1药馆|医卡通|111医药馆|医药网|药品特卖网站">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>健康领秀</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="images/common/favicon.png">
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/common/favicon.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="images/common/favicon.png">
    <meta name="msapplication-TileImage" content="images/common/favicon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
</head>
<body class="health-bc">
<#include "/static/inc/version2.2.0/new_leader_header.ftl" />
<script>$("#leader_navicator li").eq(0).addClass("cur");</script>

<!--提现开始-->
<div class="my-pharmacy-page w1000 extract-padding" style="margin-top:25px;">
<#if result.get(0)?exists && (result.get(0)?size > 0)>
    <h2 class="article-page-top">解绑提现账号</h2>
    <div class="extract-content">
        <h4 class="extract-title">解绑账号：</h4>
        <ul class="extract-list">
         <#list result.get(0)?if_exists as resc>
            <li class="clearfix">
                <input type="radio" name="checkAmount" id="checkAmount" value="${resc.id?default(0)}" checked="checked"/>
                <#if resc.bank_name?exists && resc.bank_name?string !="">
                <img src="${base}/web/version2.2.0/images/health/health_bank.png" alt=""/>
                <#else>
                <img src="${base}/web/version2.2.0/images/health/health_zfb.png" alt=""/>
                </#if>
                <span><#if resc.bank_name?exists && resc.bank_name?string !="">${resc.bank_name?default("")}</#if>&nbsp;&nbsp;&nbsp;账号：${resc.account_number?default("")}</span>
                <a href="#"></a>
            </li>
         </#list>
        </ul>
    </div>
    <dl class="extract-binding relieve-binding">
        <dt>手机验证码：</dt>
        <dd>
            <input type="text" id="mobileCode" class="extract-binding-text" value="请输入手机验证码" onfocus="javascript:if(this.value=='请输入手机验证码'){ this.value='';this.style.color='#222';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='请输入手机验证码';this.style.color='#d7d7d7';this.style.border='1px solid #d7d7d7'}"/>
            <span class="iphone-code" id="getCode">获取</span>
        </dd>
    </dl>
    <div class="extract-hint relieve--hint">
        <p>系统会根据您帐号绑定的领秀手机号发送验证码</p>
    </div>
    <div class="extract-button">
            <input type="button" value="确  认"  onclick="doit()"/>
    </div>
</div>
 	<#else>
    
    </#if>
<!--提现结束-->

<div style="margin-top:20px;"><#include "/static/inc/version2.2.0/new_leader_footer.ftl"/></div>
<!--js-->
<script type="text/javascript">
    var getCode = document.getElementById("getCode");
    var timer = null;
    var count = 60;
    function timeDesc() {
        if (count > 0) {
            count--;
            getCode.innerHTML = count + "S";
            getCode.style.background = "#f3f5f7";
        } else {
            getCode.innerHTML = "重发";
            getCode.style.background = "#fe4310";
            getCode.style.color="#FFFFFF";
            count = 60;
            window.clearInterval(timer);
            timer = "";
        }
    }
    	var $mobileCode = $("#mobileCode");
    	
	    $("#getCode").click(function(){
	    		var	amount=$("input[name='checkAmount']:checked").val();
				if(amount==null || $.trim(amount) == ""){
					$alert("warn","请选择账号！","友情提示",null);
					return false;
				}
				var mobile=  '${mobile?default('')}';
				if(count == 60){
					$.ajax({
							url: "${base}/member/bindingAmount!validateMobileCode.action",
							data:{
								mobile:$.trim(mobile),
							    },
							type:"post",
							async:false,
							cache:false,
							success: function(data) {
								if(data==0){//发送成功
									timer = window.setInterval("timeDesc()", 1000);
								}else{
									$alert("warn","网络异常！","友情提示",null);
								}
							}
					});
				}
			});
	function doit(){
	    		var	amountId=$("input[name='checkAmount']:checked").val();
				if(amountId==null || $.trim(amountId) == ""){
					$alert("warn","请选择账号！","友情提示",null);
					return false;
				}
				if($mobileCode.val()==null || $.trim($mobileCode.val()) == "" || $mobileCode.val()=="请输入手机验证码"){
					$alert("warn","验证码不能为空！","友情提示",null);
					return false;
				}
				$.ajax({
							url: "${base}/member/bindingAmount!unbinding.action",
							data:{
								numberAmountId:amountId,
								mobileCode:$mobileCode.val(),
							    },
							type:"post",
							async:false,
							cache:false,
							success: function(data) {
								if(data==0){//解除绑定成功
									$alert("warn","您已成功解除该绑定账号！","友情提示",null);
									location.href = "${base}/leaderarticle/leaderarticle!index.action";
								}else{
									$alert("warn","验证码错误！","友情提示",null);
								}
							}
				});
	}
  
</script>
</body>
</html>