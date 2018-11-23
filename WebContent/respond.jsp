<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="respond.css">

<title>回复</title>
</head>

<body>
<form action="RespondServlet" method="post">
<%@page contentType="text/html; charset=utf-8" %>
<div class="smart-green"> 
<h1>回复</h1>
<br>

<br>
 请回答(灬°ω°灬) 
<textarea rows="5" cols="30" name="Answer"></textarea><br><br>
<br>
  <br>
  
<button type="button" class="button"  onclick="this.form.submit();return fun()">发送</button>
 
<a href="success.jsp" class="button" style="text-decoration:none" >返回</a>
</div>
</form>

<script>
function fun(){
		alert("回复成功！")	
	}
</script>
</body>
</html>