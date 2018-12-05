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
    <link rel="stylesheet" type="text/css" href="css/liebiao.css"> 

  </head>
    <body>
     <div id="particles-js">
<div class=back>
  
  <div class="container">
	<div class="row clearfix">
		<div class="col-xs-12 column">
  <h1>${message}</h1>
  <table class="table" >
  	<thead>
  	<div class="alert alert-info" role="alert">
  	<div class="page-header">
	<c:forEach begin="0" end="0" var="U" items="${replyAll}" varStatus="userStatus"> 
             <form action="SearchallR" method="post"> 
           <h1>问题：  ${U.getQuestion()}</h1>
    
     </form>
   </c:forEach>    
   </div>
   </div>
  		<tr class="alert alert-info" role="alert">
  		   
  		    <th></th>
  			<th>回复人</th>
	  		<th>回复内容</th>
	  		<th>回复时间</th>
	  		
  		</tr>
  	</thead> 
 
     <c:forEach var="U" items="${replyAll}" varStatus="userStatus"> 
        <form action="SearchallR" method="post"> 
      <tbody>
       <tr >
   
           <td><input type="hidden" style="border:0px" value="${U.getRID()}" name="RID" ></td>
	       <td><input type="text" style="border:0px" value="${U.getName()}" name="Nickname" readonly></td>
	       <td><input type="text" style="border:0px" value="${U.getAnswer()}" name="Answer" readonly></td>
	       <td><input type="text" style="border:0px" value="${U.getDate2()}" name="RDate" readonly></td>
	  
	   </tr>
	   </tbody>
    </form>
    </c:forEach> 
    </table>
    <div style="text-align:center"  >
    <a href="SearchmyQ"  class="btn btn-info btn-lg" style="text-decoration:none">我的留言</a> 
     <a href="SearchallQ?page=1"  class="btn btn-info btn-lg" style="text-decoration:none">全部留言</a> 
      <a href="success.jsp" class="btn btn-info btn-lg" style="text-decoration:none">主菜单</a> 
    </div>
    </div>
       </div>
          </div>
      		</div>
      		        	</div>
          	
    <script src="js/particles.min.js"></script>
    <script src="js/app3.js"></script>
   	<script src="js/jquery.min.js"></script>
                <script>

function fun2(){
	alert("删除成功！")	
}
	
</script>
  </body>
</html>