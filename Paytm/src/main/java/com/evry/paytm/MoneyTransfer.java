package com.evry.paytm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoneyTransfer extends HttpServlet {
	
	private static UserDetailsDao uda=new UserDetailsDao();
	private static RequestDispatcher rd;
	
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	  System.out.println("Hello you entered into WalletCreation servlet post method");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		
		WalletAccount wa=uda.transferMoney(Integer.parseInt(req.getParameter("accountno")), Integer.parseInt(req.getParameter("beneficiaryaccountno")), Integer.parseInt(req.getParameter("amount")));
	    
		
		if(wa!=null)
		{
			
			rd=req.getRequestDispatcher("/welcome.jsp");
			rd.include(req, res);
			pw.println("Beneficiary Account has been credited by "+req.getParameter("amount")+" and your current balance is:"+wa.getBalance());
		
		}
		
		else {
			
			rd=req.getRequestDispatcher("/welcome.jsp");
			rd.include(req, res);
			pw.println("Something went wrong . please try again");
		}
	       
	}

}
