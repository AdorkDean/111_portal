<link rel="stylesheet" type="text/css" href="/web/version2.2.0/css/common.css" />
<link rel="stylesheet" type="text/css" href="/web/version2.2.0/css/member.css">
<link rel="stylesheet" type="text/css" href="/web/version2.2.0/css/common.extend.css">
<link rel="stylesheet" type="text/css" href="/web/version2.2.0/css/jquery-ui-1.10.4.custom.min.css">
<link rel="stylesheet" type="text/css" href="/web/css/jq-alert-confirm.css">
<script type="text/javascript" src="/web/version2.2.0/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/web/version2.2.0/js/global.js"></script>
<script type="text/javascript" src="/web/js/jq-alert-confirm.js"></script>
<script type="text/javascript" src="/web/js/cookieUtil.js"></script>
<script type="text/javascript" src="/web/version2.2.0/js/common.extend.js"></script>
<script type="text/javascript" src="/web/version2.2.0/js/jquery-ui-1.10.4.custom.min.js"></script>
<script type="text/javascript" src="/web/version2.2.0/js/search.new.js"></script>
<script type="text/javascript" src="/web/js/cart.js"></script>
<script type="text/javascript" src="/web/version2.2.0/js/common.js"></script>
<script type="text/javascript" src="/web/js/ismobile.js"></script>
<div class="header clearfix clear">
   	<div class="header-main w1090 clearfix clear" id="goods_detail_class">
           <input type="hidden" value="2" id="identy"/>
		   <#include "/static/imgout/version2.2.0/header_logo.html">
           <ul class="header-privilege clearfix">
           		<li class="separate"></li>
           		<li><b class="entity"></b>实体药店</li>
                <li><b class="gsp"></b>GSP认证</li>
                <li class="morev_h" style="display:none;">更多特权></li>
                <span class="right_cons">
	                <li><b class="flash"></b>闪电发货</li>
	                <li><b class="secrecy"></b>保密发货</li>
	                <li><b class="express"></b>99包邮</li>
                </span>
           </ul>
           <ul class="header-member-info clearfix" id="hasLogined" style="display:none;">
            	<li class="header-nav"><a href="/">首页</a></li>
                <li class="header-nav"><a href="/member/center!getOrderList.action">我的订单</a></li>
                <li class="header-nav dropdown">
                	<div class="dt-member-center">用户中心</div>
                    <div class="dd-member-center clearfix">
                    	<span><a href="/member/index!getCenterIndex.action">用户中心</a></span>
                        <div class="dd-member-center-info">
                    		<i></i>
                            <div class="header-member-name clearfix">
                            	<a href="/login/login!logout.action" class="header-exit">退出</a>
                            	<dl class="clearfix">
                            	   <a href="/member/index!getCenterIndex.action">
                                	<dt><img class="head_url" src="/web/version2.2.0/images/common/none.jpg"/></dt>
                                    <dd class="show_username">tanrenjie</dd>
                                   </a>
                                </dl>
                            </div>
                            <ul class="header-member-operation">
                            	<li><a href="/member/point.action">我的积分</a></li>
                                <li><a href="/member/collect.action">我的收藏</a></li>
                                <li><a href="/member/coupon.action">我的优惠券</a></li>
                            </ul>
                    	</div>
                    </div>
                </li>
                <li class="header-nav header-health-leader"><a href="/leaderarticle/leaderarticle!index.action" style="font-weight:bold;">健康领秀</a></li>
           </ul>
           <div class="header-login" id="h_login_reg_btn">
           	Hi，去<a href="/login/login!index.action">登录</a>/<a href="/register/register!rindex.action">注册</a>
           </div>
    </div>
</div>

