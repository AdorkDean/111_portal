  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.div_all{
		width:600px;
		height:500px;
		background-color: #fff;
		margin: auto;
	}
</style>
</head>
<body>
<div class="div_all">
	<div class="div_site_img" style="width:100%;height:60px;float:left;position:relative;padding: 10px;">
		<div style="width:150px;height:60px;">
			<img alt="" src="http://www.111yao.com/web/version2.2.0/images/login/login_logo.png">
		</div>
	</div>
	<div>
		<hr>
		<h4>尊敬的 ${username} 您好：</h4>
		<div style="font-size:12px; color:#5b5b5b;">
		您于 ${time} 申请验证邮箱，点击以下链接，即可完成验证：
		<br>
		为保障您的帐户安全，请在2小时内点击该链接，您也可以将链接复制到浏览器地址栏访问 <a href="${link?default('')}">${link?default('')}</a>
		</div>
	</div>
	
</div>

</body>
</html>