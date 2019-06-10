package com.employeeapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_Post_Employee_Record extends TestBase{
	
	String empName=RestUtils.empName();
	String empSalary=RestUtils.empSal();
	String empAge=RestUtils.empAge();
	
	@BeforeClass
	public void getEmployee() throws InterruptedException {
		
		
		logger.info("********** TC002_GET_Single_Employee_Record ***********");
		
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		 httpRequest = RestAssured.given();
		 
		 //JSONObject is a class that represents a simple JSON. We can add key-Value pairs using the put method
		 JSONObject rquestParams = new JSONObject();
		 rquestParams.put("name", empName);
		 rquestParams.put("salary", empSalary);
		 rquestParams.put("age", empAge);
		 
		 //Add a header stating the Reuest bod is a JSON
		 httpRequest.header("Content-Type", "application/json");
		 
		 //Add the Json to the body of the request
		 httpRequest.body(rquestParams.toJSONString());
		 
		 response = httpRequest.request(Method.POST, "/create");
		 
		 Thread.sleep(3000);	 
	}
	
	@Test
	public void checkResponseBody() {
		
	String responseBody = response.getBody().asString();
	Assert.assertEquals(responseBody.contains(empName), true);
	Assert.assertEquals(responseBody.contains(empSalary), true);
	Assert.assertEquals(responseBody.contains(empAge), true);
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
