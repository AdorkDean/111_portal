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
<#include "/static/inc/version2.2.0/new_leader_header.ftl"/>
<script src="/web/js/My97DatePicker/WdatePicker.js" type="text/javascript" language="javascript" ></script>
<script>$("#leader_navicator li").eq(3).addClass("cur");</script>

<div class="my-pharmacy-page w1000" style="margin-top:25px;padding-bottom:20px;">
    <div class="personal-data">
        <ul class="data-nav">
            <li><a href="/leaderarticle/leaderarticle!myLeaderFans.action"><span>我的秀粉</span></a></li>
            <li class="current"><a href="/member/bindingAmount!presentRecordList.action"><span>提现记录</span></a></li>
            <li><a href="/member/bindingAmount!proceedsDetailList.action"><span>收益明细</span></a></li>
            <li><a href="/leaderarticle/leaderarticle!leaderIdentity.action"><span>身份认证</span></a></li>
            <li><a href="/leaderarticle/leaderarticle!leaderFunctionIntroduce.action"><span>特色功能</span></a></li>
        </ul>
        <div class="data-line"></div>
    </div>
    <form name="form1" id="form1"  action="${base}/member/bindingAmount!presentRecordList.action" method="post">
        <input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(0)}" id="p_curPage">
		<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(10)}" id="pageSize">
    <div class="record-search">
        <input type="text" value="${startDate?default('')}" placeholder="开始时间" name="startDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})"/>
        <span>—</span>
        <input type="text" value="${endDate?default('')}" placeholder="结束时间" name="endDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})"  />
        <input type="button" value="筛选" class="record-search-btn" onclick="submitForm()"/>
    </div>
   </form> 
    <div class="record-info">
        <ul>
            <li>创建日期</li>
            <li>流水号</li>
            <li>提现(元)</li>
            <li>提现方式</li>
            <li>备注</li>
            <li>说明</li>
        </ul>
    </div>
    <#if pw.result?size != 0>
     <#list pw.result?if_exists as resc>
		    <ul class="record-list">
				        <li>
				            <span><#if resc.out_time?exists>${resc.out_time?string('yyyy-MM-dd')}</#if></span>
				            <span>${resc.serial_number?default('')}</span>
				            <span>${resc.amount?default(0)}</span>
				            <span><#if resc.out_type?default(0)==1>支付宝<#elseif resc.out_type?default(0)==2>银行卡</#if></span>
				            <span><#if resc.status?default(0)==1>申请提现<#elseif resc.status?default(0)==2>提现中<#elseif resc.status?default(0)==3>提现完成<#elseif resc.status?default(0)==4>审核驳回</#if></span>
				            <span class="health-explain">${resc.remark?default('')}</span>
				        </li>
		    </ul>
		  </#list>
    <!--分页开始-->
     <#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
    <!--分页结束-->
   </#if>
    <#if pw.result?size == 0>
    	<div class="health-default">
        	<p class="default-shopping">您还没有收益记录哦~~</p>
    	</div>
    </#if>
</div>

<div style="margin-top:20px;"><#include "/static/inc/version2.2.0/new_leader_footer.ftl"/></div>
<script>
	function submitForm(){
	 	$("#form1").submit();
	}
</script>
</body>
</html>