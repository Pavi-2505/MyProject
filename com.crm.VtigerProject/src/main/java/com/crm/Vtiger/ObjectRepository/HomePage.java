package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.genericUtilities.WebdriverUtility;

public class HomePage {

	@FindBy(xpath="(//a[.='Organizations'])[1]")
	private WebElement organizationsLink;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement ContactsLink;
	
	@FindBy(xpath="//img[contains(@src, 'themes/softed/images/user.PNG')]")
	private WebElement administratorImg;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signOut;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	
	
	public void logOut(WebdriverUtility wLib,WebDriver driver)
	{
		wLib.mouseOverONElement(driver, administratorImg);
		signOut.click();
	}

	
}
