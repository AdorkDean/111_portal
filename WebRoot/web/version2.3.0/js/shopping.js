// JavaScript Document
$(function(){
	//shopping choice input
	$('.chioce-mark a').click(function(){
		if($(this).hasClass('current')){
			$(this).removeClass('current');	
		}else{
			$(this).addClass('current');		
		}
	})
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
	linum = $('.mainlist li').length;//图片数量
	w = linum/2 * 210;//ul宽度
	$('.piclist').css('width', w + 'px');//ul宽度
	$('.swaplist').html($('.mainlist').html());//复制内容
	
	$('.og_next').click(function(){
		
		if($('.swaplist,.mainlist').is(':animated')){
			$('.swaplist,.mainlist').stop(true,true);
		}
		
		if($('.mainlist li').length>4){//多于4张图片
			ml = parseInt($('.mainlist').css('left'));//默认图片ul位置
			sl = parseInt($('.swaplist').css('left'));//交换图片ul位置
			if(ml<=0 && ml>w*-1){//默认图片显示时
				$('.swaplist').css({left: '840px'});//交换图片放在显示区域右侧
				$('.mainlist').animate({left: ml - 840 + 'px'},'slow');//默认图片滚动				
				if(ml==(w-840)*-1){//默认图片最后一屏时
					$('.swaplist').animate({left: '0px'},'slow');//交换图片滚动
				}
			}else{//交换图片显示时
				$('.mainlist').css({left: '840px'})//默认图片放在显示区域右
				$('.swaplist').animate({left: sl - 840 + 'px'},'slow');//交换图片滚动
				if(sl==(w-840)*-1){//交换图片最后一屏时
					$('.mainlist').animate({left: '0px'},'slow');//默认图片滚动
				}
			}
		}
	})
	$('.og_prev').click(function(){
		
		if($('.swaplist,.mainlist').is(':animated')){
			$('.swaplist,.mainlist').stop(true,true);
		}
		
		if($('.mainlist li').length>4){
			ml = parseInt($('.mainlist').css('left'));
			sl = parseInt($('.swaplist').css('left'));
			if(ml<=0 && ml>w*-1){
				$('.swaplist').css({left: w * -1 + 'px'});
				$('.mainlist').animate({left: ml + 840 + 'px'},'slow');				
				if(ml==0){
					$('.swaplist').animate({left: (w - 840) * -1 + 'px'},'slow');
				}
			}else{
				$('.mainlist').css({left: (w - 840) * -1 + 'px'});
				$('.swaplist').animate({left: sl + 840 + 'px'},'slow');
				if(sl==0){
					$('.mainlist').animate({left: '0px'},'slow');
				}
			}
		}
	});
	
	$('.goodlist').hover(function(){
		$('.exchange',this).show();
	},function(){
		$('.exchange',this).hide();
	}); 
});

//结算页展开收起
$('.address-box').hover(function(){
	$(this).addClass('address-current-box');
},function(){
	$(this).removeClass('address-current-box');
})

$('.address-box').click(function(){
	$(this).addClass('address-current-box2');
	$(this).parents('li').siblings().find('.address-box').removeClass('address-current-box2');
	$("#set-top-v").val($(this).parents('li').index());
})
//更多地址
$('.show-more-address').click(function(){


	var _index = $("#set-top-v").val();
	if(_index == '')
	{
		_index = 0;
	}

	$(".address-box li").each(function(index){
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

//
$('.city-ipt2').click(function(){
	$('.third-out').show();
})

$('.choice-city').click(function(){
	$('.second-out').show();
})
$('.close-city').click(function(){
	$('.second-out').hide();
})
$('.close-add').click(function(){
	$('.third-out').hide();
})
$('.search-location').click(function(){
	$('.map-location-list').show();
})


//弹窗、遮罩层
function outs(click_id,out_id,shade_id){
	$(click_id).click(function(){
		alert(1);
		$(shade_id).css({
			display:"block"
		})
		/*alert($("#del_").val());*/
		$(out_id).show();

	})
	$(".close-out").click(function(){
		$(out_id).hide();
		$(shade_id).hide();

	})
}
//outs("#popup-btn1","#out1","#shade");
//outs("#popup-btn2","#out2","#shade");
//outs(".popup-btn3","#out3","#shade");
//outs(".popup-btn4","#out4","#shade");
//outs(".popup-btn5","#out5","#shade");
//outs(".popup-btn6","#out6","#shade");

//发票信息弹窗操作
$('.invoice-info-list li').click(function(){
	$(this).addClass('invoice-curr');
	$(this).siblings().removeClass('invoice-curr');
})
$('.invoice-list li').click(function(){
	$(this).addClass('invoice-curr').siblings().removeClass('invoice-curr');
})
$('.invoice-company').hover(function(){
	$(this).find('.invoice-operate').show();
},function(){
	$(this).find('.invoice-operate').hide();
})
$('.edit-btn').click(function(){
	$(this).parents('li').addClass('invoice-curr');
	$(this).parents('.invoice-company-info').addClass('invoice-company-edit');
	$(this).parents('li').siblings().find('.invoice-company-info').removeClass('invoice-company-edit');
})
$('.save-btn').click(function(){
	$(this).parents('li').addClass('invoice-curr');
	$(this).parents('.invoice-company-info').removeClass('invoice-company-edit');
	$(this).parents('li').siblings().find('.invoice-company-info').removeClass('invoice-company-edit');
})
//银行卡
$('.pay-terrace-list li').click(function(){
	if($(this).hasClass('show')){
		$(this).removeClass('show');
	}else{
		$(this).addClass('show').siblings().removeClass('show');
	}
})
$('.pay-terrace-list li').hover(function(){
	$(this).addClass('show2');
},function(){
	$(this).removeClass('show2');
})
