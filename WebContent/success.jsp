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
  		<div class="top-title">.o GoBang o.</div>
  		  	</div>
  <div class="middle">
  	<div class="middle-left">
  	<div class="ranktitle">排行榜</div>
  <div class="rankblock">
  		<div class="user ranktop">
  			<div class="me"> 我 </div>
		  	<div class="No">${userInfo.getMyrank()}</div>
		  	<div class="name">
		  		${userInfo.getName()}
		  	</div>	
		  	<div class="rank">${userInfo.getCountW()}-${userInfo.getCountL()}</div>
		  	<div class="rankname">${userInfo.getRankname()}</div>
		  	<div class="point">${userInfo.getSC()}<span class="pts">pts</span></div>
  		</div>
		<div class="ranking">
			<c:forEach items="${userRanking}" var ="R" varStatus="status">
				<div class="user otheruser">
					<div class="No">${R.getMyrank()}</div>
				  	<div class="name">
				  		${R.getName()}
				  	</div>	
				  	<div class="rank">${R.getCountW()}-${R.getCountL()}</div>
				  	<div class="rankname">${R.getRankname()}</div>
				  	<div class="point">${R.getSC()}<span class="pts">pts</span></div>
				</div>
			</c:forEach>
		</div>
		</div>
		<div class="boxcontainer">
			<div class="box" id="box"></div>
		</div>	
  	</div>
  	<div class="middle-right">
  		<div class="start-btn"><a href="demo.jsp" style="text-decoration:none"><div class="btn-title">开始游戏</div></a></div>
  		

  		<c:if test="${grant!=1}">
		<div class="start-btn"><a href="Question.jsp" style="text-decoration:none"><div class="btn-title">留言</div></a></div>
		</c:if>
        <div class="start-btn"><a href="SearchallQ" style="text-decoration:none"><div class="btn-title">查看留言</div></a></div>
		<c:if test="${grant==1}">
		<div class="start-btn"><a href="Searchall"><div class="btn-title" style="text-decoration:none">所有用户</div></a></div>
		</c:if>
		<div class="start-btn"><a href="login.jsp" style="text-decoration:none"><div class="btn-title">退出登录</div></a></div>
  	</div>
  </div>
	<script src="js/success.js" charset="utf-8"></script>
	<script src="js/jquery.min.js" charset="utf-8"></script>
	<script src="js/paging.js" charset="utf-8"></script>
    <script>
    	var count="<%=session.getAttribute("count")%>"; 
        var pages = parseInt((parseInt(count)+4)/5);
        var initpage="<%=session.getAttribute("initpage")%>";
        console.log(pages)
        $('#box').paging({
            initPageNo:initpage , // 初始页码
            totalPages: pages, //总页数
            totalCount: '合计' + count + '条数据', // 条目总数
            slideSpeed: 0, // 缓动速度。单位毫秒
            jump: true, //是否支持跳转
            callback: function(page) { // 回调函数
                console.log(page);
                var temp_form = document.createElement("form");
                temp_form.action = "RankingServlet";
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
  </body>
</html>