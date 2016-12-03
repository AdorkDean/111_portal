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
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<form id="inputForm" name="form1" action="${base}/member/point.action" method="post" >
<input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(0)}" id="p_curPage">
<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(10)}" id="pageSize">
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
                                        <p>积分可用于兑换优惠券</p>
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
                        <#if pw.result?has_content>
                        <div class="content">
                            <ul>
                            	<#list pw.result?if_exists as resc>
                                <li>
                                    <div class="pic">
                                        <span>${resc.name?default('')} <b>优惠券</b></span>
                                        <div class="pic-hide"><p>${resc.instro?default('')}<br/>有限期：${resc.endTime?string('yyyy-MM-dd')}</p><div class="pic-hide-bg"></div></div>
                                    </div>
                                    <div class="num">
                                        <div class="txt">
                                            <p><b>${resc.exchangeCount?default(0)}</b>积分</p>
                                        </div>
                                        <div class="btn"><a href="#" class="exchange" val="${resc.id}">兑换</a></div>
                                    </div>
                                </li>
                                </#list>
                            </ul>
                        </div>
                        </#if>
                </div>
            </div>
            <!--分页开始-->
            <#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
            <!--分页结束-->
        </div>
    </div>
<div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
</div>
</form>
</body>
</html>
<script type="text/javascript" >
$(document).ready( function() {
    var delay = 0;
    $('.bar').children('span').each( function() {
        var num = ${member.accumulateIntegral?default(0)}/<#if nextGrade?has_content >${nextGrade.consumePrice}<#else>${member.accumulateIntegral?default(0)}</#if>;
        $(this)
            .width(0)
            .delay(delay)
            .animate({
                'width': (num*100)+'%'
            }, 3000);
        delay += 1500;
    });
    
    $(".exchange").click(function(){
    
    	var def = $(this);
    	$confirm("warn","是否兑换?","系统提示",function(tag){
			if(tag){
				$.ajax({
		            type: "post",
		            cache: false,
		            dataType:"json",
		            url: "${base}/member/point!exchange.action",
		            data:{id:def.attr("val")},	            
		            success: function(data, textStatus){
		            	if(data){
			            	$alert("success","兑换成功","友情提示",null);
			            	setTimeout("reload()",3000);
		            	}else{
		            		$alert("warn","兑换失败","友情提示",null);
		            	}
		            }
		        });
			}
		});
	    
    });
});

function reload(){
	window.location.reload();
}

function changeCouponPoint(type){
   if(type==1){
      window.location.href="${base}/member/point.action";
   }else{
      window.location.href="${base}/member/point!pointList.action";
   }
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