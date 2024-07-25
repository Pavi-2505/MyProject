package com.crm.Vtiger.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * tHis method is used to get random number
	 * @return
	 */
	public int getRandomNo()
	{
		Random random = new Random();
		return random.nextInt(1000);
	}
	
	/**
	 * This method is used to fetch date in YYYY-MM-DD formate
	 * @return
	 */
	public String getSystemDate()
	{
		Date dateObj = new Date();//14-07-2024
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
	}
}
