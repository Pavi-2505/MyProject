package com.crm.Organisation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.crm.Vtiger.genericUtilities.ExcelUtility;
import com.crm.Vtiger.genericUtilities.FileUtility;

public class Dataprovider_CreateOrganization {
	
	@DataProvider(name = "organizationDetails")
	public Object[][] dataForCreateOrganization() throws EncryptedDocumentException, IOException
	{

		ExcelUtility eLib = new ExcelUtility();
		int theRowCount = eLib.getTheRowCount("Organisation");
		int theCellCount = 12;
		 Object[][] allData = new Object[theRowCount][theCellCount];
			for(int i=0;i<theRowCount;i++)
			{
				for(int j=0; j<theCellCount; j++)
				{
				allData[i][j]=eLib.readDatafRomExcel("Organisation", i+1, j);
					
				}
			}
		
		return allData;
		
	}

}
