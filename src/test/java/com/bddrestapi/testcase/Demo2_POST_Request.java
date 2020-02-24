package com.bddrestapi.testcase;

import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.restapi.utis.RestApiUtil;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo2_POST_Request {
   
	public static HashMap<String, String> map  = new HashMap<String, String>();
	@BeforeClass
	public void postData()
	{   
		System.out.println("Start ***** Demo2_POST_Request ****** ");
		
		map.put("FirstName", RestApiUtil.getFirstName());
		map.put("LastName", RestApiUtil.getLastName());
		map.put("UserName", RestApiUtil.getUserName());
		map.put("Password", RestApiUtil.getPassword());
		map.put("Email", RestApiUtil.getEmail());
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register	";
	}
	@Test
	public void createEmployee()
	{
		given()
		  .contentType("application/json")
		  .body(map)
		.when()
		  .post()
		.then()
		  .statusCode(201)
		  .assertThat().body("SuccessCode", equalTo("OPERATION_SUCCESS"))
		  .and()
		  .body("Message", equalTo("Operation completed successfully"));
	}
	@AfterClass
	public void tearDown()
	{
		System.out.println("End ***** Demo2_POST_Request ****** ");
	}
}
