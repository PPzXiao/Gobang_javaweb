<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/particles.css">
<title>登陆</title>
</head>
<body>
<div id="particles-js">
<div class="top">  
	<div class="top-title">.o Gobang o.</div>
	<div class="top-subtitle">来与ai对战吧！</div>
	<form class="form1" action="LoginServlet"  method="post" >
		<input class="form-control" type="text" autocomplete="off" name="Nickname" placeholder="用户名"><br><br>
 		<input class="form-control" type="password" autocomplete="off" name="Password" placeholder="密码" ><br><br>
 				<div class="reg_suc">${message}</div>
	         	<button type="button"  class="btn btn-primary login"  onclick="this.form.submit()">登陆</button>
	</form>
	<div class="top-bottom">
 		<span>还没有账号？</span><a href="register.jsp" class="" onclick="this.form.submit()" > 注册</a>
 	</div>
 	<a href="ADlogin.jsp">
 	<img class="admin" alt="" src="img/pika.png">
 	</a>
</div>
</div>
<script src="js/particles.min.js"></script>
<script src="js/app.js"></script>
   	<script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $('input').val('')
            $('#submit').on('click', function () {
                $('.tip').show()
            })
        })
    </script>

</body>
</html>