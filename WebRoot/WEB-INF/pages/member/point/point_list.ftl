<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的积分</title>
     <#include "/WEB-INF/pages/inc/taglibs.ftl">
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
    <script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${base}/web/js/member.js"></script>
    <!--[if IE 6]>
    <script src="${base}/web/js/png.js"></script>
    <script>
        PNG.fix('*');
    </script>
    <![endif]-->
     <style>
        .jf-tab{margin-left:20px;}
        .jf-tab td{line-height:60px; border-bottom:1px solid #d7d7d7;}
        .blue-font{color:#3c94e7; font-weight: bold;}
        .red-font{color:#e77470;}
        .weight-font{font-weight:bold;}
        .current{display: block;}
        .state-list{position: relative;float:left;  margin:10px 20px 0;}
        .state-list .select-box{ _width:150px;}
        .select-order{ position: absolute; top:10px;; right:0; }
        .select-order span{float:left; display: inline-block; cursor: pointer; margin-right:10px; width:60px; height:28px; line-height:28px; text-align: center;}
        .select-order span.current{background: #19a69f; border-radius:5px; color:#FFF;}
        .list-con .select-cur{display: block;}
    </style>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<form id="form1" name="form1" action="${base}/member/point!pointList.action" method="post">
<input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(0)}" id="p_curPage">
<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(10)}" id="pageSize">	
<input type="hidden" name="pointType" value="${pointType?default(1)}" id="pointType">
<input type="hidden" name="timeType" value="${timeType?default(1)}" id="timeType">
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content">
            <div class="member-con-center">
                <div class="member-center-top">
                    <div class="center-top-head">
                        <div class="head-img"><img src="<#if member.headPortrait?exists && member.headPortrait?has_content>${base}${member.headPortrait?default('')}<#else>${ui1}/static/image/temp/20160127/73569e0fe07f5e60234179baddec94eb.jpg</#if>" alt=""/></div>
                    </div>
                    <div class="center-top-txt">
                        <h3><#if nickname?exists && nickname?has_content>${nickname}<#else>${member.userName}</#if></h3>
                    </div>
                    <div class="center-top-card">
                        <div class="card"><!--<img src="${base}/web/images/member-center/member-card01.png" alt=""/>--></div>
                        <div class="integral">
                            <div class="num"><em id="member_point">${member.integral?default(0)}</em><b>积分</b></div>
                            <div class="txt">
                                <ul>
                                    <li>
                                        <p>积分可用于兑换优惠券 </p>
                                        <a href="/member/point!rule.action">获取积分</a>
                                    </li>
                                    <li>
                                        <p>距离下一等级还差<b>${nextGrade.consumePrice?default(0) - member.accumulateIntegral?default(0)}</b>积分</p>
                                        <div class="bar gradient stripe color3"><span></span></div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="member-my-integral">
                        <div class="member-refund-line line-mar"></div>
                         <div class="info">
		                	<span val="1" onclick="changeCouponPoint(1)" <#if type == "1">style="cursor: pointer; color: #19a69f;border-bottom:2px solid #19a69f;"<#else>style="cursor: pointer;" </#if>>积分兑换优惠券</span>
		                	<span val="2" onclick="changeCouponPoint(2)" <#if type == "2">style="cursor: pointer; color: #19a69f;border-bottom:2px solid #19a69f;"<#else>style="cursor: pointer;" </#if>>积分兑换记录</span>
		                </div>
                      <div class="list-con" style="position: relative;">
                                 <div class="state-list">
                                     <select class="select-box" id="timeType_s" name ="timeType_s" onchange="changeTimeType()">
                                         <option value="1" <#if timeType == '1'>selected="selected"</#if>>1个月内记录</option>
                                         <option value="2" <#if timeType == '2'>selected="selected"</#if>>3个月内记录</option>
                                         <option value="3" <#if timeType == '3'>selected="selected"</#if>>半年内记录</option>
                                         <option value="4" <#if timeType == '4'>selected="selected"</#if>>更多记录</option>
                                     </select>
                                 </div>
                                 <div class="select-order"><span  <#if pointType == '1'>class="current"</#if> onclick="chengePointType(1)">线上积分</span><span <#if pointType == '2'>class="current"</#if> onclick="chengePointType(2)">门店积分</span></div>
                                 <div class="list-order-sel">
                                     <div class="select-content select-cur">
                                         <table width="950" border="0" cellpadding="0" cellspacing="0" class="jf-tab">
                                             <tr>
                                                 <td align="center" valign="middle" height="60">来源/用途</td>
                                                 <td align="center" valign="middle" height="60">积分变化</td>
                                                 <td align="center" valign="middle" height="60">日期</td>
                                                 <td align="center" valign="middle" height="60">备注</td>
                                             </tr>
                                             <#if pw.result?has_content>
						                        <#list pw.result?if_exists as resc>
							                        <tr>
	                                                 <td align="center" valign="middle" height="60" >${resc.remark?default('')}</td>
	                                                 
	                                                    <#if resc.pointSource == '1'>
	                                                       <td align="center" valign="middle" height="60" class="red-font">
	                                                        +${resc.integral?default('')}
	                                                        </td>
	                                                     <#else>
	                                                      <td align="center" valign="middle" height="60" style="color: #3c94e7;">${resc.integral?default('')}</td>
	                                                     </#if>
	                                                 <td align="center" valign="middle" height="60" >${resc.createDate?default(0)}</td>
	                                                 <td align="center" valign="middle" height="60" >
	                                                     <#if resc.pointSource == '1'>
	                                                         	交易获得
	                                                     <#else>
	                                                                                                                                                               交易使用
	                                                     </#if>
	                                                 
	                                                 </td>
	                                                 
	                                             </tr>
						                        </#list>
						                        </#if>
                                         </table>
                                     </div>
                                 </div>
                             </div>
                         </div>
                    </div>
                </div>
                <!--分页开始-->
	            <#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
	            <!--分页结束-->
            </div>
            
<div class="user_center_footer" style="float:left; "><#include "/static/inc/version2.2.0/footer.ftl">
       <style>.autocomplete_ui {width:170px;}.autocomplete_ui span {width:165px;}</style>
    </div>
        </div>
    </div>
</div>
</form>
</body>
</html>
<script type="text/javascript" >
function changeCouponPoint(type){
   if(type==1){
      window.location.href="${base}/member/point.action";
   }else{
      window.location.href="${base}/member/point!pointList.action";
   }
}

function querySubmit(){
  $("#form1").submit();
}
//更改积分类型
function chengePointType(pointType){
    $("#pointType").val(pointType);
    $("#p_curPage").val(1);
    $("#pageSize").val(10);
    querySubmit();
}
function changeTimeType(){
    $("#p_curPage").val(1);
    $("#pageSize").val(10);
   $("#timeType").val($("#timeType_s").val());
   querySubmit();
}
</script>

<script type="text/javascript">
$().ready(function() {
//异步刷新会员积分
$.ajax({
	url : "${base}/member/profile!ajaxMemberInfo.action",
	type : "post",
	datatype:"json",
	success : function(data) {
		if (data != null) { 
		     $("#member_point").html(data.integral);
		}
	},
	error : function() {}
});

});      
</script>
