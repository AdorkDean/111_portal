// JavaScript Document
$(function(){
	/*header dropdown*/
	$('.dropdown').hover(function(){
		$(this).addClass('hover');	
	},function(){
		$(this).removeClass('hover');	
	});
	/*search associate*/
	$('.header-search-input').focus(function(){
		$('.associate-box').show();	
	})	
	$('.header-search-input').blur(function(){
		$('.associate-box').hide();	
	});
	/*nav menu*/
	$('#nav-menu .menu > li').hover(function(){
		$(this).find('.children').animate({ opacity:'show', height:'show' },200);
		$(this).find('.nav-dropdown').addClass('navhover');
	}, function() {
		$('.children').stop(true,true).hide();
		$('.nav-dropdown').removeClass('navhover');
	});
	/*column3*/
	$(".column2-list li").filter(function(i){
	if((i + 1)%2 == 0)
		$(this).css("margin-right",0);
	})
	/*column3*/
	$(".column3-list li").filter(function(i){
	if((i + 1)%3 == 0)
		$(this).css("margin-right",0);
	})
	/*column3*/
	$(".column4-list li").filter(function(i){
	if((i + 1)%4 == 0)
		$(this).css("margin-right",0);
	})
	/*sider-nav scroll*/
	$(window).scroll(function(){
		/*var oHotTop = $('.hot-today').offset().top;
		var oHotLeft = $('.hot-today').offset().left;
		var scrTop = $(window).scrollTop() || document.documentElement.scrollTop;
		scrTop >= oHotTop ? $(".sider-nav").addClass('Jfix'): $(".sider-nav").removeClass('Jfix');
		if(scrTop >= oHotTop){
			$(".sider-nav").addClass('Jfix').css("left",oHotLeft - 56 + "px")
		}else{
			$(".sider-nav").removeClass('Jfix').css	("left","-" + 56 + "px")
		}*/	
	});
	/*sider-nav list*/
	$('.sider-nav ul li').hover(function(){
		$(this).find('.current-s').show();
	},function(){
		$(this).find('.current-s').hide();	
	})
	$('.nav-hot').click(function(){
		var oHotDistance = $('.hot-today').offset().top;
		$('body').animate({scrollTop: oHotDistance},500);
	})
	$('.nav-recommend').click(function(){
		var oRecommendDistance = $('.recommend').offset().top;
		$('body').animate({scrollTop: oRecommendDistance},500);
	})
	$('.nav-family').click(function(){
		var oFamilyDistance = $('.family').offset().top;
		$('body').animate({scrollTop: oFamilyDistance},500);
	})
	$('.nav-gift').click(function(){
		var oGiftDistance = $('.gift').offset().top;
		$('body').animate({scrollTop: oGiftDistance},500);
	})
});

