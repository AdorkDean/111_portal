var client_key = "111yao";
var imgurl = "http://img.zdfei.com/";
//限购数量前端代码改此处
var cartMaxNum = 50000;

function shortBug(id){
	var count = $('.product_nums_in').val();
	if(count=='' || count==0){
		count = 1;
	}
	
	var rs = add_cart(id,count);
	 if(rs>0){
		 //window.location.href="/member/order!toOrderAdd.action";
		 window.location.href="/carts/cart!page.action?url="+window.location.href;
		 return false;
	   }else{
		   mywarn(rs);
	   }
}

function cartRecomm(){

	$('#shopping-list-ul-ljl').html("");
	//$('#recommond-pro-id-ljl').html("");
	jQuery.ajax
	   ({
	       type: "post",
	       url: "/index!recommendpro.action",	 
	       async:false, 
	       success: function(data)
	       {
	    	   //var s=jQuery.parseJSON(data);
	    	    var jsonArry = eval(data);
	    	    var n = 0;
				for(var i=0;i<jsonArry.length;i++)
				{ 
					
					// 加入 购物车弹出层推荐的三个商品
					if(n<3){
						
						$('#shopping-list-ul-ljl').append("<li><a href='/p/"+jsonArry[i].id+".html' target='_new'><img style='width:120px;height:120px' src='"+imgUrl+jsonArry[i].proimg+"'/></a><p style='width:150px;overflow:hidden;'><a href='/p/"+jsonArry[i].id+".html' target='_new'>"+jsonArry[i].goods_name+"</a></p><span>￥"+jsonArry[i].saleprice.toFixed(2)+"<b>￥"+jsonArry[i].marketprice.toFixed(2)+"</b></span></li>");
					}
					
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
					
					// 购物车页下的推荐商品列表 
					
					var str = "<li>"
                    +"<a class='product-list-link' href='/p/"+jsonArry[i].id+".html' target='_new'>"
                    +"<img src='"+imgurl+jsonArry[i].proimg+"'  id='img_"+jsonArry[i].id+"'/></a>"
                    +"<p class='product-list-price'><span id='price_"+jsonArry[i].id+"'>¥"+jsonArry[i].saleprice+"</span><i>¥"+jsonArry[i].marketprice+"</i> </p>"
                    +"<a class='product-list-link' href='/static/product/p/"+jsonArry[i].id+".html' target='_new'><p class='product-list-text'>"+jsonArry[i].goods_name+"</p></a>"
                    +"<div class='attention-into-cart clearfix clear'>"
                    +"<a href='javascript:void(-1);' onclick='attention("+jsonArry[i].id+",0,"+i+")' class='pay-attention'><i id='colt-"+i+"'"+hobB+"></i>关注</a>";
                    if(jsonArry[i].type==2||jsonArry[i].type==3){
                    	str+="<a target='_new' href='/p/"+jsonArry[i].id+".html'  class='list-into-cart'><i></i>立即预订</a></div></li>";
                    }else{
                    	str+="<a href='javascript:void(-1);' onclick='add4("+jsonArry[i].id+")' class='list-into-cart'><i></i>加入购物车</a></div></li>";
                    }
                    $('#recommond-pro-id-ljl').append(str);
				    n++;
				}
	       }
	   }); 
	
}



function recommend(){
	 jQuery.ajax
	   ({
	       type: "post",
	       url: "/carts/cart!recommend.action",	 
	       async:false, 
	       success: function(data)
	       {
	       	 	alert(data);
	       }
	   }); 
}


function goodsDetailRecomm(){
	
	var id = $("#gid").val();
	$('#shopping-list-ul-ljl').html("");
	jQuery.ajax
	   ({
	       type: "post",
	       url: "/index!hotpros.action?goodsid="+id,	 
	       async:false, 
	       success: function(data)
	       {
	    	   var s=jQuery.parseJSON(data);
	    	   var i = 0;
	    	   $.each(s, function(i, n){
	    		    if(i<3)
	    		    $('#shopping-list-ul-ljl').append("<li><a href='javascript:void(-1);'><img src='"+imgurl+s.proimg+"'/><p>"+n.goods_name+"</p></a><span>￥"+n.pc_price+" <b>￥"+n.pc_price+"</b></span></li>");
	          	  	i++;
	           });
	       }
	   }); 
}


//鼠标滑过购物车特效
$("#mycart-id").mouseover(function()
{
	var dis = $('#empty2').css('display');
	if(dis=='none'){
		getCartSum(2);
    }else{
 	   
    }
	
	$(this).attr("class","header-cart show-empty fr");
})
$("#mycart-id").mouseleave(function()
{
	$('#empty1').hide();
	$('#empty2').hide();
	$(this).attr("class","header-cart fr");
	
});



function getCartSum(n){
	
	
   jQuery.ajax
   ({
       type: "post",
       url: "/carts/cart!getCartSum.action",	 
       async:false, 
       success: function(data)
       {
       	  var s=jQuery.parseJSON(data);
       	  if(s.cnt>99){
       		$('#csum').text("99+");
       		$('#cnt2').text("99+");
       		
       	  }else{
       		$('#csum').text(s.cnt);
       		$('#cnt2').text(s.cnt);
       		
       	  }
       	  
       	  if(s.cnt>0){
       		$('#cnt2').show();
       	  }else{
       		$('#cnt2').hide();
       	  }
       	  
          if(n!=1)
          {
        	  
          	$('#cart-product-top').html("");
          	
          	if(s.cnt==0){
          		$('#empty2').hide();
          		$('#empty1').show();
          		
         	 }else{
          		$('#empty1').hide();
          		$('#empty2').show();
          		
            }
          	
          //	alert("s.zongjia==="+s.zongjia);
          	
          	$('#zj').html(s.zongjia);
          	$('#zj2').html(s.zongjia);
          	$('#yh').html(s.youhui);
          	$.each(s.list, function(i, n){
          	  	$('#cart-product-top').append("<li  id='record_"+n.itemid+"' ><a href='javascript:void(0)' onclick='del_html("+n.itemid+")' class='delete-cart-pro'>删除</a><a href='/p/"+n.goodsid+".html' target='_new' class='cart-pro'><img src="+imgurl+n.image_url+"><div class='cart-pro-text'><p>"+n.goods_name+"</p><p><span>¥"+n.pc_price+"</span>X"+n.quantity+"</p></div></a></li>");
         	 });
          
          }
          
       }
   }); 
  
 }



function getCartSumBottom(){
	
	 jQuery.ajax
	   ({
	       type: "post",
	       url: "/carts/cart!getCartSum.action",	 
	       async:false, 
	       success: function(data)
	       {
	    	   var s=jQuery.parseJSON(data);
	    	  
	    	   if(s.cnt==0){
	          		$('#cart02').hide();
	          		$('#cart01').show();
	          		$('#cnt2').hide();
	    	   	 	
	         	 }else{
	         		 
	         		$('#sider-cart-id').find('.sider-hover').stop(true,true).fadeIn();
	         		$('#sider-cart-id').find('.sider-show').stop(true,true).fadeIn();
	    	   	 	
//	          		$('#cart01').hide();
//	          		$('#cart02').show();
	          		$('#cnt2').show();
	          		$('#cart-product-bottom').html("");
		          	$.each(s.list, function(i, n){
		          	  	$('#cart-product-bottom').append("<li id='recordbotom_"+n.itemid+"' ><a onclick='del_index_bottom("+n.itemid+")' href='javascript:void(0)' class='delete-cart-pro'>删除</a><a href='/p/"+n.goodsid+".html' target='_new' class='cart-pro'><img src="+imgurl+n.image_url+"><div class='cart-pro-text'><p>"+n.goods_name+"</p><p><span>¥"+n.pc_price+"</span>X"+n.quantity+"</p></div></a></li>");
		         	 });
	            }
	    	   
	    	    if(s.cnt>99){
	    	    	 $('#cnt2').text("99+");
	    	    }else{
	    	    	 $('#cnt2').text(s.cnt);
	    	    }
	    	   
	          	$('#zj2').html(s.zongjia);
	          	$('#yh2').html(s.youhui);
	          	
	          	 // var sCartCount = $('.sider-cart-list ul li').length;
	      	    var sCartCount = $('#cart-product-bottom').children().length;      	    
		      	  if(sCartCount>=3){
		              $('.sider-cart-list').css("top","-142px");
		      		$('.sider-cart-list').find('.white-s-bar').css("top","139px");
		          }else if(sCartCount==2){
		      		$('.sider-cart-list').css("top","-77px");
		      		$('.sider-cart-list').find('.white-s-bar').css("top","74px");	
		      	}else if(sCartCount==1){
		      		$('.sider-cart-list').css("top","-13px");
		      		$('.sider-cart-list').find('.white-s-bar').css("top","10px");
		      	}
	      	  
	      	    
	      	    
	       }
	   }); 
	 
	  
}




$(document).ready(function (){
	
	$('#count-plus').unbind('click').bind('click', function() {
		
		var input = $(this).parent().find("input");
		var old_val = input.val();
		if(old_val==''){
		        input.val(1);
		        return ;
		}
		if(input.val()<1000){
			input.val(parseInt(old_val)+1);
		}
	});
	
	$('#count-minus').unbind('click').bind('click', function() {
		
		var input = $(this).parent().find("input");
		var old_val = input.val();
		if(old_val==''){
	        input.val(1);
	        return ;
		}
		if(input.val()>1){
			input.val(parseInt(old_val)-1);
		}
	});
	
	$('.go-on').bind('click', function() {
		$('#shade').hide();
	});
	
	
	
	$("input[name='kuang']").focusout(function () {
		 var patrn=/^[0-9]{1,20}$/; 
		 var bakval = $(this).parent().find('div'); 
		 var ary = bakval.text().split("_");
		 var itemid = ary[1];//购物车项id
		 var oldval = ary[0];//旧个数
		 var goodId = $(this).attr("gid");
	
		 var kuang_val = $(this).val();
		 if(!patrn.exec($.trim(kuang_val))){
			 $(this).attr("value",oldval);
			 return ;
		 }
		 if(kuang_val<=0){
			 $(this).val("1");
			 kuang_val=1;
		 }
		 if(kuang_val>cartMaxNum){
//			 $(this).val(oldval);
			 $alert("warn","最多添加"+cartMaxNum+"个","111医药馆提示您",null);
			 $(this).val(cartMaxNum+"");
//			 return;
		 }
		 update(itemid,goodId,3,kuang_val);

	})
	
	
	
	
});





function addtc(id){
	
   var rs = add_cart(id,1);
   if(rs>0){
	 var key = getCookie("111yao");
	  window.location.href="/carts/cart!page.action?key="+key;
	  return false;
   }else {
	   mywarn(rs);
	   return;
   }
}

function addCartAlert(id){
	var rs = add_cart(id,1);
	  if(rs>0){
		 $alert("success","加入成功","111医药馆提示您",null);
	   }else{
		   mywarn(rs);
		   return;
	   }
}




function add2(id,obj){
	
	$('#mprice').text($('#price_'+id).text());
	$('#mpic').attr("src",$('#img_'+id).attr('src'));
	//$('#mpic').attr("src","http://ui.111yao.com/upload/image/201411/5ec340ed-1a84-478c-b17e-b610f73d032d-large.jpg");
	$('#mcnt').text(1);
	
    var rs = add_cart(id,1);
    
    
   if(rs>0){
	  // $('#shade-child').show();
	   $('#shade').show();
	   
	   return false;
   }else{
	   mywarn(rs);
   }
}


function add3(id,obj){
	
    var rs = add_cart(id,1);
    
   if(rs>0){
	  // $('#shade-child').show();
	   get_cart_sum();
	   $alert("success","添加成功","111医药馆提示您",null);
	   return false;
   }else{
	   mywarn(rs);
   }
}


function add4(id,obj){
	
	
    var rs = add_cart(id,1);
    
   if(rs>0){
	  // $('#shade-child').show();
	   $alert("success","添加成功","111医药馆提示您",null);
	   window.location.reload();
	   return false;
   }else{
	   mywarn(rs);
   }
}



function add(id){
	
	var img = $("#goodaimg").val();
	var name = $("#goodsName").val();
	var price = $("#pcPrice").val();
	var id = $("#gid").val();
	
	$('#mpic').attr("src",imgurl+img);
	
	var count = $('.count-text').val();
	if(count=='' || count==0){
		count = 1;
	}
	
	$('#mcnt').text(count);
	
	$('#mprice').text(parseInt(count)*parseFloat(price));
	
	var rs = add_cart(id,count);
   if(rs>0){
	  
	  var img = $('.pro-img');
		var flyElm = img.clone().css('opacity', 0.75);
		$('body').append(flyElm);
		flyElm.css({
			'z-index': 9000,
			'display': 'block',
			'position': 'absolute',
			'top': img.offset().top +'px',
			'left': img.offset().left +'px',
			'width': img.width() +'px',
			'height': img.height() +'px'
		});
		flyElm.animate({
			top: $('#mycart-id').offset().top,
			left: $('#mycart-id').offset().left,
			width: 20,
			height: 32
		}, 'slow', function() {
			flyElm.remove();
		});
		
   }
   
   else if(rs==-2){
	  $alert("warn","库存不足","111医药馆提示您",null);
	  return false;
   }else if(rs==-3){
	  $alert("warn","该商品正促销中，超出了购买数量","111医药馆提示您",null);
	 return false;
   }else if(rs==-100){
	   $alert("warn","该商品为处方药，请咨询购买","111医药馆提示您",null);
	   return false;
   }else if(rs==-200){
	   $alert("warn","该商品为下架商品","111医药馆提示您",null);
	   return;
   }else if(rs==0){
	  $alert("warn","操作失败","111医药馆提示您",null);
	  return false;
   }
	
}





function islogin(){
	var n =0;
	  jQuery.ajax
	   ({
	       type: "post",
	       url: jsCtx+"/carts/cart!isLogin.action",	 
	       async:false, 
	       success: function(data)
	       {
	    	  
	    	  if(data>0){
	    	  	$('.cart-login-tips').hide();
	    	  }else{
	    	  	$('.cart-login-tips').show();
	    	  }
	    	  n = data;
	       }
	   }); 
	  
	  return n;
}



function checkEmpty(){
	var flag = false;
	var n = 0;
	var len = $("label[name='item-checkbox']").each(function(){
		flag = $(this).hasClass('checked-curr');
		if(flag==true){
			n++;
		}
	});
	
	var btn = $('.go-settle-accounts'); 
	if(n==0){
		btn.css('background','#BDB0B0');
		btn.unbind();
		//window.location.reload();
	}else{
		btn.css('background','#e37070');
		btn.click(function(){
			window.location.href=jsCtx+"/member/order!toOrderAdd.action";
		});
	}
}

function delCheckEmpty(){
	var flag = false;
	var n = 0;
	var len = $("label[name='item-checkbox']").each(function(){
//		flag = $(this).hasClass('checked-curr');
//		if(flag==true){
//			n++;
//		}
		n++;
	});
	if(n==0){
		
		window.location.reload();
	}
}

function add_cart(gid,cnt){
	
   var status = 0;
   jQuery.ajax
   ({
       type: "post",
       url: "/carts/cart!addCart.action",	  
       data:{'gid':gid,'cnt':cnt},
       async:false,
       success: function(data)
       {
    	   
    	   var s=jQuery.parseJSON(data);
    	   status = s.status;
    	   if(s.status>0)
    	   {
    		   getCartSum(1); 
    	   }
       }
   }); 
   return status;

}


function money_index(){
	
	jQuery.ajax
   ({
       type: "post",
       url:"/carts/cart!money.action", 
       success: function(data)
       {
    	  
    	   var s=jQuery.parseJSON(data);
    	   
    	   $('#zj2').text(s.money.toFixed(2));
    	   $('#yh2').text(s.youhui.toFixed(2));
    	   
    	   if(s.count>99){
        	   $('#csum').text("99+");
        	   $('#cnt2').text("99+");
    	   }else{
    		   $('#csum').text(s.count);
        	   $('#cnt2').text(s.count);
    	   }
    	   
    	  
    	   
//    	   if(s.count==0){
//    		   $('.header-cart-count').hide();
//    		   $('#cnt2').hide();
//    	   }else{
//    		   $('.header-cart-count').show();
//    		   $('#cnt2').show();
//    	   }
    	   
       }
   }); 
}


function money(){
	
	
	jQuery.ajax
   ({
       type: "post",
       url:jsCtx+"/carts/cart!money.action", 
       success: function(data)
       {
    	   var s=jQuery.parseJSON(data);
    	   $('#money').text(s.money.toFixed(2));
    	   $('#money1').text(s.money.toFixed(2));
    	   $('#g-count').text(s.count);
    	  
    	   $('#youhui').text(s.youhui.toFixed(2));
    	   
    	   $('#zj2').text(s.money.toFixed(2));
    	   $('#yh2').text(s.youhui.toFixed(2));
    	   $('#cnt2').text(s.count);
    	   

    	   
    	   if(s.gift.length>0){
    		   $.each(s.gift, function(i, n){
        		   if(n.promid>0)
        		   {
        			   $('#gift-div-'+n.promid).show();
            		   $('#gift-ul-'+n.promid).html("<li><a href='/p/"+n.goodsid+".html' target='_new'><img src='"+imgurl+n.image_url+"'/></a></li>");
        		   }else{
        			   $('#gift-div-'+n.promid).hide();
        		   }
               });
    	   }else{
    		   $('.non-selling').hide();
    	   }
    	  
    	   
       }
   }); 
}

/**
 * 拼接的li输入框失去焦点事件
 */
//function inputBoxBlur(){
//	
//}


var _count = 0;
function update(cartid,goodsid,flag,count){
	if(_count==0){
		_count = 1;
		var old_val=  $("#count_"+cartid).val();
		if(flag==1){//+
//			$("#count_"+cartid).val(parseInt(old_val)+1);
		}else if(flag==2){//-
			if(old_val==1){
				_count = 0;
				return;
			}
//			$("#count_"+cartid).val(parseInt(old_val)-1);
			
		}
		if(flag=="1"&&(parseInt(old_val)+count>cartMaxNum)){
//		$("#count_"+cartid).val(old_val);
			$alert("warn","最多添加"+cartMaxNum+"个","111医药馆提示您",null);
			$("#count_"+cartid).val(cartMaxNum);
			_count = 0;
			return;
		}
		if(flag=="3"&&count>cartMaxNum){
			$alert("warn","最多添加"+cartMaxNum+"个","111医药馆提示您",null);
			$("#count_"+cartid).val(cartMaxNum);
			count = cartMaxNum;
			_count = 0;
			return;
		}
		if(old_val<=0){
			location.reload();
			return;
		}
		
		jQuery.ajax
		({
			type: "post",
			url: jsCtx+"/carts/cart!update.action",	  
			async: false,
			data:{"cartid":cartid,"goodsid":goodsid,"flag":flag,"count":count},
			success: function(data)
			{
				var s=jQuery.parseJSON(data);
				
				if(s.data>0)
				{
					$('#heji_'+cartid).html("<b>"+(parseFloat($('#price_'+cartid).text())*$("#count_"+cartid).val()).toFixed(2)+"</b>");
					money();
					get_cart_sum();
					_count = 0;
				}else{
					$("#count_"+cartid).val(s.cnt);
					mywarn(s.data);
					if(s.data==-100){
						$('#record_'+cartid).remove();
						var itms = $("a[name='item_checkbox']").length;
						if(itms<=0){
							window.location.reload(true);
						}
					}
				}
				
				if(flag==1){
					$("#count_"+cartid).val(parseInt(old_val)+1);
				}else if(flag==2){
					$("#count_"+cartid).val(parseInt(old_val)-1);
				}
				_count = 0;
			}
		}); 
		
	}
}


function collect(cartid,goodsid){
	
	var isLogin = islogin();
	if(isLogin==0){
		window.location.href=jsCtx+"/login/login!index.action?redirectUrl="+window.location.href;
	}
	
   jQuery.ajax
   ({
       type: "post",
       url: jsCtx+"/carts/cart!collect.action",	  
       data:{"cartid":cartid,"goodsid":goodsid},
       success: function(data)
       {
          if(data>0){
        	  $('#record_'+cartid).remove();
        	  money();
        	  checkEmpty();
          }
       }
   }); 
}

function del(id){
	
   jQuery.ajax
   ({
       type: "post",
       url: jsCtx+"/carts/cart!del.action",	  
       data:{"id":id},
       success: function(data)
       {
          if(data>0){
        	  $('#record_'+id).remove();
        	  money();
//        	  delCheckEmpty();
        	  checkChoose();
        	  var itms = $("a[name='item_checkbox']").length;
        	  get_cart_sum();
        	  
    		if(itms<=0){
    			window.location.reload(true);
    		}else if(itms==1){
    			$(".shopping-cart-settlement").attr("style","margin-top:160px");
    		}else if(itms==2){
    			$(".shopping-cart-settlement").attr("style","margin-top:80px");
    		}else if(itms>=3){
    			$(".shopping-cart-settlement").attr("style","margin-top:0px");
    		}
          }
       }
   }); 
}


function del_html(id){
	
   jQuery.ajax
   ({
       type: "post",
       url: "/carts/cart!del.action",	  
       data:{"id":id},
       success: function(data)
       {
          if(data>0){
        	  $('#record_'+id).remove();
        	   //money();
        	   getCartSum(2);
        	  
        	  var child =  $('#cart-product-top').children().length;
        	  // alert(child);
        	   if(child==0){
        	   	    $('#empty2').hide();
        	 		$('#empty1').show();
        	 		$('#csum').text(0);
        	   }
        	  
          }
       }
   });
   
   
   
   /*
   var bottomitem = $("li[name='bottomitem']").length;
   if(bottomitem==0){
	   
	   $('#cart01').show();
	   $('#cart02').hide();
   }
*/
	  
	  
}


function mytest(id){
	$('#recordbotom_'+id).remove();
	
	var sCartCount = $('#cart-product-bottom').children().length;
	//alert(sCartCount);
    if(sCartCount>=3){
        $('.sider-cart-list').css("top","-196px");
    }else if(sCartCount==2){
		$('.sider-cart-list').css("top","-126px");	
	}else if(sCartCount==1){
		$('.sider-cart-list').css("top","-61px");	
	}
	    
}

function del_index_bottom(id){

   jQuery.ajax
   ({
       type: "post",
       url: "/carts/cart!del.action",	  
       data:{"id":id},
       success: function(data)
       {
    	  
          if(data>0){
        	  $('#recordbotom_'+id).remove();
        	   var ul = $('#cart-product-bottom').children('li').length;
        	   money_index();
        	   if(ul==0){
        		   $('#cart02').hide();
        		   $('#cart01').show();
        	   }
          }
          
            var sCartCount = $('#cart-product-bottom').children().length;
          		//alert("sCartCount=="+sCartCount);
            if(sCartCount>=3){
	              $('.sider-cart-list').css("top","-142px");
	      		$('.sider-cart-list').find('.white-s-bar').css("top","139px");
	          }else if(sCartCount==2){
	      		$('.sider-cart-list').css("top","-77px");
	      		$('.sider-cart-list').find('.white-s-bar').css("top","74px");	
	      	}else if(sCartCount==1){
	      		$('.sider-cart-list').css("top","-13px");
	      		$('.sider-cart-list').find('.white-s-bar').css("top","10px");
	      	}
       }
   }); 
   		
   
}


$(document).ready(function(){

   $('#allchk').click(function(){
	   
	 
	   
   		var flag = $(this).hasClass('checked-curr');
   	    var str = "";
       $("label[name='item-checkbox']").each(function(){
       	  str =  str +","+ this.id;
       });
       str = str.substring(1,str.length);
       var x = 0;
         if(flag){
         	 $(this).removeClass('checked-curr');
         }else{
             x = 1;
         	 $(this).addClass('checked-curr');
         }
        jQuery.ajax
	   ({
	       type: "post",
	       url: jsCtx+"/carts/cart!allChecked.action",	  
	       data:{"x":x,"id":str},
	       success: function(data)
	       {
	          if(data>0){
	          	 if(flag){
		         	 $("label[name='item-checkbox']").removeClass('checked-curr');
		         }else{
		         	  $("label[name='item-checkbox']").addClass('checked-curr');
		         }
	          	 money();
	          	 checkEmpty();
	          }
	         
	       }
	   }); 
      
   });
   
    $("label[name='item-checkbox']").click(function() {
    	
         var flag = $(this).hasClass('checked-curr');
        
         var x = 0;
         if(flag){
         	 $(this).removeClass('checked-curr');
         }else{
             x = 1;
         	 $(this).addClass('checked-curr');
         }
        
	    jQuery.ajax
	   ({
	       type: "post",
	       url: jsCtx+"/carts/cart!checked.action",	  
	       data:{"x":x,"id":$(this).attr("cid")},
	       async:false, 
	       success: function(data)
	       {
	          if(data>0){
	          	 if(flag){
		         	 $(this).addClass('checked-curr');
		         }else{
		         	 $(this).removeClass('checked-curr');
		         }
	          	 money();
	          	 checkEmpty();
	          }
	         
	       }
	   }); 
	    checkedStatus();
        
    });
});



function checkedStatus(){
	 var a1= $("label[name='item-checkbox']").length;
	    var n = 0;
	    var len = $("label[name='item-checkbox']").each(function(){
			flag = $(this).hasClass('checked-curr');
			if(flag==true){
				n++;
			}
		});
		  
		if(a1!=n){
			$('#allchk').removeClass('checked-curr');
		}else{
			$('#allchk'). addClass('checked-curr');
		}
}


function mywarn(rs)
{
   if(rs>0)
   {
	   $alertCanDisplay("success","加入成功！","111医药馆提示您",null);
   }
   else if(rs == 0)
   {
  	 $alertCanDisplay("warn","参数错误！","111医药馆提示您",null);
   }
   else if(rs == -1)
   {
  	 $alertCanDisplay("warn","库存不足！","111医药馆提示您",null);
   }
   else if(rs == -2)
   {
  	 $alertCanDisplay("warn","该商品为下架商品！","111医药馆提示您",null);
   }
   else if(rs == -3)
   {
  	 $alertCanDisplay("warn","该商品为处方药，请联系客服购买！","111医药馆提示您",null);
   }
   else if(rs == -4)
   {
  	 $alertCanDisplay("warn","该商品数大于促销数量！","111医药馆提示您",null);
   }
   else if(rs == -5)
   {
  	 $alertCanDisplay("warn","您已经购买过该促销商品！","111医药馆提示您",null);
   }
   else if(rs == -7)
   {
  	 $alertCanDisplay("warn","购物车单品不能超过"+cartMaxNum+"条","111医药馆提示您",null);
   }
   else if(rs == -99)
   {
	   $alertCanDisplay("warn","服务器内部错误！","111医药馆提示您",null);
   }
   else if(rs == -100)
   {
	   $alertCanDisplay("warn","该商品已被删除","111医药馆提示您",null);
	   
   }
   
   
}



function validateMaxMoney(obj) {
	// 先把非数字的都替换掉，除了数字和.
	obj.value = obj.value.replace(/[^\d]/g, "");
	// 必须保证第一个为数字而不是.
	obj.value = obj.value.replace(/^/g, "");
	// 保证只有出现一个.而没有多个.
	obj.value = obj.value.replace(/\.{2,}/g, ".");
	// 保证.只出现一次，而不能出现两次以上
	obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$",
			".");
//	if (obj.value.indexOf(".") != -1) {
		var subVar = obj.value.substring(obj.value.indexOf(".") + 1,
				obj.value.length);
		if (subVar.length > 6) {
			obj.value = obj.value.substring(0, obj.value.length
					- (subVar.length - 6));
		}
//	}
}



function checkBox(itemId){
	var _Obj = $("#check_"+itemId);
	var flag = _Obj.hasClass('current');//click之后是反着的
	var x = '0';
	if (!flag) {
		x = '1';
		if(!_Obj.hasClass("current")){
			_Obj.addClass("current");
		}
		_Obj.parent("div").parent("div").parent("li").addClass('bgred');
	} else {
		if(_Obj.hasClass("current")){
			_Obj.removeClass("current");
		}
		_Obj.parent("div").parent("div").parent("li").removeClass('bgred');
	}
	jQuery.ajax({
		type : "post",
		url : jsCtx + "/carts/cart!checked.action",
		data : {
			"x" : x,
			"id" : _Obj.attr("cid")
		},
		async:false,
		success : function(data) {
			var s=jQuery.parseJSON(data);
	       	  
			if (s.data > 0) {
//				if (!flag) {
//					_Obj.addClass('current');
//				} else {
//					_Obj.removeClass('current');
//				}
				money();
//				checkEmpty();
			}
			////:0:医卡通不选全部选,1:医卡通选;2:全选
			if(s.ifYkt==1){
				$("#all_only").removeClass('current');
				$("#ykt_only").removeClass('current');
				$("#ykt_only").addClass('current');
			}else if(s.ifYkt==2){
				$("#all_only").removeClass('current');
				$("#ykt_only").removeClass('current');
				$("#all_only").addClass('current');
			}else{
				$("#all_only").removeClass('current');
				$("#ykt_only").removeClass('current');
			}
			checkChoose();
		}
	});
}




$(function(){
	/**
	 * 单条选中按钮
	 */
	$("a[name='item_checkbox']").click(function() {
		var flag = $(this).hasClass('current');//click之后是反着的
		var x = 0;
		if (!flag) {
			x = 1;
			$(this).addClass("current");
			$(this).parent("div").parent("div").parent("li").removeClass();
			$(this).parent("div").parent("div").parent("li").addClass('bgred clearfix clear');
		} else {
			$(this).removeClass("current");
			$(this).parent("div").parent("div").parent("li").removeClass();
			$(this).parent("div").parent("div").parent("li").addClass('clearfix clear');
		}
		jQuery.ajax({
			type : "post",
			url : jsCtx + "/carts/cart!checked.action",
			data : {
				"x" : x,
				"id" : $(this).attr("cid")
			},
			success : function(data) {
				var s=jQuery.parseJSON(data);
		       	  
				if (s.data > 0) {
					if (flag) {
						$(this).addClass('current');
					} else {
						$(this).removeClass('current');
					}
					money();
					checkEmpty();
				}
				////:0:医卡通不选全部选,1:医卡通选;2:全选
				if(s.ifYkt==1){
					$("#all_only").removeClass('current');
					$("#ykt_only").removeClass('current');
					$("#ykt_only").addClass('current');
				}else if(s.ifYkt==2){
					$("#all_only").removeClass('current');
					$("#ykt_only").removeClass('current');
					$("#all_only").addClass('current');
				}else{
					$("#all_only").removeClass('current');
					$("#ykt_only").removeClass('current');
				}
				checkChoose();
			}
		});
	});
/**
 * 只选医卡通
 */
$("#ykt_only").click(function(){
	var flag = $(this).hasClass('current');//click之后是反着的
	var type="1";
	if(flag){
		type="2";
		$(this).removeClass('current');
	}else{
		$(this).addClass('current');
	}
	$("#all_only").removeClass('current');
	jQuery.ajax({
		type : "post",
		url : jsCtx + "/carts/cart!chooseYKT.action",
		data : {
			"type" : type,
			"cartId" : $(this).attr("cid")
		},
		success : function(data) {
			var pp = eval("("+data+")");
			var checks = pp.check;
			var unchecks = pp.uncheck;
			for(var i=0;i<checks.length;i++){
				if(checks[i]!=undefined){
					if(!$("#check_"+checks[i]).hasClass('current')){//非选中状态
						$("#check_"+checks[i]).addClass("current");
						$("#check_"+checks[i]).parent("div").parent("div").parent("li").removeClass();
						$("#check_"+checks[i]).parent("div").parent("div").parent("li").addClass('bgred clearfix clear');
					}
				}
			}
			for(var i=0;i<unchecks.length;i++){
				if(unchecks[i]!=undefined){
					if($("#check_"+unchecks[i]).hasClass('current')){//选中状态
						$("#check_"+unchecks[i]).removeClass("current");
						$("#check_"+unchecks[i]).parent("div").parent("div").parent("li").removeClass();
						$("#check_"+unchecks[i]).parent("div").parent("div").parent("li").addClass('clearfix clear');
					}
				}
				
			}
			money();
			checkEmpty();
			checkChoose();
		}
	});
});

$("#all_only").click(function(){
	var flag = $(this).hasClass('current');//click之后是反着的
	var type="3";
	if(flag){
		type="4";
		$(this).removeClass('current');
	}else{
		$(this).addClass('current');
	}
	$("#ykt_only").removeClass('current');
	jQuery.ajax({
		type : "post",
		url : jsCtx + "/carts/cart!chooseYKT.action",
		data : {
			"type" : type,
			"cartId" : $(this).attr("cid")
		},
		success : function(data) {
			var pp = eval("("+data+")");
			var checks = pp.check;
			var unchecks = pp.uncheck;
			for(var i=0;i<checks.length;i++){
				if(checks[i]!=undefined){
					if(!$("#check_"+checks[i]).hasClass('current')){//非选中状态
						$("#check_"+checks[i]).addClass("current");
						$("#check_"+checks[i]).parent("div").parent("div").parent("li").removeClass();
						$("#check_"+checks[i]).parent("div").parent("div").parent("li").addClass('bgred clearfix clear');
					}
				}
			}
			for(var i=0;i<unchecks.length;i++){
				if(unchecks[i]!=undefined){
					if($("#check_"+unchecks[i]).hasClass('current')){//选中状态
						$("#check_"+unchecks[i]).removeClass("current");
						$("#check_"+unchecks[i]).parent("div").parent("div").parent("li").removeClass();
						$("#check_"+unchecks[i]).parent("div").parent("div").parent("li").addClass('clearfix clear');
					}
				}
				
			}
			money();
			checkEmpty();
			checkChoose();
		}
		
	});
});

$("#jiesuanBtn").click(function(){
	//判断购物车项是否符合结算
	//window.location.href=jsCtx+"/member/order!toOrderAdd.action";
	
	var cnt = checkChoose();
	if(cnt<=0){
//		$alert("warn","未选商品","111医药馆提示您",null);
		return;
	}
	
	
	jQuery.ajax({
		type : "post",
		url : jsCtx + "/carts/cart!jiesuanJudge.action",
		data : {
			"cartId" : $("#tcartId").val()
		},
		success : function(data) {
			var resultJson = eval("("+data+")");
			if(resultJson.status==-1){//购物车为空
				$alert("warn","购物车为空","111医药馆提示您",null);
			}else if(resultJson.status==-2){
				var dataJson = eval(resultJson.cartData);//不符合数组
				var kucun = 0;
				var xiajia = 0;
				var chufang = 0;
				for(var i=0;i<dataJson.length;i++) {
					var itemData = dataJson[i];
					////{"stock":3,"status":1,"quantity":7,"is_suit":0,"itemId":8973}
					if(itemData!=null && itemData.quantity>itemData.stock){
						$("#tip_"+itemData.itemId).text("库存不足");
						kucun += 1;
					}
					if(itemData!=null && (itemData.is_suit==2||itemData.is_suit==3)){
						$("#tip_"+itemData.itemId).text("处方药");
						chufang += 1;
					}
					if(itemData!=null && itemData.status==2){
						$("#tip_"+itemData.itemId).text("已下架");
						xiajia += 1;
					}
					if(kucun>0 && xiajia>0 && chufang>0){
						$alert("warn","购物车内商品有库存不足、包含处方药、包含已下架商品","111医药馆提示您",null);
					}else if(kucun>0 && xiajia>0){
						$alert("warn","购物车内商品有库存不足、包含已下架商品","111医药馆提示您",null);
					}else if(chufang>0 && xiajia>0){
						$alert("warn","购物车内商品包含处方药、包含已下架商品","111医药馆提示您",null);
					}else if(chufang>0 && kucun>0){
						$alert("warn","购物车内商品有库存不足、包含处方药","111医药馆提示您",null);
					}else if(kucun>0){
						$alert("warn","购物车内商品库存不足","111医药馆提示您",null);
					}else if(xiajia>0){
						$alert("warn","购物车内商品包含已下架商品","111医药馆提示您",null);
					}else if(chufang>0){
						$alert("warn","购物车内商品包含处方药","111医药馆提示您",null);
					}
					$("#check_"+itemData.itemId).removeClass('current');
					$("#record_"+itemData.itemId).removeClass("bgred ");
				}
				money();
				checkEmpty();
			}else{
				//跳转结算也面
//				alert("跳转结算也面");
				window.location.href=jsCtx+"/member/order!toOrderAdd.action";
			}
		}
	});
});

});

/**
 * 飞一般的加入购物车
 * @param id ：商品ID
 * @returns {Boolean}
 */
function new_addCart(id)
{
	var counts = parseInt($.trim($(".product_nums_in").val()));
	var rs = new_add_cart_bynums(id, counts);
    if(rs > 0)
    {
  	    var img = $(".pro-img");
		var flyElm = img.clone().css('opacity', 0.75);
		$('body').append(flyElm);
		flyElm.css({
			'z-index': 9000,
			'display': 'block',
			'position': 'absolute',
			'top': img.offset().top +'px',
			'left': img.offset().left +'px',
			'width': img.width() +'px',
			'height': img.height() +'px'
		});
		flyElm.animate({
			top: $('#mycart-id').offset().top,
			left: $('#mycart-id').offset().left,
			width: 20,
			height: 32
		}, 'slow', function() {
			flyElm.remove();
		});
   	 	return false;
     }
     else if(rs == 0)
     {
    	 $alertCanDisplay("warn","参数错误！","111医药馆提示您",null);
    	 return false;
     }
     else if(rs == -1)
     {
    	 $alertCanDisplay("warn","库存不足！","111医药馆提示您",null);
    	 return false;
     }
     else if(rs == -2)
     {
    	 $alertCanDisplay("warn","该商品为下架商品！","111医药馆提示您",null);
    	 return;
     }
     else if(rs == -3)
     {
    	 $alertCanDisplay("warn","该商品为处方药，请联系客服购买！","111医药馆提示您",null);
    	 return false;
     }
     else if(rs == -4)
     {
    	 $alertCanDisplay("warn","该商品数大于促销数量！","111医药馆提示您",null);
    	 return false;
     }
     else if(rs == -5)
     {
    	 $alertCanDisplay("warn","您已经购买过该促销商品！","111医药馆提示您",null);
    	 return false;
     }
     else if(rs == -7)
     {
    	 $alertCanDisplay("warn","购物车单品不能超过"+cartMaxNum+"个","111医药馆提示您",null);
    	 return false;
     }
     else if(rs == -99)
     {
    	 $alertCanDisplay("warn","服务器内部错误！","111医药馆提示您",null);
    	 return false;
     }
}
/**
 * 列表页飞一般的加入购物车
 * @param id ：商品ID
 * @returns {Boolean}
 */
function new_list_addCart(id)
{
	var rs = new_add_cart_bynums(id, 1);
	if(rs > 0)
	{
		var img = $("#"+id).parents('li').find('img');
		var flyElm = img.clone().css('opacity', 0.75);
		$('body').append(flyElm);
		flyElm.css({
			'z-index': 9000,
			'display': 'block',
			'position': 'absolute',
			'top': img.offset().top,//+$(document).scrollTop(),//img.offset().top +'px',
			'left': img.offset().left,//img.offset().left +'px',
			'width': img.width() +'px',
			'height': img.height() +'px'
		});
		flyElm.animate({
			top: $('#mycart-id').offset().top,
			left: $('#mycart-id').offset().left,
			width: 20,
			height: 32
		}, 'slow', function() {
			flyElm.remove();
		});
		return false;
	}
	else if(rs == 0)
	{
		$alertCanDisplay("warn","参数错误！","111医药馆提示您",null);
		return false;
	}
	else if(rs == -1)
	{
		$alertCanDisplay("warn","库存不足！","111医药馆提示您",null);
		return false;
	}
	else if(rs == -2)
	{
		$alertCanDisplay("warn","该商品为下架商品！","111医药馆提示您",null);
		return;
	}
	else if(rs == -3)
	{
		$alertCanDisplay("warn","该商品为处方药，请联系客服购买！","111医药馆提示您",null);
		return false;
	}
	else if(rs == -4)
	{
		$alertCanDisplay("warn","该商品数大于促销数量！","111医药馆提示您",null);
		return false;
	}
	else if(rs == -5)
	{
		$alertCanDisplay("warn","您已经购买过该促销商品！","111医药馆提示您",null);
		return false;
	}
	else if(rs == -99)
	{
		$alertCanDisplay("warn","服务器内部错误！","111医药馆提示您",null);
		return false;
	}
}

/**
 * 新加入购物车方法
 * @param gid ：商品ID
 * @param counts ：商品数量
 * @returns {Number}
 */
function new_add_cart_bynums(gid, counts)
{
	var status = 0;
	jQuery.ajax
	({
       type: "post",
       url: "/carts/cart!addCart.action",	  
       data:{'gid':gid, 'cnt':counts},
       async:false,
       success: function(data)
       {
    	   var s = jQuery.parseJSON(data);
    	   status = s.status;
    	   if(s.status>0)
    	   {
    		   get_cart_sum();
    	   }
       }
	 }); 
	 return status;
}

//获取购物车数量
function get_cart_sum()
{
   jQuery.ajax
   ({
       type: "POST",
       url: "/carts/cart!getCartSum.action",	 
       async:false, 
       success: function(data)
       {
       	  var s = jQuery.parseJSON(data);
       	  if(s.cnt > 99)
       	  {
       		$(".cart_num").html("99+");
       	  }
       	  else
       	  {
       		$(".cart_num").html(s.cnt);
       	  }
       }
   }); 
}



function checkChoose(){
	var flag = false;
	var n = 0;
	var len = $("a[name='item_checkbox']").each(function(){
		flag = $(this).hasClass('current');
		if(flag==true){
			n++;
		}
	});
	//#BDB0B0
	if(n<=0){
		$("#jiesuanBtn").attr("style","background:rgba(0, 0, 0, 0) linear-gradient(to bottom, #BDB0B0, #BDB0B0) repeat scroll 0 0");
	}else{
		$("#jiesuanBtn").attr("style","background:rgba(0, 0, 0, 0) linear-gradient(to bottom, #ff6338, #fe4310) repeat scroll 0 0");
	}
	return n;
}
