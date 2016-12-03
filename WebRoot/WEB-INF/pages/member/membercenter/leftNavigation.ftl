<!--左侧导航开始-->
<div class="member-nav-left">
    <div class="member-nav-list">
        <ul>
            <li class="tab-tit">交易管理</li>
            <li><a href="#">我的订单</a></li>
            <li><a href="#">我的收藏</a></li>
            <li><a href="#">我的积分</a></li>
            <li><a href="#">我的优惠券</a></li>
            <li><a href="#">我的评论</a></li>
        </ul>
    </div>
    <div class="member-nav-list list-cur">
        <ul>
            <li class="tab-tit">个人中心</li>
            <li id="accountSecurity"><a href="${base}/member/memberCenter!toAccountSecurity.action">账户安全</a></li>
            <li id="baseMemberCenter"><a href="${base}/member/memberCenter!toEditBaseMemberCenter.action">个人资料</a></li>
            <li><a href="#">收货地址</a></li>
            <li><a href="#">消息中心</a></li>
        </ul>
    </div>
    <div class="member-nav-list">
        <ul>
            <li class="tab-tit"><a href="#">健康领袖</a></li>
        </ul>
    </div>
    <div class="member-nav-list">
        <ul>
            <li class="tab-tit">服务中心</li>
            <li><a href="#">售后服务</a></li>
            <li><a href="#">退款退货</a></li>
            <li><a href="#">我的评价</a></li>
            <li><a href="#">我的咨询</a></li>
        </ul>
    </div>
</div>
<!--左侧导航结束-->
<script type="text/javascript">
$().ready(function() {
	alert(location.href);
	alert(this.href);
	var tag = true;
	
	$(".member-nav-list li a").each(function(){
	
		if(location.href == this.href && tag ){
			$(this).parent().parent().parent().addClass("list-cur");
			$(this).parent().addClass("tit-cur");
			tag = false;
		}
	});
	
	
	
	if($(".member-nav-list .tit-cur").length == 0){
	
		$(".member-nav-list li a").each(function(){
		
			var locationURL = location.href.split(".action");
			var aURL	 = this.href.split(".action");
			if(locationURL[0] == aURL[0] && tag){
				$(this).parent().parent().parent().addClass("list-cur");
				$(this).parent().addClass("tit-cur");
				tag = false;
			}
		});
	}
	
	if($(".member-nav-list .tit-cur").length == 0){
	
		$(".member-nav-list li a").each(function(){
			var locationURL = location.href.split(".action")[0].split("!");
			var aURL	 = this.href.split(".action")[0].split("!");
			
			alert(locationURL);
			if(locationURL[0] == aURL[0] && tag){
				$(this).parent().parent().parent().addClass("list-cur");
				$(this).parent().addClass("tit-cur");
				tag = false;
			}
		});
	}
	
});
</script>