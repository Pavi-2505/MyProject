package com.crm.Organisation;

import org.testng.annotations.Test;

import com.crm.Vtiger.genericUtilities.Baseclass;

public class Sample2Test extends Baseclass{

	@Test
	public void sample2Test()
	{
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void Demo2Test()
	{
		System.out.println("Hello");
	}
}
