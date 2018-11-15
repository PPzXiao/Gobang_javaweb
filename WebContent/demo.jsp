<%@ page language="java" import="java.util.*" import="com.entity.User" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>五子棋</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<!--五子棋-->
<div class="left">
    <canvas id="chess" width="450px" height="450px"></canvas>
</div>
<div class="right">${userInfo.getName()}</div>
    <script src="index.js"></script>
</body>
</html>