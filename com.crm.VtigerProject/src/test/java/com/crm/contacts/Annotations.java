package com.crm.contacts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("beforeSuite");
	}
	
	@BeforeTest
	public void beforetest()
	{
		System.out.println("beforetest");
	}
	
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("beforeclass");
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("beforemethod");
	}
	
	@Test
	public void myTest()
	{
		System.out.println("Hello");
	}
	
	@Test
	public void myTest1()
	{
		System.out.println("hi");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("afterSuite");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("aftermethos");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("aftertest");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("afterclass");
	}
}
