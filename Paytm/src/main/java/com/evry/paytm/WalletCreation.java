package com.evry.paytm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WalletCreation extends HttpServlet {

	private static WalletAccount wac;
	private static UserDetailsDao uda=new UserDetailsDao();
	private static RequestDispatcher rd;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	  System.out.println("Hello you entered into WalletCreation servlet post method");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		System.out.println(req.getParameter("username"));
	        wac=new WalletAccount();
	       wac.setUsername(req.getParameter("username"));
	       uda.createWallet(wac);
	  
		rd=req.getRequestDispatcher("/welcome.jsp");
		rd.include(req, res);
		pw.println("Hi ... "+req.getParameter("username")+" you wallet Account :"+wac.getAccount_no()+" has been created successfully. now you are free to proceed with transactoins ");
	       
	       
	}
}
