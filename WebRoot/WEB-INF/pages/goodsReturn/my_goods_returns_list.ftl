<!DOCTYPE html>
<html>
<#include "/WEB-INF/pages/inc/taglibs.ftl">
<head>
    <title>退款退货</title>
    
	<style type="text/css">
		.page-box{
			float:right;
		}
	</style>
    
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
	<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
		
<form id="subForm" name="form1" method="post" action="${base}/member/return!myReturns.action">
                    
<div class="member-line" style="border-top:2px solid #00aaa0">
    <div class="member-wrap">
        <!-------左侧------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content refund">
            <h2>退货换货</h2>
            <div class="member-refund">
            	<div class="member-refund-line"></div>
                <div class="info" id="choose-info"><span>退款/退换货记录</span><!--<span>退款明细</span>--></div>
                <div class="list" id="choose-list list">
                    <div class="list-con current">
                         <div class="state">
                             <div class="state-list">
                                 <select class="selete-box" name="status" id="searchStatus" style="width:92px;">
                                     <option value="">全部状态</option>
                                     <option value="auditing" <#if orderStatus?exists && orderStatus=="auditing">selected = "selected"</#if>>审核中</option>
                                     <option value="nopass" <#if orderStatus?exists && orderStatus=="nopass">selected = "selected"</#if>>审核不通过</option>
                                     <option value="ing" <#if orderStatus?exists && orderStatus=="ing">selected = "selected"</#if>>处理中</option>
                                     <option value="finish" <#if orderStatus?exists && orderStatus=="finish">selected = "selected"</#if>>结束</option>
                                 </select>
                             </div>
                             <div class="search111" style="float: right">
                                 <input type="text"
                                 	<#if orderSn?exists&&orderSn?default('')!=''>value="${orderSn?default('')}"<#else> id="key" value="请输入订单编号..." </#if>
                                  name="orderSn"  class="input-text"/>
                                 <input class="input-btn" type="button" id="searchBtn" value="搜索">
                                 <#--<input type="button" value="搜索" id="searchBtn" class="btn"/>-->
                             </div>
                         </div>
                         <div class="table-wrap">
                             <table width="950" border="0" cellpadding="0" cellspacing="0">
                                 <tr class="tab-top">
                                     <td align="left" valign="middle" height="40" width="15%">退款/退换货编号</td>
                                     <td align="left" valign="middle" height="40" width="15%">订单编号</td>
                                     <td align="left" valign="middle" height="40" width="20%">商品名称</td>
                                     <td align="left" valign="middle" height="40" width="15%">申请时间</td>
                                     <td align="left" valign="middle" height="40" width="15%">状态</td>
                                     <td align="left" valign="middle" height="40" width="20%">操作</td>
                                 </tr>
                                 	<#if pw.result?size lte 0>
                                 		<tr>
											<td colspan="4" align="left" valign="middle" height="40">
												<div class="text"><p>暂无退款/退换货申请记录</p></div>
											</td>
										</tr>
                                 	</#if>
                                 <#list pw.result as tReturn>
									<tr>
										<td align="left" valign="middle" height="40" class="cor-b">${tReturn.orderSn?if_exists}</td>
										<td align="left" valign="middle" height="40" class="cor-b">${tReturn.oldOrderSn?if_exists}</td>
										<td align="left" valign="middle" height="40">${tReturn.goodsName?if_exists}</td>
										<td align="left" valign="middle" height="40">${tReturn.createTime?if_exists?string("yyyy-MM-dd HH:mm:ss")}</td>
										<td align="left" valign="middle" height="40">
											<#if tReturn.orderStatus?exists && tReturn.orderStatus==0>
												审核中
											<#elseif tReturn.orderStatus?exists && tReturn.orderStatus==1>
												审核中
											<#elseif tReturn.orderStatus?exists && tReturn.orderStatus==2>
												审核不通过
											<#elseif tReturn.orderStatus?exists && tReturn.orderStatus==3>
												审核中
											<#elseif tReturn.orderStatus?exists && tReturn.orderStatus==4>
												审核不通过
											<#elseif tReturn.orderStatus?exists && tReturn.orderStatus==5>
												处理中
											<#elseif tReturn.orderStatus?exists && tReturn.orderStatus==6>
												处理中
											<#elseif tReturn.orderStatus?exists && tReturn.orderStatus==7>
												处理中
											<#elseif tReturn.orderStatus?exists && tReturn.orderStatus==8>
												处理中
											<#elseif tReturn.orderStatus?exists && tReturn.orderStatus==9>
												结束
											<#else>
												状态有误
											</#if>
										</td>
										<td align="left" valign="middle" height="40">
											<div>
												<a href="javascript:void(0)" style="color:#3c94e7;" onclick="detailReturn(${tReturn.id?if_exists})">查看详情</a>
											</div>
										</td>
									</tr>
								</#list>
                             </table>
                         </div>
                     </div>
                </div>
            </div>
            <!--分页开始-->
	            <#--<#include "/WEB-INF/pages/inc/pagination.ftl">-->
	            <#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
            <!--分页结束-->
            <!-- 退款/退货弹窗开始-->
            <!-- 退款/退货弹窗结束-->
        </div>
    </div>
    <input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(1)}" id="p_curPage">
	<input type="hidden" name="rs.p_pageSize" value="5" id="pageSize">
            
    <div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
    
</div>
</form>
<div id="shade"></div>
<script type="text/javascript" src="${base}/web/js/return_list.js"></script>
<script type="text/javascript">
var title = "请输入订单编号...";
$("#key").focus(function(){
    	if(title == $(this).val()){
			$(this).val("");    	
    	}
    });
</script>
</body>

</html>