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
			$("#img100").src= imagePath;
			$("#img48").src= imagePath;
		}else{ 
			var reader = new FileReader(); 
			reader.readAsDataURL(file); 
			reader.onload = function(e){
				$("#img148").attr("src",this.result);
				$("#img100").attr("src",this.result);
				$("#img48").attr("src",this.result);
			}
			
			return true; 
		} 
	});
	
	
	$("#imageSubmit").click(function(){
	
		if(!$("#head").triggerHandler("change")){
			return;
		}	
	    var formData = new FormData($('#inputForm')[0]);
	    $.ajax({
	        url: '/member/profile!uploadHeadPortrait_2.action',  //server script to process data
	        type: 'POST',
	        //Ajax事件
	        beforeSend: function(){},
	        success: function(data){
	        	var imgPath = decodeURIComponent(data);
	        	$("#headPortrait").attr("src",imgPath);
	        	$alertCanDisplay("success","上传成功！","友情提示",null);
	        	$("#out6").hide();
	 	        $("#shade").hide();
	 	        $("#head").val('');
	        	
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

function clearImgDiv(){
	$("#img148").attr("src","");
	$("#img100").attr("src","");
	$("#img48").attr("src","");
}

$('.data-header-img').hover(function(){
    $('.data-header-btn',this).show();
},function(){
    $('.data-header-btn',this).hide();
});

//弹窗、遮罩层
function outs(click_id,out_id,shade_id){
    $(click_id).click(function(){
    	clearImgDiv();
    	
        $(shade_id).css({
            display:"block"
        })
        $(out_id).show();

    })
    $(".close-out").click(function(){
        $(out_id).hide();
        $(shade_id).hide();

    })
}
outs(".popup-btn6","#out6","#shade");

$("#btn-close").click(function(){
	$("#out6").hide();
    $("#shade").hide();
	clearImgDiv();
});