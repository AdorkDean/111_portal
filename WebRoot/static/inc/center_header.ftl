<#include "/static/inc/header_common.html">
<#assign contextPath = request.contextPath/>
<#assign www = "http://new.111yao.com"/>
<#assign ui = "http://ui.111yao.com"/>  
<#assign ui1 = "http://img.zdfei.com"/>  
<script>
var jsCtx = "${base}";
var CtxPath = "${contextPath}";
</script>

<div class="logo-search-cart" style="border-bottom:#bc2d0d 1px solid;">
        <div class="w1210 clearfix clear">
            
            <!-- 我的购物车 -->
            <#include "/static/inc/header_shopcart.html">
            <!-- LOGO部分 -->
        	<div class="important" style="float:right;margin-top:18px;margin-right:10px;cursor:pointer;"><img src="http://img.zdfei.com/static/image/temp/20160311/96933e94bd3eae90f001bd4cd566295e.png" onclick="window.open('http://wpa.qq.com/msgrd?v=3&uin=2601114970&site=qq&menu=yes')"/></div>
            <h1 class="logo fl">
            <#include "/static/imgout/header_logo.html">
            </h1>
            <div class="current-page" style="float:left;margin-top:10px;margin-left:20px;">
            	<h2 class="current-location" style="font-family:'Arial',Microsoft Yahei;color:#e74925;font-size:22px;font-weight:bold;letter-spacing:2px;">我的111</h2>
                <a href="/" style="border:#e74925 1px solid;border-radius:10px;display:block;color:#e74925;width:120px;text-align:center;margin-left:-2px;margin-top:2px;">返回医药馆首页</a>
            </div>
        </div>
    </div>
</div>

<#include "/static/inc/header_cartjs.html">
