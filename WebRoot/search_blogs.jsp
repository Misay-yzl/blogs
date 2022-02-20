<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="head.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>${title}</title>
<style>
	#fenye{
		text-align:center;
		margin: 0px auto;
	}
</style>
<c:if test="${empty page1.getList()}">
	<div id="div_last">
		<p>没有该内容,请重新搜索!</p>
	</div>
</c:if>
<c:if test="${!empty page1.getList()}">
	 <c:forEach items="${page1.getList()}" var="item">
		  <div class="body_first">
			  <div class="col-md-12 column" >
					<blockquote>
					<span hidden class="id_getID">${item.getId()}</span>
						<p class="title_first">
							
							<a target="_blank" href="selectAllBlogs_article?action=one&blogs_id=${item.getId()}">${item.getTitle()} </a>	
						</p> <small><span class="author_first">
										<img id="touxiang" class="touxiang" alt="" src="headAddress/${item.getHead()}" height="25" width="25" style="margin-top:0px;"/>
										<a target="_blank" href="author_blogs?author=${item.getAuthor()}">${item.getAuthor()}</a>
									</span> 
									<cite>${item.getWrite_time()}</cite>
									<cite>${item.getContent()}</cite>
							</small>
					</blockquote>
				</div>
		  </div>
	</c:forEach>
	<div class="col-md-12 column" id="fenye">	
			<ul class="pagination pagination-lg">
				<li>
					 <a href="search_blogs?name1=${title}&pageNo=${page1.pageNo-1}">上一页</a>
				</li>
				<c:forEach var= "temp"   begin= "1"   step= "1" end="${page1.totalPageCount}">
					<li>
						 <a href="search_blogs?name1=${title}&pageNo=${temp-1}">${temp}</a>
					</li>
	 			</c:forEach>
	 			<li>
					 <a href="search_blogs?name1=${title}&pageNo=${page1.pageNo+1}">下一页</a>
				</li>
			</ul>
	</div>
</c:if>
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
  </body>
</html>
