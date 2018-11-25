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
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>    <title>所有问题页面</title>
    

  </head>
    <body>

  
  <div class="container">
	<div class="row clearfix">
		<div class="col-xs-12 column">
  <h1>${message}</h1>
  <table class="table" >
  	<thead>
  		<tr class="success">
  		   
  		    <th></th>
  			<th>回复人</th>
	  		<th>回复内容</th>
	  		<th>回复时间</th>
	  		
  		</tr>
  	</thead> 
  	<%
    int QID =Integer.parseInt(request.getParameter("QID"));   
        if(QID != 0){
        session.setAttribute("userInfo2", QID);
    }
%>
 <%System.out.println(QID); %>
     <c:forEach var="U" items="${replyAll}" varStatus="userStatus"> 
        <form action="SearchallR" method="post"> 
      <tbody>
       <tr >
   
           <td><input type="hidden" style="border:0px" value="${U.getRID()}" name="RID" ></td>
	       <td><input type="text" style="border:0px" value="${U.getName()}" name="Nickname" readonly></td>
	       <td><input type="text" style="border:0px" value="${U.getAnswer()}" name="Answer" readonly></td>
	       <td><input type="text" style="border:0px" value="${U.getDate2()}" name="RDate" readonly></td>
	       <td>
	       <div class="btn-group" role="group" aria-label="...">
	         <c:if test="${grant==1}">
	     <%--   <a href="DeleteQServlet?QID=${U.getQID()}" style="text-decoration:none" class="btn btn-primary" onclick="return fun2()">删除</a> --%>
	       </c:if>
	       </div>
	       </td>
	   </tr>
	   </tbody>
    </form>
    </c:forEach> 
     
   
    </div>
       </div>
          </div>
           <div style="text-align:right"  >
   <%--  <c:if test="${grant==0}">
	         <a href="respond.jsp?QID=${QID}" style="text-decoration:none" class="btn btn-primary ">回复</a>
	            </c:if> --%>
     <a href="SearchallQ" class="btn btn-primary btn-lg" style="text-decoration:none">返回</a> 
     </div>
                <script>

function fun2(){
	alert("删除成功！")	
}
	
</script>
  </body>
</html>