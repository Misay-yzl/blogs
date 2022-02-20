package com.blogs.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.blogs.service.Blogs_authorService;
import com.blogs.service.imp.Blogs_authorServiceImp;

@WebServlet("/updateHead")
public class Servlet_updateHead extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String author=request.getParameter("author");
		//System.out.println(author);
		boolean isMultipart=ServletFileUpload.isMultipartContent(request);//判断是否是文件上传表单提交请求
		if(isMultipart){//是文件上传表单请求
			//创建FileItemFactory 对象
			FileItemFactory factory=new DiskFileItemFactory();
			//创建ServletFileUpload
			ServletFileUpload upload=new ServletFileUpload(factory);
			//upload.setSizeMax(200*1024);
			List<FileItem> itemList=null;
			try {
				itemList = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(FileItem item:itemList){
				if(item.isFormField()){//判断是否是普通表单字段
					String name=item.getFieldName();//获得name属性值
					String value=item.getString("UTF-8");
					//System.out.print(name+"="+value+"<br>");
				}else{//文件上传表单字段 file作用域
					//String[] exts={"png","jpg","bmp","gif"};
					List<String> esList=Arrays.asList("png","jpg","bmp","gif");
					String fileName=item.getName();//获得文件名称
					String ext=fileName.substring(fileName.lastIndexOf('.')+1);//获得文件的后缀名
					//out.print(ext);
					if(esList.contains(ext)){//判断集合中是否包含所上传的文件格式
						String path=this.getServletContext().getRealPath("headAddress");
						//String path=application.getRealPath("imgUpload");
						String wenjiangming=author+"."+ext;		
						String filePath=path+"/"+wenjiangming;
						//System.out.print(filePath);
						//修改数据库
						Blogs_authorService bas=new Blogs_authorServiceImp();
						bas.update_AuthorHead(author, wenjiangming);
						request.getSession().setAttribute("head", wenjiangming);//修改session中的头像值
						
						
						File file=new File(filePath);
						//out.print(fileName);
						try {
							item.write(file);//保存文件
						} catch (Exception e) {
							e.printStackTrace();
						}
						response.sendRedirect("select_author_blogs.jsp");
						//System.out.println("保存成功");
					}else{
						PrintWriter out=response.getWriter();
						out.write("<script type='text/javascript'>");
						out.write("alert('图片格式必须是png、jpg、bmp、gif格式');");
						out.write("window.location.href='select_author_blogs.jsp';");
						out.write("</script>");
					}
				}
			}
		}else{	
			response.sendRedirect("select_author_blogs.jsp");
		}
		
	}
	
}
