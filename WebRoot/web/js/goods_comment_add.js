$(document).ready(function() {
	$('.star-bg a').click(function() {
		$(this).addClass('star-active').siblings().removeClass('star-active');
		var _star = $(this).attr("class").substring(4,5);
		if(0<_star.parseInt<5){
			$(this).parent("span").siblings("input").val(_star);
		}
	})
	$('.show-dis').click(function() {
		$(this).parents('.dis-all').siblings('form').children(0).show();
		$(this).parents('li').siblings().find('.dis-input-box').hide();
	})
});

/**
 * 添加评论
 */
function saveComment(id) {
	var goods = $("#subForm_" + id).find("input[name='goods']").val();
	var seller = $("#subForm_" + id).find("input[name='seller']").val();
	var fastMail = $("#subForm_" + id).find("input[name='fastMail']").val();
	var fastMailPeople = $("#subForm_" + id).find(
			"input[name='fastMailPeople']").val();
	var anonymous = $("#subForm_" + id).find("input[name='anonymous']").val();
	var comment = $("#subForm_" + id).find("textarea[name='comment']").val();
	if (goods == null || goods == "" || seller == null || seller == ""
			|| fastMail == null || fastMail == "" || fastMailPeople == null
			|| fastMailPeople == "") {
		$alert("warn", "请先选择评分等级!");
		return false;
	}
	if(comment==null|| comment=="" || comment.length<10){
		$alert("warn", "麻烦填写10-400个字");
		return false;
	}
	
	$.ajax({//setShowGoodsComment
		url: "../member/comment!saveGoodsComment.action",
		type: "POST",
		data: {
			'id':id,'goods':goods,'seller':seller,'fastMail':fastMail,'fastMailPeople':fastMailPeople,'comment':comment,'anonymous':anonymous
		} ,
		success: function(data){
			if(data.status==1){
				$alert("success","评论成功");
				$("#subForm_" + id).hide();
				$("#if_" + id).html("已评论");
				$("textarea").text("");
			}else if(data.status==2){
				$alert("warn",data.message);
				$("#subForm_" + id).hide();
				$("#if_" + id).html("已评论");
			}else{
				$alert("warn",data.message);
			}
		},error:function(data){
			$alert("warn","内部错误,请稍后重试!");
			window.location.reload(true);
		}
	});
	
}
var iii = 0;
/**
 * 匿名复选
 */
function checkedAnonymous(id){
	if(iii==0){
		$("#subForm_" + id).find("input[name='anonymous']").val(1);
		iii = 1;
	}else{
		$("#subForm_" + id).find("input[name='anonymous']").val("");
		iii = 0;
	}
}


/**
 * textarea文本输入还能输入多少
 */
function checkLen(obj) {
	var maxChars = 400;//最多字符数
	if (obj.value.length > maxChars)
	obj.value = obj.value.substring(0,maxChars);
	var curr = maxChars - obj.value.length;
	document.getElementById("leaveCount").innerHTML = curr.toString();
}
$(function(){
	
	var tt = $("textarea[name='comment']").val();
	if(undefined !=tt && tt.length!=null && tt.length>400){
		$("textarea[name='comment']").html(tt.substring(0,400));
		document.getElementById("leaveCount").innerHTML = 400-tt.length;
	}else if(undefined !=tt && tt.length!=null && tt.length<=400){
		document.getElementById("leaveCount").innerHTML = 400-tt.length;
	}else if(undefined !=tt && tt.length!=null){
		document.getElementById("leaveCount").innerHTML = 400;
	}
})