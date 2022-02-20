<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page  isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="icon" href="images/favicon (1).ico" type="image/x-icon"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <style>
  	#header_first{
  		width:480px;
  	    text-align:center;
  		margin:0px auto;
  	}
  	.body_first{
  		width:600px;
  	    /* text-align:center; */
  		margin:0px auto;
  	}
  	.title_first,.author_first{
  		cursor:pointer;
  	}
  	body{
  		background: url(images/banner.jpg)no-repeat fixed;
   		background-size: cover;
  	}
  	#fixed{
  		position: fixed;
  		width: 100%;
  		z-index: 10;
  	}
	.body_first11{
		height: 60px
	}
	#div_last{
    		width:150px;
    		margin: 10px auto;
    	}
    	#touxiang{
    		margin-top:13px;
    		border-radius: 50%;
			overflow: hidden;
			cursor:pointer;
    	}
  </style>
  <body>
  <div id="fixed">
	  <nav class="navbar navbar-default" role="navigation">
		<div id="header_first"> 
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">首页</a>
			</div>
			<form action="search_blogs" method="post" class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="搜索" name="name1">
				</div>
				<button type="submit" class="btn btn-default">搜索</button>
			</form>
			<c:if test="${!empty author}">	
					<ul class="nav navbar-nav">		
						<li class="dropdown">	
							<img id="touxiang" alt="" src="headAddress/${head}" height="25" width="25"/>
						</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" id="author_first">
							${author}
							<b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li><a target="_blank" href="select_author_blogs.jsp">个人主页</a></li>
							<li><a target="_blank" href="send_blogs.jsp">写博客</a></li>
							<li class="divider"></li>
							<li><a href="LogoutSession">退出</a></li>
						</ul>
					</li>
				</ul>
			</c:if>
			<c:if test="${empty author}">
  				<div class="navbar-header">
					<a class="navbar-brand" href="login.html">注册/登录</a>
				</div>
  			</c:if>	
		</div>
	  </nav>
	  </div>
 	 <div class="body_first11">
	  </div>
	 </body>
	 	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
		<script type="text/javascript">
				$("#touxiang").click(function(){
					window.open("select_author_blogs.jsp");
				})
				$("input[name=name1]").val("${title}");
		</script>
</html>
