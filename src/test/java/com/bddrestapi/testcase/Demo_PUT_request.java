package com.bddrestapi.testcase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restapi.utis.RestApiUtil;

import io.restassured.RestAssured;

public class Demo_PUT_request {
    
	public static HashMap<String, String> map  = new HashMap<String, String>();
	int empID=1;
	
	@BeforeClass
	public void putData()
	{   
		System.out.println("Start ***** Demo3_PUT_Request ****** ");
		
		map.put("name", RestApiUtil.getFirstName());
		map.put("salary", RestApiUtil.empSalary());
		map.put("age", RestApiUtil.empAge());
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="update/"+empID;
	}
	@Test
	public void updateEmployee()
	{
		given()
		  .contentType("application/json")
		  .body(map)
		.when()
		  .put()
		.then()
		  .statusCode(200)
		  .assertThat().body("status", equalTo("success"))
		  .and()
		  .log().all();  //To print the log
	}
	@AfterClass
	public void tearDown()
	{
		System.out.println("End ***** Demo3_PUT_Request ****** ");
	}
}
