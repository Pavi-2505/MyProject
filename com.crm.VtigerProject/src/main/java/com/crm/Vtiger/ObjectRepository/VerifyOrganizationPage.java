package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyOrganizationPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")private WebElement verifyOrglink;
	
	public VerifyOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getVerifyOrglink() {
		return verifyOrglink;
	}
	
	
}
