
function showloading()
{
  	$(".loading-ui").show();
  	$(".mask-ui").show();
}

function hideloading()
{
	$(".loading-ui").hide();
	$(".mask-ui").hide();
}

function launchFullscreen(a) {
        if (a.requestFullscreen) {
            a.requestFullscreen()
        } else {
            if (a.mozRequestFullScreen) {
                a.mozRequestFullScreen()
            } else {
                if (a.msRequestFullscreen) {
                    a.msRequestFullscreen()
                } else {
                    if (a.webkitRequestFullscreen) {
                        a.webkitRequestFullScreen()
                    }
                }
            }
        }
    };
    function exitFullscreen() {
        if (document.exitFullscreen) {
            document.exitFullscreen()
        } else {
            if (document.mozCancelFullScreen) {
                document.mozCancelFullScreen()
            } else {
                if (document.webkitExitFullscreen) {
                    document.webkitExitFullscreen()
                }
            }
        }
    };
    function fullscreenElement() {
        return document.fullscreenElement || document.webkitCurrentFullScreenElement || document.mozFullScreenElement || null
    };
    $(function() {
        $("#phoneclose").on('click',null,
        function() {
            $("#previewbox").fadeOut();
            $(".mask-ui").fadeOut();
        });
        $("#phone").on('click',null,
        function() {
            if ($("#previewbox").css("display") == "block") {
                $("#previewbox").hide();
            } else {
            	var content = ues.getContent();
            	$("#previewbox").css("left","44%").fadeIn();
                $("#preview").html(content);
                $(".mask-ui").fadeIn();
            }
        });
        $(window).on('fullscreenchange webkitfullscreenchange mozfullscreenchange',null,
        function() {
            if (!fullscreenElement()) {
                $('.wxeditor').css({
                    margin: '0'
                });
            }
        });
        $('.fullshowbox').on('click',null,
        function() {
            $('.wxeditor').css({
                margin: '50px 0'
            });
            launchFullscreen(document.documentElement)
        });
        $('.fullhidebox').on('click',null,
        function() {
            $('#wxeditortip,#header').show();
            exitFullscreen()
        });
        var b = ["borderTopColor", "borderRightColor", "borderBottomColor", "borderLeftColor"],
        d = [];
        $.each(b,
        function(a) {
            d.push(".itembox .wxqq-" + b[a])
        });
        $("#colorpickerbox").ColorPicker({
            flat: true,
            color: "#00bbec",
            onChange: function(a, e, f) {
                $(".itembox .wxqq-bg").css({
                    backgroundColor: "#" + e
                });
                $(".itembox .wxqq-color").css({
                    color: "#" + e
                });
                $.each(d,
                function(g) {
                    $(d[g]).css(b[g], "#" + e)
                })
            }
        });
        var c = UE.getEditor("editor", {
            topOffset: 0,
            autoFloatEnabled: false,
            autoHeightEnabled: false,
            autotypeset: {
                removeEmptyline: true
            },
        });
        c.ready(function() {
            c.addListener('contentChange',
            function() {
                $("#preview").html(c.getContent() + '<div><a style="font-size:12px;color:#607fa6" href="javascript:void(0);" id="post-user">阅读原文</a> <em style="color:#8c8c8c;font-style:normal;font-size:12px;">阅读 100000+</em><span class="fr"><a style="font-size:12px;color:#607fa6" href="javascript:void(0);">举报</a></span></div>');
            });
            $(".itembox").on("click",null,
            function(a)
             {
  			    var content = ues.getContent();
  			    var f = $(this).html();
				if(content.indexOf("goods_img_p_1") >= 0 && f.indexOf("goods_img_p_1") >= 0)
				{
					$alert("warn","编辑器中已存在商品一！")
					return false;
				}
				if(content.indexOf("goods_img_p_2") >= 0 && f.indexOf("goods_img_p_2") >= 0)
				{
					$alert("warn","编辑器中已存在商品二！")
					return false;
				}
				if(content.indexOf("goods_img_p_3") >= 0 && f.indexOf("goods_img_p_3") >= 0)
				{
					$alert("warn","编辑器中已存在商品三！")
					return false;
				}
				if(content.indexOf("goods_img_p_4") >= 0 && f.indexOf("goods_img_p_4") >= 0)
				{
					$alert("warn","编辑器中已存在商品四！")
					return false;
				}
				if(content.indexOf("goods_img_p_5") >= 0 && f.indexOf("goods_img_p_5") >= 0)
				{
					$alert("warn","编辑器中已存在商品五！")
					return false;
				}
	            c.execCommand("insertHtml", $(this).html())
            })
        });
        $(".tabs li a").on("click",null,
        function() {
            $(this).addClass("current").parent().siblings().each(function() {
                $(this).find("a").removeClass("current")
            });
            $("#" + $(this).attr("tab")).show().siblings().hide()
        })
    });
    
    
    
    
    
    
    
  /*小图标选择器*/
  function shifuMouseDownMark(id) {
  	var con   = $('#'+id).find("span").html();
  	var range = UE.getEditor('editor').selection.getRange();

  	range.select();
  	
  	UE.getEditor('editor').selection.getText();
  	
  	UE.getEditor('editor').execCommand('insertHtml',con);
  }
  $(function () 
  {
      $(window).resize(function(){
  		var win_height = $(window).height();
  		$('#bdeditor').height(win_height);
  		var area_height = win_height -6;
  		if(area_height > 800){
  			area_height = 800;
  		}
  		
  		$('#editor').height(area_height-40);
  		$('#styleselect').height(area_height);
  		$('.content').height(area_height-165);
  	}).trigger('resize');

  	$('.clear_article_ui').click(function()
  	{
  		$confirm("warn","是否确认清空内容，清空后内容将无法恢复","111医药馆提示您",function(result)
  		{
  			if(result)
  			{
  				c.setContent('');
  			}
  		});
  	});
      
   	//window.onbeforeunload = function(event) { return confirm("确定离开此页面吗？"); }
  	var client = new ZeroClipboard( $('.copy-editor-html') );
  	ZeroClipboard.config({
  				swfPath: "ueditor/third-party/zeroclipboard/ZeroClipboard.swf"
  			});
  	client.on( 'ready', function(event) {
  		client.on( 'copy', function(event) {
  	  		event.clipboardData.setData('text/html', c.getContent());
  	  		event.clipboardData.setData('text/plain',c.getContent()); 
  		});
          client.on('aftercopy',function(event) {
  			alert('正文内容已经复制到剪切板，可粘贴（ctrl+v）到微信公众平台编辑器中使用！');
  		 });
  	});  
  	
  	  
      var b = ["borderTopColor", "borderRightColor", "borderBottomColor", "borderLeftColor"],
          d = [];
      $.each(b, function (a) {
          d.push(".itembox .wxqq-" + b[a])
      });
      $("#colorpickerbox").ColorPicker({
          flat: true,
          color: "#00bbec",
          onChange: function (a, e, f) {
              $(".itembox .wxqq-bg").css({
                  backgroundColor: "#" + e
              });
              $(".itembox .wxqq-color").css({
                  color: "#" + e
              });
              $.each(d, function (g) {
                  $(d[g]).css(b[g], "#" + e)
              })
          }
      });

      var c = UE.getEditor("editor", {
          topOffset: 0,
          autotypeset: {
              removeEmptyline: true
          },
          toolbars: [
              ['fullscreen', 'source', 'undo', 'redo', 'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'removeformat', 'autotypeset', 'blockquote', 'pasteplain', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', 'rowspacingtop', 'rowspacingbottom', 'lineheight', 'indent', 'justifyleft', 'justifycenter', 'justifyright', 'fontfamily', 'fontsize', 'justifyjustify', 'touppercase', 'tolowercase', 'insertimage', 'emotion', 'insertvideo', 'map', 'date', 'time', 'spechars', 'preview', 'searchreplace'],
              ['con', 'title', 'fork', 'guide', 'division', 'other', 'mystyle']
          ],
          autoHeightEnabled: false,
          allowDivTransToP: false,
          autoFloatEnabled: true,
          enableAutoSave: false
      });
      c.ready(function () {
          c.addListener('contentChange', function () {
              $("#preview").html(c.getContent());
              $("#wxpreview").html(c.getContent());
          });

      });
      $(".tabs li a").on("click",null, function () 
      {
          $(this).addClass("current").parent().siblings().each(function () 
          {
              $(this).find("a").removeClass("current")
          });
          var $index = $(this).attr("tab");
          $("#" + $index).show().siblings().hide();
      });
  	

  	window.onload = function() 
  	{
  		var LSContent = localStorage.getItem('ueditor_preference');
  		if(LSContent) {
  			var JContent;
  			try{
  				JContent = JSON.parse(LSContent);
  			} catch(ex) {
  				throw new Error("JSON格式的数据有误，转化失败!");
  			}
  			if(JContent.localContent) {
  				setTimeout(function() {
  					UE.getEditor('editor').setContent(JContent.localContent);
  					
  				},350);
  				
  			}
  		}
  	}
  });
  
var offset = 1;
$(function()
{
	//返回
	$(".toback").click(function()
	{
		window.history.back();
		//window.location.href = "/leaderarticle/leaderarticle!draftLeaderArticleList.action";
	});
	
	//关闭选择商品层
	$(".close_pops_x").click(function()
	{
		//关闭已选择的商品事件
		//close_selected_goods(-1);
		$("#shade_goods").fadeOut();
	});
	
	//显示选择商品层
	$("#select_goods_id").click(function()
	{
		offset = 1;
		$(".select_g_p_d_v").html("");
		load_select_goods_data(offset, "");
	});
	
	//加载更多
	$("#load_ing_more_data_btn").click(function()
	{
		var v = $("#search_v_sel_g").val();
		$(this).addClass("loadcurrent").html("加载中...");
		offset += 1;
		load_select_goods_data(offset, "");
	});
	
	//搜索商品
	$(".t_btn_search").click(function()
	{
		$(".select_g_p_d_v").html("");
		var obj = $("#search_v_sel_g");
		var v = $.trim(obj.val());
		if(v == null || v == undefined || v == "")
		{
			obj.focus();
			load_select_goods_data(offset, "");
		}
		else
		{
			load_select_goods_data(offset, v);
			offset == 1;
		}
	});
	
	//自动补全
	$("#search_v_sel_g").keyup(function(e)
	{
		/*var keyword = $.trim($("#search_v_sel_g").val());
		if(keyword != null && keyword != '' && keyword != undefined)
		{
			getSearchTipsNew(keyword);
		}*/
		var theEvent = e || window.event;    
	    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;  
	    if(code == 13)
	    {  
	    	$(".t_btn_search").click();
	    }
	})
	.keydown(function(e)
	{
		/*var keyword = $.trim($("#search_v_sel_g").val());
		if(keyword != null && keyword != '' && keyword != undefined)
		{
			getSearchTipsNew(keyword);
		}*/
		var theEvent = e || window.event;    
	    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;  
	    if(code == 13)
	    {  
	    	$(".t_btn_search").click();
	    }
	})
	.focus(function()
	{
		offset = 1;
	});
	
	//默认加载关闭按钮功能
	//close_selected_goods(-2);
	
});

//加载选择商品数据
function load_select_goods_data(offset, v)
{
	v = encodeURI(encodeURI(v));
	console.log("offset is == " + offset);
	$.ajax
	({
		  type: "POST",
		  url: "/leaderarticle/leaderarticle!list.action?offset="+offset+"&name="+v,
		  async: false,
		  success: function(data) 
		  {  
			  var lg = data.length;
			  var lis = "";
			  var j = 0;
			  for(var i=0; i<lg; i++)
			  {
				  j = (offset+1-2)*8+i;
				  var goods_id = data[i].goods_id;
				  var abbreviation_picture = global_image_url + data[i].abbreviation_picture;
				  var goods_name = data[i].short_name;
				  var goods_price = data[i].pc_price;
				  var rebate_amount = data[i].rebate_amount;
				  lis +=
				    "<li>"
	  				+"<img class=\"sel_goods_i_m_g\" src='"+abbreviation_picture+"' onclick=\"window.open('/p/"+goods_id+".html','_blank')\"/>"
	  				+"<a id='goods_name_l_oad' class=\"goods_n_a_name\">"+goods_name+"</a>"
	  				+"<a class=\"goods_n_a_name\">¥"+goods_price+"</a>"
	  				+"<a class=\"goods_n_a_name\">可返收益："+rebate_amount+"</a>"
	  				+"<a class=\"goods_n_a_s_l_btn\" id='sel_ect_btn_"+j+"' style='display:none' onclick='select_goods_event("+j+")'>选择</a>"
	  				+"<input type='hidden' id='goods_id_temp_"+j+"' value='"+goods_id+"'/>"
	  				+"</li>";
			  }
			  $(".select_g_p_d_v").append(lis);
			  $("#shade_goods").fadeIn();
			  
			  //选择商品鼠标滑过特效
			  $(".select_g_p_d_v li").each(function(i)
			  {
				  $(this).mouseover(function()
				  {
					  $(this).addClass("current");
					  $("#sel_ect_btn_"+i).show();
				  })
				  .mouseleave(function()
				  {
					  $(this).removeClass("current");
					  $("#sel_ect_btn_"+i).hide();
				  });
			  });
			  offset += 1;
			  window.setTimeout(function() 
			  {
				  $("#load_ing_more_data_btn").removeClass("loadcurrent").html("加载更多");
			  },500);
			  
			  //判断是否显示加载更多按钮
			  if(lg >= 8)
			  {
				  $(".load_more_info_btn").show();
			  }
			  else
			  {
				  $(".load_more_info_btn").hide();
			  }
	      },  
	      error: function(e) 
	      {  
	    	  console.log(e);
	      }  
	 });
}

//获取补全结果
function getSearchTipsNew(keyword)
{
	$.ajax(
   {
      type: "GET",
      url: "/leaderarticle/leaderarticle!getshortname.action?name="+keyword,
      async: false,
      cache: false,
      success: function(json)
      {
   	   	   var aim = json+"";
		   var array = aim.split(",");
		   console.log("success--json==="+json);
		   $("#search_v_sel_g").autocomplete({source: array});
      },
      error: function()
      {
   	   	   console.log("error");
      }
   }); 
}

//选择商品事件
function select_goods_event(j)
{
	var obj = $("#sel_ect_btn_"+j).parent();
	var src = obj.find("img").attr("src");
	var goods_name = obj.find("a#goods_name_l_oad").html();
	var goods_id = $("#goods_id_temp_"+j).val();
	j = j+5;
	var lis =
	"<li>"
	+"<img class='goods_img_c_s' src='"+src+"'/>"
	+"<a href='/p/"+goods_id+".html' target='_blank'>"+goods_name+"</a>"
	+"<img class='close_img_i_n' id='close_img_i_n_"+j+"' onclick=fuckyEvent("+j+") src='/web/images/colorpicker/health-close.png'/>"
	+"<input class='goods_id_hidden' type='hidden' value='"+goods_id+"'/>"
	+"</li>";
	
	var lg = $(".selected_goods_list li").length;
	if(lg == 0)
	{
		$alertCanDisplay("success","添加商品成功！","111医药馆提示您",null,null);
		$(".selected_goods_list").append(lis).show();
	}
	if(lg < 5 && lg != 0)
	{
		var goods_id_set = "";
		$(".selected_goods_list li").each(function()
		{
			goods_id_set += $(this).find("input.goods_id_hidden").val() + ",";
		});
		if(goods_id_set.indexOf(goods_id) == -1)
		{
			$alertCanDisplay("success","添加商品成功！","111医药馆提示您",null,null);
			$(".selected_goods_list").append(lis);
		}
		else
		{
			$alertCanDisplay("error","您已添加过该商品！","111医药馆提示您",null,null);
		}
	}
	if(lg >= 5)
	{
		$alertCanDisplay("warn","您最多可以选择5个商品！","111医药馆提示您",null,null);
	}
	
	//改变某些元素高度
	setHTML_Ele_Height();
}

//保存数据
function save_new_leader_data(type, _object,newStr,oldStr)
{
	var edit_page = $("#edit_page").val();
	var goods_ids = "";
	var length = $(".selected_goods_list li").length;
	var title = $.trim($("#title").val());
	var share_image_url = $.trim($("#share_image_url").val());
	var share_title = $.trim($("#share_title").val());
	var url = "/leaderarticle/leaderarticle!save.action";
	var articleId = null;
    if(title == '' || title == null || title == undefined)
    {
  	    $alertCanDisplay("warn","文章标题不能为空！","111医药馆提示您",null,null);
  	    return;
    }
    if(share_image_url == '' || share_image_url == null || share_image_url == undefined)
    {
  	    $alertCanDisplay("warn","请上传分享图片！","111医药馆提示您",null,null);
  	    return;
    }
    if(share_title == '' || share_title == null || share_title == undefined)
    {
    	$alertCanDisplay("warn","分享语不能为空！","111医药馆提示您",null,null);
  	    return;
    }
    if(length == 0)
	{
		$alertCanDisplay("warn","请选择商品！","111医药馆提示您",null,null);
  	    return;
	}
	else
	{
		if(edit_page == undefined)
		{
			$(".selected_goods_list li").each(function(i)
			{
				var t = $(this).find("input.goods_id_hidden").val();
				goods_ids += t + ",";
			});
		}
		else
		{
			articleId = $.trim($("#articleId").val());
			url = "/leaderarticle/leaderarticle!update.action";
			$(".selected_goods_list li").each(function(i)
			{
				var t = $(this).find("input.goods_id_hidden").val();
				var s = $(this).find("input.article_goods_id_hidden").val();
				if(s == undefined)
				{
					s = "";
				}
				goods_ids += t + "-" + s + ",";
			});
		}
	}
	goods_ids = goods_ids.substring(0, goods_ids.length-1);
	console.log("goods_ids==="+goods_ids);
	//文章内容
	var content = ues.getContent();
	if(content == '' || content == null || content == undefined)
	{
	  	$alertCanDisplay("warn","文章内容不能为空！","111医药馆提示您",null,null);
	  	return;
	}
	_object.innerHTML = newStr;
	_object.style.background = "url(http://img.zdfei.com/static/image/temp/20160128/a1125330d69f3f2cf1f093ad8a71bfbd.gif) no-repeat";
	_object.style.backgroundPosition = "0px";
	_object.style.color = "#000";
	content = strEnc(content,"1","2","3");
	$.ajax
	({
		type: "POST",
		url: url,
		async: false,
		data:{"title":title, "share_title":share_title, "share_image_url":share_image_url, "content":content, "goods_ids":goods_ids, "type":type, "articleId":articleId},
		dataType: "json",
		success: function(data) 
		{  
	    },  
	    error: function(e) 
	    {  
	      	console.log(e);
			window.setTimeout(function()
			{
				$("#sub_mit_btn_check").show();
				$("#sub_mit_btn_check_ing").hide();
			},500);
	    }  
	 });
	 window.location.href = "/leaderarticle/leaderarticle!draftLeaderArticleList.action";
}

//关闭已选择的商品事件
function close_selected_goods(j)
{
	$(".selected_goods_list li").each(function(i)
	{
		$(this).find("img.close_img_i_n").click(function()
		{
			//文章ID
			var article_goods_id = $(this).parent().find("input.article_goods_id_hidden").val();
			if(article_goods_id == undefined)
			{
				$(this).parent().remove();
				var leght = $(".selected_goods_list li").length;
				if(leght == 0)
				{
					backHTML_Ele_Height();
				}
			}
			else
			{
				if(j == -1)
				{
					if(window.confirm("您确定要删除吗？"))
					{
						$(this).parent().remove();
						var leght = $(".selected_goods_list li").length;
						if(leght == 0)
						{
							backHTML_Ele_Height();
						}
						$.post("/leaderarticle/leaderarticle!delag.action?article_goods_id="+article_goods_id,null,function(data){});
					}
				}
			}
		});
	});
}

function fuckyEvent(j)
{
	var article_goods_id = $("#close_img_i_n_"+j).parent().find("input.article_goods_id_hidden").val();
	if(article_goods_id == undefined)
	{
		$("#close_img_i_n_"+j).parent().remove();
		var leght = $(".selected_goods_list li").length;
		if(leght == 0)
		{
			backHTML_Ele_Height();
		}
	}
	else
	{
		if(window.confirm("您确定要删除吗？"))
		{
			$("#close_img_i_n_"+j).parent().remove();
			var leght = $(".selected_goods_list li").length;
			if(leght == 0)
			{
				backHTML_Ele_Height();
			}
			$.post("/leaderarticle/leaderarticle!delag.action?article_goods_id="+article_goods_id,null,function(data){});
		}
	}
}



//改变某些元素的高度
function setHTML_Ele_Height()
{
	$(".line_sprite").css({"height":"1180px","top":"-426px"});
	$(".main_contents_v").css({"height":"1180px"});
	$(".tabs").css({"top":"-420px"});
}

//还原某些元素的高度
function backHTML_Ele_Height()
{
	$(".selected_goods_list").hide();
	$(".line_sprite").css({"height":"1030px","top":"-276px"});
	$(".main_contents_v").css({"height":"1030px"});
	$(".tabs").css({"top":"-270px"});
}







