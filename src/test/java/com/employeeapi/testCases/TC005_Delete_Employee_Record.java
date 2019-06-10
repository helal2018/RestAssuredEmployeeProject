package com.employeeapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_Delete_Employee_Record extends TestBase{
	
	
	@BeforeClass
	public void updateEmployee() throws InterruptedException {
		
		
		logger.info("********** TC002_GET_Single_Employee_Record ***********");
		
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		 httpRequest = RestAssured.given();
		 
		 response = httpRequest.request(Method.GET, "/employees");
		 
		 //First get the JsonPath object instance from the Response interface
		 JsonPath jsonPathEvaluator = response.jsonPath();
		 
		 //Capture id from the response before deleting the data
		 String empID = jsonPathEvaluator.get("[0].id");
		 response = httpRequest.request(Method.DELETE, "/delete/"+empID);
		 
		 Thread.sleep(3000);	 
	}
	
	@Test
	public void checkResponseBody() {
		
	String responseBody = response.getBody().asString();
	Assert.assertEquals(responseBody.contains("successfully! deleted Records"), true);
	
	}
	
	//status code validation
	@Test
	public void checkStatusCode() {
	
	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
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
	Assert.assertEquals(contentType, "text/html; charset=UTF-8");
			
	}

	@Test
	public void checkServerType() {
	String serverType = response.header("Server");
	Assert.assertEquals(serverType, "nginx/1.14.1");
			
	}
	
				
	@Test
	public void checkContentEncoding() {
	String contentEncoding = response.header("Content-Encoding");
	
	Assert.assertEquals(contentEncoding, "gzip");
				
			
	}
	
	
	@AfterClass
	public void tearDown() {
	logger.info("********** Checking Cookies ***********");
		
	}

}
