package com.crm.Organisation;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Vtiger.ObjectRepository.LoginPage;
import com.crm.Vtiger.genericUtilities.Baseclass;
import com.crm.Vtiger.genericUtilities.FileUtility;
import com.crm.Vtiger.genericUtilities.JavaUtility;
import com.crm.Vtiger.genericUtilities.WebdriverUtility;



public class CreateOrganisationTest extends Baseclass{

	WebDriver driver;
	FileUtility fLib = new FileUtility();
	WebdriverUtility wLib = new WebdriverUtility();
	JavaUtility jLib = new JavaUtility();
	LoginPage login = new LoginPage(driver);
	

	@Test(groups= {"smoke"})
	public void createOrganisationTest() throws IOException, InterruptedException {
		
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
   
		
		int randomNo = jLib.getRandomNo();
		
		wLib.implicitWait(driver, 10);

		wLib.maximizeTheBrowser(driver);

		driver.get(URL);
		// driver.navigate().to("http://localhost:8888");
		
		login.loginToAppln(USERNAME, PASSWORD);

	
		driver.findElement(By.name("accountname")).sendKeys("Infosys" + randomNo);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String createdOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (createdOrgName.contains("Infosys")) {
			System.out.println("testcase is pass");
		} else {
			System.out.println("testcase is fail"); 
		}

		WebElement adminstrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		Actions action = new Actions(driver);
		action.moveToElement(adminstrator).perform();

		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		driver.quit();

	}

	@Test
	public void createOrganisationTestAndSave() throws IOException {
		//
		
		FileInputStream fin = new FileInputStream(
				"C:\\Users\\LENOVO\\eclipse-workspace\\com.crm.VtigerProject\\src\\test\\resources\\commondata.properties");
		Properties prop = new Properties();
		prop.load(fin);
		String URL = prop.getProperty("url");
		String BROWSER = prop.getProperty("browser");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);

		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[.='Organizations']")).click();

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

	
		// Xpath
		// Using the `Alt + Shift + L` shortcut, you can quickly extract an expression
		// into a local variable.
		WebElement organizationName = driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input"));
		// Ctrl + Alt + Down Arrow (or Ctrl + Alt + Up Arrow to duplicate the line above
		WebElement website = driver.findElement(By.className("detailedViewTextBox"));
		WebElement employess = driver.findElement(By.cssSelector("input#employees"));
		WebElement ticketsymbol = driver.findElement(By.id("tickersymbol"));
		WebElement otherMail = driver.findElement(By.cssSelector("input.detailedViewTextBox[name='email2']"));
		WebElement industry = driver.findElement(By.cssSelector("select[name^='in']"));
		WebElement endWith = driver.findElement(By.cssSelector("select[name$='type']"));
		WebElement emailOptOut = driver.findElement(By.cssSelector("select[name$='type']"));
		WebElement phone = driver.findElement(By.xpath("//input[@type='text'][@id='phone']"));
		WebElement fax = driver.findElement(By.xpath("//input[@type='text' and @id='fax']"));
		WebElement otherPhone = driver.findElement(By.xpath("//input[@name='otherphone' or @id='otherphone']"));
		WebElement ownership = driver.findElement(By.xpath("//input[contains(@name,'ownership')]"));
		WebElement siscode = driver.findElement(By.xpath("//input[contains(@name,'siccode') and contains(@id,'siccode')]"));
		WebElement copyShippingAddress= driver.findElement(By.xpath("//b[text()='Copy Shipping address']"));
		WebElement addressInformation= driver.findElement(By.xpath("//b[text()='Address Information']"));
		WebElement save= driver.findElement(By.xpath("(//input[contains(@title,'Save')])[1]"));
		WebElement chat= driver.findElement(By.xpath("//img[contains(@title,'Chat')]"));
		WebElement more= driver.findElement(By.xpath("//a[.='More']"));
		WebElement invoice= driver.findElement(By.xpath("//a[@id='more' and @name='Invoice']"));
		WebElement shipState= driver.findElement(By.xpath("//input[@name='ship_state']"));
		
		//-- Radio Button --		
		WebElement userRadioButton = driver.findElement(By.xpath("//input[@type='text' and @id='fax']"));
		//Position of Button
		Point location = userRadioButton.getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("User button location is :" + x + ':' + y);
		
		//Color of the button
		String colorOfSaveButton = save.getCssValue("background-color");
		System.out.println("Color of the save button is:" + colorOfSaveButton);
		
		//Size of the Button
		
		Dimension sizeOfSaveButton = save.getSize();
		int height = sizeOfSaveButton.getHeight();
		int width = sizeOfSaveButton.getWidth();
		System.out.println("Sixe of the save button is :" + height + ':' + width);
		
		//-- DropDown--
		
		Select select = new Select(industry);
		select.selectByIndex(1);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		System.out.println("Selected option is :" + firstSelectedOption);
		List<WebElement> allIndustryOptions = select.getOptions();
		for (WebElement industryOption : allIndustryOptions) {
			System.out.println("Industry options are:" + industryOption.getText());
			
			if(industryOption.getText().equals("Education"))
			{
				industryOption.click();
			}
			
		}
		
		//--CheckBox--
		
		if (emailOptOut.isSelected()) {
			
			emailOptOut.click();
			
		}
		
		
		//-- Actions
		
		Actions ac = new Actions(driver);
		
		  ac.moveToElement(more).build().perform();
		  
		  boolean moredisplayed = invoice.isDisplayed();
		  Assert.assertTrue(moredisplayed);
		 
		
		//ac.click(organizationName).build().perform();
		ac.sendKeys(organizationName, "TCS").build().perform();
		
		
		//-- JavaScript
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		//This is **narrowing** (or **downcasting**) because you are converting a general type (`WebDriver`) to a more specific type (`JavascriptExecutor`). This allows you to use specialized methods of the `JavascriptExecutor` that are not available in the general `WebDriver` interface.
		//The line `JavascriptExecutor js = (JavascriptExecutor) driver;` means you are converting the `driver` object to a `JavascriptExecutor` so you can run JavaScript commands in the browser through Selenium.
		//Yes, `JavascriptExecutor` is an interface in Selenium WebDriver. By casting the `WebDriver` instance to `JavascriptExecutor`, you can use methods defined in the `JavascriptExecutor` interface to execute JavaScript code within the browser.
		
		 // Example: Scroll up by 500 pixels
        js.executeScript("window.scrollBy(0, -500);");

        // Example: Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Example: Scroll to the top of the page
        js.executeScript("window.scrollTo(0, 0);");

        // Example: Scroll an element into view
       
        js.executeScript("arguments[0].scrollIntoView();", shipState);

        // Example: Click an element using JavaScript
        js.executeScript("arguments[0].click();", shipState);

        // Example: Send keys to an input field using JavaScript
       
        js.executeScript("arguments[0].value = 'Berlin';", shipState);
        
        js.executeScript("document.getElementsByName('ship_city')[0].value = 'Berlin';");
        
      //-- Windows Handling
		
      		String currentWindow = driver.getWindowHandle();
      		chat.click();
      		String title = driver.getTitle();
      		System.out.println(title);
      		Set<String> windowHandles = driver.getWindowHandles();
      		List<String> allwindows = new ArrayList<>(windowHandles);
      		driver.switchTo().window(allwindows.get(0));
      		
      	// -- Screenshot
      		
      		TakesScreenshot ts = (TakesScreenshot) driver;
      		File source = ts.getScreenshotAs(OutputType.FILE);  
      		File des = new File("C:\\Users\\LENOVO\\eclipse-workspace\\com.crm.VtigerProject\\ScreenShot\\save.png");
      		FileHandler.copy(source, des);


	}

	@Test
	public void google() {
		/*
		 * driver = new ChromeDriver();
		 * driver.get("https://mail.google.com/mail/u/0/#inbox");;
		 * driver.manage().window().maximize(); //d[contains(@data-tooltip,'Sent')]
		 * WebElement sent = driver.findElement(By.id(":lp")); sent.click();
		 * 
		 * WebElement searchMail =
		 * driver.findElement(By.xpath("//input[@placeholder='Search mail']"));
		 * searchMail.sendKeys("Testing");
		 */

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		WebElement accept = driver.findElement(By.xpath("//div[text()='Alle akzeptieren']"));
		accept.click();
		WebElement search = driver.findElement(By.xpath("//textarea[@title='Search']"));
		search.sendKeys("Tajmahal");

	}
}