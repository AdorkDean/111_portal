<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- description -->
    <meta name="description" content="">
    <!-- keywords -->
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>修改头像</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="/web/img/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="/web/img/favicon-196x196.png">
    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="img/apple-icon-touch.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="img/win8-tile-icon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
</head>
<body>
<#include "/static/inc/center_header.ftl">
<link rel="stylesheet" type="text/css" href="${base}/web/css/commonNew.css"/>
<link rel="stylesheet" type="text/css" href="${base}/web/css/member.css"/>
<div class="member-line">
    <div class="member-wrap">
        <!-------左侧菜单------->
        <#include "/WEB-INF/pages/member/left-menu.ftl">
        <!------右侧-------->
        <form id="inputForm" name="inputForm" method="post" enctype="multipart/form-data">
        <div class="member-content">
            <div class="head-portrait">
                <div class="info">头像照片</div>
                <div class="head-main">
                    <div class="select-head">
                        <div class="style">
                            <div class="inp">选择您要上传的头像</div>
                            <p>仅支持JPG、GIF、PNG、JPEG、BMP格式，文件小于4M</p>
                            <input id="head" name="head"  type="file" class="file-btn"/>
                        </div>
                        <div class="pic">
                            <img id="img148" src="" alt=""/>
                        </div>
                        <div class="save-btn">
                        	<input id="imageSubmit" type="button" value="保存" style="display:block;"/>
                        </div>
                    </div>
                    <div class="preview">
                          <div class="txt">
                              <h3>预览效果</h3>
                              <p>你上传的图片会自动生成2种尺寸，请注意小尺寸的头像是否清晰</p>
                          </div>
                        <div class="pic-b">
                        
                        
                            <img id="img140" src="" alt=""/><span>140*140像素</span>
                        </div>
                        <div class="pic-s">
                            <img id="img76" src="" alt=""/><span>76*76像素</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
    </div>
</div>
<#include "/static/inc/footer.ftl">
</body>
</html>
<script type="text/javascript" src="${base}/web/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" >
$().ready(function(){
	
	$("#head").change(function(){
	
		var file = this.files[0]
		
		if(file == undefined){
			return false;
		}
		var name = file.name;
    	var size = file.size;
    	var type = file.type;
    	
	    if(size > 4 *1024*1024){
	    	alert("文件不能大于4M!");
	    	return false;
	    }
	    
	    //JPG、GIF、PNG、JPEG、BMP
	    if(!(type.toLocaleUpperCase().toString().indexOf('JPG')>0
	    	||type.toLocaleUpperCase().toString().indexOf('GIF')>0
	    	||type.toLocaleUpperCase().toString().indexOf('PNG')>0
	    	||type.toLocaleUpperCase().toString().indexOf('JPEG')>0
	    	||type.toLocaleUpperCase().toString().indexOf('BMP')>0)){
	    	alert("文件格式只能是JPG、GIF、PNG、JPEG、BMP!");
	    	return false;
	    }
		
		if(typeof FileReader == 'undefined'){ 
			var imagePath=input.value;
			
			$("#img148").src= imagePath;
			$("#img140").src= imagePath;
			$("#img76").src= imagePath;
		}else{ 
			var reader = new FileReader(); 
			reader.readAsDataURL(file); 
			reader.onload = function(e){
				$("#img148").attr("src",this.result);
				$("#img140").attr("src",this.result);
				$("#img76").attr("src",this.result);
			}
			
			return true; 
		} 
	});
	
	
	$("#imageSubmit").click(function(){
	
		if(!$("#head").triggerHandler("change")){
			return;
		}	
	    
	    var formData = new FormData($('form')[0]);
	    $.ajax({
	        url: '${base}/member/profile!uploadHeadPortrait.action',  //server script to process data
	        type: 'POST',
	        //Ajax事件
	        beforeSend: function(){},
	        success: function(){
	        	$alert("success","上传成功！","友情提示",null);
	        	setTimeout("reload()",3000);
	        	
	        },
	        error: function(){},
	        // Form数据
	        data: formData,
	        cache: false,
	        contentType: false,
	        processData: false
	    });
	    
	    
	});
});
function reload(){
	window.location.href="${base}/member/order.action";
}
</script>
