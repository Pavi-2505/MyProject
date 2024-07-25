package com.crm.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testngptc {
	
	@Test(priority = -1,invocationCount = 1)
	public void m1()
	{
		Assert.fail();
		System.out.println("hi");
	}
	
	@Test(priority = 0,dependsOnMethods = "m1")
	public void m2()
	{
		System.out.println("bye");
	}
	
	@Test(priority = -2,invocationCount = 2)
	public void m3()
	{
		System.out.println("hello");
	}
}