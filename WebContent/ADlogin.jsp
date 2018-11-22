<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="login.css">
<title>管理员登陆</title>
</head>
<body>
<div class="top"> 
	<div class="top-title">.o Gobang o.</div> 
	<div class="top-subtitle">管理员登录</div>
	<form class="form1" action="ADloginServlet"  method="post" >
	<input class="form-control" type="text" name="ADname" placeholder="用户名"><br><br>
 	<input class="form-control" type="password" name="ADpassword" placeholder="密码"><br><br>
	<button type="button" class="btn btn-primary login" onclick="this.form.submit()">登陆</button>
	</form>
 	<a href="login.jsp">
 	<img class="admin" alt="" src="./pika.png">
 	</a>
</div>
</body>
</html>