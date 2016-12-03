$(function() {
	// $("#choose-info span").click(function(){
	// $(this).addClass('current').siblings().removeClass('current');
	// $("#choose-list
	// .list-con:eq("+$(this).index()+")").addClass('current').siblings().removeClass('current');
	// })
	$("#allComment").click(function() {
		$("#allComment").addClass('current').siblings().removeClass('current');
		window.location.href = "../member/comment!myGoodsCommentPage.action";
	});
	$("#bestComment").click(function() {
		$("#bestComment").addClass('current').siblings().removeClass('current');
		window.location.href = "../member/comment!myGoodsCommentPage.action?type=1";
	});
	$("#betterComment").click(function() {
		$("#betterComment").addClass('current').siblings().removeClass('current');
		window.location.href = "../member/comment!myGoodsCommentPage.action?type=2";
	});
	$("#poorComment").click(function() {
		$("#poorComment").addClass('current').siblings().removeClass('current');
		window.location.href = "../member/comment!myGoodsCommentPage.action?type=3";
	});
	var type = $("#_type").val();
	if (type == null || type == "") {
		$("#allComment").addClass('current').siblings().removeClass('current');
	}
	if (type == 1) {
		$("#bestComment").addClass('current').siblings().removeClass('current');
	}
	if (type == 2) {
		$("#betterComment").addClass('current').siblings().removeClass('current');
	}
	if (type == 3) {
		$("#poorComment").addClass('current').siblings().removeClass('current');
	}
})