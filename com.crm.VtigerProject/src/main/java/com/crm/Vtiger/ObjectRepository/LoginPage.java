package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	@FindBy(name = "user_name")private WebElement usernameEdtTxt;
	
	@FindBy(name = "user_password")private WebElement passwordEdtTxt;
	
	@FindBy(id = "submitButton")private WebElement submitBtnclick;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getUsernameEdtTxt() {
		return usernameEdtTxt;
	}

	public WebElement getPasswordEdtTxt() {	
		return passwordEdtTxt;
	}

	public WebElement getSubmitBtnclick() {
		return submitBtnclick;
	}
	
	
	//Business logic
	public void loginToAppln(String username,String password)
	{
		usernameEdtTxt.sendKeys(username);
		passwordEdtTxt.sendKeys(password);
		submitBtnclick.click();
	}
}
