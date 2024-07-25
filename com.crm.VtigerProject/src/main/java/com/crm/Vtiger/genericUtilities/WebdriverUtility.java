package com.crm.Vtiger.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author LENOVO
 * 
 */

public class WebdriverUtility {

	/**
	 * This utility is for maximize the screen
	 * 
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This utility is for launch Url
	 * 
	 * @param driver
	 * @param url
	 */
	public void launchUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	/**
	 * This utility is for click the element
	 * @param element
	 */
	public void click(WebElement element) {
		element.click();
	}

	/**
	 * This utility is for click the element
	 * @param element
	 */
	public void click(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * This utility is for send the keys to element
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void sendKeys(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + value + "';", element);
	}
	
	/**
	 * This utility is for send the keys to element
	 * @param driver
	 * @param id
	 * @param value
	 */
	public void sendKeys(WebDriver driver, String id, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementByid('"+ id +"').value='" + value + "';");
	}
	
	/**
	 * This utility is for send the keys to element
	 * @param element
	 * @param value
	 */
	public void sendData(WebElement element, String value) {
		element.sendKeys(value);
	}

	/**
	 * This method will wait till all elements the page gets load
	 * 
	 * @param driver
	 */
	public void implicitWait(WebDriver driver, int waitTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
	}

	/**
	 * this method wait till the particular element in the page to visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitTillElementTovisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will wait till the particular element in the page to click
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitTillElementClick(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is java wait method
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 20) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * This method is used to select the dropdown by using index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method is used to select the dropdown by using value
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method is used to select the dropdown by using visible text
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropDown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/*
	 * &* This method is used to right click On Element
	 */
	public void rightclickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/*
	 * &* This method is used to mouseover On Element
	 */
	public void mouseOverONElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/*
	 * &* This method is used to scrollThePage till the Element
	 */
	public void scrollTillElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element).perform();
	}

	/**
	 * THis method is used to switch to frame based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchingFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * THis method is used to switch to frame based on id/name
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchingFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	/**
	 * THis method is used to switch to frame based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchingFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * THis method is used to switch control from child frame to parenmt frame
	 */
	public void swtchingToParentframe(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * THis method is used to switch control back to main window
	 */
	public void swtchingBactTomainWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * THis method is used to switch window based on URL
	 * 
	 * @param driver
	 * @param PartialURL
	 */
	public void switchingWindow(WebDriver driver, String PartialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String url = driver.getCurrentUrl();
			if (url.contains(PartialURL)) {
				break;
			}
		}
	}

	/**
	 * THis method is used to switch window based on title
	 * 
	 * @param Partialtitle
	 * @param driver
	 */
	public void switchingWindow(String Partialtitle, WebDriver driver) {
		Set<String> set = driver.getWindowHandles();
		for (String wid : set) {
			driver.switchTo().window(wid);
			String url = driver.getCurrentUrl();
			if (url.contains(Partialtitle)) {
				break;
			}
		}
	}

	/**
	 * This method is used to get the screenShot of a WebPage
	 * 
	 * @param driver
	 * @param screenShotName
	 */
	public static String getTheScreenShotOfThePage(WebDriver driver, String screenShotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenShots/" + screenShotName +".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenShotName;
	}
}
