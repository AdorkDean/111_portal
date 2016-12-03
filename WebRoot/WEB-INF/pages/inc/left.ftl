 <div class="uc_left">
     <ul>
        <li>我的订单</li>
        <li class="sign" id="1" ><a href="${base}/user/ucorder!orderList.action">订单中心</a></li>
        <li class="sign" id="2" ><a href="${base}/user/fav!getFavWorks.action">我的关注</a></li>
        <li class="sign" id="7" ><a href="${base}/user/usercoupon!getCouponInfo.action">优惠券</a></li>
        <li>服务中心</li>
        <li class="sign" id="3" ><a href="${base}/user/comment!getUserComment.action">我的咨询</a></li>
        <li class="sign" id="4" ><a href="#">防伪查询</a></li>
        <li>账户中心</li>
        <li class="sign" id="5" ><a href="${base}/user/ucenter!toUserInfo.action">账户信息</a></li>
        <li class="sign" id="6" ><a href="${base}/user/ucenter!secCenter.action">账户安全</a></li>
     </ul>
</div>

<script>
$(document).ready(function (){
	
   var sign = $('#sign').val();
   $("#"+sign).addClass("now");
   /*
   $("li").filter('.sign').hover(
	function(){
		$(this).addClass("now");
	},
	function(){
		$(this).removeClass("now");
	});*/
});
</script>

