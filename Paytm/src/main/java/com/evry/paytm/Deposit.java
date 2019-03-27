package com.evry.paytm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Deposit extends HttpServlet {
	
	private static UserDetailsDao uda=new UserDetailsDao();
	private static RequestDispatcher rd;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	  System.out.println("Hello you entered into Deposit servlet post method");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		int accountno=Integer.parseInt(req.getParameter("accountno"));
		int amount=Integer.parseInt(req.getParameter("amount"));
		
		WalletAccount wa=uda.depositMoney(accountno, amount);
		
		if(wa!=null)
		{
			
			rd=req.getRequestDispatcher("/welcome.jsp");
			rd.include(req, res);
			pw.println("Money has been successfully  deposited to your account :"+wa.getAccount_no()+" and the current balance is:"+wa.getBalance());
		}
		
		else {
			
			rd=req.getRequestDispatcher("/welcome.jsp");
			rd.include(req, res);
			pw.println("Something went wrong . please try again");
		}
		
	    
		
	       
	       
	}

}
