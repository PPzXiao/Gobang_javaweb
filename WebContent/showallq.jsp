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
<link rel="stylesheet" href="css/paging.css">
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
  	<h1>全部留言         <small>留言总数:${count2}  
  	<a href="SearchmyQ" class="btn btn-info " style="text-decoration:none">查看我的留言</a>  
  	<a href="success.jsp" class="btn btn-info " style="text-decoration:none">主菜单
  	</a> </small></h1>
  	
    
    
  	</div>
  	</div>
  		<tr class="alert alert-info" role="alert">

  		    <th></th>
  			<th>留言人</th>
	  		<th>问题</th>
	  		<th>问题内容</th>
	  		<th>留言时间</th>
	  	    <th>操作</th>
  		</tr>
  	</thead> 
     <c:forEach var="U" items="${questionAll}" varStatus="userStatus"> 
        <form action="QuestionServlet" method="post"> 
      <tbody>
       <tr >
           <td><input type="hidden" style="border:0px" value="${U.getQID()}" name="QID"  ></td>
	       <td><input type="text" style="border:0px" value="${U.getName()}" name="Nickname" readonly></td>
	       <td><input type="text" style="border:0px" value="${U.getQuestion()}" name="Question" readonly></td>
	       <td><input type="text" style="border:0px" value="${U.getText()}" name="Text" readonly></td>
	       <td><input type="text" style="border:0px" value="${U.getDate2()}" name="Date" readonly></td>
	       <td>
	       <div class="btn-group" role="group" aria-label="..." >
	        <c:if test="${grant==0}">
	         <a href="respond.jsp?QID=${U.getQID()}" style="text-decoration:none" class="btn btn-info ">回复</a>
	            </c:if>
	           
	         <a href="SearchallR?QID=${U.getQID()}" style="text-decoration:none" class="btn btn-info ">查看回复</a>
	    
	         <c:if test="${grant==1}">
	       <a href="DeleteQServlet?QID=${U.getQID()}" style="text-decoration:none" class="btn btn-info" onclick="return fun2()">删除</a>
	       </c:if>
	       </div>
	       </td>
	   </tr>
	   </tbody>
    </form>
    </c:forEach> 
   
   
    </table >
   <div style="text-align:center">
  	    <div  class="box" id="box"></div>
    </div>
  
    </div>
       </div>
          </div>
          	</div>
          	</div>
          	
    <script src="js/particles.min.js"></script>
    <script src="js/app3.js"></script>
   	<script src="js/jquery.min.js"></script>
    <script src="js/paging.js" charset="utf-8"></script>
    <script>
    	var count2="<%=session.getAttribute("count2")%>"; 
        var pages = parseInt((parseInt(count2)+7)/8);
        var initpage="<%=session.getAttribute("initpage2")%>";
        console.log(pages)
        $(".box").css("width",function(i,curr){
				console.log(curr);
				if(pages<5) return 700-50*(5-pages);
				else return 700;
		});
        $('#box').paging({
            initPageNo:initpage , // 初始页码
            totalPages: pages, //总页数
            totalCount: '合计' + count2 + '条数据', // 条目总数
            slideSpeed: 0, // 缓动速度。单位毫秒
            jump: true, //是否支持跳转
            callback: function(page) { // 回调函数
                console.log(page);
                var temp_form = document.createElement("form");
                temp_form.action = "SearchallQ";
                //如需打开新窗口，form的target属性要设置为'_blank'
                temp_form.target = "_self";
                temp_form.method = "post";
                temp_form.style.display = "none";
                //添加参数
                    var opt = document.createElement("textarea");
                    opt.name = "page";
                    opt.value = page;
                    temp_form.appendChild(opt);
                document.body.appendChild(temp_form);
                //提交数据
                temp_form.submit();
            }
        })
    </script>
    
    
    
                <script>

function fun2(){
	alert("删除成功！")	
}
	
</script>


  </body>
</html>