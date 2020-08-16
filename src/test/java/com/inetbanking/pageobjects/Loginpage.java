package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
	public Loginpage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(name="uid")
	WebElement Txtusername;
	
	@FindBy(name="password")
	WebElement Txtpassword;
	
	@FindBy(name="btnLogin")
	WebElement LoginButton;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a") 
	WebElement Logout;
	
	public void SetUsername(String Uname)
	
	{
		Txtusername.sendKeys(Uname);
	}
	
public void Setpassword(String passwrd)
	
	{
	Txtpassword.sendKeys(passwrd);
	}
	

public void LoginButn()

{
	LoginButton.click();
}

public void Logout()
{
	Logout.click();
}


}
