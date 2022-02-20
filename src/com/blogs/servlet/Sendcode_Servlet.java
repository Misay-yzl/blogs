package com.blogs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blogs.utils.Random_Math;
import com.blogs.utils.SendEmail;
@WebServlet(urlPatterns="/Sendcode",name="Sendcode")
public class Sendcode_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String code=Random_Math.getMath();
		//System.out.println(email+code);
		String flag=req.getParameter("flag");
		System.out.println(flag);
		if(flag==""||flag==null){
			try {
				SendEmail.sendZ(email, code);//∑¢ÀÕ◊¢≤·” œ‰
			} catch (Exception e) {
				System.out.println("∑¢ÀÕ ß∞‹!");
				//e.printStackTrace();
			}
			PrintWriter out=resp.getWriter();
			out.print(code);
			out.flush();
			out.close();
		}else {
			try {
				SendEmail.sendG(email, code);//∑¢ÀÕ’“ªÿ√‹¬Î” œ‰
			} catch (Exception e) {
				System.out.println("∑¢ÀÕ ß∞‹!");
				//e.printStackTrace();
			}
			PrintWriter out=resp.getWriter();
			out.print(code);
			out.flush();
			out.close();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
