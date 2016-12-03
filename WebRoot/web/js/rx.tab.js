// JavaScript Document
	function del_fun(id){
		$("#del_").val(id);
	}
    $(document).ready(function() {
		//选项卡
		function tabs(tabTit, on, tabCon) {
                    $(tabCon).each(function () {
                        $(this).children().eq(0).show();
                    });
                    $(tabTit).children().click(function () {//鼠标“click”的效果
                        $(this).addClass(on).siblings().removeClass(on);
                        var index = $(tabTit).children().index(this);
                        $(tabCon).children().eq(index).show().siblings().hide();
                    });
                }
                //tabs("#tab-hd", "active", "#tab-bd");
				//tabs("#tab-hd3", "active2", "#tab-bd3");
				//tabs("#tab-hd4", "active2", "#tab-bd4");
		
				function tabtems(tabTit, on, tabCon) {
                    $(tabCon).each(function () {
                        $(this).children().eq(0).show();
                    });
                    $(tabTit).each(function () {
                        $(this).children().eq(0).addClass(on);
                    });
                    $(tabTit).children().click(function () {//鼠标“click”的效果
                        $(this).addClass(on).siblings().removeClass(on);
                        var index = $(tabTit).children().index(this);
                        $(tabCon).children().eq(index).show().siblings().hide();
                    });
                }
				tabtems("#tab-hd2", "active2", "#tab-bd2");
		//弹窗、遮罩层
		function outs(click_id,out_id,shade_id){
                $(click_id).click(function(){
                $(shade_id).css({
                    display:"block"
                })
				alert($("#del_").val());
                $(out_id).show();
				
                })
                $(".close-out").click(function(){
                    $(out_id).hide();
                    $(shade_id).hide();
                    
                })
            }
            outs("#popup-btn1","#out1","#shade");
			outs("#popup-btn2","#out2","#shade");
			outs(".popup-btn3","#out3","#shade");
			outs(".popup-btn4","#out4","#shade");
		
		//结算页展开收起
        $('.receiving-address-list').hover(function(){
			$(this).addClass('receiving-address-curr');
		},function(){
			$(this).removeClass('receiving-address-curr');	
		})
		$('.receiving-address-list').click(function(){
			$(this).addClass('receiving-address-curr2');
			$(this).parents('li').siblings().find('.receiving-address-list').removeClass('receiving-address-curr2');
		})
		$('.show-more-address').click(function(){
			var oCorner = $(this).find('i');
			if(oCorner.hasClass('off')){
				$('.more-receiving-address').removeClass('height-auto');
				oCorner.removeClass('off');
			}else{
				$('.more-receiving-address').addClass('height-auto');
				oCorner.addClass('off');
			}
		})
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
			
		})
		
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
		
		//品牌列表
		var oCount = $('.for-count li').length;
		if(oCount<18){
			$('.multi-line').css({"height":"auto"});
			$('.filter-brand-more').hide();
		}else{
			$('.filter-brand-more').show();	
		}
		
		//商品列表展开收起
		$('.filter-brand-more').click(function(){
			var oCorner3 = $(this).find('b');
			if(oCorner3.hasClass('off')){
				$('.multi-line').removeClass('height-auto');
				$(this).find('span').html('更多');
				oCorner3.removeClass('off');
			}else{
				$('.multi-line').addClass('height-auto');
				$(this).find('span').html('收起');
				oCorner3.addClass('off');
			}
		})
		//商品详情展开收起
		$('.promotion-info a').click(function(){
			var oCorner4 = $(this).find('i');
			if(oCorner4.hasClass('off')){
				$('.promotion-info').removeClass('height-auto');
				oCorner4.removeClass('off');
			}else{
				$('.promotion-info').addClass('height-auto');
				oCorner4.addClass('off');
			}
		})
		
		//飞入购物车
		
		
		$('.btn-buy').bind('click',function(){
			
			var goodsid = $(this).attr('id');
			
			 var rs = add_cart(goodsid,1);
			 if(rs>0){
				
			 }else{
				 mywarn(rs);
				 return;
			 }
			  /* if(rs>0){
				   // getCartSum(1);   
			   }else if(rs==-2){
					  $alert("warn","库存不足","111医药馆提示您",null);
					  return false;
			   }else if(rs==-3){
				  $alert("warn","该商品正促销中，超出了购买数量","111医药馆提示您",null);
				 return false;
			   }else if(rs==-100){
				   $alert("warn","该商品为处方药，请咨询购买","111医药馆提示您",null);
				   return false;
			   }else if(rs==-200){
				   $alert("warn","该商品为下架商品","111医药馆提示您",null);
				   return;
			   }else if(rs==0){
				  $alert("warn","操作失败","111医药馆提示您",null);
				  return false;
			   }*/
			   
			   
			var img = $(this).parents('li').find('img');
			var flyElm = img.clone().css('opacity', 0.75);
			$('body').append(flyElm);
			flyElm.css({
				'z-index': 9000,
				'display': 'block',
				'position': 'absolute',
				'top': img.offset().top,//+$(document).scrollTop(),//img.offset().top +'px',
				'left': img.offset().left,//img.offset().left +'px',
				'width': img.width() +'px',
				'height': img.height() +'px'
			});
			
			flyElm.animate({
				top: $('.header-cart').offset().top,
				left: $('.header-cart').offset().left,
				width: 20,
				height: 32
			}, 'slow', function() {
				 flyElm.remove();   
			});
			
			

		}); 
		
	
    });
    
    
    
