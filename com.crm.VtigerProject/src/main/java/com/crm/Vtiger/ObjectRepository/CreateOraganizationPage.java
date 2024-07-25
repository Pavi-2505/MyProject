package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.genericUtilities.ExcelUtility;
import com.crm.Vtiger.genericUtilities.FileUtility;
import com.crm.Vtiger.genericUtilities.JavaUtility;
import com.crm.Vtiger.genericUtilities.WebdriverUtility;

public class CreateOraganizationPage {

	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebdriverUtility wLib = new WebdriverUtility();
	WebDriver driver;
	
	HomePage homePage = new HomePage(driver);

	@FindBy(xpath = "//*[@name='accountname']")
	private WebElement organizationNametxtFld;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public CreateOraganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationName() {
		return organizationNametxtFld;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void createOrganization(String organizationName)

	{
		//wLib.click(homePage.getOrganizationsLink());
		wLib.sendData(organizationNametxtFld, organizationName);
		wLib.click(saveButton);
	}
}
