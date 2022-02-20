<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="head.jsp" %>
<% 
	/* Object list=request.getAttribute("list");
	if(list==""||list==null){
		response.sendRedirect("SelectAuthor_blogs?author="+author);
		return;
	} */
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    	<title>${zuoz}的博客</title>
    </head>
    <style>
    	#div_last{
    		/* text-align:center; */
    		width:200px;
    		margin: 0px auto;
    	}
    	#sendbolgs{
    		text-decoration: none;
    		color:white;
    	}
    	#tou{
    		position:absolute;
    	}
    	#touxiang12{
    		position:absolute;
    		border-radius: 50%;
			overflow: hidden;
    	}
    	#fenye{
			text-align:center;
			margin: 0px auto;
		}
    </style>
  <body>
    <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div id="tou">
				<h3>
					${zuoz}的博客
				</h3>
				<c:if test="${!empty headAddress}">
					<img id="touxiang12" alt="" src="headAddress/${headAddress}" height="120" width="120"/>
				</c:if>		
			</div>
			<c:if test="${!empty list}">
  				<c:forEach items="${list}" var="item">
				  <div class="body_first">
					  <div class="col-md-12 column" >
							<blockquote>
							<span hidden class="id_getID">${item.getId()}</span>
								<p class="title_first">
									<a target="_blank" href="selectAllBlogs_article?action=one&blogs_id=${item.getId()}">${item.getTitle()}</a>	
								</p> <small><cite>${item.getWrite_time()}</cite>&nbsp;&nbsp;
									<a style="text-decoration:none;">${item.getClassify()}</a>
								</small>
							</blockquote>
						</div>
				  </div>
	 			</c:forEach>
  			</c:if>
  			 <c:if test="${empty list}">
  				<div id="div_last">
	  				<h4>他还没有写过文章哦!</h4>
  				</div>
  			</c:if>
		</div>
		<c:if test="${!empty list}">
		<div class="col-md-12 column" id="fenye">	
			<ul class="pagination pagination-lg">
				<li>
					 <a href="author_blogs?author=${zuoz}&pageNo=${page1.pageNo-1}">上一页</a>
				</li>
				<c:forEach var= "temp"   begin= "1"   step= "1" end="${page1.totalPageCount}">
					<li>
						 <a href="author_blogs?author=${zuoz}&pageNo=${temp-1}">${temp}</a>
					</li>
	 			</c:forEach>
	 			<li>
					 <a href="author_blogs?author=${zuoz}&pageNo=${page1.pageNo+1}">下一页</a>
				</li>
			</ul>
		</div>
		</c:if>
	</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".title_first a").css("color","#333333");
			$(".title_first a").hover(function () {
				$(this).css("color","red")
			},function () {
				$(this).css("color","#333333")
			})
			$("small a").css("color","#777777")
		})
	</script>
  </body>
</html>
