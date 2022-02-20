$(function (){
	$(".title_first a").css("color","#333333");
	$(".title_first a").hover(function () {
		$(this).css("color","red")
	},function () {
		$(this).css("color","#333333")
	})
	$(".author_first a").css("color","#777777")
	$(".author_first a").hover(function () {
		$(this).css("color","red")
	},function () {
		$(this).css("color","#777777")
	})
	
	$(".touxiang").click(function(){
		var author=$(this).next().text();
		window.open("author_blogs?author="+author);  
	})
})