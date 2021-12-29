package com.crm.autodest.genericUtility;

import java.util.Date;
import java.util.Random;


/**
 * 
 * @author JWALA KUMAR
 *
 */

public class JavaUtility {
	/**
	 * it is used to generate random number
	 * @return int data
	 */
	
	public int getRanDomNumber() {
		Random random = new Random();
		int intRandom = random.nextInt(10000);
		return intRandom;
	}
	/**
	 * use to get system date in YYYY-MM-DD format
	 * @return
	 */
	public String getSystemDateWithFormate() {
		Date date = new Date();
		String dateAndTime = date.toString();
		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		
		String finalFormate = YYYY +"-"+MM+"DD";
		return finalFormate;
			
	}
	

}
