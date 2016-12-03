function openBrowse(target){ 
	var ie=navigator.appName=="Microsoft Internet Explorer" ? true : false; 
	if(ie){ 
	document.getElementById(target).click(); 
	}else{
	var a=document.createEvent("MouseEvents");//FF的处理 
	a.initEvent("click", true, true);  
	document.getElementById(target).dispatchEvent(a); 
	} 
} 



var result = document.getElementById("result1"); 
var input = document.getElementById("file1"); 
 
if(typeof FileReader==='undefined'){ 
	input.attachEvent("onchange",loadImgForIE);
}else{ 
	input.addEventListener('change',readFile,false); 
} 

function readFile(){ 
	var file = this.files[0]; 
	if(!/image\/\w+/.test(file.type)){ 
		alert("文件必须为图片！"); 
		return false; 
	} 
	var reader = new FileReader(); 
	reader.readAsDataURL(file); 
	reader.onload = function(e){ 
		result.innerHTML = '<img src="'+this.result+'" width=60px height=60px />';
	} 
} 

function loadImgForIE(){
	var imagePath=input.value;
	result.innerHTML = '<img src="'+imagePath+'" width=60px height=60px />' 
}



var result2 = document.getElementById("result2"); 
var input2 = document.getElementById("file2"); 
 
if(typeof FileReader==='undefined'){ 
	input2.attachEvent("onchange",loadImgForIE2);
}else{ 
	input2.addEventListener('change',readFile2,false); 
} 

function readFile2(){ 
	var file = this.files[0]; 
	if(!/image\/\w+/.test(file.type)){ 
		alert("文件必须为图片！"); 
		return false; 
	} 
	var reader = new FileReader(); 
	reader.readAsDataURL(file); 
	reader.onload = function(e){ 
		result2.innerHTML = '<img src="'+this.result+'" width=60px height=60px />' 
	} 
} 

function loadImgForIE2(){
	var imagePath=input2.value;
	result2.innerHTML = '<img src="'+imagePath+'" width=60px height=60px />' 
}

