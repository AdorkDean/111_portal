<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>积分规则</title>
    <script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/user_center_searchbox.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <div class="member-content">
            <h2>积分规则</h2>
           <div class="member-main">
                <div class="integral-text">
                    <h3>一、会员级别说明如下</h3>
                    <p>111医药馆的会员级别共分为5个等级，分别为：普卡会员、银卡会员、金卡会员、白金卡会员、钻石卡会员。会员级别的升降均由系统自动处理，无需申请。会员级别由累计积分决定，累计积分越高会员等级越高，享受到的会员权益越大。</p>
                    <p>会员积分为2：1，即购买订单金额所送积分两元等于一积分。</p>
                    <img src="${base}/web/images/member-center/member-img04.jpg" alt=""/>
                    <h3>二、会员级别规则</h3>
                    <img src="${base}/web/images/member-center/member-img05.jpg" alt=""/>
                    <p>举例：会员小A在2013年2月1日升级为白金会员，截止至2014年1月31日累计积分为20000，此时扣除4000累计积分，剩余累计积分为16000，可用积分清零，系统根据剩余累计积分重新判断会员小A为白金会员，有效期为1年。</p>
                    <h3>三、会员级别享有的服务</h3>
                    <img src="${base}/web/images/member-center/member-img06.jpg" alt=""/>
                </div>
            </div>
        </div>
<div class="user_center_footer" style="float:left; "><#include "/static/inc/version2.2.0/footer.ftl">
       <style>.autocomplete_ui {width:170px;}.autocomplete_ui span {width:165px;}</style>
    </div>
    </div>
</div>
</body>
</html>