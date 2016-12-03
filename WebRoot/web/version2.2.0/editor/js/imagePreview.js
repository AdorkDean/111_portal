function readFile(obj){
	var file = obj.files[0]; 
	if(typeof(file) == "undefined"){
		return false;
	}
	if(!/image\/jpeg/.test(file.type) && !/image\/png/.test(file.type) && !/image\/jpg/.test(file.type) && !/image\/JPG/.test(file.type) && !/image\/PNG/.test(file.type))
	{ 
		$alert("warn","图片文件格式不正确！")
		$(obj).val("");
		return false; 
	}
	if(file.size>2097152){ 
		$alert("warn","文件必须小于等于2M"); 
		$(obj).val("");
		return false; 
	}
	var reader = new FileReader(); 
	reader.readAsDataURL(file); 
	reader.onload = function(e){
		$(obj).siblings("span")[0].innerHTML = '<img style="width:108px;height:78px;" src="'+this.result+'" alt="" id=""/>' ;
	} 
}
function loadImgForIE(obj){
	var imgPath=$(obj).val();
	$(obj).siblings("span")[0].innerHTML = '<img src="'+this.result+'" alt="" id=""/>' ;
}