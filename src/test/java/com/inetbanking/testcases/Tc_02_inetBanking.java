package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;
import com.inetbanking.utilities.xlutils;


import junit.framework.Assert;


public class Tc_02_inetBanking extends Base_Class {
	
	@Test(dataProvider="Logindata")
	public void LoginDDT(String uname,String pass) throws InterruptedException
	{
		Thread.sleep(4000);
		Loginpage lp=new Loginpage(driver);
	    lp.SetUsername(uname);
	    Thread.sleep(4000);
	    logger.info("Username is provided");
	    lp.Setpassword(pass);
	    Thread.sleep(4000);
	    logger.info("Password is provided");
	    lp.LoginButn();
	    Thread.sleep(4000);
	    logger.info("Login passsed");
	    
	    if(isalertpresent()==true)
	    {
	    	driver.switchTo().alert().accept();
	    	driver.switchTo().defaultContent();
	    	Assert.assertTrue(false); 
	    	Thread.sleep(4000);
	    }
	    else
	    {
	    	Assert.assertTrue(true);
	    	Thread.sleep(5000);
	    	lp.Logout();
	    	logger.info("logout is done");
	    	driver.switchTo().alert().accept();
	    	Thread.sleep(4000);
	    	
	    }
	    
	}
	
	public boolean isalertpresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		
	}
	
	catch (Exception e)
		{
		 return false;
		}
		}
	
	@DataProvider(name="Logindata")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/LoginData.xlsx";
		
		int rownum =xlutils.getrowcount(path, "Sheet1");
				
		int colcount=xlutils.getcellcount(path, "Sheet1", 1);
		
		String logindata [][]=new  String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=xlutils.getcelldata(path, "Sheet1",i, j);
			}
		}
		
		return logindata;
	}
	
	

}
