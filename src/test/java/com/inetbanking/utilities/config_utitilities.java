package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class config_utitilities {
	
	Properties Pro;

    public config_utitilities()
	{
		File src = new File("./Configuration/Config.properties");
			try
			{
				FileInputStream fil = new FileInputStream(src);
				Pro=new Properties();
				Pro.load(fil);
			}
			catch (Exception e)
			{
				System.out.print("The Exception is:" + e);
			}
	}
    
    public String getApplicationURL()
    {
    	String AURL=Pro.getProperty("url");
    	return AURL;
    }
    
    public String getapplicationUsername()
    
    {
    	String Ausername=Pro.getProperty("Username");
    	return Ausername;
    }
    
    public String getapplicationPassword()
    {
    	String Apassword=Pro.getProperty("Password");
    	return Apassword;
    
    }
    
    public String getchromepath()
    {
    	String chromepath=Pro.getProperty("chromepath");
    	return chromepath;
    }
    
    public String getIEPath()
    {
    	String IeBrowserpath=Pro.getProperty("IeBrowserpath");
    	return IeBrowserpath;
    }
    
    public String getFirefoxpath()
    {
    	String MozillaBrowserpath=Pro.getProperty("MozillaBrowserpath");
    	return MozillaBrowserpath;
    }
}
