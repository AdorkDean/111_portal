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

<form name="form1" id="form1"  action="${base}/member/bindingAmount_st!drawingProceeds.action" method="post" style="margin-top:25px;">
<@ww.token/>
<div class="my-pharmacy-page w1000 extract-padding">
    <h2 class="article-page-top">提取收益到您的账户 <span class="font-color">可提取收益：<b>${account.remainingAmount?default(0)}</b>元</span><span>未到账收益：<b>${account.waitAmount?default(0)}</b>元</span><a href="${base}/member/bindingAmount!bindingAmountIndex.action" class="add-shop-btn">添加账号</a><a href="${base}/member/bindingAmount!presentRecordList.action" class="detail-btn">提现记录</a></h2>
    <#if result.get(0)?exists && (result.get(0)?size > 0)>
    <div class="extract-content">
        <h4 class="extract-title">选择账号：</h4>
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
                <a href="${base}/member/bindingAmount!unbindingIndex.action">解绑账号</a>
            </li>
         </#list>
        </ul>
    </div>
    <div class="extract-content">
        <h4 class="extract-title">输入提现金额：</h4>
        <div class="extract-list">
            <input type="text" id="tqAmount" name="tqAmount" class="extract-list-text" onfocus="javascript:if(this.value==''){ this.value='';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='';this.style.border='1px solid #d7d7d7'}"/> 元
        </div>
    </div>
    <div class="extract-button">
            <input type="button" value="确  认" onclick="doit()"/>
    </div>
    <#else>
    
    </#if>
</div>
</form>

<div style="margin-top:20px;"><#include "/static/inc/version2.2.0/new_leader_footer.ftl"/></div>


<!--提现结束-->
<script type="text/javascript">
   
   		var $tqAmount = $("#tqAmount");
    	var $ktqAmount = "${account.remainingAmount?default(0)}";
    	
	function doit(){
	    		var	amount=$("input[name='checkAmount']:checked").val();
	    		if(amount==null || $.trim(amount) == ""){
					$alert("warn","请选择账号！","友情提示",null);
					return false;
				}
				if($tqAmount.val()==null || $.trim($tqAmount.val()) == ""){
					$alert("warn","请输入提现金额！","友情提示",null);
					return false;
				}
				if(parseFloat($tqAmount.val()) >parseFloat($ktqAmount)){
					$alert("warn","提现金额大于可用收益！","友情提示",null);
					return false;
				}
				if(parseFloat($tqAmount.val()) <10){
					$alert("warn","提现最小金额为10元！","友情提示",null);
					return false;
				}
				$alert("warn","您已成功申请提现，请等待审核！","友情提示",null);
				setTimeout(function()
						{
							$('#form1').submit();
						}, 1500);
	}
  
</script>
<!--js-->
</body>
</html>