
/** writing the cookie of browser */
function setCookie(name,value) 
{ 
    var Days = 90; 
    var exp = new Date(); 
    exp.setTime(exp.getTime() + Days*24*60*60*1000); 
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString() + ";path=/"; 
} 

/** reading the cookie of browser */
function getCookie(name) 
{ 
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    
    if(arr=document.cookie.match(reg))
    {
    	return unescape(arr[2]); 
    }
    else 
    {
    	return null; 
    }
} 

/** deleting the cookie of browser */
function delCookie(name) 
{ 
    var cval = getCookie(name); 
    if(cval != null) 
    {
    	var exp = new Date(); 
    	exp.setTime(exp.getTime() - 1); 
    	document.cookie= name + "="+cval+";expires="+exp.toGMTString() + ";path=/"; 
    }
}

var id = "";
/**
 * Put the product information in COOKIE collector
 * @param proid：商品ID
 * @param price：价格
 * @param img：商品图片
 * @param name：商品名称
 */
function putProInCookie(proid, price, img, name)
{
	var proArray = proid+"#"+price+"#"+img+"#"+removeSign(name);
	var i = proArray;
	if(getCookie("id") == null)
	{
		id += i + ":::";
		setCookie("id",id);
	}
	else
	{
		var ids = getCookie("id");
		if(ids.indexOf(i) < 0)
		{
			ids += i + ":::";
			setCookie("id",ids);
		}
	}
}

/** remove the charactor of # */
function removeSign(content)
{
	if(content.indexOf("#") > 0)
	{
		var a = content.split("#");
		var r = "";
		for(var i=0;i<a.length;i++)
		{
			r+=a[i];
		}
		return r;
	}
	return content;
}

/** invert the strings */
function $invert(str)
{
	try
	{
		var s = str.substring(0,str.length-3);
		var a = s.split(":::");
		var t = "";
		for(var i=a.length-1;i>=0;i--)
		{
			t += a[i] + ":::";
		}
		console.log("$invert.t= "+t);
		return t;
	}
	catch(e)
	{
		console.log(e);
		return str;
	}
}

/**
 * 通过特殊符号反转字符串
 * @param str ：要反转的字符串
 * @param symbol : 特殊符号
 * @param lg : 特殊符号长度
 * @returns 返回目标字符串
 */
function invertStr(str, symbol, lg)
{
	try
	{
		var s = str.substring(0,str.length-lg);
		var a = s.split(symbol);
		var t = "";
		for(var i=a.length-1;i>=0;i--)
		{
			t += a[i] + symbol;
		}
		console.log("invertStr.@returns = "+t);
		return t;
	}
	catch(e)
	{
		console.log(e);
		return str;
	}
} 

var kws = "";
/** Put the keyword into cookie */
function putKeyWordsInCookies(j)
{
	var i = encodeURIComponent(j);
	if(getCookie("kws") == null)
	{
		kws += i + "@";
		setCookie("kws",kws);
	}
	else
	{
		var ky = getCookie("kws");
		if(ky.indexOf(i) < 0)
		{
			ky += i + "@";
			setCookie("kws",ky);
		}
		console.log("ky="+ky);
	}
	console.log("putKeyWordsInCookies.i="+i);
}













