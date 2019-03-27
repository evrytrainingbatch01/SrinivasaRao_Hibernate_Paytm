package com.evry.paytm;

import java.util.Random;

public class CommonFunctionality {
	
	public static int generateAccountNo()
	{
		Random rd=new Random();
		return rd.nextInt(10000000);
		
	
}
}