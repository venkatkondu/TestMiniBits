package com.tmb.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.util.ReadProperty;
import com.tmb.util.ReadProperty2;

public class Driver { // I need this class to launch and close the browser etc...

	//public static WebDriver driver; // to initialize what How this is  
	
	public static void initDriver(String browser) // later on I will pass the browser Name in this class 
	{// avoid some extra nulls I have to add some more mechanism 
						// below is the normal driver reference is required 
		
		if(Objects.isNull(DriverManager.getDriver()))// if driver instance is null then only create a new session 
		{ // by this we can avoid unnecessary browser calling 
			
			if(browser.equalsIgnoreCase("chrome"))
			{
		
		System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
		//driver=new ChromeDriver();// later on I will update this is to the browserLess By using the ChromeOptions 
	/// I have set it to the ThreadLocal for the Parallel execution 
		DriverManager.setDriver(new ChromeDriver()); /// this is for the thread safty 
		//DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// this we will never Use in realTime 
		
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "/home/venkat/Softwares/Browsers/geckodriver");
			//	driver=new FirefoxDriver();
				DriverManager.setDriver(new FirefoxDriver());
				// Later On I will update this about to Actions and JavascriptExecutor etc...
		//	DriverManager.getDriver().get("https://www.google.co.in/"); // for passing the url of the local thread
		//	DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// this we will never Use in realTime 
				
			}
			else
			{
				System.out.println("Browser name is worngly Entered ");
			}
	DriverManager.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	DriverManager.getDriver().get(ReadProperty.getKeyValue("url")); // here I Need get the url from the Properties file for that 
	//Driver.getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	// Actually we will get the above time and from the constants or Properties file later on I willl update this 
	// How to perform the explicitly wait 
	
	//WebDriverWait exWait=new WebDriverWait(driver,10);// we have to pass driver and time duration of the explicitly wait 
	// the above one I will update later on the requirement
	//DriverManager.getDriver().get("https://www.google.co.in/"); // for passing the url of the local thread
		}// if-else 
		
	}
	
	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
		
			DriverManager.getDriver().quit();// for thread safty 
			DriverManager.unLoad();// it will definetly make it null no doubt about it 
		//driver=null; //By this some reasons explicitly I have to make it null
		}
	}
	public static void closeDriver()
	{
		// I will update this later on about this . Normally I'm getting the error when I'm running the snippet 
		DriverManager.getDriver().close(); // I will check only particular session Id only I will update this later on As per the content 
	//	unLoad();
		// for the above we can acheive the Thread safty 
	}
	
}
