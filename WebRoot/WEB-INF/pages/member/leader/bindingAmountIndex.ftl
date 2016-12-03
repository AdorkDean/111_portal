<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="111医药馆网上药店是国家药监局认证指定网上药房|打造为老百姓服务药品价格低品种全|网上购药买药就选壹壹壹医药馆药品特卖网站">
    <!-- keywords -->
    <meta name="keywords" content="壹壹壹医药馆|壹药馆|11医药馆|1药馆|医卡通|111医药馆|医药网|药品特卖网站">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>绑定提现帐号</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="images/common/favicon.png">
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/common/favicon.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="images/common/favicon.png">
    <meta name="msapplication-TileImage" content="images/common/favicon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <style>
    #kaihuhang {display: none;}
    </style>
   
</head>
<body class="health-bc">
<#include "/static/inc/version2.2.0/new_leader_header.ftl" />
<script>$("#leader_navicator li").eq(0).addClass("cur");</script>


<!--提现开始-->
<div class="my-pharmacy-page w1000 extract-padding" style="margin-top:25px;">
    <h2 class="article-page-top">绑定提现账号</h2>
    <dl class="extract-binding extract-binding-margin">
        <dt>选择提现方式：</dt>
        <dd>
            <input name="amount" type="radio" class="extract-binding-radio" value="1" id="numberType" checked="checked" onclick="bankNhide()"/> 支付宝
            <input name="amount" type="radio" class="extract-binding-radio" value="2" id="numberType" onclick="bankNshow()"/> 银行卡
        </dd>
    </dl>
    <dl class="extract-binding">
        <dt>账号：</dt>
        <dd>
            <input type="text" class="extract-binding-text"  id="numberAmount" onfocus="javascript:if(this.value==''){ this.value='';this.style.color='#222';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='';this.style.color='#d7d7d7';this.style.border='1px solid #d7d7d7'}"/>
        </dd>
    </dl>
    <dl class="extract-binding">
        <dt>确认账号：</dt>
        <dd>
            <input type="text" class="extract-binding-text"  id="reNumberAmount" onfocus="javascript:if(this.value==''){ this.value='';this.style.color='#222';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='';this.style.color='#d7d7d7';this.style.border='1px solid #d7d7d7'}"/>
        </dd>
    </dl>
    <div id="kaihuhang">
    <dl class="extract-binding">
        <dt>持卡人姓名：</dt>
        <dd>
            <input type="text" class="extract-binding-text"  id="accountRealName" onfocus="javascript:if(this.value==''){ this.value='';this.style.color='#222';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='';this.style.color='#d7d7d7';this.style.border='1px solid #d7d7d7'}"/>
        </dd>
    </dl>
    <dl class="extract-binding">
        <dt>开户行：</dt>
        <dd>
            <input type="text" class="extract-binding-text"  id="bankName" onfocus="javascript:if(this.value==''){ this.value='';this.style.color='#222';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='';this.style.color='#d7d7d7';this.style.border='1px solid #d7d7d7'}"/>
        </dd>
    </dl>
    </div>
    <dl class="extract-binding">
        <dt>手机验证码：</dt>
        <dd>
            <input type="text" class="extract-binding-text" value="请输入手机验证码" onfocus="javascript:if(this.value=='请输入手机验证码'){ this.value='';this.style.color='#222';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='请输入手机验证码';this.style.color='#d7d7d7';this.style.border='1px solid #d7d7d7'}" id="mobileCode"/>
            <span class="iphone-code" id="getCode">获取</span>
        </dd>
    </dl>
    <div class="extract-hint">
        <p>系统会根据您帐号绑定的领秀手机号发送验证码</p>
    </div>
    <div class="extract-button extract-button-margin">
            <input type="button" value="确  认"  onclick="doit()"/>
    </div>
</div>
<!--提现结束-->

<div style="margin-top:20px;"><#include "/static/inc/version2.2.0/new_leader_footer.ftl"/></div>

<!--js-->
<script type="text/javascript">
    var getCode = document.getElementById("getCode");
    var timer = null;
    var count = 60;
    function timeDesc() {
        if(count > 0) {
            count--;
            getCode.innerHTML = count + "S";
            getCode.style.background = "#f3f5f7";
        } else {
            getCode.innerHTML = "重发";
            getCode.style.background = "#fe4310";
            getCode.style.color="#FFFFFF";
            count = 60;
            window.clearInterval(timer);
            timer = "";
        }
    }
   		var $numberAmount = $("#numberAmount");
    	var $reNumberAmount = $("#reNumberAmount");
    	var $mobileCode = $("#mobileCode");
    	var $bankName = $("#bankName");
    	
	    $("#getCode").click(function(){
	    		if($numberAmount.val()==null || $.trim($numberAmount.val()) == ""){
					$alert("warn","账号不能为空！","友情提示",null);
					return false;
				}
				if(($reNumberAmount.val()) != ($numberAmount.val())){
					$alert("warn","两次账号不一致！","友情提示",null);
					return false;
				}
				var	numberType=$("input[name='amount']:checked").val();
	    		if(numberType==2){
	    			if($bankName.val()==null || $.trim($bankName.val()) == ""){
					$alert("warn","银行名称不能为空！","友情提示",null);
					return false;
					}
	    		}
				var mobile=  '${mobile?default('')}';
				if(count == 60){
					$.ajax({
							url: "${base}/member/bindingAmount!validateMobileCode.action",
							data:{
								mobile:$.trim(mobile),
							    },
							type:"post",
							async:false,
							cache:false,
							success: function(data) {
								if(data==0){//发送成功
									timer = window.setInterval("timeDesc()", 1000);
								}else{
									$alert("warn","网络异常！","友情提示",null);
								}
							}
					});
				}
			});
	function bankNshow(){
				 $("#kaihuhang").show();
			}
	function bankNhide(){
				 $("#kaihuhang").hide();
			}
	function doit(){
	    		var	numberType=$("input[name='amount']:checked").val();
	    		if(numberType==2){
	    			if($bankName.val()==null || $.trim($bankName.val()) == ""){
					$alert("warn","银行名称不能为空！","友情提示",null);
					return false;
					}
	    		}
				if($numberAmount.val()==null || $.trim($numberAmount.val()) == ""){
					$alert("warn","账号不能为空！","友情提示",null);
					return false;
				}
				if(($reNumberAmount.val()) != ($numberAmount.val())){
					$alert("warn","两次账号不一致！","友情提示",null);
					return false;
				}
				if($mobileCode.val()==null || $.trim($mobileCode.val()) == "" || $mobileCode.val()=="请输入手机验证码"){
					$alert("warn","验证码不能为空！","友情提示",null);
					return false;
				}
				$.ajax({
							url: "${base}/member/bindingAmount!bindingAmount.action",
							data:{
								numberType:numberType,
								numberAmount:$numberAmount.val(),
								bankName:$bankName.val(),
								mobileCode:$mobileCode.val(),
								accountRealName:$("#accountRealName").val(),
							    },
							type:"post",
							async:false,
							cache:false,
							success: function(data) {
								if(data==0){//绑定成功
									location.href = "${base}/leaderarticle/leaderarticle!index.action";
								}else{
									$alert("warn","验证码错误！","友情提示",null);
								}
							}
				});
	}
  
</script>
</body>
</html>