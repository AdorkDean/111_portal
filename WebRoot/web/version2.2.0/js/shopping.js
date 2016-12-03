// JavaScript Document
$(function(){
	//shopping choice input
//	$('.chioce-mark a').click(function(){
//		if($(this).hasClass('current')){
//			$(this).removeClass('current');	
//		}else{
//			$(this).addClass('current');		
//		}
//	})
	//shopping cart collect
	$('.shopping-cart-collect').click(function(){
		if($(this).hasClass('curr')){
			$(this).removeClass('curr');	
		}else{
			$(this).addClass('curr');		
		}	
	})
})
//结算页选项卡切换
$(function(){
	$(".address-box").click(function(){
		if($(this).hasClass('address-current-box')){
			$(this).removeClass('address-current-box');
		}else{
			$(this).addClass('address-current-box').siblings().removeClass('address-current-box');
		}
	})
})
$(function(){
	$(".pay-box").click(function(){
		if($(this).hasClass('pay-current-box')){
			$(this).removeClass('pay-current-box');
		}else{
			$(this).addClass('pay-current-box').siblings().removeClass('pay-current-box');
		}
	})
})
//发票信息
$('.pay-way li a').click(function(){
	$(this).addClass('pay-curr');
	$(this).parent('li').siblings().find('a').removeClass('pay-curr');
})
$('.coupons-title a').click(function(){
	var oCorner2 = $(this).find('i');
	if(oCorner2.hasClass('off')){
		$(this).parent().siblings().hide();
		oCorner2.removeClass('off');
	}else{
		$(this).parent().siblings().show();
		oCorner2.addClass('off');
	}
});

//guess like scroll
$(function(){
//	linum = $('.mainlist li').length;//图片数量
//	w = linum/2 * 210;//ul宽度
//	$('.piclist').css('width', w + 'px');//ul宽度
//	$('.swaplist').html($('.mainlist').html());//复制内容
//	
//	
//	
//	$('.goodlist').hover(function(){
//		$('.exchange',this).show();
//	},function(){
//		$('.exchange',this).hide();
//	}); 
});

//更多地址
$('.show-more-address').click(function(){


	var _index = $("#set-top-v").val();
	if(_index == '')
	{
		_index = 0;
	}

	$(".address-box").each(function(index){
		if(index == _index)
		{
			$(".address-total").prepend($(this));
			$("#set-top-v").val($(this).index())
		}

	});
	var oCorner = $(this).find('i');
	if(oCorner.hasClass('off')){
		$('.address-total').removeClass('height-auto');
		oCorner.removeClass('off');
	}else{
		$('.address-total').addClass('height-auto');
		oCorner.addClass('off');
	}
})