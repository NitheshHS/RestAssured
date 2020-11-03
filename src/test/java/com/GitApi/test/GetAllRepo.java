package com.GitApi.test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAllRepo {
	@Test
	public void getAllRepoTest() {
		
		//https://api.github.com
		
		Response res = given()
			.pathParam("username", "NitheshHS")
			.auth()
				.basic("NitheshHS", "********")
		.when()
			.get("https://api.github.com/users/{username}/repos");
		res.then()
			.assertThat().statusCode(201)
			.and()
			.assertThat().contentType(ContentType.JSON)
			.log().headers();
		System.out.println(res.getStatusCode());
		
	}

}
