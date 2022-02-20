<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="head.jsp" %>
<% 
	Object author=request.getSession().getAttribute("author");
	if(author==""||author==null){
		response.sendRedirect("index.jsp");
		return;
	}
	Object list=request.getAttribute("page1");
	if(list==""||list==null){
		request.getRequestDispatcher("SelectAuthor_blogs?author="+author).forward(request, response);
		//response.sendRedirect("SelectAuthor_blogs?author="+author1);
		return;
	}
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    	<title>${author}的博客</title>
    </head>
    <style>
    	#div_last{
    		/* text-align:center; */
    		width:250px;
    		margin: 0px auto;
    	}
    	#sendbolgs{
    		text-decoration: none;
    		color:white;
    	}
    	small a{
    		cursor:pointer;
    	}
    	#tou{
    		position:absolute;
    		z-index: 10;
    	}
    	#touxiang12{
    		border-radius: 50%;
			overflow: hidden;
    	}
    
    	.imgInput{
		    opacity: 0;
    	}
    	#fenye{
			text-align:center;
			margin: 0px auto;
		}
		.xiugai{
			height: 0px;
			display:inline
		}
    </style>
  <body>
    <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">		
			<div id="tou">
				<h3>
					${author}的博客
				</h3>
				<c:if test="${!empty headAddress}">
					<img id="touxiang12" alt="" src="headAddress/${headAddress}" height="120" width="120"/>
				</c:if>
				<c:if test="${empty headAddress}">
					<img id="touxiang12" alt="" src="images/默认头像.jpg" height="120" width="120"/>
				</c:if>
				
				<form action="updateHead?author=${author}" method="post" enctype="multipart/form-data">
					<input class="imgInput" type="file" required name="file" accept="image/png,image/gif,image/jpeg,image/bmp" style="width: 72px;"/>
					<input type="button" value="选择文件" class="btn btn-default"/>
					<input type="submit" value="保存" class="btn btn-default"/>
				</form>
				<button class="btn btn-default" id="author_send_blogs">发布文章</button>
			</div>

			<c:if test="${!empty page1.getList()}">
  				<c:forEach items="${page1.getList()}" var="item">
				  <div class="body_first">
					  <div class="col-md-12 column" >
							<blockquote>
							 <span hidden class="id_getID">${item.getId()}</span>
								<p class="title_first">
									<a target="_blank" href="selectAllBlogs_article?action=one&blogs_id=${item.getId()}">${item.getTitle()}</a>	
								</p>
								<small><cite>${item.getWrite_time()}</cite>&nbsp;&nbsp;
								<%-- <a href="select_blogs?id=${item.getId()}" class="update">修改</a> --%>
									<form action="select_blogs" method="post" class="xiugai">
										<input type="text" name="id" hidden>
										<a href="#" class="update">修改</a>
										&nbsp;&nbsp;&nbsp;<a href="#" class="del">删除</a>
									</form>
								</small>
							</blockquote>
						</div>
				  </div>
	 			</c:forEach>
  			</c:if>
  			 <c:if test="${empty page1.getList()}">
  				<div id="div_last">
	  				<h4>你还没有写过文章哦!</h4>
	  				<button type="button" class="btn btn-warning btn-lg" id="author_send_blogs2">发布文章</button>
  				</div>
  			</c:if>
		</div>
		<c:if test="${!empty page1.getList()}">
		<div class="col-md-12 column" id="fenye">	
			<ul class="pagination pagination-lg">
				<li>
					 <a href="SelectAuthor_blogs?author=${author}&pageNo=${page1.pageNo-1}">上一页</a>
				</li>
				<c:forEach var= "temp"   begin= "1"   step= "1" end="${page1.totalPageCount}">
					<li>
						 <a href="SelectAuthor_blogs?author=${author}&pageNo=${temp-1}">${temp}</a>
					</li>
	 			</c:forEach>
	 			<li>
					 <a href="SelectAuthor_blogs?author=${author}&pageNo=${page1.pageNo+1}">下一页</a>
				</li>
			</ul>
		</div>
		</c:if>
	</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript">
		$(function(){
			//发布博客按钮单击事件
			$("#author_send_blogs,#author_send_blogs2").click(function(){
				window.open("send_blogs.jsp");
			})
		
			//选择文件单击事件
			$("input[type='button']").click(function () {
			    $('.imgInput').click()//调用file
			})
			$(".imgInput").change(function(){
		        $("#touxiang12").attr("src",URL.createObjectURL($(this)[0].files[0]));
		    });
		
			$(".title_first a").css("color","#333333");
			$(".title_first a").hover(function () {
				$(this).css("color","red")
			},function () {
				$(this).css("color","#333333")
			})
			//删除
			$(".del").click(function(){
				var flag=confirm("确定要删除嘛?");
				var id=$(this).parent().parent().prev().prev().text()
				if(flag){
					$.post("del_blogs","id="+id,function(data){
						if(data){
							window.location.href="select_author_blogs.jsp";
							alert("删除成功!")
						}else{
							alert("删除失败,请稍后再试!")
						}
					})
				}
				
			})
			
			//修改
			$(".update").click(function(){
				var id=$(this).parent().parent().prev().prev().text()
				$(this).prev().val(id);
				//alert($(this).prev().val())
				$(this).parent().submit();
			})
			
			
		})
	</script>
  </body>
</html>
