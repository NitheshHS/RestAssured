package com.Reqres.test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

public class GetAllUser {
	
	@Test
	public void getAlluserTest() {
		
		Response res = when()
			.get("https://reqres.in/api/users?page=2");
		System.out.println(res.jsonPath().get("data[1].first_name"));
		
		
		res.then().time(lessThan(5l), TimeUnit.SECONDS)
			.assertThat().body("data[1].first_name", equalTo("Lindsay"))
			.and()
			.assertThat().header("Content-Type", equalTo("application/json; charset=utf-8"))
			.and()
			.log().all();
	
	}

}
