function changeRandomCode(){
	var random_code_img = $('#code');
	random_code_img.src=random_code_img.src+"?"; 
	random_code_img.attr("src",random_code_img.attr("src")+"?");
 }

document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
     if(e && e.keyCode==13){ // enter 键
       login();
    }
}; 
     

function login(){
	var name = $('#name').val();
	    var pwd = $('#pwd').val();
	    var code = $('#cd').val();
	    var error = $('.error_ico');
	    var erinfo = "";
	    if($.trim(name)==""){
	    	error.text("请输入用户名");
	    	$('#name').focus();
	    	error.show();
	    	return;	
	    }
	    if($.trim(pwd)==""){
	    	error.text("请输入密码");
	    	$('#pwd').focus();
	    	error.show();
	    	return;
	    }
	    if($.trim(code)==""){
	    	error.text("请输入验证码");
	    	$('#cd').focus();
	    	error.show();
	    	return;
	    }
	   
	    var rand = getRand();
	    if($.trim(code)!=rand){
	    	error.text("验证码输入错误");
	    	changeRandomCode();
	    	$('#cd').focus();
	    	error.show();
	    	return;
	    }
	    error.hide();
	   $(this).css("background-color","#B4B2AD");
	   $('#lf').submit();
	   $(this).unbind();
}
 
// login
$(document).ready(function (){
	
	 $('#lobut').bind('click', function() {
	     login();
	 });
});

// 注册 
$(document).ready(function (){
	
	 $('#joinbtn').bind('click', function() {
	    
		 var name = $('#name').val();
	    var pwd = $('#pwd').val();
	    var rpwd = $('#rpwd').val();
	    var code = $('#cd').val();
	    var email = $('#email').val();
	   
	    if($.trim(name)==""){
	    	$('#nspan').text("请输入用户名");
	    	$('#name').focus();
	    	$('#nspan').show();
	    	return;	
	    }else{
	    	var nd = namesd()
	        if(nd>0){
	     	$('#nspan').text("该用户名已被注册");
	        	$('#nspan').show();
	        	$('#name').focus();
	        	return;
	        }
	    }
	    
	    $('#nspan').hide();
	    // 邮箱验证
       
        if(validate.isEmpty(email)){
        	$('#espan').text("邮箱不能为空");
        	$('#email').focus();
        	$('#espan').show();
        	return;
        }else{
        	var ismail = validate.isEmail(email);
        	if(!ismail){
        		$('#espan').text("邮箱格式不正确,请认真填写");
        		$('#espan').show();
        		$('#email').focus();
        		return;
        	}
        }
        
        $('#espan').hide();
	    if($.trim(pwd)==""){
	    	$('#pspan').text("请输入密码");
	    	$('#pwd').focus();
	    	$('#pspan').show();
	    	return;
	    }
	    
	     if($.trim(rpwd)==""){
	    	$('#rspan').text("请再次输入密码");
	    	$('#rpwd').focus();
	    	$('#rspan').show();
	    	return;
	    }else{
	    	if($.trim(pwd)!=$.trim(rpwd)){
		    	$('#rspan').text("两次输入的密码不一致");
		    	$('#rpwd').focus();
		    	$('#rspan').show();
		    	return;
	    	}
	    }
	     $('#pspan').hide();
	     $('#rspan').hide();
	    if($.trim(code)==""){
	    	$('#cspan').text("请输入验证码");
	    	$('#cd').focus();
	    	$('#cspan').show();
	    	return;
	    }
	  
	    var rand = getRand();
	    if($.trim(code)!=rand){
	    	$('#cspan').text("验证码输入错误");
	    	changeRandomCode();
	    	$('#cd').focus();
	    	$('#cspan').show();
	    	return;
	    }
	    $('#cspan').hide();
	    
	    var agree = $('#agree').is(':checked');
	    if(!agree){
	    	alert("请同意798艺术品全球推广平台注册协议");
	    	return;
	    }
	    if(agree){
		$(this).css("background-color","#B4B2AD"); 
		$(this).val("正在注册...");
		$(this).unbind();
	    var f = $('#reform');
	       jQuery.ajax
		  	({
		       type: "post",
		       url: jsCtx+"/user/users!register.action",	
		       async:false,
		       data:f.serialize(),
		       success: function(data)
		       {    
			   		if(data>0){
			   			alert("注册成功");
			   			window.location.href=jsCtx+"/user/users!login_page.action";
			   		}
		       }
		     }); 
	    }
	    
	 });
});


function namesd(){
	var name = $('#name').val();
	var n = 0;
	jQuery.ajax
  	({
       type: "post",
       url: jsCtx+"/user/users!webNamesd.action",	
       async:false,
       data:{'name':name},
       success: function(data)
       {    
	   		n = data;
       }
     }); 
     return n;
}



 function getRand(){
    var code = "";
 	jQuery.ajax
	 ({
       type: "post",
       url: jsCtx+"/user/users!isRand.action",	
       async:false,
       success: function(data)
       {    
	   		code = data;
       }
     });
     return code;
 }
 
 $(document).ready(function (){
	  $('#stepfirst').bind('click', function(){
			var name = $('#name').val();
		    var code = $('#cd').val();
		   
		    if($.trim(name)==""){
		    	$('#stspan').text("请输入用户名");
		    	$('#name').focus();
		    	$('#stspan').show();
		    	return;	
		    }else{
		    	var nd = namesd()
		        if(nd==0){
		     	$('#stspan').text("该用户名不存在");
		        	$('#stspan').show();
		        	$('#name').focus();
		        	return;
		        }
		    }
		 $('#stspan').hide();
		if($.trim(code)==""){
	    	$('#st2span').text("请输入验证码");
	    	$('#cd').focus();
	    	$('#st2span').show();
	    	return;
	    }
	   
	    var rand = getRand();
	    if($.trim(code)!=rand){
	    	$('#st2span').text("验证码输入错误");
	    	changeRandomCode();
	    	$('#cd').focus();
	    	$('#st2span').show();
	    	return;
	    }
	    $('#st2span').hide();
	  
	    $(this).css("background-color","#B4B2AD");
	    $('#form2').submit();
	    $(this).unbind();
	    
	  });
 });
 
 
 function updatePassword(){
	 
	 var pwd1 = $('#pwd1').val();
	 var pwd2 = $('#pwd2').val();
	 if($.trim(pwd1)==""){
		 $('#sppwd1').text("密码不能为空");
		 $('#sppwd1').show();
		 $('#pwd1').focus();
		 return;
	 }
	  $('#sppwd1').hide();
	 if($.trim(pwd2)==""){
		 $('#sppwd2').text("请再次确认密码");
		 $('#sppwd2').show();
		 $('#pwd2').focus();
		 return;
	 }
	 if($.trim(pwd1) != $.trim(pwd2)){
		 $('#sppwd2').text("再次输入的密码不一致");
		 $('#sppwd2').show();
		 return;
	 }
	$('#sppwd2').hide();
	$('#upbut').css("background-color","#B4B2AD");
    $('#alertform').submit();
    $('#upbut').unbind();
   
	  
 }

