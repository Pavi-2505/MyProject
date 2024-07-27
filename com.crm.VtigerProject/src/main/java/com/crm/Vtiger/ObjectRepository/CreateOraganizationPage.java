package com.crm.Vtiger.ObjectRepository;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOraganizationPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@name='accountname']")
    private WebElement organizationNametxtFld;

    @FindBy(xpath = "//input[@name='website' and @class='detailedViewTextBox']")
    private WebElement website;

    @FindBy(css = "input#employees")
    private WebElement employess;

    @FindBy(id = "tickersymbol")
    private WebElement ticketsymbol;

    @FindBy(css = "input.detailedViewTextBox[name='email2']")
    private WebElement otherMail;

    @FindBy(css = "select[name^='in']")
    private WebElement industry;

    @FindAll(@FindBy(xpath = "//select[@name='industry']//option"))
    private List<WebElement> industryAllOptions;

    @FindBy(xpath = "//input[@type='text'][@id='phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@type='text' and @id='fax']")
    private WebElement fax;

    @FindBy(xpath = "//input[@name='otherphone' or @id='otherphone']")
    private WebElement otherPhone;

    @FindBy(xpath = "//b[text()='Copy Shipping address']")
    private WebElement copyShippingAddress;

    @FindBy(xpath = "(//input[contains(@title,'Save')])[1]")
    private WebElement save;

    @FindBy(xpath = "//span[@class='dvHeaderText']")
    private WebElement createdOrgName;
    
	@FindBy(xpath = "//input[@name='ship_state']")
	private WebElement shipState;

	@FindBy(xpath = "//input[@name='ship_city']")
	private WebElement shipCity;

	@FindBy(xpath = "(//input[contains(@value,'Cancel  ')])[1]")
	private WebElement cancel;
	
    public CreateOraganizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@type='text' and @name='email1']")
    private WebElement email;
    
    public WebElement getOrganizationName() {
        return organizationNametxtFld;
    }

    public WebElement getWebsite() {
        return website;
    }

    public WebElement getEmployess() {
        return employess;
    }

    public WebElement getTicketsymbol() {
        return ticketsymbol;
    }

    public WebElement getOtherMail() {
        return otherMail;
    }

    public WebElement getIndustry() {
        return industry;
    }

    public List<WebElement> getIndustryAllOption() {
        return industryAllOptions;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getFax() {
        return fax;
    }

    public WebElement getOtherPhone() {
        return otherPhone;
    }

    public WebElement getCopyShippingAddress() {
        return copyShippingAddress;
    }

    public WebElement getSave() {
        return save;
    }

    public WebElement getCreatedOrgName() {
        return createdOrgName;
    }

    public WebElement getShipCity() {
        return shipCity;
    }

    public WebElement getShipState() {
        return shipState;
    }
    public WebElement getEmail() {
        return email;
    }
    public WebElement getCancel() {
        return cancel;
    }
}
