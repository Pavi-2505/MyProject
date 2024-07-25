package com.crm.Organisation;

import org.testng.annotations.Test;

import com.crm.Vtiger.genericUtilities.Baseclass;

public class Sample1Test extends Baseclass{

	@Test
	public void sample1Test()
	{
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void demo1Test()
	{
		System.out.println("hi");
	}
}
