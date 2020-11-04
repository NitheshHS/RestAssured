package com.GitApi.test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class GetAllRepo {
	@Test
	public void getAllRepoTest() {
		
		//https://api.github.com
		
		Response res = given()
			.pathParam("username", "NitheshHS")
			.auth()
				.basic("NitheshHS", "nithesh@1998")
		.when()
			.get("https://api.github.com/users/{username}/repos");
		
		ArrayList<String> list = res.jsonPath().get("name");
		for(String str:list) {
			System.out.println(str);
		}
		
		res.then()
			.assertThat().statusCode(200)
			.and()
			.assertThat().contentType(ContentType.JSON);
		System.out.println(res.getStatusCode());
		
	}

}
