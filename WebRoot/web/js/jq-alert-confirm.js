/**
 * 对话框函数JS库依赖JQ、JQ-UI插件
 * @author LGP
 * @date 2015年8月28日
 */
(function($) 
{
	$.alerts = 
	{
	//对话框对屏幕中心的垂直偏移量
	verticalOffset: -75,
	//对话框对屏幕中心的水平偏移量
	horizontalOffset: 0,
	//是否允许对话框随窗口相对移动
	repositionOnResize: false,
	//遮罩层透明度
	overlayOpacity: .1,
	//遮罩层背景颜色
	overlayColor: '#000', 
	//对话框是否允许拽
	draggable: true,
	okButton: '确 定',
	cancelButton: '取 消',
    //自定义对话框class
	dialogClass: null,
	
	
	/**
	 * alert函数
	 * @param message 消息内容
	 * @param title 标题
	 * @param callback 回调函数
	 */
	alert:function(imgtype, message, title, callback) 
	{
		if(title == null || title == '') title = '系统提示';
		$.alerts._show(imgtype, title, message, null, 'alert',null);
	},
	
	alertCanDisplay:function(imgtype, message, title, callback) 
	{
		if(title == null || title == '') title = '系统提示';
		$.alerts._show(imgtype, title, message, null, 'alertCanDisplay',null);
	},
	
	confirm: function(imgtype, message, title, callback) 
	{
		if(title == null || title == '') title = '系统提示';
		$.alerts._show(imgtype, title, message, null, 'confirm', function(result)
		{
			if( callback ) callback(result);
		});
	},
	
	prompt: function(imgtype, message, value, title, callback) 
	{
		if(title == null || title == '') title = '系统提示';
		$.alerts._show(imgtype, title, message, value, 'prompt', function(result)
		{
			if( callback ) callback(result);
		});
	},
	
	 /**
	  * 对话框显示函数
	  * @param imgtype 图片类型 warn:警告 success:成功 error:失败
	  * @param title 标题
	  * @param msg 内容
	  * @param value 传值
	  * @param type 对话框类型（alert、confirm、prompt）
	  * @param callback 回调函数（没有为null）
	 */
	_show:function(imgtype, title, msg, value, type, callback) 
	{
		$.alerts._hide();
		$.alerts._overlay('show');
		var divimgObj = null;
		if(imgtype == '' || imgtype == null)
		{
			divimgObj = '<div id="popup_content" style="background: 18px 18px no-repeat url(/web/img/warn.png);">';
		}
		if(imgtype == 'warn')
		{
			divimgObj = '<div id="popup_content" style="background: 18px 18px no-repeat url(/web/img/warn.png);">';
		}
		if(imgtype == 'success')
		{
			divimgObj = '<div id="popup_content" style="background: 18px 18px no-repeat url(/web/img//success.png);">';
		}
		if(imgtype == 'error')
		{
			divimgObj = '<div id="popup_content" style="background: 18px 18px no-repeat url(/web/img/error.png);">';
		}
		$("body").append(
		'<div id="popup_container">' +
		'<h1 id="popup_title"></h1>' +
		 divimgObj +
		'<div id="popup_message"></div>' +
		'</div>' +
		'</div>');
		
		if( $.alerts.dialogClass )
		{
			$("#popup_container").addClass($.alerts.dialogClass);
		}
	    var pos = ('undefined' == typeof (document.body.style.maxHeight)) ? 'absolute' : 'fixed';
		$("#popup_container").css(
		{
			position: pos,
			zIndex: 99999999999999999999,
			padding: 0,
			margin: 0
		});
		$("#popup_title").html("<a>"+title+"</a>");
		$("#popup_content").addClass(type);
		$("#popup_message").text(msg);
		$("#popup_message").html( $("#popup_message").text().replace(/\n/g, '<br />') );
		$("#popup_container").css(
		{
			minWidth: $("#popup_container").outerWidth(),
			maxWidth: $("#popup_container").outerWidth()
		});
	    
		$.alerts._reposition();
		$.alerts._maintainPosition(true);
	
		//判断对话框类型
		switch(type) 
		{
			case 'alert':
				$("#popup_message").after('<div id="popup_panel"><input type="button" value="' + $.alerts.okButton + '" id="popup_ok" /></div>');
				/*window.setTimeout(function(){
					$.alerts._hide();
				},2000);*/
				$("#popup_ok").click( function() 
				{
					$.alerts._hide();
					//callback(true);
				});
				$("#popup_ok").focus().keypress( function(e) 
				{
					if( e.keyCode == 13 || e.keyCode == 27 ) 
					{
						$("#popup_ok").trigger('click');
					}
				});
			break;
			
			case 'alertCanDisplay':
				$("#popup_message").after('<div id="popup_panel"><input type="button" value="' + $.alerts.okButton + '" id="popup_ok" /></div>');
				window.setTimeout(function(){
					$.alerts._hide();
				},500);
				$("#popup_ok").click( function() 
						{
					$.alerts._hide();
					//callback(true);
						});
				$("#popup_ok").focus().keypress( function(e) 
						{
					if( e.keyCode == 13 || e.keyCode == 27 ) 
					{
						$("#popup_ok").trigger('click');
					}
						});
				break;
			
			case 'confirm':
				$("#popup_message").after('<div id="popup_panel"><input type="button" value="' + $.alerts.okButton + '" id="popup_ok" /> <input type="button" value="' + $.alerts.cancelButton + '" id="popup_cancel" /></div>');
				$("#popup_ok").click( function() 
				{
					$.alerts._hide();
					if( callback ) callback(true);
				});
				$("#popup_cancel").click( function() 
				{
					$.alerts._hide();
					if( callback ) callback(false);
				});
				$("#popup_ok").focus();
				$("#popup_ok, #popup_cancel").keypress( function(e) 
				{
					if( e.keyCode == 13 ) $("#popup_ok").trigger('click');
					if( e.keyCode == 27 ) $("#popup_cancel").trigger('click');
				});
			break;
			case 'prompt':
				$("#popup_message").append('<br /><input type="text" id="popup_prompt" />').after('<div id="popup_panel"><input type="button" value="' + $.alerts.okButton + '" id="popup_ok" /> <input type="button" value="' + $.alerts.cancelButton + '" id="popup_cancel" /></div>');
				$("#popup_prompt").width( $("#popup_message").width() );
				$("#popup_ok").click( function() 
				{
					var val = $("#popup_prompt").val();
					$.alerts._hide();
					if( callback ) callback( val );
				});
				$("#popup_cancel").click( function() 
				{
					$.alerts._hide();
					if( callback ) callback( null );
				});
				$("#popup_prompt, #popup_ok, #popup_cancel").keypress( function(e) 
				{
					if( e.keyCode == 13 ) $("#popup_ok").trigger('click');
					if( e.keyCode == 27 ) $("#popup_cancel").trigger('click');
				});
				if( value ) $("#popup_prompt").val(value);
				$("#popup_prompt").focus().select();
			break;
		}
	
		//鼠标拖拽函数
		if($.alerts.draggable) 
		{
			try 
			{
			$("#popup_container").draggable({ handle: $("#popup_title") });
			$("#popup_title").css({ cursor: 'move' });
			}
			catch(e) 
			{
			}
		}
	},

	//对话框隐藏函数
	_hide: function() 
	{
		$("#popup_container").remove();
		$.alerts._overlay('hide');
		$.alerts._maintainPosition(false);
	},

	//遮罩层函数
	_overlay: function(status) 
	{
		switch( status ) 
		{
			case 'show':
			$.alerts._overlay('hide');
			$("BODY").append('<div id="popup_overlay"></div>');
			$("#popup_overlay").css({
			position: 'absolute',
			zIndex: 99998,
			top: '0px',
			left: '0px',
			width: '100%',
			height: $(document).height(),
			background: $.alerts.overlayColor,
			opacity: $.alerts.overlayOpacity
			});
			break;
			case 'hide':
			$("#popup_overlay").remove();
			break;
		}
	},

	//对话框定位函数
	_reposition: function() 
	{
		var top = (($(window).height() / 2) - ($("#popup_container").outerHeight() / 2)) + $.alerts.verticalOffset;
		var left = (($(window).width() / 2) - ($("#popup_container").outerWidth() / 2)) + $.alerts.horizontalOffset;
		if( top < 0 ) top = 0;
		if( left < 0 ) left = 0;
		if ('undefined' == typeof (document.body.style.maxHeight)) top = top + $(window).scrollTop();
		$("#popup_container").css(
		{
			top: top + 'px',
			left: left + 'px'
		});
		$("#popup_overlay").height( $(document).height());
	},

	//窗口放大放小函数
	_maintainPosition: function(status) 
	{
		if( $.alerts.repositionOnResize ) 
		{
			switch(status) 
			{
			case true:
				$(window).bind('resize', function() {
					$.alerts._reposition();
				});
			break;
			case false:
				$(window).unbind('resize');
			break;
			}
		}
	}
},

	/**
	 * alert对话框
	 * @param imgtype 图片类型 warn:警告 success:成功 error:失败
	 * @param message 内容
	 * @param title 标题
	 * @param callback 回调函数为null
	 * @see
	 * $alert("warn","这是alert对话框","111医药馆提示您",null);
	 */
	$alert = function(imgtype, message, title, callback) 
	{
		$.alerts.alert(imgtype, message, title, callback);
	};
	
	/**
	 * alertCanDisplay对话框
	 * @param imgtype 图片类型 warn:警告 success:成功 error:失败
	 * @param message 内容
	 * @param title 标题
	 * @param callback 回调函数为null
	 * @see
	 * $alertCanDisplay("warn","这是alert对话框","111医药馆提示您",null);
	 */
	$alertCanDisplay = function(imgtype, message, title, callback) 
	{
		$.alerts.alertCanDisplay(imgtype, message, title, callback);
	};
	
	/**
	 * confirm对话框
	 * @param imgtype 图片类型 warn:警告 success:成功 error:失败
	 * @param message 内容
	 * @param title 标题
	 * @param callback 回调函数的返回值为布尔类型
	 * @see
	 * $confirm("warn","这是confirm对话框",null,function(result)
	 * {
	 *   if(result)
	 *   {
	 *	    console.log(result);
	 *   }
	 * });
	 */
	$confirm = function(imgtype, message, title, callback) 
	{
		$.alerts.confirm(imgtype, message, title, callback);
	};
	
	/**
	 * prompt对话框
	 * @param imgtype 图片类型 warn:警告 success:成功 error:失败
	 * @param message 内容
	 * @param value 所填内容
	 * @param title 标题
	 * @param callback 回调函数的返回值为value之对象内容
	 * @see
	 * $prompt("warn","这是prompt对话框",null,null,function(result)
     * {
     *  	console.log(result);
     * });
	 */
	$prompt = function(imgtype, message, value, title, callback)
	{
		$.alerts.prompt(imgtype, message, value, title, callback);
	};

})(jQuery);