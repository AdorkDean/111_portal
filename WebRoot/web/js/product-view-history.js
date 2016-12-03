/**
 * The product history view plugin of js
 * @author LGP
 * @date 2015-08-29
 */
$(function()
{
	//商品ID
	var $proId = $.trim($("#gid").val());
	//商品图片
	var $goodaimg = $.trim($("#goodaimg").val());
	//名称
	var $goodsName = $.trim($("#goodsName").val());
	//价格
	var $pcPrice = $.trim($("#pcPrice").val());
	if($proId != '' && $proId != null)
	{
		var psets = getCookie("id");
		if(psets != null && psets != '')
		{
			var parray = $proId+"#"+$pcPrice+"#"+$goodaimg+"#"+removeSign($goodsName);
			var _parray = $pcPrice+"#"+$goodaimg+"#"+removeSign($goodsName);
			if(psets.indexOf(_parray) > 0)
			{
				psets = psets.replace(parray+":::","");
				delCookie("id");
				setCookie("id",psets);
			}
		}
		putProInCookie($proId, $pcPrice, $goodaimg, $goodsName);
	}
	var proInfos = ($invert(getCookie("id")) + "").replace(",", ":");
	//get product info from cookies
	try
	{
		proInfos = proInfos.substring(0,proInfos.length - 3);
		var jsonArry = proInfos.split(":::");
		var myprohisview = "";
		var lgth = jsonArry.length;
		if(parseInt(lgth) > 10)
		{
			lgth = 10;
		}
		if(lgth > 0)
		{
			for(var i=0;i<lgth;i++)
			{
				 //the detail of product
				 var proinfo = jsonArry[i].split("#");
				 //here is goodsid
				 var proId = proinfo[0];
				 //here is price
				 var price = proinfo[1];
				 //here is image
				 var proImg;
				 if(proinfo[2] == '' || proinfo[2] == null)
				 {
					 proImg = "/web/images/300.jpg";
				 }
				 else
				 {
					 proImg = imgUrl+proinfo[2];
				 }
				 //goods name
				 var goods_name = proinfo[3];
				 myprohisview += 
					"<li>"
					+"<a href='/p/"+proId+".html' target='_blank'>"
					+"<img src='"+proImg+"'/>"
					+"<p><span>¥"+price+"</span></p>"
					+"<p>"+goods_name+"</p>"
					+"</a>"
					+"</li>";
			}
			$("#myprohisview").append(myprohisview);
		}
	}
	catch(e)
	{
		 var myprohisview = "";
		 //the detail of product
		 var proinfo = proInfos.split("#");
		 //here is goodsid
		 var proId = proinfo[0];
		 //here is price
		 var price = proinfo[1];
		 //here is image
		 var proImg;
		 if(proinfo[2] == '' || proinfo[2] == null)
		 {
			 proImg = "/web/images/300.jpg";
		 }
		 else
		 {
			 proImg = proinfo[2];
		 }
		 //goods name
		 var goods_name = proinfo[3];
		 myprohisview += 
			"<li>"
			+"<a href='/p/"+proId+".html' target='_blank'>"
			+"<img src='"+proImg+"'/>"
			+"<p><span>￥"+price+"</span></p>"
			+"<p>"+goods_name+"</p>"
			+"</a>"
			+"</li>";
		$("#myprohisview").append(myprohisview);
	}
	
	
});

