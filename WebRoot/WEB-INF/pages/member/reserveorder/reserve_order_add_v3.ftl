<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="">
    <!-- keywords -->
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>需求确认</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="${base}/web/img/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="img/favicon-196x196.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="${base}/web/img/apple-icon-touch.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="${base}/web/img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <!--style-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css">
    <!--header-->
    <!--footer-->
    <!--product-->
    <link rel="stylesheet" type="text/css" href="${base}/web/css/product.css">
    <link rel="stylesheet" type="text/css" href="${base}/web/css/reserveOrder.css">
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=51293f48fbe2e1e51de5299446404273&plugin=AMap.PlaceSearch,AMap.Geocoder"></script>
</head>
<#include "/WEB-INF/pages/inc/taglibs.ftl">
<#include "${base}/static/inc/version2.2.0/header.ftl"/>
<#include "${base}/static/inc/version2.2.0/search_box.html"/>
<script>
    $(".current-location").html("需求确认");
</script>
<style>
    .w100{
        width:153px;
    }
    .w1210{width:1210px;}
    .shopping-state {
        width:1190px;
    }

    .w1210 {
        padding-bottom: 80px;
    }



    .com-out.out{position:absolute; top:50%; margin-top:-200px; left:50%; margin-left:-345px; z-index:1000;}
    #shade {display:none;width:100%;height:100%;top:0;left:0; right:0; bottom:0; position:fixed;  _position:absolute; background: rgb(0, 0, 0); /* RGBa with 0.6 opacity */ background: rgba(0, 0, 0, 0.6); /* For IE 5.5 - 7*/ filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000); /* For IE 8*/ -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)"; z-index:999; }
    .com-out .double-out{position:relative;}
    .com-out .out-title{height:40px; line-height:40px; padding:0 40px; font-size:18px; text-align:left; background:#e9e9e9; border-bottom:2px solid #adadad; position:relative;}
    .com-out .close-out{width:20px; height:20px; display:inline-block; overflow:hidden; background:url(${base}/web/img/close.png) no-repeat; position:absolute; right:10px; top:10px; z-index:9;}
    .com-out .out-title .close-out{background-position:0 -20px;}
    .com-out .out-info{padding:20px 40px 40px; background:#fff;}
    .com-out .refund-details{margin-bottom:15px;}
    .com-out .refund-details dt b{color:#f14440; margin-right:5px; font-weight:bold;}
    .com-out .refund-details dt{height:23px; line-height:23px; float:left; width:90px; margin-right:10px; text-align:right;}
    .com-out .refund-details dd{width:510px; float:left;}
    .com-out .refund-box{float:left; border:1px solid #a6a6a6; padding:0 0 0 5px;}
    .com-out .refund-price{height:14px; line-height:14px; padding:4px 5px 3px 0; width:80px; border-left:none;}
    .com-out .receive-p input{width:120px;}
    .com-out .add-address{width:96px; float:left;}
    .com-out .refund-list{width:166px; height:21px; line-height:21px; position:relative; border:1px solid #a6a6a6; border-radius:2px; -moz-border-radius:2px; -webkit-border-radius:2px;}
    .com-out .choice-city i{width:8px; height:5px; display:inline-block; background:url(${base}/web/img/choice_city_ico.png) no-repeat; float:left; margin:8px 5px 0;}
    .com-out .location-box{float:left; border:1px solid #a6a6a6; padding:0 0 0 5px; position:relative; margin-left:10px; margin-top:0; background:none;}
    .com-out .location-box input{width:185px; color:#afafaf; height: 14px;line-height: 14px;padding: 3px 5px 3px 0;}
    .com-out .location-list{width:195px; position:absolute; left:-1px; top:21px; border:1px solid #a6a6a6; background:#fff; display:none;}
    .com-out .location-list li a{ height:24px; line-height:24px; color:#a2a2a2; display:block; padding:0 5px;}
    .com-out .refund-box{float:left; border:1px solid #a6a6a6; padding:0 0 0 5px;}
    .com-out .receive-d input{width:340px;}
    .com-out .tel-details dd{width:auto;}
    .com-out .tel-details dd input{width:120px;}
    .com-out .tel-sec{height:23px; line-height:23px; float:left; width:90px; margin:0 10px 0 18px; text-align:right;}
    .com-out .for-btn-box{padding:10px 0 15px; text-align:center;}
    .com-out .add-receive-box{padding:0 0 15px 100px;}
    .com-out .for-btn-box a{height:21px; line-height:21px; display:inline-block; width:106px; text-align:center;}
    .com-out .for-btn-box a.submit-refund{border:1px solid #a6a6a6; color:#000; border-radius:2px; -moz-border-radius:2px; -webkit-border-radius:2px; margin-right:20px; background:#dadada;
        /* Firefox 3.6+ */
        background: -moz-linear-gradient(top, #fff, #dadada);
        /* Safari 4-5, Chrome 1-9 */
        /* -webkit-gradient(,  [, ]?,  [, ]? [, ]*) */
        background: -webkit-gradient(linear,top,from(#fff),to(#dadada));
        /* Safari 5.1+, Chrome 10+ */
        background: -webkit-linear-gradient(top, #fff, #dadada);
        /* Opera 11.10+ */
        background: -o-linear-gradient(top, #fff, #dadada);}
    .com-out .for-btn-box a.cancle-refund{border:1px solid #158e88; border-radius:2px; -moz-border-radius:2px; -webkit-border-radius:2px; color:#fff; background:#dadada;
        /* Firefox 3.6+ */
        background: -moz-linear-gradient(top, #42bcb7, #19a49d);
        /* Safari 4-5, Chrome 1-9 */
        /* -webkit-gradient(,  [, ]?,  [, ]? [, ]*) */
        background: -webkit-gradient(linear,top,from(#42bcb7),to(#19a49d));
        /* Safari 5.1+, Chrome 10+ */
        background: -webkit-linear-gradient(top, #42bcb7, #19a49d);
        /* Opera 11.10+ */
        background: -o-linear-gradient(top, #42bcb7, #19a49d);}
    .com-out .add-receive-box a{float:left;}
    .com-out .first-out,.second-out,.third-out{ position:absolute; left:0; top:0; right:0;}
    .com-out .second-out{display:none; z-index:9; background:#fff; padding-bottom:0;}
    .com-out .city-title{ background:none; border-bottom:1px solid #eee; font-size:12px; padding:0; margin:0 0 0 25px;}
    .com-out .close-city{width:20px; height:20px; display:inline-block; overflow:hidden; background:url(${base}/web/img/close.png) no-repeat; position:absolute; right:10px; top:10px; z-index:9; background-position:0 -20px;}
    .com-out .city-main{padding-left:25px;}
    .com-out .city-location{height:60px;}
    .com-out .guess-location{padding-right:25px; height:30px; line-height:30px; border-right:1px solid #ddd; float:left; margin:15px 0; font-size:14px; color:#0089dc;}
    .com-out .guess-location span{background:#ff6000; height:22px; line-height:22px; border-radius:4px; -webkit-border-radius:4px; padding:0 20px; margin-left:15px; margin:4px 0 4px 15px; display:inline-block; color:#fff; float:right; font-size:16px;}
    .com-out .input-city{height:28px; width:188px; background:#f5f5f5; border:1px solid #ededed; position:relative; padding:0 5px; float:left; margin:15px 0 0 25px;}
    .com-out .input-city input{ height:16px; line-height:16px; padding:6px 0; background:none; width:100%; color:#afafaf;}
    .com-out .input-city-list{width:198px; position:absolute; left:-1px; top:28px; border:1px solid #ededed; background:#fff; display:none;}
    .com-out .input-city-list li a{ height:24px; line-height:24px; color:#a2a2a2; display:block; padding:0 5px;}
    .com-out .input-city-list li a:hover{ background:#f1f1f1;}
    .com-out .city-location-list{height:219px; overflow-y:scroll;}
    .com-out .city-location-list dl{ font-size:14px; border-top:1px solid #eee;}
    .com-out .city-location-list dl dt{color:#0089dc; float:left; line-height:38px; width:45px;}
    .com-out .city-location-list dl dd{float:left; width:600px; overflow:hidden;}
    .com-out .citytown-list li{ width:70px; overflow:hidden; height:38px; line-height:38px; text-align:left; float:left; margin-right:4px;}
    .com-out .third-out{display:none; z-index:19; background:#fff;}
    .com-out .close-add{width:20px; height:20px; display:inline-block; overflow:hidden; background:url(${base}/web/img/close.png) no-repeat; position:absolute; right:10px; top:10px; z-index:9; background-position:0 -20px;}
    .com-out .show-map2{height:310px; width:690px;}
    .com-out .ab-location{width:322px; height:42px; background:#fff; position:relative; left:10px; top:10px; z-index:999; float:left; box-shadow:2px 2px 4px 0 #ccc;}
    .com-out .fill-lication{width:260px; height:42px; float:left; padding:0 10px;}
    .com-out .ipt-lication{width:100%; height:22px; line-height:22px; padding:10px 0; color:#999; font-size:14px;}
    .com-out .search-location{width:42px; height:42px; display:inline-block; background:#ffa02f url(${base}/web/img/search_location.png) no-repeat; float:right;}
    .com-out .map-location-list{position:absolute; width:322px; height:360px; left:0; top:50px; overflow:hidden; display:none; box-shadow:2px 2px 4px 0 #ccc;}
    .com-out .map-location-list li a{height:40px; display:block; padding:10px; font-size:14px; background:rgba(255,255,255,.8); position:relative;}
    .com-out .map-location-list li a:hover{ background:#f1f1f1;}
    .com-out .map-location-list li a .location-title{color:#575757;}
    .com-out .map-location-list li a .location-text{color:#999;}
    .com-out .map-location-list li a p{padding-left:25px;}
    .com-out .map-location-list li i{width:15px; height:19px; line-height:15px; color:#fff; display:inline-block; position:absolute; overflow:hidden; background:url(${base}/web/img/map_point.png) no-repeat; font-style:normal; text-align:center; font-size:12px; font-family:"SimHei"; top:18px; left:10px;}
    .com-out .manual-locate-btn{width: 154px; height: 40px; line-height: 40px; background: #3682d8; color: #fff; font-size: 14px; text-align: center; display: inline-block; position: relative; right: 38px; top: 10px; z-index: 999; float: right;}
    .com-out .manual-locate .out-info{position: relative; padding:20px 0; top: 20px; left: 10px; right: 10px; width: 670px; overflow: hidden; z-index: 1099;}
    .com-out .manual-locate .out-info .refund-details dt{width:170px;}
    .com-out .manual-locate .out-info .refund-details dd{width:430px;}
    .com-out .address-tip{height:23px; line-height:23px; float:left; margin-right:10px; padding:0 0 0 7px;}
    .com-out .selete-box{background:none; border:none; width:100%;}
    .com-out .close-add{width:20px; height:20px; display:inline-block; overflow:hidden; background:#FFF url(${base}/web/img/close.png) no-repeat; position:absolute; right:10px; top:10px; z-index:9; background-position:0 -20px;}
</style>
<body>

<!--封装生成预订单需要的参数表单-->
<form name="reserveOrderForm" id="reserveOrderForm">
    <input id="receiverId" name="receiverId" type="hidden" value="${receiverId?default('')}"/>
    <input id="remark" name="remark" type="hidden" value=""/>
    <input id="deliveryId" name="deliveryId" type="hidden" value=""/>
    <input id="rxImgUrl" name="rxImgUrl" type="hidden" value=""/>
    <input id="goodsId" name="goodsId" type="hidden" value="${goods.id?default('')}"/>
    <input id="goodsNum" name="goodsNum" type="hidden" value="1"/>
    <input id="replyMobile" name="replyMobile" type="hidden" value=""/>
</form>
<form name="reserveOrderPayForm" id="reserveOrderPayForm" method="post">
    <input id="reserveOrderId" name="reserveOrderId" type="hidden" value=""/>
    <input id="orderAmount" name="orderAmount" type="hidden" value=""/>
</form>
<input id="haveAddressFlag" name="haveAddressFlag" type="hidden" value="<#if receiverList?size gt 0>1</#if>"/>
<!--购物车模块开始-->
<div class="shopping-cart-box">
    <!--购物步骤开始-->
    <div class="shopping-state">
        <!--进度条-->
        <div id="process" class="section4">
            <div class="bar-left"></div>
            <div class="node doing">
                <ul>
                    <li class="tx1"><span class="state state-yf"><s></s>提交预定</span></li>
                </ul>
            </div>
            <div class="proce wait">
                <ul>
                    <li class="tx1">&nbsp;</li>
                </ul>
            </div>
            <div class="node wait">
                <ul>
                    <li class="tx1"><span class="state"><s></s>药师回拨</span></li>
                </ul>
            </div>
            <div class="proce wait">
                <ul>
                    <li class="tx1">&nbsp;</li>
                </ul>
            </div>
            <div class="node wait">
                <ul>
                    <li class="tx1"><span class="state"><s></s>线下付款</span></li>
                </ul>
            </div>
            <div class="proce wait">
                <ul>
                    <li class="tx1">&nbsp;</li>
                </ul>
            </div>
            <div class="node wait" style="border-radius:0 8px 8px 0; -moz-border-radius:0 8px 8px 0; -webkit-border-radius:0 8px 8px 0;">
                <ul>
                    <li class="tx1"><span class="state"><s></s>流程结束</span></li>
                </ul>
            </div>
        </div>
    </div>
    <!--购物步骤结束-->
    <div class="shopping-cart-main roaw1210 w1210">
        <!--我的购物车开始-->
        <div class="my-shopping-cart">
            <!--收货人信息-->
            <div class="my-shopping-cart-list clearfix clear">
                <h4 class="receiver-info-title">
                    收货人信息<a href="javascript:void(0)" class="add-new-receiver" id="popup-btn2"><i>+</i>新增收货人信息</a>
                    <!--<span style="height:20px; padding-left:10px; padding-top:10px; background:#FFF; color:#e74925; font-weight:bold;">注意：北京大兴亦庄地区下单立减邮费</span>-->
                </h4>
                <div class="receiving-address">
                    <div class="receiving-address-all">
                        <input type="hidden" id="set-top-v" value="0"/>
                        <ul class="more-receiving-address mt10" id="receiverULId">
                        <#list receiverList as receiver>
                            <li>
                                <div class="receiving-address-list clearfix clear <#if receiver_index?if_exists ==0>receiving-address-curr2</#if>" id="receiving-address-list" >
                                    <input id="receiver_id" type="hidden" value="${receiver.id?default('')}"/>
                                    <div class="receiving-address-operate">
                                        <a href="javascript:void(0)" id="moren_shouhuo" onClick="setDefaultReceiverDiv(${receiver.id?default('')})">设为默认收货地址</a>
                                        <a href="javascript:void(0)" onClick="updateReceiverDiv(${receiver.id?default('')})" class="popup-btn3">编辑</a>
                                        <a href="javascript:void(0)" class="popup-btn4" onClick="delReceiverDiv(${receiver.id?default('')});">删除</a>
                                    </div>
                                    <div class="receiving-area">
                                        <b></b>
                                        <span>${receiver.receiver?default('')}</span>&nbsp;&nbsp;
                                        <span>${receiver.areaFirstName?default('')}</span>
                                    </div>
                                    <p class="receiving-details">
                                        <span class="area-name">${receiver.receiver?default('')}</span>
                                        <span class="area-a">${receiver.area?default('')}</span>
                                        <span class="area-long">${receiver.locationAddress?default('')}${receiver.address?default('')}
                                        </span>
                                        <span class="receiver-tel">${receiver.mobile?default('')}</span>
                                    </p>
                                </div>
                            </li>
                        </#list>
                        </ul>
                        <div class="show-more-address" onclick="receiverAllShow()" id="receiverAllShow_DivId">
                            <a href="javascript:gdshdz()"><i></i>更多地址</a>
                        </div>
                    </div>
                </div>
            </div>
            <!--联系方式-->
            <div class="my-shopping-cart-list mt-1 clearfix clear">
                <h4 class="receiver-info-title">
                    请补充您的送货清单，药师会在1个小时之内与您联系
                </h4>
                <div class="leave-message">
                    <span class="phone-yf">手　机：</span>
                    <div class="location-box" style="background:none;">
                        <!--<input type="text" id="replyMobileTemp" name="replyMobileTemp" class="city-ipt" value="请输入手机号，供药师回拨" onfocus="javascript:if(this.value=='请输入手机号，供药师回拨'){ this.value='';this.style.color='#333'}" onblur="javascript:if(this.value==''){ this.value='请输入手机号，供药师回拨';this.style.color='#afafaf'}">-->
                        <input type="text" id="replyMobileTemp" name="replyMobileTemp" class="city-ipt" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  placeholder="请输入手机号，供药师回拨" maxlength="11" value=""/>
                    </div>
                    <i>(必填)</i><span><font color="red" style="float: left;margin: 5px 0 0 5px;" id="replyMobileTempMsg"></font></span>
                </div>
            </div>
            <!--上传处方-->
            <div class="my-shopping-cart-list mt-1 clearfix clear">
                <h4 class="receiver-info-title">
                    上传处方可以缩短审核时间（选填）
                </h4>
                <div class="leave-message">
                    <div class="file-box">
                        <span class="reserve_img">点此上传</span>
                        <input type="file"  id="reserveImg" name="reserveImg" value="" onchange="ajaxFileUpload();"/>
                        <i class="img-close" onclick="removeImg();"></i>
                    </div>
                    <p class="jpg-yf">(仅限一张)图片大小不超过5M；支持jpg/png/gif格式</p>
                </div>
            </div>
            <!--确定预定信息-->
            <div class="my-shopping-cart-list mt-1 clearfix clear">
                <h4 class="receiver-info-title">
                    确定预订信息
                </h4>
                <div class="my-shopping-cart-list clearfix clear">
                    <div class="shopping-cart-model shopping-cart-title clearfix clear">
                        <div class="w100 fr position-yf">
                            服务费 <i class="serve-yf" onmouseover="$('.serve-tet').show();" onmouseout="$('.serve-tet').hide();"></i>
                            <div class="serve-tet" style="display:none;">
                                <p>当天（同一地址）预定多款药品，只收取一次运费及服务费，如有疑问，可拨打客服电话400-606-3111</p>
                                <em></em>
                            </div>
                        </div>
                        <div class="w100 fr">
                            小计（元）
                        </div>
                        <div class="w100 fr">
                            数量
                        </div>
                        <div class="w100 fr">
                            单价（元）
                        </div>
                    </div>
                    <div class="shopping-cart-model shopping-cart-list clearfix clear">
                        <ul>
                            <li class="clearfix clear">
                                <div class="cart-product-info clearfix clear">
                                    <div class="w555 fl">
                                        <dl class="cart-list-info clearfix clear">
                                            <dt><img src="${ui1}${goods.abbreviationPicture?default('')}"/></dt>
                                            <dd>
                                                <p class="cart-product-title">${goods.goodsName?default('')}</p>
                                                <p class="cart-product-spec">规格：${goods.spec?default('')}</p>
                                            </dd>
                                        </dl>
                                    </div>
                                    <div class="w100 fl">
                                        <span class="cart-list-price cart-list-total-price pc_price">${goods.pcPrice?string("0.00")}</span>
                                    </div>
                                    <div class="w100 fl">
                                        <div class="cart-product-count">
                                            <a href="javascript:void(0)" class="count-plus"  onclick="updateCount($(this),'add');" >+</a>
                                            <a href="javascript:void(0)" class="count-minus" onclick="updateCount($(this),'sub');">-</a>
                                            <input class="count-text" name="kuang_count" readonly type="text" value="1" maxlength="3" >
                                        </div>
                                    </div>
                                    <div class="w100 fl">
                                        <span class="cart-list-price cart-list-total-price goods_total">${goods.pcPrice?default('')}</span>
                                    </div>
                                    <div class="w100 fl">
                                        <p class="cart-list-operate">运费及服务费<span class="freight">${freight?default('')}</span>元</p>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="leave-message">
                    <span class="phone-yf">添加备注：</span>
                    <div class="message-input">
                        <input type="text" id="remarkTemp" maxlength="200">
                    </div>
                    <i>(选填)</i>
                </div>
                <p class="tel-yf">当天（同一地址）预定多款药品，只收取一次运费及服务费，如有疑问，可拨打客服电话400-606-3111</p>
            </div>
            <div class="for-settle-accounts clearfix clear">
                <p>总计：<b>¥<span class="total_amount">${goods.totalAmount?default('')}</span>元</b></p>
                <a href="javascript:saveReserveOrder()" id="tijiaoOrder" class="go-settle-accounts gray">提交预定</a>
            </div>
        </div>
        <!--我的购物车结束-->
    </div>
</div>
<!--购物模块结束-->



<#include "/WEB-INF/pages/member/reserveorder/reserve_order_shad_div.ftl">
<!--<script  type="text/javascript" src="${base}/web/js/productNew.js"></script>-->


<script type="text/javascript" src="${base}/web/js/jquery.lSelect.js"></script>
<script type="text/javascript" src="${base}/web/js/input.js"></script>
<script type="text/javascript" src="${base}/web/js/jq-alert-confirm.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/web/css/jq-alert-confirm.css"/>
<script type="text/javascript" src="${base}/web/js/cookieUtil.js"></script>
<script type="text/javascript" src="${base}/web/js/reserve_order_add.js"></script>
<script type="text/javascript" src="${base}/web/js/ajaxfileupload.js"></script>
<script>


</script>
<#include "${base}/static/inc/version2.2.0/footer.ftl"/>
</body>
</html>
