<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="head.jsp" %>
<% 
	Object author=request.getSession().getAttribute("author");
	if(author==""||author==null){
		response.sendRedirect("index.jsp");
	}
	Object classify=request.getAttribute("classify");
	if(classify==null||classify==""){
		response.sendRedirect("selectAllClassify");
	}
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>写博客</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <style>
  	textarea{
  		width: 1000px;
  		height: 450px;
  		margin-top: -30px;
  	}
  	#inputEmail3{
  		margin: 30px 0px 0px -50px;
  		height: 50px;
  		width:905px;
  		font-size: 30px;
  	}
  	h3{
  		margin-top: 43px;
  	}
  	#fabu{
  		float:right;
  		margin-right:20px;
  		width: 100px;
  	}
  	
  	#div_first123{
  		 opacity: 0.5;
  	}
  	
  </style>
  <body>
    <div class="container">
	<div class="row clearfix" id="div_first123">
		<div class="col-md-12 column">
			<label for="inputEmail3" class="col-sm-2 control-label"><h3>请输入标题:</h3></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3" />
					</div>
			<div class="jumbotron" >
				<p style="margin-top: 100px;">
					<textarea style="resize:none"></textarea>
				</p>
				<p>
        			<div class="option">
			            <label for="fenlei">分类:</label>
			            <!-- <input type="text" id="fenlei"/> -->
						<select id="fenlei">
							 <c:forEach items="${classify}" var="class1">
							 	<option value="${class1.getClassify()}">${class1.getClassify()}</option>
							 </c:forEach>
						</select>
        			</div>
					 <a class="btn btn-primary btn-large"  id="fabu">发布</a>
				</p>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(function(){
		$("#inputEmail3").removeAttr("disabled");
		//$("textarea").text();
		//发布按钮单击事件
		$("#fabu").click(function(){
			var text=$("textarea").val()
			//alert(text)
			
			var reqTAB=new RegExp("\t","g");
			text=text.replace(reqTAB,"@TAB")
			
			var reg = new RegExp("\n","g");//g,表示全部替换。
			text=text.replace(reg,"@huanhang");
			
			var reg1 = new RegExp("%","g");//g,表示全部替换。
			text=text.replace(reg1,"@baifenhao");
			
			var reglg = new RegExp("<","g");//g,表示全部替换。
			text=text.replace(reglg,"@xiaoyuhao");
			var reggt = new RegExp(">","g");//g,表示全部替换。
			text=text.replace(reggt,"@dayuhao");
			
			var title=$("#inputEmail3").val()
			var regtitle = new RegExp("%","g");//g,表示全部替换。
			title=title.replace(regtitle,"@baifenhao");
			
			var regtitleg = new RegExp("<","g");//g,表示全部替换。
			title=title.replace(regtitleg,"@xiaoyuhao");
			var regtitlet = new RegExp(">","g");//g,表示全部替换。
			title=title.replace(regtitlet,"@dayuhao");
			var fenlei=$("#fenlei").val()
			//alert(text)
			var author=$.trim($("#author_first").text())
			if($.trim(title)==""){
				alert("请输入标题!")
				return;
			}
			if($.trim(text)==""){
				alert("请输入内容!")
				return;
			}
			if($.trim(fenlei)==""){
				alert("请选择分类!")
				return;
			}
			if(author==""){
				alert("请先登录!")
				return;
			}
			var str="title="+title+"&fenlei="+fenlei+"&text="+text+"&author="+author
			//return false;
			$.get("select_classify","fenlei="+fenlei,function(data){
				if(data=="true"){
					$.post("send_blogs",str,function(data2){
						if(data2=="true"){
							alert("发布成功!")
							 location.replace(document.referrer);
							
							//window.location.href="index.jsp";
						}else{
							alert("发布失败,请重新再试!")
						}
					})
				}else{
					$.get("add_classify","fenlei="+fenlei,function(){
						$.post("send_blogs",str,function(data2){
							if(data2=="true"){
								alert("发布成功!")
								 location.replace(document.referrer);
								//window.location.href="index.jsp";
							}else{
								alert("发布失败,请重新再试!")
							}
						})
					})
				}
			})
			
		})
	})
</script>
  </body>
</html>
