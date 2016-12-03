$(function()
{
	$(".morev_h").show();
	$(".right_cons").hide();
	$(".morev_h").mouseover(function()
	{
		var left = $(".morev_h").offset().left - 35;
		$(".right_cons").css({"position":"absolute","z-index":"999","background":"#f8f8f8","left":left}).show();
		$(".morev_h").hide();
	});
	$(".right_cons").mouseleave(function()
	{
		$(".morev_h").show();
		$(".right_cons").hide();
	});
});