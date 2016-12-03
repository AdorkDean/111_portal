var imgUrl = "http://img.zdfei.com/";
$(function(){
	var linum = 0;
	$.ajaxSetup ({
		 cache: false
    });
	/** 推荐商品数据加载 */
	$.ajax({  
		type: "get",               
		url: "/index!recommendpro.action",               
		success: function(data) {  
			var jsonArry = eval(data);
			var recmmd_02 = "";
			linum = jsonArry.length;
			for(var i=0;i<jsonArry.length;i++) {
				//商品id
				var proId = jsonArry[i].id;
				//商品图片
				var proImg;
				if(jsonArry[i].proimg == '' || jsonArry[i].proimg == null) {
					proImg = "/web/images/300.jpg";
				}
				else {
					proImg = imgUrl+jsonArry[i].proimg;
				}
				//市场价
				var marketprice = jsonArry[i].marketprice;
				//销售价
				var saleprice = jsonArry[i].saleprice;
				//商品名称
				var goods_name = jsonArry[i].goods_name;
				//是否已关注
				var isc = jsonArry[i].isc;
				var wuxing = "";
				if(isc!=null){
					wuxing = "curr";
				}
				/////////////////////////////////////////////////////////////////////////
				recmmd_02 +=
						"<li class='goodlist'>"
						+	"<a href='/p/"+proId+".html' target='_blank' style='overflow:hidden; display:block; float:left;'>" 
						+		"<img src='"+proImg+"' class='pics' /></a>"
						+	"<dl>"
						+		"<dt>"
						+		"	<a href='#' target='_blank' class='title'>"+goods_name+"</a>"
						+		"	<span class='en'>¥"+saleprice+"</span>"
						+		"	<p><span class='max-price'>￥"+marketprice+"</span></p>"
						+		"	<div class='exchange'>"
						+		"		<a href='javascript:void(0)' onclick='addToCart("+proId+")' class='add-shopping-cart'><i></i>加入购物车</a>"
						+		"		<a href='javascript:void(0)' id='colt-"+i+"' class='add-collect "+wuxing+"' onclick='javascript:attention("+proId+",0,"+i+")'><i></i><span>添加收藏</span></a>"
						+		"	</div>"
						+		"</dt>"
						+	"</dl>"
						+"</li>";
			 }
			 $(".mainlist").append(recmmd_02);
			 w = linum/2 * 420;//ul宽度
			 $('.piclist').css('width', w + 'px');//ul宽度
		 },  error: function() {  
		 }  
	}); 
	
$('.og_next').click(function(){
	if($('.swaplist,.mainlist').is(':animated')){
		$('.swaplist,.mainlist').stop(true,true);
	}
	if(linum>4){
			ml = parseInt($('.mainlist').css('left'));//默认图片ul位置;梯度:0px;-840px;-1680px;
			if(((linum/4)*(-840))<ml-840){
				$('.mainlist').animate({left: ml - 840 + 'px'},'slow');//默认图片滚动
			}else{
			}
	}
	
	
	
	
		
	})
	$('.og_prev').click(function(){
		if($('.swaplist,.mainlist').is(':animated')){
			$('.swaplist,.mainlist').stop(true,true);
		}
		//linum/4   屏数
		if(linum>4){
			//ml=0px;w=1680px;
			ml = parseInt($('.mainlist').css('left'));//主li，左距离
			if(ml<0 && ml>(w*-1)){
				$('.mainlist').animate({left: ml + 840 + 'px'},'slow');
			}else{
			}
		}
	});
});


/** 关注商品 */
function attention(proid,ctype,i)
{
	if(!checklogin())
	{
		window.location.href="/login/login!index.action?redirectUrl="+encodeURIComponent(window.location.href);
	}
	$.ajax(
	{
		url: "/index!attentionpro.action?proid="+proid+"&ctype="+ctype,
		type: "GET",
		dataType: "json",
		cache: false,
		async: false,
		success: function(data){
			if (data == 1) {//关注
				var flag = $("#colt-" + i).hasClass("curr");
				if(!flag){
					$("#colt-" + i).addClass("curr");
				}
//				$("#colt-" + i).css("background",
//						"url(/web/images/red_heart.png) no-repeat");
			} else {//取消关注
				var flag = $("#colt-" + i).hasClass("curr");
				if(flag){
					$("#colt-" + i).removeClass("curr");
				}
//				$("#colt-" + i).css("background",
//						"url(/web/images/gray_heart.png) no-repeat");
			}
		}
	});
}

function islogin_cart(){
	
  var n = 0;
  jQuery.ajax
   ({
       type: "post",
       url: "/carts/cart!isLogin.action",	
       async:false,
       success: function(data)
       {
    	  if(data>0){
    	  	n = 1;
    	  }
       }
   }); 
  return n;
}

/**checking login */
function checklogin() 
{
	var result = false;
	$.ajax(
	{
		url: "/index!clogin.action",
		type: "GET",
		dataType: "json",
		cache: false,
		async: false,
		success: function(data) 
		{
			if(data == 1)
			{
				result = true;
			}
		}
	});
	return result;
}


function addToCart(id){
	//0:参数错误;-1:库存不足，-2:下架;-3:处方药;-4:商品数大于促销;-5:已经购买过该促销商品的促销个数;-6:剩一条不能在减了;-99:内部错误
	var rs = add_cart(id, 1);
	if (rs > 0) {
		$alert("success", "已成功添加至购物车！", "111医药馆提示您", null);
		get_cart_sum();
		return false;
	} else if (rs == -1) {
		$alert("warn", "库存不足", "111医药馆提示您", null);
		return false;
	} else if (rs == -4) {
		$alert("warn", "该商品正促销中，超出了购买数量", "111医药馆提示您", null);
		return false;
	} else if (rs == -3) {
		$alert("warn", "该商品为处方药，请咨询购买", "111医药馆提示您", null);
		return false;
	} else if (rs == -2) {
		$alert("warn", "该商品为下架商品", "111医药馆提示您", null);
		return;
	} else if (rs == -7) {
		$alert("warn", "购物车单品不能超过199个", "111医药馆提示您", null);
		return;
	} else if (rs == 0) {
		$alert("warn", "操作失败", "111医药馆提示您", null);
		return false;
	}
}


function appendCartItemByAjax(id){
	jQuery.ajax
	   ({
	       type: "post",
	       url: "/carts/cart!ajaxCartItemByGoodsId.action",	 
	       data:{'goodsId':id},
	       async:false, 
	       success: function(data){
	    	   var json = jQuery.parseJSON(data);
	    	   var itemData = json.dataItm;
	    	   var inputCount = $("#count_"+itemData.itemid);
	    	   if(inputCount!=undefined&&inputCount.val()!=undefined){
	    		   var itemId = itemData.itemid;
	    		   $("#count_"+itemData.itemid).val(parseInt($("#count_"+itemData.itemid).val())+1);
	    		   $('#heji_'+itemId).html("<b>"+(parseFloat($('#price_'+itemId).text())*$("#count_"+itemId).val()).toFixed(2)+"</b>");
	    		   money();
	    		   checkChoose();
	    	   }else{
//	    		   window.location.reload(true);
//	    		   return ;
	    		   //alert("拼接字符串");
	    		   if(itemData==undefined||itemData==""){
	    			   window.location.reload(true);
	    			   
	    		   }else{
	    			   
	    			   var itemHtml = "";
	    			   if(itemData.is_selected==1){
	    				   itemHtml += "<li class='bgred clearfix clear' id='record_"+itemData.itemid+"'>";
	    			   }else{
	    				   itemHtml += "<li class='clearfix clear' id='record_"+itemData.itemid+"'>";
	    			   }
	    			   itemHtml += "<div class='w400 clearfix'>";
	    			   itemHtml += "	<div class='chioce-mark'>";
	    			   if(itemData.is_selected==1){
	    				   itemHtml += "     <a href='javascript:void(0)' name='item_checkbox' onclick='checkBox("+itemData.itemid+")' class='current' cid='"+itemData.itemid+"' id='check_"+itemData.itemid+"'></a>";
	    			   }else{
	    				   itemHtml += "     <a href='javascript:void(0)' name='item_checkbox' onclick='checkBox("+itemData.itemid+")' cid='"+itemData.itemid+"' id='check_"+itemData.itemid+"'></a>";
	    			   }
	    			   itemHtml += "             </div>";
	    			   itemHtml += "      <a href='#' class='shopping-cart-p-details'>";
	    			   itemHtml += "            <dl class='shopping-cart-info-text clearfix'>";
	    			   itemHtml += "                   <dt><a href='/p/"+itemData.goodsid+".html' target='_new'><img src='"+$("#imgUrl").val()+itemData.image_url+"'/></a></dt>";
	    			   itemHtml += "                 <dd>";
	    			   itemHtml += "                   <p class='shopping-cart-info-text-title'><a href='/p/"+itemData.goodsid+".html' target='_new'>"+itemData.goods_name+"</a></p>";
	    			   itemHtml += "                   <p class='shopping-cart-info-text-spec'>"+itemData.spec+"</p>";
	    			   itemHtml += "                    </dd>";
	    			   
	    			   if(itemData.ykt_flag==1){
	    				   itemHtml += "                  <dd>&nbsp;</dd>";
	    			   }else{
	    				   itemHtml += "	                    <dd> <span>（不支持医卡通支付）</span></dd>";
	    			   }
	    			   itemHtml += "                </dl>";
	    			   itemHtml += "              </a>";
	    			   itemHtml += "             </div>";
	    			   itemHtml += "            <div class='w125'>";
	    			   itemHtml += "             	<p class='shopping-cart-info-price' id='price_"+itemData.itemid+"'>"+itemData.pc_price+"</p>";
	    			   itemHtml += "              </div>";
	    			   itemHtml += "               <div class='w150'>";
	    			   itemHtml += "                            	<div class='shopping-cart-count' style='margin-bottom: 0px;'>";
	    			   itemHtml += "                                	<a href='javascript:void(0)' onclick='update("+itemData.itemid+","+itemData.goodsid+",2,1)' class='minu'>-</a>";
	    			   itemHtml += "                                	<input type='text' onKeyUp='validateMaxMoney(this)'  onblur='update("+itemData.itemid+","+itemData.goodsid+",3,this.value)' name='kuang' value='"+itemData.quantity+"' gid='"+itemData.goodsid+"'  id='count_"+itemData.itemid+"' maxlength='3'>";
	    			   itemHtml += "                                	<a href='javascript:void(0)' onclick='update("+itemData.itemid+","+itemData.goodsid+",1,1)' class='plus'>+</a>";
	    			   itemHtml += "                                	<div  style='display:none'>"+itemData.quantity+"_"+itemData.itemid+"</div>";
	    			   itemHtml += "                                </div>";
	    			   itemHtml += "                                <div id='tip_"+itemData.itemid+"' style='text-align: center;color:red;margin-top: 2px;' class='buzu'></div>";
	    			   itemHtml += "                            </div>";
	    			   itemHtml += "                       <div class='w125'>";
	    			   itemHtml += "                          <p class='shopping-cart-info-price' id='heji_"+itemData.itemid+"'><b>"+(parseFloat(itemData.quantity)*parseFloat(itemData.pc_price))+"</b></p>";
	    			   itemHtml += "                       </div>";
	    			   itemHtml += "                    <div class='w140'>";
	    			   itemHtml += "                 <div class='shopping-cart-operate'>";
	    			   itemHtml += "          <a href='javascript:void(0)' onclick='del("+itemData.itemid+")' class='shopping-cart-delete'></a>";
	    			   itemHtml += "    </div>";
	    			   itemHtml += " </div>";
	    			   itemHtml += "</li>";
	    			   $("#itmUl").append(itemHtml);
	    			   money();
	    			   checkChoose();
	    			   var marginTop = $(".shopping-cart-settlement").css("margin-top");
	    			   if(marginTop=="80px"){
	    				   $(".shopping-cart-settlement").attr("style","margin-top:0px");
	    			   }
	    			   if(marginTop=="160px"){
	    				   $(".shopping-cart-settlement").attr("style","margin-top:80px");
	    			   }
	    		   }
	    	   }
	       }
	   }); 
}

