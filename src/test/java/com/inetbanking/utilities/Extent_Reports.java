package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Reports {
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports Extenttest;
	public ExtentTest logger;


public void CreateReport(ITestContext testContext) throws IOException
{
	String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String repname="Test-Report"+ timestamp+".html";
	
	htmlReporter =new ExtentSparkReporter(System.getProperty("user.dir")+"test-output"+repname);
	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent.config.xml");
	
	htmlReporter.config().setDocumentTitle("Ebanking Automation Report");
	htmlReporter.config().setReportName("Automation Report");
	htmlReporter.config().setTheme(Theme.DARK);
	
	Extenttest=new ExtentReports();
	Extenttest.attachReporter(htmlReporter);
	
	Extenttest.setSystemInfo("Hostname", "1.010.23");
	Extenttest.setSystemInfo("Testname","Gopi");
	Extenttest.setSystemInfo("ApplicationName","Ebanking");
}

public void Testsuccess(ITestContext tr)
{
	logger=Extenttest.createTest(tr.getName());
	logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
}

public void TestFailure(ITestContext tr)
{
	logger=Extenttest.createTest(tr.getName());
	logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	
     String Screenshot=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
     
     File fr=new File(Screenshot);
     if(fr.exists())
     {
    	 try
    	 {
    		 logger.fail("The Screendetails is below:" +logger.addScreenCaptureFromPath(Screenshot));
    	 }
    	 catch (Exception e)
    	 {
    		 System.out.print(e);
    	 }
     }
    		 }
public void TestSkipped(ITestContext tr)
{
	logger=Extenttest.createTest(tr.getName());
	logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	
}

public void finish()

{
	Extenttest.flush();
}

}