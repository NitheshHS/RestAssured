package com.GitApi.test;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetASingleRepo {
	
	@Test
	public void getSingleReposTest() {
		
		Response res = given()
			.baseUri("https://api.github.com")
			.pathParam("owner", "NitheshHS")
			.pathParam("repo", "RestFull")
			.auth()	
				.basic("NitheshHS", "nithesh@1998")
		.when()
			.get("/repos/{owner}/{repo}");
		
		
		String username = res.jsonPath().get("owner.login");
		System.out.println(username);
	}

}
