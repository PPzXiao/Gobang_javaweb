<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/success.css">
<link rel="stylesheet" href="css/paging.css">

      <title>登陆成功</title>
  </head>
  <body> 
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
  		<div class="modify">
  			<form action="ModifyPServlet">
	  			<div class="modify-title">修改密码</div>
		  		<input type="hidden" style="" value="${userInfo.getID()}" name="UserID">
		  		<span>用户名</span><input type="text" class="form-control" value="${userInfo.getName()}" name="Nickname" readonly>
			    <span>原密码</span><input type="password" class="form-control"   autocomplete="off"  name="Password0">
			    <span>新密码</span><input type="password" class="form-control"  autocomplete="off"  name="Password1">
			    <span>确认密码</span><input type="password" class="form-control"  autocomplete="off" name="Password2">
			    <button type="button"  class="btn btn-primary" style="width:100px;margin-top:30px;" onclick="this.form.submit()">提交</button>
	    	</form>
	    </div>
  	</div>
  	<div class="middle-right">
  		<div class="start-btn"><a href="demo.jsp" style="text-decoration:none"><div class="btn-title">开始游戏</div></a></div>
  		<c:if test="${grant!=1}">
		<div class="start-btn"><a href="success.jsp" style="text-decoration:none"><div class="btn-title">排行榜</div></a></div>
		</c:if>

  		<c:if test="${grant!=1}">
		<div class="start-btn"><a href="Question.jsp" style="text-decoration:none"><div class="btn-title">留言</div></a></div>
		</c:if>
        <div class="start-btn"><a href="SearchallQ" style="text-decoration:none"><div class="btn-title">查看留言</div></a></div>
		<c:if test="${grant==1}">
		<div class="start-btn"><a href="Searchall"><div class="btn-title" style="text-decoration:none">所有用户</div></a></div>
		</c:if>
  	</div>
  </div>
  		<script>
    	var count="<%=request.getAttribute("message")%>"; 
    	if(count=="1"){
    		alert("修改成功")
    	}
    	else if(count=="0") {alert("修改失败")
		}
    	</script>
		<script src="js/jquery.min.js"></script>
  </body>
</html>