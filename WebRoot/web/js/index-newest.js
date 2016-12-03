$(function()
{
	//图片延迟加载
	$(".lazy").lazyload(
	{
		threshold: 100,
		effect: "fadeIn",
		skip_invisible: false
	});
	
	//限购倒计时
	var $day = $(".t-d-a-day");
	var $hour = $(".t-d-a-hour");
	var $min = $(".t-d-a-min");
	var $sec = $(".t-d-a-secon");
	//距离开始时间
	var starttime = $.trim($("#startTime").val());
	//距离结束时间
	var endtime = $.trim($("#endTime").val());
	var isShow = false;
	function ShowCountDown()
	{ 
		var p;
		if(isShow == false)
		{
			p = fnt(starttime);
		}
		else
		{
			p = fnt(endtime);
		}
		var year = p[0];
		var month = p[1];
		var day = p[2];
		var hour = p[3];
		var min = p[4];
		var sec = p[5];
		var now = new Date(); 
		var endDate = new Date(year, month-1, day, hour, min, sec); 
		var leftTime = 0;
		if(endDate.getTime()-now.getTime() > 0)
		{
			leftTime = endDate.getTime()-now.getTime();
		}
		else
		{
			leftTime = dif(starttime, endtime);
			if(isShow == false)
			{
				isShow = true;
			}
		}
		if(leftTime <= 0)
		{
			$day.html("00");
			$hour.html("00");
			$min.html("00");
			$sec.html("00");
			return;
		}
		else
		{
			var leftsecond = parseInt(leftTime/1000); 
			var day = Math.floor(leftsecond/(60*60*24)); 
			var hour = Math.floor((leftsecond-day*24*60*60)/3600); 
			var minute = Math.floor((leftsecond-day*24*60*60-hour*3600)/60); 
			var second = Math.floor(leftsecond-day*24*60*60-hour*3600-minute*60);
			if(day <= 0)
			{
				$day.html("00");
			}
			else
			{
				$day.html(day);
			}
			if(hour <= 0)
			{
				$hour.html("00");
			}
			else
			{
				$hour.html(hour);
			}
			if(minute <= 0)
			{
				$min.html("00");
			}
			else
			{
				$min.html(minute);
			}
			if(second <= 0)
			{
				$sec.html("00");
			}
			
			else
			{
				$sec.html(second);
			}
		}
    } 
	
	//开始倒计
    window.setInterval(function(){ShowCountDown();}, 1000);
    
    //时间到期
    var clearTime = null;
        clearTime = window.setInterval(function()
        {
        	if(dif(starttime, endtime) == 0)
        	{
    			$day.html("00");
    			$hour.html("00");
    			$min.html("00");
    			$sec.html("00");
        	}
			if(($day.html() == '00') && ($hour.html() == '00') && ($min.html() == '00') && ($sec.html() == '00') && dif(starttime, endtime) == 0)
		    {
		    	isShow = false;
		    }
			if(isShow)
			{
				changeBtn(1);
				$(".countdown-title").html("距离结束");
			}
			else
			{
				changeBtn(1);
				$(".countdown-title").html("距离开始");
				if(($day.html() == '00') && ($hour.html() == '00') && ($min.html() == '00') && ($sec.html() == '00') && dif(starttime, endtime) == 0)
				{
					changeBtn(2);
					$(".countdown-title").html("限时抢购");
					window.clearInterval(clearTime);
				}
			}
        },1000);
        
});

/**
 * 计算两时间差
 * @param stime 开始时间
 * @param etime 结束时间
 */
function dif(stime, etime)
{
	var _s = fnt(stime);
	var _e = fnt(etime);
	if(isTrue(_e[0], _e[1], _e[2], _e[3], _e[4], _e[5]))
	{
		var _sd = new Date(_s[0], _s[1], _s[2], _s[3], _s[4], _s[5]).getTime();
		var _ed = new Date(_e[0], _e[1], _e[2], _e[3], _e[4], _e[5]).getTime();
		var _f = parseInt(_ed) - parseInt(_sd);
		if(_f > 0)
		{
			return _f;
		}
	}
	return 0;
}

/**
 * 格式化时间
 * @param stime
 * @returns {Array}
 */
function fnt(stime)
{
	var n = new Array();
	var a = stime.split(" ");
	var b = a[0].split("-");
	var c = a[1].split(":");
	n[0] = b[0];
	n[1] = b[1];
	n[2] = b[2];
	n[3] = c[0];
	n[4] = c[1];
	n[5] = c[2];
	return n;
}

/**
 * 判断时间合法性
 */
function isTrue(year,month,date,hour,min,sec)
{
	var d = new Date();
	var _year = parseInt(d.getFullYear());
	var _month = parseInt((parseInt(d.getMonth())+1));
	var _date = parseInt(d.getDate());
	var _hour = parseInt(d.getHours());
	var _min = parseInt(d.getMinutes());
	var _sec = parseInt(d.getSeconds());
	if(year < _year)
	{
		return false;
	}
	if(year > _year)
	{
		return true;
	}
	if(year == _year)
	{
		if(month < _month)
		{
			return false;
		}
		if(month > _month)
		{
			return true;
		}
		if(month == _month)
		{
			if(date < _date)
			{
				return false;
			}
			if(date > _date)
			{
				return true;
			}
			if(date == _date)
			{
				if(hour < _hour)
				{
					return false;
				}
				if(hour > _hour)
				{
					return true;
				}
				if(hour == _hour)
				{
					if(min < _min)
					{
						return false;
					}
					if(min > _min)
					{
						return true;
					}
					if(min == _min)
					{
						if(sec < _sec)
						{
							return false;
						}
						if(sec >=  _sec)
						{
							return true;
						}
					}
				}
			}
		}
	}
}


/**
 * 加载最新评论、最新资讯
 */
var liLg = 0;
window.onload = function()
{
	loadingDataInHome();
};

function loadingDataInHome()
{
	if(liLg == 0)
	{
		//加载最新评论
		$.ajax(
		{  
			type: "get",               
			url: "/index!newcomment.action",               
			success: function(data)
			{  
				var jsonArry = eval(data);
				var newest = "";
				for(var i=0;i<jsonArry.length;i++)
				{
					//商品id
					var proId = jsonArry[i].goods_id;
					//商品图片
					var proImg;
					if(jsonArry[i].prourl == '' || jsonArry[i].prourl == null)
					{
						proImg = "/web/images/300.jpg";
					}
					else
					{
						proImg = imgUrl+jsonArry[i].prourl;
					}
					//用户头像
					var userUrl;
					if(jsonArry[i].uhurl == '' || jsonArry[i].uhurl == null)
					{
						userUrl = "/static/image/user-img-little.jpg";
					}
					else
					{
						userUrl = jsonArry[i].uhurl;
					}
					//用户昵称
					var userNickName;
					if(jsonArry[i].nickname == '' || jsonArry[i].nickname == null)
					{
						userNickName = "该用户暂时没有昵称";
					}
					else
					{
						userNickName = jsonArry[i].nickname;
					}
					//商品评论
					var comment = jsonArry[i].comment;
					newest += 
							"<li>"
							+"<div class='comment-pro'><img src='"+proImg+"' onclick='toaim("+proId+");'/></div>"
							+"<div class='comment-show'>"
							+"<div class='comment-user'>"
							+"<img src='"+userUrl+"'/>"
							+"<span>"+userNickName+"</span>"
							+"</div>"
							+"<p title='"+comment+"'><i></i><span>"+comment+"</span></p>"
							+"</div>"
							+"</li>";
					}
					$("#newest-ui").append(newest);
					
				},  
				error: function()
				{  
					console.log("server error !");
				}  
			}); 
	//加载最新资讯
	$.ajax(
	{  
		type: "get",               
		url: "/index!newconsult.action",               
		success: function(data)
		{  
			var jsonArry = eval(data);
			var newest = "";
			if(jsonArry != '' && jsonArry != null)
			{
				for(var i=0;i<jsonArry.length;i++)
				{
					//问
					var content = jsonArry[i].content;
					//答
					var answer = jsonArry[i].answer;
					//管理员头像
					var adminurl = "http://ui1.111yao.com/static/image/temp/20151016/e71aac77378b8861e06819b0bb9ba9e5.jpg";
					//用户头像
					var userurl;
					if(jsonArry[i].userurl == '' || jsonArry[i].userurl == null)
					{
						userurl = "/static/image/user-img-little.jpg";
					}
					else
					{
						userurl = jsonArry[i].userurl;
					}
					newest += 
						"<li class='event clearfix clear'>"
						+"<img src='"+userurl+"'/>"
						+"<p><i></i><span>"+content+"</span></p>"
						+"</li>"
						+"<li class='clearfix clear'>"
						+"<img src='"+adminurl+"'/>"
						+"<p><i></i><span>"+answer+"</span></p>"
						+"</li>";
				    }
					$("#consult-list").append(newest);
			}
		},  
		error: function()
		{  
			console.log("server error !");
		}  
		}); 
		liLg = 2;
	}
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

function toaim(id)
{
	var url = "/p/"+id+".html";
	window.open(url,"_blank");
}

//改变抢购按钮
function changeBtn(type)
{
	if(type == 1)
	{
		$(".panic-buying-pro li a").find("b").each(function(index)
		{
			$(this).removeClass("grabgo").addClass("grab");
		});
	}
	if(type == 2)
	{
		$(".panic-buying-pro li a").find("b").each(function(index)
		{
			$(this).removeClass("grab").addClass("grabgo");
		});
	}
}
