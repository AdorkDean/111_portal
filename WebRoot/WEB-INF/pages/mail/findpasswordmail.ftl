<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>找回密码</title>

</head>
<body>
	<p>${username?default('')}:</p>
	<p>您好！</p>
	<p>欢迎使用111医药馆找回密码功能，请点击以下链接重置您的密码(邮件链接两小时内有效，请尽快完成密码重置)</p>
	<p>
		<a href="http://www.111yao.com/findpassword/findpassword!setEamilPassword.action?username=${username?default('')}&key=${randomUUID?default('')}" target="_blank">http://www.111yao.com/findpassword/findpassword!setEamilPassword.action?username=${username?default('')}&key=${randomUUID?default('')}</a>
	</p>
	<p>111医药馆</p>
	<p>${currentDate?string("yyyy-MM-dd")}</p>
</body>
</html>