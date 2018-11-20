<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="success.css">
      

      <title>登陆成功</title>
  </head>
  <body> 
  	<div class="top"> 
  		<div class="top-img-left" alt="" src="./flower1.png"></div>
  		<div class="top-img-right" alt="" src="./flower2.png"></div>
  		<div class="top-title">.o GoBang o.</div>
  		  	</div>
  <div class="middle">
  	<div class="middle-left"></div>
  	<div class="middle-right">
  		<div class="start-btn"><a href="demo.jsp" style="text-decoration:none"><div class="btn-title">开始游戏</div></a></div>
  		<div class="start-btn"><a href="SearchallQ" style="text-decoration:none"><div class="btn-title">查看留言</div></a></div>
		<div class="start-btn"><a href="Question.jsp" style="text-decoration:none"><div class="btn-title">留言</div></a></div>
		<c:if test="${grant==1}">
		<div class="start-btn"><a href="Searchall"><div class="btn-title" style="text-decoration:none">所有用户</div></a></div>
		</c:if>
  	</div>
  </div>
	<script src="success.js"></script>
  </body>
</html>