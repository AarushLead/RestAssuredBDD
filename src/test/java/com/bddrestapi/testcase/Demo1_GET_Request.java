package com.bddrestapi.testcase;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Demo1_GET_Request {
    
	@Test
	public void getWeatherDetail()
	{
		given()
		.when()
		  .get("http://restapi.demoqa.com/utilities/weather/city/hyderabad")
		.then()
		  .statusCode(200)                                     //Validate Status Code
		  .statusLine("HTTP/1.1 200 OK")                       //Validate Status Line
		  .assertThat().body("City", equalTo("Hyderabad"))     //Validate response body
		  .header("Content-Type","application/json");          //Validate Header
		
	}
}
