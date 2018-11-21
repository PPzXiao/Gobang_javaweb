<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>    <title>所有问题页面</title>
    
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>所有用户页面</title>
    <script type="text/javascript">
    function post(i) {
    	var testform=document.getElementById("update").getElementsByTagName("form");
    	console.log(testform);
    	testform[i-1].submit();
    	}
    </script>
  </head>
  
  <body id="update">
  
  <div class="container">
	<div class="row clearfix">
		<div class="col-xs-12 column">
			<h1>${message}</h1>
			<table class="table">
  	<thead>
  		<tr class="success">
  			<th>UserID</th>
	  		<th>用户名</th>
	  		<th>密码</th>
	  		<th>注册时间</th>
	  		<th>邮箱</th>
	  		<th>操作</th>
  		</tr>
  	</thead>
     <c:forEach var="U" items="${userAll}" varStatus="userStatus"> 
      <form action="UpdateServlet" method="post"> 
      <tbody>
       <tr>
	       <td><input type="text" style="border:0px" value="${U.getID()}" name="UserID" readonly></td>
	       <td><input type="text" style="border:0px" value="${U.getName()}" style="border:0px" name="Nickname"></td>
	       <td><input type="text" style="border:0px" value="${U.getPwd()}" name="Password"></td>
	       <td><input type="text" style="border:0px" value="${U.getDate()}" name="RegisterDate" readonly></td>
	       <td><input type="text" style="border:0px" value="${U.getEmail()}" name="Email"></td>
	       <td>
	       <div class="btn-group" role="group" aria-label="...">
	    
 		   <button type="button" class="btn btn-default" href="javascript:;" style="text-decoration:none" onclick="post(${userStatus.count});return fun()">更新</button>
 	       <a href="DeleteServlet?UserID=${U.getID()}" style="text-decoration:none" class="btn btn-default" onclick="return fun2()">删除</a>
			</div>
	       </td>
	   </tr>
	   </tbody>
    </form> 
    </c:forEach>  
    </table>
      <div style="text-align:right"  >
     <a href="success.jsp" class="btn btn-default" style="text-decoration:none">返回</a> 
     </div>
    </div>
       </div>
       </div>
       <script>
function fun(){
		alert("更新成功！")	
	}
function fun2(){
	alert("删除成功！")	
}
	
</script>
  </body>
</html>