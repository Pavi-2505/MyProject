package com.crm.contacts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Vtiger.ObjectRepository.CreateContactImgPage;
import com.crm.Vtiger.ObjectRepository.CreateContactPage;
import com.crm.Vtiger.ObjectRepository.HomePage;
import com.crm.Vtiger.ObjectRepository.Verifycontactpage;
import com.crm.Vtiger.genericUtilities.Baseclass;

//@Listeners(com.crm.Vtiger.genericUtilities.ListnerImplementation.class)
public class CreatContactTest extends Baseclass{
	

	@Test(groups = {"smokeTest","regTest"},retryAnalyzer = com.crm.Vtiger.genericUtilities.RetryImplementation.class)
	public void creatContactTest() throws IOException
	{
		int randNum = jLib.getRandomNo();
		
		String Firstname = eLib.readDatafRomExcel("contacts", 1, 0);
		
		String LastName = eLib.readDatafRomExcel("contacts", 1, 1)+randNum;
		
		HomePage homepage = new HomePage(driver);
		wLib.click(homepage.getContactsLink());
		
	//	Assert.fail();
		
		CreateContactImgPage createContactImgPage = new CreateContactImgPage(driver);
		createContactImgPage.getCreateContactimg().click();
		
		CreateContactPage createContactPage = new CreateContactPage(driver);
		createContactPage.createCtnt(Firstname, LastName);
		
		Verifycontactpage verifycontactpage = new Verifycontactpage(driver);
		String createdCntName=verifycontactpage.getCreatedContact().getText();
		
		Assert.assertTrue(createdCntName.contains(LastName), LastName+"Lastname is not created");
	}
	
	@Test
	public void m2test()
	{
		System.out.println("hello");
	}
}
