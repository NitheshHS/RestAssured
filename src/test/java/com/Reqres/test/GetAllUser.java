package com.Reqres.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllUser {
	
	@Test
	public void getAlluserTest() {
	
		
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri("https://reqres.in");
		builder.setContentType(ContentType.JSON);
		RequestSpecification specification = builder.build();
		
		
		Response res = given()
			.spec(specification)
		.when()
			.get("/api/users?page=2");
		System.out.println(res.jsonPath().get("data[1].first_name"));
		
		
		res.then().time(lessThan(10l), TimeUnit.SECONDS)
			.assertThat().body("data[1].first_name", equalTo("Lindsay"))
			.and()
			.assertThat().header("Content-Type", equalTo("application/json; charset=utf-8"))
			.and()
			.log().all();
	
	}

}
