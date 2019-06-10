package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	//In this class we create three methods to generate random names, salaries and ages
	
	public static String empName() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		
		return ("Steve" + generatedString);
		}
		public static String empSal() {
		
		String generatedString = RandomStringUtils.randomNumeric(5);
		
		return (generatedString);
		}
		public static String empAge() {
			
		String generatedString = RandomStringUtils.randomNumeric(2);
			
		return (generatedString);
		}
	

}
