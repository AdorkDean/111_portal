//优惠券列表
$(function()
{
	$.ajax(
	{
		url: "/index!getCouponList.action",
		type: "GET",
		dataType: "json",
		cache: false,
		async: false,
		success: function(data) 
		{
			var datas = eval(data);
			var lis = "";
			if(datas != null && datas != '' && datas != undefined)
			{
				var lg = datas.length;
				for(var i=0;i<lg;i++)
				{
					var j = i+1;
					//优惠券ID
					var id = datas[i].id;
					//优惠券面值
					var dis_price = datas[i].dis_price;
					//优惠券名称
					var name = datas[i].name;
					//开始时间
					var start_time = datas[i].start_time;
					start_time = start_time.substring(0,10);
					//结束时间
					var end_time = datas[i].end_time;
					end_time = end_time.substring(0,10);
					//是否已领
					var isget = datas[i].isget;
					
					//数据封装
					var numberOne = "<li id='color0"+j+"' class='color0"+j+" cursorPo' onclick=getCoupon("+id+",this.id)>";
					var numberTwo = "<a>立即领取</a>";
					if(isget != 0)
					{
						numberOne = "<li class='color0"+j+" grayfilerc'>";
						numberTwo = "<a>已领取过</a>";
					}
	                lis += 
	                numberOne
	                +"<div class='list-bg'>"
	                +"<b>￥"+dis_price+"</b>"
	                +"<p class='weight-p'>"+name+"</p>"
	                +"<p>"+start_time+"至"+end_time+"</p>"
	                +numberTwo
	                +"</div>"
	                +"</li>";
	                if(i==7)
	                {
	                	break;
	                }
				}
				$("#loadingDatas").html(lis);
			}
		}
	});
});
	
//优惠券获取
function getCoupon(id, objId)
{
	if($("#"+objId).hasClass("grayfilerc"))
	{
		return;
	}
    if(!checklogin())
    {
        window.location.href="/login/login!index.action?redirectUrl="+window.location.href;
    }
    else
    {
    	$("#loadingGif").show();
    	$("#maskForCoupon").show();
		window.setTimeout(function()
		{
            $.ajax(
            {
                url: "/coupon/coupon!zqBindingCoupon.action?couponId="+id,
                type: "GET",
                cache: false,
                async: false,
                success: function(data)
                {
                	$("#loadingGif").hide("fast");
                	$("#maskForCoupon").hide("fast");
                	var result = data;
					window.setTimeout(function()
					{
                        if(result == 1)
                        {
                            $alertCanDisplay("success","恭喜您，已成功领取该优惠券！","111馆医药提示您",null);
                        }
                        if(result == 2)
                        {
                        	$alertCanDisplay("warn","抱歉，您已领取过此优惠券！","111馆医药提示您",null);
                        	return;
                        }
                        if(result == 3)
                        {
                        	$alertCanDisplay("warn","抱歉，此优惠券已发完！","111馆医药提示您",null);
                        	return;
                        }
                        if(result == 4)
                        {
                        	$alertCanDisplay("error","服务器错误，请确认您已经联网！","111馆医药提示您",null);
                        	return;
                        }
                        if(result == 5)
                        {
                        	$alertCanDisplay("error","无效优惠券！","111馆医药提示您",null);
                        	return;
                        }
                    	$("#"+objId).addClass("grayfilerc");
                    	$("#"+objId).find("a").html("已领取过");
                    	$("#"+objId).removeClass("cursorPo");
					},100);
					
                },
                error: function()
                {
                	$("#maskForCoupon").hide();
                	$("#loadingGif").hide();
                }
            });
		},500);
    }
};
//显示/隐藏优惠券列表
function showOrHideCouponList(param)
{
	if(param == 1)
	{
		$(".coupon-shade").fadeIn();
		$("body").css("overflow","hidden");
	}
	else
	{
		$(".coupon-shade").fadeOut();
		$("body").css("overflow","auto");
	}
}