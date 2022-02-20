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
		boolean isMultipart=ServletFileUpload.isMultipartContent(request);//�ж��Ƿ����ļ��ϴ����ύ����
		if(isMultipart){//���ļ��ϴ�������
			//����FileItemFactory ����
			FileItemFactory factory=new DiskFileItemFactory();
			//����ServletFileUpload
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
				if(item.isFormField()){//�ж��Ƿ�����ͨ���ֶ�
					String name=item.getFieldName();//���name����ֵ
					String value=item.getString("UTF-8");
					//System.out.print(name+"="+value+"<br>");
				}else{//�ļ��ϴ����ֶ� file������
					//String[] exts={"png","jpg","bmp","gif"};
					List<String> esList=Arrays.asList("png","jpg","bmp","gif");
					String fileName=item.getName();//����ļ�����
					String ext=fileName.substring(fileName.lastIndexOf('.')+1);//����ļ��ĺ�׺��
					//out.print(ext);
					if(esList.contains(ext)){//�жϼ������Ƿ�������ϴ����ļ���ʽ
						String path=this.getServletContext().getRealPath("headAddress");
						//String path=application.getRealPath("imgUpload");
						String wenjiangming=author+"."+ext;		
						String filePath=path+"/"+wenjiangming;
						//System.out.print(filePath);
						//�޸����ݿ�
						Blogs_authorService bas=new Blogs_authorServiceImp();
						bas.update_AuthorHead(author, wenjiangming);
						request.getSession().setAttribute("head", wenjiangming);//�޸�session�е�ͷ��ֵ
						
						
						File file=new File(filePath);
						//out.print(fileName);
						try {
							item.write(file);//�����ļ�
						} catch (Exception e) {
							e.printStackTrace();
						}
						response.sendRedirect("select_author_blogs.jsp");
						//System.out.println("����ɹ�");
					}else{
						PrintWriter out=response.getWriter();
						out.write("<script type='text/javascript'>");
						out.write("alert('ͼƬ��ʽ������png��jpg��bmp��gif��ʽ');");
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
