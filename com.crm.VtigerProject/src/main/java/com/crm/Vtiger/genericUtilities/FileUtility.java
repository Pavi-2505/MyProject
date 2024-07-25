package com.crm.Vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	/**
	 * This method is used to read common data from property File
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.propertfilePath);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
