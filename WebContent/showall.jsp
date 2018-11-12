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
  </head>
  
  <body>
  <h1>${message}</h1>
  <table  width="600" border="1" cellpadding="0" >
  		<tr>
  			<th>UserID</th>
	  		<th>用户名</th>
	  		<th>密码</th>
	  		<th>注册时间</th>
	  		<th>邮箱</th>
	  		<th>操作</th>
  		</tr>
     <c:forEach var="U" items="${userAll}"  > 
      <form action="UpdateServlet" method="post"> 
       <tr>
	       <td><input type="text" value="${U.UserID}" name="UserID" ></td>
	       <td><input type="text" value="${U.Nickname}" name="Nickname"></td>
	       <td><input type="text" value="${U.Password}" name="Password"></td>
	       <td><input type="text" value="${U.RegisterDate}" name="RegisterDate"></td>
	       <td><input type="text" value="${U.Email}" name="Email"></td>
	       <td><a href="DeleteServlet?id=${U.UserID}">删除</a>  <input type="submit" value="更新"/></td>
	   </tr>
    </form> 
    </c:forEach>  
    </table>
  </body>
</html>