package com.employeeapi.testCases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_All_Employees extends TestBase{
	
	@BeforeClass
	public void getAllEmployees() throws InterruptedException {
		
		
		logger.info("********** Started TC001_Get_All_Employees ***********");
		
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		 httpRequest = RestAssured.given();
		 response = httpRequest.request(Method.GET, "/employees");
		 
		 Thread.sleep(3000);
	}
		
		@Test
		public void checkResponseBody() {
		
		logger.info("********** Checking Response Code ***********");
			
		String responseBody = response.getBody().asString();
		logger.info("Response Body is: " + responseBody);
		Assert.assertTrue(responseBody!=null);
		}
		
		//status code validation
		@Test
		public void checkStatusCode() {
		logger.info("********** Checking Status Body ***********");
		
		int statusCode = response.getStatusCode();
		logger.info("status code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		}
		
		@Test
		public void checkResponseTime() {
		logger.info("********** Checking Response Time ***********");
		long responseTime = response.getTime();
		logger.info("Response Time is==> " + responseTime);

		if(responseTime>200)
			logger.warn("Response Time is greater than 100");
		
		Assert.assertTrue(responseTime<10000);
							
		}
		//status line verification
		@Test
		public void checkStatusLine() {
		logger.info("********** Checking Status line ***********");
		String statusLine = response.getStatusLine();
		logger.info("status lines is: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		}
		
		//status checkContentTyp
		@Test
		public void checkContentType() {
			logger.info("********** Checking Content Type ***********");
		String contentType = response.header("Content-Type");
		logger.info("Content Type is: " + contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
				
		}
	
		@Test
		public void checkServerType() {
		logger.info("********** Checking Server Type ***********");
		String serverType = response.header("Server");
		logger.info("Content Server is: " + serverType);
		Assert.assertEquals(serverType, "nginx/1.14.1");;;
				
		}

		@Test
		public void checkContentEncoding() {
		logger.info("********** Checking Content Encoding ***********");
		String contentEncoding = response.header("Content-Encoding");
		logger.info("Content Type is: " + contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
				
		}
		
	
		@Test
		public void checkContentLength() {
		logger.info("********** Checking Content Length ***********");
		String contentLength = response.header("Content-Length");
		logger.info("Content Lenght is==> " + contentLength);

		if(Integer.parseInt(contentLength)<100)
			logger.warn("Content Length is less than 100");
		
		Assert.assertTrue(Integer.parseInt(contentLength)>100);
					
				
		}
		
		@Test
		public void checkCookies() {
		logger.info("********** Checking Cookies ***********");
		String contentLength = response.header("PHPSESSID");			
				
		}
		
		@AfterClass
		public void tearDown() {
		logger.info("********** Checking Cookies ***********");
			
		}
}
