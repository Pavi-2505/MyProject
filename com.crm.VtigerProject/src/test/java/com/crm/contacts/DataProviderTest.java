package com.crm.contacts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.Vtiger.genericUtilities.ExcelUtility;
import com.crm.Vtiger.genericUtilities.WebdriverUtility;

public class DataProviderTest {
	
	@Test(dataProvider = "getData")
	public void logintoApp(String USERNAME,String PASSWORD)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);

		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();
	}
	
	@DataProvider()
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
//		Object[][] obj = new Object[3][2];
//		
//		obj[0][0]="admin";
//		obj[0][1]="manager";
//		
//		obj[1][0]="manager";
//		obj[1][1]="admin";
//		
//		obj[2][0]="admin";
//		obj[2][1]="admin";
//		return obj;
		
		ExcelUtility Elib = new ExcelUtility();
		int count = Elib.getTheRowCount("dataprovider");
		
		Object[][] obj = new Object[count][2];
		
		for(int i=0;i<count;i++)
		{
			obj[i][0]=Elib.readDatafRomExcel("dataprovider", i+1, 0);
			obj[i][1]=Elib.readDatafRomExcel("dataprovider", i+1, 1);
		}
		return obj;
	}
}
