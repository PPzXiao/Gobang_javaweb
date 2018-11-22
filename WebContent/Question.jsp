<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="Question.css">

<title>留言</title>
</head>

<body>
<form action="QuestionServlet" method="post">
<%@page contentType="text/html; charset=utf-8" %>
<div class="smart-green"> 
<h1>留言</h1>
<br>
请提问(*´・ｖ・) 

<input type="text" name="Question"/><br> 
<br>
 具体描述一下吧(灬°ω°灬) 
<textarea rows="5" cols="30" name="Text"></textarea><br><br>
<br>
  <br>
  
<button type="button" class="button"  onclick="this.form.submit();return fun()">发送</button>
 
<a href="success.jsp" class="button" style="text-decoration:none" >返回</a>
</div>
</form>

<script>
function fun(){
		alert("留言成功！")	
	}
</script>
</body>
</html>