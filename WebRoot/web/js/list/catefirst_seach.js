var numbrand = 100;
//var urlbase = "http://www.jkr99.com";
//var urlbase = "www.testyao.com";
//根据不同的排序搜索商品
function set(obj) {
	var v = obj;

	var u;
	var keyword = $("#url_B").val();
	if (v == "id_a") {
		$("#sort").val(0);
		var o = $("#orderby").val();
		if (o == 1) {
			$("#orderby").val(2);
		} else if (o == 2) {
			$("#orderby").val(1);
		}
		u = "-h0"  + "-i" + $("#orderby").val();
	}

	if (v == "click_a") {
		$("#sort").val(1);
		var o = $("#orderby").val();
		if (o == 1) {
			$("#orderby").val(2);
		} else if (o == 2) {
			$("#orderby").val(1);

		}
		u = "-h1" + "-i" + $("#orderby").val();
	}

	if (v == "price_a") {
		$("#sort").val(2);
		var o = $("#orderby").val();
		if (o == 1) {
			$("#orderby").val(2);
		} else if (o == 2) {
			$("#orderby").val(1);
		}
		u = "-h2" + "-i" + $("#orderby").val();
	}

	if (v == "salesvolume_a") {
		$("#sort").val(3);
		var o = $("#orderby").val();
		if (o == 1) {
			$("#orderby").val(2);
		} else {
			$("#orderby").val(1);
		}
		u = "-h3" + "-i" + $("#orderby").val();
	}
	var url =$("#url_E").val() + $("#type").val() + $("#url_F").val()
			+ $("#brandid").val() + $("#url_G").val() + $("#pricea").val()
			+ $("#url_H").val() + $("#priceb").val() ;
	window.location.href = "/" +keyword + "/slist" + url + u + ".html";
}

$(document).ready(function() {
		//设置价格高亮显示
		var viewv = $("#pricea").val() + '|' + $("#priceb").val();
		$("#priceRange1 li a[id='" + viewv + "']").addClass("curr");

		//设置 品牌 高亮显示
		viewv = $("#brandid").val();
		var obj = $("#brandId li a[id='" + viewv + "']");
		obj.addClass("curr");
		$("#SubPrice").click(
				function() {
					var s = $("#startPriceII").val();
					var e = $("#endPriceII").val();
					var r = /^[0-9]+$/;
					if (!validate.isEmpty(s)) {
						if (!r.test(s)) {
							 $alert("warn","开始价格只能为正整数");  
							return;
						}
					}
					if (!validate.isEmpty(e)) {
						if (!r.test(e)) {
							 $alert("warn","结束价格只能为正整数");  
							return;
						}
					}  

					if (parseInt(s) > parseInt(e)) {
						var m = s;
						s = e;
						e = m;
					}
					var str = "-f" + s + "-g" + e;
					var url_B=$("#url_B").val();
					var url = $("#url_E").val() + $("#type").val() + $("#url_F").val()
					+ $("#brandid").val();
					window.location.href = "/" + url_B + "/slist"
							+ url+str+".html";
					//var str=""+s+"|"+e;
					//$("#startprice").val(s);
					//$("#endprice").val(e);
					//$("#priceRangeView").val(str);
					//$("#subformsearch").submit();
				});
	});
function guanzhu(id){
	$.get("/index!attentionpro.action?proid="+id+"&ctype=0",null,function(data){
		if(data==1){
			$("#"+id).addClass("already");
		}
	});
}

