package com.crm.Organisation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.crm.Vtiger.ObjectRepository.CreateOraganizationPage;
import com.crm.Vtiger.ObjectRepository.HomePage;
import com.crm.Vtiger.ObjectRepository.LoginPage;
import com.crm.Vtiger.genericUtilities.Baseclass;
import com.crm.Vtiger.genericUtilities.FileUtility;
import com.crm.Vtiger.genericUtilities.JavaUtility;
import com.crm.Vtiger.genericUtilities.WebdriverUtility;

public class CreateOrganisationTest extends Baseclass {

//    FileUtility fLib = new FileUtility();
//    WebdriverUtility wLib = new WebdriverUtility();
//    JavaUtility jLib = new JavaUtility();
//    LoginPage login = new LoginPage(driver);
   public HomePage homePage = new HomePage(driver);
   public CreateOraganizationPage createOrganizationPage = new CreateOraganizationPage(driver);

    @Test(groups = {"smoke"}, dataProvider = "organizationDetails", dataProviderClass = Dataprovider_CreateOrganization.class)
    public void createOrganisationTest(String OrganizationName, String Website, String TicketSymbol, String employees,
            String otherEmail, String industry, String phone, String fax, String otherPhone, String email,
            String shippingCity, String shippingState) throws IOException, InterruptedException {

    	
    	System.out.println(OrganizationName);
    	System.out.println(Website);
    	System.out.println(industry);
    	
        int randomNo = jLib.getRandomNo();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to Organizations page
        wLib.click(homePage.getOrganizationsLink());
        wait.until(ExpectedConditions.visibilityOf(createOrganizationPage.getOrganizationName()));

        // Fill in the form fields
        wLib.sendData(createOrganizationPage.getOrganizationName(), OrganizationName+randomNo);
        wLib.sendData(createOrganizationPage.getWebsite(), Website);
        wLib.sendData(createOrganizationPage.getTicketsymbol(), TicketSymbol);
        wLib.sendData(createOrganizationPage.getEmployess(), employees);
        wLib.sendData(createOrganizationPage.getOtherMail(), otherEmail);

        // Select industry
        wLib.click(createOrganizationPage.getIndustry());
        for (WebElement industryOption : createOrganizationPage.getIndustryAllOption()) {
            if (industryOption.getText().contains(industry)) {
                wLib.click(industryOption);
                break;
            }
        }

        // Fill in remaining fields
        wLib.sendData(createOrganizationPage.getPhone(), phone);
        wLib.sendData(createOrganizationPage.getFax(), fax);
        wLib.sendData(createOrganizationPage.getOtherPhone(), otherPhone);
        wLib.sendData(createOrganizationPage.getEmail(), email);
        wLib.sendData(createOrganizationPage.getShipCity(), shippingCity);
        wLib.sendData(createOrganizationPage.getShipState(), shippingState);

        // Copy shipping address and save
        wLib.click(createOrganizationPage.getCopyShippingAddress());
        wLib.click(createOrganizationPage.getSave());
        
     

        // Verify the organization was created
        wait.until(ExpectedConditions.visibilityOf(createOrganizationPage.getCreatedOrgName()));
        if (createOrganizationPage.getCreatedOrgName().getText().contains(OrganizationName)) {
            System.out.println("Test case passed");
        } else {
            System.out.println("Test case failed");
        }
    }
    

    @Test(groups = {"smoke"}, dataProvider = "organizationDetails", dataProviderClass = Dataprovider_CreateOrganization.class)
    public void createOrganisationCancel(String OrganizationName, String Website, String TicketSymbol, String employees,
            String otherEmail, String industry, String phone, String fax, String otherPhone, String email,
            String shippingCity, String shippingState) throws IOException, InterruptedException {

        int randomNo = jLib.getRandomNo();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to Organizations page
        wLib.click(homePage.getOrganizationsLink());
        wait.until(ExpectedConditions.visibilityOf(createOrganizationPage.getOrganizationName()));

        // Fill in the form fields
        wLib.sendData(createOrganizationPage.getOrganizationName(), OrganizationName+randomNo);
        wLib.sendData(createOrganizationPage.getWebsite(), Website);
        wLib.sendData(createOrganizationPage.getTicketsymbol(), TicketSymbol);
        wLib.sendData(createOrganizationPage.getEmployess(), employees);
        wLib.sendData(createOrganizationPage.getOtherMail(), otherEmail);

        // Select industry
        wLib.click(createOrganizationPage.getIndustry());
        for (WebElement industryOption : createOrganizationPage.getIndustryAllOption()) {
            if (industryOption.getText().contains(industry)) {
                wLib.click(industryOption);
                break;
            }
        }

        // Fill in remaining fields
        wLib.sendData(createOrganizationPage.getPhone(), phone);
        wLib.sendData(createOrganizationPage.getFax(), fax);
        wLib.sendData(createOrganizationPage.getOtherPhone(), otherPhone);
        wLib.sendData(createOrganizationPage.getEmail(), email);
        wLib.sendData(createOrganizationPage.getShipCity(), shippingCity);
        wLib.sendData(createOrganizationPage.getShipState(), shippingState);

        // Copy shipping address and save
        wLib.click(createOrganizationPage.getCopyShippingAddress());
        wLib.click(createOrganizationPage.getCancel());
        boolean displayed = createOrganizationPage.getOrganizationName().isDisplayed();
        assertEquals(displayed, false);

        // Verify the organization was created
        wait.until(ExpectedConditions.visibilityOf(createOrganizationPage.getCreatedOrgName()));
        if (createOrganizationPage.getCreatedOrgName().getText().contains(OrganizationName)) {
            System.out.println("Test case passed");
        } else {
            System.out.println("Test case failed");
        }
    }
}
