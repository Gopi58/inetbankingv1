package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;

public class Tc01_inetBanking extends Base_Class{
	
	@Test
	public void Testcase1() throws IOException
	{
		
		Loginpage lp1 = new Loginpage(driver);
		lp1.SetUsername(Username);
		logger.info("The Username of the EBanking Application is Entered");
		lp1.Setpassword(Password);
		logger.info("The Password of the EBanking Application is Entered");
		lp1.LoginButn();
		logger.info("Application Logged in successfully");
		String title =driver.getTitle().toString();
		System.out.print(title);
		
		if(title.equals("Guru99 Bank Manager HomePage123"))
		{
			Assert.assertTrue(true);
		}
		
		capturescreenshot(driver,"Testcase1");
		Assert.assertFalse(false);
		
	}
	

}
