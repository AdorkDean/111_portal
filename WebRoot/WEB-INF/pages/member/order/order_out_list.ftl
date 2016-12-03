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
    <title>我的订单</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="${base}/img/favicon.png">


    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="${base}/web/img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <link href="${base}/web/css/commonNew.css" rel="stylesheet" type="text/css" />
    <link href="${base}/web/css/iconfont.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
    <script type="text/javascript" src="${base}/web/js/jquery.min.js"></script>
    <script type="text/javascript" src="${base}/web/js/member.js"></script>
    <style type="text/css">
        .select-order{position: absolute; top:17px;; left:100px; }
        .select-order a{float:left; display: inline-block; margin-right:10px; width:60px; height:28px; line-height:28px; text-align: center;}
        .select-order a.current{background: #19a69f; border-radius:5px; color:#FFF;}
        .jf-tab td{line-height:60px; border-bottom:1px solid #d7d7d7;}
        .blue-font{color:#3c94e7;}
        .red-font{color:#e77470;}
        .weight-font{font-weight:bold;}
        .list-con{display: none;}
        .current{display: block;}
        .weight-blue-font{color:#3c94e7;font-weight:bold;}
        .weight-red-font{color:#e77470;font-weight:bold;}
        .list-order .select-order-list{display: none;}
        .list-order .current{display: block;}
    </style>
</head>
<body style="height:100%;">
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<div class="member-line">
    <div class="member-wrap" style="overflow: visible;">
        <!-------左侧------->
 <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content refund" style="position: relative;">
        <form name="form1" action="${base}/member/orderlist!getOutOrderList.action" method="post" >
      <input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default()}" id="p_curPage">
		<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(10)}" id="pageSize">
		</form>
            <h2>我的订单</h2><div class="select-order"><a href="${base}/member/center!getOrderList.action">线上订单</a><a href="${base}/member/orderlist!getOutOrderList.action" class="current">门店订单</a></div>
            <div class="list-order">
                <div class="select-order-list current">
                    <div class="member-refund">
                        <div class="list">
                            <div class="list-con current">
                                <div class="table-wrap">
                                    <table width="950" border="0" cellpadding="0" cellspacing="0" class="jf-tab">
                                        <tr>
                                            <td align="center" valign="middle" height="60">订单编号</td>
                                            <td align="center" valign="middle" height="60">订单金额(元)</td>
                                            <td align="center" valign="middle" height="60">订单时间</td>
                                            <td align="center" valign="middle" height="60">订单状态</td>
                                            <td align="center" valign="middle" height="60">操作</td>
                                        </tr>
                                        <#list result.list?if_exists as resc>
                                        <tr>
                                            <td align="center" valign="middle" height="60" class="weight-blue-font">${resc.orderSn?default('')}</td>
                                            <td align="center" valign="middle" height="60" class="weight-red-font">${resc.orderAmount?default('0.00')}</td>
                                            <td align="center" valign="middle" height="60" class="weight-font">${resc.accdate?default('')}</td>
                                            <td align="center" valign="middle" height="60" class="red-font">${resc.orderStatus?default('')}</td>
                                            <td align="center" valign="middle" height="60" class="blue-font"><a href="${base}/storeOrder/storeOrder!storeOrderInfo.action?orderSn=${resc.orderSn?default('')}">查看详情</a></td>
                                        </tr>
                                        </#list>
                                    </table>

                                </div>

                            </div>
                            <!--分页开始-->
		            <#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
		            <!--分页结束-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div style="float:left;width:100%;">
<#include "/static/inc/version2.2.0/footer.ftl">
<style>.autocomplete_ui {width:170px;}.autocomplete_ui span {width:165px;}</style>
</div>
</body>
</html>