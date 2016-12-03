<#assign ww=JspTaglibs["/WEB-INF/webwork.tld"]>
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
    <title>提现</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="/web/img/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="/web/img/favicon-196x196.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="img/apple-icon-touch.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
<script>
$(function(){
<#if err?exists>
   <#if err?default(0)==-2>
     $alert("warn","该用户无资金账户",null,null);
   <#elseif err?default(0)==-3>
     $alert("warn","提现金额大于可提现金额",null,null); 
   <#else>
     $alert("warn","申请成功",null,null);  
   </#if>
</#if>
});
</script>
</head>
<body>
<#include "/static/inc/version2.2.0/header.ftl">
<#include "/static/inc/version2.2.0/center_leader.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/health.css"/>
<script type="text/javascript" src="${base}/web/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${base}/web/js/member.js"></script>
<script type="text/javascript">
$(function(){
	$(".current-page").find("h2").css({"color":"#19a69f","font-family":"Microsoft Yahei","letter-spacing":"1px"}).html("健康领秀");
	$(".current-page").find("a").css({"color":"#19a69f","border":"#19a69f 1px solid"});
});
</script>
<div class="health-line">
<div class="health-wrap">
    <div class="current-position">当前位置：<a href="${base}/member/index!getCenterIndex.action">用户中心</a>/<a href="${base}/healthLeader/leader!leader.action">领秀中心</a>/提现</div>
    <div class="health-main">
        <div class="health-nav">
            <ul>
                <li class="current"><a href="${base}/healthLeader/leader!leader.action">领秀中心</a></li>
                <li><a href="${base}/healthLeader/leader!list.action">领秀药房</a></li>
                <li><a href="${base}/healthLeader/leader!ranking.action">领秀排行</a></li>
            </ul>
        </div>
        <div class="health-content"  style="overflow: hidden;">
            <!-- 左侧开始-->
            <div class="part-left">
                <div class="bank-card">
                    <div class="bank-card-info" id="choose-info"><span class="l current">银行卡</span><span class="r">支付宝</span></div>
                    <div class="bank-card-list" id="choose-list">
                        <div class="list-con current">
                            <h2>${account.remainingAmount?default(0)}</h2>
                            <span>可提取壹贝</span>
                            <p>提现注意事项：最小提现单位为10元。每月发放奖金日为10号，每月申请提现的截止日期为5号。5号之后申请提现顺延至下月10号发放奖金。每月只可申请一次。</p>
                            <div class="list-form">
                                <dl>
                                    <dt>提取金额</dt>
                                    <dd>
                                        <input type="text" onkeyup="clearNoNum(this)" id="yamount"/>
                                        <b>元</b>
                                        <em>您申请的提现金额不能超过可提现壹贝</em>
                                    </dd>
                                </dl>
                                <dl>
                                    <dt>开户行</dt>
                                    <dd><input type="text" value="如中国银行"  onfocus="javascript:if(this.value=='如中国银行'){ this.value='';this.style.color='#333'}" onblur="javascript:if(this.value==''){ this.value='如中国银行';this.style.color='#c0c9ca'}" maxlength="100" id="kaihu"/></dd>
                                </dl>
                                <dl>
                                    <dt>银行卡号</dt>
                                    <dd><input type="text" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')" onpaste="value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')" oncontextmenu = "value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')" maxlength="25" id="yhk"/></dd>
                                </dl>
                                <dl style="border-bottom:none;">
                                    <dt>姓名</dt>
                                    <dd><input type="text" maxlength="10" id="yxm"/></dd>
                                </dl>
                            </div>
                            <div class="form-submit"><input type="button" value="提交申请" onclick="subform(2);"/></div>
                            <div class="history-btn"><a href="${base}/member/amountout!list.action">佣金历史</a></div>
                        </div>
                        <div class="list-con">
                            <h2>${account.remainingAmount?default(0)}</h2>
                            <span>可提取壹贝</span>
                            <p>提现注意事项：最小提现单位为10元。每月发放奖金日为10号，每月申请提现的截止日期为5号。5号之后申请提现顺延至下月10号发放奖金。每月只可申请一次。</p>
                            <div class="list-form">
                                <dl>
                                    <dt>提取金额</dt>
                                    <dd>
                                        <input type="text" onkeyup="clearNoNum(this)" id="zamount"/>
                                        <b>元</b>
                                        <em>您申请的提现金额不能超过可提现壹贝</em>
                                    </dd>
                                </dl>
                                <dl>
                                    <dt>支付宝号</dt>
                                    <dd><input type="text" maxlength="20" id="zname"/></dd>
                                </dl>
                                <dl style="border-bottom:none;">
                                    <dt>姓名</dt>
                                    <dd><input type="text" maxlength="10" id="zxm"/></dd>
                                </dl>
                            </div>
                            <div class="form-submit"><input type="button" value="提交申请" onclick="subform(1);"/></div>
                            <div class="history-btn"><a href="${base}/member/amountout!list.action">佣金历史</a></div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 左侧结束-->
            <!-- 右侧开始-->
            <div class="part-right">
                <div class="status">
                  <p>这是您的专属身份：</p>
                        <span style="color:#000;">分享到</span>
                        <style>#jiathis_webchat img{margin:0 auto;}</style>
						<div onmouseover="setShare('111医药馆注册即超值豪礼！要健康、要美丽、要时尚@111医药馆', '${leaderUrl?default('')}','1','${qmap.code?default('')}','${ui1}${qmap.dimensional_code_url?default('')}');" style="margin-top:10px;"> <!--自定义第一个分享标题和链接-->
		                     <div class="jiathis_style">       
		                     <a href="http://www.jiathis.com/share/?uid=2058212" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
		                     <a class="jiathis_button_weixin"></a>
		                     <a class="jiathis_button_tsina"></a>
		                     <a class="jiathis_button_qzone"></a>
		                     <a class="jiathis_button_kaixin001"></a>
		                     <a class="jiathis_button_renren"></a>
		                     </div>
						</div>
                </div>
                <div class="two-dimension"><img src="${ui1}/static/image/codeqr/${qmap.code?default('')}.jpg" alt=""/></div>
            </div>
            <!-- 右侧结束-->
        </div>
    </div>
</div>
</div>
<form name="form1" id="form1"  action="${base}/member/amountout_st!subAmountOut.action" method="post">
<@ww.token/>
<input type="hidden" name="amountOut.outType" value="" id="outType">
<input type="hidden" name="amountOut.amount" value="" id="amount">
<input type="hidden" name="amountOut.alipayNo" value="" id="alipayNo">
<input type="hidden" name="amountOut.bankName" value="" id="bankName">
<input type="hidden" name="amountOut.bankNo" value="" id="bankNo">
<input type="hidden" name="amountOut.realName" value="" id="realName">
</form>
<script type="text/javascript">
      function setShare(title, url,type,code,pic) {
          //url = "${www}/healthLeader/sharedleader!shareLeader.action?hurl="+encodeURIComponent(url)+"&code="+code; 
          url = "http://www.111yao.com/web/share/leader.html?code=${qmap.code?default('')}&id=${qmap.id?default('')}"; 
          jiathis_config.title = title;
          jiathis_config.url = url;
          jiathis_config.pic = pic;
      }
        var jiathis_config = {}
</script>   
<!--分享参数代码结束-->
<!--分享功能代码统一放到页尾-->
<div class="user_center_footer"><#include "/static/inc/version2.2.0/footer.ftl"></div>
<script type="text/javascript" src="http://v1.jiathis.com/code/jia.js?uid=2058212" charset="utf-8"></script>
</body>
<script language="JavaScript" type="text/javascript">
    var m = ${account.remainingAmount?default(0)};
	function clearNoNum(obj){
		obj.value = obj.value.replace(/[^\d.]/g,""); //清除"数字"和"."以外的字符
		obj.value = obj.value.replace(/^\./g,""); //验证第一个字符是数字而不是
		obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的
		obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
		obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数
	}
	
	function subform(type){
	   if(type==2){  //银行卡提现
	     var yamount = $('#yamount').val();
	     if($.trim(yamount)==""){
		      $alert("warn","提现金额不能为空",null,null);
		      return false;
		 }
		 if(parseFloat(m)<parseFloat(yamount)){
		      $alert("warn","提现金额大于可用壹贝",null,null);
		      return false;		 
		 }
		 if(parseFloat(yamount)<10){
		      $alert("warn","提现最小金额为10元",null,null);
		      return false;		 
		 }	 
		 $('#amount').val(yamount);
	     var kaihu = $('#kaihu').val();
	     if($.trim(kaihu)=="" || kaihu=="如中国银行"){
	     	  $alert("warn","开户行不能为空",null,null);
		      return false;
		 }	     
		  $('#bankName').val(kaihu);
		  
		  
	     var yhk = $('#yhk').val();
	     if($.trim(yhk)==""){
	          $alert("warn","银行卡号不能为空",null,null);
		      return false;
		 }	  
		  $('#bankNo').val(yhk);   
	     var yxm = $('#yxm').val();
	     if($.trim(yxm)==""){
	          $alert("warn","姓名不能为空",null,null);
		      return false;
		 }	
		  $('#realName').val(yxm);
		  $('#outType').val(type); 
		  $('#form1').submit();    
	   }else{    //支付宝提现
	     var zamount = $('#zamount').val();
	     if($.trim(zamount)==""){
	          $alert("warn","提现金额不能为空",null,null);
		      return false;
		 }
		 if(parseFloat(m)<parseFloat(zamount)){
		      $alert("warn","提现金额大于可用壹贝",null,null);
		      return false;		 
		 }
		 if(parseFloat(zamount)<10){
		      $alert("warn","提现最小金额为10元",null,null);
		      return false;		 
		 }	
		 $('#amount').val(zamount);
	     var zname = $('#zname').val();
	     if($.trim(zname)==""){
	          $alert("warn","支付宝账号不能为空",null,null);
		      return false;
		 }
		  $('#alipayNo').val(zname);	     
	     var zxm = $('#zxm').val();
	     if($.trim(zxm)==""){
	          $alert("warn","姓名不能为空",null,null);
		      return false;
		 }
		 $('#realName').val(zxm);
		 $('#outType').val(type); 
		 $('#form1').submit();       
	   }
	
	}
	
</script>
</html>