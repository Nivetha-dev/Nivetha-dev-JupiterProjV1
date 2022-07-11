package com.jupiterproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getContactURL()
	{
		String contacturl=pro.getProperty("cotactURL");
		return contacturl;
	}
	
	public String getForename()
	{
	String forename=pro.getProperty("forename");
	return forename;
	}
	
	public String getSurname()
	{
	String surname=pro.getProperty("surname");
	return surname;
	}
	public String getEmail()
	{
	String email=pro.getProperty("email");
	return email;
	}
	public String getTelephone()
	{
	String telephone=pro.getProperty("telephone");
	return telephone;
	}
	public String getMessage()
	{
	String message=pro.getProperty("message");
	return message;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getcartHeader1()
	{
	String cartHeader1=pro.getProperty("cartHeader1");
	return cartHeader1;
	}
	public String getcartHeader2()
	{
	String cartHeader1=pro.getProperty("cartHeader2");
	return cartHeader1;
	}
	public String getcartHeader4()
	{
	String cartHeader1=pro.getProperty("cartHeader4");
	return cartHeader1;
	}
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
	public int[] getitemCount()
	{
	int itemCount[]= {Integer.parseInt(pro.getProperty("itemCount1")),Integer.parseInt(pro.getProperty("itemCount2")),
			Integer.parseInt(pro.getProperty("itemCount3"))};
	return itemCount;
	}
}
