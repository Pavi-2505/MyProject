package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verifycontactpage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")private WebElement createdContact;
	
	
	public Verifycontactpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreatedContact() {
		return createdContact;
	}
	
	
}
