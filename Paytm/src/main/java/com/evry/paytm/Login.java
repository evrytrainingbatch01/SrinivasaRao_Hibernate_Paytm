package com.evry.paytm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static UserDetailsDao uda=new UserDetailsDao();
	private static boolean flag;
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		RequestDispatcher rd;
	  System.out.println("Hello you entered into Login servlet Get method");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		flag=uda.loginVerify(username,password);
		
		if(flag)
		{
			rd=req.getRequestDispatcher("/welcome.jsp");
			 rd.include(req, res);  
		}
		else
		{
			pw.println("Sorry...  username or Password are incorrect ");
			rd=req.getRequestDispatcher("/index.jsp");
			rd.include(req, res);
		}
		
	
	}
}
