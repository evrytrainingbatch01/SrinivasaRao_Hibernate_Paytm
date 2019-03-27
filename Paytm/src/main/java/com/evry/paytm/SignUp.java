package com.evry.paytm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet {

	private static UserDetailsDao uda=new UserDetailsDao();
	private static UserDetails ud;
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	  System.out.println("Hello you entered into SignUp servlet Get method");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.print("Registration Form: <br><br> "
				+ "<form action=\"/Paytm/signup\" method=\"post\">"
				+ "UserName :<input type=\"text\" name=\"username\"><br>Password :<input type=\"text\" name=\"password\"><br>Confirm Password :<input type=\"text\" name=\"confirmpassword\"><br><button type=\"submit\">SignUp</button></form>");
		
		
	
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	  System.out.println("Hello you entered into SignUp servlet post method");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ud=new UserDetails();
		ud.setUsername(req.getParameter("username"));
		ud.setPassword(req.getParameter("password"));
		
		uda.createUserDetails(ud);
		
		pw.println("Hi... "+req.getParameter("username")+" you have been registered succesfully . plese login <br><br>"
				+ "<form><button type=\"submit\" formaction=\"/Paytm/loginform\">Login</button></form>");
	
	}
}
