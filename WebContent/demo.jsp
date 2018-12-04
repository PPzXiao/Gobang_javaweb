<%@ page language="java" import="java.util.*" import="com.entity.User" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge; charset=utf-8">
    <title>五子棋</title>
    <link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/success.css">
<link rel="stylesheet" type="text/css" href="css/particles.css">
</head>
<body>
<!--五子棋--> 
<div class="top"> 
  		<div class="top-img-left" alt="" src="img/flower1.png"></div>
  		<div class="top-img-right" alt="" src="img/flower2.png"></div>
  		<div class="userinfo">
  			<span class="welcome">biu~${userInfo.getName()}</span>
  			<img class="headimg" alt="" src="img/headimg.png">
  			<div class="show">
  				<a href="Modify.jsp"><div>修改信息</div>
  				<a href="ModifyP.jsp"><div>修改密码</div>
  				<a href="login.jsp"><div>退出登录</div></a>
  			</div>
  		</div>
  		<div class="top-title">.o GoBang o.</div>
  		  	</div>
  <div class="middle">
  	<div class="middle-left">
  		<div class="chess">
  		<canvas id="chess" width="450px" height="450px"></canvas>
  		</div>
  	</div>
  	<div class="middle-right">
  	</div>
  </div> 
 <script src="js/index.js"></script> 
</body>
</html>