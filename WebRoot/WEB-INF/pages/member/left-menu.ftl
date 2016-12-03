 <div class="member-nav-left">
        <div class="member-nav-list">
            <ul>
                <li class="tab-tit">交易管理</li>
                <li class="list"><a href="${base}/member/center!getOrderList.action" >我的订单</a></li>
                <li class="list"><a href="${base}/member/collect.action">我的收藏</a></li>
                <li class="list"><a href="${base}/member/point.action">我的积分</a></li>
                <li class="list"><a href="${base}/member/coupon.action">我的优惠劵</a></li>
                <li class="list"><a href="${base}/member/center!getOrderList.action?orderType=4">历史订单</a></li>
            </ul>
        </div>
        <div class="member-nav-list list-cur">
            <ul>
                <li class="tab-tit">用户中心</li>
                <#if member.source?default(0)!=0&&member.source?default(0)!=1&&member.source?default(0)!=2&&member.source?default(0)!=3&&member.source?default(0)!=4>
                <li class="list"><a href="${base}/member/memberCenter!toAccountSecurity.action">账户安全</a></li>
                </#if>
                <li class="list"><a href="${base}/member/memberCenter!toEditBaseMemberCenter.action">个人资料</a></li>
                <li class="list"><a href="${base}/member/receiver.action">收货地址</a></li>
            </ul>
        </div>
        <div class="member-nav-list">
            <ul>
                <li class="tab-tit"><a href="${base}/leaderarticle/leaderarticle!index.action">健康领秀</a></li>
            </ul>
        </div>
        <div class="member-nav-list">
            <ul>
                <li class="tab-tit">服务中心</li>
                <li class="list"><a href="${base}/member/help!after_service.action">售后服务</a></li>
                <li class="list"><a href="${base}/member/return!myReturns.action">退款退货</a></li>
                <li class="list"><a href="${base}/member/comment!myGoodsCommentPage.action">我的评价</a></li>
                <li class="list"><a href="${base}/member/consult!myGoodsConsultPage.action">我的咨询</a></li>
            </ul>
        </div>
    </div>
<script type="text/javascript">
$().ready(function() {
	
	var tag = true;
	
	var orderact = location.href.indexOf("order.action") ;
	
	
	$(".member-nav-list .list a").each(function(){
		if(location.href == this.href && tag ){
			$(this).parent().parent().parent().addClass("list-cur");
			$(this).parent().addClass("tit-cur");
			tag = false;
		}
	});
	
	if($(".member-nav-list .tit-cur").length == 0){
	
		$(".member-nav-list .list a").each(function(){
		
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
	
		$(".member-nav-list .list a").each(function(){
		
			var locationURL = location.href.split(".action")[0].split("!");
			var aURL	 = this.href.split(".action")[0].split("!");
			
			if(locationURL[0] == aURL[0] && tag){
				$(this).parent().parent().parent().addClass("list-cur");
			    if(orderact<0)
				$(this).parent().addClass("tit-cur");
				tag = false;
			}
		});
	}
	
});
</script>
