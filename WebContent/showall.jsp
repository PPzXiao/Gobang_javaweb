<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
  <h1>${message}</h1>
  <table class="table"  width="600" border="1" cellpadding="0" >
  	<thead>
  		<tr>
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
	       <td><input type="text" value="${U.getID()}" name="UserID" readonly></td>
	       <td><input type="text" value="${U.getName()}" name="Nickname"></td>
	       <td><input type="text" value="${U.getPwd()}" name="Password"></td>
	       <td><input type="text" value="${U.getDate()}" name="RegisterDate"></td>
	       <td><input type="text" value="${U.getEmail()}" name="Email"></td>
	       <td><a href="DeleteServlet?UserID=${U.getID()}">删除</a>  <a href="javascript:;" onclick="post(${userStatus.count})">更新</a></td>
	   </tr>
	   </tbody>
    </form> 
    </c:forEach>  
    </table>
  </body>
</html>