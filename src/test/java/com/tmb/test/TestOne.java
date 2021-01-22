package com.tmb.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;
import com.tmb.util.ReadProperty2;

public final class TestOne extends BaseTest{
//By the final Key word I am not allowed to extends to another class  of this class 
	
	private TestOne() // By this I am not allowed to create Objects on this class  explicitly 
	{
		
	}
	
	//@BeforeMethod
	@BeforeMethod
	//@Parameters({"browser"})// this is for the I am getting the value from the xml file
	public void beforeMethod() // I am get the browser Property from the properties file not in XML file
	{
		System.out.println(" \t\t --- @BeforeMethod  ---- ");
		// I have to initialize the browser FOr that 
		//DriverManager.getDriver().get("https://www.google.co.in/"); // for passing the url of the local thread

		String browserProperty=null;
		try {
			browserProperty=ReadProperty2.getKeyVal("browser");
			System.out.println(" I am goint to launch the :: "+browserProperty+" ::: -------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // get the value from the property file 
		
		if(browserProperty==null)
		{
			//browserProperty="chrome"; //later I will implement 
		}
		
		Driver.initDriver(browserProperty);
	
	}
	
	@Test
	public void test001()
	{
		System.out.println(" \t\t  ----- @Test  ------");
		//DriverManager.getDriver().get("https://www.google.co.in/"); // for passing the url of the local thread

		System.out.println("Titile of the page is :: "+DriverManager.getDriver().getTitle());
	}
	@Test
	public void test002()
	{
		System.out.println(" \t\t  ----- @Test  ------");
		//DriverManager.getDriver().get("https://www.google.co.in/"); // for passing the url of the local thread

		System.out.println("Titile of the page is :: "+DriverManager.getDriver().getTitle());
	}
	@Test
	public void test003()
	{
		System.out.println(" \t\t  ----- @Test  ------");
		///DriverManager.getDriver().get("https://www.google.co.in/"); // for passing the url of the local thread

		System.out.println("Titile of the page is :: "+DriverManager.getDriver().getTitle());
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println(" \t\t ---@AfterMethod  ---- ");
		Driver.quitDriver();
		//Driver.closeDriver();
	}
	
	
	
	
	/*	The priority of the @Test(priority =-ve -->default --> +ve --> captial_Alphabetical Order --> small_Alpabetical Order)
	 * 
	 * 
	 * 
	 * */
	
}
