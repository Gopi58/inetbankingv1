package com.inetbanking.testcases;

import com.inetbanking.pageobjects.Loginpage;

public class TC_Addcustomer extends Base_Class{
	
	public void Addcustomer() throws InterruptedException
	
	{
		Loginpage lp = new Loginpage(driver);
		lp.SetUsername(Username);
		lp.Setpassword(Password);
		lp.LoginButn();
		
		Thread.sleep(3000);
		
	}
	
	

}
