package com.tmb.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;
import com.tmb.util.ReadProperty2;

public class TestTwo {
	
	@BeforeMethod
//	@Parameters({"browser"})
	public void beforeMethod()// value comes form the properties file not From XML file
	{
		System.out.println(" \t\t --- @BeforeMethod ---- ");
		
		String browser=null;
		try {
			browser = ReadProperty2.getKeyVal("browser");System.out.println("I am going to launch the :: "+browser+" ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(browser==null)
		{
			//browser="chrome";
		}
		
		Driver.initDriver(browser);
	}
	
	@Test
	public void test201()
	{

		System.out.println(" \t\t --- @Test ---- ");
		System.out.println("title of the document is :: "+DriverManager.getDriver().getTitle());

	}
	@Test
	public void test202()
	{

		System.out.println(" \t\t --- @Test ---- ");
		System.out.println("title of the document is :: "+DriverManager.getDriver().getTitle());

	}
	//@Test
	public void test203()
	{

		System.out.println(" \t\t --- @Test ---- ");
	//	DriverManager.getDriver().get("https://google.co.in");
		System.out.println("title of the document is :: "+DriverManager.getDriver().getTitle());

	}
	//@Test
	public void test204()
	{

		System.out.println(" \t\t --- @Test ---- ");
		System.out.println("title of the document is :: "+DriverManager.getDriver().getTitle());

	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println(" \t\t --- @AfterMethod ---- ");

		//Driver.closeDriver();
		Driver.quitDriver();
	}

}
