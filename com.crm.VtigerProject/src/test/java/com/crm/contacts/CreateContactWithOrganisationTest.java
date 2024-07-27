package com.crm.contacts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Vtiger.ObjectRepository.CreateContactImgPage;
import com.crm.Vtiger.ObjectRepository.CreateContactPage;
import com.crm.Vtiger.ObjectRepository.CreateOraganizationPage;
import com.crm.Vtiger.ObjectRepository.CreateOrgImgPage;
import com.crm.Vtiger.ObjectRepository.HomePage;
import com.crm.Vtiger.ObjectRepository.LoginPage;
import com.crm.Vtiger.ObjectRepository.VerifyOrganizationPage;
import com.crm.Vtiger.ObjectRepository.Verifycontactpage;
import com.crm.Vtiger.genericUtilities.Baseclass;
import com.crm.Vtiger.genericUtilities.ExcelUtility;
import com.crm.Vtiger.genericUtilities.FileUtility;
import com.crm.Vtiger.genericUtilities.JavaUtility;
import com.crm.Vtiger.genericUtilities.WebdriverUtility;

//@Listeners(com.crm.Vtiger.genericUtilities.ListnerImplementation.class)
public class CreateContactWithOrganisationTest extends Baseclass{

	@Test(groups = {"smokeTest","regTest"})
	public void createContactWithOrganisationTest() throws IOException
	{
		int randNum = jLib.getRandomNo();
		
		String Firstname = eLib.readDatafRomExcel("contacts", 1, 0);
		
		String LastName = eLib.readDatafRomExcel("contacts", 1, 1);
		
		String orgName = eLib.readDatafRomExcel("Organisation", 1, 0)+randNum;
		
		HomePage homepage = new HomePage(driver);
		CreateOrgImgPage createOrgImgPage = new CreateOrgImgPage(driver);
		
		
		CreateOraganizationPage createOraganizationPage = new CreateOraganizationPage(driver);
		VerifyOrganizationPage VerifyOrganizationPage = new VerifyOrganizationPage(driver);
		CreateContactImgPage createContactImgPage = new CreateContactImgPage(driver);
		CreateContactPage createContactPage = new CreateContactPage(driver);

		wLib.click(homepage.getOrganizationsLink());
		createOrgImgPage.getCreateOrgLkpImg().click();
		
		String createdOrgName = VerifyOrganizationPage.getVerifyOrglink().getText();

		if (createdOrgName.contains(orgName)) {
			System.out.println("organisation is created");
		} else {
			System.out.println("organisation is not created");
		}

		//creating contact with organization
		wLib.click(homepage.getContactsLink());		

		wLib.click(createContactImgPage.getCreateContactimg());		
		createContactPage.createCtctWithOrg(Firstname, LastName, orgName);
		
		Verifycontactpage verifycontactpage = new Verifycontactpage(driver);
		String createdCntName=verifycontactpage.getCreatedContact().getText();
		
		Assert.assertTrue(createdCntName.contains(LastName), LastName+"Lastname is not created");
	}
}