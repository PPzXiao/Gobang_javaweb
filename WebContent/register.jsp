<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="login.css">
<title>注册页面</title>
</head>
<body>
<div class="top top2"> 
	<div class="top-title">.o Gobang o.</div>
	<div class="top-subtitle">来与ai对战吧！</div>
	<form class="form1" action="RegisterServlet"  method="post">
		用户： 	<input class="form-control" type="text" name="Nickname"><br><br>
 		密码：     	<input class="form-control" type="password" name="Password"><br><br>
	            邮箱：    	<input class="form-control" type="text" name="Email"><br><br>
	            <button type="button" class="btn btn-primary login" onclick="this.form.submit()">注册</button>
	</form>
	<div class="top-bottom">
 		<span>已有账号？</span><a href="login.jsp"> 登陆</a>
	</div>
</div>
</body>
</html>