package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.config_utitilities;

public class Base_Class {
	
	
	public static WebDriver driver;
	public static Logger logger;
 

	config_utitilities Readconfig =new config_utitilities();
	
	public String url=Readconfig.getApplicationURL();
	public String Username=Readconfig.getapplicationUsername();
	public String Password=Readconfig.getapplicationPassword();
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger=Logger.getLogger("Ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", Readconfig.getchromepath());
		driver =new ChromeDriver(); 
		driver.manage().window().maximize();
		}
		else if(br.equals("IE"))
		{
			
		    System.setProperty("webdriver.ie.driver", Readconfig.getIEPath());
		    DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		   
		    caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
		    driver = new InternetExplorerDriver(caps);
			
		
		}
		else if(br.equals("gecko"))
		{
			System.setProperty("webdriver.gecko.driver", Readconfig.getFirefoxpath());
			driver =new FirefoxDriver(); 
		}
		driver.get(url);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
	public void capturescreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir"+"/Sceenshots/"+tname+".png"));
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
