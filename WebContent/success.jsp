<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
     <link rel="stylesheet" type="text/css" href="success.css">
      
      <title>登陆成功</title>
  </head>
  <body> 
  	<div class="top">
  		<div class="top-title">.o GoBang o.</div>
  	</div>
  <div class="middle">
  	<div class="middle-left"></div>
  	<div class="middle-right">
  		<div class="start-btn"><a href="demo.jsp"><div class="btn-title">开始游戏</div></a></div>
  		<div class="start-btn"><a href="SearchallQ"><div class="btn-title">查看留言</div></a></div>
		<div class="start-btn"><a href="Question.jsp"><div class="btn-title">留言</div></a></div>
		<c:if test="${grant==1}">
		<div class="start-btn"><a href="Searchall"><div class="btn-title">所有用户</div></a></div>
		</c:if>
  	</div>
  </div>
  
  
  
  
	<span>${userInfo.getName()} ${grant}<br></span>
		<c:if test="${grant==1}"> 
			<a href="Searchall">查看所有用户</a>
		</c:if>
		<a href="SearchallQ">查看所有问题</a>
		<a href="Question.jsp">留言</a>
	<a href="demo.jsp">开始游戏</a>
	<script src="success.js"></script>
  </body>
</html>