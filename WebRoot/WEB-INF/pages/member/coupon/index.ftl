<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/png" href="/web/img/favicon.png">
    <title>我的优惠券</title>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
    <script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
    <!--[if IE 6]>
    <script src="${base}/web/js/png.js"></script>
    <script>
        PNG.fix('*');
    </script>
    <![endif]-->
    <title>我的优惠券</title>
    <style>
        .discount-coupon{width:990px; overflow: hidden; margin-left:20px; padding-top:9px;}
        .pre-position{position:relative; float:left; width:486px; margin-right:9px; margin-bottom:20px; height:130px; border-radius:8px;}
        .pink-bg{background: #ff7b9d;}
        .gray-bg{background: #c1c1c1;}
        .cp-bg{position: absolute; top:0; left:0; z-index: 8; width:486px; height:132px; background: url("${base}/web/images/discount_coupon_bg.png") no-repeat center center;}
        .cp-use{position: absolute; top:0; left:0; z-index: 7; width:486px; height:132px; background: url("${base}/web/images/cp_use.png") no-repeat center center;}
        .cp_past_due{position: absolute; top:0; left:0; z-index: 7; width:486px; height:132px; background: url("${base}/web/images/cp_past_due.png") no-repeat center center;}
        .cp-main-left{position: absolute; top:0; left:0;z-index: 9; width:276px; overflow: hidden;}
        .cp-main-left span{display: block; text-align: center; color:#FFF;}
        .cp-main-left span:nth-child(1){font-size:50px; font-weight:bold;}
        .cp-main-left span:nth-child(2){font-size:18px;}
        .cp-main-left span:nth-child(3){font-size:15px;}
        .cp-main-right{position: absolute; top:0; right:0; z-index: 9;width:208px; overflow: hidden;}
        .cp-main-right span{display: block; padding-left:20px; color:#FFF; font-size:16px;}
        .cp-main-right span:nth-child(1){margin-top:12px;}
        .cp-main-right span:nth-child(3){margin-top:13px;}
        .close-box{ display:none; position: absolute; top:0; right:0; z-index: 10; cursor: pointer; width:38px; height:38px; }
        .pink-bg .close-box{background: url("${base}/web/images/cp_close_pink.png") no-repeat;}
        .gray-bg .close-box{background: url("${base}/web/images/cp_close_gray.png") no-repeat;}
        .pre-position:hover .close-box{display:block;}
        .coupon-none{ width:1010px; height:230px;}
        .coupon-none img{width:200px; height:180px; margin: 70px auto 10px;}
        .coupon-none p{text-align: center; width:980px;}
        .member-main .info a {display: block;}
         .member-main .info a.current span{color: #19a69f;border-bottom: 2px solid #19a69f;}
       
    </style>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<form id="inputForm" name="form1" action="${base}/member/coupon.action?" method="post" >
<input type="hidden" name="rs.p_curPage" value="${rs.p_curPage?default(0)}" id="p_curPage">
<input type="hidden" name="rs.p_pageSize" value="${rs.p_pageSize?default(10)}" id="pageSize">
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content">
            <h2>我的优惠券</h2>
            <div class="member-main">
            	 <div class="member-refund-line line-mar"></div>
            	 <input type="hidden" name="type" value="${type?default('')}"/>
                <div class="info" id="choose-info-coupon">
                	<a href="${base}/member/coupon.action?type=1"><span <#if type == "1">class="current"</#if>>可使用（${countUse?default(0)}）</span></a>
                	<a href="${base}/member/coupon.action?type=2"><span <#if type == "2">class="current"</#if>>已使用（${countUsed?default(0)}）</span></a>
                	<a href="${base}/member/coupon.action?type=3"><span <#if type == "3">class="current"</#if>>已过期（${countTimeOUt?default(0)})</span></a>
                </div>
                <div class="list" id="choose-list-coupon">
                 <#if type == "1">
                    <div class="list-con current">
	                 <#if pw.result?has_content && type == "1">
					                   <ul class="discount-coupon">
			                    		<#list pw.result?if_exists as resc>
					                            <li class="pre-position pink-bg">
					                                <div class="cp-bg"></div>
					                                <div class="close-box" onclick="javascript:deleteCoupon('${resc.cardId?default(0)}','1')"></div>
					                                <div class="cp-main-left">
					                                    <span>￥${resc.dis_price?default('')}</span>
					                                    <span>${resc.name?default('')}</span>
					                                    <span>${resc.start_time?string('yyyy-MM-dd')}至${resc.end_time?string('yyyy-MM-dd')}</span>
					                                </div>
					                                <div class="cp-main-right">
					                                    <span>优惠券编码</span>
					                                    <span>${resc.card_no?default('')}</span>
					                                    <span>使用专区</span>
					                                    <span>${resc.useName?default('')}</span>
					                                </div>
					                            </li>
				                         </#list>  
					                   </ul>
					      <#else>
						       <div class="coupon-none">
		                        <img src="${base}/web/images//coupon_none.png" alt=""/>
		                        <p>您还没有可使用的优惠券哟~</p>
		                   	   </div>
	                     </#if> 	
                    </div> 
                  <#elseif type=="2">  
                    <div class="list-con current">
	                 <#if pw.result?has_content && type == "2">
					              <ul class="discount-coupon">
			                       	  <#list pw.result?if_exists as resc>
					                            <li class="pre-position gray-bg">
					                                <div class="cp-bg"></div>
					                                <div class="cp-main-left">
					                                    <span>￥${resc.dis_price?default('')}</span>
					                                    <span>${resc.name?default('')}</span>
					                                    <span>${resc.start_time?string('yyyy-MM-dd')}至${resc.end_time?string('yyyy-MM-dd')}</span>
					                                </div>
					                                <div class="cp-main-right">
					                                    <span>优惠券编码</span>
					                                    <span>${resc.card_no?default('')}</span>
					                                    <span>使用专区</span>
					                                    <span>${resc.useName?default('')}</span>
					                                </div>
					                            </li>
				                         </#list>  
					                   </ul>
					      <#else>
					      <div class="coupon-none current">
		                        <img src="${base}/web/images/coupon_none.png" alt=""/>
		                        <p>您还没有已使用的优惠券哟~</p>
		                   	   </div>
	                      </#if> 
                    </div>
                 <#else>   
                    <div class="list-con current">
	                  <#if pw.result?has_content && type == "3">
			                      <ul class="discount-coupon">
			                        <#list pw.result?if_exists as resc>
			                            <li class="pre-position gray-bg">
			                                <div class="cp-bg"></div>
			                                <div class="close-box" onclick="javascript:deleteCoupon('${resc.cardId?default(0)}','3')"></div>
			                                <div class="cp-main-left">
			                                    <span>￥${resc.dis_price?default('')}</span>
			                                    <span>${resc.name?default('')}</span>
			                                    <span>${resc.start_time?string('yyyy-MM-dd')}至${resc.end_time?string('yyyy-MM-dd')}</span>
			                                </div>
			                                <div class="cp-main-right">
			                                    <span>优惠券编码</span>
			                                    <span>${resc.card_no?default('')}</span>
			                                    <span>使用专区</span>
			                                    <span>${resc.useName?default('')}</span>
			                                </div>
			                            </li>
			                          </#list>  
			                        </ul>
			                <#else>
				                <div class="coupon-none">
			                        <img src="${base}/web/images/coupon_none.png" alt=""/>
			                        <p>您还没有已过期的优惠券哟~</p>
			                   	</div>
	                       </#if>	
                    </div> 
                  </#if>                  
                </div>
            </div>
            <#include "/WEB-INF/pages/inc/pagebox_condition_center.ftl">
            <!-- 商品列表-->
            <div id ="recommond-pro-id">
            
            </div>
            <!-- 商品列表-->
        </div>
    </div>
    <div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
    <style>.autocomplete_ui {width:170px;}.autocomplete_ui span {width:165px;}</style>
</div>
</form>
<script  type="text/javascript">
	$(function(){
    $("#choose-info-coupon a").click(function(){
        $(this).addClass('current').siblings().removeClass('current');
        $("#choose-list-coupon .list-con:eq("+$(this).index()+")").addClass('current').siblings().removeClass('current');
    })
})
</script>
<script type="text/javascript">
function deleteCoupon(couponCardId,type)
{
		$confirm("warn","您确定要删除该优惠券吗?",null,function(result)
			  {
			    if(result)
			    {
			 	   $.ajax({
				    url: "${base}/member/coupon!deleteCoupon.action",
				    type: "GET",
				 	data: {
				 		couponCardId: couponCardId,
				 		type: type,
				 	},
				  	cache: false,
			      	success: function(data) {
					if(data==1){
						$alert("warn","删除成功！");
						location.href="/member/coupon.action?type=1";
						return false;
					}else if(data==3){
						$alert("warn","删除成功！");
						location.href="/member/coupon.action?type=3";
						return false;
					}
				 }
			 	});
		     }
	 });
}
</script>
</body>
</html>
<script type="text/javascript" src="${base}/web/js/goods-recommend.js"></script>
