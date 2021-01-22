package com.tmb.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
private static WebDriver driver;
	
	private static ThreadLocal<WebDriver> dr=new ThreadLocal<WebDriver>();// How it will work internally I have to check later on About thi 
	// For this I Have to create 3 metods to load and set and close the thread loacl 
	public static WebDriver getDriver()
	{
		return dr.get(); /// this is for the thread local 
	}
	
	public static void setDriver(WebDriver driverRef)
	{
		dr.set(driverRef);// this is for set the WebDriver value to the ThreadLoacl class for the Parallel execution 
	}
	
	public static void unLoad()
	{
		dr.remove();// this is for the remove Thread in locally normally 
	}
	
	

}
