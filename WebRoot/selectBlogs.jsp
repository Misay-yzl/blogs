<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="head.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>${blogs.getTitle()}</title>
</head>
<style>
	.ahthor_pinglen{
		cursor:pointer;
	}
	#seblogs_first{
		width:800px;
  		margin:0px auto;
  		opacity: 0.7;
	}
 	
 	#pinglenqu{
 		width:770px;
 		margin:0px auto;
 	}
 	#pinglenqu div{
 		padding: 5px;
 		font-size: 18px;
 	}
 	#inputEmail3{
 		font-size: 18px;
 	}
	#touxiang12{
    		border-radius: 50%;
			overflow: hidden;
			cursor:pointer;
    }
</style>
<body>
	<div id="seblogs_first">
		<div class="col-md-12 column" >
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="text-center">
					${blogs.getTitle()}
					</h3>
				</div>	
				<div class="panel-body">
					<h4>作者:${blogs.getAuthor()}&nbsp;&nbsp;&nbsp;&nbsp;
					时间: ${blogs.getWrite_time()}
					</h4>	
				</div>
				<div class="panel-footer">分类专栏:<span class="label label-info">${blogs.getClassify()}</span> </div>
			</div>	
			<div class="jumbotron well">
				<p>${blogs.getContent()}</p>
			</div>
		</div>
		<div class="div_last">
			<div class="form-group">
					<div class="col-sm-11">
						<input type="text" class="form-control" id="inputEmail3" placeholder="请输入评论"/>
					</div>	
					<button type="button" class="btn btn-default" id="send_pinglun">评论</button>
					
					<div class="panel panel-default" id="pinglenqu">
						<c:if test="${empty  Blogs_commentList}">
							<div class="panel-body" id="no">
								目前还没有人评论哦!
							</div>
						</c:if>
						<c:if test="${!empty  Blogs_commentList}">
							 <c:forEach items="${Blogs_commentList}" var="item">
								 <div class="panel-body">
									<img id="touxiang12" class="ahthro_img_pinglen" alt="" src="headAddress/${item.getHead()}" height="25" width="25"/>
									<span class="ahthor_pinglen">${item.getAuthor()}</span>:
										${item.getContent()} <%-- ${item.getRelease_time()} --%>
								 </div>
							 </c:forEach>
						 </c:if>
					</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript">
		$(function(){
			//头像和评论人单击事件
			$(".ahthor_pinglen").click(function(){
				window.open("author_blogs?author="+$(this).text());
			})
			$(".ahthro_img_pinglen").click(function(){
				window.open("author_blogs?author="+$(this).next().text());
			})
			//评论按钮单击事件
			$("#send_pinglun").click(function(){
				var pinglun=$("#inputEmail3").val();//获取评论内容
				var author=$.trim($("#author_first").text())//获取登录者名字
				var blogsId=${blogs.getId()}//获取博客编号
				if(author==""){
					alert("请先登录!")
					return;
				}
				if(pinglun==""){
					alert("请输入评论!")
					return;
				}
				var reg1 = new RegExp("%","g");//g,表示全部替换。
				var pinglun1=pinglun.replace(reg1,"@baifenhao");
				
				var str="blogsId="+blogsId+"&author="+author+"&content="+pinglun1
				$.post("send_comment",str,function(data){
					if(data){
						$("#no").text("");
						$("#inputEmail3").val("");
						$("#pinglenqu").append("<div class='panel-body'><img id='touxiang12' class='ahthro_img_pinglen' src='headAddress/${head}' height='25' width='25'/><span class='ahthor_pinglen'> "+author+"</span>: "+pinglun+"</div>");
					}else{
						alert("评论失败!");
					}
				})	
			})
		})
	</script>
</body>
</html>