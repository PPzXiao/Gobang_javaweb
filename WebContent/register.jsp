<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>注册页面</title>
</head>
<body>
<form action="RegisterServlet"method="post" style="padding-top:-700px;">
	   输入用户名:<input name="Nickname" type="text"><br><br>
	   输入密码:<input name="Password" type="password"><br><br>
	   输入邮箱:<input name="Email" type="text"><br><br>  
	   <input type="reset" value="重置"><input type="submit" value="注册">
</form>
</body>
</html>