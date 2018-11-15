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
    <title>所有问题页面</title>
    
  </head>
  
  
  <h1>${message}</h1>
  <table class="table"  width="600" border="1" cellpadding="0" >
  	<thead>
  		<tr>
  		
	  		<th>问题</th>
	  		<th>问题内容</th>
	  		<th>留言时间</th>
	  	
  		</tr>
  	</thead> 
     <c:forEach var="U" items="${questionAll}" varStatus="userStatus"> 
        <form action="QuestionServlet" method="post"> 
      <tbody>
       <tr>
	       
	       <td><input type="text" value="${U.getQuestion()}" name="Question" readonly></td>
	       <td><input type="text" value="${U.getText()}" name="Text" readonly></td>
	       <td><input type="text" value="${U.getDate2()}" name="Date" readonly></td>
	       
	   </tr>
	   </tbody>
    </form>
    </c:forEach>  
    </table>
  </body>
</html>