$(function() 
{
	$.ajaxSetup
	({
		 cache: false
    });
	/** 推荐商品数据加载 */
	$.ajax(
	{  
		type: "get",               
		url: "/index!recommendpro.action",               
		success: function(data)
		{  
			var jsonArry = eval(data);
			var recmmd_02 = "";
			for(var i=0;i<jsonArry.length;i++)
			{
				//商品id
				var proId = jsonArry[i].id;
				//商品图片
				var proImg;
				if(jsonArry[i].proimg == '' || jsonArry[i].proimg == null)
				{
					proImg = "/web/images/300.jpg";
				}
				else
				{
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
				var hobB = "style='background:url(/web/images/gray_heart.png) no-repeat;'";
				if(isc == null)
				{
				}
				else
				{
					hobB = "style='background:url(/web/images/red_heart.png) no-repeat;'";
				}
				recmmd_02 += 
					"    <li>"
					+"        <a class='product-list-link' target='_blank' href='/p/"+proId+".html'>"
					+"            <img id='img_"+proId+"' src='"+proImg+"'/>"
					+"           <p class='product-list-price'>"
					+"           	<span id='price_"+proId+"'>¥"+saleprice+"</span><i>¥"+marketprice+"</i>"
					+"            </p>"
					+"            <p class='product-list-text'>"+goods_name
					+"            </p>"
					+"        </a>"              	          	
					+"        <div class='attention-into-cart clearfix clear'>"
					+"        	<a href='javascript:;' class='pay-attention' onclick='javascript:attention("+proId+",0,"+i+")'><i id='colt-"+i+"'"+hobB+"></i>关注</a>";
					if(jsonArry[i].type==2||jsonArry[i].type==3){
						recmmd_02 +="     <a target='_new' href='/p/"+proId+".html' class='list-into-cart' ><img src='/web/img/cart_ico_p.png' style='float:left;width:15px;height:15px;margin-top:5px;'/><span style='float:left;margin-left:5px;'>立即预订</span></a>";
					}else{
						recmmd_02 +="        	<a href='javascript:;' class='list-into-cart' onclick='addToCart("+proId+")'><img src='/web/img/cart_ico_p.png' style='float:left;width:15px;height:15px;margin-top:5px;'/><span style='float:left;margin-left:5px;'>加入购物车</span></a>";
					}
					recmmd_02+="        </div>"
					+"	</li>";
			 }
			 var htmlObj = recmmd_01 + recmmd_02 + recmmd_03;
			 $("#recommond-pro-id").append(htmlObj);
		 },  
		 error: function()
		 {  
		 }  
	}); 
	
});

var recmmd_01 = 
	"<div class='cart-filter-list clearfix clear' id='tuijian' style='overflow:hidden;float:left;margin-left:10px;'>"
	+"<div id='tuijianwrp'>"
	+"<ul class='filter-product-list clearfix clear' style='overflow:hidden;width:1029px;margin-left:0px;'>";

var recmmd_03 = 
	"</ul> "
	+"</div>"
	+"</div>";

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
		success: function(data) 
		{
			if(data == 1)
			{
				$("#colt-"+i).css("background","url(/web/images/red_heart.png) no-repeat");
			}
			else
			{
				$("#colt-"+i).css("background","url(/web/images/gray_heart.png) no-repeat");
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


function addToCart(id)
{
   var rs = add_cart(id,1);
   if(rs>0)
   {
	   $alert("success","已成功添加至购物车！","111医药馆提示您",null);
	   return false;
   }
   else if(rs==-2)
   {
	  $alert("warn","库存不足","111医药馆提示您",null);
	  return false;
   }
   else if(rs==-3)
   {
	  $alert("warn","该商品正促销中，超出了购买数量","111医药馆提示您",null);
	 return false;
   }
   else if(rs==-100)
   {
	   $alert("warn","该商品为处方药，请咨询购买","111医药馆提示您",null);
	   return false;
   }
   else if(rs==-200)
   {
	   $alert("warn","该商品为下架商品","111医药馆提示您",null);
	   return;
   }
   else if(rs==0)
   {
	  $alert("warn","操作失败","111医药馆提示您",null);
	  return false;
   }
}


















