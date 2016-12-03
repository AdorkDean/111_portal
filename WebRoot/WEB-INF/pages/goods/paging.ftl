    <div class="page-jump fr">
        <span id="psizeid"></span><span>到第</span><input type="text" value="1" id="pageval"/><span class="page_y">页</span>
        <a href="javascript:;" class="page_make" onclick="pageQuery();">确定</a>
    </div>
    <div class="page clearfix">
    	<input type="hidden" value="" id="pageSizeId"/>
    	<input type="hidden" value="" id="pageId"/>
    	<input type="hidden" value="0" id="typeId"/>
        <a href="javascript:;" class="page-next" onclick="pageNext();" id="pnextid" >下一页 &gt;&gt;</a>
        <span id="span2" style="display:none">...</span>
        <div id="adiv"></div>
        <span id="span1" style="display:none">...</span>
        <a href="javascript:;" class="page-prev" onclick="pagePrev();">&lt;&lt; 上一页</a>
    </div>
<script type="text/javascript">
	function paging(page,pageSize){
		$("#psizeid").text("共"+pageSize+"页，");	
		$("#pageSizeId").val(pageSize);
		$("#pageId").val(page);
		setA();
	}
	function pageQuery(){
		var pagev = $("#pageval").val();
		var size = $("#pageSizeId").val();
		var type= $("#typeId").val();
		if(isInts(pagev)){
			if(Number(pagev)>0&&Number(pagev)<=Number(size)){
				$("#pageId").val(pagev);
				setA();
				updata(pagev,type);
			}else{
				alert("输入页数有误!");
			}
		}else{
			alert("请输入数字!");
		}
	}
	function isInts(str){
    if (str == ""){
      	return false;
    }
    var r = /^[0-9]+$/;
    return r.test(str);
}
	function pageQueryVal(v){
		$("#pageId").val(v);
		var type= $("#typeId").val();
		setA();
		updata(v,type);
	}
	function pagePrev(){
		var index= $("#pageId").val();
		var type = $("#typeId").val();
		if(index==1){
			$("#pagePrev").unbind("click");
		}else{
			$("#pageId").val(Number(index)-Number(1));
			setA();
			updata(Number(index)-Number(1),type);
		}
	}
	function pageNext(){
		var size = $("#pageSizeId").val();
		var index= $("#pageId").val();
		var type= $("#typeId").val();
		if(index==size){
			$("#pnextid").unbind("click");
		}else{
			$("#pageId").val(Number(index)+Number(1));
			setA();
			updata(Number(index)+Number(1),type);
		}
	}
	function setA(){
		var size = $("#pageSizeId").val();
		var index= $("#pageId").val();
		var htmla = "";
		if(size<5){
			$("#span1").hide();
			$("#span2").hide();
			for (var i = 1; i <= size; i++) {
				htmla = "<a href='javascript:;' id='a"+i+"' name='aids' onclick='pageQueryVal("+i+")'>"+i+"</a>"+htmla
			}
		}else if (index==size) {
			$("#span1").show();
			$("#span2").hide();
			for (var i = Number(index)-Number(4); i <=size; i++) {
				htmla = "<a href='javascript:;' id='a"+i+"' name='aids' onclick='pageQueryVal("+i+")'>"+i+"</a>"+htmla
			}
		}else if(index<=3){
			$("#span1").hide();
			$("#span2").show();
			for (var i = 1; i <= 5; i++) {
				htmla = "<a href='javascript:;' id='a"+i+"' name='aids' onclick='pageQueryVal("+i+")'>"+i+"</a>"+htmla
			}
		}else if (index>=3&&(index<=Number(size)-Number(3))) {
			$("#span1").show();
			$("#span2").show();
			for (var i = Number(index)-Number(2); i <= Number(index)+Number(2); i++) {
				htmla = "<a href='javascript:;' id='a"+i+"' name='aids' onclick='pageQueryVal("+i+")'>"+i+"</a>"+htmla
			}
		}else if(index>=(Number(size)-Number(2))){
			$("#span1").show();
			$("#span2").hide();
			for (var i = Number(index)-Number(3); i <=size; i++) {
				htmla = "<a href='javascript:;' id='a"+i+"' name='aids' onclick='pageQueryVal("+i+")'>"+i+"</a>"+htmla
			}
		}
		$("#adiv").html("");
		$("#adiv").append(htmla);
		$("#a"+index+"").attr("class","current");
	}
	function updata(pages,type){
		jQuery.ajax({
		       type: "post",
		       async: false,
		       url: " ${base}/goodsComment/ajaxGoodsComment!getListByAjax.action",	  
		       data:{"goodsId":$("#gid").val(),"type":type,"currentPage":pages},
		       success: function(data){
		       		$("#pageSizeId").val(data.pageSize);
		       		$("#psizeid").text("共"+data.pageSize+"页，");
		       		$("#allData"+type+"").find("li").remove(); 
		      		var allData = "";
		      		for(var i=0; i<data.list.length; i++){
						allData=allData+'<li class="clearfix clear"><div class="w380"><div class="column1"><div class="assess-text"><span class="fr">'+data.list[i].createDate+'</span>'+data.list[i].comment+'</div></div></div>'+
						'<div class="w328"><div class="column2"><div class="start-bg"><span class="start start'+parseInt(data.list[i].sumFraction/4)+'"></span></div></div></div><div class="w300"><div class="column3"><dl class="assess-person">'+
						'<dt><img src="${base}'+data.list[i].headPortrait+'"/>'+data.list[i].userName+'</dt></dl></div></div></li>';
                	} 
					$("#allData"+type+"").append(allData);
		       },error:function(){
		       		alert("网络异常");
		       }
		   }); 
		}
		function tabonc(v){
			$("#typeId").val(v);
			updata(1,v);
			$("#pageId").val(1);
			setA();
		}
</script>