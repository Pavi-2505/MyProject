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

public class CreateContactPage {

	WebDriver driver;
//	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
//	
//	wLib.switchingWindow(driver, "Accounts&action");
//	
//	driver.findElement(By.name("search_text")).sendKeys(orgName);
//	
//	driver.findElement(By.name("search")).click();
//	
//	driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
//	
//	wLib.switchingWindow(driver, "Contacts&action");

	@FindBy(name = "firstname")
	private WebElement FirstNameTxtFld;

	@FindBy(name = "lastname")
	private WebElement lastNameTxtFld;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement orgLkpImg;

	@FindBy(name = "search_text")
	private WebElement searchOrgTxtFld;

	@FindBy(name = "search")
	private WebElement searchbtn;

	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	WebdriverUtility wLib = new WebdriverUtility();
	
	public void createCtnt(String firstName, String lastName) {
		wLib.sendData(FirstNameTxtFld, firstName);
		wLib.sendData(lastNameTxtFld, lastName);
		wLib.click(saveBtn);
	}

	public void createCtctWithOrg(String firstName, String lastName, String orgname) {

		wLib.sendData(FirstNameTxtFld, firstName);
		wLib.sendData(lastNameTxtFld, lastName);
		wLib.click(orgLkpImg);
		wLib.switchingWindow(driver, "Accounts&action");
		wLib.sendData(searchOrgTxtFld, orgname);
		wLib.click(searchbtn);
		driver.findElement(By.xpath("//a[.='" + orgname + "']")).click();
		wLib.switchingWindow(driver, "Contacts&action");
		saveBtn.click();
	}
}
