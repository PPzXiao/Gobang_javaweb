<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>登陆页面</title>
</head>
<body>
	<form action="LoginServlet"  method="post"  style="padding-top:-700px;">
		用户名： 	<input type="text" name="Nickname"value=""><br><br>
 		密码：     	<input type="password" name="Password"value=""><br><br>
	         	<input type="submit" value="登录" name="denglu"><input type="reset" value="重置"><br>
	</form>
	<form action="register.jsp">
	 	<input type="submit" value="新用户注册">
    </form>
</body>
</html>