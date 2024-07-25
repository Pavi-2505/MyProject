package com.crm.Vtiger.genericUtilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.Vtiger.ObjectRepository.HomePage;
import com.crm.Vtiger.ObjectRepository.LoginPage;

public class Baseclass {

	public static WebDriver sdriver;
	public WebDriver driver;
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebdriverUtility wLib = new WebdriverUtility();

	/**
	 * Here we are connecting to DataBase
	 */
	@BeforeSuite(alwaysRun = true)
	public void connectDB() {
		System.out.println("Database connection successful");
	}

	/**
	 * This method is going to open the browser
	 * @throws IOException
	 */
//	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(/*String BROWSER*/) throws IOException {
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		
		String URL = fLib.readDataFromPropertyFile("url");
		//String BROWSER = System.getProperty("browser");
		//String URL = System.getProperty("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		sdriver=driver;
		wLib.maximizeTheBrowser(driver);
		wLib.launchUrl(driver, URL);
		wLib.implicitWait(driver, 10);
	}

	/**
	 * This method is used to Login to Application
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@BeforeMethod(alwaysRun = true)
	public void logintoApp() throws EncryptedDocumentException, IOException {
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToAppln(USERNAME, PASSWORD);
	}

	/**
	 * This method is used to Logout from application
	 */
	@AfterMethod(alwaysRun = true)
	public void logoutFromApp() {
		HomePage homepage = new HomePage(driver);
		homepage.logOut(wLib, driver);
	}

	/**
	 * THis method is used to Close The browser
	 */
	@AfterClass(alwaysRun = true)
	public void closebrowser() {
		driver.quit();
	}

	/**
	 * THis method is used to close DB connection
	 */
	@AfterSuite(alwaysRun = true)
	public void closeDB() {
		System.out.println("Database closed");
	}
}
