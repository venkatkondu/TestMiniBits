package com.tmb.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.tmb.driver.Driver;

public class BaseTest {
	
	
	protected BaseTest() // By this we can not create Objects explicitly But we will provide valus to it's sub classes 
	{
		// later on I will update as per the requirement 
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println(" \t\t --- @BeforeSuite ---- ");

	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println(" \t\t --- @AfterSuite ---- ");
		//Driver.quitDriver();// to close the entaire sessions
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println(" \t\t --- @BeforeTest ---- ");

	
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println(" \t\t --- @AfterTest ---- ");

	}
	@BeforeClass
	public void beforeClass()
	{	
		System.out.println(" \t\t --- @BeforeClass ---- ");

		
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println(" \t\t --- @AfterClass ---- ");

	}
}
