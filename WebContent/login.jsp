<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="login.css">
<title>登陆</title>
</head>
<body>
<div class="top"> 
	<div class="top-title">.o Gobang o.</div>
	<div class="top-subtitle">来与ai对战吧！</div>
	<form class="form1" action="LoginServlet"  method="post" >
		<input class="form-control" type="text" autocomplete="off" name="Nickname" placeholder="用户名"><br><br>
		        <p class="tip">请输入合法的邮箱地址</p>
 		密码：     	<input class="form-control" type="password" name="Password"><br><br>
 				<div class="reg_suc">${message}</div>
	         	<button type="button"  class="btn btn-primary login" onclick="this.form.submit()">登陆</button>
	</form>
	<div class="top-bottom">
 		<span>还没有账号？</span><a href="register.jsp" class="" onclick="this.form.submit()"> 注册</a>
 	</div>
 	<a href="ADlogin.jsp">
 	<img class="admin" alt="" src="./pika.png">
 	</a>
</div>
   	<script src="./jquery.min.js"></script>
    <script>
        $(function () {
            $('input').val('')
            $('.login').on('click', function () {
                $('.tip').show()
            })
        })
    </script>

</body>
</html>