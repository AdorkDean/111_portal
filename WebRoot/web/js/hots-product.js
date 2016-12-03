/** 
 * 推荐商品数据加载[猜你在找]
 * @author LGP
 * @date 2015-08-20
 */
var visitUrl = "http://app.portal.com:8083/";
var imgUrl = "http://img.zdfei.com";
var liLg = 0;
var url = visitUrl + "/sltRouter?method=getRecommendGoods&platform_type=1";
if(liLg == 0)
{
	$.ajax(
	{  
    	type: "GET",               
        url: url,  
        async:false, 
		dataType: "jsonp",
		jsonp: "jsoncallback",              
        success: function(data)
        {  
        	var lg = data.rlist.length;
        	if(lg > 0)
        	{
        		var o = data.rlist;
	        	var lis = "";
	        	for(var i=0; i<lg; i++)
	        	{
	        		 var id = o[i].pid;
	        		 var price = o[i].price;
	        		 var image = "/web/images/300.jpg";
	        		 if(o[i].image != '' && o[i].image != null)
	        		 {
	        			 image = imgUrl + o[i].image;
	        		 }
	        		 //商品名称
	        		 var name = o[i].name;
	        		 lis += 
        			 "<li>"
        			 +"<a href='/p/"+id+".html' target='_blank'>"
        			 +"<img src='"+image+"'/>"
        			 +"<p><span>¥"+price+"</span></p>"
        			 +"<p>"+name+"</p>"
        			 +"</a>"
        			 +"</li>";
	        	}
	        	$("#hotsproducts").append(lis);
        	}
        },  
        error: function(e){console.log("e=["+e+"]");} 
	 });
	 liLg = 2;
}

function getScrollTop()
{
    var scrollTop=0;
    if(document.documentElement&&document.documentElement.scrollTop)
    {
        scrollTop=document.documentElement.scrollTop;
    }
    else if(document.body)
    {
        scrollTop=document.body.scrollTop;
    }
    return scrollTop;
}

function atted(id,i)
{
   if(checklogin())
   {
	   $.get("/index!attentionpro.action?proid="+id+"&ctype=0",null,function(data)
	   {
		   if(data == 1)
		   {
			   $("#atted-btn-"+i).attr("class","add-collect curr");
		   }
		   else
		   {
			   $("#atted-btn-"+i).attr("class","add-collect");
		   }
        });
   }
   else
   {
	   window.location.href = "/login/login!index.action?redirectUrl="+location.href;
   }
}  