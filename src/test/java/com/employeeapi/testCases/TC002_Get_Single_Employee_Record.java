package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Employee_Record extends TestBase {
	
	@BeforeClass
	public void getEmployee() throws InterruptedException {
		
		
		logger.info("********** TC002_GET_Single_Employee_Record ***********");
		
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		 httpRequest = RestAssured.given();
		 response = httpRequest.request(Method.GET, "/employees" +empID);
		 
		 Thread.sleep(3000);
	}
		
		@Test
		public void checkResponseBody() {
			
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empID), true);
		}
		
		//status code validation
		@Test
		public void checkStatusCode() {
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		}
		
		@Test
		public void checkResponseTime() {
		long responseTime = response.getTime();

		Assert.assertTrue(responseTime>100);
		}
		//status line verification
		@Test
		public void checkStatusLine() {
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		}
		
		//status checkContentTyp
		@Test
		public void checkContentType() {
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "text/html;charset=UTF-8");
				
		}
	
		@Test
		public void checkServerType() {
		String serverType = response.header("Server");
		Assert.assertEquals(serverType, "nginx/1.14.1");
				
		}
		
					
		@Test
		public void checkContentLength() {
		String contentLength = response.header("Content-Length");
		
		Assert.assertTrue(Integer.parseInt(contentLength)>1500);
					
				
		}
		
		
		@AfterClass
		public void tearDown() {
		logger.info("********** Checking Cookies ***********");
			
		}

}
